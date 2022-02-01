package com.tencent.mobileqq.fpsreport;

import android.content.Context;
import android.graphics.Canvas;
import android.os.SystemClock;
import android.util.AttributeSet;
import com.tencent.mobileqq.widget.SlideDetectListView;
import com.tencent.qqperf.monitor.fps.FPSCalculator;
import com.tencent.qqperf.tools.PerformanceReportUtils;

public class FPSSlideDetectListView
  extends SlideDetectListView
{
  private FPSCalculator p;
  private boolean q = false;
  private long r = 0L;
  private String s;
  
  public FPSSlideDetectListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    paramCanvas = this.p;
    if (paramCanvas != null) {
      paramCanvas.b();
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (this.q)
    {
      this.q = false;
      PerformanceReportUtils.a(this.s, SystemClock.uptimeMillis());
    }
  }
  
  protected void reportScrollStateChange(int paramInt)
  {
    super.reportScrollStateChange(paramInt);
    FPSCalculator localFPSCalculator = this.p;
    if (localFPSCalculator != null) {
      localFPSCalculator.a(paramInt);
    }
  }
  
  public void setActTAG(String paramString)
  {
    this.s = paramString;
    this.p = new FPSCalculator();
    this.p.a(paramString);
    setStartTime(SystemClock.uptimeMillis());
  }
  
  public void setStartTime(long paramLong)
  {
    this.q = true;
    this.r = paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.fpsreport.FPSSlideDetectListView
 * JD-Core Version:    0.7.0.1
 */