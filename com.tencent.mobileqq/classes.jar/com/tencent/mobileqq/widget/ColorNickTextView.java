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
import com.tencent.mobileqq.vas.troopnick.TroopNickNameHelper;
import com.tencent.mobileqq.vas.troopnick.TroopNickResDrawable;
import java.util.ArrayList;
import java.util.Arrays;

public class ColorNickTextView
  extends TextView
  implements MosaicEffect.IMosaicEffect
{
  private int jdField_a_of_type_Int = 0;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private Rect jdField_a_of_type_AndroidGraphicsRect = new Rect();
  private ColorClearableEditText.SpanComparator jdField_a_of_type_ComTencentMobileqqWidgetColorClearableEditText$SpanComparator = new ColorClearableEditText.SpanComparator();
  private MosaicEffect jdField_a_of_type_ComTencentMobileqqWidgetMosaicEffect;
  private CharSequence jdField_a_of_type_JavaLangCharSequence;
  private ArrayList<ColorClearableEditText.Paragraph> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  public boolean a;
  private float[] jdField_a_of_type_ArrayOfFloat;
  private int[] jdField_a_of_type_ArrayOfInt;
  private int jdField_b_of_type_Int;
  private Bitmap jdField_b_of_type_AndroidGraphicsBitmap;
  private Rect jdField_b_of_type_AndroidGraphicsRect = new Rect();
  private int jdField_c_of_type_Int;
  private Rect jdField_c_of_type_AndroidGraphicsRect = new Rect();
  
  public ColorNickTextView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ColorNickTextView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ColorNickTextView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_Boolean = false;
    setLayerType(1, null);
  }
  
  private Canvas a(int paramInt1, int paramInt2)
  {
    Object localObject = this.jdField_a_of_type_AndroidGraphicsBitmap;
    if ((localObject == null) || (((Bitmap)localObject).getWidth() != paramInt1) || (this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight() != paramInt2))
    {
      localObject = this.jdField_a_of_type_AndroidGraphicsBitmap;
      if (localObject != null) {
        ((Bitmap)localObject).recycle();
      }
      this.jdField_a_of_type_AndroidGraphicsBitmap = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
    }
    localObject = new Canvas(this.jdField_a_of_type_AndroidGraphicsBitmap);
    ((Canvas)localObject).drawColor(0, PorterDuff.Mode.CLEAR);
    return localObject;
  }
  
  private PointF a()
  {
    PointF localPointF = new PointF();
    Rect localRect = new Rect();
    int i = 0;
    float f = 0.0F;
    while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      Object localObject = (ColorClearableEditText.Paragraph)this.jdField_a_of_type_JavaUtilArrayList.get(i);
      int j = ((ColorClearableEditText.Paragraph)localObject).jdField_c_of_type_Int;
      if (j != 1)
      {
        if (j == 2)
        {
          localObject = (EmoticonSpan)((ColorClearableEditText.Paragraph)localObject).jdField_a_of_type_AndroidTextStyleCharacterStyle;
          localPointF.x += ((EmoticonSpan)localObject).getDrawable().getBounds().width();
          f = Math.max(f, ((EmoticonSpan)localObject).getDrawable().getBounds().height());
        }
      }
      else
      {
        localPointF.x += getPaint().measureText(((ColorClearableEditText.Paragraph)localObject).jdField_a_of_type_JavaLangString);
        getPaint().getTextBounds(((ColorClearableEditText.Paragraph)localObject).jdField_a_of_type_JavaLangString, 0, ((ColorClearableEditText.Paragraph)localObject).jdField_a_of_type_JavaLangString.length(), localRect);
        f = Math.max(f, localRect.height());
      }
      i += 1;
    }
    localPointF.y = f;
    return localPointF;
  }
  
  private void a(Canvas paramCanvas)
  {
    if (this.jdField_a_of_type_Int != 0)
    {
      a();
      if (this.jdField_a_of_type_JavaUtilArrayList.size() == 0)
      {
        getPaint().setShader(null);
        super.onDraw(paramCanvas);
        return;
      }
      Object localObject1 = a();
      float f3 = ((PointF)localObject1).x;
      float f6 = ((PointF)localObject1).y;
      float f1 = 0.0F;
      if ((f3 > 0.0F) && (f6 > 0.0F))
      {
        getPaint().setColor(-16777216);
        int i = this.jdField_a_of_type_Int;
        float f2;
        float f4;
        if (i != 1)
        {
          int k;
          int m;
          Object localObject2;
          int j;
          ColorClearableEditText.Paragraph localParagraph;
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
                  if (this.jdField_b_of_type_AndroidGraphicsBitmap != null)
                  {
                    i = (int)f3;
                    k = (int)f6;
                    localObject1 = a(i, k);
                    m = this.jdField_b_of_type_AndroidGraphicsBitmap.getWidth();
                    for (i = 0; i < f3; i = j)
                    {
                      localObject2 = this.jdField_c_of_type_AndroidGraphicsRect;
                      j = i + m;
                      ((Rect)localObject2).set(i, 0, j, k);
                      ((Canvas)localObject1).drawBitmap(this.jdField_b_of_type_AndroidGraphicsBitmap, this.jdField_b_of_type_AndroidGraphicsRect, this.jdField_c_of_type_AndroidGraphicsRect, getPaint());
                    }
                    localObject1 = new BitmapShader(this.jdField_a_of_type_AndroidGraphicsBitmap, Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
                    getPaint().setShader((Shader)localObject1);
                  }
                }
              }
              else
              {
                getPaint().setShader(null);
                localObject1 = a((int)f3, (int)f6);
                localObject2 = new Paint(getPaint());
                i = 0;
                j = 0;
                while (j < this.jdField_a_of_type_JavaUtilArrayList.size())
                {
                  localParagraph = (ColorClearableEditText.Paragraph)this.jdField_a_of_type_JavaUtilArrayList.get(j);
                  k = localParagraph.jdField_c_of_type_Int;
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
                      localObject3 = this.jdField_a_of_type_ArrayOfInt;
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
                localObject1 = new BitmapShader(this.jdField_a_of_type_AndroidGraphicsBitmap, Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
                getPaint().setShader((Shader)localObject1);
              }
            }
            else
            {
              f1 = f3 / 2.0F;
              localObject1 = new RadialGradient(f1, f6 / 2.0F, f1, this.jdField_a_of_type_ArrayOfInt, this.jdField_a_of_type_ArrayOfFloat, Shader.TileMode.CLAMP);
              getPaint().setShader((Shader)localObject1);
            }
          }
          else
          {
            getPaint().setShader(null);
            localObject1 = a((int)f3, (int)f6);
            localObject2 = new Paint(getPaint());
            i = 0;
            f1 = 0.0F;
            k = 0;
            while (k < this.jdField_a_of_type_JavaUtilArrayList.size())
            {
              localParagraph = (ColorClearableEditText.Paragraph)this.jdField_a_of_type_JavaUtilArrayList.get(k);
              j = localParagraph.jdField_c_of_type_Int;
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
                  getPaint().getTextBounds(localParagraph.jdField_a_of_type_JavaLangString, 0, localParagraph.jdField_a_of_type_JavaLangString.length(), this.jdField_a_of_type_AndroidGraphicsRect);
                  j = this.jdField_a_of_type_AndroidGraphicsRect.height();
                }
                i = j;
                for (j = 0; j < localParagraph.jdField_a_of_type_JavaLangString.length(); j = m)
                {
                  localObject3 = getPaint();
                  str = localParagraph.jdField_a_of_type_JavaLangString;
                  m = j + 1;
                  float f7 = ((TextPaint)localObject3).measureText(str, j, m);
                  if (this.jdField_b_of_type_Int == 1) {
                    f2 = f1;
                  } else {
                    f2 = f7 * 0.5F + f1;
                  }
                  if (this.jdField_b_of_type_Int == 1)
                  {
                    f3 = i;
                    f3 = f3 * 0.5F + f6 - f3;
                  }
                  else
                  {
                    f3 = f6 - i;
                  }
                  if (this.jdField_b_of_type_Int == 1) {
                    f4 = f1 + f7;
                  } else {
                    f4 = f7 * 0.5F + f1;
                  }
                  float f5;
                  if (this.jdField_b_of_type_Int == 1)
                  {
                    f5 = i;
                    f5 = f5 * 0.5F + f6 - f5;
                  }
                  else
                  {
                    f5 = i;
                  }
                  ((Paint)localObject2).setShader(new LinearGradient(f2, f3, f4, f5, this.jdField_a_of_type_ArrayOfInt, this.jdField_a_of_type_ArrayOfFloat, Shader.TileMode.CLAMP));
                  ((Paint)localObject2).setStyle(Paint.Style.FILL);
                  f3 = i;
                  f2 = f1 + f7;
                  ((Canvas)localObject1).drawRect(f1, f6 - f3, f2, f6, (Paint)localObject2);
                  f1 = f2;
                }
              }
              k += 1;
            }
            localObject1 = new BitmapShader(this.jdField_a_of_type_AndroidGraphicsBitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
            getPaint().setShader((Shader)localObject1);
          }
        }
        else
        {
          getPaint().setShader(null);
          if (this.jdField_b_of_type_Int == 1) {
            f1 = 0.0F;
          } else {
            f1 = f3 * 0.5F;
          }
          if (this.jdField_b_of_type_Int == 1) {
            f2 = f6 * 0.5F;
          } else {
            f2 = 0.0F;
          }
          if (this.jdField_b_of_type_Int != 1) {
            f3 *= 0.5F;
          }
          f4 = f6;
          if (this.jdField_b_of_type_Int == 1) {
            f4 = f6 * 0.5F;
          }
          localObject1 = new LinearGradient(f1, f2, f3, f4, this.jdField_a_of_type_ArrayOfInt, this.jdField_a_of_type_ArrayOfFloat, Shader.TileMode.CLAMP);
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
  
  public int a()
  {
    return this.jdField_c_of_type_Int;
  }
  
  public void a()
  {
    Object localObject1 = getText();
    if ((localObject1 instanceof Spanned)) {
      localObject1 = (Spanned)localObject1;
    } else {
      localObject1 = null;
    }
    if (localObject1 != null)
    {
      this.jdField_a_of_type_JavaLangCharSequence = getText();
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      int j = getText().length();
      int i = 0;
      CharacterStyle[] arrayOfCharacterStyle = (CharacterStyle[])((Spanned)localObject1).getSpans(0, j, CharacterStyle.class);
      if (arrayOfCharacterStyle.length == 0)
      {
        localObject1 = new ColorClearableEditText.Paragraph(1, 0, this.jdField_a_of_type_JavaLangCharSequence.length(), this.jdField_a_of_type_JavaLangCharSequence.toString(), null);
        this.jdField_a_of_type_JavaUtilArrayList.add(localObject1);
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetColorClearableEditText$SpanComparator.a((Spanned)localObject1);
      Arrays.sort(arrayOfCharacterStyle, this.jdField_a_of_type_ComTencentMobileqqWidgetColorClearableEditText$SpanComparator);
      int k;
      for (j = 0; i < arrayOfCharacterStyle.length; j = k)
      {
        int m = ((Spanned)localObject1).getSpanStart(arrayOfCharacterStyle[i]);
        k = ((Spanned)localObject1).getSpanEnd(arrayOfCharacterStyle[i]);
        if (m > j)
        {
          localObject2 = new ColorClearableEditText.Paragraph(1, j, m, getText().subSequence(j, m).toString(), null);
          this.jdField_a_of_type_JavaUtilArrayList.add(localObject2);
        }
        Object localObject2 = getText().subSequence(m, k).toString();
        if ((arrayOfCharacterStyle[i] instanceof EmoticonSpan)) {
          j = 2;
        } else {
          j = 3;
        }
        localObject2 = new ColorClearableEditText.Paragraph(j, m, k, (String)localObject2, arrayOfCharacterStyle[i]);
        this.jdField_a_of_type_JavaUtilArrayList.add(localObject2);
        if ((i == arrayOfCharacterStyle.length - 1) && (k < getText().length()))
        {
          localObject2 = getText().subSequence(k, getText().length()).toString();
          localObject2 = new ColorClearableEditText.Paragraph(1, k, getText().length(), (String)localObject2, null);
          this.jdField_a_of_type_JavaUtilArrayList.add(localObject2);
        }
        i += 1;
      }
    }
  }
  
  public void b()
  {
    Drawable localDrawable = getBackground();
    if ((localDrawable instanceof TroopNickResDrawable))
    {
      a();
      ((TroopNickResDrawable)localDrawable).a(a());
    }
  }
  
  public void draw(Canvas paramCanvas)
  {
    MosaicEffect localMosaicEffect = this.jdField_a_of_type_ComTencentMobileqqWidgetMosaicEffect;
    if (localMosaicEffect != null)
    {
      localMosaicEffect.a(paramCanvas);
      return;
    }
    super.draw(paramCanvas);
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    Object localObject = getBackground();
    if ((localObject instanceof TroopNickResDrawable))
    {
      localObject = (TroopNickResDrawable)localObject;
      ((TroopNickResDrawable)localObject).a(null);
      ((TroopNickResDrawable)localObject).a();
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    MosaicEffect localMosaicEffect = this.jdField_a_of_type_ComTencentMobileqqWidgetMosaicEffect;
    if (localMosaicEffect != null)
    {
      localMosaicEffect.b(paramCanvas);
      return;
    }
    a(paramCanvas);
  }
  
  public void setCustomCloth(int paramInt)
  {
    this.jdField_c_of_type_Int = paramInt;
    Object localObject = getBackground();
    if ((localObject instanceof TroopNickResDrawable))
    {
      localObject = (TroopNickResDrawable)localObject;
      ((TroopNickResDrawable)localObject).a(a());
      ((TroopNickResDrawable)localObject).a(paramInt);
      return;
    }
    TroopNickNameHelper.a(this, getContext(), paramInt, true);
  }
  
  public void setMosaicEffect(MosaicEffect paramMosaicEffect)
  {
    MosaicEffect localMosaicEffect = this.jdField_a_of_type_ComTencentMobileqqWidgetMosaicEffect;
    if (localMosaicEffect != null) {
      localMosaicEffect.a(null);
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetMosaicEffect = paramMosaicEffect;
    paramMosaicEffect = this.jdField_a_of_type_ComTencentMobileqqWidgetMosaicEffect;
    if (paramMosaicEffect != null) {
      paramMosaicEffect.a(this);
    }
    invalidate();
  }
  
  public void setSpecialColor(int paramInt1, int[] paramArrayOfInt, float[] paramArrayOfFloat, int paramInt2, Bitmap paramBitmap)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    if (paramArrayOfInt != null) {
      this.jdField_a_of_type_ArrayOfInt = Arrays.copyOf(paramArrayOfInt, paramArrayOfInt.length);
    }
    if (paramArrayOfFloat != null) {
      this.jdField_a_of_type_ArrayOfFloat = Arrays.copyOf(paramArrayOfFloat, paramArrayOfFloat.length);
    }
    this.jdField_b_of_type_AndroidGraphicsBitmap = paramBitmap;
    paramArrayOfInt = this.jdField_b_of_type_AndroidGraphicsBitmap;
    if (paramArrayOfInt != null) {
      this.jdField_b_of_type_AndroidGraphicsRect.set(0, 0, paramArrayOfInt.getWidth(), this.jdField_b_of_type_AndroidGraphicsBitmap.getHeight());
    }
    invalidate();
  }
  
  public void setText(CharSequence paramCharSequence, TextView.BufferType paramBufferType)
  {
    super.setText(paramCharSequence, paramBufferType);
    b();
  }
  
  public void superDrawMosaic(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
  }
  
  public void superOnDrawMosaic(Canvas paramCanvas)
  {
    a(paramCanvas);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.ColorNickTextView
 * JD-Core Version:    0.7.0.1
 */