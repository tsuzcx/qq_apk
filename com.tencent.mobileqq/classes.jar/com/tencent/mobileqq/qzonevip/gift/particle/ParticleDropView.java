package com.tencent.mobileqq.qzonevip.gift.particle;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import bazv;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

public class ParticleDropView
  extends ParticleTextureView
{
  private Bitmap a;
  private int d;
  
  public ParticleDropView(Context paramContext)
  {
    super(paramContext);
  }
  
  public ParticleDropView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public ParticleDropView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected int a()
  {
    return 0;
  }
  
  protected void a()
  {
    for (;;)
    {
      bazv localbazv;
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        if (!localIterator.hasNext()) {
          break;
        }
        localbazv = (bazv)localIterator.next();
        if (localbazv == null) {
          continue;
        }
        if (localbazv.d > 0.75F)
        {
          localbazv.jdField_b_of_type_Float += 13.0F;
          if (!localbazv.jdField_a_of_type_Boolean)
          {
            localbazv.jdField_b_of_type_Int = a(-1, 1);
            localbazv.jdField_a_of_type_Boolean = true;
          }
          if (localbazv.jdField_b_of_type_Int == 0) {
            localbazv.jdField_b_of_type_Int = 1;
          }
          localbazv.jdField_a_of_type_Float += localbazv.jdField_b_of_type_Int;
          a(localbazv);
          if ((localbazv.jdField_a_of_type_Int != 0) && (localbazv.jdField_b_of_type_Float < this.jdField_b_of_type_Int)) {
            continue;
          }
          localIterator.remove();
        }
      }
      localbazv.jdField_b_of_type_Float += 8.0F;
    }
  }
  
  public void a(bazv parambazv)
  {
    int j = 255;
    long l1 = System.currentTimeMillis() - parambazv.jdField_a_of_type_Long;
    long l2 = parambazv.jdField_b_of_type_Long;
    int i;
    if (l1 <= parambazv.jdField_b_of_type_Long / 4L)
    {
      i = (int)((float)(l1 - l2 / 4L) * 255.0F / (float)(l2 / 4L) + 255.0F);
      if (i <= 255) {
        break label159;
      }
      i = j;
    }
    label159:
    for (;;)
    {
      j = i;
      if (i < 0) {
        j = 0;
      }
      parambazv.jdField_a_of_type_Int = j;
      return;
      if ((l1 >= parambazv.jdField_b_of_type_Long / 4L) && (l1 < parambazv.jdField_b_of_type_Long * 3L / 4L))
      {
        i = 255;
        break;
      }
      i = (int)((float)(l2 * 3L / 4L - l1) * 255.0F / (float)(l2 * 3L / 4L) + 255.0F);
      break;
    }
  }
  
  protected void a(Bitmap[] paramArrayOfBitmap)
  {
    int i = 4;
    int j = 0;
    if ((paramArrayOfBitmap == null) || (paramArrayOfBitmap.length == 0) || (this.jdField_a_of_type_Int == 0) || (this.jdField_b_of_type_Int == 0))
    {
      QLog.e("ParticleDropView", 1, "addData: bitmap = null error");
      return;
    }
    Bitmap localBitmap = paramArrayOfBitmap[0];
    this.d += 1;
    if (this.d < 3) {
      i = a(2, 4);
    }
    paramArrayOfBitmap = this.jdField_a_of_type_JavaLangObject;
    for (;;)
    {
      if (j < i) {}
      bazv localbazv;
      try
      {
        localbazv = new bazv();
        localbazv.jdField_a_of_type_AndroidGraphicsBitmap = localBitmap;
        localbazv.jdField_b_of_type_Long = a(2000, 3500);
        localbazv.jdField_a_of_type_Float = (a(0, this.jdField_a_of_type_Int + 100) - 100);
        localbazv.jdField_b_of_type_Float = (a(0, this.jdField_b_of_type_Int * 4 / 5) - 200);
        localbazv.jdField_a_of_type_Int = 0;
        localbazv.d = a(0.15F, 0.75F);
        localbazv.jdField_b_of_type_Float -= 300.0F;
        localbazv.c = a(0, 360);
        this.jdField_a_of_type_JavaUtilArrayList.add(localbazv);
        j += 1;
      }
      finally {}
    }
    if (this.d % 2 == 0)
    {
      localbazv = new bazv();
      localbazv.jdField_a_of_type_AndroidGraphicsBitmap = localBitmap;
      localbazv.jdField_b_of_type_Long = a(2000, 3500);
      localbazv.jdField_a_of_type_Float = (a(0, this.jdField_a_of_type_Int + 100) - 100);
      localbazv.jdField_b_of_type_Float = (a(0, 100) - 300);
      localbazv.jdField_a_of_type_Int = 0;
      localbazv.c = a(0, 360);
      this.jdField_a_of_type_JavaUtilArrayList.add(localbazv);
    }
  }
  
  protected boolean a()
  {
    return (this.c % 40 == 0) && (!this.jdField_a_of_type_Boolean);
  }
  
  protected Bitmap[] a()
  {
    return new Bitmap[] { this.jdField_a_of_type_AndroidGraphicsBitmap };
  }
  
  public void b()
  {
    super.b();
    setAlpha(1.0F);
  }
  
  public void c()
  {
    super.c();
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      return;
    }
  }
  
  public void setBitmap(Bitmap paramBitmap)
  {
    this.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qzonevip.gift.particle.ParticleDropView
 * JD-Core Version:    0.7.0.1
 */