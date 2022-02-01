package com.tencent.mobileqq.search.presenter;

import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.search.model.GroupSearchModelMoreItem;
import com.tencent.mobileqq.search.model.IModel;
import com.tencent.mobileqq.search.model.ISearchResultGroupModel;
import com.tencent.mobileqq.search.view.ISearchResultGroupView;
import com.tencent.mobileqq.statistics.ReportController;

public class SearchResultGroupMorePresenter
  implements IPresenter<IModel, ISearchResultGroupView>
{
  public void a(IModel paramIModel, ISearchResultGroupView paramISearchResultGroupView)
  {
    paramIModel = (ISearchResultGroupModel)paramIModel;
    paramISearchResultGroupView.b().setText(paramIModel.b());
    paramISearchResultGroupView.a().setOnClickListener(new SearchResultGroupMorePresenter.1(this, paramIModel));
    if ((paramIModel instanceof GroupSearchModelMoreItem)) {
      ReportController.b(null, "CliOper", "", "", "0X80061B6", "0X80061B6", 0, 0, "", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.search.presenter.SearchResultGroupMorePresenter
 * JD-Core Version:    0.7.0.1
 */