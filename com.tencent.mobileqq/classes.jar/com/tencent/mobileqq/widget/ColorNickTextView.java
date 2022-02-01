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
  public boolean a = false;
  private MosaicEffect b;
  private Bitmap c;
  private Rect d = new Rect();
  private int e = 0;
  private int[] f;
  private float[] g;
  private int h;
  private Bitmap i;
  private Rect j = new Rect();
  private Rect k = new Rect();
  private CharSequence l;
  private int m;
  private ArrayList<ColorClearableEditText.Paragraph> n = new ArrayList();
  private ColorClearableEditText.SpanComparator o = new ColorClearableEditText.SpanComparator();
  
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
    setLayerType(1, null);
  }
  
  private Canvas a(int paramInt1, int paramInt2)
  {
    Object localObject = this.c;
    if ((localObject == null) || (((Bitmap)localObject).getWidth() != paramInt1) || (this.c.getHeight() != paramInt2))
    {
      localObject = this.c;
      if (localObject != null) {
        ((Bitmap)localObject).recycle();
      }
      this.c = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
    }
    localObject = new Canvas(this.c);
    ((Canvas)localObject).drawColor(0, PorterDuff.Mode.CLEAR);
    return localObject;
  }
  
  private void a(Canvas paramCanvas)
  {
    if (this.e != 0)
    {
      a();
      if (this.n.size() == 0)
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
        int i1 = this.e;
        float f2;
        float f4;
        if (i1 != 1)
        {
          int i3;
          int i4;
          Object localObject2;
          int i2;
          ColorClearableEditText.Paragraph localParagraph;
          Object localObject3;
          String str;
          if (i1 != 2)
          {
            if (i1 != 3)
            {
              if (i1 != 4)
              {
                if (i1 == 5)
                {
                  getPaint().setShader(null);
                  if (this.i != null)
                  {
                    i1 = (int)f3;
                    i3 = (int)f6;
                    localObject1 = a(i1, i3);
                    i4 = this.i.getWidth();
                    for (i1 = 0; i1 < f3; i1 = i2)
                    {
                      localObject2 = this.k;
                      i2 = i1 + i4;
                      ((Rect)localObject2).set(i1, 0, i2, i3);
                      ((Canvas)localObject1).drawBitmap(this.i, this.j, this.k, getPaint());
                    }
                    localObject1 = new BitmapShader(this.c, Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
                    getPaint().setShader((Shader)localObject1);
                  }
                }
              }
              else
              {
                getPaint().setShader(null);
                localObject1 = a((int)f3, (int)f6);
                localObject2 = new Paint(getPaint());
                i1 = 0;
                i2 = 0;
                while (i2 < this.n.size())
                {
                  localParagraph = (ColorClearableEditText.Paragraph)this.n.get(i2);
                  i3 = localParagraph.e;
                  if (i3 != 1)
                  {
                    if (i3 == 2) {
                      f1 += ((EmoticonSpan)localParagraph.d).getDrawable().getBounds().width();
                    }
                  }
                  else {
                    for (i3 = 0; i3 < localParagraph.c.length(); i3 = i4)
                    {
                      localObject3 = getPaint();
                      str = localParagraph.c;
                      i4 = i3 + 1;
                      f2 = ((TextPaint)localObject3).measureText(str, i3, i4);
                      localObject3 = this.f;
                      ((Paint)localObject2).setColor(localObject3[(i1 % localObject3.length)]);
                      ((Paint)localObject2).setStyle(Paint.Style.FILL);
                      f2 = f1 + f2;
                      ((Canvas)localObject1).drawRect(f1, 0.0F, f2, f6, (Paint)localObject2);
                      i1 += 1;
                      f1 = f2;
                    }
                  }
                  i2 += 1;
                }
                localObject1 = new BitmapShader(this.c, Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
                getPaint().setShader((Shader)localObject1);
              }
            }
            else
            {
              f1 = f3 / 2.0F;
              localObject1 = new RadialGradient(f1, f6 / 2.0F, f1, this.f, this.g, Shader.TileMode.CLAMP);
              getPaint().setShader((Shader)localObject1);
            }
          }
          else
          {
            getPaint().setShader(null);
            localObject1 = a((int)f3, (int)f6);
            localObject2 = new Paint(getPaint());
            i1 = 0;
            f1 = 0.0F;
            i3 = 0;
            while (i3 < this.n.size())
            {
              localParagraph = (ColorClearableEditText.Paragraph)this.n.get(i3);
              i2 = localParagraph.e;
              if (i2 != 1)
              {
                if (i2 == 2) {
                  f1 += ((EmoticonSpan)localParagraph.d).getDrawable().getBounds().width();
                }
              }
              else
              {
                i2 = i1;
                if (i1 == 0)
                {
                  getPaint().getTextBounds(localParagraph.c, 0, localParagraph.c.length(), this.d);
                  i2 = this.d.height();
                }
                i1 = i2;
                for (i2 = 0; i2 < localParagraph.c.length(); i2 = i4)
                {
                  localObject3 = getPaint();
                  str = localParagraph.c;
                  i4 = i2 + 1;
                  float f7 = ((TextPaint)localObject3).measureText(str, i2, i4);
                  if (this.h == 1) {
                    f2 = f1;
                  } else {
                    f2 = f7 * 0.5F + f1;
                  }
                  if (this.h == 1)
                  {
                    f3 = i1;
                    f3 = f3 * 0.5F + f6 - f3;
                  }
                  else
                  {
                    f3 = f6 - i1;
                  }
                  if (this.h == 1) {
                    f4 = f1 + f7;
                  } else {
                    f4 = f7 * 0.5F + f1;
                  }
                  float f5;
                  if (this.h == 1)
                  {
                    f5 = i1;
                    f5 = f5 * 0.5F + f6 - f5;
                  }
                  else
                  {
                    f5 = i1;
                  }
                  ((Paint)localObject2).setShader(new LinearGradient(f2, f3, f4, f5, this.f, this.g, Shader.TileMode.CLAMP));
                  ((Paint)localObject2).setStyle(Paint.Style.FILL);
                  f3 = i1;
                  f2 = f1 + f7;
                  ((Canvas)localObject1).drawRect(f1, f6 - f3, f2, f6, (Paint)localObject2);
                  f1 = f2;
                }
              }
              i3 += 1;
            }
            localObject1 = new BitmapShader(this.c, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
            getPaint().setShader((Shader)localObject1);
          }
        }
        else
        {
          getPaint().setShader(null);
          if (this.h == 1) {
            f1 = 0.0F;
          } else {
            f1 = f3 * 0.5F;
          }
          if (this.h == 1) {
            f2 = f6 * 0.5F;
          } else {
            f2 = 0.0F;
          }
          if (this.h != 1) {
            f3 *= 0.5F;
          }
          f4 = f6;
          if (this.h == 1) {
            f4 = f6 * 0.5F;
          }
          localObject1 = new LinearGradient(f1, f2, f3, f4, this.f, this.g, Shader.TileMode.CLAMP);
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
  
  private PointF getContentSize()
  {
    PointF localPointF = new PointF();
    Rect localRect = new Rect();
    int i1 = 0;
    float f1 = 0.0F;
    while (i1 < this.n.size())
    {
      Object localObject = (ColorClearableEditText.Paragraph)this.n.get(i1);
      int i2 = ((ColorClearableEditText.Paragraph)localObject).e;
      if (i2 != 1)
      {
        if (i2 == 2)
        {
          localObject = (EmoticonSpan)((ColorClearableEditText.Paragraph)localObject).d;
          localPointF.x += ((EmoticonSpan)localObject).getDrawable().getBounds().width();
          f1 = Math.max(f1, ((EmoticonSpan)localObject).getDrawable().getBounds().height());
        }
      }
      else
      {
        localPointF.x += getPaint().measureText(((ColorClearableEditText.Paragraph)localObject).c);
        getPaint().getTextBounds(((ColorClearableEditText.Paragraph)localObject).c, 0, ((ColorClearableEditText.Paragraph)localObject).c.length(), localRect);
        f1 = Math.max(f1, localRect.height());
      }
      i1 += 1;
    }
    localPointF.y = f1;
    return localPointF;
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
      this.l = getText();
      this.n.clear();
      int i2 = getText().length();
      int i1 = 0;
      CharacterStyle[] arrayOfCharacterStyle = (CharacterStyle[])((Spanned)localObject1).getSpans(0, i2, CharacterStyle.class);
      if (arrayOfCharacterStyle.length == 0)
      {
        localObject1 = new ColorClearableEditText.Paragraph(1, 0, this.l.length(), this.l.toString(), null);
        this.n.add(localObject1);
        return;
      }
      this.o.a((Spanned)localObject1);
      Arrays.sort(arrayOfCharacterStyle, this.o);
      int i3;
      for (i2 = 0; i1 < arrayOfCharacterStyle.length; i2 = i3)
      {
        int i4 = ((Spanned)localObject1).getSpanStart(arrayOfCharacterStyle[i1]);
        i3 = ((Spanned)localObject1).getSpanEnd(arrayOfCharacterStyle[i1]);
        if (i4 > i2)
        {
          localObject2 = new ColorClearableEditText.Paragraph(1, i2, i4, getText().subSequence(i2, i4).toString(), null);
          this.n.add(localObject2);
        }
        Object localObject2 = getText().subSequence(i4, i3).toString();
        if ((arrayOfCharacterStyle[i1] instanceof EmoticonSpan)) {
          i2 = 2;
        } else {
          i2 = 3;
        }
        localObject2 = new ColorClearableEditText.Paragraph(i2, i4, i3, (String)localObject2, arrayOfCharacterStyle[i1]);
        this.n.add(localObject2);
        if ((i1 == arrayOfCharacterStyle.length - 1) && (i3 < getText().length()))
        {
          localObject2 = getText().subSequence(i3, getText().length()).toString();
          localObject2 = new ColorClearableEditText.Paragraph(1, i3, getText().length(), (String)localObject2, null);
          this.n.add(localObject2);
        }
        i1 += 1;
      }
    }
  }
  
  public void b()
  {
    Drawable localDrawable = getBackground();
    if ((localDrawable instanceof TroopNickResDrawable))
    {
      a();
      ((TroopNickResDrawable)localDrawable).a(getContentSize());
    }
  }
  
  public void draw(Canvas paramCanvas)
  {
    MosaicEffect localMosaicEffect = this.b;
    if (localMosaicEffect != null)
    {
      localMosaicEffect.a(paramCanvas);
      return;
    }
    super.draw(paramCanvas);
  }
  
  public int getColorNickId()
  {
    return this.m;
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    Object localObject = getBackground();
    if ((localObject instanceof TroopNickResDrawable))
    {
      localObject = (TroopNickResDrawable)localObject;
      ((TroopNickResDrawable)localObject).a(null);
      ((TroopNickResDrawable)localObject).c();
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    MosaicEffect localMosaicEffect = this.b;
    if (localMosaicEffect != null)
    {
      localMosaicEffect.b(paramCanvas);
      return;
    }
    a(paramCanvas);
  }
  
  public void setCustomCloth(int paramInt)
  {
    this.m = paramInt;
    Object localObject = getBackground();
    if ((localObject instanceof TroopNickResDrawable))
    {
      localObject = (TroopNickResDrawable)localObject;
      ((TroopNickResDrawable)localObject).a(getContentSize());
      ((TroopNickResDrawable)localObject).a(paramInt);
      return;
    }
    TroopNickNameHelper.a(this, getContext(), paramInt, true);
  }
  
  public void setMosaicEffect(MosaicEffect paramMosaicEffect)
  {
    MosaicEffect localMosaicEffect = this.b;
    if (localMosaicEffect != null) {
      localMosaicEffect.a(null);
    }
    this.b = paramMosaicEffect;
    paramMosaicEffect = this.b;
    if (paramMosaicEffect != null) {
      paramMosaicEffect.a(this);
    }
    invalidate();
  }
  
  public void setSpecialColor(int paramInt1, int[] paramArrayOfInt, float[] paramArrayOfFloat, int paramInt2, Bitmap paramBitmap)
  {
    this.e = paramInt1;
    this.h = paramInt2;
    if (paramArrayOfInt != null) {
      this.f = Arrays.copyOf(paramArrayOfInt, paramArrayOfInt.length);
    }
    if (paramArrayOfFloat != null) {
      this.g = Arrays.copyOf(paramArrayOfFloat, paramArrayOfFloat.length);
    }
    this.i = paramBitmap;
    paramArrayOfInt = this.i;
    if (paramArrayOfInt != null) {
      this.j.set(0, 0, paramArrayOfInt.getWidth(), this.i.getHeight());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.ColorNickTextView
 * JD-Core Version:    0.7.0.1
 */