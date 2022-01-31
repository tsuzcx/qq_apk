package com.tencent.mobileqq.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.os.Build;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import aoks;
import benn;
import bhtb;

public class BubbleVideoView
  extends BubbleImageView
{
  private static benn a;
  private Bitmap b;
  private boolean c;
  
  public BubbleVideoView(Context paramContext)
  {
    super(paramContext);
  }
  
  public BubbleVideoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public BubbleVideoView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void b(Canvas paramCanvas)
  {
    if (jdField_a_of_type_Benn != null) {
      jdField_a_of_type_Benn.a(this, paramCanvas);
    }
  }
  
  public static void setDrawListener(benn parambenn)
  {
    jdField_a_of_type_Benn = parambenn;
  }
  
  protected void a()
  {
    String str = Build.MODEL.toUpperCase();
    if ((str.contains("M821")) || (str.contains("A0001"))) {
      this.jdField_a_of_type_Int = 2;
    }
  }
  
  protected void a(Canvas paramCanvas)
  {
    if (a())
    {
      if ((this.jdField_b_of_type_AndroidGraphicsBitmap != null) && ((this.jdField_b_of_type_AndroidGraphicsBitmap.getWidth() != getWidth()) || (this.jdField_b_of_type_AndroidGraphicsBitmap.getHeight() != getHeight())))
      {
        this.jdField_b_of_type_AndroidGraphicsBitmap.recycle();
        this.jdField_b_of_type_AndroidGraphicsBitmap = null;
      }
      if (this.jdField_b_of_type_AndroidGraphicsBitmap == null) {}
      try
      {
        this.jdField_b_of_type_AndroidGraphicsBitmap = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.ARGB_8888);
        if (this.jdField_b_of_type_AndroidGraphicsBitmap != null)
        {
          Canvas localCanvas = new Canvas(this.jdField_b_of_type_AndroidGraphicsBitmap);
          localCanvas.setDensity(getResources().getDisplayMetrics().densityDpi);
          Paint localPaint = new Paint(1);
          localPaint.setColor(-16777216);
          localCanvas.drawPath(this.jdField_c_of_type_AndroidGraphicsPath, localPaint);
          if (this.jdField_b_of_type_AndroidGraphicsBitmap.getPixel(this.jdField_b_of_type_AndroidGraphicsBitmap.getWidth() >> 1, this.jdField_b_of_type_AndroidGraphicsBitmap.getHeight() >> 1) != -16777216)
          {
            localPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_OUT));
            localCanvas.drawRect(0.0F, 0.0F, this.jdField_b_of_type_AndroidGraphicsBitmap.getWidth(), this.jdField_b_of_type_AndroidGraphicsBitmap.getHeight(), localPaint);
            this.jdField_b_of_type_AndroidGraphicsPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
          }
        }
        if (this.jdField_b_of_type_AndroidGraphicsBitmap != null) {
          paramCanvas.drawBitmap(this.jdField_b_of_type_AndroidGraphicsBitmap, 0.0F, 0.0F, this.jdField_b_of_type_AndroidGraphicsPaint);
        }
        return;
      }
      catch (OutOfMemoryError localOutOfMemoryError1)
      {
        for (;;)
        {
          try
          {
            this.jdField_b_of_type_AndroidGraphicsBitmap = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.ARGB_4444);
          }
          catch (OutOfMemoryError localOutOfMemoryError2)
          {
            try
            {
              this.jdField_b_of_type_AndroidGraphicsBitmap = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.ARGB_4444);
            }
            catch (OutOfMemoryError localOutOfMemoryError3) {}
          }
        }
      }
    }
    super.a(paramCanvas);
  }
  
  public boolean a()
  {
    return this.jdField_c_of_type_Boolean;
  }
  
  protected void b()
  {
    this.e = f;
    int i;
    if (bhtb.e())
    {
      this.jdField_a_of_type_Int = 1;
      a();
      this.jdField_a_of_type_AndroidContentResResources = getResources();
      if (Build.VERSION.SDK_INT >= 28)
      {
        this.g = true;
        Object localObject = (String)aoks.a().a(462);
        if ((localObject != null) && (((String)localObject).length() > 0))
        {
          localObject = ((String)localObject).split("\\|");
          if ((localObject != null) && (localObject.length > 0))
          {
            String str = Build.MODEL.toUpperCase();
            int j = localObject.length;
            i = 0;
            label96:
            if (i < j)
            {
              CharSequence localCharSequence = localObject[i];
              if ((localCharSequence == null) || (localCharSequence.length() <= 0) || (!str.contains(localCharSequence))) {
                break label252;
              }
              this.g = false;
            }
          }
        }
      }
      if (this.jdField_a_of_type_Int != 1) {
        break label280;
      }
      this.jdField_b_of_type_AndroidGraphicsPaint = new Paint();
      this.jdField_b_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
      this.jdField_b_of_type_AndroidGraphicsPaint.setAntiAlias(true);
      this.jdField_b_of_type_AndroidGraphicsPaint.setFilterBitmap(true);
      this.jdField_b_of_type_AndroidGraphicsPaint.setColor(-16777216);
      if (!this.g) {
        break label259;
      }
      this.jdField_b_of_type_AndroidGraphicsPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_OUT));
      this.jdField_c_of_type_AndroidGraphicsPath = new Path();
      this.jdField_c_of_type_AndroidGraphicsRectF = new RectF();
      this.jdField_b_of_type_ArrayOfFloat = new float[8];
    }
    label252:
    while (this.jdField_a_of_type_Int != 2) {
      for (;;)
      {
        return;
        this.jdField_a_of_type_Int = 2;
        break;
        i += 1;
        break label96;
        this.jdField_b_of_type_AndroidGraphicsPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
      }
    }
    label259:
    label280:
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidGraphicsPaint.setFilterBitmap(true);
    this.jdField_a_of_type_AndroidGraphicsRectF = new RectF();
    this.jdField_b_of_type_AndroidGraphicsRectF = new RectF();
    this.jdField_c_of_type_AndroidGraphicsPath = new Path();
    this.jdField_c_of_type_AndroidGraphicsRectF = new RectF();
    this.jdField_b_of_type_ArrayOfFloat = new float[8];
  }
  
  public void draw(Canvas paramCanvas)
  {
    b(paramCanvas);
    super.draw(paramCanvas);
  }
  
  public void setUseXfermodeBitmap(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.BubbleVideoView
 * JD-Core Version:    0.7.0.1
 */