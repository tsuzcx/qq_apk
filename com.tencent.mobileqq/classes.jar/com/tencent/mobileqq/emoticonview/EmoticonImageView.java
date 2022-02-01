package com.tencent.mobileqq.emoticonview;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import com.tencent.image.URLImageView;

public class EmoticonImageView
  extends URLImageView
{
  private static boolean sDisableNewIcon;
  private static Rect sDstRect;
  private static Bitmap sNewIcon;
  private static Rect sSrcRect;
  private boolean mNewIconVisible;
  private Paint mPaint;
  
  public EmoticonImageView(Context paramContext)
  {
    super(paramContext);
  }
  
  public EmoticonImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public EmoticonImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public static void disableNewIcon(boolean paramBoolean)
  {
    sDisableNewIcon = paramBoolean;
  }
  
  public static boolean isNewIconDisable()
  {
    return sDisableNewIcon;
  }
  
  public boolean isNewIconVisible()
  {
    return this.mNewIconVisible;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (!sDisableNewIcon)
    {
      if (!this.mNewIconVisible) {
        return;
      }
      if (sNewIcon != null) {}
    }
    try
    {
      sNewIcon = BitmapFactory.decodeResource(super.getResources(), 2130850889);
    }
    catch (Exception localException)
    {
      label40:
      Bitmap localBitmap;
      int i;
      int j;
      int m;
      int k;
      break label40;
    }
    localBitmap = sNewIcon;
    if (localBitmap != null)
    {
      if (sSrcRect == null)
      {
        i = localBitmap.getWidth();
        j = sNewIcon.getHeight();
        m = super.getWidth();
        k = super.getHeight();
        sSrcRect = new Rect(0, 0, i, j);
        m = (m - i) / 2;
        k = (int)(k - super.getResources().getDisplayMetrics().density * 13.0F);
        sDstRect = new Rect(m, k, i + m, j + k);
      }
      if (this.mPaint == null) {
        this.mPaint = new Paint();
      }
      paramCanvas.drawBitmap(sNewIcon, sSrcRect, sDstRect, this.mPaint);
    }
  }
  
  public void setNewIconVisible(boolean paramBoolean)
  {
    this.mNewIconVisible = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmoticonImageView
 * JD-Core Version:    0.7.0.1
 */