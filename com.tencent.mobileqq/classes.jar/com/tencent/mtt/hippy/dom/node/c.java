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
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.adapter.image.HippyDrawable;
import com.tencent.mtt.hippy.adapter.image.HippyImageLoader;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.uimanager.HippyViewEvent;
import com.tencent.mtt.hippy.utils.UIThreadUtils;
import com.tencent.mtt.hippy.utils.UrlUtils;
import com.tencent.mtt.hippy.views.image.HippyImageView.ImageEvent;
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
  private final WeakReference<ImageNode> f;
  private int g = 0;
  private int h;
  private final HippyImageLoader i;
  private final HippyEngineContext j;
  private Movie k = null;
  private int l = 0;
  private long m = -1L;
  
  public c(Drawable paramDrawable, String paramString, ImageNode paramImageNode, HippyImageLoader paramHippyImageLoader, HippyEngineContext paramHippyEngineContext)
  {
    super(paramDrawable, paramString, paramImageNode.getVerticalAlignment());
    this.j = paramHippyEngineContext;
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
        int i2 = Math.round(((ImageNode)localObject).getStyleWidth());
        int i3 = Math.round(((ImageNode)localObject).getStyleHeight());
        float f1 = ((ImageNode)localObject).getPosition(1);
        int i1 = 0;
        float f2 = ((ImageNode)localObject).getPosition(0);
        int n;
        if (Float.isNaN(f2)) {
          n = 0;
        } else {
          n = Math.round(f2);
        }
        if (!Float.isNaN(f1)) {
          i1 = Math.round(f1);
        }
        this.a = n;
        this.b = i1;
        this.c = i2;
        this.d = i3;
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
        if ((localObject instanceof TextNode)) {
          ((TextNode)localObject).postInvalidateDelayed(paramLong);
        }
      }
    }
  }
  
  private void a(Canvas paramCanvas, float paramFloat1, float paramFloat2, int paramInt1, int paramInt2)
  {
    Movie localMovie = this.k;
    if (localMovie == null) {
      return;
    }
    int i1 = localMovie.duration();
    int n = i1;
    if (i1 == 0) {
      n = 1000;
    }
    long l1 = System.currentTimeMillis();
    long l2 = this.m;
    if (l2 != -1L)
    {
      this.l = ((int)(this.l + (l1 - l2)));
      if (this.l > n) {
        this.l = 0;
      }
    }
    this.m = l1;
    float f2 = paramInt1 / this.k.width();
    float f3 = paramInt2 / this.k.height();
    float f1 = paramFloat1;
    if (f2 != 0.0F) {
      f1 = paramFloat1 / f2;
    }
    paramFloat1 = paramFloat2;
    if (f3 != 0.0F) {
      paramFloat1 = paramFloat2 / f3;
    }
    this.k.setTime(this.l);
    paramCanvas.save();
    paramCanvas.scale(f2, f3);
    this.k.draw(paramCanvas, f1, paramFloat1);
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
        int i1 = this.c;
        int n = i1;
        if (i1 == 0) {
          n = paramHippyDrawable.getIntrinsicWidth();
        }
        int i2 = this.d;
        i1 = i2;
        if (i2 == 0) {
          i1 = paramHippyDrawable.getIntrinsicHeight();
        }
        paramHippyDrawable.setBounds(0, 0, n, i1);
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
      else
      {
        if (!paramHippyDrawable.isAnimated()) {
          break label151;
        }
        this.k = paramHippyDrawable.getGIF();
      }
      this.g = 2;
      break label156;
      label151:
      this.g = 0;
      label156:
      a(0L);
      return;
    }
    this.g = 0;
  }
  
  private void a(HippyImageView.ImageEvent paramImageEvent)
  {
    Object localObject = this.f;
    if (localObject == null) {
      return;
    }
    ImageNode localImageNode = (ImageNode)((WeakReference)localObject).get();
    if (localImageNode == null) {
      return;
    }
    if (paramImageEvent == HippyImageView.ImageEvent.ONLOAD) {
      localObject = "onLoad";
    } else if (paramImageEvent == HippyImageView.ImageEvent.ONERROR) {
      localObject = "onError";
    } else {
      localObject = null;
    }
    if ((!TextUtils.isEmpty((CharSequence)localObject)) && (localImageNode.isEnableImageEvent(paramImageEvent))) {
      new HippyViewEvent((String)localObject).send(localImageNode.getId(), this.j, null);
    }
  }
  
  private void a(String paramString, HippyMap paramHippyMap, HippyImageLoader paramHippyImageLoader)
  {
    this.g = 1;
    paramHippyImageLoader.fetchImage(paramString, new c.2(this), paramHippyMap);
  }
  
  private void c(String paramString)
  {
    if ((!TextUtils.isEmpty(this.e)) && (this.e.equals(paramString)) && (this.g != 0)) {
      return;
    }
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
  
  protected boolean a(String paramString)
  {
    return (UrlUtils.isWebUrl(paramString)) || (UrlUtils.isFileUrl(paramString));
  }
  
  public void b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
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
    Movie localMovie = this.k;
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
        paramInt2 = this.k.height();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mtt.hippy.dom.node.c
 * JD-Core Version:    0.7.0.1
 */