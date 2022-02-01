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
  
  private PointF getContentSize()
  {
    PointF localPointF = new PointF();
    Rect localRect = new Rect();
    int i = 0;
    float f = 0.0F;
    if (i < this.mParagraphs.size())
    {
      Object localObject = (QColorClearableEditText.Paragraph)this.mParagraphs.get(i);
      switch (((QColorClearableEditText.Paragraph)localObject).c)
      {
      }
      for (;;)
      {
        i += 1;
        break;
        localPointF.x += getPaint().measureText(((QColorClearableEditText.Paragraph)localObject).jdField_a_of_type_JavaLangString);
        getPaint().getTextBounds(((QColorClearableEditText.Paragraph)localObject).jdField_a_of_type_JavaLangString, 0, ((QColorClearableEditText.Paragraph)localObject).jdField_a_of_type_JavaLangString.length(), localRect);
        f = Math.max(f, localRect.height());
        continue;
        localObject = (EmoticonSpan)((QColorClearableEditText.Paragraph)localObject).jdField_a_of_type_AndroidTextStyleCharacterStyle;
        localPointF.x += ((EmoticonSpan)localObject).getDrawable().getBounds().width();
        f = Math.max(f, ((EmoticonSpan)localObject).getDrawable().getBounds().height());
      }
    }
    localPointF.y = f;
    return localPointF;
  }
  
  private Canvas getShaderCanvas(int paramInt1, int paramInt2)
  {
    if ((this.mShaderBitmap == null) || (this.mShaderBitmap.getWidth() != paramInt1) || (this.mShaderBitmap.getHeight() != paramInt2))
    {
      if (this.mShaderBitmap != null) {
        this.mShaderBitmap.recycle();
      }
      this.mShaderBitmap = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
    }
    Canvas localCanvas = new Canvas(this.mShaderBitmap);
    localCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
    return localCanvas;
  }
  
  private void onDrawInner(Canvas paramCanvas)
  {
    Object localObject;
    float f3;
    float f6;
    float f1;
    Paint localPaint;
    int i;
    int j;
    QColorClearableEditText.Paragraph localParagraph;
    if (this.mColorType != 0)
    {
      splitParagraph();
      if (this.mParagraphs.size() == 0)
      {
        getPaint().setShader(null);
        super.onDraw(paramCanvas);
        return;
      }
      localObject = getContentSize();
      f3 = ((PointF)localObject).x;
      f6 = ((PointF)localObject).y;
      if ((f3 > 0.0F) && (f6 > 0.0F)) {
        getPaint().setColor(-16777216);
      }
      switch (this.mColorType)
      {
      default: 
        super.onDraw(paramCanvas);
        return;
      case 2: 
        getPaint().setShader(null);
        localObject = getShaderCanvas((int)f3, (int)f6);
        f1 = 0.0F;
        localPaint = new Paint(getPaint());
        i = 0;
        j = 0;
        while (j < this.mParagraphs.size())
        {
          localParagraph = (QColorClearableEditText.Paragraph)this.mParagraphs.get(j);
          switch (localParagraph.c)
          {
          default: 
            j += 1;
            break;
          case 1: 
            label216:
            if (i != 0) {
              break label1116;
            }
            getPaint().getTextBounds(localParagraph.jdField_a_of_type_JavaLangString, 0, localParagraph.jdField_a_of_type_JavaLangString.length(), this.mTextBound);
            i = this.mTextBound.height();
          }
        }
      }
    }
    label310:
    label333:
    label347:
    label1116:
    for (;;)
    {
      int k = 0;
      float f2;
      if (k < localParagraph.jdField_a_of_type_JavaLangString.length())
      {
        float f7 = getPaint().measureText(localParagraph.jdField_a_of_type_JavaLangString, k, k + 1);
        if (this.mOrientation == 1)
        {
          f2 = f1;
          if (this.mOrientation != 1) {
            break label454;
          }
          f3 = i * 0.5F + f6 - i;
          if (this.mOrientation != 1) {
            break label465;
          }
          f4 = f1 + f7;
          if (this.mOrientation != 1) {
            break label477;
          }
        }
        label477:
        for (float f5 = i * 0.5F + f6 - i;; f5 = i)
        {
          localPaint.setShader(new LinearGradient(f2, f3, f4, f5, this.mColors, this.mPositions, Shader.TileMode.CLAMP));
          localPaint.setStyle(Paint.Style.FILL);
          ((Canvas)localObject).drawRect(f1, f6 - i, f1 + f7, f6, localPaint);
          k += 1;
          f1 += f7;
          break;
          f2 = f1 + 0.5F * f7;
          break label310;
          f3 = f6 - i;
          break label333;
          f4 = f1 + 0.5F * f7;
          break label347;
        }
      }
      break label216;
      f1 += ((EmoticonSpan)localParagraph.jdField_a_of_type_AndroidTextStyleCharacterStyle).getDrawable().getBounds().width();
      break label216;
      localObject = new BitmapShader(this.mShaderBitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
      getPaint().setShader((Shader)localObject);
      break;
      localObject = new RadialGradient(f3 / 2.0F, f6 / 2.0F, f3 / 2.0F, this.mColors, this.mPositions, Shader.TileMode.CLAMP);
      getPaint().setShader((Shader)localObject);
      break;
      getPaint().setShader(null);
      if (this.mOrientation == 1)
      {
        f1 = 0.0F;
        label608:
        if (this.mOrientation != 1) {
          break label693;
        }
        f2 = f6 * 0.5F;
        label622:
        if (this.mOrientation != 1) {
          break label698;
        }
        label630:
        if (this.mOrientation != 1) {
          break label708;
        }
      }
      for (float f4 = f6 * 0.5F;; f4 = f6)
      {
        localObject = new LinearGradient(f1, f2, f3, f4, this.mColors, this.mPositions, Shader.TileMode.CLAMP);
        getPaint().setShader((Shader)localObject);
        break;
        f1 = f3 * 0.5F;
        break label608;
        f2 = 0.0F;
        break label622;
        f3 *= 0.5F;
        break label630;
      }
      getPaint().setShader(null);
      localObject = getShaderCanvas((int)f3, (int)f6);
      f1 = 0.0F;
      localPaint = new Paint(getPaint());
      i = 0;
      j = 0;
      if (j < this.mParagraphs.size())
      {
        localParagraph = (QColorClearableEditText.Paragraph)this.mParagraphs.get(j);
        switch (localParagraph.c)
        {
        }
        for (;;)
        {
          j += 1;
          break;
          k = 0;
          while (k < localParagraph.jdField_a_of_type_JavaLangString.length())
          {
            f2 = getPaint().measureText(localParagraph.jdField_a_of_type_JavaLangString, k, k + 1);
            localPaint.setColor(this.mColors[(i % this.mColors.length)]);
            localPaint.setStyle(Paint.Style.FILL);
            ((Canvas)localObject).drawRect(f1, 0.0F, f1 + f2, f6, localPaint);
            k += 1;
            i += 1;
            f1 += f2;
          }
          continue;
          f1 += ((EmoticonSpan)localParagraph.jdField_a_of_type_AndroidTextStyleCharacterStyle).getDrawable().getBounds().width();
        }
      }
      localObject = new BitmapShader(this.mShaderBitmap, Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
      getPaint().setShader((Shader)localObject);
      break;
      getPaint().setShader(null);
      if (this.mTexture == null) {
        break;
      }
      localObject = getShaderCanvas((int)f3, (int)f6);
      j = this.mTexture.getWidth();
      i = 0;
      while (i < f3)
      {
        this.mTextureDstRect.set(i, 0, i + j, (int)f6);
        ((Canvas)localObject).drawBitmap(this.mTexture, this.mTextureRect, this.mTextureDstRect, getPaint());
        i += j;
      }
      localObject = new BitmapShader(this.mShaderBitmap, Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
      getPaint().setShader((Shader)localObject);
      break;
      getPaint().setShader(null);
      break;
    }
  }
  
  public void draw(Canvas paramCanvas)
  {
    if (this.mMosaicEffect != null)
    {
      this.mMosaicEffect.a(paramCanvas);
      return;
    }
    super.draw(paramCanvas);
  }
  
  public int getColorNickId()
  {
    return this.mColorNickId;
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    if (this.mMosaicEffect != null)
    {
      this.mMosaicEffect.b(paramCanvas);
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
    if (this.mMosaicEffect != null) {
      this.mMosaicEffect.a(null);
    }
    this.mMosaicEffect = paramMosaicEffect;
    if (this.mMosaicEffect != null) {
      this.mMosaicEffect.a(this);
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
    if (this.mTexture != null) {
      this.mTextureRect.set(0, 0, this.mTexture.getWidth(), this.mTexture.getHeight());
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
    int j = 0;
    Object localObject1 = getText();
    if ((localObject1 instanceof Spanned)) {}
    for (localObject1 = (Spanned)localObject1;; localObject1 = null)
    {
      CharacterStyle[] arrayOfCharacterStyle;
      if (localObject1 != null)
      {
        this.mSplitedText = getText();
        this.mParagraphs.clear();
        arrayOfCharacterStyle = (CharacterStyle[])((Spanned)localObject1).getSpans(0, getText().length(), CharacterStyle.class);
        if (arrayOfCharacterStyle.length == 0)
        {
          localObject1 = new QColorClearableEditText.Paragraph(1, 0, this.mSplitedText.length(), this.mSplitedText.toString(), null);
          this.mParagraphs.add(localObject1);
        }
      }
      else
      {
        return;
      }
      this.mSpanComparator.a((Spanned)localObject1);
      Arrays.sort(arrayOfCharacterStyle, this.mSpanComparator);
      int i = 0;
      label135:
      int m;
      int k;
      Object localObject2;
      if (i < arrayOfCharacterStyle.length)
      {
        m = ((Spanned)localObject1).getSpanStart(arrayOfCharacterStyle[i]);
        k = ((Spanned)localObject1).getSpanEnd(arrayOfCharacterStyle[i]);
        if (m > j)
        {
          localObject2 = new QColorClearableEditText.Paragraph(1, j, m, getText().subSequence(j, m).toString(), null);
          this.mParagraphs.add(localObject2);
        }
        localObject2 = getText().subSequence(m, k).toString();
        if (!(arrayOfCharacterStyle[i] instanceof EmoticonSpan)) {
          break label364;
        }
      }
      label364:
      for (j = 2;; j = 3)
      {
        localObject2 = new QColorClearableEditText.Paragraph(j, m, k, (String)localObject2, arrayOfCharacterStyle[i]);
        this.mParagraphs.add(localObject2);
        if ((i == arrayOfCharacterStyle.length - 1) && (k < getText().length()))
        {
          localObject2 = getText().subSequence(k, getText().length()).toString();
          localObject2 = new QColorClearableEditText.Paragraph(1, k, getText().length(), (String)localObject2, null);
          this.mParagraphs.add(localObject2);
        }
        i += 1;
        j = k;
        break label135;
        break;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.widget.QColorNickTextView
 * JD-Core Version:    0.7.0.1
 */