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
  private static final Object a;
  private static final String b;
  private static final String[] c = { "qq.android.native.short.video.filter.const", "qq.android.native.short.video.filter.const.v1", "qq.android.native.short.video.filter.const.v2", "qq.android.native.short.video.filter.const.v3", "qq.android.native.short.video.filter.const.v4", "qq.android.native.short.video.filter.const.v665", "qq.android.native.short.video.filter.const.v700" };
  private static final String[] d = { "qq.android.native.short.video.filter.var", "qq.android.native.short.video.filter.var.v1", "qq.android.native.short.video.filter.var.v2", "qq.android.native.short.video.filter.var.v3", "qq.android.native.short.video.filter.var.v665" };
  private static final String[] e = { "qq.android.native.short.video.x86", "qq.android.native.short.video", "qq.android.native.short.video.v658", "qq.android.native.short.video.v660", "qq.android.native.short.video.v665", "qq.android.native.short.video.v670", "qq.android.native.short.video.v700" };
  private static boolean f = false;
  private static boolean g = false;
  private static boolean h = false;
  private static boolean i = false;
  private static boolean j = false;
  private static boolean k = false;
  
  static
  {
    SvEffectSdkInitor.a();
    a = new Object();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(AppConstants.SDCARD_PATH);
    localStringBuilder.append("early");
    b = localStringBuilder.toString();
  }
  
  public static boolean a()
  {
    int m;
    if ((!((ICameraCompatible)QRoute.api(ICameraCompatible.class)).isFoundProductManufacturer(CameraCompatibleConstants.w)) && (!((ICameraCompatible)QRoute.api(ICameraCompatible.class)).isNotSupportFilterBasedSdk())) {
      m = 0;
    } else {
      m = 1;
    }
    if (m != 0) {
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
    return ((IAEPath)QRoute.api(IAEPath.class)).getPendantBasePath();
  }
  
  public static String c()
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
  
  public static boolean d()
  {
    boolean bool1 = ((IAEResUtil)QRoute.api(IAEResUtil.class)).isAEBaseSoReady();
    boolean bool2 = VideoEnvironment.isShortVideoSoLibLoaded();
    return (bool1) && (bool2);
  }
  
  public static boolean e()
  {
    if (Build.VERSION.SDK_INT < 21) {
      return false;
    }
    return QmcfManager.getInstance().isQmcfSupported();
  }
  
  public static boolean f()
  {
    return PtvFilterSoLoad.SVFilterSoLoadStatus.a();
  }
  
  public static int g()
  {
    int m;
    if (e())
    {
      if (f()) {
        m = 1;
      } else {
        m = 2;
      }
    }
    else {
      m = 0;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getQmcfSoState:");
      localStringBuilder.append(m);
      QLog.d("PtvFilterSoLoad", 2, localStringBuilder.toString());
    }
    return m;
  }
  
  public static boolean h()
  {
    if (g) {
      return i;
    }
    int m = Build.VERSION.SDK_INT;
    boolean bool3 = false;
    boolean bool1;
    if (m >= 21) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    boolean bool4 = ShortVideoPortraitResourceManager.e() ^ true;
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
    i = bool2;
    g = true;
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
    return i;
  }
  
  private static void k()
  {
    Object localObject1 = new File(b);
    if (!((File)localObject1).exists()) {
      return;
    }
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(((File)localObject1).getAbsolutePath());
    ((StringBuilder)localObject2).append(File.separator);
    localObject1 = ((StringBuilder)localObject2).toString();
    int i1 = 0;
    int m = 0;
    while (m < c.length)
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append(c[m]);
      localObject2 = new File(((StringBuilder)localObject2).toString());
      if (((File)localObject2).exists()) {
        ((File)localObject2).delete();
      }
      m += 1;
    }
    m = 0;
    int n;
    for (;;)
    {
      n = i1;
      if (m >= d.length) {
        break;
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append(d[m]);
      localObject2 = new File(((StringBuilder)localObject2).toString());
      if (((File)localObject2).exists()) {
        ((File)localObject2).delete();
      }
      m += 1;
    }
    while (n < e.length)
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append(e[n]);
      localObject2 = new File(((StringBuilder)localObject2).toString());
      if (((File)localObject2).exists()) {
        ((File)localObject2).delete();
      }
      n += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.util.PtvFilterSoLoad
 * JD-Core Version:    0.7.0.1
 */