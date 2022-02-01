package com.tencent.mobileqq.fpsreport;

import android.content.Context;
import android.graphics.Canvas;
import android.os.SystemClock;
import android.util.AttributeSet;
import com.tencent.qqperf.monitor.fps.FPSCalculator;
import com.tencent.qqperf.tools.PerformanceReportUtils;
import com.tencent.widget.PinnedFooterExpandableListView;

public class FPSPinnedFooterExpandableListView
  extends PinnedFooterExpandableListView
{
  private FPSCalculator a;
  private boolean b = false;
  private long c = 0L;
  private String d;
  
  public FPSPinnedFooterExpandableListView(Context paramContext)
  {
    super(paramContext);
  }
  
  public FPSPinnedFooterExpandableListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public FPSPinnedFooterExpandableListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    paramCanvas = this.a;
    if (paramCanvas != null) {
      paramCanvas.b();
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (this.b)
    {
      this.b = false;
      PerformanceReportUtils.a(this.d, SystemClock.uptimeMillis());
    }
  }
  
  protected void reportScrollStateChange(int paramInt)
  {
    super.reportScrollStateChange(paramInt);
    FPSCalculator localFPSCalculator = this.a;
    if (localFPSCalculator != null) {
      localFPSCalculator.a(paramInt);
    }
  }
  
  public void setActTAG(String paramString)
  {
    this.d = paramString;
    this.a = new FPSCalculator();
    this.a.a(paramString);
    setStartTime(SystemClock.uptimeMillis());
  }
  
  public void setStartTime(long paramLong)
  {
    this.b = true;
    this.c = paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.fpsreport.FPSPinnedFooterExpandableListView
 * JD-Core Version:    0.7.0.1
 */