package com.tencent.mobileqq.camera.utils;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.hardware.Camera;
import android.hardware.Camera.CameraInfo;
import android.os.Build.VERSION;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.camera.CameraHolder;
import com.tencent.mobileqq.camera.adapter.CameraWrapper;
import com.tencent.mobileqq.camera.adapter.DeviceInstance;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.zip.InflaterInputStream;

@TargetApi(9)
public class CameraUtils
{
  public static boolean a;
  public static boolean b = true;
  
  public static int a(Context paramContext)
  {
    return a(paramContext).getInt("qcamera_conf_version", 0);
  }
  
  public static int a(CameraHolder paramCameraHolder, int paramInt1, int paramInt2)
  {
    int i = paramInt2;
    if (paramInt2 == -1) {
      i = 0;
    }
    Camera.CameraInfo localCameraInfo = paramCameraHolder.a()[paramInt1];
    if (localCameraInfo.facing == 1) {
      return (paramCameraHolder.a().a(paramInt1, localCameraInfo.orientation) - i + 360) % 360;
    }
    return (paramCameraHolder.a().a(paramInt1, localCameraInfo.orientation) + i) % 360;
  }
  
  public static SharedPreferences a(Context paramContext)
  {
    return paramContext.getSharedPreferences("qcamera_pref", 4);
  }
  
  public static Bitmap a(Bitmap paramBitmap)
  {
    int i = paramBitmap.getHeight();
    int j = paramBitmap.getWidth();
    if (QLog.isColorLevel()) {
      QLog.i("Q.camera.CameraUtils", 4, "clipBitmapToScreenRatio bmpWidth=" + j + " bmpHeight=" + i + " screenWidth=" + ScreenUtil.a + " screenHeight=" + ScreenUtil.b);
    }
    if (i < j) {
      return paramBitmap;
    }
    double d = ScreenUtil.b * 1.0D / ScreenUtil.a;
    if (d > i * 1.0D / j)
    {
      k = (int)(i / d);
      if (QLog.isColorLevel()) {
        QLog.i("Q.camera.CameraUtils", 4, "clipBitmapToScreenRatio targetWidth=" + k + " bmpWidth=" + j);
      }
      return Bitmap.createBitmap(paramBitmap, 0, 0, k, i);
    }
    int k = (int)(d * j);
    if (QLog.isColorLevel()) {
      QLog.i("Q.camera.CameraUtils", 4, "clipBitmapToScreenRatio targetHeight=" + k + " bmpHeight=" + i);
    }
    return Bitmap.createBitmap(paramBitmap, 0, 0, j, k);
  }
  
  public static Bitmap a(Bitmap paramBitmap, int paramInt, boolean paramBoolean)
  {
    System.currentTimeMillis();
    if ((paramBitmap != null) && (!paramBitmap.isRecycled()))
    {
      if ((paramInt == 0) || (paramInt == 360)) {
        return paramBitmap;
      }
      Object localObject1 = new Matrix();
      ((Matrix)localObject1).setRotate(paramInt, paramBitmap.getWidth() / 2.0F, paramBitmap.getHeight() / 2.0F);
      try
      {
        localObject1 = Bitmap.createBitmap(paramBitmap, 0, 0, paramBitmap.getWidth(), paramBitmap.getHeight(), (Matrix)localObject1, true);
        if ((paramBoolean) && (paramBitmap != localObject1)) {}
        localOutOfMemoryError1.printStackTrace();
      }
      catch (OutOfMemoryError localOutOfMemoryError1)
      {
        try
        {
          a(paramBitmap);
          return localObject1;
        }
        catch (OutOfMemoryError localOutOfMemoryError2)
        {
          for (;;)
          {
            paramBitmap = localOutOfMemoryError1;
            Object localObject2 = localOutOfMemoryError2;
          }
        }
        localOutOfMemoryError1 = localOutOfMemoryError1;
        paramBitmap = null;
      }
      QLog.w("Q.camera.CameraUtils", 2, "OutOfMemoryError. ", localOutOfMemoryError1);
      return paramBitmap;
    }
    return null;
  }
  
  @TargetApi(10)
  public static Bitmap a(byte[] paramArrayOfByte, Rect paramRect, boolean paramBoolean, int paramInt)
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    localOptions.inSampleSize = 1;
    BitmapFactory.decodeByteArray(paramArrayOfByte, 0, paramArrayOfByte.length, localOptions);
    int i = localOptions.outHeight;
    int j = localOptions.outWidth;
    double d4;
    double d5;
    double d1;
    double d2;
    double d3;
    if (j > i)
    {
      paramInt = 1;
      d4 = 1.0D * Math.max(i, j) / Math.min(i, j);
      d5 = 1.0D * paramRect.height() / paramRect.width();
      d1 = j;
      d2 = i;
      if (d4 <= d5) {
        break label337;
      }
      if (paramInt == 0) {
        break label319;
      }
      d3 = d5 * d2;
      d1 = d2;
      d2 = d3;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.camera.CameraUtils", 2, "clipJpegToBitmap tw=" + d2 + " th=" + d1 + " bw=" + j + " bh=" + i + " br=" + d4 + " sr=" + d5);
      }
      localOptions.inJustDecodeBounds = false;
      d3 = (j - d2) / 2.0D;
      d4 = (j + d2) / 2.0D;
      d5 = (i - d1) / 2.0D;
      double d6 = (i + d1) / 2.0D;
      if (Build.VERSION.SDK_INT >= 10)
      {
        paramRect = new Rect((int)d3, (int)d5, (int)d4, (int)d6);
        paramArrayOfByte = BitmapRegionDecoder.newInstance(paramArrayOfByte, 0, paramArrayOfByte.length, true);
        paramRect = paramArrayOfByte.decodeRegion(paramRect, localOptions);
        paramArrayOfByte.recycle();
        return paramRect;
        paramInt = 0;
        break;
        label319:
        d3 = d5 * d1;
        d2 = d1;
        d1 = d3;
        continue;
        label337:
        if (d4 >= d5) {
          break label451;
        }
        if (paramInt != 0)
        {
          d3 = 1.0D / d5 * d1;
          d2 = d1;
          d1 = d3;
          continue;
        }
        d3 = 1.0D / d5 * d2;
        d1 = d2;
        d2 = d3;
        continue;
      }
      try
      {
        localOptions.inSampleSize = 2;
        paramArrayOfByte = BitmapFactory.decodeByteArray(paramArrayOfByte, 0, paramArrayOfByte.length, localOptions);
        paramRect = Bitmap.createBitmap(paramArrayOfByte, (int)(d3 / 2.0D), (int)(d5 / 2.0D), (int)(d2 / 2.0D), (int)(d1 / 2.0D));
        paramArrayOfByte.recycle();
        return paramRect;
      }
      catch (OutOfMemoryError paramArrayOfByte)
      {
        paramArrayOfByte.printStackTrace();
        throw paramArrayOfByte;
      }
      label451:
      d3 = d1;
      d1 = d2;
      d2 = d3;
    }
  }
  
  public static void a(Context paramContext, int paramInt)
  {
    a(paramContext).edit().putInt("qcamera_conf_version", paramInt).commit();
  }
  
  public static void a(Context paramContext, boolean paramBoolean)
  {
    a(paramContext).edit().putBoolean("disableCameraSDK", paramBoolean);
  }
  
  public static void a(Matrix paramMatrix, boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    paramMatrix.reset();
    int i;
    if (paramInt2 < paramInt3)
    {
      i = 1;
      if (i != 0) {
        paramInt2 = paramInt3 * paramInt5 / paramInt4;
      }
      if (!paramBoolean) {
        break label89;
      }
    }
    label89:
    for (float f = -1.0F;; f = 1.0F)
    {
      paramMatrix.setScale(f, 1.0F);
      paramMatrix.postRotate(paramInt1);
      paramMatrix.postScale(paramInt2 / 2000.0F, paramInt3 / 2000.0F);
      paramMatrix.postTranslate(paramInt2 / 2.0F, paramInt3 / 2.0F);
      return;
      i = 0;
      break;
    }
  }
  
  public static boolean a()
  {
    int i = 2;
    Object localObject;
    boolean bool1;
    if (b)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.camera.CameraUtils", 2, "[isChoiceQCamera] + ENTER");
      }
      localObject = DeviceInstance.a().a();
      String str = DeviceInstance.a().b();
      QLog.i("Q.camera.CameraUtils", 1, "My Phone: " + (String)localObject + ",  Model: " + str);
      bool1 = CameraWrapper.a().c();
      boolean bool2 = b();
      if ((!bool1) && (bool2)) {
        break label277;
      }
      if (QLog.isColorLevel()) {
        QLog.i("Q.camera.CameraUtils", 2, "[isChoiceQCamera] enter system camera 0, qcameraDisabled=" + bool1 + " sysVerSupported=" + bool2);
      }
      if (bool1) {
        i = 1;
      }
      bool1 = false;
    }
    for (;;)
    {
      localObject = new HashMap();
      ((HashMap)localObject).put("param_FailCode", String.valueOf(i));
      ((HashMap)localObject).put(BaseConstants.RDM_NoChangeFailCode, "");
      StatisticCollector.a(BaseApplication.getContext()).a(null, "qcamera_choice_type", false, 0L, 0L, (HashMap)localObject, "");
      QLog.i("Q.camera.CameraUtils", 1, "[isChoiceQCamera] choice self qcamera: " + bool1 + " choiceResult: " + i);
      a = bool1;
      b = false;
      if (QLog.isColorLevel()) {
        QLog.i("Q.camera.CameraUtils", 1, "[isChoiceQCamera] choice self qcamera final: " + a);
      }
      return a;
      label277:
      if (CameraWrapper.a().a())
      {
        if (QLog.isColorLevel()) {
          QLog.i("Q.camera.CameraUtils", 2, "[isChoiceQCamera] enter system camera 1");
        }
        bool1 = false;
        i = 3;
      }
      else if (d())
      {
        bool1 = true;
        i = 10;
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.i("Q.camera.CameraUtils", 2, "[isChoiceQCamera] enter system camera 3");
        }
        bool1 = false;
        i = 4;
      }
    }
  }
  
  public static boolean a(Context paramContext)
  {
    return a(paramContext).getBoolean("disableCameraSDK", true);
  }
  
  public static boolean a(Context paramContext, String paramString, int paramInt)
  {
    a(a(paramContext), paramString, paramInt);
    CameraWrapper.a().a();
    b = true;
    return true;
  }
  
  /* Error */
  private static boolean a(SharedPreferences paramSharedPreferences, String paramString, int paramInt)
  {
    // Byte code:
    //   0: ldc 79
    //   2: iconst_4
    //   3: ldc_w 379
    //   6: invokestatic 111	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   9: aload_1
    //   10: invokestatic 385	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   13: ifeq +14 -> 27
    //   16: ldc 79
    //   18: iconst_4
    //   19: ldc_w 387
    //   22: invokestatic 390	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   25: iconst_0
    //   26: ireturn
    //   27: iconst_0
    //   28: invokestatic 395	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   31: astore 6
    //   33: aload 6
    //   35: astore 5
    //   37: invokestatic 400	org/xmlpull/v1/XmlPullParserFactory:newInstance	()Lorg/xmlpull/v1/XmlPullParserFactory;
    //   40: invokevirtual 404	org/xmlpull/v1/XmlPullParserFactory:newPullParser	()Lorg/xmlpull/v1/XmlPullParser;
    //   43: astore 7
    //   45: aload 6
    //   47: astore 5
    //   49: aload 7
    //   51: new 406	java/io/StringReader
    //   54: dup
    //   55: aload_1
    //   56: invokespecial 409	java/io/StringReader:<init>	(Ljava/lang/String;)V
    //   59: invokeinterface 415 2 0
    //   64: aload 6
    //   66: astore 5
    //   68: aload 7
    //   70: invokeinterface 418 1 0
    //   75: istore_3
    //   76: aload 6
    //   78: astore 5
    //   80: aload_0
    //   81: invokeinterface 239 1 0
    //   86: astore 8
    //   88: aload 6
    //   90: astore 5
    //   92: aload 8
    //   94: invokeinterface 421 1 0
    //   99: pop
    //   100: aload 6
    //   102: astore 5
    //   104: aload 8
    //   106: ldc 24
    //   108: iload_2
    //   109: invokeinterface 245 3 0
    //   114: pop
    //   115: aload 6
    //   117: astore 5
    //   119: invokestatic 283	com/tencent/mobileqq/camera/adapter/DeviceInstance:a	()Lcom/tencent/mobileqq/camera/adapter/DeviceInstance;
    //   122: invokevirtual 285	com/tencent/mobileqq/camera/adapter/DeviceInstance:a	()Ljava/lang/String;
    //   125: astore 9
    //   127: aload 6
    //   129: astore 5
    //   131: new 81	java/lang/StringBuilder
    //   134: dup
    //   135: invokespecial 82	java/lang/StringBuilder:<init>	()V
    //   138: aload 9
    //   140: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   143: ldc_w 423
    //   146: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   149: getstatic 428	android/os/Build:DISPLAY	Ljava/lang/String;
    //   152: ldc_w 430
    //   155: ldc_w 423
    //   158: invokevirtual 434	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   161: invokevirtual 437	java/lang/String:toUpperCase	()Ljava/lang/String;
    //   164: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   167: invokevirtual 107	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   170: astore 10
    //   172: aload 6
    //   174: astore 5
    //   176: invokestatic 77	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   179: ifeq +765 -> 944
    //   182: aload 6
    //   184: astore 5
    //   186: ldc 79
    //   188: iconst_4
    //   189: new 81	java/lang/StringBuilder
    //   192: dup
    //   193: invokespecial 82	java/lang/StringBuilder:<init>	()V
    //   196: ldc_w 439
    //   199: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   202: aload 9
    //   204: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   207: ldc_w 441
    //   210: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   213: aload 10
    //   215: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   218: invokevirtual 107	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   221: invokestatic 111	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   224: goto +720 -> 944
    //   227: aload_0
    //   228: astore 5
    //   230: aload 7
    //   232: invokeinterface 444 1 0
    //   237: istore_2
    //   238: goto +714 -> 952
    //   241: goto -14 -> 227
    //   244: aload 7
    //   246: invokeinterface 447 1 0
    //   251: astore_1
    //   252: invokestatic 77	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   255: ifeq +29 -> 284
    //   258: ldc 79
    //   260: iconst_4
    //   261: new 81	java/lang/StringBuilder
    //   264: dup
    //   265: invokespecial 82	java/lang/StringBuilder:<init>	()V
    //   268: ldc_w 449
    //   271: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   274: aload_1
    //   275: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   278: invokevirtual 107	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   281: invokestatic 451	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   284: aload_1
    //   285: aload 9
    //   287: invokevirtual 455	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   290: ifeq +341 -> 631
    //   293: invokestatic 77	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   296: ifeq +51 -> 347
    //   299: ldc 79
    //   301: iconst_4
    //   302: new 81	java/lang/StringBuilder
    //   305: dup
    //   306: invokespecial 82	java/lang/StringBuilder:<init>	()V
    //   309: ldc_w 449
    //   312: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   315: aload_1
    //   316: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   319: ldc_w 457
    //   322: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   325: aload 9
    //   327: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   330: ldc_w 441
    //   333: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   336: aload 10
    //   338: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   341: invokevirtual 107	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   344: invokestatic 451	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   347: aload 7
    //   349: invokeinterface 460 1 0
    //   354: istore_3
    //   355: iconst_0
    //   356: istore_2
    //   357: iload_2
    //   358: iload_3
    //   359: if_icmpge +262 -> 621
    //   362: aload 7
    //   364: iload_2
    //   365: invokeinterface 463 2 0
    //   370: astore_1
    //   371: aload 7
    //   373: iload_2
    //   374: invokeinterface 466 2 0
    //   379: astore 5
    //   381: aload_1
    //   382: ldc 251
    //   384: invokevirtual 455	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   387: ifeq +74 -> 461
    //   390: aload 5
    //   392: invokestatic 469	java/lang/Boolean:parseBoolean	(Ljava/lang/String;)Z
    //   395: invokestatic 395	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   398: invokevirtual 472	java/lang/Boolean:booleanValue	()Z
    //   401: istore 4
    //   403: invokestatic 77	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   406: ifeq +585 -> 991
    //   409: ldc 79
    //   411: iconst_4
    //   412: new 81	java/lang/StringBuilder
    //   415: dup
    //   416: invokespecial 82	java/lang/StringBuilder:<init>	()V
    //   419: ldc_w 474
    //   422: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   425: iload_2
    //   426: iconst_1
    //   427: iadd
    //   428: invokevirtual 91	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   431: ldc_w 476
    //   434: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   437: aload_1
    //   438: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   441: ldc_w 478
    //   444: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   447: aload 5
    //   449: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   452: invokevirtual 107	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   455: invokestatic 111	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   458: goto +533 -> 991
    //   461: aload_1
    //   462: ldc_w 480
    //   465: invokevirtual 483	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   468: ifeq +40 -> 508
    //   471: aload 8
    //   473: aload_1
    //   474: aload 5
    //   476: invokestatic 489	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   479: invokestatic 492	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   482: invokevirtual 495	java/lang/Integer:intValue	()I
    //   485: invokeinterface 245 3 0
    //   490: pop
    //   491: goto -88 -> 403
    //   494: astore_0
    //   495: ldc 79
    //   497: iconst_1
    //   498: aload_0
    //   499: iconst_0
    //   500: anewarray 4	java/lang/Object
    //   503: invokestatic 498	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   506: aload_0
    //   507: athrow
    //   508: aload_1
    //   509: ldc_w 500
    //   512: invokevirtual 483	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   515: ifeq +34 -> 549
    //   518: aload 8
    //   520: aload_1
    //   521: aload 5
    //   523: invokestatic 503	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   526: invokeinterface 507 3 0
    //   531: pop
    //   532: goto -129 -> 403
    //   535: astore_0
    //   536: ldc 79
    //   538: iconst_1
    //   539: aload_0
    //   540: iconst_0
    //   541: anewarray 4	java/lang/Object
    //   544: invokestatic 498	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   547: aload_0
    //   548: athrow
    //   549: aload 8
    //   551: aload_1
    //   552: aload 5
    //   554: invokestatic 469	java/lang/Boolean:parseBoolean	(Ljava/lang/String;)Z
    //   557: invokestatic 395	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   560: invokevirtual 472	java/lang/Boolean:booleanValue	()Z
    //   563: invokeinterface 255 3 0
    //   568: pop
    //   569: goto -166 -> 403
    //   572: astore_1
    //   573: ldc 79
    //   575: iconst_1
    //   576: aload_1
    //   577: iconst_0
    //   578: anewarray 4	java/lang/Object
    //   581: invokestatic 498	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   584: invokestatic 77	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   587: ifeq +29 -> 616
    //   590: ldc 79
    //   592: iconst_4
    //   593: new 81	java/lang/StringBuilder
    //   596: dup
    //   597: invokespecial 82	java/lang/StringBuilder:<init>	()V
    //   600: ldc_w 509
    //   603: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   606: aload_0
    //   607: invokevirtual 512	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   610: invokevirtual 107	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   613: invokestatic 111	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   616: aload_0
    //   617: invokevirtual 472	java/lang/Boolean:booleanValue	()Z
    //   620: ireturn
    //   621: iconst_1
    //   622: invokestatic 395	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   625: astore_1
    //   626: aload_1
    //   627: astore_0
    //   628: goto -401 -> 227
    //   631: ldc_w 514
    //   634: aload_1
    //   635: invokevirtual 455	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   638: ifeq +350 -> 988
    //   641: aload 7
    //   643: invokeinterface 460 1 0
    //   648: istore_3
    //   649: iconst_0
    //   650: istore_2
    //   651: iload_2
    //   652: iload_3
    //   653: if_icmpge +352 -> 1005
    //   656: aload 7
    //   658: iload_2
    //   659: invokeinterface 463 2 0
    //   664: astore_1
    //   665: aload 7
    //   667: iload_2
    //   668: invokeinterface 466 2 0
    //   673: astore 5
    //   675: aload_1
    //   676: ldc 251
    //   678: invokevirtual 455	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   681: ifeq +74 -> 755
    //   684: aload 5
    //   686: invokestatic 469	java/lang/Boolean:parseBoolean	(Ljava/lang/String;)Z
    //   689: invokestatic 395	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   692: invokevirtual 472	java/lang/Boolean:booleanValue	()Z
    //   695: istore 4
    //   697: invokestatic 77	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   700: ifeq +298 -> 998
    //   703: ldc 79
    //   705: iconst_4
    //   706: new 81	java/lang/StringBuilder
    //   709: dup
    //   710: invokespecial 82	java/lang/StringBuilder:<init>	()V
    //   713: ldc_w 516
    //   716: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   719: iload_2
    //   720: iconst_1
    //   721: iadd
    //   722: invokevirtual 91	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   725: ldc_w 476
    //   728: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   731: aload_1
    //   732: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   735: ldc_w 478
    //   738: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   741: aload 5
    //   743: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   746: invokevirtual 107	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   749: invokestatic 111	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   752: goto +246 -> 998
    //   755: aload_1
    //   756: ldc_w 480
    //   759: invokevirtual 483	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   762: ifeq +26 -> 788
    //   765: aload 8
    //   767: aload_1
    //   768: aload 5
    //   770: invokestatic 489	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   773: invokestatic 492	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   776: invokevirtual 495	java/lang/Integer:intValue	()I
    //   779: invokeinterface 245 3 0
    //   784: pop
    //   785: goto -88 -> 697
    //   788: aload_1
    //   789: ldc_w 500
    //   792: invokevirtual 483	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   795: ifeq +20 -> 815
    //   798: aload 8
    //   800: aload_1
    //   801: aload 5
    //   803: invokestatic 503	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   806: invokeinterface 507 3 0
    //   811: pop
    //   812: goto -115 -> 697
    //   815: aload 8
    //   817: aload_1
    //   818: aload 5
    //   820: invokestatic 469	java/lang/Boolean:parseBoolean	(Ljava/lang/String;)Z
    //   823: invokestatic 395	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   826: invokevirtual 472	java/lang/Boolean:booleanValue	()Z
    //   829: invokeinterface 255 3 0
    //   834: pop
    //   835: goto -138 -> 697
    //   838: aload_0
    //   839: invokevirtual 472	java/lang/Boolean:booleanValue	()Z
    //   842: ifeq +53 -> 895
    //   845: aload 8
    //   847: ldc 251
    //   849: iload 4
    //   851: invokeinterface 255 3 0
    //   856: pop
    //   857: ldc 79
    //   859: iconst_1
    //   860: new 81	java/lang/StringBuilder
    //   863: dup
    //   864: invokespecial 82	java/lang/StringBuilder:<init>	()V
    //   867: ldc_w 518
    //   870: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   873: iload 4
    //   875: invokevirtual 302	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   878: invokevirtual 107	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   881: invokestatic 111	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   884: aload 8
    //   886: invokeinterface 248 1 0
    //   891: pop
    //   892: goto -308 -> 584
    //   895: aload 8
    //   897: ldc 251
    //   899: iload 4
    //   901: invokeinterface 255 3 0
    //   906: pop
    //   907: ldc 79
    //   909: iconst_1
    //   910: new 81	java/lang/StringBuilder
    //   913: dup
    //   914: invokespecial 82	java/lang/StringBuilder:<init>	()V
    //   917: ldc_w 520
    //   920: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   923: iload 4
    //   925: invokevirtual 302	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   928: invokevirtual 107	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   931: invokestatic 111	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   934: goto -50 -> 884
    //   937: astore_1
    //   938: aload 5
    //   940: astore_0
    //   941: goto -368 -> 573
    //   944: aload 6
    //   946: astore_0
    //   947: iconst_0
    //   948: istore 4
    //   950: iload_3
    //   951: istore_2
    //   952: iload_2
    //   953: iconst_1
    //   954: if_icmpeq -116 -> 838
    //   957: iload_2
    //   958: tableswitch	default:+30 -> 988, 0:+-717->241, 1:+30->988, 2:+-714->244, 3:+50->1008
    //   989: <illegal opcode>
    //   990: iconst_4
    //   991: iload_2
    //   992: iconst_1
    //   993: iadd
    //   994: istore_2
    //   995: goto -638 -> 357
    //   998: iload_2
    //   999: iconst_1
    //   1000: iadd
    //   1001: istore_2
    //   1002: goto -351 -> 651
    //   1005: goto -778 -> 227
    //   1008: goto -781 -> 227
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1011	0	paramSharedPreferences	SharedPreferences
    //   0	1011	1	paramString	String
    //   0	1011	2	paramInt	int
    //   75	876	3	i	int
    //   401	548	4	bool	boolean
    //   35	904	5	localObject	Object
    //   31	914	6	localBoolean	java.lang.Boolean
    //   43	623	7	localXmlPullParser	org.xmlpull.v1.XmlPullParser
    //   86	810	8	localEditor	SharedPreferences.Editor
    //   125	201	9	str1	String
    //   170	167	10	str2	String
    // Exception table:
    //   from	to	target	type
    //   37	45	494	org/xmlpull/v1/XmlPullParserException
    //   49	64	494	org/xmlpull/v1/XmlPullParserException
    //   68	76	494	org/xmlpull/v1/XmlPullParserException
    //   80	88	494	org/xmlpull/v1/XmlPullParserException
    //   92	100	494	org/xmlpull/v1/XmlPullParserException
    //   104	115	494	org/xmlpull/v1/XmlPullParserException
    //   119	127	494	org/xmlpull/v1/XmlPullParserException
    //   131	172	494	org/xmlpull/v1/XmlPullParserException
    //   176	182	494	org/xmlpull/v1/XmlPullParserException
    //   186	224	494	org/xmlpull/v1/XmlPullParserException
    //   230	238	494	org/xmlpull/v1/XmlPullParserException
    //   244	284	494	org/xmlpull/v1/XmlPullParserException
    //   284	347	494	org/xmlpull/v1/XmlPullParserException
    //   347	355	494	org/xmlpull/v1/XmlPullParserException
    //   362	403	494	org/xmlpull/v1/XmlPullParserException
    //   403	458	494	org/xmlpull/v1/XmlPullParserException
    //   461	491	494	org/xmlpull/v1/XmlPullParserException
    //   508	532	494	org/xmlpull/v1/XmlPullParserException
    //   549	569	494	org/xmlpull/v1/XmlPullParserException
    //   621	626	494	org/xmlpull/v1/XmlPullParserException
    //   631	649	494	org/xmlpull/v1/XmlPullParserException
    //   656	697	494	org/xmlpull/v1/XmlPullParserException
    //   697	752	494	org/xmlpull/v1/XmlPullParserException
    //   755	785	494	org/xmlpull/v1/XmlPullParserException
    //   788	812	494	org/xmlpull/v1/XmlPullParserException
    //   815	835	494	org/xmlpull/v1/XmlPullParserException
    //   838	884	494	org/xmlpull/v1/XmlPullParserException
    //   884	892	494	org/xmlpull/v1/XmlPullParserException
    //   895	934	494	org/xmlpull/v1/XmlPullParserException
    //   37	45	535	java/io/IOException
    //   49	64	535	java/io/IOException
    //   68	76	535	java/io/IOException
    //   80	88	535	java/io/IOException
    //   92	100	535	java/io/IOException
    //   104	115	535	java/io/IOException
    //   119	127	535	java/io/IOException
    //   131	172	535	java/io/IOException
    //   176	182	535	java/io/IOException
    //   186	224	535	java/io/IOException
    //   230	238	535	java/io/IOException
    //   244	284	535	java/io/IOException
    //   284	347	535	java/io/IOException
    //   347	355	535	java/io/IOException
    //   362	403	535	java/io/IOException
    //   403	458	535	java/io/IOException
    //   461	491	535	java/io/IOException
    //   508	532	535	java/io/IOException
    //   549	569	535	java/io/IOException
    //   621	626	535	java/io/IOException
    //   631	649	535	java/io/IOException
    //   656	697	535	java/io/IOException
    //   697	752	535	java/io/IOException
    //   755	785	535	java/io/IOException
    //   788	812	535	java/io/IOException
    //   815	835	535	java/io/IOException
    //   838	884	535	java/io/IOException
    //   884	892	535	java/io/IOException
    //   895	934	535	java/io/IOException
    //   244	284	572	java/lang/Exception
    //   284	347	572	java/lang/Exception
    //   347	355	572	java/lang/Exception
    //   362	403	572	java/lang/Exception
    //   403	458	572	java/lang/Exception
    //   461	491	572	java/lang/Exception
    //   508	532	572	java/lang/Exception
    //   549	569	572	java/lang/Exception
    //   621	626	572	java/lang/Exception
    //   631	649	572	java/lang/Exception
    //   656	697	572	java/lang/Exception
    //   697	752	572	java/lang/Exception
    //   755	785	572	java/lang/Exception
    //   788	812	572	java/lang/Exception
    //   815	835	572	java/lang/Exception
    //   838	884	572	java/lang/Exception
    //   884	892	572	java/lang/Exception
    //   895	934	572	java/lang/Exception
    //   37	45	937	java/lang/Exception
    //   49	64	937	java/lang/Exception
    //   68	76	937	java/lang/Exception
    //   80	88	937	java/lang/Exception
    //   92	100	937	java/lang/Exception
    //   104	115	937	java/lang/Exception
    //   119	127	937	java/lang/Exception
    //   131	172	937	java/lang/Exception
    //   176	182	937	java/lang/Exception
    //   186	224	937	java/lang/Exception
    //   230	238	937	java/lang/Exception
  }
  
  public static boolean a(Bitmap paramBitmap)
  {
    if ((paramBitmap != null) && (!paramBitmap.isRecycled()))
    {
      paramBitmap.recycle();
      return true;
    }
    return false;
  }
  
  public static byte[] a(byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.camera.CameraUtils", 4, "[decodeXML] + BEGIN");
    }
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    try
    {
      paramArrayOfByte = new InflaterInputStream(new ByteArrayInputStream(paramArrayOfByte));
      byte[] arrayOfByte = new byte[256];
      for (;;)
      {
        int i = paramArrayOfByte.read(arrayOfByte);
        if (-1 == i) {
          break;
        }
        localByteArrayOutputStream.write(arrayOfByte, 0, i);
      }
      paramArrayOfByte = localByteArrayOutputStream.toByteArray();
    }
    catch (Throwable paramArrayOfByte)
    {
      if (QLog.isColorLevel())
      {
        QLog.d("OlympicUtil", 2, "inflateConfigString");
        paramArrayOfByte.printStackTrace();
      }
      return null;
    }
    return paramArrayOfByte;
  }
  
  @TargetApi(10)
  public static Bitmap b(byte[] paramArrayOfByte, Rect paramRect, boolean paramBoolean, int paramInt)
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    localOptions.inSampleSize = 1;
    BitmapFactory.decodeByteArray(paramArrayOfByte, 0, paramArrayOfByte.length, localOptions);
    int j = localOptions.outHeight;
    int k = localOptions.outWidth;
    int i;
    double d4;
    double d5;
    double d1;
    double d2;
    if (k > j)
    {
      i = 1;
      d4 = 1.0D * Math.max(j, k) / Math.min(j, k);
      d5 = 1.0D * paramRect.height() / paramRect.width();
      d1 = k;
      d2 = j;
      if (d4 <= d5) {
        break label392;
      }
      if (i == 0) {
        break label374;
      }
      d1 = d2;
      d2 = d5 * d2;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.camera.CameraUtils", 2, "clipJpegToBitmap tw=" + d2 + " th=" + d1 + " bw=" + k + " bh=" + j + " br=" + d4 + " sr=" + d5);
      }
      localOptions.inJustDecodeBounds = false;
      double d3 = (k - d2) / 2.0D;
      d4 = (k + d2) / 2.0D;
      d5 = (j - d1) / 2.0D;
      double d6 = (j + d1) / 2.0D;
      if (Build.VERSION.SDK_INT >= 10)
      {
        paramRect = new Rect((int)d3, (int)d5, (int)d4, (int)d6);
        paramArrayOfByte = BitmapRegionDecoder.newInstance(paramArrayOfByte, 0, paramArrayOfByte.length, true);
        paramRect = paramArrayOfByte.decodeRegion(paramRect, localOptions);
        paramArrayOfByte.recycle();
        paramArrayOfByte = new Matrix();
        paramArrayOfByte.setRotate(paramInt, paramRect.getWidth() / 2.0F, paramRect.getHeight() / 2.0F);
        if (paramBoolean) {
          paramArrayOfByte.postScale(-1.0F, 1.0F);
        }
        return Bitmap.createBitmap(paramRect, 0, 0, paramRect.getWidth(), paramRect.getHeight(), paramArrayOfByte, false);
        i = 0;
        break;
        label374:
        d3 = d5 * d1;
        d2 = d1;
        d1 = d3;
        continue;
        label392:
        if (d4 >= d5) {
          break label550;
        }
        if (i != 0)
        {
          d3 = 1.0D / d5 * d1;
          d2 = d1;
          d1 = d3;
          continue;
        }
        d3 = 1.0D / d5;
        d1 = d2;
        d2 = d3 * d2;
        continue;
      }
      try
      {
        localOptions.inSampleSize = 2;
        paramArrayOfByte = BitmapFactory.decodeByteArray(paramArrayOfByte, 0, paramArrayOfByte.length, localOptions);
        paramRect = new Matrix();
        paramRect.setRotate(paramInt, paramArrayOfByte.getWidth() / 2.0F, paramArrayOfByte.getHeight() / 2.0F);
        if (paramBoolean) {
          paramRect.postScale(-1.0F, 1.0F);
        }
        paramRect = Bitmap.createBitmap(paramArrayOfByte, (int)(d3 / 2.0D), (int)(d5 / 2.0D), (int)(d2 / 2.0D), (int)(d1 / 2.0D), paramRect, false);
        paramArrayOfByte.recycle();
        return paramRect;
      }
      catch (OutOfMemoryError paramArrayOfByte)
      {
        paramArrayOfByte.printStackTrace();
        throw paramArrayOfByte;
      }
      label550:
      d3 = d1;
      d1 = d2;
      d2 = d3;
    }
  }
  
  public static boolean b()
  {
    return Build.VERSION.SDK_INT >= CameraWrapper.a().a();
  }
  
  public static boolean c()
  {
    int i = BaseApplicationImpl.getContext().getPackageManager().checkPermission("android.permission.CAMERA", BaseApplicationImpl.getContext().getPackageName());
    if (i != 0)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.camera.CameraUtils", 2, "[isCameraReady] camera has not permission " + i);
      }
      return false;
    }
    return true;
  }
  
  public static boolean d()
  {
    for (;;)
    {
      boolean bool;
      try
      {
        bool = c();
        if (!QLog.isColorLevel()) {
          break label149;
        }
        StringBuilder localStringBuilder = new StringBuilder().append("[isCameraReady] check camera permission: ");
        if (!bool) {
          break label155;
        }
        localObject = "OK";
        QLog.i("Q.camera.CameraUtils", 2, (String)localObject);
      }
      catch (Exception localException)
      {
        Object localObject;
        int j;
        localException.printStackTrace();
        return false;
      }
      j = CameraWrapper.a().b();
      if (j >= 1)
      {
        localObject = new Camera.CameraInfo();
        int i = 0;
        if (i < j)
        {
          Camera.getCameraInfo(i, (Camera.CameraInfo)localObject);
          if (((Camera.CameraInfo)localObject).facing == 0)
          {
            i = 1;
            if (i == 0)
            {
              if (!QLog.isColorLevel()) {
                break label153;
              }
              QLog.i("Q.camera.CameraUtils", 2, "[isCameraReady] check back camera exist: failed");
              return false;
            }
          }
          else
          {
            i += 1;
            continue;
          }
          if (QLog.isColorLevel()) {
            QLog.i("Q.camera.CameraUtils", 2, "[isCameraReady] check back camera exist: OK");
          }
          return true;
        }
        else
        {
          i = 0;
          continue;
          label149:
          if (bool) {
            continue;
          }
        }
      }
      label153:
      return false;
      label155:
      String str = "FAILED";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\com33.jar
 * Qualified Name:     com.tencent.mobileqq.camera.utils.CameraUtils
 * JD-Core Version:    0.7.0.1
 */