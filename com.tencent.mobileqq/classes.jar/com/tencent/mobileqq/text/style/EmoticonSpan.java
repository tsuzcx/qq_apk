package com.tencent.mobileqq.text.style;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.style.ReplacementSpan;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.qqemoticon.api.ISysEmoApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class EmoticonSpan
  extends ReplacementSpan
{
  public static final int ANIMATION_MASK = -2147483648;
  public float eBottom;
  public float eLeft;
  public float eRight;
  public float eTop;
  public int emojiType;
  public int index;
  private WeakReference<Drawable> mDrawableRef;
  protected volatile boolean mIsAPNG;
  int size;
  
  public EmoticonSpan(int paramInt1, int paramInt2, int paramInt3)
  {
    this.index = paramInt1;
    this.size = paramInt2;
    this.emojiType = paramInt3;
  }
  
  protected Drawable doGetDrwable()
  {
    Drawable localDrawable;
    if (this.emojiType == 0)
    {
      localDrawable = ((ISysEmoApi)QRoute.api(ISysEmoApi.class)).getEmojiDrawable(this.index);
      if (localDrawable != null)
      {
        i = this.size;
        localDrawable.setBounds(0, 0, i, i);
      }
      return localDrawable;
    }
    int i = this.index;
    if ((0x80000000 & i) == 0)
    {
      localDrawable = ((ISysEmoApi)QRoute.api(ISysEmoApi.class)).getSysFaceDrawable(this.index, false);
      if (localDrawable != null)
      {
        i = this.size;
        localDrawable.setBounds(0, 0, i, i);
      }
      return localDrawable;
    }
    i = 0x7FFFFFFF & i;
    if (((ISysEmoApi)QRoute.api(ISysEmoApi.class)).isSysFaceValid(i))
    {
      if (((ISysEmoApi)QRoute.api(ISysEmoApi.class)).isSysFaceStatic(i))
      {
        localDrawable = ((ISysEmoApi)QRoute.api(ISysEmoApi.class)).getSysFaceDrawable(i, false);
        if (localDrawable != null)
        {
          i = this.size;
          localDrawable.setBounds(0, 0, i, i);
        }
        return localDrawable;
      }
      localDrawable = ((ISysEmoApi)QRoute.api(ISysEmoApi.class)).getSysFaceDrawable(i, true);
      if (localDrawable != null)
      {
        i = this.size;
        localDrawable.setBounds(0, 0, i, i);
      }
      return localDrawable;
    }
    return new ColorDrawable();
  }
  
  public void draw(Canvas paramCanvas, CharSequence paramCharSequence, int paramInt1, int paramInt2, float paramFloat, int paramInt3, int paramInt4, int paramInt5, Paint paramPaint)
  {
    paramCharSequence = getDrawable();
    paramCanvas.save();
    float f2 = paramInt4 - this.size;
    float f1 = f2;
    if (paramInt5 > paramInt4)
    {
      f1 = f2;
      if (paramPaint != null) {
        f1 = f2 + paramPaint.getFontMetrics().descent;
      }
    }
    paramCanvas.translate(paramFloat, f1);
    if (paramCharSequence != null)
    {
      paramCharSequence.draw(paramCanvas);
      this.eLeft = paramFloat;
      this.eTop = paramInt3;
      this.eRight = (this.eLeft + this.size);
      this.eBottom = paramInt5;
    }
    paramCanvas.restore();
  }
  
  public String getDescription()
  {
    return "";
  }
  
  public Drawable getDrawable()
  {
    Object localObject1 = this.mDrawableRef;
    if (localObject1 != null) {
      localObject2 = (Drawable)((WeakReference)localObject1).get();
    } else {
      localObject2 = null;
    }
    localObject1 = localObject2;
    if ((localObject2 instanceof URLDrawable))
    {
      URLDrawable localURLDrawable = (URLDrawable)localObject2;
      localObject1 = localObject2;
      if (this.mIsAPNG)
      {
        localObject1 = localObject2;
        if (!localURLDrawable.mUseApngImage)
        {
          if (QLog.isColorLevel()) {
            QLog.d("QQText", 2, "getDrawable: change to apng");
          }
          localObject1 = null;
        }
      }
    }
    Object localObject2 = localObject1;
    if (localObject1 == null)
    {
      localObject2 = doGetDrwable();
      this.mDrawableRef = new WeakReference(localObject2);
    }
    return localObject2;
  }
  
  public int getIndex()
  {
    return this.index & 0x7FFFFFFF;
  }
  
  public int getSize(Paint paramPaint, CharSequence paramCharSequence, int paramInt1, int paramInt2, Paint.FontMetricsInt paramFontMetricsInt)
  {
    if (paramFontMetricsInt != null)
    {
      paramFontMetricsInt.ascent = (-this.size);
      paramFontMetricsInt.descent = 0;
      paramFontMetricsInt.top = paramFontMetricsInt.ascent;
      paramFontMetricsInt.bottom = 0;
    }
    return this.size;
  }
  
  public void setSize(int paramInt)
  {
    this.size = paramInt;
    Drawable localDrawable = getDrawable();
    if (localDrawable != null) {
      localDrawable.setBounds(0, 0, paramInt, paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.text.style.EmoticonSpan
 * JD-Core Version:    0.7.0.1
 */