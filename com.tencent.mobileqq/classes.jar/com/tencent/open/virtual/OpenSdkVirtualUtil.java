package com.tencent.open.virtual;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.DisplayMetrics;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.util.BitmapManager;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.open.agent.util.AuthorityUtil;
import com.tencent.open.agent.util.SSOLog;
import com.tencent.open.model.AccountInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.MD5;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.MessageDigest;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import mqq.manager.WtloginManager;
import oicq.wlogin_sdk.sharemem.WloginSimpleInfo;
import oicq.wlogin_sdk.tools.cryptor;

public class OpenSdkVirtualUtil
{
  private static Bitmap a(Bitmap paramBitmap)
  {
    if (paramBitmap == null) {
      return null;
    }
    Bitmap localBitmap = Bitmap.createBitmap(paramBitmap.getWidth(), paramBitmap.getHeight(), Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(localBitmap);
    Paint localPaint = new Paint();
    Rect localRect = new Rect(0, 0, paramBitmap.getWidth(), paramBitmap.getHeight());
    RectF localRectF = new RectF(localRect);
    localPaint.setAntiAlias(true);
    localCanvas.drawARGB(0, 0, 0, 0);
    localPaint.setColor(-65536);
    localCanvas.drawRoundRect(localRectF, 4.0F, 4.0F, localPaint);
    localPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
    localCanvas.drawBitmap(paramBitmap, localRect, localRect, localPaint);
    return localBitmap;
  }
  
  public static Bitmap a(BaseApplication paramBaseApplication, String paramString)
  {
    long l = paramBaseApplication.getSharedPreferences("ssoappicon", 0).getLong(paramString, 0L);
    if (l == 0L) {
      return null;
    }
    if (System.currentTimeMillis() / 1000L - l > 172800L) {
      return null;
    }
    paramBaseApplication = new StringBuilder();
    paramBaseApplication.append(AppConstants.SDCARD_PATH);
    paramBaseApplication.append("appicon/");
    paramBaseApplication.append(paramString);
    return BitmapManager.a(paramBaseApplication.toString());
  }
  
  public static Bitmap a(String paramString, int paramInt, boolean paramBoolean)
  {
    float f = MobileQQ.sMobileQQ.getResources().getDisplayMetrics().density;
    paramInt = (int)(paramInt * f);
    Bitmap localBitmap2 = BitmapManager.a(b(paramString));
    Bitmap localBitmap1 = localBitmap2;
    if (localBitmap2 == null) {
      localBitmap1 = BitmapManager.a(c(paramString));
    }
    if (localBitmap1 == null) {
      return null;
    }
    paramString = new Matrix();
    paramString.reset();
    f = paramInt / localBitmap1.getWidth();
    paramString.postScale(f, f);
    localBitmap1 = Bitmap.createBitmap(localBitmap1, 0, 0, localBitmap1.getWidth(), localBitmap1.getHeight(), paramString, false);
    paramString = localBitmap1;
    if (paramBoolean) {
      paramString = a(localBitmap1);
    }
    return paramString;
  }
  
  public static String a(String paramString1, String paramString2)
  {
    Object localObject = paramString1;
    if (paramString1 != null)
    {
      localObject = paramString1;
      if (paramString2 != null)
      {
        localObject = paramString1;
        if (paramString1.contains(paramString2))
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("*");
          ((StringBuilder)localObject).append(AuthorityUtil.a(paramString2));
          localObject = paramString1.replaceAll(paramString2, ((StringBuilder)localObject).toString());
        }
      }
    }
    return localObject;
  }
  
  public static String a(WtloginManager paramWtloginManager, String paramString)
  {
    if (paramWtloginManager == null) {
      return "0";
    }
    WloginSimpleInfo localWloginSimpleInfo = new WloginSimpleInfo();
    paramWtloginManager.getBasicUserInfo(paramString, localWloginSimpleInfo);
    return Long.toString(localWloginSimpleInfo._uin);
  }
  
  public static void a(BaseApplication paramBaseApplication, String paramString, Bitmap paramBitmap)
  {
    if (paramBitmap == null) {
      return;
    }
    paramBaseApplication.getSharedPreferences("ssoappicon", 0).edit().putLong(paramString, System.currentTimeMillis() / 1000L).commit();
    paramBaseApplication = new StringBuilder();
    paramBaseApplication.append(AppConstants.SDCARD_PATH);
    paramBaseApplication.append("appicon/");
    paramBaseApplication = new File(paramBaseApplication.toString());
    if (!paramBaseApplication.exists()) {
      paramBaseApplication.mkdirs();
    }
    paramBaseApplication = new File(paramBaseApplication, paramString);
    if (paramBaseApplication.exists()) {
      paramBaseApplication.delete();
    }
    try
    {
      paramBaseApplication = new FileOutputStream(paramBaseApplication);
      paramBitmap.compress(Bitmap.CompressFormat.PNG, 90, paramBaseApplication);
      paramBaseApplication.flush();
      paramBaseApplication.close();
      return;
    }
    catch (IOException paramBaseApplication)
    {
      SSOLog.a("BaseOpenSdkVirtualUtil", "IOException", paramBaseApplication);
      return;
    }
    catch (FileNotFoundException paramBaseApplication)
    {
      SSOLog.a("BaseOpenSdkVirtualUtil", "FileNotFoundException", paramBaseApplication);
    }
  }
  
  /* Error */
  public static void a(String paramString1, AccountInfo paramAccountInfo, String paramString2, com.tencent.open.agent.authority.CGICallback paramCGICallback, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 291	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: istore 8
    //   6: ldc_w 293
    //   9: astore 10
    //   11: iload 8
    //   13: ifne +1276 -> 1289
    //   16: aload_1
    //   17: ifnonnull +6 -> 23
    //   20: goto +1269 -> 1289
    //   23: iload 4
    //   25: ifeq +11 -> 36
    //   28: ldc_w 295
    //   31: astore 9
    //   33: goto +8 -> 41
    //   36: ldc_w 297
    //   39: astore 9
    //   41: aload 9
    //   43: iconst_1
    //   44: anewarray 4	java/lang/Object
    //   47: dup
    //   48: iconst_0
    //   49: aload_0
    //   50: aastore
    //   51: invokestatic 301	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   54: astore 9
    //   56: ldc_w 274
    //   59: bipush 8
    //   61: anewarray 4	java/lang/Object
    //   64: dup
    //   65: iconst_0
    //   66: ldc_w 303
    //   69: aastore
    //   70: dup
    //   71: iconst_1
    //   72: aload_0
    //   73: aastore
    //   74: dup
    //   75: iconst_2
    //   76: ldc_w 305
    //   79: aastore
    //   80: dup
    //   81: iconst_3
    //   82: aload_1
    //   83: getfield 309	com/tencent/open/model/AccountInfo:a	Ljava/lang/String;
    //   86: invokestatic 191	com/tencent/open/agent/util/AuthorityUtil:a	(Ljava/lang/String;)Ljava/lang/String;
    //   89: aastore
    //   90: dup
    //   91: iconst_4
    //   92: ldc_w 311
    //   95: aastore
    //   96: dup
    //   97: iconst_5
    //   98: iload 4
    //   100: invokestatic 317	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   103: aastore
    //   104: dup
    //   105: bipush 6
    //   107: ldc_w 319
    //   110: aastore
    //   111: dup
    //   112: bipush 7
    //   114: aload 9
    //   116: aastore
    //   117: invokestatic 322	com/tencent/open/agent/util/SSOLog:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   120: new 324	java/net/URL
    //   123: dup
    //   124: aload 9
    //   126: invokespecial 325	java/net/URL:<init>	(Ljava/lang/String;)V
    //   129: astore 11
    //   131: new 327	com/tencent/open/virtual/OpenSdkVirtualUtil$1
    //   134: dup
    //   135: aload 11
    //   137: invokespecial 330	com/tencent/open/virtual/OpenSdkVirtualUtil$1:<init>	(Ljava/net/URL;)V
    //   140: astore 9
    //   142: aload 11
    //   144: invokevirtual 334	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   147: checkcast 336	javax/net/ssl/HttpsURLConnection
    //   150: astore 12
    //   152: aload 12
    //   154: aload 9
    //   156: invokevirtual 340	javax/net/ssl/HttpsURLConnection:setHostnameVerifier	(Ljavax/net/ssl/HostnameVerifier;)V
    //   159: aload 12
    //   161: sipush 10000
    //   164: invokevirtual 343	javax/net/ssl/HttpsURLConnection:setConnectTimeout	(I)V
    //   167: aload 12
    //   169: sipush 30000
    //   172: invokevirtual 346	javax/net/ssl/HttpsURLConnection:setReadTimeout	(I)V
    //   175: aload 12
    //   177: iconst_1
    //   178: invokevirtual 349	javax/net/ssl/HttpsURLConnection:setDoOutput	(Z)V
    //   181: aload 12
    //   183: iconst_1
    //   184: invokevirtual 352	javax/net/ssl/HttpsURLConnection:setDoInput	(Z)V
    //   187: aload 12
    //   189: iconst_0
    //   190: invokevirtual 355	javax/net/ssl/HttpsURLConnection:setUseCaches	(Z)V
    //   193: aload 12
    //   195: ldc_w 357
    //   198: invokevirtual 360	javax/net/ssl/HttpsURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   201: aload 12
    //   203: ldc_w 362
    //   206: ldc_w 364
    //   209: invokevirtual 368	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   212: new 111	java/lang/StringBuilder
    //   215: dup
    //   216: ldc_w 370
    //   219: invokespecial 371	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   222: astore 9
    //   224: aload 9
    //   226: ldc_w 373
    //   229: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   232: pop
    //   233: aload 9
    //   235: getstatic 378	android/os/Build$VERSION:SDK	Ljava/lang/String;
    //   238: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   241: pop
    //   242: aload 9
    //   244: ldc_w 373
    //   247: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   250: pop
    //   251: aload 9
    //   253: getstatic 383	android/os/Build:DEVICE	Ljava/lang/String;
    //   256: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   259: pop
    //   260: aload 9
    //   262: ldc_w 373
    //   265: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   268: pop
    //   269: aload 9
    //   271: getstatic 386	android/os/Build$VERSION:RELEASE	Ljava/lang/String;
    //   274: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   277: pop
    //   278: aload 9
    //   280: ldc_w 373
    //   283: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   286: pop
    //   287: aload 9
    //   289: ldc_w 388
    //   292: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   295: pop
    //   296: aload 9
    //   298: ldc_w 373
    //   301: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   304: pop
    //   305: aload 9
    //   307: ldc_w 390
    //   310: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   313: pop
    //   314: aload 9
    //   316: ldc_w 392
    //   319: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   322: pop
    //   323: aload 12
    //   325: ldc_w 394
    //   328: aload 9
    //   330: invokevirtual 128	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   333: invokevirtual 368	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   336: aload 12
    //   338: ldc_w 396
    //   341: ldc_w 398
    //   344: invokevirtual 368	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   347: ldc_w 400
    //   350: aload_0
    //   351: invokevirtual 404	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   354: istore 4
    //   356: iload 4
    //   358: ifeq +64 -> 422
    //   361: ldc_w 406
    //   364: iconst_1
    //   365: anewarray 4	java/lang/Object
    //   368: dup
    //   369: iconst_0
    //   370: invokestatic 105	java/lang/System:currentTimeMillis	()J
    //   373: invokestatic 409	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   376: aastore
    //   377: invokestatic 301	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   380: astore_0
    //   381: new 111	java/lang/StringBuilder
    //   384: dup
    //   385: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   388: astore 9
    //   390: aload 9
    //   392: ldc_w 411
    //   395: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   398: pop
    //   399: aload 9
    //   401: aload_0
    //   402: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   405: pop
    //   406: aload 12
    //   408: ldc_w 413
    //   411: aload 9
    //   413: invokevirtual 128	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   416: invokevirtual 368	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   419: goto +14 -> 433
    //   422: aload 12
    //   424: ldc_w 413
    //   427: ldc_w 415
    //   430: invokevirtual 368	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   433: new 111	java/lang/StringBuilder
    //   436: dup
    //   437: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   440: astore_0
    //   441: aload_0
    //   442: ldc_w 417
    //   445: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   448: pop
    //   449: new 111	java/lang/StringBuilder
    //   452: dup
    //   453: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   456: astore 9
    //   458: aload 9
    //   460: ldc_w 419
    //   463: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   466: pop
    //   467: aload 9
    //   469: aload_1
    //   470: getfield 309	com/tencent/open/model/AccountInfo:a	Ljava/lang/String;
    //   473: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   476: pop
    //   477: aload_0
    //   478: aload 9
    //   480: invokevirtual 128	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   483: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   486: pop
    //   487: aload_0
    //   488: ldc_w 421
    //   491: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   494: pop
    //   495: aload_0
    //   496: ldc_w 423
    //   499: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   502: pop
    //   503: aload_0
    //   504: ldc_w 425
    //   507: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   510: pop
    //   511: aload_0
    //   512: ldc_w 421
    //   515: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   518: pop
    //   519: aload_0
    //   520: ldc_w 427
    //   523: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   526: pop
    //   527: aload_0
    //   528: aload_1
    //   529: getfield 429	com/tencent/open/model/AccountInfo:b	Ljava/lang/String;
    //   532: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   535: pop
    //   536: aload 12
    //   538: ldc_w 431
    //   541: aload_0
    //   542: invokevirtual 128	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   545: invokevirtual 368	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   548: aload 12
    //   550: invokevirtual 435	javax/net/ssl/HttpsURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   553: astore_0
    //   554: new 437	java/io/OutputStreamWriter
    //   557: dup
    //   558: aload_0
    //   559: ldc_w 439
    //   562: invokespecial 442	java/io/OutputStreamWriter:<init>	(Ljava/io/OutputStream;Ljava/lang/String;)V
    //   565: astore 9
    //   567: aload 9
    //   569: aload_2
    //   570: invokevirtual 445	java/io/OutputStreamWriter:write	(Ljava/lang/String;)V
    //   573: aload 9
    //   575: invokevirtual 446	java/io/OutputStreamWriter:flush	()V
    //   578: aload 12
    //   580: invokevirtual 449	javax/net/ssl/HttpsURLConnection:connect	()V
    //   583: aload 12
    //   585: invokevirtual 452	javax/net/ssl/HttpsURLConnection:getResponseCode	()I
    //   588: istore 5
    //   590: aload 12
    //   592: invokevirtual 455	javax/net/ssl/HttpsURLConnection:getResponseMessage	()Ljava/lang/String;
    //   595: astore_2
    //   596: aload_2
    //   597: astore 11
    //   599: iload 5
    //   601: sipush 200
    //   604: if_icmpne +250 -> 854
    //   607: new 457	java/io/BufferedInputStream
    //   610: dup
    //   611: aload 12
    //   613: invokevirtual 461	javax/net/ssl/HttpsURLConnection:getInputStream	()Ljava/io/InputStream;
    //   616: invokespecial 464	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   619: astore 13
    //   621: new 466	java/io/ByteArrayOutputStream
    //   624: dup
    //   625: invokespecial 467	java/io/ByteArrayOutputStream:<init>	()V
    //   628: astore 14
    //   630: aload 13
    //   632: invokevirtual 470	java/io/BufferedInputStream:read	()I
    //   635: istore 6
    //   637: iload 6
    //   639: iconst_m1
    //   640: if_icmpeq +21 -> 661
    //   643: aload 14
    //   645: iload 6
    //   647: i2b
    //   648: invokevirtual 472	java/io/ByteArrayOutputStream:write	(I)V
    //   651: aload 13
    //   653: invokevirtual 470	java/io/BufferedInputStream:read	()I
    //   656: istore 6
    //   658: goto -21 -> 637
    //   661: aload 14
    //   663: invokevirtual 473	java/io/ByteArrayOutputStream:toString	()Ljava/lang/String;
    //   666: astore 12
    //   668: aload 13
    //   670: invokestatic 478	com/tencent/open/agent/util/CloseableUtil:a	(Ljava/io/Closeable;)V
    //   673: aload 14
    //   675: invokestatic 478	com/tencent/open/agent/util/CloseableUtil:a	(Ljava/io/Closeable;)V
    //   678: iconst_1
    //   679: istore 7
    //   681: aload 12
    //   683: astore 10
    //   685: goto +175 -> 860
    //   688: astore_1
    //   689: aload_2
    //   690: astore 10
    //   692: iconst_1
    //   693: istore 7
    //   695: aload 12
    //   697: astore_2
    //   698: aload_0
    //   699: astore 11
    //   701: iload 5
    //   703: istore 6
    //   705: iload 7
    //   707: istore 5
    //   709: aload 10
    //   711: astore_0
    //   712: goto +529 -> 1241
    //   715: astore_1
    //   716: aload 9
    //   718: astore 10
    //   720: iconst_1
    //   721: istore 7
    //   723: aload_0
    //   724: astore 11
    //   726: iload 5
    //   728: istore 6
    //   730: iload 7
    //   732: istore 5
    //   734: aload 12
    //   736: astore 9
    //   738: aload 10
    //   740: astore_0
    //   741: goto +396 -> 1137
    //   744: astore_1
    //   745: goto +84 -> 829
    //   748: astore 11
    //   750: ldc_w 274
    //   753: ldc_w 480
    //   756: aload 11
    //   758: invokestatic 281	com/tencent/open/agent/util/SSOLog:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   761: new 111	java/lang/StringBuilder
    //   764: dup
    //   765: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   768: astore 12
    //   770: aload 12
    //   772: ldc_w 482
    //   775: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   778: pop
    //   779: aload 12
    //   781: aload 11
    //   783: invokevirtual 485	java/io/IOException:getMessage	()Ljava/lang/String;
    //   786: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   789: pop
    //   790: aload 12
    //   792: invokevirtual 128	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   795: astore 11
    //   797: aload 13
    //   799: invokestatic 478	com/tencent/open/agent/util/CloseableUtil:a	(Ljava/io/Closeable;)V
    //   802: aload 14
    //   804: invokestatic 478	com/tencent/open/agent/util/CloseableUtil:a	(Ljava/io/Closeable;)V
    //   807: goto +47 -> 854
    //   810: astore_1
    //   811: aload 11
    //   813: astore_2
    //   814: aload_0
    //   815: astore 11
    //   817: aload_2
    //   818: astore_0
    //   819: goto +280 -> 1099
    //   822: astore_1
    //   823: aload 11
    //   825: astore_2
    //   826: goto +219 -> 1045
    //   829: aload 13
    //   831: invokestatic 478	com/tencent/open/agent/util/CloseableUtil:a	(Ljava/io/Closeable;)V
    //   834: aload 14
    //   836: invokestatic 478	com/tencent/open/agent/util/CloseableUtil:a	(Ljava/io/Closeable;)V
    //   839: aload_1
    //   840: athrow
    //   841: astore_1
    //   842: aload_0
    //   843: astore 11
    //   845: aload_2
    //   846: astore_0
    //   847: goto +252 -> 1099
    //   850: astore_1
    //   851: goto +194 -> 1045
    //   854: iconst_0
    //   855: istore 7
    //   857: aload 11
    //   859: astore_2
    //   860: ldc_w 274
    //   863: bipush 6
    //   865: anewarray 4	java/lang/Object
    //   868: dup
    //   869: iconst_0
    //   870: ldc_w 487
    //   873: aastore
    //   874: dup
    //   875: iconst_1
    //   876: iload 5
    //   878: invokestatic 492	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   881: aastore
    //   882: dup
    //   883: iconst_2
    //   884: ldc_w 494
    //   887: aastore
    //   888: dup
    //   889: iconst_3
    //   890: aload 10
    //   892: aload_1
    //   893: getfield 309	com/tencent/open/model/AccountInfo:a	Ljava/lang/String;
    //   896: invokestatic 496	com/tencent/open/virtual/OpenSdkVirtualUtil:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   899: aastore
    //   900: dup
    //   901: iconst_4
    //   902: ldc_w 498
    //   905: aastore
    //   906: dup
    //   907: iconst_5
    //   908: aload_2
    //   909: aastore
    //   910: invokestatic 322	com/tencent/open/agent/util/SSOLog:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   913: aload 9
    //   915: invokestatic 478	com/tencent/open/agent/util/CloseableUtil:a	(Ljava/io/Closeable;)V
    //   918: aload_0
    //   919: invokestatic 478	com/tencent/open/agent/util/CloseableUtil:a	(Ljava/io/Closeable;)V
    //   922: aload_3
    //   923: ifnull +302 -> 1225
    //   926: iload 7
    //   928: ifeq +17 -> 945
    //   931: aload_3
    //   932: iconst_1
    //   933: aload 10
    //   935: iload 5
    //   937: aload_2
    //   938: invokeinterface 503 5 0
    //   943: pop
    //   944: return
    //   945: aload_3
    //   946: iconst_0
    //   947: aconst_null
    //   948: iload 5
    //   950: aload_2
    //   951: invokeinterface 503 5 0
    //   956: pop
    //   957: return
    //   958: astore_1
    //   959: aload 10
    //   961: astore 11
    //   963: aload_2
    //   964: astore 10
    //   966: aload 11
    //   968: astore_2
    //   969: aload_0
    //   970: astore 11
    //   972: iload 5
    //   974: istore 6
    //   976: iload 7
    //   978: istore 5
    //   980: aload 10
    //   982: astore_0
    //   983: goto +258 -> 1241
    //   986: astore_1
    //   987: aload 9
    //   989: astore 12
    //   991: aload_0
    //   992: astore 11
    //   994: iload 5
    //   996: istore 6
    //   998: iload 7
    //   1000: istore 5
    //   1002: aload 10
    //   1004: astore 9
    //   1006: aload 12
    //   1008: astore_0
    //   1009: goto +128 -> 1137
    //   1012: astore_1
    //   1013: aload_0
    //   1014: astore 11
    //   1016: aload 10
    //   1018: astore_0
    //   1019: goto +80 -> 1099
    //   1022: astore_1
    //   1023: ldc_w 293
    //   1026: astore_2
    //   1027: goto +18 -> 1045
    //   1030: astore_1
    //   1031: aload_0
    //   1032: astore 11
    //   1034: goto +59 -> 1093
    //   1037: astore_1
    //   1038: ldc_w 293
    //   1041: astore_2
    //   1042: iconst_m1
    //   1043: istore 5
    //   1045: aload 9
    //   1047: astore 12
    //   1049: iconst_0
    //   1050: istore 7
    //   1052: aload_0
    //   1053: astore 11
    //   1055: iload 5
    //   1057: istore 6
    //   1059: iload 7
    //   1061: istore 5
    //   1063: aload 10
    //   1065: astore 9
    //   1067: aload 12
    //   1069: astore_0
    //   1070: goto +67 -> 1137
    //   1073: astore_1
    //   1074: goto +13 -> 1087
    //   1077: astore_1
    //   1078: aload_0
    //   1079: astore 11
    //   1081: goto +40 -> 1121
    //   1084: astore_1
    //   1085: aconst_null
    //   1086: astore_0
    //   1087: aconst_null
    //   1088: astore 9
    //   1090: aload_0
    //   1091: astore 11
    //   1093: iconst_m1
    //   1094: istore 5
    //   1096: aload 10
    //   1098: astore_0
    //   1099: ldc_w 293
    //   1102: astore_2
    //   1103: iconst_0
    //   1104: istore 7
    //   1106: iload 5
    //   1108: istore 6
    //   1110: iload 7
    //   1112: istore 5
    //   1114: goto +127 -> 1241
    //   1117: astore_1
    //   1118: aconst_null
    //   1119: astore 11
    //   1121: ldc_w 293
    //   1124: astore_2
    //   1125: iconst_m1
    //   1126: istore 6
    //   1128: iconst_0
    //   1129: istore 5
    //   1131: aconst_null
    //   1132: astore_0
    //   1133: aload 10
    //   1135: astore 9
    //   1137: ldc_w 274
    //   1140: ldc_w 505
    //   1143: aload_1
    //   1144: invokestatic 281	com/tencent/open/agent/util/SSOLog:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1147: new 111	java/lang/StringBuilder
    //   1150: dup
    //   1151: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   1154: astore 10
    //   1156: aload 10
    //   1158: ldc_w 507
    //   1161: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1164: pop
    //   1165: aload 10
    //   1167: aload_1
    //   1168: invokevirtual 508	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1171: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1174: pop
    //   1175: aload 10
    //   1177: invokevirtual 128	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1180: astore_1
    //   1181: aload_0
    //   1182: invokestatic 478	com/tencent/open/agent/util/CloseableUtil:a	(Ljava/io/Closeable;)V
    //   1185: aload 11
    //   1187: invokestatic 478	com/tencent/open/agent/util/CloseableUtil:a	(Ljava/io/Closeable;)V
    //   1190: aload_3
    //   1191: ifnull +34 -> 1225
    //   1194: iload 5
    //   1196: ifeq +17 -> 1213
    //   1199: aload_3
    //   1200: iconst_1
    //   1201: aload 9
    //   1203: iload 6
    //   1205: aload_1
    //   1206: invokeinterface 503 5 0
    //   1211: pop
    //   1212: return
    //   1213: aload_3
    //   1214: iconst_0
    //   1215: aconst_null
    //   1216: iload 6
    //   1218: aload_1
    //   1219: invokeinterface 503 5 0
    //   1224: pop
    //   1225: return
    //   1226: astore 10
    //   1228: aload 9
    //   1230: astore_1
    //   1231: aload_0
    //   1232: astore 9
    //   1234: aload_2
    //   1235: astore_0
    //   1236: aload_1
    //   1237: astore_2
    //   1238: aload 10
    //   1240: astore_1
    //   1241: aload 9
    //   1243: invokestatic 478	com/tencent/open/agent/util/CloseableUtil:a	(Ljava/io/Closeable;)V
    //   1246: aload 11
    //   1248: invokestatic 478	com/tencent/open/agent/util/CloseableUtil:a	(Ljava/io/Closeable;)V
    //   1251: aload_3
    //   1252: ifnull +35 -> 1287
    //   1255: iload 5
    //   1257: ifeq +18 -> 1275
    //   1260: aload_3
    //   1261: iconst_1
    //   1262: aload_2
    //   1263: iload 6
    //   1265: aload_0
    //   1266: invokeinterface 503 5 0
    //   1271: pop
    //   1272: goto +15 -> 1287
    //   1275: aload_3
    //   1276: iconst_0
    //   1277: aconst_null
    //   1278: iload 6
    //   1280: aload_0
    //   1281: invokeinterface 503 5 0
    //   1286: pop
    //   1287: aload_1
    //   1288: athrow
    //   1289: ldc_w 274
    //   1292: iconst_4
    //   1293: anewarray 4	java/lang/Object
    //   1296: dup
    //   1297: iconst_0
    //   1298: ldc_w 510
    //   1301: aastore
    //   1302: dup
    //   1303: iconst_1
    //   1304: aload_0
    //   1305: aastore
    //   1306: dup
    //   1307: iconst_2
    //   1308: ldc_w 512
    //   1311: aastore
    //   1312: dup
    //   1313: iconst_3
    //   1314: iload 4
    //   1316: invokestatic 317	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1319: aastore
    //   1320: invokestatic 322	com/tencent/open/agent/util/SSOLog:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   1323: aload_3
    //   1324: ifnull +18 -> 1342
    //   1327: aload_3
    //   1328: iconst_0
    //   1329: ldc_w 293
    //   1332: iconst_m1
    //   1333: ldc_w 514
    //   1336: invokeinterface 503 5 0
    //   1341: pop
    //   1342: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1343	0	paramString1	String
    //   0	1343	1	paramAccountInfo	AccountInfo
    //   0	1343	2	paramString2	String
    //   0	1343	3	paramCGICallback	com.tencent.open.agent.authority.CGICallback
    //   0	1343	4	paramBoolean	boolean
    //   588	668	5	i	int
    //   635	644	6	j	int
    //   679	432	7	k	int
    //   4	8	8	bool	boolean
    //   31	1211	9	localObject1	Object
    //   9	1167	10	localObject2	Object
    //   1226	13	10	localObject3	Object
    //   129	596	11	localObject4	Object
    //   748	34	11	localIOException	IOException
    //   795	452	11	localObject5	Object
    //   150	918	12	localObject6	Object
    //   619	211	13	localBufferedInputStream	java.io.BufferedInputStream
    //   628	207	14	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    // Exception table:
    //   from	to	target	type
    //   668	678	688	finally
    //   668	678	715	java/lang/Exception
    //   630	637	744	finally
    //   643	658	744	finally
    //   661	668	744	finally
    //   750	797	744	finally
    //   630	637	748	java/io/IOException
    //   643	658	748	java/io/IOException
    //   661	668	748	java/io/IOException
    //   797	807	810	finally
    //   797	807	822	java/lang/Exception
    //   607	630	841	finally
    //   829	841	841	finally
    //   607	630	850	java/lang/Exception
    //   829	841	850	java/lang/Exception
    //   860	913	958	finally
    //   860	913	986	java/lang/Exception
    //   590	596	1012	finally
    //   590	596	1022	java/lang/Exception
    //   567	590	1030	finally
    //   567	590	1037	java/lang/Exception
    //   554	567	1073	finally
    //   554	567	1077	java/lang/Exception
    //   120	356	1084	finally
    //   361	419	1084	finally
    //   422	433	1084	finally
    //   433	554	1084	finally
    //   120	356	1117	java/lang/Exception
    //   361	419	1117	java/lang/Exception
    //   422	433	1117	java/lang/Exception
    //   433	554	1117	java/lang/Exception
    //   1137	1181	1226	finally
  }
  
  public static void a(NewIntent paramNewIntent)
  {
    paramNewIntent.putExtra("timeout", 11000L);
    paramNewIntent.putExtra("strategy", 0);
  }
  
  public static byte[] a(byte[] paramArrayOfByte, AccountInfo paramAccountInfo)
  {
    paramAccountInfo = paramAccountInfo.d;
    return cryptor.decrypt(paramArrayOfByte, 0, paramArrayOfByte.length, paramAccountInfo);
  }
  
  public static String[] a(String paramString)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(System.currentTimeMillis() / 1000L);
    String str1 = "";
    ((StringBuilder)localObject1).append("");
    String str3 = ((StringBuilder)localObject1).toString();
    String[] arrayOfString = new String[3];
    arrayOfString[0] = "";
    arrayOfString[1] = "";
    arrayOfString[2] = "";
    localObject1 = MobileQQ.sMobileQQ.getPackageManager();
    try
    {
      localObject1 = ((PackageManager)localObject1).getPackageInfo(paramString, 64).signatures;
      MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
      localMessageDigest.update(localObject1[0].toByteArray());
      Object localObject2 = HexUtil.bytes2HexStr(localMessageDigest.digest()).toLowerCase();
      localObject1 = str1;
      try
      {
        localMessageDigest.reset();
        localObject1 = str1;
        StringBuilder localStringBuilder = new StringBuilder();
        localObject1 = str1;
        localStringBuilder.append(paramString);
        localObject1 = str1;
        localStringBuilder.append("_");
        localObject1 = str1;
        localStringBuilder.append((String)localObject2);
        localObject1 = str1;
        localStringBuilder.append("_");
        localObject1 = str1;
        localStringBuilder.append(str3);
        localObject1 = str1;
        localStringBuilder.append("");
        localObject1 = str1;
        localMessageDigest.update(localStringBuilder.toString().getBytes());
        localObject1 = str1;
        paramString = HexUtil.bytes2HexStr(localMessageDigest.digest());
        localObject1 = paramString;
        SSOLog.a("BaseOpenSdkVirtualUtil", new Object[] { "getAuthorizeSign.success" });
      }
      catch (Exception localException1)
      {
        paramString = (String)localObject2;
        localObject2 = localException1;
      }
      SSOLog.a("BaseOpenSdkVirtualUtil", "getAuthorizeSign.e:", localException2);
    }
    catch (Exception localException2)
    {
      paramString = "";
      localObject1 = localException1;
    }
    String str2 = paramString;
    paramString = (String)localObject1;
    arrayOfString[0] = str2;
    arrayOfString[1] = paramString;
    arrayOfString[2] = str3;
    return arrayOfString;
  }
  
  public static String b(String paramString)
  {
    Object localObject = MD5.toMD5(paramString);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject);
    localStringBuilder.append(paramString);
    localObject = MD5.toMD5(localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject);
    localStringBuilder.append(paramString);
    paramString = MD5.toMD5(localStringBuilder.toString());
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(AppConstants.PATH_SSO_HEAD_HD);
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(".png");
    return ((StringBuilder)localObject).toString();
  }
  
  public static byte[] b(byte[] paramArrayOfByte, AccountInfo paramAccountInfo)
  {
    byte[] arrayOfByte1 = paramAccountInfo.c;
    paramAccountInfo = paramAccountInfo.d;
    paramArrayOfByte = cryptor.encrypt(paramArrayOfByte, 0, paramArrayOfByte.length, paramAccountInfo);
    paramAccountInfo = new byte[arrayOfByte1.length + 4 + paramArrayOfByte.length];
    byte[] arrayOfByte2 = new byte[4];
    arrayOfByte2[0] = ((byte)(arrayOfByte1.length >> 24));
    arrayOfByte2[1] = ((byte)(arrayOfByte1.length >> 16));
    arrayOfByte2[2] = ((byte)(arrayOfByte1.length >> 8));
    arrayOfByte2[3] = ((byte)arrayOfByte1.length);
    System.arraycopy(arrayOfByte2, 0, paramAccountInfo, 0, arrayOfByte2.length);
    System.arraycopy(arrayOfByte1, 0, paramAccountInfo, arrayOfByte2.length, arrayOfByte1.length);
    System.arraycopy(paramArrayOfByte, 0, paramAccountInfo, arrayOfByte2.length + arrayOfByte1.length, paramArrayOfByte.length);
    return paramAccountInfo;
  }
  
  private static String c(String paramString)
  {
    Object localObject = MD5.toMD5(paramString);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject);
    localStringBuilder.append(paramString);
    localObject = MD5.toMD5(localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject);
    localStringBuilder.append(paramString);
    paramString = MD5.toMD5(localStringBuilder.toString());
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(AppConstants.PATH_HEAD_HD);
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(".png");
    return ((StringBuilder)localObject).toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.virtual.OpenSdkVirtualUtil
 * JD-Core Version:    0.7.0.1
 */