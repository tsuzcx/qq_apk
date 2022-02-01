package com.tencent.turingfd.sdk.xq;

public final class Cygnus
{
  public static Cygnus sh;
  public static int th;
  public static Object uh = new Object();
  public int action;
  public float pressure;
  public float size;
  public int toolType;
  public Cygnus vh;
  public int wh;
  public float xh;
  public float yh;
  
  public static Cygnus obtain()
  {
    synchronized (uh)
    {
      if (th > 0)
      {
        localCygnus = sh;
        sh = sh.vh;
        localCygnus.vh = null;
        th -= 1;
        return localCygnus;
      }
      Cygnus localCygnus = new Cygnus();
      return localCygnus;
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("action : ");
    localStringBuilder.append(this.action);
    localStringBuilder.append(",deviceId : ");
    localStringBuilder.append(this.wh);
    localStringBuilder.append(",toolType : ");
    localStringBuilder.append(this.toolType);
    localStringBuilder.append(",rawX : ");
    localStringBuilder.append(this.xh);
    localStringBuilder.append(",rawY : ");
    localStringBuilder.append(this.yh);
    localStringBuilder.append(",pressure : ");
    localStringBuilder.append(this.pressure);
    localStringBuilder.append(",size : ");
    localStringBuilder.append(this.size);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.turingfd.sdk.xq.Cygnus
 * JD-Core Version:    0.7.0.1
 */