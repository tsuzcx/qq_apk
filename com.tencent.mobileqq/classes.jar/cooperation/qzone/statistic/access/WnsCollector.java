package cooperation.qzone.statistic.access;

import android.content.Context;
import bihe;
import bjog;
import bjoh;
import bjol;
import bjom;
import bjon;
import bjoo;
import bjov;
import bjow;
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
    bjoo localbjoo = new bjoo(bihe.d(), bihe.c(), true);
    bjom localbjom = new bjom(bihe.a());
    bjog localbjog = new bjog();
    localbjog.a(this.jdField_a_of_type_CooperationQzoneStatisticAccessConceptStatistic);
    bjon localbjon = new bjon("https://wspeed.qq.com/w.cgi");
    localbjon.a(true);
    localbjon.a().a(true);
    a(localbjoo);
    a(localbjom);
    a(localbjog);
    a(localbjon);
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
    bjov.a(paramContext);
  }
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    this.jdField_a_of_type_CooperationQzoneStatisticAccessConceptStatistic.setValue(WnsKeys.Device, paramString1);
    this.jdField_a_of_type_CooperationQzoneStatisticAccessConceptStatistic.setValue(WnsKeys.SDKVersion, paramString2);
    this.jdField_a_of_type_CooperationQzoneStatisticAccessConceptStatistic.setValue(WnsKeys.DeviceInfo, paramString3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     cooperation.qzone.statistic.access.WnsCollector
 * JD-Core Version:    0.7.0.1
 */