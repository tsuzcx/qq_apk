package cooperation.ilive.lite.metrics;

import com.tencent.tfm.metrics.api.Metrics;
import com.tencent.tfm.metrics.api.MetricsApi;
import com.tencent.tfm.metrics.api.SimpleCounter;

public class LiveMetricsReportImpl
  implements ILiveMetricsReport
{
  public void a(String paramString)
  {
    MetricsApi.getDefault().buildSimpleCounter(paramString);
  }
  
  public void a(String paramString, float paramFloat, String... paramVarArgs)
  {
    ((SimpleCounter)MetricsApi.getDefault().get(paramString, SimpleCounter.class)).count(paramFloat, paramVarArgs);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.ilive.lite.metrics.LiveMetricsReportImpl
 * JD-Core Version:    0.7.0.1
 */