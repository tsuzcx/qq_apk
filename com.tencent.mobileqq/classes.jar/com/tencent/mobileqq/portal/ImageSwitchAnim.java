package com.tencent.mobileqq.portal;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;

public class ImageSwitchAnim
{
  public static int[] a;
  public static Bitmap[] a;
  public float a;
  public int a;
  long jdField_a_of_type_Long;
  public Bitmap a;
  private Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint();
  private Rect jdField_a_of_type_AndroidGraphicsRect = new Rect();
  private RectF jdField_a_of_type_AndroidGraphicsRectF = new RectF();
  boolean jdField_a_of_type_Boolean = false;
  public float b;
  public int b;
  public Bitmap b;
  public int c;
  Bitmap c;
  public int d;
  public int e;
  public int f;
  public int g;
  public int h;
  public int i;
  public int j;
  public int k = 0;
  public int l = 0;
  int m = 0;
  
  static
  {
    jdField_a_of_type_ArrayOfInt = new int[] { 2130845423, 2130845424, 2130845425, 2130845426, 2130845427, 2130845428, 2130845429, 2130845430, 2130845431, 2130845432, 2130845433, 2130845434, 2130845435, 2130845436, 2130845437, 2130845438, 2130845439, 2130845440, 2130845441, 2130845442, 2130845443, 2130845444 };
    jdField_a_of_type_ArrayOfAndroidGraphicsBitmap = null;
  }
  
  public ImageSwitchAnim(Context paramContext, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    this.jdField_a_of_type_Float = 1.0F;
    this.jdField_b_of_type_Float = 1.0F;
    this.jdField_c_of_type_AndroidGraphicsBitmap = null;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    this.h = paramInt8;
    this.g = paramInt7;
    this.jdField_c_of_type_Int = paramInt3;
    this.d = paramInt4;
    this.e = paramInt5;
    this.f = paramInt6;
    a(paramContext);
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = true;
    this.m = 0;
    this.jdField_a_of_type_Long = System.currentTimeMillis();
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    this.h = paramInt8;
    this.g = paramInt7;
    this.jdField_c_of_type_Int = paramInt3;
    this.d = paramInt4;
    this.e = paramInt5;
    this.f = paramInt6;
  }
  
  public void a(Context paramContext)
  {
    if (jdField_a_of_type_ArrayOfAndroidGraphicsBitmap == null)
    {
      jdField_a_of_type_ArrayOfAndroidGraphicsBitmap = new Bitmap[jdField_a_of_type_ArrayOfInt.length];
      int n = 0;
      try
      {
        for (;;)
        {
          int i1 = jdField_a_of_type_ArrayOfInt.length;
          if (n < i1) {
            try
            {
              jdField_a_of_type_ArrayOfAndroidGraphicsBitmap[n] = BitmapFactory.decodeResource(paramContext.getResources(), jdField_a_of_type_ArrayOfInt[n]);
              n += 1;
            }
            catch (OutOfMemoryError localOutOfMemoryError)
            {
              for (;;)
              {
                localOutOfMemoryError.printStackTrace();
              }
            }
          }
        }
        return;
      }
      catch (OutOfMemoryError paramContext)
      {
        paramContext.printStackTrace();
        this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
      }
    }
  }
  
  public void a(Bitmap paramBitmap)
  {
    if (this.jdField_a_of_type_AndroidGraphicsBitmap == null)
    {
      this.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap;
      this.jdField_b_of_type_AndroidGraphicsBitmap = paramBitmap;
      return;
    }
    this.jdField_b_of_type_AndroidGraphicsBitmap = paramBitmap;
  }
  
  public boolean a(Canvas paramCanvas)
  {
    long l1 = 880L;
    if (this.jdField_a_of_type_AndroidGraphicsBitmap == null) {
      return false;
    }
    paramCanvas.save();
    paramCanvas.translate(this.jdField_c_of_type_Int, this.d);
    paramCanvas.scale(this.jdField_a_of_type_Float, this.jdField_b_of_type_Float, this.jdField_a_of_type_Int / 2, this.jdField_b_of_type_Int / 2);
    this.jdField_a_of_type_AndroidGraphicsRectF.set(this.e, this.f, this.e + this.g, this.f + this.h);
    this.jdField_a_of_type_AndroidGraphicsRect.set(0, 0, this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth(), this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight());
    paramCanvas.drawBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap, this.jdField_a_of_type_AndroidGraphicsRect, this.jdField_a_of_type_AndroidGraphicsRectF, null);
    if (this.jdField_c_of_type_AndroidGraphicsBitmap != null)
    {
      this.jdField_a_of_type_AndroidGraphicsRect.set(this.jdField_a_of_type_Int - this.k - this.i, this.jdField_b_of_type_Int - this.l - this.j, this.jdField_a_of_type_Int - this.k, this.jdField_b_of_type_Int - this.l);
      paramCanvas.drawBitmap(this.jdField_c_of_type_AndroidGraphicsBitmap, null, this.jdField_a_of_type_AndroidGraphicsRect, null);
    }
    long l2;
    if (this.jdField_a_of_type_Boolean)
    {
      l2 = System.currentTimeMillis() - this.jdField_a_of_type_Long;
      if (l2 >= 440L) {
        this.jdField_a_of_type_AndroidGraphicsBitmap = this.jdField_b_of_type_AndroidGraphicsBitmap;
      }
      if (l2 < 880L) {
        break label436;
      }
      b();
    }
    for (;;)
    {
      this.m = ((int)(l1 / 40L));
      if (this.m >= jdField_a_of_type_ArrayOfInt.length) {
        this.m %= jdField_a_of_type_ArrayOfInt.length;
      }
      int n = (int)(this.g * 0.35F / 2.0F);
      int i1 = (int)(this.h * 0.35F / 2.0F);
      this.jdField_a_of_type_AndroidGraphicsRectF.set(this.e - n, this.f - i1, n + this.e + this.g, i1 + (this.f + this.h));
      if (jdField_a_of_type_ArrayOfAndroidGraphicsBitmap[this.m] != null)
      {
        this.jdField_a_of_type_AndroidGraphicsRect.set(0, 0, jdField_a_of_type_ArrayOfAndroidGraphicsBitmap[this.m].getWidth(), jdField_a_of_type_ArrayOfAndroidGraphicsBitmap[this.m].getHeight());
        paramCanvas.drawBitmap(jdField_a_of_type_ArrayOfAndroidGraphicsBitmap[this.m], this.jdField_a_of_type_AndroidGraphicsRect, this.jdField_a_of_type_AndroidGraphicsRectF, null);
      }
      paramCanvas.restore();
      return true;
      paramCanvas.restore();
      return false;
      label436:
      l1 = l2;
    }
  }
  
  public void b()
  {
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void b(Bitmap paramBitmap)
  {
    this.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap;
    this.jdField_b_of_type_AndroidGraphicsBitmap = paramBitmap;
  }
  
  public void c(Bitmap paramBitmap)
  {
    this.jdField_c_of_type_AndroidGraphicsBitmap = paramBitmap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.portal.ImageSwitchAnim
 * JD-Core Version:    0.7.0.1
 */