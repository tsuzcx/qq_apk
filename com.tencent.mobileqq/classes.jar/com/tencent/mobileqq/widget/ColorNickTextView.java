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
import aykp;
import bcka;
import bckb;
import bcnb;
import bcnc;
import java.util.ArrayList;
import java.util.Arrays;

public class ColorNickTextView
  extends TextView
  implements bcnc
{
  private int jdField_a_of_type_Int;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private Rect jdField_a_of_type_AndroidGraphicsRect = new Rect();
  private bckb jdField_a_of_type_Bckb = new bckb();
  private bcnb jdField_a_of_type_Bcnb;
  private CharSequence jdField_a_of_type_JavaLangCharSequence;
  private ArrayList<bcka> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  public boolean a;
  private float[] jdField_a_of_type_ArrayOfFloat;
  private int[] jdField_a_of_type_ArrayOfInt;
  private int jdField_b_of_type_Int;
  private Bitmap jdField_b_of_type_AndroidGraphicsBitmap;
  private Rect jdField_b_of_type_AndroidGraphicsRect = new Rect();
  private Rect c = new Rect();
  
  public ColorNickTextView(Context paramContext)
  {
    super(paramContext);
  }
  
  public ColorNickTextView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public ColorNickTextView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private Canvas a(int paramInt1, int paramInt2)
  {
    if ((this.jdField_a_of_type_AndroidGraphicsBitmap == null) || (this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth() != paramInt1) || (this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight() != paramInt2))
    {
      if (this.jdField_a_of_type_AndroidGraphicsBitmap != null) {
        this.jdField_a_of_type_AndroidGraphicsBitmap.recycle();
      }
      this.jdField_a_of_type_AndroidGraphicsBitmap = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
    }
    Canvas localCanvas = new Canvas(this.jdField_a_of_type_AndroidGraphicsBitmap);
    localCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
    return localCanvas;
  }
  
  private PointF a()
  {
    PointF localPointF = new PointF();
    Rect localRect = new Rect();
    int i = 0;
    float f = 0.0F;
    if (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      Object localObject = (bcka)this.jdField_a_of_type_JavaUtilArrayList.get(i);
      switch (((bcka)localObject).c)
      {
      }
      for (;;)
      {
        i += 1;
        break;
        localPointF.x += getPaint().measureText(((bcka)localObject).jdField_a_of_type_JavaLangString);
        getPaint().getTextBounds(((bcka)localObject).jdField_a_of_type_JavaLangString, 0, ((bcka)localObject).jdField_a_of_type_JavaLangString.length(), localRect);
        f = Math.max(f, localRect.height());
        continue;
        localObject = (aykp)((bcka)localObject).jdField_a_of_type_AndroidTextStyleCharacterStyle;
        localPointF.x += ((aykp)localObject).a().getBounds().width();
        f = Math.max(f, ((aykp)localObject).a().getBounds().height());
      }
    }
    localPointF.y = f;
    return localPointF;
  }
  
  private void a(Canvas paramCanvas)
  {
    Object localObject;
    float f3;
    float f6;
    float f1;
    Paint localPaint;
    int i;
    int j;
    bcka localbcka;
    if (this.jdField_a_of_type_Int != 0)
    {
      a();
      if (this.jdField_a_of_type_JavaUtilArrayList.size() == 0)
      {
        getPaint().setShader(null);
        super.onDraw(paramCanvas);
        return;
      }
      localObject = a();
      f3 = ((PointF)localObject).x;
      f6 = ((PointF)localObject).y;
      if ((f3 > 0.0F) && (f6 > 0.0F)) {
        getPaint().setColor(-16777216);
      }
      switch (this.jdField_a_of_type_Int)
      {
      default: 
        super.onDraw(paramCanvas);
        return;
      case 2: 
        getPaint().setShader(null);
        localObject = a((int)f3, (int)f6);
        f1 = 0.0F;
        localPaint = new Paint(getPaint());
        i = 0;
        j = 0;
        while (j < this.jdField_a_of_type_JavaUtilArrayList.size())
        {
          localbcka = (bcka)this.jdField_a_of_type_JavaUtilArrayList.get(j);
          switch (localbcka.c)
          {
          default: 
            j += 1;
            break;
          case 1: 
            label216:
            if (i != 0) {
              break label1116;
            }
            getPaint().getTextBounds(localbcka.jdField_a_of_type_JavaLangString, 0, localbcka.jdField_a_of_type_JavaLangString.length(), this.jdField_a_of_type_AndroidGraphicsRect);
            i = this.jdField_a_of_type_AndroidGraphicsRect.height();
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
      if (k < localbcka.jdField_a_of_type_JavaLangString.length())
      {
        float f7 = getPaint().measureText(localbcka.jdField_a_of_type_JavaLangString, k, k + 1);
        if (this.jdField_b_of_type_Int == 1)
        {
          f2 = f1;
          if (this.jdField_b_of_type_Int != 1) {
            break label454;
          }
          f3 = i * 0.5F + f6 - i;
          if (this.jdField_b_of_type_Int != 1) {
            break label465;
          }
          f4 = f1 + f7;
          if (this.jdField_b_of_type_Int != 1) {
            break label477;
          }
        }
        label477:
        for (float f5 = i * 0.5F + f6 - i;; f5 = i)
        {
          localPaint.setShader(new LinearGradient(f2, f3, f4, f5, this.jdField_a_of_type_ArrayOfInt, this.jdField_a_of_type_ArrayOfFloat, Shader.TileMode.CLAMP));
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
      f1 += ((aykp)localbcka.jdField_a_of_type_AndroidTextStyleCharacterStyle).a().getBounds().width();
      break label216;
      localObject = new BitmapShader(this.jdField_a_of_type_AndroidGraphicsBitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
      getPaint().setShader((Shader)localObject);
      break;
      localObject = new RadialGradient(f3 / 2.0F, f6 / 2.0F, f3 / 2.0F, this.jdField_a_of_type_ArrayOfInt, this.jdField_a_of_type_ArrayOfFloat, Shader.TileMode.CLAMP);
      getPaint().setShader((Shader)localObject);
      break;
      getPaint().setShader(null);
      if (this.jdField_b_of_type_Int == 1)
      {
        f1 = 0.0F;
        label608:
        if (this.jdField_b_of_type_Int != 1) {
          break label693;
        }
        f2 = f6 * 0.5F;
        label622:
        if (this.jdField_b_of_type_Int != 1) {
          break label698;
        }
        label630:
        if (this.jdField_b_of_type_Int != 1) {
          break label708;
        }
      }
      for (float f4 = f6 * 0.5F;; f4 = f6)
      {
        localObject = new LinearGradient(f1, f2, f3, f4, this.jdField_a_of_type_ArrayOfInt, this.jdField_a_of_type_ArrayOfFloat, Shader.TileMode.CLAMP);
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
      localObject = a((int)f3, (int)f6);
      f1 = 0.0F;
      localPaint = new Paint(getPaint());
      i = 0;
      j = 0;
      if (j < this.jdField_a_of_type_JavaUtilArrayList.size())
      {
        localbcka = (bcka)this.jdField_a_of_type_JavaUtilArrayList.get(j);
        switch (localbcka.c)
        {
        }
        for (;;)
        {
          j += 1;
          break;
          k = 0;
          while (k < localbcka.jdField_a_of_type_JavaLangString.length())
          {
            f2 = getPaint().measureText(localbcka.jdField_a_of_type_JavaLangString, k, k + 1);
            localPaint.setColor(this.jdField_a_of_type_ArrayOfInt[(i % this.jdField_a_of_type_ArrayOfInt.length)]);
            localPaint.setStyle(Paint.Style.FILL);
            ((Canvas)localObject).drawRect(f1, 0.0F, f1 + f2, f6, localPaint);
            k += 1;
            i += 1;
            f1 += f2;
          }
          continue;
          f1 += ((aykp)localbcka.jdField_a_of_type_AndroidTextStyleCharacterStyle).a().getBounds().width();
        }
      }
      localObject = new BitmapShader(this.jdField_a_of_type_AndroidGraphicsBitmap, Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
      getPaint().setShader((Shader)localObject);
      break;
      getPaint().setShader(null);
      if (this.jdField_b_of_type_AndroidGraphicsBitmap == null) {
        break;
      }
      localObject = a((int)f3, (int)f6);
      j = this.jdField_b_of_type_AndroidGraphicsBitmap.getWidth();
      i = 0;
      while (i < f3)
      {
        this.c.set(i, 0, i + j, (int)f6);
        ((Canvas)localObject).drawBitmap(this.jdField_b_of_type_AndroidGraphicsBitmap, this.jdField_b_of_type_AndroidGraphicsRect, this.c, getPaint());
        i += j;
      }
      localObject = new BitmapShader(this.jdField_a_of_type_AndroidGraphicsBitmap, Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
      getPaint().setShader((Shader)localObject);
      break;
      getPaint().setShader(null);
      break;
    }
  }
  
  public void a()
  {
    int j = 0;
    Object localObject1 = getText();
    if ((localObject1 instanceof Spanned)) {}
    for (localObject1 = (Spanned)localObject1;; localObject1 = null)
    {
      CharacterStyle[] arrayOfCharacterStyle;
      if (localObject1 != null)
      {
        this.jdField_a_of_type_JavaLangCharSequence = getText();
        this.jdField_a_of_type_JavaUtilArrayList.clear();
        arrayOfCharacterStyle = (CharacterStyle[])((Spanned)localObject1).getSpans(0, getText().length(), CharacterStyle.class);
        if (arrayOfCharacterStyle.length == 0)
        {
          localObject1 = new bcka(1, 0, this.jdField_a_of_type_JavaLangCharSequence.length(), this.jdField_a_of_type_JavaLangCharSequence.toString(), null);
          this.jdField_a_of_type_JavaUtilArrayList.add(localObject1);
        }
      }
      else
      {
        return;
      }
      this.jdField_a_of_type_Bckb.a((Spanned)localObject1);
      Arrays.sort(arrayOfCharacterStyle, this.jdField_a_of_type_Bckb);
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
          localObject2 = new bcka(1, j, m, getText().subSequence(j, m).toString(), null);
          this.jdField_a_of_type_JavaUtilArrayList.add(localObject2);
        }
        localObject2 = getText().subSequence(m, k).toString();
        if (!(arrayOfCharacterStyle[i] instanceof aykp)) {
          break label364;
        }
      }
      label364:
      for (j = 2;; j = 3)
      {
        localObject2 = new bcka(j, m, k, (String)localObject2, arrayOfCharacterStyle[i]);
        this.jdField_a_of_type_JavaUtilArrayList.add(localObject2);
        if ((i == arrayOfCharacterStyle.length - 1) && (k < getText().length()))
        {
          localObject2 = getText().subSequence(k, getText().length()).toString();
          localObject2 = new bcka(1, k, getText().length(), (String)localObject2, null);
          this.jdField_a_of_type_JavaUtilArrayList.add(localObject2);
        }
        i += 1;
        j = k;
        break label135;
        break;
      }
    }
  }
  
  public void b(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
  }
  
  public void c(Canvas paramCanvas)
  {
    a(paramCanvas);
  }
  
  public void draw(Canvas paramCanvas)
  {
    if (this.jdField_a_of_type_Bcnb != null)
    {
      this.jdField_a_of_type_Bcnb.a(paramCanvas);
      return;
    }
    super.draw(paramCanvas);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if (this.jdField_a_of_type_Bcnb != null)
    {
      this.jdField_a_of_type_Bcnb.b(paramCanvas);
      return;
    }
    a(paramCanvas);
  }
  
  public void setMosaicEffect(bcnb parambcnb)
  {
    if (this.jdField_a_of_type_Bcnb != null) {
      this.jdField_a_of_type_Bcnb.a(null);
    }
    this.jdField_a_of_type_Bcnb = parambcnb;
    if (this.jdField_a_of_type_Bcnb != null) {
      this.jdField_a_of_type_Bcnb.a(this);
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
    if (this.jdField_b_of_type_AndroidGraphicsBitmap != null) {
      this.jdField_b_of_type_AndroidGraphicsRect.set(0, 0, this.jdField_b_of_type_AndroidGraphicsBitmap.getWidth(), this.jdField_b_of_type_AndroidGraphicsBitmap.getHeight());
    }
    invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.ColorNickTextView
 * JD-Core Version:    0.7.0.1
 */