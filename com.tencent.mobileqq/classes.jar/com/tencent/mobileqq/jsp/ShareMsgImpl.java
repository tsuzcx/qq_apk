package com.tencent.mobileqq.jsp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.tencent.biz.AuthorizeConfig;
import com.tencent.biz.pubaccount.readinjoy.common.WxShareHelperFromReadInjoy;
import com.tencent.biz.pubaccount.readinjoy.common.WxShareHelperFromReadInjoy.WXShareHelperFromReadInjoyListener;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.biz.qrcode.util.QRUtils;
import com.tencent.biz.troop.TroopMemberApiClient;
import com.tencent.biz.webviewplugin.Share;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.DirectForwardActivity;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.TeamWorkDocEditBrowserActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.confess.ConfessMsgUtil;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.mobileqq.data.MessageForTribeShortVideo;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgFactory;
import com.tencent.mobileqq.webview.swift.WebUiBaseInterface;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.mobileqq.webview.swift.WebViewProvider;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserComponentsProvider;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserShareMenuHandler;
import com.tencent.mobileqq.webviewplugin.WebUiUtils.QQBrowserBaseActivityInterface;
import com.tencent.mobileqq.webviewplugin.WebUiUtils.WebShareInterface;
import com.tencent.mobileqq.webviewplugin.WebUiUtils.WebShareReportInterface;
import com.tencent.mobileqq.webviewplugin.WebUiUtils.WebUiMethodInterface;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.mobileqq.wxapi.WXShareHelper.WXShareListener;
import com.tencent.open.agent.report.ReportCenter;
import com.tencent.qidian.QidianManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QZoneShareManager;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import mqq.app.MobileQQ;
import org.json.JSONException;
import org.json.JSONObject;

public class ShareMsgImpl
{
  Activity jdField_a_of_type_AndroidAppActivity;
  Context jdField_a_of_type_AndroidContentContext;
  WxShareHelperFromReadInjoy.WXShareHelperFromReadInjoyListener jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonWxShareHelperFromReadInjoy$WXShareHelperFromReadInjoyListener;
  TroopMemberApiClient jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient = null;
  AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  ShareMsgImpl.ShareMsgImplListener jdField_a_of_type_ComTencentMobileqqJspShareMsgImpl$ShareMsgImplListener;
  WebViewPlugin.PluginRuntime jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin$PluginRuntime;
  WebViewPlugin jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin;
  WebUiUtils.QQBrowserBaseActivityInterface jdField_a_of_type_ComTencentMobileqqWebviewpluginWebUiUtils$QQBrowserBaseActivityInterface = null;
  WebUiUtils.WebShareInterface jdField_a_of_type_ComTencentMobileqqWebviewpluginWebUiUtils$WebShareInterface = null;
  WebUiUtils.WebShareReportInterface jdField_a_of_type_ComTencentMobileqqWebviewpluginWebUiUtils$WebShareReportInterface = null;
  WebUiUtils.WebUiMethodInterface jdField_a_of_type_ComTencentMobileqqWebviewpluginWebUiUtils$WebUiMethodInterface = null;
  QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  WXShareHelper.WXShareListener jdField_a_of_type_ComTencentMobileqqWxapiWXShareHelper$WXShareListener;
  String jdField_a_of_type_JavaLangString;
  String b;
  
  public ShareMsgImpl(Context paramContext, Activity paramActivity, AppInterface paramAppInterface, ShareMsgImpl.ShareMsgImplListener paramShareMsgImplListener)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqJspShareMsgImpl$ShareMsgImplListener = paramShareMsgImplListener;
    if (this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient == null)
    {
      this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient = TroopMemberApiClient.a();
      this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.a();
    }
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWxapiWXShareHelper$WXShareListener != null) {
      WXShareHelper.a().b(this.jdField_a_of_type_ComTencentMobileqqWxapiWXShareHelper$WXShareListener);
    }
    if (this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient != null) {
      this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.b();
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonWxShareHelperFromReadInjoy$WXShareHelperFromReadInjoyListener != null) {
      WxShareHelperFromReadInjoy.a().b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonWxShareHelperFromReadInjoy$WXShareHelperFromReadInjoyListener);
    }
  }
  
  void a(Activity paramActivity)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebUiUtils$WebShareInterface != null) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = ((Share)this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebUiUtils$WebShareInterface.getShare()).a();
      }
    }
    else {
      return;
    }
    WebUiBaseInterface localWebUiBaseInterface = null;
    if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin$PluginRuntime != null) {
      localWebUiBaseInterface = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin$PluginRuntime.a(this.jdField_a_of_type_AndroidAppActivity);
    }
    if (paramActivity.getClass().getName().equalsIgnoreCase("com.tencent.qqreadinjoy.detailspage.ReadInJoyArticleDetailActivity"))
    {
      if ((paramActivity instanceof WebUiUtils.WebShareInterface))
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = ((Share)((WebUiUtils.WebShareInterface)paramActivity).getShare()).a();
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(paramActivity, paramActivity.getResources().getDimensionPixelSize(2131299166));
      return;
    }
    if ((localWebUiBaseInterface instanceof WebUiUtils.WebShareInterface))
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = ((Share)((WebUiUtils.WebShareInterface)paramActivity).getShare()).a();
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(paramActivity, paramActivity.getResources().getDimensionPixelSize(2131299166));
  }
  
  public void a(Intent paramIntent, byte paramByte, int paramInt)
  {
    Object localObject;
    String str;
    if (paramByte == 1)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqJspShareMsgImpl$ShareMsgImplListener;
      str = this.jdField_a_of_type_JavaLangString;
      if (paramInt == -1)
      {
        paramIntent = "true";
        ((ShareMsgImpl.ShareMsgImplListener)localObject).onSharMsgcallback(str, paramIntent);
      }
    }
    do
    {
      do
      {
        return;
        paramIntent = "false";
        break;
        if (paramByte == 2)
        {
          localObject = this.jdField_a_of_type_ComTencentMobileqqJspShareMsgImpl$ShareMsgImplListener;
          str = this.jdField_a_of_type_JavaLangString;
          if (paramInt == -1) {}
          for (paramIntent = "{\"result\":1}";; paramIntent = "{\"result\":0}")
          {
            ((ShareMsgImpl.ShareMsgImplListener)localObject).onSharMsgcallback(str, paramIntent);
            return;
          }
        }
        if (paramByte == 3)
        {
          localObject = this.jdField_a_of_type_ComTencentMobileqqJspShareMsgImpl$ShareMsgImplListener;
          str = this.jdField_a_of_type_JavaLangString;
          if (paramInt == -1) {}
          for (paramIntent = "{\"result\":0}";; paramIntent = "{\"result\":4}")
          {
            ((ShareMsgImpl.ShareMsgImplListener)localObject).onSharMsgcallback(str, paramIntent);
            return;
          }
        }
      } while (paramByte != 4);
      localObject = this.jdField_a_of_type_AndroidAppActivity;
    } while ((paramInt != -1) || (localObject == null) || (((Activity)localObject).isFinishing()) || (paramIntent == null));
    paramIntent = new Bundle(paramIntent.getExtras());
    this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.b(paramIntent);
  }
  
  public void a(WebUiBaseInterface paramWebUiBaseInterface)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebUiUtils$WebUiMethodInterface == null) && ((paramWebUiBaseInterface instanceof WebUiUtils.WebUiMethodInterface))) {
      this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebUiUtils$WebUiMethodInterface = ((WebUiUtils.WebUiMethodInterface)paramWebUiBaseInterface);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebUiUtils$QQBrowserBaseActivityInterface == null) && ((paramWebUiBaseInterface instanceof WebUiUtils.QQBrowserBaseActivityInterface))) {
      this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebUiUtils$QQBrowserBaseActivityInterface = ((WebUiUtils.QQBrowserBaseActivityInterface)paramWebUiBaseInterface);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebUiUtils$WebShareReportInterface == null) && ((paramWebUiBaseInterface instanceof WebUiUtils.WebShareReportInterface))) {
      this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebUiUtils$WebShareReportInterface = ((WebUiUtils.WebShareReportInterface)paramWebUiBaseInterface);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebUiUtils$WebShareInterface == null) && ((paramWebUiBaseInterface instanceof WebUiUtils.WebShareInterface))) {
      this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebUiUtils$WebShareInterface = ((WebUiUtils.WebShareInterface)paramWebUiBaseInterface);
    }
  }
  
  public void a(WebViewPlugin paramWebViewPlugin)
  {
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin = paramWebViewPlugin;
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin$PluginRuntime = paramWebViewPlugin.mRuntime;
    paramWebViewPlugin = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin$PluginRuntime.a(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin$PluginRuntime.a());
    if ((paramWebViewPlugin != null) && ((paramWebViewPlugin instanceof WebUiUtils.WebUiMethodInterface))) {
      this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebUiUtils$WebUiMethodInterface = ((WebUiUtils.WebUiMethodInterface)paramWebViewPlugin);
    }
    paramWebViewPlugin = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin$PluginRuntime.a(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin$PluginRuntime.a());
    if ((paramWebViewPlugin != null) && ((paramWebViewPlugin instanceof WebUiUtils.QQBrowserBaseActivityInterface))) {
      this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebUiUtils$QQBrowserBaseActivityInterface = ((WebUiUtils.QQBrowserBaseActivityInterface)paramWebViewPlugin);
    }
    paramWebViewPlugin = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin$PluginRuntime.a(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin$PluginRuntime.a());
    if ((paramWebViewPlugin != null) && ((paramWebViewPlugin instanceof WebUiUtils.WebShareReportInterface))) {
      this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebUiUtils$WebShareReportInterface = ((WebUiUtils.WebShareReportInterface)paramWebViewPlugin);
    }
    paramWebViewPlugin = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin$PluginRuntime.a(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin$PluginRuntime.a());
    if ((paramWebViewPlugin != null) && ((paramWebViewPlugin instanceof WebUiUtils.WebShareInterface))) {
      this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebUiUtils$WebShareInterface = ((WebUiUtils.WebShareInterface)paramWebViewPlugin);
    }
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = null;
    for (;;)
    {
      Intent localIntent;
      try
      {
        if (this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebUiUtils$WebShareInterface != null)
        {
          this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = ((Share)this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebUiUtils$WebShareInterface.getShare()).a();
          if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
            this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
          }
        }
        localIntent = new Intent();
        Object localObject = new JSONObject(paramString);
        this.jdField_a_of_type_JavaLangString = ((JSONObject)localObject).optString("callback");
        paramString = ((JSONObject)localObject).optString("appName");
        if (!AuthorizeConfig.a().d("ark_authorize_config", paramString))
        {
          if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
            break;
          }
          this.jdField_a_of_type_ComTencentMobileqqJspShareMsgImpl$ShareMsgImplListener.onSharMsgcallback(this.jdField_a_of_type_JavaLangString, "{\"result\":2}");
          return;
        }
        String str1 = ((JSONObject)localObject).optString("toUin");
        int i = ((JSONObject)localObject).optInt("uinType", 0);
        String str2 = ((JSONObject)localObject).optString("toNickName");
        if ((str1 != null) && (str1.length() >= 5))
        {
          localIntent.setClass(this.jdField_a_of_type_AndroidContentContext, DirectForwardActivity.class);
          localIntent.putExtra("toUin", str1);
          localIntent.putExtra("uinType", i);
          localIntent.putExtra("nickName", str2);
          localIntent.putExtra("shareQQType", ((JSONObject)localObject).optInt("shareQQType", 13));
          localIntent.putExtra("forward_type", 27);
          localIntent.putExtra("openerProc", MobileQQ.getMobileQQ().getQQProcessName());
          localIntent.putExtra("k_back", ((JSONObject)localObject).optBoolean("k_back", ((JSONObject)localObject).optBoolean("back", false)));
          str1 = ((JSONObject)localObject).optString("appDesc");
          str2 = ((JSONObject)localObject).optString("appMinVersion");
          String str3 = ((JSONObject)localObject).optString("appView");
          String str4 = ((JSONObject)localObject).optString("appConfig");
          String str5 = ((JSONObject)localObject).optString("metaData");
          String str6 = ((JSONObject)localObject).optString("promptText");
          localObject = ((JSONObject)localObject).optString("compatibleText");
          if ((TextUtils.isEmpty(paramString)) || (TextUtils.isEmpty(str3)) || (TextUtils.isEmpty(str5))) {
            this.jdField_a_of_type_ComTencentMobileqqJspShareMsgImpl$ShareMsgImplListener.onSharMsgcallback(this.jdField_a_of_type_JavaLangString, "{\"result\":1}");
          }
          localIntent.putExtra("forward_ark_app_name", paramString);
          localIntent.putExtra("forward_ark_app_view", str3);
          localIntent.putExtra("forward_ark_app_desc", str1);
          localIntent.putExtra("forward_ark_app_ver", str2);
          localIntent.putExtra("forward_ark_app_prompt", str6);
          localIntent.putExtra("forward_ark_app_meta", str5);
          localIntent.putExtra("forward_ark_app_config", str4);
          localIntent.putExtra("forward_ark_app_compat", (String)localObject);
          localIntent.putExtra("is_ark_display_share", true);
          localIntent.putExtra("appName", paramString);
          localIntent.putExtra("appView", str3);
          localIntent.putExtra("appMinVersion", str2);
          localIntent.putExtra("metaData", str5);
          localIntent.putExtra("scale", this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().scaledDensity);
          if (!(this.jdField_a_of_type_AndroidContentContext instanceof QQBrowserActivity)) {
            break label662;
          }
          paramString = ((QQBrowserActivity)this.jdField_a_of_type_AndroidContentContext).getWebViewProvider();
          if (paramString != null)
          {
            paramString = paramString.getCurrentUrl();
            if (!TextUtils.isEmpty(paramString)) {
              localIntent.putExtra("forward_ark_h5_from_js", paramString);
            }
          }
          this.jdField_a_of_type_ComTencentMobileqqJspShareMsgImpl$ShareMsgImplListener.startActivityForResult(localIntent, (byte)3);
          return;
        }
      }
      catch (JSONException paramString)
      {
        this.jdField_a_of_type_ComTencentMobileqqJspShareMsgImpl$ShareMsgImplListener.onSharMsgcallback(this.jdField_a_of_type_JavaLangString, "{\"result\":3}");
        QLog.e("ShareMsgImpl", 1, "shareArkMsg error: " + paramString.toString());
        return;
      }
      localIntent.putExtra("isWebCompShare", true);
      localIntent.setClass(this.jdField_a_of_type_AndroidContentContext, ForwardRecentActivity.class);
      continue;
      label662:
      if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin$PluginRuntime != null)
      {
        paramString = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin$PluginRuntime.a();
        if (paramString != null)
        {
          paramString = paramString.getCurrentUrl();
          if (!TextUtils.isEmpty(paramString)) {
            localIntent.putExtra("forward_ark_h5_from_js", paramString);
          }
        }
        else if (this.jdField_a_of_type_AndroidAppActivity != null)
        {
          paramString = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin$PluginRuntime.a(this.jdField_a_of_type_AndroidAppActivity);
          if ((paramString instanceof WebUiUtils.WebUiMethodInterface))
          {
            paramString = ((WebUiUtils.WebUiMethodInterface)paramString).getCurrentUrl();
            if (!TextUtils.isEmpty(paramString)) {
              localIntent.putExtra("forward_ark_h5_from_js", paramString);
            }
          }
        }
      }
    }
  }
  
  void a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    paramString2 = this.jdField_a_of_type_AndroidAppActivity;
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null) {
      a(paramString2);
    }
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString3)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ShareMsgImpl", 2, "shareMsgToSina empty title or share_url");
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
      }
      QQToast.a(BaseApplication.getContext(), 0, 2131719291, 0).b(BaseApplication.getContext().getResources().getDimensionPixelSize(2131299166));
    }
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("ShareMsgImpl", 2, "shareMsgToSina installSinaWeibo:false");
      }
      try
      {
        paramString1 = URLEncoder.encode(paramString1, "UTF-8");
        paramString1 = "https://service.weibo.com/share/share.php?" + "title=" + paramString1;
        paramString3 = URLEncoder.encode(paramString3, "UTF-8");
        paramString1 = paramString1 + "&url=" + paramString3;
        paramString3 = URLEncoder.encode(paramString4, "UTF-8");
        paramString1 = paramString1 + "&pic=" + paramString3;
        paramString1 = paramString1 + "&_wv=3";
        paramString3 = new Intent(paramString2, QQBrowserActivity.class);
        paramString3.putExtra("url", paramString1);
        paramString2.startActivity(paramString3);
        if (QLog.isColorLevel()) {
          QLog.d("ShareMsgImpl", 2, "shareMsgToSina start webview!");
        }
      }
      catch (Exception paramString1)
      {
        for (;;)
        {
          QQToast.a(BaseApplication.getContext(), 0, 2131719291, 0).b(BaseApplication.getContext().getResources().getDimensionPixelSize(2131299166));
          paramString1.printStackTrace();
          if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
            this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
          }
        }
      }
      finally
      {
        if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null) || (!this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
          break;
        }
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
      }
    } while (!QLog.isColorLevel());
    QLog.d("ShareMsgImpl", 2, "shareMsgToSina end!");
  }
  
  void a(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShareMsgImpl", 2, "shareMsgToQidianOrQiye start: " + paramInt);
    }
    Activity localActivity = this.jdField_a_of_type_AndroidAppActivity;
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null) {
      a(localActivity);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    }
    QidianManager.a(localActivity, paramInt, paramString1, paramString2, paramString3, paramString4, "", 0, false);
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    long l = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("ShareMsgImpl", 2, "dialog get web js time :" + l);
    }
    this.jdField_a_of_type_JavaLangString = null;
    for (;;)
    {
      JSONObject localJSONObject;
      String str1;
      String str2;
      String str3;
      String str4;
      String str5;
      String str6;
      String str7;
      String str8;
      String str9;
      int k;
      String str14;
      try
      {
        localJSONObject = new JSONObject(paramString);
        Activity localActivity = this.jdField_a_of_type_AndroidAppActivity;
        if (!paramBoolean) {
          break label838;
        }
        paramString = "shareType";
        str1 = localJSONObject.optString(paramString, "0");
        str2 = localJSONObject.optString("title");
        str3 = localJSONObject.optString("desc");
        if (!paramBoolean) {
          break label1217;
        }
        paramString = "shareUrl";
        str4 = localJSONObject.optString(paramString);
        if (!paramBoolean) {
          break label1224;
        }
        paramString = "imageUrl";
        paramString = localJSONObject.optString(paramString);
        str5 = localJSONObject.optString("shareElement");
        str6 = localJSONObject.optString("flash_url");
        str7 = localJSONObject.optString("article_id");
        str8 = localJSONObject.optString("rowkey");
        str9 = localJSONObject.optString("isfan");
        k = localJSONObject.optInt("WXShareFromQQKandian");
        String str10 = localJSONObject.optString("short_video_vid");
        String str11 = localJSONObject.optString("short_video_url");
        String str12 = localJSONObject.optString("short_video_cover_url");
        String str13 = localJSONObject.optString("short_video_theme_name");
        str14 = localJSONObject.optString("is_tribe_short_video");
        i = 0;
        if (TextUtils.isEmpty(paramString)) {
          i = 1;
        }
        j = i;
        if (TextUtils.isEmpty(str3)) {
          j = i | 0x2;
        }
        if (!TextUtils.isEmpty(str2)) {
          break label1211;
        }
        i = j | 0x4;
        Object localObject = new Bundle();
        ((Bundle)localObject).putString("report_type", "102");
        ((Bundle)localObject).putString("act_type", "94");
        StringBuilder localStringBuilder = new StringBuilder().append("");
        if (i != 0) {
          break label1231;
        }
        j = 0;
        ((Bundle)localObject).putString("intext_1", j);
        ((Bundle)localObject).putString("intext_2", "" + i);
        ((Bundle)localObject).putString("stringext_1", "" + str4);
        ReportCenter.a().a((Bundle)localObject, "", this.jdField_a_of_type_ComTencentCommonAppAppInterface.getAccount(), false);
        i = localJSONObject.optInt("shareQQType", 13);
        this.jdField_a_of_type_JavaLangString = localJSONObject.optString("callback");
        paramBoolean = localJSONObject.optBoolean("keepShareUrl", false);
        localObject = new HashMap();
        if ((!paramBoolean) && (str4 != null) && (str4.length() > 140) && (!"3".equals(str1))) {
          ((HashMap)localObject).put("share_url", str4);
        }
        if ((paramString != null) && (paramString.length() > 80) && (!"2".equals(str1)) && (!"3".equals(str1)) && (!"4".equals(str1))) {
          ((HashMap)localObject).put("image_url", paramString);
        }
        if ((str6 != null) && (str6.length() > 30)) {
          ((HashMap)localObject).put("flash_url", str6);
        }
        if (!TextUtils.isEmpty(str10)) {
          ((HashMap)localObject).put("short_video_vid", str10);
        }
        if (!TextUtils.isEmpty(str12)) {
          ((HashMap)localObject).put("short_video_cover_url", str12);
        }
        if (!TextUtils.isEmpty(str11)) {
          ((HashMap)localObject).put("short_video_url", str11);
        }
        if (!TextUtils.isEmpty(str13)) {
          ((HashMap)localObject).put("short_video_theme_name", str11);
        }
        if (!TextUtils.isEmpty(str14)) {
          ((HashMap)localObject).put("is_tribe_short_video", str14);
        }
        if ((((HashMap)localObject).isEmpty()) || ("1".equals(str1))) {
          break label845;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null) {
          a(localActivity);
        }
        if (!this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())
        {
          this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(2131693940);
          this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
        }
        ThreadManager.post(new ShareMsgImpl.1(this, (HashMap)localObject, str4, paramString, str6, str1, localJSONObject, str2, str3, str5, str7, str8, str9, k, str14, i, localActivity), 8, null, true);
        return;
      }
      catch (JSONException paramString) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("ShareMsgImpl", 2, "shareMsg error: " + paramString.toString());
      return;
      label838:
      paramString = "share_type";
      continue;
      label845:
      if ("1".equals(str1))
      {
        a(localJSONObject, str1, str2, str3, str4, paramString, str5, str6);
        ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).reportPAShareItemEvent(1002, str4, str7, str8, str9);
        return;
      }
      if (("2".equals(str1)) || ("3".equals(str1)))
      {
        a(localJSONObject, str1, str2, str3, str4, paramString, str5, str6, k);
        if ("2".equals(str1)) {
          ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).reportPAShareItemEvent(1003, str4, str7, str8, str9);
        }
        if (!"3".equals(str1)) {
          break;
        }
        ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).reportPAShareItemEvent(1004, str4, str7, str8, str9);
        return;
      }
      if ("4".equals(str1))
      {
        b(str2, str3, str4, paramString);
        ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).reportPAShareItemEvent(1005, str4, str7, str8, str9);
        return;
      }
      if ("5".equals(str1))
      {
        a(str2, str3, str4, paramString, 6);
        return;
      }
      if ("6".equals(str1))
      {
        a(str2, str3, str4, paramString, 7);
        return;
      }
      if ((!TextUtils.isEmpty(str14)) && (localJSONObject.has("is_tribe_short_video")) && (str14.equals("true")))
      {
        b(localJSONObject, str1, str2, str3, str4, paramString, str5, str6, i);
        return;
      }
      c(localJSONObject, str1, str2, str3, str4, paramString, str5, str6, i);
      ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).reportPAShareItemEvent(1001, str4, str7, str8, str9);
      return;
      label1211:
      int i = j;
      continue;
      label1217:
      paramString = "share_url";
      continue;
      label1224:
      paramString = "image_url";
      continue;
      label1231:
      int j = 1;
    }
  }
  
  /* Error */
  void a(JSONObject paramJSONObject)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 99	com/tencent/mobileqq/jsp/ShareMsgImpl:jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin$PluginRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   4: ifnull +293 -> 297
    //   7: aload_0
    //   8: getfield 99	com/tencent/mobileqq/jsp/ShareMsgImpl:jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin$PluginRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   11: invokevirtual 624	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/biz/pubaccount/CustomWebView;
    //   14: invokevirtual 630	com/tencent/biz/pubaccount/CustomWebView:getPluginEngine	()Lcom/tencent/mobileqq/webview/swift/WebViewPluginEngine;
    //   17: astore_3
    //   18: aload_0
    //   19: getfield 99	com/tencent/mobileqq/jsp/ShareMsgImpl:jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin$PluginRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   22: invokevirtual 377	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/mobileqq/webview/swift/WebViewProvider;
    //   25: invokeinterface 342 1 0
    //   30: astore 4
    //   32: aload_3
    //   33: invokevirtual 633	com/tencent/mobileqq/webview/swift/WebViewPluginEngine:a	()Lcom/tencent/biz/AuthorizeConfig;
    //   36: aload 4
    //   38: ldc_w 635
    //   41: invokevirtual 637	com/tencent/biz/AuthorizeConfig:a	(Ljava/lang/String;Ljava/lang/String;)Z
    //   44: istore_2
    //   45: iload_2
    //   46: ifne +38 -> 84
    //   49: ldc_w 352
    //   52: iconst_1
    //   53: ldc_w 639
    //   56: invokestatic 371	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   59: aload_0
    //   60: getfield 54	com/tencent/mobileqq/jsp/ShareMsgImpl:jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   63: ifnull +239 -> 302
    //   66: aload_0
    //   67: getfield 54	com/tencent/mobileqq/jsp/ShareMsgImpl:jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   70: invokevirtual 60	com/tencent/mobileqq/widget/QQProgressDialog:isShowing	()Z
    //   73: ifeq +229 -> 302
    //   76: aload_0
    //   77: getfield 54	com/tencent/mobileqq/jsp/ShareMsgImpl:jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   80: invokevirtual 63	com/tencent/mobileqq/widget/QQProgressDialog:dismiss	()V
    //   83: return
    //   84: aload_1
    //   85: ldc_w 641
    //   88: invokevirtual 644	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   91: astore_3
    //   92: aload_1
    //   93: ldc_w 646
    //   96: invokevirtual 644	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   99: astore 4
    //   101: aload_1
    //   102: ldc_w 648
    //   105: invokevirtual 644	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   108: astore 5
    //   110: aload_1
    //   111: ldc_w 477
    //   114: invokevirtual 644	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   117: astore 6
    //   119: aload_1
    //   120: ldc_w 650
    //   123: ldc_w 652
    //   126: invokevirtual 473	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   129: astore 7
    //   131: aload_1
    //   132: ldc_w 654
    //   135: ldc_w 450
    //   138: invokevirtual 473	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   141: astore_1
    //   142: new 197	org/json/JSONObject
    //   145: dup
    //   146: aload_1
    //   147: invokespecial 199	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   150: ldc_w 656
    //   153: invokevirtual 644	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   156: astore_1
    //   157: new 541	java/util/HashMap
    //   160: dup
    //   161: invokespecial 542	java/util/HashMap:<init>	()V
    //   164: astore 8
    //   166: aload 8
    //   168: ldc_w 650
    //   171: aload 7
    //   173: invokeinterface 659 3 0
    //   178: pop
    //   179: aload 8
    //   181: ldc_w 656
    //   184: aload_1
    //   185: invokeinterface 659 3 0
    //   190: pop
    //   191: aload 8
    //   193: ldc_w 477
    //   196: aload 6
    //   198: invokeinterface 659 3 0
    //   203: pop
    //   204: aload_0
    //   205: getfield 40	com/tencent/mobileqq/jsp/ShareMsgImpl:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   208: astore_1
    //   209: aload_1
    //   210: ifnull +37 -> 247
    //   213: aload_1
    //   214: aload_3
    //   215: aload 4
    //   217: aload 5
    //   219: ldc_w 450
    //   222: aload_1
    //   223: invokevirtual 128	android/app/Activity:getResources	()Landroid/content/res/Resources;
    //   226: invokevirtual 322	android/content/res/Resources:getDisplayMetrics	()Landroid/util/DisplayMetrics;
    //   229: getfield 328	android/util/DisplayMetrics:scaledDensity	F
    //   232: aload 8
    //   234: invokestatic 664	com/tencent/mobileqq/activity/ArkFullScreenAppActivity:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;FLjava/util/Map;)Landroid/content/Intent;
    //   237: astore_3
    //   238: aload_3
    //   239: ifnull +8 -> 247
    //   242: aload_1
    //   243: aload_3
    //   244: invokestatic 669	com/tencent/mobileqq/forward/ForwardBaseOption:a	(Landroid/content/Context;Landroid/content/Intent;)V
    //   247: aload_0
    //   248: getfield 54	com/tencent/mobileqq/jsp/ShareMsgImpl:jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   251: ifnull +51 -> 302
    //   254: aload_0
    //   255: getfield 54	com/tencent/mobileqq/jsp/ShareMsgImpl:jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   258: invokevirtual 60	com/tencent/mobileqq/widget/QQProgressDialog:isShowing	()Z
    //   261: ifeq +41 -> 302
    //   264: aload_0
    //   265: getfield 54	com/tencent/mobileqq/jsp/ShareMsgImpl:jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   268: invokevirtual 63	com/tencent/mobileqq/widget/QQProgressDialog:dismiss	()V
    //   271: return
    //   272: astore_1
    //   273: ldc_w 352
    //   276: iconst_1
    //   277: ldc_w 671
    //   280: aload_1
    //   281: invokestatic 674	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   284: return
    //   285: astore_1
    //   286: aload_1
    //   287: invokevirtual 675	org/json/JSONException:printStackTrace	()V
    //   290: ldc_w 450
    //   293: astore_1
    //   294: goto -137 -> 157
    //   297: iconst_1
    //   298: istore_2
    //   299: goto -254 -> 45
    //   302: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	303	0	this	ShareMsgImpl
    //   0	303	1	paramJSONObject	JSONObject
    //   44	255	2	bool	boolean
    //   17	227	3	localObject	Object
    //   30	186	4	str1	String
    //   108	110	5	str2	String
    //   117	80	6	str3	String
    //   129	43	7	str4	String
    //   164	69	8	localHashMap	HashMap
    // Exception table:
    //   from	to	target	type
    //   0	45	272	java/lang/Exception
    //   49	83	272	java/lang/Exception
    //   84	142	272	java/lang/Exception
    //   142	157	272	java/lang/Exception
    //   157	209	272	java/lang/Exception
    //   213	238	272	java/lang/Exception
    //   242	247	272	java/lang/Exception
    //   247	271	272	java/lang/Exception
    //   286	290	272	java/lang/Exception
    //   142	157	285	org/json/JSONException
  }
  
  void a(JSONObject paramJSONObject, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    paramString1 = this.jdField_a_of_type_AndroidAppActivity;
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null) {
      a(paramString1);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    }
    paramString6 = new Bundle();
    paramString6.putString("title", paramString2);
    paramString6.putString("desc", paramString3);
    paramString6.putString("detail_url", paramString4);
    paramString6.putString("from", "qq");
    if (paramJSONObject != null) {
      paramString6.putString("default_text", paramJSONObject.optString("default_text"));
    }
    paramJSONObject = new ArrayList(1);
    paramJSONObject.add(paramString5);
    paramString6.putStringArrayList("image_url", paramJSONObject);
    paramString6.putLong("req_share_id", 0L);
    paramString6.putInt("iUrlInfoFrm", 1);
    paramString6.putLong("share_begin_time", SwiftBrowserShareMenuHandler.b);
    if ((this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebUiUtils$WebShareReportInterface != null) && (this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebUiUtils$WebUiMethodInterface != null))
    {
      paramString6.putString("strurt_msgid", this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebUiUtils$WebShareReportInterface.getMsgid());
      paramString6.putString("struct_uin", this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebUiUtils$WebShareReportInterface.getPublicUin());
      paramString6.putString("struct_url", this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebUiUtils$WebUiMethodInterface.getCurrentUrl());
      paramString6.putBoolean("from_web", true);
      if ((this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebUiUtils$WebShareReportInterface.getSourcePuin() != null) && (!"".equals(this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebUiUtils$WebShareReportInterface.getSourcePuin()))) {
        paramString6.putString("source_puin", this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebUiUtils$WebShareReportInterface.getSourcePuin());
      }
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebUiUtils$QQBrowserBaseActivityInterface != null) && (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin != null)) {}
    for (int i = this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebUiUtils$QQBrowserBaseActivityInterface.switchRequestCode(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin, (byte)1, true);; i = 1)
    {
      if (paramString1.getIntent().getBooleanExtra("confess_half_screen_web", false)) {
        i = 15001;
      }
      if (QZoneShareManager.jumpToQzoneShare(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_AndroidContentContext, paramString6, null, i)) {
        return;
      }
      QRUtils.a(1, 2131689486);
      this.jdField_a_of_type_ComTencentMobileqqJspShareMsgImpl$ShareMsgImplListener.onSharMsgcallback(this.jdField_a_of_type_JavaLangString, "false");
      return;
    }
  }
  
  void a(JSONObject paramJSONObject, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, int paramInt)
  {
    paramJSONObject = this.jdField_a_of_type_AndroidAppActivity;
    int i = -1;
    if (!WXShareHelper.a().a()) {
      i = 2131720753;
    }
    while (i != -1)
    {
      QRUtils.a(0, i);
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null) {
        a(paramJSONObject);
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
      }
      return;
      if (!WXShareHelper.a().b()) {
        i = 2131720754;
      }
    }
    HashMap localHashMap = new HashMap(1);
    paramString2 = new ShareMsgImpl.3(this, paramString1, paramString4, paramInt, localHashMap, paramString6, paramString2, paramString3, paramString7);
    if (TextUtils.isEmpty(paramString5))
    {
      paramString2.run();
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null) {
      a(paramJSONObject);
    }
    if (!this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(2131693940);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
    }
    ThreadManager.post(new ShareMsgImpl.4(this, paramString5, localHashMap, paramString2, paramString1, paramString4), 8, null, false);
  }
  
  public boolean a(String paramString)
  {
    return (this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebUiUtils$WebShareInterface != null) && (this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebUiUtils$WebShareInterface.setShareUrl(paramString));
  }
  
  public void b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return;
      this.jdField_a_of_type_JavaLangString = null;
      try
      {
        paramString = new JSONObject(paramString);
        Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, ForwardRecentActivity.class);
        localIntent.putExtra("isFromShare", true);
        String str = paramString.optString("toUin");
        int i = paramString.optInt("uinType", 0);
        if ((str != null) && (str.length() >= 5))
        {
          localIntent.setClass(this.jdField_a_of_type_AndroidContentContext, DirectForwardActivity.class);
          localIntent.putExtra("toUin", str);
          localIntent.putExtra("uinType", i);
        }
        localIntent.putExtra("forward_type", -1);
        localIntent.putExtra("forward_text", paramString.optString("text"));
        this.jdField_a_of_type_JavaLangString = paramString.optString("callback");
        if (paramString.has("report")) {
          localIntent.putExtra("report", paramString.getString("report"));
        }
        localIntent.putExtra("openerProc", MobileQQ.getMobileQQ().getQQProcessName());
        this.jdField_a_of_type_ComTencentMobileqqJspShareMsgImpl$ShareMsgImplListener.startActivityForResult(localIntent, (byte)1);
        return;
      }
      catch (JSONException paramString) {}
    } while (!QLog.isColorLevel());
    QLog.d("ShareMsgImpl", 2, "shareText error: " + paramString.getMessage());
  }
  
  void b(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShareMsgImpl", 2, "shareMsgToSina start!");
    }
    try
    {
      Object localObject1 = Uri.parse(paramString3);
      if (localObject1 != null)
      {
        localObject1 = ((Uri)localObject1).getHost();
        if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (("article.mp.qq.com".equalsIgnoreCase((String)localObject1)) || ("post.mp.qq.com".equalsIgnoreCase((String)localObject1))))
        {
          a(paramString1, paramString2, paramString3, paramString4);
          return;
        }
      }
    }
    catch (Exception localException)
    {
      do
      {
        Activity localActivity = this.jdField_a_of_type_AndroidAppActivity;
        if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null) {
          a(localActivity);
        }
        if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString3)))
        {
          if (QLog.isColorLevel()) {
            QLog.d("ShareMsgImpl", 2, "shareMsgToSina empty title or share_url");
          }
          if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
            this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
          }
          QQToast.a(BaseApplication.getContext(), 0, 2131719291, 0).b(BaseApplication.getContext().getResources().getDimensionPixelSize(2131299166));
          return;
        }
        Object localObject2 = BaseApplicationImpl.getContext().getPackageManager();
        try
        {
          localObject2 = ((PackageManager)localObject2).getApplicationInfo("com.sina.weibo", 8192);
          if (QLog.isColorLevel()) {
            QLog.d("ShareMsgImpl", 2, "shareMsgToSina installSinaWeibo:true");
          }
          ThreadManager.executeOnSubThread(new ShareMsgImpl.2(this, paramString4, localActivity, paramString1, paramString2, paramString3, (ApplicationInfo)localObject2));
        }
        catch (PackageManager.NameNotFoundException paramString2)
        {
          for (;;)
          {
            if (!QLog.isColorLevel()) {
              break label267;
            }
            QLog.d("ShareMsgImpl", 2, "shareMsgToSina installSinaWeibo:false");
            try
            {
              paramString1 = URLEncoder.encode(paramString1, "UTF-8");
              paramString1 = "https://service.weibo.com/share/share.php?" + "title=" + paramString1;
              paramString2 = URLEncoder.encode(paramString3, "UTF-8");
              paramString1 = paramString1 + "&url=" + paramString2;
              paramString2 = URLEncoder.encode(paramString4, "UTF-8");
              paramString1 = paramString1 + "&pic=" + paramString2;
              paramString1 = paramString1 + "&_wv=3";
              paramString2 = new Intent(localActivity, QQBrowserActivity.class);
              paramString2.putExtra("url", paramString1);
              localActivity.startActivity(paramString2);
              if (!QLog.isColorLevel()) {
                break label434;
              }
              QLog.d("ShareMsgImpl", 2, "shareMsgToSina start webview!");
              if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null) || (!this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
                continue;
              }
              this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
            }
            catch (Exception paramString1)
            {
              QQToast.a(BaseApplication.getContext(), 0, 2131719291, 0).b(BaseApplication.getContext().getResources().getDimensionPixelSize(2131299166));
              paramString1.printStackTrace();
              if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null) || (!this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
                continue;
              }
              this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
            }
            finally
            {
              if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null) || (!this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
                break label544;
              }
              this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
            }
          }
        }
      } while (!QLog.isColorLevel());
      QLog.d("ShareMsgImpl", 2, "shareMsgToSina end!");
      return;
    }
  }
  
  void b(JSONObject paramJSONObject, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, int paramInt)
  {
    Activity localActivity = this.jdField_a_of_type_AndroidAppActivity;
    Intent localIntent = new Intent();
    paramString1 = paramJSONObject.optString("toUin");
    int i = paramJSONObject.optInt("uinType", 0);
    String str1;
    String str2;
    int j;
    if ((paramString1 != null) && (paramString1.length() >= 5))
    {
      localIntent.setClass(this.jdField_a_of_type_AndroidContentContext, DirectForwardActivity.class);
      localIntent.putExtra("toUin", paramString1);
      localIntent.putExtra("uinType", i);
      localIntent.putExtra("key_flag_from_plugin", true);
      paramString5 = paramString2;
      if (paramString2 != null)
      {
        paramString5 = paramString2;
        if (paramString2.length() > 45) {
          paramString5 = paramString2.substring(0, 45) + "…";
        }
      }
      i = paramInt;
      if (paramInt <= 0) {
        i = 13;
      }
      paramString2 = "";
      paramString3 = "";
      paramString1 = "";
      paramString6 = "";
      paramString7 = "";
      str1 = "";
      str2 = "";
      if ((!paramJSONObject.has("is_tribe_short_video")) || (!paramJSONObject.getString("is_tribe_short_video").equals("true"))) {
        break label1073;
      }
      paramInt = 0;
      j = 0;
      if (paramJSONObject.has("tribe_video_vid")) {
        paramString2 = paramJSONObject.getString("tribe_video_vid");
      }
      if (paramJSONObject.has("tribe_video_url")) {
        paramString3 = paramJSONObject.getString("tribe_video_url");
      }
      if (paramJSONObject.has("tribe_video_theme")) {
        paramString6 = paramJSONObject.getString("tribe_video_theme");
      }
      if (paramJSONObject.has("tribe_cover_url")) {
        paramString1 = paramJSONObject.getString("tribe_cover_url");
      }
      if (paramJSONObject.has("tribe_video_width")) {
        paramInt = paramJSONObject.getInt("tribe_video_width");
      }
      if (paramJSONObject.has("tribe_video_height")) {
        j = paramJSONObject.getInt("tribe_video_height");
      }
      if (paramJSONObject.has("tribe_name")) {
        paramString7 = paramJSONObject.getString("tribe_name");
      }
      if (paramJSONObject.has("tribe_bid")) {
        str1 = paramJSONObject.getString("tribe_bid");
      }
      if (paramJSONObject.has("tribe_pid")) {
        str2 = paramJSONObject.getString("tribe_pid");
      }
      localIntent.putExtra("forward_type", 36);
    }
    for (;;)
    {
      try
      {
        localJSONObject = new JSONObject();
      }
      catch (Exception paramString6)
      {
        boolean bool;
        paramString2 = null;
      }
      try
      {
        localJSONObject.put("is_tribe_short_video", 1);
        localJSONObject.put("tribe_name", paramString7);
        localJSONObject.put("tribe_video_vid", paramString2);
        localJSONObject.put("tribe_video_url", paramString3);
        localJSONObject.put("tribe_video_theme", paramString6);
        localJSONObject.put("tribe_video_width", paramInt);
        localJSONObject.put("tribe_video_height", j);
        localJSONObject.put("tribe_bid", str1);
        localJSONObject.put("tribe_pid", str2);
        localIntent.putExtra("qqtribeVideoInfoExtra ", localJSONObject.toString());
        paramString3 = localJSONObject;
        paramString6 = paramString3;
        localIntent.putExtra("pluginName", "web_share");
        localIntent.putExtra("title", paramString5);
        localIntent.putExtra("shareQQType", i);
        localIntent.putExtra("forward_type", 36);
        localIntent.putExtra("req_share_id", paramJSONObject.optLong("appid", -1L));
        localIntent.putExtra("pkg_name", "com.tencent.mobileqq");
        localIntent.putExtra("image_url_remote", paramString1);
        localIntent.putExtra("brief_key", paramJSONObject.optString("desc"));
        localIntent.putExtra("flag", paramJSONObject.optInt("flag", 0));
        localIntent.putExtra("detail_url", paramString4);
        localIntent.putExtra("req_type", 118);
        localIntent.putExtra("openerProc", MobileQQ.getMobileQQ().getQQProcessName());
        bool = paramJSONObject.optBoolean("back", false);
        if (paramJSONObject.has("k_back")) {
          bool = paramJSONObject.getBoolean("k_back");
        }
        localIntent.putExtra("k_back", bool);
        if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null) {
          a(localActivity);
        }
        if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing()))
        {
          long l = System.currentTimeMillis();
          if (QLog.isColorLevel()) {
            QLog.d("ShareMsgImpl", 2, "dialog dimiss time :" + l);
          }
          this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
        }
        paramString1 = paramJSONObject.optString("puin", null);
        if (paramString1 != null) {
          break label1157;
        }
        paramString1 = paramJSONObject.optString("oaUin");
      }
      catch (Exception paramString6)
      {
        for (;;)
        {
          paramString2 = localJSONObject;
        }
        paramString3 = null;
        continue;
        continue;
      }
      if (!TextUtils.isEmpty(paramString1))
      {
        paramString2 = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getEntityManagerFactory(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getAccount()).createEntityManager();
        paramString3 = (AccountDetail)paramString2.find(AccountDetail.class, paramString1);
        paramString2.close();
        if (paramString3 == null) {
          break label1151;
        }
        paramString3 = paramString3.name;
        paramString2 = paramString3;
        if (TextUtils.isEmpty(paramString3))
        {
          paramString2 = paramString3;
          if (paramJSONObject.has("sourceName")) {
            paramString2 = paramJSONObject.optString("sourceName");
          }
        }
        paramString3 = paramString2;
        if (TextUtils.isEmpty(paramString2)) {
          paramString3 = paramString1;
        }
        localIntent.putExtra("source_url", paramJSONObject.optString("source_url", ""));
        localIntent.putExtra("struct_share_key_source_action", "web");
        localIntent.putExtra("source_puin", paramString1);
        localIntent.putExtra("app_name", paramString3);
        localIntent.putExtra("req_type", 118);
        paramJSONObject = StructMsgFactory.a(localIntent.getExtras());
        if (paramJSONObject != null) {
          break label1095;
        }
        if (QLog.isColorLevel()) {
          QLog.d("ShareMsgImpl", 2, "build struct msg fail");
        }
        this.jdField_a_of_type_ComTencentMobileqqJspShareMsgImpl$ShareMsgImplListener.onSharMsgcallback(this.jdField_a_of_type_JavaLangString, "false");
      }
      return;
      localIntent.putExtra("isWebCompShare", true);
      localIntent.setClass(this.jdField_a_of_type_AndroidContentContext, ForwardRecentActivity.class);
      break;
      paramString3 = paramString2;
      if (QLog.isColorLevel())
      {
        QLog.d("ShareMsgImpl", 2, QLog.getStackTraceString(paramString6));
        paramString3 = paramString2;
        continue;
        label1073:
        if (QLog.isColorLevel()) {
          QLog.w("ShareMsgImpl", 2, "forward short video is false");
        }
        paramString6 = null;
      }
    }
    label1095:
    paramJSONObject.mMsgServiceID = 118;
    paramJSONObject.mTribeShortVideoExtra = paramString6.toString();
    paramJSONObject.mCompatibleText = MessageForTribeShortVideo.buildCompatibleText();
    localIntent.putExtra("stuctmsg_bytes", paramJSONObject.getBytes());
    this.jdField_a_of_type_ComTencentMobileqqJspShareMsgImpl$ShareMsgImplListener.startActivityForResult(localIntent, (byte)4);
  }
  
  public boolean b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ShareMsgImpl", 2, "setShareInfo been called");
    }
    Bundle localBundle = new Bundle();
    for (;;)
    {
      Object localObject;
      try
      {
        paramString = new JSONObject(paramString);
        String str1 = paramString.optString("title");
        String str2 = paramString.optString("desc");
        String str3 = paramString.optString("share_url");
        String str4 = paramString.optString("image_url");
        localObject = paramString.optString("type");
        String str5 = paramString.optString("miniprogram_image_url");
        String str6 = paramString.optString("cover_url");
        String str7 = paramString.optString("source_name");
        String str8 = paramString.optString("article_id");
        boolean bool1 = paramString.optBoolean("editable", true);
        String str9 = paramString.optString("policy");
        boolean bool2 = paramString.optBoolean("isCreator", false);
        String str10 = paramString.optString("singleLineTitle");
        boolean bool3 = paramString.optBoolean("contentEdited");
        boolean bool4 = paramString.optBoolean("isNewCreate");
        String str11 = paramString.optString("groupCode");
        String str12 = paramString.optString("domainId");
        String str13 = paramString.optString("localPadId");
        if (!TextUtils.isEmpty(str6)) {
          localBundle.putString("cover_url", str6);
        }
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          localBundle.putString("type", (String)localObject);
        }
        if (!TextUtils.isEmpty(str5)) {
          localBundle.putString("miniprogram_image_url", str5);
        }
        if (!TextUtils.isEmpty(str7)) {
          localBundle.putString("source_name", str7);
        }
        if (!TextUtils.isEmpty(str8)) {
          localBundle.putString("article_id", str8);
        }
        if (!TextUtils.isEmpty(str10)) {
          localBundle.putString("singleLineTitle", str10);
        }
        localBundle.putBoolean("editable", bool1);
        localBundle.putBoolean("isCreator", bool2);
        if (!TextUtils.isEmpty(str9)) {
          localBundle.putString("policy", str9);
        }
        localBundle.putBoolean("contentEdited", bool3);
        localBundle.putBoolean("isNewCreate", bool4);
        if (!TextUtils.isEmpty(str11)) {
          localBundle.putString("groupCode", str11);
        }
        if (!TextUtils.isEmpty(str12)) {
          localBundle.putString("domainId", str12);
        }
        if (!TextUtils.isEmpty(str13)) {
          localBundle.putString("localPadId", str13);
        }
        localObject = this.jdField_a_of_type_AndroidAppActivity;
        if ((localObject != null) && ((localObject instanceof TeamWorkDocEditBrowserActivity)))
        {
          paramString = paramString.optString("type");
          if (!TextUtils.isEmpty(paramString))
          {
            if (!"docx".equals(paramString)) {
              break label556;
            }
            ((TeamWorkDocEditBrowserActivity)localObject).a(1);
          }
        }
        paramString = null;
        if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin$PluginRuntime != null) {
          paramString = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin$PluginRuntime.a(this.jdField_a_of_type_AndroidAppActivity);
        }
        if ((paramString == null) || (!(paramString instanceof WebUiUtils.WebShareInterface))) {
          break;
        }
        localBundle.putInt("extra_url_info_from", 1);
        return ((WebUiUtils.WebShareInterface)paramString).setSummary(str1, str2, str3, str4, localBundle);
      }
      catch (JSONException paramString)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ShareMsgImpl", 2, "setShareInfo param error");
        }
        return false;
      }
      label556:
      if ("sheet".equals(paramString)) {
        ((TeamWorkDocEditBrowserActivity)localObject).a(2);
      }
    }
    return false;
  }
  
  public void c(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    for (;;)
    {
      Object localObject;
      try
      {
        localObject = new JSONObject(paramString);
        if (!"0".equals(((JSONObject)localObject).optString("share_type", "0"))) {
          break;
        }
        paramString = new Intent(this.jdField_a_of_type_AndroidContentContext, ForwardRecentActivity.class);
        paramString.putExtra("pluginName", "web_share");
        paramString.putExtra("forward_type", -4);
        paramString.putExtra("openerProc", MobileQQ.getMobileQQ().getQQProcessName());
        paramString.putExtra("req_type", 3);
        paramString.putExtra("k_back", false);
        paramString.putExtra("key_flag_from_plugin", true);
        paramString.putExtra("forward_text", ((JSONObject)localObject).optString("text"));
        paramString.putExtra("struct_share_key_source_name", ((JSONObject)localObject).optString("srcName"));
        paramString.putExtra("struct_share_key_source_icon", ((JSONObject)localObject).optString("srcIconUrl"));
        paramString.putExtra("struct_share_key_source_url", ((JSONObject)localObject).optString("srcUrl"));
        localObject = StructMsgFactory.a(paramString.getExtras());
        if (localObject != null) {
          break label251;
        }
        if (QLog.isColorLevel()) {
          QLog.d("ShareMsgImpl", 2, "build struct msg fail");
        }
        this.jdField_a_of_type_ComTencentMobileqqJspShareMsgImpl$ShareMsgImplListener.startActivityForResult(paramString, (byte)1);
        return;
      }
      catch (JSONException paramString) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("ShareMsgImpl", 2, "shareHyperText error: " + paramString.getMessage());
      return;
      label251:
      paramString.putExtra("stuctmsg_bytes", ((AbsStructMsg)localObject).getBytes());
    }
  }
  
  void c(JSONObject paramJSONObject, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, int paramInt)
  {
    if ((paramJSONObject.has("isArkMessage")) && (paramJSONObject.getBoolean("isArkMessage")))
    {
      a(paramJSONObject);
      return;
    }
    Activity localActivity = this.jdField_a_of_type_AndroidAppActivity;
    Intent localIntent = new Intent();
    String str = paramJSONObject.optString("toUin");
    int i = paramJSONObject.optInt("uinType", 0);
    localIntent.putExtra("forward_source_business_type", 100500);
    Bundle localBundle;
    if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin$PluginRuntime != null)
    {
      paramString1 = (SwiftBrowserShareMenuHandler)this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin$PluginRuntime.a().getComponentProvider().a(4);
      localBundle = paramString1.a();
      if (TextUtils.isEmpty(paramString1.e))
      {
        paramString1 = "";
        localIntent.putExtra("forward_source_sub_business_type", paramString1);
      }
    }
    for (;;)
    {
      int j;
      if ((TextUtils.isEmpty(str)) && (i == 0) && (localBundle != null) && (!localBundle.isEmpty()))
      {
        str = localBundle.getString("to_qq");
        j = localBundle.getInt("to_uin_type");
        i = j;
        paramString1 = str;
        if (QLog.isColorLevel())
        {
          QLog.d("ShareMsgImpl", 2, "shareMsgToQQ() called : toUin = " + str + ", uinType = " + j);
          paramString1 = str;
          i = j;
        }
      }
      for (;;)
      {
        str = paramJSONObject.optString("toNickName");
        j = paramJSONObject.optInt("isEncryptUin", 0);
        if ((paramString1 != null) && (paramString1.length() >= 5))
        {
          localIntent.setClass(this.jdField_a_of_type_AndroidContentContext, DirectForwardActivity.class);
          localIntent.putExtra("toUin", paramString1);
          localIntent.putExtra("uinType", i);
          if (j == 1)
          {
            localIntent.putExtra("isEncryptUin", j);
            localIntent.putExtra("vfwebqq", paramJSONObject.optString("vfwebqq"));
            localIntent.putExtra("tok", paramJSONObject.optString("tok"));
          }
          if ((!TextUtils.isEmpty(str)) || (localBundle == null) || (localBundle.isEmpty())) {
            break label2439;
          }
          paramString1 = localBundle.getString("to_uin_name");
          if (QLog.isColorLevel()) {
            QLog.d("ShareMsgImpl", 2, "shareMsgToQQ() called : nickName = " + paramString1);
          }
          localIntent.putExtra("nickName", paramString1);
        }
        for (;;)
        {
          if ((this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin == null) && (!TextUtils.isEmpty(paramString1))) {
            localIntent.putExtra("nickName", paramString1);
          }
          label437:
          localIntent.putExtra("key_flag_from_plugin", true);
          paramString1 = null;
          if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin$PluginRuntime != null) {
            paramString1 = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin$PluginRuntime.a();
          }
          if (paramString1 != null)
          {
            paramString1 = (SwiftBrowserShareMenuHandler)paramString1.getComponentProvider().a(4);
            if ((paramString1 == null) || (paramString1.a == null) || (!paramString1.a.a(localIntent))) {}
          }
          label1924:
          label1932:
          for (i = 38;; i = 1001)
          {
            paramString1 = paramString2;
            if (paramString2 != null)
            {
              paramString1 = paramString2;
              if (paramString2.length() > 45) {
                paramString1 = paramString2.substring(0, 45) + "…";
              }
            }
            paramString2 = paramString3;
            if (paramString3 != null)
            {
              paramString2 = paramString3;
              if (paramString3.length() > 60) {
                paramString2 = paramString3.substring(0, 60) + "…";
              }
            }
            j = paramInt;
            if (paramInt <= 0) {
              j = 13;
            }
            localIntent.putExtra("pluginName", "web_share");
            localIntent.putExtra("title", paramString1);
            localIntent.putExtra("desc", paramString2);
            localIntent.putExtra("detail_url", paramString4);
            localIntent.putExtra("shareQQType", j);
            localIntent.putExtra("forward_type", i);
            localIntent.putExtra("req_share_id", paramJSONObject.optLong("appid", -1L));
            localIntent.putExtra("pkg_name", "com.tencent.mobileqq");
            localIntent.putExtra("image_url_remote", paramString5);
            localIntent.putExtra("brief_key", BaseApplicationImpl.getContext().getString(2131696382, new Object[] { paramString1 }));
            localIntent.putExtra("flag", paramJSONObject.optInt("flag", 0));
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
            if ("audio".equals(paramString6))
            {
              paramInt = 2;
              localIntent.putExtra("audio_url", paramString7);
            }
            boolean bool;
            long l;
            for (;;)
            {
              localIntent.putExtra("req_type", paramInt);
              if (paramJSONObject.has("report")) {
                localIntent.putExtra("report", paramJSONObject.getString("report"));
              }
              localIntent.putExtra("openerProc", MobileQQ.getMobileQQ().getQQProcessName());
              bool = paramJSONObject.optBoolean("back", false);
              if (paramJSONObject.has("k_back")) {
                bool = paramJSONObject.getBoolean("k_back");
              }
              localIntent.putExtra("k_back", bool);
              if (paramJSONObject.has("serviceID")) {
                localIntent.putExtra("new_share_service_id", paramJSONObject.getString("serviceID"));
              }
              if (paramJSONObject.has("serviceID"))
              {
                paramInt = paramJSONObject.getInt("serviceID");
                if ((paramInt == 116) || (paramInt == 123)) {
                  localIntent.putExtra("compatible_text", ConfessMsgUtil.jdField_a_of_type_JavaLangString);
                }
              }
              if (paramJSONObject.has("need_send_long_msg_when_failed")) {
                localIntent.putExtra("need_send_long_msg_when_failed", paramJSONObject.optBoolean("need_send_long_msg_when_failed"));
              }
              l = paramJSONObject.optLong("appid", 0L);
              if (l <= 0L) {
                break label1337;
              }
              paramJSONObject = this.jdField_a_of_type_ComTencentCommonAppAppInterface;
              if (paramJSONObject != null)
              {
                if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null) {
                  a(localActivity);
                }
                if (!this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())
                {
                  this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(2131693940);
                  this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
                }
                localIntent.putExtra("struct_share_key_source_name", Long.toString(l));
                Share.a(paramJSONObject, this.jdField_a_of_type_AndroidContentContext, paramJSONObject.getAccount(), l, 3000L, new ShareMsgImpl.5(this, localIntent, l, paramString4));
              }
              label1247:
              if (localBundle == null) {
                break label2415;
              }
              localBundle.clear();
              return;
              paramString1 = paramString1.e;
              break;
              localIntent.putExtra("isWebCompShare", true);
              localIntent.setClass(this.jdField_a_of_type_AndroidContentContext, ForwardRecentActivity.class);
              break label437;
              i = paramJSONObject.optInt("req_type", 146);
              paramInt = i;
              if (i == 2)
              {
                localIntent.putExtra("audio_url", paramJSONObject.getString("audio_url"));
                paramInt = i;
              }
            }
            label1337:
            if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null) {
              a(localActivity);
            }
            if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing()))
            {
              l = System.currentTimeMillis();
              if (QLog.isColorLevel()) {
                QLog.d("ShareMsgImpl", 2, "dialog dimiss time :" + l);
              }
              this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
            }
            paramString1 = paramJSONObject.optString("puin", null);
            if (paramString1 == null) {
              paramString1 = paramJSONObject.optString("oaUin");
            }
            label1596:
            label1606:
            label1616:
            label2389:
            label2415:
            for (;;)
            {
              if (!TextUtils.isEmpty(paramString1))
              {
                paramString2 = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getEntityManagerFactory(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getAccount()).createEntityManager();
                paramString5 = (AccountDetail)paramString2.find(AccountDetail.class, paramString1);
                paramString2.close();
                paramString4 = paramJSONObject.optString("src_action", "");
                paramString2 = null;
                if (TextUtils.isEmpty(paramString4)) {
                  if (paramString5 == null) {
                    break label2423;
                  }
                }
              }
              label2287:
              label2417:
              label2423:
              for (paramString2 = paramString5.name;; paramString2 = null)
              {
                paramString3 = paramString2;
                if (TextUtils.isEmpty(paramString2))
                {
                  paramString3 = paramString2;
                  if (paramJSONObject.has("sourceName")) {
                    paramString3 = paramJSONObject.optString("sourceName");
                  }
                }
                paramString2 = paramString3;
                if (TextUtils.isEmpty(paramString3)) {
                  paramString2 = paramString1;
                }
                for (;;)
                {
                  if (paramString2.equalsIgnoreCase(this.jdField_a_of_type_AndroidContentContext.getString(2131699723)))
                  {
                    bool = paramString2.equalsIgnoreCase(this.jdField_a_of_type_AndroidContentContext.getString(2131699723));
                    if (bool)
                    {
                      paramJSONObject = "mqqapi://app/action?pkg=com.tencent.mobileqq&cmp=cooperation.readinjoy.ReadInJoyProxyActivity";
                      if (!bool) {
                        break label1924;
                      }
                      paramString3 = "mqqapi://readinjoy/open?src_type=internal&version=1";
                      if (!bool) {
                        break label1932;
                      }
                      paramString4 = "https://sqimg.qq.com/qq_product_operations/ydqpush/message_icon/kandian.png";
                      localIntent.putExtra("source_puin", paramString1);
                      localIntent.putExtra("struct_share_key_source_action", "plugin");
                      localIntent.putExtra("struct_share_key_source_a_action_data", paramJSONObject);
                      localIntent.putExtra("struct_share_key_source_i_action_data", paramString3);
                      localIntent.putExtra("struct_share_key_content_a_action_DATA", paramJSONObject);
                      localIntent.putExtra("struct_share_key_source_icon", paramString4);
                      localIntent.putExtra("app_name", paramString2);
                    }
                  }
                  for (;;)
                  {
                    if ((this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebUiUtils$WebShareReportInterface != null) && (this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebUiUtils$WebUiMethodInterface != null))
                    {
                      localIntent.putExtra("strurt_msgid", this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebUiUtils$WebShareReportInterface.getMsgid());
                      localIntent.putExtra("struct_uin", this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebUiUtils$WebShareReportInterface.getPublicUin());
                      localIntent.putExtra("struct_url", this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebUiUtils$WebUiMethodInterface.getCurrentUrl());
                      localIntent.putExtra("from_web", true);
                      if ((this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebUiUtils$WebShareReportInterface.getSourcePuin() != null) && (!"".equals(this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebUiUtils$WebShareReportInterface.getSourcePuin()))) {
                        localIntent.putExtra("source_puin", this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebUiUtils$WebShareReportInterface.getSourcePuin());
                      }
                    }
                    paramJSONObject = StructMsgFactory.a(localIntent.getExtras());
                    if (paramJSONObject != null) {
                      break label2389;
                    }
                    if (QLog.isColorLevel()) {
                      QLog.d("ShareMsgImpl", 2, "build struct msg fail");
                    }
                    this.jdField_a_of_type_ComTencentMobileqqJspShareMsgImpl$ShareMsgImplListener.onSharMsgcallback(this.jdField_a_of_type_JavaLangString, "false");
                    return;
                    if (paramJSONObject.has("sourceName")) {
                      paramString2 = paramJSONObject.optString("sourceName");
                    }
                    paramString3 = paramString2;
                    if (TextUtils.isEmpty(paramString2))
                    {
                      paramString3 = paramString2;
                      if (paramString5 != null) {
                        paramString3 = paramString5.name;
                      }
                    }
                    if (!TextUtils.isEmpty(paramString3)) {
                      break label2417;
                    }
                    paramString2 = paramString1;
                    break;
                    paramJSONObject = "mqqapi://app/action?pkg=com.tencent.mobileqq&cmp=cooperation.readinjoy.ReadInJoyProxyActivity&from=recent";
                    break label1596;
                    paramString3 = "mqqapi://readinjoy/open?src_type=internal&version=1&from=recent";
                    break label1606;
                    paramString4 = "https://sqimg.qq.com/qq_product_operations/ydqpush/message_icon/dingyuehao.png";
                    break label1616;
                    paramString3 = paramJSONObject.optString("src_webActionUrl", "");
                    paramString5 = paramJSONObject.optString("src_actionData", "");
                    paramString6 = paramJSONObject.optString("src_a_actionData", "");
                    paramString7 = paramJSONObject.optString("src_i_actionData", "");
                    if ((TextUtils.isEmpty(paramString4)) || (("web".equals(paramString4)) && ((TextUtils.isEmpty(paramString3)) || (paramString3.contains("webcard.mp.qq.com")))) || ((!"web".equals(paramString4)) && (TextUtils.isEmpty(paramString5)) && ((TextUtils.isEmpty(paramString6)) || (TextUtils.isEmpty(paramString7)))))
                    {
                      paramString3 = String.format("mqqapi://app/action?pkg=com.tencent.mobileqq&cmp=com.tencent.biz.pubaccount.AccountDetail.activity.api.impl.AccountDetailActivity&uin=%s", new Object[] { paramString1 });
                      paramString4 = String.format("mqqapi://card/show_pslcard?src_type=internal&card_type=public_account&uin=%s&version=1", new Object[] { paramString1 });
                      localIntent.putExtra("struct_share_key_source_action", "plugin");
                      localIntent.putExtra("struct_share_key_source_a_action_data", paramString3);
                      localIntent.putExtra("struct_share_key_source_i_action_data", paramString4);
                    }
                    for (;;)
                    {
                      localIntent.putExtra("source_puin", paramString1);
                      localIntent.putExtra("app_name", paramString2);
                      paramJSONObject = paramJSONObject.optString("src_iconUrl", "");
                      if (!TextUtils.isEmpty(paramJSONObject)) {
                        break label2287;
                      }
                      localIntent.putExtra("struct_share_key_source_icon", "https://url.cn/JS8oE7");
                      break;
                      localIntent.putExtra("struct_share_key_source_action", paramString4);
                      if ("web".equals(paramString4))
                      {
                        localIntent.putExtra("struct_share_key_source_url", paramString3);
                        localIntent.putExtra("source_url", paramString3);
                      }
                      else
                      {
                        if (!TextUtils.isEmpty(paramString5)) {
                          localIntent.putExtra("struct_share_key_source_action_data", paramString5);
                        }
                        if (!TextUtils.isEmpty(paramString6)) {
                          localIntent.putExtra("struct_share_key_source_a_action_data", paramString6);
                        }
                        if (!TextUtils.isEmpty(paramString7)) {
                          localIntent.putExtra("struct_share_key_source_i_action_data", paramString7);
                        }
                      }
                    }
                    localIntent.putExtra("struct_share_key_source_icon", paramJSONObject);
                    continue;
                    if (paramJSONObject.has("sourceName"))
                    {
                      paramString1 = paramJSONObject.optString("sourceName");
                      localIntent.putExtra("app_name", paramString1);
                      if (("手Q阅读".equals(paramString1)) && (paramJSONObject.has("srcIconUrl"))) {
                        localIntent.putExtra("struct_share_key_source_icon", paramJSONObject.optString("srcIconUrl"));
                      }
                    }
                    else
                    {
                      localIntent.putExtra("app_name", this.jdField_a_of_type_AndroidContentContext.getString(2131696399));
                    }
                  }
                  localIntent.putExtra("stuctmsg_bytes", paramJSONObject.getBytes());
                  this.jdField_a_of_type_ComTencentMobileqqJspShareMsgImpl$ShareMsgImplListener.startActivityForResult(localIntent, (byte)1);
                  break label1247;
                  break;
                  paramString2 = paramString3;
                }
              }
            }
          }
          label2439:
          paramString1 = str;
        }
        paramString1 = str;
      }
      localBundle = null;
    }
  }
  
  public void d(String paramString)
  {
    try
    {
      this.jdField_a_of_type_JavaLangString = null;
      paramString = new JSONObject(paramString);
      Intent localIntent = new Intent();
      String str = paramString.optString("toUin");
      if ((str == null) || (str.length() < 5))
      {
        if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
          this.jdField_a_of_type_ComTencentMobileqqJspShareMsgImpl$ShareMsgImplListener.onSharMsgcallback(this.jdField_a_of_type_JavaLangString, "{\"result\":0}");
        }
        if (QLog.isColorLevel()) {
          QLog.d("ShareMsgImpl", 2, "toUin invalide: " + str);
        }
      }
      else
      {
        this.jdField_a_of_type_JavaLangString = paramString.optString("callback");
        localIntent.setClass(this.jdField_a_of_type_AndroidContentContext, DirectForwardActivity.class);
        localIntent.putExtra("toUin", str);
        localIntent.putExtra("key_flag_from_plugin", true);
        localIntent.putExtra("pluginName", "web_share");
        localIntent.putExtra("forward_type", 30);
        localIntent.putExtra("k_back", true);
        this.jdField_a_of_type_ComTencentMobileqqJspShareMsgImpl$ShareMsgImplListener.startActivityForResult(localIntent, (byte)2);
        return;
      }
    }
    catch (JSONException paramString)
    {
      this.jdField_a_of_type_ComTencentMobileqqJspShareMsgImpl$ShareMsgImplListener.onSharMsgcallback(this.jdField_a_of_type_JavaLangString, "{\"result\":0}");
      if (QLog.isColorLevel()) {
        QLog.d("ShareMsgImpl", 2, "shareMsg error: " + paramString.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.jsp.ShareMsgImpl
 * JD-Core Version:    0.7.0.1
 */