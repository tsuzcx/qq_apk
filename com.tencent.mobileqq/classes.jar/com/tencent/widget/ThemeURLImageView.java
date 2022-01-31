package com.tencent.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.theme.ThemeUtil;

public class ThemeURLImageView
  extends URLImageView
{
  public static String a;
  Paint jdField_a_of_type_AndroidGraphicsPaint;
  boolean jdField_a_of_type_Boolean = true;
  
  static
  {
    jdField_a_of_type_JavaLangString = "1000";
  }
  
  public ThemeURLImageView(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public ThemeURLImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public ThemeURLImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private void a()
  {
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidGraphicsPaint.setColorFilter(ThemeUtil.NIGHTMODE_COLORFILTER);
  }
  
  public static void setCurThemeId(String paramString)
  {
    jdField_a_of_type_JavaLangString = paramString;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if ((this.jdField_a_of_type_Boolean) && (ThemeUtil.isNowThemeIsNight(null, false, ThemeUtil.curThemeId)))
    {
      paramCanvas.saveLayer(null, this.jdField_a_of_type_AndroidGraphicsPaint, 31);
      super.onDraw(paramCanvas);
      paramCanvas.restore();
      return;
    }
    super.onDraw(paramCanvas);
  }
  
  public void setSupportMaskView(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.widget.ThemeURLImageView
 * JD-Core Version:    0.7.0.1
 */