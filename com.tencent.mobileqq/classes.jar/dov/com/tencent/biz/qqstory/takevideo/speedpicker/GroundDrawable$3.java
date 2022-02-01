package dov.com.tencent.biz.qqstory.takevideo.speedpicker;

import android.util.Property;

class GroundDrawable$3
  extends Property<GroundDrawable, Integer>
{
  GroundDrawable$3(GroundDrawable paramGroundDrawable, Class paramClass, String paramString)
  {
    super(paramClass, paramString);
  }
  
  public Integer a(GroundDrawable paramGroundDrawable)
  {
    if (paramGroundDrawable != null) {
      return Integer.valueOf(GroundDrawable.b(paramGroundDrawable));
    }
    return Integer.valueOf(0);
  }
  
  public void a(GroundDrawable paramGroundDrawable, Integer paramInteger)
  {
    if (paramGroundDrawable != null) {
      GroundDrawable.b(paramGroundDrawable, paramInteger.intValue());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.speedpicker.GroundDrawable.3
 * JD-Core Version:    0.7.0.1
 */