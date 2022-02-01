package com.tencent.mobileqq.kandian.biz.tab;

import android.animation.AnimatorSet;
import android.animation.AnimatorSet.Builder;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.animation.LinearInterpolator;
import com.tencent.mobileqq.widget.TabDragAnimationView;
import com.tencent.qphone.base.util.QLog;

public class ReadInjoyTabDragAnimationView
  extends TabDragAnimationView
{
  private boolean t;
  private int u = 0;
  private Drawable v;
  private int w;
  private int x;
  private AnimatorSet y;
  
  public ReadInjoyTabDragAnimationView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ReadInjoyTabDragAnimationView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ReadInjoyTabDragAnimationView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private ReadInjoyTabDragAnimationView.DrawableBound getDrawableBound()
  {
    ReadInjoyTabDragAnimationView.DrawableBound localDrawableBound = new ReadInjoyTabDragAnimationView.DrawableBound(null);
    int k = getPaddingLeft();
    int j = getRight() - getLeft() - getPaddingRight();
    int m = getPaddingTop();
    int n = getBottom() - getTop() - getPaddingBottom();
    int i = this.c;
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3)
        {
          if (i != 4)
          {
            i = (k + j) / 2;
            m = (m + n) / 2;
            k = i - this.d / 2;
            j = i + this.d / 2;
            n = m - this.e / 2;
            m += this.e / 2;
            break label303;
          }
          m = (m + n) / 2;
          k = j - this.d / 2;
          i = m - this.e / 2;
          n = this.e / 2;
        }
        else
        {
          m = (m + n) / 2;
          j = this.d + k;
          i = m - this.e / 2;
          n = this.e / 2;
        }
        m += n;
        n = i;
        break label303;
      }
      i = (k + j) / 2;
      j = i - this.d / 2;
      i += this.d / 2;
      m = n - this.e;
      k = n;
    }
    else
    {
      i = (k + j) / 2;
      j = i - this.d / 2;
      i += this.d / 2;
      k = this.e + m;
    }
    n = m;
    m = k;
    k = j;
    j = i;
    label303:
    localDrawableBound.a = k;
    localDrawableBound.c = n;
    localDrawableBound.b = j;
    localDrawableBound.d = m;
    return localDrawableBound;
  }
  
  private boolean j()
  {
    return this.l;
  }
  
  public void a()
  {
    this.v = getContext().getResources().getDrawable(2130851443);
  }
  
  public void a(int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("changeStyle  : ");
    ((StringBuilder)localObject).append(paramInt);
    QLog.d("ReadInjoyTabDragAnimationView", 4, ((StringBuilder)localObject).toString());
    this.u = paramInt;
    localObject = this.y;
    if (localObject != null)
    {
      ((AnimatorSet)localObject).cancel();
      this.y = null;
    }
    com.tencent.mobileqq.kandian.glue.report.RIJKanDianTabReport.b = this.u;
    invalidate();
  }
  
  public void a(boolean paramBoolean)
  {
    if ((j()) && (this.t))
    {
      if (this.u != 1) {
        return;
      }
      if (!paramBoolean)
      {
        setPivotX(this.w);
        setPivotY(this.x);
        localObjectAnimator1 = ObjectAnimator.ofFloat(this, "scaleX", new float[] { 1.0F, 0.8F, 1.0F }).setDuration(150L);
        localObjectAnimator2 = ObjectAnimator.ofFloat(this, "scaleY", new float[] { 1.0F, 0.8F, 1.0F }).setDuration(150L);
        ObjectAnimator localObjectAnimator3 = ObjectAnimator.ofFloat(this, "rotation", new float[] { 0.0F, 720.0F }).setDuration(800L);
        ObjectAnimator localObjectAnimator4 = ObjectAnimator.ofFloat(this, "alpha", new float[] { 1.0F, 0.0F }).setDuration(200L);
        localObjectAnimator4.setStartDelay(700L);
        this.y = new AnimatorSet();
        this.y.setInterpolator(new LinearInterpolator());
        this.y.play(localObjectAnimator1).with(localObjectAnimator2);
        this.y.play(localObjectAnimator2).before(localObjectAnimator3);
        this.y.play(localObjectAnimator3).with(localObjectAnimator4);
        this.y.addListener(new ReadInjoyTabDragAnimationView.1(this));
        this.y.start();
        return;
      }
      setPivotX(this.w);
      setPivotY(this.x);
      setVisibility(0);
      ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(this, "alpha", new float[] { 0.0F, 1.0F }).setDuration(500L);
      ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(this, "rotation", new float[] { -30.0F, 0.0F }).setDuration(500L);
      this.y = new AnimatorSet();
      this.y.play(localObjectAnimator2).with(localObjectAnimator1);
      this.y.addListener(new ReadInjoyTabDragAnimationView.2(this));
      this.y.start();
    }
  }
  
  public int getStyle()
  {
    return this.u;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    ReadInjoyTabDragAnimationView.DrawableBound localDrawableBound;
    if ((j()) && (this.t) && (this.u == 1))
    {
      localDrawableBound = getDrawableBound();
      if (this.v != null)
      {
        this.w = ((localDrawableBound.a + localDrawableBound.b) / 2);
        this.x = ((localDrawableBound.c + localDrawableBound.d) / 2);
        this.v.setBounds(localDrawableBound.a, localDrawableBound.c, localDrawableBound.b, localDrawableBound.d);
        this.v.draw(paramCanvas);
      }
    }
    else
    {
      if (this.w == 0)
      {
        localDrawableBound = getDrawableBound();
        this.w = ((localDrawableBound.a + localDrawableBound.b) / 2);
        this.x = ((localDrawableBound.c + localDrawableBound.d) / 2);
      }
      super.onDraw(paramCanvas);
    }
  }
  
  public void setIsSelect(boolean paramBoolean)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("setIsSelect  : ");
    ((StringBuilder)localObject).append(paramBoolean);
    QLog.d("ReadInjoyTabDragAnimationView", 4, ((StringBuilder)localObject).toString());
    this.t = paramBoolean;
    localObject = this.y;
    if (localObject != null)
    {
      ((AnimatorSet)localObject).cancel();
      this.y = null;
    }
    invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.tab.ReadInjoyTabDragAnimationView
 * JD-Core Version:    0.7.0.1
 */