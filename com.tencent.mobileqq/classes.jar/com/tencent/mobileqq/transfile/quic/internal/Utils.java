package com.tencent.mobileqq.transfile.quic.internal;

import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.reflect.Method;
import mqq.app.MobileQQ;

public class Utils
{
  public static final String ANDROMEDA_NAME = "libandromeda.so";
  public static final String QUIC_LIB_NAME = "libquic_engine.so";
  public static final String TAG = "quic";
  
  public static boolean checkIfCPUx86()
  {
    if (Build.VERSION.SDK_INT > 27) {
      return false;
    }
    String str = getSystemProperty("ro.product.cpu.abi", "arm");
    if (TextUtils.isEmpty(str)) {
      return false;
    }
    return str.contains("x86");
  }
  
  public static String getAndromedaSoPath()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(getQuicSoSavePath());
    localStringBuilder.append("libandromeda.so");
    return localStringBuilder.toString();
  }
  
  public static String getQuicEngineSoPath()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(getQuicSoSavePath());
    localStringBuilder.append("libquic_engine.so");
    return localStringBuilder.toString();
  }
  
  public static String getQuicSoSavePath()
  {
    try
    {
      Object localObject = new File(MobileQQ.getContext().getFilesDir(), "/quic_net_res");
      if (!((File)localObject).exists()) {
        ((File)localObject).mkdirs();
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(((File)localObject).getAbsolutePath());
      localStringBuilder.append(File.separator);
      localObject = localStringBuilder.toString();
      return localObject;
    }
    catch (NullPointerException localNullPointerException)
    {
      QLog.e("quic", 1, "npe:", localNullPointerException);
    }
    return "/quic_net_res";
  }
  
  private static String getSystemProperty(String paramString1, String paramString2)
  {
    try
    {
      Class localClass = Class.forName("android.os.SystemProperties");
      paramString1 = (String)localClass.getMethod("get", new Class[] { String.class, String.class }).invoke(localClass, new Object[] { paramString1, "" });
      return paramString1;
    }
    catch (Exception paramString1)
    {
      QLog.e("quic", 4, paramString1, new Object[0]);
    }
    return paramString2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.quic.internal.Utils
 * JD-Core Version:    0.7.0.1
 */