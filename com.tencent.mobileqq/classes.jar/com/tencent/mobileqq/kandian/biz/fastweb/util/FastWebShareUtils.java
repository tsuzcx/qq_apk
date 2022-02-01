package com.tencent.mobileqq.kandian.biz.fastweb.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.net.Uri.Builder;
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
import com.tencent.mobileqq.kandian.base.utils.RIJSPUtils;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.fastweb.FastWebActivity;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicEngine;
import com.tencent.mobileqq.kandian.glue.report.RIJTransMergeKanDianReport;
import com.tencent.mobileqq.kandian.glue.report.ReadinjoyReportUtils;
import com.tencent.mobileqq.kandian.repo.common.constant.ReadInJoyConstants;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgFactory;
import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserShareMenuHandler;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.mobileqq.wxapi.WXShareHelper.WXShareListener;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QZoneShareManager;
import java.util.ArrayList;
import java.util.HashMap;
import mqq.app.MobileQQ;
import org.json.JSONException;
import org.json.JSONObject;

public class FastWebShareUtils
{
  private static final String a = "FastWebShareUtils";
  private String b;
  private WXShareHelper.WXShareListener c;
  private QQProgressDialog d;
  private AbsBaseArticleInfo e;
  
  private int a(int paramInt)
  {
    int i = paramInt;
    if (paramInt <= 0) {
      i = 13;
    }
    return i;
  }
  
  private String a(IPublicAccountDetail paramIPublicAccountDetail, String paramString1, JSONObject paramJSONObject, String paramString2)
  {
    boolean bool = TextUtils.isEmpty(paramString1);
    Object localObject = null;
    paramString1 = null;
    if (bool)
    {
      if (paramIPublicAccountDetail != null) {
        paramString1 = paramIPublicAccountDetail.getName();
      }
      if ((TextUtils.isEmpty(paramString1)) && (paramJSONObject.has("sourceName"))) {
        paramString1 = paramJSONObject.optString("sourceName");
      }
      paramIPublicAccountDetail = paramString1;
      if (!TextUtils.isEmpty(paramString1)) {
        return paramIPublicAccountDetail;
      }
    }
    else
    {
      paramString1 = localObject;
      if (paramJSONObject.has("sourceName")) {
        paramString1 = paramJSONObject.optString("sourceName");
      }
      if ((TextUtils.isEmpty(paramString1)) && (paramIPublicAccountDetail != null)) {
        paramString1 = paramIPublicAccountDetail.getName();
      }
      paramIPublicAccountDetail = paramString1;
      if (!TextUtils.isEmpty(paramString1)) {
        return paramIPublicAccountDetail;
      }
    }
    paramIPublicAccountDetail = paramString2;
    return paramIPublicAccountDetail;
  }
  
  private String a(String paramString)
  {
    String str = ReadInJoyUtils.a();
    if (TextUtils.isEmpty(str)) {
      return paramString;
    }
    try
    {
      Uri.Builder localBuilder = Uri.parse(paramString).buildUpon();
      localBuilder.appendQueryParameter("iid", str);
      str = localBuilder.toString();
      return str;
    }
    catch (NullPointerException localNullPointerException)
    {
      QLog.e(a, 2, localNullPointerException, new Object[0]);
    }
    return paramString;
  }
  
  public static String a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    return new UrlBuilder(paramString1).a("title", paramString2).a("url", paramString3).a("pic", paramString4).a("_wv", "3").a();
  }
  
  private void a(long paramLong, AppInterface paramAppInterface, Activity paramActivity, Intent paramIntent)
  {
    Share.a(paramAppInterface, paramActivity, paramAppInterface.getAccount(), paramLong, 3000L, new FastWebShareUtils.4(this, paramIntent, paramActivity));
  }
  
  private void a(Activity paramActivity)
  {
    if (this.d == null) {
      this.d = new QQProgressDialog(paramActivity);
    }
  }
  
  public static void a(Context paramContext, String paramString, int paramInt, AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (paramAbsBaseArticleInfo == null) {
        return;
      }
      paramContext = RIJTransMergeKanDianReport.a(paramContext, paramAbsBaseArticleInfo, (int)paramAbsBaseArticleInfo.mChannelID, "1");
      try
      {
        paramContext.put("location", paramInt);
        ReportUtil.a(paramAbsBaseArticleInfo, paramString, paramContext.toString());
        return;
      }
      catch (Exception paramContext)
      {
        paramContext.printStackTrace();
      }
    }
  }
  
  public static void a(Context paramContext, String paramString, int paramInt1, AbsBaseArticleInfo paramAbsBaseArticleInfo, int paramInt2)
  {
    if (paramInt2 == -1)
    {
      a(paramContext, paramString, paramInt1, paramAbsBaseArticleInfo);
      return;
    }
    paramContext = RIJTransMergeKanDianReport.a(paramContext, paramAbsBaseArticleInfo, (int)paramAbsBaseArticleInfo.mChannelID, "1", paramInt2);
    try
    {
      paramContext.put("location", paramInt1);
      ReportUtil.a(paramAbsBaseArticleInfo, paramString, paramContext.toString());
      return;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  private void a(Intent paramIntent, String paramString1, String paramString2)
  {
    if (paramIntent != null)
    {
      if (TextUtils.isEmpty(paramString2)) {
        return;
      }
      paramIntent.putExtra(paramString1, paramString2);
    }
  }
  
  private void a(Intent paramIntent, String paramString1, String paramString2, JSONObject paramJSONObject)
  {
    int i;
    if ("audio".equals(paramString1))
    {
      paramIntent.putExtra("audio_url", paramString2);
      i = 2;
    }
    else
    {
      j = paramJSONObject.optInt("req_type", 1);
      i = j;
      if (j == 2)
      {
        paramIntent.putExtra("audio_url", paramJSONObject.getString("audio_url"));
        i = j;
      }
    }
    int j = i;
    if (i == 1) {
      j = 144;
    }
    paramIntent.putExtra("req_type", j);
    if (paramJSONObject.has("report")) {
      paramIntent.putExtra("report", paramJSONObject.getString("report"));
    }
  }
  
  private void a(Intent paramIntent, String paramString1, JSONObject paramJSONObject, String paramString2, boolean paramBoolean)
  {
    if (paramIntent != null)
    {
      if (paramJSONObject == null) {
        return;
      }
      if (paramJSONObject.has(paramString2))
      {
        if (paramBoolean) {}
        try
        {
          paramIntent.putExtra(paramString1, Integer.parseInt(paramJSONObject.getString(paramString2)));
          return;
        }
        catch (NumberFormatException paramIntent)
        {
          paramString1 = a;
          paramJSONObject = new StringBuilder();
          paramJSONObject.append("[handleShareMsgToQQParams] paramsKey = ");
          paramJSONObject.append(paramString2);
          paramJSONObject.append(", e = ");
          paramJSONObject.append(paramIntent);
          QLog.e(paramString1, 1, paramJSONObject.toString());
          return;
        }
        catch (JSONException paramIntent)
        {
          paramString1 = a;
          paramJSONObject = new StringBuilder();
          paramJSONObject.append("[handleShareMsgToQQParams] paramsKey = ");
          paramJSONObject.append(paramString2);
          paramJSONObject.append(", e = ");
          paramJSONObject.append(paramIntent);
          QLog.e(paramString1, 1, paramJSONObject.toString());
        }
        paramIntent.putExtra(paramString1, paramJSONObject.getString(paramString2));
        return;
      }
    }
  }
  
  private void a(Intent paramIntent, JSONObject paramJSONObject)
  {
    paramIntent.putExtra("openerProc", MobileQQ.getMobileQQ().getQQProcessName());
    boolean bool = paramJSONObject.optBoolean("back", false);
    if (paramJSONObject.has("k_back")) {
      bool = paramJSONObject.getBoolean("k_back");
    }
    paramIntent.putExtra("k_back", bool);
    if (paramJSONObject.has("serviceID")) {
      paramIntent.putExtra("new_share_service_id", paramJSONObject.getString("serviceID"));
    }
  }
  
  private void a(Intent paramIntent, JSONObject paramJSONObject, Activity paramActivity)
  {
    long l = paramJSONObject.optLong("appid", 0L);
    if (l > 0L)
    {
      paramJSONObject = (AppInterface)ReadInJoyUtils.b();
      if (paramJSONObject != null)
      {
        a(paramActivity);
        if (!this.d.isShowing())
        {
          this.d.c(2131891516);
          this.d.show();
        }
        paramIntent.putExtra("struct_share_key_source_name", Long.toString(l));
        a(l, paramJSONObject, paramActivity, paramIntent);
      }
    }
    else
    {
      a(paramActivity);
      Object localObject1 = this.d;
      if ((localObject1 != null) && (((QQProgressDialog)localObject1).isShowing()))
      {
        l = System.currentTimeMillis();
        localObject1 = a;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("dialog dimiss time :");
        ((StringBuilder)localObject2).append(l);
        QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
        this.d.dismiss();
      }
      Object localObject2 = paramJSONObject.optString("puin", null);
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = paramJSONObject.optString("oaUin");
      }
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        localObject2 = (AppInterface)ReadInJoyUtils.b();
        localObject2 = ((AppInterface)localObject2).getEntityManagerFactory(((AppInterface)localObject2).getAccount()).createEntityManager();
        Object localObject3 = (IPublicAccountDetail)((EntityManager)localObject2).find(((IPublicAccountProxy)QRoute.api(IPublicAccountProxy.class)).getImplClass(IPublicAccountDetail.class), (String)localObject1);
        ((EntityManager)localObject2).close();
        localObject2 = paramJSONObject.optString("src_action", "");
        String str = a((IPublicAccountDetail)localObject3, (String)localObject2, paramJSONObject, (String)localObject1);
        if (str.equalsIgnoreCase(paramActivity.getString(2131897917)))
        {
          boolean bool = str.equalsIgnoreCase(paramActivity.getString(2131897917));
          if (bool) {
            paramJSONObject = "mqqapi://app/action?pkg=com.tencent.mobileqq&cmp=cooperation.readinjoy.ReadInJoyProxyActivity";
          } else {
            paramJSONObject = "mqqapi://app/action?pkg=com.tencent.mobileqq&cmp=cooperation.readinjoy.ReadInJoyProxyActivity&from=recent";
          }
          if (bool) {
            localObject2 = "mqqapi://readinjoy/open?src_type=internal&version=1";
          } else {
            localObject2 = "mqqapi://readinjoy/open?src_type=internal&version=1&from=recent";
          }
          if (bool) {
            localObject3 = "https://sqimg.qq.com/qq_product_operations/ydqpush/message_icon/kandian.png";
          } else {
            localObject3 = "https://sqimg.qq.com/qq_product_operations/ydqpush/message_icon/dingyuehao.png";
          }
          paramIntent.putExtra("source_puin", (String)localObject1);
          paramIntent.putExtra("struct_share_key_source_action", "plugin");
          paramIntent.putExtra("struct_share_key_source_a_action_data", paramJSONObject);
          paramIntent.putExtra("struct_share_key_source_i_action_data", (String)localObject2);
          paramIntent.putExtra("struct_share_key_content_a_action_DATA", paramJSONObject);
          paramIntent.putExtra("struct_share_key_source_icon", (String)localObject3);
          paramIntent.putExtra("app_name", str);
        }
        else
        {
          localObject3 = paramJSONObject.optString("puin");
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(ReadInJoyConstants.l);
          localStringBuilder.append(Base64Util.encodeToString(((String)localObject3).getBytes(), 2));
          paramJSONObject.put("src_webActionUrl", localStringBuilder.toString());
          a(paramIntent, paramJSONObject, (String)localObject2, (String)localObject1, str);
        }
      }
      else if (paramJSONObject.has("sourceName"))
      {
        localObject1 = paramJSONObject.optString("sourceName");
        paramIntent.putExtra("app_name", (String)localObject1);
        if (("手Q阅读".equals(localObject1)) && (paramJSONObject.has("srcIconUrl"))) {
          paramIntent.putExtra("struct_share_key_source_icon", paramJSONObject.optString("srcIconUrl"));
        }
      }
      else
      {
        paramIntent.putExtra("app_name", paramActivity.getString(2131894190));
      }
      paramJSONObject = StructMsgFactory.a(paramIntent.getExtras());
      if (paramJSONObject == null)
      {
        QLog.d(a, 2, "build struct msg fail");
        return;
      }
      paramIntent.putExtra("stuctmsg_bytes", paramJSONObject.getBytes());
      paramActivity.startActivityForResult(paramIntent, 1);
    }
  }
  
  private void a(Intent paramIntent, JSONObject paramJSONObject, String paramString1, String paramString2, String paramString3)
  {
    String str1 = paramJSONObject.optString("src_webActionUrl", "");
    String str2 = paramJSONObject.optString("src_actionData", "");
    String str3 = paramJSONObject.optString("src_a_actionData", "");
    String str4 = paramJSONObject.optString("src_i_actionData", "");
    if ((!TextUtils.isEmpty(paramString1)) && ((!"web".equals(paramString1)) || ((!TextUtils.isEmpty(str1)) && (!str1.contains("webcard.mp.qq.com")))) && (("web".equals(paramString1)) || (!TextUtils.isEmpty(str2)) || ((!TextUtils.isEmpty(str3)) && (!TextUtils.isEmpty(str4)))))
    {
      paramIntent.putExtra("struct_share_key_source_action", paramString1);
      if ("web".equals(paramString1))
      {
        paramString1 = ReadinjoyReportUtils.a(this.e, str1, ReadinjoyReportUtils.f);
        paramIntent.putExtra("struct_share_key_source_url", paramString1);
        paramIntent.putExtra("source_url", paramString1);
      }
      else
      {
        a(paramIntent, "struct_share_key_source_action_data", str2);
        a(paramIntent, "struct_share_key_source_a_action_data", str3);
        a(paramIntent, "struct_share_key_source_i_action_data", str4);
      }
    }
    else
    {
      paramString1 = String.format("mqqapi://app/action?pkg=com.tencent.mobileqq&cmp=com.tencent.biz.pubaccount.AccountDetail.activity.api.impl.AccountDetailActivity&uin=%s", new Object[] { paramString2 });
      str1 = String.format("mqqapi://card/show_pslcard?src_type=internal&card_type=public_account&uin=%s&version=1", new Object[] { paramString2 });
      paramIntent.putExtra("struct_share_key_source_action", "plugin");
      paramIntent.putExtra("struct_share_key_source_a_action_data", paramString1);
      paramIntent.putExtra("struct_share_key_source_i_action_data", str1);
    }
    paramIntent.putExtra("source_puin", paramString2);
    paramIntent.putExtra("app_name", paramString3);
    paramJSONObject = paramJSONObject.optString("src_iconUrl", "");
    if (TextUtils.isEmpty(paramJSONObject))
    {
      paramIntent.putExtra("struct_share_key_source_icon", "https://url.cn/JS8oE7");
      return;
    }
    paramIntent.putExtra("struct_share_key_source_icon", paramJSONObject);
  }
  
  private void a(AbsBaseArticleInfo paramAbsBaseArticleInfo, int paramInt)
  {
    if (this.c != null) {
      return;
    }
    this.c = new FastWebShareUtils.1(this, paramAbsBaseArticleInfo, paramInt);
    WXShareHelper.a().a(this.c);
  }
  
  private void a(String paramString1, String paramString2, int paramInt, String paramString3, String paramString4, String paramString5, String paramString6, AbsBaseArticleInfo paramAbsBaseArticleInfo, String paramString7, Activity paramActivity, boolean paramBoolean)
  {
    HashMap localHashMap = new HashMap(1);
    AppInterface localAppInterface = (AppInterface)ReadInJoyUtils.b();
    int i;
    if (paramInt == 9) {
      i = 3;
    } else {
      i = 4;
    }
    if (!WXShareHelper.a().b()) {
      paramInt = 2131918154;
    } else if (!WXShareHelper.a().c()) {
      paramInt = 2131918155;
    } else {
      paramInt = -1;
    }
    if (paramInt != -1)
    {
      QRUtils.a(0, paramInt);
      return;
    }
    a(paramAbsBaseArticleInfo, i);
    paramString1 = new FastWebShareUtils.2(this, localHashMap, paramBoolean, paramString3, paramString4, paramString5, paramString1, paramString2, localAppInterface, paramString7, paramAbsBaseArticleInfo, i);
    if (TextUtils.isEmpty(paramString6))
    {
      paramString1.run();
      return;
    }
    a(paramActivity);
    this.d.c(2131891516);
    this.d.show();
    ThreadManager.post(new FastWebShareUtils.3(this, paramString6, paramBoolean, localHashMap, localAppInterface, paramString1), 8, null, false);
  }
  
  private void a(String paramString1, String paramString2, String paramString3, AbsBaseArticleInfo paramAbsBaseArticleInfo, String paramString4, Activity paramActivity)
  {
    AppInterface localAppInterface = (AppInterface)ReadInJoyUtils.b();
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
        paramString1 = a("https://service.weibo.com/share/share.php?", paramString1, paramString2, paramString3);
        paramString2 = new Intent(paramActivity, QQBrowserActivity.class);
        paramString2.putExtra("url", paramString1);
        paramActivity.startActivity(paramString2);
        if (QLog.isColorLevel()) {
          QLog.d(a, 2, "shareMsgToSina start webview!");
        }
        a(localAppInterface.getApplication().getApplicationContext(), paramString4, 6, paramAbsBaseArticleInfo);
        ReportUtil.a(localAppInterface.getApplication().getApplicationContext(), localAppInterface, paramAbsBaseArticleInfo, 5, -1, false);
      }
      catch (Exception paramString1)
      {
        QQToast.makeText(BaseApplication.getContext(), 0, 2131916544, 0).show(BaseApplication.getContext().getResources().getDimensionPixelSize(2131299920));
        paramString2 = a;
        paramString3 = new StringBuilder();
        paramString3.append("shareMsgToSina error! msg=");
        paramString3.append(paramString1);
        QLog.d(paramString2, 2, paramString3.toString());
      }
      if (QLog.isColorLevel()) {
        QLog.d(a, 2, "shareMsgToSina end!");
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(a, 2, "shareMsgToSina empty title or share_url");
    }
    QQToast.makeText(BaseApplication.getContext(), 0, 2131916544, 0).show(BaseApplication.getContext().getResources().getDimensionPixelSize(2131299920));
  }
  
  private void a(String paramString1, String paramString2, String paramString3, JSONObject paramJSONObject, String paramString4, AbsBaseArticleInfo paramAbsBaseArticleInfo, String paramString5, Activity paramActivity)
  {
    AppInterface localAppInterface = (AppInterface)ReadInJoyUtils.b();
    Bundle localBundle = new Bundle();
    localBundle.putString("title", paramString1);
    localBundle.putString("desc", paramString2);
    localBundle.putString("detail_url", paramString3);
    localBundle.putString("from", "qq");
    if (paramJSONObject != null) {
      localBundle.putString("default_text", paramJSONObject.optString("default_text"));
    }
    paramString1 = new ArrayList(1);
    if ((TextUtils.isEmpty(paramString4)) && (paramAbsBaseArticleInfo != null) && (!TextUtils.isEmpty(paramAbsBaseArticleInfo.mFirstPagePicUrl))) {
      paramString1.add(paramAbsBaseArticleInfo.mFirstPagePicUrl);
    } else {
      paramString1.add(paramString4);
    }
    localBundle.putStringArrayList("image_url", paramString1);
    localBundle.putLong("req_share_id", 0L);
    localBundle.putInt("iUrlInfoFrm", 1);
    localBundle.putLong("share_begin_time", SwiftBrowserShareMenuHandler.x);
    if (!QZoneShareManager.jumpToQzoneShare(localAppInterface, paramActivity, localBundle, null, 1))
    {
      QRUtils.a(1, 2131886094);
      ReportUtil.b(localAppInterface.getApplication().getApplicationContext(), localAppInterface, paramAbsBaseArticleInfo, 2, -1, false, false);
      return;
    }
    a(localAppInterface.getApplication().getApplicationContext(), paramString5, 3, paramAbsBaseArticleInfo);
    ReportUtil.a(localAppInterface.getApplication().getApplicationContext(), localAppInterface, paramAbsBaseArticleInfo, 2, -1, false);
  }
  
  public static boolean a()
  {
    return TextUtils.equals("1", (CharSequence)RIJSPUtils.b("kandian_daily_fast_web_bottom_share", "0"));
  }
  
  private boolean b(String paramString)
  {
    return (paramString != null) && (paramString.length() >= 5);
  }
  
  private String c(String paramString)
  {
    Object localObject = paramString;
    if (paramString != null)
    {
      localObject = paramString;
      if (paramString.length() > 45)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramString.substring(0, 45));
        ((StringBuilder)localObject).append("…");
        localObject = ((StringBuilder)localObject).toString();
      }
    }
    return localObject;
  }
  
  private String d(String paramString)
  {
    Object localObject = paramString;
    if (paramString != null)
    {
      localObject = paramString;
      if (paramString.length() > 60)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramString.substring(0, 60));
        ((StringBuilder)localObject).append("…");
        localObject = ((StringBuilder)localObject).toString();
      }
    }
    return localObject;
  }
  
  void a(Activity paramActivity, JSONObject paramJSONObject, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, int paramInt)
  {
    Intent localIntent = new Intent();
    String str1 = paramJSONObject.optString("toUin");
    int i = paramJSONObject.optInt("uinType", 0);
    String str2 = paramJSONObject.optString("friendName");
    if (b(str1))
    {
      localIntent.setClass(paramActivity.getApplicationContext(), DirectForwardActivity.class);
      localIntent.putExtra("toUin", str1);
      localIntent.putExtra("uinType", i);
      localIntent.putExtra("uinname", str2);
    }
    else
    {
      localIntent.putExtra("isWebCompShare", true);
      localIntent.setClass(paramActivity.getApplicationContext(), ForwardRecentActivity.class);
    }
    localIntent.putExtra("key_flag_from_plugin", true);
    paramString1 = c(paramString1);
    paramString2 = d(paramString2);
    paramInt = a(paramInt);
    localIntent.putExtra("pluginName", "web_share");
    localIntent.putExtra("title", paramString1);
    localIntent.putExtra("desc", paramString2);
    localIntent.putExtra("detail_url", paramString3);
    localIntent.putExtra("shareQQType", paramInt);
    localIntent.putExtra("forward_type", 1001);
    localIntent.putExtra("req_share_id", paramJSONObject.optLong("appid", -1L));
    localIntent.putExtra("pkg_name", "com.tencent.mobileqq");
    localIntent.putExtra("image_url_remote", paramString4);
    localIntent.putExtra("brief_key", BaseApplicationImpl.getContext().getString(2131894173, new Object[] { paramString1 }));
    localIntent.putExtra("flag", paramJSONObject.optInt("flag", 0));
    a(localIntent, "struct_share_key_content_action", paramJSONObject, "contentAction", false);
    a(localIntent, "struct_share_key_content_action_DATA", paramJSONObject, "actionData", false);
    a(localIntent, "struct_share_key_source_action", paramJSONObject, "sourceAction", false);
    a(localIntent, "is_share_flag", paramJSONObject, "isShareFlag", true);
    a(localIntent, "struct_share_key_source_action_data", paramJSONObject, "srcActionData", false);
    a(localIntent, "app_name", paramJSONObject, "appName", false);
    a(localIntent, paramString5, paramString6, paramJSONObject);
    a(localIntent, paramJSONObject);
    a(localIntent, paramJSONObject, paramActivity);
  }
  
  public void a(AbsBaseArticleInfo paramAbsBaseArticleInfo, int paramInt1, Activity paramActivity, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt2, String paramString5)
  {
    this.e = paramAbsBaseArticleInfo;
    AppInterface localAppInterface = (AppInterface)ReadInJoyUtils.b();
    if (((Boolean)RIJSPUtils.b("is_share_strike", Boolean.valueOf(false))).booleanValue())
    {
      QRUtils.a(1, 2131916544);
      QLog.d(a, 1, "sharing is stroked!");
      return;
    }
    boolean bool;
    try
    {
      paramString3 = new JSONObject(paramString3);
      str1 = paramString3.optString("share_type", "0");
      str2 = paramString3.optString("title");
      str3 = paramString3.optString("desc");
      str4 = a(paramString3.optString("share_url"));
      str5 = paramString3.optString("image_url");
      str6 = paramString3.optString("shareElement");
      str7 = paramString3.optString("flash_url");
      if ((!(paramActivity instanceof FastWebActivity)) || (!"2".equals(str1))) {
        break label475;
      }
      if (paramString3.optInt("mini_program_enabled", 1) != 1) {
        break label469;
      }
      bool = true;
    }
    catch (Exception paramAbsBaseArticleInfo)
    {
      String str1;
      String str2;
      String str3;
      String str4;
      String str5;
      String str6;
      String str7;
      label187:
      int i;
      label293:
      label317:
      paramActivity = a;
      paramString1 = new StringBuilder();
      paramString1.append("doShareAction error! msg=");
      paramString1.append(paramAbsBaseArticleInfo);
      QLog.d(paramActivity, 1, paramString1.toString());
    }
    if (paramAbsBaseArticleInfo != null)
    {
      paramString1 = paramAbsBaseArticleInfo.innerUniqueID;
      i = paramString3.optInt("shareQQType", 13);
      if (paramInt1 != 72) {
        break label489;
      }
      paramString3.put("toUin", paramString4);
      paramString3.put("uinType", paramInt2);
      paramString3.put("friendName", paramString5);
      a(paramActivity, paramString3, str2, str3, str4, str5, str6, str7, i);
      a(localAppInterface.getApplication().getApplicationContext(), paramString2, 2, paramAbsBaseArticleInfo);
      ReportUtil.a(localAppInterface.getApplication().getApplicationContext(), localAppInterface, paramAbsBaseArticleInfo, 1, 19, false);
      return;
      if (paramInt1 != 3) {
        break label503;
      }
      a(str2, str3, str4, paramString3, str5, paramAbsBaseArticleInfo, paramString2, paramActivity);
      return;
      if (paramInt1 == 12)
      {
        a(str2, str4, str5, paramAbsBaseArticleInfo, paramString2, paramActivity);
        ReadInJoyLogicEngine.a().O();
        return;
      }
    }
    for (;;)
    {
      a(paramString1, str1, paramInt1, str2, str3, str4, str5, paramAbsBaseArticleInfo, paramString2, paramActivity, bool);
      ReadInJoyLogicEngine.a().O();
      return;
      for (;;)
      {
        a(paramActivity, paramString3, str2, str3, str4, str5, str6, str7, i);
        a(localAppInterface.getApplication().getApplicationContext(), paramString2, 2, paramAbsBaseArticleInfo);
        ReportUtil.a(localAppInterface.getApplication().getApplicationContext(), localAppInterface, paramAbsBaseArticleInfo, 1, -1, false);
        return;
        return;
        label469:
        bool = false;
        break;
        label475:
        bool = false;
        break;
        paramString1 = "";
        break label187;
        label489:
        if (paramInt1 != 2) {
          if (paramInt1 != 73) {
            break label293;
          }
        }
      }
      label503:
      if (paramInt1 != 9) {
        if (paramInt1 != 10) {
          break label317;
        }
      }
    }
  }
  
  public void b()
  {
    if (this.c != null) {
      WXShareHelper.a().b(this.c);
    }
    this.d = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.fastweb.util.FastWebShareUtils
 * JD-Core Version:    0.7.0.1
 */