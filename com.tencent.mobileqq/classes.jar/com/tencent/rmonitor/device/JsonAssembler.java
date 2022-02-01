package com.tencent.rmonitor.device;

import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.content.Context;
import android.hardware.display.DisplayManager;
import android.opengl.GLES20;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Environment;
import android.support.annotation.RequiresApi;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.rmonitor.base.meta.BaseInfo;
import com.tencent.rmonitor.base.meta.UserMeta;
import com.tencent.rmonitor.common.util.AndroidVersion;
import com.tencent.rmonitor.common.util.AndroidVersion.Companion;
import com.tencent.rmonitor.common.util.FileUtil;
import com.tencent.rmonitor.common.util.FileUtil.Companion;
import com.tencent.rmonitor.common.util.StringUtil;
import com.tencent.rmonitor.device.device.DeviceCamera;
import com.tencent.rmonitor.device.device.DeviceCamera.Companion;
import com.tencent.rmonitor.device.device.DeviceCpu;
import com.tencent.rmonitor.device.device.DeviceCpu.Companion;
import com.tencent.rmonitor.device.device.DeviceIo;
import com.tencent.rmonitor.device.device.DeviceIo.Companion;
import com.tencent.rmonitor.device.device.DeviceMedia;
import com.tencent.rmonitor.device.device.DeviceMedia.Companion;
import com.tencent.rmonitor.device.device.DeviceStore;
import com.tencent.rmonitor.device.device.DeviceStore.Companion;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/rmonitor/device/JsonAssembler;", "", "()V", "glRender", "", "glVender", "glVersion", "composeBaseInfo", "json", "Lorg/json/JSONObject;", "composeCamera", "composeCpu", "composeGpu", "composeIo", "composeMemory", "context", "Landroid/content/Context;", "composeNet", "composeOther", "composeScreen", "rmonitor-base_release"}, k=1, mv={1, 1, 15})
public final class JsonAssembler
{
  private String a;
  private String b;
  private String c;
  
  @RequiresApi(16)
  @NotNull
  public final JsonAssembler a(@NotNull Context paramContext, @NotNull JSONObject paramJSONObject)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    Intrinsics.checkParameterIsNotNull(paramJSONObject, "json");
    long l1 = Runtime.getRuntime().maxMemory();
    ActivityManager.MemoryInfo localMemoryInfo = new ActivityManager.MemoryInfo();
    Object localObject = paramContext.getSystemService("activity");
    paramContext = localObject;
    if (!(localObject instanceof ActivityManager)) {
      paramContext = null;
    }
    paramContext = (ActivityManager)paramContext;
    if (paramContext != null) {
      paramContext.getMemoryInfo(localMemoryInfo);
    }
    long l2 = 1048576;
    paramJSONObject.put("max_mem", String.valueOf(l1 / l2)).put("low_mem", String.valueOf(localMemoryInfo.threshold / l2)).put("total_mem", String.valueOf(localMemoryInfo.totalMem / l2));
    return this;
  }
  
  @NotNull
  public final JsonAssembler a(@NotNull JSONObject paramJSONObject)
  {
    Intrinsics.checkParameterIsNotNull(paramJSONObject, "json");
    paramJSONObject.put("plantform", "Android").put("device_id", BaseInfo.userMeta.deviceId).put("device_model", Build.MODEL).put("product", Build.PRODUCT).put("manu", Build.MANUFACTURER).put("os_version", Build.VERSION.RELEASE).put("hardware", Build.HARDWARE);
    return this;
  }
  
  @NotNull
  public final JsonAssembler b(@NotNull Context paramContext, @NotNull JSONObject paramJSONObject)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    Intrinsics.checkParameterIsNotNull(paramJSONObject, "json");
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    Object localObject;
    if (AndroidVersion.a.c())
    {
      localObject = paramContext.getSystemService("display");
      paramContext = localObject;
      if (!(localObject instanceof DisplayManager)) {
        paramContext = null;
      }
      paramContext = (DisplayManager)paramContext;
      if (paramContext != null)
      {
        paramContext = paramContext.getDisplay(0);
        if (paramContext != null) {
          paramContext.getRealMetrics(localDisplayMetrics);
        }
      }
    }
    else
    {
      localObject = paramContext.getSystemService("window");
      paramContext = localObject;
      if (!(localObject instanceof WindowManager)) {
        paramContext = null;
      }
      paramContext = (WindowManager)paramContext;
      if (paramContext != null)
      {
        paramContext = paramContext.getDefaultDisplay();
        if (paramContext != null) {
          paramContext.getMetrics(localDisplayMetrics);
        }
      }
    }
    paramContext = new StringBuilder();
    paramContext.append(String.valueOf(localDisplayMetrics.widthPixels));
    paramContext.append("*");
    paramContext.append(String.valueOf(localDisplayMetrics.heightPixels));
    paramJSONObject.put("screen_size", paramContext.toString()).put("screen_dpi", String.valueOf(localDisplayMetrics.densityDpi)).put("screen_density", String.valueOf(localDisplayMetrics.density));
    return this;
  }
  
  @NotNull
  public final JsonAssembler b(@NotNull JSONObject paramJSONObject)
  {
    Intrinsics.checkParameterIsNotNull(paramJSONObject, "json");
    if (AndroidVersion.a.d())
    {
      String[] arrayOfString = Build.SUPPORTED_ABIS;
      StringBuilder localStringBuilder = new StringBuilder(arrayOfString.length * 20);
      int j = arrayOfString.length;
      int i = 0;
      while (i < j)
      {
        localStringBuilder.append(arrayOfString[i]);
        localStringBuilder.append(", ");
        paramJSONObject.put("cpuabi", localStringBuilder.toString());
        i += 1;
      }
    }
    paramJSONObject.put("cpuabi", Build.CPU_ABI);
    paramJSONObject.put("cpuabi2", Build.CPU_ABI2).put("cpu_max_hz", DeviceCpu.a.c()).put("cpu_min_hz", DeviceCpu.a.d()).put("cpu_name", DeviceCpu.a.b()).put("availy_core", String.valueOf(Runtime.getRuntime().availableProcessors())).put("avaliable_cpu_scheduler", StringUtil.a(FileUtil.a.b("/sys/devices/system/cpu/cpu0/cpufreq/scaling_available_governors"))).put("current_cpu_scheduler", StringUtil.a(FileUtil.a.b("/sys/devices/system/cpu/cpu0/cpufreq/scaling_governor"))).put("number_soft_core", String.valueOf(DeviceCpu.a.a()));
    return this;
  }
  
  @NotNull
  public final JsonAssembler c(@NotNull JSONObject paramJSONObject)
  {
    Intrinsics.checkParameterIsNotNull(paramJSONObject, "json");
    EGLHelper localEGLHelper = new EGLHelper();
    if (localEGLHelper.a(10, 10))
    {
      this.a = GLES20.glGetString(7937);
      this.b = GLES20.glGetString(7936);
      this.c = GLES20.glGetString(7938);
      localEGLHelper.a();
    }
    paramJSONObject.put("gl_vender", this.b).put("gl_render", this.a).put("gl_version", this.c);
    return this;
  }
  
  @NotNull
  public final JsonAssembler d(@NotNull JSONObject paramJSONObject)
  {
    Intrinsics.checkParameterIsNotNull(paramJSONObject, "json");
    String[] arrayOfString = DeviceCamera.a.b(BaseInfo.app);
    paramJSONObject.put("main_camera_size", arrayOfString[0]).put("camera_size", arrayOfString[1]).put("all_camera_size", DeviceCamera.a.a(BaseInfo.app)).put("media_codec", DeviceMedia.a.a());
    return this;
  }
  
  @NotNull
  public final JsonAssembler e(@NotNull JSONObject paramJSONObject)
  {
    Intrinsics.checkParameterIsNotNull(paramJSONObject, "json");
    paramJSONObject.put("default_receive_windows", FileUtil.a.b("/proc/sys/net/core/rmem_default")).put("default_send_windows", FileUtil.a.b("/proc/sys/net/core/wmem_default"));
    return this;
  }
  
  @NotNull
  public final JsonAssembler f(@NotNull JSONObject paramJSONObject)
  {
    Intrinsics.checkParameterIsNotNull(paramJSONObject, "json");
    paramJSONObject = paramJSONObject.put("available_io_scheduler", StringUtil.a(DeviceIo.a.b())).put("read_ahead", DeviceIo.a.a());
    DeviceStore.Companion localCompanion = DeviceStore.a;
    Object localObject = Environment.getDataDirectory();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "Environment.getDataDirectory()");
    localObject = ((File)localObject).getPath();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "Environment.getDataDirectory().path");
    paramJSONObject = paramJSONObject.put("data_block_size", String.valueOf(localCompanion.a((String)localObject)));
    localCompanion = DeviceStore.a;
    localObject = Environment.getExternalStorageDirectory();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "Environment.getExternalStorageDirectory()");
    localObject = ((File)localObject).getPath();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "Environment.getExternalStorageDirectory().path");
    paramJSONObject.put("sdcard_block_size", String.valueOf(localCompanion.a((String)localObject)));
    return this;
  }
  
  @NotNull
  public final JsonAssembler g(@NotNull JSONObject paramJSONObject)
  {
    Intrinsics.checkParameterIsNotNull(paramJSONObject, "json");
    paramJSONObject.put("other1", "").put("other2", "").put("other3", "").put("other4", "").put("other5", "").put("other6", "").put("other7", "").put("other8", "");
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.device.JsonAssembler
 * JD-Core Version:    0.7.0.1
 */