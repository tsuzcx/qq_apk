package com.tencent.mobileqq.portal;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.Transformation;
import java.util.ArrayList;
import java.util.Iterator;

public class BaseAnimHolder
{
  public float a;
  public Drawable a;
  public Transformation a;
  public ArrayList<Animation> a;
  public float b = 1.0F;
  public int j = 0;
  public int k = 0;
  public int l;
  public int m;
  public int n = 255;
  
  public BaseAnimHolder()
  {
    this.jdField_a_of_type_AndroidViewAnimationTransformation = new Transformation();
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = null;
    this.jdField_a_of_type_Float = 1.0F;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, View paramView)
  {
    this.j = paramInt1;
    this.k = paramInt2;
    this.l = paramInt3;
    this.m = paramInt4;
  }
  
  public void a(Animation paramAnimation)
  {
    this.jdField_a_of_type_JavaUtilArrayList.add(paramAnimation);
    paramAnimation.start();
  }
  
  public boolean a(Canvas paramCanvas)
  {
    if ((this.n != 0) && (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null))
    {
      paramCanvas.save();
      paramCanvas.translate(this.j, this.k);
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setAlpha(this.n);
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(0, 0, this.l, this.m);
      paramCanvas.scale(this.jdField_a_of_type_Float, this.b, this.l / 2, this.m / 2);
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.draw(paramCanvas);
      paramCanvas.restore();
    }
    paramCanvas = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    for (boolean bool = false;; bool = true)
    {
      if (!paramCanvas.hasNext()) {
        return bool;
      }
      Animation localAnimation = (Animation)paramCanvas.next();
      if ((!bool) && (!localAnimation.getTransformation(AnimationUtils.currentAnimationTimeMillis(), this.jdField_a_of_type_AndroidViewAnimationTransformation))) {
        break;
      }
    }
    return bool;
  }
  
  public void b()
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
  }
  
  public boolean b()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    for (boolean bool = false;; bool = true)
    {
      if (!localIterator.hasNext()) {
        return bool;
      }
      Animation localAnimation = (Animation)localIterator.next();
      if ((!bool) && (!localAnimation.getTransformation(AnimationUtils.currentAnimationTimeMillis(), this.jdField_a_of_type_AndroidViewAnimationTransformation))) {
        break;
      }
    }
    return bool;
  }
  
  public void c(Canvas paramCanvas)
  {
    if ((this.n != 0) && (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null))
    {
      paramCanvas.save();
      paramCanvas.translate(this.j, this.k);
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setAlpha(this.n);
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(0, 0, this.l, this.m);
      paramCanvas.scale(this.jdField_a_of_type_Float, this.b, this.l / 2, this.m / 2);
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.draw(paramCanvas);
      paramCanvas.restore();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.portal.BaseAnimHolder
 * JD-Core Version:    0.7.0.1
 */