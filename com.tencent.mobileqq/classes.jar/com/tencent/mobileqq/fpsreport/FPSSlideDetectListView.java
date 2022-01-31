package com.tencent.mobileqq.fpsreport;

import android.content.Context;
import android.graphics.Canvas;
import android.os.SystemClock;
import android.util.AttributeSet;
import com.tencent.mfsdk.collector.FPSCalculator;
import com.tencent.mobileqq.utils.PerformanceReportUtils;
import com.tencent.mobileqq.widget.SlideDetectListView;

public class FPSSlideDetectListView
  extends SlideDetectListView
{
  private long jdField_a_of_type_Long;
  private FPSCalculator jdField_a_of_type_ComTencentMfsdkCollectorFPSCalculator;
  private String jdField_a_of_type_JavaLangString;
  private boolean f;
  
  public FPSSlideDetectListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    if (this.jdField_a_of_type_ComTencentMfsdkCollectorFPSCalculator != null) {
      this.jdField_a_of_type_ComTencentMfsdkCollectorFPSCalculator.b();
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (this.f)
    {
      this.f = false;
      PerformanceReportUtils.a(this.jdField_a_of_type_JavaLangString, SystemClock.uptimeMillis());
    }
  }
  
  protected void reportScrollStateChange(int paramInt)
  {
    super.reportScrollStateChange(paramInt);
    if (this.jdField_a_of_type_ComTencentMfsdkCollectorFPSCalculator != null) {
      this.jdField_a_of_type_ComTencentMfsdkCollectorFPSCalculator.a(paramInt);
    }
  }
  
  public void setActTAG(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_ComTencentMfsdkCollectorFPSCalculator = new FPSCalculator();
    this.jdField_a_of_type_ComTencentMfsdkCollectorFPSCalculator.a(paramString);
    setStartTime(SystemClock.uptimeMillis());
  }
  
  public void setStartTime(long paramLong)
  {
    this.f = true;
    this.jdField_a_of_type_Long = paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\com33.jar
 * Qualified Name:     com.tencent.mobileqq.fpsreport.FPSSlideDetectListView
 * JD-Core Version:    0.7.0.1
 */