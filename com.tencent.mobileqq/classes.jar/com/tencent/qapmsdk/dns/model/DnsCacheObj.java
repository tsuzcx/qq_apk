package com.tencent.qapmsdk.dns.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class DnsCacheObj
{
  public int from;
  public String host;
  public CopyOnWriteArrayList<IpCachedItem> ipList;
  public String ssid;
  public long ttl;
  public long updateTime;
  public boolean wifi;
  
  public static String hash(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    return String.valueOf(str.hashCode());
  }
  
  public List<String> getIpList()
  {
    ArrayList localArrayList = new ArrayList();
    if ((this.ipList != null) && (this.ipList.size() > 0))
    {
      Iterator localIterator = this.ipList.iterator();
      while (localIterator.hasNext()) {
        localArrayList.add(((IpCachedItem)localIterator.next()).ip);
      }
    }
    return localArrayList;
  }
  
  public String toString()
  {
    return "DnsCacheObj{host='" + this.host + '\'' + ", ipList=" + this.ipList + ", ttl=" + this.ttl + ", updateTime=" + this.updateTime + ", wifi=" + this.wifi + ", ssid='" + this.ssid + '\'' + ", from=" + this.from + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qapmsdk.dns.model.DnsCacheObj
 * JD-Core Version:    0.7.0.1
 */