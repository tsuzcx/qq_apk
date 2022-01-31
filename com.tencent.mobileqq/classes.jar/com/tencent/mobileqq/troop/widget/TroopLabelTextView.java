package com.tencent.mobileqq.troop.widget;

import aekt;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.drawable.GradientDrawable;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import bhxo;
import bhxp;
import com.tencent.qphone.base.util.QLog;

public class TroopLabelTextView
  extends TextView
  implements bhxp
{
  protected int a;
  private Context jdField_a_of_type_AndroidContentContext;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private Canvas jdField_a_of_type_AndroidGraphicsCanvas;
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  private PorterDuffXfermode jdField_a_of_type_AndroidGraphicsPorterDuffXfermode;
  public bhxo a;
  int jdField_b_of_type_Int;
  private Bitmap jdField_b_of_type_AndroidGraphicsBitmap;
  private int c;
  private int d;
  
  public TroopLabelTextView(Context paramContext, int paramInt1, int paramInt2, int paramInt3)
  {
    super(paramContext);
    this.jdField_a_of_type_Int = paramInt1;
    setTextColor(paramInt2);
    setMaxLines(1);
    setGravity(17);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, aekt.a(16.0F, getResources()));
    localLayoutParams.rightMargin = 4;
    paramInt2 = aekt.a(4.0F, getResources());
    int i = aekt.a(4.0F, getResources());
    int j = aekt.a(0.0F, getResources());
    int k = aekt.a(0.0F, getResources());
    setTextSize(1, 10.0F);
    if (paramInt3 == 2) {
      paramInt1 = aekt.a(10.0F, getResources());
    }
    for (;;)
    {
      setLayoutParams(localLayoutParams);
      setPadding(paramInt1, j, i, k);
      this.jdField_a_of_type_AndroidContentContext = paramContext;
      this.c = paramInt3;
      this.jdField_b_of_type_Int = aekt.a(2.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      this.d = aekt.a(5.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      a();
      return;
      paramInt1 = paramInt2;
      if (paramInt3 == 1)
      {
        setIncludeFontPadding(false);
        localLayoutParams.height = aekt.a(14.0F, getResources());
        paramInt1 = paramInt2;
      }
    }
  }
  
  private void a()
  {
    this.jdField_a_of_type_Bhxo = new bhxo();
    this.jdField_a_of_type_Bhxo.a(true);
    this.jdField_a_of_type_Bhxo.a(bhxo.c);
  }
  
  public void a_(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
  }
  
  public void draw(Canvas paramCanvas)
  {
    this.jdField_a_of_type_Bhxo.a(paramCanvas, this);
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    if ((this.c == 2) && (this.jdField_a_of_type_AndroidGraphicsBitmap != null))
    {
      this.jdField_a_of_type_AndroidGraphicsPaint.setXfermode(this.jdField_a_of_type_AndroidGraphicsPorterDuffXfermode);
      this.jdField_a_of_type_AndroidGraphicsCanvas.drawColor(this.jdField_a_of_type_Int);
      this.jdField_a_of_type_AndroidGraphicsCanvas.drawBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap, 0.0F, 0.0F, this.jdField_a_of_type_AndroidGraphicsPaint);
      this.jdField_a_of_type_AndroidGraphicsPaint.setXfermode(null);
      paramCanvas.drawBitmap(this.jdField_b_of_type_AndroidGraphicsBitmap, 0.0F, 0.0F, this.jdField_a_of_type_AndroidGraphicsPaint);
    }
    super.onDraw(paramCanvas);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3 + (getPaddingLeft() + getPaddingRight()), paramInt4);
    GradientDrawable localGradientDrawable = new GradientDrawable();
    if (this.c == 1)
    {
      localGradientDrawable.setColor(this.jdField_a_of_type_Int);
      localGradientDrawable.setCornerRadius(this.jdField_b_of_type_Int);
      setBackgroundDrawable(localGradientDrawable);
    }
    do
    {
      return;
      if (this.c == 0)
      {
        localGradientDrawable.setStroke(2, this.jdField_a_of_type_Int);
        localGradientDrawable.setCornerRadius(getHeight() / 2);
        setBackgroundDrawable(localGradientDrawable);
        return;
      }
    } while (this.c != 2);
  }
  
  public void setColor(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Int = paramInt1;
    setTextColor(paramInt2);
  }
  
  public void setMaskImage(int paramInt)
  {
    try
    {
      this.jdField_a_of_type_AndroidGraphicsBitmap = BitmapFactory.decodeResource(getResources(), paramInt);
      this.jdField_b_of_type_AndroidGraphicsBitmap = Bitmap.createBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth(), this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight(), Bitmap.Config.ARGB_8888);
      this.jdField_a_of_type_AndroidGraphicsCanvas = new Canvas(this.jdField_b_of_type_AndroidGraphicsBitmap);
      this.jdField_a_of_type_AndroidGraphicsPaint = new Paint(1);
      this.jdField_a_of_type_AndroidGraphicsPorterDuffXfermode = new PorterDuffXfermode(PorterDuff.Mode.DST_IN);
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("TroopLabelTextView", 2, "TroopLabelTextView setMaskImage OOM");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.TroopLabelTextView
 * JD-Core Version:    0.7.0.1
 */