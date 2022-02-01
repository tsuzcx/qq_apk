package cooperation.ilive.share;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.qrcode.util.QRUtils;
import com.tencent.biz.webviewplugin.Share;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.ark.ArkAppCenterUtil;
import com.tencent.mobileqq.qcircle.api.data.SerializableMap;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.mobileqq.widget.share.ShareActionSheetFactory;
import com.tencent.mobileqq.widget.share.ShareActionSheetV2.Param;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.mobileqq.wxapi.WXShareHelper.WXShareListener;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QZoneShareManager;
import cooperation.qzone.mobilereport.MobileReportManager;
import cooperation.qzone.mobilereport.MobileReportManager.ActionInfoBuilder;
import cooperation.qzone.mobilereport.MobileReportManager.ItemInfoBuilder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

public class IliveShareHelper
{
  private static final String DEFAUL_MAIN_TITLE = "这个直播太有趣啦，快来一起看吧";
  private static final String HINT_TITLE = "这个直播太有趣啦，快来和{nick_name}一起看吧";
  private static final String KEY_ARK_APP_NAME = "appName";
  private static final String KEY_ARK_APP_VIEW = "appView";
  private static final String KEY_ARK_META_DATA = "metaData";
  private static final String KEY_ARK_MIN_VERSION = "appMinVersion";
  private static final String TAG = "IliveShareHelper";
  private ShareActionSheet mActionSheet;
  private String mCurrentNickName;
  private Bundle mDataBundle;
  public Activity mHostActivity;
  private QQProgressDialog mLoadingDialog;
  private Share mShare;
  private String mWXTransaction;
  private WXShareHelper.WXShareListener wxShareListener;
  
  public IliveShareHelper(Activity paramActivity, Bundle paramBundle)
  {
    this.mDataBundle = paramBundle;
    init(paramActivity);
  }
  
  private String addShareParams(String paramString1, String paramString2, String paramString3)
  {
    if (paramString1 == null) {
      return "";
    }
    if (paramString1.contains("?"))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString1);
      localStringBuilder.append("&");
      localStringBuilder.append(paramString2);
      localStringBuilder.append("=");
      localStringBuilder.append(paramString3);
      return localStringBuilder.toString();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append("?");
    localStringBuilder.append(paramString2);
    localStringBuilder.append("=");
    localStringBuilder.append(paramString3);
    return localStringBuilder.toString();
  }
  
  public static String cutString(String paramString)
  {
    if (paramString == null) {
      return "";
    }
    if ((paramString.length() <= 30) && (paramString.getBytes().length <= 100)) {
      return paramString;
    }
    Object localObject = paramString;
    if (paramString.length() > 30) {
      localObject = paramString.substring(0, 30);
    }
    paramString = (String)localObject;
    if (Math.min(((String)localObject).getBytes().length, 100) == 100)
    {
      int i = ((String)localObject).length() / 2;
      paramString = new StringBuilder(((String)localObject).substring(0, i));
      while (paramString.toString().getBytes().length < 100)
      {
        paramString.append(((String)localObject).charAt(i));
        i += 1;
      }
      paramString = paramString.toString();
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append("...");
    return ((StringBuilder)localObject).toString();
  }
  
  private void finish()
  {
    Activity localActivity = this.mHostActivity;
    if (localActivity != null)
    {
      localActivity.finish();
      this.mHostActivity.overridePendingTransition(0, 0);
    }
  }
  
  private List<ShareActionSheetBuilder.ActionSheetItem>[] getActionSheetItems(List<Integer>[] paramArrayOfList)
  {
    List[] arrayOfList = new List[paramArrayOfList.length];
    int i = 0;
    while (i < paramArrayOfList.length)
    {
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = paramArrayOfList[i].iterator();
      while (localIterator.hasNext()) {
        localArrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(((Integer)localIterator.next()).intValue()));
      }
      arrayOfList[i] = localArrayList;
      i += 1;
    }
    return arrayOfList;
  }
  
  public static String getFollowInfo(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("zt_str1", paramString1);
      localJSONObject.put("zt_str2", paramString2);
      localJSONObject.put("zt_str3", paramString3);
      localJSONObject.put("zt_str4", paramString4);
      localJSONObject.put("roomid", paramString5);
    }
    catch (JSONException paramString1)
    {
      paramString1.printStackTrace();
    }
    return localJSONObject.toString();
  }
  
  private Intent getShareArkIntent()
  {
    if (this.mDataBundle == null) {
      return null;
    }
    Intent localIntent = new Intent(this.mHostActivity.getApplicationContext(), ForwardRecentActivity.class);
    try
    {
      String str1 = replaceArkData();
      if (TextUtils.isEmpty(str1)) {
        return null;
      }
      JSONObject localJSONObject = new JSONObject(str1);
      str1 = localJSONObject.optString("appName");
      String str2 = localJSONObject.optString("appView");
      String str3 = localJSONObject.optString("metaData");
      String str4 = localJSONObject.optString("promptText");
      String str5 = localJSONObject.optString("ver");
      localJSONObject = localJSONObject.optJSONObject("appConfig");
      localIntent.putExtra("forward_type", 27);
      localIntent.putExtra("is_ark_display_share", true);
      localIntent.putExtra("forward_ark_app_name", str1);
      localIntent.putExtra("forward_ark_app_view", str2);
      localIntent.putExtra("forward_ark_app_ver", str5);
      localIntent.putExtra("forward_ark_app_prompt", str4);
      localIntent.putExtra("forward_ark_app_meta", str3);
      if (localJSONObject != null) {
        localIntent.putExtra("forward_ark_app_config", localJSONObject.toString());
      }
      localIntent.putExtra("scale", ArkAppCenterUtil.a());
      localIntent.putExtra("appName", str1);
      localIntent.putExtra("appView", str2);
      localIntent.putExtra("appMinVersion", str5);
      localIntent.putExtra("metaData", str3);
      return localIntent;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return localIntent;
  }
  
  private String getShareCoverUrl()
  {
    Bundle localBundle = this.mDataBundle;
    if (localBundle == null) {
      return null;
    }
    return localBundle.getString("share_cover_url");
  }
  
  private List<Integer> getShareLines()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Integer.valueOf(2));
    localArrayList.add(Integer.valueOf(3));
    localArrayList.add(Integer.valueOf(9));
    localArrayList.add(Integer.valueOf(10));
    return localArrayList;
  }
  
  @NotNull
  private List[] getShareList()
  {
    return new List[] { getShareLines() };
  }
  
  private void initLoadingDialog(Activity paramActivity)
  {
    if (this.mLoadingDialog == null) {
      this.mLoadingDialog = new QQProgressDialog(paramActivity);
    }
  }
  
  private void initWXShareListenenr()
  {
    if (this.wxShareListener != null) {
      return;
    }
    this.wxShareListener = new IliveShareHelper.6(this);
    WXShareHelper.a().a(this.wxShareListener);
  }
  
  private String replaceArkData()
  {
    String str1 = "{\n    \"appName\":\"com.tencent.subscription\",\n    \"appView\":\"baseView\",\n    \"appConfig\":{\n        \"forward\":1,\n        \"autosize\":0,\n        \"type\":\"normal\"\n    },\n \"ver\":\"1.0.0.45\",\n    \"appDesc\":\"QQ直播\",\n    \"promptText\":\"来自QQ直播的分享\",\n    \"metaData\":{\n        \"data\":{\n            \"avatarJumpUrl\":\"{avatar_jump_url}\",\n            \"contentJumpUrl\":\"{h5_jump_url}\",\n            \"iconJumpUrl\":\"{icon_jump_url}\",\n            \"jumpUrl\":{\n                \"8.3.9\":{\n                    \"contentJumpUrl\":\"{content_jump_url}\"\n                },\n                \"pc\":{\n                    \"contentJumpUrl\":\"https://qzs.qzone.qq.com/qzone/hybrid/page/jumpQQ.html?url=https%3A%2F%2Fh5.qzone.qq.comhttps%3A%2F%2Fh5.qzone.qq.com%2Fv2%2Fvip%2Flive%2Froom%3Froomid%3D110008711\"\n                }\n            },\n            \"media\":[\n                {\n                    \"isVideo\":false,\n                    \"height\":2339,\n                    \"width\":1080,\n                    \"url\":\"{cover_url}\"\n                }\n            ],\n            \"title\":\"{title}\",\n            \"nick\":\"{nick_name}\",\n            \"common\":{\n                \"appIcon\":\"https://qzonestyle.gtimg.cn/qzone/qzact/act/external/live/live-icon-new.png\",\n                \"appName\":\"开播啦鹅\",\n                \"meta\":\"\",\n                \"avatar\":\"{avatar_url}\"\n            }\n        }\n    }\n}";
    Object localObject1 = str1;
    for (;;)
    {
      String str3;
      try
      {
        long l1 = this.mDataBundle.getLong("share_uin");
        localObject1 = str1;
        long l2 = this.mDataBundle.getLong("share_room_id", -1L);
        localObject1 = str1;
        str3 = "mqqapi://vaslive/watch?roomid={roomid}".replace("{roomid}", String.valueOf(l2));
        localObject1 = str1;
        String str2 = "https://h5.qzone.qq.com/v2/vip/live/room?roomid={roomid}".replace("{roomid}", String.valueOf(l2));
        localObject1 = str1;
        Object localObject3 = new StringBuilder();
        localObject1 = str1;
        ((StringBuilder)localObject3).append(str2);
        localObject1 = str1;
        ((StringBuilder)localObject3).append("&_proxy=1");
        localObject1 = str1;
        str2 = ((StringBuilder)localObject3).toString();
        localObject1 = str1;
        str3 = addShareParams(str3, "source", "qqhy");
        localObject1 = str1;
        str1 = "{\n    \"appName\":\"com.tencent.subscription\",\n    \"appView\":\"baseView\",\n    \"appConfig\":{\n        \"forward\":1,\n        \"autosize\":0,\n        \"type\":\"normal\"\n    },\n \"ver\":\"1.0.0.45\",\n    \"appDesc\":\"QQ直播\",\n    \"promptText\":\"来自QQ直播的分享\",\n    \"metaData\":{\n        \"data\":{\n            \"avatarJumpUrl\":\"{avatar_jump_url}\",\n            \"contentJumpUrl\":\"{h5_jump_url}\",\n            \"iconJumpUrl\":\"{icon_jump_url}\",\n            \"jumpUrl\":{\n                \"8.3.9\":{\n                    \"contentJumpUrl\":\"{content_jump_url}\"\n                },\n                \"pc\":{\n                    \"contentJumpUrl\":\"https://qzs.qzone.qq.com/qzone/hybrid/page/jumpQQ.html?url=https%3A%2F%2Fh5.qzone.qq.comhttps%3A%2F%2Fh5.qzone.qq.com%2Fv2%2Fvip%2Flive%2Froom%3Froomid%3D110008711\"\n                }\n            },\n            \"media\":[\n                {\n                    \"isVideo\":false,\n                    \"height\":2339,\n                    \"width\":1080,\n                    \"url\":\"{cover_url}\"\n                }\n            ],\n            \"title\":\"{title}\",\n            \"nick\":\"{nick_name}\",\n            \"common\":{\n                \"appIcon\":\"https://qzonestyle.gtimg.cn/qzone/qzact/act/external/live/live-icon-new.png\",\n                \"appName\":\"开播啦鹅\",\n                \"meta\":\"\",\n                \"avatar\":\"{avatar_url}\"\n            }\n        }\n    }\n}".replace("{avatar_jump_url}", "mqqapi://qsubscribe/openhomepage?src_type=ilive&uid={uid}".replace("{uid}", String.valueOf(l1)));
        localObject1 = str1;
        str1 = str1.replace("{content_jump_url}", str3);
        localObject1 = str1;
        str1 = str1.replace("{icon_jump_url}", "mqqapi://qsubscribe/opendiscoverpage?src_type=ilive");
        localObject1 = str1;
        str2 = str1.replace("{h5_jump_url}", str2);
        localObject1 = str2;
        String str4 = this.mDataBundle.getString("share_cover_url");
        localObject1 = str2;
        str1 = this.mDataBundle.getString("share_title");
        localObject1 = str2;
        localObject3 = this.mDataBundle.getString("share_head_url");
        localObject1 = str2;
        String str5 = this.mDataBundle.getString("share_nick_name");
        localObject1 = str2;
        str3 = this.mDataBundle.getString("share_content");
        localObject1 = str2;
        str1 = toJsonsString(str1);
        localObject1 = str2;
        str5 = toJsonsString(str5);
        localObject1 = str2;
        str3 = toJsonsString(str3);
        localObject1 = str2;
        str2 = str2.replace("{nick_name}", str5);
        localObject1 = str2;
        str2 = str2.replace("{cover_url}", str4);
        localObject1 = str2;
        if (!TextUtils.isEmpty(str3)) {
          break label475;
        }
        localObject1 = str2;
        str1 = str2.replace("{title}", str1);
        localObject1 = str1;
        str1 = str1.replace("{avatar_url}", (CharSequence)localObject3);
        localObject1 = str1;
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
      }
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(" share QQ replaceArkData = \n ");
        ((StringBuilder)localObject2).append((String)localObject1);
        QLog.i("IliveShareHelper", 2, ((StringBuilder)localObject2).toString());
      }
      return localObject1;
      label475:
      Object localObject2 = str3;
    }
  }
  
  public static void reportAction(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt, String paramString6)
  {
    reportAction(paramString1, paramString2, paramString3, paramString4, "", "", paramString6, paramString5, "", paramInt, 0);
  }
  
  public static void reportAction(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, int paramInt1, int paramInt2)
  {
    paramString3 = new MobileReportManager.ItemInfoBuilder().setItemId(paramString3).setBusiInfo(paramString7).setModuleId(paramString4).setItemType(paramString8).addActionInfo(new MobileReportManager.ActionInfoBuilder(System.currentTimeMillis(), paramInt1, paramInt2).build()).build();
    MobileReportManager.getInstance().reportActionLive(paramString1, paramString2, paramString3);
  }
  
  private void shareToQQ()
  {
    Object localObject = getShareArkIntent();
    reportAction("qq_live", "room_page", "", "share_platform", "", 102, getFollowInfo("3", "", "", "", ""));
    if (localObject == null)
    {
      localObject = this.mHostActivity;
      if (localObject != null) {
        QQToast.a((Context)localObject, HardCodeUtil.a(2131714441), 0).a();
      }
      return;
    }
    if (localObject != null)
    {
      Activity localActivity = this.mHostActivity;
      if (localActivity != null) {
        localActivity.startActivityForResult((Intent)localObject, 21);
      }
    }
  }
  
  private void shareToQZone()
  {
    if (this.mDataBundle == null) {
      return;
    }
    reportAction("qq_live", "room_page", "", "share_platform", "", 102, getFollowInfo("2", "", "", "", ""));
    Bundle localBundle = new Bundle();
    SerializableMap localSerializableMap = new SerializableMap();
    HashMap localHashMap = new HashMap();
    String str2 = this.mDataBundle.getString("share_cover_url");
    String str3 = this.mDataBundle.getString("share_title");
    String str1 = this.mDataBundle.getString("share_content");
    Object localObject2 = this.mDataBundle.getString("share_nick_name");
    Object localObject1 = str1;
    if (TextUtils.isEmpty(str1))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append((String)localObject2);
      ((StringBuilder)localObject1).append("当前正在直播，快来围观");
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    str1 = addShareParams("https://h5.qzone.qq.com/v2/vip/live/room?roomid={roomid}".replace("{roomid}", String.valueOf(this.mDataBundle.getLong("share_room_id", -1L))), "source", "qqkj");
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(str1);
    ((StringBuilder)localObject2).append("&_proxy=1");
    str1 = ((StringBuilder)localObject2).toString();
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(" shareToQZone url = ");
      ((StringBuilder)localObject2).append(str1);
      QLog.i("IliveShareHelper", 2, ((StringBuilder)localObject2).toString());
    }
    localBundle.putString("title", str3);
    localBundle.putString("desc", (String)localObject1);
    localBundle.putString("detail_url", str1);
    localObject1 = new ArrayList(1);
    ((ArrayList)localObject1).add(str2);
    localBundle.putStringArrayList("image_url", (ArrayList)localObject1);
    localBundle.putLong("req_share_id", 0L);
    localObject1 = new JSONObject();
    ((JSONObject)localObject1).put("appname", "[em]e10031[/em]来自购物直播");
    ((JSONObject)localObject1).put("actiontype", 2);
    ((JSONObject)localObject1).put("actionurl", "mqqapi://qsubscribe/opendiscoverpage?src_type=ilive");
    localHashMap.put("cell_refer", ((JSONObject)localObject1).toString());
    localSerializableMap.setMap(localHashMap);
    localBundle.putSerializable("share_qzone_info", localSerializableMap);
    QZoneShareManager.jumpToQzoneShare(BaseApplicationImpl.getApplication().getRuntime().getAccount(), this.mHostActivity, localBundle, null, -1);
    if (QLog.isColorLevel()) {
      QLog.d("IliveShareHelper", 1, "shareToQZone  success");
    }
  }
  
  private void shareWeChat(int paramInt)
  {
    if (this.mHostActivity != null)
    {
      if (this.mDataBundle == null) {
        return;
      }
      if (paramInt == 9) {
        reportAction("qq_live", "room_page", "", "share_platform", "", 102, getFollowInfo("1", "", "", "", ""));
      } else {
        reportAction("qq_live", "room_page", "", "share_platform", "", 102, getFollowInfo("4", "", "", "", ""));
      }
      Object localObject2 = "https://h5.qzone.qq.com/v2/vip/live/room?roomid={roomid}".replace("{roomid}", String.valueOf(this.mDataBundle.getLong("share_room_id", -1L)));
      if (paramInt == 9) {
        localObject1 = "wxhy";
      } else {
        localObject1 = "wxpyq";
      }
      Object localObject1 = addShareParams((String)localObject2, "source", (String)localObject1);
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append("&_proxy=1");
      String str1 = ((StringBuilder)localObject2).toString();
      String str2 = this.mDataBundle.getString("share_nick_name");
      localObject1 = this.mDataBundle.getString("share_title");
      localObject2 = this.mDataBundle.getString("share_content");
      if (TextUtils.isEmpty((CharSequence)localObject1))
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(str2);
        ((StringBuilder)localObject1).append("这个直播太有趣啦，快来一起看吧");
        localObject1 = ((StringBuilder)localObject1).toString();
      }
      else
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append(str2);
        ((StringBuilder)localObject3).append("：");
        ((StringBuilder)localObject3).append((String)localObject1);
        localObject1 = ((StringBuilder)localObject3).toString();
      }
      Object localObject3 = cutString((String)localObject1);
      if (TextUtils.isEmpty(this.mCurrentNickName)) {
        this.mCurrentNickName = str2;
      }
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        localObject1 = cutString("这个直播太有趣啦，快来和{nick_name}一起看吧".replace("{nick_name}", this.mCurrentNickName));
      } else {
        localObject1 = localObject2;
      }
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("shareWeChat , shareUrl = ");
        ((StringBuilder)localObject2).append(str1);
        ((StringBuilder)localObject2).append(" , title = ");
        ((StringBuilder)localObject2).append((String)localObject3);
        ((StringBuilder)localObject2).append(" , desc = ");
        ((StringBuilder)localObject2).append((String)localObject1);
        QLog.i("IliveShareHelper", 2, ((StringBuilder)localObject2).toString());
      }
      localObject2 = new HashMap(1);
      if ((str1 != null) && (!str1.isEmpty()))
      {
        int i;
        if (!WXShareHelper.a().a()) {
          i = 2131720478;
        } else if (!WXShareHelper.a().b()) {
          i = 2131720479;
        } else {
          i = -1;
        }
        if (i != -1)
        {
          QRUtils.a(0, i);
          return;
        }
        initWXShareListenenr();
        localObject1 = new IliveShareHelper.4(this, (Map)localObject2, (String)localObject3, (String)localObject1, str1, paramInt);
        if (TextUtils.isEmpty(getShareCoverUrl()))
        {
          ((Runnable)localObject1).run();
          return;
        }
        initLoadingDialog(this.mHostActivity);
        this.mLoadingDialog.c(2131693895);
        this.mLoadingDialog.show();
        ThreadManager.post(new IliveShareHelper.5(this, (Map)localObject2, (Runnable)localObject1), 8, null, false);
        return;
      }
      QQToast.a(this.mHostActivity, 1, HardCodeUtil.a(2131714438), 0).a();
    }
  }
  
  public static String toJsonsString(String paramString)
  {
    if (paramString == null) {
      return "null";
    }
    StringBuilder localStringBuilder = new StringBuilder(1024);
    int j = paramString.length();
    int i = 0;
    while (i < j)
    {
      char c = paramString.charAt(i);
      if (c != '\f')
      {
        if (c != '\r')
        {
          if ((c != '"') && (c != '/') && (c != '\\')) {}
          switch (c)
          {
          default: 
            if (c <= '\037') {
              localStringBuilder.append(String.format("\\u%04x", new Object[] { Integer.valueOf(c) }));
            } else {
              localStringBuilder.append(c);
            }
            break;
          case '\n': 
            localStringBuilder.append("\\n");
            break;
          case '\t': 
            localStringBuilder.append("\\t");
            break;
          case '\b': 
            localStringBuilder.append("\\b");
            break;
            localStringBuilder.append('\\');
            localStringBuilder.append(c);
            break;
          }
        }
        else
        {
          localStringBuilder.append("\\r");
        }
      }
      else {
        localStringBuilder.append("\\f");
      }
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  public void dismiss()
  {
    ShareActionSheet localShareActionSheet = this.mActionSheet;
    if ((localShareActionSheet != null) && (localShareActionSheet.isShowing()))
    {
      this.mActionSheet.dismiss();
      finish();
    }
  }
  
  public void init(Activity paramActivity)
  {
    this.mHostActivity = paramActivity;
    ShareActionSheetV2.Param localParam = new ShareActionSheetV2.Param();
    localParam.context = paramActivity;
    this.mActionSheet = ShareActionSheetFactory.create(localParam);
    this.mActionSheet.setOnDismissListener(new IliveShareHelper.1(this));
    this.mActionSheet.setCancelListener(new IliveShareHelper.2(this));
    this.mActionSheet.setItemClickListenerV2(new IliveShareHelper.SheetItemClickProcessor(this));
    ThreadManagerV2.executeOnFileThread(new IliveShareHelper.3(this));
  }
  
  public void onDestroy()
  {
    ShareActionSheet localShareActionSheet = this.mActionSheet;
    if ((localShareActionSheet != null) && (localShareActionSheet.isShowing())) {
      this.mActionSheet.dismiss();
    }
    WXShareHelper.a().b(this.wxShareListener);
  }
  
  public void setIsFullScreen(boolean paramBoolean)
  {
    ShareActionSheet localShareActionSheet = this.mActionSheet;
    if (localShareActionSheet != null) {
      localShareActionSheet.setEnableNotTriggerVirtualNavigationBar(paramBoolean);
    }
  }
  
  public void setShare(Share paramShare)
  {
    this.mShare = paramShare;
    if (this.mShare != null)
    {
      this.mDataBundle.putString("share_cover_url", paramShare.getShareUrl());
      this.mDataBundle.putString("share_title", paramShare.a());
      this.mDataBundle.putString("share_content", paramShare.b());
      this.mDataBundle.putString("share_cover_url", paramShare.c());
    }
  }
  
  public void showActionSheet()
  {
    if (this.mActionSheet == null) {
      return;
    }
    reportAction("qq_live", "room_page", "share_button", "share", "4", 102, getFollowInfo("", "", "", "", ""));
    List[] arrayOfList = getShareList();
    this.mHostActivity.getIntent().putExtra("big_brother_source_key", "biz_src_jc_vip");
    this.mActionSheet.setActionSheetItems(getActionSheetItems(arrayOfList));
    this.mActionSheet.setRowVisibility(8, 0, 0);
    this.mActionSheet.show();
    this.mHostActivity.overridePendingTransition(0, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     cooperation.ilive.share.IliveShareHelper
 * JD-Core Version:    0.7.0.1
 */