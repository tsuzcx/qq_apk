package com.tencent.mobileqq.portal;

import aepi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.view.View;
import awnl;
import java.util.ArrayList;

public class SanHuaView
  extends View
{
  float jdField_a_of_type_Float;
  int jdField_a_of_type_Int;
  long jdField_a_of_type_Long;
  Resources jdField_a_of_type_AndroidContentResResources = getResources();
  Matrix jdField_a_of_type_AndroidGraphicsMatrix = new Matrix();
  ArrayList<awnl> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  boolean jdField_a_of_type_Boolean = false;
  private int[] jdField_a_of_type_ArrayOfInt = { 2130844873, 2130844874, 2130844875, 2130844876, 2130844877, 2130844878, 2130844879, 2130844880 };
  private Bitmap[] jdField_a_of_type_ArrayOfAndroidGraphicsBitmap = new Bitmap[this.jdField_a_of_type_ArrayOfInt.length];
  float jdField_b_of_type_Float;
  int jdField_b_of_type_Int;
  int c;
  
  public SanHuaView(Context paramContext, int paramInt1, int paramInt2)
  {
    super(paramContext);
    this.jdField_a_of_type_Float = paramInt1;
    this.jdField_b_of_type_Float = paramInt2;
    paramInt1 = i;
    try
    {
      while (paramInt1 < this.jdField_a_of_type_ArrayOfAndroidGraphicsBitmap.length)
      {
        this.jdField_a_of_type_ArrayOfAndroidGraphicsBitmap[paramInt1] = BitmapFactory.decodeResource(this.jdField_a_of_type_AndroidContentResResources, this.jdField_a_of_type_ArrayOfInt[paramInt1]);
        paramInt1 += 1;
      }
      return;
    }
    catch (OutOfMemoryError paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    invalidate();
  }
  
  public void a(int paramInt)
  {
    int i = 0;
    while (i < paramInt)
    {
      int j = (int)(this.jdField_a_of_type_ArrayOfAndroidGraphicsBitmap.length * Math.random());
      if (this.jdField_a_of_type_ArrayOfAndroidGraphicsBitmap[j] != null) {
        this.jdField_a_of_type_JavaUtilArrayList.add(awnl.a(this.jdField_a_of_type_ArrayOfAndroidGraphicsBitmap[j], this.jdField_a_of_type_Float, this.jdField_b_of_type_Float, this.jdField_a_of_type_AndroidContentResResources));
      }
      i += 1;
    }
    this.jdField_a_of_type_Int += paramInt;
  }
  
  public void b()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_a_of_type_Int = 0;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if (!this.jdField_a_of_type_Boolean) {}
    do
    {
      return;
      super.onDraw(paramCanvas);
      float f1 = (float)(System.currentTimeMillis() - this.jdField_a_of_type_Long) / 1000.0F;
      int i = 0;
      awnl localawnl;
      if (i < this.jdField_a_of_type_Int)
      {
        localawnl = (awnl)this.jdField_a_of_type_JavaUtilArrayList.get(i);
        if (localawnl == null) {}
        for (;;)
        {
          i += 1;
          break;
          float f2;
          float f3;
          float f4;
          if (localawnl.jdField_a_of_type_Double < 0.0D)
          {
            f2 = localawnl.c;
            f3 = localawnl.d;
            f4 = aepi.a(270.0F, this.jdField_a_of_type_AndroidContentResResources);
            localawnl.jdField_a_of_type_ArrayOfFloat[0] = (this.jdField_a_of_type_Float - f2 * f1);
            localawnl.jdField_a_of_type_ArrayOfFloat[1] = (this.jdField_b_of_type_Float + (f3 * f1 + f4 * 0.5F * f1 * f1));
          }
          else
          {
            f2 = localawnl.c;
            f3 = localawnl.d;
            f4 = aepi.a(270.0F, this.jdField_a_of_type_AndroidContentResResources);
            localawnl.jdField_a_of_type_ArrayOfFloat[0] = (f2 * f1 + this.jdField_a_of_type_Float);
            localawnl.jdField_a_of_type_ArrayOfFloat[1] = (this.jdField_b_of_type_Float - (f3 * f1 - f4 * 0.5F * f1 * f1));
          }
        }
      }
      i = 0;
      int j = 0;
      if (i < this.jdField_a_of_type_Int)
      {
        localawnl = (awnl)this.jdField_a_of_type_JavaUtilArrayList.get(i);
        int k;
        if (localawnl == null) {
          k = j;
        }
        for (;;)
        {
          i += 1;
          j = k;
          break;
          k = j;
          if (localawnl.jdField_a_of_type_ArrayOfFloat[0] < this.jdField_b_of_type_Int)
          {
            k = j;
            if (localawnl.jdField_a_of_type_ArrayOfFloat[0] > 0.0F)
            {
              k = j;
              if (localawnl.jdField_a_of_type_ArrayOfFloat[1] < this.c)
              {
                k = j;
                if (localawnl.jdField_a_of_type_ArrayOfFloat[1] > 0.0F)
                {
                  this.jdField_a_of_type_AndroidGraphicsMatrix.setTranslate(-localawnl.jdField_a_of_type_Int / 2, -localawnl.jdField_b_of_type_Int / 2);
                  this.jdField_a_of_type_AndroidGraphicsMatrix.postRotate(localawnl.jdField_a_of_type_Float);
                  this.jdField_a_of_type_AndroidGraphicsMatrix.postTranslate(localawnl.jdField_a_of_type_Int / 2 + localawnl.jdField_a_of_type_ArrayOfFloat[0], localawnl.jdField_b_of_type_Int / 2 + localawnl.jdField_a_of_type_ArrayOfFloat[1]);
                  paramCanvas.drawBitmap(localawnl.jdField_a_of_type_AndroidGraphicsBitmap, this.jdField_a_of_type_AndroidGraphicsMatrix, null);
                  k = j + 1;
                }
              }
            }
          }
        }
      }
      if (j == 0) {
        b();
      }
    } while (!this.jdField_a_of_type_Boolean);
    invalidate();
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.jdField_b_of_type_Int = paramInt1;
    this.c = paramInt2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.portal.SanHuaView
 * JD-Core Version:    0.7.0.1
 */