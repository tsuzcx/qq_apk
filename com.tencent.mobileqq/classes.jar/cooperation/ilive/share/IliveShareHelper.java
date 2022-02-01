package cooperation.ilive.share;

import amtj;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import bhht;
import com.tencent.biz.subscribe.beans.SerializableMap;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.ark.ArkAppCenterUtil;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
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
import yyi;

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
  private bhht mLoadingDialog;
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
    if (paramString1.contains("?")) {
      return paramString1 + "&" + paramString2 + "=" + paramString3;
    }
    return paramString1 + "?" + paramString2 + "=" + paramString3;
  }
  
  public static String cutString(String paramString)
  {
    if (paramString == null) {
      str = "";
    }
    do
    {
      return str;
      if (paramString.length() > 30) {
        break;
      }
      str = paramString;
    } while (paramString.getBytes().length <= 100);
    String str = paramString;
    if (paramString.length() > 30) {
      str = paramString.substring(0, 30);
    }
    paramString = str;
    if (Math.min(str.getBytes().length, 100) == 100)
    {
      int i = str.length() / 2;
      paramString = new StringBuilder(str.substring(0, i));
      while (paramString.toString().getBytes().length < 100)
      {
        paramString.append(str.charAt(i));
        i += 1;
      }
      paramString = paramString.toString();
    }
    return paramString + "...";
  }
  
  private void finish()
  {
    if (this.mHostActivity != null)
    {
      this.mHostActivity.finish();
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
      return localJSONObject.toString();
    }
    catch (JSONException paramString1)
    {
      for (;;)
      {
        paramString1.printStackTrace();
      }
    }
  }
  
  private Intent getShareArkIntent()
  {
    if (this.mDataBundle == null) {}
    for (;;)
    {
      return null;
      Intent localIntent = new Intent(this.mHostActivity.getApplicationContext(), ForwardRecentActivity.class);
      try
      {
        String str1 = replaceArkData();
        if (!TextUtils.isEmpty(str1))
        {
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
          localIntent.putExtra("scale", ArkAppCenterUtil.getDensity());
          localIntent.putExtra("appName", str1);
          localIntent.putExtra("appView", str2);
          localIntent.putExtra("appMinVersion", str5);
          localIntent.putExtra("metaData", str3);
        }
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          localJSONException.printStackTrace();
        }
      }
    }
    return localIntent;
  }
  
  private String getShareCoverUrl()
  {
    if (this.mDataBundle == null) {
      return null;
    }
    return this.mDataBundle.getString("share_cover_url");
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
      this.mLoadingDialog = new bhht(paramActivity);
    }
  }
  
  private void initWXShareListenenr()
  {
    if (this.wxShareListener != null) {
      return;
    }
    this.wxShareListener = new IliveShareHelper.6(this);
    WXShareHelper.getInstance().addObserver(this.wxShareListener);
  }
  
  private String replaceArkData()
  {
    String str2 = "{\n    \"appName\":\"com.tencent.subscription\",\n    \"appView\":\"baseView\",\n    \"appConfig\":{\n        \"forward\":1,\n        \"autosize\":0,\n        \"type\":\"normal\"\n    },\n \"ver\":\"1.0.0.45\",\n    \"appDesc\":\"QQ直播\",\n    \"promptText\":\"来自QQ直播的分享\",\n    \"metaData\":{\n        \"data\":{\n            \"avatarJumpUrl\":\"{avatar_jump_url}\",\n            \"contentJumpUrl\":\"{h5_jump_url}\",\n            \"iconJumpUrl\":\"{icon_jump_url}\",\n            \"jumpUrl\":{\n                \"8.3.9\":{\n                    \"contentJumpUrl\":\"{content_jump_url}\"\n                },\n                \"pc\":{\n                    \"contentJumpUrl\":\"https://qzs.qzone.qq.com/qzone/hybrid/page/jumpQQ.html?url=https%3A%2F%2Fh5.qzone.qq.comhttps%3A%2F%2Fh5.qzone.qq.com%2Fv2%2Fvip%2Flive%2Froom%3Froomid%3D110008711\"\n                }\n            },\n            \"media\":[\n                {\n                    \"isVideo\":false,\n                    \"height\":2339,\n                    \"width\":1080,\n                    \"url\":\"{cover_url}\"\n                }\n            ],\n            \"title\":\"{title}\",\n            \"nick\":\"{nick_name}\",\n            \"common\":{\n                \"appIcon\":\"https://qzonestyle.gtimg.cn/qzone/qzact/act/external/live/live-icon-new.png\",\n                \"appName\":\"开播啦鹅\",\n                \"meta\":\"\",\n                \"avatar\":\"{avatar_url}\"\n            }\n        }\n    }\n}";
    String str1 = str2;
    for (;;)
    {
      try
      {
        long l1 = this.mDataBundle.getLong("share_uin");
        str1 = str2;
        long l2 = this.mDataBundle.getLong("share_room_id", -1L);
        str1 = str2;
        String str4 = "mqqapi://vaslive/watch?roomid={roomid}".replace("{roomid}", String.valueOf(l2));
        str1 = str2;
        String str3 = "https://h5.qzone.qq.com/v2/vip/live/room?roomid={roomid}".replace("{roomid}", String.valueOf(l2));
        str1 = str2;
        str3 = str3 + "&_proxy=1";
        str1 = str2;
        str4 = addShareParams(str4, "source", "qqhy");
        str1 = str2;
        str2 = "{\n    \"appName\":\"com.tencent.subscription\",\n    \"appView\":\"baseView\",\n    \"appConfig\":{\n        \"forward\":1,\n        \"autosize\":0,\n        \"type\":\"normal\"\n    },\n \"ver\":\"1.0.0.45\",\n    \"appDesc\":\"QQ直播\",\n    \"promptText\":\"来自QQ直播的分享\",\n    \"metaData\":{\n        \"data\":{\n            \"avatarJumpUrl\":\"{avatar_jump_url}\",\n            \"contentJumpUrl\":\"{h5_jump_url}\",\n            \"iconJumpUrl\":\"{icon_jump_url}\",\n            \"jumpUrl\":{\n                \"8.3.9\":{\n                    \"contentJumpUrl\":\"{content_jump_url}\"\n                },\n                \"pc\":{\n                    \"contentJumpUrl\":\"https://qzs.qzone.qq.com/qzone/hybrid/page/jumpQQ.html?url=https%3A%2F%2Fh5.qzone.qq.comhttps%3A%2F%2Fh5.qzone.qq.com%2Fv2%2Fvip%2Flive%2Froom%3Froomid%3D110008711\"\n                }\n            },\n            \"media\":[\n                {\n                    \"isVideo\":false,\n                    \"height\":2339,\n                    \"width\":1080,\n                    \"url\":\"{cover_url}\"\n                }\n            ],\n            \"title\":\"{title}\",\n            \"nick\":\"{nick_name}\",\n            \"common\":{\n                \"appIcon\":\"https://qzonestyle.gtimg.cn/qzone/qzact/act/external/live/live-icon-new.png\",\n                \"appName\":\"开播啦鹅\",\n                \"meta\":\"\",\n                \"avatar\":\"{avatar_url}\"\n            }\n        }\n    }\n}".replace("{avatar_jump_url}", "mqqapi://qsubscribe/openhomepage?src_type=ilive&uid={uid}".replace("{uid}", String.valueOf(l1)));
        str1 = str2;
        str2 = str2.replace("{content_jump_url}", str4);
        str1 = str2;
        str2 = str2.replace("{icon_jump_url}", "mqqapi://qsubscribe/opendiscoverpage?src_type=ilive");
        str1 = str2;
        str2 = str2.replace("{h5_jump_url}", str3);
        str1 = str2;
        String str5 = this.mDataBundle.getString("share_cover_url");
        str1 = str2;
        str4 = this.mDataBundle.getString("share_title");
        str1 = str2;
        str3 = this.mDataBundle.getString("share_head_url");
        str1 = str2;
        str2 = str2.replace("{nick_name}", this.mDataBundle.getString("share_nick_name"));
        str1 = str2;
        str2 = str2.replace("{cover_url}", str5);
        str1 = str2;
        str2 = str2.replace("{title}", str4);
        str1 = str2;
        str2 = str2.replace("{avatar_url}", str3);
        str1 = str2;
        if (QLog.isColorLevel()) {
          QLog.i("IliveShareHelper", 2, " share QQ replaceArkData = \n " + str1);
        }
        return str1;
      }
      catch (Throwable localThrowable)
      {
        continue;
      }
      str2.printStackTrace();
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
    Intent localIntent = getShareArkIntent();
    reportAction("qq_live", "room_page", "", "share_platform", "", 102, getFollowInfo("3", "", "", "", ""));
    if (localIntent == null) {
      if (this.mHostActivity != null) {
        QQToast.a(this.mHostActivity, amtj.a(2131713677), 0).a();
      }
    }
    while ((localIntent == null) || (this.mHostActivity == null)) {
      return;
    }
    this.mHostActivity.startActivityForResult(localIntent, 21);
  }
  
  private void shareToQZone()
  {
    if (this.mDataBundle == null) {}
    do
    {
      return;
      reportAction("qq_live", "room_page", "", "share_platform", "", 102, getFollowInfo("2", "", "", "", ""));
      Bundle localBundle = new Bundle();
      SerializableMap localSerializableMap = new SerializableMap();
      HashMap localHashMap = new HashMap();
      Object localObject1 = this.mDataBundle.getString("share_cover_url");
      Object localObject2 = this.mDataBundle.getString("share_title");
      String str1 = this.mDataBundle.getString("share_nick_name");
      str1 = str1 + "当前正在直播，快来围观";
      String str2 = addShareParams("https://h5.qzone.qq.com/v2/vip/live/room?roomid={roomid}".replace("{roomid}", String.valueOf(this.mDataBundle.getLong("share_room_id", -1L))), "source", "qqkj");
      str2 = str2 + "&_proxy=1";
      if (QLog.isColorLevel()) {
        QLog.i("IliveShareHelper", 2, " shareToQZone url = " + str2);
      }
      localBundle.putString("title", (String)localObject2);
      localBundle.putString("desc", str1);
      localBundle.putString("detail_url", str2);
      localObject2 = new ArrayList(1);
      ((ArrayList)localObject2).add(localObject1);
      localBundle.putStringArrayList("image_url", (ArrayList)localObject2);
      localBundle.putLong("req_share_id", 0L);
      localObject1 = new JSONObject();
      ((JSONObject)localObject1).put("appname", "[em]e10031[/em]来自购物直播");
      ((JSONObject)localObject1).put("actiontype", 2);
      ((JSONObject)localObject1).put("actionurl", "mqqapi://qsubscribe/opendiscoverpage?src_type=ilive");
      localHashMap.put("cell_refer", ((JSONObject)localObject1).toString());
      localSerializableMap.setMap(localHashMap);
      localBundle.putSerializable("share_qzone_info", localSerializableMap);
      QZoneShareManager.jumpToQzoneShare(BaseApplicationImpl.getApplication().getRuntime().getAccount(), this.mHostActivity, localBundle, null, -1);
    } while (!QLog.isColorLevel());
    QLog.d("IliveShareHelper", 1, "shareToQZone  success");
  }
  
  private void shareWeChat(int paramInt)
  {
    if ((this.mHostActivity == null) || (this.mDataBundle == null)) {
      return;
    }
    String str1;
    label90:
    Object localObject2;
    if (paramInt == 9)
    {
      reportAction("qq_live", "room_page", "", "share_platform", "", 102, getFollowInfo("1", "", "", "", ""));
      str1 = "https://h5.qzone.qq.com/v2/vip/live/room?roomid={roomid}".replace("{roomid}", String.valueOf(this.mDataBundle.getLong("share_room_id", -1L)));
      if (paramInt != 9) {
        break label346;
      }
      localObject1 = "wxhy";
      localObject1 = addShareParams(str1, "source", (String)localObject1);
      str1 = (String)localObject1 + "&_proxy=1";
      localObject2 = this.mDataBundle.getString("share_nick_name");
      localObject1 = this.mDataBundle.getString("share_title");
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        break label353;
      }
    }
    String str2;
    int i;
    label346:
    label353:
    for (Object localObject1 = (String)localObject2 + "这个直播太有趣啦，快来一起看吧";; localObject1 = (String)localObject2 + "：" + (String)localObject1)
    {
      localObject1 = cutString((String)localObject1);
      if (TextUtils.isEmpty(this.mCurrentNickName)) {
        this.mCurrentNickName = ((String)localObject2);
      }
      str2 = cutString("这个直播太有趣啦，快来和{nick_name}一起看吧".replace("{nick_name}", this.mCurrentNickName));
      if (QLog.isColorLevel()) {
        QLog.i("IliveShareHelper", 2, "shareWeChat , shareUrl = " + str1 + " , title = " + (String)localObject1 + " , desc = " + str2);
      }
      localObject2 = new HashMap(1);
      i = -1;
      if ((str1 != null) && (!str1.isEmpty())) {
        break label382;
      }
      QQToast.a(this.mHostActivity, 1, amtj.a(2131713674), 0).a();
      return;
      reportAction("qq_live", "room_page", "", "share_platform", "", 102, getFollowInfo("4", "", "", "", ""));
      break;
      localObject1 = "wxpyq";
      break label90;
    }
    label382:
    if (!WXShareHelper.getInstance().isWXinstalled()) {
      i = 2131719722;
    }
    while (i != -1)
    {
      yyi.a(0, i);
      return;
      if (!WXShareHelper.getInstance().isWXsupportApi()) {
        i = 2131719723;
      }
    }
    initWXShareListenenr();
    localObject1 = new IliveShareHelper.4(this, (Map)localObject2, (String)localObject1, str2, str1, paramInt);
    if (TextUtils.isEmpty(getShareCoverUrl()))
    {
      ((Runnable)localObject1).run();
      return;
    }
    initLoadingDialog(this.mHostActivity);
    this.mLoadingDialog.c(2131693585);
    this.mLoadingDialog.show();
    ThreadManager.post(new IliveShareHelper.5(this, (Map)localObject2, (Runnable)localObject1), 8, null, false);
  }
  
  public void dismiss()
  {
    if ((this.mActionSheet != null) && (this.mActionSheet.isShowing()))
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
    if ((this.mActionSheet != null) && (this.mActionSheet.isShowing())) {
      this.mActionSheet.dismiss();
    }
    WXShareHelper.getInstance().removeObserver(this.wxShareListener);
  }
  
  public void setIsFullScreen(boolean paramBoolean)
  {
    if (this.mActionSheet != null) {
      this.mActionSheet.setEnableNotTriggerVirtualNavigationBar(paramBoolean);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.ilive.share.IliveShareHelper
 * JD-Core Version:    0.7.0.1
 */