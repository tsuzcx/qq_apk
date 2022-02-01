package dov.com.tencent.biz.qqstory.takevideo.speedpicker;

import android.util.Property;

class MarkDrawable$2
  extends Property<MarkDrawable, Integer>
{
  MarkDrawable$2(MarkDrawable paramMarkDrawable, Class paramClass, String paramString)
  {
    super(paramClass, paramString);
  }
  
  public Integer a(MarkDrawable paramMarkDrawable)
  {
    if (paramMarkDrawable != null) {
      return Integer.valueOf(MarkDrawable.b(paramMarkDrawable));
    }
    return Integer.valueOf(255);
  }
  
  public void a(MarkDrawable paramMarkDrawable, Integer paramInteger)
  {
    if (paramMarkDrawable != null) {
      MarkDrawable.b(paramMarkDrawable, paramInteger.intValue());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.speedpicker.MarkDrawable.2
 * JD-Core Version:    0.7.0.1
 */