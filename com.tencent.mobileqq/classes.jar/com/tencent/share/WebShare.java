package com.tencent.share;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.biz.common.util.Util;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.pubaccount.accountdetail.api.IPublicAccountDetailActivity;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.biz.qrcode.util.QRUtils;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserShareMenuHandler;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.open.agent.report.ReportCenter;
import com.tencent.qphone.base.util.QLog;
import cooperation.plugin.PluginBaseActivity;
import cooperation.qzone.QZoneShareData;
import cooperation.qzone.QZoneShareManager;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/share/WebShare;", "", "hostActivity", "Landroid/app/Activity;", "webview", "Lcom/tencent/biz/pubaccount/CustomWebView;", "runtime", "Lmqq/app/AppRuntime;", "(Landroid/app/Activity;Lcom/tencent/biz/pubaccount/CustomWebView;Lmqq/app/AppRuntime;)V", "activityForLaunchPlugin", "getActivityForLaunchPlugin", "()Landroid/app/Activity;", "setActivityForLaunchPlugin", "(Landroid/app/Activity;)V", "getHostActivity", "onShareHandler", "", "getOnShareHandler", "()Ljava/lang/String;", "setOnShareHandler", "(Ljava/lang/String;)V", "onShareQQFriendHandler", "getOnShareQQFriendHandler", "setOnShareQQFriendHandler", "onShareQQSpecifiedFriendHandler", "getOnShareQQSpecifiedFriendHandler", "setOnShareQQSpecifiedFriendHandler", "onShareQZoneHandler", "getOnShareQZoneHandler", "setOnShareQZoneHandler", "onShareWXFriendHandler", "getOnShareWXFriendHandler", "setOnShareWXFriendHandler", "onShareWXTimelineHandler", "getOnShareWXTimelineHandler", "setOnShareWXTimelineHandler", "getRuntime", "()Lmqq/app/AppRuntime;", "shareProgressDialog", "Lcom/tencent/mobileqq/widget/QQProgressDialog;", "getWebview", "()Lcom/tencent/biz/pubaccount/CustomWebView;", "actionShareToQQFriend", "", "action", "", "uinType", "uin", "nickname", "getShareProgressDialog", "notifyOnShare", "forWhat", "notifyOnShareQQFriend", "notifyOnShareQQSpecifiedFriend", "notifyOnShareQZone", "notifyOnShareWXFriend", "notifyOnShareWXTimeline", "share2QZone", "share2WeChat", "shareUrl", "sourcePuin", "defaultUrl", "msgId", "share2WechatCircle", "shareStructFromH5", "shareToQzone", "", "shareToWechat", "Companion", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class WebShare
{
  public static final WebShare.Companion a = new WebShare.Companion(null);
  @Nullable
  private String b;
  @Nullable
  private String c;
  @Nullable
  private String d;
  @Nullable
  private String e;
  @Nullable
  private String f;
  @Nullable
  private String g;
  private QQProgressDialog h;
  @Nullable
  private Activity i;
  @NotNull
  private final Activity j;
  @Nullable
  private final CustomWebView k;
  @Nullable
  private final AppRuntime l;
  
  public WebShare(@NotNull Activity paramActivity, @Nullable CustomWebView paramCustomWebView, @Nullable AppRuntime paramAppRuntime)
  {
    this.j = paramActivity;
    this.k = paramCustomWebView;
    this.l = paramAppRuntime;
  }
  
  private final void a(int paramInt, String paramString1, String paramString2)
  {
    if (this.d != null)
    {
      JSONObject localJSONObject = new JSONObject();
      try
      {
        localJSONObject.put("targetUinType", paramInt);
        localJSONObject.put("targetUin", paramString1);
        localJSONObject.put("targetNickname", paramString2);
      }
      catch (JSONException paramString1)
      {
        QLog.e("WebShare", 1, "notifyOnShareQQSpecifiedFriend process data error!", (Throwable)paramString1);
      }
      paramString1 = this.k;
      if (paramString1 != null) {
        paramString1.callJs(this.d, new String[] { localJSONObject.toString() });
      }
    }
  }
  
  private final void a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    if (!TextUtils.isEmpty((CharSequence)this.b)) {
      b(3);
    } else if (!TextUtils.isEmpty((CharSequence)this.f)) {
      g();
    }
    ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "mp_msg_webview_40", "weixin_share", 0, 1, 0, "", "", "", "");
    if ((paramString2 != null) && ((Intrinsics.areEqual("", paramString2) ^ true)))
    {
      paramString1 = ((IPublicAccountDetailActivity)QRoute.api(IPublicAccountDetailActivity.class)).getArticleId(paramString3);
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005B07", "0X8005B07", 1003, 0, paramString2, paramString4, paramString3, paramString1, false);
    }
    ReportCenter.a().a("", "", "", "1000", "103", "0", false);
  }
  
  private final void b(int paramInt)
  {
    String str;
    switch (paramInt)
    {
    case 5: 
    default: 
      str = "-1";
      break;
    case 8: 
      str = "4";
      break;
    case 7: 
      str = "6";
      break;
    case 6: 
      str = "5";
      break;
    case 4: 
      str = "3";
      break;
    case 3: 
      str = "2";
      break;
    case 2: 
      str = "1";
      break;
    case 1: 
      str = "0";
    }
    Object localObject = a();
    if (localObject != null) {
      ((QQProgressDialog)localObject).show();
    }
    localObject = this.k;
    if (localObject != null)
    {
      ((CustomWebView)localObject).callJs(this.b, new String[] { str });
      return;
    }
    QLog.w("WebShare", 1, "notifyOnShare webview is null");
  }
  
  private final void c()
  {
    String str = this.e;
    if (str != null)
    {
      CustomWebView localCustomWebView = this.k;
      if (localCustomWebView != null) {
        localCustomWebView.callJs(str, new String[] { "1" });
      }
    }
  }
  
  private final void d()
  {
    String str = this.c;
    if (str != null)
    {
      CustomWebView localCustomWebView = this.k;
      if (localCustomWebView != null) {
        localCustomWebView.callJs(str, new String[] { "0" });
      }
    }
  }
  
  private final boolean e()
  {
    if (this.i == null)
    {
      if (StringsKt.equals(this.j.getPackageName(), "com.tencent.qqreadinjoy", true))
      {
        localObject2 = this.j;
        localObject1 = localObject2;
        if (!(localObject2 instanceof PluginBaseActivity)) {
          localObject1 = null;
        }
        localObject1 = (PluginBaseActivity)localObject1;
        if (localObject1 != null) {
          localObject1 = ((PluginBaseActivity)localObject1).getOutActivity();
        } else {
          localObject1 = null;
        }
      }
      else
      {
        localObject1 = this.j;
      }
      this.i = ((Activity)localObject1);
    }
    QZoneShareData localQZoneShareData = new QZoneShareData();
    Object localObject1 = this.k;
    if (localObject1 != null) {
      localObject1 = ((CustomWebView)localObject1).getTitle();
    } else {
      localObject1 = null;
    }
    Object localObject2 = localObject1;
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      localObject2 = null;
    }
    localQZoneShareData.mTitle = ((String)localObject2);
    localQZoneShareData.mSummary = ((String)null);
    localQZoneShareData.mImageUrls = new ArrayList(1);
    localObject1 = this.k;
    if (localObject1 != null) {
      localObject1 = ((CustomWebView)localObject1).getUrl();
    } else {
      localObject1 = null;
    }
    localQZoneShareData.targetUrl = Util.a((String)localObject1, new String[0]);
    localQZoneShareData.mShareBeginTime = SwiftBrowserShareMenuHandler.x;
    localQZoneShareData.from = 2;
    localObject1 = this.k;
    if (localObject1 != null) {
      localQZoneShareData.mWebUrl = ((CustomWebView)localObject1).getUrl();
    }
    localObject1 = this.l;
    if (localObject1 != null)
    {
      QZoneShareManager.shareToQzone((Context)this.i, ((AppRuntime)localObject1).getCurrentAccountUin(), localQZoneShareData, null, -1);
      return true;
    }
    QRUtils.a(1, 2131886094);
    return true;
  }
  
  private final void f()
  {
    if (!TextUtils.isEmpty((CharSequence)this.b)) {
      b(4);
    } else if (!TextUtils.isEmpty((CharSequence)this.g)) {
      h();
    }
    ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "mp_msg_webview_42", "pengyouquan_share", 0, 1, 0, "", "", "", "");
    ReportCenter.a().a("", "", "", "1000", "104", "0", false);
  }
  
  private final void g()
  {
    String str = this.f;
    if (str != null)
    {
      CustomWebView localCustomWebView = this.k;
      if (localCustomWebView != null) {
        localCustomWebView.callJs(str, new String[] { "2" });
      }
    }
  }
  
  private final void h()
  {
    String str = this.g;
    if (str != null)
    {
      CustomWebView localCustomWebView = this.k;
      if (localCustomWebView != null) {
        localCustomWebView.callJs(str, new String[] { "3" });
      }
    }
  }
  
  private final void i()
  {
    Object localObject = this.k;
    if (localObject != null) {
      localObject = ((CustomWebView)localObject).getUrl();
    } else {
      localObject = null;
    }
    localObject = Util.a((String)localObject, new String[0]);
    ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).reportPAShareItemEvent(1001, (String)localObject, 100);
    if (!TextUtils.isEmpty((CharSequence)this.b)) {
      b(1);
    } else if (!TextUtils.isEmpty((CharSequence)this.c)) {
      d();
    } else {
      QLog.e("WebShare", 1, "onShareHandler and onShareQQFriendHandler is empty");
    }
    ReportCenter.a().a("", "", "", "1000", "101", "0", false);
    ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "mp_msg_webview_38", "qq_share", 0, 1, 0, "", "", "", "");
  }
  
  @Nullable
  public final QQProgressDialog a()
  {
    if (this.h == null)
    {
      int m = this.j.getResources().getDimensionPixelSize(2131299920);
      this.h = new QQProgressDialog((Context)this.j, m);
      Object localObject = this.h;
      if (localObject != null) {
        ((QQProgressDialog)localObject).c(2131886090);
      }
      long l1 = System.currentTimeMillis();
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("dialog show time :");
        ((StringBuilder)localObject).append(l1);
        QLog.d("WebShare", 2, ((StringBuilder)localObject).toString());
      }
    }
    return this.h;
  }
  
  public final void a(int paramInt)
  {
    Object localObject = this.k;
    if (localObject != null) {
      localObject = ((CustomWebView)localObject).getUrl();
    } else {
      localObject = null;
    }
    localObject = Util.a((String)localObject, new String[0]);
    if (paramInt == 9) {
      ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).reportPAShareItemEvent(1003, (String)localObject, 100);
    } else {
      ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).reportPAShareItemEvent(1004, (String)localObject, 100);
    }
    WXShareHelper localWXShareHelper = WXShareHelper.a();
    Intrinsics.checkExpressionValueIsNotNull(localWXShareHelper, "WXShareHelper.getInstance()");
    int m;
    if (!localWXShareHelper.b())
    {
      m = 2131918154;
    }
    else
    {
      localWXShareHelper = WXShareHelper.a();
      Intrinsics.checkExpressionValueIsNotNull(localWXShareHelper, "WXShareHelper.getInstance()");
      if (!localWXShareHelper.c()) {
        m = 2131918155;
      } else {
        m = -1;
      }
    }
    if (m != -1)
    {
      QRUtils.a(0, m);
      return;
    }
    if (paramInt == 9)
    {
      Intrinsics.checkExpressionValueIsNotNull(localObject, "url");
      a((String)localObject, "", (String)localObject, "");
      return;
    }
    f();
  }
  
  public final void a(int paramInt1, int paramInt2, @NotNull String paramString1, @NotNull String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "uin");
    Intrinsics.checkParameterIsNotNull(paramString2, "nickname");
    if ((paramInt1 == 72) && (!TextUtils.isEmpty((CharSequence)this.d))) {
      a(paramInt2, paramString1, paramString2);
    }
    i();
  }
  
  public final void a(@Nullable String paramString)
  {
    this.b = paramString;
  }
  
  public final void b()
  {
    if (!TextUtils.isEmpty((CharSequence)this.b)) {
      b(2);
    } else if (!TextUtils.isEmpty((CharSequence)this.e)) {
      c();
    } else {
      e();
    }
    ReportCenter.a().a("", "", "", "1000", "102", "0", false);
    ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "mp_msg_webview_44", "qzone_share", 0, 1, 0, "", "", "", "");
  }
  
  public final void b(@Nullable String paramString)
  {
    this.c = paramString;
  }
  
  public final void c(@Nullable String paramString)
  {
    this.d = paramString;
  }
  
  public final void d(@Nullable String paramString)
  {
    this.e = paramString;
  }
  
  public final void e(@Nullable String paramString)
  {
    this.f = paramString;
  }
  
  public final void f(@Nullable String paramString)
  {
    this.g = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.share.WebShare
 * JD-Core Version:    0.7.0.1
 */