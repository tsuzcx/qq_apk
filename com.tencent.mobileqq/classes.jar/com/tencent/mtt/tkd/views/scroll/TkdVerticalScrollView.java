package com.tencent.mtt.tkd.views.scroll;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.View;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.mtt.hippy.utils.PixelUtil;
import com.tencent.mtt.hippy.views.scroll.HippyVerticalScrollView;

public class TkdVerticalScrollView
  extends HippyVerticalScrollView
  implements TkdScrollView
{
  private boolean mIsLoading = false;
  private int mPreloadDistance = 0;
  
  public TkdVerticalScrollView(Context paramContext)
  {
    super(paramContext);
    this.mScrollMinOffset = ((int)PixelUtil.dp2px(5.0F));
  }
  
  private boolean shouldEmitEndReachedEvent(int paramInt1, int paramInt2)
  {
    int i = getHeight();
    int j = getHeight();
    if (getChildCount() > 0) {
      i = getChildAt(0).getHeight();
    }
    if ((i <= j) || (i < this.mPreloadDistance)) {}
    while ((paramInt1 > 0) && (paramInt1 > paramInt2) && (j + paramInt1 >= i - this.mPreloadDistance)) {
      return true;
    }
    return false;
  }
  
  public void callLoadMoreFinish()
  {
    this.mIsLoading = false;
  }
  
  public void callScrollToPosition(int paramInt1, int paramInt2, Promise paramPromise)
  {
    paramInt1 = getScrollY() + paramInt1;
    if (paramInt2 <= 0)
    {
      scrollTo(0, paramInt1);
      if (paramPromise != null)
      {
        localObject = new HippyMap();
        ((HippyMap)localObject).pushString("msg", "on scroll end!");
        paramPromise.resolve(localObject);
      }
      return;
    }
    Object localObject = ObjectAnimator.ofInt(this, "scrollX", new int[] { 0 });
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofInt(this, "scrollY", new int[] { paramInt1 });
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.setDuration(paramInt2);
    localAnimatorSet.playTogether(new Animator[] { localObject, localObjectAnimator });
    localAnimatorSet.addListener(new TkdVerticalScrollView.1(this, paramPromise));
    localAnimatorSet.start();
  }
  
  public void callScrollToTop(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      smoothScrollTo(0, 0);
      return;
    }
    scrollTo(0, 0);
  }
  
  public void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if ((this.mPreloadDistance > 0) && (!this.mIsLoading) && (shouldEmitEndReachedEvent(paramInt2, paramInt4)))
    {
      TkdScrollViewEventHelper.emitScrollEndReachedEvent(this);
      this.mIsLoading = true;
    }
  }
  
  public void setPreloadDistance(int paramInt)
  {
    this.mPreloadDistance = ((int)PixelUtil.dp2px(Math.max(0, paramInt)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mtt.tkd.views.scroll.TkdVerticalScrollView
 * JD-Core Version:    0.7.0.1
 */