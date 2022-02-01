package com.tencent.mobileqq.kandian.biz.playfeeds;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class VideoFeedsLikeAnimate$LikeExplosionView
  extends View
{
  private List<VideoFeedsLikeAnimate.LikeExplosionView.LikeExplosion> b = new ArrayList();
  private Paint c = new Paint();
  private Matrix d = new Matrix();
  private Random e;
  private float f;
  private long g = 500L;
  
  public VideoFeedsLikeAnimate$LikeExplosionView(VideoFeedsLikeAnimate paramVideoFeedsLikeAnimate, Context paramContext, Random paramRandom)
  {
    super(paramContext);
    this.e = paramRandom;
  }
  
  private void b()
  {
    VideoFeedsLikeAnimate.a(this.a).removeView(this);
  }
  
  public void a()
  {
    ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofPropertyValuesHolder(this, new PropertyValuesHolder[] { PropertyValuesHolder.ofKeyframe("alpha", new Keyframe[] { Keyframe.ofFloat(0.0F, 0.0F), Keyframe.ofFloat(0.12F, 1.0F), Keyframe.ofFloat(0.8F, 1.0F), Keyframe.ofFloat(1.0F, 0.0F) }) });
    ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(this, "explosionFraction", new float[] { 0.0F, 1.0F });
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.playTogether(new Animator[] { localObjectAnimator2, localObjectAnimator1 });
    localAnimatorSet.setStartDelay(250L);
    localAnimatorSet.addListener(new VideoFeedsLikeAnimate.LikeExplosionView.1(this));
    localAnimatorSet.setDuration(this.g);
    localAnimatorSet.setInterpolator(new AccelerateDecelerateInterpolator());
    localAnimatorSet.start();
  }
  
  public float getExplosionFraction()
  {
    return this.f;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    Object localObject = this.b;
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((VideoFeedsLikeAnimate.LikeExplosionView.LikeExplosion)((Iterator)localObject).next()).a(paramCanvas);
      }
    }
  }
  
  public void setExplosionEachDirection(int paramInt)
  {
    if (paramInt <= 0) {
      return;
    }
    int j = 0;
    if (j < 4)
    {
      int m = j * 90;
      int k = j + 1;
      int i = 0;
      for (;;)
      {
        j = k;
        if (i >= paramInt) {
          break;
        }
        try
        {
          j = (int)(this.e.nextFloat() * (k * 90 - m) + m);
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder1 = new StringBuilder();
            localStringBuilder1.append("setIconExplosionEachDirection, angele: ");
            localStringBuilder1.append(j);
            QLog.d("VideoFeedsLikeAnimate", 2, localStringBuilder1.toString());
          }
          this.b.add(new VideoFeedsLikeAnimate.LikeExplosionView.CircleLikeExplosion(this, j));
          i += 1;
        }
        catch (Exception localException)
        {
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder2 = new StringBuilder();
            localStringBuilder2.append("setIconExplosionEachDirection: ");
            localStringBuilder2.append(localException.getMessage());
            QLog.d("VideoFeedsLikeAnimate", 2, localStringBuilder2.toString());
          }
        }
      }
    }
  }
  
  public void setExplosionFraction(float paramFloat)
  {
    this.f = paramFloat;
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext()) {
      ((VideoFeedsLikeAnimate.LikeExplosionView.LikeExplosion)localIterator.next()).a(paramFloat);
    }
    invalidate();
  }
  
  public void setExplosionSize(int paramInt)
  {
    int i = 0;
    while (i < paramInt)
    {
      this.b.add(new VideoFeedsLikeAnimate.LikeExplosionView.CircleLikeExplosion(this));
      i += 1;
    }
  }
  
  public void setIconExplosion(Drawable[] paramArrayOfDrawable, int paramInt1, int paramInt2)
  {
    if ((paramArrayOfDrawable != null) && (paramArrayOfDrawable.length != 0))
    {
      if (paramInt1 <= 0) {
        return;
      }
      Object localObject = new int[3];
      Object tmp21_19 = localObject;
      tmp21_19[0] = -15;
      Object tmp26_21 = tmp21_19;
      tmp26_21[1] = 0;
      Object tmp30_26 = tmp26_21;
      tmp30_26[2] = 15;
      tmp30_26;
      int i = 0;
      for (;;)
      {
        if (i < paramInt1) {
          try
          {
            int j = this.e.nextInt(paramArrayOfDrawable.length);
            int k = this.e.nextInt(localObject.length);
            this.b.add(new VideoFeedsLikeAnimate.LikeExplosionView.IconLikeExplosion(this, paramArrayOfDrawable[j], paramInt2, localObject[k]));
            i += 1;
          }
          catch (Exception paramArrayOfDrawable)
          {
            if (QLog.isColorLevel())
            {
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append("setIconExplosion: ");
              ((StringBuilder)localObject).append(paramArrayOfDrawable.getMessage());
              QLog.d("VideoFeedsLikeAnimate", 2, ((StringBuilder)localObject).toString());
            }
          }
        }
      }
    }
  }
  
  public void setIconExplosionEachDirection(Drawable[] paramArrayOfDrawable, int paramInt1, int paramInt2)
  {
    int j;
    if ((paramArrayOfDrawable != null) && (paramArrayOfDrawable.length != 0))
    {
      if (paramInt1 <= 0) {
        return;
      }
      j = 2;
    }
    for (;;)
    {
      int i;
      int k;
      int m;
      try
      {
        localObject = new int[3];
        localObject[0] = -15;
        localObject[1] = 0;
        localObject[2] = 15;
        i = 0;
      }
      catch (Exception paramArrayOfDrawable)
      {
        int n;
        int i1;
        int i2;
        StringBuilder localStringBuilder;
        if (!QLog.isColorLevel()) {
          break label235;
        }
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("setIconExplosionEachDirection: ");
        ((StringBuilder)localObject).append(paramArrayOfDrawable.getMessage());
        QLog.d("VideoFeedsLikeAnimate", 2, ((StringBuilder)localObject).toString());
      }
      if (i < paramInt1)
      {
        n = this.e.nextInt(paramArrayOfDrawable.length);
        i1 = this.e.nextInt(localObject.length);
        i2 = (int)(this.e.nextFloat() * (k * 90 - m) + m);
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("angele: ");
          localStringBuilder.append(i2);
          QLog.d("VideoFeedsLikeAnimate", j, localStringBuilder.toString());
        }
        this.b.add(new VideoFeedsLikeAnimate.LikeExplosionView.IconLikeExplosion(this, paramArrayOfDrawable[n], paramInt2, localObject[i1], i2));
        i += 1;
        j = 2;
      }
      else
      {
        i = k;
        label235:
        while (i >= 4) {
          return;
        }
        m = i * 90;
        k = i + 1;
        i = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsLikeAnimate.LikeExplosionView
 * JD-Core Version:    0.7.0.1
 */