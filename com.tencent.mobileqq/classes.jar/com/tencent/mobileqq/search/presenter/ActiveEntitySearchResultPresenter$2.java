package com.tencent.mobileqq.search.presenter;

import android.view.View;
import com.tencent.mobileqq.search.model.GroupBaseNetSearchModelItem;
import com.tencent.mobileqq.troop.utils.TroopNotifyHelper.OnTroopSafeDialogClickConfirm;

class ActiveEntitySearchResultPresenter$2
  implements TroopNotifyHelper.OnTroopSafeDialogClickConfirm
{
  ActiveEntitySearchResultPresenter$2(ActiveEntitySearchResultPresenter paramActiveEntitySearchResultPresenter) {}
  
  public void a(Object... paramVarArgs)
  {
    if ((paramVarArgs != null) && (paramVarArgs.length == 2))
    {
      View localView = (View)paramVarArgs[0];
      paramVarArgs = (GroupBaseNetSearchModelItem)paramVarArgs[1];
      ActiveEntitySearchResultPresenter.a(this.a, localView.getContext(), paramVarArgs);
      ActiveEntitySearchResultPresenter.a(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.search.presenter.ActiveEntitySearchResultPresenter.2
 * JD-Core Version:    0.7.0.1
 */