package com.tencent.turingfd.sdk.ams.ga;

public class Orion
{
  public int cd = -1;
  public String result = "";
  public int type = -1;
  public long ve = -1L;
  public int we = -1;
  
  public Orion(int paramInt1, int paramInt2, long paramLong, String paramString, int paramInt3)
  {
    this.cd = paramInt1;
    this.type = paramInt2;
    this.ve = paramLong;
    this.result = paramString;
    this.we = paramInt3;
  }
  
  public static Orion m(int paramInt)
  {
    return new Orion(paramInt, 100, -1L, "", -1);
  }
  
  public static Orion n(int paramInt)
  {
    return new Orion(paramInt, 200, -1L, "", -1);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.cd);
    localStringBuilder.append("_");
    localStringBuilder.append(this.type);
    localStringBuilder.append("_");
    localStringBuilder.append(this.ve);
    localStringBuilder.append("_");
    localStringBuilder.append(this.we);
    localStringBuilder.append("_");
    localStringBuilder.append(this.result);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.turingfd.sdk.ams.ga.Orion
 * JD-Core Version:    0.7.0.1
 */