package com.tencent.mobileqq.fpsreport;

import adlb;
import adlc;
import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import com.tencent.widget.XListView;

public class FPSXListView
  extends XListView
{
  private int jdField_a_of_type_Int;
  private adlc jdField_a_of_type_Adlc;
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
    if (this.jdField_a_of_type_Adlc != null) {
      this.jdField_a_of_type_Adlc.a();
    }
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Adlc != null)) {
      this.jdField_a_of_type_Adlc.b();
    }
  }
  
  public void reportScrollStateChange(int paramInt)
  {
    super.reportScrollStateChange(paramInt);
    if (this.jdField_a_of_type_Adlc != null) {
      this.jdField_a_of_type_Adlc.a(paramInt);
    }
    if (this.jdField_a_of_type_Int == 1) {
      if (paramInt == 0) {
        adlb.a().a("list_leba_new", false);
      }
    }
    while (this.jdField_a_of_type_Int != 2)
    {
      return;
      adlb.a().a("list_leba_new");
      return;
    }
    if (paramInt == 0)
    {
      adlb.a().a("list_leba", false);
      return;
    }
    adlb.a().a("list_leba");
  }
  
  public void setActTAG(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Adlc = new adlc();
    this.jdField_a_of_type_Adlc.a(paramString);
  }
  
  public void setReportType(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.fpsreport.FPSXListView
 * JD-Core Version:    0.7.0.1
 */