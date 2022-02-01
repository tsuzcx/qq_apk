package cooperation.qzone.statistic.access;

import android.content.Context;
import common.config.service.QZoneConfigHelper;
import cooperation.qzone.statistic.access.concept.Collector;
import cooperation.qzone.statistic.access.concept.Global;
import cooperation.qzone.statistic.access.concept.Key;
import cooperation.qzone.statistic.access.concept.Sampler;
import cooperation.qzone.statistic.access.concept.Statistic;
import java.util.Random;

public class WnsCollector
  extends Collector
{
  private static Context context;
  public static WnsCollector instance = new WnsCollector();
  protected Statistic publicShareInfo = new Statistic(WnsKeys.PublicKeys);
  protected Random sampleRandom;
  
  public WnsCollector()
  {
    WnsCondition localWnsCondition = new WnsCondition(QZoneConfigHelper.getAccReportInterval(), QZoneConfigHelper.getAccReportCount(), true);
    LinearSampler localLinearSampler = new LinearSampler(QZoneConfigHelper.getAccReportSamples());
    HttpAssembler localHttpAssembler = new HttpAssembler();
    localHttpAssembler.setPublicField(this.publicShareInfo);
    WapProxyHttpDeliverer localWapProxyHttpDeliverer = new WapProxyHttpDeliverer("https://wspeed.qq.com/w.cgi");
    localWapProxyHttpDeliverer.setGZipEnabled(true);
    localWapProxyHttpDeliverer.getServers().setOptionalEnabled(true);
    setCondition(localWnsCondition);
    setSampler(localLinearSampler);
    setAssembler(localHttpAssembler);
    setDeliverer(localWapProxyHttpDeliverer);
  }
  
  public static WnsCollector Instance()
  {
    if (instance == null) {
      instance = new WnsCollector();
    }
    return instance;
  }
  
  public Statistic createStatistic()
  {
    Statistic localStatistic = new Statistic(WnsKeys.PrivateKeys);
    localStatistic.setValue(WnsKeys.DType, Integer.valueOf(0));
    localStatistic.setValue(WnsKeys.ODetails, "");
    localStatistic.setValue(WnsKeys.Timestamp, Long.valueOf(System.currentTimeMillis() / 1000L));
    Key localKey = WnsKeys.Frequency;
    if (getSampler() == null) {}
    for (int i = 1;; i = getSampler().getFrequency())
    {
      localStatistic.setValue(localKey, Integer.valueOf(i));
      return localStatistic;
    }
  }
  
  public Statistic getPublicShareInfo()
  {
    return this.publicShareInfo;
  }
  
  public void init(Context paramContext)
  {
    Global.setContext(paramContext);
  }
  
  public void setPublicShareInfo(String paramString1, String paramString2, String paramString3)
  {
    this.publicShareInfo.setValue(WnsKeys.Device, paramString1);
    this.publicShareInfo.setValue(WnsKeys.SDKVersion, paramString2);
    this.publicShareInfo.setValue(WnsKeys.DeviceInfo, paramString3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.statistic.access.WnsCollector
 * JD-Core Version:    0.7.0.1
 */