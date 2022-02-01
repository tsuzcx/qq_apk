package com.tencent.mobileqq.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.os.Build;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.util.VersionUtils;

public class BubbleVideoView
  extends BubbleImageView
{
  private static BubbleVideoView.DrawListener A;
  private boolean B;
  private Bitmap a;
  
  public BubbleVideoView(Context paramContext)
  {
    super(paramContext);
  }
  
  public BubbleVideoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public BubbleVideoView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void b(Canvas paramCanvas)
  {
    BubbleVideoView.DrawListener localDrawListener = A;
    if (localDrawListener != null) {
      localDrawListener.a(this, paramCanvas);
    }
  }
  
  public static void setDrawListener(BubbleVideoView.DrawListener paramDrawListener)
  {
    A = paramDrawListener;
  }
  
  protected void a()
  {
    String str = Build.MODEL.toUpperCase();
    if ((str.contains("M821")) || (str.contains("A0001"))) {
      this.e = 2;
    }
  }
  
  protected void a(Canvas paramCanvas)
  {
    if (c())
    {
      localObject = this.a;
      if ((localObject != null) && ((((Bitmap)localObject).getWidth() != getWidth()) || (this.a.getHeight() != getHeight())))
      {
        this.a.recycle();
        this.a = null;
      }
      if (this.a != null) {}
    }
    try
    {
      this.a = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.ARGB_8888);
    }
    catch (OutOfMemoryError localOutOfMemoryError1)
    {
      label81:
      label102:
      label123:
      Paint localPaint;
      Bitmap localBitmap;
      break label81;
    }
    try
    {
      this.a = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.ARGB_4444);
    }
    catch (OutOfMemoryError localOutOfMemoryError2)
    {
      break label102;
    }
    try
    {
      this.a = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.ARGB_4444);
    }
    catch (OutOfMemoryError localOutOfMemoryError3)
    {
      break label123;
    }
    Object localObject = this.a;
    if (localObject != null)
    {
      localObject = new Canvas((Bitmap)localObject);
      ((Canvas)localObject).setDensity(getResources().getDisplayMetrics().densityDpi);
      localPaint = new Paint(1);
      localPaint.setColor(-16777216);
      ((Canvas)localObject).drawPath(this.s, localPaint);
      localBitmap = this.a;
      if (localBitmap.getPixel(localBitmap.getWidth() >> 1, this.a.getHeight() >> 1) != -16777216)
      {
        localPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_OUT));
        ((Canvas)localObject).drawRect(0.0F, 0.0F, this.a.getWidth(), this.a.getHeight(), localPaint);
        this.q.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
      }
    }
    localObject = this.a;
    if (localObject != null)
    {
      paramCanvas.drawBitmap((Bitmap)localObject, 0.0F, 0.0F, this.q);
      return;
      super.a(paramCanvas);
    }
  }
  
  protected void b()
  {
    this.w = x;
    if (VersionUtils.e()) {
      this.e = 1;
    } else {
      this.e = 2;
    }
    a();
    this.u = getResources();
    if (Build.VERSION.SDK_INT >= 28)
    {
      this.y = true;
      Object localObject = (String)QConfigManager.b().b(462);
      if ((localObject != null) && (((String)localObject).length() > 0))
      {
        localObject = ((String)localObject).split("\\|");
        if ((localObject != null) && (localObject.length > 0))
        {
          String str = Build.MODEL.toUpperCase();
          int j = localObject.length;
          int i = 0;
          while (i < j)
          {
            CharSequence localCharSequence = localObject[i];
            if ((localCharSequence != null) && (localCharSequence.length() > 0) && (str.contains(localCharSequence)))
            {
              this.y = false;
              break;
            }
            i += 1;
          }
        }
      }
    }
    if (this.e == 1)
    {
      this.q = new Paint();
      this.q.setStyle(Paint.Style.FILL);
      this.q.setAntiAlias(true);
      this.q.setFilterBitmap(true);
      this.q.setColor(-16777216);
      if (this.y) {
        this.q.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_OUT));
      } else {
        this.q.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
      }
      this.s = new Path();
      this.t = new RectF();
      this.r = new float[8];
      return;
    }
    if (this.e == 2)
    {
      this.g = new Paint();
      this.g.setAntiAlias(true);
      this.g.setFilterBitmap(true);
      this.o = new RectF();
      this.p = new RectF();
      this.s = new Path();
      this.t = new RectF();
      this.r = new float[8];
    }
  }
  
  public boolean c()
  {
    return this.B;
  }
  
  public void draw(Canvas paramCanvas)
  {
    b(paramCanvas);
    super.draw(paramCanvas);
  }
  
  public void setUseXfermodeBitmap(boolean paramBoolean)
  {
    this.B = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.BubbleVideoView
 * JD-Core Version:    0.7.0.1
 */