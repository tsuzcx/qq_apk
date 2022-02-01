package com.tencent.mobileqq.kandian.biz.viola.presenter;

import com.tencent.mobileqq.activity.fling.TopGestureLayout.OnGestureListener;
import com.tencent.mobileqq.kandian.glue.viola.modules.BridgeModule;
import com.tencent.mobileqq.kandian.glue.viola.view.ViolaBaseView;

class ViolaFragmentPresenter$ViolaTopGestureLayoutListener
  implements TopGestureLayout.OnGestureListener
{
  private ViolaFragmentPresenter$ViolaTopGestureLayoutListener(ViolaFragmentPresenter paramViolaFragmentPresenter) {}
  
  private BridgeModule a()
  {
    ViolaBaseView localViolaBaseView = this.a.n();
    if (localViolaBaseView == null) {
      return null;
    }
    return (BridgeModule)localViolaBaseView.b(BridgeModule.MODULE_NAME);
  }
  
  public void flingLToR()
  {
    BridgeModule localBridgeModule = a();
    if ((localBridgeModule != null) && (localBridgeModule.onFlingLToR())) {
      return;
    }
    this.a.o();
  }
  
  public void flingRToL() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.viola.presenter.ViolaFragmentPresenter.ViolaTopGestureLayoutListener
 * JD-Core Version:    0.7.0.1
 */