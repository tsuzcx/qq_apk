package dov.com.qq.im.story.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import biws;
import bjao;
import vzl;

public class BeautyProviderView
  extends FrameLayout
{
  private float jdField_a_of_type_Float = 1.0F;
  public int a;
  private biws jdField_a_of_type_Biws;
  private bjao jdField_a_of_type_Bjao;
  private int b = 500;
  private final int c = 300;
  
  public BeautyProviderView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_Int = vzl.a(getContext(), 242.0F);
  }
  
  public BeautyProviderView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Int = vzl.a(getContext(), 242.0F);
  }
  
  public void setControllerAndManager(bjao parambjao, biws parambiws)
  {
    this.jdField_a_of_type_Bjao = parambjao;
    this.jdField_a_of_type_Biws = parambiws;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.story.view.BeautyProviderView
 * JD-Core Version:    0.7.0.1
 */