package com.tencent.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.TextView;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;

public class ThemeTextView
  extends TextView
{
  public static String c = "1000";
  Paint a;
  boolean b = true;
  
  public ThemeTextView(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public ThemeTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public ThemeTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.widget.ThemeTextView
 * JD-Core Version:    0.7.0.1
 */