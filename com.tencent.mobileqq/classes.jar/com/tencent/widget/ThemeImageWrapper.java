package com.tencent.widget;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;

public class ThemeImageWrapper
{
  public static int MODE_CIRCLE = 1;
  public static int MODE_OTHER = 3;
  public static int MODE_SQURE = 2;
  int defColor;
  boolean isSupportMaskView = true;
  boolean mAdaptThemeForHead = false;
  Paint mMaskPaint = new Paint();
  private int maskColor = ThemeUtil.jdField_a_of_type_Int;
  private int maskMode = MODE_CIRCLE;
  RectF tempRectF = new RectF();
  
  public ThemeImageWrapper()
  {
    this.mMaskPaint.setAntiAlias(true);
    this.mMaskPaint.setColorFilter(ThemeUtil.jdField_a_of_type_AndroidGraphicsColorFilter);
    this.defColor = this.mMaskPaint.getColor();
  }
  
  public static boolean isNightMode()
  {
    return ("1103".equals(ThemeUtil.jdField_a_of_type_JavaLangString)) || ("2920".equals(ThemeUtil.jdField_a_of_type_JavaLangString));
  }
  
  public static boolean isNightModeForSimpleUI()
  {
    return "2920".equals(ThemeUtil.jdField_a_of_type_JavaLangString);
  }
  
  public void adaptThemeForHead(boolean paramBoolean)
  {
    this.mAdaptThemeForHead = paramBoolean;
  }
  
  public void onDraw(Canvas paramCanvas, ThemeImageWrapper.DrawInterface paramDrawInterface)
  {
    if ((paramCanvas == null) || (paramDrawInterface == null)) {
      return;
    }
    if ((this.isSupportMaskView) && (isNightMode()))
    {
      this.tempRectF.set(0.0F, 0.0F, paramDrawInterface.getWidth(), paramDrawInterface.getHeight());
      int i = this.maskMode;
      if (isNightModeForSimpleUI()) {
        i = MODE_OTHER;
      }
      if (i == MODE_CIRCLE)
      {
        paramDrawInterface.superOnDraw(paramCanvas);
        this.mMaskPaint.setColorFilter(null);
        this.mMaskPaint.setColor(this.maskColor);
        paramCanvas.drawRoundRect(this.tempRectF, this.tempRectF.centerX(), this.tempRectF.centerY(), this.mMaskPaint);
        return;
      }
      if (i == MODE_SQURE)
      {
        paramDrawInterface.superOnDraw(paramCanvas);
        this.mMaskPaint.setColorFilter(null);
        this.mMaskPaint.setColor(this.maskColor);
        paramCanvas.drawRect(this.tempRectF, this.mMaskPaint);
        return;
      }
      if (this.mMaskPaint.getColorFilter() == null) {
        this.mMaskPaint.setColorFilter(ThemeUtil.jdField_a_of_type_AndroidGraphicsColorFilter);
      }
      this.mMaskPaint.setColor(this.defColor);
      paramCanvas.saveLayer(null, this.mMaskPaint, 31);
      paramDrawInterface.superOnDraw(paramCanvas);
      paramCanvas.restore();
      return;
    }
    paramDrawInterface.superOnDraw(paramCanvas);
  }
  
  public void setMaskShape(int paramInt)
  {
    this.maskMode = paramInt;
  }
  
  public void setSupportMaskView(boolean paramBoolean)
  {
    this.isSupportMaskView = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.widget.ThemeImageWrapper
 * JD-Core Version:    0.7.0.1
 */