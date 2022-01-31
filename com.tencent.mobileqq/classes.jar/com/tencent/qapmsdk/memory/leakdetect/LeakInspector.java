package com.tencent.qapmsdk.memory.leakdetect;

import android.os.Build.VERSION;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.qapmsdk.base.listener.IInspectorListener;
import com.tencent.qapmsdk.base.meta.BaseInfo;
import com.tencent.qapmsdk.common.logcat.ILogcat;
import com.tencent.qapmsdk.common.logcat.LogcatManager;
import com.tencent.qapmsdk.common.logger.Logger;
import com.tencent.qapmsdk.common.util.AppInfo;
import com.tencent.qapmsdk.common.util.InspectUUID;
import com.tencent.qapmsdk.common.util.RecyclablePool;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.UUID;

public class LeakInspector
{
  private static final int CHECK_PIVOT = 5000;
  public static int LOOP_MAX_COUNT = 100;
  private static final String TAG = "QAPM_memory_LeakInspector";
  private static final int TIME_UNIT = 1000;
  private static boolean autoDump = false;
  private static long lastTimeGC = 0L;
  private static LeakInspector leakInspector;
  private static RecyclablePool sPool;
  private IInspectorListener inspectorListener;
  private Handler leakHandler;
  
  private LeakInspector(Handler paramHandler, IInspectorListener paramIInspectorListener)
  {
    this.leakHandler = paramHandler;
    this.inspectorListener = paramIInspectorListener;
  }
  
  private void addLogcat(List<String> paramList)
  {
    if (Build.VERSION.SDK_INT < 16)
    {
      if (!AppInfo.hasPermissions(BaseInfo.app, new String[] { "android.permission.READ_LOGS" })) {}
    }
    else
    {
      Object localObject = LogcatManager.initLogcat(1);
      ((ILogcat)localObject).setArgs(new String[] { "-t", "100", "-v", "threadtime" });
      localObject = ((ILogcat)localObject).getLogcatFile();
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        paramList.add(localObject);
      }
    }
  }
  
  private static void doGC()
  {
    long l = System.currentTimeMillis();
    if (l - lastTimeGC >= 5000L)
    {
      System.runFinalization();
      Runtime.getRuntime().gc();
      lastTimeGC = l;
    }
  }
  
  public static void enableAutoDump(boolean paramBoolean)
  {
    autoDump = paramBoolean;
  }
  
  @Nullable
  private InspectUUID generateInspectUUID(@NonNull Object paramObject, String paramString)
  {
    try
    {
      InspectUUID localInspectUUID = (InspectUUID)sPool.obtain(InspectUUID.class);
      if (localInspectUUID == null) {
        return null;
      }
      localInspectUUID.weakObj = new WeakReference(paramObject);
      localInspectUUID.uuid = UUID.randomUUID().toString().toCharArray();
      localInspectUUID.digest = paramString;
      localInspectUUID.className = paramObject.getClass().getSimpleName();
      return localInspectUUID;
    }
    catch (Exception paramObject) {}
    return null;
  }
  
  public static void initInspector(Handler paramHandler, IInspectorListener paramIInspectorListener)
  {
    if (leakInspector != null) {
      return;
    }
    leakInspector = new LeakInspector(paramHandler, paramIInspectorListener);
    sPool = new RecyclablePool(InspectUUID.class, 20);
  }
  
  private void newInspect(@NonNull Object paramObject, String paramString)
  {
    if (leakInspector.inspectorListener.onFilter(paramObject)) {}
    do
    {
      return;
      paramObject = generateInspectUUID(paramObject, paramString);
    } while (paramObject == null);
    paramObject = new LeakInspector.InspectorRunner(this, paramObject, 0);
    this.leakHandler.post(paramObject);
  }
  
  public static void startInspect(@NonNull Object paramObject, String paramString)
  {
    if (leakInspector == null)
    {
      Logger.INSTANCE.e(new String[] { "QAPM_memory_LeakInspector", "Please call initInspector before this" });
      return;
    }
    if (leakInspector.inspectorListener == null)
    {
      Logger.INSTANCE.e(new String[] { "QAPM_memory_LeakInspector", "Please init a listener first!" });
      return;
    }
    leakInspector.newInspect(paramObject, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qapmsdk.memory.leakdetect.LeakInspector
 * JD-Core Version:    0.7.0.1
 */