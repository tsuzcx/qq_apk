package com.tencent.mobileqq.webview.swift.component;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.ClipboardManager;
import android.text.Html;
import android.text.TextUtils;
import com.tencent.biz.common.util.Util;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.pubaccount.accountdetail.api.IPublicAccountDetailActivity;
import com.tencent.biz.pubaccount.api.IPublicAccountJavascriptInterface.ActionItem;
import com.tencent.biz.pubaccount.api.IPublicAccountProxy;
import com.tencent.biz.pubaccount.util.api.IPublicAccountH5AbilityPlugin;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.biz.qrcode.util.QRUtils;
import com.tencent.biz.troop.TroopMemberApiClient;
import com.tencent.biz.webviewplugin.Share;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.Doraemon.util.DoraemonUtil;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.TeamWorkDocEditBrowserActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.addfriend.api.IAddFriendApi;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.browser.BrowserDialogViewModel;
import com.tencent.mobileqq.filemanager.fileassistant.util.QFileAssistantUtils;
import com.tencent.mobileqq.kandian.base.view.api.IFontSizePanel;
import com.tencent.mobileqq.kandian.base.view.api.IFontSizePanelBuilder;
import com.tencent.mobileqq.kandian.base.view.api.IFontSizePanelBuilderFactory;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.common.api.IReadInJoyHelper;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.teamwork.SharePolicyInfo;
import com.tencent.mobileqq.teamwork.TeamWorkConvertUtils;
import com.tencent.mobileqq.util.ScreenShotUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.webview.swift.SwiftBrowserUIStyle;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.WebViewUIUtils;
import com.tencent.mobileqq.webview.util.IWebColorNoteInject;
import com.tencent.mobileqq.webviewplugin.WebUiUtils.WebShareReportInterface;
import com.tencent.mobileqq.webviewplugin.WebUiUtils.WebTitleBarInterface;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.mobileqq.widget.share.ShareActionSheet.OnItemClickListener;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.open.agent.report.ReportCenter;
import com.tencent.open.base.MD5Utils;
import com.tencent.qidian.QidianManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.stat.MttLoader;
import com.tencent.widget.RangeButtonView.OnChangeListener;
import com.tencent.widget.ThemeImageWrapper;
import cooperation.qqfav.QfavHelper;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mqq.app.AppRuntime;
import org.json.JSONException;
import org.json.JSONObject;

public class SwiftBrowserShareMenuHandler
  extends SwiftBrowserComponentsProvider.SwiftBrowserComponent
  implements DialogInterface.OnDismissListener, WebUiUtils.WebShareReportInterface, ShareActionSheet.OnItemClickListener, RangeButtonView.OnChangeListener
{
  public static final int[] c = { 95, 100, 107, 115, 127 };
  public static long x = -1L;
  public ArrayList<IPublicAccountJavascriptInterface.ActionItem> A = null;
  protected Bundle B;
  public String C = "general_url";
  private String D;
  private int E;
  private int F;
  private IFontSizePanel G = null;
  private int H;
  private boolean I = false;
  private boolean J = false;
  private boolean K = false;
  private boolean L = false;
  private SwiftBrowserShareMenuHandler.ShareToFriendCallback M = null;
  private boolean N = true;
  private boolean O = true;
  private boolean P = false;
  private long Q = -1L;
  private long R = -1L;
  private int a;
  public Activity d;
  public WebViewFragment e;
  public Share f;
  public boolean g;
  public ShareActionSheetBuilder h;
  public final ArrayList<String> i = new ArrayList();
  public long j = 4L;
  public boolean k = true;
  public boolean l = false;
  public int m = 0;
  public String n = "";
  public String o = "";
  public String p = "";
  public String q = "";
  public String r;
  public String s;
  public String t;
  TroopMemberApiClient u = null;
  boolean v = false;
  public int w = 1;
  public boolean y = false;
  public boolean z = false;
  
  private void a(int paramInt, String paramString)
  {
    DialogUtil.a(this.d, c(paramInt), 2131888773, 2131918066, new SwiftBrowserShareMenuHandler.4(this, paramInt, paramString), new SwiftBrowserShareMenuHandler.5(this, paramInt, paramString)).show();
  }
  
  private void a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    JSONObject localJSONObject;
    if (!TextUtils.isEmpty(this.f.S)) {
      this.f.b(paramString1, 3, true);
    } else if (!TextUtils.isEmpty(this.f.X)) {
      this.f.s();
    } else if (this.f.T != null) {
      localJSONObject = new JSONObject();
    }
    try
    {
      localJSONObject.put("type", 2);
      label77:
      DoraemonUtil.b(this.f.T, localJSONObject);
      this.f.a(paramString1, 3, true);
      ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "mp_msg_webview_40", "weixin_share", 0, 1, 0, "", "", "", "");
      if ((paramString2 != null) && (!"".equals(paramString2)))
      {
        paramString1 = ((IPublicAccountDetailActivity)QRoute.api(IPublicAccountDetailActivity.class)).getArticleId(paramString3);
        ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005B07", "0X8005B07", 1003, 0, paramString2, paramString4, paramString3, paramString1, false);
      }
      ReportCenter.a().a("", "", "", "1000", "103", "0", false);
      return;
    }
    catch (JSONException localJSONException)
    {
      break label77;
    }
  }
  
  private void b()
  {
    Object localObject = this.d.getIntent();
    WebViewFragment localWebViewFragment = this.e;
    if (localWebViewFragment != null) {
      localObject = localWebViewFragment.getIntent();
    }
    this.D = ((Intent)localObject).getStringExtra("url");
    if (this.D == null)
    {
      this.D = ((Intent)localObject).getStringExtra("key_params_qq");
      if (this.D == null) {
        this.D = "";
      }
    }
    localObject = ((Intent)localObject).getExtras();
    if (localObject != null)
    {
      this.m = ((Bundle)localObject).getInt("uin_type");
      this.n = ((Bundle)localObject).getString("puin");
      this.o = ((Bundle)localObject).getString("msg_id");
      if (this.o == null) {
        this.o = "";
      }
      this.p = ((Bundle)localObject).getString("source_puin");
      if (this.p == null) {
        this.p = "";
      }
      this.q = ((Bundle)localObject).getString("friendUin");
      if (this.q == null) {
        this.q = "";
      }
      this.E = ((Bundle)localObject).getInt("appid");
      this.F = ((Bundle)localObject).getInt("troopid");
      this.P = ((Bundle)localObject).getBoolean("fromFav");
      if (this.P)
      {
        this.Q = ((Bundle)localObject).getLong("favID");
        this.R = ((Bundle)localObject).getLong("favGroupID");
      }
      this.H = ((Bundle)localObject).getInt("articalChannelId", 100);
    }
  }
  
  private void b(int paramInt, String paramString)
  {
    if (paramInt == 1)
    {
      c(paramString);
      return;
    }
    if (paramInt == 3)
    {
      f(paramString);
      return;
    }
    if (paramInt == 10)
    {
      e(paramString);
      return;
    }
    if (paramInt == 12) {
      d(paramString);
    }
  }
  
  private String c(int paramInt)
  {
    if (paramInt == 1)
    {
      localWebViewFragment = this.e;
      return localWebViewFragment.getString(2131917104, new Object[] { localWebViewFragment.getString(2131888243) });
    }
    if (paramInt == 3)
    {
      localWebViewFragment = this.e;
      return localWebViewFragment.getString(2131917104, new Object[] { localWebViewFragment.getString(2131916572) });
    }
    if (paramInt == 10)
    {
      localWebViewFragment = this.e;
      return localWebViewFragment.getString(2131917104, new Object[] { localWebViewFragment.getString(2131916568) });
    }
    if (paramInt == 12)
    {
      localWebViewFragment = this.e;
      return localWebViewFragment.getString(2131917104, new Object[] { localWebViewFragment.getString(2131894189) });
    }
    WebViewFragment localWebViewFragment = this.e;
    return localWebViewFragment.getString(2131917104, new Object[] { localWebViewFragment.getString(2131917740) });
  }
  
  private void c(String paramString)
  {
    ((ClipboardManager)this.d.getSystemService("clipboard")).setText(paramString);
    QRUtils.a(2, 2131888247);
    if ((this.K) && (!TextUtils.isEmpty(this.f.S))) {
      this.f.o();
    }
  }
  
  private void d(String paramString)
  {
    if (!TextUtils.isEmpty(this.f.S)) {
      this.f.b(paramString, 8, false);
    } else {
      this.f.a(paramString, 8, false);
    }
    String str = this.D;
    if (this.b.a() != null) {
      str = this.b.a().getUrl();
    }
    paramString = Uri.parse(str);
    try
    {
      paramString = paramString.getQueryParameter("article_id");
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
      paramString = "";
    }
    if (paramString == null) {
      paramString = "";
    }
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X800787A", "0X800787A", 0, 0, paramString, str, "", "");
    ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).reportPAShareItemEvent(1005, str, this.H);
  }
  
  private void e(String paramString)
  {
    JSONObject localJSONObject;
    if (!TextUtils.isEmpty(this.f.S)) {
      this.f.b(paramString, 4, true);
    } else if (!TextUtils.isEmpty(this.f.Y)) {
      this.f.t();
    } else if (this.f.T != null) {
      localJSONObject = new JSONObject();
    }
    try
    {
      localJSONObject.put("type", 3);
      label75:
      DoraemonUtil.b(this.f.T, localJSONObject);
      this.f.a(paramString, 4, true);
      ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "mp_msg_webview_42", "pengyouquan_share", 0, 1, 0, "", "", "", "");
      ReportCenter.a().a("", "", "", "1000", "104", "0", false);
      return;
    }
    catch (JSONException localJSONException)
    {
      break label75;
    }
  }
  
  private void f(String paramString)
  {
    if (!TextUtils.isEmpty(this.f.S)) {
      this.f.b(paramString, 2, false);
    } else if (!TextUtils.isEmpty(this.f.W)) {
      this.f.r();
    } else if (this.f.T != null) {
      paramString = new JSONObject();
    }
    try
    {
      paramString.put("type", 1);
      label75:
      DoraemonUtil.b(this.f.T, paramString);
      this.f.c();
      ReportCenter.a().a("", "", "", "1000", "102", "0", false);
      ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "mp_msg_webview_44", "qzone_share", 0, 1, 0, "", "", "", "");
      return;
    }
    catch (JSONException localJSONException)
    {
      break label75;
    }
  }
  
  private Intent o()
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("forward_type", 1001);
    localIntent.putExtra("pluginName", "web_share");
    return localIntent;
  }
  
  private void p()
  {
    if (b(this.f.getShareUrl()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("SwiftBrowserShareMenuHandler", 2, "is not need load share js..");
      }
    }
    else
    {
      if (QLog.isColorLevel()) {
        QLog.d("SwiftBrowserShareMenuHandler", 2, "loadShareJs");
      }
      a(System.currentTimeMillis());
      int i2 = com.tencent.mobileqq.webprocess.WebAccelerateHelper.getInstance().getWebViewFeatureParams()[2].intValue();
      int i1 = i2;
      if (i2 < 0) {
        i1 = 190;
      }
      String str = String.format("function callShare(){\"loading\"==document.readyState?window.addEventListener(\"load\",sharePageInfo(),!1):sharePageInfo()}var readStyleProp=function(a,b){var c,d;return b?(b=b.toLowerCase(),a.style&&a.style[b]?c=a.style[b]:a.currentStyle?(b=b.replace(/\\-([a-z])([a-z]?)/gi,function(a,b,c){return b.toUpperCase()+c.toLowerCase()}),c=a.currentStyle[b]):document.defaultView&&document.defaultView.getComputedStyle&&(d=document.defaultView.getComputedStyle(a,null),c=d.getPropertyValue(b)),-1!=c.indexOf(\"px\")&&(c=c.replace(/(px)/i,\"\")),c):void 0},parsePageInfo=function(){var b,c,d,e,f,g,h,i,j,k,l,a={};for(a[\"shareURL\"]=document.documentURI,b=\"\",c=\"\",d=document.getElementsByTagName(\"meta\"),f=0;f<d.length;f++)e=d[f],!a.title&&e.getAttribute(\"itemprop\")&&\"name\"==e.getAttribute(\"itemprop\").toLowerCase()&&void 0!=e.content&&\"\"!=e.content&&(a[\"title\"]=e.content),a.summary||\"description\"!=e.name||void 0!=e.content&&\"\"!=e.content&&(b=e.content),!a.summary&&e.getAttribute(\"itemprop\")&&\"description\"==e.getAttribute(\"itemprop\").toLowerCase()&&void 0!=e.content&&\"\"!=e.content&&(c=e.content),!a.image&&e.getAttribute(\"itemprop\")&&\"image\"==e.getAttribute(\"itemprop\").toLowerCase()&&void 0!=e.content&&\"\"!=e.content&&(a[\"image\"]=e.content);if(\"\"!=c?a[\"summary\"]=c:\"\"!=b&&(a[\"summary\"]=b),!a.image)for(g=document.getElementsByTagName(\"img\"),h=%d,i=%d,f=0;f<g.length&&30>f;f++)if(j=g[f],(j.src.startsWith(\"//\")||j.src.startsWith(\"http://\")||j.src.startsWith(\"https://\"))&&(k=j.width,l=j.height,void 0!=j.naturalWidth&&void 0!=j.naturalHeight&&(k=j.naturalWidth,l=j.naturalHeight),k>=h&&10*h>k&&l>=i&&10*i>l&&\"none\"!=readStyleProp(j,\"display\")&&\"hidden\"!=readStyleProp(j,\"visibility\"))){a[\"image\"]=j.src,a.image.startsWith(\"//\")&&(a.image=(document.documentURI.startsWith(\"http:\")?\"http:\":\"https:\")+a.image);break}return a},sharePageInfo=function(){var a,c,d,e;try{a=parsePageInfo()}catch(b){}a||(a=new object),a[\"type\"]=\"share\",a[\"callback\"]=1,c=JSON.stringify(a),d=\"jsbridge://share/setShare?p=\"+encodeURIComponent(c),e=document.createElement(\"iframe\"),e.style.cssText=\"display:none;width:0px;height:0px;\",(document.documentElement||document.body).appendChild(e),e.src=d};callShare();", new Object[] { Integer.valueOf(i1), Integer.valueOf(i1) });
      if (this.b.a() != null)
      {
        WebView localWebView = this.b.a();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("javascript:");
        localStringBuilder.append(str);
        localStringBuilder.append(";");
        localWebView.loadUrl(localStringBuilder.toString());
      }
    }
  }
  
  public void a()
  {
    super.a();
    this.v = false;
    this.d = this.b.b();
    this.e = ((WebViewFragment)this.b.c());
    b();
  }
  
  public void a(int paramInt)
  {
    String str2 = g();
    if (str2 == null) {
      str2 = this.D;
    }
    Object localObject = Uri.parse(str2);
    if ((!"article.mp.qq.com".equalsIgnoreCase(((Uri)localObject).getHost())) && (!"post.mp.qq.com".equalsIgnoreCase(((Uri)localObject).getHost()))) {
      return;
    }
    String str1;
    try
    {
      localObject = ((Uri)localObject).getQueryParameter("article_id");
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      str1 = "";
    }
    if (str1 == null) {
      str1 = "";
    }
    if (paramInt != 21)
    {
      switch (paramInt)
      {
      default: 
        return;
      case 12: 
        ReportController.b(null, "dc01160", "Pb_account_lifeservice", "", "0X8007C04", "0X8007C04", 0, 1, 0, str1, str2, "1012", "");
        return;
      case 11: 
        ReportController.b(null, "dc01160", "Pb_account_lifeservice", "", "0X8007C04", "0X8007C04", 0, 1, 0, str1, str2, "1008", "");
        return;
      case 10: 
        ReportController.b(null, "dc01160", "Pb_account_lifeservice", "", "0X8007C04", "0X8007C04", 0, 1, 0, str1, str2, "1004", "");
        return;
      case 9: 
        ReportController.b(null, "dc01160", "Pb_account_lifeservice", "", "0X8007C04", "0X8007C04", 0, 1, 0, str1, str2, "1003", "");
        return;
      case 8: 
        ReportController.b(null, "dc01160", "Pb_account_lifeservice", "", "0X8007C04", "0X8007C04", 0, 1, 0, str1, str2, "1009", "");
        return;
      case 7: 
        ReportController.b(null, "dc01160", "Pb_account_lifeservice", "", "0X8007C04", "0X8007C04", 0, 1, 0, str1, str2, "1010", "");
        return;
      case 6: 
        ReportController.b(null, "dc01160", "Pb_account_lifeservice", "", "0X8007C04", "0X8007C04", 0, 1, 0, str1, str2, "1007", "");
        return;
      case 5: 
        ReportController.b(null, "dc01160", "Pb_account_lifeservice", "", "0X8007C04", "0X8007C04", 0, 1, 0, str1, str2, "1005", "");
        return;
      case 4: 
        ReportController.b(null, "dc01160", "Pb_account_lifeservice", "", "0X8007C04", "0X8007C04", 0, 1, 0, str1, str2, "1006", "");
        return;
      case 3: 
        ReportController.b(null, "dc01160", "Pb_account_lifeservice", "", "0X8007C04", "0X8007C04", 0, 1, 0, str1, str2, "1002", "");
        return;
      case 2: 
        ReportController.b(null, "dc01160", "Pb_account_lifeservice", "", "0X8007C04", "0X8007C04", 0, 1, 0, str1, str2, "1001", "");
        return;
      }
      ReportController.b(null, "dc01160", "Pb_account_lifeservice", "", "0X8007C04", "0X8007C04", 0, 1, 0, str1, str2, "1011", "");
      return;
    }
    ReportController.b(null, "dc01160", "Pb_account_lifeservice", "", "0X8007C04", "0X8007C04", 0, 1, 0, str1, str2, "1013", "");
  }
  
  public void a(int paramInt, Bundle paramBundle)
  {
    super.a(paramInt, paramBundle);
    if (paramInt != 2)
    {
      if (paramInt != 3)
      {
        if (paramInt != 4)
        {
          if (paramInt != 9) {
            return;
          }
          a(paramBundle.getString("url", ""));
          return;
        }
        paramBundle = this.h;
        if (paramBundle != null) {
          paramBundle.onConfigurationChanged();
        }
        paramBundle = this.G;
        if ((paramBundle != null) && (paramBundle.b()))
        {
          this.G.c();
          h();
        }
      }
      else
      {
        this.v = true;
        paramBundle = this.G;
        if (paramBundle != null) {
          paramBundle.a();
        }
        paramBundle = this.u;
        if (paramBundle != null)
        {
          paramBundle.a(this.a);
          this.u.f();
        }
        this.i.clear();
      }
    }
    else if ((paramBundle != null) && (paramBundle.getInt("state_machine_step", -1) == 1)) {
      i();
    }
  }
  
  public void a(int paramInt, ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem)
  {
    String str = g();
    Bundle localBundle = new Bundle();
    WebViewFragment localWebViewFragment = this.e;
    if (localWebViewFragment != null)
    {
      localBundle.putString("qq", localWebViewFragment.getUin());
      localBundle.putString("public_uin", this.n);
      localBundle.putString("source_public_uin", this.p);
      localBundle.putString("default_url", this.e.getUrl());
      localBundle.putString("msg_id", this.o);
      localBundle.putString("troop_app_info_url", this.t);
      localBundle.putString("troop_app_share_url", this.s);
      localBundle.putInt("troop_id", this.F);
      localBundle.putInt("troop_app_id", this.E);
      localBundle.putInt("uin_type", this.m);
    }
    if ((paramInt == 72) && (paramActionSheetItem != null))
    {
      localBundle.putString("to_qq", paramActionSheetItem.uin);
      localBundle.putString("to_uin_name", paramActionSheetItem.label);
      localBundle.putInt("to_uin_type", paramActionSheetItem.uinType);
    }
    a(paramInt, str, localBundle);
  }
  
  @TargetApi(12)
  public void a(int paramInt, String paramString, Bundle paramBundle)
  {
    int i1 = paramInt;
    String str1 = "";
    Object localObject6;
    Object localObject7;
    Object localObject3;
    Object localObject4;
    Object localObject5;
    int i2;
    Object localObject10;
    int i3;
    Object localObject8;
    Object localObject9;
    Object localObject11;
    if (paramBundle != null)
    {
      localObject6 = paramBundle.getString("qq", "");
      localObject7 = paramBundle.getString("public_uin", "");
      localObject3 = paramBundle.getString("source_public_uin", "");
      localObject4 = paramBundle.getString("default_url", "");
      localObject5 = paramBundle.getString("msg_id", "");
      paramInt = paramBundle.getInt("troop_app_id", 0);
      i2 = paramBundle.getInt("troop_id", 0);
      localObject10 = paramBundle.getString("troop_app_info_url", "");
      paramBundle.getInt("uin_type", 0);
      i3 = paramBundle.getInt("to_uin_type", 0);
      localObject8 = paramBundle.getString("to_qq", "");
      localObject9 = paramBundle.getString("to_uin_name", "");
      this.B = paramBundle;
    }
    else
    {
      localObject11 = "";
      localObject1 = localObject11;
      localObject2 = localObject1;
      localObject3 = localObject2;
      localObject4 = localObject3;
      localObject5 = localObject4;
      localObject6 = localObject5;
      localObject9 = localObject6;
      paramInt = 0;
      i2 = 0;
      i3 = 0;
      localObject8 = localObject6;
      localObject10 = localObject5;
      localObject5 = localObject4;
      localObject4 = localObject3;
      localObject3 = localObject2;
      localObject7 = localObject1;
      localObject6 = localObject11;
    }
    Object localObject1 = this.D;
    Object localObject2 = this.e;
    if (localObject2 != null)
    {
      localObject2 = ((WebViewFragment)localObject2).getRedirect302Url();
      localObject11 = this.e.getWebView();
      localObject1 = localObject2;
      if (localObject11 != null)
      {
        localObject11 = ((WebView)localObject11).getOriginalUrl();
        localObject1 = localObject2;
        localObject2 = localObject11;
        break label276;
      }
    }
    localObject2 = null;
    label276:
    if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (!((String)localObject2).equals(paramString))) {}
    try
    {
      localObject11 = Uri.parse((String)localObject2);
    }
    catch (Exception localException1)
    {
      String str2;
      boolean bool;
      label385:
      break label385;
    }
    for (;;)
    {
      try
      {
        str2 = ((Uri)localObject11).getHost();
        bool = ((Uri)localObject11).isHierarchical();
        if (!bool) {
          continue;
        }
      }
      catch (Exception localException2)
      {
        break label385;
        Object localObject12 = null;
        break;
      }
      try
      {
        localObject11 = ((Uri)localObject11).getQueryParameter("_pflag");
        if ((!TextUtils.isEmpty((CharSequence)localObject11)) && (("post.mp.qq.com".equalsIgnoreCase(str2)) || ("url.cn".equalsIgnoreCase(str2))))
        {
          int i4 = Integer.parseInt((String)localObject11);
          if ((i4 >> 3 & 0x1) == 1) {
            paramString = (String)localObject2;
          }
        }
      }
      catch (Exception localException3)
      {
        break label385;
      }
    }
    if (i1 == 1)
    {
      if ((this.f.a() != null) && (this.f.a().c == 0))
      {
        a(i1, paramString);
        paramInt = i1;
      }
      else
      {
        c(paramString);
        paramInt = i1;
      }
    }
    else if (i1 == 11) {
      bool = Pattern.compile("(http|https)://.*.mp.qq.com.*").matcher(paramString).matches();
    }
    try
    {
      paramString = URLEncoder.encode(paramString, "UTF-8");
    }
    catch (UnsupportedEncodingException paramString)
    {
      label471:
      long l1;
      long l2;
      break label471;
    }
    if (QLog.isColorLevel()) {
      QLog.d("SwiftBrowserShareMenuHandler", 2, "encode shareUrl failed, because UTF-8 is unknown");
    }
    paramString = null;
    if (bool)
    {
      localObject2 = String.valueOf(NetConnInfoCenter.getServerTime());
      paramBundle = new StringBuilder();
      paramBundle.append(paramString);
      paramBundle.append(200);
      paramBundle.append((String)localObject2);
      paramBundle.append("jubao@article@123");
      localObject1 = MD5Utils.encodeHexStr(paramBundle.toString());
      paramBundle = (Bundle)localObject1;
      if (localObject1 != null)
      {
        paramBundle = (Bundle)localObject1;
        if (!((String)localObject1).isEmpty()) {
          paramBundle = ((String)localObject1).toLowerCase();
        }
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("https://post.mp.qq.com/jubao/index?qq=");
      ((StringBuilder)localObject1).append((String)localObject6);
      ((StringBuilder)localObject1).append("&mp_uin=");
      ((StringBuilder)localObject1).append((String)localObject7);
      ((StringBuilder)localObject1).append("&scene=200&sub_appname=article_webview&timestamp=");
      ((StringBuilder)localObject1).append((String)localObject2);
      ((StringBuilder)localObject1).append("&sign=");
      ((StringBuilder)localObject1).append(paramBundle);
      ((StringBuilder)localObject1).append("&article_url=");
      ((StringBuilder)localObject1).append(paramString);
      ((StringBuilder)localObject1).append("&_wv=3");
      paramString = ((StringBuilder)localObject1).toString();
    }
    else
    {
      paramBundle = new StringBuilder();
      paramBundle.append("https://guanjia.qq.com/online_server/m_report.html?shareUrl=");
      paramBundle.append(paramString);
      paramBundle.append("&qq=");
      paramBundle.append((String)localObject6);
      paramBundle.append("&_wv=7");
      paramString = paramBundle.toString();
    }
    paramBundle = new Intent(this.d, QQBrowserActivity.class);
    paramBundle.putExtra("url", paramString);
    paramBundle.putExtra("hide_more_button", true);
    this.d.startActivity(paramBundle);
    ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "mp_msg_webview_67", "jvbao_click", 0, 1, 0, "", "", "", "");
    paramInt = i1;
    if (localObject3 != null)
    {
      paramInt = i1;
      if (!"".equals(localObject3))
      {
        paramString = ((IPublicAccountDetailActivity)QRoute.api(IPublicAccountDetailActivity.class)).getArticleId((String)localObject4);
        ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005B07", "0X8005B07", 1008, 0, (String)localObject3, (String)localObject5, (String)localObject4, paramString, false);
        paramInt = i1;
        break label4243;
        if ((i1 != 2) && (i1 != 72) && (i1 != 73))
        {
          if (i1 == 26)
          {
            paramBundle.putString("to_qq", "3636666661");
            paramBundle.putString("to_uin_name", this.e.getString(2131896189));
            a(72, paramString, paramBundle);
            paramInt = 72;
          }
          else if (i1 == 4)
          {
            BrowserDialogViewModel.a(this.d, paramString, (String)localObject6);
            paramInt = i1;
          }
          else if (i1 == 5)
          {
            if ((this.e != null) && (this.d != null))
            {
              if (!TextUtils.isEmpty(paramString))
              {
                paramBundle = new HashMap();
                paramBundle.put("KEY_PID", String.valueOf(50079));
                paramBundle.put("KEY_EUSESTAT", String.valueOf(5));
                paramBundle.put("ChannelID", BaseApplicationImpl.getContext().getApplicationInfo().processName);
                paramBundle.put("PosID", Integer.toString(0));
                paramString = MttLoader.getValidQBUrl(BaseApplicationImpl.getContext(), paramString);
                paramInt = MttLoader.loadUrl(BaseApplicationImpl.getContext(), paramString, paramBundle, null);
                if ((4 == paramInt) || (5 == paramInt) || (paramInt != 0))
                {
                  paramString = new Intent();
                  paramString.putExtra("url", "https://upage.imtt.qq.com/m_imtt/qq_download_middle_page/real/qq_download_middle_page.html");
                  RouteUtils.a(this.d, paramString, "/base/browser");
                }
              }
              ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "mp_msg_webview_46", "qqbrowser_share", 0, 1, 0, "", "", "", "");
              ReportController.b(null, "P_CliOper", "VIPCOMIC", "", "0X80061A0", "0X80061A0", 1000, 0, Util.b((String)localObject4, new String[0]), null, null, null);
              paramInt = i1;
              if (localObject3 != null)
              {
                paramInt = i1;
                if (!"".equals(localObject3))
                {
                  paramString = ((IPublicAccountDetailActivity)QRoute.api(IPublicAccountDetailActivity.class)).getArticleId((String)localObject4);
                  ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005B07", "0X8005B07", 1005, 0, (String)localObject3, (String)localObject5, (String)localObject4, paramString, false);
                  paramInt = i1;
                }
              }
            }
            else
            {
              throw new InvalidParameterException("ACTION_OPEN_IN_QQ_BROWSER should be handled by QQBrowserActivity!");
            }
          }
          else if (i1 == 3)
          {
            x = System.currentTimeMillis();
            paramBundle = (Bundle)localObject1;
            if (TextUtils.isEmpty((CharSequence)localObject1)) {
              paramBundle = (Bundle)localObject2;
            }
            ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).reportPAShareItemEvent(1002, paramBundle, this.H);
            if ((this.f.a() != null) && (this.f.a().c == 0))
            {
              a(i1, paramString);
              paramInt = i1;
            }
            else
            {
              f(paramString);
              paramInt = i1;
            }
          }
          else if (i1 == 6)
          {
            if (this.f.setShareUrl(paramString)) {
              this.f.a(paramString, 9, false);
            }
            paramInt = i1;
            if (localObject3 != null)
            {
              paramInt = i1;
              if (!"".equals(localObject3))
              {
                paramString = ((IPublicAccountDetailActivity)QRoute.api(IPublicAccountDetailActivity.class)).getArticleId((String)localObject4);
                ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005B07", "0X8005B07", 1007, 0, (String)localObject3, (String)localObject5, (String)localObject4, paramString, false);
                paramInt = i1;
              }
            }
          }
          else if (i1 == 129)
          {
            QfavHelper.a(this.d, this.e.getAppRuntime().getCurrentAccountUin(), this.Q, this.R);
            paramInt = i1;
          }
          else if ((i1 != 9) && (i1 != 10))
          {
            if (i1 == 13)
            {
              this.f.a(paramString, 5, true);
              paramInt = i1;
            }
            else if (i1 == 15)
            {
              if (this.e != null)
              {
                if (!NetworkUtil.isNetSupport(BaseApplicationImpl.getContext()))
                {
                  QQToast.makeText(BaseApplicationImpl.getContext(), 2, 2131917368, 0).show(this.e.getWebTitleBarInterface().m());
                  return;
                }
                j().a(paramInt, new SwiftBrowserShareMenuHandler.2(this));
                paramString = new StringBuilder();
                paramString.append("");
                paramString.append(i2);
                paramString = paramString.toString();
                paramBundle = new StringBuilder();
                paramBundle.append("");
                paramBundle.append(paramInt);
                ReportController.b(null, "P_CliOper", "Grp_open", "", "third_app", "add_menu", 0, 1, 0, paramString, paramBundle.toString(), "", "");
                paramInt = i1;
              }
              else
              {
                throw new InvalidParameterException("ACTION_ADD_TROOP_APP should be handled by QQBrowserActivity!");
              }
            }
            else if (i1 == 16)
            {
              paramString = new Intent(this.d, QQBrowserActivity.class);
              paramString.putExtra("url", (String)localObject10);
              paramString.putExtra("hide_operation_bar", true);
              paramString.putExtra("hide_more_button", true);
              this.d.startActivity(paramString);
              paramString = new StringBuilder();
              paramString.append("");
              paramString.append(i2);
              paramString = paramString.toString();
              paramBundle = new StringBuilder();
              paramBundle.append("");
              paramBundle.append(paramInt);
              ReportController.b(null, "P_CliOper", "Grp_open", "", "third_app", "detail_menu", 0, 1, 0, paramString, paramBundle.toString(), "", "");
              paramInt = i1;
            }
            else if (i1 == 17)
            {
              if (paramBundle != null) {
                paramString = paramBundle.getString("troop_app_share_url", "");
              } else {
                paramString = "";
              }
              paramBundle = new Intent(this.d, QQBrowserActivity.class);
              paramBundle.putExtra("url", paramString);
              paramBundle.putExtra("hide_operation_bar", true);
              paramBundle.putExtra("hide_more_button", true);
              this.d.startActivity(paramBundle);
              paramString = new StringBuilder();
              paramString.append("");
              paramString.append(i2);
              paramString = paramString.toString();
              paramBundle = new StringBuilder();
              paramBundle.append("");
              paramBundle.append(paramInt);
              ReportController.b(null, "P_CliOper", "Grp_open", "", "third_app", "share_menu", 0, 1, 0, paramString, paramBundle.toString(), "", "");
              paramInt = i1;
            }
            else if (i1 == 18)
            {
              if (this.e != null)
              {
                paramString = (SwiftBrowserStatistics)this.b.d().a(-2);
                if ((!TextUtils.isEmpty(this.e.getWebView().getUrl())) && (paramString != null))
                {
                  paramString.aq = false;
                  paramString.u = System.currentTimeMillis();
                  this.e.getWebView().reload();
                  this.e.getWebView().setOnCustomScrollChangeListener(null);
                  paramString.a(this.e.getWebView(), this.e.getWebView().getUrl(), 1, 0, 0, 0, 0, null);
                }
                else
                {
                  paramBundle = this.e.getCurrentUrl();
                  if ((!TextUtils.isEmpty(paramBundle)) && (paramString != null))
                  {
                    paramString.aq = false;
                    paramString.u = System.currentTimeMillis();
                    this.e.getWebView().loadUrl(paramBundle);
                    paramString.a(this.e.getWebView(), paramBundle, 1, 0, 0, 0, 0, null);
                  }
                }
                paramString = new StringBuilder();
                paramString.append("");
                paramString.append(i2);
                paramString = paramString.toString();
                paramBundle = new StringBuilder();
                paramBundle.append("");
                paramBundle.append(paramInt);
                ReportController.b(null, "P_CliOper", "Grp_open", "", "third_app", "refresh_menu", 0, 1, 0, paramString, paramBundle.toString(), "", "");
                paramInt = i1;
              }
              else
              {
                throw new InvalidParameterException("ACTION_REFRESH_TROOP_APP_VIEW should be handled by QQBrowserActivity!");
              }
            }
            else if (i1 == 7)
            {
              h();
              paramInt = i1;
            }
            else if ((i1 != 19) && (i1 != 20))
            {
              if (i1 == 21)
              {
                paramString = (SwiftBrowserScreenShotHandler)this.b.d().a(64);
                if (paramString != null) {
                  paramString.a(null, null, 2);
                }
                paramString = Uri.parse(this.D);
                try
                {
                  paramString = paramString.getQueryParameter("article_id");
                }
                catch (Exception paramString)
                {
                  paramString.printStackTrace();
                  paramString = "";
                }
                paramBundle = paramString;
                if (paramString == null) {
                  paramBundle = "";
                }
                ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X8007071", "0X8007071", 0, 0, paramBundle, "", "", "");
                ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).reportPAinfoToLighthouse("0X8007071", "", paramBundle, "", "", "");
                paramInt = i1;
              }
              else if (i1 == 12)
              {
                if ((this.f.a() != null) && (this.f.a().c == 0))
                {
                  a(i1, paramString);
                  paramInt = i1;
                }
                else
                {
                  d(paramString);
                  paramInt = i1;
                }
              }
              else if (i1 == 34)
              {
                if (!TextUtils.isEmpty(this.f.S))
                {
                  this.f.n();
                  paramInt = i1;
                }
                else
                {
                  paramInt = i1;
                  if (QLog.isColorLevel())
                  {
                    QLog.d("diandian", 2, "dian dian is here");
                    paramInt = i1;
                  }
                }
              }
              else
              {
                l1 = 0L;
                if (i1 == 35)
                {
                  paramString = this.A;
                  if (paramString != null)
                  {
                    paramString = paramString.iterator();
                    while (paramString.hasNext())
                    {
                      paramBundle = (IPublicAccountJavascriptInterface.ActionItem)paramString.next();
                      if (paramBundle.a == 3) {
                        try
                        {
                          paramString = new JSONObject(paramBundle.c);
                          l1 = paramString.getLong("uin");
                          paramString = paramString.optString("name");
                        }
                        catch (JSONException paramString)
                        {
                          paramString.printStackTrace();
                          return;
                        }
                      }
                    }
                  }
                  paramString = null;
                  paramBundle = (IAddFriendApi)QRoute.api(IAddFriendApi.class);
                  localObject1 = this.d;
                  localObject2 = new StringBuilder();
                  ((StringBuilder)localObject2).append(l1);
                  ((StringBuilder)localObject2).append("");
                  paramString = paramBundle.startAddFriend((Context)localObject1, 1, ((StringBuilder)localObject2).toString(), null, 3096, 1, paramString, null, null, null, null);
                  ((IAddFriendApi)QRoute.api(IAddFriendApi.class)).launchAddFriend(this.d, paramString);
                  ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X8008C0F", "0X8008C0F", 0, 0, "", "", "", "", false);
                  paramInt = i1;
                }
                else if (i1 == 30)
                {
                  paramString = this.A;
                  l2 = l1;
                  if (paramString != null)
                  {
                    l2 = l1;
                    if (this.y)
                    {
                      paramString = paramString.iterator();
                      do
                      {
                        l2 = l1;
                        if (!paramString.hasNext()) {
                          break;
                        }
                        paramBundle = (IPublicAccountJavascriptInterface.ActionItem)paramString.next();
                      } while (paramBundle.a != 1);
                      try
                      {
                        l2 = new JSONObject(paramBundle.c).getLong("uin");
                      }
                      catch (JSONException paramString)
                      {
                        paramString.printStackTrace();
                        return;
                      }
                    }
                  }
                  paramString = new Intent();
                  paramBundle = new Bundle();
                  paramString.setComponent(new ComponentName(this.d, ChatActivity.class));
                  paramBundle.putString("uin", String.valueOf(l2));
                  paramBundle.putInt("uintype", 1008);
                  paramString.putExtras(paramBundle);
                  paramString.putExtra("is_come_from_readinjoy", true);
                  paramString.setFlags(67108864);
                  this.d.startActivity(paramString);
                  ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X8008C3B", "0X8008C3B", 0, 0, "", "", "", "", false);
                  paramInt = i1;
                }
                else
                {
                  if ((i1 == 37) && (this.z))
                  {
                    paramString = this.A;
                    l2 = l1;
                    if (paramString != null)
                    {
                      paramString = paramString.iterator();
                      do
                      {
                        l2 = l1;
                        if (!paramString.hasNext()) {
                          break;
                        }
                        paramBundle = (IPublicAccountJavascriptInterface.ActionItem)paramString.next();
                      } while (paramBundle.a != 1);
                      try
                      {
                        l2 = new JSONObject(paramBundle.c).getLong("uin");
                      }
                      catch (JSONException paramString)
                      {
                        paramString.printStackTrace();
                        return;
                      }
                    }
                    paramString = AIOUtils.a(new Intent(this.d, SplashActivity.class), null);
                    paramBundle = new StringBuilder();
                    paramBundle.append(l2);
                    paramBundle.append("");
                    paramString.putExtra("uin", paramBundle.toString());
                    paramString.putExtra("uintype", 0);
                    this.d.startActivity(paramString);
                    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X8008C11", "0X8008C11", 0, 0, "", "", "", "", false);
                    return;
                  }
                  if (i1 == 31)
                  {
                    paramString = this.A;
                    l2 = l1;
                    if (paramString != null)
                    {
                      paramString = paramString.iterator();
                      do
                      {
                        l2 = l1;
                        if (!paramString.hasNext()) {
                          break;
                        }
                        paramBundle = (IPublicAccountJavascriptInterface.ActionItem)paramString.next();
                      } while (paramBundle.a != 2);
                      try
                      {
                        l2 = new JSONObject(paramBundle.c).getLong("puin");
                      }
                      catch (JSONException paramString)
                      {
                        paramString.printStackTrace();
                        return;
                      }
                    }
                    paramString = new ActivityURIRequest(this.d, "/pubaccount/detail");
                    paramBundle = paramString.extra();
                    localObject1 = new StringBuilder();
                    ((StringBuilder)localObject1).append(l2);
                    ((StringBuilder)localObject1).append("");
                    paramBundle.putString("uin", ((StringBuilder)localObject1).toString());
                    paramString.extra().putBoolean("from_js", true);
                    QRoute.startUri(paramString, null);
                    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X8008C47", "0X8008C47", 0, 0, "", "", "", "", false);
                    paramInt = i1;
                  }
                  else if (i1 == 38)
                  {
                    this.f.p();
                    paramInt = i1;
                  }
                  else if (i1 == 68)
                  {
                    TeamWorkConvertUtils.a(1, ((IPublicAccountProxy)QRoute.api(IPublicAccountProxy.class)).isPublicAccountBrowser(this.d) ^ true);
                    paramBundle = g();
                    paramString = paramBundle;
                    if (paramBundle == null) {
                      paramString = this.D;
                    }
                    paramBundle = this.f;
                    if (paramBundle == null) {
                      paramBundle = str1;
                    } else {
                      paramBundle = paramBundle.d();
                    }
                    TeamWorkConvertUtils.a(paramString, paramBundle);
                    paramInt = i1;
                  }
                  else if (i1 == 70)
                  {
                    paramString = ((QQBrowserActivity)this.d).getWebColorNoteInjector();
                    paramInt = i1;
                    if (paramString != null)
                    {
                      paramString.a();
                      paramInt = i1;
                    }
                  }
                  else
                  {
                    paramInt = i1;
                    if (i1 == 71)
                    {
                      ReportController.b(null, "dc00898", "", "", "0X800A9A4", "0X800A9A4", 0, 0, "1", "", "", "");
                      ScreenShotUtil.b(this.b.a(), new SwiftBrowserShareMenuHandler.3(this));
                      paramInt = i1;
                    }
                  }
                }
              }
            }
            else
            {
              if (i1 == 19) {
                paramInt = 6;
              } else {
                paramInt = 7;
              }
              if (!TextUtils.isEmpty(this.f.S))
              {
                this.f.b(paramString, paramInt, false);
                paramInt = i1;
              }
              else
              {
                this.f.a(paramString, paramInt, true);
                paramInt = i1;
              }
            }
          }
          else
          {
            paramInt = -1;
            paramBundle = (Bundle)localObject1;
            if (TextUtils.isEmpty((CharSequence)localObject1)) {
              paramBundle = (Bundle)localObject2;
            }
            if (i1 == 9) {
              ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).reportPAShareItemEvent(1003, paramBundle, this.H);
            } else {
              ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).reportPAShareItemEvent(1004, paramBundle, this.H);
            }
            if (!WXShareHelper.a().b()) {
              paramInt = 2131918154;
            } else if (!WXShareHelper.a().c()) {
              paramInt = 2131918155;
            }
            if (paramInt != -1)
            {
              QRUtils.a(0, paramInt);
              paramInt = i1;
            }
            else if (i1 == 9)
            {
              if (this.f.a() != null)
              {
                this.f.u().show();
                ThreadManager.excute(new SwiftBrowserShareMenuHandler.1(this, paramString, (String)localObject3, (String)localObject4, (String)localObject5), 128, null, false);
                paramInt = i1;
              }
              else
              {
                a(paramString, (String)localObject3, (String)localObject4, (String)localObject5);
                paramInt = i1;
              }
            }
            else if ((this.f.a() != null) && (this.f.a().c == 0))
            {
              a(i1, paramString);
              paramInt = i1;
            }
            else
            {
              e(paramString);
              paramInt = i1;
            }
          }
        }
        else
        {
          paramBundle = this.M;
          if (paramBundle != null)
          {
            paramBundle.a(paramString);
            paramInt = i1;
          }
          else
          {
            if (this.e == null)
            {
              if (this.b.a() != null)
              {
                paramBundle = (SwiftBrowserStatistics)this.b.d().a(-2);
                if ((TextUtils.isEmpty(this.b.a().getUrl())) || (paramBundle == null)) {
                  break label4133;
                }
                localObject3 = this.b.a().getUrl();
                if (TextUtils.isEmpty(paramBundle.aw)) {
                  break label4133;
                }
                if (!paramBundle.aw.equals(localObject3)) {
                  if (!paramBundle.aw.equals(paramString)) {
                    break label4133;
                  }
                }
              }
              else
              {
                throw new InvalidParameterException("ACTION_REFRESH_FREIEND_VIEW should be handled by QQBrowserActivity!");
              }
            }
            else
            {
              paramBundle = (SwiftBrowserStatistics)this.b.d().a(-2);
              if ((TextUtils.isEmpty(this.e.getWebView().getUrl())) || (paramBundle == null)) {
                break label4133;
              }
              localObject3 = this.e.getWebView().getUrl();
              if ((TextUtils.isEmpty(paramBundle.aw)) || ((!paramBundle.aw.equals(localObject3)) && (!paramBundle.aw.equals(paramString)))) {
                break label4133;
              }
            }
            bool = true;
            break label4136;
            label4133:
            bool = false;
            label4136:
            this.f.ae = bool;
            if (QLog.isColorLevel()) {
              QLog.d("SwiftBrowserShareMenuHandler", 2, new Object[] { "ShareArkFromH5 mShare.isShareArk=", Boolean.valueOf(this.f.ae), ",\n shareUrl=", Util.b(paramString, new String[0]) });
            }
            if ((i1 == 72) && (!TextUtils.isEmpty(this.f.V))) {
              this.f.a(i3, (String)localObject8, (String)localObject9);
            }
            a(paramString, (String)localObject1, (String)localObject2);
            paramInt = i1;
          }
        }
      }
    }
    label4243:
    a(paramInt);
  }
  
  public void a(long paramLong)
  {
    ((SwiftBrowserStatistics)this.b.d().a(-2)).a = paramLong;
  }
  
  public void a(Share paramShare, long paramLong)
  {
    a(paramShare, paramLong, true, true);
  }
  
  public void a(Share paramShare, long paramLong, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramShare == null) {
      return;
    }
    Object localObject = this.d;
    if (localObject != null)
    {
      if (((Activity)localObject).isFinishing()) {
        return;
      }
      localObject = this.D;
      WebViewFragment localWebViewFragment = this.e;
      if (localWebViewFragment != null) {
        localObject = localWebViewFragment.getRedirect302Url();
      }
      ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).reportPAShareButtonEvent((String)localObject);
      this.f = paramShare;
      this.j = paramLong;
      b();
      p();
      c();
      if (this.h == null)
      {
        this.h = new ShareActionSheetBuilder(this.d, false, 2);
        this.h.setIntentForStartForwardRecentActivity(o());
      }
      paramShare = null;
      localObject = (SwiftBrowserScreenShotHandler)this.b.d().a(64);
      if (localObject != null) {
        paramShare = ((SwiftBrowserScreenShotHandler)localObject).b();
      }
      localObject = (SwiftBrowserStatistics)this.b.d().a(-2);
      if ((this.e != null) && (localObject != null)) {
        if (((SwiftBrowserStatistics)localObject).ay)
        {
          paramShare = new StringBuilder();
          paramShare.append("<font color='#777777'>应用由 </font><font color='#00a5e0'>");
          paramShare.append(this.r);
          paramShare.append("</font><font color='#777777'> 提供</font>");
          paramShare = paramShare.toString();
          this.h.setActionSheetTitle(Html.fromHtml(paramShare));
          paramShare = new StringBuilder();
          paramShare.append("");
          paramShare.append(this.F);
          paramShare = paramShare.toString();
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("");
          ((StringBuilder)localObject).append(this.E);
          ReportController.b(null, "P_CliOper", "Grp_open", "", "third_app", "exp_menu", 0, 1, 0, paramShare, ((StringBuilder)localObject).toString(), "", "");
        }
        else if (!TextUtils.isEmpty(paramShare))
        {
          this.h.setActionSheetTitle(paramShare);
        }
        else
        {
          this.h.setActionSheetTitle(BaseApplicationImpl.getApplication().getString(2131916528));
        }
      }
      this.h.setActionSheetItems(aE_());
      this.h.setItemClickListenerV2(this);
      this.h.setOnDismissListener(this);
      paramShare = this.h;
      int i2 = 8;
      int i1;
      if (paramBoolean1) {
        i1 = 0;
      } else {
        i1 = 8;
      }
      if (paramBoolean2) {
        i2 = 0;
      }
      paramShare.setRowVisibility(i1, 0, i2);
      try
      {
        this.h.show();
      }
      catch (Exception paramShare)
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("actionSheet.show exception=");
          ((StringBuilder)localObject).append(paramShare);
          QLog.d("SwiftBrowserShareMenuHandler", 2, ((StringBuilder)localObject).toString());
        }
      }
      if ((this.e != null) && (this.m == 1008))
      {
        paramShare = g();
        localObject = paramShare;
        if (paramShare == null) {
          localObject = this.e.getUrl();
        }
        if (TextUtils.isEmpty(this.n)) {
          return;
        }
        paramShare = Uri.parse((String)localObject);
        try
        {
          paramShare = paramShare.getQueryParameter("article_id");
        }
        catch (Exception paramShare)
        {
          paramShare.printStackTrace();
          paramShare = "";
        }
        if (paramShare == null) {
          paramShare = "";
        }
        ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005F78", "0X8005F78", 0, 0, this.n, (String)localObject, this.o, paramShare, false);
      }
      if (this.z)
      {
        ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X8008CAA", "0X8008CAA", 0, 0, "", "", "", "", false);
        return;
      }
      if (this.y) {
        ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X8008CAB", "0X8008CAB", 0, 0, "", "", "", "", false);
      }
    }
  }
  
  public void a(SwiftBrowserShareMenuHandler.ShareToFriendCallback paramShareToFriendCallback)
  {
    this.M = paramShareToFriendCallback;
  }
  
  public void a(String paramString)
  {
    this.D = paramString;
  }
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    if (TextUtils.isEmpty(paramString2)) {
      paramString2 = paramString3;
    }
    ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).reportPAShareItemEvent(1001, paramString2, this.H);
    if (!TextUtils.isEmpty(this.f.S)) {
      this.f.b(paramString1, 1, false);
    } else if (!TextUtils.isEmpty(this.f.U)) {
      this.f.q();
    } else if (this.f.T != null) {
      paramString2 = new JSONObject();
    }
    try
    {
      paramString2.put("type", 0);
      label109:
      DoraemonUtil.b(this.f.T, paramString2);
      this.f.a(paramString1, 1, false);
      ReportCenter.a().a("", "", "", "1000", "101", "0", false);
      ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "mp_msg_webview_38", "qq_share", 0, 1, 0, "", "", "", "");
      return;
    }
    catch (JSONException paramString3)
    {
      break label109;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.N = paramBoolean;
  }
  
  public List<ShareActionSheetBuilder.ActionSheetItem>[] aE_()
  {
    ArrayList localArrayList1 = new ArrayList();
    Object localObject1 = (SwiftBrowserStatistics)this.b.d().a(-2);
    if ((this.e != null) && (localObject1 != null) && (((SwiftBrowserStatistics)localObject1).ay))
    {
      localArrayList1.add(ShareActionSheetBuilder.ActionSheetItem.build(15));
      localArrayList1.add(ShareActionSheetBuilder.ActionSheetItem.build(16));
      localArrayList1.add(ShareActionSheetBuilder.ActionSheetItem.build(17));
      localArrayList1.add(ShareActionSheetBuilder.ActionSheetItem.build(18));
      return (List[])new ArrayList[] { localArrayList1 };
    }
    localObject1 = null;
    if (BaseApplicationImpl.getApplication().getRuntime() != null) {
      localObject1 = BaseApplicationImpl.getApplication().getRuntime();
    }
    IPublicAccountH5AbilityPlugin localIPublicAccountH5AbilityPlugin = (IPublicAccountH5AbilityPlugin)QRoute.api(IPublicAccountH5AbilityPlugin.class);
    if ((localObject1 != null) && (!TextUtils.isEmpty(((AppRuntime)localObject1).getAccount())) && (this.J) && (!localIPublicAccountH5AbilityPlugin.contains(this.i, "menuItem:share:diandian")) && (!TextUtils.isEmpty(this.f.S))) {
      localArrayList1.add(ShareActionSheetBuilder.ActionSheetItem.build(34));
    }
    if ((localObject1 != null) && (!TextUtils.isEmpty(((AppRuntime)localObject1).getAccount())) && (!localIPublicAccountH5AbilityPlugin.contains(this.i, "menuItem:share:qq")) && ((this.j & 0x8) == 0L)) {
      localArrayList1.add(ShareActionSheetBuilder.ActionSheetItem.build(2));
    }
    if (QFileAssistantUtils.b()) {
      localArrayList1.add(ShareActionSheetBuilder.ActionSheetItem.build(26));
    }
    if ((localObject1 != null) && (!TextUtils.isEmpty(((AppRuntime)localObject1).getAccount())) && (!localIPublicAccountH5AbilityPlugin.contains(this.i, "menuItem:share:QZone")) && ((this.j & 0x10) == 0L)) {
      localArrayList1.add(ShareActionSheetBuilder.ActionSheetItem.build(3));
    }
    if (((this.j & 0x8000000) != 0L) && (((IReadInJoyHelper)QRoute.api(IReadInJoyHelper.class)).isOSVersionSupportReadInJoy()) && (!localIPublicAccountH5AbilityPlugin.contains(this.i, "menuItem:share:kandian")) && (localObject1 != null))
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("readinjoy_");
      ((StringBuilder)localObject2).append(((AppRuntime)localObject1).getAccount());
      ((StringBuilder)localObject2).append("_");
      ((StringBuilder)localObject2).append(1);
      localObject2 = ((StringBuilder)localObject2).toString();
      localObject2 = BaseApplicationImpl.getApplication().getSharedPreferences((String)localObject2, 4);
      if ((localObject2 != null) && (((SharedPreferences)localObject2).getBoolean("share_to_news", false))) {
        localArrayList1.add(ShareActionSheetBuilder.ActionSheetItem.build(13));
      }
    }
    if ((localObject1 != null) && (!TextUtils.isEmpty(((AppRuntime)localObject1).getAccount())) && (!localIPublicAccountH5AbilityPlugin.contains(this.i, "menuItem:share:appMessage")) && ((this.j & 0x4000) == 0L)) {
      localArrayList1.add(ShareActionSheetBuilder.ActionSheetItem.build(9));
    }
    if ((localObject1 != null) && (!TextUtils.isEmpty(((AppRuntime)localObject1).getAccount())) && (!localIPublicAccountH5AbilityPlugin.contains(this.i, "menuItem:share:timeline")) && ((this.j & 0x8000) == 0L)) {
      localArrayList1.add(ShareActionSheetBuilder.ActionSheetItem.build(10));
    }
    Object localObject2 = this.d.getIntent();
    int i1;
    if ((localObject2 != null) && (((Intent)localObject2).getBooleanExtra("use_wei_bo_sdk", false))) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    if (((i1 != 0) || (this.I)) && (!localIPublicAccountH5AbilityPlugin.contains(this.i, "menuItem:share:sinaWeibo"))) {
      localArrayList1.add(ShareActionSheetBuilder.ActionSheetItem.build(12));
    }
    if ((!localIPublicAccountH5AbilityPlugin.contains(this.i, "menuItem:openWithQQBrowser")) && ((this.j & 0x200) == 0L)) {
      localArrayList1.add(ShareActionSheetBuilder.ActionSheetItem.build(5));
    }
    if ((!localIPublicAccountH5AbilityPlugin.contains(this.i, "menuItem:openWithSafari")) && ((this.j & 0x100) == 0L)) {
      localArrayList1.add(ShareActionSheetBuilder.ActionSheetItem.build(4));
    }
    localObject2 = BaseApplicationImpl.getApplication().getPackageManager();
    if ((!localIPublicAccountH5AbilityPlugin.contains(this.i, "menuItem:share:qiDian")) && ((0x10 & this.j) == 0L)) {
      QidianManager.a(this.d, localArrayList1);
    }
    if ((!localIPublicAccountH5AbilityPlugin.contains(this.i, "menuItem:share:qiYeQQ")) && ((this.j & 0x20) == 0L) && (new Intent().setPackage("com.tencent.eim").setData(Uri.parse("eimapi://")).resolveActivity((PackageManager)localObject2) != null)) {
      localArrayList1.add(ShareActionSheetBuilder.ActionSheetItem.build(20));
    }
    ArrayList localArrayList2 = new ArrayList();
    Object localObject3;
    if (this.N)
    {
      localObject3 = (QQBrowserActivity)this.d;
      localObject2 = ((QQBrowserActivity)localObject3).getOriginalUrl();
      localObject3 = ((QQBrowserActivity)localObject3).getWebColorNoteInjector();
      if ((localObject3 != null) && (((IWebColorNoteInject)localObject3).a((String)localObject2)))
      {
        boolean bool = ((IWebColorNoteInject)localObject3).d();
        localObject3 = ShareActionSheetBuilder.ActionSheetItem.build(70);
        localObject2 = BaseApplicationImpl.getApplication();
        if (!bool) {
          i1 = 2131916465;
        } else {
          i1 = 2131887833;
        }
        ((ShareActionSheetBuilder.ActionSheetItem)localObject3).label = ((BaseApplicationImpl)localObject2).getString(i1);
        if (!bool) {
          i1 = 2130848038;
        } else {
          i1 = 2130848047;
        }
        ((ShareActionSheetBuilder.ActionSheetItem)localObject3).icon = i1;
        if (ThemeImageWrapper.isNightMode())
        {
          if (!bool) {
            i1 = 2130848039;
          } else {
            i1 = 2130848048;
          }
          ((ShareActionSheetBuilder.ActionSheetItem)localObject3).icon = i1;
        }
        if (!bool) {
          localObject2 = "colornote";
        } else {
          localObject2 = "colornote_cancel";
        }
        ((ShareActionSheetBuilder.ActionSheetItem)localObject3).reportID = ((String)localObject2);
        localArrayList2.add(localObject3);
      }
    }
    ShareActionSheetBuilder.ActionSheetItem localActionSheetItem;
    if (this.y)
    {
      localObject2 = this.A;
      if (localObject2 != null)
      {
        localObject2 = ((ArrayList)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (IPublicAccountJavascriptInterface.ActionItem)((Iterator)localObject2).next();
          localActionSheetItem = ShareActionSheetBuilder.ActionSheetItem.build(30);
          i1 = ((IPublicAccountJavascriptInterface.ActionItem)localObject3).a;
          if (i1 != 1)
          {
            if (i1 == 2) {
              localArrayList2.add(ShareActionSheetBuilder.ActionSheetItem.build(31));
            }
          }
          else
          {
            if (TextUtils.isEmpty(((IPublicAccountJavascriptInterface.ActionItem)localObject3).b)) {
              localActionSheetItem.label = BaseApplicationImpl.getApplication().getString(2131892927);
            } else {
              localActionSheetItem.label = ((IPublicAccountJavascriptInterface.ActionItem)localObject3).b;
            }
            localArrayList2.add(localActionSheetItem);
          }
        }
      }
    }
    if (this.z)
    {
      localObject2 = this.A;
      if (localObject2 != null)
      {
        localObject2 = ((ArrayList)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (IPublicAccountJavascriptInterface.ActionItem)((Iterator)localObject2).next();
          localActionSheetItem = ShareActionSheetBuilder.ActionSheetItem.build(37);
          i1 = ((IPublicAccountJavascriptInterface.ActionItem)localObject3).a;
          if (i1 != 1)
          {
            if (i1 == 3) {
              localArrayList2.add(ShareActionSheetBuilder.ActionSheetItem.build(35));
            }
          }
          else
          {
            if (TextUtils.isEmpty(((IPublicAccountJavascriptInterface.ActionItem)localObject3).b)) {
              localActionSheetItem.label = BaseApplicationImpl.getApplication().getString(2131892927);
            } else {
              localActionSheetItem.label = ((IPublicAccountJavascriptInterface.ActionItem)localObject3).b;
            }
            localArrayList2.add(localActionSheetItem);
          }
        }
      }
    }
    localObject2 = (SwiftBrowserScreenShotHandler)this.b.d().a(64);
    if ((localObject2 != null) && (((SwiftBrowserScreenShotHandler)localObject2).e()) && (!localIPublicAccountH5AbilityPlugin.contains(this.i, "menuItem:screenShotShare"))) {
      localArrayList2.add(ShareActionSheetBuilder.ActionSheetItem.build(21));
    }
    if ((localObject1 != null) && (!TextUtils.isEmpty(((AppRuntime)localObject1).getAccount())) && (!localIPublicAccountH5AbilityPlugin.contains(this.i, "menuItem:favorite")) && ((this.j & 0x2000) == 0L)) {
      localArrayList2.add(ShareActionSheetBuilder.ActionSheetItem.build(6));
    }
    if (this.P) {
      localArrayList2.add(ShareActionSheetBuilder.ActionSheetItem.build(129));
    }
    if ((localObject1 != null) && (!TextUtils.isEmpty(((AppRuntime)localObject1).getAccount())) && (!localIPublicAccountH5AbilityPlugin.contains(this.i, "menuItem:exportTencentDocs")) && ((((SwiftBrowserUIStyleHandler)this.b.d().a(2)).f.d & 0x4000) == 0L))
    {
      localObject2 = g();
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = this.D;
      }
      if (TeamWorkConvertUtils.a((String)localObject1))
      {
        localArrayList2.add(ShareActionSheetBuilder.ActionSheetItem.build(68));
        TeamWorkConvertUtils.a(0, 1);
      }
    }
    if ((!localIPublicAccountH5AbilityPlugin.contains(this.i, "menuItem:setFont")) && (!this.l) && (this.g)) {
      localArrayList2.add(ShareActionSheetBuilder.ActionSheetItem.build(7));
    }
    if ((!localIPublicAccountH5AbilityPlugin.contains(this.i, "menuItem:copyUrl")) && ((this.j & 0x20) == 0L)) {
      localArrayList2.add(ShareActionSheetBuilder.ActionSheetItem.build(1));
    }
    if (((TextUtils.isEmpty(this.D)) || (!"docs.qq.com".equals(Uri.parse(this.D).getHost()))) && (!localIPublicAccountH5AbilityPlugin.contains(this.i, "menuItem:screenLongShotShare")) && ((this.j & 0x8000) == 0L) && (this.b != null) && (this.b.a() != null) && (this.b.a().getX5WebViewExtension() != null)) {
      localArrayList2.add(ShareActionSheetBuilder.ActionSheetItem.build(71));
    }
    if ((!localIPublicAccountH5AbilityPlugin.contains(this.i, "menuItem:exposeArticle")) && (this.k)) {
      localArrayList2.add(ShareActionSheetBuilder.ActionSheetItem.build(11));
    }
    return (List[])new ArrayList[] { localArrayList1, localArrayList2 };
  }
  
  @TargetApi(14)
  public void b(int paramInt)
  {
    if (this.b.a() != null)
    {
      if (this.v) {
        return;
      }
      Object localObject = c;
      if ((paramInt < localObject.length) && (paramInt >= 0))
      {
        this.w = paramInt;
        int i1 = localObject[paramInt];
        this.b.a().getSettings().setTextZoom(i1);
        localObject = this.f;
        if (localObject != null) {
          ((Share)localObject).a(paramInt, i1);
        }
        return;
      }
      QLog.d("SwiftBrowserShareMenuHandler", 2, new Object[] { "adjustFontSize fontSizeIndex=", Integer.valueOf(paramInt) });
    }
  }
  
  public void b(boolean paramBoolean)
  {
    this.I = paramBoolean;
  }
  
  public boolean b(String paramString)
  {
    String str = this.f.getShareUrl();
    boolean bool3 = TextUtils.isEmpty(this.f.d());
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (!bool3)
    {
      bool1 = bool2;
      if (!TextUtils.isEmpty(this.f.e()))
      {
        bool1 = bool2;
        if (!TextUtils.isEmpty(str))
        {
          bool1 = bool2;
          if (str.equals(Util.a(paramString, new String[0]))) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  public void c(boolean paramBoolean)
  {
    this.J = paramBoolean;
  }
  
  public boolean c()
  {
    boolean bool = false;
    this.g = false;
    if (((SwiftBrowserUIStyleHandler)this.b.d().a(2)).f.l) {
      return false;
    }
    if (this.b.a() != null)
    {
      this.b.a();
      int i1 = WebView.getTbsCoreVersion(BaseApplicationImpl.getContext());
      if ((i1 > 0) && (i1 < 36201))
      {
        this.g = false;
        return this.g;
      }
    }
    if (Build.VERSION.SDK_INT >= 14) {
      bool = true;
    }
    this.g = bool;
    return this.g;
  }
  
  public String d()
  {
    return this.o;
  }
  
  public void d(boolean paramBoolean)
  {
    this.K = paramBoolean;
  }
  
  public String e()
  {
    return this.n;
  }
  
  public void e(boolean paramBoolean)
  {
    this.L = paramBoolean;
  }
  
  public String f()
  {
    return this.p;
  }
  
  public String g()
  {
    Share localShare = this.f;
    if (localShare == null) {
      return "";
    }
    return localShare.getShareUrl();
  }
  
  public void h()
  {
    this.G = ((IFontSizePanelBuilderFactory)QRoute.api(IFontSizePanelBuilderFactory.class)).createFontSizePanelBuilder(this.d.getLayoutInflater()).a(this).a(this.w).a().a(this.b.a());
  }
  
  public void i()
  {
    if (c())
    {
      TroopMemberApiClient localTroopMemberApiClient = this.u;
      if (localTroopMemberApiClient != null) {
        localTroopMemberApiClient.a(this.a);
      }
      this.a = j().g(new SwiftBrowserShareMenuHandler.6(this));
      return;
    }
    b(1);
  }
  
  public TroopMemberApiClient j()
  {
    if (this.u == null)
    {
      this.u = TroopMemberApiClient.a();
      this.u.e();
    }
    return this.u;
  }
  
  public boolean k()
  {
    return this.I;
  }
  
  public boolean l()
  {
    return this.J;
  }
  
  public boolean m()
  {
    return this.L;
  }
  
  public Bundle n()
  {
    return this.B;
  }
  
  public void onChange(int paramInt1, int paramInt2)
  {
    if (paramInt1 == paramInt2) {
      return;
    }
    b(paramInt2);
    j().b(this.w);
  }
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if ((this.j & 0x20000) != 0L)
    {
      paramDialogInterface = this.e;
      if (paramDialogInterface != null) {
        WebViewUIUtils.b(paramDialogInterface.getActivity());
      }
    }
    paramDialogInterface = this.e;
    if ((paramDialogInterface != null) && (paramDialogInterface.getUIStyleHandler() != null) && ((this.e.getHostActivity() instanceof TeamWorkDocEditBrowserActivity)) && (!TextUtils.isEmpty(this.e.getUrl())) && (this.e.getUrl().contains("sheet"))) {
      this.e.getUIStyleHandler().i();
    }
    try
    {
      if ((this.f != null) && (this.f.u() != null)) {
        this.f.u().dismiss();
      }
    }
    catch (Throwable paramDialogInterface)
    {
      QLog.e("SwiftBrowserShareMenuHandler", 1, paramDialogInterface, new Object[0]);
    }
    if ((this.B != null) && (QLog.isColorLevel())) {
      QLog.d("SwiftBrowserShareMenuHandler", 2, "onDismiss() called don't clear mExtraParams for time sequence problems");
    }
  }
  
  public void onItemClick(ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem, ShareActionSheet paramShareActionSheet)
  {
    if (paramActionSheetItem == null) {
      return;
    }
    this.h.dismiss();
    a(paramActionSheetItem.action, paramActionSheetItem);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.component.SwiftBrowserShareMenuHandler
 * JD-Core Version:    0.7.0.1
 */