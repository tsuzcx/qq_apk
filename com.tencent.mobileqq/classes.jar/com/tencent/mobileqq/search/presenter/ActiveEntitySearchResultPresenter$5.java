package com.tencent.mobileqq.search.presenter;

import com.tencent.mobileqq.search.model.GroupBaseNetSearchModelItem;
import com.tencent.mobileqq.troop.activity.JoinTroopUtil.JoinTroopCallback;

class ActiveEntitySearchResultPresenter$5
  implements JoinTroopUtil.JoinTroopCallback
{
  ActiveEntitySearchResultPresenter$5(ActiveEntitySearchResultPresenter paramActiveEntitySearchResultPresenter, GroupBaseNetSearchModelItem paramGroupBaseNetSearchModelItem) {}
  
  public void a(String paramString, int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqSearchModelGroupBaseNetSearchModelItem.b != null) && (this.jdField_a_of_type_ComTencentMobileqqSearchModelGroupBaseNetSearchModelItem.b.equals(paramString)))
    {
      if (paramInt != 3) {
        break label45;
      }
      this.jdField_a_of_type_ComTencentMobileqqSearchModelGroupBaseNetSearchModelItem.m = 2;
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqSearchPresenterActiveEntitySearchResultPresenter.a();
      return;
      label45:
      if ((paramInt == 2) || (paramInt == 4)) {
        this.jdField_a_of_type_ComTencentMobileqqSearchModelGroupBaseNetSearchModelItem.m = 1;
      } else if (paramInt == 1) {
        this.jdField_a_of_type_ComTencentMobileqqSearchModelGroupBaseNetSearchModelItem.m = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.search.presenter.ActiveEntitySearchResultPresenter.5
 * JD-Core Version:    0.7.0.1
 */