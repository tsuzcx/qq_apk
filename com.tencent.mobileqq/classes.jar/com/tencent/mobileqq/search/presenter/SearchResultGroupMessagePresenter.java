package com.tencent.mobileqq.search.presenter;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.search.model.IModel;
import com.tencent.mobileqq.search.model.ISearchResultGroupModel;
import com.tencent.mobileqq.search.model.ISearchResultModel;
import com.tencent.mobileqq.search.model.ISearchResultPositionModel;
import com.tencent.mobileqq.search.util.SearchViewUtils;
import com.tencent.mobileqq.search.view.FTSMessageSearchResultView;
import com.tencent.mobileqq.search.view.ISearchResultGroupView;
import com.tencent.mobileqq.search.view.SearchResultGroupMessageView;
import com.tencent.mobileqq.search.view.SearchResultView;
import com.tencent.mobileqq.theme.ThemeUtil;
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
        if (i < k)
        {
          ISearchResultModel localISearchResultModel = (ISearchResultModel)localList.get(i);
          View localView;
          label142:
          int m;
          int n;
          if (this.jdField_a_of_type_Boolean)
          {
            localView = LayoutInflater.from(paramISearchResultGroupView.a().getContext()).inflate(2131562977, null);
            paramIModel = new FTSMessageSearchResultView(localView);
            localView.setTag(2131381651, localISearchResultModel);
            localView.setTag(2131381656, paramIModel);
            localView.setTag(2131381652, Integer.valueOf(i));
            localView.setTag(2131381650, Integer.valueOf(localList.size()));
            localView.setTag(2131381653, this.jdField_a_of_type_ComTencentMobileqqSearchPresenterSearchResultGroupPresenter);
            SearchViewUtils.a(localISearchResultModel, k, i);
            m = localISearchResultModel.a();
            n = localISearchResultModel.b();
            if (!(localISearchResultModel instanceof ISearchResultPositionModel)) {
              break label334;
            }
          }
          label334:
          for (int j = ((ISearchResultPositionModel)localISearchResultModel).u;; j = 0)
          {
            SearchViewUtils.a(m, n, localView, j);
            localLinearLayout.addView(localView);
            if (this.jdField_a_of_type_ComTencentMobileqqSearchPresenterSearchResultGroupPresenter.a() != null) {
              this.jdField_a_of_type_ComTencentMobileqqSearchPresenterSearchResultGroupPresenter.a().a((IModel)localList.get(i), paramIModel);
            }
            i += 1;
            break;
            localView = LayoutInflater.from(paramISearchResultGroupView.a().getContext()).inflate(2131562976, null);
            paramIModel = new SearchResultView(localView);
            break label142;
          }
        }
      }
    }
    paramIModel = localISearchResultGroupModel.a();
    if ((paramIModel == null) || (paramIModel.isEmpty()))
    {
      if (paramISearchResultGroupView.b() != null) {
        paramISearchResultGroupView.b().setVisibility(8);
      }
      localSearchResultGroupMessageView.jdField_a_of_type_AndroidViewView.setVisibility(0);
      localSearchResultGroupMessageView.jdField_a_of_type_AndroidViewView.setTag(2131381652, Integer.valueOf(-1));
      localSearchResultGroupMessageView.jdField_a_of_type_AndroidWidgetTextView.setText(localISearchResultGroupModel.b());
      localSearchResultGroupMessageView.b.setText(HardCodeUtil.a(2131713603));
      localSearchResultGroupMessageView.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130846343);
      localSearchResultGroupMessageView.jdField_a_of_type_AndroidViewView.setOnClickListener(new SearchResultGroupMessagePresenter.1(this, localISearchResultGroupModel));
      return;
    }
    localSearchResultGroupMessageView.jdField_a_of_type_AndroidViewView.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.search.presenter.SearchResultGroupMessagePresenter
 * JD-Core Version:    0.7.0.1
 */