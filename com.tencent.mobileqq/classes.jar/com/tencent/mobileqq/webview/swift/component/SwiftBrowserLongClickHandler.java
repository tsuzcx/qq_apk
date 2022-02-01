package com.tencent.mobileqq.webview.swift.component;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.TeamWorkDocEditBrowserActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qrscan.ScannerResult;
import com.tencent.mobileqq.qrscan.api.IMiniCodeApi;
import com.tencent.mobileqq.qrscan.api.IScanUtilApi;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.export.external.extension.interfaces.IX5WebViewExtension;
import com.tencent.smtt.export.external.interfaces.IX5WebViewBase.HitTestResult;
import com.tencent.smtt.export.external.interfaces.IX5WebViewBase.HitTestResult.ImageAnchorData;
import com.tencent.smtt.sdk.CookieManager;
import com.tencent.widget.ActionSheet;

public class SwiftBrowserLongClickHandler
  extends SwiftBrowserComponentsProvider.SwiftBrowserComponent
{
  public ActionSheet a;
  String c;
  QQProgressDialog d;
  CookieManager e;
  Activity f;
  int g = 0;
  String h;
  int i = -1;
  String j;
  ScannerResult k;
  Object l = new Object();
  
  private void d(String paramString)
  {
    if (this.f.isFinishing()) {
      return;
    }
    ThreadManager.excute(new SwiftBrowserLongClickHandler.4(this, paramString), 64, null, true);
  }
  
  public void a()
  {
    super.a();
    this.f = this.b.b();
    Activity localActivity = this.f;
    if ((localActivity instanceof QQBrowserActivity)) {
      this.g = ((QQBrowserActivity)localActivity).getTitleBarHeight();
    }
    ThreadManager.postImmediately(new SwiftBrowserLongClickHandler.1(this), null, true);
  }
  
  public void a(int paramInt, Bundle paramBundle)
  {
    if (paramInt != 3) {
      return;
    }
    paramBundle = this.a;
    if ((paramBundle != null) && (paramBundle.isShowing())) {
      this.a.dismiss();
    }
    ((IMiniCodeApi)QRoute.api(IMiniCodeApi.class)).unInit(hashCode(), "SwiftBrowserLongClickHandler");
  }
  
  /* Error */
  void a(String paramString)
  {
    // Byte code:
    //   0: new 115	java/io/File
    //   3: dup
    //   4: aload_1
    //   5: invokespecial 117	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: astore 8
    //   10: aconst_null
    //   11: astore 6
    //   13: aconst_null
    //   14: astore_1
    //   15: new 119	java/io/FileInputStream
    //   18: dup
    //   19: aload 8
    //   21: invokespecial 122	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   24: astore 5
    //   26: aload 5
    //   28: invokevirtual 127	java/io/InputStream:read	()I
    //   31: istore_2
    //   32: aload 5
    //   34: invokevirtual 127	java/io/InputStream:read	()I
    //   37: istore_3
    //   38: aload 5
    //   40: invokevirtual 127	java/io/InputStream:read	()I
    //   43: istore 4
    //   45: iload_2
    //   46: bipush 66
    //   48: if_icmpne +354 -> 402
    //   51: iload_3
    //   52: bipush 77
    //   54: if_icmpne +348 -> 402
    //   57: ldc 129
    //   59: astore_1
    //   60: goto +6 -> 66
    //   63: ldc 131
    //   65: astore_1
    //   66: aload 5
    //   68: invokevirtual 134	java/io/InputStream:close	()V
    //   71: aload_1
    //   72: astore 6
    //   74: goto +37 -> 111
    //   77: astore_1
    //   78: goto +10 -> 88
    //   81: goto +22 -> 103
    //   84: astore_1
    //   85: aconst_null
    //   86: astore 5
    //   88: aload 5
    //   90: ifnull +8 -> 98
    //   93: aload 5
    //   95: invokevirtual 134	java/io/InputStream:close	()V
    //   98: aload_1
    //   99: athrow
    //   100: aconst_null
    //   101: astore 5
    //   103: aload 5
    //   105: ifnull +6 -> 111
    //   108: goto -42 -> 66
    //   111: aload 6
    //   113: ifnull +250 -> 363
    //   116: aload_0
    //   117: getfield 136	com/tencent/mobileqq/webview/swift/component/SwiftBrowserLongClickHandler:c	Ljava/lang/String;
    //   120: invokestatic 142	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   123: invokevirtual 146	android/net/Uri:getLastPathSegment	()Ljava/lang/String;
    //   126: astore 5
    //   128: aload 5
    //   130: invokestatic 152	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   133: ifeq +9 -> 142
    //   136: ldc 154
    //   138: astore_1
    //   139: goto +34 -> 173
    //   142: aload 5
    //   144: astore_1
    //   145: aload 5
    //   147: aload 6
    //   149: invokevirtual 160	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   152: ifeq +21 -> 173
    //   155: aload 5
    //   157: iconst_0
    //   158: aload 5
    //   160: invokevirtual 163	java/lang/String:length	()I
    //   163: aload 6
    //   165: invokevirtual 163	java/lang/String:length	()I
    //   168: isub
    //   169: invokevirtual 167	java/lang/String:substring	(II)Ljava/lang/String;
    //   172: astore_1
    //   173: new 115	java/io/File
    //   176: dup
    //   177: getstatic 172	com/tencent/mobileqq/app/AppConstants:SDCARD_IMG_SAVE	Ljava/lang/String;
    //   180: invokespecial 117	java/io/File:<init>	(Ljava/lang/String;)V
    //   183: invokevirtual 175	java/io/File:mkdirs	()Z
    //   186: pop
    //   187: new 177	java/lang/StringBuilder
    //   190: dup
    //   191: invokespecial 178	java/lang/StringBuilder:<init>	()V
    //   194: astore 5
    //   196: aload 5
    //   198: getstatic 172	com/tencent/mobileqq/app/AppConstants:SDCARD_IMG_SAVE	Ljava/lang/String;
    //   201: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   204: pop
    //   205: aload 5
    //   207: aload_1
    //   208: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   211: pop
    //   212: aload 5
    //   214: aload 6
    //   216: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   219: pop
    //   220: aload 5
    //   222: invokevirtual 185	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   225: astore 5
    //   227: new 115	java/io/File
    //   230: dup
    //   231: aload 5
    //   233: invokespecial 117	java/io/File:<init>	(Ljava/lang/String;)V
    //   236: astore 7
    //   238: iconst_2
    //   239: istore_2
    //   240: aload 7
    //   242: invokevirtual 188	java/io/File:exists	()Z
    //   245: ifeq +90 -> 335
    //   248: iload_2
    //   249: ldc 189
    //   251: if_icmpge +84 -> 335
    //   254: new 177	java/lang/StringBuilder
    //   257: dup
    //   258: invokespecial 178	java/lang/StringBuilder:<init>	()V
    //   261: astore 5
    //   263: aload 5
    //   265: getstatic 172	com/tencent/mobileqq/app/AppConstants:SDCARD_IMG_SAVE	Ljava/lang/String;
    //   268: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   271: pop
    //   272: aload 5
    //   274: aload_1
    //   275: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   278: pop
    //   279: aload 5
    //   281: ldc 191
    //   283: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   286: pop
    //   287: aload 5
    //   289: iload_2
    //   290: invokevirtual 194	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   293: pop
    //   294: aload 5
    //   296: ldc 196
    //   298: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   301: pop
    //   302: aload 5
    //   304: aload 6
    //   306: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   309: pop
    //   310: aload 5
    //   312: invokevirtual 185	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   315: astore 5
    //   317: new 115	java/io/File
    //   320: dup
    //   321: aload 5
    //   323: invokespecial 117	java/io/File:<init>	(Ljava/lang/String;)V
    //   326: astore 7
    //   328: iload_2
    //   329: iconst_1
    //   330: iadd
    //   331: istore_2
    //   332: goto -92 -> 240
    //   335: aload 8
    //   337: aload 7
    //   339: invokevirtual 200	java/io/File:renameTo	(Ljava/io/File;)Z
    //   342: ifeq +21 -> 363
    //   345: aload_0
    //   346: getfield 40	com/tencent/mobileqq/webview/swift/component/SwiftBrowserLongClickHandler:f	Landroid/app/Activity;
    //   349: new 202	com/tencent/mobileqq/webview/swift/component/SwiftBrowserLongClickHandler$5
    //   352: dup
    //   353: aload_0
    //   354: aload 5
    //   356: invokespecial 203	com/tencent/mobileqq/webview/swift/component/SwiftBrowserLongClickHandler$5:<init>	(Lcom/tencent/mobileqq/webview/swift/component/SwiftBrowserLongClickHandler;Ljava/lang/String;)V
    //   359: invokevirtual 207	android/app/Activity:runOnUiThread	(Ljava/lang/Runnable;)V
    //   362: return
    //   363: aload_0
    //   364: getfield 40	com/tencent/mobileqq/webview/swift/component/SwiftBrowserLongClickHandler:f	Landroid/app/Activity;
    //   367: new 209	com/tencent/mobileqq/webview/swift/component/SwiftBrowserLongClickHandler$6
    //   370: dup
    //   371: aload_0
    //   372: invokespecial 210	com/tencent/mobileqq/webview/swift/component/SwiftBrowserLongClickHandler$6:<init>	(Lcom/tencent/mobileqq/webview/swift/component/SwiftBrowserLongClickHandler;)V
    //   375: invokevirtual 207	android/app/Activity:runOnUiThread	(Ljava/lang/Runnable;)V
    //   378: return
    //   379: astore 5
    //   381: goto -281 -> 100
    //   384: astore 7
    //   386: goto -305 -> 81
    //   389: astore 5
    //   391: aload_1
    //   392: astore 6
    //   394: goto -283 -> 111
    //   397: astore 5
    //   399: goto -301 -> 98
    //   402: iload_2
    //   403: sipush 137
    //   406: if_icmpne +15 -> 421
    //   409: iload_3
    //   410: bipush 80
    //   412: if_icmpne +9 -> 421
    //   415: ldc 212
    //   417: astore_1
    //   418: goto -352 -> 66
    //   421: iload_2
    //   422: bipush 71
    //   424: if_icmpne +15 -> 439
    //   427: iload_3
    //   428: bipush 73
    //   430: if_icmpne +9 -> 439
    //   433: ldc 214
    //   435: astore_1
    //   436: goto -370 -> 66
    //   439: iload_2
    //   440: sipush 255
    //   443: if_icmpne +16 -> 459
    //   446: iload_3
    //   447: sipush 216
    //   450: if_icmpne +9 -> 459
    //   453: ldc 216
    //   455: astore_1
    //   456: goto -390 -> 66
    //   459: bipush 82
    //   461: iload_2
    //   462: if_icmpne -399 -> 63
    //   465: bipush 73
    //   467: iload_3
    //   468: if_icmpne -405 -> 63
    //   471: bipush 70
    //   473: iload 4
    //   475: if_icmpne -412 -> 63
    //   478: ldc 218
    //   480: astore_1
    //   481: goto -415 -> 66
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	484	0	this	SwiftBrowserLongClickHandler
    //   0	484	1	paramString	String
    //   31	432	2	m	int
    //   37	432	3	n	int
    //   43	433	4	i1	int
    //   24	331	5	localObject	Object
    //   379	1	5	localIOException1	java.io.IOException
    //   389	1	5	localIOException2	java.io.IOException
    //   397	1	5	localIOException3	java.io.IOException
    //   11	382	6	str	String
    //   236	102	7	localFile1	java.io.File
    //   384	1	7	localIOException4	java.io.IOException
    //   8	328	8	localFile2	java.io.File
    // Exception table:
    //   from	to	target	type
    //   26	45	77	finally
    //   15	26	84	finally
    //   15	26	379	java/io/IOException
    //   26	45	384	java/io/IOException
    //   66	71	389	java/io/IOException
    //   93	98	397	java/io/IOException
  }
  
  void a(String paramString, int paramInt)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("PhotoConst.SINGLE_PHOTO_PATH", paramString);
    localIntent.putExtra("detectType", paramInt);
    localIntent.putExtra("fromPicQRDecode", true);
    localIntent.putExtra("preScanResult", this.k);
    String str = this.c;
    paramString = str;
    if (!TextUtils.isEmpty(str))
    {
      paramString = str;
      if (str.startsWith("data:")) {
        paramString = "";
      }
    }
    localIntent.putExtra("report_params", ((IScanUtilApi)QRoute.api(IScanUtilApi.class)).buildQRScanReportParams(null, paramString, null, null, null, 5));
    RouteUtils.a(this.f, localIntent, "/qrscan/scanner");
  }
  
  public boolean a(View paramView)
  {
    Object localObject1 = this.f;
    if (localObject1 != null)
    {
      if (((Activity)localObject1).isFinishing()) {
        return true;
      }
      localObject1 = "";
      Object localObject2 = this.b;
      int n = 0;
      boolean bool2;
      if ((localObject2 != null) && (this.b.a() != null))
      {
        localObject2 = this.b.a();
        IX5WebViewBase.HitTestResult localHitTestResult = ((com.tencent.smtt.sdk.WebView)localObject2).getX5HitTestResult();
        if (localHitTestResult != null)
        {
          int i1 = localHitTestResult.getType();
          if (i1 == 8)
          {
            paramView = (View)localObject1;
            m = i1;
            if ((localHitTestResult.getData() instanceof IX5WebViewBase.HitTestResult.ImageAnchorData))
            {
              paramView = ((IX5WebViewBase.HitTestResult.ImageAnchorData)localHitTestResult.getData()).mPicUrl;
              m = i1;
            }
          }
          else
          {
            paramView = localHitTestResult.getExtra();
            m = i1;
          }
        }
        else
        {
          paramView = ((com.tencent.smtt.sdk.WebView)localObject2).getHitTestResult();
          if (paramView == null) {
            break label287;
          }
          m = paramView.getType();
          paramView = paramView.getExtra();
        }
        localObject1 = ((com.tencent.smtt.sdk.WebView)localObject2).getX5WebViewExtension();
        if (localObject1 != null)
        {
          localObject1 = (Boolean)((IX5WebViewExtension)localObject1).invokeMiscMethod("supportImageQuery", new Bundle());
          boolean bool1;
          if (localObject1 != null)
          {
            bool1 = ((Boolean)localObject1).booleanValue();
          }
          else
          {
            QLog.e("SwiftBrowserLongClickHandler", 1, "X5WebView supportImageQuery invoke result is null.");
            bool1 = false;
          }
          bool2 = bool1;
          if (QLog.isColorLevel())
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("isSupportImageQuery:");
            ((StringBuilder)localObject1).append(bool1);
            QLog.d("SwiftBrowserLongClickHandler", 2, ((StringBuilder)localObject1).toString());
            bool2 = bool1;
          }
        }
        else
        {
          QLog.e("SwiftBrowserLongClickHandler", 1, "X5WebView extension is null. can't get ability of supportImageQuery");
          bool2 = false;
        }
        break label331;
        label287:
        return false;
      }
      else
      {
        if ((paramView instanceof android.webkit.WebView))
        {
          paramView = ((android.webkit.WebView)paramView).getHitTestResult();
          if (paramView != null)
          {
            m = paramView.getType();
            paramView = paramView.getExtra();
          }
          else
          {
            return false;
          }
        }
        else
        {
          paramView = "";
          m = 0;
        }
        bool2 = false;
      }
      label331:
      if ((m != 8) && (m != 5))
      {
        QLog.e("SwiftBrowserLongClickHandler", 1, "the type of HitTestResult is not image type.");
        return false;
      }
      if (TextUtils.isEmpty(paramView))
      {
        QLog.e("SwiftBrowserLongClickHandler", 1, "the image url of HitTestResult is empty.");
        return false;
      }
      if (QLog.isColorLevel()) {
        QLog.d("SwiftBrowserLongClickHandler", 2, "showActionSheet");
      }
      this.c = paramView;
      int m = n;
      if ((this.f instanceof TeamWorkDocEditBrowserActivity)) {
        m = 1;
      }
      this.a = ActionSheet.createMenuSheet(this.f);
      if (bool2) {
        this.a.addButton(2131887621);
      }
      this.a.addButton(2131887620);
      this.a.addButton(2131887619);
      if (m != 0) {
        this.a.addButton(2131890802);
      }
      this.a.addCancelButton(2131887648);
      d(this.c);
      this.a.setOnButtonClickListenerV2(new SwiftBrowserLongClickHandler.2(this));
      this.a.setOnDismissListener(new SwiftBrowserLongClickHandler.3(this));
      this.a.setCanceledOnTouchOutside(true);
      try
      {
        this.a.show();
        return true;
      }
      catch (Exception paramView)
      {
        paramView.printStackTrace();
      }
    }
    return true;
  }
  
  void b(String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("forward_type", 1);
    localBundle.putString("forward_filepath", paramString);
    localBundle.putString("forward_extra", paramString);
    localBundle.putBoolean("not_forward", true);
    localBundle.putString("forward_thumb", paramString);
    localBundle.putBoolean("isFromShare", true);
    localBundle.putBoolean("isJumpAIO", true);
    paramString = new Intent();
    paramString.putExtras(localBundle);
    ForwardBaseOption.a(this.f, paramString, 21);
  }
  
  public boolean b()
  {
    ??? = this.d;
    if ((??? != null) && (((QQProgressDialog)???).isShowing())) {
      this.d.dismiss();
    }
    for (;;)
    {
      synchronized (this.l)
      {
        if ((!TextUtils.isEmpty(this.j)) && (this.j.equals(this.h)) && (this.k != null))
        {
          bool1 = this.k.h();
          bool2 = this.k.g();
          if (bool1)
          {
            a(this.h, 1);
            return true;
          }
          if (bool2)
          {
            a(this.h, 2);
            return true;
          }
          QQToast.makeText(this.f.getApplicationContext(), 1, 2131887015, 1).show(this.g);
          return false;
        }
      }
      boolean bool1 = false;
      boolean bool2 = false;
    }
  }
  
  void c(String paramString)
  {
    if (this.b == null)
    {
      QLog.e("SwiftBrowserLongClickHandler", 1, "x5QueryImage. mComponentContext is null");
      return;
    }
    Object localObject = this.b.a();
    if (localObject == null)
    {
      QLog.e("SwiftBrowserLongClickHandler", 1, "x5QueryImage. x5WebView is null");
      return;
    }
    localObject = ((com.tencent.smtt.sdk.WebView)localObject).getX5WebViewExtension();
    if (localObject == null)
    {
      QLog.e("SwiftBrowserLongClickHandler", 1, "x5QueryImage. extension is null");
      return;
    }
    if (TextUtils.isEmpty(paramString))
    {
      QLog.e("SwiftBrowserLongClickHandler", 1, "x5QueryImage. filePath is null");
      return;
    }
    ThreadManager.excute(new SwiftBrowserLongClickHandler.7(this, paramString, (IX5WebViewExtension)localObject), 64, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.component.SwiftBrowserLongClickHandler
 * JD-Core Version:    0.7.0.1
 */