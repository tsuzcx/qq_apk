package cooperation.qlink;

import java.util.HashMap;

class QlinkReliableReport$PerformanceReporting
{
  private String a;
  private String b;
  private boolean c;
  private long d;
  private long e;
  private HashMap<String, String> f;
  
  public QlinkReliableReport$PerformanceReporting(String paramString1, String paramString2, boolean paramBoolean, long paramLong1, long paramLong2, HashMap<String, String> paramHashMap)
  {
    this.a = paramString1;
    this.b = paramString2;
    this.c = paramBoolean;
    this.d = paramLong1;
    this.e = paramLong2;
    this.f = paramHashMap;
  }
  
  public String a()
  {
    return this.a;
  }
  
  public String b()
  {
    return this.b;
  }
  
  public boolean c()
  {
    return this.c;
  }
  
  public long d()
  {
    return this.d;
  }
  
  public long e()
  {
    return this.e;
  }
  
  public HashMap<String, String> f()
  {
    return this.f;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("uin[");
    localStringBuilder.append(this.a);
    localStringBuilder.append("], tagName[");
    localStringBuilder.append(this.b);
    localStringBuilder.append("], success[");
    localStringBuilder.append(this.c);
    localStringBuilder.append("], size[");
    localStringBuilder.append(this.e);
    localStringBuilder.append("]");
    localStringBuilder.append(this.c);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qlink.QlinkReliableReport.PerformanceReporting
 * JD-Core Version:    0.7.0.1
 */