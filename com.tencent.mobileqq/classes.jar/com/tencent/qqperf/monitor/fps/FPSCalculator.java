package com.tencent.qqperf.monitor.fps;

import android.view.animation.AnimationUtils;
import com.tencent.qqperf.tools.BusinessRecoderForPerf;
import com.tencent.qqperf.tools.PerformanceReportUtils;
import java.util.concurrent.CopyOnWriteArrayList;

public class FPSCalculator
{
  private final CopyOnWriteArrayList<String> a = new CopyOnWriteArrayList();
  private StringBuffer b = new StringBuffer();
  private long c = -1L;
  private int d = 0;
  private String e = null;
  
  public void a()
  {
    if (this.a.size() < 1) {
      return;
    }
    new FPSCalculator.1(this).execute(new Void[0]);
  }
  
  public void a(int paramInt)
  {
    if (this.e != null)
    {
      if (paramInt == 2)
      {
        this.c = AnimationUtils.currentAnimationTimeMillis();
        this.d = 0;
        return;
      }
      if ((this.c > 0L) && (this.d > 0))
      {
        long l = AnimationUtils.currentAnimationTimeMillis() - this.c;
        if ((l > 1000L) || ((l >= 500L) && ("actFPSRecent".equals(this.e))))
        {
          paramInt = (int)Math.floor(this.d * 1000 / ((float)l * 1.0F));
          this.b.setLength(0);
          StringBuffer localStringBuffer = this.b;
          localStringBuffer.append("FPSCalculator ");
          localStringBuffer.append(this.e);
          localStringBuffer.append(" frameCount :");
          localStringBuffer.append(this.d);
          localStringBuffer.append(",diffTime :");
          localStringBuffer.append(l);
          localStringBuffer.append(" fps:");
          localStringBuffer.append(paramInt);
          localStringBuffer = this.b;
          localStringBuffer.append(",aioBusiness=");
          localStringBuffer.append(BusinessRecoderForPerf.a());
          this.a.add(this.b.toString());
          if ((paramInt > 0) && (!"".equals(this.e))) {
            PerformanceReportUtils.a(this.e, paramInt, String.valueOf(BusinessRecoderForPerf.a()));
          }
          if (this.a.size() > 100) {
            a();
          }
        }
      }
      this.c = -1L;
      this.d = 0;
    }
  }
  
  public void a(String paramString)
  {
    this.e = paramString;
  }
  
  public void b()
  {
    if (this.e != null) {
      this.d += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqperf.monitor.fps.FPSCalculator
 * JD-Core Version:    0.7.0.1
 */