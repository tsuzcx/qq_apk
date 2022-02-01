package com.tencent.mobileqq.troop.homework.recite.ui;

import android.text.Editable;
import android.text.TextWatcher;
import com.tencent.biz.qqstory.view.widget.LoadingMoreHelper;
import com.tencent.mobileqq.troop.widget.LoadMoreXListView;

class SearchReciteArticleFragment$1
  implements TextWatcher
{
  SearchReciteArticleFragment$1(SearchReciteArticleFragment paramSearchReciteArticleFragment) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    if (paramEditable.length() == 0)
    {
      this.a.e();
      this.a.a(false);
      return;
    }
    this.a.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiSearchReciteArticleFragment$SearchResultListAdapter.a();
    this.a.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiSearchReciteArticleFragment$SearchResultListAdapter.notifyDataSetChanged();
    this.a.jdField_a_of_type_ComTencentMobileqqTroopWidgetLoadMoreXListView.a.a(false);
    this.a.b = 0;
    this.a.a(true);
    paramEditable = paramEditable.toString();
    this.a.b(paramEditable);
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.recite.ui.SearchReciteArticleFragment.1
 * JD-Core Version:    0.7.0.1
 */