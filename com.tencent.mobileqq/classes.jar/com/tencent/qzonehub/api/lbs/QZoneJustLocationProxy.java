package com.tencent.qzonehub.api.lbs;

import cooperation.qzone.LbsDataV2.GpsInfo;
import java.util.concurrent.ConcurrentHashMap;

public class QZoneJustLocationProxy
  implements QZoneJustLocationInterface
{
  private static Object jdField_a_of_type_JavaLangObject = new Object();
  private static String jdField_a_of_type_JavaLangString;
  private static ConcurrentHashMap<String, QZoneJustLocationProxy> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private QZoneJustLocationInterface jdField_a_of_type_ComTencentQzonehubApiLbsQZoneJustLocationInterface;
  
  private QZoneJustLocationProxy(String paramString)
  {
    jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_ComTencentQzonehubApiLbsQZoneJustLocationInterface = QZoneNewJustLocation.a(jdField_a_of_type_JavaLangString);
  }
  
  public static QZoneJustLocationProxy a(String paramString)
  {
    Object localObject1 = (QZoneJustLocationProxy)jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
    if (localObject1 == null) {
      synchronized (jdField_a_of_type_JavaLangObject)
      {
        QZoneJustLocationProxy localQZoneJustLocationProxy = (QZoneJustLocationProxy)jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
        localObject1 = localQZoneJustLocationProxy;
        if (localQZoneJustLocationProxy == null)
        {
          localObject1 = new QZoneJustLocationProxy(paramString);
          jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, localObject1);
        }
        return localObject1;
      }
    }
    return localObject1;
  }
  
  public LbsDataV2.GpsInfo a()
  {
    return this.jdField_a_of_type_ComTencentQzonehubApiLbsQZoneJustLocationInterface.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qzonehub.api.lbs.QZoneJustLocationProxy
 * JD-Core Version:    0.7.0.1
 */