package com.tencent.mobileqq.fpsreport;

import acyd;
import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import com.tencent.widget.SwipListView;

public class FPSSwipListView
  extends SwipListView
{
  private acyd jdField_a_of_type_Acyd;
  private boolean jdField_a_of_type_Boolean = true;
  
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
    if (this.jdField_a_of_type_Acyd != null) {
      this.jdField_a_of_type_Acyd.a();
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Acyd != null)) {
      this.jdField_a_of_type_Acyd.b();
    }
  }
  
  public void reportScrollStateChange(int paramInt)
  {
    super.reportScrollStateChange(paramInt);
    if (this.jdField_a_of_type_Acyd != null) {
      this.jdField_a_of_type_Acyd.a(paramInt);
    }
  }
  
  public void setActTAG(String paramString)
  {
    this.jdField_a_of_type_Acyd = new acyd();
    this.jdField_a_of_type_Acyd.a(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.fpsreport.FPSSwipListView
 * JD-Core Version:    0.7.0.1
 */