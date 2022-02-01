package com.tencent.mobileqq.onlinestatus.auto.location;

import com.tencent.qphone.base.util.QLog;

public class AverageSampler
{
  private String a;
  private int b;
  private int c = 0;
  private double d = 0.0D;
  private double e = 0.0D;
  private AverageSampler.OnSamplerTriggerListener f;
  private long g;
  
  AverageSampler(String paramString, int paramInt)
  {
    this.a = paramString;
    this.b = paramInt;
    a();
  }
  
  void a()
  {
    this.c = 0;
    this.d = 0.0D;
    this.e = 0.0D;
  }
  
  public void a(double paramDouble)
  {
    long l = System.currentTimeMillis();
    int i = this.c;
    Object localObject;
    if (i < this.b - 1)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("[status][sampler] ");
        ((StringBuilder)localObject).append(this.a);
        ((StringBuilder)localObject).append(" sample. count: ");
        ((StringBuilder)localObject).append(this.c);
        ((StringBuilder)localObject).append(" value: ");
        ((StringBuilder)localObject).append(paramDouble);
        ((StringBuilder)localObject).append(" total: ");
        ((StringBuilder)localObject).append(this.d);
        QLog.d("TimeSampler", 2, ((StringBuilder)localObject).toString());
      }
      this.d += paramDouble;
      this.e = Math.max(this.e, paramDouble);
      this.c += 1;
    }
    else
    {
      this.d += paramDouble;
      if (l - this.g < 30L)
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("[status][sampler] ");
          ((StringBuilder)localObject).append(this.a);
          ((StringBuilder)localObject).append(" sample. batch mode count: ");
          ((StringBuilder)localObject).append(this.c);
          ((StringBuilder)localObject).append(" value: ");
          ((StringBuilder)localObject).append(paramDouble);
          ((StringBuilder)localObject).append(" total: ");
          ((StringBuilder)localObject).append(this.d);
          QLog.d("TimeSampler", 2, ((StringBuilder)localObject).toString());
        }
        this.e = Math.max(this.e, paramDouble);
        this.c += 1;
        return;
      }
      double d1 = this.d;
      double d2 = i + 1;
      Double.isNaN(d2);
      d1 /= d2;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("[status][sampler] ");
        ((StringBuilder)localObject).append(this.a);
        ((StringBuilder)localObject).append(" sample. triggered count: ");
        ((StringBuilder)localObject).append(this.c);
        ((StringBuilder)localObject).append(" value: ");
        ((StringBuilder)localObject).append(paramDouble);
        ((StringBuilder)localObject).append(" total: ");
        ((StringBuilder)localObject).append(this.d);
        ((StringBuilder)localObject).append(" ave: ");
        ((StringBuilder)localObject).append(d1);
        QLog.d("TimeSampler", 2, ((StringBuilder)localObject).toString());
      }
      localObject = this.f;
      if (localObject != null) {
        ((AverageSampler.OnSamplerTriggerListener)localObject).a(d1, this.e);
      }
      a();
    }
    this.g = l;
  }
  
  void a(AverageSampler.OnSamplerTriggerListener paramOnSamplerTriggerListener)
  {
    this.f = paramOnSamplerTriggerListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.auto.location.AverageSampler
 * JD-Core Version:    0.7.0.1
 */