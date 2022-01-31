package com.tencent.mobileqq.fpsreport;

import android.content.Context;
import android.graphics.Canvas;
import android.os.SystemClock;
import android.util.AttributeSet;
import baec;
import com.tencent.widget.PinnedFooterExpandableListView;
import zqp;

public class FPSPinnedFooterExpandableListView
  extends PinnedFooterExpandableListView
{
  private long jdField_a_of_type_Long;
  private String jdField_a_of_type_JavaLangString;
  private zqp jdField_a_of_type_Zqp;
  private boolean b;
  
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
    if (this.jdField_a_of_type_Zqp != null) {
      this.jdField_a_of_type_Zqp.b();
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (this.b)
    {
      this.b = false;
      baec.a(this.jdField_a_of_type_JavaLangString, SystemClock.uptimeMillis());
    }
  }
  
  public void reportScrollStateChange(int paramInt)
  {
    super.reportScrollStateChange(paramInt);
    if (this.jdField_a_of_type_Zqp != null) {
      this.jdField_a_of_type_Zqp.a(paramInt);
    }
  }
  
  public void setActTAG(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Zqp = new zqp();
    this.jdField_a_of_type_Zqp.a(paramString);
    setStartTime(SystemClock.uptimeMillis());
  }
  
  public void setStartTime(long paramLong)
  {
    this.b = true;
    this.jdField_a_of_type_Long = paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.fpsreport.FPSPinnedFooterExpandableListView
 * JD-Core Version:    0.7.0.1
 */