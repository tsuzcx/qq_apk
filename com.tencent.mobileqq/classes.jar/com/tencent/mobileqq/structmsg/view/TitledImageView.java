package com.tencent.mobileqq.structmsg.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.RectF;
import android.text.DynamicLayout;
import android.text.Layout;
import android.text.Layout.Alignment;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.text.method.SingleLineTransformationMethod;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.widget.AnyScaleTypeImageView;

public class TitledImageView
  extends AnyScaleTypeImageView
{
  private CharSequence a = null;
  private TextPaint b = new TextPaint();
  private int c = -16777216;
  private int d = -1;
  private int e = 10;
  private int f = 10;
  private Path g = null;
  private Layout h = null;
  private TransformationMethod i;
  
  public TitledImageView(Context paramContext)
  {
    super(paramContext);
    this.b.setAntiAlias(true);
    this.i = SingleLineTransformationMethod.getInstance();
  }
  
  public TitledImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.b.setAntiAlias(true);
    this.i = SingleLineTransformationMethod.getInstance();
  }
  
  public TitledImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.b.setAntiAlias(true);
    this.i = SingleLineTransformationMethod.getInstance();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (!TextUtils.isEmpty(this.a))
    {
      this.b.setColor(this.c);
      this.b.setStyle(Paint.Style.FILL_AND_STROKE);
      float f1 = getMeasuredHeight() - this.b.getTextSize() - this.e * 2;
      paramCanvas.save();
      paramCanvas.clipRect(0.0F, f1, getMeasuredWidth(), getMeasuredHeight());
      Object localObject = this.g;
      if (localObject != null) {
        paramCanvas.drawPath((Path)localObject, this.b);
      }
      int j = this.e;
      paramCanvas.translate(0.0F + j, f1 + j);
      this.b.setColor(this.d);
      localObject = this.h;
      if (localObject != null) {
        ((Layout)localObject).draw(paramCanvas);
      }
      paramCanvas.restore();
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    paramInt1 = getMeasuredHeight();
    paramInt2 = getMeasuredWidth();
    if (paramInt1 >= 1)
    {
      if (paramInt2 < 1) {
        return;
      }
      if (paramBoolean)
      {
        this.g = new Path();
        float f1 = paramInt1 - this.e * 2 - this.b.getTextSize();
        float f2 = paramInt2;
        float f3 = paramInt1;
        this.g.moveTo(0.0F, f1);
        this.g.lineTo(f2, f1);
        this.g.lineTo(f2, f3 - this.f);
        paramInt1 = this.f;
        Object localObject = new RectF(f2 - paramInt1 * 2, f3 - paramInt1 * 2, f2, f3);
        this.g.arcTo((RectF)localObject, 0.0F, 90.0F, false);
        this.g.lineTo(this.f + 0.0F, f3);
        paramInt1 = this.f;
        localObject = new RectF(0.0F, f3 - paramInt1 * 2, paramInt1 * 2 + 0.0F, f3);
        this.g.arcTo((RectF)localObject, 90.0F, 90.0F, true);
        this.g.lineTo(0.0F, f1);
        this.g.close();
        localObject = this.a;
        if (localObject != null)
        {
          localObject = this.i.getTransformation((CharSequence)localObject, this);
          paramInt1 = (int)Layout.getDesiredWidth(this.a, this.b);
          this.h = new DynamicLayout(this.a, (CharSequence)localObject, this.b, paramInt1, Layout.Alignment.ALIGN_NORMAL, 1.0F, 0.5F, false, TextUtils.TruncateAt.END, (int)(f2 - this.e * 2));
        }
      }
    }
  }
  
  public void setTextBackground(int paramInt)
  {
    this.c = paramInt;
  }
  
  public void setTextColor(int paramInt)
  {
    this.d = paramInt;
  }
  
  public void setTextPadding(int paramInt)
  {
    this.e = paramInt;
  }
  
  public void setTextSize(float paramFloat)
  {
    this.b.setTextSize(paramFloat);
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    if ((this.a instanceof QQText))
    {
      this.a = paramCharSequence;
      return;
    }
    this.a = new QQText(paramCharSequence, 1, 16);
  }
  
  public void settextBgRadius(int paramInt)
  {
    this.f = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.view.TitledImageView
 * JD-Core Version:    0.7.0.1
 */