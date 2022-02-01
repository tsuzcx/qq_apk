package com.tencent.mobileqq.fpsreport;

import android.content.Context;
import android.graphics.Canvas;
import android.os.SystemClock;
import android.util.AttributeSet;
import com.tencent.qqperf.monitor.fps.FPSCalculator;
import com.tencent.qqperf.tools.PerformanceReportUtils;
import com.tencent.widget.SwipPinnedHeaderExpandableListView;

public class FPSPinnedHeaderExpandableListView
  extends SwipPinnedHeaderExpandableListView
{
  private long jdField_a_of_type_Long = 0L;
  private FPSCalculator jdField_a_of_type_ComTencentQqperfMonitorFpsFPSCalculator;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean = false;
  
  public FPSPinnedHeaderExpandableListView(Context paramContext)
  {
    super(paramContext);
  }
  
  public FPSPinnedHeaderExpandableListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public FPSPinnedHeaderExpandableListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentQqperfMonitorFpsFPSCalculator != null) {
      this.jdField_a_of_type_ComTencentQqperfMonitorFpsFPSCalculator.a();
    }
  }
  
  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    if (this.jdField_a_of_type_ComTencentQqperfMonitorFpsFPSCalculator != null) {
      this.jdField_a_of_type_ComTencentQqperfMonitorFpsFPSCalculator.b();
    }
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = false;
      PerformanceReportUtils.a(this.jdField_a_of_type_JavaLangString, SystemClock.uptimeMillis());
    }
  }
  
  public void reportScrollStateChange(int paramInt)
  {
    super.reportScrollStateChange(paramInt);
    if (this.jdField_a_of_type_ComTencentQqperfMonitorFpsFPSCalculator != null) {
      this.jdField_a_of_type_ComTencentQqperfMonitorFpsFPSCalculator.a(paramInt);
    }
  }
  
  public void setActTAG(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_ComTencentQqperfMonitorFpsFPSCalculator = new FPSCalculator();
    this.jdField_a_of_type_ComTencentQqperfMonitorFpsFPSCalculator.a(paramString);
    setStartTime(SystemClock.uptimeMillis());
  }
  
  public void setStartTime(long paramLong)
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Long = paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.fpsreport.FPSPinnedHeaderExpandableListView
 * JD-Core Version:    0.7.0.1
 */