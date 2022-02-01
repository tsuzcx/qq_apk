package com.tencent.mobileqq.shortvideo.util;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build.VERSION;
import com.tencent.av.core.VcSystemInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qmcf.QmcfManager;
import com.tencent.mobileqq.shortvideo.ShortVideoArtResourceMgr;
import com.tencent.mobileqq.shortvideo.ShortVideoPortraitResourceManager;
import com.tencent.mobileqq.shortvideo.ShortVideoTrackingResourceMgr;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraCompatibleList;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sveffects.SvEffectSdkInitor;
import dov.com.qq.im.ae.AEPath.CAMERA.INTERNAL_FILES;
import dov.com.qq.im.ae.download.AEResUtil;
import dov.com.qq.im.ae.download.old.AEOldPath.CAMERA.INTERNAL_FILES;
import java.io.File;

public class PtvFilterSoLoad
{
  private static final Object jdField_a_of_type_JavaLangObject;
  private static final String jdField_a_of_type_JavaLangString;
  private static boolean jdField_a_of_type_Boolean = false;
  private static final String[] jdField_a_of_type_ArrayOfJavaLangString;
  private static boolean jdField_b_of_type_Boolean = false;
  private static final String[] jdField_b_of_type_ArrayOfJavaLangString;
  private static boolean jdField_c_of_type_Boolean = false;
  private static final String[] jdField_c_of_type_ArrayOfJavaLangString;
  private static boolean d = false;
  private static boolean e = false;
  private static boolean f = false;
  
  static
  {
    SvEffectSdkInitor.a();
    jdField_a_of_type_JavaLangObject = new Object();
    jdField_a_of_type_JavaLangString = AppConstants.SDCARD_PATH + "early";
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { "qq.android.native.short.video.filter.const", "qq.android.native.short.video.filter.const.v1", "qq.android.native.short.video.filter.const.v2", "qq.android.native.short.video.filter.const.v3", "qq.android.native.short.video.filter.const.v4", "qq.android.native.short.video.filter.const.v665", "qq.android.native.short.video.filter.const.v700" };
    jdField_b_of_type_ArrayOfJavaLangString = new String[] { "qq.android.native.short.video.filter.var", "qq.android.native.short.video.filter.var.v1", "qq.android.native.short.video.filter.var.v2", "qq.android.native.short.video.filter.var.v3", "qq.android.native.short.video.filter.var.v665" };
    jdField_c_of_type_ArrayOfJavaLangString = new String[] { "qq.android.native.short.video.x86", "qq.android.native.short.video", "qq.android.native.short.video.v658", "qq.android.native.short.video.v660", "qq.android.native.short.video.v665", "qq.android.native.short.video.v670", "qq.android.native.short.video.v700" };
  }
  
  public static int a()
  {
    int i;
    if (c()) {
      if (d()) {
        i = 1;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PtvFilterSoLoad", 2, "getQmcfSoState:" + i);
      }
      return i;
      i = 2;
      continue;
      i = 0;
    }
  }
  
  public static String a()
  {
    return AEPath.CAMERA.INTERNAL_FILES.jdField_a_of_type_JavaLangString;
  }
  
  public static boolean a()
  {
    int i;
    if ((CameraCompatibleList.e(CameraCompatibleList.w)) || (CameraCompatibleList.b()))
    {
      i = 1;
      if (i == 0) {
        break label28;
      }
    }
    for (;;)
    {
      return false;
      i = 0;
      break;
      label28:
      boolean bool = VcSystemInfo.isBeautySupported();
      try
      {
        Class localClass = Class.forName("android.opengl.EGL14");
        if ((!bool) || (localClass == null) || (Build.VERSION.SDK_INT < 17)) {
          continue;
        }
        return true;
      }
      catch (ClassNotFoundException localClassNotFoundException)
      {
        for (;;)
        {
          Object localObject = null;
        }
      }
    }
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    try
    {
      boolean bool = a(paramQQAppInterface, paramContext, null);
      return bool;
    }
    finally
    {
      paramQQAppInterface = finally;
      throw paramQQAppInterface;
    }
  }
  
  /* Error */
  public static boolean a(QQAppInterface paramQQAppInterface, Context paramContext, dov.com.qq.im.ae.download.AEResManager.AEDownloadCallBack paramAEDownloadCallBack)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 4
    //   3: ldc 2
    //   5: monitorenter
    //   6: invokestatic 168	com/tencent/mobileqq/shortvideo/util/PtvFilterSoLoad:a	()Z
    //   9: istore 5
    //   11: iload 5
    //   13: ifeq +85 -> 98
    //   16: invokestatic 173	dov/com/qq/im/ae/download/AEResManager:a	()Ldov/com/qq/im/ae/download/AEResManager;
    //   19: getstatic 178	dov/com/qq/im/ae/download/AEResInfo:b	Ldov/com/qq/im/ae/download/AEResInfo;
    //   22: aload_2
    //   23: iconst_0
    //   24: invokevirtual 181	dov/com/qq/im/ae/download/AEResManager:a	(Ldov/com/qq/im/ae/download/AEResInfo;Ldov/com/qq/im/ae/download/AEResManager$AEDownloadCallBack;Z)V
    //   27: invokestatic 173	dov/com/qq/im/ae/download/AEResManager:a	()Ldov/com/qq/im/ae/download/AEResManager;
    //   30: getstatic 183	dov/com/qq/im/ae/download/AEResInfo:c	Ldov/com/qq/im/ae/download/AEResInfo;
    //   33: aload_2
    //   34: iconst_0
    //   35: invokevirtual 181	dov/com/qq/im/ae/download/AEResManager:a	(Ldov/com/qq/im/ae/download/AEResInfo;Ldov/com/qq/im/ae/download/AEResManager$AEDownloadCallBack;Z)V
    //   38: aload_0
    //   39: invokestatic 188	com/tencent/mobileqq/shortvideo/ShortVideoResDownload:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)Z
    //   42: pop
    //   43: invokestatic 191	dov/com/qq/im/ae/download/AEResUtil:b	()Z
    //   46: istore_3
    //   47: invokestatic 115	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   50: ifeq +43 -> 93
    //   53: ldc 193
    //   55: iconst_2
    //   56: new 27	java/lang/StringBuilder
    //   59: dup
    //   60: invokespecial 28	java/lang/StringBuilder:<init>	()V
    //   63: ldc 195
    //   65: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   68: iload_3
    //   69: invokevirtual 198	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   72: ldc 200
    //   74: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   77: iload 5
    //   79: invokevirtual 198	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   82: ldc 202
    //   84: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   87: invokevirtual 43	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   90: invokestatic 205	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   93: ldc 2
    //   95: monitorexit
    //   96: iload_3
    //   97: ireturn
    //   98: iload 4
    //   100: istore_3
    //   101: aload_2
    //   102: ifnull -55 -> 47
    //   105: aload_2
    //   106: getstatic 178	dov/com/qq/im/ae/download/AEResInfo:b	Ldov/com/qq/im/ae/download/AEResInfo;
    //   109: aconst_null
    //   110: iconst_0
    //   111: iconst_m1
    //   112: invokeinterface 211 5 0
    //   117: iload 4
    //   119: istore_3
    //   120: goto -73 -> 47
    //   123: astore_0
    //   124: ldc 2
    //   126: monitorexit
    //   127: aload_0
    //   128: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	129	0	paramQQAppInterface	QQAppInterface
    //   0	129	1	paramContext	Context
    //   0	129	2	paramAEDownloadCallBack	dov.com.qq.im.ae.download.AEResManager.AEDownloadCallBack
    //   46	74	3	bool1	boolean
    //   1	117	4	bool2	boolean
    //   9	69	5	bool3	boolean
    // Exception table:
    //   from	to	target	type
    //   6	11	123	finally
    //   16	47	123	finally
    //   47	93	123	finally
    //   105	117	123	finally
  }
  
  public static String b()
  {
    return AEOldPath.CAMERA.INTERNAL_FILES.jdField_a_of_type_JavaLangString;
  }
  
  private static void b()
  {
    int k = 0;
    Object localObject = new File(jdField_a_of_type_JavaLangString);
    if (!((File)localObject).exists()) {}
    for (;;)
    {
      return;
      localObject = ((File)localObject).getAbsolutePath() + File.separator;
      int i = 0;
      File localFile;
      while (i < jdField_a_of_type_ArrayOfJavaLangString.length)
      {
        localFile = new File((String)localObject + jdField_a_of_type_ArrayOfJavaLangString[i]);
        if (localFile.exists()) {
          localFile.delete();
        }
        i += 1;
      }
      i = 0;
      int j;
      for (;;)
      {
        j = k;
        if (i >= jdField_b_of_type_ArrayOfJavaLangString.length) {
          break;
        }
        localFile = new File((String)localObject + jdField_b_of_type_ArrayOfJavaLangString[i]);
        if (localFile.exists()) {
          localFile.delete();
        }
        i += 1;
      }
      while (j < jdField_c_of_type_ArrayOfJavaLangString.length)
      {
        localFile = new File((String)localObject + jdField_c_of_type_ArrayOfJavaLangString[j]);
        if (localFile.exists()) {
          localFile.delete();
        }
        j += 1;
      }
    }
  }
  
  public static boolean b()
  {
    boolean bool1 = AEResUtil.a();
    boolean bool2 = VideoEnvironment.isShortVideoSoLibLoaded();
    return (bool1) && (bool2);
  }
  
  public static String c()
  {
    String str = ShortVideoArtResourceMgr.a();
    if (str.equals("artfilter000_0"))
    {
      VideoEnvironment.LogDownLoad("PtvFilterSoLoad", "getValidArtFilterPath:pathVersion=artfilter000_0", null);
      return null;
    }
    return ShortVideoArtResourceMgr.b() + str + File.separator;
  }
  
  public static boolean c()
  {
    if (Build.VERSION.SDK_INT < 21) {}
    while (!QmcfManager.getInstance().isQmcfSupported()) {
      return false;
    }
    return true;
  }
  
  public static String d()
  {
    String str = ShortVideoTrackingResourceMgr.a();
    if (str.equals("Tracking000_0"))
    {
      VideoEnvironment.LogDownLoad("PtvFilterSoLoad", "getTrackingBasePath:pathVersion=Tracking000_0", null);
      return null;
    }
    return ShortVideoTrackingResourceMgr.b() + str + File.separator;
  }
  
  public static boolean d()
  {
    return PtvFilterSoLoad.SVFilterSoLoadStatus.a();
  }
  
  public static boolean e()
  {
    boolean bool4 = false;
    if (jdField_b_of_type_Boolean) {
      return d;
    }
    boolean bool1;
    if (Build.VERSION.SDK_INT >= 21)
    {
      bool1 = true;
      if (ShortVideoPortraitResourceManager.b()) {
        break label126;
      }
    }
    label126:
    for (boolean bool2 = true;; bool2 = false)
    {
      boolean bool5 = MediaCodecDPC.h();
      boolean bool3 = bool4;
      if (bool1)
      {
        bool3 = bool4;
        if (bool2)
        {
          bool3 = bool4;
          if (bool5) {
            bool3 = true;
          }
        }
      }
      d = bool3;
      jdField_b_of_type_Boolean = true;
      if (QLog.isColorLevel()) {
        QLog.i("PtvFilterSoLoad", 2, "isSupportPortarit sdkSupport:" + bool1 + ", whiteList:" + bool2 + ", switchOpen:" + bool5);
      }
      return d;
      bool1 = false;
      break;
    }
  }
  
  public static boolean f()
  {
    boolean bool3 = false;
    if (jdField_c_of_type_Boolean) {
      return e;
    }
    boolean bool4 = MediaCodecDPC.j();
    if (!CameraCompatibleList.d()) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      boolean bool5 = h();
      boolean bool2 = bool3;
      if (bool4)
      {
        bool2 = bool3;
        if (bool1)
        {
          bool2 = bool3;
          if (bool5) {
            bool2 = true;
          }
        }
      }
      e = bool2;
      jdField_c_of_type_Boolean = true;
      if (QLog.isColorLevel()) {
        QLog.i("PtvFilterSoLoad", 2, "isSupportARParticle switchOpen:" + bool4 + ", notInBlackList:" + bool1 + ", hasGyroscope:" + bool5 + ", isSupportARParticle:" + e);
      }
      return e;
    }
  }
  
  public static boolean g()
  {
    f = true;
    return f;
  }
  
  private static boolean h()
  {
    return BaseApplicationImpl.getContext().getPackageManager().hasSystemFeature("android.hardware.sensor.gyroscope");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.util.PtvFilterSoLoad
 * JD-Core Version:    0.7.0.1
 */