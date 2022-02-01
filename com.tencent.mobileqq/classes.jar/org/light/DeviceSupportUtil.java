package org.light;

import android.app.Application;
import android.content.Context;
import java.lang.reflect.Method;
import java.util.ArrayList;
import org.light.device.ApiHelper;
import org.light.device.DeviceInstance;
import org.light.device.GpuScopeAttrs;
import org.light.gles.GLCapabilities;
import org.light.utils.LightLogUtil;

public class DeviceSupportUtil
{
  private static final String[] DEVICE_ABILITY_ARRAY = { "3d.kapu", "ai.emotion", "ai.hand", "ai.3dmm", "ai", "ai.face3d", "OpenCL", "ai.gan", "ai.segment.gpu", "JavaScript", "ai.segment", "ai.segmentHair", "ai.body", "ai.catFace", "ai.gender", "ai.expression", "shareGLContextError", "render.shadow", "render.fxaa", "render.msaa", "render.ssao", "render.dither", "render.bloom", "render.vignette", "render.color_grading", "ai.InitSegmentHair", "imu.smooth.enable" };
  private static final String TAG = "DeviceSupportUtil";
  private static boolean inited = false;
  
  private static String[] getDeviceAbilityKeys(LightAsset paramLightAsset)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramLightAsset != null)
    {
      String[] arrayOfString = DEVICE_ABILITY_ARRAY;
      int j = arrayOfString.length;
      int i = 0;
      while (i < j)
      {
        String str = arrayOfString[i];
        if (paramLightAsset.needRenderAbility(str)) {
          localArrayList.add(str);
        }
        i += 1;
      }
    }
    return (String[])localArrayList.toArray();
  }
  
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
        Object localObject1 = ((Application)Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, (Object[])null)).getApplicationContext();
        DeviceInstance.getInstance().initSettings((Context)localObject1, "");
        GLCapabilities.init(true);
        if ((GpuScopeAttrs.getInstance().getDeviceModel() == null) && (GpuScopeAttrs.getInstance().getGPuModel() == null))
        {
          GpuScopeAttrs.getInstance().init((Context)localObject1, DeviceInstance.getInstance().getDeviceName(), GLCapabilities.getGPUInfo(), DeviceInstance.getInstance().getDeviceVersion(), "");
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("DeviceName = ");
          ((StringBuilder)localObject1).append(DeviceInstance.getInstance().getDeviceName());
          LightLogUtil.e("DeviceSupportUtil", ((StringBuilder)localObject1).toString());
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("SystemVersion = ");
          ((StringBuilder)localObject1).append(DeviceInstance.getInstance().getDeviceVersion());
          LightLogUtil.e("DeviceSupportUtil", ((StringBuilder)localObject1).toString());
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
    //   3: ldc 104
    //   5: invokestatic 110	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   8: ldc 112
    //   10: iconst_0
    //   11: anewarray 106	java/lang/Class
    //   14: invokevirtual 116	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   17: aconst_null
    //   18: aconst_null
    //   19: checkcast 118	[Ljava/lang/Object;
    //   22: invokevirtual 124	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   25: checkcast 126	android/app/Application
    //   28: invokevirtual 130	android/app/Application:getApplicationContext	()Landroid/content/Context;
    //   31: astore_1
    //   32: invokestatic 136	org/light/device/DeviceInstance:getInstance	()Lorg/light/device/DeviceInstance;
    //   35: aload_1
    //   36: aload_0
    //   37: invokevirtual 142	org/light/device/DeviceInstance:initSettings	(Landroid/content/Context;Ljava/lang/String;)V
    //   40: iconst_1
    //   41: invokestatic 147	org/light/gles/GLCapabilities:init	(Z)V
    //   44: invokestatic 152	org/light/device/GpuScopeAttrs:getInstance	()Lorg/light/device/GpuScopeAttrs;
    //   47: aload_1
    //   48: invokestatic 136	org/light/device/DeviceInstance:getInstance	()Lorg/light/device/DeviceInstance;
    //   51: invokevirtual 164	org/light/device/DeviceInstance:getDeviceName	()Ljava/lang/String;
    //   54: invokestatic 167	org/light/gles/GLCapabilities:getGPUInfo	()Ljava/lang/String;
    //   57: invokestatic 136	org/light/device/DeviceInstance:getInstance	()Lorg/light/device/DeviceInstance;
    //   60: invokevirtual 170	org/light/device/DeviceInstance:getDeviceVersion	()Ljava/lang/String;
    //   63: aload_0
    //   64: invokevirtual 173	org/light/device/GpuScopeAttrs:init	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   67: new 175	java/lang/StringBuilder
    //   70: dup
    //   71: invokespecial 176	java/lang/StringBuilder:<init>	()V
    //   74: astore_0
    //   75: aload_0
    //   76: ldc 178
    //   78: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   81: pop
    //   82: aload_0
    //   83: invokestatic 136	org/light/device/DeviceInstance:getInstance	()Lorg/light/device/DeviceInstance;
    //   86: invokevirtual 164	org/light/device/DeviceInstance:getDeviceName	()Ljava/lang/String;
    //   89: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   92: pop
    //   93: ldc 10
    //   95: aload_0
    //   96: invokevirtual 185	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   99: invokestatic 191	org/light/utils/LightLogUtil:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   102: new 175	java/lang/StringBuilder
    //   105: dup
    //   106: invokespecial 176	java/lang/StringBuilder:<init>	()V
    //   109: astore_0
    //   110: aload_0
    //   111: ldc 193
    //   113: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   116: pop
    //   117: aload_0
    //   118: invokestatic 136	org/light/device/DeviceInstance:getInstance	()Lorg/light/device/DeviceInstance;
    //   121: invokevirtual 170	org/light/device/DeviceInstance:getDeviceVersion	()Ljava/lang/String;
    //   124: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   127: pop
    //   128: ldc 10
    //   130: aload_0
    //   131: invokevirtual 185	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   134: invokestatic 191	org/light/utils/LightLogUtil:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   137: iconst_1
    //   138: putstatic 102	org/light/DeviceSupportUtil:inited	Z
    //   141: goto +41 -> 182
    //   144: astore_0
    //   145: goto +41 -> 186
    //   148: astore_0
    //   149: new 175	java/lang/StringBuilder
    //   152: dup
    //   153: invokespecial 176	java/lang/StringBuilder:<init>	()V
    //   156: astore_1
    //   157: aload_1
    //   158: ldc 195
    //   160: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   163: pop
    //   164: aload_1
    //   165: aload_0
    //   166: invokevirtual 198	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   169: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   172: pop
    //   173: ldc 10
    //   175: aload_1
    //   176: invokevirtual 185	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   179: invokestatic 201	org/light/utils/LightLogUtil:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   182: ldc 2
    //   184: monitorexit
    //   185: return
    //   186: ldc 2
    //   188: monitorexit
    //   189: aload_0
    //   190: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	191	0	paramString	String
    //   31	145	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   3	141	144	finally
    //   149	182	144	finally
    //   3	141	148	java/lang/Exception
  }
  
  public static boolean isAbilitiesSupported(String[] paramArrayOfString)
  {
    if ((paramArrayOfString != null) && (paramArrayOfString.length > 0))
    {
      if (!inited) {
        init();
      }
      int j = paramArrayOfString.length;
      int i = 0;
      while (i < j)
      {
        if (!isAbilityDeviceSupport(paramArrayOfString[i])) {
          return false;
        }
        i += 1;
      }
    }
    return true;
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
        i = 16;
      }
      break;
    case 1266327981: 
      if (paramString.equals("JavaScript")) {
        i = 9;
      }
      break;
    case 1155171942: 
      if (paramString.equals("imu.smooth.enable")) {
        i = 27;
      }
      break;
    case 1088081055: 
      if (paramString.equals("ai.InitSegmentHair")) {
        i = 26;
      }
      break;
    case 926728984: 
      if (paramString.equals("3d.kapu")) {
        i = 0;
      }
      break;
    case 728654733: 
      if (paramString.equals("ai.catFace")) {
        i = 13;
      }
      break;
    case 324797074: 
      if (paramString.equals("render.vignette")) {
        i = 23;
      }
      break;
    case 304644842: 
      if (paramString.equals("ace3d.flush")) {
        i = 25;
      }
      break;
    case 3018567: 
      if (paramString.equals("ai.gender")) {
        i = 14;
      }
      break;
    case 3112: 
      if (paramString.equals("ai")) {
        i = 4;
      }
      break;
    case -29632972: 
      if (paramString.equals("ai.face3d")) {
        i = 5;
      }
      break;
    case -334238805: 
      if (paramString.equals("render.bloom")) {
        i = 22;
      }
      break;
    case -577373154: 
      if (paramString.equals("ai.expression")) {
        i = 15;
      }
      break;
    case -835779680: 
      if (paramString.equals("render.color_grading")) {
        i = 24;
      }
      break;
    case -1054718347: 
      if (paramString.equals("ai.hand")) {
        i = 2;
      }
      break;
    case -1054883928: 
      if (paramString.equals("ai.body")) {
        i = 12;
      }
      break;
    case -1056294409: 
      if (paramString.equals("ai.3dmm")) {
        i = 3;
      }
      break;
    case -1288894344: 
      if (paramString.equals("render.shadow")) {
        i = 17;
      }
      break;
    case -1419497458: 
      if (paramString.equals("ai.gan")) {
        i = 7;
      }
      break;
    case -1450994539: 
      if (paramString.equals("ai.emotion")) {
        i = 1;
      }
      break;
    case -1672837146: 
      if (paramString.equals("render.ssao")) {
        i = 20;
      }
      break;
    case -1673015906: 
      if (paramString.equals("render.msaa")) {
        i = 19;
      }
      break;
    case -1673219638: 
      if (paramString.equals("render.fxaa")) {
        i = 18;
      }
      break;
    case -1716838530: 
      if (paramString.equals("render.dither")) {
        i = 21;
      }
      break;
    case -1847539473: 
      if (paramString.equals("ai.segmentHair")) {
        i = 11;
      }
      break;
    case -1848308053: 
      if (paramString.equals("ai.segment.gpu")) {
        i = 8;
      }
      break;
    case -1926713261: 
      if (paramString.equals("OpenCL")) {
        i = 6;
      }
      break;
    case -2147478675: 
      if (paramString.equals("ai.segment")) {
        i = 10;
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
    case 27: 
      bool1 = isImuSmoothEnable();
      break;
    case 26: 
      bool1 = isHairSegPreLoadSupportedDevice();
      break;
    case 25: 
      bool1 = supportAce3dFLush();
      break;
    case 17: 
    case 18: 
    case 19: 
    case 20: 
    case 21: 
    case 22: 
    case 23: 
    case 24: 
      bool1 = supportFilamentFeature(paramString);
      break;
    case 16: 
      bool1 = isShareGLContextError();
      break;
    case 9: 
      bool1 = supportJavaScript();
      break;
    case 6: 
    case 7: 
    case 8: 
      bool1 = supportOpenCL();
      break;
    case 5: 
      bool1 = supportAceEngine();
      break;
    case 1: 
    case 2: 
    case 3: 
    case 4: 
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
    LightLogUtil.w("DeviceSupportUtil", localStringBuilder.toString());
    return bool1;
  }
  
  public static boolean isDeviceSupportAsset(LightAsset paramLightAsset)
  {
    return isAbilitiesSupported(getDeviceAbilityKeys(paramLightAsset));
  }
  
  public static boolean isHairSegPreLoadSupportedDevice()
  {
    return GLCapabilities.isDeviceSupportHairSegPreLoad();
  }
  
  private static boolean isImuSmoothEnable()
  {
    return GLCapabilities.isImuSmoothEnable();
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
  
  private static boolean supportAce3dFLush()
  {
    return (supportAceEngine()) && (GLCapabilities.isDeviceSupportAce3dFlush());
  }
  
  private static boolean supportAceEngine()
  {
    return (GLCapabilities.getGlesVersion().contains("3.")) && (GLCapabilities.isFilamentShaderCompileSucceed()) && (GLCapabilities.isDeviceSupportAceEngine());
  }
  
  private static boolean supportAiAbility()
  {
    return GLCapabilities.isDeviceSupportAiAbility();
  }
  
  private static boolean supportFilamentFeature(String paramString)
  {
    return (supportAceEngine()) && (GLCapabilities.isDeviceSupportFilamentFeature(paramString));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.light.DeviceSupportUtil
 * JD-Core Version:    0.7.0.1
 */