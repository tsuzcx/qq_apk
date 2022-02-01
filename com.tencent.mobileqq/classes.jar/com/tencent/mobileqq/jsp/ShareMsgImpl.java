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
  QQProgressDialog a;
  String b;
  WXShareHelper.WXShareListener c;
  IWxShareHelperFromReadInjoy.WXShareHelperFromReadInjoyListener d;
  String e;
  Context f;
  WebUiUtils.WebUiMethodInterface g = null;
  WebUiUtils.QQBrowserBaseActivityInterface h = null;
  WebUiUtils.WebShareReportInterface i = null;
  WebUiUtils.WebShareInterface j = null;
  TroopMemberApiClient k = null;
  WebViewPlugin.PluginRuntime l;
  WebViewPlugin m;
  Activity n;
  AppInterface o;
  ShareMsgImpl.ShareMsgImplListener p;
  
  public ShareMsgImpl(Context paramContext, Activity paramActivity, AppInterface paramAppInterface, ShareMsgImpl.ShareMsgImplListener paramShareMsgImplListener)
  {
    this.f = paramContext;
    this.n = paramActivity;
    this.o = paramAppInterface;
    this.p = paramShareMsgImplListener;
    if (this.k == null)
    {
      this.k = TroopMemberApiClient.a();
      this.k.e();
    }
  }
  
  public void a()
  {
    Object localObject = this.a;
    if ((localObject != null) && (((QQProgressDialog)localObject).isShowing())) {
      this.a.dismiss();
    }
    if (this.c != null) {
      WXShareHelper.a().b(this.c);
    }
    localObject = this.k;
    if (localObject != null) {
      ((TroopMemberApiClient)localObject).f();
    }
    if (this.d != null) {
      ((IWxShareHelperFromReadInjoy)QRoute.api(IWxShareHelperFromReadInjoy.class)).removeObserver(this.d);
    }
  }
  
  void a(Activity paramActivity)
  {
    if (this.a == null)
    {
      Object localObject = this.j;
      if (localObject != null)
      {
        this.a = ((Share)((WebUiUtils.WebShareInterface)localObject).getShare()).u();
        return;
      }
      localObject = null;
      WebViewPlugin.PluginRuntime localPluginRuntime = this.l;
      if (localPluginRuntime != null) {
        localObject = localPluginRuntime.a(this.n);
      }
      if (paramActivity.getClass().getName().equalsIgnoreCase("com.tencent.qqreadinjoy.detailspage.ReadInJoyArticleDetailActivity"))
      {
        if ((paramActivity instanceof WebUiUtils.WebShareInterface))
        {
          this.a = ((Share)((WebUiUtils.WebShareInterface)paramActivity).getShare()).u();
          return;
        }
        this.a = new QQProgressDialog(paramActivity, paramActivity.getResources().getDimensionPixelSize(2131299920));
        return;
      }
      if ((localObject instanceof WebUiUtils.WebShareInterface))
      {
        this.a = ((Share)((WebUiUtils.WebShareInterface)paramActivity).getShare()).u();
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
              this.a = ((CommonShareHelper)localObject).a().a();
              return;
            }
            this.a = new QQProgressDialog(paramActivity, paramActivity.getResources().getDimensionPixelSize(2131299920));
            return;
          }
        }
        this.a = new QQProgressDialog(paramActivity, paramActivity.getResources().getDimensionPixelSize(2131299920));
        return;
      }
      this.a = new QQProgressDialog(paramActivity, paramActivity.getResources().getDimensionPixelSize(2131299920));
    }
  }
  
  public void a(Intent paramIntent, byte paramByte, int paramInt)
  {
    String str;
    if (paramByte == 1)
    {
      localObject = this.p;
      str = this.b;
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
      paramIntent = this.p;
      str = this.b;
      if (paramInt == -1) {
        localObject = "{\"result\":1}";
      }
      paramIntent.onSharMsgcallback(str, (String)localObject);
      return;
    }
    if (paramByte == 3)
    {
      paramIntent = this.p;
      str = this.b;
      if (paramInt != -1) {
        localObject = "{\"result\":4}";
      }
      paramIntent.onSharMsgcallback(str, (String)localObject);
      return;
    }
    if (paramByte == 4)
    {
      localObject = this.n;
      if ((paramInt == -1) && (localObject != null) && (!((Activity)localObject).isFinishing()) && (paramIntent != null))
      {
        paramIntent = new Bundle(paramIntent.getExtras());
        this.k.b(paramIntent);
      }
    }
  }
  
  public void a(WebUiBaseInterface paramWebUiBaseInterface)
  {
    if ((this.g == null) && ((paramWebUiBaseInterface instanceof WebUiUtils.WebUiMethodInterface))) {
      this.g = ((WebUiUtils.WebUiMethodInterface)paramWebUiBaseInterface);
    }
    if ((this.h == null) && ((paramWebUiBaseInterface instanceof WebUiUtils.QQBrowserBaseActivityInterface))) {
      this.h = ((WebUiUtils.QQBrowserBaseActivityInterface)paramWebUiBaseInterface);
    }
    if ((this.j == null) && ((paramWebUiBaseInterface instanceof WebUiUtils.WebShareInterface))) {
      this.j = ((WebUiUtils.WebShareInterface)paramWebUiBaseInterface);
    }
  }
  
  public void a(WebViewPlugin paramWebViewPlugin)
  {
    this.m = paramWebViewPlugin;
    this.l = paramWebViewPlugin.mRuntime;
    paramWebViewPlugin = this.l;
    paramWebViewPlugin = paramWebViewPlugin.a(paramWebViewPlugin.d());
    if ((paramWebViewPlugin != null) && ((paramWebViewPlugin instanceof WebUiUtils.WebUiMethodInterface))) {
      this.g = ((WebUiUtils.WebUiMethodInterface)paramWebViewPlugin);
    }
    paramWebViewPlugin = this.l;
    paramWebViewPlugin = paramWebViewPlugin.a(paramWebViewPlugin.d());
    if ((paramWebViewPlugin != null) && ((paramWebViewPlugin instanceof WebUiUtils.QQBrowserBaseActivityInterface))) {
      this.h = ((WebUiUtils.QQBrowserBaseActivityInterface)paramWebViewPlugin);
    }
    paramWebViewPlugin = this.l;
    paramWebViewPlugin = paramWebViewPlugin.a(paramWebViewPlugin.d());
    if ((paramWebViewPlugin != null) && ((paramWebViewPlugin instanceof WebUiUtils.WebShareInterface))) {
      this.j = ((WebUiUtils.WebShareInterface)paramWebViewPlugin);
    }
    b(this.m);
  }
  
  /* Error */
  void a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 54	com/tencent/mobileqq/jsp/ShareMsgImpl:n	Landroid/app/Activity;
    //   4: astore_2
    //   5: aload_0
    //   6: getfield 68	com/tencent/mobileqq/jsp/ShareMsgImpl:a	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   9: ifnonnull +8 -> 17
    //   12: aload_0
    //   13: aload_2
    //   14: invokevirtual 238	com/tencent/mobileqq/jsp/ShareMsgImpl:a	(Landroid/app/Activity;)V
    //   17: aload_1
    //   18: invokestatic 244	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   21: ifne +354 -> 375
    //   24: aload_3
    //   25: invokestatic 244	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   28: ifeq +6 -> 34
    //   31: goto +344 -> 375
    //   34: invokestatic 249	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   37: ifeq +11 -> 48
    //   40: ldc 251
    //   42: iconst_2
    //   43: ldc 253
    //   45: invokestatic 256	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   48: aload_1
    //   49: ldc_w 258
    //   52: invokestatic 264	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   55: astore_1
    //   56: new 266	java/lang/StringBuilder
    //   59: dup
    //   60: invokespecial 267	java/lang/StringBuilder:<init>	()V
    //   63: astore 5
    //   65: aload 5
    //   67: ldc_w 269
    //   70: invokevirtual 273	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   73: pop
    //   74: aload 5
    //   76: ldc_w 275
    //   79: invokevirtual 273	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   82: pop
    //   83: aload 5
    //   85: aload_1
    //   86: invokevirtual 273	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   89: pop
    //   90: aload 5
    //   92: invokevirtual 278	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   95: astore_1
    //   96: aload_3
    //   97: ldc_w 258
    //   100: invokestatic 264	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   103: astore_3
    //   104: new 266	java/lang/StringBuilder
    //   107: dup
    //   108: invokespecial 267	java/lang/StringBuilder:<init>	()V
    //   111: astore 5
    //   113: aload 5
    //   115: aload_1
    //   116: invokevirtual 273	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   119: pop
    //   120: aload 5
    //   122: ldc_w 280
    //   125: invokevirtual 273	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   128: pop
    //   129: aload 5
    //   131: aload_3
    //   132: invokevirtual 273	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   135: pop
    //   136: aload 5
    //   138: invokevirtual 278	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   141: astore_1
    //   142: aload 4
    //   144: ldc_w 258
    //   147: invokestatic 264	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   150: astore_3
    //   151: new 266	java/lang/StringBuilder
    //   154: dup
    //   155: invokespecial 267	java/lang/StringBuilder:<init>	()V
    //   158: astore 4
    //   160: aload 4
    //   162: aload_1
    //   163: invokevirtual 273	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   166: pop
    //   167: aload 4
    //   169: ldc_w 282
    //   172: invokevirtual 273	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   175: pop
    //   176: aload 4
    //   178: aload_3
    //   179: invokevirtual 273	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   182: pop
    //   183: aload 4
    //   185: invokevirtual 278	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   188: astore_1
    //   189: new 266	java/lang/StringBuilder
    //   192: dup
    //   193: invokespecial 267	java/lang/StringBuilder:<init>	()V
    //   196: astore_3
    //   197: aload_3
    //   198: aload_1
    //   199: invokevirtual 273	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   202: pop
    //   203: aload_3
    //   204: ldc_w 284
    //   207: invokevirtual 273	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   210: pop
    //   211: aload_3
    //   212: invokevirtual 278	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   215: astore_1
    //   216: new 206	android/content/Intent
    //   219: dup
    //   220: aload_2
    //   221: ldc_w 286
    //   224: invokespecial 289	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   227: astore_3
    //   228: aload_3
    //   229: ldc_w 291
    //   232: aload_1
    //   233: invokevirtual 295	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   236: pop
    //   237: aload_2
    //   238: aload_3
    //   239: invokevirtual 299	android/app/Activity:startActivity	(Landroid/content/Intent;)V
    //   242: invokestatic 249	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   245: ifeq +12 -> 257
    //   248: ldc 251
    //   250: iconst_2
    //   251: ldc_w 301
    //   254: invokestatic 256	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   257: aload_0
    //   258: getfield 68	com/tencent/mobileqq/jsp/ShareMsgImpl:a	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   261: astore_1
    //   262: aload_1
    //   263: ifnull +71 -> 334
    //   266: aload_1
    //   267: invokevirtual 74	com/tencent/mobileqq/widget/QQProgressDialog:isShowing	()Z
    //   270: ifeq +64 -> 334
    //   273: goto +54 -> 327
    //   276: astore_1
    //   277: goto +73 -> 350
    //   280: astore_1
    //   281: invokestatic 307	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   284: iconst_0
    //   285: ldc_w 308
    //   288: iconst_0
    //   289: invokestatic 314	com/tencent/mobileqq/widget/QQToast:makeText	(Landroid/content/Context;III)Lcom/tencent/mobileqq/widget/QQToast;
    //   292: invokestatic 307	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   295: invokevirtual 315	com/tencent/qphone/base/util/BaseApplication:getResources	()Landroid/content/res/Resources;
    //   298: ldc 148
    //   300: invokevirtual 154	android/content/res/Resources:getDimensionPixelSize	(I)I
    //   303: invokevirtual 319	com/tencent/mobileqq/widget/QQToast:show	(I)Landroid/widget/Toast;
    //   306: pop
    //   307: aload_1
    //   308: invokevirtual 322	java/lang/Exception:printStackTrace	()V
    //   311: aload_0
    //   312: getfield 68	com/tencent/mobileqq/jsp/ShareMsgImpl:a	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   315: astore_1
    //   316: aload_1
    //   317: ifnull +17 -> 334
    //   320: aload_1
    //   321: invokevirtual 74	com/tencent/mobileqq/widget/QQProgressDialog:isShowing	()Z
    //   324: ifeq +10 -> 334
    //   327: aload_0
    //   328: getfield 68	com/tencent/mobileqq/jsp/ShareMsgImpl:a	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   331: invokevirtual 77	com/tencent/mobileqq/widget/QQProgressDialog:dismiss	()V
    //   334: invokestatic 249	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   337: ifeq +12 -> 349
    //   340: ldc 251
    //   342: iconst_2
    //   343: ldc_w 324
    //   346: invokestatic 256	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   349: return
    //   350: aload_0
    //   351: getfield 68	com/tencent/mobileqq/jsp/ShareMsgImpl:a	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   354: astore_2
    //   355: aload_2
    //   356: ifnull +17 -> 373
    //   359: aload_2
    //   360: invokevirtual 74	com/tencent/mobileqq/widget/QQProgressDialog:isShowing	()Z
    //   363: ifeq +10 -> 373
    //   366: aload_0
    //   367: getfield 68	com/tencent/mobileqq/jsp/ShareMsgImpl:a	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   370: invokevirtual 77	com/tencent/mobileqq/widget/QQProgressDialog:dismiss	()V
    //   373: aload_1
    //   374: athrow
    //   375: invokestatic 249	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   378: ifeq +12 -> 390
    //   381: ldc 251
    //   383: iconst_2
    //   384: ldc_w 326
    //   387: invokestatic 256	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   390: aload_0
    //   391: getfield 68	com/tencent/mobileqq/jsp/ShareMsgImpl:a	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   394: astore_1
    //   395: aload_1
    //   396: ifnull +17 -> 413
    //   399: aload_1
    //   400: invokevirtual 74	com/tencent/mobileqq/widget/QQProgressDialog:isShowing	()Z
    //   403: ifeq +10 -> 413
    //   406: aload_0
    //   407: getfield 68	com/tencent/mobileqq/jsp/ShareMsgImpl:a	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   410: invokevirtual 77	com/tencent/mobileqq/widget/QQProgressDialog:dismiss	()V
    //   413: invokestatic 307	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   416: iconst_0
    //   417: ldc_w 308
    //   420: iconst_0
    //   421: invokestatic 314	com/tencent/mobileqq/widget/QQToast:makeText	(Landroid/content/Context;III)Lcom/tencent/mobileqq/widget/QQToast;
    //   424: invokestatic 307	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   427: invokevirtual 315	com/tencent/qphone/base/util/BaseApplication:getResources	()Landroid/content/res/Resources;
    //   430: ldc 148
    //   432: invokevirtual 154	android/content/res/Resources:getDimensionPixelSize	(I)I
    //   435: invokevirtual 319	com/tencent/mobileqq/widget/QQToast:show	(I)Landroid/widget/Toast;
    //   438: pop
    //   439: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	440	0	this	ShareMsgImpl
    //   0	440	1	paramString1	String
    //   0	440	2	paramString2	String
    //   0	440	3	paramString3	String
    //   0	440	4	paramString4	String
    //   63	74	5	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   48	257	276	finally
    //   281	311	276	finally
    //   48	257	280	java/lang/Exception
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
    Object localObject = this.n;
    if (this.a == null) {
      a((Activity)localObject);
    }
    QQProgressDialog localQQProgressDialog = this.a;
    if ((localQQProgressDialog != null) && (localQQProgressDialog.isShowing())) {
      this.a.dismiss();
    }
    QidianManager.a((Activity)localObject, paramInt, paramString1, paramString2, paramString3, paramString4, "", 0, false);
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    long l1 = System.currentTimeMillis();
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("dialog get web js time :");
      ((StringBuilder)localObject1).append(l1);
      QLog.d("ShareMsgImpl", 2, ((StringBuilder)localObject1).toString());
    }
    this.b = null;
    label1330:
    label1338:
    label1351:
    label1356:
    label1359:
    for (;;)
    {
      Object localObject2;
      try
      {
        localObject2 = new JSONObject(paramString);
        localObject1 = this.n;
        if (paramBoolean)
        {
          paramString = "shareType";
          String str1 = ((JSONObject)localObject2).optString(paramString, "0");
          String str2 = ((JSONObject)localObject2).optString("title");
          String str3 = ((JSONObject)localObject2).optString("desc");
          if (!paramBoolean) {
            break label1338;
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
            i3 = ((JSONObject)localObject2).optInt("WXShareFromQQKandian");
            localObject3 = ((JSONObject)localObject2).optString("short_video_vid");
            String str11 = ((JSONObject)localObject2).optString("short_video_url");
            String str12 = ((JSONObject)localObject2).optString("short_video_cover_url");
            String str13 = ((JSONObject)localObject2).optString("short_video_theme_name");
            paramString = ((JSONObject)localObject2).optString("is_tribe_short_video");
            if (TextUtils.isEmpty(str5))
            {
              i2 = 1;
              i1 = i2;
              if (TextUtils.isEmpty(str3)) {
                i1 = i2 | 0x2;
              }
              i2 = i1;
              if (TextUtils.isEmpty(str2)) {
                i2 = i1 | 0x4;
              }
              localObject4 = new Bundle();
              ((Bundle)localObject4).putString("report_type", "102");
              ((Bundle)localObject4).putString("act_type", "94");
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append("");
              if (i2 != 0) {
                break label1351;
              }
              i1 = 0;
              localStringBuilder.append(i1);
              ((Bundle)localObject4).putString("intext_1", localStringBuilder.toString());
              localStringBuilder = new StringBuilder();
              localStringBuilder.append("");
              localStringBuilder.append(i2);
              ((Bundle)localObject4).putString("intext_2", localStringBuilder.toString());
              localStringBuilder = new StringBuilder();
              localStringBuilder.append("");
              localStringBuilder.append(str4);
              ((Bundle)localObject4).putString("stringext_1", localStringBuilder.toString());
              ReportCenter.a().a((Bundle)localObject4, "", this.o.getAccount(), false);
              i1 = ((JSONObject)localObject2).optInt("shareQQType", 13);
              this.b = ((JSONObject)localObject2).optString("callback");
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
                break label1356;
              }
              ((HashMap)localObject4).put("short_video_url", str11);
              if (!TextUtils.isEmpty(str13)) {
                ((HashMap)localObject4).put("short_video_theme_name", str11);
              }
              if (TextUtils.isEmpty(paramString)) {
                break label1359;
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
            int i3;
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
          localObject3 = this.a;
          if (localObject3 == null) {
            a((Activity)localObject1);
          }
          paramBoolean = this.a.isShowing();
          if (!paramBoolean)
          {
            this.a.c(2131891516);
            this.a.show();
          }
        }
        try
        {
          ThreadManager.post(new ShareMsgImpl.1(this, (HashMap)localObject4, str4, str5, str7, str1, (JSONObject)localObject2, str2, str3, str6, str8, str9, str10, i3, paramString, i1, (Activity)localObject1), 8, null, true);
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
          b((JSONObject)localObject2, str1, str2, str3, str4, str5, str6, str7, i1);
          return;
        }
        c((JSONObject)localObject2, str1, str2, str3, str4, str5, str6, str7, i1);
        ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).reportPAShareItemEvent(1001, str4, str8, str9, str10);
        return;
        a((JSONObject)localObject2, str1, str2, str3, str4, str5, str6, str7, i3);
        if ("2".equals(str1)) {
          ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).reportPAShareItemEvent(1003, str4, str8, str9, str10);
        }
        if (!"3".equals(str1)) {
          break label1330;
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
      int i2 = 0;
      continue;
      int i1 = 1;
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
        if (this.l == null) {
          break label299;
        }
        Object localObject2 = this.l.a().getPluginEngine();
        String str1 = this.l.f().getCurrentUrl();
        bool = ((WebViewPluginEngine)localObject2).c().a(str1, "QQApi.shareArkMessage");
        if (!bool)
        {
          QLog.e("ShareMsgImpl", 1, "shareArkMessage permission deny!");
          if ((this.a == null) || (!this.a.isShowing())) {
            break;
          }
          this.a.dismiss();
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
        paramJSONObject = this.n;
        if (paramJSONObject != null)
        {
          localObject1 = ArkFullScreenAppActivity.a(paramJSONObject, (String)localObject2, str1, str2, "", paramJSONObject.getResources().getDisplayMetrics().scaledDensity, (Map)localObject1);
          if (localObject1 != null) {
            ForwardBaseOption.a(paramJSONObject, (Intent)localObject1);
          }
        }
        if ((this.a != null) && (this.a.isShowing()))
        {
          this.a.dismiss();
          return;
        }
      }
      catch (Exception paramJSONObject)
      {
        QLog.e("ShareMsgImpl", 1, "shareArkMsg error:", paramJSONObject);
      }
      return;
      label299:
      boolean bool = true;
    }
  }
  
  void a(JSONObject paramJSONObject, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    paramString1 = this.n;
    if (this.a == null) {
      a(paramString1);
    }
    paramString6 = this.a;
    if ((paramString6 != null) && (paramString6.isShowing())) {
      this.a.dismiss();
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
    paramString6.putLong("share_begin_time", SwiftBrowserShareMenuHandler.x);
    paramJSONObject = this.i;
    if ((paramJSONObject != null) && (this.g != null))
    {
      paramString6.putString("strurt_msgid", paramJSONObject.d());
      paramString6.putString("struct_uin", this.i.e());
      paramString6.putString("struct_url", this.g.getCurrentUrl());
      paramString6.putBoolean("from_web", true);
      if ((this.i.f() != null) && (!"".equals(this.i.f()))) {
        paramString6.putString("source_puin", this.i.f());
      }
    }
    paramJSONObject = this.h;
    if (paramJSONObject != null)
    {
      paramString2 = this.m;
      if (paramString2 != null)
      {
        i1 = paramJSONObject.switchRequestCode(paramString2, (byte)1, true);
        break label320;
      }
    }
    int i1 = 1;
    label320:
    if (paramString1.getIntent().getBooleanExtra("confess_half_screen_web", false)) {
      i1 = 15001;
    }
    if (QZoneShareManager.jumpToQzoneShare(this.o, this.f, paramString6, null, i1)) {
      return;
    }
    QRUtils.a(1, 2131886094);
    this.p.onSharMsgcallback(this.b, "false");
  }
  
  void a(JSONObject paramJSONObject, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, int paramInt)
  {
    paramJSONObject = this.n;
    int i1;
    if (!WXShareHelper.a().b()) {
      i1 = 2131918154;
    } else if (!WXShareHelper.a().c()) {
      i1 = 2131918155;
    } else {
      i1 = -1;
    }
    if (i1 != -1)
    {
      QRUtils.a(0, i1);
      if (this.a == null) {
        a(paramJSONObject);
      }
      paramJSONObject = this.a;
      if ((paramJSONObject != null) && (paramJSONObject.isShowing())) {
        this.a.dismiss();
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
    if (this.a == null) {
      a(paramJSONObject);
    }
    if (!this.a.isShowing())
    {
      this.a.c(2131891516);
      this.a.show();
    }
    ThreadManager.post(new ShareMsgImpl.4(this, paramString5, localHashMap, paramString2, paramString1, paramString4), 8, null, false);
  }
  
  public boolean a(String paramString)
  {
    WebUiUtils.WebShareInterface localWebShareInterface = this.j;
    return (localWebShareInterface != null) && (localWebShareInterface.setShareUrl(paramString));
  }
  
  public void b(WebViewPlugin paramWebViewPlugin)
  {
    paramWebViewPlugin = (SwiftBrowserShareMenuHandler)paramWebViewPlugin.getBrowserComponent(4);
    if ((paramWebViewPlugin instanceof WebUiUtils.WebShareReportInterface)) {
      this.i = paramWebViewPlugin;
    }
  }
  
  /* Error */
  void b(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    // Byte code:
    //   0: invokestatic 249	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +12 -> 15
    //   6: ldc 251
    //   8: iconst_2
    //   9: ldc_w 718
    //   12: invokestatic 256	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   15: aload_3
    //   16: invokestatic 724	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   19: astore 5
    //   21: aload 5
    //   23: ifnull +50 -> 73
    //   26: aload 5
    //   28: invokevirtual 727	android/net/Uri:getHost	()Ljava/lang/String;
    //   31: astore 5
    //   33: aload 5
    //   35: invokestatic 244	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   38: ifne +35 -> 73
    //   41: ldc_w 729
    //   44: aload 5
    //   46: invokevirtual 141	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   49: ifne +14 -> 63
    //   52: ldc_w 731
    //   55: aload 5
    //   57: invokevirtual 141	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   60: ifeq +13 -> 73
    //   63: aload_0
    //   64: aload_1
    //   65: aload_2
    //   66: aload_3
    //   67: aload 4
    //   69: invokevirtual 733	com/tencent/mobileqq/jsp/ShareMsgImpl:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   72: return
    //   73: aload_0
    //   74: getfield 54	com/tencent/mobileqq/jsp/ShareMsgImpl:n	Landroid/app/Activity;
    //   77: astore 5
    //   79: aload_0
    //   80: getfield 68	com/tencent/mobileqq/jsp/ShareMsgImpl:a	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   83: ifnonnull +9 -> 92
    //   86: aload_0
    //   87: aload 5
    //   89: invokevirtual 238	com/tencent/mobileqq/jsp/ShareMsgImpl:a	(Landroid/app/Activity;)V
    //   92: aload_1
    //   93: invokestatic 244	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   96: ifne +400 -> 496
    //   99: aload_3
    //   100: invokestatic 244	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   103: ifeq +6 -> 109
    //   106: goto +390 -> 496
    //   109: invokestatic 736	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   112: invokevirtual 740	com/tencent/qphone/base/util/BaseApplication:getPackageManager	()Landroid/content/pm/PackageManager;
    //   115: astore 6
    //   117: aload 6
    //   119: ldc_w 742
    //   122: sipush 8192
    //   125: invokevirtual 748	android/content/pm/PackageManager:getApplicationInfo	(Ljava/lang/String;I)Landroid/content/pm/ApplicationInfo;
    //   128: astore 6
    //   130: invokestatic 249	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   133: ifeq +12 -> 145
    //   136: ldc 251
    //   138: iconst_2
    //   139: ldc_w 750
    //   142: invokestatic 256	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   145: new 752	com/tencent/mobileqq/jsp/ShareMsgImpl$2
    //   148: dup
    //   149: aload_0
    //   150: aload 4
    //   152: aload 5
    //   154: aload_1
    //   155: aload_2
    //   156: aload_3
    //   157: aload 6
    //   159: invokespecial 755	com/tencent/mobileqq/jsp/ShareMsgImpl$2:<init>	(Lcom/tencent/mobileqq/jsp/ShareMsgImpl;Ljava/lang/String;Landroid/app/Activity;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/content/pm/ApplicationInfo;)V
    //   162: invokestatic 759	com/tencent/mobileqq/app/ThreadManager:executeOnSubThread	(Ljava/lang/Runnable;)V
    //   165: goto +290 -> 455
    //   168: invokestatic 249	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   171: ifeq +11 -> 182
    //   174: ldc 251
    //   176: iconst_2
    //   177: ldc 253
    //   179: invokestatic 256	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   182: aload_1
    //   183: ldc_w 258
    //   186: invokestatic 264	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   189: astore_1
    //   190: new 266	java/lang/StringBuilder
    //   193: dup
    //   194: invokespecial 267	java/lang/StringBuilder:<init>	()V
    //   197: astore_2
    //   198: aload_2
    //   199: ldc_w 269
    //   202: invokevirtual 273	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   205: pop
    //   206: aload_2
    //   207: ldc_w 275
    //   210: invokevirtual 273	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   213: pop
    //   214: aload_2
    //   215: aload_1
    //   216: invokevirtual 273	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   219: pop
    //   220: aload_2
    //   221: invokevirtual 278	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   224: astore_1
    //   225: aload_3
    //   226: ldc_w 258
    //   229: invokestatic 264	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   232: astore_2
    //   233: new 266	java/lang/StringBuilder
    //   236: dup
    //   237: invokespecial 267	java/lang/StringBuilder:<init>	()V
    //   240: astore_3
    //   241: aload_3
    //   242: aload_1
    //   243: invokevirtual 273	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   246: pop
    //   247: aload_3
    //   248: ldc_w 280
    //   251: invokevirtual 273	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   254: pop
    //   255: aload_3
    //   256: aload_2
    //   257: invokevirtual 273	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   260: pop
    //   261: aload_3
    //   262: invokevirtual 278	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   265: astore_1
    //   266: aload 4
    //   268: ldc_w 258
    //   271: invokestatic 264	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   274: astore_2
    //   275: new 266	java/lang/StringBuilder
    //   278: dup
    //   279: invokespecial 267	java/lang/StringBuilder:<init>	()V
    //   282: astore_3
    //   283: aload_3
    //   284: aload_1
    //   285: invokevirtual 273	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   288: pop
    //   289: aload_3
    //   290: ldc_w 282
    //   293: invokevirtual 273	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   296: pop
    //   297: aload_3
    //   298: aload_2
    //   299: invokevirtual 273	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   302: pop
    //   303: aload_3
    //   304: invokevirtual 278	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   307: astore_1
    //   308: new 266	java/lang/StringBuilder
    //   311: dup
    //   312: invokespecial 267	java/lang/StringBuilder:<init>	()V
    //   315: astore_2
    //   316: aload_2
    //   317: aload_1
    //   318: invokevirtual 273	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   321: pop
    //   322: aload_2
    //   323: ldc_w 284
    //   326: invokevirtual 273	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   329: pop
    //   330: aload_2
    //   331: invokevirtual 278	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   334: astore_1
    //   335: new 206	android/content/Intent
    //   338: dup
    //   339: aload 5
    //   341: ldc_w 286
    //   344: invokespecial 289	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   347: astore_2
    //   348: aload_2
    //   349: ldc_w 291
    //   352: aload_1
    //   353: invokevirtual 295	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   356: pop
    //   357: aload 5
    //   359: aload_2
    //   360: invokevirtual 299	android/app/Activity:startActivity	(Landroid/content/Intent;)V
    //   363: invokestatic 249	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   366: ifeq +12 -> 378
    //   369: ldc 251
    //   371: iconst_2
    //   372: ldc_w 301
    //   375: invokestatic 256	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   378: aload_0
    //   379: getfield 68	com/tencent/mobileqq/jsp/ShareMsgImpl:a	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   382: astore_1
    //   383: aload_1
    //   384: ifnull +71 -> 455
    //   387: aload_1
    //   388: invokevirtual 74	com/tencent/mobileqq/widget/QQProgressDialog:isShowing	()Z
    //   391: ifeq +64 -> 455
    //   394: goto +54 -> 448
    //   397: astore_1
    //   398: goto +73 -> 471
    //   401: astore_1
    //   402: invokestatic 307	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   405: iconst_0
    //   406: ldc_w 308
    //   409: iconst_0
    //   410: invokestatic 314	com/tencent/mobileqq/widget/QQToast:makeText	(Landroid/content/Context;III)Lcom/tencent/mobileqq/widget/QQToast;
    //   413: invokestatic 307	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   416: invokevirtual 315	com/tencent/qphone/base/util/BaseApplication:getResources	()Landroid/content/res/Resources;
    //   419: ldc 148
    //   421: invokevirtual 154	android/content/res/Resources:getDimensionPixelSize	(I)I
    //   424: invokevirtual 319	com/tencent/mobileqq/widget/QQToast:show	(I)Landroid/widget/Toast;
    //   427: pop
    //   428: aload_1
    //   429: invokevirtual 322	java/lang/Exception:printStackTrace	()V
    //   432: aload_0
    //   433: getfield 68	com/tencent/mobileqq/jsp/ShareMsgImpl:a	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   436: astore_1
    //   437: aload_1
    //   438: ifnull +17 -> 455
    //   441: aload_1
    //   442: invokevirtual 74	com/tencent/mobileqq/widget/QQProgressDialog:isShowing	()Z
    //   445: ifeq +10 -> 455
    //   448: aload_0
    //   449: getfield 68	com/tencent/mobileqq/jsp/ShareMsgImpl:a	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   452: invokevirtual 77	com/tencent/mobileqq/widget/QQProgressDialog:dismiss	()V
    //   455: invokestatic 249	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   458: ifeq +12 -> 470
    //   461: ldc 251
    //   463: iconst_2
    //   464: ldc_w 324
    //   467: invokestatic 256	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   470: return
    //   471: aload_0
    //   472: getfield 68	com/tencent/mobileqq/jsp/ShareMsgImpl:a	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   475: astore_2
    //   476: aload_2
    //   477: ifnull +17 -> 494
    //   480: aload_2
    //   481: invokevirtual 74	com/tencent/mobileqq/widget/QQProgressDialog:isShowing	()Z
    //   484: ifeq +10 -> 494
    //   487: aload_0
    //   488: getfield 68	com/tencent/mobileqq/jsp/ShareMsgImpl:a	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   491: invokevirtual 77	com/tencent/mobileqq/widget/QQProgressDialog:dismiss	()V
    //   494: aload_1
    //   495: athrow
    //   496: invokestatic 249	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   499: ifeq +12 -> 511
    //   502: ldc 251
    //   504: iconst_2
    //   505: ldc_w 326
    //   508: invokestatic 256	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   511: aload_0
    //   512: getfield 68	com/tencent/mobileqq/jsp/ShareMsgImpl:a	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   515: astore_1
    //   516: aload_1
    //   517: ifnull +17 -> 534
    //   520: aload_1
    //   521: invokevirtual 74	com/tencent/mobileqq/widget/QQProgressDialog:isShowing	()Z
    //   524: ifeq +10 -> 534
    //   527: aload_0
    //   528: getfield 68	com/tencent/mobileqq/jsp/ShareMsgImpl:a	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   531: invokevirtual 77	com/tencent/mobileqq/widget/QQProgressDialog:dismiss	()V
    //   534: invokestatic 307	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   537: iconst_0
    //   538: ldc_w 308
    //   541: iconst_0
    //   542: invokestatic 314	com/tencent/mobileqq/widget/QQToast:makeText	(Landroid/content/Context;III)Lcom/tencent/mobileqq/widget/QQToast;
    //   545: invokestatic 307	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   548: invokevirtual 315	com/tencent/qphone/base/util/BaseApplication:getResources	()Landroid/content/res/Resources;
    //   551: ldc 148
    //   553: invokevirtual 154	android/content/res/Resources:getDimensionPixelSize	(I)I
    //   556: invokevirtual 319	com/tencent/mobileqq/widget/QQToast:show	(I)Landroid/widget/Toast;
    //   559: pop
    //   560: return
    //   561: astore 5
    //   563: goto -490 -> 73
    //   566: astore_2
    //   567: goto -399 -> 168
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	570	0	this	ShareMsgImpl
    //   0	570	1	paramString1	String
    //   0	570	2	paramString2	String
    //   0	570	3	paramString3	String
    //   0	570	4	paramString4	String
    //   19	339	5	localObject1	Object
    //   561	1	5	localException	Exception
    //   115	43	6	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   182	378	397	finally
    //   402	432	397	finally
    //   182	378	401	java/lang/Exception
    //   15	21	561	java/lang/Exception
    //   26	63	561	java/lang/Exception
    //   63	72	561	java/lang/Exception
    //   117	145	566	android/content/pm/PackageManager$NameNotFoundException
    //   145	165	566	android/content/pm/PackageManager$NameNotFoundException
  }
  
  void b(JSONObject paramJSONObject, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, int paramInt)
  {
    paramString1 = paramString2;
    Activity localActivity = this.n;
    Intent localIntent = new Intent();
    paramString3 = paramJSONObject.optString("toUin");
    int i1 = paramJSONObject.optInt("uinType", 0);
    if ((paramString3 != null) && (paramString3.length() >= 5))
    {
      localIntent.setClass(this.f, DirectForwardActivity.class);
      localIntent.putExtra("toUin", paramString3);
      localIntent.putExtra("uinType", i1);
    }
    else
    {
      localIntent.putExtra("isWebCompShare", true);
      localIntent.setClass(this.f, ForwardRecentActivity.class);
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
        i1 = paramJSONObject.getInt("tribe_video_width");
      } else {
        i1 = 0;
      }
      int i2;
      if (paramJSONObject.has("tribe_video_height")) {
        i2 = paramJSONObject.getInt("tribe_video_height");
      } else {
        i2 = 0;
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
          localJSONObject.put("tribe_video_width", i1);
          localJSONObject.put("tribe_video_height", i2);
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
          break label615;
        }
      }
      catch (Exception paramString5)
      {
        paramString2 = null;
      }
      QLog.d("ShareMsgImpl", 2, QLog.getStackTraceString(paramString5));
      label615:
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
    if (this.a == null) {
      a(localActivity);
    }
    paramString1 = this.a;
    if ((paramString1 != null) && (paramString1.isShowing()))
    {
      long l1 = System.currentTimeMillis();
      if (QLog.isColorLevel())
      {
        paramString1 = new StringBuilder();
        paramString1.append("dialog dimiss time :");
        paramString1.append(l1);
        QLog.d(paramString5, 2, paramString1.toString());
      }
      this.a.dismiss();
    }
    paramString2 = null;
    paramString3 = paramJSONObject.optString("puin", null);
    paramString1 = paramString3;
    if (paramString3 == null) {
      paramString1 = paramJSONObject.optString("oaUin");
    }
    if (!TextUtils.isEmpty(paramString1))
    {
      paramString3 = this.o;
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
        this.p.onSharMsgcallback(this.b, "false");
        return;
      }
      paramJSONObject.mMsgServiceID = 118;
      paramJSONObject.mTribeShortVideoExtra = paramString6.toString();
      paramJSONObject.mCompatibleText = MessageForTribeShortVideo.buildCompatibleText();
      localIntent.putExtra("stuctmsg_bytes", paramJSONObject.getBytes());
      this.p.startActivityForResult(localIntent, (byte)4);
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
      label562:
      label565:
      label568:
      break label568;
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
      break label565;
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
      localObject = this.n;
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
      localObject = this.l;
      if (localObject != null) {
        paramString = ((WebViewPlugin.PluginRuntime)localObject).a(this.n);
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
      break label562;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ShareMsgImpl", 2, "setShareInfo param error");
    }
    return false;
  }
  
  public void c(String paramString)
  {
    this.b = null;
    label863:
    for (;;)
    {
      try
      {
        if (this.j != null)
        {
          this.a = ((Share)this.j.getShare()).u();
          if ((this.a != null) && (this.a.isShowing())) {
            this.a.dismiss();
          }
        }
        localObject1 = new Intent();
        Object localObject2 = new JSONObject(paramString);
        this.b = ((JSONObject)localObject2).optString("callback");
        paramString = ((JSONObject)localObject2).optString("appName");
        if (!AuthorizeConfig.a().f("ark_authorize_config", paramString))
        {
          if (!TextUtils.isEmpty(this.b)) {
            this.p.onSharMsgcallback(this.b, "{\"result\":2}");
          }
        }
        else
        {
          String str1 = ((JSONObject)localObject2).optString("toUin");
          int i1 = ((JSONObject)localObject2).optInt("uinType", 0);
          String str2 = ((JSONObject)localObject2).optString("toNickName");
          if (str1 == null) {
            break label863;
          }
          if (str1.length() >= 5)
          {
            ((Intent)localObject1).setClass(this.f, DirectForwardActivity.class);
            ((Intent)localObject1).putExtra("toUin", str1);
            ((Intent)localObject1).putExtra("uinType", i1);
            ((Intent)localObject1).putExtra("nickName", str2);
          }
          else
          {
            ((Intent)localObject1).putExtra("isWebCompShare", true);
            ((Intent)localObject1).setClass(this.f, ForwardRecentActivity.class);
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
            this.p.onSharMsgcallback(this.b, "{\"result\":1}");
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
          ((Intent)localObject1).putExtra("scale", this.f.getResources().getDisplayMetrics().scaledDensity);
          boolean bool = this.f instanceof QQBrowserActivity;
          if (bool)
          {
            paramString = ((QQBrowserActivity)this.f).getWebViewProvider();
            if (paramString != null)
            {
              paramString = paramString.getCurrentUrl();
              if (!TextUtils.isEmpty(paramString)) {
                ((Intent)localObject1).putExtra("forward_ark_h5_from_js", paramString);
              }
            }
          }
          else if (this.l != null)
          {
            paramString = this.l.f();
            if (paramString != null)
            {
              paramString = paramString.getCurrentUrl();
              if (!TextUtils.isEmpty(paramString)) {
                ((Intent)localObject1).putExtra("forward_ark_h5_from_js", paramString);
              }
            }
            else if (this.n != null)
            {
              paramString = this.l.a(this.n);
              if ((paramString instanceof WebUiUtils.WebUiMethodInterface))
              {
                paramString = ((WebUiUtils.WebUiMethodInterface)paramString).getCurrentUrl();
                if (!TextUtils.isEmpty(paramString)) {
                  ((Intent)localObject1).putExtra("forward_ark_h5_from_js", paramString);
                }
              }
              else if (this.l.a() != null)
              {
                paramString = Util.a(this.l.a().getUrl(), new String[0]);
                if (!TextUtils.isEmpty(paramString)) {
                  ((Intent)localObject1).putExtra("forward_ark_h5_from_js", paramString);
                }
              }
            }
          }
          this.p.startActivityForResult((Intent)localObject1, (byte)3);
          return;
        }
      }
      catch (JSONException paramString)
      {
        this.p.onSharMsgcallback(this.b, "{\"result\":3}");
        Object localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("shareArkMsg error: ");
        ((StringBuilder)localObject1).append(paramString.toString());
        QLog.e("ShareMsgImpl", 1, ((StringBuilder)localObject1).toString());
        return;
      }
      return;
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
    Activity localActivity = this.n;
    Intent localIntent = new Intent();
    Object localObject2 = paramJSONObject.optString("toUin");
    int i2 = paramJSONObject.optInt("uinType", 0);
    localIntent.putExtra("forward_source_business_type", 100500);
    paramString1 = this.l;
    if ((paramString1 != null) && (paramString1.f() != null))
    {
      paramString1 = (SwiftBrowserShareMenuHandler)this.l.f().getComponentProvider().a(4);
      localObject1 = paramString1.n();
      if (TextUtils.isEmpty(paramString1.C)) {
        paramString1 = "";
      } else {
        paramString1 = paramString1.C;
      }
      localIntent.putExtra("forward_source_sub_business_type", paramString1);
      paramString1 = (String)localObject1;
    }
    else
    {
      paramString1 = this.l;
      if ((paramString1 != null) && (paramString1.a() != null))
      {
        paramString1 = this.l.a().getParent();
        if ((paramString1 instanceof IQQComicHippyWebviewShareHelper))
        {
          paramString1 = (IQQComicHippyWebviewShareHelper)paramString1;
          if ((paramString1.getShareHelper() instanceof CommonShareHelper))
          {
            paramString1 = (CommonShareHelper)paramString1.getShareHelper();
            localObject1 = paramString1.b();
            if (TextUtils.isEmpty(paramString1.c())) {
              paramString1 = "";
            } else {
              paramString1 = paramString1.c();
            }
            localIntent.putExtra("forward_source_sub_business_type", paramString1);
            paramString1 = (String)localObject1;
            break label266;
          }
        }
      }
      paramString1 = null;
    }
    label266:
    Object localObject1 = localObject2;
    int i1 = i2;
    if (TextUtils.isEmpty((CharSequence)localObject2))
    {
      localObject1 = localObject2;
      i1 = i2;
      if (i2 == 0)
      {
        localObject1 = localObject2;
        i1 = i2;
        if (paramString1 != null)
        {
          localObject1 = localObject2;
          i1 = i2;
          if (!paramString1.isEmpty())
          {
            localObject2 = paramString1.getString("to_qq");
            i2 = paramString1.getInt("to_uin_type");
            localObject1 = localObject2;
            i1 = i2;
            if (QLog.isColorLevel())
            {
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append("shareMsgToQQ() called : toUin = ");
              ((StringBuilder)localObject1).append((String)localObject2);
              ((StringBuilder)localObject1).append(", uinType = ");
              ((StringBuilder)localObject1).append(i2);
              QLog.d("ShareMsgImpl", 2, ((StringBuilder)localObject1).toString());
              i1 = i2;
              localObject1 = localObject2;
            }
          }
        }
      }
    }
    localObject2 = paramJSONObject.optString("toNickName");
    i2 = paramJSONObject.optInt("isEncryptUin", 0);
    if ((localObject1 != null) && (((String)localObject1).length() >= 5))
    {
      localIntent.setClass(this.f, DirectForwardActivity.class);
      localIntent.putExtra("toUin", (String)localObject1);
      localIntent.putExtra("uinType", i1);
      if (i2 == 1)
      {
        localIntent.putExtra("isEncryptUin", i2);
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
      if ((this.m == null) && (!TextUtils.isEmpty((CharSequence)localObject1))) {
        localIntent.putExtra("nickName", (String)localObject1);
      }
    }
    else
    {
      localIntent.putExtra("isWebCompShare", true);
      localIntent.setClass(this.f, ForwardRecentActivity.class);
    }
    localIntent.putExtra("key_flag_from_plugin", true);
    i2 = 1001;
    localObject1 = this.l;
    if (localObject1 != null) {
      localObject1 = ((WebViewPlugin.PluginRuntime)localObject1).f();
    } else {
      localObject1 = null;
    }
    i1 = i2;
    if (localObject1 != null)
    {
      localObject1 = (SwiftBrowserShareMenuHandler)((WebViewProvider)localObject1).getComponentProvider().a(4);
      i1 = i2;
      if (localObject1 != null)
      {
        i1 = i2;
        if (((SwiftBrowserShareMenuHandler)localObject1).f != null)
        {
          i1 = i2;
          if (((SwiftBrowserShareMenuHandler)localObject1).f.a(localIntent)) {
            i1 = 38;
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
    localIntent.putExtra("forward_type", i1);
    localIntent.putExtra("req_share_id", paramJSONObject.optLong("appid", -1L));
    localIntent.putExtra("pkg_name", "com.tencent.mobileqq");
    localIntent.putExtra("image_url_remote", paramString5);
    localIntent.putExtra("brief_key", BaseApplicationImpl.getContext().getString(2131894173, new Object[] { localObject1 }));
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
      i1 = paramJSONObject.optInt("req_type", 146);
      paramInt = i1;
      if (i1 == 2)
      {
        localIntent.putExtra("audio_url", paramJSONObject.getString("audio_url"));
        paramInt = i1;
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
        localIntent.putExtra("compatible_text", ConfessMsgUtil.b);
      }
    }
    if (paramJSONObject.has("need_send_long_msg_when_failed")) {
      localIntent.putExtra("need_send_long_msg_when_failed", paramJSONObject.optBoolean("need_send_long_msg_when_failed"));
    }
    long l1 = paramJSONObject.optLong("appid", 0L);
    if (l1 > 0L)
    {
      paramJSONObject = this.o;
      if (paramJSONObject != null)
      {
        if (this.a == null) {
          a(localActivity);
        }
        if (!this.a.isShowing())
        {
          this.a.c(2131891516);
          this.a.show();
        }
        localIntent.putExtra("struct_share_key_source_name", Long.toString(l1));
        Share.a(paramJSONObject, this.f, paramJSONObject.getAccount(), l1, 3000L, new ShareMsgImpl.5(this, localIntent, l1, paramString4));
      }
    }
    else
    {
      if (this.a == null) {
        a(localActivity);
      }
      paramString2 = this.a;
      if ((paramString2 != null) && (paramString2.isShowing()))
      {
        l1 = System.currentTimeMillis();
        if (QLog.isColorLevel())
        {
          paramString2 = new StringBuilder();
          paramString2.append("dialog dimiss time :");
          paramString2.append(l1);
          QLog.d("ShareMsgImpl", 2, paramString2.toString());
        }
        this.a.dismiss();
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
        paramString5 = this.o;
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
            break label1918;
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
            break label1918;
          }
        }
        paramString3 = paramString2;
        label1918:
        if (paramString3.equalsIgnoreCase(this.f.getString(2131897917)))
        {
          bool = paramString3.equalsIgnoreCase(this.f.getString(2131897917));
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
        localIntent.putExtra("app_name", this.f.getString(2131894190));
      }
      paramJSONObject = this.i;
      if ((paramJSONObject != null) && (this.g != null))
      {
        localIntent.putExtra("strurt_msgid", paramJSONObject.d());
        localIntent.putExtra("struct_uin", this.i.e());
        localIntent.putExtra("struct_url", this.g.getCurrentUrl());
        localIntent.putExtra("from_web", true);
        if ((this.i.f() != null) && (!"".equals(this.i.f()))) {
          localIntent.putExtra("source_puin", this.i.f());
        }
      }
      paramJSONObject = StructMsgFactory.a(localIntent.getExtras());
      if (paramJSONObject == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ShareMsgImpl", 2, "build struct msg fail");
        }
        this.p.onSharMsgcallback(this.b, "false");
        return;
      }
      localIntent.putExtra("stuctmsg_bytes", paramJSONObject.getBytes());
      this.p.startActivityForResult(localIntent, (byte)1);
    }
    if (paramString1 != null) {
      paramString1.clear();
    }
  }
  
  public void d(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    this.b = null;
    try
    {
      paramString = new JSONObject(paramString);
      localObject = new Intent(this.f, ForwardRecentActivity.class);
      ((Intent)localObject).putExtra("isFromShare", true);
      String str = paramString.optString("toUin");
      int i1 = paramString.optInt("uinType", 0);
      if ((str != null) && (str.length() >= 5))
      {
        ((Intent)localObject).setClass(this.f, DirectForwardActivity.class);
        ((Intent)localObject).putExtra("toUin", str);
        ((Intent)localObject).putExtra("uinType", i1);
      }
      ((Intent)localObject).putExtra("forward_type", -1);
      ((Intent)localObject).putExtra("forward_text", paramString.optString("text"));
      this.b = paramString.optString("callback");
      if (paramString.has("report")) {
        ((Intent)localObject).putExtra("report", paramString.getString("report"));
      }
      ((Intent)localObject).putExtra("openerProc", MobileQQ.getMobileQQ().getQQProcessName());
      this.p.startActivityForResult((Intent)localObject, (byte)1);
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
  
  public void e(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    try
    {
      localObject = new JSONObject(paramString);
      if ("0".equals(((JSONObject)localObject).optString("share_type", "0")))
      {
        paramString = new Intent(this.f, ForwardRecentActivity.class);
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
        this.p.startActivityForResult(paramString, (byte)1);
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
  
  public void f(String paramString)
  {
    try
    {
      this.b = null;
      localObject = new JSONObject(paramString);
      Intent localIntent = new Intent();
      paramString = ((JSONObject)localObject).optString("toUin");
      if ((paramString != null) && (paramString.length() >= 5))
      {
        this.b = ((JSONObject)localObject).optString("callback");
        localIntent.setClass(this.f, DirectForwardActivity.class);
        localIntent.putExtra("toUin", paramString);
        localIntent.putExtra("key_flag_from_plugin", true);
        localIntent.putExtra("pluginName", "web_share");
        localIntent.putExtra("forward_type", 30);
        localIntent.putExtra("k_back", true);
        this.p.startActivityForResult(localIntent, (byte)2);
        return;
      }
      if (!TextUtils.isEmpty(this.b)) {
        this.p.onSharMsgcallback(this.b, "{\"result\":0}");
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
      this.p.onSharMsgcallback(this.b, "{\"result\":0}");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.jsp.ShareMsgImpl
 * JD-Core Version:    0.7.0.1
 */