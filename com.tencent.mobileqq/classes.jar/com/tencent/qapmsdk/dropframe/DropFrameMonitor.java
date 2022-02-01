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
      Logger.INSTANCE.d(new String[] { "QAPM_dropframe_DropFrameMonitor", "build version is low, " + f });
      return;
    }
    if ((f < 58.0F) || (f > 62.0F))
    {
      Logger.INSTANCE.d(new String[] { "QAPM_dropframe_DropFrameMonitor", "refresh rate is valid, " + f });
      return;
    }
    this.frameRate = ((1.0E+009F / f));
    new Handler(Looper.getMainLooper()).post(new DropFrameMonitor.1(this));
    this.calHandler = new Handler(ThreadManager.getMonitorThreadLooper(), new DropFrameMonitor.2(this));
    this.fpsMeasuringCallback = new DropFrameMonitor.3(this);
  }
  
  private DropFrameMonitor(boolean paramBoolean) {}
  
  private boolean checkValidData(DropFrameResultMeta paramDropFrameResultMeta)
  {
    if ((paramDropFrameResultMeta.dropCount < 0) || (paramDropFrameResultMeta.duration <= 1.E-009D)) {}
    long l1;
    label65:
    do
    {
      return false;
      paramDropFrameResultMeta = paramDropFrameResultMeta.dropIntervals;
      int j = paramDropFrameResultMeta.length;
      int i = 0;
      l1 = 0L;
      for (;;)
      {
        if (i >= j) {
          break label65;
        }
        long l2 = paramDropFrameResultMeta[i];
        if (l2 < 0L) {
          break;
        }
        l1 += l2;
        i += 1;
      }
    } while (l1 <= 0L);
    return true;
  }
  
  /* Error */
  public static DropFrameMonitor getInstance()
  {
    // Byte code:
    //   0: getstatic 206	com/tencent/qapmsdk/dropframe/DropFrameMonitor:instance	Lcom/tencent/qapmsdk/dropframe/DropFrameMonitor;
    //   3: ifnonnull +27 -> 30
    //   6: ldc 2
    //   8: monitorenter
    //   9: getstatic 206	com/tencent/qapmsdk/dropframe/DropFrameMonitor:instance	Lcom/tencent/qapmsdk/dropframe/DropFrameMonitor;
    //   12: astore_0
    //   13: aload_0
    //   14: ifnonnull +13 -> 27
    //   17: new 2	com/tencent/qapmsdk/dropframe/DropFrameMonitor
    //   20: dup
    //   21: invokespecial 207	com/tencent/qapmsdk/dropframe/DropFrameMonitor:<init>	()V
    //   24: putstatic 206	com/tencent/qapmsdk/dropframe/DropFrameMonitor:instance	Lcom/tencent/qapmsdk/dropframe/DropFrameMonitor;
    //   27: ldc 2
    //   29: monitorexit
    //   30: getstatic 206	com/tencent/qapmsdk/dropframe/DropFrameMonitor:instance	Lcom/tencent/qapmsdk/dropframe/DropFrameMonitor;
    //   33: areturn
    //   34: astore_0
    //   35: new 2	com/tencent/qapmsdk/dropframe/DropFrameMonitor
    //   38: dup
    //   39: iconst_1
    //   40: invokespecial 209	com/tencent/qapmsdk/dropframe/DropFrameMonitor:<init>	(Z)V
    //   43: putstatic 206	com/tencent/qapmsdk/dropframe/DropFrameMonitor:instance	Lcom/tencent/qapmsdk/dropframe/DropFrameMonitor;
    //   46: goto -19 -> 27
    //   49: astore_0
    //   50: ldc 2
    //   52: monitorexit
    //   53: aload_0
    //   54: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   12	2	0	localDropFrameMonitor	DropFrameMonitor
    //   34	1	0	localThrowable	Throwable
    //   49	5	0	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   17	27	34	java/lang/Throwable
    //   9	13	49	finally
    //   17	27	49	finally
    //   27	30	49	finally
    //   35	46	49	finally
    //   50	53	49	finally
  }
  
  private int getRangeIndex(int paramInt)
  {
    int i = 1;
    if (paramInt <= 0) {
      i = 0;
    }
    while (paramInt == 1) {
      return i;
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
    float f2 = 60.0F;
    float f1 = f2;
    if (localObject != null)
    {
      f1 = f2;
      if (!AndroidVersion.isJellyBeanMr1()) {}
    }
    for (;;)
    {
      try
      {
        localObject = (DisplayManager)((Context)localObject).getSystemService("display");
        if ((localObject != null) && (((DisplayManager)localObject).getDisplay(0) != null))
        {
          f1 = ((DisplayManager)localObject).getDisplay(0).getRefreshRate();
          return f1;
        }
      }
      catch (Exception localException)
      {
        Logger.INSTANCE.exception("QAPM_dropframe_DropFrameMonitor", "getRefreshRate", localException);
        return 60.0F;
      }
      f1 = 60.0F;
    }
  }
  
  private boolean preMonitorScene()
  {
    if (Looper.getMainLooper() != Looper.myLooper()) {}
    while ((this.choreographer == null) || (isStarted)) {
      return false;
    }
    this.choreographer.removeFrameCallback(this.fpsMeasuringCallback);
    this.choreographer.postFrameCallback(this.fpsMeasuringCallback);
    isStarted = true;
    return true;
  }
  
  public void beginDropFrameScene(String paramString)
  {
    if (!PluginController.INSTANCE.whetherPluginSampling(PluginCombination.dropFramePlugin.plugin)) {
      Logger.INSTANCE.i(new String[] { "QAPM_dropframe_DropFrameMonitor", "DropFrame loose: ", paramString });
    }
    do
    {
      return;
      Logger.INSTANCE.d(new String[] { "QAPM_dropframe_DropFrameMonitor", "beginDropFrameScene", paramString });
    } while (!preMonitorScene());
    if (!TextUtils.isEmpty(paramString))
    {
      currentScene = paramString;
      return;
    }
    currentScene = ActivityInfo.getCurrentActivityName();
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
    if ((this.choreographer == null) || (!isStarted)) {
      return;
    }
    this.choreographer.removeFrameCallback(this.fpsMeasuringCallback);
    this.choreographer = null;
  }
  
  public void stopDropFrameScene()
  {
    Logger.INSTANCE.d(new String[] { "QAPM_dropframe_DropFrameMonitor", "stopDropFrameScene" });
    if (!isStarted) {}
    while (this.choreographer == null) {
      return;
    }
    try
    {
      this.choreographer.removeFrameCallback(this.fpsMeasuringCallback);
      this.lastFrameTimeNs = 0L;
      if ("".equals(currentScene))
      {
        Object localObject = ActivityInfo.getCurrentActivityName();
        if (!checkValidData(this.dropItem)) {
          break label237;
        }
        Logger.INSTANCE.i(new String[] { "QAPM_dropframe_DropFrameMonitor", "DropFrame, scene: ", localObject, ", state: ", String.valueOf(this.dropItem.state), " , duration: ", Float.toString(this.dropItem.duration / 1000000.0F), " , dropCount: ", Arrays.toString(this.dropItem.dropIntervals) });
        this.dropItem.scene = currentScene;
        localObject = new InsertRunnable(BaseInfo.userMeta.uin, currentScene, this.dropItem);
        this.calHandler.post((Runnable)localObject);
        currentScene = "";
        isStarted = false;
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        Logger.INSTANCE.exception("QAPM_dropframe_DropFrameMonitor", localThrowable);
        continue;
        String str = currentScene;
        continue;
        label237:
        this.dropItem.reset();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qapmsdk.dropframe.DropFrameMonitor
 * JD-Core Version:    0.7.0.1
 */