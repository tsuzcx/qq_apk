package org.light;

import android.app.Application;
import android.content.Context;
import java.lang.reflect.Method;
import org.light.device.ApiHelper;
import org.light.device.DeviceInstance;
import org.light.device.GpuScopeAttrs;
import org.light.gles.GLCapabilities;
import org.light.utils.LightLogUtil;

public class DeviceSupportUtil
{
  private static final String TAG = "DeviceSupportUtil";
  private static boolean inited = false;
  
  private static void init()
  {
    try
    {
      boolean bool = inited;
      if (bool) {
        return;
      }
      try
      {
        Context localContext = ((Application)Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, (Object[])null)).getApplicationContext();
        DeviceInstance.getInstance().initSettings(localContext, "");
        GLCapabilities.init(true);
        if ((GpuScopeAttrs.getInstance().getDeviceModel() == null) && (GpuScopeAttrs.getInstance().getGPuModel() == null)) {
          GpuScopeAttrs.getInstance().init(localContext, DeviceInstance.getInstance().getDeviceName(), GLCapabilities.getGPUInfo(), "");
        }
        inited = true;
      }
      catch (Exception localException)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("init failed: ");
        localStringBuilder.append(localException.getMessage());
        LightLogUtil.w("DeviceSupportUtil", localStringBuilder.toString());
      }
      return;
    }
    finally {}
  }
  
  /* Error */
  public static void init(String paramString)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc 24
    //   5: invokestatic 30	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   8: ldc 32
    //   10: iconst_0
    //   11: anewarray 26	java/lang/Class
    //   14: invokevirtual 36	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   17: aconst_null
    //   18: aconst_null
    //   19: checkcast 38	[Ljava/lang/Object;
    //   22: invokevirtual 44	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   25: checkcast 46	android/app/Application
    //   28: invokevirtual 50	android/app/Application:getApplicationContext	()Landroid/content/Context;
    //   31: astore_1
    //   32: invokestatic 56	org/light/device/DeviceInstance:getInstance	()Lorg/light/device/DeviceInstance;
    //   35: aload_1
    //   36: aload_0
    //   37: invokevirtual 62	org/light/device/DeviceInstance:initSettings	(Landroid/content/Context;Ljava/lang/String;)V
    //   40: iconst_1
    //   41: invokestatic 67	org/light/gles/GLCapabilities:init	(Z)V
    //   44: invokestatic 72	org/light/device/GpuScopeAttrs:getInstance	()Lorg/light/device/GpuScopeAttrs;
    //   47: aload_1
    //   48: invokestatic 56	org/light/device/DeviceInstance:getInstance	()Lorg/light/device/DeviceInstance;
    //   51: invokevirtual 84	org/light/device/DeviceInstance:getDeviceName	()Ljava/lang/String;
    //   54: invokestatic 87	org/light/gles/GLCapabilities:getGPUInfo	()Ljava/lang/String;
    //   57: aload_0
    //   58: invokevirtual 90	org/light/device/GpuScopeAttrs:init	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   61: new 92	java/lang/StringBuilder
    //   64: dup
    //   65: invokespecial 93	java/lang/StringBuilder:<init>	()V
    //   68: astore_0
    //   69: aload_0
    //   70: ldc 114
    //   72: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   75: pop
    //   76: aload_0
    //   77: invokestatic 56	org/light/device/DeviceInstance:getInstance	()Lorg/light/device/DeviceInstance;
    //   80: invokevirtual 84	org/light/device/DeviceInstance:getDeviceName	()Ljava/lang/String;
    //   83: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   86: pop
    //   87: ldc 8
    //   89: aload_0
    //   90: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   93: invokestatic 117	org/light/utils/LightLogUtil:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   96: iconst_1
    //   97: putstatic 22	org/light/DeviceSupportUtil:inited	Z
    //   100: goto +41 -> 141
    //   103: astore_0
    //   104: goto +41 -> 145
    //   107: astore_0
    //   108: new 92	java/lang/StringBuilder
    //   111: dup
    //   112: invokespecial 93	java/lang/StringBuilder:<init>	()V
    //   115: astore_1
    //   116: aload_1
    //   117: ldc 95
    //   119: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   122: pop
    //   123: aload_1
    //   124: aload_0
    //   125: invokevirtual 102	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   128: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   131: pop
    //   132: ldc 8
    //   134: aload_1
    //   135: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   138: invokestatic 111	org/light/utils/LightLogUtil:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   141: ldc 2
    //   143: monitorexit
    //   144: return
    //   145: ldc 2
    //   147: monitorexit
    //   148: aload_0
    //   149: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	150	0	paramString	String
    //   31	104	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   3	100	103	finally
    //   108	141	103	finally
    //   3	100	107	java/lang/Exception
  }
  
  public static boolean isAbilityDeviceSupport(String paramString)
  {
    if (!inited) {
      init();
    }
    int i = -1;
    int j = paramString.hashCode();
    boolean bool2 = true;
    switch (j)
    {
    default: 
      break;
    case 1946725565: 
      if (paramString.equals("shareGLContextError")) {
        i = 13;
      }
      break;
    case 1266327981: 
      if (paramString.equals("JavaScript")) {
        i = 6;
      }
      break;
    case 926728984: 
      if (paramString.equals("3d.kapu")) {
        i = 0;
      }
      break;
    case 728654733: 
      if (paramString.equals("ai.catFace")) {
        i = 10;
      }
      break;
    case 3018567: 
      if (paramString.equals("ai.gender")) {
        i = 11;
      }
      break;
    case 3112: 
      if (paramString.equals("ai")) {
        i = 1;
      }
      break;
    case -29632972: 
      if (paramString.equals("ai.face3d")) {
        i = 2;
      }
      break;
    case -577373154: 
      if (paramString.equals("ai.expression")) {
        i = 12;
      }
      break;
    case -1054883928: 
      if (paramString.equals("ai.body")) {
        i = 9;
      }
      break;
    case -1419497458: 
      if (paramString.equals("ai.gan")) {
        i = 4;
      }
      break;
    case -1847539473: 
      if (paramString.equals("ai.segmentHair")) {
        i = 8;
      }
      break;
    case -1848308053: 
      if (paramString.equals("ai.segment.gpu")) {
        i = 5;
      }
      break;
    case -1926713261: 
      if (paramString.equals("OpenCL")) {
        i = 3;
      }
      break;
    case -2147478675: 
      if (paramString.equals("ai.segment")) {
        i = 7;
      }
      break;
    }
    boolean bool1 = bool2;
    switch (i)
    {
    default: 
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("isAbilityDeviceSupport - key \"");
      localStringBuilder.append(paramString);
      localStringBuilder.append("\" not found");
      LightLogUtil.w("DeviceSupportUtil", localStringBuilder.toString());
      bool1 = bool2;
      break;
    case 13: 
      bool1 = isShareGLContextError();
      break;
    case 6: 
      bool1 = supportJavaScript();
      break;
    case 3: 
    case 4: 
    case 5: 
      bool1 = supportOpenCL();
      break;
    case 2: 
      bool1 = supportAceEngine();
      break;
    case 1: 
      bool1 = supportAiAbility();
      break;
    case 0: 
      bool1 = supportKapu();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("isAbilityDeviceSupport - ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" ");
    if (bool1) {
      paramString = "true";
    } else {
      paramString = "false";
    }
    localStringBuilder.append(paramString);
    LightLogUtil.d("DeviceSupportUtil", localStringBuilder.toString());
    return bool1;
  }
  
  public static boolean isMaterialDeviceSupport(String paramString)
  {
    LightLogUtil.d("DeviceSupportUtil", "isMaterialDeviceSupport");
    return true;
  }
  
  public static boolean isShareGLContextError()
  {
    return GLCapabilities.isShareGLContextError();
  }
  
  private static boolean supportAceEngine()
  {
    return (GLCapabilities.getGlesVersion().contains("3.")) && (GLCapabilities.isFilamentShaderCompileSucceed()) && (GLCapabilities.isDeviceSupportAceEngine());
  }
  
  private static boolean supportAiAbility()
  {
    return GLCapabilities.isDeviceSupportAiAbility();
  }
  
  private static boolean supportJavaScript()
  {
    return ApiHelper.hasLollipop();
  }
  
  private static boolean supportKapu()
  {
    return (supportAceEngine()) && (GLCapabilities.isDeviceSupportKapu());
  }
  
  private static boolean supportOpenCL()
  {
    return (ApiHelper.hasMarshmallow()) && (GLCapabilities.isDeviceSupportOpenCL());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     org.light.DeviceSupportUtil
 * JD-Core Version:    0.7.0.1
 */