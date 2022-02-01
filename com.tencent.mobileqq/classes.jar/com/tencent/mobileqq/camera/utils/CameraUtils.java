package com.tencent.mobileqq.camera.utils;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.hardware.Camera;
import android.hardware.Camera.CameraInfo;
import android.os.Build.VERSION;
import com.tencent.mobileqq.camera.CameraHolder;
import com.tencent.mobileqq.camera.adapter.CameraWrapper;
import com.tencent.mobileqq.camera.adapter.DeviceInstance;
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
  public static boolean a = false;
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
  
  public static Bitmap a(Bitmap paramBitmap, int paramInt, boolean paramBoolean)
  {
    System.currentTimeMillis();
    Object localObject3 = null;
    Object localObject2 = null;
    Object localObject1 = localObject3;
    label119:
    Bitmap localBitmap;
    if (paramBitmap != null)
    {
      localObject1 = localObject3;
      if (!paramBitmap.isRecycled())
      {
        if ((paramInt != 0) && (paramInt != 360))
        {
          localObject1 = new Matrix();
          ((Matrix)localObject1).setRotate(paramInt, paramBitmap.getWidth() / 2.0F, paramBitmap.getHeight() / 2.0F);
          try
          {
            localObject1 = Bitmap.createBitmap(paramBitmap, 0, 0, paramBitmap.getWidth(), paramBitmap.getHeight(), (Matrix)localObject1, true);
            if ((paramBoolean) && (paramBitmap != localObject1)) {
              try
              {
                a(paramBitmap);
              }
              catch (OutOfMemoryError localOutOfMemoryError2)
              {
                paramBitmap = (Bitmap)localObject1;
                localObject1 = localOutOfMemoryError2;
                break label119;
              }
            }
            return localObject1;
          }
          catch (OutOfMemoryError localOutOfMemoryError1)
          {
            paramBitmap = localOutOfMemoryError2;
            localOutOfMemoryError1.printStackTrace();
            QLog.w("Q.camera.CameraUtils", 2, "OutOfMemoryError. ", localOutOfMemoryError1);
            return paramBitmap;
          }
        }
        localBitmap = paramBitmap;
      }
    }
    return localBitmap;
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
    if (j > i) {
      paramInt = 1;
    } else {
      paramInt = 0;
    }
    double d1 = Math.max(i, j);
    Double.isNaN(d1);
    double d2 = Math.min(i, j);
    Double.isNaN(d2);
    double d6 = d1 * 1.0D / d2;
    d1 = paramRect.height();
    Double.isNaN(d1);
    d2 = paramRect.width();
    Double.isNaN(d2);
    double d7 = d1 * 1.0D / d2;
    double d5 = j;
    d2 = i;
    if (d6 > d7) {
      if (paramInt != 0) {
        Double.isNaN(d2);
      }
    }
    for (d1 = d7 * d2;; d1 *= d2)
    {
      d3 = d2;
      d4 = d1;
      break label265;
      Double.isNaN(d5);
      for (d1 = d7 * d5;; d1 *= d5)
      {
        break label257;
        if (d6 >= d7) {
          break label253;
        }
        if (paramInt == 0) {
          break;
        }
        d1 = 1.0D / d7;
        Double.isNaN(d5);
      }
      d1 = 1.0D / d7;
      Double.isNaN(d2);
    }
    label253:
    d1 = d2;
    label257:
    double d4 = d5;
    double d3 = d1;
    label265:
    if (QLog.isColorLevel())
    {
      paramRect = new StringBuilder();
      paramRect.append("clipJpegToBitmap tw=");
      paramRect.append(d4);
      paramRect.append(" th=");
      paramRect.append(d3);
      paramRect.append(" bw=");
      paramRect.append(j);
      paramRect.append(" bh=");
      paramRect.append(i);
      paramRect.append(" br=");
      paramRect.append(d6);
      paramRect.append(" sr=");
      paramRect.append(d7);
      QLog.i("Q.camera.CameraUtils", 2, paramRect.toString());
    }
    localOptions.inJustDecodeBounds = false;
    Double.isNaN(d5);
    d1 = (d5 - d4) / 2.0D;
    Double.isNaN(d5);
    d5 = (d5 + d4) / 2.0D;
    Double.isNaN(d2);
    d6 = (d2 - d3) / 2.0D;
    Double.isNaN(d2);
    d2 = (d2 + d3) / 2.0D;
    if (Build.VERSION.SDK_INT >= 10)
    {
      paramRect = new Rect((int)d1, (int)d6, (int)d5, (int)d2);
      paramArrayOfByte = BitmapRegionDecoder.newInstance(paramArrayOfByte, 0, paramArrayOfByte.length, true);
      paramRect = paramArrayOfByte.decodeRegion(paramRect, localOptions);
      paramArrayOfByte.recycle();
      return paramRect;
    }
    try
    {
      localOptions.inSampleSize = 2;
      paramArrayOfByte = BitmapFactory.decodeByteArray(paramArrayOfByte, 0, paramArrayOfByte.length, localOptions);
      paramRect = Bitmap.createBitmap(paramArrayOfByte, (int)(d1 / 2.0D), (int)(d6 / 2.0D), (int)(d4 / 2.0D), (int)(d3 / 2.0D));
      paramArrayOfByte.recycle();
      return paramRect;
    }
    catch (OutOfMemoryError paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    for (;;)
    {
      throw paramArrayOfByte;
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
    if (paramInt2 < paramInt3) {
      i = 1;
    } else {
      i = 0;
    }
    int j = paramInt2;
    if (i != 0)
    {
      j = paramInt2;
      if (paramInt4 != 0) {
        j = paramInt5 * paramInt3 / paramInt4;
      }
    }
    if (paramBoolean) {
      f1 = -1.0F;
    } else {
      f1 = 1.0F;
    }
    paramMatrix.setScale(f1, 1.0F);
    paramMatrix.postRotate(paramInt1);
    float f1 = j;
    float f2 = f1 / 2000.0F;
    float f3 = paramInt3;
    paramMatrix.postScale(f2, f3 / 2000.0F);
    paramMatrix.postTranslate(f1 / 2.0F, f3 / 2.0F);
  }
  
  public static boolean a()
  {
    Object localObject;
    if (b)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.camera.CameraUtils", 2, "[isChoiceQCamera] + ENTER");
      }
      localObject = DeviceInstance.a().a();
      String str = DeviceInstance.a().b();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("My Phone: ");
      localStringBuilder.append((String)localObject);
      localStringBuilder.append(",  Model: ");
      localStringBuilder.append(str);
      QLog.i("Q.camera.CameraUtils", 1, localStringBuilder.toString());
      boolean bool1 = CameraWrapper.a().c();
      boolean bool2 = b();
      int i;
      if ((!bool1) && (bool2))
      {
        if (CameraWrapper.a().a())
        {
          if (QLog.isColorLevel()) {
            QLog.i("Q.camera.CameraUtils", 2, "[isChoiceQCamera] enter system camera 1");
          }
          i = 3;
        }
        else
        {
          if (c())
          {
            i = 10;
            bool1 = true;
            break label239;
          }
          if (QLog.isColorLevel()) {
            QLog.i("Q.camera.CameraUtils", 2, "[isChoiceQCamera] enter system camera 3");
          }
          i = 4;
        }
      }
      else
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("[isChoiceQCamera] enter system camera 0, qcameraDisabled=");
          ((StringBuilder)localObject).append(bool1);
          ((StringBuilder)localObject).append(" sysVerSupported=");
          ((StringBuilder)localObject).append(bool2);
          QLog.i("Q.camera.CameraUtils", 2, ((StringBuilder)localObject).toString());
        }
        if (bool1) {
          i = 1;
        } else {
          i = 2;
        }
      }
      bool1 = false;
      label239:
      localObject = new HashMap();
      ((HashMap)localObject).put("param_FailCode", String.valueOf(i));
      ((HashMap)localObject).put(BaseConstants.RDM_NoChangeFailCode, "");
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "qcamera_choice_type", false, 0L, 0L, (HashMap)localObject, "");
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[isChoiceQCamera] choice self qcamera: ");
      ((StringBuilder)localObject).append(bool1);
      ((StringBuilder)localObject).append(" choiceResult: ");
      ((StringBuilder)localObject).append(i);
      QLog.i("Q.camera.CameraUtils", 1, ((StringBuilder)localObject).toString());
      a = bool1;
      b = false;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[isChoiceQCamera] choice self qcamera final: ");
      ((StringBuilder)localObject).append(a);
      QLog.i("Q.camera.CameraUtils", 1, ((StringBuilder)localObject).toString());
    }
    return a;
  }
  
  public static boolean a(Context paramContext)
  {
    return CameraWrapper.a().c();
  }
  
  public static boolean a(Context paramContext, String paramString, int paramInt)
  {
    a(a(paramContext), paramString, paramInt);
    CameraWrapper.a().a(true);
    b = true;
    return true;
  }
  
  /* Error */
  private static boolean a(SharedPreferences paramSharedPreferences, String paramString, int paramInt)
  {
    // Byte code:
    //   0: ldc 102
    //   2: iconst_4
    //   3: ldc_w 363
    //   6: invokestatic 191	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   9: aload_1
    //   10: invokestatic 369	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   13: ifeq +14 -> 27
    //   16: ldc 102
    //   18: iconst_4
    //   19: ldc_w 371
    //   22: invokestatic 374	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   25: iconst_0
    //   26: ireturn
    //   27: iconst_0
    //   28: invokestatic 379	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   31: astore 7
    //   33: aload 7
    //   35: astore 6
    //   37: invokestatic 384	org/xmlpull/v1/XmlPullParserFactory:newInstance	()Lorg/xmlpull/v1/XmlPullParserFactory;
    //   40: invokevirtual 388	org/xmlpull/v1/XmlPullParserFactory:newPullParser	()Lorg/xmlpull/v1/XmlPullParser;
    //   43: astore 11
    //   45: aload 7
    //   47: astore 6
    //   49: aload 11
    //   51: new 390	java/io/StringReader
    //   54: dup
    //   55: aload_1
    //   56: invokespecial 393	java/io/StringReader:<init>	(Ljava/lang/String;)V
    //   59: invokeinterface 399 2 0
    //   64: aload 7
    //   66: astore 6
    //   68: aload 11
    //   70: invokeinterface 402 1 0
    //   75: istore_3
    //   76: aload 7
    //   78: astore 6
    //   80: aload_0
    //   81: invokeinterface 224 1 0
    //   86: astore 12
    //   88: aload 7
    //   90: astore 6
    //   92: aload 12
    //   94: invokeinterface 405 1 0
    //   99: pop
    //   100: aload 7
    //   102: astore 6
    //   104: aload 12
    //   106: ldc 24
    //   108: iload_2
    //   109: invokeinterface 230 3 0
    //   114: pop
    //   115: aload 7
    //   117: astore 6
    //   119: invokestatic 270	com/tencent/mobileqq/camera/adapter/DeviceInstance:a	()Lcom/tencent/mobileqq/camera/adapter/DeviceInstance;
    //   122: invokevirtual 272	com/tencent/mobileqq/camera/adapter/DeviceInstance:a	()Ljava/lang/String;
    //   125: astore_0
    //   126: aload 7
    //   128: astore 6
    //   130: new 160	java/lang/StringBuilder
    //   133: dup
    //   134: invokespecial 161	java/lang/StringBuilder:<init>	()V
    //   137: astore_1
    //   138: aload 7
    //   140: astore 6
    //   142: aload_1
    //   143: aload_0
    //   144: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   147: pop
    //   148: aload 7
    //   150: astore 6
    //   152: aload_1
    //   153: ldc_w 407
    //   156: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   159: pop
    //   160: aload 7
    //   162: astore 6
    //   164: aload_1
    //   165: getstatic 412	android/os/Build:DISPLAY	Ljava/lang/String;
    //   168: ldc_w 414
    //   171: ldc_w 407
    //   174: invokevirtual 418	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   177: invokevirtual 421	java/lang/String:toUpperCase	()Ljava/lang/String;
    //   180: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   183: pop
    //   184: aload 7
    //   186: astore 6
    //   188: aload_1
    //   189: invokevirtual 187	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   192: astore_1
    //   193: aload 7
    //   195: astore 6
    //   197: invokestatic 158	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   200: istore 4
    //   202: iload 4
    //   204: ifeq +79 -> 283
    //   207: aload 7
    //   209: astore 6
    //   211: new 160	java/lang/StringBuilder
    //   214: dup
    //   215: invokespecial 161	java/lang/StringBuilder:<init>	()V
    //   218: astore 8
    //   220: aload 7
    //   222: astore 6
    //   224: aload 8
    //   226: ldc_w 423
    //   229: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   232: pop
    //   233: aload 7
    //   235: astore 6
    //   237: aload 8
    //   239: aload_0
    //   240: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   243: pop
    //   244: aload 7
    //   246: astore 6
    //   248: aload 8
    //   250: ldc_w 425
    //   253: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   256: pop
    //   257: aload 7
    //   259: astore 6
    //   261: aload 8
    //   263: aload_1
    //   264: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   267: pop
    //   268: aload 7
    //   270: astore 6
    //   272: ldc 102
    //   274: iconst_4
    //   275: aload 8
    //   277: invokevirtual 187	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   280: invokestatic 191	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   283: iconst_0
    //   284: istore 4
    //   286: iload_3
    //   287: istore_2
    //   288: iload_2
    //   289: iconst_1
    //   290: if_icmpeq +869 -> 1159
    //   293: iload_2
    //   294: ifeq +8 -> 302
    //   297: iload_2
    //   298: iconst_2
    //   299: if_icmpeq +22 -> 321
    //   302: aload_0
    //   303: astore 6
    //   305: aload 7
    //   307: astore 8
    //   309: iload 4
    //   311: istore 5
    //   313: aload_1
    //   314: astore_0
    //   315: aload 6
    //   317: astore_1
    //   318: goto +810 -> 1128
    //   321: aload 7
    //   323: astore 6
    //   325: aload 11
    //   327: invokeinterface 428 1 0
    //   332: astore 13
    //   334: aload 7
    //   336: astore 6
    //   338: aload 13
    //   340: aload_0
    //   341: invokevirtual 432	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   344: istore 5
    //   346: iload 5
    //   348: ifeq +442 -> 790
    //   351: aload 7
    //   353: astore 6
    //   355: invokestatic 158	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   358: ifeq +104 -> 462
    //   361: aload 7
    //   363: astore 6
    //   365: new 160	java/lang/StringBuilder
    //   368: dup
    //   369: invokespecial 161	java/lang/StringBuilder:<init>	()V
    //   372: astore 8
    //   374: aload 7
    //   376: astore 6
    //   378: aload 8
    //   380: ldc_w 434
    //   383: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   386: pop
    //   387: aload 7
    //   389: astore 6
    //   391: aload 8
    //   393: aload 13
    //   395: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   398: pop
    //   399: aload 7
    //   401: astore 6
    //   403: aload 8
    //   405: ldc_w 436
    //   408: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   411: pop
    //   412: aload 7
    //   414: astore 6
    //   416: aload 8
    //   418: aload_0
    //   419: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   422: pop
    //   423: aload 7
    //   425: astore 6
    //   427: aload 8
    //   429: ldc_w 425
    //   432: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   435: pop
    //   436: aload 7
    //   438: astore 6
    //   440: aload 8
    //   442: aload_1
    //   443: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   446: pop
    //   447: aload 7
    //   449: astore 6
    //   451: ldc 102
    //   453: iconst_4
    //   454: aload 8
    //   456: invokevirtual 187	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   459: invokestatic 439	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   462: aload 7
    //   464: astore 6
    //   466: aload 11
    //   468: invokeinterface 442 1 0
    //   473: istore_2
    //   474: iconst_0
    //   475: istore_3
    //   476: iload_3
    //   477: iload_2
    //   478: if_icmpge +287 -> 765
    //   481: aload 7
    //   483: astore 6
    //   485: aload 11
    //   487: iload_3
    //   488: invokeinterface 445 2 0
    //   493: astore 8
    //   495: aload 7
    //   497: astore 6
    //   499: aload 11
    //   501: iload_3
    //   502: invokeinterface 448 2 0
    //   507: astore 9
    //   509: aload 7
    //   511: astore 6
    //   513: aload 8
    //   515: ldc 236
    //   517: invokevirtual 432	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   520: ifeq +23 -> 543
    //   523: aload 7
    //   525: astore 6
    //   527: aload 9
    //   529: invokestatic 451	java/lang/Boolean:parseBoolean	(Ljava/lang/String;)Z
    //   532: invokestatic 379	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   535: invokevirtual 454	java/lang/Boolean:booleanValue	()Z
    //   538: istore 4
    //   540: goto +108 -> 648
    //   543: aload 7
    //   545: astore 6
    //   547: aload 8
    //   549: ldc_w 456
    //   552: invokevirtual 459	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   555: ifeq +31 -> 586
    //   558: aload 7
    //   560: astore 6
    //   562: aload 12
    //   564: aload 8
    //   566: aload 9
    //   568: invokestatic 465	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   571: invokestatic 468	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   574: invokevirtual 471	java/lang/Integer:intValue	()I
    //   577: invokeinterface 230 3 0
    //   582: pop
    //   583: goto +65 -> 648
    //   586: aload 7
    //   588: astore 6
    //   590: aload 8
    //   592: ldc_w 473
    //   595: invokevirtual 459	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   598: ifeq +25 -> 623
    //   601: aload 7
    //   603: astore 6
    //   605: aload 12
    //   607: aload 8
    //   609: aload 9
    //   611: invokestatic 476	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   614: invokeinterface 480 3 0
    //   619: pop
    //   620: goto +28 -> 648
    //   623: aload 7
    //   625: astore 6
    //   627: aload 12
    //   629: aload 8
    //   631: aload 9
    //   633: invokestatic 451	java/lang/Boolean:parseBoolean	(Ljava/lang/String;)Z
    //   636: invokestatic 379	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   639: invokevirtual 454	java/lang/Boolean:booleanValue	()Z
    //   642: invokeinterface 240 3 0
    //   647: pop
    //   648: aload 7
    //   650: astore 6
    //   652: invokestatic 158	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   655: ifeq +759 -> 1414
    //   658: aload 7
    //   660: astore 6
    //   662: new 160	java/lang/StringBuilder
    //   665: dup
    //   666: invokespecial 161	java/lang/StringBuilder:<init>	()V
    //   669: astore 10
    //   671: aload 7
    //   673: astore 6
    //   675: aload 10
    //   677: ldc_w 482
    //   680: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   683: pop
    //   684: aload 7
    //   686: astore 6
    //   688: aload 10
    //   690: iload_3
    //   691: iconst_1
    //   692: iadd
    //   693: invokevirtual 177	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   696: pop
    //   697: aload 7
    //   699: astore 6
    //   701: aload 10
    //   703: ldc_w 484
    //   706: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   709: pop
    //   710: aload 7
    //   712: astore 6
    //   714: aload 10
    //   716: aload 8
    //   718: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   721: pop
    //   722: aload 7
    //   724: astore 6
    //   726: aload 10
    //   728: ldc_w 486
    //   731: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   734: pop
    //   735: aload 7
    //   737: astore 6
    //   739: aload 10
    //   741: aload 9
    //   743: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   746: pop
    //   747: aload 7
    //   749: astore 6
    //   751: ldc 102
    //   753: iconst_4
    //   754: aload 10
    //   756: invokevirtual 187	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   759: invokestatic 191	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   762: goto +652 -> 1414
    //   765: aload_0
    //   766: astore 9
    //   768: aload 7
    //   770: astore 6
    //   772: iconst_1
    //   773: invokestatic 379	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   776: astore 8
    //   778: iload 4
    //   780: istore 5
    //   782: aload_1
    //   783: astore_0
    //   784: aload 9
    //   786: astore_1
    //   787: goto +341 -> 1128
    //   790: aload_1
    //   791: astore 9
    //   793: aload_0
    //   794: astore 10
    //   796: aload 7
    //   798: astore 8
    //   800: iload 4
    //   802: istore 5
    //   804: aload 9
    //   806: astore_0
    //   807: aload 10
    //   809: astore_1
    //   810: aload 7
    //   812: astore 6
    //   814: ldc_w 488
    //   817: aload 13
    //   819: invokevirtual 432	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   822: ifeq +306 -> 1128
    //   825: aload 7
    //   827: astore 6
    //   829: aload 11
    //   831: invokeinterface 442 1 0
    //   836: istore_2
    //   837: iconst_0
    //   838: istore_3
    //   839: aload 7
    //   841: astore 8
    //   843: iload 4
    //   845: istore 5
    //   847: aload 9
    //   849: astore_0
    //   850: aload 10
    //   852: astore_1
    //   853: iload_3
    //   854: iload_2
    //   855: if_icmpge +273 -> 1128
    //   858: aload 7
    //   860: astore 6
    //   862: aload 11
    //   864: iload_3
    //   865: invokeinterface 445 2 0
    //   870: astore_0
    //   871: aload 7
    //   873: astore 6
    //   875: aload 11
    //   877: iload_3
    //   878: invokeinterface 448 2 0
    //   883: astore_1
    //   884: aload 7
    //   886: astore 6
    //   888: aload_0
    //   889: ldc 236
    //   891: invokevirtual 432	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   894: ifeq +22 -> 916
    //   897: aload 7
    //   899: astore 6
    //   901: aload_1
    //   902: invokestatic 451	java/lang/Boolean:parseBoolean	(Ljava/lang/String;)Z
    //   905: invokestatic 379	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   908: invokevirtual 454	java/lang/Boolean:booleanValue	()Z
    //   911: istore 4
    //   913: goto +100 -> 1013
    //   916: aload 7
    //   918: astore 6
    //   920: aload_0
    //   921: ldc_w 456
    //   924: invokevirtual 459	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   927: ifeq +29 -> 956
    //   930: aload 7
    //   932: astore 6
    //   934: aload 12
    //   936: aload_0
    //   937: aload_1
    //   938: invokestatic 465	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   941: invokestatic 468	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   944: invokevirtual 471	java/lang/Integer:intValue	()I
    //   947: invokeinterface 230 3 0
    //   952: pop
    //   953: goto +60 -> 1013
    //   956: aload 7
    //   958: astore 6
    //   960: aload_0
    //   961: ldc_w 473
    //   964: invokevirtual 459	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   967: ifeq +23 -> 990
    //   970: aload 7
    //   972: astore 6
    //   974: aload 12
    //   976: aload_0
    //   977: aload_1
    //   978: invokestatic 476	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   981: invokeinterface 480 3 0
    //   986: pop
    //   987: goto +26 -> 1013
    //   990: aload 7
    //   992: astore 6
    //   994: aload 12
    //   996: aload_0
    //   997: aload_1
    //   998: invokestatic 451	java/lang/Boolean:parseBoolean	(Ljava/lang/String;)Z
    //   1001: invokestatic 379	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1004: invokevirtual 454	java/lang/Boolean:booleanValue	()Z
    //   1007: invokeinterface 240 3 0
    //   1012: pop
    //   1013: aload 7
    //   1015: astore 6
    //   1017: invokestatic 158	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1020: ifeq +401 -> 1421
    //   1023: aload 7
    //   1025: astore 6
    //   1027: new 160	java/lang/StringBuilder
    //   1030: dup
    //   1031: invokespecial 161	java/lang/StringBuilder:<init>	()V
    //   1034: astore 8
    //   1036: aload 7
    //   1038: astore 6
    //   1040: aload 8
    //   1042: ldc_w 490
    //   1045: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1048: pop
    //   1049: aload 7
    //   1051: astore 6
    //   1053: aload 8
    //   1055: iload_3
    //   1056: iconst_1
    //   1057: iadd
    //   1058: invokevirtual 177	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1061: pop
    //   1062: aload 7
    //   1064: astore 6
    //   1066: aload 8
    //   1068: ldc_w 484
    //   1071: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1074: pop
    //   1075: aload 7
    //   1077: astore 6
    //   1079: aload 8
    //   1081: aload_0
    //   1082: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1085: pop
    //   1086: aload 7
    //   1088: astore 6
    //   1090: aload 8
    //   1092: ldc_w 486
    //   1095: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1098: pop
    //   1099: aload 7
    //   1101: astore 6
    //   1103: aload 8
    //   1105: aload_1
    //   1106: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1109: pop
    //   1110: aload 7
    //   1112: astore 6
    //   1114: ldc 102
    //   1116: iconst_4
    //   1117: aload 8
    //   1119: invokevirtual 187	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1122: invokestatic 191	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1125: goto +296 -> 1421
    //   1128: aload 8
    //   1130: astore 6
    //   1132: aload 11
    //   1134: invokeinterface 493 1 0
    //   1139: istore_2
    //   1140: aload_0
    //   1141: astore 6
    //   1143: aload_1
    //   1144: astore_0
    //   1145: aload 6
    //   1147: astore_1
    //   1148: aload 8
    //   1150: astore 7
    //   1152: iload 5
    //   1154: istore 4
    //   1156: goto -868 -> 288
    //   1159: aload 7
    //   1161: astore 6
    //   1163: aload 7
    //   1165: invokevirtual 454	java/lang/Boolean:booleanValue	()Z
    //   1168: ifeq +71 -> 1239
    //   1171: aload 7
    //   1173: astore 6
    //   1175: aload 12
    //   1177: ldc 236
    //   1179: iload 4
    //   1181: invokeinterface 240 3 0
    //   1186: pop
    //   1187: aload 7
    //   1189: astore 6
    //   1191: new 160	java/lang/StringBuilder
    //   1194: dup
    //   1195: invokespecial 161	java/lang/StringBuilder:<init>	()V
    //   1198: astore_0
    //   1199: aload 7
    //   1201: astore 6
    //   1203: aload_0
    //   1204: ldc_w 495
    //   1207: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1210: pop
    //   1211: aload 7
    //   1213: astore 6
    //   1215: aload_0
    //   1216: iload 4
    //   1218: invokevirtual 296	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1221: pop
    //   1222: aload 7
    //   1224: astore 6
    //   1226: ldc 102
    //   1228: iconst_1
    //   1229: aload_0
    //   1230: invokevirtual 187	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1233: invokestatic 191	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1236: goto +68 -> 1304
    //   1239: aload 7
    //   1241: astore 6
    //   1243: aload 12
    //   1245: ldc 236
    //   1247: iload 4
    //   1249: invokeinterface 240 3 0
    //   1254: pop
    //   1255: aload 7
    //   1257: astore 6
    //   1259: new 160	java/lang/StringBuilder
    //   1262: dup
    //   1263: invokespecial 161	java/lang/StringBuilder:<init>	()V
    //   1266: astore_0
    //   1267: aload 7
    //   1269: astore 6
    //   1271: aload_0
    //   1272: ldc_w 497
    //   1275: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1278: pop
    //   1279: aload 7
    //   1281: astore 6
    //   1283: aload_0
    //   1284: iload 4
    //   1286: invokevirtual 296	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1289: pop
    //   1290: aload 7
    //   1292: astore 6
    //   1294: ldc 102
    //   1296: iconst_1
    //   1297: aload_0
    //   1298: invokevirtual 187	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1301: invokestatic 191	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1304: aload 7
    //   1306: astore 6
    //   1308: aload 12
    //   1310: invokeinterface 233 1 0
    //   1315: pop
    //   1316: aload 7
    //   1318: astore 6
    //   1320: goto +15 -> 1335
    //   1323: astore_0
    //   1324: ldc 102
    //   1326: iconst_1
    //   1327: aload_0
    //   1328: iconst_0
    //   1329: anewarray 4	java/lang/Object
    //   1332: invokestatic 500	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   1335: invokestatic 158	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1338: ifeq +36 -> 1374
    //   1341: new 160	java/lang/StringBuilder
    //   1344: dup
    //   1345: invokespecial 161	java/lang/StringBuilder:<init>	()V
    //   1348: astore_0
    //   1349: aload_0
    //   1350: ldc_w 502
    //   1353: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1356: pop
    //   1357: aload_0
    //   1358: aload 6
    //   1360: invokevirtual 505	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1363: pop
    //   1364: ldc 102
    //   1366: iconst_4
    //   1367: aload_0
    //   1368: invokevirtual 187	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1371: invokestatic 191	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1374: aload 6
    //   1376: invokevirtual 454	java/lang/Boolean:booleanValue	()Z
    //   1379: ireturn
    //   1380: astore_0
    //   1381: ldc 102
    //   1383: iconst_1
    //   1384: aload_0
    //   1385: iconst_0
    //   1386: anewarray 4	java/lang/Object
    //   1389: invokestatic 500	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   1392: aload_0
    //   1393: athrow
    //   1394: astore_0
    //   1395: ldc 102
    //   1397: iconst_1
    //   1398: aload_0
    //   1399: iconst_0
    //   1400: anewarray 4	java/lang/Object
    //   1403: invokestatic 500	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   1406: goto +5 -> 1411
    //   1409: aload_0
    //   1410: athrow
    //   1411: goto -2 -> 1409
    //   1414: iload_3
    //   1415: iconst_1
    //   1416: iadd
    //   1417: istore_3
    //   1418: goto -942 -> 476
    //   1421: iload_3
    //   1422: iconst_1
    //   1423: iadd
    //   1424: istore_3
    //   1425: goto -586 -> 839
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1428	0	paramSharedPreferences	SharedPreferences
    //   0	1428	1	paramString	String
    //   0	1428	2	paramInt	int
    //   75	1350	3	i	int
    //   200	1085	4	bool1	boolean
    //   311	842	5	bool2	boolean
    //   35	1340	6	localObject1	Object
    //   31	1286	7	localObject2	Object
    //   218	931	8	localObject3	Object
    //   507	341	9	localObject4	Object
    //   669	182	10	localObject5	Object
    //   43	1090	11	localXmlPullParser	org.xmlpull.v1.XmlPullParser
    //   86	1223	12	localEditor	SharedPreferences.Editor
    //   332	486	13	str	String
    // Exception table:
    //   from	to	target	type
    //   37	45	1323	java/lang/Exception
    //   49	64	1323	java/lang/Exception
    //   68	76	1323	java/lang/Exception
    //   80	88	1323	java/lang/Exception
    //   92	100	1323	java/lang/Exception
    //   104	115	1323	java/lang/Exception
    //   119	126	1323	java/lang/Exception
    //   130	138	1323	java/lang/Exception
    //   142	148	1323	java/lang/Exception
    //   152	160	1323	java/lang/Exception
    //   164	184	1323	java/lang/Exception
    //   188	193	1323	java/lang/Exception
    //   197	202	1323	java/lang/Exception
    //   211	220	1323	java/lang/Exception
    //   224	233	1323	java/lang/Exception
    //   237	244	1323	java/lang/Exception
    //   248	257	1323	java/lang/Exception
    //   261	268	1323	java/lang/Exception
    //   272	283	1323	java/lang/Exception
    //   325	334	1323	java/lang/Exception
    //   338	346	1323	java/lang/Exception
    //   355	361	1323	java/lang/Exception
    //   365	374	1323	java/lang/Exception
    //   378	387	1323	java/lang/Exception
    //   391	399	1323	java/lang/Exception
    //   403	412	1323	java/lang/Exception
    //   416	423	1323	java/lang/Exception
    //   427	436	1323	java/lang/Exception
    //   440	447	1323	java/lang/Exception
    //   451	462	1323	java/lang/Exception
    //   466	474	1323	java/lang/Exception
    //   485	495	1323	java/lang/Exception
    //   499	509	1323	java/lang/Exception
    //   513	523	1323	java/lang/Exception
    //   527	540	1323	java/lang/Exception
    //   547	558	1323	java/lang/Exception
    //   562	583	1323	java/lang/Exception
    //   590	601	1323	java/lang/Exception
    //   605	620	1323	java/lang/Exception
    //   627	648	1323	java/lang/Exception
    //   652	658	1323	java/lang/Exception
    //   662	671	1323	java/lang/Exception
    //   675	684	1323	java/lang/Exception
    //   688	697	1323	java/lang/Exception
    //   701	710	1323	java/lang/Exception
    //   714	722	1323	java/lang/Exception
    //   726	735	1323	java/lang/Exception
    //   739	747	1323	java/lang/Exception
    //   751	762	1323	java/lang/Exception
    //   772	778	1323	java/lang/Exception
    //   814	825	1323	java/lang/Exception
    //   829	837	1323	java/lang/Exception
    //   862	871	1323	java/lang/Exception
    //   875	884	1323	java/lang/Exception
    //   888	897	1323	java/lang/Exception
    //   901	913	1323	java/lang/Exception
    //   920	930	1323	java/lang/Exception
    //   934	953	1323	java/lang/Exception
    //   960	970	1323	java/lang/Exception
    //   974	987	1323	java/lang/Exception
    //   994	1013	1323	java/lang/Exception
    //   1017	1023	1323	java/lang/Exception
    //   1027	1036	1323	java/lang/Exception
    //   1040	1049	1323	java/lang/Exception
    //   1053	1062	1323	java/lang/Exception
    //   1066	1075	1323	java/lang/Exception
    //   1079	1086	1323	java/lang/Exception
    //   1090	1099	1323	java/lang/Exception
    //   1103	1110	1323	java/lang/Exception
    //   1114	1125	1323	java/lang/Exception
    //   1132	1140	1323	java/lang/Exception
    //   1163	1171	1323	java/lang/Exception
    //   1175	1187	1323	java/lang/Exception
    //   1191	1199	1323	java/lang/Exception
    //   1203	1211	1323	java/lang/Exception
    //   1215	1222	1323	java/lang/Exception
    //   1226	1236	1323	java/lang/Exception
    //   1243	1255	1323	java/lang/Exception
    //   1259	1267	1323	java/lang/Exception
    //   1271	1279	1323	java/lang/Exception
    //   1283	1290	1323	java/lang/Exception
    //   1294	1304	1323	java/lang/Exception
    //   1308	1316	1323	java/lang/Exception
    //   37	45	1380	java/io/IOException
    //   49	64	1380	java/io/IOException
    //   68	76	1380	java/io/IOException
    //   80	88	1380	java/io/IOException
    //   92	100	1380	java/io/IOException
    //   104	115	1380	java/io/IOException
    //   119	126	1380	java/io/IOException
    //   130	138	1380	java/io/IOException
    //   142	148	1380	java/io/IOException
    //   152	160	1380	java/io/IOException
    //   164	184	1380	java/io/IOException
    //   188	193	1380	java/io/IOException
    //   197	202	1380	java/io/IOException
    //   211	220	1380	java/io/IOException
    //   224	233	1380	java/io/IOException
    //   237	244	1380	java/io/IOException
    //   248	257	1380	java/io/IOException
    //   261	268	1380	java/io/IOException
    //   272	283	1380	java/io/IOException
    //   325	334	1380	java/io/IOException
    //   338	346	1380	java/io/IOException
    //   355	361	1380	java/io/IOException
    //   365	374	1380	java/io/IOException
    //   378	387	1380	java/io/IOException
    //   391	399	1380	java/io/IOException
    //   403	412	1380	java/io/IOException
    //   416	423	1380	java/io/IOException
    //   427	436	1380	java/io/IOException
    //   440	447	1380	java/io/IOException
    //   451	462	1380	java/io/IOException
    //   466	474	1380	java/io/IOException
    //   485	495	1380	java/io/IOException
    //   499	509	1380	java/io/IOException
    //   513	523	1380	java/io/IOException
    //   527	540	1380	java/io/IOException
    //   547	558	1380	java/io/IOException
    //   562	583	1380	java/io/IOException
    //   590	601	1380	java/io/IOException
    //   605	620	1380	java/io/IOException
    //   627	648	1380	java/io/IOException
    //   652	658	1380	java/io/IOException
    //   662	671	1380	java/io/IOException
    //   675	684	1380	java/io/IOException
    //   688	697	1380	java/io/IOException
    //   701	710	1380	java/io/IOException
    //   714	722	1380	java/io/IOException
    //   726	735	1380	java/io/IOException
    //   739	747	1380	java/io/IOException
    //   751	762	1380	java/io/IOException
    //   772	778	1380	java/io/IOException
    //   814	825	1380	java/io/IOException
    //   829	837	1380	java/io/IOException
    //   862	871	1380	java/io/IOException
    //   875	884	1380	java/io/IOException
    //   888	897	1380	java/io/IOException
    //   901	913	1380	java/io/IOException
    //   920	930	1380	java/io/IOException
    //   934	953	1380	java/io/IOException
    //   960	970	1380	java/io/IOException
    //   974	987	1380	java/io/IOException
    //   994	1013	1380	java/io/IOException
    //   1017	1023	1380	java/io/IOException
    //   1027	1036	1380	java/io/IOException
    //   1040	1049	1380	java/io/IOException
    //   1053	1062	1380	java/io/IOException
    //   1066	1075	1380	java/io/IOException
    //   1079	1086	1380	java/io/IOException
    //   1090	1099	1380	java/io/IOException
    //   1103	1110	1380	java/io/IOException
    //   1114	1125	1380	java/io/IOException
    //   1132	1140	1380	java/io/IOException
    //   1163	1171	1380	java/io/IOException
    //   1175	1187	1380	java/io/IOException
    //   1191	1199	1380	java/io/IOException
    //   1203	1211	1380	java/io/IOException
    //   1215	1222	1380	java/io/IOException
    //   1226	1236	1380	java/io/IOException
    //   1243	1255	1380	java/io/IOException
    //   1259	1267	1380	java/io/IOException
    //   1271	1279	1380	java/io/IOException
    //   1283	1290	1380	java/io/IOException
    //   1294	1304	1380	java/io/IOException
    //   1308	1316	1380	java/io/IOException
    //   37	45	1394	org/xmlpull/v1/XmlPullParserException
    //   49	64	1394	org/xmlpull/v1/XmlPullParserException
    //   68	76	1394	org/xmlpull/v1/XmlPullParserException
    //   80	88	1394	org/xmlpull/v1/XmlPullParserException
    //   92	100	1394	org/xmlpull/v1/XmlPullParserException
    //   104	115	1394	org/xmlpull/v1/XmlPullParserException
    //   119	126	1394	org/xmlpull/v1/XmlPullParserException
    //   130	138	1394	org/xmlpull/v1/XmlPullParserException
    //   142	148	1394	org/xmlpull/v1/XmlPullParserException
    //   152	160	1394	org/xmlpull/v1/XmlPullParserException
    //   164	184	1394	org/xmlpull/v1/XmlPullParserException
    //   188	193	1394	org/xmlpull/v1/XmlPullParserException
    //   197	202	1394	org/xmlpull/v1/XmlPullParserException
    //   211	220	1394	org/xmlpull/v1/XmlPullParserException
    //   224	233	1394	org/xmlpull/v1/XmlPullParserException
    //   237	244	1394	org/xmlpull/v1/XmlPullParserException
    //   248	257	1394	org/xmlpull/v1/XmlPullParserException
    //   261	268	1394	org/xmlpull/v1/XmlPullParserException
    //   272	283	1394	org/xmlpull/v1/XmlPullParserException
    //   325	334	1394	org/xmlpull/v1/XmlPullParserException
    //   338	346	1394	org/xmlpull/v1/XmlPullParserException
    //   355	361	1394	org/xmlpull/v1/XmlPullParserException
    //   365	374	1394	org/xmlpull/v1/XmlPullParserException
    //   378	387	1394	org/xmlpull/v1/XmlPullParserException
    //   391	399	1394	org/xmlpull/v1/XmlPullParserException
    //   403	412	1394	org/xmlpull/v1/XmlPullParserException
    //   416	423	1394	org/xmlpull/v1/XmlPullParserException
    //   427	436	1394	org/xmlpull/v1/XmlPullParserException
    //   440	447	1394	org/xmlpull/v1/XmlPullParserException
    //   451	462	1394	org/xmlpull/v1/XmlPullParserException
    //   466	474	1394	org/xmlpull/v1/XmlPullParserException
    //   485	495	1394	org/xmlpull/v1/XmlPullParserException
    //   499	509	1394	org/xmlpull/v1/XmlPullParserException
    //   513	523	1394	org/xmlpull/v1/XmlPullParserException
    //   527	540	1394	org/xmlpull/v1/XmlPullParserException
    //   547	558	1394	org/xmlpull/v1/XmlPullParserException
    //   562	583	1394	org/xmlpull/v1/XmlPullParserException
    //   590	601	1394	org/xmlpull/v1/XmlPullParserException
    //   605	620	1394	org/xmlpull/v1/XmlPullParserException
    //   627	648	1394	org/xmlpull/v1/XmlPullParserException
    //   652	658	1394	org/xmlpull/v1/XmlPullParserException
    //   662	671	1394	org/xmlpull/v1/XmlPullParserException
    //   675	684	1394	org/xmlpull/v1/XmlPullParserException
    //   688	697	1394	org/xmlpull/v1/XmlPullParserException
    //   701	710	1394	org/xmlpull/v1/XmlPullParserException
    //   714	722	1394	org/xmlpull/v1/XmlPullParserException
    //   726	735	1394	org/xmlpull/v1/XmlPullParserException
    //   739	747	1394	org/xmlpull/v1/XmlPullParserException
    //   751	762	1394	org/xmlpull/v1/XmlPullParserException
    //   772	778	1394	org/xmlpull/v1/XmlPullParserException
    //   814	825	1394	org/xmlpull/v1/XmlPullParserException
    //   829	837	1394	org/xmlpull/v1/XmlPullParserException
    //   862	871	1394	org/xmlpull/v1/XmlPullParserException
    //   875	884	1394	org/xmlpull/v1/XmlPullParserException
    //   888	897	1394	org/xmlpull/v1/XmlPullParserException
    //   901	913	1394	org/xmlpull/v1/XmlPullParserException
    //   920	930	1394	org/xmlpull/v1/XmlPullParserException
    //   934	953	1394	org/xmlpull/v1/XmlPullParserException
    //   960	970	1394	org/xmlpull/v1/XmlPullParserException
    //   974	987	1394	org/xmlpull/v1/XmlPullParserException
    //   994	1013	1394	org/xmlpull/v1/XmlPullParserException
    //   1017	1023	1394	org/xmlpull/v1/XmlPullParserException
    //   1027	1036	1394	org/xmlpull/v1/XmlPullParserException
    //   1040	1049	1394	org/xmlpull/v1/XmlPullParserException
    //   1053	1062	1394	org/xmlpull/v1/XmlPullParserException
    //   1066	1075	1394	org/xmlpull/v1/XmlPullParserException
    //   1079	1086	1394	org/xmlpull/v1/XmlPullParserException
    //   1090	1099	1394	org/xmlpull/v1/XmlPullParserException
    //   1103	1110	1394	org/xmlpull/v1/XmlPullParserException
    //   1114	1125	1394	org/xmlpull/v1/XmlPullParserException
    //   1132	1140	1394	org/xmlpull/v1/XmlPullParserException
    //   1163	1171	1394	org/xmlpull/v1/XmlPullParserException
    //   1175	1187	1394	org/xmlpull/v1/XmlPullParserException
    //   1191	1199	1394	org/xmlpull/v1/XmlPullParserException
    //   1203	1211	1394	org/xmlpull/v1/XmlPullParserException
    //   1215	1222	1394	org/xmlpull/v1/XmlPullParserException
    //   1226	1236	1394	org/xmlpull/v1/XmlPullParserException
    //   1243	1255	1394	org/xmlpull/v1/XmlPullParserException
    //   1259	1267	1394	org/xmlpull/v1/XmlPullParserException
    //   1271	1279	1394	org/xmlpull/v1/XmlPullParserException
    //   1283	1290	1394	org/xmlpull/v1/XmlPullParserException
    //   1294	1304	1394	org/xmlpull/v1/XmlPullParserException
    //   1308	1316	1394	org/xmlpull/v1/XmlPullParserException
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
      return paramArrayOfByte;
    }
    catch (Throwable paramArrayOfByte)
    {
      if (QLog.isColorLevel())
      {
        QLog.d("OlympicUtil", 2, "inflateConfigString");
        paramArrayOfByte.printStackTrace();
      }
    }
    return null;
  }
  
  public static SharedPreferences b(Context paramContext)
  {
    return paramContext.getSharedPreferences("qcamera_local", 4);
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
    if (k > j) {
      i = 1;
    } else {
      i = 0;
    }
    double d1 = Math.max(j, k);
    Double.isNaN(d1);
    double d2 = Math.min(j, k);
    Double.isNaN(d2);
    double d6 = d1 * 1.0D / d2;
    d1 = paramRect.height();
    Double.isNaN(d1);
    d2 = paramRect.width();
    Double.isNaN(d2);
    double d7 = d1 * 1.0D / d2;
    double d5 = k;
    d2 = j;
    if (d6 > d7) {
      if (i != 0) {
        Double.isNaN(d2);
      }
    }
    for (d1 = d7 * d2;; d1 *= d2)
    {
      d3 = d2;
      d4 = d1;
      break label269;
      Double.isNaN(d5);
      for (d1 = d7 * d5;; d1 *= d5)
      {
        break label261;
        if (d6 >= d7) {
          break label257;
        }
        if (i == 0) {
          break;
        }
        d1 = 1.0D / d7;
        Double.isNaN(d5);
      }
      d1 = 1.0D / d7;
      Double.isNaN(d2);
    }
    label257:
    d1 = d2;
    label261:
    double d4 = d5;
    double d3 = d1;
    label269:
    if (QLog.isColorLevel())
    {
      paramRect = new StringBuilder();
      paramRect.append("clipJpegToBitmap tw=");
      paramRect.append(d4);
      paramRect.append(" th=");
      paramRect.append(d3);
      paramRect.append(" bw=");
      paramRect.append(k);
      paramRect.append(" bh=");
      paramRect.append(j);
      paramRect.append(" br=");
      paramRect.append(d6);
      paramRect.append(" sr=");
      paramRect.append(d7);
      QLog.i("Q.camera.CameraUtils", 2, paramRect.toString());
    }
    localOptions.inJustDecodeBounds = false;
    Double.isNaN(d5);
    d1 = (d5 - d4) / 2.0D;
    Double.isNaN(d5);
    d5 = (d5 + d4) / 2.0D;
    Double.isNaN(d2);
    d6 = (d2 - d3) / 2.0D;
    Double.isNaN(d2);
    d2 = (d2 + d3) / 2.0D;
    if (Build.VERSION.SDK_INT >= 10)
    {
      paramRect = new Rect((int)d1, (int)d6, (int)d5, (int)d2);
      paramArrayOfByte = BitmapRegionDecoder.newInstance(paramArrayOfByte, 0, paramArrayOfByte.length, true);
      paramRect = paramArrayOfByte.decodeRegion(paramRect, localOptions);
      paramArrayOfByte.recycle();
      paramArrayOfByte = new Matrix();
      paramArrayOfByte.setRotate(paramInt, paramRect.getWidth() / 2.0F, paramRect.getHeight() / 2.0F);
      if (paramBoolean) {
        paramArrayOfByte.postScale(-1.0F, 1.0F);
      }
      return Bitmap.createBitmap(paramRect, 0, 0, paramRect.getWidth(), paramRect.getHeight(), paramArrayOfByte, false);
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
      paramRect = Bitmap.createBitmap(paramArrayOfByte, (int)(d1 / 2.0D), (int)(d6 / 2.0D), (int)(d4 / 2.0D), (int)(d3 / 2.0D), paramRect, false);
      paramArrayOfByte.recycle();
      return paramRect;
    }
    catch (OutOfMemoryError paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    for (;;)
    {
      throw paramArrayOfByte;
    }
  }
  
  public static boolean b()
  {
    return Build.VERSION.SDK_INT >= CameraWrapper.a().a();
  }
  
  public static boolean c()
  {
    if (CameraWrapper.a().b() < 1) {
      return false;
    }
    if (!CameraWrapper.a().d()) {
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.i("Q.camera.CameraUtils", 2, "isCameraReady  OK");
    }
    return true;
  }
  
  public static boolean d()
  {
    try
    {
      int j = CameraWrapper.a().b();
      if (j > 0)
      {
        int i = 0;
        while (i < j)
        {
          Camera.CameraInfo localCameraInfo = new Camera.CameraInfo();
          Camera.getCameraInfo(i, localCameraInfo);
          int k = localCameraInfo.facing;
          if (1 == k) {
            return true;
          }
          i += 1;
        }
      }
      return false;
    }
    catch (RuntimeException localRuntimeException)
    {
      QLog.e("Q.camera.CameraUtils", 1, "hasFrontCamera error, ", localRuntimeException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.camera.utils.CameraUtils
 * JD-Core Version:    0.7.0.1
 */