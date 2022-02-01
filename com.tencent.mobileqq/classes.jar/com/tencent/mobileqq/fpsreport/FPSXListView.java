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
  private int jdField_a_of_type_Int = 0;
  private FPSCalculator jdField_a_of_type_ComTencentQqperfMonitorFpsFPSCalculator;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean = true;
  
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
  
  public void b()
  {
    FPSCalculator localFPSCalculator = this.jdField_a_of_type_ComTencentQqperfMonitorFpsFPSCalculator;
    if (localFPSCalculator != null) {
      localFPSCalculator.a();
    }
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    if (this.jdField_a_of_type_Boolean)
    {
      paramCanvas = this.jdField_a_of_type_ComTencentQqperfMonitorFpsFPSCalculator;
      if (paramCanvas != null) {
        paramCanvas.b();
      }
    }
  }
  
  protected void reportScrollStateChange(int paramInt)
  {
    super.reportScrollStateChange(paramInt);
    FPSCalculator localFPSCalculator = this.jdField_a_of_type_ComTencentQqperfMonitorFpsFPSCalculator;
    if (localFPSCalculator != null) {
      localFPSCalculator.a(paramInt);
    }
    int i = this.jdField_a_of_type_Int;
    if (i == 1)
    {
      if (paramInt == 0)
      {
        DropFrameMonitor.a().a("list_leba_new", false);
        return;
      }
      DropFrameMonitor.a().a("list_leba_new");
      return;
    }
    if (i == 2)
    {
      if (paramInt == 0)
      {
        DropFrameMonitor.a().a("list_leba", false);
        return;
      }
      DropFrameMonitor.a().a("list_leba");
    }
  }
  
  public void setActTAG(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_ComTencentQqperfMonitorFpsFPSCalculator = new FPSCalculator();
    this.jdField_a_of_type_ComTencentQqperfMonitorFpsFPSCalculator.a(paramString);
  }
  
  public void setReportType(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.fpsreport.FPSXListView
 * JD-Core Version:    0.7.0.1
 */