package com.tencent.mobileqq.search.presenter;

import android.text.TextUtils;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.search.model.GroupSearchModelFooter;
import com.tencent.mobileqq.search.model.IModel;
import com.tencent.mobileqq.search.view.ISearchResultGroupView;
import com.tencent.mobileqq.search.view.SearchResultGroupFooterView;

public class SearchResultGroupFooterViewPresenter
  implements IPresenter<IModel, ISearchResultGroupView>
{
  public void a(IModel paramIModel, ISearchResultGroupView paramISearchResultGroupView)
  {
    paramISearchResultGroupView = (SearchResultGroupFooterView)paramISearchResultGroupView;
    if ((paramIModel instanceof GroupSearchModelFooter))
    {
      paramIModel = (GroupSearchModelFooter)paramIModel;
      if (TextUtils.isEmpty(paramIModel.a)) {
        break label81;
      }
      paramISearchResultGroupView.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      paramISearchResultGroupView.jdField_a_of_type_AndroidWidgetTextView.setText(paramIModel.a);
    }
    for (;;)
    {
      paramISearchResultGroupView.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(new SearchResultGroupFooterViewPresenter.1(this, paramIModel));
      if (TextUtils.isEmpty(paramIModel.b)) {
        paramISearchResultGroupView.jdField_a_of_type_AndroidWidgetLinearLayout.setEnabled(false);
      }
      return;
      label81:
      paramISearchResultGroupView.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.search.presenter.SearchResultGroupFooterViewPresenter
 * JD-Core Version:    0.7.0.1
 */