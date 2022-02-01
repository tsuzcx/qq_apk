package com.tencent.mobileqq.troop.widget;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.AnimatorSet.Builder;
import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AccelerateInterpolator;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

@TargetApi(11)
public class MessageSubtitleView
  extends RelativeLayout
{
  protected static int d = 1;
  protected static int e = 2;
  protected static int f = 3;
  protected ArrayList<TextView> a = new ArrayList(4);
  int b = 0;
  protected Queue<CharSequence> c = new LinkedList();
  private Handler g;
  private final Runnable h = new MessageSubtitleView.1(this);
  private final Runnable i = new MessageSubtitleView.2(this);
  
  public MessageSubtitleView(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public MessageSubtitleView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  private ObjectAnimator a(TextView paramTextView)
  {
    paramTextView = ObjectAnimator.ofFloat(paramTextView, "alpha", new float[] { 0.0F, 1.0F });
    paramTextView.setDuration(200L);
    return paramTextView;
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    if (paramInt1 >= 0)
    {
      if (paramInt1 >= this.a.size()) {
        return;
      }
      TextView localTextView = (TextView)this.a.get(paramInt1);
      boolean bool;
      if (paramInt1 == 0) {
        bool = true;
      } else {
        bool = false;
      }
      Object localObject = null;
      if (paramInt2 == d) {
        localObject = c(localTextView);
      } else if (paramInt2 == e) {
        localObject = b(localTextView);
      } else if (paramInt2 == f) {
        localObject = a(localTextView);
      }
      if (localObject != null)
      {
        ((Animator)localObject).setInterpolator(new AccelerateInterpolator(0.2F));
        ((Animator)localObject).addListener(new MessageSubtitleView.TextAnimationListener(this, bool, paramInt2));
        ((Animator)localObject).start();
      }
    }
  }
  
  private ObjectAnimator b(TextView paramTextView)
  {
    paramTextView = ObjectAnimator.ofFloat(paramTextView, "translationY", new float[] { paramTextView.getTranslationY(), paramTextView.getTranslationY() - this.b });
    paramTextView.setDuration(200L);
    return paramTextView;
  }
  
  private AnimatorSet c(TextView paramTextView)
  {
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.play(a(paramTextView)).with(b(paramTextView));
    return localAnimatorSet;
  }
  
  private void c()
  {
    if (this.a.size() > 3)
    {
      this.g.removeCallbacks(this.i);
      d();
      return;
    }
    if (this.a.size() == 3)
    {
      this.g.removeCallbacks(this.i);
      d();
    }
    a();
    if (this.a.size() == 1)
    {
      this.g.removeCallbacks(this.i);
      this.g.postDelayed(this.i, 8000L);
    }
  }
  
  private void d()
  {
    ArrayList localArrayList = this.a;
    if ((localArrayList != null) && (localArrayList.size() != 0))
    {
      int j = 0;
      while (j < this.a.size())
      {
        a(j, e);
        j += 1;
      }
    }
  }
  
  public void a()
  {
    if ((!this.c.isEmpty()) && (this.a.size() <= 3))
    {
      Object localObject = getContext();
      CharSequence localCharSequence = (CharSequence)this.c.poll();
      TextView localTextView = new TextView((Context)localObject);
      localTextView.setShadowLayer(3.0F, 3.0F, 3.0F, 2131165856);
      localTextView.setEllipsize(TextUtils.TruncateAt.END);
      localTextView.setSingleLine(true);
      localTextView.setTextSize(18.0F);
      localTextView.setTextColor(-1);
      localTextView.setTag(Long.valueOf(System.currentTimeMillis()));
      localTextView.setTranslationY(0.0F);
      localTextView.setText(localCharSequence);
      localObject = new RelativeLayout.LayoutParams(((Context)localObject).getResources().getDimensionPixelSize(2131299821), ((Context)localObject).getResources().getDimensionPixelSize(2131299819));
      ((RelativeLayout.LayoutParams)localObject).topMargin = (this.a.size() * this.b);
      addView(localTextView, (ViewGroup.LayoutParams)localObject);
      this.a.add(localTextView);
      if (this.a.size() == 4)
      {
        a(this.a.size() - 1, d);
        return;
      }
      a(this.a.size() - 1, f);
    }
  }
  
  void a(Context paramContext)
  {
    this.g = new Handler(paramContext.getMainLooper());
    this.b = paramContext.getResources().getDimensionPixelSize(2131299819);
  }
  
  public void b()
  {
    Object localObject = this.a;
    if (localObject != null)
    {
      if (((ArrayList)localObject).size() == 0) {
        return;
      }
      int k;
      for (int j = 0; j < this.a.size(); j = k + 1)
      {
        localObject = (TextView)this.a.get(j);
        float f1 = ((TextView)localObject).getY();
        if (f1 < 0.0F)
        {
          removeView((View)localObject);
          this.a.remove(localObject);
          k = j - 1;
        }
        else
        {
          k = j;
          if (f1 == 0.0F)
          {
            long l2 = 8200L - (System.currentTimeMillis() - ((Long)((TextView)this.a.get(0)).getTag()).longValue());
            long l1 = l2;
            if (l2 <= 0L) {
              l1 = 1000L;
            }
            this.g.removeCallbacks(this.i);
            this.g.postDelayed(this.i, l1);
            k = j;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.MessageSubtitleView
 * JD-Core Version:    0.7.0.1
 */