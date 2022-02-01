package com.tencent.mobileqq.kandian.biz.comment.ui;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.IView;
import com.tencent.mobileqq.kandian.biz.comment.entity.BaseCommentData;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyHelper;

public class ReadInJoyCommentLikeView
  extends FrameLayout
  implements IView
{
  private BaseCommentData a;
  private RelativeLayout b;
  private ImageView c;
  private TextView d;
  private View.OnClickListener e;
  private ReadInJoyCommentLikeView.OnLikeStateChangeLinstener f;
  
  public ReadInJoyCommentLikeView(@NonNull Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public ReadInJoyCommentLikeView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public ReadInJoyCommentLikeView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private void a()
  {
    inflate(getContext(), 2131626160, this);
    this.b = ((RelativeLayout)findViewById(2131437485));
    this.c = ((ImageView)findViewById(2131436437));
    this.d = ((TextView)findViewById(2131448356));
    this.e = new ReadInJoyCommentLikeView.1(this);
    setOnClickListener(this.e);
  }
  
  private void a(View paramView)
  {
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(paramView, SCALE_X, new float[] { 1.0F, 0.5F, 0.0F, 0.5F, 1.0F, 1.6F, 1.0F });
    paramView = ObjectAnimator.ofFloat(paramView, SCALE_Y, new float[] { 1.0F, 0.5F, 0.0F, 0.5F, 1.0F, 1.6F, 1.0F });
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.playTogether(new Animator[] { localObjectAnimator, paramView });
    localAnimatorSet.setDuration(400L);
    localAnimatorSet.start();
  }
  
  private void b()
  {
    BaseCommentData localBaseCommentData = this.a;
    if (localBaseCommentData != null)
    {
      ImageView localImageView = this.c;
      int i;
      if (localBaseCommentData.isLiked()) {
        i = 2130843867;
      } else {
        i = 2130843865;
      }
      localImageView.setImageResource(i);
      if (this.a.likeCnt > 0) {
        this.d.setText(ReadInJoyHelper.d(this.a.likeCnt));
      }
      if (this.a.likeCnt == 0) {
        this.d.setText("");
      }
    }
  }
  
  public void a(BaseCommentData paramBaseCommentData)
  {
    this.a = paramBaseCommentData;
    b();
  }
  
  public void comLayout(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    onComLayout(true, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public int getComMeasuredHeight()
  {
    return getMeasuredHeight();
  }
  
  public int getComMeasuredWidth()
  {
    return getMeasuredWidth();
  }
  
  public void measureComponent(int paramInt1, int paramInt2)
  {
    onComMeasure(paramInt1, paramInt2);
  }
  
  public void onComLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    layout(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void onComMeasure(int paramInt1, int paramInt2)
  {
    measure(paramInt1, paramInt2);
  }
  
  public void setOnLikeListener(ReadInJoyCommentLikeView.OnLikeStateChangeLinstener paramOnLikeStateChangeLinstener)
  {
    this.f = paramOnLikeStateChangeLinstener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.ui.ReadInJoyCommentLikeView
 * JD-Core Version:    0.7.0.1
 */