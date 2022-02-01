package cooperation.ilive.lite;

import com.tencent.mobileqq.vas.ipc.RemoteProxy;
import cooperation.ilive.lite.metrics.ILiveMetricsReport;
import cooperation.ilive.lite.metrics.LiveMetricsReportImpl;

public class IliveMetricsReportUtil
{
  public static void a()
  {
    ((ILiveMetricsReport)RemoteProxy.getProxy(LiveMetricsReportImpl.class)).a("ilive_watch");
  }
  
  public static void a(String paramString)
  {
    ((ILiveMetricsReport)RemoteProxy.getProxy(LiveMetricsReportImpl.class)).a("ilive_watch", 1.0F, new String[] { paramString });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.ilive.lite.IliveMetricsReportUtil
 * JD-Core Version:    0.7.0.1
 */