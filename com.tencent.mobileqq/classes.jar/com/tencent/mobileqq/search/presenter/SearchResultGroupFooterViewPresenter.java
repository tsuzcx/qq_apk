package com.tencent.mobileqq.search.presenter;

import ahuj;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.search.model.GroupSearchModelFooter;
import com.tencent.mobileqq.search.model.IModel;
import com.tencent.mobileqq.search.view.ISearchResultGroupView;
import com.tencent.mobileqq.search.view.SearchResultGroupFooterView;
import com.tencent.mobileqq.theme.ThemeUtil;

public class SearchResultGroupFooterViewPresenter
  implements IPresenter
{
  public void a(IModel paramIModel, ISearchResultGroupView paramISearchResultGroupView)
  {
    paramISearchResultGroupView = (SearchResultGroupFooterView)paramISearchResultGroupView;
    boolean bool;
    Resources localResources;
    if ((paramIModel instanceof GroupSearchModelFooter))
    {
      paramIModel = (GroupSearchModelFooter)paramIModel;
      if (TextUtils.isEmpty(paramIModel.a)) {
        break label123;
      }
      paramISearchResultGroupView.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      paramISearchResultGroupView.jdField_a_of_type_AndroidWidgetTextView.setText(paramIModel.a);
      paramISearchResultGroupView.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(new ahuj(this, paramIModel));
      bool = ThemeUtil.isInNightMode(BaseApplicationImpl.getApplication().getRuntime());
      localResources = paramISearchResultGroupView.a().getResources();
      if (TextUtils.isEmpty(paramIModel.b)) {
        break label147;
      }
      if (!bool) {
        break label135;
      }
      paramISearchResultGroupView.jdField_a_of_type_AndroidWidgetLinearLayout.setBackgroundResource(2130838580);
    }
    for (;;)
    {
      if (!bool) {
        break label193;
      }
      paramISearchResultGroupView.jdField_a_of_type_AndroidViewView.setBackgroundColor(localResources.getColor(2131492950));
      return;
      label123:
      paramISearchResultGroupView.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      break;
      label135:
      paramISearchResultGroupView.jdField_a_of_type_AndroidWidgetLinearLayout.setBackgroundResource(2130838579);
    }
    label147:
    if (bool) {
      paramISearchResultGroupView.jdField_a_of_type_AndroidWidgetLinearLayout.setBackgroundColor(localResources.getColor(2131492948));
    }
    for (;;)
    {
      paramISearchResultGroupView.jdField_a_of_type_AndroidWidgetLinearLayout.setEnabled(false);
      break;
      paramISearchResultGroupView.jdField_a_of_type_AndroidWidgetLinearLayout.setBackgroundColor(localResources.getColor(2131492969));
    }
    label193:
    paramISearchResultGroupView.jdField_a_of_type_AndroidViewView.setBackgroundColor(localResources.getColor(2131492949));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.search.presenter.SearchResultGroupFooterViewPresenter
 * JD-Core Version:    0.7.0.1
 */