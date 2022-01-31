package com.tencent.mobileqq.profile.view;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.animation.DecelerateInterpolator;
import android.widget.TextView;
import avau;
import avav;
import avay;
import bbkk;
import bblx;
import bbly;
import bblz;

public final class VipTagView
  extends TextView
  implements bbly
{
  private static final int[] jdField_a_of_type_ArrayOfInt = { 2131298364, 2131298365, 2131298366, 2131298367, 2131298368 };
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  private avay jdField_a_of_type_Avay;
  private bbkk<Float> jdField_a_of_type_Bbkk;
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  
  public VipTagView(Context paramContext)
  {
    super(paramContext);
    b();
  }
  
  public VipTagView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public VipTagView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    if (!isInEditMode()) {
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, new int[] { 16843087 });
    }
    try
    {
      paramAttributeSet = paramContext.getString(0);
      paramContext.recycle();
      if (paramAttributeSet != null) {
        setLabelText(paramAttributeSet);
      }
      b();
      return;
    }
    finally
    {
      paramContext.recycle();
    }
  }
  
  private void a(int paramInt)
  {
    setBackgroundResource(2130846488);
    if ((paramInt > 0) && (paramInt <= 5))
    {
      Object localObject = getBackground();
      if ((localObject instanceof GradientDrawable))
      {
        Resources localResources = getResources();
        localObject = (GradientDrawable)localObject;
        ((GradientDrawable)localObject).mutate();
        paramInt = localResources.getDimensionPixelSize(jdField_a_of_type_ArrayOfInt[(paramInt - 1)]);
        ((GradientDrawable)localObject).setSize(paramInt, paramInt);
      }
    }
  }
  
  private void a(Canvas paramCanvas)
  {
    if (this.b)
    {
      int i = getHeight();
      int j = this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight();
      float f1 = this.jdField_a_of_type_Float;
      paramCanvas.save();
      float f2 = getWidth() - this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth();
      float f3 = i;
      float f4 = j;
      paramCanvas.translate(f2, -(i * 0.8F + j) * this.jdField_a_of_type_Float + (f3 * 0.8F + f4));
      this.jdField_a_of_type_AndroidGraphicsPaint.setAlpha((int)(255.0F - this.jdField_a_of_type_Float * 200.0F));
      paramCanvas.scale(f1, f1);
      paramCanvas.drawBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap, 0.0F, 0.0F, this.jdField_a_of_type_AndroidGraphicsPaint);
      paramCanvas.restore();
    }
  }
  
  private void b()
  {
    setClickable(true);
    Resources localResources = getResources();
    setTextSize(0, localResources.getDimensionPixelSize(2131298355));
    int i = localResources.getDimensionPixelSize(2131298360);
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(-16777216);
    this.jdField_a_of_type_AndroidGraphicsPaint.setTextSize(i);
    this.jdField_a_of_type_AndroidGraphicsPaint.setTextAlign(Paint.Align.LEFT);
    this.jdField_a_of_type_AndroidGraphicsBitmap = Bitmap.createBitmap((int)this.jdField_a_of_type_AndroidGraphicsPaint.measureText("+1"), i, Bitmap.Config.ARGB_4444);
    new Canvas(this.jdField_a_of_type_AndroidGraphicsBitmap).drawText("+1", 0.0F, i, this.jdField_a_of_type_AndroidGraphicsPaint);
    this.jdField_a_of_type_Avay = new avay(this);
    this.jdField_a_of_type_Bbkk = new bbkk(Float.valueOf(0.0F), Float.valueOf(1.0F), new avau(this));
    this.jdField_a_of_type_Bbkk.setDuration(800L);
    this.jdField_a_of_type_Bbkk.setInterpolator(new DecelerateInterpolator());
    this.jdField_a_of_type_Bbkk.setAnimationListener(new avav(this));
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_Int <= 99) {}
    for (String str1 = String.valueOf(this.jdField_a_of_type_Int);; str1 = "99+")
    {
      if ((getText() instanceof String))
      {
        String str2 = (String)getText();
        str2 = str2.substring(0, str2.indexOf('('));
        setText(str2 + "(" + str1 + ")");
      }
      return;
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_Int += 1;
    this.b = true;
    startAnimation(this.jdField_a_of_type_Bbkk);
    c();
  }
  
  public void a(bblx parambblx, float paramFloat1, float paramFloat2) {}
  
  public void a(bblx parambblx, bblz parambblz, float paramFloat1, float paramFloat2) {}
  
  public boolean a()
  {
    return this.jdField_a_of_type_Avay.a();
  }
  
  public boolean a(bblx parambblx, float paramFloat1, float paramFloat2)
  {
    bringToFront();
    this.jdField_a_of_type_Avay.b();
    return true;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    a(paramCanvas);
  }
  
  public void setLabelAndPraise(String paramString, int paramInt)
  {
    setLabelText(paramString);
    this.jdField_a_of_type_Int = paramInt;
    c();
  }
  
  public void setLabelText(String paramString)
  {
    int i = 0;
    String str = paramString;
    if (paramString.length() > 5) {
      str = paramString.substring(0, 5);
    }
    paramString = str.toCharArray();
    StringBuilder localStringBuilder = new StringBuilder();
    while (i < paramString.length)
    {
      localStringBuilder.append(paramString[i]);
      if ((str.length() > 3) && (i == 1)) {
        localStringBuilder.append('\n');
      }
      i += 1;
    }
    localStringBuilder.append("\n(0)");
    setText(localStringBuilder);
    a(str.length());
  }
  
  public void setShakingState(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Avay.a();
      return;
    }
    this.jdField_a_of_type_Avay.b();
  }
  
  public void setTagColor(int paramInt1, int paramInt2)
  {
    Object localObject = getBackground();
    if ((localObject instanceof GradientDrawable))
    {
      localObject = (GradientDrawable)localObject;
      ((GradientDrawable)localObject).setColor(paramInt2);
      ((GradientDrawable)localObject).setStroke(2, paramInt1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.profile.view.VipTagView
 * JD-Core Version:    0.7.0.1
 */