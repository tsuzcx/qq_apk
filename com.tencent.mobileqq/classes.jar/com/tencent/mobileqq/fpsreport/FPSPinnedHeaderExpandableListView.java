package com.tencent.mobileqq.fpsreport;

import adlc;
import android.content.Context;
import android.graphics.Canvas;
import android.os.SystemClock;
import android.util.AttributeSet;
import bhoc;
import com.tencent.widget.SwipPinnedHeaderExpandableListView;

public class FPSPinnedHeaderExpandableListView
  extends SwipPinnedHeaderExpandableListView
{
  private long jdField_a_of_type_Long;
  private adlc jdField_a_of_type_Adlc;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  
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
    if (this.jdField_a_of_type_Adlc != null) {
      this.jdField_a_of_type_Adlc.a();
    }
  }
  
  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    if (this.jdField_a_of_type_Adlc != null) {
      this.jdField_a_of_type_Adlc.b();
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = false;
      bhoc.a(this.jdField_a_of_type_JavaLangString, SystemClock.uptimeMillis());
    }
  }
  
  public void reportScrollStateChange(int paramInt)
  {
    super.reportScrollStateChange(paramInt);
    if (this.jdField_a_of_type_Adlc != null) {
      this.jdField_a_of_type_Adlc.a(paramInt);
    }
  }
  
  public void setActTAG(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Adlc = new adlc();
    this.jdField_a_of_type_Adlc.a(paramString);
    setStartTime(SystemClock.uptimeMillis());
  }
  
  public void setStartTime(long paramLong)
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Long = paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.fpsreport.FPSPinnedHeaderExpandableListView
 * JD-Core Version:    0.7.0.1
 */