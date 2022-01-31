package cooperation.qzone.statistic.access;

import android.content.Context;
import bgfp;
import bhme;
import bhmf;
import bhmj;
import bhmk;
import bhml;
import bhmm;
import bhmt;
import bhmu;
import cooperation.qzone.statistic.access.concept.Collector;
import cooperation.qzone.statistic.access.concept.Key;
import cooperation.qzone.statistic.access.concept.Statistic;

public class WnsCollector
  extends Collector
{
  public static WnsCollector a;
  protected Statistic a;
  
  static
  {
    jdField_a_of_type_CooperationQzoneStatisticAccessWnsCollector = new WnsCollector();
  }
  
  public WnsCollector()
  {
    this.jdField_a_of_type_CooperationQzoneStatisticAccessConceptStatistic = new Statistic(WnsKeys.PublicKeys);
    bhmm localbhmm = new bhmm(bgfp.d(), bgfp.c(), true);
    bhmk localbhmk = new bhmk(bgfp.a());
    bhme localbhme = new bhme();
    localbhme.a(this.jdField_a_of_type_CooperationQzoneStatisticAccessConceptStatistic);
    bhml localbhml = new bhml("https://wspeed.qq.com/w.cgi");
    localbhml.a(true);
    localbhml.a().a(true);
    a(localbhmm);
    a(localbhmk);
    a(localbhme);
    a(localbhml);
  }
  
  public static WnsCollector a()
  {
    if (jdField_a_of_type_CooperationQzoneStatisticAccessWnsCollector == null) {
      jdField_a_of_type_CooperationQzoneStatisticAccessWnsCollector = new WnsCollector();
    }
    return jdField_a_of_type_CooperationQzoneStatisticAccessWnsCollector;
  }
  
  public Statistic a()
  {
    Statistic localStatistic = new Statistic(WnsKeys.PrivateKeys);
    localStatistic.setValue(WnsKeys.DType, Integer.valueOf(0));
    localStatistic.setValue(WnsKeys.ODetails, "");
    localStatistic.setValue(WnsKeys.Timestamp, Long.valueOf(System.currentTimeMillis() / 1000L));
    Key localKey = WnsKeys.Frequency;
    if (a() == null) {}
    for (int i = 1;; i = a().a())
    {
      localStatistic.setValue(localKey, Integer.valueOf(i));
      return localStatistic;
    }
  }
  
  public void a(Context paramContext)
  {
    bhmt.a(paramContext);
  }
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    this.jdField_a_of_type_CooperationQzoneStatisticAccessConceptStatistic.setValue(WnsKeys.Device, paramString1);
    this.jdField_a_of_type_CooperationQzoneStatisticAccessConceptStatistic.setValue(WnsKeys.SDKVersion, paramString2);
    this.jdField_a_of_type_CooperationQzoneStatisticAccessConceptStatistic.setValue(WnsKeys.DeviceInfo, paramString3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.statistic.access.WnsCollector
 * JD-Core Version:    0.7.0.1
 */