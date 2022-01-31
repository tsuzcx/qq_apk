package dov.com.qq.im.story.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import blbm;
import blly;
import xod;

public class BeautyProviderView
  extends FrameLayout
{
  private float jdField_a_of_type_Float = 1.0F;
  public int a;
  private blbm jdField_a_of_type_Blbm;
  private blly jdField_a_of_type_Blly;
  private int b = 500;
  private final int c = 300;
  
  public BeautyProviderView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_Int = xod.a(getContext(), 242.0F);
  }
  
  public BeautyProviderView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Int = xod.a(getContext(), 242.0F);
  }
  
  public void setControllerAndManager(blly paramblly, blbm paramblbm)
  {
    this.jdField_a_of_type_Blly = paramblly;
    this.jdField_a_of_type_Blbm = paramblbm;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     dov.com.qq.im.story.view.BeautyProviderView
 * JD-Core Version:    0.7.0.1
 */