package com.tencent.qapmsdk.dropframe;

import android.annotation.TargetApi;
import android.content.Context;
import android.hardware.display.DisplayManager;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.Choreographer;
import android.view.Choreographer.FrameCallback;
import android.view.Display;
import com.tencent.qapmsdk.base.config.DefaultPluginConfig;
import com.tencent.qapmsdk.base.config.PluginCombination;
import com.tencent.qapmsdk.base.listener.IBaseListener;
import com.tencent.qapmsdk.base.listener.IDropFrameListener;
import com.tencent.qapmsdk.base.meta.BaseInfo;
import com.tencent.qapmsdk.base.meta.DropFrameResultMeta;
import com.tencent.qapmsdk.base.meta.UserMeta;
import com.tencent.qapmsdk.base.monitorplugin.PluginController;
import com.tencent.qapmsdk.base.monitorplugin.QAPMMonitorPlugin;
import com.tencent.qapmsdk.common.activty.ActivityInfo;
import com.tencent.qapmsdk.common.logger.Logger;
import com.tencent.qapmsdk.common.thread.ThreadManager;
import com.tencent.qapmsdk.common.util.AndroidVersion;
import java.util.Arrays;

@TargetApi(16)
public class DropFrameMonitor
  extends QAPMMonitorPlugin
{
  private static final float DEFAULT_REFRESH_RATE = 60.0F;
  private static final int DROP_0 = 0;
  private static final int DROP_1 = 1;
  private static final int DROP_LESS_15 = 15;
  private static final int DROP_LESS_4 = 4;
  private static final int DROP_LESS_8 = 8;
  private static final int DROP_RANGE_0 = 0;
  private static final int DROP_RANGE_1 = 1;
  private static final int DROP_RANGE_2_4 = 2;
  private static final int DROP_RANGE_4_8 = 3;
  private static final int DROP_RANGE_8_15 = 4;
  private static final int DROP_RANGE_OVER_15 = 5;
  private static final long FRAME_INTERVAL_NANOS = 16666667L;
  private static final double MAX_DURATION = 1.E-009D;
  private static final float MAX_REFRESH_RATE = 62.0F;
  private static final float MIN_REFRESH_RATE = 58.0F;
  private static final int MSG_ON_FRAME_RENDERED = 1;
  private static final String TAG = "QAPM_dropframe_DropFrameMonitor";
  private static String currentScene = "";
  private static volatile DropFrameMonitor instance;
  private static boolean isStarted = false;
  @Nullable
  private Handler calHandler;
  private Choreographer choreographer;
  @NonNull
  private DropFrameResultMeta dropItem = new DropFrameResultMeta();
  @Nullable
  private Choreographer.FrameCallback fpsMeasuringCallback;
  private long frameRate = 16666667L;
  private long lastFrameTimeNs = 0L;
  
  private DropFrameMonitor()
  {
    if (!AndroidVersion.isJellyBean()) {
      return;
    }
    float f = getRefreshRate();
    if (!AndroidVersion.isJellyBean())
    {
      localLogger = Logger.INSTANCE;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("build version is low, ");
      localStringBuilder.append(f);
      localLogger.d(new String[] { "QAPM_dropframe_DropFrameMonitor", localStringBuilder.toString() });
      return;
    }
    if ((f >= 58.0F) && (f <= 62.0F))
    {
      this.frameRate = ((1.0E+009F / f));
      new Handler(Looper.getMainLooper()).post(new DropFrameMonitor.1(this));
      this.calHandler = new Handler(ThreadManager.getMonitorThreadLooper(), new DropFrameMonitor.2(this));
      this.fpsMeasuringCallback = new DropFrameMonitor.3(this);
      return;
    }
    Logger localLogger = Logger.INSTANCE;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("refresh rate is valid, ");
    localStringBuilder.append(f);
    localLogger.d(new String[] { "QAPM_dropframe_DropFrameMonitor", localStringBuilder.toString() });
  }
  
  private DropFrameMonitor(boolean paramBoolean) {}
  
  private boolean checkValidData(DropFrameResultMeta paramDropFrameResultMeta)
  {
    int i = paramDropFrameResultMeta.dropCount;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (i >= 0)
    {
      if (paramDropFrameResultMeta.duration <= 1.E-009D) {
        return false;
      }
      paramDropFrameResultMeta = paramDropFrameResultMeta.dropIntervals;
      int j = paramDropFrameResultMeta.length;
      long l1 = 0L;
      i = 0;
      while (i < j)
      {
        long l2 = paramDropFrameResultMeta[i];
        if (l2 < 0L) {
          return false;
        }
        l1 += l2;
        i += 1;
      }
      bool1 = bool2;
      if (l1 > 0L) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public static DropFrameMonitor getInstance()
  {
    if (instance == null) {
      label30:
      try
      {
        DropFrameMonitor localDropFrameMonitor = instance;
        if (localDropFrameMonitor != null) {}
      }
      finally {}
    }
    try
    {
      instance = new DropFrameMonitor();
    }
    catch (Throwable localThrowable)
    {
      break label30;
    }
    instance = new DropFrameMonitor(true);
    return instance;
  }
  
  private int getRangeIndex(int paramInt)
  {
    if (paramInt <= 0) {
      return 0;
    }
    if (paramInt == 1) {
      return 1;
    }
    if (paramInt < 4) {
      return 2;
    }
    if (paramInt < 8) {
      return 3;
    }
    if (paramInt < 15) {
      return 4;
    }
    return 5;
  }
  
  @TargetApi(17)
  private float getRefreshRate()
  {
    Object localObject = BaseInfo.app;
    if ((localObject != null) && (AndroidVersion.isJellyBeanMr1())) {
      try
      {
        localObject = (DisplayManager)((Context)localObject).getSystemService("display");
        if ((localObject != null) && (((DisplayManager)localObject).getDisplay(0) != null))
        {
          float f = ((DisplayManager)localObject).getDisplay(0).getRefreshRate();
          return f;
        }
      }
      catch (Exception localException)
      {
        Logger.INSTANCE.exception("QAPM_dropframe_DropFrameMonitor", "getRefreshRate", localException);
      }
    }
    return 60.0F;
  }
  
  private boolean preMonitorScene()
  {
    if (Looper.getMainLooper() != Looper.myLooper()) {
      return false;
    }
    Choreographer localChoreographer = this.choreographer;
    if (localChoreographer != null)
    {
      if (isStarted) {
        return false;
      }
      localChoreographer.removeFrameCallback(this.fpsMeasuringCallback);
      this.choreographer.postFrameCallback(this.fpsMeasuringCallback);
      isStarted = true;
      return true;
    }
    return false;
  }
  
  public void beginDropFrameScene(String paramString)
  {
    if (!PluginController.INSTANCE.whetherPluginSampling(PluginCombination.dropFramePlugin.plugin))
    {
      Logger.INSTANCE.i(new String[] { "QAPM_dropframe_DropFrameMonitor", "DropFrame loose: ", paramString });
      return;
    }
    Logger.INSTANCE.d(new String[] { "QAPM_dropframe_DropFrameMonitor", "beginDropFrameScene", paramString });
    if (preMonitorScene())
    {
      if (!TextUtils.isEmpty(paramString))
      {
        currentScene = paramString;
        return;
      }
      currentScene = ActivityInfo.getCurrentActivityName();
    }
  }
  
  public void setListener(@NonNull IBaseListener paramIBaseListener)
  {
    try
    {
      com.tencent.qapmsdk.base.listener.ListenerManager.dropFrameListener = (IDropFrameListener)paramIBaseListener;
      return;
    }
    catch (Exception paramIBaseListener)
    {
      Logger.INSTANCE.exception("QAPM_dropframe_DropFrameMonitor", paramIBaseListener);
    }
  }
  
  public void start() {}
  
  public void stop()
  {
    Choreographer localChoreographer = this.choreographer;
    if (localChoreographer != null)
    {
      if (!isStarted) {
        return;
      }
      localChoreographer.removeFrameCallback(this.fpsMeasuringCallback);
      this.choreographer = null;
    }
  }
  
  public void stopDropFrameScene()
  {
    Logger.INSTANCE.d(new String[] { "QAPM_dropframe_DropFrameMonitor", "stopDropFrameScene" });
    if (!isStarted) {
      return;
    }
    Choreographer localChoreographer = this.choreographer;
    if (localChoreographer == null) {
      return;
    }
    try
    {
      localChoreographer.removeFrameCallback(this.fpsMeasuringCallback);
    }
    catch (Throwable localThrowable)
    {
      Logger.INSTANCE.exception("QAPM_dropframe_DropFrameMonitor", localThrowable);
    }
    this.lastFrameTimeNs = 0L;
    Object localObject;
    if ("".equals(currentScene)) {
      localObject = ActivityInfo.getCurrentActivityName();
    } else {
      localObject = currentScene;
    }
    if (checkValidData(this.dropItem))
    {
      Logger.INSTANCE.i(new String[] { "QAPM_dropframe_DropFrameMonitor", "DropFrame, scene: ", localObject, ", state: ", String.valueOf(this.dropItem.state), " , duration: ", Float.toString(this.dropItem.duration / 1000000.0F), " , dropCount: ", Arrays.toString(this.dropItem.dropIntervals) });
      this.dropItem.scene = currentScene;
      localObject = new InsertRunnable(BaseInfo.userMeta.uin, currentScene, this.dropItem);
      this.calHandler.post((Runnable)localObject);
    }
    else
    {
      this.dropItem.reset();
    }
    currentScene = "";
    isStarted = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qapmsdk.dropframe.DropFrameMonitor
 * JD-Core Version:    0.7.0.1
 */