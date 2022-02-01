package com.tencent.mobileqq.kandian.biz.atlas;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mobileqq.app.BaseActivity;

class ReadInJoyAtlasCommentFragment$3
  implements Animation.AnimationListener
{
  ReadInJoyAtlasCommentFragment$3(ReadInJoyAtlasCommentFragment paramReadInJoyAtlasCommentFragment) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.a.getView().setVisibility(8);
    this.a.getBaseActivity().setResult(-1);
    this.a.getBaseActivity().finish();
    this.a.getBaseActivity().overridePendingTransition(0, 0);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.atlas.ReadInJoyAtlasCommentFragment.3
 * JD-Core Version:    0.7.0.1
 */