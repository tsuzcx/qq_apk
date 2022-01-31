package cooperation.qzone.statistic;

import android.os.Build;
import android.os.Build.VERSION;
import bfpj;
import bfpk;
import bgdq;
import com.tencent.qphone.base.util.BaseApplication;
import cooperation.qzone.statistic.access.WnsCollector;
import cooperation.qzone.statistic.access.concept.Statistic;
import java.util.concurrent.atomic.AtomicBoolean;

public class StatisticCollector
{
  private AtomicBoolean inited = new AtomicBoolean(false);
  
  private String getDevice()
  {
    return Build.MODEL + "(" + Build.VERSION.RELEASE + ")";
  }
  
  public static StatisticCollector getInstance()
  {
    if (!bgdq.a().inited.get()) {}
    try
    {
      if (!bgdq.a().inited.get()) {
        bgdq.a().init();
      }
      return bgdq.a();
    }
    finally {}
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
    WnsCollector.a().a(BaseApplication.getContext());
    WnsCollector.a().a(getDevice(), getSDKVersion(), bfpj.a().c());
    WnsCollector.a().a();
    this.inited.set(true);
  }
  
  public void forceReport()
  {
    WnsCollector.a().g();
  }
  
  public int getAppid()
  {
    return 1000027;
  }
  
  public String getReleaseVersion()
  {
    return bfpk.c();
  }
  
  public Statistic getStatistic()
  {
    return WnsCollector.a().a();
  }
  
  public void put(Statistic paramStatistic)
  {
    WnsCollector.a().a(paramStatistic);
  }
  
  public void reportImmediate()
  {
    WnsCollector.a().g();
    WnsCollector.a().f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.statistic.StatisticCollector
 * JD-Core Version:    0.7.0.1
 */