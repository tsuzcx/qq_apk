package com.tencent.mobileqq.fpsreport;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import com.tencent.qqperf.monitor.fps.FPSCalculator;
import com.tencent.widget.SwipListView;

public class FPSSwipListView
  extends SwipListView
{
  private FPSCalculator a;
  private boolean b = true;
  
  public FPSSwipListView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public FPSSwipListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 16842868);
  }
  
  public FPSSwipListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void a()
  {
    FPSCalculator localFPSCalculator = this.a;
    if (localFPSCalculator != null) {
      localFPSCalculator.a();
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }
  
  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    if (this.b)
    {
      paramCanvas = this.a;
      if (paramCanvas != null) {
        paramCanvas.b();
      }
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
    this.a = new FPSCalculator();
    this.a.a(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.fpsreport.FPSSwipListView
 * JD-Core Version:    0.7.0.1
 */