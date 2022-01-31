package com.tencent.mobileqq.fpsreport;

import aaae;
import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import com.tencent.widget.XListView;
import zzz;

public class FPSXListView
  extends XListView
{
  private int jdField_a_of_type_Int;
  private aaae jdField_a_of_type_Aaae;
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
    if (this.jdField_a_of_type_Aaae != null) {
      this.jdField_a_of_type_Aaae.a();
    }
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Aaae != null)) {
      this.jdField_a_of_type_Aaae.b();
    }
  }
  
  public void reportScrollStateChange(int paramInt)
  {
    super.reportScrollStateChange(paramInt);
    if (this.jdField_a_of_type_Aaae != null) {
      this.jdField_a_of_type_Aaae.a(paramInt);
    }
    if (this.jdField_a_of_type_Int == 1) {
      if (paramInt == 0) {
        zzz.a().a("list_leba_new", false);
      }
    }
    while (this.jdField_a_of_type_Int != 2)
    {
      return;
      zzz.a().a("list_leba_new");
      return;
    }
    if (paramInt == 0)
    {
      zzz.a().a("list_leba", false);
      return;
    }
    zzz.a().a("list_leba");
  }
  
  public void setActTAG(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Aaae = new aaae();
    this.jdField_a_of_type_Aaae.a(paramString);
  }
  
  public void setReportType(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.fpsreport.FPSXListView
 * JD-Core Version:    0.7.0.1
 */