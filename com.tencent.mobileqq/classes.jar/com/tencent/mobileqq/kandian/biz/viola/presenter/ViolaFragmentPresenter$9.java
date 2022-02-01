package com.tencent.mobileqq.kandian.biz.viola.presenter;

import com.tencent.hippy.qq.app.HippyQQEngine;

class ViolaFragmentPresenter$9
  implements Runnable
{
  ViolaFragmentPresenter$9(ViolaFragmentPresenter paramViolaFragmentPresenter) {}
  
  public void run()
  {
    if (this.this$0.a != null)
    {
      this.this$0.a.onDestroy();
      this.this$0.a = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.viola.presenter.ViolaFragmentPresenter.9
 * JD-Core Version:    0.7.0.1
 */