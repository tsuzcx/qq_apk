package com.tencent.mobileqq.dinifly;

import android.graphics.Matrix;
import android.support.annotation.NonNull;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import com.tencent.mobileqq.dinifly.model.layer.CompositionLayer;
import com.tencent.mobileqq.dinifly.model.layer.ImageLayer;

public class ViewAnimation
  extends Animation
{
  private boolean enableXCoordinateMirrored = false;
  private int mCenterX;
  private int mCenterY;
  public ImageLayer mImageLayer;
  private DiniFlyAnimationView mLottieAnimationView;
  private Matrix resMatrix = new Matrix();
  
  public ViewAnimation(@NonNull DiniFlyAnimationView paramDiniFlyAnimationView)
  {
    this.mLottieAnimationView = paramDiniFlyAnimationView;
  }
  
  private void mirrorXCoordinate(Matrix paramMatrix)
  {
    float[] arrayOfFloat = new float[9];
    paramMatrix.getValues(arrayOfFloat);
    arrayOfFloat[2] *= -1.0F;
    paramMatrix.setValues(arrayOfFloat);
  }
  
  protected void applyTransformation(float paramFloat, Transformation paramTransformation)
  {
    paramTransformation = paramTransformation.getMatrix();
    if (this.mImageLayer != null)
    {
      this.resMatrix.set(this.mImageLayer.getMatrix());
      if (this.enableXCoordinateMirrored) {
        mirrorXCoordinate(this.resMatrix);
      }
      paramTransformation.set(this.resMatrix);
      return;
    }
    try
    {
      this.mImageLayer = ((ImageLayer)this.mLottieAnimationView.getLottieDrawable().getCompositionLayer().getLayer());
      return;
    }
    catch (NullPointerException paramTransformation)
    {
      paramTransformation.printStackTrace();
    }
  }
  
  public void initialize(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.initialize(paramInt1, paramInt2, paramInt3, paramInt4);
    this.mCenterX = (paramInt1 / 2);
    this.mCenterY = (paramInt2 / 2);
  }
  
  public void setEnableXCoordinateMirrored(boolean paramBoolean)
  {
    this.enableXCoordinateMirrored = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.ViewAnimation
 * JD-Core Version:    0.7.0.1
 */