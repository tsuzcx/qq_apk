package com.tencent.mobileqq.hotchat.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.util.AttributeSet;
import android.widget.ImageView;

public class HeartView
  extends ImageView
{
  private static Bitmap c;
  private static Bitmap d;
  private static Paint e;
  private static Canvas f;
  protected final int a = 2130846922;
  protected final int b = 2130846921;
  private boolean g = true;
  
  public HeartView(Context paramContext)
  {
    super(paramContext);
  }
  
  public HeartView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public HeartView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public static Bitmap a(int paramInt1, int paramInt2)
  {
    try
    {
      Bitmap localBitmap = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
      return localBitmap;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      localOutOfMemoryError.printStackTrace();
    }
    return null;
  }
  
  public Bitmap a(int paramInt)
  {
    if (c == null) {}
    try
    {
      c = BitmapFactory.decodeResource(getResources(), 2130846922);
      if (d == null) {}
      Bitmap localBitmap1;
      Bitmap localBitmap2;
      Bitmap localBitmap3;
      Canvas localCanvas;
      Paint localPaint;
      return null;
    }
    catch (OutOfMemoryError localOutOfMemoryError1)
    {
      try
      {
        d = BitmapFactory.decodeResource(getResources(), 2130846921);
        if (e == null) {
          e = new Paint(3);
        }
        if (f == null) {
          f = new Canvas();
        }
        localBitmap1 = c;
        localBitmap2 = d;
        localBitmap3 = a(localBitmap2.getWidth(), localBitmap2.getHeight());
        if (localBitmap3 == null) {
          return null;
        }
        localCanvas = f;
        localCanvas.setBitmap(localBitmap3);
        localPaint = e;
        if (this.g)
        {
          localCanvas.drawBitmap(localBitmap2, 0.0F, 0.0F, localPaint);
          localPaint.setColorFilter(new PorterDuffColorFilter(paramInt, PorterDuff.Mode.SRC_ATOP));
          localCanvas.drawBitmap(localBitmap1, (localBitmap2.getWidth() - localBitmap1.getWidth()) / 2.0F, (localBitmap2.getHeight() - localBitmap1.getHeight()) / 2.0F, localPaint);
        }
        else
        {
          localPaint.setColorFilter(new PorterDuffColorFilter(paramInt, PorterDuff.Mode.SRC_ATOP));
          localCanvas.drawBitmap(localBitmap2, 0.0F, 0.0F, localPaint);
        }
        localPaint.setColorFilter(null);
        localCanvas.setBitmap(null);
        return localBitmap3;
      }
      catch (OutOfMemoryError localOutOfMemoryError2) {}
      localOutOfMemoryError1 = localOutOfMemoryError1;
      return null;
    }
  }
  
  public void setColor(int paramInt)
  {
    Bitmap localBitmap = a(paramInt);
    if (localBitmap != null)
    {
      super.setImageBitmap(localBitmap);
      return;
    }
    super.setImageResource(2130846922);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.hotchat.ui.HeartView
 * JD-Core Version:    0.7.0.1
 */