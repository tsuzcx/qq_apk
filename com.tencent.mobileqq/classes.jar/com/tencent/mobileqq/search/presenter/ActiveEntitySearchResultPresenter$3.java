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
      ActiveEntitySearchResultPresenter.a(this.jdField_a_of_type_ComTencentMobileqqSearchPresenterActiveEntitySearchResultPresenter, paramView);
      ActiveEntitySearchResultPresenter.a(this.jdField_a_of_type_ComTencentMobileqqSearchPresenterActiveEntitySearchResultPresenter, this.jdField_a_of_type_ComTencentMobileqqSearchModelGroupBaseNetSearchModelItem);
      if (ActiveEntitySearchResultPresenter.a(this.jdField_a_of_type_ComTencentMobileqqSearchPresenterActiveEntitySearchResultPresenter) != null)
      {
        ActiveEntitySearchResultPresenter.a(this.jdField_a_of_type_ComTencentMobileqqSearchPresenterActiveEntitySearchResultPresenter).addObserver(ActiveEntitySearchResultPresenter.a(this.jdField_a_of_type_ComTencentMobileqqSearchPresenterActiveEntitySearchResultPresenter));
        try
        {
          ((ITroopMngHandler)ActiveEntitySearchResultPresenter.a(this.jdField_a_of_type_ComTencentMobileqqSearchPresenterActiveEntitySearchResultPresenter).getBusinessHandler(BusinessHandlerFactory.TROOP_MNG_HANDLER)).a(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqSearchModelGroupBaseNetSearchModelItem.b), Long.valueOf(ActiveEntitySearchResultPresenter.a(this.jdField_a_of_type_ComTencentMobileqqSearchPresenterActiveEntitySearchResultPresenter).getCurrentUin()).longValue(), null);
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
        }
      }
      else
      {
        ActiveEntitySearchResultPresenter.a(this.jdField_a_of_type_ComTencentMobileqqSearchPresenterActiveEntitySearchResultPresenter, paramView.getContext(), this.jdField_a_of_type_ComTencentMobileqqSearchModelGroupBaseNetSearchModelItem);
        ActiveEntitySearchResultPresenter.a(this.jdField_a_of_type_ComTencentMobileqqSearchPresenterActiveEntitySearchResultPresenter);
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.search.presenter.ActiveEntitySearchResultPresenter.3
 * JD-Core Version:    0.7.0.1
 */