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
  
  /* Error */
  private static void init()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 14	org/light/DeviceSupportUtil:inited	Z
    //   6: istore_0
    //   7: iload_0
    //   8: ifeq +7 -> 15
    //   11: ldc 2
    //   13: monitorexit
    //   14: return
    //   15: ldc 23
    //   17: invokestatic 29	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   20: ldc 31
    //   22: iconst_0
    //   23: anewarray 25	java/lang/Class
    //   26: invokevirtual 35	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   29: aconst_null
    //   30: aconst_null
    //   31: checkcast 37	[Ljava/lang/Object;
    //   34: invokevirtual 43	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   37: checkcast 45	android/app/Application
    //   40: invokevirtual 49	android/app/Application:getApplicationContext	()Landroid/content/Context;
    //   43: astore_1
    //   44: invokestatic 55	org/light/device/DeviceInstance:getInstance	()Lorg/light/device/DeviceInstance;
    //   47: aload_1
    //   48: ldc 57
    //   50: invokevirtual 61	org/light/device/DeviceInstance:initSettings	(Landroid/content/Context;Ljava/lang/String;)V
    //   53: iconst_1
    //   54: invokestatic 66	org/light/gles/GLCapabilities:init	(Z)V
    //   57: invokestatic 71	org/light/device/GpuScopeAttrs:getInstance	()Lorg/light/device/GpuScopeAttrs;
    //   60: invokevirtual 75	org/light/device/GpuScopeAttrs:getDeviceModel	()Lorg/light/device/GpuScopeAttrs$GpuBean$DeviceModel;
    //   63: ifnonnull +30 -> 93
    //   66: invokestatic 71	org/light/device/GpuScopeAttrs:getInstance	()Lorg/light/device/GpuScopeAttrs;
    //   69: invokevirtual 79	org/light/device/GpuScopeAttrs:getGPuModel	()Lorg/light/device/GpuScopeAttrs$GpuBean$GpuModel;
    //   72: ifnonnull +21 -> 93
    //   75: invokestatic 71	org/light/device/GpuScopeAttrs:getInstance	()Lorg/light/device/GpuScopeAttrs;
    //   78: aload_1
    //   79: invokestatic 55	org/light/device/DeviceInstance:getInstance	()Lorg/light/device/DeviceInstance;
    //   82: invokevirtual 83	org/light/device/DeviceInstance:getDeviceName	()Ljava/lang/String;
    //   85: invokestatic 86	org/light/gles/GLCapabilities:getGPUInfo	()Ljava/lang/String;
    //   88: ldc 57
    //   90: invokevirtual 89	org/light/device/GpuScopeAttrs:init	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   93: iconst_1
    //   94: putstatic 14	org/light/DeviceSupportUtil:inited	Z
    //   97: goto -86 -> 11
    //   100: astore_1
    //   101: ldc 8
    //   103: new 91	java/lang/StringBuilder
    //   106: dup
    //   107: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   110: ldc 94
    //   112: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   115: aload_1
    //   116: invokevirtual 101	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   119: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   122: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   125: invokestatic 110	org/light/utils/LightLogUtil:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   128: goto -117 -> 11
    //   131: astore_1
    //   132: ldc 2
    //   134: monitorexit
    //   135: aload_1
    //   136: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   6	2	0	bool	boolean
    //   43	36	1	localContext	Context
    //   100	16	1	localException	Exception
    //   131	5	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   15	93	100	java/lang/Exception
    //   93	97	100	java/lang/Exception
    //   3	7	131	finally
    //   15	93	131	finally
    //   93	97	131	finally
    //   101	128	131	finally
  }
  
  public static void init(String paramString)
  {
    try
    {
      Context localContext = ((Application)Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, (Object[])null)).getApplicationContext();
      DeviceInstance.getInstance().initSettings(localContext, paramString);
      GLCapabilities.init(true);
      GpuScopeAttrs.getInstance().init(localContext, DeviceInstance.getInstance().getDeviceName(), GLCapabilities.getGPUInfo(), paramString);
      inited = true;
      return;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        LightLogUtil.w("DeviceSupportUtil", "init failed: " + paramString.getMessage());
      }
    }
    finally {}
  }
  
  public static boolean isAbilityDeviceSupport(String paramString)
  {
    boolean bool1 = true;
    boolean bool2 = true;
    if (!inited) {
      init();
    }
    int i = -1;
    label178:
    label207:
    StringBuilder localStringBuilder;
    switch (paramString.hashCode())
    {
    default: 
      switch (i)
      {
      default: 
        bool1 = bool2;
        LightLogUtil.w("DeviceSupportUtil", "isAbilityDeviceSupport - key \"" + paramString + "\" not found");
      case 4: 
      case 5: 
      case 6: 
      case 7: 
      case 8: 
      case 9: 
        localStringBuilder = new StringBuilder().append("isAbilityDeviceSupport - ").append(paramString).append(" ");
        if (!bool1) {}
        break;
      }
      break;
    }
    for (paramString = "true";; paramString = "false")
    {
      LightLogUtil.d("DeviceSupportUtil", paramString);
      return bool1;
      if (!paramString.equals("3d.kapu")) {
        break;
      }
      i = 0;
      break;
      if (!paramString.equals("ai")) {
        break;
      }
      i = 1;
      break;
      if (!paramString.equals("ai.face3d")) {
        break;
      }
      i = 2;
      break;
      if (!paramString.equals("ai.segment.gpu")) {
        break;
      }
      i = 3;
      break;
      if (!paramString.equals("ai.segment")) {
        break;
      }
      i = 4;
      break;
      if (!paramString.equals("ai.segmentHair")) {
        break;
      }
      i = 5;
      break;
      if (!paramString.equals("ai.body")) {
        break;
      }
      i = 6;
      break;
      if (!paramString.equals("ai.catFace")) {
        break;
      }
      i = 7;
      break;
      if (!paramString.equals("ai.gender")) {
        break;
      }
      i = 8;
      break;
      if (!paramString.equals("ai.expression")) {
        break;
      }
      i = 9;
      break;
      if (!paramString.equals("shareGLContextError")) {
        break;
      }
      i = 10;
      break;
      bool1 = supportKapu();
      break label207;
      bool1 = supportAiAbility();
      break label207;
      bool1 = supportAceEngine();
      break label207;
      bool1 = supportGPUSegment();
      break label207;
      bool1 = isShareGLContextError();
      break label178;
    }
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
  
  private static boolean supportGPUSegment()
  {
    return (ApiHelper.hasMarshmallow()) && (GLCapabilities.isDeviceSupportGPUSegment());
  }
  
  private static boolean supportKapu()
  {
    return (supportAceEngine()) && (GLCapabilities.isDeviceSupportKapu());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     org.light.DeviceSupportUtil
 * JD-Core Version:    0.7.0.1
 */