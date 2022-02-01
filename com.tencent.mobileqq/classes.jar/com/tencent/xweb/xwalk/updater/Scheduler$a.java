package com.tencent.xweb.xwalk.updater;

import com.tencent.xweb.internal.i;
import org.xwalk.core.XWalkEnvironment;

class Scheduler$a
{
  public i a = new i();
  public i b = new i();
  
  public boolean a(double paramDouble1, double paramDouble2)
  {
    return a(paramDouble1, paramDouble2, 1.0D);
  }
  
  public boolean a(double paramDouble1, double paramDouble2, double paramDouble3)
  {
    double d = this.a.b;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramDouble2 <= d)
    {
      if (paramDouble2 < this.a.a) {
        return false;
      }
      bool1 = bool2;
      if (paramDouble1 <= this.b.b)
      {
        if (paramDouble1 < this.b.a) {
          return false;
        }
        bool1 = bool2;
        if (XWalkEnvironment.getTodayGrayValueByKey("DOWNLOAD_SCHEDULE") <= b(paramDouble1, paramDouble2) * 10000.0D * paramDouble3) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public double b(double paramDouble1, double paramDouble2)
  {
    return this.a.a(paramDouble2) * this.b.a(paramDouble1);
  }
  
  public String c(double paramDouble1, double paramDouble2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[ ");
    localStringBuilder.append(this.a.a);
    localStringBuilder.append(",");
    localStringBuilder.append(this.a.b);
    localStringBuilder.append("] => [");
    localStringBuilder.append(this.b.a);
    localStringBuilder.append(",");
    localStringBuilder.append(this.b.b);
    localStringBuilder.append("],scale=");
    localStringBuilder.append(b(paramDouble1, paramDouble2));
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.xweb.xwalk.updater.Scheduler.a
 * JD-Core Version:    0.7.0.1
 */