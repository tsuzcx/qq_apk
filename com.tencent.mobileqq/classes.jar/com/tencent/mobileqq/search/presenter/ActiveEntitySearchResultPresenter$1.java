package com.tencent.mobileqq.search.presenter;

import android.view.View;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.search.model.GroupBaseNetSearchModelItem;
import com.tencent.mobileqq.troop.api.observer.TroopMngObserver;
import com.tencent.mobileqq.troop.utils.TroopNotifyHelper;
import com.tencent.qphone.base.util.QLog;

class ActiveEntitySearchResultPresenter$1
  extends TroopMngObserver
{
  ActiveEntitySearchResultPresenter$1(ActiveEntitySearchResultPresenter paramActiveEntitySearchResultPresenter) {}
  
  public void a(boolean paramBoolean, String paramString, int paramInt)
  {
    if ((ActiveEntitySearchResultPresenter.a(this.a) != null) && (ActiveEntitySearchResultPresenter.a(this.a).b.equals(paramString)))
    {
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder();
        paramString.append("onQueryJoinTroopCanNoVerify result:");
        paramString.append(paramBoolean);
        paramString.append("highRiskTroop");
        paramString.append(paramInt);
        QLog.d("Q.uniteSearch.ActiveEntitySearchResultPresenter", 2, paramString.toString());
      }
      ActiveEntitySearchResultPresenter.c(this.a).removeObserver(ActiveEntitySearchResultPresenter.b(this.a));
      if (ActiveEntitySearchResultPresenter.d(this.a) != null)
      {
        if ((paramBoolean) && (paramInt != 0))
        {
          TroopNotifyHelper.a(ActiveEntitySearchResultPresenter.d(this.a).getContext(), ActiveEntitySearchResultPresenter.e(this.a), new Object[] { ActiveEntitySearchResultPresenter.d(this.a), ActiveEntitySearchResultPresenter.a(this.a) });
          return;
        }
        paramString = this.a;
        ActiveEntitySearchResultPresenter.a(paramString, ActiveEntitySearchResultPresenter.d(paramString).getContext(), ActiveEntitySearchResultPresenter.a(this.a));
        ActiveEntitySearchResultPresenter.f(this.a);
      }
      return;
    }
    ActiveEntitySearchResultPresenter.c(this.a).removeObserver(ActiveEntitySearchResultPresenter.b(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.presenter.ActiveEntitySearchResultPresenter.1
 * JD-Core Version:    0.7.0.1
 */