package com.tencent.qapmsdk.dns.b;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class a
{
  public String a;
  public CopyOnWriteArrayList<c> b;
  public long c;
  public long d;
  public boolean e;
  public String f;
  public int g;
  
  public static String a(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    return String.valueOf(str.hashCode());
  }
  
  public List<String> a()
  {
    ArrayList localArrayList = new ArrayList();
    if ((this.b != null) && (this.b.size() > 0))
    {
      Iterator localIterator = this.b.iterator();
      while (localIterator.hasNext()) {
        localArrayList.add(((c)localIterator.next()).a);
      }
    }
    return localArrayList;
  }
  
  public String toString()
  {
    return "DnsCacheObj{host='" + this.a + '\'' + ", ipList=" + this.b + ", ttl=" + this.c + ", updateTime=" + this.d + ", wifi=" + this.e + ", ssid='" + this.f + '\'' + ", from=" + this.g + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qapmsdk.dns.b.a
 * JD-Core Version:    0.7.0.1
 */