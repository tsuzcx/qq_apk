package dov.com.tencent.biz.qqstory.takevideo.speedpicker;

import android.util.Property;

class GroundDrawable$7
  extends Property<GroundDrawable, Float>
{
  GroundDrawable$7(GroundDrawable paramGroundDrawable, Class paramClass, String paramString)
  {
    super(paramClass, paramString);
  }
  
  public Float a(GroundDrawable paramGroundDrawable)
  {
    if (paramGroundDrawable != null) {
      return Float.valueOf(GroundDrawable.d(paramGroundDrawable));
    }
    return Float.valueOf(0.0F);
  }
  
  public void a(GroundDrawable paramGroundDrawable, Float paramFloat)
  {
    if (paramGroundDrawable != null) {
      GroundDrawable.c(paramGroundDrawable, paramFloat.floatValue());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.speedpicker.GroundDrawable.7
 * JD-Core Version:    0.7.0.1
 */