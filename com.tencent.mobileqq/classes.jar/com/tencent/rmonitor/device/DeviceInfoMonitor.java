package com.tencent.rmonitor.device;

import android.annotation.TargetApi;
import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import com.tencent.rmonitor.base.config.ConfigCenter;
import com.tencent.rmonitor.base.config.ConfigProxy;
import com.tencent.rmonitor.base.config.DefaultPluginConfig;
import com.tencent.rmonitor.base.meta.BaseInfo;
import com.tencent.rmonitor.base.meta.DeviceMeta;
import com.tencent.rmonitor.base.meta.UserMeta;
import com.tencent.rmonitor.base.plugin.listener.IDeviceInfoListener;
import com.tencent.rmonitor.base.plugin.listener.ListenerManager;
import com.tencent.rmonitor.base.plugin.listener.MonitorListenerMng;
import com.tencent.rmonitor.base.plugin.monitor.PluginController;
import com.tencent.rmonitor.base.plugin.monitor.QAPMMonitorPlugin;
import com.tencent.rmonitor.base.reporter.ReporterMachine;
import com.tencent.rmonitor.base.reporter.data.ReportData;
import com.tencent.rmonitor.common.json.JsonDispose;
import com.tencent.rmonitor.common.json.JsonDispose.Companion;
import com.tencent.rmonitor.common.lifecycle.IActivityStateCallback;
import com.tencent.rmonitor.common.lifecycle.LifecycleCallback;
import com.tencent.rmonitor.common.logger.Logger;
import com.tencent.rmonitor.common.util.AndroidVersion;
import com.tencent.rmonitor.common.util.AndroidVersion.Companion;
import com.tencent.rmonitor.common.util.FileUtil;
import com.tencent.rmonitor.common.util.FileUtil.Companion;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/rmonitor/device/DeviceInfoMonitor;", "Lcom/tencent/rmonitor/base/plugin/monitor/QAPMMonitorPlugin;", "()V", "foreBack", "Lcom/tencent/rmonitor/common/lifecycle/IActivityStateCallback;", "jsonAssembler", "Lcom/tencent/rmonitor/device/JsonAssembler;", "lastReportTime", "", "canReport", "", "doReport", "", "context", "Landroid/content/Context;", "getDeviceInfo", "Lorg/json/JSONObject;", "noteReportTime", "readReportTime", "", "reportDevice", "start", "stop", "writeReportTime", "curTime", "Companion", "DeviceForeCallbackImpl", "rmonitor-base_release"}, k=1, mv={1, 1, 15})
public final class DeviceInfoMonitor
  extends QAPMMonitorPlugin
{
  public static final DeviceInfoMonitor.Companion a = new DeviceInfoMonitor.Companion(null);
  private long b = -1L;
  private final JsonAssembler c = new JsonAssembler();
  private final IActivityStateCallback d = (IActivityStateCallback)new DeviceInfoMonitor.DeviceForeCallbackImpl(this);
  
  private final boolean a(long paramLong)
  {
    FileUtil.Companion localCompanion = FileUtil.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(FileUtil.a.b());
    localStringBuilder.append("/reportDeviceInfo");
    return localCompanion.a(localStringBuilder.toString(), String.valueOf(paramLong), false);
  }
  
  private final void b(Context paramContext)
  {
    if (PluginController.b.d(131)) {
      try
      {
        Object localObject = ConfigProxy.INSTANCE.getConfig().b(131);
        Intrinsics.checkExpressionValueIsNotNull(localObject, "ConfigProxy.config.getPl…inConfig(PluginId.DEVICE)");
        paramContext = a(paramContext);
        paramContext.put("data_time", String.valueOf(System.currentTimeMillis()));
        paramContext.put("plugin", 131);
        localObject = new ReportData(0, ((DefaultPluginConfig)localObject).c, true, 1L, 1L, paramContext, true, true, BaseInfo.userMeta.uin);
        ((ReportData)localObject).setParams(JsonDispose.a.a(BaseInfo.pubJson, ((ReportData)localObject).getParams()));
        Iterator localIterator = ((Iterable)ListenerManager.l.a()).iterator();
        while (localIterator.hasNext()) {
          ((IDeviceInfoListener)localIterator.next()).onBeforeReport(new DeviceMeta(paramContext));
        }
        ReporterMachine.a.a((ReportData)localObject, null);
        return;
      }
      catch (Exception paramContext)
      {
        Logger.b.a("RMonitor_device_DeviceInfo", (Throwable)paramContext);
      }
    }
  }
  
  private final boolean c()
  {
    boolean bool1 = PluginController.b.a();
    boolean bool2 = true;
    if (bool1) {
      return true;
    }
    bool1 = bool2;
    if (this.b == -1L)
    {
      Object localObject1 = e();
      if (localObject1 != null)
      {
        Object localObject2 = (CharSequence)localObject1;
        int i;
        if (((CharSequence)localObject2).length() == 0) {
          i = 1;
        } else {
          i = 0;
        }
        if (i != 0)
        {
          bool1 = false;
          break label152;
        }
        if (TextUtils.isDigitsOnly((CharSequence)localObject2))
        {
          this.b = Long.parseLong((String)localObject1);
          localObject1 = Logger.b;
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("canReport, lastReportTime : ");
          ((StringBuilder)localObject2).append(this.b);
          ((Logger)localObject1).d(new String[] { "RMonitor_device_DeviceInfo", ((StringBuilder)localObject2).toString() });
          bool1 = bool2;
          break label152;
        }
      }
      return true;
    }
    label152:
    if (System.currentTimeMillis() - this.b <= 2592000000L) {
      return false;
    }
    return bool1;
  }
  
  private final void d()
  {
    long l = System.currentTimeMillis();
    if (a(l)) {
      this.b = l;
    }
  }
  
  /* Error */
  private final String e()
  {
    // Byte code:
    //   0: new 84	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 85	java/lang/StringBuilder:<init>	()V
    //   7: astore_1
    //   8: aload_1
    //   9: getstatic 82	com/tencent/rmonitor/common/util/FileUtil:a	Lcom/tencent/rmonitor/common/util/FileUtil$Companion;
    //   12: invokevirtual 90	com/tencent/rmonitor/common/util/FileUtil$Companion:b	()Ljava/lang/String;
    //   15: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   18: pop
    //   19: aload_1
    //   20: ldc 96
    //   22: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: pop
    //   26: new 300	java/io/File
    //   29: dup
    //   30: aload_1
    //   31: invokevirtual 99	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   34: invokespecial 303	java/io/File:<init>	(Ljava/lang/String;)V
    //   37: astore_1
    //   38: aload_1
    //   39: invokevirtual 306	java/io/File:exists	()Z
    //   42: ifne +10 -> 52
    //   45: aload_1
    //   46: invokevirtual 309	java/io/File:createNewFile	()Z
    //   49: pop
    //   50: aconst_null
    //   51: areturn
    //   52: new 311	java/io/FileInputStream
    //   55: dup
    //   56: aload_1
    //   57: invokespecial 314	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   60: astore 4
    //   62: aload 4
    //   64: checkcast 316	java/io/Closeable
    //   67: astore_3
    //   68: aconst_null
    //   69: checkcast 260	java/lang/Throwable
    //   72: astore_2
    //   73: aload_2
    //   74: astore_1
    //   75: aload_3
    //   76: checkcast 311	java/io/FileInputStream
    //   79: astore 5
    //   81: aload_2
    //   82: astore_1
    //   83: getstatic 82	com/tencent/rmonitor/common/util/FileUtil:a	Lcom/tencent/rmonitor/common/util/FileUtil$Companion;
    //   86: new 318	java/io/InputStreamReader
    //   89: dup
    //   90: aload 4
    //   92: checkcast 320	java/io/InputStream
    //   95: ldc_w 322
    //   98: invokespecial 325	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   101: iconst_0
    //   102: iconst_2
    //   103: aconst_null
    //   104: invokestatic 328	com/tencent/rmonitor/common/util/FileUtil$Companion:a	(Lcom/tencent/rmonitor/common/util/FileUtil$Companion;Ljava/io/InputStreamReader;IILjava/lang/Object;)Ljava/lang/String;
    //   107: astore 4
    //   109: aload 4
    //   111: ifnull +26 -> 137
    //   114: aload_2
    //   115: astore_1
    //   116: aload 4
    //   118: checkcast 270	java/lang/CharSequence
    //   121: invokestatic 334	kotlin/text/StringsKt:trim	(Ljava/lang/CharSequence;)Ljava/lang/CharSequence;
    //   124: invokevirtual 337	java/lang/Object:toString	()Ljava/lang/String;
    //   127: astore 4
    //   129: aload_3
    //   130: aload_2
    //   131: invokestatic 343	kotlin/io/CloseableKt:closeFinally	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   134: aload 4
    //   136: areturn
    //   137: aload_2
    //   138: astore_1
    //   139: new 345	kotlin/TypeCastException
    //   142: dup
    //   143: ldc_w 347
    //   146: invokespecial 348	kotlin/TypeCastException:<init>	(Ljava/lang/String;)V
    //   149: athrow
    //   150: astore_2
    //   151: goto +8 -> 159
    //   154: astore_2
    //   155: aload_2
    //   156: astore_1
    //   157: aload_2
    //   158: athrow
    //   159: aload_3
    //   160: aload_1
    //   161: invokestatic 343	kotlin/io/CloseableKt:closeFinally	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   164: aload_2
    //   165: athrow
    //   166: astore_1
    //   167: getstatic 256	com/tencent/rmonitor/common/logger/Logger:b	Lcom/tencent/rmonitor/common/logger/Logger;
    //   170: aload_1
    //   171: invokevirtual 351	com/tencent/rmonitor/common/logger/Logger:a	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   174: pop
    //   175: ldc_w 352
    //   178: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	179	0	this	DeviceInfoMonitor
    //   7	154	1	localObject1	Object
    //   166	5	1	localThrowable1	Throwable
    //   72	66	2	localThrowable2	Throwable
    //   150	1	2	localObject2	Object
    //   154	11	2	localThrowable3	Throwable
    //   67	93	3	localCloseable	java.io.Closeable
    //   60	75	4	localObject3	Object
    //   79	1	5	localFileInputStream	java.io.FileInputStream
    // Exception table:
    //   from	to	target	type
    //   75	81	150	finally
    //   83	109	150	finally
    //   116	129	150	finally
    //   139	150	150	finally
    //   157	159	150	finally
    //   75	81	154	java/lang/Throwable
    //   83	109	154	java/lang/Throwable
    //   116	129	154	java/lang/Throwable
    //   139	150	154	java/lang/Throwable
    //   38	50	166	java/lang/Throwable
    //   52	73	166	java/lang/Throwable
    //   129	134	166	java/lang/Throwable
    //   159	166	166	java/lang/Throwable
  }
  
  @TargetApi(18)
  @NotNull
  public final JSONObject a(@NotNull Context paramContext)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    JSONObject localJSONObject = new JSONObject();
    this.c.a(localJSONObject).b(localJSONObject).b(paramContext, localJSONObject).a(paramContext, localJSONObject).c(localJSONObject).d(localJSONObject).f(localJSONObject).e(localJSONObject).g(localJSONObject);
    return localJSONObject;
  }
  
  public final boolean b()
  {
    Object localObject = BaseInfo.app;
    if (localObject != null)
    {
      localObject = ((Application)localObject).getApplicationContext();
      if (localObject != null)
      {
        if (c())
        {
          Logger.b.d(new String[] { "RMonitor_device_DeviceInfo", "begin reportDevice" });
          b((Context)localObject);
          d();
          return true;
        }
        Logger.b.d(new String[] { "RMonitor_device_DeviceInfo", "canReport return false" });
      }
    }
    return false;
  }
  
  public void start()
  {
    if (AndroidVersion.a.a())
    {
      Logger.b.d(new String[] { "RMonitor_device_DeviceInfo", "DeviceInfoMonitor start" });
      LifecycleCallback.a(this.d);
    }
  }
  
  public void stop()
  {
    Logger.b.d(new String[] { "RMonitor_device_DeviceInfo", "DeviceInfoMonitor stop" });
    LifecycleCallback.b(this.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.device.DeviceInfoMonitor
 * JD-Core Version:    0.7.0.1
 */