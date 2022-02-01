package com.tencent.mobileqq.search.base.presenter;

import android.text.TextUtils;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.search.base.view.ISearchResultGroupView;
import com.tencent.mobileqq.search.business.group.model.GroupSearchModelFooter;
import com.tencent.mobileqq.search.business.group.view.SearchResultGroupFooterView;
import com.tencent.mobileqq.search.model.IModel;

public class SearchResultGroupFooterViewPresenter
  implements IPresenter<IModel, ISearchResultGroupView>
{
  public void a(IModel paramIModel, ISearchResultGroupView paramISearchResultGroupView)
  {
    paramISearchResultGroupView = (SearchResultGroupFooterView)paramISearchResultGroupView;
    if ((paramIModel instanceof GroupSearchModelFooter))
    {
      paramIModel = (GroupSearchModelFooter)paramIModel;
      if (!TextUtils.isEmpty(paramIModel.a))
      {
        paramISearchResultGroupView.a.setVisibility(0);
        paramISearchResultGroupView.b.setText(paramIModel.a);
      }
      else
      {
        paramISearchResultGroupView.a.setVisibility(8);
      }
      paramISearchResultGroupView.a.setOnClickListener(new SearchResultGroupFooterViewPresenter.1(this, paramIModel));
      if (TextUtils.isEmpty(paramIModel.b)) {
        paramISearchResultGroupView.a.setEnabled(false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.search.base.presenter.SearchResultGroupFooterViewPresenter
 * JD-Core Version:    0.7.0.1
 */