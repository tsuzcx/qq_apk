package dov.com.qq.im.story.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import bnvb;
import bojo;
import zlx;

public class BeautyProviderView
  extends FrameLayout
{
  private float jdField_a_of_type_Float = 1.0F;
  public int a;
  private bnvb jdField_a_of_type_Bnvb;
  private bojo jdField_a_of_type_Bojo;
  private int b = 500;
  private final int c = 300;
  
  public BeautyProviderView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_Int = zlx.a(getContext(), 242.0F);
  }
  
  public BeautyProviderView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Int = zlx.a(getContext(), 242.0F);
  }
  
  public void setControllerAndManager(bojo parambojo, bnvb parambnvb)
  {
    this.jdField_a_of_type_Bojo = parambojo;
    this.jdField_a_of_type_Bnvb = parambnvb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.story.view.BeautyProviderView
 * JD-Core Version:    0.7.0.1
 */