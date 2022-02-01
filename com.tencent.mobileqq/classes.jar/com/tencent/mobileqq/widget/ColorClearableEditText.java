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
import com.tencent.mobileqq.text.style.EmoticonSpan;
import com.tencent.mobileqq.vas.troopnick.TroopNickNameHelper;
import com.tencent.mobileqq.vas.troopnick.TroopNickResDrawable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ColorClearableEditText
  extends ClearableEditText
{
  private int jdField_a_of_type_Int = 0;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private Rect jdField_a_of_type_AndroidGraphicsRect = new Rect();
  private ColorClearableEditText.SpanComparator jdField_a_of_type_ComTencentMobileqqWidgetColorClearableEditText$SpanComparator = new ColorClearableEditText.SpanComparator();
  private ArrayList<ColorClearableEditText.Paragraph> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private float[] jdField_a_of_type_ArrayOfFloat;
  private int[] jdField_a_of_type_ArrayOfInt;
  private int jdField_b_of_type_Int;
  private Bitmap jdField_b_of_type_AndroidGraphicsBitmap;
  private Rect jdField_b_of_type_AndroidGraphicsRect = new Rect();
  private int jdField_c_of_type_Int;
  private Rect jdField_c_of_type_AndroidGraphicsRect = new Rect();
  
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
      Object localObject = (ColorClearableEditText.Paragraph)this.jdField_a_of_type_JavaUtilArrayList.get(i);
      switch (((ColorClearableEditText.Paragraph)localObject).jdField_c_of_type_Int)
      {
      }
      for (;;)
      {
        i += 1;
        break;
        localPointF.x += getPaint().measureText(((ColorClearableEditText.Paragraph)localObject).jdField_a_of_type_JavaLangString);
        getPaint().getTextBounds(((ColorClearableEditText.Paragraph)localObject).jdField_a_of_type_JavaLangString, 0, ((ColorClearableEditText.Paragraph)localObject).jdField_a_of_type_JavaLangString.length(), localRect);
        f = Math.max(f, localRect.height());
        continue;
        localObject = (EmoticonSpan)((ColorClearableEditText.Paragraph)localObject).jdField_a_of_type_AndroidTextStyleCharacterStyle;
        localPointF.x += ((EmoticonSpan)localObject).getDrawable().getBounds().width();
        f = Math.max(f, ((EmoticonSpan)localObject).getDrawable().getBounds().height());
      }
    }
    localPointF.y = f;
    return localPointF;
  }
  
  public static void a(List<ColorClearableEditText.Paragraph> paramList, ColorClearableEditText.SpanComparator paramSpanComparator, Spannable paramSpannable)
  {
    paramList.clear();
    CharacterStyle[] arrayOfCharacterStyle = (CharacterStyle[])paramSpannable.getSpans(0, paramSpannable.length(), CharacterStyle.class);
    if (arrayOfCharacterStyle.length == 0)
    {
      paramList.add(new ColorClearableEditText.Paragraph(1, 0, paramSpannable.length(), paramSpannable.toString(), null));
      return;
    }
    paramSpanComparator.a(paramSpannable);
    Arrays.sort(arrayOfCharacterStyle, paramSpanComparator);
    int j = 0;
    int i = 0;
    label76:
    int m;
    int k;
    if (i < arrayOfCharacterStyle.length)
    {
      m = paramSpannable.getSpanStart(arrayOfCharacterStyle[i]);
      k = paramSpannable.getSpanEnd(arrayOfCharacterStyle[i]);
      if (m > j) {
        paramList.add(new ColorClearableEditText.Paragraph(1, j, m, paramSpannable.subSequence(j, m).toString(), null));
      }
      paramSpanComparator = paramSpannable.subSequence(m, k).toString();
      if (!(arrayOfCharacterStyle[i] instanceof EmoticonSpan)) {
        break label279;
      }
    }
    label279:
    for (j = 2;; j = 3)
    {
      paramList.add(new ColorClearableEditText.Paragraph(j, m, k, paramSpanComparator, arrayOfCharacterStyle[i]));
      if ((i == arrayOfCharacterStyle.length - 1) && (k < paramSpannable.length()))
      {
        paramSpanComparator = paramSpannable.subSequence(k, paramSpannable.length()).toString();
        paramList.add(new ColorClearableEditText.Paragraph(1, k, paramSpannable.length(), paramSpanComparator, null));
      }
      i += 1;
      j = k;
      break label76;
      break;
    }
  }
  
  public int a()
  {
    return this.jdField_c_of_type_Int;
  }
  
  public ArrayList<ColorClearableEditText.Paragraph> a()
  {
    return this.jdField_a_of_type_JavaUtilArrayList;
  }
  
  public void a()
  {
    a(this.jdField_a_of_type_JavaUtilArrayList, this.jdField_a_of_type_ComTencentMobileqqWidgetColorClearableEditText$SpanComparator, getText());
  }
  
  public void b()
  {
    a();
    Object localObject = getBackground();
    if ((localObject instanceof TroopNickResDrawable))
    {
      localObject = (TroopNickResDrawable)localObject;
      PointF localPointF = a();
      if ((localPointF.x == 0.0F) && (localPointF.y == 0.0F)) {
        localPointF.x = 1.0F;
      }
      ((TroopNickResDrawable)localObject).a(localPointF);
    }
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    Drawable localDrawable = getBackground();
    if ((localDrawable instanceof TroopNickResDrawable))
    {
      ((TroopNickResDrawable)localDrawable).a(null);
      ((TroopNickResDrawable)localDrawable).a();
    }
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    Object localObject;
    float f3;
    float f6;
    float f1;
    Paint localPaint;
    int i;
    int j;
    ColorClearableEditText.Paragraph localParagraph;
    if (this.jdField_a_of_type_Int != 0)
    {
      a(this.jdField_a_of_type_JavaUtilArrayList, this.jdField_a_of_type_ComTencentMobileqqWidgetColorClearableEditText$SpanComparator, getText());
      localObject = a();
      f3 = ((PointF)localObject).x;
      f6 = ((PointF)localObject).y;
      if ((f3 > 0.0F) && (f6 > 0.0F)) {}
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
          localParagraph = (ColorClearableEditText.Paragraph)this.jdField_a_of_type_JavaUtilArrayList.get(j);
          switch (localParagraph.jdField_c_of_type_Int)
          {
          default: 
            j += 1;
            break;
          case 1: 
            label196:
            if (i != 0) {
              break label1104;
            }
            getPaint().getTextBounds(localParagraph.jdField_a_of_type_JavaLangString, 0, localParagraph.jdField_a_of_type_JavaLangString.length(), this.jdField_a_of_type_AndroidGraphicsRect);
            i = this.jdField_a_of_type_AndroidGraphicsRect.height();
          }
        }
      }
    }
    label290:
    label314:
    label328:
    label461:
    label1104:
    for (;;)
    {
      int k = 0;
      float f2;
      if (k < localParagraph.jdField_a_of_type_JavaLangString.length())
      {
        float f7 = getPaint().measureText(localParagraph.jdField_a_of_type_JavaLangString, k, k + 1);
        if (this.jdField_b_of_type_Int == 1)
        {
          f2 = f1;
          if (this.jdField_b_of_type_Int != 1) {
            break label437;
          }
          f3 = i * 0.5F + f6 - i;
          if (this.jdField_b_of_type_Int != 1) {
            break label448;
          }
          f4 = f1 + f7;
          if (this.jdField_b_of_type_Int != 1) {
            break label461;
          }
        }
        for (float f5 = i * 0.5F + f6 - i;; f5 = i)
        {
          localPaint.setShader(new LinearGradient(f2, f3, f4, f5, this.jdField_a_of_type_ArrayOfInt, this.jdField_a_of_type_ArrayOfFloat, Shader.TileMode.CLAMP));
          localPaint.setStyle(Paint.Style.FILL);
          ((Canvas)localObject).drawRect(f1, f6 - i, f1 + f7, f6, localPaint);
          k += 1;
          f1 += f7;
          break;
          f2 = f1 + 0.5F * f7;
          break label290;
          f3 = f6 - i;
          break label314;
          f4 = f1 + 0.5F * f7;
          break label328;
        }
      }
      break label196;
      f1 += ((EmoticonSpan)localParagraph.jdField_a_of_type_AndroidTextStyleCharacterStyle).getDrawable().getBounds().width();
      break label196;
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
        label592:
        if (this.jdField_b_of_type_Int != 1) {
          break label680;
        }
        f2 = f6 * 0.5F;
        label607:
        if (this.jdField_b_of_type_Int != 1) {
          break label685;
        }
        label615:
        if (this.jdField_b_of_type_Int != 1) {
          break label696;
        }
      }
      for (float f4 = f6 * 0.5F;; f4 = f6)
      {
        localObject = new LinearGradient(f1, f2, f3, f4, this.jdField_a_of_type_ArrayOfInt, this.jdField_a_of_type_ArrayOfFloat, Shader.TileMode.CLAMP);
        getPaint().setShader((Shader)localObject);
        break;
        f1 = f3 * 0.5F;
        break label592;
        f2 = 0.0F;
        break label607;
        f3 *= 0.5F;
        break label615;
      }
      getPaint().setShader(null);
      localObject = a((int)f3, (int)f6);
      f1 = 0.0F;
      localPaint = new Paint(getPaint());
      i = 0;
      j = 0;
      if (j < this.jdField_a_of_type_JavaUtilArrayList.size())
      {
        localParagraph = (ColorClearableEditText.Paragraph)this.jdField_a_of_type_JavaUtilArrayList.get(j);
        switch (localParagraph.jdField_c_of_type_Int)
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
            localPaint.setColor(this.jdField_a_of_type_ArrayOfInt[(i % this.jdField_a_of_type_ArrayOfInt.length)]);
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
        this.jdField_c_of_type_AndroidGraphicsRect.set(i, 0, i + j, (int)f6);
        ((Canvas)localObject).drawBitmap(this.jdField_b_of_type_AndroidGraphicsBitmap, this.jdField_b_of_type_AndroidGraphicsRect, this.jdField_c_of_type_AndroidGraphicsRect, getPaint());
        i += j;
      }
      localObject = new BitmapShader(this.jdField_a_of_type_AndroidGraphicsBitmap, Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
      getPaint().setShader((Shader)localObject);
      break;
      getPaint().setShader(null);
      break;
    }
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
    this.jdField_c_of_type_Int = paramInt;
    TroopNickNameHelper.a(this, getContext(), paramInt, paramBoolean);
    b();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.widget.ColorClearableEditText
 * JD-Core Version:    0.7.0.1
 */