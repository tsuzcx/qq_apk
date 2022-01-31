package dov.com.qq.im.story.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import blft;
import blqk;
import xsm;

public class BeautyProviderView
  extends FrameLayout
{
  private float jdField_a_of_type_Float = 1.0F;
  public int a;
  private blft jdField_a_of_type_Blft;
  private blqk jdField_a_of_type_Blqk;
  private int b = 500;
  private final int c = 300;
  
  public BeautyProviderView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_Int = xsm.a(getContext(), 242.0F);
  }
  
  public BeautyProviderView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Int = xsm.a(getContext(), 242.0F);
  }
  
  public void setControllerAndManager(blqk paramblqk, blft paramblft)
  {
    this.jdField_a_of_type_Blqk = paramblqk;
    this.jdField_a_of_type_Blft = paramblft;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     dov.com.qq.im.story.view.BeautyProviderView
 * JD-Core Version:    0.7.0.1
 */