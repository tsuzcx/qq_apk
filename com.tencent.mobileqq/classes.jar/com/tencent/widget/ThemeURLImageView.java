package com.tencent.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.widget.QQUIDelegate;

public class ThemeURLImageView
  extends URLImageView
{
  public static String CUR_THEMEID = "1000";
  boolean isSupportMaskView = true;
  Paint mPaint;
  
  public ThemeURLImageView(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public ThemeURLImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  public ThemeURLImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  private void init()
  {
    this.mPaint = new Paint();
    this.mPaint.setAntiAlias(true);
    this.mPaint.setColorFilter(QQTheme.a);
  }
  
  public static void setCurThemeId(String paramString)
  {
    CUR_THEMEID = paramString;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if ((this.isSupportMaskView) && (QQUIDelegate.b()))
    {
      paramCanvas.saveLayer(null, this.mPaint, 31);
      super.onDraw(paramCanvas);
      paramCanvas.restore();
      return;
    }
    super.onDraw(paramCanvas);
  }
  
  public void setSupportMaskView(boolean paramBoolean)
  {
    this.isSupportMaskView = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.widget.ThemeURLImageView
 * JD-Core Version:    0.7.0.1
 */