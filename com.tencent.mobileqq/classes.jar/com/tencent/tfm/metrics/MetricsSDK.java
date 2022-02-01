package com.tencent.tfm.metrics;

import android.content.Context;
import android.content.IntentFilter;
import com.tencent.tfm.metrics.api.DimensionProvider;
import com.tencent.tfm.metrics.api.Measure;
import com.tencent.tfm.metrics.api.Metrics;
import com.tencent.tfm.metrics.api.MetricsConfig;
import com.tencent.tfm.metrics.api.RawMeasure;
import com.tencent.tfm.metrics.api.SimpleCounter;
import com.tencent.tfm.metrics.api.StatPolicy;
import com.tencent.tfm.metrics.api.SuccessRateMeasure;
import com.tencent.tfm.metrics.utils.AppInfo;
import com.tencent.tfm.metrics.utils.ELog;
import com.tencent.tfm.metrics.utils.StringUtils;
import java.util.concurrent.atomic.AtomicBoolean;

public class MetricsSDK
  implements Metrics
{
  private static MetricsSDK instance;
  private ICollector collector;
  private DimensionProvider dimensionProvider;
  private AtomicBoolean init = new AtomicBoolean(false);
  private final InstrumentRegistry instrumentRegistry = new InstrumentRegistry();
  
  public MetricsSDK()
  {
    instance = this;
  }
  
  static MetricsSDK getInstance()
  {
    return instance;
  }
  
  private static void setLogEnable(boolean paramBoolean)
  {
    ELog.setLogAble(paramBoolean);
  }
  
  public RawMeasure buildRawMeasure(String arg1, StatPolicy... paramVarArgs)
  {
    String str = StringUtils.dealUploadValue(???);
    synchronized (this.instrumentRegistry)
    {
      RawMeasureSDK localRawMeasureSDK = (RawMeasureSDK)get(str, RawMeasureSDK.class);
      if (localRawMeasureSDK != null) {
        return localRawMeasureSDK;
      }
      paramVarArgs = new RawMeasureSDK(str, paramVarArgs);
      paramVarArgs = (RawMeasure)this.instrumentRegistry.register(paramVarArgs);
      return paramVarArgs;
    }
  }
  
  public SimpleCounter buildSimpleCounter(String paramString)
  {
    paramString = new SimpleCounterSDK(StringUtils.dealUploadValue(paramString));
    return (SimpleCounter)this.instrumentRegistry.register(paramString);
  }
  
  public SuccessRateMeasure buildSuccessRateCounter(String arg1)
  {
    Object localObject1 = StringUtils.dealUploadValue(???);
    synchronized (this.instrumentRegistry)
    {
      SuccessRateMeasureSDK localSuccessRateMeasureSDK = (SuccessRateMeasureSDK)get((String)localObject1, SuccessRateMeasureSDK.class);
      if (localSuccessRateMeasureSDK != null) {
        return localSuccessRateMeasureSDK;
      }
      localObject1 = new SuccessRateMeasureSDK((String)localObject1);
      localObject1 = (SuccessRateMeasure)this.instrumentRegistry.register((AbstractInstrument)localObject1);
      return localObject1;
    }
  }
  
  public <I extends Measure> I get(String paramString, Class<I> paramClass)
  {
    paramString = StringUtils.dealUploadValue(paramString);
    return this.instrumentRegistry.get(paramString, paramClass);
  }
  
  ICollector getCollector()
  {
    return this.collector;
  }
  
  DimensionProvider getDimensionProvider()
  {
    return this.dimensionProvider;
  }
  
  public void start(Context paramContext, MetricsConfig paramMetricsConfig)
  {
    if (!this.init.compareAndSet(false, true)) {
      return;
    }
    Context localContext = paramContext.getApplicationContext();
    this.collector = new AndroidCollector();
    this.collector.setReporter(paramMetricsConfig.getReporter());
    if (paramMetricsConfig.getReportInterval() >= 1000L) {
      this.collector.updateReportInterval(paramMetricsConfig.getReportInterval());
    }
    if (paramMetricsConfig.getDimensionProvider() == null) {}
    for (paramContext = new DefaultDimensionProvider(localContext);; paramContext = paramMetricsConfig.getDimensionProvider())
    {
      this.dimensionProvider = paramContext;
      AppInfo.setChannel(paramMetricsConfig.getChannel());
      paramContext = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
      localContext.registerReceiver(new NetworkStateReceiver(), paramContext);
      setLogEnable(paramMetricsConfig.isLogEnable());
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tfm.metrics.MetricsSDK
 * JD-Core Version:    0.7.0.1
 */