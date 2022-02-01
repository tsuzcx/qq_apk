package com.tencent.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;

public class ThemeRecentDynamicAvatarView
  extends RecentDynamicAvatarView
{
  public static String t = "1000";
  Paint r;
  boolean s = true;
  
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
    this.r = new Paint();
    this.r.setAntiAlias(true);
    this.r.setColorFilter(ThemeUtil.NIGHTMODE_COLORFILTER);
  }
  
  public static void setCurThemeId(String paramString)
  {
    t = paramString;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if ((this.s) && (ThemeUtil.isNowThemeIsNight(null, false, ThemeUtil.curThemeId)))
    {
      paramCanvas.saveLayer(null, this.r, 31);
      super.onDraw(paramCanvas);
      paramCanvas.restore();
      return;
    }
    super.onDraw(paramCanvas);
  }
  
  public void setSupportMaskView(boolean paramBoolean)
  {
    this.s = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.widget.ThemeRecentDynamicAvatarView
 * JD-Core Version:    0.7.0.1
 */