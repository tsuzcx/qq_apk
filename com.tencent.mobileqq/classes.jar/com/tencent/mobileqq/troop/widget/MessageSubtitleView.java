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
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AccelerateInterpolator;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import bgnr;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

@TargetApi(11)
public class MessageSubtitleView
  extends RelativeLayout
{
  protected static int b;
  public static int c = 2;
  protected static int d = 3;
  int jdField_a_of_type_Int = 0;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private final Runnable jdField_a_of_type_JavaLangRunnable = new MessageSubtitleView.1(this);
  protected ArrayList<TextView> a;
  public Queue<CharSequence> a;
  private final Runnable b;
  
  static
  {
    jdField_b_of_type_Int = 1;
  }
  
  public MessageSubtitleView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList(4);
    this.jdField_a_of_type_JavaUtilQueue = new LinkedList();
    this.jdField_b_of_type_JavaLangRunnable = new MessageSubtitleView.2(this);
    a(paramContext);
  }
  
  public MessageSubtitleView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList(4);
    this.jdField_a_of_type_JavaUtilQueue = new LinkedList();
    this.jdField_b_of_type_JavaLangRunnable = new MessageSubtitleView.2(this);
    a(paramContext);
  }
  
  private AnimatorSet a(TextView paramTextView)
  {
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.play(a(paramTextView)).with(b(paramTextView));
    return localAnimatorSet;
  }
  
  private ObjectAnimator a(TextView paramTextView)
  {
    paramTextView = ObjectAnimator.ofFloat(paramTextView, "alpha", new float[] { 0.0F, 1.0F });
    paramTextView.setDuration(200L);
    return paramTextView;
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    if ((paramInt1 < 0) || (paramInt1 >= this.jdField_a_of_type_JavaUtilArrayList.size())) {}
    label135:
    for (;;)
    {
      return;
      Object localObject = (TextView)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt1);
      boolean bool;
      if (paramInt1 == 0)
      {
        bool = true;
        if (paramInt2 != jdField_b_of_type_Int) {
          break label95;
        }
        localObject = a((TextView)localObject);
      }
      for (;;)
      {
        if (localObject == null) {
          break label135;
        }
        ((Animator)localObject).setInterpolator(new AccelerateInterpolator(0.2F));
        ((Animator)localObject).addListener(new bgnr(this, bool, paramInt2));
        ((Animator)localObject).start();
        return;
        bool = false;
        break;
        label95:
        if (paramInt2 == c) {
          localObject = b((TextView)localObject);
        } else if (paramInt2 == d) {
          localObject = a((TextView)localObject);
        } else {
          localObject = null;
        }
      }
    }
  }
  
  private ObjectAnimator b(TextView paramTextView)
  {
    paramTextView = ObjectAnimator.ofFloat(paramTextView, "translationY", new float[] { paramTextView.getTranslationY(), paramTextView.getTranslationY() - this.jdField_a_of_type_Int });
    paramTextView.setDuration(200L);
    return paramTextView;
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList.size() > 3)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
      d();
    }
    do
    {
      return;
      if (this.jdField_a_of_type_JavaUtilArrayList.size() == 3)
      {
        this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
        d();
      }
      a();
    } while (this.jdField_a_of_type_JavaUtilArrayList.size() != 1);
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_b_of_type_JavaLangRunnable, 8000L);
  }
  
  private void d()
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() != 0))
    {
      int i = 0;
      while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
      {
        a(i, c);
        i += 1;
      }
    }
  }
  
  public void a()
  {
    if ((!this.jdField_a_of_type_JavaUtilQueue.isEmpty()) && (this.jdField_a_of_type_JavaUtilArrayList.size() <= 3))
    {
      Object localObject = getContext();
      CharSequence localCharSequence = (CharSequence)this.jdField_a_of_type_JavaUtilQueue.poll();
      TextView localTextView = new TextView((Context)localObject);
      localTextView.setShadowLayer(3.0F, 3.0F, 3.0F, 2131165553);
      localTextView.setEllipsize(TextUtils.TruncateAt.END);
      localTextView.setSingleLine(true);
      localTextView.setTextSize(18.0F);
      localTextView.setTextColor(-1);
      localTextView.setTag(Long.valueOf(System.currentTimeMillis()));
      localTextView.setTranslationY(0.0F);
      localTextView.setText(localCharSequence);
      localObject = new RelativeLayout.LayoutParams(((Context)localObject).getResources().getDimensionPixelSize(2131299001), ((Context)localObject).getResources().getDimensionPixelSize(2131298999));
      ((RelativeLayout.LayoutParams)localObject).topMargin = (this.jdField_a_of_type_JavaUtilArrayList.size() * this.jdField_a_of_type_Int);
      addView(localTextView, (ViewGroup.LayoutParams)localObject);
      this.jdField_a_of_type_JavaUtilArrayList.add(localTextView);
      if (this.jdField_a_of_type_JavaUtilArrayList.size() == 4) {
        a(this.jdField_a_of_type_JavaUtilArrayList.size() - 1, jdField_b_of_type_Int);
      }
    }
    else
    {
      return;
    }
    a(this.jdField_a_of_type_JavaUtilArrayList.size() - 1, d);
  }
  
  void a(Context paramContext)
  {
    this.jdField_a_of_type_AndroidOsHandler = new Handler(paramContext.getMainLooper());
    this.jdField_a_of_type_Int = paramContext.getResources().getDimensionPixelSize(2131298999);
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_JavaUtilArrayList.size() == 0)) {
      return;
    }
    int i = 0;
    label20:
    float f;
    int j;
    if (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      TextView localTextView = (TextView)this.jdField_a_of_type_JavaUtilArrayList.get(i);
      f = localTextView.getY();
      if (f >= 0.0F) {
        break label83;
      }
      removeView(localTextView);
      this.jdField_a_of_type_JavaUtilArrayList.remove(localTextView);
      j = i - 1;
    }
    for (;;)
    {
      i = j + 1;
      break label20;
      break;
      label83:
      j = i;
      if (f == 0.0F)
      {
        long l2 = 8200L - (System.currentTimeMillis() - ((Long)((TextView)this.jdField_a_of_type_JavaUtilArrayList.get(0)).getTag()).longValue());
        long l1 = l2;
        if (l2 <= 0L) {
          l1 = 1000L;
        }
        this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
        this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_b_of_type_JavaLangRunnable, l1);
        j = i;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.MessageSubtitleView
 * JD-Core Version:    0.7.0.1
 */