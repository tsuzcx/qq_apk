package com.tencent.mobileqq.shortvideo.util;

import android.content.Context;
import android.os.Build.VERSION;
import com.tencent.aelight.camera.api.IAEPath;
import com.tencent.aelight.camera.api.ICameraCompatible;
import com.tencent.aelight.camera.constants.CameraCompatibleConstants;
import com.tencent.aelight.camera.download.api.AEResInfo;
import com.tencent.aelight.camera.download.api.IAEDownloadCallBack;
import com.tencent.aelight.camera.download.api.IAEResDownload;
import com.tencent.aelight.camera.download.api.IAEResUtil;
import com.tencent.aelight.camera.util.api.IMediaCodecDPC;
import com.tencent.av.core.VcSystemInfo;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qmcf.QmcfManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.ShortVideoArtResourceMgr;
import com.tencent.mobileqq.shortvideo.ShortVideoPortraitResourceManager;
import com.tencent.mobileqq.shortvideo.ShortVideoResDownload;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sveffects.SvEffectSdkInitor;
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(AppConstants.SDCARD_PATH);
    localStringBuilder.append("early");
    jdField_a_of_type_JavaLangString = localStringBuilder.toString();
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { "qq.android.native.short.video.filter.const", "qq.android.native.short.video.filter.const.v1", "qq.android.native.short.video.filter.const.v2", "qq.android.native.short.video.filter.const.v3", "qq.android.native.short.video.filter.const.v4", "qq.android.native.short.video.filter.const.v665", "qq.android.native.short.video.filter.const.v700" };
    jdField_b_of_type_ArrayOfJavaLangString = new String[] { "qq.android.native.short.video.filter.var", "qq.android.native.short.video.filter.var.v1", "qq.android.native.short.video.filter.var.v2", "qq.android.native.short.video.filter.var.v3", "qq.android.native.short.video.filter.var.v665" };
    jdField_c_of_type_ArrayOfJavaLangString = new String[] { "qq.android.native.short.video.x86", "qq.android.native.short.video", "qq.android.native.short.video.v658", "qq.android.native.short.video.v660", "qq.android.native.short.video.v665", "qq.android.native.short.video.v670", "qq.android.native.short.video.v700" };
  }
  
  public static int a()
  {
    int i;
    if (c())
    {
      if (d()) {
        i = 1;
      } else {
        i = 2;
      }
    }
    else {
      i = 0;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getQmcfSoState:");
      localStringBuilder.append(i);
      QLog.d("PtvFilterSoLoad", 2, localStringBuilder.toString());
    }
    return i;
  }
  
  public static String a()
  {
    return ((IAEPath)QRoute.api(IAEPath.class)).getPendantBasePath();
  }
  
  public static boolean a()
  {
    int i;
    if ((!((ICameraCompatible)QRoute.api(ICameraCompatible.class)).isFoundProductManufacturer(CameraCompatibleConstants.w)) && (!((ICameraCompatible)QRoute.api(ICameraCompatible.class)).isNotSupportFilterBasedSdk())) {
      i = 0;
    } else {
      i = 1;
    }
    if (i != 0) {
      return false;
    }
    boolean bool = VcSystemInfo.isBeautySupported();
    try
    {
      localClass = Class.forName("android.opengl.EGL14");
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      Class localClass;
      label64:
      break label64;
    }
    localClass = null;
    return (bool) && (localClass != null) && (Build.VERSION.SDK_INT >= 17);
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
  
  public static boolean a(QQAppInterface paramQQAppInterface, Context paramContext, IAEDownloadCallBack paramIAEDownloadCallBack)
  {
    try
    {
      boolean bool3 = a();
      boolean bool2 = false;
      boolean bool1;
      if (bool3)
      {
        ((IAEResDownload)QRoute.api(IAEResDownload.class)).requestDownload(AEResInfo.AE_RES_BASE_PACKAGE, paramIAEDownloadCallBack, false);
        ((IAEResDownload)QRoute.api(IAEResDownload.class)).requestDownload(AEResInfo.LIGHT_RES_BASE_PACKAGE, paramIAEDownloadCallBack, false);
        ShortVideoResDownload.a(paramQQAppInterface);
        bool1 = ((IAEResUtil)QRoute.api(IAEResUtil.class)).isLightCameraResExist();
      }
      else
      {
        bool1 = bool2;
        if (paramIAEDownloadCallBack != null)
        {
          paramIAEDownloadCallBack.onAEDownloadFinish(AEResInfo.AE_RES_BASE_PACKAGE, null, false, -1);
          bool1 = bool2;
        }
      }
      if (QLog.isColorLevel())
      {
        paramQQAppInterface = new StringBuilder();
        paramQQAppInterface.append("startDownloadFilterSo, soExist[");
        paramQQAppInterface.append(bool1);
        paramQQAppInterface.append("], support[");
        paramQQAppInterface.append(bool3);
        paramQQAppInterface.append("]");
        QLog.i("PtuResCheck", 2, paramQQAppInterface.toString());
      }
      return bool1;
    }
    finally {}
  }
  
  public static String b()
  {
    String str = ShortVideoArtResourceMgr.a();
    if (str.equals("artfilter000_0"))
    {
      VideoEnvironment.LogDownLoad("PtvFilterSoLoad", "getValidArtFilterPath:pathVersion=artfilter000_0", null);
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(ShortVideoArtResourceMgr.b());
    localStringBuilder.append(str);
    localStringBuilder.append(File.separator);
    return localStringBuilder.toString();
  }
  
  private static void b()
  {
    Object localObject1 = new File(jdField_a_of_type_JavaLangString);
    if (!((File)localObject1).exists()) {
      return;
    }
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(((File)localObject1).getAbsolutePath());
    ((StringBuilder)localObject2).append(File.separator);
    localObject1 = ((StringBuilder)localObject2).toString();
    int k = 0;
    int i = 0;
    while (i < jdField_a_of_type_ArrayOfJavaLangString.length)
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append(jdField_a_of_type_ArrayOfJavaLangString[i]);
      localObject2 = new File(((StringBuilder)localObject2).toString());
      if (((File)localObject2).exists()) {
        ((File)localObject2).delete();
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
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append(jdField_b_of_type_ArrayOfJavaLangString[i]);
      localObject2 = new File(((StringBuilder)localObject2).toString());
      if (((File)localObject2).exists()) {
        ((File)localObject2).delete();
      }
      i += 1;
    }
    while (j < jdField_c_of_type_ArrayOfJavaLangString.length)
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append(jdField_c_of_type_ArrayOfJavaLangString[j]);
      localObject2 = new File(((StringBuilder)localObject2).toString());
      if (((File)localObject2).exists()) {
        ((File)localObject2).delete();
      }
      j += 1;
    }
  }
  
  public static boolean b()
  {
    boolean bool1 = ((IAEResUtil)QRoute.api(IAEResUtil.class)).isAEBaseSoReady();
    boolean bool2 = VideoEnvironment.isShortVideoSoLibLoaded();
    return (bool1) && (bool2);
  }
  
  public static boolean c()
  {
    if (Build.VERSION.SDK_INT < 21) {
      return false;
    }
    return QmcfManager.getInstance().isQmcfSupported();
  }
  
  public static boolean d()
  {
    return PtvFilterSoLoad.SVFilterSoLoadStatus.a();
  }
  
  public static boolean e()
  {
    if (jdField_b_of_type_Boolean) {
      return d;
    }
    int i = Build.VERSION.SDK_INT;
    boolean bool3 = false;
    boolean bool1;
    if (i >= 21) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    boolean bool4 = ShortVideoPortraitResourceManager.b() ^ true;
    boolean bool5 = ((IMediaCodecDPC)QRoute.api(IMediaCodecDPC.class)).isPortraitSwitchOpen();
    boolean bool2 = bool3;
    if (bool1)
    {
      bool2 = bool3;
      if (bool4)
      {
        bool2 = bool3;
        if (bool5) {
          bool2 = true;
        }
      }
    }
    d = bool2;
    jdField_b_of_type_Boolean = true;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("isSupportPortarit sdkSupport:");
      localStringBuilder.append(bool1);
      localStringBuilder.append(", whiteList:");
      localStringBuilder.append(bool4);
      localStringBuilder.append(", switchOpen:");
      localStringBuilder.append(bool5);
      QLog.i("PtvFilterSoLoad", 2, localStringBuilder.toString());
    }
    return d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.util.PtvFilterSoLoad
 * JD-Core Version:    0.7.0.1
 */