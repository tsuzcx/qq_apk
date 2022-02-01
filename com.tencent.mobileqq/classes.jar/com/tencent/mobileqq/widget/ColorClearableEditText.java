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
import android.text.Spannable;
import android.text.TextPaint;
import android.text.style.CharacterStyle;
import android.util.AttributeSet;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.text.style.EmoticonSpan;
import com.tencent.mobileqq.troop.api.ITroopNickEdit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ColorClearableEditText
  extends ClearableEditText
{
  private Bitmap e;
  private Rect f = new Rect();
  private int g = 0;
  private int[] h;
  private float[] i;
  private int j;
  private Bitmap k;
  private Rect l = new Rect();
  private Rect m = new Rect();
  private ArrayList<ColorClearableEditText.Paragraph> n = new ArrayList();
  private int o;
  private ColorClearableEditText.SpanComparator p = new ColorClearableEditText.SpanComparator();
  
  public ColorClearableEditText(Context paramContext)
  {
    super(paramContext);
  }
  
  public ColorClearableEditText(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public ColorClearableEditText(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private Canvas a(int paramInt1, int paramInt2)
  {
    Object localObject = this.e;
    if ((localObject == null) || (((Bitmap)localObject).getWidth() != paramInt1) || (this.e.getHeight() != paramInt2))
    {
      localObject = this.e;
      if (localObject != null) {
        ((Bitmap)localObject).recycle();
      }
      this.e = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
    }
    localObject = new Canvas(this.e);
    ((Canvas)localObject).drawColor(0, PorterDuff.Mode.CLEAR);
    return localObject;
  }
  
  public static void a(List<ColorClearableEditText.Paragraph> paramList, ColorClearableEditText.SpanComparator paramSpanComparator, Spannable paramSpannable)
  {
    paramList.clear();
    int i2 = paramSpannable.length();
    int i1 = 0;
    CharacterStyle[] arrayOfCharacterStyle = (CharacterStyle[])paramSpannable.getSpans(0, i2, CharacterStyle.class);
    if (arrayOfCharacterStyle.length == 0)
    {
      paramList.add(new ColorClearableEditText.Paragraph(1, 0, paramSpannable.length(), paramSpannable.toString(), null));
      return;
    }
    paramSpanComparator.a(paramSpannable);
    Arrays.sort(arrayOfCharacterStyle, paramSpanComparator);
    int i3;
    for (i2 = 0; i1 < arrayOfCharacterStyle.length; i2 = i3)
    {
      int i4 = paramSpannable.getSpanStart(arrayOfCharacterStyle[i1]);
      i3 = paramSpannable.getSpanEnd(arrayOfCharacterStyle[i1]);
      if (i4 > i2) {
        paramList.add(new ColorClearableEditText.Paragraph(1, i2, i4, paramSpannable.subSequence(i2, i4).toString(), null));
      }
      paramSpanComparator = paramSpannable.subSequence(i4, i3).toString();
      if ((arrayOfCharacterStyle[i1] instanceof EmoticonSpan)) {
        i2 = 2;
      } else {
        i2 = 3;
      }
      paramList.add(new ColorClearableEditText.Paragraph(i2, i4, i3, paramSpanComparator, arrayOfCharacterStyle[i1]));
      if ((i1 == arrayOfCharacterStyle.length - 1) && (i3 < paramSpannable.length()))
      {
        paramSpanComparator = paramSpannable.subSequence(i3, paramSpannable.length()).toString();
        paramList.add(new ColorClearableEditText.Paragraph(1, i3, paramSpannable.length(), paramSpanComparator, null));
      }
      i1 += 1;
    }
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
    a(this.n, this.p, getText());
  }
  
  public void b()
  {
    a();
    Drawable localDrawable = getBackground();
    ((ITroopNickEdit)QRoute.api(ITroopNickEdit.class)).updateDrawablePadding(localDrawable, getContentSize());
  }
  
  public ArrayList<ColorClearableEditText.Paragraph> getParagraphs()
  {
    return this.n;
  }
  
  public int getScid()
  {
    return this.o;
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    Drawable localDrawable = getBackground();
    ((ITroopNickEdit)QRoute.api(ITroopNickEdit.class)).onDetachedFromWindow(localDrawable);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if (this.g != 0)
    {
      a(this.n, this.p, getText());
      Object localObject1 = getContentSize();
      float f3 = ((PointF)localObject1).x;
      float f6 = ((PointF)localObject1).y;
      float f1 = 0.0F;
      if ((f3 > 0.0F) && (f6 > 0.0F))
      {
        int i1 = this.g;
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
                  if (this.k != null)
                  {
                    i1 = (int)f3;
                    i3 = (int)f6;
                    localObject1 = a(i1, i3);
                    i4 = this.k.getWidth();
                    for (i1 = 0; i1 < f3; i1 = i2)
                    {
                      localObject2 = this.m;
                      i2 = i1 + i4;
                      ((Rect)localObject2).set(i1, 0, i2, i3);
                      ((Canvas)localObject1).drawBitmap(this.k, this.l, this.m, getPaint());
                    }
                    localObject1 = new BitmapShader(this.e, Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
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
                      localObject3 = this.h;
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
                localObject1 = new BitmapShader(this.e, Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
                getPaint().setShader((Shader)localObject1);
              }
            }
            else
            {
              f1 = f3 / 2.0F;
              localObject1 = new RadialGradient(f1, f6 / 2.0F, f1, this.h, this.i, Shader.TileMode.CLAMP);
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
                  getPaint().getTextBounds(localParagraph.c, 0, localParagraph.c.length(), this.f);
                  i2 = this.f.height();
                }
                i1 = i2;
                for (i2 = 0; i2 < localParagraph.c.length(); i2 = i4)
                {
                  localObject3 = getPaint();
                  str = localParagraph.c;
                  i4 = i2 + 1;
                  float f7 = ((TextPaint)localObject3).measureText(str, i2, i4);
                  if (this.j == 1) {
                    f2 = f1;
                  } else {
                    f2 = f7 * 0.5F + f1;
                  }
                  if (this.j == 1)
                  {
                    f3 = i1;
                    f3 = f3 * 0.5F + f6 - f3;
                  }
                  else
                  {
                    f3 = f6 - i1;
                  }
                  if (this.j == 1) {
                    f4 = f1 + f7;
                  } else {
                    f4 = f7 * 0.5F + f1;
                  }
                  float f5;
                  if (this.j == 1)
                  {
                    f5 = i1;
                    f5 = f5 * 0.5F + f6 - f5;
                  }
                  else
                  {
                    f5 = i1;
                  }
                  ((Paint)localObject2).setShader(new LinearGradient(f2, f3, f4, f5, this.h, this.i, Shader.TileMode.CLAMP));
                  ((Paint)localObject2).setStyle(Paint.Style.FILL);
                  f3 = i1;
                  f2 = f1 + f7;
                  ((Canvas)localObject1).drawRect(f1, f6 - f3, f2, f6, (Paint)localObject2);
                  f1 = f2;
                }
              }
              i3 += 1;
            }
            localObject1 = new BitmapShader(this.e, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
            getPaint().setShader((Shader)localObject1);
          }
        }
        else
        {
          getPaint().setShader(null);
          if (this.j == 1) {
            f1 = 0.0F;
          } else {
            f1 = f3 * 0.5F;
          }
          if (this.j == 1) {
            f2 = f6 * 0.5F;
          } else {
            f2 = 0.0F;
          }
          if (this.j != 1) {
            f3 *= 0.5F;
          }
          f4 = f6;
          if (this.j == 1) {
            f4 = f6 * 0.5F;
          }
          localObject1 = new LinearGradient(f1, f2, f3, f4, this.h, this.i, Shader.TileMode.CLAMP);
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
  
  public void setBackgroundDrawable(Drawable paramDrawable)
  {
    super.setBackgroundDrawable(paramDrawable);
  }
  
  public void setCustomCloth(int paramInt)
  {
    setCustomCloth(paramInt, false);
  }
  
  public void setCustomCloth(int paramInt, boolean paramBoolean)
  {
    this.o = paramInt;
    ((ITroopNickEdit)QRoute.api(ITroopNickEdit.class)).setCustomCloth(this, getContext(), paramInt, paramBoolean);
    b();
  }
  
  public void setSpecialColor(int paramInt1, int[] paramArrayOfInt, float[] paramArrayOfFloat, int paramInt2, Bitmap paramBitmap)
  {
    this.g = paramInt1;
    this.j = paramInt2;
    if (paramArrayOfInt != null) {
      this.h = Arrays.copyOf(paramArrayOfInt, paramArrayOfInt.length);
    }
    if (paramArrayOfFloat != null) {
      this.i = Arrays.copyOf(paramArrayOfFloat, paramArrayOfFloat.length);
    }
    this.k = paramBitmap;
    paramArrayOfInt = this.k;
    if (paramArrayOfInt != null) {
      this.l.set(0, 0, paramArrayOfInt.getWidth(), this.k.getHeight());
    }
    invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.ColorClearableEditText
 * JD-Core Version:    0.7.0.1
 */