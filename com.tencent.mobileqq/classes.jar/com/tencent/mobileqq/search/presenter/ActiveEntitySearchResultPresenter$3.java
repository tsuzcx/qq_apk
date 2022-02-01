package com.tencent.mobileqq.search.presenter;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.search.model.GroupBaseNetSearchModelItem;
import com.tencent.mobileqq.troop.api.handler.ITroopMngHandler;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ActiveEntitySearchResultPresenter$3
  implements View.OnClickListener
{
  ActiveEntitySearchResultPresenter$3(ActiveEntitySearchResultPresenter paramActiveEntitySearchResultPresenter, GroupBaseNetSearchModelItem paramGroupBaseNetSearchModelItem) {}
  
  public void onClick(View paramView)
  {
    if ("ActiveEntitySearchResultPresenter_add_troop".equals(paramView.getTag()))
    {
      ActiveEntitySearchResultPresenter.a(this.b, paramView);
      ActiveEntitySearchResultPresenter.a(this.b, this.a);
      if (ActiveEntitySearchResultPresenter.b(this.b) != null)
      {
        ActiveEntitySearchResultPresenter.c(this.b).addObserver(ActiveEntitySearchResultPresenter.b(this.b));
        try
        {
          ((ITroopMngHandler)ActiveEntitySearchResultPresenter.c(this.b).getBusinessHandler(BusinessHandlerFactory.TROOP_MNG_HANDLER)).a(Long.parseLong(this.a.b), Long.valueOf(ActiveEntitySearchResultPresenter.c(this.b).getCurrentUin()).longValue(), null);
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
        }
      }
      else
      {
        ActiveEntitySearchResultPresenter.a(this.b, paramView.getContext(), this.a);
        ActiveEntitySearchResultPresenter.f(this.b);
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.presenter.ActiveEntitySearchResultPresenter.3
 * JD-Core Version:    0.7.0.1
 */