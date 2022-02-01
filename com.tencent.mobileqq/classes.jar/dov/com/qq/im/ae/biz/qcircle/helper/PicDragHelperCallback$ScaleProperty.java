package dov.com.qq.im.ae.biz.qcircle.helper;

import android.util.Property;
import android.view.View;

public class PicDragHelperCallback$ScaleProperty
  extends Property<View, Float>
{
  public PicDragHelperCallback$ScaleProperty(String paramString)
  {
    super(Float.class, paramString);
  }
  
  public Float a(View paramView)
  {
    return Float.valueOf(paramView.getScaleX());
  }
  
  public void a(View paramView, Float paramFloat)
  {
    paramView.setScaleX(paramFloat.floatValue());
    paramView.setScaleY(paramFloat.floatValue());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.biz.qcircle.helper.PicDragHelperCallback.ScaleProperty
 * JD-Core Version:    0.7.0.1
 */