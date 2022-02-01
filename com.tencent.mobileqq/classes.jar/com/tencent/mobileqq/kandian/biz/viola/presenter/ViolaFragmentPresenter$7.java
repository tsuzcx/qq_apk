package com.tencent.mobileqq.kandian.biz.viola.presenter;

import com.tencent.mobileqq.kandian.biz.viola.api.IViolaFragmentView;
import com.tencent.mobileqq.kandian.biz.viola.view.ViolaFragment.ViolaGestureLayoutListener;
import com.tencent.mobileqq.kandian.glue.viola.delegate.ViolaInitDelegate.ViolaGestureLayoutStateChangeListener;

class ViolaFragmentPresenter$7
  implements ViolaInitDelegate.ViolaGestureLayoutStateChangeListener
{
  ViolaFragmentPresenter$7(ViolaFragmentPresenter paramViolaFragmentPresenter) {}
  
  public void a(int paramInt)
  {
    if (ViolaFragmentPresenter.a(this.a).getViolaGestureLayoutListener() != null) {
      ViolaFragmentPresenter.a(this.a).getViolaGestureLayoutListener().a(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.viola.presenter.ViolaFragmentPresenter.7
 * JD-Core Version:    0.7.0.1
 */