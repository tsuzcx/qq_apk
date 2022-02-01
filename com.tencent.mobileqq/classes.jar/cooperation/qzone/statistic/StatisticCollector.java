package cooperation.qzone.statistic;

import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qzonehub.api.report.lp.ILpReportUtils;
import cooperation.qzone.statistic.access.WnsCollector;
import cooperation.qzone.statistic.access.concept.Statistic;
import java.util.concurrent.atomic.AtomicBoolean;

public class StatisticCollector
{
  private AtomicBoolean inited = new AtomicBoolean(false);
  
  private String getDevice()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(Build.MODEL);
    localStringBuilder.append("(");
    localStringBuilder.append(Build.VERSION.RELEASE);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
  
  public static StatisticCollector getInstance()
  {
    if (!StatisticCollector.H.access$000().inited.get()) {
      try
      {
        if (!StatisticCollector.H.access$000().inited.get()) {
          StatisticCollector.H.access$000().init();
        }
      }
      finally {}
    }
    return StatisticCollector.H.access$000();
  }
  
  private String getSDKVersion()
  {
    return Build.VERSION.SDK;
  }
  
  private void init()
  {
    if (this.inited.get()) {
      return;
    }
    WnsCollector.Instance().init(BaseApplication.getContext());
    WnsCollector.Instance().setPublicShareInfo(getDevice(), getSDKVersion(), ((ILpReportUtils)QRoute.api(ILpReportUtils.class)).getDeviceInfor());
    WnsCollector.Instance().startWork();
    this.inited.set(true);
  }
  
  public void forceReport()
  {
    WnsCollector.Instance().forceDeliver();
  }
  
  public int getAppid()
  {
    return 1000027;
  }
  
  public String getReleaseVersion()
  {
    return ((ILpReportUtils)QRoute.api(ILpReportUtils.class)).getVersionForHabo();
  }
  
  public Statistic getStatistic()
  {
    return WnsCollector.Instance().createStatistic();
  }
  
  public void put(Statistic paramStatistic)
  {
    WnsCollector.Instance().collect(paramStatistic);
  }
  
  public void reportImmediate()
  {
    WnsCollector.Instance().forceDeliver();
    WnsCollector.Instance().flush();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.statistic.StatisticCollector
 * JD-Core Version:    0.7.0.1
 */