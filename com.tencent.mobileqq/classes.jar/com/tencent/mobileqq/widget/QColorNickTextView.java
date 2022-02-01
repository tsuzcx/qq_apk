package com.tencent.mobileqq.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.PointF;
import android.graphics.PorterDuff.Mode;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.style.CharacterStyle;
import android.util.AttributeSet;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.tencent.mobileqq.text.style.EmoticonSpan;
import java.util.ArrayList;
import java.util.Arrays;

public class QColorNickTextView
  extends TextView
  implements MosaicEffect.IMosaicEffect
{
  private int mColorNickId;
  private int mColorType = 0;
  private int[] mColors;
  private MosaicEffect mMosaicEffect;
  private int mOrientation;
  private ArrayList<QColorClearableEditText.Paragraph> mParagraphs = new ArrayList();
  private float[] mPositions;
  private Bitmap mShaderBitmap;
  private QColorClearableEditText.SpanComparator mSpanComparator = new QColorClearableEditText.SpanComparator();
  private CharSequence mSplitedText;
  private Rect mTextBound = new Rect();
  private Bitmap mTexture;
  private Rect mTextureDstRect = new Rect();
  private Rect mTextureRect = new Rect();
  public boolean needRefreshSpecialColor = false;
  
  public QColorNickTextView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public QColorNickTextView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public QColorNickTextView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setLayerType(1, null);
  }
  
  private Canvas getShaderCanvas(int paramInt1, int paramInt2)
  {
    Object localObject = this.mShaderBitmap;
    if ((localObject == null) || (((Bitmap)localObject).getWidth() != paramInt1) || (this.mShaderBitmap.getHeight() != paramInt2))
    {
      localObject = this.mShaderBitmap;
      if (localObject != null) {
        ((Bitmap)localObject).recycle();
      }
      this.mShaderBitmap = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
    }
    localObject = new Canvas(this.mShaderBitmap);
    ((Canvas)localObject).drawColor(0, PorterDuff.Mode.CLEAR);
    return localObject;
  }
  
  private void onDrawInner(Canvas paramCanvas)
  {
    if (this.mColorType != 0)
    {
      splitParagraph();
      if (this.mParagraphs.size() == 0)
      {
        getPaint().setShader(null);
        super.onDraw(paramCanvas);
        return;
      }
      Object localObject1 = getContentSize();
      float f3 = ((PointF)localObject1).x;
      float f6 = ((PointF)localObject1).y;
      float f1 = 0.0F;
      if ((f3 > 0.0F) && (f6 > 0.0F))
      {
        getPaint().setColor(-16777216);
        int i = this.mColorType;
        float f2;
        float f4;
        if (i != 1)
        {
          int k;
          int m;
          Object localObject2;
          int j;
          QColorClearableEditText.Paragraph localParagraph;
          Object localObject3;
          String str;
          if (i != 2)
          {
            if (i != 3)
            {
              if (i != 4)
              {
                if (i == 5)
                {
                  getPaint().setShader(null);
                  if (this.mTexture != null)
                  {
                    i = (int)f3;
                    k = (int)f6;
                    localObject1 = getShaderCanvas(i, k);
                    m = this.mTexture.getWidth();
                    for (i = 0; i < f3; i = j)
                    {
                      localObject2 = this.mTextureDstRect;
                      j = i + m;
                      ((Rect)localObject2).set(i, 0, j, k);
                      ((Canvas)localObject1).drawBitmap(this.mTexture, this.mTextureRect, this.mTextureDstRect, getPaint());
                    }
                    localObject1 = new BitmapShader(this.mShaderBitmap, Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
                    getPaint().setShader((Shader)localObject1);
                  }
                }
              }
              else
              {
                getPaint().setShader(null);
                localObject1 = getShaderCanvas((int)f3, (int)f6);
                localObject2 = new Paint(getPaint());
                i = 0;
                j = 0;
                while (j < this.mParagraphs.size())
                {
                  localParagraph = (QColorClearableEditText.Paragraph)this.mParagraphs.get(j);
                  k = localParagraph.c;
                  if (k != 1)
                  {
                    if (k == 2) {
                      f1 += ((EmoticonSpan)localParagraph.jdField_a_of_type_AndroidTextStyleCharacterStyle).getDrawable().getBounds().width();
                    }
                  }
                  else {
                    for (k = 0; k < localParagraph.jdField_a_of_type_JavaLangString.length(); k = m)
                    {
                      localObject3 = getPaint();
                      str = localParagraph.jdField_a_of_type_JavaLangString;
                      m = k + 1;
                      f2 = ((TextPaint)localObject3).measureText(str, k, m);
                      localObject3 = this.mColors;
                      ((Paint)localObject2).setColor(localObject3[(i % localObject3.length)]);
                      ((Paint)localObject2).setStyle(Paint.Style.FILL);
                      f2 = f1 + f2;
                      ((Canvas)localObject1).drawRect(f1, 0.0F, f2, f6, (Paint)localObject2);
                      i += 1;
                      f1 = f2;
                    }
                  }
                  j += 1;
                }
                localObject1 = new BitmapShader(this.mShaderBitmap, Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
                getPaint().setShader((Shader)localObject1);
              }
            }
            else
            {
              f1 = f3 / 2.0F;
              localObject1 = new RadialGradient(f1, f6 / 2.0F, f1, this.mColors, this.mPositions, Shader.TileMode.CLAMP);
              getPaint().setShader((Shader)localObject1);
            }
          }
          else
          {
            getPaint().setShader(null);
            localObject1 = getShaderCanvas((int)f3, (int)f6);
            localObject2 = new Paint(getPaint());
            i = 0;
            f1 = 0.0F;
            k = 0;
            while (k < this.mParagraphs.size())
            {
              localParagraph = (QColorClearableEditText.Paragraph)this.mParagraphs.get(k);
              j = localParagraph.c;
              if (j != 1)
              {
                if (j == 2) {
                  f1 += ((EmoticonSpan)localParagraph.jdField_a_of_type_AndroidTextStyleCharacterStyle).getDrawable().getBounds().width();
                }
              }
              else
              {
                j = i;
                if (i == 0)
                {
                  getPaint().getTextBounds(localParagraph.jdField_a_of_type_JavaLangString, 0, localParagraph.jdField_a_of_type_JavaLangString.length(), this.mTextBound);
                  j = this.mTextBound.height();
                }
                i = j;
                for (j = 0; j < localParagraph.jdField_a_of_type_JavaLangString.length(); j = m)
                {
                  localObject3 = getPaint();
                  str = localParagraph.jdField_a_of_type_JavaLangString;
                  m = j + 1;
                  float f7 = ((TextPaint)localObject3).measureText(str, j, m);
                  if (this.mOrientation == 1) {
                    f2 = f1;
                  } else {
                    f2 = f7 * 0.5F + f1;
                  }
                  if (this.mOrientation == 1)
                  {
                    f3 = i;
                    f3 = f3 * 0.5F + f6 - f3;
                  }
                  else
                  {
                    f3 = f6 - i;
                  }
                  if (this.mOrientation == 1) {
                    f4 = f1 + f7;
                  } else {
                    f4 = f7 * 0.5F + f1;
                  }
                  float f5;
                  if (this.mOrientation == 1)
                  {
                    f5 = i;
                    f5 = f5 * 0.5F + f6 - f5;
                  }
                  else
                  {
                    f5 = i;
                  }
                  ((Paint)localObject2).setShader(new LinearGradient(f2, f3, f4, f5, this.mColors, this.mPositions, Shader.TileMode.CLAMP));
                  ((Paint)localObject2).setStyle(Paint.Style.FILL);
                  f3 = i;
                  f2 = f1 + f7;
                  ((Canvas)localObject1).drawRect(f1, f6 - f3, f2, f6, (Paint)localObject2);
                  f1 = f2;
                }
              }
              k += 1;
            }
            localObject1 = new BitmapShader(this.mShaderBitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
            getPaint().setShader((Shader)localObject1);
          }
        }
        else
        {
          getPaint().setShader(null);
          if (this.mOrientation == 1) {
            f1 = 0.0F;
          } else {
            f1 = f3 * 0.5F;
          }
          if (this.mOrientation == 1) {
            f2 = f6 * 0.5F;
          } else {
            f2 = 0.0F;
          }
          if (this.mOrientation != 1) {
            f3 *= 0.5F;
          }
          f4 = f6;
          if (this.mOrientation == 1) {
            f4 = f6 * 0.5F;
          }
          localObject1 = new LinearGradient(f1, f2, f3, f4, this.mColors, this.mPositions, Shader.TileMode.CLAMP);
          getPaint().setShader((Shader)localObject1);
        }
      }
    }
    else
    {
      getPaint().setShader(null);
    }
    super.onDraw(paramCanvas);
  }
  
  public void draw(Canvas paramCanvas)
  {
    MosaicEffect localMosaicEffect = this.mMosaicEffect;
    if (localMosaicEffect != null)
    {
      localMosaicEffect.a(paramCanvas);
      return;
    }
    super.draw(paramCanvas);
  }
  
  public int getColorNickId()
  {
    return this.mColorNickId;
  }
  
  public PointF getContentSize()
  {
    PointF localPointF = new PointF();
    Rect localRect = new Rect();
    int i = 0;
    float f = 0.0F;
    while (i < this.mParagraphs.size())
    {
      Object localObject = (QColorClearableEditText.Paragraph)this.mParagraphs.get(i);
      int j = ((QColorClearableEditText.Paragraph)localObject).c;
      if (j != 1)
      {
        if (j == 2)
        {
          localObject = (EmoticonSpan)((QColorClearableEditText.Paragraph)localObject).jdField_a_of_type_AndroidTextStyleCharacterStyle;
          localPointF.x += ((EmoticonSpan)localObject).getDrawable().getBounds().width();
          f = Math.max(f, ((EmoticonSpan)localObject).getDrawable().getBounds().height());
        }
      }
      else
      {
        localPointF.x += getPaint().measureText(((QColorClearableEditText.Paragraph)localObject).jdField_a_of_type_JavaLangString);
        getPaint().getTextBounds(((QColorClearableEditText.Paragraph)localObject).jdField_a_of_type_JavaLangString, 0, ((QColorClearableEditText.Paragraph)localObject).jdField_a_of_type_JavaLangString.length(), localRect);
        f = Math.max(f, localRect.height());
      }
      i += 1;
    }
    localPointF.y = f;
    return localPointF;
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    MosaicEffect localMosaicEffect = this.mMosaicEffect;
    if (localMosaicEffect != null)
    {
      localMosaicEffect.b(paramCanvas);
      return;
    }
    onDrawInner(paramCanvas);
  }
  
  public void setCustomCloth(int paramInt)
  {
    this.mColorNickId = paramInt;
  }
  
  public void setMosaicEffect(MosaicEffect paramMosaicEffect)
  {
    MosaicEffect localMosaicEffect = this.mMosaicEffect;
    if (localMosaicEffect != null) {
      localMosaicEffect.a(null);
    }
    this.mMosaicEffect = paramMosaicEffect;
    paramMosaicEffect = this.mMosaicEffect;
    if (paramMosaicEffect != null) {
      paramMosaicEffect.a(this);
    }
    invalidate();
  }
  
  public void setSpecialColor(int paramInt1, int[] paramArrayOfInt, float[] paramArrayOfFloat, int paramInt2, Bitmap paramBitmap)
  {
    this.mColorType = paramInt1;
    this.mOrientation = paramInt2;
    if (paramArrayOfInt != null) {
      this.mColors = Arrays.copyOf(paramArrayOfInt, paramArrayOfInt.length);
    }
    if (paramArrayOfFloat != null) {
      this.mPositions = Arrays.copyOf(paramArrayOfFloat, paramArrayOfFloat.length);
    }
    this.mTexture = paramBitmap;
    paramArrayOfInt = this.mTexture;
    if (paramArrayOfInt != null) {
      this.mTextureRect.set(0, 0, paramArrayOfInt.getWidth(), this.mTexture.getHeight());
    }
    invalidate();
  }
  
  public void setText(CharSequence paramCharSequence, TextView.BufferType paramBufferType)
  {
    super.setText(paramCharSequence, paramBufferType);
    updateDrawablePadding();
  }
  
  public void splitParagraph()
  {
    Object localObject1 = getText();
    if ((localObject1 instanceof Spanned)) {
      localObject1 = (Spanned)localObject1;
    } else {
      localObject1 = null;
    }
    if (localObject1 != null)
    {
      this.mSplitedText = getText();
      this.mParagraphs.clear();
      int j = getText().length();
      int i = 0;
      CharacterStyle[] arrayOfCharacterStyle = (CharacterStyle[])((Spanned)localObject1).getSpans(0, j, CharacterStyle.class);
      if (arrayOfCharacterStyle.length == 0)
      {
        localObject1 = new QColorClearableEditText.Paragraph(1, 0, this.mSplitedText.length(), this.mSplitedText.toString(), null);
        this.mParagraphs.add(localObject1);
        return;
      }
      this.mSpanComparator.a((Spanned)localObject1);
      Arrays.sort(arrayOfCharacterStyle, this.mSpanComparator);
      int k;
      for (j = 0; i < arrayOfCharacterStyle.length; j = k)
      {
        int m = ((Spanned)localObject1).getSpanStart(arrayOfCharacterStyle[i]);
        k = ((Spanned)localObject1).getSpanEnd(arrayOfCharacterStyle[i]);
        if (m > j)
        {
          localObject2 = new QColorClearableEditText.Paragraph(1, j, m, getText().subSequence(j, m).toString(), null);
          this.mParagraphs.add(localObject2);
        }
        Object localObject2 = getText().subSequence(m, k).toString();
        if ((arrayOfCharacterStyle[i] instanceof EmoticonSpan)) {
          j = 2;
        } else {
          j = 3;
        }
        localObject2 = new QColorClearableEditText.Paragraph(j, m, k, (String)localObject2, arrayOfCharacterStyle[i]);
        this.mParagraphs.add(localObject2);
        if ((i == arrayOfCharacterStyle.length - 1) && (k < getText().length()))
        {
          localObject2 = getText().subSequence(k, getText().length()).toString();
          localObject2 = new QColorClearableEditText.Paragraph(1, k, getText().length(), (String)localObject2, null);
          this.mParagraphs.add(localObject2);
        }
        i += 1;
      }
    }
  }
  
  public void superDrawMosaic(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
  }
  
  public void superOnDrawMosaic(Canvas paramCanvas)
  {
    onDrawInner(paramCanvas);
  }
  
  public void updateDrawablePadding() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.QColorNickTextView
 * JD-Core Version:    0.7.0.1
 */