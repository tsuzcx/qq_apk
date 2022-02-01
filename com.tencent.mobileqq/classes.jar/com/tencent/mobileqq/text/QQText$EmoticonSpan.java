package com.tencent.mobileqq.text;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.style.ReplacementSpan;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.emoticon.QQEmojiUtil;
import com.tencent.mobileqq.emoticon.QQSysFaceUtil;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class QQText$EmoticonSpan
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
  
  public QQText$EmoticonSpan(int paramInt1, int paramInt2, int paramInt3)
  {
    this.index = paramInt1;
    this.size = paramInt2;
    this.emojiType = paramInt3;
  }
  
  protected Drawable doGetDrwable()
  {
    Drawable localDrawable2;
    Drawable localDrawable1;
    if (this.emojiType == 0)
    {
      localDrawable2 = QQEmojiUtil.getEmojiDrawable(this.index);
      localDrawable1 = localDrawable2;
      if (localDrawable2 != null)
      {
        localDrawable2.setBounds(0, 0, this.size, this.size);
        localDrawable1 = localDrawable2;
      }
    }
    do
    {
      int i;
      do
      {
        do
        {
          return localDrawable1;
          if ((0x80000000 & this.index) != 0) {
            break;
          }
          localDrawable2 = TextUtils.getSysEmotcationDrawable(this.index, false);
          localDrawable1 = localDrawable2;
        } while (localDrawable2 == null);
        localDrawable2.setBounds(0, 0, this.size, this.size);
        return localDrawable2;
        i = 0x7FFFFFFF & this.index;
        if (!QQSysFaceUtil.isValidFaceId(i)) {
          break label158;
        }
        if (!QQSysFaceUtil.isStaticFace(i)) {
          break;
        }
        localDrawable2 = TextUtils.getSysEmotcationDrawable(i, false);
        localDrawable1 = localDrawable2;
      } while (localDrawable2 == null);
      localDrawable2.setBounds(0, 0, this.size, this.size);
      return localDrawable2;
      localDrawable2 = TextUtils.getSysEmotcationDrawable(i, true);
      localDrawable1 = localDrawable2;
    } while (localDrawable2 == null);
    localDrawable2.setBounds(0, 0, this.size, this.size);
    return localDrawable2;
    label158:
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
    if (localObject1 != null) {}
    for (localObject1 = (Drawable)((WeakReference)localObject1).get();; localObject1 = null)
    {
      Object localObject2;
      if ((localObject1 instanceof URLDrawable))
      {
        localObject2 = (URLDrawable)localObject1;
        if ((this.mIsAPNG) && (!((URLDrawable)localObject2).mUseApngImage))
        {
          if (QLog.isColorLevel()) {
            QLog.d("QQText", 2, "getDrawable: change to apng");
          }
          localObject1 = null;
        }
      }
      for (;;)
      {
        localObject2 = localObject1;
        if (localObject1 == null)
        {
          localObject2 = doGetDrwable();
          this.mDrawableRef = new WeakReference(localObject2);
        }
        return localObject2;
      }
    }
  }
  
  public int getIndex()
  {
    return 0x7FFFFFFF & this.index;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.text.QQText.EmoticonSpan
 * JD-Core Version:    0.7.0.1
 */