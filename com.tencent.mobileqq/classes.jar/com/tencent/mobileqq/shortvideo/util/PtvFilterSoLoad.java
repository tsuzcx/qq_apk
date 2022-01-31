package com.tencent.mobileqq.shortvideo.util;

import aidt;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Environment;
import com.tencent.av.core.VcSystemInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qmcf.QmcfManager;
import com.tencent.mobileqq.shortvideo.PendantVersionManager;
import com.tencent.mobileqq.shortvideo.ShortVideoArtResourceMgr;
import com.tencent.mobileqq.shortvideo.ShortVideoPortraitResourceManager;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraCompatibleList;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sveffects.SvEffectSdkInitor;
import com.tencent.ttpic.ar.util.ARMatrixUtil;
import java.io.File;

public class PtvFilterSoLoad
{
  private static PtvFilterSoLoad.SVFilterDownloadSession jdField_a_of_type_ComTencentMobileqqShortvideoUtilPtvFilterSoLoad$SVFilterDownloadSession;
  private static final Object jdField_a_of_type_JavaLangObject;
  private static final String jdField_a_of_type_JavaLangString;
  private static boolean jdField_a_of_type_Boolean;
  private static final String[] jdField_a_of_type_ArrayOfJavaLangString = { "qq.android.native.short.video.filter.const", "qq.android.native.short.video.filter.const.v1", "qq.android.native.short.video.filter.const.v2", "qq.android.native.short.video.filter.const.v3", "qq.android.native.short.video.filter.const.v4", "qq.android.native.short.video.filter.const.v665", "qq.android.native.short.video.filter.const.v700" };
  private static final String jdField_b_of_type_JavaLangString;
  private static boolean jdField_b_of_type_Boolean;
  private static final String[] jdField_b_of_type_ArrayOfJavaLangString = { "qq.android.native.short.video.filter.var", "qq.android.native.short.video.filter.var.v1", "qq.android.native.short.video.filter.var.v2", "qq.android.native.short.video.filter.var.v3", "qq.android.native.short.video.filter.var.v665" };
  private static boolean jdField_c_of_type_Boolean;
  private static final String[] jdField_c_of_type_ArrayOfJavaLangString = { "qq.android.native.short.video.x86", "qq.android.native.short.video", "qq.android.native.short.video.v658", "qq.android.native.short.video.v660", "qq.android.native.short.video.v665", "qq.android.native.short.video.v670", "qq.android.native.short.video.v700" };
  private static boolean d;
  private static boolean e;
  
  static
  {
    SvEffectSdkInitor.a();
    jdField_a_of_type_JavaLangString = Environment.getDataDirectory() + "/data/" + "com.tencent.mobileqq" + "/app_lib/qq_filter/";
    jdField_a_of_type_JavaLangObject = new Object();
    jdField_a_of_type_ComTencentMobileqqShortvideoUtilPtvFilterSoLoad$SVFilterDownloadSession = new PtvFilterSoLoad.SVFilterDownloadSession();
    jdField_b_of_type_JavaLangString = AppConstants.aJ + "early";
  }
  
  public static int a()
  {
    int i;
    if (d()) {
      if (b(BaseApplicationImpl.getContext())) {
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
  
  public static int a(Context paramContext)
  {
    int i;
    if (b()) {
      if (a(paramContext)) {
        i = 1;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PtvFilterSoLoad", 2, "getFilterSoState " + i);
      }
      return i;
      i = 2;
      continue;
      i = 0;
    }
  }
  
  public static String a(Context paramContext)
  {
    if (paramContext == null) {
      return jdField_a_of_type_JavaLangString;
    }
    paramContext = paramContext.getFilesDir();
    if (paramContext != null) {
      return paramContext.getParent() + "/app_lib/qq_filter/";
    }
    return jdField_a_of_type_JavaLangString;
  }
  
  public static String a(Context paramContext, int[] paramArrayOfInt)
  {
    paramArrayOfInt = PendantVersionManager.a();
    if (paramArrayOfInt.equals("Pendant000_0"))
    {
      VideoEnvironment.a("PtvFilterSoLoad", "getSVFilterSoPath:pathVersion=Pendant000_0", null);
      return null;
    }
    return a(paramContext) + paramArrayOfInt + File.separator;
  }
  
  public static void a()
  {
    int k = 0;
    Object localObject = new File(jdField_b_of_type_JavaLangString);
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
  
  public static boolean a()
  {
    return SoLoader.e();
  }
  
  public static boolean a(Context paramContext)
  {
    return PtvFilterSoLoad.SVFilterSoLoadStatus.a(paramContext);
  }
  
  public static boolean a(Context paramContext, boolean paramBoolean)
  {
    return SoLoader.a(paramContext, paramBoolean);
  }
  
  /* Error */
  public static boolean a(com.tencent.mobileqq.app.QQAppInterface paramQQAppInterface, Context paramContext)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: invokestatic 145	com/tencent/mobileqq/shortvideo/util/PtvFilterSoLoad:b	()Z
    //   6: ifeq +24 -> 30
    //   9: aload_0
    //   10: invokestatic 212	com/tencent/mobileqq/shortvideo/ShortVideoResDownload:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)Z
    //   13: pop
    //   14: aload_1
    //   15: invokestatic 147	com/tencent/mobileqq/shortvideo/util/PtvFilterSoLoad:a	(Landroid/content/Context;)Z
    //   18: istore_2
    //   19: iload_2
    //   20: ifeq +10 -> 30
    //   23: iconst_1
    //   24: istore_2
    //   25: ldc 2
    //   27: monitorexit
    //   28: iload_2
    //   29: ireturn
    //   30: iconst_0
    //   31: istore_2
    //   32: goto -7 -> 25
    //   35: astore_0
    //   36: ldc 2
    //   38: monitorexit
    //   39: aload_0
    //   40: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	41	0	paramQQAppInterface	com.tencent.mobileqq.app.QQAppInterface
    //   0	41	1	paramContext	Context
    //   18	14	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   3	19	35	finally
  }
  
  public static boolean a(String paramString)
  {
    return PtvFilterSoLoad.SVFilterSoLoadStatus.a(paramString);
  }
  
  public static String b(Context paramContext)
  {
    int[] arrayOfInt = new int[1];
    String str = a(paramContext, arrayOfInt);
    if (str != null) {}
    for (paramContext = str;; paramContext = "null")
    {
      VideoEnvironment.a("PtvFilterSoLoad", "getSVFilterSoPath:errCode=" + arrayOfInt[0] + ",pathLog=" + paramContext, null);
      return str;
    }
  }
  
  public static void b()
  {
    if (!jdField_a_of_type_Boolean)
    {
      jdField_a_of_type_Boolean = true;
      ThreadManager.post(new aidt(), 5, null, false);
    }
  }
  
  public static boolean b()
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
      boolean bool = VcSystemInfo.e();
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
  
  public static boolean b(Context paramContext)
  {
    return PtvFilterSoLoad.SVFilterSoLoadStatus.b(paramContext);
  }
  
  public static String c(Context paramContext)
  {
    paramContext = ShortVideoArtResourceMgr.a();
    if (paramContext.equals("artfilter000_0"))
    {
      VideoEnvironment.a("PtvFilterSoLoad", "getValidArtFilterPath:pathVersion=artfilter000_0", null);
      return null;
    }
    return ShortVideoArtResourceMgr.b() + paramContext + File.separator;
  }
  
  public static boolean c()
  {
    boolean bool1 = PtvFilterSoLoad.SVFilterSoLoadStatus.a();
    boolean bool2 = VideoEnvironment.e();
    return (bool1) && (bool2);
  }
  
  public static String d(Context paramContext)
  {
    paramContext = ShortVideoPortraitResourceManager.a();
    if (paramContext.equals("Portrait000_0"))
    {
      VideoEnvironment.a("PtvFilterSoLoad", "getPortraitBasePath:pathVersion=Portrait000_0", null);
      return null;
    }
    return ShortVideoPortraitResourceManager.b() + paramContext + File.separator;
  }
  
  public static boolean d()
  {
    if (Build.VERSION.SDK_INT < 21) {}
    while (!QmcfManager.a().d()) {
      return false;
    }
    return true;
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
      boolean bool5 = MediaCodecDPC.i();
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
    boolean bool4 = MediaCodecDPC.k();
    if (!CameraCompatibleList.d()) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      boolean bool5 = ARMatrixUtil.hasGyroscope();
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.util.PtvFilterSoLoad
 * JD-Core Version:    0.7.0.1
 */