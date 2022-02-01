package com.tencent.qqpimsecure.wificore.api.connect;

public class b
{
  public static final b ea = new b();
  private b.a eb = b.a.es;
  private String ec = "-1";
  private int ed = -1;
  protected long ee = -1L;
  private a ef = null;
  private long eg = 0L;
  private long eh = 0L;
  private long ei = -1L;
  private long ej = -1L;
  private long ek = -1L;
  private boolean el = false;
  private long em = -1L;
  private int en = -1;
  private int eo = -1;
  private float ep = -1.0F;
  private int eq = -1;
  private int er = -1;
  
  public b.a g()
  {
    return this.eb;
  }
  
  public String h()
  {
    return this.ec;
  }
  
  public boolean i()
  {
    return g() != b.a.es;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(hashCode());
    localStringBuilder.append(" ");
    localStringBuilder.append("ConnectSource: " + this.eb.toString());
    localStringBuilder.append(" startConnectTime: " + h().split(",")[0]);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqpimsecure.wificore.api.connect.b
 * JD-Core Version:    0.7.0.1
 */