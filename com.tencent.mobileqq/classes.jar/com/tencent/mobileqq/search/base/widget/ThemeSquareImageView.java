package com.tencent.mobileqq.search.base.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.SquareImageView;

public class ThemeSquareImageView
  extends SquareImageView
{
  public static String c = "1000";
  Paint a;
  boolean b = true;
  
  public ThemeSquareImageView(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public ThemeSquareImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public ThemeSquareImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private void a()
  {
    this.a = new Paint();
    this.a.setAntiAlias(true);
    this.a.setColorFilter(ThemeUtil.NIGHTMODE_COLORFILTER);
  }
  
  public static void setCurThemeId(String paramString)
  {
    c = paramString;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if ((this.b) && (ThemeUtil.isNowThemeIsNight(null, false, ThemeUtil.curThemeId)))
    {
      paramCanvas.saveLayer(null, this.a, 31);
      super.onDraw(paramCanvas);
      paramCanvas.restore();
      return;
    }
    super.onDraw(paramCanvas);
  }
  
  public void setSupportMaskView(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.base.widget.ThemeSquareImageView
 * JD-Core Version:    0.7.0.1
 */