package com.tencent.mobileqq.search.presenter;

import android.view.View;
import com.tencent.mobileqq.activity.contact.troop.TroopNotifyHelper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopBusinessObserver;
import com.tencent.mobileqq.search.model.GroupBaseNetSearchModelItem;
import com.tencent.qphone.base.util.QLog;

class ActiveEntitySearchResultPresenter$1
  extends TroopBusinessObserver
{
  ActiveEntitySearchResultPresenter$1(ActiveEntitySearchResultPresenter paramActiveEntitySearchResultPresenter) {}
  
  public void onQueryJoinTroopWhetherHighRisk(boolean paramBoolean, String paramString, int paramInt)
  {
    if ((ActiveEntitySearchResultPresenter.a(this.a) == null) || (!ActiveEntitySearchResultPresenter.a(this.a).b.equals(paramString))) {
      ActiveEntitySearchResultPresenter.a(this.a).removeObserver(ActiveEntitySearchResultPresenter.a(this.a));
    }
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("Q.uniteSearch.ActiveEntitySearchResultPresenter", 2, "onQueryJoinTroopCanNoVerify result:" + paramBoolean + "highRiskTroop" + paramInt);
      }
      ActiveEntitySearchResultPresenter.a(this.a).removeObserver(ActiveEntitySearchResultPresenter.a(this.a));
    } while (ActiveEntitySearchResultPresenter.a(this.a) == null);
    if ((paramBoolean) && (paramInt != 0))
    {
      TroopNotifyHelper.a(ActiveEntitySearchResultPresenter.a(this.a).getContext(), ActiveEntitySearchResultPresenter.a(this.a), new Object[] { ActiveEntitySearchResultPresenter.a(this.a), ActiveEntitySearchResultPresenter.a(this.a) });
      return;
    }
    ActiveEntitySearchResultPresenter.a(this.a, ActiveEntitySearchResultPresenter.a(this.a).getContext(), ActiveEntitySearchResultPresenter.a(this.a));
    ActiveEntitySearchResultPresenter.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.search.presenter.ActiveEntitySearchResultPresenter.1
 * JD-Core Version:    0.7.0.1
 */