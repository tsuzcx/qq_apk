package com.tencent.mobileqq.search.presenter;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.search.base.presenter.IFacePresenter;
import com.tencent.mobileqq.search.base.presenter.IPresenter;
import com.tencent.mobileqq.search.base.util.SearchViewUtils;
import com.tencent.mobileqq.search.base.view.ISearchResultGroupView;
import com.tencent.mobileqq.search.base.view.IView;
import com.tencent.mobileqq.search.base.view.SearchResultView;
import com.tencent.mobileqq.search.business.fts.view.FTSMessageSearchResultView;
import com.tencent.mobileqq.search.model.IModel;
import com.tencent.mobileqq.search.model.ISearchResultGroupModel;
import com.tencent.mobileqq.search.model.ISearchResultModel;
import com.tencent.mobileqq.search.model.ISearchResultPositionModel;
import com.tencent.mobileqq.search.view.SearchResultGroupMessageView;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import java.util.List;

public class SearchResultGroupMessagePresenter
  implements IPresenter<IModel, ISearchResultGroupView>
{
  private IFaceDecoder jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder;
  private SearchResultGroupPresenter jdField_a_of_type_ComTencentMobileqqSearchPresenterSearchResultGroupPresenter;
  boolean jdField_a_of_type_Boolean;
  
  public SearchResultGroupMessagePresenter(IFaceDecoder paramIFaceDecoder, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder = paramIFaceDecoder;
    this.jdField_a_of_type_ComTencentMobileqqSearchPresenterSearchResultGroupPresenter = new SearchResultGroupPresenter(paramIFaceDecoder, paramBoolean);
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void a(IModel paramIModel, ISearchResultGroupView paramISearchResultGroupView)
  {
    ISearchResultGroupModel localISearchResultGroupModel = (ISearchResultGroupModel)paramIModel;
    SearchResultGroupMessageView localSearchResultGroupMessageView = (SearchResultGroupMessageView)paramISearchResultGroupView;
    int i = localISearchResultGroupModel.a();
    LinearLayout localLinearLayout = localSearchResultGroupMessageView.a();
    ThemeUtil.isInNightMode(BaseApplicationImpl.getApplication().getRuntime());
    if (localLinearLayout != null)
    {
      List localList = localISearchResultGroupModel.a();
      if ((localList != null) && (!localList.isEmpty()))
      {
        localLinearLayout.removeAllViews();
        int k = Math.min(localList.size(), i);
        i = 0;
        while (i < k)
        {
          ISearchResultModel localISearchResultModel = (ISearchResultModel)localList.get(i);
          Object localObject;
          if (this.jdField_a_of_type_Boolean)
          {
            paramIModel = LayoutInflater.from(paramISearchResultGroupView.a().getContext()).inflate(2131562796, null);
            localObject = new FTSMessageSearchResultView(paramIModel);
          }
          else
          {
            paramIModel = LayoutInflater.from(paramISearchResultGroupView.a().getContext()).inflate(2131562795, null);
            localObject = new SearchResultView(paramIModel);
          }
          paramIModel.setTag(2131380884, localISearchResultModel);
          paramIModel.setTag(2131380889, localObject);
          paramIModel.setTag(2131380885, Integer.valueOf(i));
          paramIModel.setTag(2131380883, Integer.valueOf(localList.size()));
          paramIModel.setTag(2131380886, this.jdField_a_of_type_ComTencentMobileqqSearchPresenterSearchResultGroupPresenter);
          SearchViewUtils.a(localISearchResultModel, k, i);
          int m = localISearchResultModel.b();
          int n = localISearchResultModel.f_();
          int j;
          if ((localISearchResultModel instanceof ISearchResultPositionModel)) {
            j = ((ISearchResultPositionModel)localISearchResultModel).u;
          } else {
            j = 0;
          }
          SearchViewUtils.a(m, n, paramIModel, j);
          localLinearLayout.addView(paramIModel);
          if (this.jdField_a_of_type_ComTencentMobileqqSearchPresenterSearchResultGroupPresenter.a() != null) {
            this.jdField_a_of_type_ComTencentMobileqqSearchPresenterSearchResultGroupPresenter.a().a((IModel)localList.get(i), (IView)localObject);
          }
          i += 1;
        }
      }
    }
    paramIModel = localISearchResultGroupModel.a();
    if ((paramIModel != null) && (!paramIModel.isEmpty()))
    {
      localSearchResultGroupMessageView.jdField_b_of_type_AndroidViewView.setVisibility(8);
      return;
    }
    if (paramISearchResultGroupView.b() != null) {
      paramISearchResultGroupView.b().setVisibility(8);
    }
    localSearchResultGroupMessageView.jdField_b_of_type_AndroidViewView.setVisibility(0);
    localSearchResultGroupMessageView.jdField_b_of_type_AndroidViewView.setTag(2131380885, Integer.valueOf(-1));
    localSearchResultGroupMessageView.jdField_b_of_type_AndroidWidgetTextView.setText(localISearchResultGroupModel.b());
    localSearchResultGroupMessageView.c.setText(HardCodeUtil.a(2131713570));
    localSearchResultGroupMessageView.a.setImageResource(2130846216);
    localSearchResultGroupMessageView.jdField_b_of_type_AndroidViewView.setOnClickListener(new SearchResultGroupMessagePresenter.1(this, localISearchResultGroupModel));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.search.presenter.SearchResultGroupMessagePresenter
 * JD-Core Version:    0.7.0.1
 */