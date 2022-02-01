package com.tencent.mobileqq.qzonevip.gift.particle;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.AttributeSet;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

public class ParticleExplodeView
  extends ParticleTextureView
{
  public ParticleExplodeView(Context paramContext)
  {
    super(paramContext);
  }
  
  public ParticleExplodeView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public ParticleExplodeView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private float a(float paramFloat)
  {
    return (paramFloat - this.jdField_a_of_type_Int / 2) / 2.0F;
  }
  
  private float a(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    float f1 = this.jdField_a_of_type_Int / 2;
    float f2 = this.b / 2;
    paramFloat2 = (f2 - paramFloat2) / (f1 - paramFloat1);
    return f2 + (paramFloat3 + paramFloat1) * paramFloat2 - f1 * paramFloat2;
  }
  
  private Bitmap a(Bitmap paramBitmap1, Bitmap paramBitmap2, Bitmap paramBitmap3)
  {
    int i = a(0, 3);
    if (i == 0) {
      return paramBitmap1;
    }
    if (i == 1) {
      return paramBitmap2;
    }
    return paramBitmap3;
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3, Bitmap paramBitmap1, Bitmap paramBitmap2, Bitmap paramBitmap3)
  {
    int j = 0;
    if (j < paramInt1)
    {
      ParticleObject localParticleObject = new ParticleObject();
      localParticleObject.jdField_a_of_type_AndroidGraphicsBitmap = a(paramBitmap1, paramBitmap2, paramBitmap3);
      int i = 0;
      if (paramInt3 == 0) {
        i = a(0, 360);
      }
      for (;;)
      {
        double[] arrayOfDouble = a(paramInt2, i);
        localParticleObject.jdField_a_of_type_Float = ((float)(this.jdField_a_of_type_Int / 2 + arrayOfDouble[0]));
        localParticleObject.b = ((float)(this.b / 2 + arrayOfDouble[1]));
        localParticleObject.c = a(0, 360);
        this.jdField_a_of_type_JavaUtilArrayList.add(localParticleObject);
        j += 1;
        break;
        if (paramInt3 == 1) {
          i = a(0, 180);
        } else if (paramInt3 == 2) {
          i = a(180, 360);
        }
      }
    }
  }
  
  private double[] a(int paramInt1, int paramInt2)
  {
    return new double[] { paramInt1 * Math.cos(Math.toRadians(paramInt2)), paramInt1 * Math.sin(Math.toRadians(paramInt2)) };
  }
  
  protected int a()
  {
    return 20;
  }
  
  protected void a()
  {
    for (;;)
    {
      float f2;
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        if (!localIterator.hasNext()) {
          break;
        }
        ParticleObject localParticleObject = (ParticleObject)localIterator.next();
        if (localParticleObject == null) {
          continue;
        }
        f2 = a(localParticleObject.jdField_a_of_type_Float);
        if ((f2 > 0.0F) && (f2 < 5.0F))
        {
          f1 = 5.0F;
          localParticleObject.b = a(localParticleObject.jdField_a_of_type_Float, localParticleObject.b, f1);
          localParticleObject.jdField_a_of_type_Float = (f1 + localParticleObject.jdField_a_of_type_Float);
          localParticleObject.c += 15.0F;
          if ((localParticleObject.jdField_a_of_type_Float >= 0.0F) && (localParticleObject.jdField_a_of_type_Float <= this.jdField_a_of_type_Int) && (localParticleObject.jdField_a_of_type_Float != this.jdField_a_of_type_Int / 2)) {
            continue;
          }
          localIterator.remove();
        }
      }
      float f1 = f2;
      if (f2 > -5.0F)
      {
        f1 = f2;
        if (f2 < 0.0F) {
          f1 = -5.0F;
        }
      }
    }
  }
  
  protected void a(Bitmap[] paramArrayOfBitmap)
  {
    if ((paramArrayOfBitmap == null) || (paramArrayOfBitmap.length == 0) || (this.jdField_a_of_type_Int == 0) || (this.b == 0))
    {
      QLog.e("ParticleExplodeView", 1, "updateData: bitmap = null error");
      return;
    }
    Object localObject = this.jdField_a_of_type_JavaLangObject;
    Bitmap localBitmap1 = paramArrayOfBitmap[0];
    Bitmap localBitmap2 = paramArrayOfBitmap[1];
    paramArrayOfBitmap = paramArrayOfBitmap[2];
    try
    {
      a(5, this.jdField_a_of_type_Int / 40, 0, localBitmap1, localBitmap2, paramArrayOfBitmap);
      a(5, this.jdField_a_of_type_Int / 20, 0, localBitmap1, localBitmap2, paramArrayOfBitmap);
      a(5, this.jdField_a_of_type_Int / 10, 0, localBitmap1, localBitmap2, paramArrayOfBitmap);
      a(5, this.jdField_a_of_type_Int / 7, 0, localBitmap1, localBitmap2, paramArrayOfBitmap);
      a(5, this.jdField_a_of_type_Int / 5, 0, localBitmap1, localBitmap2, paramArrayOfBitmap);
      a(5, this.jdField_a_of_type_Int / 4, 0, localBitmap1, localBitmap2, paramArrayOfBitmap);
      a(5, this.jdField_a_of_type_Int / 3, 0, localBitmap1, localBitmap2, paramArrayOfBitmap);
      a(5, this.jdField_a_of_type_Int / 2, 1, localBitmap1, localBitmap2, paramArrayOfBitmap);
      a(5, this.jdField_a_of_type_Int / 2, 2, localBitmap1, localBitmap2, paramArrayOfBitmap);
      a(5, this.jdField_a_of_type_Int * 3 / 5, 1, localBitmap1, localBitmap2, paramArrayOfBitmap);
      a(5, this.jdField_a_of_type_Int * 3 / 5, 2, localBitmap1, localBitmap2, paramArrayOfBitmap);
      return;
    }
    finally {}
  }
  
  protected boolean a()
  {
    return false;
  }
  
  protected Bitmap[] a()
  {
    return new Bitmap[] { BitmapFactory.decodeResource(this.jdField_a_of_type_AndroidContentContext.getResources(), 2130848494), BitmapFactory.decodeResource(this.jdField_a_of_type_AndroidContentContext.getResources(), 2130848495), BitmapFactory.decodeResource(this.jdField_a_of_type_AndroidContentContext.getResources(), 2130848496) };
  }
  
  public void c()
  {
    this.jdField_a_of_type_Boolean = true;
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this, "alpha", new float[] { 1.0F, 0.0F });
    localObjectAnimator.setDuration(500L);
    localObjectAnimator.addListener(new ParticleExplodeView.1(this));
    localObjectAnimator.start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qzonevip.gift.particle.ParticleExplodeView
 * JD-Core Version:    0.7.0.1
 */