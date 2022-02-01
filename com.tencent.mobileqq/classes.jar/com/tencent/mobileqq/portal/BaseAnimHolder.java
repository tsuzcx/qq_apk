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
  public int A;
  public Drawable B = null;
  public float C = 1.0F;
  public float D = 1.0F;
  public int E = 255;
  public ArrayList<Animation> F = new ArrayList();
  public Transformation w = new Transformation();
  public int x = 0;
  public int y = 0;
  public int z;
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, View paramView)
  {
    this.x = paramInt1;
    this.y = paramInt2;
    this.z = paramInt3;
    this.A = paramInt4;
  }
  
  public void a(Animation paramAnimation)
  {
    this.F.add(paramAnimation);
    paramAnimation.start();
  }
  
  public boolean a(Canvas paramCanvas)
  {
    if ((this.E != 0) && (this.B != null))
    {
      paramCanvas.save();
      paramCanvas.translate(this.x, this.y);
      this.B.setAlpha(this.E);
      this.B.setBounds(0, 0, this.z, this.A);
      paramCanvas.scale(this.C, this.D, this.z / 2, this.A / 2);
      this.B.draw(paramCanvas);
      paramCanvas.restore();
    }
    paramCanvas = this.F.iterator();
    for (boolean bool = false;; bool = true)
    {
      if (!paramCanvas.hasNext()) {
        return bool;
      }
      Animation localAnimation = (Animation)paramCanvas.next();
      if ((!bool) && (!localAnimation.getTransformation(AnimationUtils.currentAnimationTimeMillis(), this.w))) {
        break;
      }
    }
    return bool;
  }
  
  public void c()
  {
    this.F.clear();
  }
  
  public void d(Canvas paramCanvas)
  {
    if ((this.E != 0) && (this.B != null))
    {
      paramCanvas.save();
      paramCanvas.translate(this.x, this.y);
      this.B.setAlpha(this.E);
      this.B.setBounds(0, 0, this.z, this.A);
      paramCanvas.scale(this.C, this.D, this.z / 2, this.A / 2);
      this.B.draw(paramCanvas);
      paramCanvas.restore();
    }
  }
  
  public boolean i()
  {
    Iterator localIterator = this.F.iterator();
    for (boolean bool = false;; bool = true)
    {
      if (!localIterator.hasNext()) {
        return bool;
      }
      Animation localAnimation = (Animation)localIterator.next();
      if ((!bool) && (!localAnimation.getTransformation(AnimationUtils.currentAnimationTimeMillis(), this.w))) {
        break;
      }
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.portal.BaseAnimHolder
 * JD-Core Version:    0.7.0.1
 */