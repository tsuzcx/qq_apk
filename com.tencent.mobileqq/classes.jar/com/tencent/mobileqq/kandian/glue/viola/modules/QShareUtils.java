package com.tencent.mobileqq.kandian.glue.viola.modules;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.accountdetail.api.IPublicAccountDetail;
import com.tencent.biz.pubaccount.api.IPublicAccountProxy;
import com.tencent.biz.qrcode.util.QRUtils;
import com.tencent.biz.webviewplugin.Share;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.DirectForwardActivity;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.video.VideoStructMsgHelper;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicEngine;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgFactory;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserShareMenuHandler;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.mobileqq.wxapi.WXShareHelper.WXShareListener;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QZoneShareManager;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import mqq.app.MobileQQ;
import org.json.JSONObject;

public class QShareUtils
{
  public static String a = "QShareUtils";
  private QQProgressDialog b;
  private String c;
  private WXShareHelper.WXShareListener d;
  
  public static Bitmap a(Bitmap paramBitmap)
  {
    int j = paramBitmap.getWidth();
    int i = paramBitmap.getHeight();
    int k = j * i;
    if (k > 8000)
    {
      double d1 = k;
      Double.isNaN(d1);
      d1 = Math.sqrt(8000.0D / d1);
      double d2 = j;
      Double.isNaN(d2);
      j = (int)(d2 * d1);
      d2 = i;
      Double.isNaN(d2);
      Bitmap localBitmap = Bitmap.createScaledBitmap(paramBitmap, j, (int)(d2 * d1), true);
      paramBitmap.recycle();
      return localBitmap;
    }
    return paramBitmap;
  }
  
  private String a(JSONObject paramJSONObject)
  {
    String str2 = paramJSONObject.optString("puin", null);
    String str1 = str2;
    if (str2 == null) {
      str1 = paramJSONObject.optString("oaUin");
    }
    return str1;
  }
  
  private String a(JSONObject paramJSONObject, String paramString, int paramInt)
  {
    if ((!TextUtils.isEmpty(paramJSONObject.optString("wx_share_url"))) && (paramInt == 9)) {
      return paramJSONObject.optString("wx_share_url");
    }
    if ((!TextUtils.isEmpty(paramJSONObject.optString("wx_circle_share_url"))) && (paramInt == 10)) {
      return paramJSONObject.optString("wx_circle_share_url");
    }
    return paramString;
  }
  
  private String a(JSONObject paramJSONObject, String paramString1, IPublicAccountDetail paramIPublicAccountDetail, String paramString2, String paramString3)
  {
    if (TextUtils.isEmpty(paramString2))
    {
      if (paramIPublicAccountDetail != null) {
        paramString3 = paramIPublicAccountDetail.getName();
      }
      if ((TextUtils.isEmpty(paramString3)) && (paramJSONObject.has("sourceName"))) {
        paramIPublicAccountDetail = paramJSONObject.optString("sourceName");
      } else {
        paramIPublicAccountDetail = paramString3;
      }
      paramJSONObject = paramIPublicAccountDetail;
      if (!TextUtils.isEmpty(paramIPublicAccountDetail)) {
        return paramJSONObject;
      }
    }
    else
    {
      if (paramJSONObject.has("sourceName")) {
        paramString3 = paramJSONObject.optString("sourceName");
      }
      if ((TextUtils.isEmpty(paramString3)) && (paramIPublicAccountDetail != null)) {
        paramIPublicAccountDetail = paramIPublicAccountDetail.getName();
      } else {
        paramIPublicAccountDetail = paramString3;
      }
      paramJSONObject = paramIPublicAccountDetail;
      if (!TextUtils.isEmpty(paramIPublicAccountDetail)) {
        return paramJSONObject;
      }
    }
    paramJSONObject = paramString1;
    return paramJSONObject;
  }
  
  private void a(Activity paramActivity)
  {
    if (this.b == null) {
      this.b = new QQProgressDialog(paramActivity);
    }
  }
  
  private void a(Activity paramActivity, Intent paramIntent, long paramLong)
  {
    AppInterface localAppInterface = (AppInterface)ReadInJoyUtils.b();
    if (localAppInterface != null)
    {
      a(paramActivity);
      if (!this.b.isShowing())
      {
        this.b.c(2131891516);
        this.b.show();
      }
      paramIntent.putExtra("struct_share_key_source_name", Long.toString(paramLong));
      Share.a(localAppInterface, paramActivity, localAppInterface.getAccount(), paramLong, 3000L, new QShareUtils.4(this, paramIntent, paramActivity));
    }
  }
  
  private void a(Activity paramActivity, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    if (QLog.isColorLevel()) {
      QLog.d(a, 2, "shareMsgToSina start!");
    }
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)))
    {
      if (QLog.isColorLevel()) {
        QLog.d(a, 2, "shareMsgToSina installSinaWeibo:false");
      }
      try
      {
        paramString1 = URLEncoder.encode(paramString1, "UTF-8");
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("https://service.weibo.com/share/share.php?");
        ((StringBuilder)localObject).append("title=");
        ((StringBuilder)localObject).append(paramString1);
        localObject = ((StringBuilder)localObject).toString();
        paramString2 = URLEncoder.encode(paramString2, "UTF-8");
        paramString1 = paramString2;
        if (paramString3 != null)
        {
          paramString1 = paramString2;
          if (paramString3.contains("kandianshare.html5.qq.com")) {
            paramString1 = URLEncoder.encode(paramString3, "UTF-8");
          }
        }
        paramString2 = new StringBuilder();
        paramString2.append((String)localObject);
        paramString2.append("&url=");
        paramString2.append(paramString1);
        paramString1 = paramString2.toString();
        paramString2 = URLEncoder.encode(paramString4, "UTF-8");
        paramString3 = new StringBuilder();
        paramString3.append(paramString1);
        paramString3.append("&pic=");
        paramString3.append(paramString2);
        paramString1 = paramString3.toString();
        paramString2 = new StringBuilder();
        paramString2.append(paramString1);
        paramString2.append("&_wv=3");
        paramString1 = paramString2.toString();
        paramString2 = new Intent(paramActivity, QQBrowserActivity.class);
        paramString2.putExtra("url", paramString1);
        paramActivity.startActivity(paramString2);
        if (QLog.isColorLevel()) {
          QLog.d(a, 2, "shareMsgToSina start webview!");
        }
      }
      catch (Exception paramActivity)
      {
        QQToast.makeText(BaseApplication.getContext(), 0, 2131916544, 0).show(BaseApplication.getContext().getResources().getDimensionPixelSize(2131299920));
        paramActivity.printStackTrace();
      }
      if (QLog.isColorLevel()) {
        QLog.d(a, 2, "shareMsgToSina end!");
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(a, 2, "shareMsgToSina empty title or share_url");
    }
    QQToast.makeText(BridgeModuleHelper.e(), 0, 2131916544, 0).show(BridgeModuleHelper.e().getResources().getDimensionPixelSize(2131299920));
  }
  
  private void a(Activity paramActivity, JSONObject paramJSONObject, Intent paramIntent)
  {
    a(paramActivity);
    c();
    String str2 = a(paramJSONObject);
    Object localObject3;
    String str1;
    String str3;
    if (!TextUtils.isEmpty(str2))
    {
      localObject1 = (AppInterface)ReadInJoyUtils.b();
      localObject1 = ((AppInterface)localObject1).getEntityManagerFactory(((AppInterface)localObject1).getAccount()).createEntityManager();
      localObject2 = (IPublicAccountDetail)((EntityManager)localObject1).find(((IPublicAccountProxy)QRoute.api(IPublicAccountProxy.class)).getImplClass(IPublicAccountDetail.class), str2);
      ((EntityManager)localObject1).close();
      localObject1 = paramJSONObject.optString("src_action", "");
      localObject3 = a(paramJSONObject, str2, (IPublicAccountDetail)localObject2, (String)localObject1, null);
      if (((String)localObject3).equalsIgnoreCase(paramActivity.getString(2131897917)))
      {
        boolean bool = ((String)localObject3).equalsIgnoreCase(paramActivity.getString(2131897917));
        if (bool) {
          localObject1 = "mqqapi://app/action?pkg=com.tencent.mobileqq&cmp=cooperation.readinjoy.ReadInJoyProxyActivity";
        } else {
          localObject1 = "mqqapi://app/action?pkg=com.tencent.mobileqq&cmp=cooperation.readinjoy.ReadInJoyProxyActivity&from=recent";
        }
        if (bool) {
          localObject2 = "mqqapi://readinjoy/open?src_type=internal&version=1";
        } else {
          localObject2 = "mqqapi://readinjoy/open?src_type=internal&version=1&from=recent";
        }
        if (bool) {
          str1 = "https://sqimg.qq.com/qq_product_operations/ydqpush/message_icon/kandian.png";
        } else {
          str1 = "https://sqimg.qq.com/qq_product_operations/ydqpush/message_icon/dingyuehao.png";
        }
        paramIntent.putExtra("source_puin", str2);
        paramIntent.putExtra("struct_share_key_source_action", "plugin");
        paramIntent.putExtra("struct_share_key_source_a_action_data", (String)localObject1);
        paramIntent.putExtra("struct_share_key_source_i_action_data", (String)localObject2);
        paramIntent.putExtra("struct_share_key_content_a_action_DATA", (String)localObject1);
        paramIntent.putExtra("struct_share_key_source_icon", str1);
        paramIntent.putExtra("app_name", (String)localObject3);
        localObject2 = "src_iconUrl";
        localObject1 = "struct_share_key_source_icon";
      }
      else
      {
        localObject2 = paramJSONObject.optString("src_iconUrl", "");
        str1 = paramJSONObject.optString("src_actionData", "");
        str3 = paramJSONObject.optString("src_a_actionData", "");
        String str4 = paramJSONObject.optString("src_i_actionData", "");
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          if ("web".equals(localObject1)) {
            if (!TextUtils.isEmpty((CharSequence)localObject2)) {
              if (((String)localObject2).contains("webcard.mp.qq.com")) {
                break label504;
              }
            } else {
              break label504;
            }
          }
          if (("web".equals(localObject1)) || (!TextUtils.isEmpty(str1)) || ((!TextUtils.isEmpty(str3)) && (!TextUtils.isEmpty(str4))))
          {
            paramIntent.putExtra("struct_share_key_source_action", (String)localObject1);
            if ("web".equals(localObject1))
            {
              paramIntent.putExtra("struct_share_key_source_url", (String)localObject2);
              paramIntent.putExtra("source_url", (String)localObject2);
              break label569;
            }
            if (!TextUtils.isEmpty(str1)) {
              paramIntent.putExtra("struct_share_key_source_action_data", str1);
            }
            if (!TextUtils.isEmpty(str3)) {
              paramIntent.putExtra("struct_share_key_source_a_action_data", str3);
            }
            if (TextUtils.isEmpty(str4)) {
              break label569;
            }
            paramIntent.putExtra("struct_share_key_source_i_action_data", str4);
            break label569;
          }
        }
        label504:
        localObject1 = String.format("mqqapi://app/action?pkg=com.tencent.mobileqq&cmp=com.tencent.biz.pubaccount.AccountDetail.activity.api.impl.AccountDetailActivity&uin=%s", new Object[] { str2 });
        localObject2 = String.format("mqqapi://card/show_pslcard?src_type=internal&card_type=public_account&uin=%s&version=1", new Object[] { str2 });
        paramIntent.putExtra("struct_share_key_source_action", "plugin");
        paramIntent.putExtra("struct_share_key_source_a_action_data", (String)localObject1);
        paramIntent.putExtra("struct_share_key_source_i_action_data", (String)localObject2);
        label569:
        paramIntent.putExtra("source_puin", str2);
        paramIntent.putExtra("app_name", (String)localObject3);
        localObject2 = "src_iconUrl";
        str1 = paramJSONObject.optString((String)localObject2, "");
        if (TextUtils.isEmpty(str1))
        {
          localObject1 = "struct_share_key_source_icon";
          paramIntent.putExtra((String)localObject1, "https://url.cn/JS8oE7");
        }
        else
        {
          localObject1 = "struct_share_key_source_icon";
          paramIntent.putExtra((String)localObject1, str1);
        }
      }
    }
    else
    {
      localObject3 = paramJSONObject;
      str1 = "src_iconUrl";
      str2 = "struct_share_key_source_icon";
      if (!((JSONObject)localObject3).has("source_name")) {
        break label756;
      }
      str3 = ((JSONObject)localObject3).optString("source_name");
      paramIntent.putExtra("app_name", str3);
      localObject2 = str1;
      localObject1 = str2;
      if ("手Q阅读".equals(str3))
      {
        localObject2 = str1;
        localObject1 = str2;
        if (((JSONObject)localObject3).has("srcIconUrl"))
        {
          paramIntent.putExtra(str2, ((JSONObject)localObject3).optString("srcIconUrl"));
          localObject1 = str2;
          localObject2 = str1;
        }
      }
    }
    break label779;
    label756:
    paramIntent.putExtra("app_name", paramActivity.getString(2131894190));
    Object localObject1 = str2;
    Object localObject2 = str1;
    label779:
    paramJSONObject = paramJSONObject.optString((String)localObject2, "");
    if (TextUtils.isEmpty(paramJSONObject)) {
      paramIntent.putExtra((String)localObject1, "https://url.cn/JS8oE7");
    } else {
      paramIntent.putExtra((String)localObject1, paramJSONObject);
    }
    paramJSONObject = StructMsgFactory.a(paramIntent.getExtras());
    if (paramJSONObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(a, 2, "build struct msg fail");
      }
      return;
    }
    paramIntent.putExtra("stuctmsg_bytes", paramJSONObject.getBytes());
    paramActivity.startActivityForResult(paramIntent, 21);
  }
  
  private void a(Activity paramActivity, JSONObject paramJSONObject, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, int paramInt, boolean paramBoolean)
  {
    String str2 = paramString1;
    String str1 = paramString2;
    Intent localIntent = new Intent();
    Object localObject = paramJSONObject.optString("toUin");
    int i = paramJSONObject.optInt("uinType", 0);
    String str3 = paramJSONObject.optString("friendName");
    if ((localObject != null) && (((String)localObject).length() >= 5))
    {
      localIntent.setClass(paramActivity.getApplicationContext(), DirectForwardActivity.class);
      localIntent.putExtra("toUin", (String)localObject);
      localIntent.putExtra("uinType", i);
      localIntent.putExtra("uinname", str3);
    }
    else
    {
      localIntent.putExtra("isWebCompShare", true);
      localIntent.setClass(paramActivity.getApplicationContext(), ForwardRecentActivity.class);
    }
    localObject = paramJSONObject.optJSONObject("shareVideoMsgForArk");
    if (localObject != null)
    {
      localIntent.putExtras(VideoStructMsgHelper.a.a((JSONObject)localObject));
      paramActivity.startActivityForResult(localIntent, 21);
      return;
    }
    localIntent.putExtra("key_flag_from_plugin", true);
    localObject = str2;
    if (str2 != null)
    {
      localObject = str2;
      if (paramString1.length() > 45)
      {
        paramString1 = new StringBuilder();
        paramString1.append(str2.substring(0, 45));
        paramString1.append("…");
        localObject = paramString1.toString();
      }
    }
    paramString1 = str1;
    if (str1 != null)
    {
      paramString1 = str1;
      if (paramString2.length() > 60)
      {
        paramString1 = new StringBuilder();
        paramString1.append(str1.substring(0, 60));
        paramString1.append("…");
        paramString1 = paramString1.toString();
      }
    }
    if (paramInt <= 0) {
      paramInt = 13;
    }
    localIntent.putExtra("pluginName", "web_share");
    localIntent.putExtra("title", (String)localObject);
    localIntent.putExtra("desc", paramString1);
    localIntent.putExtra("detail_url", paramString3);
    localIntent.putExtra("shareQQType", paramInt);
    localIntent.putExtra("forward_type", 1001);
    localIntent.putExtra("req_share_id", paramJSONObject.optLong("app_id", -1L));
    localIntent.putExtra("pkg_name", "com.tencent.mobileqq");
    localIntent.putExtra("image_url_remote", paramString4);
    localIntent.putExtra("brief_key", BaseApplicationImpl.getContext().getString(2131894173, new Object[] { localObject }));
    localIntent.putExtra("flag", paramJSONObject.optInt("flag", 0));
    localIntent.putExtra("is_need_show_toast", paramBoolean);
    if (paramJSONObject.has("contentAction")) {
      localIntent.putExtra("struct_share_key_content_action", paramJSONObject.getString("contentAction"));
    }
    if (paramJSONObject.has("actionData")) {
      localIntent.putExtra("struct_share_key_content_action_DATA", paramJSONObject.getString("actionData"));
    }
    if (paramJSONObject.has("sourceAction")) {
      localIntent.putExtra("struct_share_key_source_action", paramJSONObject.getString("sourceAction"));
    }
    if (paramJSONObject.has("isShareFlag")) {
      localIntent.putExtra("is_share_flag", Integer.parseInt(paramJSONObject.getString("isShareFlag")));
    }
    if (paramJSONObject.has("srcActionData")) {
      localIntent.putExtra("struct_share_key_source_action_data", paramJSONObject.getString("srcActionData"));
    }
    if (paramJSONObject.has("appName")) {
      localIntent.putExtra("app_name", paramJSONObject.getString("appName"));
    }
    if (paramJSONObject.has("source_name")) {
      localIntent.putExtra("app_name", paramJSONObject.getString("source_name"));
    }
    if (paramJSONObject.has("sourceName")) {
      localIntent.putExtra("app_name", paramJSONObject.getString("sourceName"));
    }
    if ("audio".equals(paramString5))
    {
      paramInt = 2;
      localIntent.putExtra("audio_url", paramString6);
    }
    else
    {
      i = paramJSONObject.optInt("req_type", 1);
      paramInt = i;
      if (i == 2)
      {
        localIntent.putExtra("audio_url", paramJSONObject.getString("audio_url"));
        paramInt = i;
      }
    }
    localIntent.putExtra("req_type", paramInt);
    localIntent.putExtra("openerProc", MobileQQ.getMobileQQ().getQQProcessName());
    paramBoolean = paramJSONObject.optBoolean("back", true);
    if (paramJSONObject.has("k_back")) {
      paramBoolean = paramJSONObject.getBoolean("k_back");
    }
    localIntent.putExtra("k_back", paramBoolean);
    if (paramJSONObject.has("serviceID")) {
      localIntent.putExtra("new_share_service_id", paramJSONObject.getString("serviceID"));
    }
    long l = paramJSONObject.optLong("appid", 0L);
    if (l > 0L)
    {
      a(paramActivity, localIntent, l);
      return;
    }
    a(paramActivity, paramJSONObject, localIntent);
  }
  
  private void a(JSONObject paramJSONObject, int paramInt1, Activity paramActivity, String paramString1, int paramInt2, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, boolean paramBoolean, int paramInt3)
  {
    if (paramInt1 == 72)
    {
      paramJSONObject.put("toUin", paramString1);
      paramJSONObject.put("uinType", paramInt2);
      paramJSONObject.put("friendName", paramString2);
    }
    if ((paramString6 != null) && (paramString6.contains("kandianshare.html5.qq.com")))
    {
      a(paramActivity, paramJSONObject, paramString3, paramString4, paramString6, paramString7, paramString8, paramString9, paramInt3, paramBoolean ^ true);
      return;
    }
    a(paramActivity, paramJSONObject, paramString3, paramString4, paramString5, paramString7, paramString8, paramString9, paramInt3, paramBoolean ^ true);
  }
  
  private void a(JSONObject paramJSONObject, int paramInt, AppInterface paramAppInterface, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, boolean paramBoolean1, boolean paramBoolean2)
  {
    HashMap localHashMap = new HashMap(1);
    int i;
    if (!WXShareHelper.a().b()) {
      i = 2131918154;
    } else if (!WXShareHelper.a().c()) {
      i = 2131918155;
    } else {
      i = -1;
    }
    if (i != -1)
    {
      QRUtils.a(0, i);
      return;
    }
    boolean bool;
    if ((paramJSONObject.optInt("WXShareToMiniProgram") == 1) && (paramInt == 9)) {
      bool = true;
    } else {
      bool = false;
    }
    String str = paramJSONObject.optString("WXSharePath");
    if (TextUtils.isEmpty(paramJSONObject.optString("WXShareMiniProgramSourceID"))) {
      paramJSONObject = "gh_eaa1f0b1626b";
    } else {
      paramJSONObject = paramJSONObject.optString("WXShareMiniProgramSourceID");
    }
    b();
    paramJSONObject = new QShareUtils.1(this, localHashMap, bool, paramString1, paramString2, paramString3, str, paramJSONObject, paramBoolean2, paramInt, paramString6, paramString5);
    if (TextUtils.isEmpty(paramString4))
    {
      paramJSONObject.run();
      return;
    }
    ThreadManager.post(new QShareUtils.2(this, paramString4, bool, paramBoolean1, localHashMap, paramAppInterface, paramJSONObject), 8, null, false);
  }
  
  private void a(JSONObject paramJSONObject, Activity paramActivity, AppInterface paramAppInterface, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("title", paramString1);
    localBundle.putString("desc", paramString2);
    if ((paramString4 != null) && (paramString4.contains("kandianshare.html5.qq.com"))) {
      localBundle.putString("detail_url", paramString4);
    } else {
      localBundle.putString("detail_url", paramString3);
    }
    localBundle.putString("from", "qq");
    localBundle.putString("default_text", paramJSONObject.optString("default_text"));
    paramJSONObject = new ArrayList(1);
    paramJSONObject.add(paramString5);
    localBundle.putStringArrayList("image_url", paramJSONObject);
    localBundle.putLong("req_share_id", 0L);
    localBundle.putInt("iUrlInfoFrm", 1);
    localBundle.putLong("share_begin_time", SwiftBrowserShareMenuHandler.x);
    if (!QZoneShareManager.jumpToQzoneShare(paramAppInterface, paramActivity, localBundle, null, 125)) {
      QRUtils.a(1, 2131886094);
    }
  }
  
  public static List<Integer>[] a(boolean paramBoolean, Set<String> paramSet)
  {
    if (BaseApplicationImpl.getApplication().getRuntime() == null) {
      return null;
    }
    ArrayList localArrayList1 = new ArrayList();
    if ((!paramSet.contains("menuItem:share:kandian")) && (!paramSet.contains("menuItem:share:diandian")) && (paramBoolean)) {
      localArrayList1.add(Integer.valueOf(13));
    }
    if (!paramSet.contains("menuItem:share:qq")) {
      localArrayList1.add(Integer.valueOf(2));
    }
    if (!paramSet.contains("menuItem:share:QZone")) {
      localArrayList1.add(Integer.valueOf(3));
    }
    if (!paramSet.contains("menuItem:share:appMessage")) {
      localArrayList1.add(Integer.valueOf(9));
    }
    if (!paramSet.contains("menuItem:share:timeline")) {
      localArrayList1.add(Integer.valueOf(10));
    }
    if (!paramSet.contains("menuItem:share:sinaWeibo")) {
      localArrayList1.add(Integer.valueOf(12));
    }
    paramSet.contains("menuItem:openWithQQBrowser");
    if (!paramSet.contains("menuItem:openWithSafari")) {
      localArrayList1.add(Integer.valueOf(4));
    }
    ArrayList localArrayList2 = new ArrayList();
    if (!paramSet.contains("menuItem:screenShotShare")) {
      localArrayList2.add(Integer.valueOf(21));
    }
    if (!paramSet.contains("menuItem:copyUrl")) {
      localArrayList2.add(Integer.valueOf(1));
    }
    if (!paramSet.contains("menuItem:exposeArticle")) {
      localArrayList2.add(Integer.valueOf(11));
    }
    Collections.sort(localArrayList2);
    return new List[] { localArrayList1, localArrayList2 };
  }
  
  private Bitmap b(Bitmap paramBitmap)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    paramBitmap.compress(Bitmap.CompressFormat.JPEG, 85, localByteArrayOutputStream);
    byte[] arrayOfByte = localByteArrayOutputStream.toByteArray();
    try
    {
      localByteArrayOutputStream.close();
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
    }
    Bitmap localBitmap = paramBitmap;
    if (arrayOfByte.length / 1024 > 63) {
      localBitmap = a(paramBitmap);
    }
    return localBitmap;
  }
  
  private void b()
  {
    if (this.d != null) {
      return;
    }
    this.d = new QShareUtils.3(this);
    WXShareHelper.a().a(this.d);
  }
  
  private void c()
  {
    Object localObject = this.b;
    if ((localObject != null) && (((QQProgressDialog)localObject).isShowing()))
    {
      long l = System.currentTimeMillis();
      if (QLog.isColorLevel())
      {
        localObject = a;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("dialog dimiss time :");
        localStringBuilder.append(l);
        QLog.d((String)localObject, 2, localStringBuilder.toString());
      }
      this.b.dismiss();
    }
  }
  
  public int a(int paramInt)
  {
    int i = 3;
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3)
        {
          if (paramInt != 9)
          {
            if (paramInt != 10)
            {
              if (paramInt != 12)
              {
                if (paramInt != 13) {
                  return -1;
                }
                return 7;
              }
              return 4;
            }
          }
          else {
            return 2;
          }
        }
        else {
          return 1;
        }
      }
      else {
        return 0;
      }
    }
    else {
      i = 8;
    }
    return i;
  }
  
  public void a()
  {
    WXShareHelper.a().b(this.d);
  }
  
  public void a(JSONObject paramJSONObject, int paramInt1, Activity paramActivity, String paramString1, int paramInt2, String paramString2)
  {
    AppInterface localAppInterface = (AppInterface)ReadInJoyUtils.b();
    for (;;)
    {
      try
      {
        paramJSONObject.optString("source_name", "QQ浏览器");
        String str1 = paramJSONObject.optString("title");
        String str2 = paramJSONObject.optString("desc");
        String str3 = paramJSONObject.optString("share_url");
        String str4 = paramJSONObject.optString("aio_share_url");
        String str5 = paramJSONObject.optString("qzone_share_url");
        String str6 = paramJSONObject.optString("image_url");
        String str7 = paramJSONObject.optString("flash_url");
        String str8 = paramJSONObject.optString("shareText");
        String str9 = paramJSONObject.optString("shouldSharePlainTextChannel");
        if (paramJSONObject.optInt("hideSuccessToast") != 1) {
          break label308;
        }
        bool1 = true;
        if (paramJSONObject.optInt("forceCompress") != 1) {
          break label314;
        }
        bool2 = true;
        if (paramJSONObject.optInt("is_video") != 1) {
          break label320;
        }
        bool3 = true;
        int i = paramJSONObject.optInt("shareQQType", 13);
        if ((paramInt1 != 72) && (paramInt1 != 2) && (paramInt1 != 73))
        {
          if (paramInt1 != 3) {
            break label326;
          }
          a(paramJSONObject, paramActivity, localAppInterface, str1, str2, str3, str5, str6);
          return;
          if (paramInt1 == 12)
          {
            a(paramActivity, str1, str3, str4, str6);
            ReadInJoyLogicEngine.a().O();
            return;
            a(paramJSONObject, paramInt1, localAppInterface, str1, str2, a(paramJSONObject, str3, paramInt1), str6, str8, str9, bool2, bool3);
            ReadInJoyLogicEngine.a().O();
          }
        }
        else
        {
          a(paramJSONObject, paramInt1, paramActivity, paramString1, paramInt2, paramString2, str1, str2, str3, str4, str6, "news", str7, bool1, i);
          return;
        }
      }
      catch (Exception paramJSONObject)
      {
        paramJSONObject.printStackTrace();
      }
      return;
      label308:
      boolean bool1 = false;
      continue;
      label314:
      boolean bool2 = false;
      continue;
      label320:
      boolean bool3 = false;
      continue;
      label326:
      if (paramInt1 != 9) {
        if (paramInt1 != 10) {}
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.viola.modules.QShareUtils
 * JD-Core Version:    0.7.0.1
 */