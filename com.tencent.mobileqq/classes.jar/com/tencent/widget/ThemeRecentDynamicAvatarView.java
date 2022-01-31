package com.tencent.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import com.tencent.mobileqq.theme.ThemeUtil;

public class ThemeRecentDynamicAvatarView
  extends RecentDynamicAvatarView
{
  public static String c = "1000";
  Paint d;
  boolean e = true;
  
  public ThemeRecentDynamicAvatarView(Context paramContext)
  {
    super(paramContext);
    b();
  }
  
  public ThemeRecentDynamicAvatarView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    b();
  }
  
  public ThemeRecentDynamicAvatarView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    b();
  }
  
  private void b()
  {
    this.d = new Paint();
    this.d.setAntiAlias(true);
    this.d.setColorFilter(ThemeUtil.NIGHTMODE_COLORFILTER);
  }
  
  public static void setCurThemeId(String paramString)
  {
    c = paramString;
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    if ((this.e) && (ThemeUtil.isNowThemeIsNight(null, false, ThemeUtil.curThemeId)))
    {
      paramCanvas.saveLayer(null, this.d, 31);
      super.onDraw(paramCanvas);
      paramCanvas.restore();
      return;
    }
    super.onDraw(paramCanvas);
  }
  
  public void setSupportMaskView(boolean paramBoolean)
  {
    this.e = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.widget.ThemeRecentDynamicAvatarView
 * JD-Core Version:    0.7.0.1
 */