package dov.com.qq.im.capture.util;

import amyk;
import amyl;
import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.animation.Animation;
import com.tencent.mobileqq.utils.ValueAnimation;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class QIMAnimationUtils
{
  public static Animator a(View paramView, int paramInt1, int paramInt2, int paramInt3)
  {
    ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { paramInt2, paramInt3 });
    localValueAnimator.addUpdateListener(new amyk(paramInt1, paramView));
    return localValueAnimator;
  }
  
  public static Animation a(View paramView, float paramFloat1, float paramFloat2)
  {
    return new ValueAnimation(Float.valueOf(paramFloat1), Float.valueOf(paramFloat2), new amyl(paramView));
  }
  
  public static void a(List paramList, Animator.AnimatorListener paramAnimatorListener)
  {
    if (paramList.size() > 0)
    {
      ArrayList localArrayList = new ArrayList();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        QIMAnimationUtils.AnimatorParams localAnimatorParams = (QIMAnimationUtils.AnimatorParams)paramList.next();
        ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(localAnimatorParams.jdField_a_of_type_AndroidViewView, localAnimatorParams.jdField_a_of_type_JavaLangString, new float[] { localAnimatorParams.jdField_a_of_type_Float, localAnimatorParams.jdField_b_of_type_Float }).setDuration(localAnimatorParams.jdField_a_of_type_Long);
        localObjectAnimator.setStartDelay(localAnimatorParams.jdField_b_of_type_Long);
        localArrayList.add(localObjectAnimator);
      }
      paramList = new AnimatorSet();
      paramList.playTogether(localArrayList);
      paramList.addListener(paramAnimatorListener);
      paramList.start();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.capture.util.QIMAnimationUtils
 * JD-Core Version:    0.7.0.1
 */