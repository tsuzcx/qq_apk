package com.tencent.mobileqq.search.presenter;

import com.tencent.mobileqq.search.model.GroupBaseNetSearchModelItem;
import com.tencent.mobileqq.troop.activity.JoinTroopUtil.JoinTroopCallback;

class ActiveEntitySearchResultPresenter$6
  implements JoinTroopUtil.JoinTroopCallback
{
  ActiveEntitySearchResultPresenter$6(ActiveEntitySearchResultPresenter paramActiveEntitySearchResultPresenter, GroupBaseNetSearchModelItem paramGroupBaseNetSearchModelItem) {}
  
  public void a(String paramString, int paramInt)
  {
    if ((this.a.b != null) && (this.a.b.equals(paramString)))
    {
      if (paramInt == 3) {
        this.a.R = 2;
      } else if ((paramInt != 2) && (paramInt != 4))
      {
        if (paramInt == 1) {
          this.a.R = 0;
        }
      }
      else {
        this.a.R = 1;
      }
      this.b.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.presenter.ActiveEntitySearchResultPresenter.6
 * JD-Core Version:    0.7.0.1
 */