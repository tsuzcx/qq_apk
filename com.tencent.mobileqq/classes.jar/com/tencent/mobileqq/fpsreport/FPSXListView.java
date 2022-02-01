package com.tencent.mobileqq.fpsreport;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import com.tencent.qqperf.monitor.dropframe.DropFrameMonitor;
import com.tencent.qqperf.monitor.fps.FPSCalculator;
import com.tencent.widget.XListView;

public class FPSXListView
  extends XListView
{
  private FPSCalculator a;
  private String b;
  private int c = 0;
  private boolean d = true;
  
  public FPSXListView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public FPSXListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 16842868);
  }
  
  public FPSXListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void b(boolean paramBoolean)
  {
    this.d = paramBoolean;
  }
  
  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    if (this.d)
    {
      paramCanvas = this.a;
      if (paramCanvas != null) {
        paramCanvas.b();
      }
    }
  }
  
  public void e()
  {
    FPSCalculator localFPSCalculator = this.a;
    if (localFPSCalculator != null) {
      localFPSCalculator.a();
    }
  }
  
  protected void reportScrollStateChange(int paramInt)
  {
    super.reportScrollStateChange(paramInt);
    FPSCalculator localFPSCalculator = this.a;
    if (localFPSCalculator != null) {
      localFPSCalculator.a(paramInt);
    }
    int i = this.c;
    if (i == 1)
    {
      if (paramInt == 0)
      {
        DropFrameMonitor.b().a("list_leba_new", false);
        return;
      }
      DropFrameMonitor.b().a("list_leba_new");
      return;
    }
    if (i == 2)
    {
      if (paramInt == 0)
      {
        DropFrameMonitor.b().a("list_leba", false);
        return;
      }
      DropFrameMonitor.b().a("list_leba");
    }
  }
  
  public void setActTAG(String paramString)
  {
    this.b = paramString;
    this.a = new FPSCalculator();
    this.a.a(paramString);
  }
  
  public void setReportType(int paramInt)
  {
    this.c = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.fpsreport.FPSXListView
 * JD-Core Version:    0.7.0.1
 */