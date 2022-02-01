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
  public static final int[] a;
  public static long b;
  public int a;
  public long a;
  public Activity a;
  protected Bundle a;
  TroopMemberApiClient jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient = null;
  public Share a;
  private IFontSizePanel jdField_a_of_type_ComTencentMobileqqKandianBaseViewApiIFontSizePanel = null;
  public ShareActionSheetBuilder a;
  public WebViewFragment a;
  private SwiftBrowserShareMenuHandler.ShareToFriendCallback jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserShareMenuHandler$ShareToFriendCallback = null;
  public String a;
  public final ArrayList<String> a;
  public boolean a;
  public int b;
  public String b;
  public ArrayList<IPublicAccountJavascriptInterface.ActionItem> b;
  public boolean b;
  private int jdField_c_of_type_Int;
  private long jdField_c_of_type_Long = -1L;
  public String c;
  public boolean c;
  private int jdField_d_of_type_Int;
  private long jdField_d_of_type_Long = -1L;
  public String d;
  boolean jdField_d_of_type_Boolean = false;
  private int e;
  public String e;
  public boolean e;
  private int f;
  public String f;
  public boolean f;
  public String g;
  private boolean g;
  public String h;
  private boolean h;
  private String jdField_i_of_type_JavaLangString;
  private boolean jdField_i_of_type_Boolean = false;
  private boolean j = false;
  private boolean k = true;
  private boolean l = true;
  private boolean m = false;
  
  static
  {
    jdField_a_of_type_ArrayOfInt = new int[] { 95, 100, 107, 115, 127 };
    jdField_b_of_type_Long = -1L;
  }
  
  public SwiftBrowserShareMenuHandler()
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_Long = 4L;
    this.jdField_b_of_type_Boolean = true;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_c_of_type_JavaLangString = "";
    this.jdField_d_of_type_JavaLangString = "";
    this.jdField_b_of_type_Int = 1;
    this.jdField_g_of_type_Boolean = false;
    this.jdField_h_of_type_Boolean = false;
    this.jdField_e_of_type_Boolean = false;
    this.jdField_f_of_type_Boolean = false;
    this.jdField_b_of_type_JavaUtilArrayList = null;
    this.jdField_h_of_type_JavaLangString = "general_url";
  }
  
  private Intent a()
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("forward_type", 1001);
    localIntent.putExtra("pluginName", "web_share");
    return localIntent;
  }
  
  private String a(int paramInt)
  {
    if (paramInt == 1)
    {
      localWebViewFragment = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment;
      return localWebViewFragment.getString(2131719541, new Object[] { localWebViewFragment.getString(2131691293) });
    }
    if (paramInt == 3)
    {
      localWebViewFragment = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment;
      return localWebViewFragment.getString(2131719541, new Object[] { localWebViewFragment.getString(2131719036) });
    }
    if (paramInt == 10)
    {
      localWebViewFragment = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment;
      return localWebViewFragment.getString(2131719541, new Object[] { localWebViewFragment.getString(2131719032) });
    }
    if (paramInt == 12)
    {
      localWebViewFragment = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment;
      return localWebViewFragment.getString(2131719541, new Object[] { localWebViewFragment.getString(2131696417) });
    }
    WebViewFragment localWebViewFragment = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment;
    return localWebViewFragment.getString(2131719541, new Object[] { localWebViewFragment.getString(2131720114) });
  }
  
  private void a(int paramInt, String paramString)
  {
    DialogUtil.a(this.jdField_a_of_type_AndroidAppActivity, a(paramInt), 2131691810, 2131720390, new SwiftBrowserShareMenuHandler.4(this, paramInt, paramString), new SwiftBrowserShareMenuHandler.5(this, paramInt, paramString)).show();
  }
  
  private void a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    JSONObject localJSONObject;
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizWebviewpluginShare.p)) {
      this.jdField_a_of_type_ComTencentBizWebviewpluginShare.a(paramString1, 3, true);
    } else if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizWebviewpluginShare.t)) {
      this.jdField_a_of_type_ComTencentBizWebviewpluginShare.g();
    } else if (this.jdField_a_of_type_ComTencentBizWebviewpluginShare.a != null) {
      localJSONObject = new JSONObject();
    }
    try
    {
      localJSONObject.put("type", 2);
      label77:
      DoraemonUtil.b(this.jdField_a_of_type_ComTencentBizWebviewpluginShare.a, localJSONObject);
      this.jdField_a_of_type_ComTencentBizWebviewpluginShare.a(paramString1, 3, true);
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
  
  private void b(int paramInt, String paramString)
  {
    if (paramInt == 1)
    {
      b(paramString);
      return;
    }
    if (paramInt == 3)
    {
      e(paramString);
      return;
    }
    if (paramInt == 10)
    {
      d(paramString);
      return;
    }
    if (paramInt == 12) {
      c(paramString);
    }
  }
  
  private void b(String paramString)
  {
    ((ClipboardManager)this.jdField_a_of_type_AndroidAppActivity.getSystemService("clipboard")).setText(paramString);
    QRUtils.a(2, 2131691296);
    if ((this.jdField_i_of_type_Boolean) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizWebviewpluginShare.p))) {
      this.jdField_a_of_type_ComTencentBizWebviewpluginShare.c();
    }
  }
  
  private void c(String paramString)
  {
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizWebviewpluginShare.p)) {
      this.jdField_a_of_type_ComTencentBizWebviewpluginShare.a(paramString, 8, false);
    } else {
      this.jdField_a_of_type_ComTencentBizWebviewpluginShare.a(paramString, 8, false);
    }
    String str = this.jdField_i_of_type_JavaLangString;
    if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserComponentsProvider$SwiftBrowserComponentContext.a() != null) {
      str = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserComponentsProvider$SwiftBrowserComponentContext.a().getUrl();
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
    ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).reportPAShareItemEvent(1005, str, this.jdField_f_of_type_Int);
  }
  
  private void d()
  {
    Object localObject = this.jdField_a_of_type_AndroidAppActivity.getIntent();
    WebViewFragment localWebViewFragment = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment;
    if (localWebViewFragment != null) {
      localObject = localWebViewFragment.getIntent();
    }
    this.jdField_i_of_type_JavaLangString = ((Intent)localObject).getStringExtra("url");
    if (this.jdField_i_of_type_JavaLangString == null)
    {
      this.jdField_i_of_type_JavaLangString = ((Intent)localObject).getStringExtra("key_params_qq");
      if (this.jdField_i_of_type_JavaLangString == null) {
        this.jdField_i_of_type_JavaLangString = "";
      }
    }
    localObject = ((Intent)localObject).getExtras();
    if (localObject != null)
    {
      this.jdField_a_of_type_Int = ((Bundle)localObject).getInt("uin_type");
      this.jdField_a_of_type_JavaLangString = ((Bundle)localObject).getString("puin");
      this.jdField_b_of_type_JavaLangString = ((Bundle)localObject).getString("msg_id");
      if (this.jdField_b_of_type_JavaLangString == null) {
        this.jdField_b_of_type_JavaLangString = "";
      }
      this.jdField_c_of_type_JavaLangString = ((Bundle)localObject).getString("source_puin");
      if (this.jdField_c_of_type_JavaLangString == null) {
        this.jdField_c_of_type_JavaLangString = "";
      }
      this.jdField_d_of_type_JavaLangString = ((Bundle)localObject).getString("friendUin");
      if (this.jdField_d_of_type_JavaLangString == null) {
        this.jdField_d_of_type_JavaLangString = "";
      }
      this.jdField_d_of_type_Int = ((Bundle)localObject).getInt("appid");
      this.jdField_e_of_type_Int = ((Bundle)localObject).getInt("troopid");
      this.m = ((Bundle)localObject).getBoolean("fromFav");
      if (this.m)
      {
        this.jdField_c_of_type_Long = ((Bundle)localObject).getLong("favID");
        this.jdField_d_of_type_Long = ((Bundle)localObject).getLong("favGroupID");
      }
      this.jdField_f_of_type_Int = ((Bundle)localObject).getInt("articalChannelId", 100);
    }
  }
  
  private void d(String paramString)
  {
    JSONObject localJSONObject;
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizWebviewpluginShare.p)) {
      this.jdField_a_of_type_ComTencentBizWebviewpluginShare.a(paramString, 4, true);
    } else if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizWebviewpluginShare.u)) {
      this.jdField_a_of_type_ComTencentBizWebviewpluginShare.h();
    } else if (this.jdField_a_of_type_ComTencentBizWebviewpluginShare.a != null) {
      localJSONObject = new JSONObject();
    }
    try
    {
      localJSONObject.put("type", 3);
      label75:
      DoraemonUtil.b(this.jdField_a_of_type_ComTencentBizWebviewpluginShare.a, localJSONObject);
      this.jdField_a_of_type_ComTencentBizWebviewpluginShare.a(paramString, 4, true);
      ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "mp_msg_webview_42", "pengyouquan_share", 0, 1, 0, "", "", "", "");
      ReportCenter.a().a("", "", "", "1000", "104", "0", false);
      return;
    }
    catch (JSONException localJSONException)
    {
      break label75;
    }
  }
  
  private void e()
  {
    if (a(this.jdField_a_of_type_ComTencentBizWebviewpluginShare.getShareUrl()))
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
      int i1 = com.tencent.mobileqq.webprocess.WebAccelerateHelper.getInstance().getWebViewFeatureParams()[2].intValue();
      int n = i1;
      if (i1 < 0) {
        n = 190;
      }
      String str = String.format("function callShare(){\"loading\"==document.readyState?window.addEventListener(\"load\",sharePageInfo(),!1):sharePageInfo()}var readStyleProp=function(a,b){var c,d;return b?(b=b.toLowerCase(),a.style&&a.style[b]?c=a.style[b]:a.currentStyle?(b=b.replace(/\\-([a-z])([a-z]?)/gi,function(a,b,c){return b.toUpperCase()+c.toLowerCase()}),c=a.currentStyle[b]):document.defaultView&&document.defaultView.getComputedStyle&&(d=document.defaultView.getComputedStyle(a,null),c=d.getPropertyValue(b)),-1!=c.indexOf(\"px\")&&(c=c.replace(/(px)/i,\"\")),c):void 0},parsePageInfo=function(){var b,c,d,e,f,g,h,i,j,k,l,a={};for(a[\"shareURL\"]=document.documentURI,b=\"\",c=\"\",d=document.getElementsByTagName(\"meta\"),f=0;f<d.length;f++)e=d[f],!a.title&&e.getAttribute(\"itemprop\")&&\"name\"==e.getAttribute(\"itemprop\").toLowerCase()&&void 0!=e.content&&\"\"!=e.content&&(a[\"title\"]=e.content),a.summary||\"description\"!=e.name||void 0!=e.content&&\"\"!=e.content&&(b=e.content),!a.summary&&e.getAttribute(\"itemprop\")&&\"description\"==e.getAttribute(\"itemprop\").toLowerCase()&&void 0!=e.content&&\"\"!=e.content&&(c=e.content),!a.image&&e.getAttribute(\"itemprop\")&&\"image\"==e.getAttribute(\"itemprop\").toLowerCase()&&void 0!=e.content&&\"\"!=e.content&&(a[\"image\"]=e.content);if(\"\"!=c?a[\"summary\"]=c:\"\"!=b&&(a[\"summary\"]=b),!a.image)for(g=document.getElementsByTagName(\"img\"),h=%d,i=%d,f=0;f<g.length&&30>f;f++)if(j=g[f],(j.src.startsWith(\"//\")||j.src.startsWith(\"http://\")||j.src.startsWith(\"https://\"))&&(k=j.width,l=j.height,void 0!=j.naturalWidth&&void 0!=j.naturalHeight&&(k=j.naturalWidth,l=j.naturalHeight),k>=h&&10*h>k&&l>=i&&10*i>l&&\"none\"!=readStyleProp(j,\"display\")&&\"hidden\"!=readStyleProp(j,\"visibility\"))){a[\"image\"]=j.src,a.image.startsWith(\"//\")&&(a.image=(document.documentURI.startsWith(\"http:\")?\"http:\":\"https:\")+a.image);break}return a},sharePageInfo=function(){var a,c,d,e;try{a=parsePageInfo()}catch(b){}a||(a=new object),a[\"type\"]=\"share\",a[\"callback\"]=1,c=JSON.stringify(a),d=\"jsbridge://share/setShare?p=\"+encodeURIComponent(c),e=document.createElement(\"iframe\"),e.style.cssText=\"display:none;width:0px;height:0px;\",(document.documentElement||document.body).appendChild(e),e.src=d};callShare();", new Object[] { Integer.valueOf(n), Integer.valueOf(n) });
      if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserComponentsProvider$SwiftBrowserComponentContext.a() != null)
      {
        WebView localWebView = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserComponentsProvider$SwiftBrowserComponentContext.a();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("javascript:");
        localStringBuilder.append(str);
        localStringBuilder.append(";");
        localWebView.loadUrl(localStringBuilder.toString());
      }
    }
  }
  
  private void e(String paramString)
  {
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizWebviewpluginShare.p)) {
      this.jdField_a_of_type_ComTencentBizWebviewpluginShare.a(paramString, 2, false);
    } else if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizWebviewpluginShare.s)) {
      this.jdField_a_of_type_ComTencentBizWebviewpluginShare.f();
    } else if (this.jdField_a_of_type_ComTencentBizWebviewpluginShare.a != null) {
      paramString = new JSONObject();
    }
    try
    {
      paramString.put("type", 1);
      label75:
      DoraemonUtil.b(this.jdField_a_of_type_ComTencentBizWebviewpluginShare.a, paramString);
      this.jdField_a_of_type_ComTencentBizWebviewpluginShare.a();
      ReportCenter.a().a("", "", "", "1000", "102", "0", false);
      ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "mp_msg_webview_44", "qzone_share", 0, 1, 0, "", "", "", "");
      return;
    }
    catch (JSONException localJSONException)
    {
      break label75;
    }
  }
  
  public Bundle a()
  {
    return this.jdField_a_of_type_AndroidOsBundle;
  }
  
  public TroopMemberApiClient a()
  {
    if (this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient == null)
    {
      this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient = TroopMemberApiClient.a();
      this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.a();
    }
    return this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient;
  }
  
  public String a()
  {
    return this.jdField_b_of_type_JavaLangString;
  }
  
  public void a()
  {
    super.a();
    this.jdField_d_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidAppActivity = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserComponentsProvider$SwiftBrowserComponentContext.a();
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment = ((WebViewFragment)this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserComponentsProvider$SwiftBrowserComponentContext.a());
    d();
  }
  
  public void a(int paramInt)
  {
    String str2 = d();
    if (str2 == null) {
      str2 = this.jdField_i_of_type_JavaLangString;
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
        paramBundle = this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder;
        if (paramBundle != null) {
          paramBundle.onConfigurationChanged();
        }
        paramBundle = this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewApiIFontSizePanel;
        if ((paramBundle != null) && (paramBundle.a()))
        {
          this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewApiIFontSizePanel.b();
          b();
        }
      }
      else
      {
        this.jdField_d_of_type_Boolean = true;
        paramBundle = this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewApiIFontSizePanel;
        if (paramBundle != null) {
          paramBundle.a();
        }
        paramBundle = this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient;
        if (paramBundle != null)
        {
          paramBundle.a(this.jdField_c_of_type_Int);
          this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.b();
        }
        this.jdField_a_of_type_JavaUtilArrayList.clear();
      }
    }
    else if ((paramBundle != null) && (paramBundle.getInt("state_machine_step", -1) == 1)) {
      c();
    }
  }
  
  public void a(int paramInt, ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem)
  {
    String str = d();
    Bundle localBundle = new Bundle();
    WebViewFragment localWebViewFragment = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment;
    if (localWebViewFragment != null)
    {
      localBundle.putString("qq", localWebViewFragment.getUin());
      localBundle.putString("public_uin", this.jdField_a_of_type_JavaLangString);
      localBundle.putString("source_public_uin", this.jdField_c_of_type_JavaLangString);
      localBundle.putString("default_url", this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.getUrl());
      localBundle.putString("msg_id", this.jdField_b_of_type_JavaLangString);
      localBundle.putString("troop_app_info_url", this.jdField_g_of_type_JavaLangString);
      localBundle.putString("troop_app_share_url", this.jdField_f_of_type_JavaLangString);
      localBundle.putInt("troop_id", this.jdField_e_of_type_Int);
      localBundle.putInt("troop_app_id", this.jdField_d_of_type_Int);
      localBundle.putInt("uin_type", this.jdField_a_of_type_Int);
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
    int n = paramInt;
    String str1 = "";
    Object localObject6;
    Object localObject7;
    Object localObject3;
    Object localObject4;
    Object localObject5;
    int i1;
    Object localObject10;
    int i2;
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
      i1 = paramBundle.getInt("troop_id", 0);
      localObject10 = paramBundle.getString("troop_app_info_url", "");
      paramBundle.getInt("uin_type", 0);
      i2 = paramBundle.getInt("to_uin_type", 0);
      localObject8 = paramBundle.getString("to_qq", "");
      localObject9 = paramBundle.getString("to_uin_name", "");
      this.jdField_a_of_type_AndroidOsBundle = paramBundle;
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
      i1 = 0;
      i2 = 0;
      localObject8 = localObject6;
      localObject10 = localObject5;
      localObject5 = localObject4;
      localObject4 = localObject3;
      localObject3 = localObject2;
      localObject7 = localObject1;
      localObject6 = localObject11;
    }
    Object localObject1 = this.jdField_i_of_type_JavaLangString;
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment;
    if (localObject2 != null)
    {
      localObject2 = ((WebViewFragment)localObject2).getRedirect302Url();
      localObject11 = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.getWebView();
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
          int i3 = Integer.parseInt((String)localObject11);
          if ((i3 >> 3 & 0x1) == 1) {
            paramString = (String)localObject2;
          }
        }
      }
      catch (Exception localException3)
      {
        break label385;
      }
    }
    if (n == 1)
    {
      if ((this.jdField_a_of_type_ComTencentBizWebviewpluginShare.a() != null) && (this.jdField_a_of_type_ComTencentBizWebviewpluginShare.a().jdField_a_of_type_Int == 0))
      {
        a(n, paramString);
        paramInt = n;
      }
      else
      {
        b(paramString);
        paramInt = n;
      }
    }
    else if (n == 11) {
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
    paramBundle = new Intent(this.jdField_a_of_type_AndroidAppActivity, QQBrowserActivity.class);
    paramBundle.putExtra("url", paramString);
    paramBundle.putExtra("hide_more_button", true);
    this.jdField_a_of_type_AndroidAppActivity.startActivity(paramBundle);
    ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "mp_msg_webview_67", "jvbao_click", 0, 1, 0, "", "", "", "");
    paramInt = n;
    if (localObject3 != null)
    {
      paramInt = n;
      if (!"".equals(localObject3))
      {
        paramString = ((IPublicAccountDetailActivity)QRoute.api(IPublicAccountDetailActivity.class)).getArticleId((String)localObject4);
        ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005B07", "0X8005B07", 1008, 0, (String)localObject3, (String)localObject5, (String)localObject4, paramString, false);
        paramInt = n;
        break label4252;
        if ((n != 2) && (n != 72) && (n != 73))
        {
          if (n == 26)
          {
            paramBundle.putString("to_qq", "3636666661");
            paramBundle.putString("to_uin_name", this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.getString(2131698288));
            a(72, paramString, paramBundle);
            paramInt = 72;
          }
          else if (n == 4)
          {
            BrowserDialogViewModel.a(this.jdField_a_of_type_AndroidAppActivity, paramString, (String)localObject6);
            paramInt = n;
          }
          else if (n == 5)
          {
            if ((this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment != null) && (this.jdField_a_of_type_AndroidAppActivity != null))
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
                  RouteUtils.a(this.jdField_a_of_type_AndroidAppActivity, paramString, "/base/browser");
                }
              }
              ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "mp_msg_webview_46", "qqbrowser_share", 0, 1, 0, "", "", "", "");
              ReportController.b(null, "P_CliOper", "VIPCOMIC", "", "0X80061A0", "0X80061A0", 1000, 0, Util.b((String)localObject4, new String[0]), null, null, null);
              paramInt = n;
              if (localObject3 != null)
              {
                paramInt = n;
                if (!"".equals(localObject3))
                {
                  paramString = ((IPublicAccountDetailActivity)QRoute.api(IPublicAccountDetailActivity.class)).getArticleId((String)localObject4);
                  ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005B07", "0X8005B07", 1005, 0, (String)localObject3, (String)localObject5, (String)localObject4, paramString, false);
                  paramInt = n;
                }
              }
            }
            else
            {
              throw new InvalidParameterException("ACTION_OPEN_IN_QQ_BROWSER should be handled by QQBrowserActivity!");
            }
          }
          else if (n == 3)
          {
            jdField_b_of_type_Long = System.currentTimeMillis();
            paramBundle = (Bundle)localObject1;
            if (TextUtils.isEmpty((CharSequence)localObject1)) {
              paramBundle = (Bundle)localObject2;
            }
            ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).reportPAShareItemEvent(1002, paramBundle, this.jdField_f_of_type_Int);
            if ((this.jdField_a_of_type_ComTencentBizWebviewpluginShare.a() != null) && (this.jdField_a_of_type_ComTencentBizWebviewpluginShare.a().jdField_a_of_type_Int == 0))
            {
              a(n, paramString);
              paramInt = n;
            }
            else
            {
              e(paramString);
              paramInt = n;
            }
          }
          else if (n == 6)
          {
            if (this.jdField_a_of_type_ComTencentBizWebviewpluginShare.setShareUrl(paramString)) {
              this.jdField_a_of_type_ComTencentBizWebviewpluginShare.a(paramString, 9, false);
            }
            paramInt = n;
            if (localObject3 != null)
            {
              paramInt = n;
              if (!"".equals(localObject3))
              {
                paramString = ((IPublicAccountDetailActivity)QRoute.api(IPublicAccountDetailActivity.class)).getArticleId((String)localObject4);
                ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005B07", "0X8005B07", 1007, 0, (String)localObject3, (String)localObject5, (String)localObject4, paramString, false);
                paramInt = n;
              }
            }
          }
          else if (n == 129)
          {
            QfavHelper.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.getAppRuntime().getCurrentAccountUin(), this.jdField_c_of_type_Long, this.jdField_d_of_type_Long);
            paramInt = n;
          }
          else if ((n != 9) && (n != 10))
          {
            if (n == 13)
            {
              this.jdField_a_of_type_ComTencentBizWebviewpluginShare.a(paramString, 5, true);
              paramInt = n;
            }
            else if (n == 15)
            {
              if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment != null)
              {
                if (!NetworkUtil.isNetSupport(BaseApplicationImpl.getContext()))
                {
                  QQToast.a(BaseApplicationImpl.getContext(), 2, 2131719764, 0).b(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.getWebTitleBarInterface().a());
                  return;
                }
                a().a(paramInt, new SwiftBrowserShareMenuHandler.2(this));
                paramString = new StringBuilder();
                paramString.append("");
                paramString.append(i1);
                paramString = paramString.toString();
                paramBundle = new StringBuilder();
                paramBundle.append("");
                paramBundle.append(paramInt);
                ReportController.b(null, "P_CliOper", "Grp_open", "", "third_app", "add_menu", 0, 1, 0, paramString, paramBundle.toString(), "", "");
                paramInt = n;
              }
              else
              {
                throw new InvalidParameterException("ACTION_ADD_TROOP_APP should be handled by QQBrowserActivity!");
              }
            }
            else if (n == 16)
            {
              paramString = new Intent(this.jdField_a_of_type_AndroidAppActivity, QQBrowserActivity.class);
              paramString.putExtra("url", (String)localObject10);
              paramString.putExtra("hide_operation_bar", true);
              paramString.putExtra("hide_more_button", true);
              this.jdField_a_of_type_AndroidAppActivity.startActivity(paramString);
              paramString = new StringBuilder();
              paramString.append("");
              paramString.append(i1);
              paramString = paramString.toString();
              paramBundle = new StringBuilder();
              paramBundle.append("");
              paramBundle.append(paramInt);
              ReportController.b(null, "P_CliOper", "Grp_open", "", "third_app", "detail_menu", 0, 1, 0, paramString, paramBundle.toString(), "", "");
              paramInt = n;
            }
            else if (n == 17)
            {
              if (paramBundle != null) {
                paramString = paramBundle.getString("troop_app_share_url", "");
              } else {
                paramString = "";
              }
              paramBundle = new Intent(this.jdField_a_of_type_AndroidAppActivity, QQBrowserActivity.class);
              paramBundle.putExtra("url", paramString);
              paramBundle.putExtra("hide_operation_bar", true);
              paramBundle.putExtra("hide_more_button", true);
              this.jdField_a_of_type_AndroidAppActivity.startActivity(paramBundle);
              paramString = new StringBuilder();
              paramString.append("");
              paramString.append(i1);
              paramString = paramString.toString();
              paramBundle = new StringBuilder();
              paramBundle.append("");
              paramBundle.append(paramInt);
              ReportController.b(null, "P_CliOper", "Grp_open", "", "third_app", "share_menu", 0, 1, 0, paramString, paramBundle.toString(), "", "");
              paramInt = n;
            }
            else if (n == 18)
            {
              if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment != null)
              {
                paramString = (SwiftBrowserStatistics)this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserComponentsProvider$SwiftBrowserComponentContext.a().a(-2);
                if ((!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.getWebView().getUrl())) && (paramString != null))
                {
                  paramString.jdField_g_of_type_Boolean = false;
                  paramString.r = System.currentTimeMillis();
                  this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.getWebView().reload();
                  this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.getWebView().setOnCustomScrollChangeListener(null);
                  paramString.a(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.getWebView(), this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.getWebView().getUrl(), 1, 0, 0, 0, 0, null);
                }
                else
                {
                  paramBundle = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.getCurrentUrl();
                  if ((!TextUtils.isEmpty(paramBundle)) && (paramString != null))
                  {
                    paramString.jdField_g_of_type_Boolean = false;
                    paramString.r = System.currentTimeMillis();
                    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.getWebView().loadUrl(paramBundle);
                    paramString.a(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.getWebView(), paramBundle, 1, 0, 0, 0, 0, null);
                  }
                }
                paramString = new StringBuilder();
                paramString.append("");
                paramString.append(i1);
                paramString = paramString.toString();
                paramBundle = new StringBuilder();
                paramBundle.append("");
                paramBundle.append(paramInt);
                ReportController.b(null, "P_CliOper", "Grp_open", "", "third_app", "refresh_menu", 0, 1, 0, paramString, paramBundle.toString(), "", "");
                paramInt = n;
              }
              else
              {
                throw new InvalidParameterException("ACTION_REFRESH_TROOP_APP_VIEW should be handled by QQBrowserActivity!");
              }
            }
            else if (n == 7)
            {
              b();
              paramInt = n;
            }
            else if ((n != 19) && (n != 20))
            {
              if (n == 21)
              {
                paramString = (SwiftBrowserScreenShotHandler)this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserComponentsProvider$SwiftBrowserComponentContext.a().a(64);
                if (paramString != null) {
                  paramString.a(null, null, 2);
                }
                paramString = Uri.parse(this.jdField_i_of_type_JavaLangString);
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
                paramInt = n;
              }
              else if (n == 12)
              {
                if ((this.jdField_a_of_type_ComTencentBizWebviewpluginShare.a() != null) && (this.jdField_a_of_type_ComTencentBizWebviewpluginShare.a().jdField_a_of_type_Int == 0))
                {
                  a(n, paramString);
                  paramInt = n;
                }
                else
                {
                  c(paramString);
                  paramInt = n;
                }
              }
              else if (n == 34)
              {
                if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizWebviewpluginShare.p))
                {
                  this.jdField_a_of_type_ComTencentBizWebviewpluginShare.b();
                  paramInt = n;
                }
                else
                {
                  paramInt = n;
                  if (QLog.isColorLevel())
                  {
                    QLog.d("diandian", 2, "dian dian is here");
                    paramInt = n;
                  }
                }
              }
              else
              {
                l1 = 0L;
                if (n == 35)
                {
                  paramString = this.jdField_b_of_type_JavaUtilArrayList;
                  if (paramString != null)
                  {
                    paramString = paramString.iterator();
                    while (paramString.hasNext())
                    {
                      paramBundle = (IPublicAccountJavascriptInterface.ActionItem)paramString.next();
                      if (paramBundle.jdField_a_of_type_Int == 3) {
                        try
                        {
                          paramString = new JSONObject(paramBundle.jdField_b_of_type_JavaLangString);
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
                  localObject1 = this.jdField_a_of_type_AndroidAppActivity;
                  localObject2 = new StringBuilder();
                  ((StringBuilder)localObject2).append(l1);
                  ((StringBuilder)localObject2).append("");
                  paramString = paramBundle.startAddFriend((Context)localObject1, 1, ((StringBuilder)localObject2).toString(), null, 3096, 1, paramString, null, null, null, null);
                  ((IAddFriendApi)QRoute.api(IAddFriendApi.class)).launchAddFriend(this.jdField_a_of_type_AndroidAppActivity, paramString);
                  ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X8008C0F", "0X8008C0F", 0, 0, "", "", "", "", false);
                  paramInt = n;
                }
                else if (n == 30)
                {
                  paramString = this.jdField_b_of_type_JavaUtilArrayList;
                  l2 = l1;
                  if (paramString != null)
                  {
                    l2 = l1;
                    if (this.jdField_e_of_type_Boolean)
                    {
                      paramString = paramString.iterator();
                      do
                      {
                        l2 = l1;
                        if (!paramString.hasNext()) {
                          break;
                        }
                        paramBundle = (IPublicAccountJavascriptInterface.ActionItem)paramString.next();
                      } while (paramBundle.jdField_a_of_type_Int != 1);
                      try
                      {
                        l2 = new JSONObject(paramBundle.jdField_b_of_type_JavaLangString).getLong("uin");
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
                  paramString.setComponent(new ComponentName(this.jdField_a_of_type_AndroidAppActivity, ChatActivity.class));
                  paramBundle.putString("uin", String.valueOf(l2));
                  paramBundle.putInt("uintype", 1008);
                  paramString.putExtras(paramBundle);
                  paramString.putExtra("is_come_from_readinjoy", true);
                  paramString.setFlags(67108864);
                  this.jdField_a_of_type_AndroidAppActivity.startActivity(paramString);
                  ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X8008C3B", "0X8008C3B", 0, 0, "", "", "", "", false);
                  paramInt = n;
                }
                else
                {
                  if ((n == 37) && (this.jdField_f_of_type_Boolean))
                  {
                    paramString = this.jdField_b_of_type_JavaUtilArrayList;
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
                      } while (paramBundle.jdField_a_of_type_Int != 1);
                      try
                      {
                        l2 = new JSONObject(paramBundle.jdField_b_of_type_JavaLangString).getLong("uin");
                      }
                      catch (JSONException paramString)
                      {
                        paramString.printStackTrace();
                        return;
                      }
                    }
                    paramString = AIOUtils.a(new Intent(this.jdField_a_of_type_AndroidAppActivity, SplashActivity.class), null);
                    paramBundle = new StringBuilder();
                    paramBundle.append(l2);
                    paramBundle.append("");
                    paramString.putExtra("uin", paramBundle.toString());
                    paramString.putExtra("uintype", 0);
                    this.jdField_a_of_type_AndroidAppActivity.startActivity(paramString);
                    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X8008C11", "0X8008C11", 0, 0, "", "", "", "", false);
                    return;
                  }
                  if (n == 31)
                  {
                    paramString = this.jdField_b_of_type_JavaUtilArrayList;
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
                      } while (paramBundle.jdField_a_of_type_Int != 2);
                      try
                      {
                        l2 = new JSONObject(paramBundle.jdField_b_of_type_JavaLangString).getLong("puin");
                      }
                      catch (JSONException paramString)
                      {
                        paramString.printStackTrace();
                        return;
                      }
                    }
                    paramString = new ActivityURIRequest(this.jdField_a_of_type_AndroidAppActivity, "/pubaccount/detail");
                    paramBundle = paramString.extra();
                    localObject1 = new StringBuilder();
                    ((StringBuilder)localObject1).append(l2);
                    ((StringBuilder)localObject1).append("");
                    paramBundle.putString("uin", ((StringBuilder)localObject1).toString());
                    paramString.extra().putBoolean("from_js", true);
                    QRoute.startUri(paramString, null);
                    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X8008C47", "0X8008C47", 0, 0, "", "", "", "", false);
                    paramInt = n;
                  }
                  else if (n == 38)
                  {
                    this.jdField_a_of_type_ComTencentBizWebviewpluginShare.d();
                    paramInt = n;
                  }
                  else if (n == 68)
                  {
                    TeamWorkConvertUtils.a(1, ((IPublicAccountProxy)QRoute.api(IPublicAccountProxy.class)).isPublicAccountBrowser(this.jdField_a_of_type_AndroidAppActivity) ^ true);
                    paramBundle = d();
                    paramString = paramBundle;
                    if (paramBundle == null) {
                      paramString = this.jdField_i_of_type_JavaLangString;
                    }
                    paramBundle = this.jdField_a_of_type_ComTencentBizWebviewpluginShare;
                    if (paramBundle == null) {
                      paramBundle = str1;
                    } else {
                      paramBundle = paramBundle.a();
                    }
                    TeamWorkConvertUtils.a(paramString, paramBundle);
                    paramInt = n;
                  }
                  else if (n == 70)
                  {
                    paramString = ((QQBrowserActivity)this.jdField_a_of_type_AndroidAppActivity).getWebColorNoteInjector();
                    paramInt = n;
                    if (paramString != null)
                    {
                      paramString.a();
                      paramInt = n;
                    }
                  }
                  else
                  {
                    paramInt = n;
                    if (n == 71)
                    {
                      ReportController.b(null, "dc00898", "", "", "0X800A9A4", "0X800A9A4", 0, 0, "1", "", "", "");
                      ScreenShotUtil.a(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserComponentsProvider$SwiftBrowserComponentContext.a(), new SwiftBrowserShareMenuHandler.3(this));
                      paramInt = n;
                    }
                  }
                }
              }
            }
            else
            {
              if (n == 19) {
                paramInt = 6;
              } else {
                paramInt = 7;
              }
              if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizWebviewpluginShare.p))
              {
                this.jdField_a_of_type_ComTencentBizWebviewpluginShare.a(paramString, paramInt, false);
                paramInt = n;
              }
              else
              {
                this.jdField_a_of_type_ComTencentBizWebviewpluginShare.a(paramString, paramInt, true);
                paramInt = n;
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
            if (n == 9) {
              ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).reportPAShareItemEvent(1003, paramBundle, this.jdField_f_of_type_Int);
            } else {
              ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).reportPAShareItemEvent(1004, paramBundle, this.jdField_f_of_type_Int);
            }
            if (!WXShareHelper.a().a()) {
              paramInt = 2131720478;
            } else if (!WXShareHelper.a().b()) {
              paramInt = 2131720479;
            }
            if (paramInt != -1)
            {
              QRUtils.a(0, paramInt);
              paramInt = n;
            }
            else if (n == 9)
            {
              if (this.jdField_a_of_type_ComTencentBizWebviewpluginShare.a() != null)
              {
                this.jdField_a_of_type_ComTencentBizWebviewpluginShare.a().show();
                ThreadManager.excute(new SwiftBrowserShareMenuHandler.1(this, paramString, (String)localObject3, (String)localObject4, (String)localObject5), 128, null, false);
                paramInt = n;
              }
              else
              {
                a(paramString, (String)localObject3, (String)localObject4, (String)localObject5);
                paramInt = n;
              }
            }
            else if ((this.jdField_a_of_type_ComTencentBizWebviewpluginShare.a() != null) && (this.jdField_a_of_type_ComTencentBizWebviewpluginShare.a().jdField_a_of_type_Int == 0))
            {
              a(n, paramString);
              paramInt = n;
            }
            else
            {
              d(paramString);
              paramInt = n;
            }
          }
        }
        else
        {
          paramBundle = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserShareMenuHandler$ShareToFriendCallback;
          if (paramBundle != null)
          {
            paramBundle.a(paramString);
            paramInt = n;
          }
          else
          {
            if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment == null)
            {
              if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserComponentsProvider$SwiftBrowserComponentContext.a() != null)
              {
                paramBundle = (SwiftBrowserStatistics)this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserComponentsProvider$SwiftBrowserComponentContext.a().a(-2);
                if ((TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserComponentsProvider$SwiftBrowserComponentContext.a().getUrl())) || (paramBundle == null)) {
                  break label4142;
                }
                localObject3 = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserComponentsProvider$SwiftBrowserComponentContext.a().getUrl();
                if (TextUtils.isEmpty(paramBundle.jdField_c_of_type_JavaLangString)) {
                  break label4142;
                }
                if (!paramBundle.jdField_c_of_type_JavaLangString.equals(localObject3)) {
                  if (!paramBundle.jdField_c_of_type_JavaLangString.equals(paramString)) {
                    break label4142;
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
              paramBundle = (SwiftBrowserStatistics)this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserComponentsProvider$SwiftBrowserComponentContext.a().a(-2);
              if ((TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.getWebView().getUrl())) || (paramBundle == null)) {
                break label4142;
              }
              localObject3 = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.getWebView().getUrl();
              if ((TextUtils.isEmpty(paramBundle.jdField_c_of_type_JavaLangString)) || ((!paramBundle.jdField_c_of_type_JavaLangString.equals(localObject3)) && (!paramBundle.jdField_c_of_type_JavaLangString.equals(paramString)))) {
                break label4142;
              }
            }
            bool = true;
            break label4145;
            label4142:
            bool = false;
            label4145:
            this.jdField_a_of_type_ComTencentBizWebviewpluginShare.jdField_g_of_type_Boolean = bool;
            if (QLog.isColorLevel()) {
              QLog.d("SwiftBrowserShareMenuHandler", 2, new Object[] { "ShareArkFromH5 mShare.isShareArk=", Boolean.valueOf(this.jdField_a_of_type_ComTencentBizWebviewpluginShare.jdField_g_of_type_Boolean), ",\n shareUrl=", Util.b(paramString, new String[0]) });
            }
            if ((n == 72) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizWebviewpluginShare.r))) {
              this.jdField_a_of_type_ComTencentBizWebviewpluginShare.a(i2, (String)localObject8, (String)localObject9);
            }
            a(paramString, (String)localObject1, (String)localObject2);
            paramInt = n;
          }
        }
      }
    }
    label4252:
    a(paramInt);
  }
  
  public void a(long paramLong)
  {
    ((SwiftBrowserStatistics)this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserComponentsProvider$SwiftBrowserComponentContext.a().a(-2)).jdField_a_of_type_Long = paramLong;
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
    Object localObject = this.jdField_a_of_type_AndroidAppActivity;
    if (localObject != null)
    {
      if (((Activity)localObject).isFinishing()) {
        return;
      }
      localObject = this.jdField_i_of_type_JavaLangString;
      WebViewFragment localWebViewFragment = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment;
      if (localWebViewFragment != null) {
        localObject = localWebViewFragment.getRedirect302Url();
      }
      ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).reportPAShareButtonEvent((String)localObject);
      this.jdField_a_of_type_ComTencentBizWebviewpluginShare = paramShare;
      this.jdField_a_of_type_Long = paramLong;
      d();
      e();
      a();
      if (this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder = new ShareActionSheetBuilder(this.jdField_a_of_type_AndroidAppActivity, false, 2);
        this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.setIntentForStartForwardRecentActivity(a());
      }
      paramShare = null;
      localObject = (SwiftBrowserScreenShotHandler)this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserComponentsProvider$SwiftBrowserComponentContext.a().a(64);
      if (localObject != null) {
        paramShare = ((SwiftBrowserScreenShotHandler)localObject).a();
      }
      localObject = (SwiftBrowserStatistics)this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserComponentsProvider$SwiftBrowserComponentContext.a().a(-2);
      if ((this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment != null) && (localObject != null)) {
        if (((SwiftBrowserStatistics)localObject).l)
        {
          paramShare = new StringBuilder();
          paramShare.append("<font color='#777777'>应用由 </font><font color='#00a5e0'>");
          paramShare.append(this.jdField_e_of_type_JavaLangString);
          paramShare.append("</font><font color='#777777'> 提供</font>");
          paramShare = paramShare.toString();
          this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.setActionSheetTitle(Html.fromHtml(paramShare));
          paramShare = new StringBuilder();
          paramShare.append("");
          paramShare.append(this.jdField_e_of_type_Int);
          paramShare = paramShare.toString();
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("");
          ((StringBuilder)localObject).append(this.jdField_d_of_type_Int);
          ReportController.b(null, "P_CliOper", "Grp_open", "", "third_app", "exp_menu", 0, 1, 0, paramShare, ((StringBuilder)localObject).toString(), "", "");
        }
        else if (!TextUtils.isEmpty(paramShare))
        {
          this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.setActionSheetTitle(paramShare);
        }
        else
        {
          this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.setActionSheetTitle(BaseApplicationImpl.getApplication().getString(2131718993));
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.setActionSheetItems(a());
      this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.setItemClickListenerV2(this);
      this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.setOnDismissListener(this);
      paramShare = this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder;
      int i1 = 8;
      int n;
      if (paramBoolean1) {
        n = 0;
      } else {
        n = 8;
      }
      if (paramBoolean2) {
        i1 = 0;
      }
      paramShare.setRowVisibility(n, 0, i1);
      try
      {
        this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.show();
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
      if ((this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment != null) && (this.jdField_a_of_type_Int == 1008))
      {
        paramShare = d();
        localObject = paramShare;
        if (paramShare == null) {
          localObject = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.getUrl();
        }
        if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
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
        ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005F78", "0X8005F78", 0, 0, this.jdField_a_of_type_JavaLangString, (String)localObject, this.jdField_b_of_type_JavaLangString, paramShare, false);
      }
      if (this.jdField_f_of_type_Boolean)
      {
        ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X8008CAA", "0X8008CAA", 0, 0, "", "", "", "", false);
        return;
      }
      if (this.jdField_e_of_type_Boolean) {
        ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X8008CAB", "0X8008CAB", 0, 0, "", "", "", "", false);
      }
    }
  }
  
  public void a(SwiftBrowserShareMenuHandler.ShareToFriendCallback paramShareToFriendCallback)
  {
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserShareMenuHandler$ShareToFriendCallback = paramShareToFriendCallback;
  }
  
  public void a(String paramString)
  {
    this.jdField_i_of_type_JavaLangString = paramString;
  }
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    if (TextUtils.isEmpty(paramString2)) {
      paramString2 = paramString3;
    }
    ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).reportPAShareItemEvent(1001, paramString2, this.jdField_f_of_type_Int);
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizWebviewpluginShare.p)) {
      this.jdField_a_of_type_ComTencentBizWebviewpluginShare.a(paramString1, 1, false);
    } else if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizWebviewpluginShare.q)) {
      this.jdField_a_of_type_ComTencentBizWebviewpluginShare.e();
    } else if (this.jdField_a_of_type_ComTencentBizWebviewpluginShare.a != null) {
      paramString2 = new JSONObject();
    }
    try
    {
      paramString2.put("type", 0);
      label109:
      DoraemonUtil.b(this.jdField_a_of_type_ComTencentBizWebviewpluginShare.a, paramString2);
      this.jdField_a_of_type_ComTencentBizWebviewpluginShare.a(paramString1, 1, false);
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
    this.k = paramBoolean;
  }
  
  public boolean a()
  {
    boolean bool = false;
    this.jdField_a_of_type_Boolean = false;
    if (((SwiftBrowserUIStyleHandler)this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserComponentsProvider$SwiftBrowserComponentContext.a().a(2)).a.jdField_e_of_type_Boolean) {
      return false;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserComponentsProvider$SwiftBrowserComponentContext.a() != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserComponentsProvider$SwiftBrowserComponentContext.a();
      int n = WebView.getTbsCoreVersion(BaseApplicationImpl.getContext());
      if ((n > 0) && (n < 36201))
      {
        this.jdField_a_of_type_Boolean = false;
        return this.jdField_a_of_type_Boolean;
      }
    }
    if (Build.VERSION.SDK_INT >= 14) {
      bool = true;
    }
    this.jdField_a_of_type_Boolean = bool;
    return this.jdField_a_of_type_Boolean;
  }
  
  public boolean a(String paramString)
  {
    String str = this.jdField_a_of_type_ComTencentBizWebviewpluginShare.getShareUrl();
    boolean bool3 = TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizWebviewpluginShare.a());
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (!bool3)
    {
      bool1 = bool2;
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizWebviewpluginShare.b()))
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
  
  public List<ShareActionSheetBuilder.ActionSheetItem>[] a()
  {
    ArrayList localArrayList1 = new ArrayList();
    Object localObject1 = (SwiftBrowserStatistics)this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserComponentsProvider$SwiftBrowserComponentContext.a().a(-2);
    if ((this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment != null) && (localObject1 != null) && (((SwiftBrowserStatistics)localObject1).l))
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
    if ((localObject1 != null) && (!TextUtils.isEmpty(((AppRuntime)localObject1).getAccount())) && (this.jdField_h_of_type_Boolean) && (!localIPublicAccountH5AbilityPlugin.contains(this.jdField_a_of_type_JavaUtilArrayList, "menuItem:share:diandian")) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizWebviewpluginShare.p))) {
      localArrayList1.add(ShareActionSheetBuilder.ActionSheetItem.build(34));
    }
    if ((localObject1 != null) && (!TextUtils.isEmpty(((AppRuntime)localObject1).getAccount())) && (!localIPublicAccountH5AbilityPlugin.contains(this.jdField_a_of_type_JavaUtilArrayList, "menuItem:share:qq")) && ((this.jdField_a_of_type_Long & 0x8) == 0L)) {
      localArrayList1.add(ShareActionSheetBuilder.ActionSheetItem.build(2));
    }
    if (QFileAssistantUtils.a()) {
      localArrayList1.add(ShareActionSheetBuilder.ActionSheetItem.build(26));
    }
    if ((localObject1 != null) && (!TextUtils.isEmpty(((AppRuntime)localObject1).getAccount())) && (!localIPublicAccountH5AbilityPlugin.contains(this.jdField_a_of_type_JavaUtilArrayList, "menuItem:share:QZone")) && ((this.jdField_a_of_type_Long & 0x10) == 0L)) {
      localArrayList1.add(ShareActionSheetBuilder.ActionSheetItem.build(3));
    }
    if (((this.jdField_a_of_type_Long & 0x8000000) != 0L) && (((IReadInJoyHelper)QRoute.api(IReadInJoyHelper.class)).isOSVersionSupportReadInJoy()) && (!localIPublicAccountH5AbilityPlugin.contains(this.jdField_a_of_type_JavaUtilArrayList, "menuItem:share:kandian")) && (localObject1 != null))
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
    if ((localObject1 != null) && (!TextUtils.isEmpty(((AppRuntime)localObject1).getAccount())) && (!localIPublicAccountH5AbilityPlugin.contains(this.jdField_a_of_type_JavaUtilArrayList, "menuItem:share:appMessage")) && ((this.jdField_a_of_type_Long & 0x4000) == 0L)) {
      localArrayList1.add(ShareActionSheetBuilder.ActionSheetItem.build(9));
    }
    if ((localObject1 != null) && (!TextUtils.isEmpty(((AppRuntime)localObject1).getAccount())) && (!localIPublicAccountH5AbilityPlugin.contains(this.jdField_a_of_type_JavaUtilArrayList, "menuItem:share:timeline")) && ((this.jdField_a_of_type_Long & 0x8000) == 0L)) {
      localArrayList1.add(ShareActionSheetBuilder.ActionSheetItem.build(10));
    }
    Object localObject2 = this.jdField_a_of_type_AndroidAppActivity.getIntent();
    int n;
    if ((localObject2 != null) && (((Intent)localObject2).getBooleanExtra("use_wei_bo_sdk", false))) {
      n = 1;
    } else {
      n = 0;
    }
    if (((n != 0) || (this.jdField_g_of_type_Boolean)) && (!localIPublicAccountH5AbilityPlugin.contains(this.jdField_a_of_type_JavaUtilArrayList, "menuItem:share:sinaWeibo"))) {
      localArrayList1.add(ShareActionSheetBuilder.ActionSheetItem.build(12));
    }
    if ((!localIPublicAccountH5AbilityPlugin.contains(this.jdField_a_of_type_JavaUtilArrayList, "menuItem:openWithQQBrowser")) && ((this.jdField_a_of_type_Long & 0x200) == 0L)) {
      localArrayList1.add(ShareActionSheetBuilder.ActionSheetItem.build(5));
    }
    if ((!localIPublicAccountH5AbilityPlugin.contains(this.jdField_a_of_type_JavaUtilArrayList, "menuItem:openWithSafari")) && ((this.jdField_a_of_type_Long & 0x100) == 0L)) {
      localArrayList1.add(ShareActionSheetBuilder.ActionSheetItem.build(4));
    }
    localObject2 = BaseApplicationImpl.getApplication().getPackageManager();
    if ((!localIPublicAccountH5AbilityPlugin.contains(this.jdField_a_of_type_JavaUtilArrayList, "menuItem:share:qiDian")) && ((0x10 & this.jdField_a_of_type_Long) == 0L)) {
      QidianManager.a(this.jdField_a_of_type_AndroidAppActivity, localArrayList1);
    }
    if ((!localIPublicAccountH5AbilityPlugin.contains(this.jdField_a_of_type_JavaUtilArrayList, "menuItem:share:qiYeQQ")) && ((this.jdField_a_of_type_Long & 0x20) == 0L) && (new Intent().setPackage("com.tencent.eim").setData(Uri.parse("eimapi://")).resolveActivity((PackageManager)localObject2) != null)) {
      localArrayList1.add(ShareActionSheetBuilder.ActionSheetItem.build(20));
    }
    ArrayList localArrayList2 = new ArrayList();
    Object localObject3;
    if (this.k)
    {
      localObject3 = (QQBrowserActivity)this.jdField_a_of_type_AndroidAppActivity;
      localObject2 = ((QQBrowserActivity)localObject3).getOriginalUrl();
      localObject3 = ((QQBrowserActivity)localObject3).getWebColorNoteInjector();
      if ((localObject3 != null) && (((IWebColorNoteInject)localObject3).a((String)localObject2)))
      {
        boolean bool = ((IWebColorNoteInject)localObject3).c();
        localObject3 = ShareActionSheetBuilder.ActionSheetItem.build(70);
        localObject2 = BaseApplicationImpl.getApplication();
        if (!bool) {
          n = 2131718931;
        } else {
          n = 2131690894;
        }
        ((ShareActionSheetBuilder.ActionSheetItem)localObject3).label = ((BaseApplicationImpl)localObject2).getString(n);
        if (!bool) {
          n = 2130846525;
        } else {
          n = 2130846534;
        }
        ((ShareActionSheetBuilder.ActionSheetItem)localObject3).icon = n;
        if (ThemeImageWrapper.isNightMode())
        {
          if (!bool) {
            n = 2130846526;
          } else {
            n = 2130846535;
          }
          ((ShareActionSheetBuilder.ActionSheetItem)localObject3).icon = n;
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
    if (this.jdField_e_of_type_Boolean)
    {
      localObject2 = this.jdField_b_of_type_JavaUtilArrayList;
      if (localObject2 != null)
      {
        localObject2 = ((ArrayList)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (IPublicAccountJavascriptInterface.ActionItem)((Iterator)localObject2).next();
          localActionSheetItem = ShareActionSheetBuilder.ActionSheetItem.build(30);
          n = ((IPublicAccountJavascriptInterface.ActionItem)localObject3).jdField_a_of_type_Int;
          if (n != 1)
          {
            if (n == 2) {
              localArrayList2.add(ShareActionSheetBuilder.ActionSheetItem.build(31));
            }
          }
          else
          {
            if (TextUtils.isEmpty(((IPublicAccountJavascriptInterface.ActionItem)localObject3).jdField_a_of_type_JavaLangString)) {
              localActionSheetItem.label = BaseApplicationImpl.getApplication().getString(2131695194);
            } else {
              localActionSheetItem.label = ((IPublicAccountJavascriptInterface.ActionItem)localObject3).jdField_a_of_type_JavaLangString;
            }
            localArrayList2.add(localActionSheetItem);
          }
        }
      }
    }
    if (this.jdField_f_of_type_Boolean)
    {
      localObject2 = this.jdField_b_of_type_JavaUtilArrayList;
      if (localObject2 != null)
      {
        localObject2 = ((ArrayList)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (IPublicAccountJavascriptInterface.ActionItem)((Iterator)localObject2).next();
          localActionSheetItem = ShareActionSheetBuilder.ActionSheetItem.build(37);
          n = ((IPublicAccountJavascriptInterface.ActionItem)localObject3).jdField_a_of_type_Int;
          if (n != 1)
          {
            if (n == 3) {
              localArrayList2.add(ShareActionSheetBuilder.ActionSheetItem.build(35));
            }
          }
          else
          {
            if (TextUtils.isEmpty(((IPublicAccountJavascriptInterface.ActionItem)localObject3).jdField_a_of_type_JavaLangString)) {
              localActionSheetItem.label = BaseApplicationImpl.getApplication().getString(2131695194);
            } else {
              localActionSheetItem.label = ((IPublicAccountJavascriptInterface.ActionItem)localObject3).jdField_a_of_type_JavaLangString;
            }
            localArrayList2.add(localActionSheetItem);
          }
        }
      }
    }
    localObject2 = (SwiftBrowserScreenShotHandler)this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserComponentsProvider$SwiftBrowserComponentContext.a().a(64);
    if ((localObject2 != null) && (((SwiftBrowserScreenShotHandler)localObject2).a()) && (!localIPublicAccountH5AbilityPlugin.contains(this.jdField_a_of_type_JavaUtilArrayList, "menuItem:screenShotShare"))) {
      localArrayList2.add(ShareActionSheetBuilder.ActionSheetItem.build(21));
    }
    if ((localObject1 != null) && (!TextUtils.isEmpty(((AppRuntime)localObject1).getAccount())) && (!localIPublicAccountH5AbilityPlugin.contains(this.jdField_a_of_type_JavaUtilArrayList, "menuItem:favorite")) && ((this.jdField_a_of_type_Long & 0x2000) == 0L)) {
      localArrayList2.add(ShareActionSheetBuilder.ActionSheetItem.build(6));
    }
    if (this.m) {
      localArrayList2.add(ShareActionSheetBuilder.ActionSheetItem.build(129));
    }
    if ((localObject1 != null) && (!TextUtils.isEmpty(((AppRuntime)localObject1).getAccount())) && (!localIPublicAccountH5AbilityPlugin.contains(this.jdField_a_of_type_JavaUtilArrayList, "menuItem:exportTencentDocs")) && ((((SwiftBrowserUIStyleHandler)this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserComponentsProvider$SwiftBrowserComponentContext.a().a(2)).a.jdField_b_of_type_Long & 0x4000) == 0L))
    {
      localObject2 = d();
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = this.jdField_i_of_type_JavaLangString;
      }
      if (TeamWorkConvertUtils.a((String)localObject1))
      {
        localArrayList2.add(ShareActionSheetBuilder.ActionSheetItem.build(68));
        TeamWorkConvertUtils.a(0, 1);
      }
    }
    if ((!localIPublicAccountH5AbilityPlugin.contains(this.jdField_a_of_type_JavaUtilArrayList, "menuItem:setFont")) && (!this.jdField_c_of_type_Boolean) && (this.jdField_a_of_type_Boolean)) {
      localArrayList2.add(ShareActionSheetBuilder.ActionSheetItem.build(7));
    }
    if ((!localIPublicAccountH5AbilityPlugin.contains(this.jdField_a_of_type_JavaUtilArrayList, "menuItem:copyUrl")) && ((this.jdField_a_of_type_Long & 0x20) == 0L)) {
      localArrayList2.add(ShareActionSheetBuilder.ActionSheetItem.build(1));
    }
    if (((TextUtils.isEmpty(this.jdField_i_of_type_JavaLangString)) || (!"docs.qq.com".equals(Uri.parse(this.jdField_i_of_type_JavaLangString).getHost()))) && (!localIPublicAccountH5AbilityPlugin.contains(this.jdField_a_of_type_JavaUtilArrayList, "menuItem:screenLongShotShare")) && ((this.jdField_a_of_type_Long & 0x8000) == 0L) && (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserComponentsProvider$SwiftBrowserComponentContext != null) && (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserComponentsProvider$SwiftBrowserComponentContext.a() != null) && (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserComponentsProvider$SwiftBrowserComponentContext.a().getX5WebViewExtension() != null)) {
      localArrayList2.add(ShareActionSheetBuilder.ActionSheetItem.build(71));
    }
    if ((!localIPublicAccountH5AbilityPlugin.contains(this.jdField_a_of_type_JavaUtilArrayList, "menuItem:exposeArticle")) && (this.jdField_b_of_type_Boolean)) {
      localArrayList2.add(ShareActionSheetBuilder.ActionSheetItem.build(11));
    }
    return (List[])new ArrayList[] { localArrayList1, localArrayList2 };
  }
  
  public String b()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewApiIFontSizePanel = ((IFontSizePanelBuilderFactory)QRoute.api(IFontSizePanelBuilderFactory.class)).createFontSizePanelBuilder(this.jdField_a_of_type_AndroidAppActivity.getLayoutInflater()).a(this).a(this.jdField_b_of_type_Int).a().a(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserComponentsProvider$SwiftBrowserComponentContext.a());
  }
  
  @TargetApi(14)
  public void b(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserComponentsProvider$SwiftBrowserComponentContext.a() != null)
    {
      if (this.jdField_d_of_type_Boolean) {
        return;
      }
      Object localObject = jdField_a_of_type_ArrayOfInt;
      if ((paramInt < localObject.length) && (paramInt >= 0))
      {
        this.jdField_b_of_type_Int = paramInt;
        int n = localObject[paramInt];
        this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserComponentsProvider$SwiftBrowserComponentContext.a().getSettings().setTextZoom(n);
        localObject = this.jdField_a_of_type_ComTencentBizWebviewpluginShare;
        if (localObject != null) {
          ((Share)localObject).a(paramInt, n);
        }
        return;
      }
      QLog.d("SwiftBrowserShareMenuHandler", 2, new Object[] { "adjustFontSize fontSizeIndex=", Integer.valueOf(paramInt) });
    }
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_g_of_type_Boolean = paramBoolean;
  }
  
  public boolean b()
  {
    return this.jdField_g_of_type_Boolean;
  }
  
  public String c()
  {
    return this.jdField_c_of_type_JavaLangString;
  }
  
  public void c()
  {
    if (a())
    {
      TroopMemberApiClient localTroopMemberApiClient = this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient;
      if (localTroopMemberApiClient != null) {
        localTroopMemberApiClient.a(this.jdField_c_of_type_Int);
      }
      this.jdField_c_of_type_Int = a().b(new SwiftBrowserShareMenuHandler.6(this));
      return;
    }
    b(1);
  }
  
  public void c(boolean paramBoolean)
  {
    this.jdField_h_of_type_Boolean = paramBoolean;
  }
  
  public boolean c()
  {
    return this.jdField_h_of_type_Boolean;
  }
  
  public String d()
  {
    Share localShare = this.jdField_a_of_type_ComTencentBizWebviewpluginShare;
    if (localShare == null) {
      return "";
    }
    return localShare.getShareUrl();
  }
  
  public void d(boolean paramBoolean)
  {
    this.jdField_i_of_type_Boolean = paramBoolean;
  }
  
  public boolean d()
  {
    return this.j;
  }
  
  public void e(boolean paramBoolean)
  {
    this.j = paramBoolean;
  }
  
  public void onChange(int paramInt1, int paramInt2)
  {
    if (paramInt1 == paramInt2) {
      return;
    }
    b(paramInt2);
    a().a(this.jdField_b_of_type_Int);
  }
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if ((this.jdField_a_of_type_Long & 0x20000) != 0L)
    {
      paramDialogInterface = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment;
      if (paramDialogInterface != null) {
        WebViewUIUtils.b(paramDialogInterface.getActivity());
      }
    }
    paramDialogInterface = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment;
    if ((paramDialogInterface != null) && (paramDialogInterface.getUIStyleHandler() != null) && ((this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.getHostActivity() instanceof TeamWorkDocEditBrowserActivity)) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.getUrl())) && (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.getUrl().contains("sheet"))) {
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.getUIStyleHandler().i();
    }
    try
    {
      if ((this.jdField_a_of_type_ComTencentBizWebviewpluginShare != null) && (this.jdField_a_of_type_ComTencentBizWebviewpluginShare.a() != null)) {
        this.jdField_a_of_type_ComTencentBizWebviewpluginShare.a().dismiss();
      }
    }
    catch (Throwable paramDialogInterface)
    {
      QLog.e("SwiftBrowserShareMenuHandler", 1, paramDialogInterface, new Object[0]);
    }
    if ((this.jdField_a_of_type_AndroidOsBundle != null) && (QLog.isColorLevel())) {
      QLog.d("SwiftBrowserShareMenuHandler", 2, "onDismiss() called don't clear mExtraParams for time sequence problems");
    }
  }
  
  public void onItemClick(ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem, ShareActionSheet paramShareActionSheet)
  {
    if (paramActionSheetItem == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.dismiss();
    a(paramActionSheetItem.action, paramActionSheetItem);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.component.SwiftBrowserShareMenuHandler
 * JD-Core Version:    0.7.0.1
 */