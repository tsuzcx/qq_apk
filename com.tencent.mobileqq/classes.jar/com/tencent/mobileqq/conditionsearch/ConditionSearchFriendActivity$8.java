package com.tencent.mobileqq.conditionsearch;

import SummaryCard.CondFitUser;
import com.tencent.mobileqq.app.ConditionSearchManager;
import com.tencent.mobileqq.app.ConditionSearchManager.ISearchListener;
import com.tencent.mobileqq.widget.QQToast;
import java.util.List;

class ConditionSearchFriendActivity$8
  implements ConditionSearchManager.ISearchListener
{
  ConditionSearchFriendActivity$8(ConditionSearchFriendActivity paramConditionSearchFriendActivity) {}
  
  public void a(boolean paramBoolean1, List<CondFitUser> paramList, boolean paramBoolean2, int paramInt)
  {
    this.a.a();
    if (paramInt != 1) {
      return;
    }
    if (!paramBoolean1)
    {
      QQToast.makeText(this.a, 2131887992, 0).show(this.a.getTitleBarHeight());
      return;
    }
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      ConditionSearchFriendActivity localConditionSearchFriendActivity = this.a;
      SearchResultActivity.a(localConditionSearchFriendActivity, localConditionSearchFriendActivity.b, this.a.d, this.a.e, this.a.c, this.a.a.k(), this.a.a.l(), this.a.g, this.a.f, paramList, paramBoolean2);
      return;
    }
    QQToast.makeText(this.a, 2131887995, 0).show(this.a.getTitleBarHeight());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.conditionsearch.ConditionSearchFriendActivity.8
 * JD-Core Version:    0.7.0.1
 */