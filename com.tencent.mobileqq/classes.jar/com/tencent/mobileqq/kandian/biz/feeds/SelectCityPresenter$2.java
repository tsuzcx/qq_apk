package com.tencent.mobileqq.kandian.biz.feeds;

import com.tencent.mobileqq.kandian.repo.feeds.entity.PositionData;
import mqq.util.WeakReference;

class SelectCityPresenter$2
  implements Runnable
{
  SelectCityPresenter$2(SelectCityPresenter paramSelectCityPresenter, PositionData paramPositionData) {}
  
  public void run()
  {
    SelectCityPresenter.IView localIView = (SelectCityPresenter.IView)SelectCityPresenter.a(this.this$0).get();
    if (localIView != null) {
      localIView.b(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.SelectCityPresenter.2
 * JD-Core Version:    0.7.0.1
 */