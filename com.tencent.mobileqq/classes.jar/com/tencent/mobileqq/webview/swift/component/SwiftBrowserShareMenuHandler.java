package com.tencent.mobileqq.webview.swift.component;

import akpw;
import akpx;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.ClipboardManager;
import android.text.Html;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.PopupWindow;
import com.tencent.biz.common.util.Util;
import com.tencent.biz.pubaccount.AccountDetailActivity;
import com.tencent.biz.pubaccount.PublicAccountJavascriptInterface.ActionItem;
import com.tencent.biz.pubaccount.PublicAccountReportUtils;
import com.tencent.biz.pubaccount.util.PublicAccountH5AbilityPlugin;
import com.tencent.biz.pubaccount.util.PublicAccountUtil;
import com.tencent.biz.qrcode.util.QRUtils;
import com.tencent.biz.troop.TroopMemberApiClient;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.biz.webviewplugin.Share;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.AddFriendLogicActivity;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomArkDialog.AppInfo;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItemViewHolder;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.open.agent.report.ReportCenter;
import com.tencent.open.base.MD5Utils;
import com.tencent.qidian.QidianManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.stat.MttLoader;
import com.tencent.widget.RangeButtonView;
import com.tencent.widget.RangeButtonView.OnChangeListener;
import com.tencent.widget.RangeButtonView.Title;
import cooperation.readinjoy.ReadInJoyHelper;
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
  implements DialogInterface.OnDismissListener, AdapterView.OnItemClickListener, RangeButtonView.OnChangeListener
{
  public static final int[] a;
  public static long b;
  public int a;
  public long a;
  public Activity a;
  public PopupWindow a;
  TroopMemberApiClient a;
  public Share a;
  public ShareActionSheetBuilder a;
  public WebViewFragment a;
  public String a;
  public final ArrayList a;
  public boolean a;
  public int b;
  public String b;
  public ArrayList b;
  public boolean b;
  private int c;
  public String c;
  public boolean c;
  private int jdField_d_of_type_Int;
  public String d;
  boolean jdField_d_of_type_Boolean = false;
  private int jdField_e_of_type_Int;
  private String jdField_e_of_type_JavaLangString;
  public boolean e;
  public boolean f;
  private boolean g;
  private boolean h;
  private boolean i;
  
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
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_c_of_type_JavaLangString = "";
    this.jdField_d_of_type_JavaLangString = "";
    this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient = null;
    this.jdField_b_of_type_Int = 1;
  }
  
  private void e()
  {
    if (a(this.jdField_a_of_type_ComTencentBizWebviewpluginShare.a())) {
      if (QLog.isColorLevel()) {
        QLog.d("SwiftBrowserShareMenuHandler", 2, "is not need load share js..");
      }
    }
    String str;
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("SwiftBrowserShareMenuHandler", 2, "loadShareJs");
      }
      a(System.currentTimeMillis());
      int k = com.tencent.mobileqq.webprocess.WebAccelerateHelper.getInstance().getWebViewFeatureParams()[2].intValue();
      int j = k;
      if (k < 0) {
        j = 190;
      }
      str = String.format("function callShare(){\"loading\"==document.readyState?window.addEventListener(\"load\",sharePageInfo(),!1):sharePageInfo()}var readStyleProp=function(a,b){var c,d;return b?(b=b.toLowerCase(),a.style&&a.style[b]?c=a.style[b]:a.currentStyle?(b=b.replace(/\\-([a-z])([a-z]?)/gi,function(a,b,c){return b.toUpperCase()+c.toLowerCase()}),c=a.currentStyle[b]):document.defaultView&&document.defaultView.getComputedStyle&&(d=document.defaultView.getComputedStyle(a,null),c=d.getPropertyValue(b)),-1!=c.indexOf(\"px\")&&(c=c.replace(/(px)/i,\"\")),c):void 0},parsePageInfo=function(){var b,c,d,e,f,g,h,i,j,k,l,a={};for(a[\"shareURL\"]=document.documentURI,b=\"\",c=\"\",d=document.getElementsByTagName(\"meta\"),f=0;f<d.length;f++)e=d[f],!a.title&&e.getAttribute(\"itemprop\")&&\"name\"==e.getAttribute(\"itemprop\").toLowerCase()&&void 0!=e.content&&\"\"!=e.content&&(a[\"title\"]=e.content),a.summary||\"description\"!=e.name||void 0!=e.content&&\"\"!=e.content&&(b=e.content),!a.summary&&e.getAttribute(\"itemprop\")&&\"description\"==e.getAttribute(\"itemprop\").toLowerCase()&&void 0!=e.content&&\"\"!=e.content&&(c=e.content),!a.image&&e.getAttribute(\"itemprop\")&&\"image\"==e.getAttribute(\"itemprop\").toLowerCase()&&void 0!=e.content&&\"\"!=e.content&&(a[\"image\"]=e.content);if(\"\"!=c?a[\"summary\"]=c:\"\"!=b&&(a[\"summary\"]=b),!a.image)for(g=document.getElementsByTagName(\"img\"),h=%d,i=%d,f=0;f<g.length&&30>f;f++)if(j=g[f],(j.src.startsWith(\"//\")||j.src.startsWith(\"http://\")||j.src.startsWith(\"https://\"))&&(k=j.width,l=j.height,void 0!=j.naturalWidth&&void 0!=j.naturalHeight&&(k=j.naturalWidth,l=j.naturalHeight),k>=h&&10*h>k&&l>=i&&10*i>l&&\"none\"!=readStyleProp(j,\"display\")&&\"hidden\"!=readStyleProp(j,\"visibility\"))){a[\"image\"]=j.src,a.image.startsWith(\"//\")&&(a.image=(document.documentURI.startsWith(\"http:\")?\"http:\":\"https:\")+a.image);break}return a},sharePageInfo=function(){var a,c,d,e;try{a=parsePageInfo()}catch(b){}a||(a=new object),a[\"type\"]=\"share\",a[\"callback\"]=1,c=JSON.stringify(a),d=\"jsbridge://share/setShare?p=\"+encodeURIComponent(c),e=document.createElement(\"iframe\"),e.style.cssText=\"display:none;width:0px;height:0px;\",(document.documentElement||document.body).appendChild(e),e.src=d};callShare();", new Object[] { Integer.valueOf(j), Integer.valueOf(j) });
    } while (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserComponentsProvider$SwiftBrowserComponentContext.a() == null);
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserComponentsProvider$SwiftBrowserComponentContext.a().loadUrl("javascript:" + str + ";");
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
    if (this.jdField_a_of_type_ComTencentBizWebviewpluginShare == null) {
      return "";
    }
    return this.jdField_a_of_type_ComTencentBizWebviewpluginShare.a();
  }
  
  public void a()
  {
    Object localObject = this.jdField_a_of_type_AndroidAppActivity.getIntent();
    if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment != null) {
      localObject = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.a();
    }
    this.jdField_e_of_type_JavaLangString = ((Intent)localObject).getStringExtra("url");
    if (this.jdField_e_of_type_JavaLangString == null)
    {
      this.jdField_e_of_type_JavaLangString = ((Intent)localObject).getStringExtra("key_params_qq");
      if (this.jdField_e_of_type_JavaLangString == null) {
        this.jdField_e_of_type_JavaLangString = "";
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
      ((Bundle)localObject).getBoolean("isOpeningQunApp");
      this.jdField_c_of_type_Int = ((Bundle)localObject).getInt("appid");
      this.jdField_d_of_type_Int = ((Bundle)localObject).getInt("troopid");
      if (((Bundle)localObject).getString("extraParams") == null) {}
      this.jdField_e_of_type_Int = ((Bundle)localObject).getInt("articalChannelId", 100);
    }
  }
  
  public void a(int paramInt)
  {
    Object localObject1 = a();
    Object localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = this.jdField_e_of_type_JavaLangString;
    }
    localObject1 = "";
    Object localObject3 = Uri.parse((String)localObject2);
    if ((!"article.mp.qq.com".equalsIgnoreCase(((Uri)localObject3).getHost())) && (!"post.mp.qq.com".equalsIgnoreCase(((Uri)localObject3).getHost()))) {
      return;
    }
    try
    {
      localObject3 = ((Uri)localObject3).getQueryParameter("article_id");
      localObject1 = localObject3;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
      ReportController.b(null, "dc01160", "Pb_account_lifeservice", "", "0X8007C04", "0X8007C04", 0, 1, 0, localException, (String)localObject2, "1001", "");
      return;
    }
    localObject3 = localObject1;
    if (localObject1 == null) {
      localObject3 = "";
    }
    switch (paramInt)
    {
    case 13: 
    case 14: 
    case 15: 
    case 16: 
    case 17: 
    case 18: 
    case 19: 
    case 20: 
    default: 
      return;
    case 1: 
      ReportController.b(null, "dc01160", "Pb_account_lifeservice", "", "0X8007C04", "0X8007C04", 0, 1, 0, (String)localObject3, (String)localObject2, "1011", "");
      return;
    case 2: 
    case 3: 
      ReportController.b(null, "dc01160", "Pb_account_lifeservice", "", "0X8007C04", "0X8007C04", 0, 1, 0, localException, (String)localObject2, "1002", "");
      return;
    case 9: 
      ReportController.b(null, "dc01160", "Pb_account_lifeservice", "", "0X8007C04", "0X8007C04", 0, 1, 0, localException, (String)localObject2, "1003", "");
      return;
    case 10: 
      ReportController.b(null, "dc01160", "Pb_account_lifeservice", "", "0X8007C04", "0X8007C04", 0, 1, 0, localException, (String)localObject2, "1004", "");
      return;
    case 5: 
      ReportController.b(null, "dc01160", "Pb_account_lifeservice", "", "0X8007C04", "0X8007C04", 0, 1, 0, localException, (String)localObject2, "1005", "");
      return;
    case 4: 
      ReportController.b(null, "dc01160", "Pb_account_lifeservice", "", "0X8007C04", "0X8007C04", 0, 1, 0, localException, (String)localObject2, "1006", "");
      return;
    case 6: 
      ReportController.b(null, "dc01160", "Pb_account_lifeservice", "", "0X8007C04", "0X8007C04", 0, 1, 0, localException, (String)localObject2, "1007", "");
      return;
    case 11: 
      ReportController.b(null, "dc01160", "Pb_account_lifeservice", "", "0X8007C04", "0X8007C04", 0, 1, 0, localException, (String)localObject2, "1008", "");
      return;
    case 8: 
      ReportController.b(null, "dc01160", "Pb_account_lifeservice", "", "0X8007C04", "0X8007C04", 0, 1, 0, localException, (String)localObject2, "1009", "");
      return;
    case 7: 
      ReportController.b(null, "dc01160", "Pb_account_lifeservice", "", "0X8007C04", "0X8007C04", 0, 1, 0, localException, (String)localObject2, "1010", "");
      return;
    case 12: 
      ReportController.b(null, "dc01160", "Pb_account_lifeservice", "", "0X8007C04", "0X8007C04", 0, 1, 0, localException, (String)localObject2, "1012", "");
      return;
    }
    ReportController.b(null, "dc01160", "Pb_account_lifeservice", "", "0X8007C04", "0X8007C04", 0, 1, 0, localException, (String)localObject2, "1013", "");
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (paramInt1 == paramInt2) {
      return;
    }
    b(paramInt2);
    a().a(this.jdField_b_of_type_Int);
  }
  
  public void a(int paramInt, Bundle paramBundle)
  {
    super.a(paramInt, paramBundle);
    switch (paramInt)
    {
    }
    do
    {
      do
      {
        return;
        this.jdField_d_of_type_Boolean = true;
        if (this.jdField_a_of_type_AndroidWidgetPopupWindow != null)
        {
          this.jdField_a_of_type_AndroidWidgetPopupWindow.dismiss();
          this.jdField_a_of_type_AndroidWidgetPopupWindow = null;
        }
        if (this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient != null) {
          this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.b();
        }
        this.jdField_a_of_type_JavaUtilArrayList.clear();
        return;
      } while ((paramBundle == null) || (paramBundle.getInt("state_machine_step", -1) != 1));
      d();
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder != null) {
        this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.e();
      }
    } while ((this.jdField_a_of_type_AndroidWidgetPopupWindow == null) || (!this.jdField_a_of_type_AndroidWidgetPopupWindow.isShowing()));
    this.jdField_a_of_type_AndroidWidgetPopupWindow.dismiss();
    c();
  }
  
  @TargetApi(12)
  public void a(int paramInt, String paramString, Bundle paramBundle)
  {
    String str6 = "";
    String str5;
    String str4;
    String str3;
    String str2;
    String str1;
    int k;
    int j;
    if (paramBundle != null)
    {
      str5 = paramBundle.getString("qq", "");
      str4 = paramBundle.getString("public_uin", "");
      str3 = paramBundle.getString("source_public_uin", "");
      str2 = paramBundle.getString("default_url", "");
      str1 = paramBundle.getString("msg_id", "");
      k = paramBundle.getInt("troop_app_id", 0);
      j = paramBundle.getInt("troop_id", 0);
      str6 = paramBundle.getString("troop_app_info_url", "");
      paramBundle.getInt("uin_type", 0);
    }
    for (;;)
    {
      Object localObject3 = this.jdField_e_of_type_JavaLangString;
      Object localObject4 = null;
      Object localObject1 = localObject4;
      String str8;
      Object localObject5;
      if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment != null)
      {
        str8 = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.jdField_d_of_type_JavaLangString;
        localObject5 = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.a();
        localObject1 = localObject4;
        localObject3 = str8;
        if (localObject5 != null)
        {
          localObject1 = ((WebView)localObject5).getOriginalUrl();
          localObject3 = str8;
        }
      }
      localObject4 = paramString;
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        localObject4 = paramString;
        if (((String)localObject1).equals(paramString)) {}
      }
      try
      {
        localObject4 = Uri.parse((String)localObject1);
        localObject5 = ((Uri)localObject4).getHost();
        str8 = null;
        if (((Uri)localObject4).isHierarchical()) {
          str8 = ((Uri)localObject4).getQueryParameter("_pflag");
        }
        localObject4 = paramString;
        if (!TextUtils.isEmpty(str8)) {
          if (!"post.mp.qq.com".equalsIgnoreCase((String)localObject5))
          {
            localObject4 = paramString;
            if (!"url.cn".equalsIgnoreCase((String)localObject5)) {}
          }
          else
          {
            int m = Integer.parseInt(str8);
            localObject4 = paramString;
            if ((m >> 3 & 0x1) == 1) {
              localObject4 = localObject1;
            }
          }
        }
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          label853:
          label1645:
          label1662:
          String str7 = paramString;
          label1573:
          label1905:
          continue;
          label2697:
          long l1 = 0L;
          continue;
          l1 = 0L;
          continue;
          l1 = 0L;
          continue;
          Object localObject2 = localObject3;
          continue;
          localObject2 = localObject3;
          continue;
          label3766:
          j = 0;
        }
      }
      if (paramInt == 1)
      {
        ((ClipboardManager)this.jdField_a_of_type_AndroidAppActivity.getSystemService("clipboard")).setText((CharSequence)localObject4);
        QRUtils.a(2, 2131430005);
        if ((this.i) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizWebviewpluginShare.l))) {
          this.jdField_a_of_type_ComTencentBizWebviewpluginShare.e();
        }
      }
      for (;;)
      {
        a(paramInt);
        return;
        if (paramInt == 11)
        {
          paramString = Pattern.compile("(http|https)://.*.mp.qq.com.*").matcher((CharSequence)localObject4);
          j = 0;
          if (paramString.matches()) {
            j = 1;
          }
          paramBundle = null;
          try
          {
            paramString = URLEncoder.encode((String)localObject4, "UTF-8");
            if (j != 0)
            {
              localObject3 = String.valueOf(NetConnInfoCenter.getServerTime());
              localObject1 = MD5Utils.b(paramString + 200 + (String)localObject3 + "jubao@article@123");
              paramBundle = (Bundle)localObject1;
              if (localObject1 != null)
              {
                paramBundle = (Bundle)localObject1;
                if (!((String)localObject1).isEmpty()) {
                  paramBundle = ((String)localObject1).toLowerCase();
                }
              }
              paramString = "https://post.mp.qq.com/jubao/index?qq=" + str5 + "&mp_uin=" + str4 + "&scene=200&sub_appname=article_webview&timestamp=" + (String)localObject3 + "&sign=" + paramBundle + "&article_url=" + paramString + "&_wv=3";
              paramBundle = new Intent(this.jdField_a_of_type_AndroidAppActivity, QQBrowserActivity.class);
              paramBundle.putExtra("url", paramString);
              paramBundle.putExtra("hide_more_button", true);
              this.jdField_a_of_type_AndroidAppActivity.startActivity(paramBundle);
              ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "mp_msg_webview_67", "jvbao_click", 0, 1, 0, "", "", "", "");
              if ((str3 == null) || ("".equals(str3))) {
                continue;
              }
              PublicAccountReportUtils.a(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005B07", "0X8005B07", 1008, 0, str3, str1, str2, AccountDetailActivity.a(str2), false);
            }
          }
          catch (UnsupportedEncodingException paramString)
          {
            for (;;)
            {
              paramString = paramBundle;
              if (QLog.isColorLevel())
              {
                QLog.d("SwiftBrowserShareMenuHandler", 2, "encode shareUrl failed, because UTF-8 is unknown");
                paramString = paramBundle;
                continue;
                paramString = "http://guanjia.qq.com/online_server/m_report.html?shareUrl=" + paramString + "&qq=" + str5 + "&_wv=7";
              }
            }
          }
        }
        else if (paramInt == 2)
        {
          if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment == null) {
            throw new InvalidParameterException("ACTION_REFRESH_FREIEND_VIEW should be handled by QQBrowserActivity!");
          }
          paramString = (SwiftBrowserStatistics)this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserComponentsProvider$SwiftBrowserComponentContext.a().a(-2);
          if ((!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.jdField_a_of_type_ComTencentBizUiTouchWebView.getUrl())) && (paramString != null) && (!TextUtils.isEmpty(paramString.jdField_b_of_type_JavaLangString))) {
            if (TextUtils.isEmpty((CharSequence)localObject3))
            {
              if (!((String)localObject4).equals(paramString.jdField_b_of_type_JavaLangString)) {}
            }
            else
            {
              for (j = 1;; j = 1)
              {
                if (j == 0) {
                  break label853;
                }
                b((String)localObject4, (String)localObject3, (String)localObject1);
                break;
                if ((TextUtils.isEmpty((CharSequence)localObject1)) || (!((String)localObject1).equals(paramString.jdField_b_of_type_JavaLangString))) {
                  break label3766;
                }
              }
              a((String)localObject4, (String)localObject3, (String)localObject1);
            }
          }
        }
        else
        {
          if (paramInt == 4)
          {
            paramString = new Intent("android.intent.action.VIEW", Uri.parse((String)localObject4));
            paramString.putExtra("normal", true);
            try
            {
              this.jdField_a_of_type_AndroidAppActivity.startActivity(paramString);
              ReportController.b(null, "P_CliOper", "VIPCOMIC", "", "0X800619F", "0X800619F", 1000, 0, Util.b(str2, new String[0]), null, null, null);
              ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "mp_msg_webview_48", "browser_share", 0, 1, 0, "", "", "", "");
              if ((str3 == null) || ("".equals(str3))) {
                continue;
              }
              PublicAccountReportUtils.a(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005B07", "0X8005B07", 1006, 0, str3, str1, str2, AccountDetailActivity.a(str2), false);
            }
            catch (ActivityNotFoundException paramString)
            {
              for (;;)
              {
                QRUtils.a(1, 2131430028);
              }
            }
          }
          if (paramInt == 5)
          {
            if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment != null)
            {
              if (!TextUtils.isEmpty((CharSequence)localObject4))
              {
                paramString = new HashMap();
                paramString.put("KEY_PID", String.valueOf(50079));
                paramString.put("KEY_EUSESTAT", String.valueOf(5));
                paramString.put("ChannelID", BaseApplicationImpl.getContext().getApplicationInfo().processName);
                paramString.put("PosID", Integer.toString(0));
                paramBundle = MttLoader.getValidQBUrl(BaseApplicationImpl.getContext(), (String)localObject4);
                j = MttLoader.loadUrl(BaseApplicationImpl.getContext(), paramBundle, paramString, null);
                if ((4 == j) || (5 == j) || (j != 0))
                {
                  paramString = (SwiftBrowserTBSHandler)this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserComponentsProvider$SwiftBrowserComponentContext.a().a(16);
                  if (paramString != null) {
                    paramString.a("http://mdc.html5.qq.com/d/directdown.jsp?channel_id=10367", true);
                  }
                }
              }
              ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "mp_msg_webview_46", "qqbrowser_share", 0, 1, 0, "", "", "", "");
              ReportController.b(null, "P_CliOper", "VIPCOMIC", "", "0X80061A0", "0X80061A0", 1000, 0, Util.b(str2, new String[0]), null, null, null);
              if ((str3 == null) || ("".equals(str3))) {
                continue;
              }
              PublicAccountReportUtils.a(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005B07", "0X8005B07", 1005, 0, str3, str1, str2, AccountDetailActivity.a(str2), false);
              continue;
            }
            throw new InvalidParameterException("ACTION_OPEN_IN_QQ_BROWSER should be handled by QQBrowserActivity!");
          }
          if (paramInt == 3)
          {
            jdField_b_of_type_Long = System.currentTimeMillis();
            if (TextUtils.isEmpty((CharSequence)localObject3))
            {
              PublicAccountUtil.a(1002, (String)localObject1, this.jdField_e_of_type_Int);
              if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizWebviewpluginShare.l)) {
                this.jdField_a_of_type_ComTencentBizWebviewpluginShare.a((String)localObject4, 2, false);
              }
              for (;;)
              {
                ReportCenter.a().a("", "", "", "1000", "102", "0", false);
                ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "mp_msg_webview_44", "qzone_share", 0, 1, 0, "", "", "", "");
                break;
                if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizWebviewpluginShare.n)) {
                  this.jdField_a_of_type_ComTencentBizWebviewpluginShare.g();
                } else {
                  this.jdField_a_of_type_ComTencentBizWebviewpluginShare.a();
                }
              }
            }
          }
          else
          {
            if (paramInt == 6)
            {
              if (this.jdField_a_of_type_ComTencentBizWebviewpluginShare.a((String)localObject4)) {
                this.jdField_a_of_type_ComTencentBizWebviewpluginShare.a((String)localObject4, 9, false);
              }
              if ((str3 == null) || ("".equals(str3))) {
                continue;
              }
              PublicAccountReportUtils.a(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005B07", "0X8005B07", 1007, 0, str3, str1, str2, AccountDetailActivity.a(str2), false);
              continue;
            }
            if ((paramInt == 9) || (paramInt == 10))
            {
              j = -1;
              if (TextUtils.isEmpty((CharSequence)localObject3))
              {
                if (paramInt == 9)
                {
                  PublicAccountUtil.a(1003, (String)localObject1, this.jdField_e_of_type_Int);
                  if (WXShareHelper.a().a()) {
                    break label1645;
                  }
                  j = 2131435319;
                }
                for (;;)
                {
                  if (j == -1) {
                    break label1662;
                  }
                  QRUtils.a(0, j);
                  if (paramInt != 9) {
                    break label1905;
                  }
                  ReportCenter.a().a("", "", "", "1000", "103", "0", false);
                  break;
                  PublicAccountUtil.a(1004, (String)localObject1, this.jdField_e_of_type_Int);
                  break label1573;
                  if (!WXShareHelper.a().b()) {
                    j = 2131435320;
                  }
                }
                if (paramInt == 9)
                {
                  if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizWebviewpluginShare.l)) {
                    this.jdField_a_of_type_ComTencentBizWebviewpluginShare.a((String)localObject4, 3, true);
                  }
                  for (;;)
                  {
                    ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "mp_msg_webview_40", "weixin_share", 0, 1, 0, "", "", "", "");
                    if ((str3 == null) || ("".equals(str3))) {
                      break;
                    }
                    PublicAccountReportUtils.a(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005B07", "0X8005B07", 1003, 0, str3, str1, str2, AccountDetailActivity.a(str2), false);
                    break;
                    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizWebviewpluginShare.o)) {
                      this.jdField_a_of_type_ComTencentBizWebviewpluginShare.h();
                    } else {
                      this.jdField_a_of_type_ComTencentBizWebviewpluginShare.a((String)localObject4, 3, true);
                    }
                  }
                }
                if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizWebviewpluginShare.l)) {
                  this.jdField_a_of_type_ComTencentBizWebviewpluginShare.a((String)localObject4, 4, true);
                }
                for (;;)
                {
                  ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "mp_msg_webview_42", "pengyouquan_share", 0, 1, 0, "", "", "", "");
                  break;
                  if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizWebviewpluginShare.p)) {
                    this.jdField_a_of_type_ComTencentBizWebviewpluginShare.i();
                  } else {
                    this.jdField_a_of_type_ComTencentBizWebviewpluginShare.a((String)localObject4, 4, true);
                  }
                }
                if (paramInt != 10) {
                  continue;
                }
                ReportCenter.a().a("", "", "", "1000", "104", "0", false);
              }
            }
            else
            {
              if (paramInt == 13)
              {
                this.jdField_a_of_type_ComTencentBizWebviewpluginShare.a((String)localObject4, 5, true);
                continue;
              }
              if (paramInt == 15)
              {
                if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment == null) {
                  throw new InvalidParameterException("ACTION_ADD_TROOP_APP should be handled by QQBrowserActivity!");
                }
                if (!NetworkUtil.d(BaseApplicationImpl.getContext()))
                {
                  QQToast.a(BaseApplicationImpl.getContext(), 2, 2131433192, 0).b(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.b());
                  return;
                }
                a().a(k, new akpw(this));
                ReportController.b(null, "P_CliOper", "Grp_open", "", "third_app", "add_menu", 0, 1, 0, "" + j, "" + k, "", "");
                continue;
              }
              if (paramInt == 16)
              {
                paramString = new Intent(this.jdField_a_of_type_AndroidAppActivity, QQBrowserActivity.class);
                paramString.putExtra("url", str6);
                paramString.putExtra("hide_operation_bar", true);
                paramString.putExtra("hide_more_button", true);
                this.jdField_a_of_type_AndroidAppActivity.startActivity(paramString);
                ReportController.b(null, "P_CliOper", "Grp_open", "", "third_app", "detail_menu", 0, 1, 0, "" + j, "" + k, "", "");
                continue;
              }
              if (paramInt == 17)
              {
                paramString = "";
                if (paramBundle != null) {
                  paramString = paramBundle.getString("troop_app_share_url", "");
                }
                paramBundle = new Intent(this.jdField_a_of_type_AndroidAppActivity, QQBrowserActivity.class);
                paramBundle.putExtra("url", paramString);
                paramBundle.putExtra("hide_operation_bar", true);
                paramBundle.putExtra("hide_more_button", true);
                this.jdField_a_of_type_AndroidAppActivity.startActivity(paramBundle);
                ReportController.b(null, "P_CliOper", "Grp_open", "", "third_app", "share_menu", 0, 1, 0, "" + j, "" + k, "", "");
                continue;
              }
              if (paramInt == 18)
              {
                if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment == null) {
                  throw new InvalidParameterException("ACTION_REFRESH_TROOP_APP_VIEW should be handled by QQBrowserActivity!");
                }
                paramString = (SwiftBrowserStatistics)this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserComponentsProvider$SwiftBrowserComponentContext.a().a(-2);
                if ((!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.jdField_a_of_type_ComTencentBizUiTouchWebView.getUrl())) && (paramString != null))
                {
                  this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics.jdField_d_of_type_Boolean = false;
                  paramString.n = System.currentTimeMillis();
                  this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.jdField_a_of_type_ComTencentBizUiTouchWebView.reload();
                  this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.jdField_a_of_type_ComTencentBizUiTouchWebView.setOnCustomScrollChangeListener(null);
                  paramString.a(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.jdField_a_of_type_ComTencentBizUiTouchWebView, this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.jdField_a_of_type_ComTencentBizUiTouchWebView.getUrl(), 1, 0, 0, 0, 0, null);
                }
                for (;;)
                {
                  ReportController.b(null, "P_CliOper", "Grp_open", "", "third_app", "refresh_menu", 0, 1, 0, "" + j, "" + k, "", "");
                  break;
                  paramBundle = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.b();
                  if ((!TextUtils.isEmpty(paramBundle)) && (paramString != null))
                  {
                    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics.jdField_d_of_type_Boolean = false;
                    paramString.n = System.currentTimeMillis();
                    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.jdField_a_of_type_ComTencentBizUiTouchWebView.loadUrl(paramBundle);
                    paramString.a(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.jdField_a_of_type_ComTencentBizUiTouchWebView, paramBundle, 1, 0, 0, 0, 0, null);
                  }
                }
              }
              if (paramInt == 7)
              {
                c();
                continue;
              }
              if ((paramInt == 19) || (paramInt == 20))
              {
                if (paramInt == 19) {}
                for (j = 6;; j = 7)
                {
                  if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizWebviewpluginShare.l)) {
                    break label2697;
                  }
                  this.jdField_a_of_type_ComTencentBizWebviewpluginShare.a((String)localObject4, j, false);
                  break;
                }
                this.jdField_a_of_type_ComTencentBizWebviewpluginShare.a((String)localObject4, j, true);
                continue;
              }
              if (paramInt == 21)
              {
                paramString = (SwiftBrowserScreenShotHandler)this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserComponentsProvider$SwiftBrowserComponentContext.a().a(64);
                if (paramString != null) {
                  paramString.a(null, null, 2);
                }
                paramString = "";
                paramBundle = Uri.parse(this.jdField_e_of_type_JavaLangString);
                try
                {
                  paramBundle = paramBundle.getQueryParameter("article_id");
                  paramString = paramBundle;
                }
                catch (Exception paramBundle)
                {
                  for (;;)
                  {
                    paramBundle.printStackTrace();
                  }
                }
                paramBundle = paramString;
                if (paramString == null) {
                  paramBundle = "";
                }
                PublicAccountReportUtils.a(null, "", "0X8007071", "0X8007071", 0, 0, paramBundle, "", "", "");
                PublicAccountReportUtils.a("0X8007071", "", paramBundle, "", "", "");
                continue;
              }
              if (paramInt == 12)
              {
                if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizWebviewpluginShare.l)) {
                  this.jdField_a_of_type_ComTencentBizWebviewpluginShare.a((String)localObject4, 8, false);
                }
                for (;;)
                {
                  paramBundle = this.jdField_e_of_type_JavaLangString;
                  if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserComponentsProvider$SwiftBrowserComponentContext.a() != null) {
                    paramBundle = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserComponentsProvider$SwiftBrowserComponentContext.a().getUrl();
                  }
                  paramString = "";
                  localObject1 = Uri.parse(paramBundle);
                  try
                  {
                    localObject1 = ((Uri)localObject1).getQueryParameter("article_id");
                    paramString = (String)localObject1;
                  }
                  catch (Exception localException1)
                  {
                    for (;;)
                    {
                      localException1.printStackTrace();
                    }
                  }
                  localObject1 = paramString;
                  if (paramString == null) {
                    localObject1 = "";
                  }
                  PublicAccountReportUtils.a(null, "", "0X800787A", "0X800787A", 0, 0, (String)localObject1, paramBundle, "", "");
                  PublicAccountUtil.a(1005, paramBundle, this.jdField_e_of_type_Int);
                  break;
                  this.jdField_a_of_type_ComTencentBizWebviewpluginShare.a((String)localObject4, 8, false);
                }
              }
              if (paramInt == 34)
              {
                if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizWebviewpluginShare.l))
                {
                  this.jdField_a_of_type_ComTencentBizWebviewpluginShare.d();
                  continue;
                }
                if (!QLog.isColorLevel()) {
                  continue;
                }
                QLog.d("diandian", 2, "dian dian is here");
                continue;
              }
              if (paramInt == 35)
              {
                long l2 = 0L;
                paramBundle = null;
                l1 = l2;
                paramString = paramBundle;
                if (this.jdField_b_of_type_JavaUtilArrayList != null)
                {
                  localObject2 = this.jdField_b_of_type_JavaUtilArrayList.iterator();
                  do
                  {
                    l1 = l2;
                    paramString = paramBundle;
                    if (!((Iterator)localObject2).hasNext()) {
                      break;
                    }
                    paramString = (PublicAccountJavascriptInterface.ActionItem)((Iterator)localObject2).next();
                  } while (paramString.jdField_a_of_type_Int != 3);
                }
                try
                {
                  paramString = new JSONObject(paramString.jdField_b_of_type_JavaLangString);
                  l1 = paramString.getLong("uin");
                  paramString = paramString.optString("name");
                  paramString = AddFriendLogicActivity.a(this.jdField_a_of_type_AndroidAppActivity, 1, l1 + "", null, 3001, 3999, paramString, null, null, null, null);
                  this.jdField_a_of_type_AndroidAppActivity.startActivity(paramString);
                  PublicAccountReportUtils.a(null, "", "0X8008C0F", "0X8008C0F", 0, 0, "", "", "", "", false);
                }
                catch (JSONException paramString)
                {
                  paramString.printStackTrace();
                  return;
                }
              }
              if (paramInt == 30)
              {
                if ((this.jdField_b_of_type_JavaUtilArrayList != null) && (this.jdField_e_of_type_Boolean))
                {
                  paramString = this.jdField_b_of_type_JavaUtilArrayList.iterator();
                  do
                  {
                    if (!paramString.hasNext()) {
                      break;
                    }
                    paramBundle = (PublicAccountJavascriptInterface.ActionItem)paramString.next();
                  } while (paramBundle.jdField_a_of_type_Int != 1);
                  try
                  {
                    l1 = new JSONObject(paramBundle.jdField_b_of_type_JavaLangString).getLong("uin");
                    paramString = new Intent();
                    paramBundle = new Bundle();
                    paramString.setComponent(new ComponentName(this.jdField_a_of_type_AndroidAppActivity, ChatActivity.class));
                    paramBundle.putString("uin", String.valueOf(l1));
                    paramBundle.putInt("uintype", 1008);
                    paramString.putExtras(paramBundle);
                    paramString.putExtra("is_come_from_readinjoy", true);
                    paramString.setFlags(67108864);
                    this.jdField_a_of_type_AndroidAppActivity.startActivity(paramString);
                    PublicAccountReportUtils.a(null, "", "0X8008C3B", "0X8008C3B", 0, 0, "", "", "", "", false);
                  }
                  catch (JSONException paramString)
                  {
                    paramString.printStackTrace();
                    return;
                  }
                }
              }
              else if ((paramInt == 37) && (this.f))
              {
                if (this.jdField_b_of_type_JavaUtilArrayList != null) {
                  paramString = this.jdField_b_of_type_JavaUtilArrayList.iterator();
                }
              }
              else {
                for (;;)
                {
                  if (paramString.hasNext())
                  {
                    paramBundle = (PublicAccountJavascriptInterface.ActionItem)paramString.next();
                    if (paramBundle.jdField_a_of_type_Int == 1)
                    {
                      try
                      {
                        l1 = new JSONObject(paramBundle.jdField_b_of_type_JavaLangString).getLong("uin");
                        paramString = AIOUtils.a(new Intent(this.jdField_a_of_type_AndroidAppActivity, SplashActivity.class), null);
                        paramString.putExtra("uin", l1 + "");
                        paramString.putExtra("uintype", 0);
                        this.jdField_a_of_type_AndroidAppActivity.startActivity(paramString);
                        PublicAccountReportUtils.a(null, "", "0X8008C11", "0X8008C11", 0, 0, "", "", "", "", false);
                        return;
                      }
                      catch (JSONException paramString)
                      {
                        paramString.printStackTrace();
                        return;
                      }
                      if (paramInt != 31) {
                        break;
                      }
                      if (this.jdField_b_of_type_JavaUtilArrayList != null)
                      {
                        paramString = this.jdField_b_of_type_JavaUtilArrayList.iterator();
                        for (;;)
                        {
                          if (paramString.hasNext())
                          {
                            paramBundle = (PublicAccountJavascriptInterface.ActionItem)paramString.next();
                            if (paramBundle.jdField_a_of_type_Int == 2) {
                              try
                              {
                                l1 = new JSONObject(paramBundle.jdField_b_of_type_JavaLangString).getLong("puin");
                                paramString = new Intent(this.jdField_a_of_type_AndroidAppActivity, AccountDetailActivity.class);
                                paramString.putExtra("uin", l1 + "");
                                paramString.putExtra("from_js", true);
                                this.jdField_a_of_type_AndroidAppActivity.startActivity(paramString);
                                PublicAccountReportUtils.a(null, "", "0X8008C47", "0X8008C47", 0, 0, "", "", "", "", false);
                              }
                              catch (JSONException paramString)
                              {
                                paramString.printStackTrace();
                                return;
                              }
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
      j = 0;
      k = 0;
      str1 = "";
      str2 = "";
      str3 = "";
      str4 = "";
      str5 = "";
    }
  }
  
  public void a(long paramLong)
  {
    ((SwiftBrowserStatistics)this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserComponentsProvider$SwiftBrowserComponentContext.a().a(-2)).jdField_a_of_type_Long = paramLong;
  }
  
  public void a(Share paramShare, long paramLong)
  {
    if (paramShare == null) {}
    label284:
    do
    {
      for (;;)
      {
        return;
        if ((this.jdField_a_of_type_AndroidAppActivity != null) && (!this.jdField_a_of_type_AndroidAppActivity.isFinishing()))
        {
          Object localObject1 = this.jdField_e_of_type_JavaLangString;
          if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment != null) {
            localObject1 = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.jdField_d_of_type_JavaLangString;
          }
          PublicAccountUtil.a((String)localObject1);
          this.jdField_a_of_type_ComTencentBizWebviewpluginShare = paramShare;
          this.jdField_a_of_type_Long = paramLong;
          a();
          e();
          a();
          if (this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder == null) {
            this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder = new ShareActionSheetBuilder(this.jdField_a_of_type_AndroidAppActivity);
          }
          paramShare = null;
          localObject1 = (SwiftBrowserScreenShotHandler)this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserComponentsProvider$SwiftBrowserComponentContext.a().a(64);
          if (localObject1 != null) {
            paramShare = ((SwiftBrowserScreenShotHandler)localObject1).a();
          }
          localObject1 = (SwiftBrowserStatistics)this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserComponentsProvider$SwiftBrowserComponentContext.a().a(-2);
          if ((this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment != null) && (localObject1 != null))
          {
            if (((SwiftBrowserStatistics)localObject1).i)
            {
              paramShare = "<font color='#777777'>应用由 </font><font color='#00a5e0'>" + this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.n + "</font><font color='#777777'> 提供</font>";
              this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.a(Html.fromHtml(paramShare));
              ReportController.b(null, "P_CliOper", "Grp_open", "", "third_app", "exp_menu", 0, 1, 0, "" + this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.jdField_j_of_type_Int, "" + this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.jdField_i_of_type_Int, "", "");
            }
          }
          else
          {
            this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.a(a());
            this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.a(this);
            this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.a(this);
          }
          try
          {
            this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.a();
            Object localObject2;
            if ((this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment != null) && (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.h == 1008))
            {
              paramShare = a();
              localObject1 = paramShare;
              if (paramShare == null) {
                localObject1 = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.g;
              }
              if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.jdField_i_of_type_JavaLangString))
              {
                paramShare = "";
                localObject2 = Uri.parse((String)localObject1);
              }
            }
            else
            {
              try
              {
                localObject2 = ((Uri)localObject2).getQueryParameter("article_id");
                paramShare = (Share)localObject2;
              }
              catch (Exception localException)
              {
                for (;;)
                {
                  localException.printStackTrace();
                }
              }
              localObject2 = paramShare;
              if (paramShare == null) {
                localObject2 = "";
              }
              PublicAccountReportUtils.a(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005F78", "0X8005F78", 0, 0, this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.jdField_i_of_type_JavaLangString, (String)localObject1, this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.jdField_j_of_type_JavaLangString, (String)localObject2, false);
              if (this.f)
              {
                PublicAccountReportUtils.a(null, "", "0X8008CAA", "0X8008CAA", 0, 0, "", "", "", "", false);
                return;
                if (!TextUtils.isEmpty(paramShare))
                {
                  this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.a(paramShare);
                  break label284;
                }
                this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.a(BaseApplicationImpl.getApplication().getString(2131433100));
              }
            }
          }
          catch (Exception paramShare)
          {
            for (;;)
            {
              if (QLog.isColorLevel()) {
                QLog.d("SwiftBrowserShareMenuHandler", 2, "actionSheet.show exception=" + paramShare);
              }
            }
          }
        }
      }
    } while (!this.jdField_e_of_type_Boolean);
    PublicAccountReportUtils.a(null, "", "0X8008CAB", "0X8008CAB", 0, 0, "", "", "", "", false);
  }
  
  public void a(String paramString)
  {
    this.jdField_e_of_type_JavaLangString = paramString;
  }
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    if (TextUtils.isEmpty(paramString2)) {}
    for (;;)
    {
      PublicAccountUtil.a(1001, paramString3, this.jdField_e_of_type_Int);
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizWebviewpluginShare.l)) {
        this.jdField_a_of_type_ComTencentBizWebviewpluginShare.a(paramString1, 1, false);
      }
      for (;;)
      {
        ReportCenter.a().a("", "", "", "1000", "101", "0", false);
        ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "mp_msg_webview_38", "qq_share", 0, 1, 0, "", "", "", "");
        return;
        if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizWebviewpluginShare.m)) {
          this.jdField_a_of_type_ComTencentBizWebviewpluginShare.f();
        } else {
          this.jdField_a_of_type_ComTencentBizWebviewpluginShare.a(paramString1, 1, false);
        }
      }
      paramString3 = paramString2;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.g = paramBoolean;
  }
  
  public boolean a()
  {
    this.jdField_a_of_type_Boolean = false;
    if (((SwiftBrowserUIStyleHandler)this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserComponentsProvider$SwiftBrowserComponentContext.a().a(2)).a.jdField_d_of_type_Boolean) {
      return false;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserComponentsProvider$SwiftBrowserComponentContext.a() != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserComponentsProvider$SwiftBrowserComponentContext.a();
      int j = WebView.getTbsCoreVersion(BaseApplicationImpl.getContext());
      if ((j > 0) && (j < 36201))
      {
        this.jdField_a_of_type_Boolean = false;
        return this.jdField_a_of_type_Boolean;
      }
    }
    if (Build.VERSION.SDK_INT >= 14) {}
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_Boolean = bool;
      return this.jdField_a_of_type_Boolean;
    }
  }
  
  public boolean a(String paramString)
  {
    boolean bool2 = false;
    String str = this.jdField_a_of_type_ComTencentBizWebviewpluginShare.a();
    boolean bool1 = bool2;
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizWebviewpluginShare.b()))
    {
      bool1 = bool2;
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizWebviewpluginShare.c()))
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
  
  public List[] a()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = (SwiftBrowserStatistics)this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserComponentsProvider$SwiftBrowserComponentContext.a().a(-2);
    if ((this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment != null) && (localObject1 != null) && (((SwiftBrowserStatistics)localObject1).i))
    {
      localObject1 = new ShareActionSheetBuilder.ActionSheetItem();
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).jdField_a_of_type_JavaLangString = BaseApplicationImpl.getApplication().getString(2131430784);
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).jdField_b_of_type_Int = 2130841265;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).jdField_c_of_type_Int = 15;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).jdField_b_of_type_JavaLangString = "";
      localArrayList.add(localObject1);
      localObject1 = new ShareActionSheetBuilder.ActionSheetItem();
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).jdField_a_of_type_JavaLangString = BaseApplicationImpl.getApplication().getString(2131430785);
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).jdField_b_of_type_Int = 2130841267;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).jdField_c_of_type_Int = 16;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).jdField_b_of_type_JavaLangString = "";
      localArrayList.add(localObject1);
      localObject1 = new ShareActionSheetBuilder.ActionSheetItem();
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).jdField_a_of_type_JavaLangString = BaseApplicationImpl.getApplication().getString(2131430786);
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).jdField_b_of_type_Int = 2130841270;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).jdField_c_of_type_Int = 17;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).jdField_b_of_type_JavaLangString = "";
      localArrayList.add(localObject1);
      localObject1 = new ShareActionSheetBuilder.ActionSheetItem();
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).jdField_a_of_type_JavaLangString = BaseApplicationImpl.getApplication().getString(2131430787);
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).jdField_b_of_type_Int = 2130841269;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).jdField_c_of_type_Int = 18;
      ((ShareActionSheetBuilder.ActionSheetItem)localObject1).jdField_b_of_type_JavaLangString = "";
      localArrayList.add(localObject1);
      return (List[])new ArrayList[] { localArrayList };
    }
    if (BaseApplicationImpl.getApplication().getRuntime() != null) {}
    for (localObject1 = BaseApplicationImpl.getApplication().getRuntime();; localObject1 = null)
    {
      if ((localObject1 != null) && (!TextUtils.isEmpty(((AppRuntime)localObject1).getAccount())) && (this.h) && (!PublicAccountH5AbilityPlugin.a(this.jdField_a_of_type_JavaUtilArrayList, "menuItem:share:diandian")) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizWebviewpluginShare.l)))
      {
        localObject2 = new ShareActionSheetBuilder.ActionSheetItem();
        ((ShareActionSheetBuilder.ActionSheetItem)localObject2).jdField_a_of_type_JavaLangString = BaseApplicationImpl.getApplication().getString(2131430138);
        ((ShareActionSheetBuilder.ActionSheetItem)localObject2).jdField_b_of_type_Int = 2130840673;
        ((ShareActionSheetBuilder.ActionSheetItem)localObject2).jdField_a_of_type_Boolean = true;
        ((ShareActionSheetBuilder.ActionSheetItem)localObject2).jdField_c_of_type_Int = 34;
        ((ShareActionSheetBuilder.ActionSheetItem)localObject2).jdField_b_of_type_JavaLangString = "";
        localArrayList.add(localObject2);
      }
      if ((localObject1 != null) && (!TextUtils.isEmpty(((AppRuntime)localObject1).getAccount())) && (!PublicAccountH5AbilityPlugin.a(this.jdField_a_of_type_JavaUtilArrayList, "menuItem:share:qq")) && ((this.jdField_a_of_type_Long & 0x8) == 0L))
      {
        localObject2 = new ShareActionSheetBuilder.ActionSheetItem();
        ((ShareActionSheetBuilder.ActionSheetItem)localObject2).jdField_a_of_type_JavaLangString = BaseApplicationImpl.getApplication().getString(2131430108);
        ((ShareActionSheetBuilder.ActionSheetItem)localObject2).jdField_b_of_type_Int = 2130838336;
        ((ShareActionSheetBuilder.ActionSheetItem)localObject2).jdField_a_of_type_Boolean = true;
        ((ShareActionSheetBuilder.ActionSheetItem)localObject2).jdField_c_of_type_Int = 2;
        ((ShareActionSheetBuilder.ActionSheetItem)localObject2).jdField_b_of_type_JavaLangString = "";
        localArrayList.add(localObject2);
      }
      if ((localObject1 != null) && (!TextUtils.isEmpty(((AppRuntime)localObject1).getAccount())) && (!PublicAccountH5AbilityPlugin.a(this.jdField_a_of_type_JavaUtilArrayList, "menuItem:share:QZone")) && ((this.jdField_a_of_type_Long & 0x10) == 0L))
      {
        localObject2 = new ShareActionSheetBuilder.ActionSheetItem();
        ((ShareActionSheetBuilder.ActionSheetItem)localObject2).jdField_a_of_type_JavaLangString = BaseApplicationImpl.getApplication().getString(2131430114);
        ((ShareActionSheetBuilder.ActionSheetItem)localObject2).jdField_b_of_type_Int = 2130838337;
        ((ShareActionSheetBuilder.ActionSheetItem)localObject2).jdField_a_of_type_Boolean = true;
        ((ShareActionSheetBuilder.ActionSheetItem)localObject2).jdField_c_of_type_Int = 3;
        ((ShareActionSheetBuilder.ActionSheetItem)localObject2).jdField_b_of_type_JavaLangString = "";
        localArrayList.add(localObject2);
      }
      if (((this.jdField_a_of_type_Long & 0x8000000) != 0L) && (ReadInJoyHelper.a()) && (!PublicAccountH5AbilityPlugin.a(this.jdField_a_of_type_JavaUtilArrayList, "menuItem:share:kandian")) && (localObject1 != null))
      {
        localObject2 = "readinjoy_" + ((AppRuntime)localObject1).getAccount() + "_" + 1;
        localObject2 = BaseApplicationImpl.getApplication().getSharedPreferences((String)localObject2, 4);
        if ((localObject2 != null) && (((SharedPreferences)localObject2).getBoolean("share_to_news", false)))
        {
          localObject2 = new ShareActionSheetBuilder.ActionSheetItem();
          ((ShareActionSheetBuilder.ActionSheetItem)localObject2).jdField_a_of_type_JavaLangString = BaseApplicationImpl.getApplication().getString(2131430128);
          ((ShareActionSheetBuilder.ActionSheetItem)localObject2).jdField_b_of_type_Int = 2130838335;
          ((ShareActionSheetBuilder.ActionSheetItem)localObject2).jdField_a_of_type_Boolean = true;
          ((ShareActionSheetBuilder.ActionSheetItem)localObject2).jdField_c_of_type_Int = 13;
          ((ShareActionSheetBuilder.ActionSheetItem)localObject2).jdField_b_of_type_JavaLangString = "";
          localArrayList.add(localObject2);
        }
      }
      if ((localObject1 != null) && (!TextUtils.isEmpty(((AppRuntime)localObject1).getAccount())) && (!PublicAccountH5AbilityPlugin.a(this.jdField_a_of_type_JavaUtilArrayList, "menuItem:share:appMessage")) && ((this.jdField_a_of_type_Long & 0x4000) == 0L))
      {
        localObject2 = new ShareActionSheetBuilder.ActionSheetItem();
        ((ShareActionSheetBuilder.ActionSheetItem)localObject2).jdField_a_of_type_JavaLangString = BaseApplicationImpl.getApplication().getString(2131430126);
        ((ShareActionSheetBuilder.ActionSheetItem)localObject2).jdField_b_of_type_Int = 2130838340;
        ((ShareActionSheetBuilder.ActionSheetItem)localObject2).jdField_c_of_type_Int = 9;
        ((ShareActionSheetBuilder.ActionSheetItem)localObject2).jdField_b_of_type_JavaLangString = "";
        localArrayList.add(localObject2);
      }
      if ((localObject1 != null) && (!TextUtils.isEmpty(((AppRuntime)localObject1).getAccount())) && (!PublicAccountH5AbilityPlugin.a(this.jdField_a_of_type_JavaUtilArrayList, "menuItem:share:timeline")) && ((this.jdField_a_of_type_Long & 0x8000) == 0L))
      {
        localObject2 = new ShareActionSheetBuilder.ActionSheetItem();
        ((ShareActionSheetBuilder.ActionSheetItem)localObject2).jdField_a_of_type_JavaLangString = BaseApplicationImpl.getApplication().getString(2131430127);
        ((ShareActionSheetBuilder.ActionSheetItem)localObject2).jdField_b_of_type_Int = 2130838334;
        ((ShareActionSheetBuilder.ActionSheetItem)localObject2).jdField_c_of_type_Int = 10;
        ((ShareActionSheetBuilder.ActionSheetItem)localObject2).jdField_b_of_type_JavaLangString = "";
        localArrayList.add(localObject2);
      }
      if ((this.g) && (!PublicAccountH5AbilityPlugin.a(this.jdField_a_of_type_JavaUtilArrayList, "menuItem:share:sinaWeibo")))
      {
        localObject2 = new ShareActionSheetBuilder.ActionSheetItem();
        ((ShareActionSheetBuilder.ActionSheetItem)localObject2).jdField_a_of_type_JavaLangString = BaseApplicationImpl.getApplication().getString(2131430132);
        ((ShareActionSheetBuilder.ActionSheetItem)localObject2).jdField_a_of_type_Boolean = true;
        ((ShareActionSheetBuilder.ActionSheetItem)localObject2).jdField_b_of_type_Int = 2130838339;
        ((ShareActionSheetBuilder.ActionSheetItem)localObject2).jdField_c_of_type_Int = 12;
        ((ShareActionSheetBuilder.ActionSheetItem)localObject2).jdField_b_of_type_JavaLangString = "";
        localArrayList.add(localObject2);
      }
      if ((!PublicAccountH5AbilityPlugin.a(this.jdField_a_of_type_JavaUtilArrayList, "menuItem:openWithQQBrowser")) && ((this.jdField_a_of_type_Long & 0x200) == 0L))
      {
        localObject2 = new ShareActionSheetBuilder.ActionSheetItem();
        ((ShareActionSheetBuilder.ActionSheetItem)localObject2).jdField_a_of_type_JavaLangString = BaseApplicationImpl.getApplication().getString(2131430113);
        ((ShareActionSheetBuilder.ActionSheetItem)localObject2).jdField_b_of_type_Int = 2130840675;
        ((ShareActionSheetBuilder.ActionSheetItem)localObject2).jdField_c_of_type_Int = 5;
        ((ShareActionSheetBuilder.ActionSheetItem)localObject2).jdField_b_of_type_JavaLangString = "";
        localArrayList.add(localObject2);
      }
      if ((!PublicAccountH5AbilityPlugin.a(this.jdField_a_of_type_JavaUtilArrayList, "menuItem:openWithSafari")) && ((this.jdField_a_of_type_Long & 0x100) == 0L))
      {
        localObject2 = new ShareActionSheetBuilder.ActionSheetItem();
        ((ShareActionSheetBuilder.ActionSheetItem)localObject2).jdField_a_of_type_JavaLangString = BaseApplicationImpl.getApplication().getString(2131430112);
        ((ShareActionSheetBuilder.ActionSheetItem)localObject2).jdField_a_of_type_Boolean = true;
        ((ShareActionSheetBuilder.ActionSheetItem)localObject2).jdField_b_of_type_Int = 2130840672;
        ((ShareActionSheetBuilder.ActionSheetItem)localObject2).jdField_c_of_type_Int = 4;
        ((ShareActionSheetBuilder.ActionSheetItem)localObject2).jdField_b_of_type_JavaLangString = "";
        localArrayList.add(localObject2);
      }
      Object localObject2 = BaseApplicationImpl.getApplication().getPackageManager();
      if ((!PublicAccountH5AbilityPlugin.a(this.jdField_a_of_type_JavaUtilArrayList, "menuItem:share:qiDian")) && ((this.jdField_a_of_type_Long & 0x10) == 0L)) {
        QidianManager.a(this.jdField_a_of_type_AndroidAppActivity, localArrayList);
      }
      if ((!PublicAccountH5AbilityPlugin.a(this.jdField_a_of_type_JavaUtilArrayList, "menuItem:share:qiYeQQ")) && ((this.jdField_a_of_type_Long & 0x20) == 0L) && (new Intent().setPackage("com.tencent.eim").setData(Uri.parse("eimapi://")).resolveActivity((PackageManager)localObject2) != null))
      {
        localObject2 = new ShareActionSheetBuilder.ActionSheetItem();
        ((ShareActionSheetBuilder.ActionSheetItem)localObject2).jdField_a_of_type_JavaLangString = BaseApplicationImpl.getApplication().getString(2131430131);
        ((ShareActionSheetBuilder.ActionSheetItem)localObject2).jdField_a_of_type_Boolean = true;
        ((ShareActionSheetBuilder.ActionSheetItem)localObject2).jdField_b_of_type_Int = 2130841716;
        ((ShareActionSheetBuilder.ActionSheetItem)localObject2).jdField_c_of_type_Int = 20;
        ((ShareActionSheetBuilder.ActionSheetItem)localObject2).jdField_b_of_type_JavaLangString = "";
        localArrayList.add(localObject2);
      }
      localObject2 = new ArrayList();
      Object localObject4;
      ShareActionSheetBuilder.ActionSheetItem localActionSheetItem;
      if ((this.jdField_e_of_type_Boolean) && (this.jdField_b_of_type_JavaUtilArrayList != null))
      {
        localObject3 = this.jdField_b_of_type_JavaUtilArrayList.iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localObject4 = (PublicAccountJavascriptInterface.ActionItem)((Iterator)localObject3).next();
          localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
          switch (((PublicAccountJavascriptInterface.ActionItem)localObject4).jdField_a_of_type_Int)
          {
          default: 
            break;
          case 1: 
            if (TextUtils.isEmpty(((PublicAccountJavascriptInterface.ActionItem)localObject4).jdField_a_of_type_JavaLangString)) {}
            for (localActionSheetItem.jdField_a_of_type_JavaLangString = BaseApplicationImpl.getApplication().getString(2131430016);; localActionSheetItem.jdField_a_of_type_JavaLangString = ((PublicAccountJavascriptInterface.ActionItem)localObject4).jdField_a_of_type_JavaLangString)
            {
              localActionSheetItem.jdField_b_of_type_Int = 2130840677;
              localActionSheetItem.jdField_a_of_type_Boolean = true;
              localActionSheetItem.jdField_c_of_type_Int = 30;
              localActionSheetItem.jdField_b_of_type_JavaLangString = "";
              ((ArrayList)localObject2).add(localActionSheetItem);
              break;
            }
          case 2: 
            localObject4 = new ShareActionSheetBuilder.ActionSheetItem();
            ((ShareActionSheetBuilder.ActionSheetItem)localObject4).jdField_a_of_type_JavaLangString = BaseApplicationImpl.getApplication().getString(2131430053);
            ((ShareActionSheetBuilder.ActionSheetItem)localObject4).jdField_b_of_type_Int = 2130840671;
            ((ShareActionSheetBuilder.ActionSheetItem)localObject4).jdField_a_of_type_Boolean = true;
            ((ShareActionSheetBuilder.ActionSheetItem)localObject4).jdField_c_of_type_Int = 31;
            ((ShareActionSheetBuilder.ActionSheetItem)localObject4).jdField_b_of_type_JavaLangString = "";
            ((ArrayList)localObject2).add(localObject4);
          }
        }
      }
      if ((this.f) && (this.jdField_b_of_type_JavaUtilArrayList != null))
      {
        localObject3 = this.jdField_b_of_type_JavaUtilArrayList.iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localObject4 = (PublicAccountJavascriptInterface.ActionItem)((Iterator)localObject3).next();
          localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
          switch (((PublicAccountJavascriptInterface.ActionItem)localObject4).jdField_a_of_type_Int)
          {
          case 2: 
          default: 
            break;
          case 1: 
            if (TextUtils.isEmpty(((PublicAccountJavascriptInterface.ActionItem)localObject4).jdField_a_of_type_JavaLangString)) {}
            for (localActionSheetItem.jdField_a_of_type_JavaLangString = BaseApplicationImpl.getApplication().getString(2131430016);; localActionSheetItem.jdField_a_of_type_JavaLangString = ((PublicAccountJavascriptInterface.ActionItem)localObject4).jdField_a_of_type_JavaLangString)
            {
              localActionSheetItem.jdField_b_of_type_Int = 2130840677;
              localActionSheetItem.jdField_a_of_type_Boolean = true;
              localActionSheetItem.jdField_c_of_type_Int = 37;
              localActionSheetItem.jdField_b_of_type_JavaLangString = "";
              ((ArrayList)localObject2).add(localActionSheetItem);
              break;
            }
          case 3: 
            localObject4 = new ShareActionSheetBuilder.ActionSheetItem();
            ((ShareActionSheetBuilder.ActionSheetItem)localObject4).jdField_a_of_type_JavaLangString = BaseApplicationImpl.getApplication().getString(2131430139);
            ((ShareActionSheetBuilder.ActionSheetItem)localObject4).jdField_b_of_type_Int = 2130840678;
            ((ShareActionSheetBuilder.ActionSheetItem)localObject4).jdField_a_of_type_Boolean = true;
            ((ShareActionSheetBuilder.ActionSheetItem)localObject4).jdField_c_of_type_Int = 35;
            ((ShareActionSheetBuilder.ActionSheetItem)localObject4).jdField_b_of_type_JavaLangString = "";
            ((ArrayList)localObject2).add(localObject4);
          }
        }
      }
      Object localObject3 = (SwiftBrowserScreenShotHandler)this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserComponentsProvider$SwiftBrowserComponentContext.a().a(64);
      if ((localObject3 != null) && (((SwiftBrowserScreenShotHandler)localObject3).a()) && (!PublicAccountH5AbilityPlugin.a(this.jdField_a_of_type_JavaUtilArrayList, "menuItem:screenShotShare")))
      {
        localObject3 = new ShareActionSheetBuilder.ActionSheetItem();
        ((ShareActionSheetBuilder.ActionSheetItem)localObject3).jdField_a_of_type_JavaLangString = BaseApplicationImpl.getApplication().getString(2131430133);
        ((ShareActionSheetBuilder.ActionSheetItem)localObject3).jdField_a_of_type_Boolean = true;
        ((ShareActionSheetBuilder.ActionSheetItem)localObject3).jdField_b_of_type_Int = 2130840676;
        ((ShareActionSheetBuilder.ActionSheetItem)localObject3).jdField_c_of_type_Int = 21;
        ((ShareActionSheetBuilder.ActionSheetItem)localObject3).jdField_b_of_type_JavaLangString = "";
        ((ArrayList)localObject2).add(localObject3);
      }
      if ((localObject1 != null) && (!TextUtils.isEmpty(((AppRuntime)localObject1).getAccount())) && (!PublicAccountH5AbilityPlugin.a(this.jdField_a_of_type_JavaUtilArrayList, "menuItem:favorite")) && ((this.jdField_a_of_type_Long & 0x2000) == 0L))
      {
        localObject1 = new ShareActionSheetBuilder.ActionSheetItem();
        ((ShareActionSheetBuilder.ActionSheetItem)localObject1).jdField_a_of_type_JavaLangString = BaseApplicationImpl.getApplication().getString(2131430124);
        ((ShareActionSheetBuilder.ActionSheetItem)localObject1).jdField_a_of_type_Boolean = true;
        ((ShareActionSheetBuilder.ActionSheetItem)localObject1).jdField_b_of_type_Int = 2130841573;
        ((ShareActionSheetBuilder.ActionSheetItem)localObject1).jdField_c_of_type_Int = 6;
        ((ShareActionSheetBuilder.ActionSheetItem)localObject1).jdField_b_of_type_JavaLangString = "";
        ((ArrayList)localObject2).add(localObject1);
      }
      if ((!PublicAccountH5AbilityPlugin.a(this.jdField_a_of_type_JavaUtilArrayList, "menuItem:setFont")) && (!this.jdField_c_of_type_Boolean) && (this.jdField_a_of_type_Boolean))
      {
        localObject1 = new ShareActionSheetBuilder.ActionSheetItem();
        ((ShareActionSheetBuilder.ActionSheetItem)localObject1).jdField_a_of_type_JavaLangString = BaseApplicationImpl.getApplication().getString(2131430109);
        ((ShareActionSheetBuilder.ActionSheetItem)localObject1).jdField_b_of_type_Int = 2130840674;
        ((ShareActionSheetBuilder.ActionSheetItem)localObject1).jdField_a_of_type_Boolean = true;
        ((ShareActionSheetBuilder.ActionSheetItem)localObject1).jdField_c_of_type_Int = 7;
        ((ShareActionSheetBuilder.ActionSheetItem)localObject1).jdField_b_of_type_JavaLangString = "";
        ((ArrayList)localObject2).add(localObject1);
      }
      if ((!PublicAccountH5AbilityPlugin.a(this.jdField_a_of_type_JavaUtilArrayList, "menuItem:copyUrl")) && ((this.jdField_a_of_type_Long & 0x20) == 0L))
      {
        localObject1 = new ShareActionSheetBuilder.ActionSheetItem();
        ((ShareActionSheetBuilder.ActionSheetItem)localObject1).jdField_a_of_type_JavaLangString = BaseApplicationImpl.getApplication().getString(2131430110);
        ((ShareActionSheetBuilder.ActionSheetItem)localObject1).jdField_b_of_type_Int = 2130838332;
        ((ShareActionSheetBuilder.ActionSheetItem)localObject1).jdField_a_of_type_Boolean = true;
        ((ShareActionSheetBuilder.ActionSheetItem)localObject1).jdField_c_of_type_Int = 1;
        ((ShareActionSheetBuilder.ActionSheetItem)localObject1).jdField_b_of_type_JavaLangString = "";
        ((ArrayList)localObject2).add(localObject1);
      }
      if ((!PublicAccountH5AbilityPlugin.a(this.jdField_a_of_type_JavaUtilArrayList, "menuItem:exposeArticle")) && (this.jdField_b_of_type_Boolean))
      {
        localObject1 = new ShareActionSheetBuilder.ActionSheetItem();
        ((ShareActionSheetBuilder.ActionSheetItem)localObject1).jdField_a_of_type_JavaLangString = BaseApplicationImpl.getApplication().getString(2131430111);
        ((ShareActionSheetBuilder.ActionSheetItem)localObject1).jdField_b_of_type_Int = 2130840663;
        ((ShareActionSheetBuilder.ActionSheetItem)localObject1).jdField_a_of_type_Boolean = true;
        ((ShareActionSheetBuilder.ActionSheetItem)localObject1).jdField_c_of_type_Int = 11;
        ((ShareActionSheetBuilder.ActionSheetItem)localObject1).jdField_b_of_type_JavaLangString = "";
        ((ArrayList)localObject2).add(localObject1);
      }
      return (List[])new ArrayList[] { localArrayList, localObject2 };
    }
  }
  
  public void b()
  {
    super.b();
    this.jdField_d_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidAppActivity = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserComponentsProvider$SwiftBrowserComponentContext.a();
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserComponentsProvider$SwiftBrowserComponentContext.a();
    a();
  }
  
  @TargetApi(14)
  public void b(int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserComponentsProvider$SwiftBrowserComponentContext.a() == null) || (this.jdField_d_of_type_Boolean)) {
      return;
    }
    this.jdField_b_of_type_Int = paramInt;
    paramInt = jdField_a_of_type_ArrayOfInt[paramInt];
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserComponentsProvider$SwiftBrowserComponentContext.a().getSettings().setTextZoom(paramInt);
  }
  
  public void b(String paramString1, String paramString2, String paramString3)
  {
    Object localObject = this.jdField_a_of_type_AndroidAppActivity.getIntent().getExtras();
    String str1 = ((Bundle)localObject).getString("forward_ark_app_name");
    String str2 = ((Bundle)localObject).getString("forward_ark_app_view");
    String str3 = ((Bundle)localObject).getString("forward_ark_app_desc");
    String str4 = ((Bundle)localObject).getString("forward_ark_app_ver");
    String str5 = ((Bundle)localObject).getString("forward_ark_app_prompt");
    String str6 = ((Bundle)localObject).getString("forward_ark_app_meta");
    String str7 = ((Bundle)localObject).getString("forward_ark_app_config");
    localObject = ((Bundle)localObject).getString("forward_ark_app_compat");
    if ((!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str2)) && (!TextUtils.isEmpty(str6)))
    {
      paramString2 = str7.toString();
      paramString1 = QQCustomArkDialog.AppInfo.a(str1, str2, str4, str6, this.jdField_a_of_type_AndroidAppActivity.getResources().getDisplayMetrics().scaledDensity, null, null);
      paramString1.putBoolean("forward_ark_app_direct", false);
      paramString1.putString("forward_ark_app_name", str1);
      paramString1.putString("forward_ark_app_view", str2);
      paramString1.putString("forward_ark_app_desc", str3);
      paramString1.putString("forward_ark_app_ver", str4);
      paramString1.putString("forward_ark_app_meta", str6);
      paramString1.putString("forward_ark_app_prompt", str5);
      paramString1.putString("forward_ark_app_config", paramString2);
      paramString1.putString("forward_ark_app_compat", (String)localObject);
      paramString1.putBoolean("forward_ark_from_h5", true);
      paramString2 = new Intent();
      paramString2.setClass(this.jdField_a_of_type_AndroidAppActivity, ForwardRecentActivity.class);
      paramString2.putExtra("forward_type", 27);
      paramString2.putExtra("is_ark_display_share", true);
      paramString2.putExtras(paramString1);
      if (paramString2 != null) {
        ForwardBaseOption.a(this.jdField_a_of_type_AndroidAppActivity, paramString2);
      }
      if (QLog.isColorLevel()) {
        QLog.i("SwiftBrowserShareMenuHandler", 2, "buildForwardIntent: " + paramString1);
      }
      ReportCenter.a().a("", "", "", "1000", "101", "0", false);
      ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "mp_msg_webview_38", "qq_ark_share", 0, 1, 0, "", "", "", "");
      return;
    }
    a(paramString1, paramString2, paramString3);
  }
  
  public void b(boolean paramBoolean)
  {
    this.h = paramBoolean;
  }
  
  public boolean b()
  {
    return this.g;
  }
  
  public void c()
  {
    Object localObject = this.jdField_a_of_type_AndroidAppActivity.getLayoutInflater().inflate(2130968985, null);
    this.jdField_a_of_type_AndroidWidgetPopupWindow = new PopupWindow((View)localObject, -1, -2);
    this.jdField_a_of_type_AndroidWidgetPopupWindow.setBackgroundDrawable(new BitmapDrawable());
    this.jdField_a_of_type_AndroidWidgetPopupWindow.setOutsideTouchable(true);
    localObject = (RangeButtonView)((View)localObject).findViewById(2131364584);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new RangeButtonView.Title("小", TypedValue.applyDimension(1, 15.0F, FontSettingManager.a)));
    localArrayList.add(new RangeButtonView.Title("标准", TypedValue.applyDimension(1, 16.0F, FontSettingManager.a)));
    localArrayList.add(new RangeButtonView.Title("", TypedValue.applyDimension(1, 17.0F, FontSettingManager.a)));
    localArrayList.add(new RangeButtonView.Title("", TypedValue.applyDimension(1, 17.0F, FontSettingManager.a)));
    localArrayList.add(new RangeButtonView.Title("大", TypedValue.applyDimension(1, 18.0F, FontSettingManager.a)));
    ((RangeButtonView)localObject).setTitleData(localArrayList);
    ((RangeButtonView)localObject).setOnChangerListener(this);
    ((RangeButtonView)localObject).setThumbPosition(this.jdField_b_of_type_Int);
    localArrayList = new ArrayList();
    localArrayList.add(BaseApplicationImpl.getApplication().getString(2131427479));
    localArrayList.add(BaseApplicationImpl.getApplication().getString(2131427480));
    localArrayList.add(BaseApplicationImpl.getApplication().getString(2131427481));
    localArrayList.add(BaseApplicationImpl.getApplication().getString(2131427482));
    localArrayList.add(BaseApplicationImpl.getApplication().getString(2131427483));
    ((RangeButtonView)localObject).setContentDescList(localArrayList);
    this.jdField_a_of_type_AndroidWidgetPopupWindow.showAtLocation(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserComponentsProvider$SwiftBrowserComponentContext.a(), 83, 0, 0);
  }
  
  public void c(boolean paramBoolean)
  {
    this.i = paramBoolean;
  }
  
  public boolean c()
  {
    return this.h;
  }
  
  public void d()
  {
    if (a())
    {
      a().e(new akpx(this));
      return;
    }
    b(1);
  }
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (((this.jdField_a_of_type_Long & 0x20000) != 0L) && (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment != null)) {
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.y();
    }
  }
  
  public void onItemClick(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = paramView.getTag();
    if (QLog.isColorLevel())
    {
      paramView = new StringBuilder().append("onItemClick, tag = ");
      if (paramAdapterView == null) {
        break label52;
      }
    }
    label52:
    for (boolean bool = true;; bool = false)
    {
      QLog.d("SwiftBrowserShareMenuHandler", 2, bool);
      if (paramAdapterView != null) {
        break;
      }
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.b();
    paramInt = ((ShareActionSheetBuilder.ActionSheetItemViewHolder)paramAdapterView).a.jdField_c_of_type_Int;
    paramAdapterView = a();
    paramView = new Bundle();
    if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment != null)
    {
      paramView.putString("qq", this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.jdField_e_of_type_JavaLangString);
      paramView.putString("public_uin", this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.jdField_i_of_type_JavaLangString);
      paramView.putString("source_public_uin", this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.k);
      paramView.putString("default_url", this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.g);
      paramView.putString("msg_id", this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.jdField_j_of_type_JavaLangString);
      paramView.putString("troop_app_info_url", this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.p);
      paramView.putString("troop_app_share_url", this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.o);
      paramView.putInt("troop_id", this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.jdField_j_of_type_Int);
      paramView.putInt("troop_app_id", this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.jdField_i_of_type_Int);
      paramView.putInt("uin_type", this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.h);
    }
    a(paramInt, paramAdapterView, paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\b.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.component.SwiftBrowserShareMenuHandler
 * JD-Core Version:    0.7.0.1
 */