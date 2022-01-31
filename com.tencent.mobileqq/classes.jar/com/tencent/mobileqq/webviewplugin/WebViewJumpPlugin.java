package com.tencent.mobileqq.webviewplugin;

import akrt;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.qrcode.util.QRUtils;
import com.tencent.mobileqq.activity.JoinDiscussionActivity;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpParser;
import com.tencent.mobileqq.webview.swift.SwiftIphoneTitleBarUI;
import com.tencent.mobileqq.webview.swift.SwiftWebViewFragmentSupporter;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.stat.MttLoader;
import java.util.HashMap;
import java.util.Map;

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
    paramString.b();
  }
  
  private void c(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return;
      if ((paramString.startsWith("mqqapi://armap_entry/map?src_type=web&version=1&from_type=0&service_id=1")) || (paramString.startsWith("mqqapi://personal_tag/tag_list"))) {}
      for (int i = 1; i != 0; i = 0)
      {
        new Handler().postDelayed(new akrt(this), 2000L);
        return;
      }
    }
  }
  
  public void a(String paramString)
  {
    paramString = JumpParser.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.mRuntime.a(), paramString);
    if (paramString != null) {
      paramString.b();
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
      this.jdField_a_of_type_ComTencentSmttSdkWebView.loadUrl("http://mdc.html5.qq.com/d/directdown.jsp?channel_id=50079");
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
        this.jdField_a_of_type_ComTencentSmttSdkWebView.loadUrl("http://mdc.html5.qq.com/d/directdown.jsp?channel_id=50079");
      } else if (i != 0) {
        this.jdField_a_of_type_ComTencentSmttSdkWebView.loadUrl("http://mdc.html5.qq.com/d/directdown.jsp?channel_id=50079");
      }
    }
  }
  
  protected boolean handleEvent(String paramString, long paramLong, Map paramMap)
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
            ((IphoneTitleBarActivity)this.mRuntime.a()).setLeftViewName(2131433298);
          }
          while ((this.mRuntime != null) && (this.mRuntime.a() != null) && (this.mRuntime.a().canGoBack()))
          {
            this.mRuntime.a().goBack();
            return true;
            label178:
            if ((this.mRuntime.a() instanceof SwiftWebViewFragmentSupporter))
            {
              paramString = this.mRuntime.a();
              if ((paramString != null) && (paramString.a.a != null)) {
                paramString.a.a.setText(2131433298);
              }
            }
          }
        }
      }
      else if ((paramLong == 8589934594L) && (!TextUtils.isEmpty(paramString)) && ((paramString.contains("chatplay/hall")) || (paramString.contains("avwithstranger/avchathall")) || (paramString.contains("chatplay/avchathall"))) && (paramString.endsWith("#child")) && (paramString.contains("adtag=client.tab")) && (this.mRuntime != null) && (this.mRuntime.a() != null)) {
        if ((this.mRuntime.a() instanceof IphoneTitleBarActivity))
        {
          ((IphoneTitleBarActivity)this.mRuntime.a()).setLeftViewName(2131433698);
        }
        else if ((this.mRuntime.a() instanceof SwiftWebViewFragmentSupporter))
        {
          paramString = this.mRuntime.a();
          if ((paramString != null) && (paramString.a.a != null)) {
            paramString.a.a.setText(2131433698);
          }
        }
      }
    }
  }
  
  /* Error */
  protected boolean handleSchemaRequest(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 6
    //   3: invokestatic 53	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   6: ifeq +51 -> 57
    //   9: aload_0
    //   10: getfield 232	com/tencent/mobileqq/webviewplugin/WebViewJumpPlugin:TAG	Ljava/lang/String;
    //   13: iconst_2
    //   14: new 234	java/lang/StringBuilder
    //   17: dup
    //   18: invokespecial 235	java/lang/StringBuilder:<init>	()V
    //   21: ldc 237
    //   23: invokevirtual 241	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: aload_1
    //   27: invokevirtual 241	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: ldc 243
    //   32: invokevirtual 241	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: aload_2
    //   36: invokevirtual 241	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: ldc 245
    //   41: invokevirtual 241	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   44: aload_0
    //   45: getfield 29	com/tencent/mobileqq/webviewplugin/WebViewJumpPlugin:c	Z
    //   48: invokevirtual 248	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   51: invokevirtual 251	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   54: invokestatic 61	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   57: aload_0
    //   58: getfield 29	com/tencent/mobileqq/webviewplugin/WebViewJumpPlugin:c	Z
    //   61: ifne +9 -> 70
    //   64: iconst_0
    //   65: istore 5
    //   67: iload 5
    //   69: ireturn
    //   70: aload_1
    //   71: invokestatic 253	com/tencent/biz/qrcode/util/QRUtils:a	(Ljava/lang/String;)Z
    //   74: ifeq +12 -> 86
    //   77: aload_1
    //   78: invokestatic 256	com/tencent/biz/qrcode/activity/ScannerUtils:a	(Ljava/lang/String;)Z
    //   81: ifeq +5 -> 86
    //   84: iconst_0
    //   85: ireturn
    //   86: aload_1
    //   87: ldc_w 258
    //   90: invokevirtual 107	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   93: ifeq +48 -> 141
    //   96: new 72	android/content/Intent
    //   99: dup
    //   100: ldc_w 260
    //   103: aload_1
    //   104: invokestatic 266	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   107: invokespecial 269	android/content/Intent:<init>	(Ljava/lang/String;Landroid/net/Uri;)V
    //   110: astore_1
    //   111: getstatic 273	com/tencent/mobileqq/utils/kapalaiadapter/MobileIssueSettings:jdField_a_of_type_Boolean	Z
    //   114: ifne +20 -> 134
    //   117: invokestatic 278	com/tencent/mobileqq/utils/kapalaiadapter/KapalaiAdapterUtil:a	()Lcom/tencent/mobileqq/utils/kapalaiadapter/KapalaiAdapterUtil;
    //   120: invokevirtual 280	com/tencent/mobileqq/utils/kapalaiadapter/KapalaiAdapterUtil:a	()Z
    //   123: ifeq +11 -> 134
    //   126: invokestatic 278	com/tencent/mobileqq/utils/kapalaiadapter/KapalaiAdapterUtil:a	()Lcom/tencent/mobileqq/utils/kapalaiadapter/KapalaiAdapterUtil;
    //   129: aload_1
    //   130: invokevirtual 283	com/tencent/mobileqq/utils/kapalaiadapter/KapalaiAdapterUtil:a	(Landroid/content/Intent;)Landroid/content/Intent;
    //   133: pop
    //   134: aload_0
    //   135: aload_1
    //   136: invokespecial 85	com/tencent/mobileqq/webviewplugin/WebViewJumpPlugin:a	(Landroid/content/Intent;)V
    //   139: iconst_1
    //   140: ireturn
    //   141: aload_1
    //   142: ldc_w 285
    //   145: invokevirtual 107	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   148: ifeq +118 -> 266
    //   151: new 72	android/content/Intent
    //   154: dup
    //   155: ldc_w 287
    //   158: invokespecial 289	android/content/Intent:<init>	(Ljava/lang/String;)V
    //   161: astore_2
    //   162: aload_1
    //   163: ldc_w 291
    //   166: invokevirtual 295	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   169: istore 4
    //   171: iload 4
    //   173: istore_3
    //   174: iload 4
    //   176: iconst_m1
    //   177: if_icmpne +8 -> 185
    //   180: aload_1
    //   181: invokevirtual 299	java/lang/String:length	()I
    //   184: istore_3
    //   185: aload_2
    //   186: ldc_w 301
    //   189: aload_1
    //   190: aload_1
    //   191: ldc_w 303
    //   194: invokevirtual 295	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   197: iconst_1
    //   198: iadd
    //   199: iload_3
    //   200: invokevirtual 307	java/lang/String:substring	(II)Ljava/lang/String;
    //   203: invokevirtual 83	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   206: pop
    //   207: aload_1
    //   208: ldc_w 309
    //   211: invokevirtual 295	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   214: istore 4
    //   216: iload 4
    //   218: istore_3
    //   219: iload 4
    //   221: iconst_m1
    //   222: if_icmpne +10 -> 232
    //   225: aload_1
    //   226: invokevirtual 299	java/lang/String:length	()I
    //   229: iconst_1
    //   230: isub
    //   231: istore_3
    //   232: aload_2
    //   233: ldc_w 311
    //   236: aload_1
    //   237: iload_3
    //   238: iconst_1
    //   239: iadd
    //   240: aload_1
    //   241: invokevirtual 299	java/lang/String:length	()I
    //   244: invokevirtual 307	java/lang/String:substring	(II)Ljava/lang/String;
    //   247: invokevirtual 83	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   250: pop
    //   251: aload_2
    //   252: ldc_w 313
    //   255: invokevirtual 317	android/content/Intent:setType	(Ljava/lang/String;)Landroid/content/Intent;
    //   258: pop
    //   259: aload_0
    //   260: aload_2
    //   261: invokespecial 85	com/tencent/mobileqq/webviewplugin/WebViewJumpPlugin:a	(Landroid/content/Intent;)V
    //   264: iconst_1
    //   265: ireturn
    //   266: aload_1
    //   267: ldc_w 319
    //   270: invokevirtual 107	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   273: ifeq +222 -> 495
    //   276: invokestatic 53	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   279: ifeq +31 -> 310
    //   282: aload_0
    //   283: getfield 232	com/tencent/mobileqq/webviewplugin/WebViewJumpPlugin:TAG	Ljava/lang/String;
    //   286: iconst_2
    //   287: new 234	java/lang/StringBuilder
    //   290: dup
    //   291: invokespecial 235	java/lang/StringBuilder:<init>	()V
    //   294: ldc_w 321
    //   297: invokevirtual 241	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   300: aload_1
    //   301: invokevirtual 241	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   304: invokevirtual 251	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   307: invokestatic 61	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   310: aload_1
    //   311: ldc_w 323
    //   314: invokevirtual 327	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   317: astore 11
    //   319: aload 11
    //   321: ifnull +1103 -> 1424
    //   324: aload 11
    //   326: arraylength
    //   327: iconst_5
    //   328: if_icmplt +1096 -> 1424
    //   331: aload 11
    //   333: iconst_2
    //   334: aaload
    //   335: ldc_w 309
    //   338: invokevirtual 327	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   341: astore_2
    //   342: aload 11
    //   344: iconst_3
    //   345: aaload
    //   346: ldc_w 309
    //   349: invokevirtual 327	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   352: astore_1
    //   353: aload 11
    //   355: iconst_4
    //   356: aaload
    //   357: ldc_w 309
    //   360: invokevirtual 327	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   363: astore 11
    //   365: aload_2
    //   366: ifnull +1058 -> 1424
    //   369: aload_2
    //   370: arraylength
    //   371: iconst_2
    //   372: if_icmpne +1052 -> 1424
    //   375: aload_1
    //   376: ifnull +1048 -> 1424
    //   379: aload_1
    //   380: arraylength
    //   381: iconst_2
    //   382: if_icmpne +1042 -> 1424
    //   385: aload 11
    //   387: ifnull +1037 -> 1424
    //   390: aload 11
    //   392: arraylength
    //   393: iconst_2
    //   394: if_icmpne +1030 -> 1424
    //   397: aload_2
    //   398: iconst_1
    //   399: aaload
    //   400: astore_2
    //   401: aload 11
    //   403: iconst_1
    //   404: aaload
    //   405: invokestatic 333	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   408: lstore 7
    //   410: aload_1
    //   411: iconst_1
    //   412: aaload
    //   413: invokestatic 333	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   416: lstore 9
    //   418: new 72	android/content/Intent
    //   421: dup
    //   422: ldc_w 335
    //   425: invokespecial 289	android/content/Intent:<init>	(Ljava/lang/String;)V
    //   428: astore_1
    //   429: aload_1
    //   430: aload_0
    //   431: getfield 37	com/tencent/mobileqq/webviewplugin/WebViewJumpPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   434: invokevirtual 42	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   437: invokevirtual 338	android/app/Activity:getPackageName	()Ljava/lang/String;
    //   440: invokevirtual 341	android/content/Intent:setPackage	(Ljava/lang/String;)Landroid/content/Intent;
    //   443: pop
    //   444: aload_1
    //   445: ldc_w 343
    //   448: iconst_1
    //   449: invokevirtual 346	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   452: pop
    //   453: aload_1
    //   454: ldc_w 348
    //   457: aload_2
    //   458: invokevirtual 83	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   461: pop
    //   462: aload_1
    //   463: ldc_w 350
    //   466: lload 9
    //   468: invokevirtual 353	android/content/Intent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
    //   471: pop
    //   472: aload_1
    //   473: ldc_w 355
    //   476: lload 7
    //   478: invokevirtual 353	android/content/Intent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
    //   481: pop
    //   482: aload_0
    //   483: getfield 37	com/tencent/mobileqq/webviewplugin/WebViewJumpPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   486: invokevirtual 42	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   489: aload_1
    //   490: invokevirtual 358	android/app/Activity:sendBroadcast	(Landroid/content/Intent;)V
    //   493: iconst_1
    //   494: ireturn
    //   495: aload_1
    //   496: ldc_w 360
    //   499: invokevirtual 107	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   502: ifeq +103 -> 605
    //   505: aload_0
    //   506: iconst_3
    //   507: invokevirtual 364	com/tencent/mobileqq/webviewplugin/WebViewJumpPlugin:getRequestCode	(B)I
    //   510: istore_3
    //   511: iload 6
    //   513: istore 5
    //   515: iload_3
    //   516: iconst_m1
    //   517: if_icmpeq -450 -> 67
    //   520: iload 6
    //   522: istore 5
    //   524: aload_0
    //   525: getfield 366	com/tencent/mobileqq/webviewplugin/WebViewJumpPlugin:b	Z
    //   528: ifne -461 -> 67
    //   531: aload_0
    //   532: iconst_1
    //   533: putfield 366	com/tencent/mobileqq/webviewplugin/WebViewJumpPlugin:b	Z
    //   536: aload_0
    //   537: getfield 27	com/tencent/mobileqq/webviewplugin/WebViewJumpPlugin:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   540: aload_0
    //   541: getfield 37	com/tencent/mobileqq/webviewplugin/WebViewJumpPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   544: invokevirtual 42	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   547: aload_1
    //   548: invokestatic 90	com/tencent/mobileqq/utils/JumpParser:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Landroid/content/Context;Ljava/lang/String;)Lcom/tencent/mobileqq/utils/JumpAction;
    //   551: astore_1
    //   552: iload 6
    //   554: istore 5
    //   556: aload_1
    //   557: ifnull -490 -> 67
    //   560: aload_1
    //   561: ldc_w 368
    //   564: invokevirtual 370	com/tencent/mobileqq/utils/JumpAction:a	(Ljava/lang/String;)V
    //   567: aload_1
    //   568: ldc_w 372
    //   571: iload_3
    //   572: invokestatic 134	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   575: invokevirtual 375	com/tencent/mobileqq/utils/JumpAction:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   578: aload_1
    //   579: ldc_w 377
    //   582: invokestatic 382	com/tencent/mobileqq/vaswebviewplugin/QWalletPayJsPlugin:getPayAppInfo	()Ljava/lang/String;
    //   585: invokevirtual 375	com/tencent/mobileqq/utils/JumpAction:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   588: aload_1
    //   589: invokevirtual 94	com/tencent/mobileqq/utils/JumpAction:b	()Z
    //   592: pop
    //   593: aload_0
    //   594: iconst_1
    //   595: putfield 383	com/tencent/mobileqq/webviewplugin/WebViewJumpPlugin:jdField_a_of_type_Boolean	Z
    //   598: aload_0
    //   599: iconst_0
    //   600: putfield 366	com/tencent/mobileqq/webviewplugin/WebViewJumpPlugin:b	Z
    //   603: iconst_1
    //   604: ireturn
    //   605: aload_1
    //   606: invokestatic 253	com/tencent/biz/qrcode/util/QRUtils:a	(Ljava/lang/String;)Z
    //   609: ifne +13 -> 622
    //   612: aload_1
    //   613: ldc_w 385
    //   616: invokevirtual 107	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   619: ifeq +83 -> 702
    //   622: aload_0
    //   623: getfield 37	com/tencent/mobileqq/webviewplugin/WebViewJumpPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   626: invokevirtual 42	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   629: astore_2
    //   630: iload 6
    //   632: istore 5
    //   634: aload_2
    //   635: ifnull -568 -> 67
    //   638: aload_0
    //   639: getfield 27	com/tencent/mobileqq/webviewplugin/WebViewJumpPlugin:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   642: aload_2
    //   643: aload_1
    //   644: invokestatic 90	com/tencent/mobileqq/utils/JumpParser:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Landroid/content/Context;Ljava/lang/String;)Lcom/tencent/mobileqq/utils/JumpAction;
    //   647: astore_2
    //   648: aload_2
    //   649: ifnull +15 -> 664
    //   652: aload_2
    //   653: ldc_w 368
    //   656: invokevirtual 370	com/tencent/mobileqq/utils/JumpAction:a	(Ljava/lang/String;)V
    //   659: aload_2
    //   660: invokevirtual 94	com/tencent/mobileqq/utils/JumpAction:b	()Z
    //   663: pop
    //   664: iload 6
    //   666: istore 5
    //   668: aload_1
    //   669: ldc_w 387
    //   672: invokevirtual 107	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   675: ifeq -608 -> 67
    //   678: new 111	android/os/Handler
    //   681: dup
    //   682: invokespecial 112	android/os/Handler:<init>	()V
    //   685: new 389	akrq
    //   688: dup
    //   689: aload_0
    //   690: invokespecial 390	akrq:<init>	(Lcom/tencent/mobileqq/webviewplugin/WebViewJumpPlugin;)V
    //   693: ldc2_w 118
    //   696: invokevirtual 123	android/os/Handler:postDelayed	(Ljava/lang/Runnable;J)Z
    //   699: pop
    //   700: iconst_1
    //   701: ireturn
    //   702: aload_1
    //   703: ldc_w 392
    //   706: invokevirtual 107	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   709: ifeq +110 -> 819
    //   712: aload_1
    //   713: invokestatic 266	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   716: ldc_w 394
    //   719: invokevirtual 398	android/net/Uri:getQueryParameter	(Ljava/lang/String;)Ljava/lang/String;
    //   722: astore_1
    //   723: aload_1
    //   724: invokestatic 100	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   727: ifeq +5 -> 732
    //   730: iconst_0
    //   731: ireturn
    //   732: new 234	java/lang/StringBuilder
    //   735: dup
    //   736: invokespecial 235	java/lang/StringBuilder:<init>	()V
    //   739: ldc_w 400
    //   742: invokevirtual 241	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   745: aload_1
    //   746: invokevirtual 241	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   749: invokevirtual 251	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   752: astore_1
    //   753: aload_0
    //   754: getfield 37	com/tencent/mobileqq/webviewplugin/WebViewJumpPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   757: invokevirtual 42	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   760: astore_2
    //   761: iload 6
    //   763: istore 5
    //   765: aload_2
    //   766: ifnull -699 -> 67
    //   769: aload_0
    //   770: getfield 27	com/tencent/mobileqq/webviewplugin/WebViewJumpPlugin:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   773: aload_2
    //   774: aload_1
    //   775: invokestatic 90	com/tencent/mobileqq/utils/JumpParser:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Landroid/content/Context;Ljava/lang/String;)Lcom/tencent/mobileqq/utils/JumpAction;
    //   778: astore_1
    //   779: aload_1
    //   780: ifnull +15 -> 795
    //   783: aload_1
    //   784: ldc_w 368
    //   787: invokevirtual 370	com/tencent/mobileqq/utils/JumpAction:a	(Ljava/lang/String;)V
    //   790: aload_1
    //   791: invokevirtual 94	com/tencent/mobileqq/utils/JumpAction:b	()Z
    //   794: pop
    //   795: new 111	android/os/Handler
    //   798: dup
    //   799: invokespecial 112	android/os/Handler:<init>	()V
    //   802: new 402	akrr
    //   805: dup
    //   806: aload_0
    //   807: invokespecial 403	akrr:<init>	(Lcom/tencent/mobileqq/webviewplugin/WebViewJumpPlugin;)V
    //   810: ldc2_w 118
    //   813: invokevirtual 123	android/os/Handler:postDelayed	(Ljava/lang/Runnable;J)Z
    //   816: pop
    //   817: iconst_1
    //   818: ireturn
    //   819: aload_1
    //   820: ldc_w 405
    //   823: invokevirtual 107	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   826: ifeq +113 -> 939
    //   829: aload_0
    //   830: getfield 152	com/tencent/mobileqq/webviewplugin/WebViewJumpPlugin:jdField_a_of_type_ComTencentSmttSdkWebView	Lcom/tencent/smtt/sdk/WebView;
    //   833: ifnonnull +19 -> 852
    //   836: invokestatic 53	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   839: ifeq +13 -> 852
    //   842: ldc 55
    //   844: iconst_2
    //   845: ldc 154
    //   847: invokestatic 61	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   850: iconst_1
    //   851: ireturn
    //   852: aload_0
    //   853: getfield 152	com/tencent/mobileqq/webviewplugin/WebViewJumpPlugin:jdField_a_of_type_ComTencentSmttSdkWebView	Lcom/tencent/smtt/sdk/WebView;
    //   856: invokevirtual 408	com/tencent/smtt/sdk/WebView:getUrl	()Ljava/lang/String;
    //   859: astore 11
    //   861: aload 11
    //   863: invokestatic 100	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   866: ifne +71 -> 937
    //   869: aload_1
    //   870: iconst_0
    //   871: anewarray 104	java/lang/String
    //   874: invokestatic 413	com/tencent/biz/common/util/Util:b	(Ljava/lang/String;[Ljava/lang/String;)Ljava/lang/String;
    //   877: astore_2
    //   878: aload_2
    //   879: astore_1
    //   880: aload_2
    //   881: invokevirtual 299	java/lang/String:length	()I
    //   884: sipush 512
    //   887: if_icmple +12 -> 899
    //   890: aload_2
    //   891: iconst_0
    //   892: sipush 512
    //   895: invokevirtual 307	java/lang/String:substring	(II)Ljava/lang/String;
    //   898: astore_1
    //   899: aconst_null
    //   900: ldc_w 415
    //   903: ldc_w 417
    //   906: ldc_w 419
    //   909: ldc_w 421
    //   912: ldc_w 423
    //   915: iconst_0
    //   916: iconst_1
    //   917: iconst_0
    //   918: aload 11
    //   920: iconst_0
    //   921: anewarray 104	java/lang/String
    //   924: invokestatic 413	com/tencent/biz/common/util/Util:b	(Ljava/lang/String;[Ljava/lang/String;)Ljava/lang/String;
    //   927: aload_1
    //   928: ldc_w 419
    //   931: ldc_w 419
    //   934: invokestatic 428	com/tencent/mobileqq/statistics/ReportController:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IIILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   937: iconst_0
    //   938: ireturn
    //   939: aload_1
    //   940: ldc_w 430
    //   943: invokevirtual 107	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   946: ifeq +41 -> 987
    //   949: aload_0
    //   950: getfield 27	com/tencent/mobileqq/webviewplugin/WebViewJumpPlugin:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   953: aload_0
    //   954: getfield 37	com/tencent/mobileqq/webviewplugin/WebViewJumpPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   957: invokevirtual 42	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   960: aload_1
    //   961: invokestatic 90	com/tencent/mobileqq/utils/JumpParser:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Landroid/content/Context;Ljava/lang/String;)Lcom/tencent/mobileqq/utils/JumpAction;
    //   964: astore_1
    //   965: iload 6
    //   967: istore 5
    //   969: aload_1
    //   970: ifnull -903 -> 67
    //   973: aload_1
    //   974: ldc_w 368
    //   977: invokevirtual 370	com/tencent/mobileqq/utils/JumpAction:a	(Ljava/lang/String;)V
    //   980: aload_1
    //   981: invokevirtual 94	com/tencent/mobileqq/utils/JumpAction:b	()Z
    //   984: pop
    //   985: iconst_1
    //   986: ireturn
    //   987: aload_1
    //   988: ldc_w 432
    //   991: invokevirtual 107	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   994: ifeq +41 -> 1035
    //   997: aload_0
    //   998: getfield 27	com/tencent/mobileqq/webviewplugin/WebViewJumpPlugin:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1001: aload_0
    //   1002: getfield 37	com/tencent/mobileqq/webviewplugin/WebViewJumpPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   1005: invokevirtual 42	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   1008: aload_1
    //   1009: invokestatic 90	com/tencent/mobileqq/utils/JumpParser:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Landroid/content/Context;Ljava/lang/String;)Lcom/tencent/mobileqq/utils/JumpAction;
    //   1012: astore_1
    //   1013: iload 6
    //   1015: istore 5
    //   1017: aload_1
    //   1018: ifnull -951 -> 67
    //   1021: aload_1
    //   1022: ldc_w 368
    //   1025: invokevirtual 370	com/tencent/mobileqq/utils/JumpAction:a	(Ljava/lang/String;)V
    //   1028: aload_1
    //   1029: invokevirtual 94	com/tencent/mobileqq/utils/JumpAction:b	()Z
    //   1032: pop
    //   1033: iconst_1
    //   1034: ireturn
    //   1035: aload_1
    //   1036: ldc_w 432
    //   1039: invokevirtual 107	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   1042: ifeq +52 -> 1094
    //   1045: aload_0
    //   1046: getfield 27	com/tencent/mobileqq/webviewplugin/WebViewJumpPlugin:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1049: aload_0
    //   1050: getfield 37	com/tencent/mobileqq/webviewplugin/WebViewJumpPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   1053: invokevirtual 42	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   1056: aload_1
    //   1057: invokestatic 90	com/tencent/mobileqq/utils/JumpParser:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Landroid/content/Context;Ljava/lang/String;)Lcom/tencent/mobileqq/utils/JumpAction;
    //   1060: astore_1
    //   1061: iload 6
    //   1063: istore 5
    //   1065: aload_1
    //   1066: ifnull -999 -> 67
    //   1069: aload_1
    //   1070: ldc_w 368
    //   1073: invokevirtual 370	com/tencent/mobileqq/utils/JumpAction:a	(Ljava/lang/String;)V
    //   1076: aload_1
    //   1077: aload_0
    //   1078: getfield 37	com/tencent/mobileqq/webviewplugin/WebViewJumpPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   1081: invokevirtual 435	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/common/app/AppInterface;
    //   1084: invokevirtual 438	com/tencent/mobileqq/utils/JumpAction:a	(Lcom/tencent/common/app/AppInterface;)V
    //   1087: aload_1
    //   1088: invokevirtual 94	com/tencent/mobileqq/utils/JumpAction:b	()Z
    //   1091: pop
    //   1092: iconst_1
    //   1093: ireturn
    //   1094: aload_1
    //   1095: ldc_w 440
    //   1098: invokevirtual 107	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   1101: ifeq +52 -> 1153
    //   1104: aload_0
    //   1105: getfield 27	com/tencent/mobileqq/webviewplugin/WebViewJumpPlugin:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1108: aload_0
    //   1109: getfield 37	com/tencent/mobileqq/webviewplugin/WebViewJumpPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   1112: invokevirtual 42	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   1115: aload_1
    //   1116: invokestatic 90	com/tencent/mobileqq/utils/JumpParser:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Landroid/content/Context;Ljava/lang/String;)Lcom/tencent/mobileqq/utils/JumpAction;
    //   1119: astore_1
    //   1120: iload 6
    //   1122: istore 5
    //   1124: aload_1
    //   1125: ifnull -1058 -> 67
    //   1128: aload_1
    //   1129: ldc_w 368
    //   1132: invokevirtual 370	com/tencent/mobileqq/utils/JumpAction:a	(Ljava/lang/String;)V
    //   1135: aload_1
    //   1136: aload_0
    //   1137: getfield 37	com/tencent/mobileqq/webviewplugin/WebViewJumpPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   1140: invokevirtual 435	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/common/app/AppInterface;
    //   1143: invokevirtual 438	com/tencent/mobileqq/utils/JumpAction:a	(Lcom/tencent/common/app/AppInterface;)V
    //   1146: aload_1
    //   1147: invokevirtual 94	com/tencent/mobileqq/utils/JumpAction:b	()Z
    //   1150: pop
    //   1151: iconst_1
    //   1152: ireturn
    //   1153: aload_1
    //   1154: ldc_w 442
    //   1157: invokevirtual 107	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   1160: ifne +13 -> 1173
    //   1163: aload_1
    //   1164: ldc_w 444
    //   1167: invokevirtual 107	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   1170: ifeq +53 -> 1223
    //   1173: new 72	android/content/Intent
    //   1176: dup
    //   1177: aload_0
    //   1178: getfield 37	com/tencent/mobileqq/webviewplugin/WebViewJumpPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   1181: invokevirtual 42	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   1184: ldc_w 446
    //   1187: invokespecial 77	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   1190: astore_2
    //   1191: aload_2
    //   1192: aload_1
    //   1193: invokestatic 266	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   1196: invokevirtual 450	android/content/Intent:setData	(Landroid/net/Uri;)Landroid/content/Intent;
    //   1199: pop
    //   1200: aload_2
    //   1201: ldc_w 452
    //   1204: ldc_w 368
    //   1207: invokevirtual 83	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   1210: pop
    //   1211: aload_0
    //   1212: aload_2
    //   1213: invokespecial 85	com/tencent/mobileqq/webviewplugin/WebViewJumpPlugin:a	(Landroid/content/Intent;)V
    //   1216: aload_0
    //   1217: aload_1
    //   1218: invokespecial 454	com/tencent/mobileqq/webviewplugin/WebViewJumpPlugin:c	(Ljava/lang/String;)V
    //   1221: iconst_1
    //   1222: ireturn
    //   1223: aload_1
    //   1224: ldc_w 456
    //   1227: invokevirtual 107	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   1230: ifeq +86 -> 1316
    //   1233: iload 6
    //   1235: istore 5
    //   1237: aload_0
    //   1238: aload_1
    //   1239: iconst_0
    //   1240: invokevirtual 458	com/tencent/mobileqq/webviewplugin/WebViewJumpPlugin:a	(Ljava/lang/String;Z)Z
    //   1243: ifne -1176 -> 67
    //   1246: iload 6
    //   1248: istore 5
    //   1250: aload_0
    //   1251: getfield 37	com/tencent/mobileqq/webviewplugin/WebViewJumpPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   1254: ifnull -1187 -> 67
    //   1257: iload 6
    //   1259: istore 5
    //   1261: aload_0
    //   1262: getfield 37	com/tencent/mobileqq/webviewplugin/WebViewJumpPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   1265: invokevirtual 42	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   1268: ifnull -1201 -> 67
    //   1271: aload_0
    //   1272: getfield 37	com/tencent/mobileqq/webviewplugin/WebViewJumpPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   1275: invokevirtual 42	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   1278: aload_1
    //   1279: invokestatic 146	com/tencent/smtt/sdk/stat/MttLoader:getValidQBUrl	(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   1282: astore_1
    //   1283: aload_0
    //   1284: getfield 152	com/tencent/mobileqq/webviewplugin/WebViewJumpPlugin:jdField_a_of_type_ComTencentSmttSdkWebView	Lcom/tencent/smtt/sdk/WebView;
    //   1287: ifnonnull +19 -> 1306
    //   1290: invokestatic 53	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1293: ifeq +13 -> 1306
    //   1296: ldc 55
    //   1298: iconst_2
    //   1299: ldc 154
    //   1301: invokestatic 61	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1304: iconst_1
    //   1305: ireturn
    //   1306: aload_0
    //   1307: getfield 152	com/tencent/mobileqq/webviewplugin/WebViewJumpPlugin:jdField_a_of_type_ComTencentSmttSdkWebView	Lcom/tencent/smtt/sdk/WebView;
    //   1310: aload_1
    //   1311: invokevirtual 160	com/tencent/smtt/sdk/WebView:loadUrl	(Ljava/lang/String;)V
    //   1314: iconst_1
    //   1315: ireturn
    //   1316: aload_1
    //   1317: ldc_w 460
    //   1320: invokevirtual 107	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   1323: ifne +10 -> 1333
    //   1326: aload_1
    //   1327: invokestatic 462	com/tencent/biz/qrcode/util/QRUtils:b	(Ljava/lang/String;)Z
    //   1330: ifeq +10 -> 1340
    //   1333: aload_0
    //   1334: aload_1
    //   1335: invokespecial 464	com/tencent/mobileqq/webviewplugin/WebViewJumpPlugin:b	(Ljava/lang/String;)V
    //   1338: iconst_1
    //   1339: ireturn
    //   1340: aload_1
    //   1341: ldc_w 466
    //   1344: invokevirtual 107	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   1347: ifeq +44 -> 1391
    //   1350: new 72	android/content/Intent
    //   1353: dup
    //   1354: ldc_w 287
    //   1357: aload_1
    //   1358: invokestatic 266	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   1361: invokespecial 269	android/content/Intent:<init>	(Ljava/lang/String;Landroid/net/Uri;)V
    //   1364: astore_1
    //   1365: aload_1
    //   1366: ldc_w 467
    //   1369: invokevirtual 471	android/content/Intent:addFlags	(I)Landroid/content/Intent;
    //   1372: pop
    //   1373: aload_1
    //   1374: ldc_w 452
    //   1377: ldc_w 368
    //   1380: invokevirtual 83	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   1383: pop
    //   1384: aload_0
    //   1385: aload_1
    //   1386: invokespecial 85	com/tencent/mobileqq/webviewplugin/WebViewJumpPlugin:a	(Landroid/content/Intent;)V
    //   1389: iconst_1
    //   1390: ireturn
    //   1391: aload_1
    //   1392: ldc_w 473
    //   1395: invokevirtual 107	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   1398: ifeq +28 -> 1426
    //   1401: aload_0
    //   1402: getfield 37	com/tencent/mobileqq/webviewplugin/WebViewJumpPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   1405: invokevirtual 42	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   1408: astore_1
    //   1409: aload_1
    //   1410: ifnull +14 -> 1424
    //   1413: aload_1
    //   1414: sipush 8213
    //   1417: invokevirtual 476	android/app/Activity:setResult	(I)V
    //   1420: aload_1
    //   1421: invokevirtual 65	android/app/Activity:finish	()V
    //   1424: iconst_0
    //   1425: ireturn
    //   1426: aload_1
    //   1427: ldc_w 478
    //   1430: invokevirtual 107	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   1433: ifeq +11 -> 1444
    //   1436: aload_0
    //   1437: aload_1
    //   1438: invokevirtual 479	com/tencent/mobileqq/webviewplugin/WebViewJumpPlugin:a	(Ljava/lang/String;)V
    //   1441: goto -17 -> 1424
    //   1444: aload_1
    //   1445: ldc_w 481
    //   1448: invokevirtual 107	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   1451: ifeq +236 -> 1687
    //   1454: aload_1
    //   1455: invokestatic 486	com/tencent/util/URLUtil:a	(Ljava/lang/String;)Ljava/util/Map;
    //   1458: astore_2
    //   1459: aload_2
    //   1460: ldc_w 348
    //   1463: invokeinterface 492 2 0
    //   1468: ifeq +178 -> 1646
    //   1471: aload_2
    //   1472: ldc_w 348
    //   1475: invokeinterface 496 2 0
    //   1480: checkcast 104	java/lang/String
    //   1483: astore_1
    //   1484: aload_1
    //   1485: invokestatic 333	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   1488: lstore 7
    //   1490: invokestatic 500	cooperation/qzone/QZoneHelper$QZoneFamousSpaceHomeConstants:a	()Ljava/lang/String;
    //   1493: astore_1
    //   1494: invokestatic 53	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1497: ifeq +42 -> 1539
    //   1500: aload_0
    //   1501: getfield 232	com/tencent/mobileqq/webviewplugin/WebViewJumpPlugin:TAG	Ljava/lang/String;
    //   1504: iconst_2
    //   1505: new 234	java/lang/StringBuilder
    //   1508: dup
    //   1509: invokespecial 235	java/lang/StringBuilder:<init>	()V
    //   1512: ldc_w 502
    //   1515: invokevirtual 241	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1518: lload 7
    //   1520: invokevirtual 505	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1523: ldc_w 507
    //   1526: invokevirtual 241	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1529: aload_1
    //   1530: invokevirtual 241	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1533: invokevirtual 251	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1536: invokestatic 61	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1539: aload_0
    //   1540: getfield 37	com/tencent/mobileqq/webviewplugin/WebViewJumpPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   1543: invokevirtual 42	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   1546: astore_2
    //   1547: new 72	android/content/Intent
    //   1550: dup
    //   1551: invokespecial 508	android/content/Intent:<init>	()V
    //   1554: astore 11
    //   1556: aload 11
    //   1558: ldc_w 510
    //   1561: lload 7
    //   1563: invokevirtual 353	android/content/Intent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
    //   1566: pop
    //   1567: aload 11
    //   1569: ldc_w 512
    //   1572: ldc_w 514
    //   1575: invokevirtual 83	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   1578: pop
    //   1579: aload 11
    //   1581: ldc_w 516
    //   1584: aload_1
    //   1585: invokevirtual 83	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   1588: pop
    //   1589: aload 11
    //   1591: ldc_w 518
    //   1594: invokestatic 523	cooperation/qzone/QzonePluginProxyActivity:a	(Landroid/content/Intent;Ljava/lang/String;)V
    //   1597: aload_2
    //   1598: aload_0
    //   1599: getfield 37	com/tencent/mobileqq/webviewplugin/WebViewJumpPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   1602: invokevirtual 435	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/common/app/AppInterface;
    //   1605: invokevirtual 528	com/tencent/common/app/AppInterface:getAccount	()Ljava/lang/String;
    //   1608: aload 11
    //   1610: iconst_0
    //   1611: invokestatic 531	cooperation/qzone/QzonePluginProxyActivity:a	(Landroid/app/Activity;Ljava/lang/String;Landroid/content/Intent;I)V
    //   1614: new 111	android/os/Handler
    //   1617: dup
    //   1618: invokespecial 112	android/os/Handler:<init>	()V
    //   1621: new 533	akrs
    //   1624: dup
    //   1625: aload_0
    //   1626: invokespecial 534	akrs:<init>	(Lcom/tencent/mobileqq/webviewplugin/WebViewJumpPlugin;)V
    //   1629: ldc2_w 118
    //   1632: invokevirtual 123	android/os/Handler:postDelayed	(Ljava/lang/Runnable;J)Z
    //   1635: pop
    //   1636: iconst_1
    //   1637: ireturn
    //   1638: astore_1
    //   1639: aload_1
    //   1640: invokevirtual 537	java/lang/NumberFormatException:printStackTrace	()V
    //   1643: goto -219 -> 1424
    //   1646: aload_1
    //   1647: bipush 63
    //   1649: invokevirtual 541	java/lang/String:lastIndexOf	(I)I
    //   1652: istore_3
    //   1653: iload_3
    //   1654: iconst_m1
    //   1655: if_icmpeq +18 -> 1673
    //   1658: aload_1
    //   1659: ldc_w 481
    //   1662: invokevirtual 299	java/lang/String:length	()I
    //   1665: iload_3
    //   1666: invokevirtual 307	java/lang/String:substring	(II)Ljava/lang/String;
    //   1669: astore_1
    //   1670: goto -186 -> 1484
    //   1673: aload_1
    //   1674: ldc_w 481
    //   1677: invokevirtual 299	java/lang/String:length	()I
    //   1680: invokevirtual 543	java/lang/String:substring	(I)Ljava/lang/String;
    //   1683: astore_1
    //   1684: goto -200 -> 1484
    //   1687: aload_1
    //   1688: ldc_w 545
    //   1691: invokevirtual 107	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   1694: ifeq +16 -> 1710
    //   1697: aload_0
    //   1698: getfield 37	com/tencent/mobileqq/webviewplugin/WebViewJumpPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   1701: invokevirtual 42	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   1704: ifnull -280 -> 1424
    //   1707: goto -283 -> 1424
    //   1710: aload_1
    //   1711: ldc_w 547
    //   1714: invokevirtual 107	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   1717: ifeq -293 -> 1424
    //   1720: aload_0
    //   1721: getfield 27	com/tencent/mobileqq/webviewplugin/WebViewJumpPlugin:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1724: aload_0
    //   1725: getfield 37	com/tencent/mobileqq/webviewplugin/WebViewJumpPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   1728: invokevirtual 42	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   1731: aload_1
    //   1732: invokestatic 90	com/tencent/mobileqq/utils/JumpParser:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Landroid/content/Context;Ljava/lang/String;)Lcom/tencent/mobileqq/utils/JumpAction;
    //   1735: astore_1
    //   1736: aload_1
    //   1737: ifnull -313 -> 1424
    //   1740: aload_1
    //   1741: invokevirtual 94	com/tencent/mobileqq/utils/JumpAction:b	()Z
    //   1744: pop
    //   1745: goto -321 -> 1424
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1748	0	this	WebViewJumpPlugin
    //   0	1748	1	paramString1	String
    //   0	1748	2	paramString2	String
    //   173	1493	3	i	int
    //   169	54	4	j	int
    //   65	1195	5	bool1	boolean
    //   1	1257	6	bool2	boolean
    //   408	1154	7	l1	long
    //   416	51	9	l2	long
    //   317	1292	11	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   1484	1539	1638	java/lang/NumberFormatException
    //   1539	1636	1638	java/lang/NumberFormatException
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
  
  protected void onCreate() {}
  
  protected void onWebViewCreated(CustomWebView paramCustomWebView)
  {
    super.onWebViewCreated(paramCustomWebView);
    this.jdField_a_of_type_ComTencentSmttSdkWebView = paramCustomWebView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\b.jar
 * Qualified Name:     com.tencent.mobileqq.webviewplugin.WebViewJumpPlugin
 * JD-Core Version:    0.7.0.1
 */