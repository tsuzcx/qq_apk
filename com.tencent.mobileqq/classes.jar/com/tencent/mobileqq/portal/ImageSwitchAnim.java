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
    jdField_a_of_type_ArrayOfInt = new int[] { 2130845296, 2130845297, 2130845298, 2130845299, 2130845300, 2130845301, 2130845302, 2130845303, 2130845304, 2130845305, 2130845306, 2130845307, 2130845308, 2130845309, 2130845310, 2130845311, 2130845312, 2130845313, 2130845314, 2130845315, 2130845316, 2130845317 };
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
          if (n >= i1) {
            break;
          }
          try
          {
            jdField_a_of_type_ArrayOfAndroidGraphicsBitmap[n] = BitmapFactory.decodeResource(paramContext.getResources(), jdField_a_of_type_ArrayOfInt[n]);
          }
          catch (OutOfMemoryError localOutOfMemoryError)
          {
            localOutOfMemoryError.printStackTrace();
          }
          n += 1;
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
    if (this.jdField_a_of_type_AndroidGraphicsBitmap == null) {
      return false;
    }
    paramCanvas.save();
    paramCanvas.translate(this.jdField_c_of_type_Int, this.d);
    paramCanvas.scale(this.jdField_a_of_type_Float, this.jdField_b_of_type_Float, this.jdField_a_of_type_Int / 2, this.jdField_b_of_type_Int / 2);
    Object localObject = this.jdField_a_of_type_AndroidGraphicsRectF;
    int n = this.e;
    float f1 = n;
    int i1 = this.f;
    ((RectF)localObject).set(f1, i1, n + this.g, i1 + this.h);
    this.jdField_a_of_type_AndroidGraphicsRect.set(0, 0, this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth(), this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight());
    paramCanvas.drawBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap, this.jdField_a_of_type_AndroidGraphicsRect, this.jdField_a_of_type_AndroidGraphicsRectF, null);
    int i2;
    int i3;
    int i4;
    if (this.jdField_c_of_type_AndroidGraphicsBitmap != null)
    {
      localObject = this.jdField_a_of_type_AndroidGraphicsRect;
      n = this.jdField_a_of_type_Int;
      i1 = this.k;
      i2 = this.i;
      i3 = this.jdField_b_of_type_Int;
      i4 = this.l;
      ((Rect)localObject).set(n - i1 - i2, i3 - i4 - this.j, n - i1, i3 - i4);
      paramCanvas.drawBitmap(this.jdField_c_of_type_AndroidGraphicsBitmap, null, this.jdField_a_of_type_AndroidGraphicsRect, null);
    }
    if (this.jdField_a_of_type_Boolean)
    {
      long l2 = System.currentTimeMillis() - this.jdField_a_of_type_Long;
      if (l2 >= 440L) {
        this.jdField_a_of_type_AndroidGraphicsBitmap = this.jdField_b_of_type_AndroidGraphicsBitmap;
      }
      long l1 = l2;
      if (l2 >= 880L)
      {
        b();
        l1 = 880L;
      }
      this.m = ((int)(l1 / 40L));
      n = this.m;
      localObject = jdField_a_of_type_ArrayOfInt;
      if (n >= localObject.length) {
        this.m = (n % localObject.length);
      }
      n = this.g;
      i1 = (int)(n * 0.35F / 2.0F);
      i2 = this.h;
      i3 = (int)(i2 * 0.35F / 2.0F);
      localObject = this.jdField_a_of_type_AndroidGraphicsRectF;
      i4 = this.e;
      f1 = i4 - i1;
      int i5 = this.f;
      ((RectF)localObject).set(f1, i5 - i3, i4 + i1 + n, i5 + i2 + i3);
      localObject = jdField_a_of_type_ArrayOfAndroidGraphicsBitmap;
      n = this.m;
      if (localObject[n] != null)
      {
        this.jdField_a_of_type_AndroidGraphicsRect.set(0, 0, localObject[n].getWidth(), jdField_a_of_type_ArrayOfAndroidGraphicsBitmap[this.m].getHeight());
        paramCanvas.drawBitmap(jdField_a_of_type_ArrayOfAndroidGraphicsBitmap[this.m], this.jdField_a_of_type_AndroidGraphicsRect, this.jdField_a_of_type_AndroidGraphicsRectF, null);
      }
      paramCanvas.restore();
      return true;
    }
    paramCanvas.restore();
    return false;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.portal.ImageSwitchAnim
 * JD-Core Version:    0.7.0.1
 */