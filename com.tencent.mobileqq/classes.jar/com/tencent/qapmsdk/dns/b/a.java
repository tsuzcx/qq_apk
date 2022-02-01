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
    Object localObject = this.b;
    if ((localObject != null) && (((CopyOnWriteArrayList)localObject).size() > 0))
    {
      localObject = this.b.iterator();
      while (((Iterator)localObject).hasNext()) {
        localArrayList.add(((c)((Iterator)localObject).next()).a);
      }
    }
    return localArrayList;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("DnsCacheObj{host='");
    localStringBuilder.append(this.a);
    localStringBuilder.append('\'');
    localStringBuilder.append(", ipList=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", ttl=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", updateTime=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", wifi=");
    localStringBuilder.append(this.e);
    localStringBuilder.append(", ssid='");
    localStringBuilder.append(this.f);
    localStringBuilder.append('\'');
    localStringBuilder.append(", from=");
    localStringBuilder.append(this.g);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qapmsdk.dns.b.a
 * JD-Core Version:    0.7.0.1
 */