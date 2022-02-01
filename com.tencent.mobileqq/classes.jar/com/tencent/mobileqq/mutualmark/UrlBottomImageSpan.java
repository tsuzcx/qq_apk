package com.tencent.mobileqq.mutualmark;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.text.style.ImageSpan;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.qphone.base.util.QLog;
import mqq.util.WeakReference;

public class UrlBottomImageSpan
  extends ImageSpan
{
  private Context a;
  private URLDrawable b;
  private String c;
  private int d = 0;
  private WeakReference<Drawable.Callback> e;
  
  public UrlBottomImageSpan(Context paramContext, int paramInt1, String paramString, int paramInt2, Drawable.Callback paramCallback)
  {
    super(paramContext, paramInt1, 0);
    this.a = paramContext;
    this.c = paramString;
    this.d = paramInt2;
    if (paramCallback != null) {
      this.e = new WeakReference(paramCallback);
    }
  }
  
  public UrlBottomImageSpan(Context paramContext, int paramInt, String paramString, Drawable.Callback paramCallback)
  {
    this(paramContext, paramInt, paramString, 0, paramCallback);
  }
  
  public void draw(Canvas paramCanvas, CharSequence paramCharSequence, int paramInt1, int paramInt2, float paramFloat, int paramInt3, int paramInt4, int paramInt5, Paint paramPaint)
  {
    paramCharSequence = getDrawable();
    if (paramCharSequence == null) {
      return;
    }
    if ((paramCharSequence instanceof URLDrawable))
    {
      paramPaint = (URLDrawable)paramCharSequence;
      Object localObject;
      if (paramPaint.getStatus() == 1)
      {
        int i = paramCharSequence.getIntrinsicWidth();
        int j = paramCharSequence.getIntrinsicHeight();
        paramInt4 = this.d;
        paramInt2 = i;
        paramInt1 = j;
        if (j > paramInt4)
        {
          paramInt2 = i;
          paramInt1 = j;
          if (paramInt4 > 0)
          {
            paramInt2 = i * paramInt4 / j;
            paramInt1 = paramInt4;
          }
        }
        localObject = this.b;
        if (paramInt2 > 0) {
          paramInt4 = paramInt2;
        } else {
          paramInt4 = 0;
        }
        if (paramInt1 > 0) {
          i = paramInt1;
        } else {
          i = 0;
        }
        ((URLDrawable)localObject).setBounds(0, 0, paramInt4, i);
      }
      else
      {
        paramInt2 = 0;
        paramInt1 = 0;
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("draw status:");
        ((StringBuilder)localObject).append(paramPaint.getStatus());
        ((StringBuilder)localObject).append(" width:");
        ((StringBuilder)localObject).append(paramInt2);
        ((StringBuilder)localObject).append(" height:");
        ((StringBuilder)localObject).append(paramInt1);
        QLog.i("UrlBottomImageSpan", 2, ((StringBuilder)localObject).toString());
      }
    }
    paramCanvas.save();
    paramCanvas.translate(paramFloat, (paramInt5 - paramInt3 - paramCharSequence.getBounds().bottom) / 2 + paramInt3);
    paramCharSequence.draw(paramCanvas);
    paramCanvas.restore();
  }
  
  public Drawable getDrawable()
  {
    Object localObject1 = this.b;
    if (localObject1 != null) {
      return localObject1;
    }
    if (this.c != null)
    {
      Object localObject2 = URLDrawable.URLDrawableOptions.obtain();
      localObject1 = null;
      try
      {
        this.b = URLDrawable.getDrawable(this.c, (URLDrawable.URLDrawableOptions)localObject2);
        localObject2 = this.e;
        if (localObject2 != null) {
          localObject1 = (Drawable.Callback)((WeakReference)localObject2).get();
        }
        if (localObject1 != null) {
          this.b.setCallback((Drawable.Callback)localObject1);
        }
        this.b.setURLDrawableListener(new UrlBottomImageSpan.1(this));
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("getDrawable. first get url:");
          ((StringBuilder)localObject2).append(this.c);
          ((StringBuilder)localObject2).append("  cb:");
          boolean bool;
          if (localObject1 != null) {
            bool = true;
          } else {
            bool = false;
          }
          ((StringBuilder)localObject2).append(bool);
          QLog.i("UrlBottomImageSpan", 2, ((StringBuilder)localObject2).toString());
        }
        return this.b;
      }
      catch (Throwable localThrowable)
      {
        this.b = null;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("getDrawable error: ");
        ((StringBuilder)localObject2).append(localThrowable.getMessage());
        QLog.e("UrlBottomImageSpan", 2, ((StringBuilder)localObject2).toString());
        return super.getDrawable();
      }
    }
    return super.getDrawable();
  }
  
  public int getSize(Paint paramPaint, CharSequence paramCharSequence, int paramInt1, int paramInt2, Paint.FontMetricsInt paramFontMetricsInt)
  {
    paramCharSequence = getDrawable();
    paramInt2 = 0;
    if (paramCharSequence == null) {
      return 0;
    }
    int j;
    int k;
    int i;
    if (((paramCharSequence instanceof URLDrawable)) && (((URLDrawable)paramCharSequence).getStatus() == 1))
    {
      j = paramCharSequence.getIntrinsicWidth();
      k = paramCharSequence.getIntrinsicHeight();
      i = this.d;
      paramInt1 = k;
      paramInt2 = j;
      if (k > i)
      {
        paramInt1 = k;
        paramInt2 = j;
        if (i > 0)
        {
          paramInt2 = j * i / k;
          paramInt1 = i;
        }
      }
      URLDrawable localURLDrawable = this.b;
      if (paramInt2 > 0) {
        i = paramInt2;
      } else {
        i = 0;
      }
      if (paramInt1 > 0) {
        j = paramInt1;
      } else {
        j = 0;
      }
      localURLDrawable.setBounds(0, 0, i, j);
    }
    else
    {
      paramInt1 = 0;
    }
    paramCharSequence = paramCharSequence.getBounds();
    if (paramFontMetricsInt != null)
    {
      paramPaint = paramPaint.getFontMetricsInt();
      j = paramPaint.bottom;
      k = paramPaint.top;
      i = (paramCharSequence.bottom - paramCharSequence.top) / 2;
      k = (j - k) / 4;
      j = i - k;
      i = -(i + k);
      paramFontMetricsInt.ascent = i;
      paramFontMetricsInt.top = i;
      paramFontMetricsInt.bottom = j;
      paramFontMetricsInt.descent = j;
    }
    if (QLog.isColorLevel())
    {
      paramPaint = new StringBuilder();
      paramPaint.append("getSize size:");
      paramPaint.append(paramCharSequence.right);
      paramPaint.append(" width:");
      paramPaint.append(paramInt2);
      paramPaint.append(" height:");
      paramPaint.append(paramInt1);
      paramPaint.append(" imageUrl:");
      paramPaint.append(this.c);
      QLog.i("UrlBottomImageSpan", 2, paramPaint.toString());
    }
    return paramCharSequence.right;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mutualmark.UrlBottomImageSpan
 * JD-Core Version:    0.7.0.1
 */