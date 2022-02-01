package com.tencent.mtt.hippy.dom.node;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Movie;
import android.graphics.Paint;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.text.style.DynamicDrawableSpan;
import android.text.style.ImageSpan;
import com.tencent.mtt.hippy.adapter.image.HippyDrawable;
import com.tencent.mtt.hippy.adapter.image.HippyImageLoader;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.utils.UIThreadUtils;
import com.tencent.mtt.hippy.utils.UrlUtils;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;

public class c
  extends ImageSpan
{
  private int a;
  private int b;
  private int c;
  private int d;
  private String e;
  private WeakReference<ImageNode> f;
  private int g = 0;
  private int h;
  private HippyImageLoader i;
  private Movie j = null;
  private int k = -1;
  private int l = 0;
  private int m = 0;
  private int n = 0;
  private float o = 1.0F;
  private float p = 1.0F;
  private boolean q = false;
  private int r = 0;
  private long s = -1L;
  
  public c(Drawable paramDrawable, String paramString, ImageNode paramImageNode, HippyImageLoader paramHippyImageLoader)
  {
    super(paramDrawable, paramString, paramImageNode.getVerticalAlignment());
    this.f = new WeakReference(paramImageNode);
    this.i = paramHippyImageLoader;
    b(paramString);
  }
  
  private void a()
  {
    Object localObject = this.f;
    if (localObject != null)
    {
      localObject = (ImageNode)((WeakReference)localObject).get();
      if (localObject != null)
      {
        int i3 = Math.round(((ImageNode)localObject).getStyleWidth());
        int i4 = Math.round(((ImageNode)localObject).getStyleHeight());
        float f1 = ((ImageNode)localObject).getPosition(1);
        int i2 = 0;
        float f2 = ((ImageNode)localObject).getPosition(0);
        int i1;
        if (f2 == (0.0F / 0.0F)) {
          i1 = 0;
        } else {
          i1 = Math.round(f2);
        }
        if (f1 != (0.0F / 0.0F)) {
          i2 = Math.round(f1);
        }
        this.a = i1;
        this.b = i2;
        this.c = i3;
        this.d = i4;
        this.h = ((ImageNode)localObject).getVerticalAlignment();
      }
    }
  }
  
  private void a(long paramLong)
  {
    Object localObject = this.f;
    if (localObject != null)
    {
      localObject = (ImageNode)((WeakReference)localObject).get();
      if (localObject != null)
      {
        localObject = ((ImageNode)localObject).getParent();
        if ((localObject != null) && ((localObject instanceof TextNode))) {
          ((TextNode)localObject).postInvalidateDelayed(paramLong);
        }
      }
    }
  }
  
  private void a(Canvas paramCanvas, float paramFloat1, float paramFloat2, int paramInt1, int paramInt2)
  {
    Movie localMovie = this.j;
    if (localMovie == null) {
      return;
    }
    int i2 = localMovie.duration();
    int i1 = i2;
    if (i2 == 0) {
      i1 = 1000;
    }
    long l1 = System.currentTimeMillis();
    long l2 = this.s;
    if (l2 != -1L)
    {
      this.r = ((int)(this.r + (l1 - l2)));
      if (this.r > i1) {
        this.r = 0;
      }
    }
    this.s = l1;
    this.o = (paramInt1 / this.j.width());
    this.p = (paramInt2 / this.j.height());
    float f2 = this.o;
    float f1 = paramFloat1;
    if (f2 != 0.0F) {
      f1 = paramFloat1 / f2;
    }
    f2 = this.p;
    paramFloat1 = paramFloat2;
    if (f2 != 0.0F) {
      paramFloat1 = paramFloat2 / f2;
    }
    this.j.setTime(this.r);
    paramCanvas.save();
    paramCanvas.scale(this.o, this.p);
    this.j.draw(paramCanvas, f1, paramFloat1);
    paramCanvas.restore();
    a(40L);
  }
  
  private void a(HippyDrawable paramHippyDrawable)
  {
    if (paramHippyDrawable != null)
    {
      Object localObject = paramHippyDrawable.getBitmap();
      if (localObject != null)
      {
        paramHippyDrawable = new BitmapDrawable((Bitmap)localObject);
        int i2 = this.c;
        int i1 = i2;
        if (i2 == 0) {
          i1 = paramHippyDrawable.getIntrinsicWidth();
        }
        int i3 = this.d;
        i2 = i3;
        if (i3 == 0) {
          i2 = paramHippyDrawable.getIntrinsicHeight();
        }
        paramHippyDrawable.setBounds(0, 0, i1, i2);
        try
        {
          localObject = ImageSpan.class.getDeclaredField("mDrawable");
          ((Field)localObject).setAccessible(true);
          ((Field)localObject).set(this, paramHippyDrawable);
          paramHippyDrawable = DynamicDrawableSpan.class.getDeclaredField("mDrawableRef");
          paramHippyDrawable.setAccessible(true);
          paramHippyDrawable.set(this, null);
        }
        catch (NoSuchFieldException paramHippyDrawable)
        {
          paramHippyDrawable.printStackTrace();
        }
        catch (IllegalAccessException paramHippyDrawable)
        {
          paramHippyDrawable.printStackTrace();
        }
      }
      else if (paramHippyDrawable.isAnimated())
      {
        this.j = paramHippyDrawable.getGIF();
      }
      a(0L);
      this.g = 2;
    }
  }
  
  private void a(String paramString, HippyMap paramHippyMap, HippyImageLoader paramHippyImageLoader)
  {
    this.g = 1;
    paramHippyImageLoader.fetchImage(paramString, new c.2(this), paramHippyMap);
  }
  
  private void c(String paramString)
  {
    if ((TextUtils.isEmpty(this.e)) || (!this.e.equals(paramString)))
    {
      this.e = paramString;
      this.g = 0;
      a();
      if (this.i != null)
      {
        if (a(this.e))
        {
          paramString = new HippyMap();
          paramString.pushBoolean("isGif", false);
          paramString.pushInt("width", this.c);
          paramString.pushInt("height", this.d);
          a(this.e, paramString, this.i);
          return;
        }
        a(this.i.getImage(this.e, null));
      }
    }
  }
  
  protected boolean a(String paramString)
  {
    return (UrlUtils.isWebUrl(paramString)) || (UrlUtils.isFileUrl(paramString));
  }
  
  public void b(String paramString)
  {
    if (UIThreadUtils.isOnUiThread())
    {
      c(paramString);
      return;
    }
    UIThreadUtils.runOnUiThread(new c.1(this, paramString));
  }
  
  public void draw(Canvas paramCanvas, CharSequence paramCharSequence, int paramInt1, int paramInt2, float paramFloat, int paramInt3, int paramInt4, int paramInt5, Paint paramPaint)
  {
    Paint.FontMetricsInt localFontMetricsInt = paramPaint.getFontMetricsInt();
    Movie localMovie = this.j;
    if (localMovie != null)
    {
      paramInt2 = this.c;
      paramInt1 = paramInt2;
      if (paramInt2 == 0) {
        paramInt1 = localMovie.width();
      }
      paramInt3 = this.d;
      paramInt2 = paramInt3;
      if (paramInt3 == 0) {
        paramInt2 = this.j.height();
      }
      paramInt3 = (localFontMetricsInt.descent + paramInt4 + paramInt4 + localFontMetricsInt.ascent) / 2;
      paramInt4 = paramInt2 / 2;
      a(paramCanvas, paramFloat + this.a, paramInt3 - paramInt4 + this.b, paramInt1, paramInt2);
      return;
    }
    if (this.h == 1)
    {
      paramCharSequence = getDrawable();
      paramInt1 = (localFontMetricsInt.descent + paramInt4 + paramInt4 + localFontMetricsInt.ascent) / 2;
      paramInt2 = paramCharSequence.getBounds().bottom / 2;
      paramCanvas.save();
      paramCanvas.translate(paramFloat + this.a, paramInt1 - paramInt2 + this.b);
      paramCharSequence.draw(paramCanvas);
      paramCanvas.restore();
      return;
    }
    super.draw(paramCanvas, paramCharSequence, paramInt1, paramInt2, paramFloat, paramInt3, paramInt4, paramInt5, paramPaint);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mtt.hippy.dom.node.c
 * JD-Core Version:    0.7.0.1
 */