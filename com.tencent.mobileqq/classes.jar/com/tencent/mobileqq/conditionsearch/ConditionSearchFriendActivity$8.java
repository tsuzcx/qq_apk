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
      QQToast.a(this.a, 2131691126, 0).b(this.a.getTitleBarHeight());
      return;
    }
    if ((paramList == null) || (paramList.isEmpty()))
    {
      QQToast.a(this.a, 2131691129, 0).b(this.a.getTitleBarHeight());
      return;
    }
    SearchResultActivity.a(this.a, this.a.jdField_a_of_type_JavaLangString, this.a.b, this.a.c, this.a.jdField_a_of_type_Int, this.a.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.b(), this.a.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.c(), this.a.e, this.a.d, paramList, paramBoolean2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.conditionsearch.ConditionSearchFriendActivity.8
 * JD-Core Version:    0.7.0.1
 */