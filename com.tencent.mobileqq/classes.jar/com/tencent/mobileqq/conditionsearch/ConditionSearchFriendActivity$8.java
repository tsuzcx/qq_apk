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
      QQToast.a(this.a, 2131691046, 0).b(this.a.getTitleBarHeight());
      return;
    }
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      ConditionSearchFriendActivity localConditionSearchFriendActivity = this.a;
      SearchResultActivity.a(localConditionSearchFriendActivity, localConditionSearchFriendActivity.jdField_a_of_type_JavaLangString, this.a.b, this.a.c, this.a.jdField_a_of_type_Int, this.a.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.b(), this.a.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.c(), this.a.e, this.a.d, paramList, paramBoolean2);
      return;
    }
    QQToast.a(this.a, 2131691049, 0).b(this.a.getTitleBarHeight());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.conditionsearch.ConditionSearchFriendActivity.8
 * JD-Core Version:    0.7.0.1
 */