package dov.com.qq.im.capture.text;

import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextPaint;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AIOUtils;

public class BaseTextRegion
{
  int a;
  public Bitmap a;
  public Typeface a;
  int b = 0;
  int c = 0;
  int d = 0;
  public int e = 0;
  public int f = 0;
  public int g = 0;
  public int h = 0;
  public int i = 2;
  
  public BaseTextRegion()
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_AndroidGraphicsBitmap = null;
    this.jdField_a_of_type_AndroidGraphicsTypeface = null;
  }
  
  public int a(float paramFloat)
  {
    return AIOUtils.a(paramFloat, BaseApplicationImpl.getApplication().getResources());
  }
  
  public int a(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int j = 0;
    while (j < paramInt)
    {
      localStringBuilder.append("我");
      j += 1;
    }
    TextPaint localTextPaint = new TextPaint();
    if (this.jdField_a_of_type_AndroidGraphicsTypeface != null) {
      localTextPaint.setTypeface(this.jdField_a_of_type_AndroidGraphicsTypeface);
    }
    localTextPaint.setShadowLayer(a(3.0F), a(5.0F), a(5.0F), -1);
    paramInt = AIOUtils.a(100.0F, BaseApplicationImpl.getApplication().getResources());
    for (;;)
    {
      localTextPaint.setTextSize(paramInt);
      StaticLayout localStaticLayout = StaticLayoutWithMaxLines.a(localStringBuilder, 0, localStringBuilder.length(), localTextPaint, this.c, Layout.Alignment.ALIGN_NORMAL, 1.0F, 0.0F, false, null, 0, 1);
      if (localTextPaint.measureText(localStringBuilder.toString()) > this.c)
      {
        paramInt -= 1;
      }
      else
      {
        if (localStaticLayout.getHeight() <= this.d) {
          break;
        }
        paramInt -= 1;
      }
    }
    return paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.capture.text.BaseTextRegion
 * JD-Core Version:    0.7.0.1
 */