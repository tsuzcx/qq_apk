package com.tencent.mobileqq.weiyun.api.impl;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Environment;
import android.text.TextUtils;
import android.util.SparseArray;
import com.qq.jce.wup.BasicClassTypeUtil;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.pluginsdk.PluginRuntime;
import com.tencent.mobileqq.pluginsdk.PluginStatic;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.mobileqq.weiyun.TransmissionHelper;
import com.tencent.mobileqq.weiyun.api.IWeiyunApi;
import com.tencent.mobileqq.weiyun.api.IWeiyunHelper;
import com.tencent.mobileqq.weiyun.api.download.IWeiyunSoListener;
import com.tencent.mobileqq.weiyun.utils.SoHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import com.tencent.weiyun.utils.NetworkUtils;
import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public final class WeiyunHelperImpl
  implements IWeiyunHelper
{
  private static final String CLS_WEIYUN_RUNTIME = "com.weiyun.plugin.app.WeiyunRuntime";
  private static final String OPEN_QQ_VIP_STRATEIE_URL = "https://h5.vip.qq.com/proxy/domain/imgcache.qq.com/club/platform/lib/pay/wv_proxy.html?_wv=524289&aid=%s";
  private static final Map<Integer, String> THUMB_TYPE_SIZE = new HashMap();
  private static final SparseArray<String> VIDEO_THUMB_TYPE_SIZE;
  private static String sDefaultRecvPath;
  private static String sDefaultThumbPath;
  private static String sDefaultUploadPDirKey = "";
  private static String sDefaultUploadPpDirKey = "";
  private static volatile boolean sDowngrade = false;
  private static boolean sStart = false;
  
  static
  {
    THUMB_TYPE_SIZE.put(Integer.valueOf(0), "16*16");
    THUMB_TYPE_SIZE.put(Integer.valueOf(1), "32*32");
    THUMB_TYPE_SIZE.put(Integer.valueOf(2), "64*64");
    THUMB_TYPE_SIZE.put(Integer.valueOf(3), "128*128");
    THUMB_TYPE_SIZE.put(Integer.valueOf(4), "320*320");
    THUMB_TYPE_SIZE.put(Integer.valueOf(5), "384*384");
    THUMB_TYPE_SIZE.put(Integer.valueOf(6), "640*640");
    THUMB_TYPE_SIZE.put(Integer.valueOf(7), "750*750");
    THUMB_TYPE_SIZE.put(Integer.valueOf(8), "1024*1024");
    VIDEO_THUMB_TYPE_SIZE = new SparseArray(9);
    VIDEO_THUMB_TYPE_SIZE.put(0, "/16");
    VIDEO_THUMB_TYPE_SIZE.put(1, "/32");
    VIDEO_THUMB_TYPE_SIZE.put(2, "/64");
    VIDEO_THUMB_TYPE_SIZE.put(3, "/128");
    VIDEO_THUMB_TYPE_SIZE.put(4, "/320");
    VIDEO_THUMB_TYPE_SIZE.put(5, "/384");
    VIDEO_THUMB_TYPE_SIZE.put(6, "/640");
    VIDEO_THUMB_TYPE_SIZE.put(7, "/750");
    VIDEO_THUMB_TYPE_SIZE.put(8, "/1024");
  }
  
  private static void initPath(Application paramApplication)
  {
    sDefaultRecvPath = AppConstants.SDCARD_FILE_SAVE_PATH;
    if ("mounted".equals(Environment.getExternalStorageState())) {
      paramApplication = new File(VFSAssistantUtils.getSDKPrivatePath(AppConstants.SDCARD_PATH));
    } else {
      paramApplication = paramApplication.getCacheDir();
    }
    sDefaultThumbPath = new File(paramApplication, "diskcache").getAbsolutePath();
  }
  
  public boolean checkSOExists(Context paramContext)
  {
    return SoHelper.a(paramContext);
  }
  
  public void cleanPwdRecord(Context paramContext, long paramLong)
  {
    ((IWeiyunApi)QRoute.api(IWeiyunApi.class)).cleanPwdRecord(paramContext, paramLong);
  }
  
  public void clearDefaultUploadDirKey()
  {
    sDefaultUploadPpDirKey = "";
    sDefaultUploadPDirKey = "";
  }
  
  public PluginRuntime createRuntime(Context paramContext)
  {
    for (;;)
    {
      try
      {
        try
        {
          localObject = Class.forName("com.weiyun.plugin.app.WeiyunRuntime");
          paramContext = (Context)localObject;
        }
        catch (Exception paramContext) {}catch (NoSuchMethodException paramContext) {}catch (InvocationTargetException paramContext) {}catch (InstantiationException paramContext) {}catch (IllegalAccessException paramContext) {}catch (IllegalArgumentException paramContext) {}
      }
      catch (ClassNotFoundException localClassNotFoundException)
      {
        Object localObject;
        continue;
        if (paramContext != null) {
          continue;
        }
      }
      try
      {
        localObject = PluginStatic.getOrCreateClassLoader(paramContext, "WeiyunPlugin.apk");
        paramContext = ((ClassLoader)localObject).loadClass("com.weiyun.plugin.app.WeiyunRuntime");
        BasicClassTypeUtil.setClassLoader(true, (ClassLoader)localObject);
      }
      catch (ClassNotFoundException paramContext)
      {
        paramContext.printStackTrace();
      }
    }
    paramContext = paramContext.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
    if ((paramContext != null) && ((paramContext instanceof PluginRuntime)))
    {
      paramContext = (PluginRuntime)paramContext;
      return paramContext;
      paramContext.printStackTrace();
      return null;
      paramContext.printStackTrace();
      return null;
      paramContext.printStackTrace();
      return null;
      paramContext.printStackTrace();
      return null;
      paramContext.printStackTrace();
      return null;
      paramContext.printStackTrace();
      return null;
    }
    return null;
    return null;
  }
  
  public void downgradePath()
  {
    if (!sDowngrade)
    {
      sDefaultRecvPath = MobileQQ.sMobileQQ.getFilesDir().getAbsolutePath();
      sDefaultThumbPath = MobileQQ.sMobileQQ.getCacheDir().getAbsolutePath();
      sDowngrade = true;
    }
  }
  
  public void downloadSo(Context paramContext, IWeiyunSoListener paramIWeiyunSoListener)
  {
    SoHelper.a(paramContext, paramIWeiyunSoListener);
  }
  
  public Pair<Pair<String, String>, Long> genThumbInfo(String paramString, int paramInt, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString)) {
      return new Pair(new Pair(paramString, paramString), Long.valueOf(0L));
    }
    String str = (String)THUMB_TYPE_SIZE.get(Integer.valueOf(paramInt));
    paramString = new StringBuilder(paramString);
    if (paramBoolean)
    {
      str = (String)VIDEO_THUMB_TYPE_SIZE.get(paramInt);
      if (!TextUtils.isEmpty(str)) {
        paramString.append(str);
      }
      paramString = paramString.toString();
      l = paramString.hashCode() * 31;
      return new Pair(new Pair(paramString, paramString), Long.valueOf(l));
    }
    paramInt = NetworkUtils.getNetworkType(MobileQQ.sMobileQQ);
    paramString.append("&nettype=");
    paramString.append(paramInt);
    if (!TextUtils.isEmpty(str))
    {
      paramString.append("&size=");
      paramString.append(str);
    }
    paramString = paramString.toString();
    str = paramString.replaceFirst("cn=\\d", "").replaceFirst("nettype=\\d", "");
    long l = str.hashCode() * 31;
    return new Pair(new Pair(paramString, str), Long.valueOf(l));
  }
  
  public String getDefaultDownloadPath()
  {
    return sDefaultRecvPath;
  }
  
  public String getDefaultThumbPath()
  {
    return sDefaultThumbPath;
  }
  
  public String[] getDefaultUploadDirKey()
  {
    return new String[] { sDefaultUploadPpDirKey, sDefaultUploadPDirKey };
  }
  
  public String getOpenQQVipH5(String paramString1, String paramString2)
  {
    paramString1 = String.format("https://h5.vip.qq.com/proxy/domain/imgcache.qq.com/club/platform/lib/pay/wv_proxy.html?_wv=524289&aid=%s", new Object[] { paramString2 });
    paramString2 = new StringBuilder();
    paramString2.append("qq vip payurl : ");
    paramString2.append(paramString1);
    QLog.d("Weiyun.AlbumBackup", 2, paramString2.toString());
    return paramString1;
  }
  
  public String getOpenWeiyunBuySpaceH5()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("weiyun shapce payurl : ");
    localStringBuilder.append("https://jump.weiyun.com/?from=3047");
    QLog.d("Weiyun.AlbumBackup", 2, localStringBuilder.toString());
    return "https://jump.weiyun.com/?from=3047";
  }
  
  public String getOpenWeiyunVipH5(String paramString1, String paramString2)
  {
    paramString1 = String.format("https://jump.weiyun.com/?from=30001&aid=%s", new Object[] { paramString2 });
    paramString2 = new StringBuilder();
    paramString2.append("weiyun vip payurl : ");
    paramString2.append(paramString1);
    QLog.d("Weiyun.AlbumBackup", 2, paramString2.toString());
    return paramString1;
  }
  
  public File getUploadSoFile(Context paramContext)
  {
    return SoHelper.a(paramContext);
  }
  
  public void notifyEnterFileAssit(Context paramContext)
  {
    paramContext.sendBroadcast(new Intent("enter_file_assit"), "com.tencent.msg.permission.pushnotify");
  }
  
  public void notifyExitFileAssit(Context paramContext)
  {
    paramContext.sendBroadcast(new Intent("exit_file_assit"), "com.tencent.msg.permission.pushnotify");
  }
  
  public void saveDefaultUploadDirKey(String paramString1, String paramString2)
  {
    if (!TextUtils.isEmpty(paramString1)) {
      sDefaultUploadPpDirKey = paramString1;
    }
    if (!TextUtils.isEmpty(paramString2)) {
      sDefaultUploadPDirKey = paramString2;
    }
  }
  
  public void shutdownWySystem()
  {
    if (sStart) {
      try
      {
        if (sStart)
        {
          TransmissionHelper.a(false, MobileQQ.sMobileQQ.waitAppRuntime(null).getLongAccountUin());
          sStart = false;
        }
        return;
      }
      finally {}
    }
  }
  
  public void startWySystem()
  {
    if (!sStart) {
      try
      {
        if (!sStart)
        {
          TransmissionHelper.a(MobileQQ.sMobileQQ, false);
          ((IWeiyunApi)QRoute.api(IWeiyunApi.class)).initPwdRecord(MobileQQ.sMobileQQ);
          initPath(MobileQQ.sMobileQQ);
          sStart = true;
        }
        return;
      }
      finally {}
    }
  }
  
  public void upgradePath()
  {
    if (sDowngrade)
    {
      initPath(MobileQQ.sMobileQQ);
      sDowngrade = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.weiyun.api.impl.WeiyunHelperImpl
 * JD-Core Version:    0.7.0.1
 */