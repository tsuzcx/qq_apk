package com.tencent.mobileqq.portal;

import aekt;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.view.View;
import awjc;
import java.util.ArrayList;

public class SanHuaView
  extends View
{
  float jdField_a_of_type_Float;
  int jdField_a_of_type_Int;
  long jdField_a_of_type_Long;
  Resources jdField_a_of_type_AndroidContentResResources = getResources();
  Matrix jdField_a_of_type_AndroidGraphicsMatrix = new Matrix();
  ArrayList<awjc> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  boolean jdField_a_of_type_Boolean = false;
  private int[] jdField_a_of_type_ArrayOfInt = { 2130844801, 2130844802, 2130844803, 2130844804, 2130844805, 2130844806, 2130844807, 2130844808 };
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
        this.jdField_a_of_type_JavaUtilArrayList.add(awjc.a(this.jdField_a_of_type_ArrayOfAndroidGraphicsBitmap[j], this.jdField_a_of_type_Float, this.jdField_b_of_type_Float, this.jdField_a_of_type_AndroidContentResResources));
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
      awjc localawjc;
      if (i < this.jdField_a_of_type_Int)
      {
        localawjc = (awjc)this.jdField_a_of_type_JavaUtilArrayList.get(i);
        if (localawjc == null) {}
        for (;;)
        {
          i += 1;
          break;
          float f2;
          float f3;
          float f4;
          if (localawjc.jdField_a_of_type_Double < 0.0D)
          {
            f2 = localawjc.c;
            f3 = localawjc.d;
            f4 = aekt.a(270.0F, this.jdField_a_of_type_AndroidContentResResources);
            localawjc.jdField_a_of_type_ArrayOfFloat[0] = (this.jdField_a_of_type_Float - f2 * f1);
            localawjc.jdField_a_of_type_ArrayOfFloat[1] = (this.jdField_b_of_type_Float + (f3 * f1 + f4 * 0.5F * f1 * f1));
          }
          else
          {
            f2 = localawjc.c;
            f3 = localawjc.d;
            f4 = aekt.a(270.0F, this.jdField_a_of_type_AndroidContentResResources);
            localawjc.jdField_a_of_type_ArrayOfFloat[0] = (f2 * f1 + this.jdField_a_of_type_Float);
            localawjc.jdField_a_of_type_ArrayOfFloat[1] = (this.jdField_b_of_type_Float - (f3 * f1 - f4 * 0.5F * f1 * f1));
          }
        }
      }
      i = 0;
      int j = 0;
      if (i < this.jdField_a_of_type_Int)
      {
        localawjc = (awjc)this.jdField_a_of_type_JavaUtilArrayList.get(i);
        int k;
        if (localawjc == null) {
          k = j;
        }
        for (;;)
        {
          i += 1;
          j = k;
          break;
          k = j;
          if (localawjc.jdField_a_of_type_ArrayOfFloat[0] < this.jdField_b_of_type_Int)
          {
            k = j;
            if (localawjc.jdField_a_of_type_ArrayOfFloat[0] > 0.0F)
            {
              k = j;
              if (localawjc.jdField_a_of_type_ArrayOfFloat[1] < this.c)
              {
                k = j;
                if (localawjc.jdField_a_of_type_ArrayOfFloat[1] > 0.0F)
                {
                  this.jdField_a_of_type_AndroidGraphicsMatrix.setTranslate(-localawjc.jdField_a_of_type_Int / 2, -localawjc.jdField_b_of_type_Int / 2);
                  this.jdField_a_of_type_AndroidGraphicsMatrix.postRotate(localawjc.jdField_a_of_type_Float);
                  this.jdField_a_of_type_AndroidGraphicsMatrix.postTranslate(localawjc.jdField_a_of_type_Int / 2 + localawjc.jdField_a_of_type_ArrayOfFloat[0], localawjc.jdField_b_of_type_Int / 2 + localawjc.jdField_a_of_type_ArrayOfFloat[1]);
                  paramCanvas.drawBitmap(localawjc.jdField_a_of_type_AndroidGraphicsBitmap, this.jdField_a_of_type_AndroidGraphicsMatrix, null);
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