package dov.com.qq.im.aeeditor.module.aifilter;

import android.animation.AnimatorSet;
import android.animation.AnimatorSet.Builder;
import android.animation.ValueAnimator;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import blfg;
import blgs;
import blgt;
import blgu;

public class AEEditorApplyAllLoadingView
  extends FrameLayout
{
  private TextView a;
  
  public AEEditorApplyAllLoadingView(@NonNull Context paramContext)
  {
    this(paramContext, null);
  }
  
  public AEEditorApplyAllLoadingView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public AEEditorApplyAllLoadingView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    LayoutInflater.from(paramContext).inflate(2131558523, this);
    this.a = ((TextView)findViewById(2131377553));
    b();
  }
  
  private void b()
  {
    AnimatorSet localAnimatorSet = new AnimatorSet();
    ValueAnimator localValueAnimator1 = ValueAnimator.ofInt(new int[] { 22, 0 });
    localValueAnimator1.setDuration(500L);
    localValueAnimator1.addUpdateListener(new blgs(this));
    ValueAnimator localValueAnimator2 = ValueAnimator.ofFloat(new float[] { 1.0F, 0.0F });
    localValueAnimator2.setDuration(1000L);
    localValueAnimator2.addUpdateListener(new blgt(this));
    localAnimatorSet.play(localValueAnimator1).before(localValueAnimator2);
    localAnimatorSet.addListener(new blgu(this));
    localAnimatorSet.start();
  }
  
  public void a()
  {
    if (getParent() == null)
    {
      blfg.a("AEEditorApplyAllLoadingView", "cancelLoading parent is null.");
      return;
    }
    ((ViewGroup)getParent()).removeAllViews();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.aifilter.AEEditorApplyAllLoadingView
 * JD-Core Version:    0.7.0.1
 */