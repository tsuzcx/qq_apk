package com.tencent.mobileqq.webview.swift.component;

import akos;
import akot;
import akou;
import akpa;
import akpb;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebView.HitTestResult;
import com.tencent.biz.qrcode.activity.ScannerActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.TeamWorkDocEditBrowserActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.export.external.interfaces.IX5WebViewBase.HitTestResult;
import com.tencent.smtt.export.external.interfaces.IX5WebViewBase.HitTestResult.ImageAnchorData;
import com.tencent.smtt.sdk.CookieManager;
import com.tencent.widget.ActionSheet;

public class SwiftBrowserLongClickHandler
  extends SwiftBrowserComponentsProvider.SwiftBrowserComponent
{
  public int a;
  public final Activity a;
  public QQProgressDialog a;
  public CookieManager a;
  public ActionSheet a;
  String a;
  public int b = -1;
  public String b;
  
  public SwiftBrowserLongClickHandler(Activity paramActivity)
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    if ((this.jdField_a_of_type_AndroidAppActivity instanceof QQBrowserActivity)) {
      this.jdField_a_of_type_Int = ((QQBrowserActivity)this.jdField_a_of_type_AndroidAppActivity).getTitleBarHeight();
    }
  }
  
  private void a()
  {
    this.jdField_a_of_type_ComTencentWidgetActionSheet = ActionSheet.c(this.jdField_a_of_type_AndroidAppActivity);
    this.jdField_a_of_type_ComTencentWidgetActionSheet.b(2131435871);
    this.jdField_a_of_type_ComTencentWidgetActionSheet.b(2131435877);
    this.jdField_a_of_type_ComTencentWidgetActionSheet.b(2131435875);
    this.jdField_a_of_type_ComTencentWidgetActionSheet.c(2131433015);
    d(this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentWidgetActionSheet.a(new akpa(this));
    this.jdField_a_of_type_ComTencentWidgetActionSheet.setOnDismissListener(new akpb(this));
    this.jdField_a_of_type_ComTencentWidgetActionSheet.setCanceledOnTouchOutside(true);
    try
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.show();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void d(String paramString)
  {
    if (this.jdField_a_of_type_AndroidAppActivity.isFinishing()) {
      return;
    }
    ThreadManager.executeOnFileThread(new akou(this, paramString));
  }
  
  /* Error */
  public java.lang.Boolean a(java.io.File paramFile)
  {
    // Byte code:
    //   0: iconst_2
    //   1: iconst_0
    //   2: ldc 108
    //   4: ldc 110
    //   6: invokestatic 115	com/tencent/qbar/QbarNativeImpl:a	(IILjava/lang/String;Ljava/lang/String;)I
    //   9: pop
    //   10: iconst_2
    //   11: newarray int
    //   13: astore 5
    //   15: aload 5
    //   17: iconst_0
    //   18: iconst_2
    //   19: iastore
    //   20: aload 5
    //   22: iconst_1
    //   23: iconst_0
    //   24: iastore
    //   25: aload 5
    //   27: aload 5
    //   29: arraylength
    //   30: invokestatic 118	com/tencent/qbar/QbarNativeImpl:a	([II)I
    //   33: pop
    //   34: new 120	java/lang/StringBuilder
    //   37: dup
    //   38: invokespecial 121	java/lang/StringBuilder:<init>	()V
    //   41: ldc 123
    //   43: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: aload_1
    //   47: invokevirtual 133	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   50: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   53: invokevirtual 136	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   56: invokestatic 142	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   59: astore_1
    //   60: iconst_m1
    //   61: istore_2
    //   62: aload_0
    //   63: getfield 23	com/tencent/mobileqq/webview/swift/component/SwiftBrowserLongClickHandler:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   66: invokevirtual 146	android/app/Activity:getContentResolver	()Landroid/content/ContentResolver;
    //   69: astore 7
    //   71: new 148	android/graphics/BitmapFactory$Options
    //   74: dup
    //   75: invokespecial 149	android/graphics/BitmapFactory$Options:<init>	()V
    //   78: astore 6
    //   80: aload 6
    //   82: iconst_1
    //   83: putfield 153	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   86: aload 7
    //   88: aload_1
    //   89: invokevirtual 159	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   92: astore 5
    //   94: aload 5
    //   96: aconst_null
    //   97: aload 6
    //   99: invokestatic 165	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   102: pop
    //   103: aload 5
    //   105: ifnull +8 -> 113
    //   108: aload 5
    //   110: invokevirtual 170	java/io/InputStream:close	()V
    //   113: aload 6
    //   115: getfield 173	android/graphics/BitmapFactory$Options:outWidth	I
    //   118: istore_3
    //   119: aload 6
    //   121: getfield 176	android/graphics/BitmapFactory$Options:outHeight	I
    //   124: istore 4
    //   126: aload 6
    //   128: iconst_0
    //   129: putfield 153	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   132: iload_3
    //   133: iload 4
    //   135: imul
    //   136: ldc 177
    //   138: if_icmple +169 -> 307
    //   141: aload 6
    //   143: iload_3
    //   144: iload 4
    //   146: imul
    //   147: i2d
    //   148: invokestatic 183	java/lang/Math:sqrt	(D)D
    //   151: ldc2_w 184
    //   154: ddiv
    //   155: invokestatic 188	java/lang/Math:ceil	(D)D
    //   158: d2i
    //   159: putfield 191	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   162: aload 7
    //   164: aload_1
    //   165: invokevirtual 159	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   168: astore_1
    //   169: aload_1
    //   170: aconst_null
    //   171: aload 6
    //   173: invokestatic 165	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   176: astore 6
    //   178: aload_1
    //   179: ifnull +7 -> 186
    //   182: aload_1
    //   183: invokevirtual 170	java/io/InputStream:close	()V
    //   186: aload 6
    //   188: invokevirtual 196	android/graphics/Bitmap:getWidth	()I
    //   191: istore_3
    //   192: aload 6
    //   194: invokevirtual 199	android/graphics/Bitmap:getHeight	()I
    //   197: istore 4
    //   199: iload_3
    //   200: iload 4
    //   202: imul
    //   203: newarray int
    //   205: astore 5
    //   207: aload 6
    //   209: aload 5
    //   211: iconst_0
    //   212: iload_3
    //   213: iconst_0
    //   214: iconst_0
    //   215: iload_3
    //   216: iload 4
    //   218: invokevirtual 203	android/graphics/Bitmap:getPixels	([IIIIIII)V
    //   221: aload 6
    //   223: invokevirtual 206	android/graphics/Bitmap:recycle	()V
    //   226: iload_3
    //   227: iload 4
    //   229: imul
    //   230: newarray byte
    //   232: astore 6
    //   234: aload 5
    //   236: aload 6
    //   238: iload_3
    //   239: iload 4
    //   241: invokestatic 211	com/tencent/imageboost/ImgProcessScan:a	([I[BII)I
    //   244: pop
    //   245: aload 6
    //   247: iload_3
    //   248: iload 4
    //   250: iconst_0
    //   251: invokestatic 214	com/tencent/qbar/QbarNativeImpl:a	([BIII)I
    //   254: istore_3
    //   255: iload_3
    //   256: istore_2
    //   257: invokestatic 216	com/tencent/qbar/QbarNativeImpl:a	()I
    //   260: pop
    //   261: iload_2
    //   262: iconst_1
    //   263: if_icmpne +112 -> 375
    //   266: invokestatic 221	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   269: ifeq +11 -> 280
    //   272: ldc 223
    //   274: iconst_2
    //   275: ldc 225
    //   277: invokestatic 228	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   280: iconst_1
    //   281: invokestatic 234	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   284: areturn
    //   285: astore_1
    //   286: invokestatic 221	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   289: ifeq +13 -> 302
    //   292: ldc 223
    //   294: iconst_2
    //   295: aload_1
    //   296: invokevirtual 235	java/lang/UnsatisfiedLinkError:toString	()Ljava/lang/String;
    //   299: invokestatic 238	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   302: iconst_0
    //   303: invokestatic 234	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   306: areturn
    //   307: aload 6
    //   309: iconst_1
    //   310: putfield 191	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   313: goto -151 -> 162
    //   316: astore_1
    //   317: ldc 223
    //   319: iconst_1
    //   320: aload_1
    //   321: invokevirtual 239	java/io/IOException:toString	()Ljava/lang/String;
    //   324: invokestatic 242	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   327: goto -70 -> 257
    //   330: astore_1
    //   331: aload 5
    //   333: astore_1
    //   334: aload_1
    //   335: ifnull +7 -> 342
    //   338: aload_1
    //   339: invokevirtual 170	java/io/InputStream:close	()V
    //   342: iconst_m1
    //   343: istore_2
    //   344: goto -87 -> 257
    //   347: astore_1
    //   348: ldc 223
    //   350: iconst_1
    //   351: aload_1
    //   352: invokevirtual 243	java/lang/RuntimeException:toString	()Ljava/lang/String;
    //   355: invokestatic 242	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   358: goto -101 -> 257
    //   361: astore_1
    //   362: ldc 223
    //   364: iconst_1
    //   365: aload_1
    //   366: invokevirtual 235	java/lang/UnsatisfiedLinkError:toString	()Ljava/lang/String;
    //   369: invokestatic 242	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   372: goto -115 -> 257
    //   375: invokestatic 221	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   378: ifeq +11 -> 389
    //   381: ldc 223
    //   383: iconst_2
    //   384: ldc 245
    //   386: invokestatic 228	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   389: iconst_0
    //   390: invokestatic 234	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   393: areturn
    //   394: astore 5
    //   396: goto -62 -> 334
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	399	0	this	SwiftBrowserLongClickHandler
    //   0	399	1	paramFile	java.io.File
    //   61	283	2	i	int
    //   118	138	3	j	int
    //   124	125	4	k	int
    //   13	319	5	localObject1	java.lang.Object
    //   394	1	5	localOutOfMemoryError	java.lang.OutOfMemoryError
    //   78	230	6	localObject2	java.lang.Object
    //   69	94	7	localContentResolver	android.content.ContentResolver
    // Exception table:
    //   from	to	target	type
    //   0	15	285	java/lang/UnsatisfiedLinkError
    //   25	34	285	java/lang/UnsatisfiedLinkError
    //   62	103	316	java/io/IOException
    //   108	113	316	java/io/IOException
    //   113	132	316	java/io/IOException
    //   141	162	316	java/io/IOException
    //   162	169	316	java/io/IOException
    //   169	178	316	java/io/IOException
    //   182	186	316	java/io/IOException
    //   186	255	316	java/io/IOException
    //   307	313	316	java/io/IOException
    //   338	342	316	java/io/IOException
    //   162	169	330	java/lang/OutOfMemoryError
    //   62	103	347	java/lang/RuntimeException
    //   108	113	347	java/lang/RuntimeException
    //   113	132	347	java/lang/RuntimeException
    //   141	162	347	java/lang/RuntimeException
    //   162	169	347	java/lang/RuntimeException
    //   169	178	347	java/lang/RuntimeException
    //   182	186	347	java/lang/RuntimeException
    //   186	255	347	java/lang/RuntimeException
    //   307	313	347	java/lang/RuntimeException
    //   338	342	347	java/lang/RuntimeException
    //   62	103	361	java/lang/UnsatisfiedLinkError
    //   108	113	361	java/lang/UnsatisfiedLinkError
    //   113	132	361	java/lang/UnsatisfiedLinkError
    //   141	162	361	java/lang/UnsatisfiedLinkError
    //   162	169	361	java/lang/UnsatisfiedLinkError
    //   169	178	361	java/lang/UnsatisfiedLinkError
    //   182	186	361	java/lang/UnsatisfiedLinkError
    //   186	255	361	java/lang/UnsatisfiedLinkError
    //   307	313	361	java/lang/UnsatisfiedLinkError
    //   338	342	361	java/lang/UnsatisfiedLinkError
    //   169	178	394	java/lang/OutOfMemoryError
    //   182	186	394	java/lang/OutOfMemoryError
    //   186	255	394	java/lang/OutOfMemoryError
  }
  
  public void a(int paramInt, Bundle paramBundle)
  {
    switch (paramInt)
    {
    }
    do
    {
      return;
    } while ((this.jdField_a_of_type_ComTencentWidgetActionSheet == null) || (!this.jdField_a_of_type_ComTencentWidgetActionSheet.isShowing()));
    this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
  }
  
  /* Error */
  public void a(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: new 129	java/io/File
    //   6: dup
    //   7: aload_1
    //   8: invokespecial 254	java/io/File:<init>	(Ljava/lang/String;)V
    //   11: astore 8
    //   13: new 256	java/io/FileInputStream
    //   16: dup
    //   17: aload 8
    //   19: invokespecial 259	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   22: astore 5
    //   24: aload 5
    //   26: invokevirtual 262	java/io/InputStream:read	()I
    //   29: istore_2
    //   30: aload 5
    //   32: invokevirtual 262	java/io/InputStream:read	()I
    //   35: istore_3
    //   36: aload 5
    //   38: invokevirtual 262	java/io/InputStream:read	()I
    //   41: istore 4
    //   43: iload_2
    //   44: bipush 66
    //   46: if_icmpne +182 -> 228
    //   49: iload_3
    //   50: bipush 77
    //   52: if_icmpne +176 -> 228
    //   55: ldc_w 264
    //   58: astore_1
    //   59: aload 5
    //   61: ifnull +337 -> 398
    //   64: aload 5
    //   66: invokevirtual 170	java/io/InputStream:close	()V
    //   69: aload_1
    //   70: ifnull +294 -> 364
    //   73: aload_0
    //   74: getfield 51	com/tencent/mobileqq/webview/swift/component/SwiftBrowserLongClickHandler:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   77: invokestatic 142	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   80: invokevirtual 267	android/net/Uri:getLastPathSegment	()Ljava/lang/String;
    //   83: astore 6
    //   85: aload 6
    //   87: invokestatic 273	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   90: ifeq +212 -> 302
    //   93: ldc_w 275
    //   96: astore 5
    //   98: new 129	java/io/File
    //   101: dup
    //   102: getstatic 280	com/tencent/mobileqq/app/AppConstants:aP	Ljava/lang/String;
    //   105: invokespecial 254	java/io/File:<init>	(Ljava/lang/String;)V
    //   108: invokevirtual 283	java/io/File:mkdirs	()Z
    //   111: pop
    //   112: new 120	java/lang/StringBuilder
    //   115: dup
    //   116: invokespecial 121	java/lang/StringBuilder:<init>	()V
    //   119: getstatic 280	com/tencent/mobileqq/app/AppConstants:aP	Ljava/lang/String;
    //   122: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   125: aload 5
    //   127: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   130: aload_1
    //   131: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   134: invokevirtual 136	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   137: astore 7
    //   139: new 129	java/io/File
    //   142: dup
    //   143: aload 7
    //   145: invokespecial 254	java/io/File:<init>	(Ljava/lang/String;)V
    //   148: astore 6
    //   150: iconst_2
    //   151: istore_2
    //   152: aload 6
    //   154: invokevirtual 286	java/io/File:exists	()Z
    //   157: ifeq +179 -> 336
    //   160: iload_2
    //   161: ldc_w 287
    //   164: if_icmpge +172 -> 336
    //   167: new 120	java/lang/StringBuilder
    //   170: dup
    //   171: invokespecial 121	java/lang/StringBuilder:<init>	()V
    //   174: getstatic 280	com/tencent/mobileqq/app/AppConstants:aP	Ljava/lang/String;
    //   177: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   180: aload 5
    //   182: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   185: ldc_w 289
    //   188: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   191: iload_2
    //   192: invokevirtual 292	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   195: ldc_w 294
    //   198: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   201: aload_1
    //   202: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   205: invokevirtual 136	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   208: astore 7
    //   210: new 129	java/io/File
    //   213: dup
    //   214: aload 7
    //   216: invokespecial 254	java/io/File:<init>	(Ljava/lang/String;)V
    //   219: astore 6
    //   221: iload_2
    //   222: iconst_1
    //   223: iadd
    //   224: istore_2
    //   225: goto -73 -> 152
    //   228: iload_2
    //   229: sipush 137
    //   232: if_icmpne +169 -> 401
    //   235: iload_3
    //   236: bipush 80
    //   238: if_icmpne +163 -> 401
    //   241: ldc_w 296
    //   244: astore_1
    //   245: goto -186 -> 59
    //   248: ldc_w 298
    //   251: astore_1
    //   252: goto -193 -> 59
    //   255: astore 5
    //   257: goto -188 -> 69
    //   260: astore_1
    //   261: aconst_null
    //   262: astore 5
    //   264: aload 5
    //   266: ifnull +127 -> 393
    //   269: aload 5
    //   271: invokevirtual 170	java/io/InputStream:close	()V
    //   274: aconst_null
    //   275: astore_1
    //   276: goto -207 -> 69
    //   279: astore_1
    //   280: aconst_null
    //   281: astore_1
    //   282: goto -213 -> 69
    //   285: astore_1
    //   286: aload 6
    //   288: astore 5
    //   290: aload 5
    //   292: ifnull +8 -> 300
    //   295: aload 5
    //   297: invokevirtual 170	java/io/InputStream:close	()V
    //   300: aload_1
    //   301: athrow
    //   302: aload 6
    //   304: astore 5
    //   306: aload 6
    //   308: aload_1
    //   309: invokevirtual 304	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   312: ifeq -214 -> 98
    //   315: aload 6
    //   317: iconst_0
    //   318: aload 6
    //   320: invokevirtual 307	java/lang/String:length	()I
    //   323: aload_1
    //   324: invokevirtual 307	java/lang/String:length	()I
    //   327: isub
    //   328: invokevirtual 311	java/lang/String:substring	(II)Ljava/lang/String;
    //   331: astore 5
    //   333: goto -235 -> 98
    //   336: aload 8
    //   338: aload 6
    //   340: invokevirtual 315	java/io/File:renameTo	(Ljava/io/File;)Z
    //   343: ifeq +21 -> 364
    //   346: aload_0
    //   347: getfield 23	com/tencent/mobileqq/webview/swift/component/SwiftBrowserLongClickHandler:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   350: new 317	akoy
    //   353: dup
    //   354: aload_0
    //   355: aload 7
    //   357: invokespecial 318	akoy:<init>	(Lcom/tencent/mobileqq/webview/swift/component/SwiftBrowserLongClickHandler;Ljava/lang/String;)V
    //   360: invokevirtual 321	android/app/Activity:runOnUiThread	(Ljava/lang/Runnable;)V
    //   363: return
    //   364: aload_0
    //   365: getfield 23	com/tencent/mobileqq/webview/swift/component/SwiftBrowserLongClickHandler:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   368: new 323	akoz
    //   371: dup
    //   372: aload_0
    //   373: invokespecial 324	akoz:<init>	(Lcom/tencent/mobileqq/webview/swift/component/SwiftBrowserLongClickHandler;)V
    //   376: invokevirtual 321	android/app/Activity:runOnUiThread	(Ljava/lang/Runnable;)V
    //   379: return
    //   380: astore 5
    //   382: goto -82 -> 300
    //   385: astore_1
    //   386: goto -96 -> 290
    //   389: astore_1
    //   390: goto -126 -> 264
    //   393: aconst_null
    //   394: astore_1
    //   395: goto -326 -> 69
    //   398: goto -329 -> 69
    //   401: iload_2
    //   402: bipush 71
    //   404: if_icmpne +16 -> 420
    //   407: iload_3
    //   408: bipush 73
    //   410: if_icmpne +10 -> 420
    //   413: ldc_w 326
    //   416: astore_1
    //   417: goto -358 -> 59
    //   420: iload_2
    //   421: sipush 255
    //   424: if_icmpne +17 -> 441
    //   427: iload_3
    //   428: sipush 216
    //   431: if_icmpne +10 -> 441
    //   434: ldc_w 328
    //   437: astore_1
    //   438: goto -379 -> 59
    //   441: bipush 82
    //   443: iload_2
    //   444: if_icmpne -196 -> 248
    //   447: bipush 73
    //   449: iload_3
    //   450: if_icmpne -202 -> 248
    //   453: bipush 70
    //   455: iload 4
    //   457: if_icmpne -209 -> 248
    //   460: ldc_w 330
    //   463: astore_1
    //   464: goto -405 -> 59
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	467	0	this	SwiftBrowserLongClickHandler
    //   0	467	1	paramString	String
    //   29	416	2	i	int
    //   35	416	3	j	int
    //   41	417	4	k	int
    //   22	159	5	localObject1	java.lang.Object
    //   255	1	5	localIOException1	java.io.IOException
    //   262	70	5	localObject2	java.lang.Object
    //   380	1	5	localIOException2	java.io.IOException
    //   1	338	6	localObject3	java.lang.Object
    //   137	219	7	str	String
    //   11	326	8	localFile	java.io.File
    // Exception table:
    //   from	to	target	type
    //   64	69	255	java/io/IOException
    //   13	24	260	java/io/IOException
    //   269	274	279	java/io/IOException
    //   13	24	285	finally
    //   295	300	380	java/io/IOException
    //   24	43	385	finally
    //   24	43	389	java/io/IOException
  }
  
  public boolean a(View paramView)
  {
    if ((this.jdField_a_of_type_AndroidAppActivity == null) || (this.jdField_a_of_type_AndroidAppActivity.isFinishing())) {
      return true;
    }
    String str = "";
    IX5WebViewBase.HitTestResult localHitTestResult;
    int j;
    int i;
    if ((this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserComponentsProvider$SwiftBrowserComponentContext != null) && (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserComponentsProvider$SwiftBrowserComponentContext.a() != null))
    {
      localHitTestResult = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserComponentsProvider$SwiftBrowserComponentContext.a().getX5HitTestResult();
      if (localHitTestResult != null)
      {
        j = localHitTestResult.getType();
        if (j == 8)
        {
          paramView = str;
          i = j;
          if ((localHitTestResult.getData() instanceof IX5WebViewBase.HitTestResult.ImageAnchorData))
          {
            paramView = ((IX5WebViewBase.HitTestResult.ImageAnchorData)localHitTestResult.getData()).mPicUrl;
            i = j;
          }
        }
      }
    }
    for (;;)
    {
      if ((i != 8) && (i != 5))
      {
        QLog.e("SwiftBrowserLongClickHandler", 1, "the type of HitTestResult is not image type.");
        return false;
        paramView = localHitTestResult.getExtra();
        i = j;
        continue;
        return false;
        if ((paramView instanceof android.webkit.WebView))
        {
          paramView = ((android.webkit.WebView)paramView).getHitTestResult();
          if (paramView != null)
          {
            i = paramView.getType();
            paramView = paramView.getExtra();
            continue;
          }
          return false;
        }
      }
      else
      {
        if (TextUtils.isEmpty(paramView))
        {
          QLog.e("SwiftBrowserLongClickHandler", 1, "the image url of HitTestResult is empty.");
          return false;
        }
        if (QLog.isColorLevel()) {
          QLog.d("SwiftBrowserLongClickHandler", 2, "showActionSheet");
        }
        this.jdField_a_of_type_JavaLangString = paramView;
        if ((this.jdField_a_of_type_AndroidAppActivity instanceof TeamWorkDocEditBrowserActivity))
        {
          a();
          return true;
        }
        this.jdField_a_of_type_ComTencentWidgetActionSheet = ActionSheet.c(this.jdField_a_of_type_AndroidAppActivity);
        this.jdField_a_of_type_ComTencentWidgetActionSheet.b(2131435586);
        this.jdField_a_of_type_ComTencentWidgetActionSheet.b(2131435688);
        this.jdField_a_of_type_ComTencentWidgetActionSheet.c(2131433015);
        d(this.jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_ComTencentWidgetActionSheet.a(new akos(this));
        this.jdField_a_of_type_ComTencentWidgetActionSheet.setOnDismissListener(new akot(this));
        this.jdField_a_of_type_ComTencentWidgetActionSheet.setCanceledOnTouchOutside(true);
        try
        {
          this.jdField_a_of_type_ComTencentWidgetActionSheet.show();
          return true;
        }
        catch (Exception paramView)
        {
          for (;;)
          {
            paramView.printStackTrace();
          }
        }
      }
      i = 0;
      paramView = str;
    }
  }
  
  public void b(String paramString)
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
    ForwardBaseOption.a(this.jdField_a_of_type_AndroidAppActivity, paramString, 21);
  }
  
  public void c(String paramString)
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidAppActivity, ScannerActivity.class);
    localIntent.putExtra("PhotoConst.SINGLE_PHOTO_PATH", paramString);
    localIntent.putExtra("QRDecode", true);
    localIntent.putExtra("QRDecodeResult", paramString);
    this.jdField_a_of_type_AndroidAppActivity.startActivity(localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\aaa.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.component.SwiftBrowserLongClickHandler
 * JD-Core Version:    0.7.0.1
 */