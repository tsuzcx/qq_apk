package com.tencent.mobileqq.webviewplugin;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.biz.common.util.Util;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.qrcode.activity.ScannerUtils;
import com.tencent.biz.qrcode.util.QRUtils;
import com.tencent.biz.troop.TroopMemberApiClient;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.JoinDiscussionActivity;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pluginsdk.BasePluginActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpParser;
import com.tencent.mobileqq.utils.kapalaiadapter.KapalaiAdapterUtil;
import com.tencent.mobileqq.utils.kapalaiadapter.MobileIssueSettings;
import com.tencent.mobileqq.vaswebviewplugin.QWalletPayJsPlugin;
import com.tencent.mobileqq.webview.swift.SwiftIphoneTitleBarUI;
import com.tencent.mobileqq.webview.swift.SwiftWebViewFragmentSupporter;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.mobileqq.webview.swift.utils.SwiftWebViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.stat.MttLoader;
import com.tencent.util.URLUtil;
import cooperation.qzone.QZoneHelper.QZoneFamousSpaceHomeConstants;
import cooperation.qzone.QzonePluginProxyActivity;
import java.util.HashMap;
import java.util.Map;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;

public class WebViewJumpPlugin
  extends WebViewPlugin
{
  public static final String a;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
  WebView jdField_a_of_type_ComTencentSmttSdkWebView;
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  private boolean c = true;
  
  static
  {
    jdField_a_of_type_JavaLangString = WebViewJumpPlugin.class.getSimpleName();
  }
  
  public WebViewJumpPlugin()
  {
    this.mPluginNameSpace = jdField_a_of_type_JavaLangString;
  }
  
  private Activity a()
  {
    for (Activity localActivity = this.mRuntime.a(); (localActivity != null) && ((localActivity instanceof BasePluginActivity)); localActivity = ((BasePluginActivity)localActivity).getOutActivity()) {}
    return localActivity;
  }
  
  private void a(Intent paramIntent)
  {
    if (this.mRuntime == null) {}
    do
    {
      return;
      if (this.mRuntime.a() != null)
      {
        this.mRuntime.a().startActivity(paramIntent);
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.d("WebViewJumpPlugin", 2, "Activity is null");
  }
  
  private void b(String paramString)
  {
    if (((paramString.startsWith("http:")) || (paramString.startsWith("https:"))) && (this.jdField_a_of_type_ComTencentSmttSdkWebView != null))
    {
      String str = this.jdField_a_of_type_ComTencentSmttSdkWebView.getUrl();
      ThreadManager.getSubThreadHandler().post(new WebViewJumpPlugin.4(this, str, paramString));
    }
  }
  
  private void c(String paramString)
  {
    Object localObject = this.mRuntime.a();
    if (localObject == null) {}
    do
    {
      return;
      ((Activity)localObject).finish();
      if (QRUtils.c(paramString))
      {
        localObject = new Intent((Context)localObject, JoinDiscussionActivity.class);
        ((Intent)localObject).putExtra("innerSig", paramString);
        a((Intent)localObject);
        return;
      }
      paramString = JumpParser.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (Context)localObject, paramString);
    } while (paramString == null);
    paramString.a();
  }
  
  private void d(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return;
      if ((paramString.startsWith("mqqapi://armap_entry/map?src_type=web&version=1&from_type=0&service_id=1")) || (paramString.startsWith("mqqapi://personal_tag/tag_list"))) {}
      for (int i = 1; i != 0; i = 0)
      {
        new Handler().postDelayed(new WebViewJumpPlugin.5(this), 2000L);
        return;
      }
    }
  }
  
  public void a(String paramString)
  {
    paramString = JumpParser.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.mRuntime.a(), paramString);
    if (paramString != null) {
      paramString.a();
    }
  }
  
  protected boolean a(String paramString, boolean paramBoolean)
  {
    boolean bool = true;
    if (TextUtils.isEmpty(paramString))
    {
      paramBoolean = false;
      return paramBoolean;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("KEY_PID", String.valueOf(50079));
    localHashMap.put("KEY_EUSESTAT", String.valueOf(5));
    paramString = MttLoader.getValidQBUrl(this.mRuntime.a(), paramString);
    int i = MttLoader.loadUrl(this.mRuntime.a(), paramString, localHashMap, null);
    if (paramBoolean)
    {
      if ((this.jdField_a_of_type_ComTencentSmttSdkWebView == null) && (QLog.isColorLevel()))
      {
        QLog.d("WebViewJumpPlugin", 2, "webview is null");
        return true;
      }
      if (4 != i) {
        break label125;
      }
      this.jdField_a_of_type_ComTencentSmttSdkWebView.loadUrl("https://appchannel.html5.qq.com/directdown?app=qqbrowser&channel=50079");
    }
    for (;;)
    {
      paramBoolean = bool;
      if (i == 0) {
        break;
      }
      return false;
      label125:
      if (5 == i) {
        this.jdField_a_of_type_ComTencentSmttSdkWebView.loadUrl("https://appchannel.html5.qq.com/directdown?app=qqbrowser&channel=50079");
      } else if (i != 0) {
        this.jdField_a_of_type_ComTencentSmttSdkWebView.loadUrl("https://appchannel.html5.qq.com/directdown?app=qqbrowser&channel=50079");
      }
    }
  }
  
  public long getWebViewEventByNameSpace(String paramString)
  {
    return 2L;
  }
  
  public long getWebViewSchemaByNameSpace(String paramString)
  {
    return 4294967295L;
  }
  
  public boolean handleEvent(String paramString, long paramLong, Map<String, Object> paramMap)
  {
    if (paramLong == 2L) {
      this.c = true;
    }
    for (;;)
    {
      return false;
      if (paramLong == 8589934597L) {
        this.c = false;
      } else if (paramLong == 8589934601L)
      {
        if ((!TextUtils.isEmpty(paramString)) && ((paramString.contains("chatplay/hall")) || (paramString.contains("avwithstranger/avchathall")) || (paramString.contains("chatplay/avchathall"))) && (paramString.endsWith("#child")))
        {
          if ((paramString.contains("adtag=client.tab")) && (this.mRuntime != null) && (this.mRuntime.a() != null))
          {
            if (!(this.mRuntime.a() instanceof IphoneTitleBarActivity)) {
              break label178;
            }
            ((IphoneTitleBarActivity)this.mRuntime.a()).setLeftViewName(2131719717);
          }
          while ((this.mRuntime != null) && (this.mRuntime.a() != null) && (this.mRuntime.a().canGoBack()))
          {
            this.mRuntime.a().goBack();
            return true;
            label178:
            if (((this.mRuntime.a() instanceof SwiftWebViewFragmentSupporter)) && (!SwiftWebViewUtils.a()))
            {
              paramString = (WebViewFragment)this.mRuntime.a();
              if ((paramString != null) && (paramString.mSwiftTitleUI.a != null)) {
                paramString.mSwiftTitleUI.a.setText(2131719717);
              }
            }
          }
        }
      }
      else if ((paramLong == 8589934594L) && (!TextUtils.isEmpty(paramString)) && ((paramString.contains("chatplay/hall")) || (paramString.contains("avwithstranger/avchathall")) || (paramString.contains("chatplay/avchathall"))) && (paramString.endsWith("#child")) && (paramString.contains("adtag=client.tab")) && (this.mRuntime != null) && (this.mRuntime.a() != null)) {
        if ((this.mRuntime.a() instanceof IphoneTitleBarActivity))
        {
          ((IphoneTitleBarActivity)this.mRuntime.a()).setLeftViewName(2131690778);
        }
        else if (((this.mRuntime.a() instanceof SwiftWebViewFragmentSupporter)) && (!SwiftWebViewUtils.a()))
        {
          paramString = (WebViewFragment)this.mRuntime.a();
          if ((paramString != null) && (paramString.mSwiftTitleUI.a != null)) {
            paramString.mSwiftTitleUI.a.setText(2131690778);
          }
        }
      }
    }
  }
  
  public boolean handleSchemaRequest(String paramString1, String paramString2)
  {
    boolean bool2 = true;
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "handleSchemaRequest-->url:" + paramString1 + ",scheme:" + paramString2 + "mActive=" + this.c);
    }
    boolean bool1;
    if (!this.c) {
      bool1 = false;
    }
    Object localObject2;
    int i;
    long l1;
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    do
                    {
                      do
                      {
                        do
                        {
                          do
                          {
                            do
                            {
                              return bool1;
                              if ((QRUtils.a(paramString1)) && (ScannerUtils.a(paramString1))) {
                                return false;
                              }
                              localObject1 = null;
                              localObject2 = a();
                              paramString2 = (String)localObject1;
                              if (localObject2 != null)
                              {
                                localObject2 = ((Activity)localObject2).getIntent();
                                paramString2 = (String)localObject1;
                                if (localObject2 != null) {
                                  paramString2 = ((Intent)localObject2).getStringExtra("big_brother_source_key");
                                }
                              }
                              if (paramString1.startsWith("tel:"))
                              {
                                paramString1 = new Intent("android.intent.action.DIAL", Uri.parse(paramString1));
                                paramString1.putExtra("big_brother_source_key", paramString2);
                                if ((!MobileIssueSettings.jdField_a_of_type_Boolean) && (KapalaiAdapterUtil.a().a())) {
                                  KapalaiAdapterUtil.a().a(paramString1);
                                }
                                a(paramString1);
                                return true;
                              }
                              if (paramString1.startsWith("sms:"))
                              {
                                paramString2 = new Intent("android.intent.action.VIEW");
                                int j = paramString1.indexOf("?");
                                i = j;
                                if (j == -1) {
                                  i = paramString1.length();
                                }
                                paramString2.putExtra("address", paramString1.substring(paramString1.indexOf(":") + 1, i));
                                j = paramString1.indexOf("=");
                                i = j;
                                if (j == -1) {
                                  i = paramString1.length() - 1;
                                }
                                paramString2.putExtra("sms_body", paramString1.substring(i + 1, paramString1.length()));
                                paramString2.setType("vnd.android-dir/mms-sms");
                                a(paramString2);
                                return true;
                              }
                              if (paramString1.startsWith("mqqapi://avatar/update?"))
                              {
                                if (QLog.isColorLevel()) {
                                  QLog.d(this.TAG, 2, "enter WebViewJumpPlugin classicHeadActivity url=" + paramString1);
                                }
                                localObject2 = paramString1.split("&");
                                if ((localObject2 == null) || (localObject2.length < 5)) {
                                  break label1520;
                                }
                                localObject1 = localObject2[2].split("=");
                                paramString2 = localObject2[3].split("=");
                                localObject2 = localObject2[4].split("=");
                                if ((localObject1 == null) || (localObject1.length != 2) || (paramString2 == null) || (paramString2.length != 2) || (localObject2 == null) || (localObject2.length != 2)) {
                                  break label1520;
                                }
                                paramString1 = localObject1[1];
                                l1 = Long.parseLong(localObject2[1]);
                                long l2 = Long.parseLong(paramString2[1]);
                                paramString2 = new Intent("com.tencent.qqhead.refreshheadreq");
                                paramString2.setPackage(this.mRuntime.a().getPackageName());
                                paramString2.putExtra("faceType", 1);
                                paramString2.putExtra("uin", paramString1);
                                paramString2.putExtra("headSystemId", l2);
                                paramString2.putExtra("faceFlag", l1);
                                this.mRuntime.a().sendBroadcast(paramString2);
                                return true;
                              }
                              if (!paramString1.startsWith("mqqapi://tenpay/pay?")) {
                                break;
                              }
                              i = getRequestCode((byte)3);
                              bool1 = bool2;
                            } while (i == -1);
                            bool1 = bool2;
                          } while (this.b);
                          this.b = true;
                          paramString1 = JumpParser.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.mRuntime.a(), paramString1);
                          bool1 = bool2;
                        } while (paramString1 == null);
                        paramString1.b("webview");
                        paramString1.a("k_requestcode", String.valueOf(i));
                        paramString1.a("url_app_info", QWalletPayJsPlugin.getPayAppInfo());
                        paramString1.a();
                        this.jdField_a_of_type_Boolean = true;
                        this.b = false;
                        return true;
                        if ((!QRUtils.a(paramString1)) && (!paramString1.startsWith("mqqopensdkapi:"))) {
                          break;
                        }
                        paramString2 = this.mRuntime.a();
                        bool1 = bool2;
                      } while (paramString2 == null);
                      paramString2 = JumpParser.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString2, paramString1);
                      if (paramString2 != null)
                      {
                        paramString2.b("webview");
                        paramString2.a();
                      }
                      if (paramString1.startsWith("http:")) {
                        break;
                      }
                      bool1 = bool2;
                    } while (!paramString1.startsWith("https:"));
                    new Handler().postDelayed(new WebViewJumpPlugin.1(this), 2000L);
                    return true;
                    if (!paramString1.startsWith("https://buluo.qq.com/cgi-bin/bar/jump?jump_type=xqquncard")) {
                      break;
                    }
                    paramString1 = Uri.parse(paramString1).getQueryParameter("xq_uin");
                    if (TextUtils.isEmpty(paramString1)) {
                      return false;
                    }
                    paramString1 = "mqqapi://app/action?pkg=com.tencent.mobileqq&cmp=com.tencent.biz.pubaccount.AccountDetail.activity.api.impl.AccountDetailActivity&uin=" + paramString1;
                    paramString2 = this.mRuntime.a();
                    bool1 = bool2;
                  } while (paramString2 == null);
                  paramString1 = JumpParser.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString2, paramString1);
                  if (paramString1 != null)
                  {
                    paramString1.b("webview");
                    paramString1.a();
                  }
                  new Handler().postDelayed(new WebViewJumpPlugin.2(this), 2000L);
                  return true;
                  if (paramString1.startsWith("http://clientui.3g.qq.com/mqqapi/"))
                  {
                    if ((this.jdField_a_of_type_ComTencentSmttSdkWebView == null) && (QLog.isColorLevel()))
                    {
                      QLog.d("WebViewJumpPlugin", 2, "webview is null");
                      return true;
                    }
                    localObject1 = this.jdField_a_of_type_ComTencentSmttSdkWebView.getUrl();
                    if (!TextUtils.isEmpty((CharSequence)localObject1))
                    {
                      paramString2 = Util.b(paramString1, new String[0]);
                      paramString1 = paramString2;
                      if (paramString2.length() > 512) {
                        paramString1 = paramString2.substring(0, 512);
                      }
                      ReportController.b(null, "P_CliOper", "BizTechReport", "", "webview_jump", "http_jumpaction", 0, 1, 0, Util.b((String)localObject1, new String[0]), paramString1, "", "");
                    }
                    return false;
                  }
                  if (!paramString1.startsWith("mqqapi://readinjoy")) {
                    break;
                  }
                  paramString1 = JumpParser.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.mRuntime.a(), paramString1);
                  bool1 = bool2;
                } while (paramString1 == null);
                paramString1.b("webview");
                paramString1.a();
                return true;
                if (!paramString1.startsWith("mqqapi://now/playmedia")) {
                  break;
                }
                paramString1 = JumpParser.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.mRuntime.a(), paramString1);
                bool1 = bool2;
              } while (paramString1 == null);
              paramString1.b("webview");
              paramString1.a();
              return true;
              if (!paramString1.startsWith("mqqapi://now/playmedia")) {
                break;
              }
              paramString1 = JumpParser.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.mRuntime.a(), paramString1);
              bool1 = bool2;
            } while (paramString1 == null);
            paramString1.b("webview");
            paramString1.a(this.mRuntime.a());
            paramString1.a();
            return true;
            if (!paramString1.startsWith("mqqapi://now/openSmallVideoRecord")) {
              break;
            }
            paramString1 = JumpParser.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.mRuntime.a(), paramString1);
            bool1 = bool2;
          } while (paramString1 == null);
          paramString1.b("webview");
          paramString1.a(this.mRuntime.a());
          paramString1.a();
          return true;
          if ((paramString1.startsWith("mqqapi://")) || (paramString1.startsWith("qqfav://operation/")) || (paramString1.startsWith("nowmqqapi://now/openroom")))
          {
            localObject1 = new Intent(this.mRuntime.a(), JumpActivity.class);
            ((Intent)localObject1).setData(Uri.parse(paramString1));
            ((Intent)localObject1).putExtra("from", "webview");
            if (!TextUtils.isEmpty(paramString2)) {
              ((Intent)localObject1).putExtra("big_brother_source_key", paramString2);
            }
            a((Intent)localObject1);
            d(paramString1);
            return true;
          }
          if (!paramString1.startsWith("qb")) {
            break;
          }
          bool1 = bool2;
        } while (a(paramString1, false));
        bool1 = bool2;
      } while (this.mRuntime == null);
      bool1 = bool2;
    } while (this.mRuntime.a() == null);
    paramString1 = MttLoader.getValidQBUrl(this.mRuntime.a(), paramString1);
    if ((this.jdField_a_of_type_ComTencentSmttSdkWebView == null) && (QLog.isColorLevel()))
    {
      QLog.d("WebViewJumpPlugin", 2, "webview is null");
      return true;
    }
    this.jdField_a_of_type_ComTencentSmttSdkWebView.loadUrl(paramString1);
    return true;
    if ((paramString1.startsWith("mqqflyticket://")) || (QRUtils.b(paramString1)))
    {
      c(paramString1);
      return true;
    }
    if (paramString1.startsWith("mqqwpa://im"))
    {
      paramString1 = new Intent("android.intent.action.VIEW", Uri.parse(paramString1));
      paramString1.addFlags(268435456);
      paramString1.putExtra("from", "webview");
      a(paramString1);
      return true;
    }
    if (paramString1.startsWith("mqqapi://pay_for_emosm_success"))
    {
      paramString2 = this.mRuntime.a();
      if (paramString2 != null)
      {
        paramString2.setResult(8213);
        paramString2.finish();
      }
    }
    label1520:
    do
    {
      do
      {
        for (;;)
        {
          b(paramString1);
          return false;
          if (paramString1.startsWith("mqqapi://od"))
          {
            a(paramString1);
          }
          else
          {
            if (paramString1.startsWith("https://mp.qzone.qq.com/u/"))
            {
              localObject1 = URLUtil.a(paramString1);
              if (((Map)localObject1).containsKey("uin")) {
                paramString2 = (String)((Map)localObject1).get("uin");
              }
              for (;;)
              {
                try
                {
                  l1 = Long.parseLong(paramString2);
                  if ((!((Map)localObject1).containsKey("is_famous_space")) || (!"0".equals(((Map)localObject1).get("is_famous_space")))) {
                    break label1746;
                  }
                  paramString2 = new Intent();
                  paramString2.putExtra("qqid", l1);
                  QzonePluginProxyActivity.setActivityNameToIntent(paramString2, "com.qzone.homepage.ui.activity.QZoneUserHomeActivity");
                  QzonePluginProxyActivity.launchPluingActivityForResult(this.mRuntime.a(), this.mRuntime.a().getAccount(), paramString2, 0);
                  new Handler().postDelayed(new WebViewJumpPlugin.3(this), 2000L);
                  return true;
                }
                catch (NumberFormatException paramString2)
                {
                  paramString2.printStackTrace();
                }
                break;
                i = paramString1.lastIndexOf('?');
                if (i != -1)
                {
                  paramString2 = paramString1.substring("https://mp.qzone.qq.com/u/".length(), i);
                }
                else
                {
                  paramString2 = paramString1.substring("https://mp.qzone.qq.com/u/".length());
                  continue;
                  paramString2 = QZoneHelper.QZoneFamousSpaceHomeConstants.getFamousSpaceHomeActionUrl();
                  if (QLog.isColorLevel()) {
                    QLog.d(this.TAG, 2, "handleJumpToFamousSpace-->famous uin:" + l1 + ",actionUrl:" + paramString2);
                  }
                  localObject1 = this.mRuntime.a();
                  localObject2 = new Intent();
                  ((Intent)localObject2).putExtra("qqid", l1);
                  ((Intent)localObject2).putExtra("refer", "famous");
                  ((Intent)localObject2).putExtra("famous_space_webview_url", paramString2);
                  QzonePluginProxyActivity.setActivityNameToIntent((Intent)localObject2, "com.qzone.homepage.ui.activity.QZoneFamousSpaceHomePageActivity");
                  QzonePluginProxyActivity.launchPluingActivityForResult((Context)localObject1, this.mRuntime.a().getAccount(), (Intent)localObject2, 0);
                }
              }
            }
            if (paramString1.startsWith("mqqconferenceflyticket://"))
            {
              if (this.mRuntime.a() == null) {}
            }
            else if (paramString1.startsWith("mqqapi://groupvideo"))
            {
              paramString2 = JumpParser.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.mRuntime.a(), paramString1);
              if (paramString2 != null) {
                paramString2.a();
              }
            }
            else
            {
              if (!paramString1.startsWith("mqqapi://stickynote")) {
                break;
              }
              paramString2 = JumpParser.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.mRuntime.a(), paramString1);
              if (paramString2 != null) {
                paramString2.a();
              }
            }
          }
        }
      } while (!paramString1.startsWith("auth://tauth.qq.com/?#"));
      paramString2 = this.mRuntime.a();
      QLog.d(this.TAG, 1, new Object[] { "qrcode login end activity=", paramString2 });
    } while (paramString2 == null);
    label1746:
    Object localObject1 = new Intent("mqq.intent.action.QRCODE_LOGIN_FINISH");
    ((Intent)localObject1).setPackage(MobileQQ.sMobileQQ.getPackageName());
    ((Intent)localObject1).putExtra("param_qr_code_url", paramString1);
    paramString2.sendBroadcast((Intent)localObject1);
    paramString2.finish();
    return true;
  }
  
  public void onActivityReady()
  {
    if ((this.mRuntime.a() instanceof QQAppInterface)) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)this.mRuntime.a());
    }
    this.jdField_a_of_type_ComTencentSmttSdkWebView = this.mRuntime.a();
  }
  
  public void onActivityResult(Intent paramIntent, byte paramByte, int paramInt)
  {
    if (paramByte == 3)
    {
      if (paramInt != -1) {
        break label129;
      }
      if ((this.jdField_a_of_type_Boolean) && (paramIntent != null) && (this.jdField_a_of_type_ComTencentSmttSdkWebView != null))
      {
        str = paramIntent.getStringExtra("callback_type");
        if (!"javascript".equals(str)) {
          break label79;
        }
        callJs(paramIntent.getStringExtra("callback_name"), new String[] { paramIntent.getStringExtra("callback_data") });
      }
    }
    label79:
    while (paramInt != 0)
    {
      String str;
      for (;;)
      {
        this.jdField_a_of_type_Boolean = false;
        return;
        if ("url".equals(str))
        {
          if ((this.jdField_a_of_type_ComTencentSmttSdkWebView == null) && (QLog.isColorLevel()))
          {
            QLog.d("WebViewJumpPlugin", 2, "webview is null");
            return;
          }
          this.jdField_a_of_type_ComTencentSmttSdkWebView.loadUrl(paramIntent.getStringExtra("callback_url"));
        }
      }
    }
    label129:
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void onCreate()
  {
    TroopMemberApiClient.a().a();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    TroopMemberApiClient.a().b();
  }
  
  public void onWebViewCreated(CustomWebView paramCustomWebView)
  {
    super.onWebViewCreated(paramCustomWebView);
    this.jdField_a_of_type_ComTencentSmttSdkWebView = paramCustomWebView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.webviewplugin.WebViewJumpPlugin
 * JD-Core Version:    0.7.0.1
 */