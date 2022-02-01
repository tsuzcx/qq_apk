package com.tencent.qapmsdk.bigbitmap;

import android.app.Application;
import android.support.annotation.NonNull;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.qapmsdk.base.config.DefaultPluginConfig;
import com.tencent.qapmsdk.base.config.PluginCombination;
import com.tencent.qapmsdk.base.listener.IBaseListener;
import com.tencent.qapmsdk.base.meta.BaseInfo;
import com.tencent.qapmsdk.base.monitorplugin.QAPMMonitorPlugin;
import com.tencent.qapmsdk.base.reporter.CommonReporter;
import com.tencent.qapmsdk.bigbitmap.checker.DefaultBitmapSizeChecker;
import com.tencent.qapmsdk.bigbitmap.checker.IBitmapSizeChecker;
import com.tencent.qapmsdk.bigbitmap.listener.BitmapExceedListener;
import com.tencent.qapmsdk.bigbitmap.listener.IBitmapExceedListener;
import com.tencent.qapmsdk.bigbitmap.provider.BitmapDrawableSizeProvider;
import com.tencent.qapmsdk.bigbitmap.provider.RootDrawableSizeProvider;
import com.tencent.qapmsdk.bigbitmap.provider.StateListDrawableSizeProvider;
import com.tencent.qapmsdk.common.activty.LifecycleCallback;
import com.tencent.qapmsdk.common.logger.Logger;
import com.tencent.qapmsdk.common.reporter.IPluginReport;
import com.tencent.qapmsdk.common.util.AndroidVersion;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

public class BitmapMonitor
  extends QAPMMonitorPlugin
{
  private static final String TAG = "QAPM_bigbitmap_BitmapMonitor";
  private static volatile BitmapMonitor instance;
  private Application application;
  private Detector detector = new Detector(new DefaultBitmapSizeChecker());
  IBitmapExceedListener exceedBitmapListener;
  private Set<String> excludedActSet = new HashSet();
  private AtomicBoolean hasInit = new AtomicBoolean(false);
  private BitmapMonitor.BitmapMonitorLifecycleCallbacks lifecycleCallbacks = new BitmapMonitor.BitmapMonitorLifecycleCallbacks(this);
  
  private JSONObject getExtraData()
  {
    JSONObject localJSONObject = new JSONObject();
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    Object localObject = (WindowManager)this.application.getSystemService("window");
    if (localObject != null)
    {
      localObject = ((WindowManager)localObject).getDefaultDisplay();
      if (!AndroidVersion.isJellyBeanMr1()) {
        break label120;
      }
      ((Display)localObject).getRealMetrics(localDisplayMetrics);
    }
    for (;;)
    {
      try
      {
        localJSONObject.put("resolution", localDisplayMetrics.widthPixels + "*" + localDisplayMetrics.heightPixels);
        localJSONObject.put("ppi", localDisplayMetrics.densityDpi);
        localJSONObject.put("threshold", this.detector.getBitmapSizeChecker().getThreshold());
        return localJSONObject;
      }
      catch (Exception localException)
      {
        label120:
        Logger.INSTANCE.e(new String[] { "QAPM_bigbitmap_BitmapMonitor", "getExtraData error: ", localException.getMessage() });
      }
      ((Display)localObject).getMetrics(localDisplayMetrics);
    }
    return localJSONObject;
  }
  
  public static BitmapMonitor getInstance()
  {
    if (instance == null) {}
    try
    {
      if (instance == null) {
        instance = new BitmapMonitor();
      }
      return instance;
    }
    finally {}
  }
  
  private void initIfNecessary()
  {
    if (this.hasInit.compareAndSet(false, true))
    {
      this.application = BaseInfo.app;
      this.exceedBitmapListener = new BitmapExceedListener();
      CommonReporter localCommonReporter = new CommonReporter(PluginCombination.bigBitmapPlugin.plugin);
      localCommonReporter.setExtraData(getExtraData());
      instance.setReporter(localCommonReporter);
      this.detector.addDrawableSizeProvider(new BitmapDrawableSizeProvider());
      this.detector.addDrawableSizeProvider(new StateListDrawableSizeProvider());
      this.detector.addDrawableSizeProvider(new RootDrawableSizeProvider());
    }
  }
  
  private boolean isActExcluded(String paramString)
  {
    return this.excludedActSet.contains(paramString);
  }
  
  private void setReporter(IPluginReport paramIPluginReport)
  {
    this.exceedBitmapListener.setReporter(paramIPluginReport);
  }
  
  public BitmapMonitor addExcludedAct(List<String> paramList)
  {
    this.excludedActSet.addAll(paramList);
    return this;
  }
  
  public void setListener(@NonNull IBaseListener paramIBaseListener) {}
  
  public void start()
  {
    initIfNecessary();
    stop();
    LifecycleCallback.INSTANCE.register(this.lifecycleCallbacks);
  }
  
  public void stop()
  {
    LifecycleCallback.INSTANCE.unRegister(this.lifecycleCallbacks);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qapmsdk.bigbitmap.BitmapMonitor
 * JD-Core Version:    0.7.0.1
 */