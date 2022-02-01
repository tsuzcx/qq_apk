package dov.com.tencent.biz.qqstory.takevideo.speedpicker;

import android.util.Property;

class MarkDrawable$3
  extends Property<MarkDrawable, Float>
{
  MarkDrawable$3(MarkDrawable paramMarkDrawable, Class paramClass, String paramString)
  {
    super(paramClass, paramString);
  }
  
  public Float a(MarkDrawable paramMarkDrawable)
  {
    if (paramMarkDrawable != null) {
      return Float.valueOf(MarkDrawable.a(paramMarkDrawable));
    }
    return Float.valueOf(0.0F);
  }
  
  public void a(MarkDrawable paramMarkDrawable, Float paramFloat)
  {
    if (paramMarkDrawable != null) {
      MarkDrawable.a(paramMarkDrawable, paramFloat.floatValue());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.speedpicker.MarkDrawable.3
 * JD-Core Version:    0.7.0.1
 */