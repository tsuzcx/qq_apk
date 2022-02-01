package com.tencent.qzonehub.api.lbs;

import cooperation.qzone.LbsDataV2.GpsInfo;
import java.util.concurrent.ConcurrentHashMap;

public class QZoneJustLocationProxy
  implements QZoneJustLocationInterface
{
  private static Object a = new Object();
  private static String b;
  private static ConcurrentHashMap<String, QZoneJustLocationProxy> d = new ConcurrentHashMap();
  private QZoneJustLocationInterface c;
  
  private QZoneJustLocationProxy(String paramString)
  {
    b = paramString;
    this.c = QZoneNewJustLocation.a(b);
  }
  
  public static QZoneJustLocationProxy a(String paramString)
  {
    Object localObject1 = (QZoneJustLocationProxy)d.get(paramString);
    if (localObject1 == null) {
      synchronized (a)
      {
        QZoneJustLocationProxy localQZoneJustLocationProxy = (QZoneJustLocationProxy)d.get(paramString);
        localObject1 = localQZoneJustLocationProxy;
        if (localQZoneJustLocationProxy == null)
        {
          localObject1 = new QZoneJustLocationProxy(paramString);
          d.put(paramString, localObject1);
        }
        return localObject1;
      }
    }
    return localObject1;
  }
  
  public LbsDataV2.GpsInfo a()
  {
    return this.c.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.qzonehub.api.lbs.QZoneJustLocationProxy
 * JD-Core Version:    0.7.0.1
 */