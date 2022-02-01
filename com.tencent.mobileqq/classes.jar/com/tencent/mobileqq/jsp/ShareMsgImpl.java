package com.tencent.mobileqq.jsp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.tencent.biz.AuthorizeConfig;
import com.tencent.biz.common.util.Util;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.pubaccount.accountdetail.api.IPublicAccountDetail;
import com.tencent.biz.pubaccount.api.IPublicAccountProxy;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.biz.qrcode.util.QRUtils;
import com.tencent.biz.troop.TroopMemberApiClient;
import com.tencent.biz.webviewplugin.Share;
import com.tencent.comic.api.IQQComicHippyWebviewShareHelper;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ArkFullScreenAppActivity;
import com.tencent.mobileqq.activity.DirectForwardActivity;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.TeamWorkDocEditBrowserActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.confess.ConfessMsgUtil;
import com.tencent.mobileqq.data.MessageForTribeShortVideo;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.kandian.biz.share.api.IWxShareHelperFromReadInjoy;
import com.tencent.mobileqq.kandian.biz.share.api.IWxShareHelperFromReadInjoy.WXShareHelperFromReadInjoyListener;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgFactory;
import com.tencent.mobileqq.webview.swift.WebUiBaseInterface;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.mobileqq.webview.swift.WebViewPluginEngine;
import com.tencent.mobileqq.webview.swift.WebViewProvider;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserComponentsProvider;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserShareMenuHandler;
import com.tencent.mobileqq.webviewplugin.WebUiUtils.QQBrowserBaseActivityInterface;
import com.tencent.mobileqq.webviewplugin.WebUiUtils.WebShareInterface;
import com.tencent.mobileqq.webviewplugin.WebUiUtils.WebShareReportInterface;
import com.tencent.mobileqq.webviewplugin.WebUiUtils.WebUiMethodInterface;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.mobileqq.wxapi.WXShareHelper.WXShareListener;
import com.tencent.open.agent.report.ReportCenter;
import com.tencent.qidian.QidianManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.share.CommonShareHelper;
import com.tencent.share.WebShare;
import cooperation.qzone.QZoneShareManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import mqq.app.MobileQQ;
import org.json.JSONException;
import org.json.JSONObject;

public class ShareMsgImpl
{
  Activity jdField_a_of_type_AndroidAppActivity;
  Context jdField_a_of_type_AndroidContentContext;
  TroopMemberApiClient jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient = null;
  AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  ShareMsgImpl.ShareMsgImplListener jdField_a_of_type_ComTencentMobileqqJspShareMsgImpl$ShareMsgImplListener;
  IWxShareHelperFromReadInjoy.WXShareHelperFromReadInjoyListener jdField_a_of_type_ComTencentMobileqqKandianBizShareApiIWxShareHelperFromReadInjoy$WXShareHelperFromReadInjoyListener;
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
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
    if ((localObject != null) && (((QQProgressDialog)localObject).isShowing())) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWxapiWXShareHelper$WXShareListener != null) {
      WXShareHelper.a().b(this.jdField_a_of_type_ComTencentMobileqqWxapiWXShareHelper$WXShareListener);
    }
    localObject = this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient;
    if (localObject != null) {
      ((TroopMemberApiClient)localObject).b();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizShareApiIWxShareHelperFromReadInjoy$WXShareHelperFromReadInjoyListener != null) {
      ((IWxShareHelperFromReadInjoy)QRoute.api(IWxShareHelperFromReadInjoy.class)).removeObserver(this.jdField_a_of_type_ComTencentMobileqqKandianBizShareApiIWxShareHelperFromReadInjoy$WXShareHelperFromReadInjoyListener);
    }
  }
  
  void a(Activity paramActivity)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null)
    {
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebUiUtils$WebShareInterface;
      if (localObject != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = ((Share)((WebUiUtils.WebShareInterface)localObject).getShare()).a();
        return;
      }
      localObject = null;
      WebViewPlugin.PluginRuntime localPluginRuntime = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin$PluginRuntime;
      if (localPluginRuntime != null) {
        localObject = localPluginRuntime.a(this.jdField_a_of_type_AndroidAppActivity);
      }
      if (paramActivity.getClass().getName().equalsIgnoreCase("com.tencent.qqreadinjoy.detailspage.ReadInJoyArticleDetailActivity"))
      {
        if ((paramActivity instanceof WebUiUtils.WebShareInterface))
        {
          this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = ((Share)((WebUiUtils.WebShareInterface)paramActivity).getShare()).a();
          return;
        }
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(paramActivity, paramActivity.getResources().getDimensionPixelSize(2131299168));
        return;
      }
      if ((localObject instanceof WebUiUtils.WebShareInterface))
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = ((Share)((WebUiUtils.WebShareInterface)paramActivity).getShare()).a();
        return;
      }
      if ((localPluginRuntime != null) && (localPluginRuntime.a() != null))
      {
        localObject = localPluginRuntime.a().getParent();
        if ((localObject instanceof IQQComicHippyWebviewShareHelper))
        {
          localObject = (IQQComicHippyWebviewShareHelper)localObject;
          if ((((IQQComicHippyWebviewShareHelper)localObject).getShareHelper() instanceof CommonShareHelper))
          {
            localObject = (CommonShareHelper)((IQQComicHippyWebviewShareHelper)localObject).getShareHelper();
            if (((CommonShareHelper)localObject).a() != null)
            {
              this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = ((CommonShareHelper)localObject).a().a();
              return;
            }
            this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(paramActivity, paramActivity.getResources().getDimensionPixelSize(2131299168));
            return;
          }
        }
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(paramActivity, paramActivity.getResources().getDimensionPixelSize(2131299168));
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(paramActivity, paramActivity.getResources().getDimensionPixelSize(2131299168));
    }
  }
  
  public void a(Intent paramIntent, byte paramByte, int paramInt)
  {
    String str;
    if (paramByte == 1)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqJspShareMsgImpl$ShareMsgImplListener;
      str = this.jdField_a_of_type_JavaLangString;
      if (paramInt == -1) {
        paramIntent = "true";
      } else {
        paramIntent = "false";
      }
      ((ShareMsgImpl.ShareMsgImplListener)localObject).onSharMsgcallback(str, paramIntent);
      return;
    }
    Object localObject = "{\"result\":0}";
    if (paramByte == 2)
    {
      paramIntent = this.jdField_a_of_type_ComTencentMobileqqJspShareMsgImpl$ShareMsgImplListener;
      str = this.jdField_a_of_type_JavaLangString;
      if (paramInt == -1) {
        localObject = "{\"result\":1}";
      }
      paramIntent.onSharMsgcallback(str, (String)localObject);
      return;
    }
    if (paramByte == 3)
    {
      paramIntent = this.jdField_a_of_type_ComTencentMobileqqJspShareMsgImpl$ShareMsgImplListener;
      str = this.jdField_a_of_type_JavaLangString;
      if (paramInt != -1) {
        localObject = "{\"result\":4}";
      }
      paramIntent.onSharMsgcallback(str, (String)localObject);
      return;
    }
    if (paramByte == 4)
    {
      localObject = this.jdField_a_of_type_AndroidAppActivity;
      if ((paramInt == -1) && (localObject != null) && (!((Activity)localObject).isFinishing()) && (paramIntent != null))
      {
        paramIntent = new Bundle(paramIntent.getExtras());
        this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.b(paramIntent);
      }
    }
  }
  
  public void a(WebUiBaseInterface paramWebUiBaseInterface)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebUiUtils$WebUiMethodInterface == null) && ((paramWebUiBaseInterface instanceof WebUiUtils.WebUiMethodInterface))) {
      this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebUiUtils$WebUiMethodInterface = ((WebUiUtils.WebUiMethodInterface)paramWebUiBaseInterface);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebUiUtils$QQBrowserBaseActivityInterface == null) && ((paramWebUiBaseInterface instanceof WebUiUtils.QQBrowserBaseActivityInterface))) {
      this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebUiUtils$QQBrowserBaseActivityInterface = ((WebUiUtils.QQBrowserBaseActivityInterface)paramWebUiBaseInterface);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebUiUtils$WebShareInterface == null) && ((paramWebUiBaseInterface instanceof WebUiUtils.WebShareInterface))) {
      this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebUiUtils$WebShareInterface = ((WebUiUtils.WebShareInterface)paramWebUiBaseInterface);
    }
  }
  
  public void a(WebViewPlugin paramWebViewPlugin)
  {
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin = paramWebViewPlugin;
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin$PluginRuntime = paramWebViewPlugin.mRuntime;
    paramWebViewPlugin = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin$PluginRuntime;
    paramWebViewPlugin = paramWebViewPlugin.a(paramWebViewPlugin.a());
    if ((paramWebViewPlugin != null) && ((paramWebViewPlugin instanceof WebUiUtils.WebUiMethodInterface))) {
      this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebUiUtils$WebUiMethodInterface = ((WebUiUtils.WebUiMethodInterface)paramWebViewPlugin);
    }
    paramWebViewPlugin = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin$PluginRuntime;
    paramWebViewPlugin = paramWebViewPlugin.a(paramWebViewPlugin.a());
    if ((paramWebViewPlugin != null) && ((paramWebViewPlugin instanceof WebUiUtils.QQBrowserBaseActivityInterface))) {
      this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebUiUtils$QQBrowserBaseActivityInterface = ((WebUiUtils.QQBrowserBaseActivityInterface)paramWebViewPlugin);
    }
    paramWebViewPlugin = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin$PluginRuntime;
    paramWebViewPlugin = paramWebViewPlugin.a(paramWebViewPlugin.a());
    if ((paramWebViewPlugin != null) && ((paramWebViewPlugin instanceof WebUiUtils.WebShareInterface))) {
      this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebUiUtils$WebShareInterface = ((WebUiUtils.WebShareInterface)paramWebViewPlugin);
    }
    b(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin);
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = null;
    label857:
    for (;;)
    {
      try
      {
        if (this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebUiUtils$WebShareInterface != null)
        {
          this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = ((Share)this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebUiUtils$WebShareInterface.getShare()).a();
          if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
            this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
          }
        }
        localObject1 = new Intent();
        Object localObject2 = new JSONObject(paramString);
        this.jdField_a_of_type_JavaLangString = ((JSONObject)localObject2).optString("callback");
        paramString = ((JSONObject)localObject2).optString("appName");
        if (!AuthorizeConfig.a().d("ark_authorize_config", paramString))
        {
          if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
            this.jdField_a_of_type_ComTencentMobileqqJspShareMsgImpl$ShareMsgImplListener.onSharMsgcallback(this.jdField_a_of_type_JavaLangString, "{\"result\":2}");
          }
        }
        else
        {
          String str1 = ((JSONObject)localObject2).optString("toUin");
          int i = ((JSONObject)localObject2).optInt("uinType", 0);
          String str2 = ((JSONObject)localObject2).optString("toNickName");
          if (str1 == null) {
            break label857;
          }
          if (str1.length() >= 5)
          {
            ((Intent)localObject1).setClass(this.jdField_a_of_type_AndroidContentContext, DirectForwardActivity.class);
            ((Intent)localObject1).putExtra("toUin", str1);
            ((Intent)localObject1).putExtra("uinType", i);
            ((Intent)localObject1).putExtra("nickName", str2);
          }
          else
          {
            ((Intent)localObject1).putExtra("isWebCompShare", true);
            ((Intent)localObject1).setClass(this.jdField_a_of_type_AndroidContentContext, ForwardRecentActivity.class);
          }
          ((Intent)localObject1).putExtra("shareQQType", ((JSONObject)localObject2).optInt("shareQQType", 13));
          ((Intent)localObject1).putExtra("forward_type", 27);
          ((Intent)localObject1).putExtra("openerProc", MobileQQ.getMobileQQ().getQQProcessName());
          ((Intent)localObject1).putExtra("k_back", ((JSONObject)localObject2).optBoolean("k_back", ((JSONObject)localObject2).optBoolean("back", false)));
          str1 = ((JSONObject)localObject2).optString("appDesc");
          str2 = ((JSONObject)localObject2).optString("appMinVersion");
          String str3 = ((JSONObject)localObject2).optString("appView");
          String str4 = ((JSONObject)localObject2).optString("appConfig");
          String str5 = ((JSONObject)localObject2).optString("metaData");
          String str6 = ((JSONObject)localObject2).optString("promptText");
          localObject2 = ((JSONObject)localObject2).optString("compatibleText");
          if ((TextUtils.isEmpty(paramString)) || (TextUtils.isEmpty(str3)) || (TextUtils.isEmpty(str5))) {
            this.jdField_a_of_type_ComTencentMobileqqJspShareMsgImpl$ShareMsgImplListener.onSharMsgcallback(this.jdField_a_of_type_JavaLangString, "{\"result\":1}");
          }
          ((Intent)localObject1).putExtra("forward_ark_app_name", paramString);
          ((Intent)localObject1).putExtra("forward_ark_app_view", str3);
          ((Intent)localObject1).putExtra("forward_ark_app_desc", str1);
          ((Intent)localObject1).putExtra("forward_ark_app_ver", str2);
          ((Intent)localObject1).putExtra("forward_ark_app_prompt", str6);
          ((Intent)localObject1).putExtra("forward_ark_app_meta", str5);
          ((Intent)localObject1).putExtra("forward_ark_app_config", str4);
          ((Intent)localObject1).putExtra("forward_ark_app_compat", (String)localObject2);
          ((Intent)localObject1).putExtra("is_ark_display_share", true);
          ((Intent)localObject1).putExtra("appName", paramString);
          ((Intent)localObject1).putExtra("appView", str3);
          ((Intent)localObject1).putExtra("appMinVersion", str2);
          ((Intent)localObject1).putExtra("metaData", str5);
          ((Intent)localObject1).putExtra("scale", this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().scaledDensity);
          boolean bool = this.jdField_a_of_type_AndroidContentContext instanceof QQBrowserActivity;
          if (bool)
          {
            paramString = ((QQBrowserActivity)this.jdField_a_of_type_AndroidContentContext).getWebViewProvider();
            if (paramString != null)
            {
              paramString = paramString.getCurrentUrl();
              if (!TextUtils.isEmpty(paramString)) {
                ((Intent)localObject1).putExtra("forward_ark_h5_from_js", paramString);
              }
            }
          }
          else if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin$PluginRuntime != null)
          {
            paramString = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin$PluginRuntime.a();
            if (paramString != null)
            {
              paramString = paramString.getCurrentUrl();
              if (!TextUtils.isEmpty(paramString)) {
                ((Intent)localObject1).putExtra("forward_ark_h5_from_js", paramString);
              }
            }
            else if (this.jdField_a_of_type_AndroidAppActivity != null)
            {
              paramString = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin$PluginRuntime.a(this.jdField_a_of_type_AndroidAppActivity);
              if ((paramString instanceof WebUiUtils.WebUiMethodInterface))
              {
                paramString = ((WebUiUtils.WebUiMethodInterface)paramString).getCurrentUrl();
                if (!TextUtils.isEmpty(paramString)) {
                  ((Intent)localObject1).putExtra("forward_ark_h5_from_js", paramString);
                }
              }
              else if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin$PluginRuntime.a() != null)
              {
                paramString = Util.a(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin$PluginRuntime.a().getUrl(), new String[0]);
                if (!TextUtils.isEmpty(paramString)) {
                  ((Intent)localObject1).putExtra("forward_ark_h5_from_js", paramString);
                }
              }
            }
          }
          this.jdField_a_of_type_ComTencentMobileqqJspShareMsgImpl$ShareMsgImplListener.startActivityForResult((Intent)localObject1, (byte)3);
          return;
        }
      }
      catch (JSONException paramString)
      {
        this.jdField_a_of_type_ComTencentMobileqqJspShareMsgImpl$ShareMsgImplListener.onSharMsgcallback(this.jdField_a_of_type_JavaLangString, "{\"result\":3}");
        Object localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("shareArkMsg error: ");
        ((StringBuilder)localObject1).append(paramString.toString());
        QLog.e("ShareMsgImpl", 1, ((StringBuilder)localObject1).toString());
        return;
      }
      return;
    }
  }
  
  /* Error */
  void a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 40	com/tencent/mobileqq/jsp/ShareMsgImpl:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   4: astore_2
    //   5: aload_0
    //   6: getfield 54	com/tencent/mobileqq/jsp/ShareMsgImpl:jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   9: ifnonnull +8 -> 17
    //   12: aload_0
    //   13: aload_2
    //   14: invokevirtual 417	com/tencent/mobileqq/jsp/ShareMsgImpl:a	(Landroid/app/Activity;)V
    //   17: aload_1
    //   18: invokestatic 250	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   21: ifne +358 -> 379
    //   24: aload_3
    //   25: invokestatic 250	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   28: ifeq +6 -> 34
    //   31: goto +348 -> 379
    //   34: invokestatic 420	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   37: ifeq +13 -> 50
    //   40: ldc_w 405
    //   43: iconst_2
    //   44: ldc_w 422
    //   47: invokestatic 424	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   50: aload_1
    //   51: ldc_w 426
    //   54: invokestatic 432	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   57: astore_1
    //   58: new 393	java/lang/StringBuilder
    //   61: dup
    //   62: invokespecial 394	java/lang/StringBuilder:<init>	()V
    //   65: astore 5
    //   67: aload 5
    //   69: ldc_w 434
    //   72: invokevirtual 400	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   75: pop
    //   76: aload 5
    //   78: ldc_w 436
    //   81: invokevirtual 400	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   84: pop
    //   85: aload 5
    //   87: aload_1
    //   88: invokevirtual 400	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   91: pop
    //   92: aload 5
    //   94: invokevirtual 406	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   97: astore_1
    //   98: aload_3
    //   99: ldc_w 426
    //   102: invokestatic 432	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   105: astore_3
    //   106: new 393	java/lang/StringBuilder
    //   109: dup
    //   110: invokespecial 394	java/lang/StringBuilder:<init>	()V
    //   113: astore 5
    //   115: aload 5
    //   117: aload_1
    //   118: invokevirtual 400	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   121: pop
    //   122: aload 5
    //   124: ldc_w 438
    //   127: invokevirtual 400	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   130: pop
    //   131: aload 5
    //   133: aload_3
    //   134: invokevirtual 400	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   137: pop
    //   138: aload 5
    //   140: invokevirtual 406	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   143: astore_1
    //   144: aload 4
    //   146: ldc_w 426
    //   149: invokestatic 432	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   152: astore_3
    //   153: new 393	java/lang/StringBuilder
    //   156: dup
    //   157: invokespecial 394	java/lang/StringBuilder:<init>	()V
    //   160: astore 4
    //   162: aload 4
    //   164: aload_1
    //   165: invokevirtual 400	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   168: pop
    //   169: aload 4
    //   171: ldc_w 440
    //   174: invokevirtual 400	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   177: pop
    //   178: aload 4
    //   180: aload_3
    //   181: invokevirtual 400	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   184: pop
    //   185: aload 4
    //   187: invokevirtual 406	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   190: astore_1
    //   191: new 393	java/lang/StringBuilder
    //   194: dup
    //   195: invokespecial 394	java/lang/StringBuilder:<init>	()V
    //   198: astore_3
    //   199: aload_3
    //   200: aload_1
    //   201: invokevirtual 400	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   204: pop
    //   205: aload_3
    //   206: ldc_w 442
    //   209: invokevirtual 400	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   212: pop
    //   213: aload_3
    //   214: invokevirtual 406	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   217: astore_1
    //   218: new 190	android/content/Intent
    //   221: dup
    //   222: aload_2
    //   223: ldc_w 363
    //   226: invokespecial 445	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   229: astore_3
    //   230: aload_3
    //   231: ldc_w 447
    //   234: aload_1
    //   235: invokevirtual 276	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   238: pop
    //   239: aload_2
    //   240: aload_3
    //   241: invokevirtual 451	android/app/Activity:startActivity	(Landroid/content/Intent;)V
    //   244: invokestatic 420	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   247: ifeq +13 -> 260
    //   250: ldc_w 405
    //   253: iconst_2
    //   254: ldc_w 453
    //   257: invokestatic 424	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   260: aload_0
    //   261: getfield 54	com/tencent/mobileqq/jsp/ShareMsgImpl:jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   264: astore_1
    //   265: aload_1
    //   266: ifnull +71 -> 337
    //   269: aload_1
    //   270: invokevirtual 60	com/tencent/mobileqq/widget/QQProgressDialog:isShowing	()Z
    //   273: ifeq +64 -> 337
    //   276: goto +54 -> 330
    //   279: astore_1
    //   280: goto +74 -> 354
    //   283: astore_1
    //   284: invokestatic 459	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   287: iconst_0
    //   288: ldc_w 460
    //   291: iconst_0
    //   292: invokestatic 465	com/tencent/mobileqq/widget/QQToast:a	(Landroid/content/Context;III)Lcom/tencent/mobileqq/widget/QQToast;
    //   295: invokestatic 459	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   298: invokevirtual 466	com/tencent/qphone/base/util/BaseApplication:getResources	()Landroid/content/res/Resources;
    //   301: ldc 133
    //   303: invokevirtual 139	android/content/res/Resources:getDimensionPixelSize	(I)I
    //   306: invokevirtual 469	com/tencent/mobileqq/widget/QQToast:b	(I)Landroid/widget/Toast;
    //   309: pop
    //   310: aload_1
    //   311: invokevirtual 472	java/lang/Exception:printStackTrace	()V
    //   314: aload_0
    //   315: getfield 54	com/tencent/mobileqq/jsp/ShareMsgImpl:jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   318: astore_1
    //   319: aload_1
    //   320: ifnull +17 -> 337
    //   323: aload_1
    //   324: invokevirtual 60	com/tencent/mobileqq/widget/QQProgressDialog:isShowing	()Z
    //   327: ifeq +10 -> 337
    //   330: aload_0
    //   331: getfield 54	com/tencent/mobileqq/jsp/ShareMsgImpl:jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   334: invokevirtual 63	com/tencent/mobileqq/widget/QQProgressDialog:dismiss	()V
    //   337: invokestatic 420	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   340: ifeq +13 -> 353
    //   343: ldc_w 405
    //   346: iconst_2
    //   347: ldc_w 474
    //   350: invokestatic 424	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   353: return
    //   354: aload_0
    //   355: getfield 54	com/tencent/mobileqq/jsp/ShareMsgImpl:jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   358: astore_2
    //   359: aload_2
    //   360: ifnull +17 -> 377
    //   363: aload_2
    //   364: invokevirtual 60	com/tencent/mobileqq/widget/QQProgressDialog:isShowing	()Z
    //   367: ifeq +10 -> 377
    //   370: aload_0
    //   371: getfield 54	com/tencent/mobileqq/jsp/ShareMsgImpl:jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   374: invokevirtual 63	com/tencent/mobileqq/widget/QQProgressDialog:dismiss	()V
    //   377: aload_1
    //   378: athrow
    //   379: invokestatic 420	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   382: ifeq +13 -> 395
    //   385: ldc_w 405
    //   388: iconst_2
    //   389: ldc_w 476
    //   392: invokestatic 424	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   395: aload_0
    //   396: getfield 54	com/tencent/mobileqq/jsp/ShareMsgImpl:jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   399: astore_1
    //   400: aload_1
    //   401: ifnull +17 -> 418
    //   404: aload_1
    //   405: invokevirtual 60	com/tencent/mobileqq/widget/QQProgressDialog:isShowing	()Z
    //   408: ifeq +10 -> 418
    //   411: aload_0
    //   412: getfield 54	com/tencent/mobileqq/jsp/ShareMsgImpl:jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   415: invokevirtual 63	com/tencent/mobileqq/widget/QQProgressDialog:dismiss	()V
    //   418: invokestatic 459	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   421: iconst_0
    //   422: ldc_w 460
    //   425: iconst_0
    //   426: invokestatic 465	com/tencent/mobileqq/widget/QQToast:a	(Landroid/content/Context;III)Lcom/tencent/mobileqq/widget/QQToast;
    //   429: invokestatic 459	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   432: invokevirtual 466	com/tencent/qphone/base/util/BaseApplication:getResources	()Landroid/content/res/Resources;
    //   435: ldc 133
    //   437: invokevirtual 139	android/content/res/Resources:getDimensionPixelSize	(I)I
    //   440: invokevirtual 469	com/tencent/mobileqq/widget/QQToast:b	(I)Landroid/widget/Toast;
    //   443: pop
    //   444: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	445	0	this	ShareMsgImpl
    //   0	445	1	paramString1	String
    //   0	445	2	paramString2	String
    //   0	445	3	paramString3	String
    //   0	445	4	paramString4	String
    //   65	74	5	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   50	260	279	finally
    //   284	314	279	finally
    //   50	260	283	java/lang/Exception
  }
  
  void a(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("shareMsgToQidianOrQiye start: ");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("ShareMsgImpl", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.jdField_a_of_type_AndroidAppActivity;
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null) {
      a((Activity)localObject);
    }
    QQProgressDialog localQQProgressDialog = this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
    if ((localQQProgressDialog != null) && (localQQProgressDialog.isShowing())) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    }
    QidianManager.a((Activity)localObject, paramInt, paramString1, paramString2, paramString3, paramString4, "", 0, false);
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    long l = System.currentTimeMillis();
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("dialog get web js time :");
      ((StringBuilder)localObject1).append(l);
      QLog.d("ShareMsgImpl", 2, ((StringBuilder)localObject1).toString());
    }
    this.jdField_a_of_type_JavaLangString = null;
    label1334:
    label1342:
    label1355:
    label1360:
    label1363:
    for (;;)
    {
      Object localObject2;
      try
      {
        localObject2 = new JSONObject(paramString);
        localObject1 = this.jdField_a_of_type_AndroidAppActivity;
        if (paramBoolean)
        {
          paramString = "shareType";
          String str1 = ((JSONObject)localObject2).optString(paramString, "0");
          String str2 = ((JSONObject)localObject2).optString("title");
          String str3 = ((JSONObject)localObject2).optString("desc");
          if (!paramBoolean) {
            break label1342;
          }
          paramString = "shareUrl";
          String str4 = ((JSONObject)localObject2).optString(paramString);
          if (paramBoolean) {
            paramString = "imageUrl";
          } else {
            paramString = "image_url";
          }
          try
          {
            str5 = ((JSONObject)localObject2).optString(paramString);
            str6 = ((JSONObject)localObject2).optString("shareElement");
            str7 = ((JSONObject)localObject2).optString("flash_url");
            str8 = ((JSONObject)localObject2).optString("article_id");
            str9 = ((JSONObject)localObject2).optString("rowkey");
            str10 = ((JSONObject)localObject2).optString("isfan");
            k = ((JSONObject)localObject2).optInt("WXShareFromQQKandian");
            localObject3 = ((JSONObject)localObject2).optString("short_video_vid");
            String str11 = ((JSONObject)localObject2).optString("short_video_url");
            String str12 = ((JSONObject)localObject2).optString("short_video_cover_url");
            String str13 = ((JSONObject)localObject2).optString("short_video_theme_name");
            paramString = ((JSONObject)localObject2).optString("is_tribe_short_video");
            if (TextUtils.isEmpty(str5))
            {
              j = 1;
              i = j;
              if (TextUtils.isEmpty(str3)) {
                i = j | 0x2;
              }
              j = i;
              if (TextUtils.isEmpty(str2)) {
                j = i | 0x4;
              }
              localObject4 = new Bundle();
              ((Bundle)localObject4).putString("report_type", "102");
              ((Bundle)localObject4).putString("act_type", "94");
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append("");
              if (j != 0) {
                break label1355;
              }
              i = 0;
              localStringBuilder.append(i);
              ((Bundle)localObject4).putString("intext_1", localStringBuilder.toString());
              localStringBuilder = new StringBuilder();
              localStringBuilder.append("");
              localStringBuilder.append(j);
              ((Bundle)localObject4).putString("intext_2", localStringBuilder.toString());
              localStringBuilder = new StringBuilder();
              localStringBuilder.append("");
              localStringBuilder.append(str4);
              ((Bundle)localObject4).putString("stringext_1", localStringBuilder.toString());
              ReportCenter.a().a((Bundle)localObject4, "", this.jdField_a_of_type_ComTencentCommonAppAppInterface.getAccount(), false);
              i = ((JSONObject)localObject2).optInt("shareQQType", 13);
              this.jdField_a_of_type_JavaLangString = ((JSONObject)localObject2).optString("callback");
              paramBoolean = ((JSONObject)localObject2).optBoolean("keepShareUrl", false);
              localObject4 = new HashMap();
              if ((!paramBoolean) && (str4 != null) && (str4.length() > 140) && (!"3".equals(str1))) {
                ((HashMap)localObject4).put("share_url", str4);
              }
              if ((str5 != null) && (str5.length() > 80) && (!"2".equals(str1)) && (!"3".equals(str1)) && (!"4".equals(str1))) {
                ((HashMap)localObject4).put("image_url", str5);
              }
              if ((str7 != null) && (str7.length() > 30)) {
                ((HashMap)localObject4).put("flash_url", str7);
              }
              if (!TextUtils.isEmpty((CharSequence)localObject3)) {
                ((HashMap)localObject4).put("short_video_vid", localObject3);
              }
              if (!TextUtils.isEmpty(str12)) {
                ((HashMap)localObject4).put("short_video_cover_url", str12);
              }
              if (TextUtils.isEmpty(str11)) {
                break label1360;
              }
              ((HashMap)localObject4).put("short_video_url", str11);
              if (!TextUtils.isEmpty(str13)) {
                ((HashMap)localObject4).put("short_video_theme_name", str11);
              }
              if (TextUtils.isEmpty(paramString)) {
                break label1363;
              }
              ((HashMap)localObject4).put("is_tribe_short_video", paramString);
              paramBoolean = ((HashMap)localObject4).isEmpty();
              if (paramBoolean) {}
            }
          }
          catch (JSONException paramString)
          {
            String str5;
            String str6;
            String str7;
            String str8;
            String str9;
            String str10;
            int k;
            Object localObject3;
            Object localObject4;
            localObject1 = "ShareMsgImpl";
          }
        }
      }
      catch (JSONException paramString)
      {
        localObject1 = "ShareMsgImpl";
      }
      try
      {
        if (!"1".equals(str1))
        {
          localObject3 = this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
          if (localObject3 == null) {
            a((Activity)localObject1);
          }
          paramBoolean = this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing();
          if (!paramBoolean)
          {
            this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(2131693895);
            this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
          }
        }
        try
        {
          ThreadManager.post(new ShareMsgImpl.1(this, (HashMap)localObject4, str4, str5, str7, str1, (JSONObject)localObject2, str2, str3, str6, str8, str9, str10, k, paramString, i, (Activity)localObject1), 8, null, true);
        }
        catch (JSONException paramString) {}
        localObject1 = "ShareMsgImpl";
        if ("1".equals(str1))
        {
          a((JSONObject)localObject2, str1, str2, str3, str4, str5, str6, str7);
          ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).reportPAShareItemEvent(1002, str4, str8, str9, str10);
          return;
        }
        if ((!"2".equals(str1)) && (!"3".equals(str1)))
        {
          paramBoolean = "4".equals(str1);
          if (!paramBoolean) {}
        }
        try
        {
          b(str2, str3, str4, str5);
          ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).reportPAShareItemEvent(1005, str4, str8, str9, str10);
          return;
        }
        catch (JSONException paramString) {}
        if ("5".equals(str1))
        {
          a(str2, str3, str4, str5, 6);
          return;
        }
        if ("6".equals(str1))
        {
          a(str2, str3, str4, str5, 7);
          return;
        }
        if ((!TextUtils.isEmpty(paramString)) && (((JSONObject)localObject2).has("is_tribe_short_video")) && (paramString.equals("true")))
        {
          b((JSONObject)localObject2, str1, str2, str3, str4, str5, str6, str7, i);
          return;
        }
        c((JSONObject)localObject2, str1, str2, str3, str4, str5, str6, str7, i);
        ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).reportPAShareItemEvent(1001, str4, str8, str9, str10);
        return;
        a((JSONObject)localObject2, str1, str2, str3, str4, str5, str6, str7, k);
        if ("2".equals(str1)) {
          ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).reportPAShareItemEvent(1003, str4, str8, str9, str10);
        }
        if (!"3".equals(str1)) {
          break label1334;
        }
        ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).reportPAShareItemEvent(1004, str4, str8, str9, str10);
        return;
      }
      catch (JSONException paramString)
      {
        continue;
      }
      localObject1 = "ShareMsgImpl";
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("shareMsg error: ");
        ((StringBuilder)localObject2).append(paramString.toString());
        QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
      }
      return;
      paramString = "share_type";
      continue;
      paramString = "share_url";
      continue;
      int j = 0;
      continue;
      int i = 1;
      continue;
    }
  }
  
  void a(JSONObject paramJSONObject)
  {
    Object localObject1 = "";
    for (;;)
    {
      try
      {
        if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin$PluginRuntime == null) {
          break label301;
        }
        Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin$PluginRuntime.a().getPluginEngine();
        String str1 = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin$PluginRuntime.a().getCurrentUrl();
        bool = ((WebViewPluginEngine)localObject2).a().a(str1, "QQApi.shareArkMessage");
        if (!bool)
        {
          QLog.e("ShareMsgImpl", 1, "shareArkMessage permission deny!");
          if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null) || (!this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
            break;
          }
          this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
          return;
        }
        localObject2 = paramJSONObject.getString("view");
        str1 = paramJSONObject.getString("app");
        String str2 = paramJSONObject.getString("meta");
        String str3 = paramJSONObject.getString("desc");
        String str4 = paramJSONObject.optString("version", "0.0.0.1");
        paramJSONObject = paramJSONObject.optString("config", "");
        try
        {
          paramJSONObject = new JSONObject(paramJSONObject).getString("type");
        }
        catch (JSONException paramJSONObject)
        {
          paramJSONObject.printStackTrace();
          paramJSONObject = (JSONObject)localObject1;
        }
        localObject1 = new HashMap();
        ((Map)localObject1).put("version", str4);
        ((Map)localObject1).put("type", paramJSONObject);
        ((Map)localObject1).put("desc", str3);
        paramJSONObject = this.jdField_a_of_type_AndroidAppActivity;
        if (paramJSONObject != null)
        {
          localObject1 = ArkFullScreenAppActivity.a(paramJSONObject, (String)localObject2, str1, str2, "", paramJSONObject.getResources().getDisplayMetrics().scaledDensity, (Map)localObject1);
          if (localObject1 != null) {
            ForwardBaseOption.a(paramJSONObject, (Intent)localObject1);
          }
        }
        if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing()))
        {
          this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
          return;
        }
      }
      catch (Exception paramJSONObject)
      {
        QLog.e("ShareMsgImpl", 1, "shareArkMsg error:", paramJSONObject);
      }
      return;
      label301:
      boolean bool = true;
    }
  }
  
  void a(JSONObject paramJSONObject, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    paramString1 = this.jdField_a_of_type_AndroidAppActivity;
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null) {
      a(paramString1);
    }
    paramString6 = this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
    if ((paramString6 != null) && (paramString6.isShowing())) {
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
    paramJSONObject = this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebUiUtils$WebShareReportInterface;
    if ((paramJSONObject != null) && (this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebUiUtils$WebUiMethodInterface != null))
    {
      paramString6.putString("strurt_msgid", paramJSONObject.a());
      paramString6.putString("struct_uin", this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebUiUtils$WebShareReportInterface.b());
      paramString6.putString("struct_url", this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebUiUtils$WebUiMethodInterface.getCurrentUrl());
      paramString6.putBoolean("from_web", true);
      if ((this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebUiUtils$WebShareReportInterface.c() != null) && (!"".equals(this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebUiUtils$WebShareReportInterface.c()))) {
        paramString6.putString("source_puin", this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebUiUtils$WebShareReportInterface.c());
      }
    }
    paramJSONObject = this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebUiUtils$QQBrowserBaseActivityInterface;
    if (paramJSONObject != null)
    {
      paramString2 = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin;
      if (paramString2 != null)
      {
        i = paramJSONObject.switchRequestCode(paramString2, (byte)1, true);
        break label320;
      }
    }
    int i = 1;
    label320:
    if (paramString1.getIntent().getBooleanExtra("confess_half_screen_web", false)) {
      i = 15001;
    }
    if (QZoneShareManager.jumpToQzoneShare(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_AndroidContentContext, paramString6, null, i)) {
      return;
    }
    QRUtils.a(1, 2131689486);
    this.jdField_a_of_type_ComTencentMobileqqJspShareMsgImpl$ShareMsgImplListener.onSharMsgcallback(this.jdField_a_of_type_JavaLangString, "false");
  }
  
  void a(JSONObject paramJSONObject, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, int paramInt)
  {
    paramJSONObject = this.jdField_a_of_type_AndroidAppActivity;
    int i;
    if (!WXShareHelper.a().a()) {
      i = 2131720478;
    } else if (!WXShareHelper.a().b()) {
      i = 2131720479;
    } else {
      i = -1;
    }
    if (i != -1)
    {
      QRUtils.a(0, i);
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null) {
        a(paramJSONObject);
      }
      paramJSONObject = this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
      if ((paramJSONObject != null) && (paramJSONObject.isShowing())) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
      }
      return;
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
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(2131693895);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
    }
    ThreadManager.post(new ShareMsgImpl.4(this, paramString5, localHashMap, paramString2, paramString1, paramString4), 8, null, false);
  }
  
  public boolean a(String paramString)
  {
    WebUiUtils.WebShareInterface localWebShareInterface = this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebUiUtils$WebShareInterface;
    return (localWebShareInterface != null) && (localWebShareInterface.setShareUrl(paramString));
  }
  
  public void b(WebViewPlugin paramWebViewPlugin)
  {
    paramWebViewPlugin = (SwiftBrowserShareMenuHandler)paramWebViewPlugin.getBrowserComponent(4);
    if ((paramWebViewPlugin instanceof WebUiUtils.WebShareReportInterface)) {
      this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebUiUtils$WebShareReportInterface = paramWebViewPlugin;
    }
  }
  
  public void b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    this.jdField_a_of_type_JavaLangString = null;
    try
    {
      paramString = new JSONObject(paramString);
      localObject = new Intent(this.jdField_a_of_type_AndroidContentContext, ForwardRecentActivity.class);
      ((Intent)localObject).putExtra("isFromShare", true);
      String str = paramString.optString("toUin");
      int i = paramString.optInt("uinType", 0);
      if ((str != null) && (str.length() >= 5))
      {
        ((Intent)localObject).setClass(this.jdField_a_of_type_AndroidContentContext, DirectForwardActivity.class);
        ((Intent)localObject).putExtra("toUin", str);
        ((Intent)localObject).putExtra("uinType", i);
      }
      ((Intent)localObject).putExtra("forward_type", -1);
      ((Intent)localObject).putExtra("forward_text", paramString.optString("text"));
      this.jdField_a_of_type_JavaLangString = paramString.optString("callback");
      if (paramString.has("report")) {
        ((Intent)localObject).putExtra("report", paramString.getString("report"));
      }
      ((Intent)localObject).putExtra("openerProc", MobileQQ.getMobileQQ().getQQProcessName());
      this.jdField_a_of_type_ComTencentMobileqqJspShareMsgImpl$ShareMsgImplListener.startActivityForResult((Intent)localObject, (byte)1);
      return;
    }
    catch (JSONException paramString)
    {
      Object localObject;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("shareText error: ");
        ((StringBuilder)localObject).append(paramString.getMessage());
        QLog.d("ShareMsgImpl", 2, ((StringBuilder)localObject).toString());
      }
    }
  }
  
  /* Error */
  void b(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    // Byte code:
    //   0: invokestatic 420	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +13 -> 16
    //   6: ldc_w 405
    //   9: iconst_2
    //   10: ldc_w 828
    //   13: invokestatic 424	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   16: aload_3
    //   17: invokestatic 834	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   20: astore 5
    //   22: aload 5
    //   24: ifnull +50 -> 74
    //   27: aload 5
    //   29: invokevirtual 837	android/net/Uri:getHost	()Ljava/lang/String;
    //   32: astore 5
    //   34: aload 5
    //   36: invokestatic 250	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   39: ifne +35 -> 74
    //   42: ldc_w 839
    //   45: aload 5
    //   47: invokevirtual 126	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   50: ifne +14 -> 64
    //   53: ldc_w 841
    //   56: aload 5
    //   58: invokevirtual 126	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   61: ifeq +13 -> 74
    //   64: aload_0
    //   65: aload_1
    //   66: aload_2
    //   67: aload_3
    //   68: aload 4
    //   70: invokevirtual 843	com/tencent/mobileqq/jsp/ShareMsgImpl:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   73: return
    //   74: aload_0
    //   75: getfield 40	com/tencent/mobileqq/jsp/ShareMsgImpl:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   78: astore 5
    //   80: aload_0
    //   81: getfield 54	com/tencent/mobileqq/jsp/ShareMsgImpl:jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   84: ifnonnull +9 -> 93
    //   87: aload_0
    //   88: aload 5
    //   90: invokevirtual 417	com/tencent/mobileqq/jsp/ShareMsgImpl:a	(Landroid/app/Activity;)V
    //   93: aload_1
    //   94: invokestatic 250	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   97: ifne +405 -> 502
    //   100: aload_3
    //   101: invokestatic 250	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   104: ifeq +6 -> 110
    //   107: goto +395 -> 502
    //   110: invokestatic 846	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   113: invokevirtual 850	com/tencent/qphone/base/util/BaseApplication:getPackageManager	()Landroid/content/pm/PackageManager;
    //   116: astore 6
    //   118: aload 6
    //   120: ldc_w 852
    //   123: sipush 8192
    //   126: invokevirtual 858	android/content/pm/PackageManager:getApplicationInfo	(Ljava/lang/String;I)Landroid/content/pm/ApplicationInfo;
    //   129: astore 6
    //   131: invokestatic 420	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   134: ifeq +13 -> 147
    //   137: ldc_w 405
    //   140: iconst_2
    //   141: ldc_w 860
    //   144: invokestatic 424	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   147: new 862	com/tencent/mobileqq/jsp/ShareMsgImpl$2
    //   150: dup
    //   151: aload_0
    //   152: aload 4
    //   154: aload 5
    //   156: aload_1
    //   157: aload_2
    //   158: aload_3
    //   159: aload 6
    //   161: invokespecial 865	com/tencent/mobileqq/jsp/ShareMsgImpl$2:<init>	(Lcom/tencent/mobileqq/jsp/ShareMsgImpl;Ljava/lang/String;Landroid/app/Activity;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/content/pm/ApplicationInfo;)V
    //   164: invokestatic 869	com/tencent/mobileqq/app/ThreadManager:executeOnSubThread	(Ljava/lang/Runnable;)V
    //   167: goto +293 -> 460
    //   170: invokestatic 420	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   173: ifeq +13 -> 186
    //   176: ldc_w 405
    //   179: iconst_2
    //   180: ldc_w 422
    //   183: invokestatic 424	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   186: aload_1
    //   187: ldc_w 426
    //   190: invokestatic 432	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   193: astore_1
    //   194: new 393	java/lang/StringBuilder
    //   197: dup
    //   198: invokespecial 394	java/lang/StringBuilder:<init>	()V
    //   201: astore_2
    //   202: aload_2
    //   203: ldc_w 434
    //   206: invokevirtual 400	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   209: pop
    //   210: aload_2
    //   211: ldc_w 436
    //   214: invokevirtual 400	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   217: pop
    //   218: aload_2
    //   219: aload_1
    //   220: invokevirtual 400	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   223: pop
    //   224: aload_2
    //   225: invokevirtual 406	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   228: astore_1
    //   229: aload_3
    //   230: ldc_w 426
    //   233: invokestatic 432	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   236: astore_2
    //   237: new 393	java/lang/StringBuilder
    //   240: dup
    //   241: invokespecial 394	java/lang/StringBuilder:<init>	()V
    //   244: astore_3
    //   245: aload_3
    //   246: aload_1
    //   247: invokevirtual 400	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   250: pop
    //   251: aload_3
    //   252: ldc_w 438
    //   255: invokevirtual 400	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   258: pop
    //   259: aload_3
    //   260: aload_2
    //   261: invokevirtual 400	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   264: pop
    //   265: aload_3
    //   266: invokevirtual 406	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   269: astore_1
    //   270: aload 4
    //   272: ldc_w 426
    //   275: invokestatic 432	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   278: astore_2
    //   279: new 393	java/lang/StringBuilder
    //   282: dup
    //   283: invokespecial 394	java/lang/StringBuilder:<init>	()V
    //   286: astore_3
    //   287: aload_3
    //   288: aload_1
    //   289: invokevirtual 400	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   292: pop
    //   293: aload_3
    //   294: ldc_w 440
    //   297: invokevirtual 400	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   300: pop
    //   301: aload_3
    //   302: aload_2
    //   303: invokevirtual 400	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   306: pop
    //   307: aload_3
    //   308: invokevirtual 406	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   311: astore_1
    //   312: new 393	java/lang/StringBuilder
    //   315: dup
    //   316: invokespecial 394	java/lang/StringBuilder:<init>	()V
    //   319: astore_2
    //   320: aload_2
    //   321: aload_1
    //   322: invokevirtual 400	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   325: pop
    //   326: aload_2
    //   327: ldc_w 442
    //   330: invokevirtual 400	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   333: pop
    //   334: aload_2
    //   335: invokevirtual 406	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   338: astore_1
    //   339: new 190	android/content/Intent
    //   342: dup
    //   343: aload 5
    //   345: ldc_w 363
    //   348: invokespecial 445	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   351: astore_2
    //   352: aload_2
    //   353: ldc_w 447
    //   356: aload_1
    //   357: invokevirtual 276	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   360: pop
    //   361: aload 5
    //   363: aload_2
    //   364: invokevirtual 451	android/app/Activity:startActivity	(Landroid/content/Intent;)V
    //   367: invokestatic 420	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   370: ifeq +13 -> 383
    //   373: ldc_w 405
    //   376: iconst_2
    //   377: ldc_w 453
    //   380: invokestatic 424	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   383: aload_0
    //   384: getfield 54	com/tencent/mobileqq/jsp/ShareMsgImpl:jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   387: astore_1
    //   388: aload_1
    //   389: ifnull +71 -> 460
    //   392: aload_1
    //   393: invokevirtual 60	com/tencent/mobileqq/widget/QQProgressDialog:isShowing	()Z
    //   396: ifeq +64 -> 460
    //   399: goto +54 -> 453
    //   402: astore_1
    //   403: goto +74 -> 477
    //   406: astore_1
    //   407: invokestatic 459	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   410: iconst_0
    //   411: ldc_w 460
    //   414: iconst_0
    //   415: invokestatic 465	com/tencent/mobileqq/widget/QQToast:a	(Landroid/content/Context;III)Lcom/tencent/mobileqq/widget/QQToast;
    //   418: invokestatic 459	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   421: invokevirtual 466	com/tencent/qphone/base/util/BaseApplication:getResources	()Landroid/content/res/Resources;
    //   424: ldc 133
    //   426: invokevirtual 139	android/content/res/Resources:getDimensionPixelSize	(I)I
    //   429: invokevirtual 469	com/tencent/mobileqq/widget/QQToast:b	(I)Landroid/widget/Toast;
    //   432: pop
    //   433: aload_1
    //   434: invokevirtual 472	java/lang/Exception:printStackTrace	()V
    //   437: aload_0
    //   438: getfield 54	com/tencent/mobileqq/jsp/ShareMsgImpl:jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   441: astore_1
    //   442: aload_1
    //   443: ifnull +17 -> 460
    //   446: aload_1
    //   447: invokevirtual 60	com/tencent/mobileqq/widget/QQProgressDialog:isShowing	()Z
    //   450: ifeq +10 -> 460
    //   453: aload_0
    //   454: getfield 54	com/tencent/mobileqq/jsp/ShareMsgImpl:jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   457: invokevirtual 63	com/tencent/mobileqq/widget/QQProgressDialog:dismiss	()V
    //   460: invokestatic 420	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   463: ifeq +13 -> 476
    //   466: ldc_w 405
    //   469: iconst_2
    //   470: ldc_w 474
    //   473: invokestatic 424	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   476: return
    //   477: aload_0
    //   478: getfield 54	com/tencent/mobileqq/jsp/ShareMsgImpl:jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   481: astore_2
    //   482: aload_2
    //   483: ifnull +17 -> 500
    //   486: aload_2
    //   487: invokevirtual 60	com/tencent/mobileqq/widget/QQProgressDialog:isShowing	()Z
    //   490: ifeq +10 -> 500
    //   493: aload_0
    //   494: getfield 54	com/tencent/mobileqq/jsp/ShareMsgImpl:jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   497: invokevirtual 63	com/tencent/mobileqq/widget/QQProgressDialog:dismiss	()V
    //   500: aload_1
    //   501: athrow
    //   502: invokestatic 420	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   505: ifeq +13 -> 518
    //   508: ldc_w 405
    //   511: iconst_2
    //   512: ldc_w 476
    //   515: invokestatic 424	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   518: aload_0
    //   519: getfield 54	com/tencent/mobileqq/jsp/ShareMsgImpl:jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   522: astore_1
    //   523: aload_1
    //   524: ifnull +17 -> 541
    //   527: aload_1
    //   528: invokevirtual 60	com/tencent/mobileqq/widget/QQProgressDialog:isShowing	()Z
    //   531: ifeq +10 -> 541
    //   534: aload_0
    //   535: getfield 54	com/tencent/mobileqq/jsp/ShareMsgImpl:jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   538: invokevirtual 63	com/tencent/mobileqq/widget/QQProgressDialog:dismiss	()V
    //   541: invokestatic 459	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   544: iconst_0
    //   545: ldc_w 460
    //   548: iconst_0
    //   549: invokestatic 465	com/tencent/mobileqq/widget/QQToast:a	(Landroid/content/Context;III)Lcom/tencent/mobileqq/widget/QQToast;
    //   552: invokestatic 459	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   555: invokevirtual 466	com/tencent/qphone/base/util/BaseApplication:getResources	()Landroid/content/res/Resources;
    //   558: ldc 133
    //   560: invokevirtual 139	android/content/res/Resources:getDimensionPixelSize	(I)I
    //   563: invokevirtual 469	com/tencent/mobileqq/widget/QQToast:b	(I)Landroid/widget/Toast;
    //   566: pop
    //   567: return
    //   568: astore 5
    //   570: goto -496 -> 74
    //   573: astore_2
    //   574: goto -404 -> 170
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	577	0	this	ShareMsgImpl
    //   0	577	1	paramString1	String
    //   0	577	2	paramString2	String
    //   0	577	3	paramString3	String
    //   0	577	4	paramString4	String
    //   20	342	5	localObject1	Object
    //   568	1	5	localException	Exception
    //   116	44	6	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   186	383	402	finally
    //   407	437	402	finally
    //   186	383	406	java/lang/Exception
    //   16	22	568	java/lang/Exception
    //   27	64	568	java/lang/Exception
    //   64	73	568	java/lang/Exception
    //   118	147	573	android/content/pm/PackageManager$NameNotFoundException
    //   147	167	573	android/content/pm/PackageManager$NameNotFoundException
  }
  
  void b(JSONObject paramJSONObject, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, int paramInt)
  {
    paramString1 = paramString2;
    Activity localActivity = this.jdField_a_of_type_AndroidAppActivity;
    Intent localIntent = new Intent();
    paramString3 = paramJSONObject.optString("toUin");
    int i = paramJSONObject.optInt("uinType", 0);
    if ((paramString3 != null) && (paramString3.length() >= 5))
    {
      localIntent.setClass(this.jdField_a_of_type_AndroidContentContext, DirectForwardActivity.class);
      localIntent.putExtra("toUin", paramString3);
      localIntent.putExtra("uinType", i);
    }
    else
    {
      localIntent.putExtra("isWebCompShare", true);
      localIntent.setClass(this.jdField_a_of_type_AndroidContentContext, ForwardRecentActivity.class);
    }
    localIntent.putExtra("key_flag_from_plugin", true);
    paramString3 = paramString1;
    if (paramString1 != null)
    {
      paramString3 = paramString1;
      if (paramString2.length() > 45)
      {
        paramString2 = new StringBuilder();
        paramString2.append(paramString1.substring(0, 45));
        paramString2.append("…");
        paramString3 = paramString2.toString();
      }
    }
    if (paramInt <= 0) {
      paramInt = 13;
    }
    if ((paramJSONObject.has("is_tribe_short_video")) && (paramJSONObject.getString("is_tribe_short_video").equals("true")))
    {
      if (paramJSONObject.has("tribe_video_vid")) {
        paramString2 = paramJSONObject.getString("tribe_video_vid");
      } else {
        paramString2 = "";
      }
      if (paramJSONObject.has("tribe_video_url")) {
        paramString5 = paramJSONObject.getString("tribe_video_url");
      } else {
        paramString5 = "";
      }
      if (paramJSONObject.has("tribe_video_theme")) {
        paramString6 = paramJSONObject.getString("tribe_video_theme");
      } else {
        paramString6 = "";
      }
      if (paramJSONObject.has("tribe_cover_url")) {
        paramString1 = paramJSONObject.getString("tribe_cover_url");
      } else {
        paramString1 = "";
      }
      if (paramJSONObject.has("tribe_video_width")) {
        i = paramJSONObject.getInt("tribe_video_width");
      } else {
        i = 0;
      }
      int j;
      if (paramJSONObject.has("tribe_video_height")) {
        j = paramJSONObject.getInt("tribe_video_height");
      } else {
        j = 0;
      }
      if (paramJSONObject.has("tribe_name")) {
        paramString7 = paramJSONObject.getString("tribe_name");
      } else {
        paramString7 = "";
      }
      String str1;
      if (paramJSONObject.has("tribe_bid")) {
        str1 = paramJSONObject.getString("tribe_bid");
      } else {
        str1 = "";
      }
      String str2;
      if (paramJSONObject.has("tribe_pid")) {
        str2 = paramJSONObject.getString("tribe_pid");
      } else {
        str2 = "";
      }
      localIntent.putExtra("forward_type", 36);
      try
      {
        JSONObject localJSONObject = new JSONObject();
        try
        {
          localJSONObject.put("is_tribe_short_video", 1);
          localJSONObject.put("tribe_name", paramString7);
          localJSONObject.put("tribe_video_vid", paramString2);
          localJSONObject.put("tribe_video_url", paramString5);
          localJSONObject.put("tribe_video_theme", paramString6);
          localJSONObject.put("tribe_video_width", i);
          localJSONObject.put("tribe_video_height", j);
          localJSONObject.put("tribe_bid", str1);
          localJSONObject.put("tribe_pid", str2);
          localIntent.putExtra("qqtribeVideoInfoExtra ", localJSONObject.toString());
          paramString2 = localJSONObject;
        }
        catch (Exception paramString5)
        {
          paramString2 = localJSONObject;
        }
        if (!QLog.isColorLevel()) {
          break label614;
        }
      }
      catch (Exception paramString5)
      {
        paramString2 = null;
      }
      QLog.d("ShareMsgImpl", 2, QLog.getStackTraceString(paramString5));
      label614:
      paramString5 = "ShareMsgImpl";
      paramString6 = paramString2;
    }
    else
    {
      paramString5 = "ShareMsgImpl";
      if (QLog.isColorLevel()) {
        QLog.w(paramString5, 2, "forward short video is false");
      }
      paramString1 = "";
      paramString6 = null;
    }
    localIntent.putExtra("pluginName", "web_share");
    localIntent.putExtra("title", paramString3);
    localIntent.putExtra("shareQQType", paramInt);
    localIntent.putExtra("forward_type", 36);
    localIntent.putExtra("req_share_id", paramJSONObject.optLong("appid", -1L));
    localIntent.putExtra("pkg_name", "com.tencent.mobileqq");
    localIntent.putExtra("image_url_remote", paramString1);
    localIntent.putExtra("brief_key", paramJSONObject.optString("desc"));
    localIntent.putExtra("flag", paramJSONObject.optInt("flag", 0));
    localIntent.putExtra("detail_url", paramString4);
    localIntent.putExtra("req_type", 118);
    localIntent.putExtra("openerProc", MobileQQ.getMobileQQ().getQQProcessName());
    boolean bool = paramJSONObject.optBoolean("back", false);
    if (paramJSONObject.has("k_back")) {
      bool = paramJSONObject.getBoolean("k_back");
    }
    localIntent.putExtra("k_back", bool);
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null) {
      a(localActivity);
    }
    paramString1 = this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
    if ((paramString1 != null) && (paramString1.isShowing()))
    {
      long l = System.currentTimeMillis();
      if (QLog.isColorLevel())
      {
        paramString1 = new StringBuilder();
        paramString1.append("dialog dimiss time :");
        paramString1.append(l);
        QLog.d(paramString5, 2, paramString1.toString());
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    }
    paramString2 = null;
    paramString3 = paramJSONObject.optString("puin", null);
    paramString1 = paramString3;
    if (paramString3 == null) {
      paramString1 = paramJSONObject.optString("oaUin");
    }
    if (!TextUtils.isEmpty(paramString1))
    {
      paramString3 = this.jdField_a_of_type_ComTencentCommonAppAppInterface;
      paramString4 = paramString3.getEntityManagerFactory(paramString3.getAccount()).createEntityManager();
      paramString3 = (IPublicAccountDetail)paramString4.find(((IPublicAccountProxy)QRoute.api(IPublicAccountProxy.class)).getImplClass(IPublicAccountDetail.class), paramString1);
      paramString4.close();
      if (paramString3 != null) {
        paramString2 = paramString3.getName();
      }
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
      localIntent.putExtra("source_url", paramJSONObject.optString("source_url", ""));
      localIntent.putExtra("struct_share_key_source_action", "web");
      localIntent.putExtra("source_puin", paramString1);
      localIntent.putExtra("app_name", paramString2);
      localIntent.putExtra("req_type", 118);
      paramJSONObject = StructMsgFactory.a(localIntent.getExtras());
      if (paramJSONObject == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d(paramString5, 2, "build struct msg fail");
        }
        this.jdField_a_of_type_ComTencentMobileqqJspShareMsgImpl$ShareMsgImplListener.onSharMsgcallback(this.jdField_a_of_type_JavaLangString, "false");
        return;
      }
      paramJSONObject.mMsgServiceID = 118;
      paramJSONObject.mTribeShortVideoExtra = paramString6.toString();
      paramJSONObject.mCompatibleText = MessageForTribeShortVideo.buildCompatibleText();
      localIntent.putExtra("stuctmsg_bytes", paramJSONObject.getBytes());
      this.jdField_a_of_type_ComTencentMobileqqJspShareMsgImpl$ShareMsgImplListener.startActivityForResult(localIntent, (byte)4);
    }
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
    try
    {
      paramString = new JSONObject(paramString);
      str1 = paramString.optString("title");
    }
    catch (JSONException paramString)
    {
      String str1;
      String str2;
      String str3;
      String str4;
      Object localObject;
      String str5;
      String str6;
      String str7;
      String str8;
      boolean bool1;
      String str9;
      boolean bool2;
      String str10;
      boolean bool3;
      boolean bool4;
      String str11;
      String str12;
      String str13;
      label563:
      label566:
      label569:
      break label569;
    }
    try
    {
      str2 = paramString.optString("desc");
      str3 = paramString.optString("share_url");
      str4 = paramString.optString("image_url");
      localObject = paramString.optString("type");
      str5 = paramString.optString("miniprogram_image_url");
    }
    catch (JSONException paramString)
    {
      break label566;
    }
    try
    {
      str6 = paramString.optString("cover_url");
      str7 = paramString.optString("source_name");
      str8 = paramString.optString("article_id");
      bool1 = paramString.optBoolean("editable", true);
      str9 = paramString.optString("policy");
      bool2 = paramString.optBoolean("isCreator", false);
      str10 = paramString.optString("singleLineTitle");
      bool3 = paramString.optBoolean("contentEdited");
      bool4 = paramString.optBoolean("isNewCreate");
      str11 = paramString.optString("groupCode");
      str12 = paramString.optString("domainId");
      str13 = paramString.optString("localPadId");
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
        if (!TextUtils.isEmpty(paramString)) {
          if ("docx".equals(paramString)) {
            ((TeamWorkDocEditBrowserActivity)localObject).a(1);
          } else if ("sheet".equals(paramString)) {
            ((TeamWorkDocEditBrowserActivity)localObject).a(2);
          }
        }
      }
      paramString = null;
      localObject = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin$PluginRuntime;
      if (localObject != null) {
        paramString = ((WebViewPlugin.PluginRuntime)localObject).a(this.jdField_a_of_type_AndroidAppActivity);
      }
      if ((paramString != null) && ((paramString instanceof WebUiUtils.WebShareInterface)))
      {
        localBundle.putInt("extra_url_info_from", 1);
        return ((WebUiUtils.WebShareInterface)paramString).setSummary(str1, str2, str3, str4, localBundle);
      }
      return false;
    }
    catch (JSONException paramString)
    {
      break label563;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ShareMsgImpl", 2, "setShareInfo param error");
    }
    return false;
  }
  
  public void c(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    try
    {
      localObject = new JSONObject(paramString);
      if ("0".equals(((JSONObject)localObject).optString("share_type", "0")))
      {
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
        if (localObject == null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("ShareMsgImpl", 2, "build struct msg fail");
          }
        }
        else {
          paramString.putExtra("stuctmsg_bytes", ((AbsStructMsg)localObject).getBytes());
        }
        this.jdField_a_of_type_ComTencentMobileqqJspShareMsgImpl$ShareMsgImplListener.startActivityForResult(paramString, (byte)1);
        return;
      }
    }
    catch (JSONException paramString)
    {
      Object localObject;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("shareHyperText error: ");
        ((StringBuilder)localObject).append(paramString.getMessage());
        QLog.d("ShareMsgImpl", 2, ((StringBuilder)localObject).toString());
      }
    }
  }
  
  void c(JSONObject paramJSONObject, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, int paramInt)
  {
    String str2 = paramString2;
    String str1 = paramString3;
    if ((paramJSONObject.has("isArkMessage")) && (paramJSONObject.getBoolean("isArkMessage")))
    {
      a(paramJSONObject);
      return;
    }
    Activity localActivity = this.jdField_a_of_type_AndroidAppActivity;
    Intent localIntent = new Intent();
    Object localObject2 = paramJSONObject.optString("toUin");
    int j = paramJSONObject.optInt("uinType", 0);
    localIntent.putExtra("forward_source_business_type", 100500);
    paramString1 = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin$PluginRuntime;
    if ((paramString1 != null) && (paramString1.a() != null))
    {
      paramString1 = (SwiftBrowserShareMenuHandler)this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin$PluginRuntime.a().getComponentProvider().a(4);
      localObject1 = paramString1.a();
      if (TextUtils.isEmpty(paramString1.h)) {
        paramString1 = "";
      } else {
        paramString1 = paramString1.h;
      }
      localIntent.putExtra("forward_source_sub_business_type", paramString1);
      paramString1 = (String)localObject1;
    }
    else
    {
      paramString1 = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin$PluginRuntime;
      if ((paramString1 != null) && (paramString1.a() != null))
      {
        paramString1 = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin$PluginRuntime.a().getParent();
        if ((paramString1 instanceof IQQComicHippyWebviewShareHelper))
        {
          paramString1 = (IQQComicHippyWebviewShareHelper)paramString1;
          if ((paramString1.getShareHelper() instanceof CommonShareHelper))
          {
            paramString1 = (CommonShareHelper)paramString1.getShareHelper();
            localObject1 = paramString1.a();
            if (TextUtils.isEmpty(paramString1.a())) {
              paramString1 = "";
            } else {
              paramString1 = paramString1.a();
            }
            localIntent.putExtra("forward_source_sub_business_type", paramString1);
            paramString1 = (String)localObject1;
            break label265;
          }
        }
      }
      paramString1 = null;
    }
    label265:
    Object localObject1 = localObject2;
    int i = j;
    if (TextUtils.isEmpty((CharSequence)localObject2))
    {
      localObject1 = localObject2;
      i = j;
      if (j == 0)
      {
        localObject1 = localObject2;
        i = j;
        if (paramString1 != null)
        {
          localObject1 = localObject2;
          i = j;
          if (!paramString1.isEmpty())
          {
            localObject2 = paramString1.getString("to_qq");
            j = paramString1.getInt("to_uin_type");
            localObject1 = localObject2;
            i = j;
            if (QLog.isColorLevel())
            {
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append("shareMsgToQQ() called : toUin = ");
              ((StringBuilder)localObject1).append((String)localObject2);
              ((StringBuilder)localObject1).append(", uinType = ");
              ((StringBuilder)localObject1).append(j);
              QLog.d("ShareMsgImpl", 2, ((StringBuilder)localObject1).toString());
              i = j;
              localObject1 = localObject2;
            }
          }
        }
      }
    }
    localObject2 = paramJSONObject.optString("toNickName");
    j = paramJSONObject.optInt("isEncryptUin", 0);
    if ((localObject1 != null) && (((String)localObject1).length() >= 5))
    {
      localIntent.setClass(this.jdField_a_of_type_AndroidContentContext, DirectForwardActivity.class);
      localIntent.putExtra("toUin", (String)localObject1);
      localIntent.putExtra("uinType", i);
      if (j == 1)
      {
        localIntent.putExtra("isEncryptUin", j);
        localIntent.putExtra("vfwebqq", paramJSONObject.optString("vfwebqq"));
        localIntent.putExtra("tok", paramJSONObject.optString("tok"));
      }
      localObject1 = localObject2;
      if (TextUtils.isEmpty((CharSequence)localObject2))
      {
        localObject1 = localObject2;
        if (paramString1 != null)
        {
          localObject1 = localObject2;
          if (!paramString1.isEmpty())
          {
            localObject1 = paramString1.getString("to_uin_name");
            if (QLog.isColorLevel())
            {
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("shareMsgToQQ() called : nickName = ");
              ((StringBuilder)localObject2).append((String)localObject1);
              QLog.d("ShareMsgImpl", 2, ((StringBuilder)localObject2).toString());
            }
            localIntent.putExtra("nickName", (String)localObject1);
          }
        }
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin == null) && (!TextUtils.isEmpty((CharSequence)localObject1))) {
        localIntent.putExtra("nickName", (String)localObject1);
      }
    }
    else
    {
      localIntent.putExtra("isWebCompShare", true);
      localIntent.setClass(this.jdField_a_of_type_AndroidContentContext, ForwardRecentActivity.class);
    }
    localIntent.putExtra("key_flag_from_plugin", true);
    j = 1001;
    localObject1 = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin$PluginRuntime;
    if (localObject1 != null) {
      localObject1 = ((WebViewPlugin.PluginRuntime)localObject1).a();
    } else {
      localObject1 = null;
    }
    i = j;
    if (localObject1 != null)
    {
      localObject1 = (SwiftBrowserShareMenuHandler)((WebViewProvider)localObject1).getComponentProvider().a(4);
      i = j;
      if (localObject1 != null)
      {
        i = j;
        if (((SwiftBrowserShareMenuHandler)localObject1).a != null)
        {
          i = j;
          if (((SwiftBrowserShareMenuHandler)localObject1).a.a(localIntent)) {
            i = 38;
          }
        }
      }
    }
    localObject1 = str2;
    if (str2 != null)
    {
      localObject1 = str2;
      if (paramString2.length() > 45)
      {
        paramString2 = new StringBuilder();
        paramString2.append(str2.substring(0, 45));
        paramString2.append("…");
        localObject1 = paramString2.toString();
      }
    }
    paramString2 = str1;
    if (str1 != null)
    {
      paramString2 = str1;
      if (paramString3.length() > 60)
      {
        paramString2 = new StringBuilder();
        paramString2.append(str1.substring(0, 60));
        paramString2.append("…");
        paramString2 = paramString2.toString();
      }
    }
    if (paramInt <= 0) {
      paramInt = 13;
    }
    localIntent.putExtra("pluginName", "web_share");
    localIntent.putExtra("title", (String)localObject1);
    localIntent.putExtra("desc", paramString2);
    localIntent.putExtra("detail_url", paramString4);
    localIntent.putExtra("shareQQType", paramInt);
    localIntent.putExtra("forward_type", i);
    localIntent.putExtra("req_share_id", paramJSONObject.optLong("appid", -1L));
    localIntent.putExtra("pkg_name", "com.tencent.mobileqq");
    localIntent.putExtra("image_url_remote", paramString5);
    localIntent.putExtra("brief_key", BaseApplicationImpl.getContext().getString(2131696401, new Object[] { localObject1 }));
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
      localIntent.putExtra("audio_url", paramString7);
      paramInt = 2;
    }
    else
    {
      i = paramJSONObject.optInt("req_type", 146);
      paramInt = i;
      if (i == 2)
      {
        localIntent.putExtra("audio_url", paramJSONObject.getString("audio_url"));
        paramInt = i;
      }
    }
    localIntent.putExtra("req_type", paramInt);
    if (paramJSONObject.has("report")) {
      localIntent.putExtra("report", paramJSONObject.getString("report"));
    }
    localIntent.putExtra("openerProc", MobileQQ.getMobileQQ().getQQProcessName());
    boolean bool = paramJSONObject.optBoolean("back", false);
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
    long l = paramJSONObject.optLong("appid", 0L);
    if (l > 0L)
    {
      paramJSONObject = this.jdField_a_of_type_ComTencentCommonAppAppInterface;
      if (paramJSONObject != null)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null) {
          a(localActivity);
        }
        if (!this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())
        {
          this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(2131693895);
          this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
        }
        localIntent.putExtra("struct_share_key_source_name", Long.toString(l));
        Share.a(paramJSONObject, this.jdField_a_of_type_AndroidContentContext, paramJSONObject.getAccount(), l, 3000L, new ShareMsgImpl.5(this, localIntent, l, paramString4));
      }
    }
    else
    {
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null) {
        a(localActivity);
      }
      paramString2 = this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
      if ((paramString2 != null) && (paramString2.isShowing()))
      {
        l = System.currentTimeMillis();
        if (QLog.isColorLevel())
        {
          paramString2 = new StringBuilder();
          paramString2.append("dialog dimiss time :");
          paramString2.append(l);
          QLog.d("ShareMsgImpl", 2, paramString2.toString());
        }
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
      }
      paramString4 = null;
      paramString3 = null;
      paramString5 = paramJSONObject.optString("puin", null);
      paramString2 = paramString5;
      if (paramString5 == null) {
        paramString2 = paramJSONObject.optString("oaUin");
      }
      if (!TextUtils.isEmpty(paramString2))
      {
        paramString5 = this.jdField_a_of_type_ComTencentCommonAppAppInterface;
        paramString5 = paramString5.getEntityManagerFactory(paramString5.getAccount()).createEntityManager();
        paramString6 = (IPublicAccountDetail)paramString5.find(((IPublicAccountProxy)QRoute.api(IPublicAccountProxy.class)).getImplClass(IPublicAccountDetail.class), paramString2);
        paramString5.close();
        paramString5 = paramJSONObject.optString("src_action", "");
        if (TextUtils.isEmpty(paramString5))
        {
          if (paramString6 != null) {
            paramString3 = paramString6.getName();
          }
          paramString4 = paramString3;
          if (TextUtils.isEmpty(paramString3))
          {
            paramString4 = paramString3;
            if (paramJSONObject.has("sourceName")) {
              paramString4 = paramJSONObject.optString("sourceName");
            }
          }
          paramString3 = paramString4;
          if (!TextUtils.isEmpty(paramString4)) {
            break label1917;
          }
        }
        else
        {
          paramString3 = paramString4;
          if (paramJSONObject.has("sourceName")) {
            paramString3 = paramJSONObject.optString("sourceName");
          }
          paramString4 = paramString3;
          if (TextUtils.isEmpty(paramString3))
          {
            paramString4 = paramString3;
            if (paramString6 != null) {
              paramString4 = paramString6.getName();
            }
          }
          paramString3 = paramString4;
          if (!TextUtils.isEmpty(paramString4)) {
            break label1917;
          }
        }
        paramString3 = paramString2;
        label1917:
        if (paramString3.equalsIgnoreCase(this.jdField_a_of_type_AndroidContentContext.getString(2131699864)))
        {
          bool = paramString3.equalsIgnoreCase(this.jdField_a_of_type_AndroidContentContext.getString(2131699864));
          if (bool) {
            paramJSONObject = "mqqapi://app/action?pkg=com.tencent.mobileqq&cmp=cooperation.readinjoy.ReadInJoyProxyActivity";
          } else {
            paramJSONObject = "mqqapi://app/action?pkg=com.tencent.mobileqq&cmp=cooperation.readinjoy.ReadInJoyProxyActivity&from=recent";
          }
          if (bool) {
            paramString4 = "mqqapi://readinjoy/open?src_type=internal&version=1";
          } else {
            paramString4 = "mqqapi://readinjoy/open?src_type=internal&version=1&from=recent";
          }
          if (bool) {
            paramString5 = "https://sqimg.qq.com/qq_product_operations/ydqpush/message_icon/kandian.png";
          } else {
            paramString5 = "https://sqimg.qq.com/qq_product_operations/ydqpush/message_icon/dingyuehao.png";
          }
          localIntent.putExtra("source_puin", paramString2);
          localIntent.putExtra("struct_share_key_source_action", "plugin");
          localIntent.putExtra("struct_share_key_source_a_action_data", paramJSONObject);
          localIntent.putExtra("struct_share_key_source_i_action_data", paramString4);
          localIntent.putExtra("struct_share_key_content_a_action_DATA", paramJSONObject);
          localIntent.putExtra("struct_share_key_source_icon", paramString5);
          localIntent.putExtra("app_name", paramString3);
        }
        else
        {
          paramString4 = paramJSONObject.optString("src_webActionUrl", "");
          paramString6 = paramJSONObject.optString("src_actionData", "");
          paramString7 = paramJSONObject.optString("src_a_actionData", "");
          str1 = paramJSONObject.optString("src_i_actionData", "");
          if ((!TextUtils.isEmpty(paramString5)) && ((!"web".equals(paramString5)) || ((!TextUtils.isEmpty(paramString4)) && (!paramString4.contains("webcard.mp.qq.com")))) && (("web".equals(paramString5)) || (!TextUtils.isEmpty(paramString6)) || ((!TextUtils.isEmpty(paramString7)) && (!TextUtils.isEmpty(str1)))))
          {
            localIntent.putExtra("struct_share_key_source_action", paramString5);
            if ("web".equals(paramString5))
            {
              localIntent.putExtra("struct_share_key_source_url", paramString4);
              localIntent.putExtra("source_url", paramString4);
            }
            else
            {
              if (!TextUtils.isEmpty(paramString6)) {
                localIntent.putExtra("struct_share_key_source_action_data", paramString6);
              }
              if (!TextUtils.isEmpty(paramString7)) {
                localIntent.putExtra("struct_share_key_source_a_action_data", paramString7);
              }
              if (!TextUtils.isEmpty(str1)) {
                localIntent.putExtra("struct_share_key_source_i_action_data", str1);
              }
            }
          }
          else
          {
            paramString4 = String.format("mqqapi://app/action?pkg=com.tencent.mobileqq&cmp=com.tencent.biz.pubaccount.AccountDetail.activity.api.impl.AccountDetailActivity&uin=%s", new Object[] { paramString2 });
            paramString5 = String.format("mqqapi://card/show_pslcard?src_type=internal&card_type=public_account&uin=%s&version=1", new Object[] { paramString2 });
            localIntent.putExtra("struct_share_key_source_action", "plugin");
            localIntent.putExtra("struct_share_key_source_a_action_data", paramString4);
            localIntent.putExtra("struct_share_key_source_i_action_data", paramString5);
          }
          localIntent.putExtra("source_puin", paramString2);
          localIntent.putExtra("app_name", paramString3);
          paramJSONObject = paramJSONObject.optString("src_iconUrl", "");
          if (TextUtils.isEmpty(paramJSONObject)) {
            localIntent.putExtra("struct_share_key_source_icon", "https://url.cn/JS8oE7");
          } else {
            localIntent.putExtra("struct_share_key_source_icon", paramJSONObject);
          }
        }
      }
      else if (paramJSONObject.has("sourceName"))
      {
        paramString2 = paramJSONObject.optString("sourceName");
        localIntent.putExtra("app_name", paramString2);
        if (("手Q阅读".equals(paramString2)) && (paramJSONObject.has("srcIconUrl"))) {
          localIntent.putExtra("struct_share_key_source_icon", paramJSONObject.optString("srcIconUrl"));
        }
        if (("QQ动漫".equals(paramString2)) && (paramJSONObject.has("srcIconUrl"))) {
          localIntent.putExtra("struct_share_key_source_icon", paramJSONObject.optString("srcIconUrl"));
        }
      }
      else
      {
        localIntent.putExtra("app_name", this.jdField_a_of_type_AndroidContentContext.getString(2131696418));
      }
      paramJSONObject = this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebUiUtils$WebShareReportInterface;
      if ((paramJSONObject != null) && (this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebUiUtils$WebUiMethodInterface != null))
      {
        localIntent.putExtra("strurt_msgid", paramJSONObject.a());
        localIntent.putExtra("struct_uin", this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebUiUtils$WebShareReportInterface.b());
        localIntent.putExtra("struct_url", this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebUiUtils$WebUiMethodInterface.getCurrentUrl());
        localIntent.putExtra("from_web", true);
        if ((this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebUiUtils$WebShareReportInterface.c() != null) && (!"".equals(this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebUiUtils$WebShareReportInterface.c()))) {
          localIntent.putExtra("source_puin", this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebUiUtils$WebShareReportInterface.c());
        }
      }
      paramJSONObject = StructMsgFactory.a(localIntent.getExtras());
      if (paramJSONObject == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ShareMsgImpl", 2, "build struct msg fail");
        }
        this.jdField_a_of_type_ComTencentMobileqqJspShareMsgImpl$ShareMsgImplListener.onSharMsgcallback(this.jdField_a_of_type_JavaLangString, "false");
        return;
      }
      localIntent.putExtra("stuctmsg_bytes", paramJSONObject.getBytes());
      this.jdField_a_of_type_ComTencentMobileqqJspShareMsgImpl$ShareMsgImplListener.startActivityForResult(localIntent, (byte)1);
    }
    if (paramString1 != null) {
      paramString1.clear();
    }
  }
  
  public void d(String paramString)
  {
    try
    {
      this.jdField_a_of_type_JavaLangString = null;
      localObject = new JSONObject(paramString);
      Intent localIntent = new Intent();
      paramString = ((JSONObject)localObject).optString("toUin");
      if ((paramString != null) && (paramString.length() >= 5))
      {
        this.jdField_a_of_type_JavaLangString = ((JSONObject)localObject).optString("callback");
        localIntent.setClass(this.jdField_a_of_type_AndroidContentContext, DirectForwardActivity.class);
        localIntent.putExtra("toUin", paramString);
        localIntent.putExtra("key_flag_from_plugin", true);
        localIntent.putExtra("pluginName", "web_share");
        localIntent.putExtra("forward_type", 30);
        localIntent.putExtra("k_back", true);
        this.jdField_a_of_type_ComTencentMobileqqJspShareMsgImpl$ShareMsgImplListener.startActivityForResult(localIntent, (byte)2);
        return;
      }
      if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
        this.jdField_a_of_type_ComTencentMobileqqJspShareMsgImpl$ShareMsgImplListener.onSharMsgcallback(this.jdField_a_of_type_JavaLangString, "{\"result\":0}");
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("toUin invalide: ");
        ((StringBuilder)localObject).append(paramString);
        QLog.d("ShareMsgImpl", 2, ((StringBuilder)localObject).toString());
      }
      return;
    }
    catch (JSONException paramString)
    {
      Object localObject;
      this.jdField_a_of_type_ComTencentMobileqqJspShareMsgImpl$ShareMsgImplListener.onSharMsgcallback(this.jdField_a_of_type_JavaLangString, "{\"result\":0}");
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("shareMsg error: ");
        ((StringBuilder)localObject).append(paramString.toString());
        QLog.d("ShareMsgImpl", 2, ((StringBuilder)localObject).toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.jsp.ShareMsgImpl
 * JD-Core Version:    0.7.0.1
 */