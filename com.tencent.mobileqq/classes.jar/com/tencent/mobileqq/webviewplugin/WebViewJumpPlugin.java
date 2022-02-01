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
  public static final String a = "WebViewJumpPlugin";
  WebView b;
  QQAppInterface c = null;
  private boolean d;
  private boolean e;
  private boolean f = true;
  
  public WebViewJumpPlugin()
  {
    this.mPluginNameSpace = a;
  }
  
  private Activity a()
  {
    for (Activity localActivity = this.mRuntime.d(); (localActivity != null) && ((localActivity instanceof BasePluginActivity)); localActivity = ((BasePluginActivity)localActivity).getOutActivity()) {}
    return localActivity;
  }
  
  private void a(Intent paramIntent)
  {
    if (this.mRuntime == null) {
      return;
    }
    if (this.mRuntime.d() != null)
    {
      this.mRuntime.d().startActivity(paramIntent);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("WebViewJumpPlugin", 2, "Activity is null");
    }
  }
  
  private void b(String paramString)
  {
    if ((paramString.startsWith("http:")) || (paramString.startsWith("https:")))
    {
      Object localObject = this.b;
      if (localObject != null)
      {
        localObject = ((WebView)localObject).getUrl();
        ThreadManager.getSubThreadHandler().post(new WebViewJumpPlugin.4(this, (String)localObject, paramString));
      }
    }
  }
  
  private void c(String paramString)
  {
    Object localObject = this.mRuntime.d();
    if (localObject == null) {
      return;
    }
    ((Activity)localObject).finish();
    if (com.tencent.biz.qrcode.util.QRUtils.c(paramString))
    {
      localObject = new Intent((Context)localObject, JoinDiscussionActivity.class);
      ((Intent)localObject).putExtra("innerSig", paramString);
      a((Intent)localObject);
      return;
    }
    paramString = JumpParser.a(this.c, (Context)localObject, paramString);
    if (paramString != null) {
      paramString.a();
    }
  }
  
  private void d(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    int i;
    if ((!paramString.startsWith("mqqapi://armap_entry/map?src_type=web&version=1&from_type=0&service_id=1")) && (!paramString.startsWith("mqqapi://personal_tag/tag_list"))) {
      i = 0;
    } else {
      i = 1;
    }
    if (i != 0) {
      new Handler().postDelayed(new WebViewJumpPlugin.5(this), 2000L);
    }
  }
  
  public void a(String paramString)
  {
    paramString = JumpParser.a(this.c, this.mRuntime.d(), paramString);
    if (paramString != null) {
      paramString.a();
    }
  }
  
  protected boolean a(String paramString, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("KEY_PID", String.valueOf(50079));
    localHashMap.put("KEY_EUSESTAT", String.valueOf(5));
    paramString = MttLoader.getValidQBUrl(this.mRuntime.d(), paramString);
    int i = MttLoader.loadUrl(this.mRuntime.d(), paramString, localHashMap, null);
    if (paramBoolean)
    {
      if ((this.b == null) && (QLog.isColorLevel()))
      {
        QLog.d("WebViewJumpPlugin", 2, "webview is null");
        return true;
      }
      if (4 == i) {
        this.b.loadUrl("https://appchannel.html5.qq.com/directdown?app=qqbrowser&channel=50079");
      } else if (5 == i) {
        this.b.loadUrl("https://appchannel.html5.qq.com/directdown?app=qqbrowser&channel=50079");
      } else if (i != 0) {
        this.b.loadUrl("https://appchannel.html5.qq.com/directdown?app=qqbrowser&channel=50079");
      }
    }
    return i == 0;
  }
  
  public long getWebViewEventByNameSpace(String paramString)
  {
    return 2L;
  }
  
  public long getWebViewSchemaByNameSpace(String paramString)
  {
    return 4294967295L;
  }
  
  protected boolean handleEvent(String paramString, long paramLong, Map<String, Object> paramMap)
  {
    if (paramLong == 2L)
    {
      this.f = true;
      return false;
    }
    if (paramLong == 8589934597L)
    {
      this.f = false;
      return false;
    }
    if (paramLong == 8589934601L)
    {
      if ((!TextUtils.isEmpty(paramString)) && ((paramString.contains("chatplay/hall")) || (paramString.contains("avwithstranger/avchathall")) || (paramString.contains("chatplay/avchathall"))) && (paramString.endsWith("#child")))
      {
        if ((paramString.contains("adtag=client.tab")) && (this.mRuntime != null) && (this.mRuntime.d() != null)) {
          if ((this.mRuntime.d() instanceof IphoneTitleBarActivity))
          {
            ((IphoneTitleBarActivity)this.mRuntime.d()).setLeftViewName(2131917001);
          }
          else if (((this.mRuntime.d() instanceof SwiftWebViewFragmentSupporter)) && (!SwiftWebViewUtils.d()))
          {
            paramString = (WebViewFragment)this.mRuntime.f();
            if ((paramString != null) && (paramString.getSwiftTitleUI().d != null)) {
              paramString.getSwiftTitleUI().d.setText(2131917001);
            }
          }
        }
        if ((this.mRuntime != null) && (this.mRuntime.a() != null) && (this.mRuntime.a().canGoBack()))
        {
          this.mRuntime.a().goBack();
          return true;
        }
      }
    }
    else if ((paramLong == 8589934594L) && (!TextUtils.isEmpty(paramString)) && ((paramString.contains("chatplay/hall")) || (paramString.contains("avwithstranger/avchathall")) || (paramString.contains("chatplay/avchathall"))) && (paramString.endsWith("#child")) && (paramString.contains("adtag=client.tab")) && (this.mRuntime != null) && (this.mRuntime.d() != null))
    {
      if ((this.mRuntime.d() instanceof IphoneTitleBarActivity))
      {
        ((IphoneTitleBarActivity)this.mRuntime.d()).setLeftViewName(2131887625);
        return false;
      }
      if (((this.mRuntime.d() instanceof SwiftWebViewFragmentSupporter)) && (!SwiftWebViewUtils.d()))
      {
        paramString = (WebViewFragment)this.mRuntime.f();
        if ((paramString != null) && (paramString.getSwiftTitleUI().d != null)) {
          paramString.getSwiftTitleUI().d.setText(2131887625);
        }
      }
    }
    return false;
  }
  
  protected boolean handleSchemaRequest(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = this.mTAG;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("handleSchemaRequest-->url:");
      ((StringBuilder)localObject2).append(paramString1);
      ((StringBuilder)localObject2).append(",scheme:");
      ((StringBuilder)localObject2).append(paramString2);
      ((StringBuilder)localObject2).append("mActive=");
      ((StringBuilder)localObject2).append(this.f);
      QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
    }
    if (!this.f) {
      return false;
    }
    if ((com.tencent.mobileqq.qrscan.utils.QRUtils.a(paramString1)) && (com.tencent.biz.qrcode.util.QRUtils.a(paramString1))) {
      return false;
    }
    Object localObject1 = null;
    Object localObject2 = a();
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
      if ((!MobileIssueSettings.a) && (KapalaiAdapterUtil.a().b())) {
        KapalaiAdapterUtil.a().a(paramString1);
      }
      a(paramString1);
      return true;
    }
    int i;
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
    long l1;
    if (paramString1.startsWith("mqqapi://avatar/update?"))
    {
      if (QLog.isColorLevel())
      {
        paramString2 = this.mTAG;
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("enter WebViewJumpPlugin classicHeadActivity url=");
        ((StringBuilder)localObject1).append(paramString1);
        QLog.d(paramString2, 2, ((StringBuilder)localObject1).toString());
      }
      localObject2 = paramString1.split("&");
      if ((localObject2 != null) && (localObject2.length >= 5))
      {
        localObject1 = localObject2[2].split("=");
        paramString2 = localObject2[3].split("=");
        localObject2 = localObject2[4].split("=");
        if ((localObject1 != null) && (localObject1.length == 2) && (paramString2 != null) && (paramString2.length == 2) && (localObject2 != null) && (localObject2.length == 2))
        {
          paramString1 = localObject1[1];
          l1 = Long.parseLong(localObject2[1]);
          long l2 = Long.parseLong(paramString2[1]);
          paramString2 = new Intent("com.tencent.qqhead.refreshheadreq");
          paramString2.setPackage(this.mRuntime.d().getPackageName());
          paramString2.putExtra("faceType", 1);
          paramString2.putExtra("uin", paramString1);
          paramString2.putExtra("headSystemId", l2);
          paramString2.putExtra("faceFlag", l1);
          this.mRuntime.d().sendBroadcast(paramString2);
          return true;
        }
      }
    }
    else
    {
      if (paramString1.startsWith("mqqapi://tenpay/pay?"))
      {
        i = getRequestCode((byte)3);
        if ((i != -1) && (!this.e))
        {
          this.e = true;
          paramString1 = JumpParser.a(this.c, this.mRuntime.d(), paramString1);
          if (paramString1 != null)
          {
            paramString1.c("webview");
            paramString1.a("k_requestcode", String.valueOf(i));
            paramString1.a("url_app_info", QWalletPayJsPlugin.getPayAppInfo());
            paramString1.a();
            this.d = true;
            this.e = false;
          }
        }
        return true;
      }
      if ((com.tencent.biz.qrcode.util.QRUtils.a(paramString1)) || (paramString1.startsWith("mqqopensdkapi:"))) {
        break label2003;
      }
      if (paramString1.startsWith("https://buluo.qq.com/cgi-bin/bar/jump?jump_type=xqquncard"))
      {
        paramString1 = Uri.parse(paramString1).getQueryParameter("xq_uin");
        if (TextUtils.isEmpty(paramString1)) {
          return false;
        }
        paramString2 = new StringBuilder();
        paramString2.append("mqqapi://app/action?pkg=com.tencent.mobileqq&cmp=com.tencent.biz.pubaccount.AccountDetail.activity.api.impl.AccountDetailActivity&uin=");
        paramString2.append(paramString1);
        paramString1 = paramString2.toString();
        paramString2 = this.mRuntime.d();
        if (paramString2 != null)
        {
          paramString1 = JumpParser.a(this.c, paramString2, paramString1);
          if (paramString1 != null)
          {
            paramString1.c("webview");
            paramString1.a();
          }
          new Handler().postDelayed(new WebViewJumpPlugin.2(this), 2000L);
        }
        return true;
      }
      if (paramString1.startsWith("http://clientui.3g.qq.com/mqqapi/"))
      {
        if ((this.b == null) && (QLog.isColorLevel()))
        {
          QLog.d("WebViewJumpPlugin", 2, "webview is null");
          return true;
        }
        localObject1 = this.b.getUrl();
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
      if (paramString1.startsWith("mqqapi://readinjoy"))
      {
        paramString1 = JumpParser.a(this.c, this.mRuntime.d(), paramString1);
        if (paramString1 != null)
        {
          paramString1.c("webview");
          paramString1.a();
        }
        return true;
      }
      if (paramString1.startsWith("mqqapi://now/playmedia"))
      {
        paramString1 = JumpParser.a(this.c, this.mRuntime.d(), paramString1);
        if (paramString1 != null)
        {
          paramString1.c("webview");
          paramString1.a();
        }
        return true;
      }
      if (paramString1.startsWith("mqqapi://now/playmedia"))
      {
        paramString1 = JumpParser.a(this.c, this.mRuntime.d(), paramString1);
        if (paramString1 != null)
        {
          paramString1.c("webview");
          paramString1.a(this.mRuntime.b());
          paramString1.a();
        }
        return true;
      }
      if (paramString1.startsWith("mqqapi://now/openSmallVideoRecord"))
      {
        paramString1 = JumpParser.a(this.c, this.mRuntime.d(), paramString1);
        if (paramString1 != null)
        {
          paramString1.c("webview");
          paramString1.a(this.mRuntime.b());
          paramString1.a();
        }
        return true;
      }
      if ((paramString1.startsWith("mqqapi://")) || (paramString1.startsWith("qqfav://operation/")) || (paramString1.startsWith("nowmqqapi://now/openroom")) || (paramString1.startsWith("mqqguild://"))) {
        break label1932;
      }
      if (paramString1.startsWith("qb"))
      {
        if ((!a(paramString1, false)) && (this.mRuntime != null))
        {
          if (this.mRuntime.d() == null) {
            return true;
          }
          paramString1 = MttLoader.getValidQBUrl(this.mRuntime.d(), paramString1);
          if ((this.b == null) && (QLog.isColorLevel()))
          {
            QLog.d("WebViewJumpPlugin", 2, "webview is null");
            return true;
          }
          this.b.loadUrl(paramString1);
        }
        return true;
      }
      if ((paramString1.startsWith("mqqflyticket://")) || (com.tencent.biz.qrcode.util.QRUtils.b(paramString1))) {
        break label1925;
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
        paramString2 = this.mRuntime.d();
        if (paramString2 != null)
        {
          paramString2.setResult(8213);
          paramString2.finish();
        }
      }
      else if (paramString1.startsWith("mqqapi://od"))
      {
        a(paramString1);
      }
      else if (paramString1.startsWith("https://mp.qzone.qq.com/u/"))
      {
        localObject1 = URLUtil.a(paramString1);
        if (((Map)localObject1).containsKey("uin"))
        {
          paramString2 = (String)((Map)localObject1).get("uin");
        }
        else
        {
          i = paramString1.lastIndexOf('?');
          if (i != -1) {
            paramString2 = paramString1.substring(26, i);
          } else {
            paramString2 = paramString1.substring(26);
          }
        }
        try
        {
          l1 = Long.parseLong(paramString2);
          if ((((Map)localObject1).containsKey("is_famous_space")) && ("0".equals(((Map)localObject1).get("is_famous_space"))))
          {
            paramString2 = new Intent();
            paramString2.putExtra("qqid", l1);
            QzonePluginProxyActivity.setActivityNameToIntent(paramString2, "com.qzone.homepage.ui.activity.QZoneUserHomeActivity");
            QzonePluginProxyActivity.launchPluingActivityForResult(this.mRuntime.d(), this.mRuntime.b().getAccount(), paramString2, 0);
          }
          else
          {
            paramString2 = QZoneHelper.QZoneFamousSpaceHomeConstants.getFamousSpaceHomeActionUrl();
            if (QLog.isColorLevel())
            {
              localObject1 = this.mTAG;
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("handleJumpToFamousSpace-->famous uin:");
              ((StringBuilder)localObject2).append(l1);
              ((StringBuilder)localObject2).append(",actionUrl:");
              ((StringBuilder)localObject2).append(paramString2);
              QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
            }
            localObject1 = this.mRuntime.d();
            localObject2 = new Intent();
            ((Intent)localObject2).putExtra("qqid", l1);
            ((Intent)localObject2).putExtra("refer", "famous");
            ((Intent)localObject2).putExtra("famous_space_webview_url", paramString2);
            QzonePluginProxyActivity.setActivityNameToIntent((Intent)localObject2, "com.qzone.homepage.ui.activity.QZoneFamousSpaceHomePageActivity");
            QzonePluginProxyActivity.launchPluingActivityForResult((Context)localObject1, this.mRuntime.b().getAccount(), (Intent)localObject2, 0);
          }
          new Handler().postDelayed(new WebViewJumpPlugin.3(this), 2000L);
          return true;
        }
        catch (NumberFormatException paramString2)
        {
          paramString2.printStackTrace();
        }
      }
      else if (paramString1.startsWith("mqqconferenceflyticket://"))
      {
        this.mRuntime.d();
      }
      else if (paramString1.startsWith("mqqapi://groupvideo"))
      {
        paramString2 = JumpParser.a(this.c, this.mRuntime.d(), paramString1);
        if (paramString2 != null) {
          paramString2.a();
        }
      }
      else if (paramString1.startsWith("mqqapi://stickynote"))
      {
        paramString2 = JumpParser.a(this.c, this.mRuntime.d(), paramString1);
        if (paramString2 != null) {
          paramString2.a();
        }
      }
      else if (paramString1.startsWith("auth://tauth.qq.com/?#"))
      {
        paramString2 = this.mRuntime.d();
        QLog.d(this.mTAG, 1, new Object[] { "qrcode login end activity=", paramString2 });
        if (paramString2 != null)
        {
          localObject1 = new Intent("mqq.intent.action.QRCODE_LOGIN_FINISH");
          ((Intent)localObject1).setPackage(MobileQQ.sMobileQQ.getPackageName());
          ((Intent)localObject1).putExtra("param_qr_code_url", paramString1);
          paramString2.sendBroadcast((Intent)localObject1);
          paramString2.finish();
          return true;
        }
      }
    }
    b(paramString1);
    return false;
    label1925:
    c(paramString1);
    return true;
    label1932:
    localObject1 = new Intent(this.mRuntime.d(), JumpActivity.class);
    ((Intent)localObject1).setData(Uri.parse(paramString1));
    ((Intent)localObject1).putExtra("from", "webview");
    if (!TextUtils.isEmpty(paramString2)) {
      ((Intent)localObject1).putExtra("big_brother_source_key", paramString2);
    }
    a((Intent)localObject1);
    d(paramString1);
    return true;
    label2003:
    paramString2 = this.mRuntime.d();
    if (paramString2 != null)
    {
      paramString2 = JumpParser.a(this.c, paramString2, paramString1);
      if (paramString2 != null)
      {
        paramString2.c("webview");
        paramString2.a();
      }
      if ((paramString1.startsWith("http:")) || (paramString1.startsWith("https:"))) {
        new Handler().postDelayed(new WebViewJumpPlugin.1(this), 2000L);
      }
    }
    return true;
  }
  
  public void onActivityReady()
  {
    if ((this.mRuntime.b() instanceof QQAppInterface)) {
      this.c = ((QQAppInterface)this.mRuntime.b());
    }
    this.b = this.mRuntime.a();
  }
  
  public void onActivityResult(Intent paramIntent, byte paramByte, int paramInt)
  {
    if (paramByte == 3)
    {
      if (paramInt == -1)
      {
        if ((this.d) && (paramIntent != null) && (this.b != null))
        {
          String str = paramIntent.getStringExtra("callback_type");
          if ("javascript".equals(str))
          {
            callJs(paramIntent.getStringExtra("callback_name"), new String[] { paramIntent.getStringExtra("callback_data") });
          }
          else if ("url".equals(str))
          {
            if ((this.b == null) && (QLog.isColorLevel()))
            {
              QLog.d("WebViewJumpPlugin", 2, "webview is null");
              return;
            }
            this.b.loadUrl(paramIntent.getStringExtra("callback_url"));
          }
        }
        this.d = false;
        return;
      }
      if (paramInt == 0) {
        this.d = false;
      }
    }
  }
  
  protected void onCreate()
  {
    TroopMemberApiClient.a().e();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    TroopMemberApiClient.a().f();
  }
  
  protected void onWebViewCreated(CustomWebView paramCustomWebView)
  {
    super.onWebViewCreated(paramCustomWebView);
    this.b = paramCustomWebView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.webviewplugin.WebViewJumpPlugin
 * JD-Core Version:    0.7.0.1
 */