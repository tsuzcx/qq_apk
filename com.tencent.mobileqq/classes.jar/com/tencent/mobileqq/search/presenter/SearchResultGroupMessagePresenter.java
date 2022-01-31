package com.tencent.mobileqq.search.presenter;

import ahuk;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.search.model.IModel;
import com.tencent.mobileqq.search.model.ISearchResultGroupModel;
import com.tencent.mobileqq.search.model.ISearchResultModel;
import com.tencent.mobileqq.search.util.SearchViewUtils;
import com.tencent.mobileqq.search.view.FTSMessageSearchResultView;
import com.tencent.mobileqq.search.view.ISearchResultGroupView;
import com.tencent.mobileqq.search.view.SearchResultGroupMessageView;
import com.tencent.mobileqq.search.view.SearchResultView;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.util.FaceDecoder;
import java.util.List;

public class SearchResultGroupMessagePresenter
  implements IPresenter
{
  private SearchResultGroupPresenter jdField_a_of_type_ComTencentMobileqqSearchPresenterSearchResultGroupPresenter;
  private FaceDecoder jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder;
  boolean jdField_a_of_type_Boolean;
  
  public SearchResultGroupMessagePresenter(FaceDecoder paramFaceDecoder, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder = paramFaceDecoder;
    this.jdField_a_of_type_ComTencentMobileqqSearchPresenterSearchResultGroupPresenter = new SearchResultGroupPresenter(paramFaceDecoder, paramBoolean);
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void a(IModel paramIModel, ISearchResultGroupView paramISearchResultGroupView)
  {
    ISearchResultGroupModel localISearchResultGroupModel = (ISearchResultGroupModel)paramIModel;
    SearchResultGroupMessageView localSearchResultGroupMessageView = (SearchResultGroupMessageView)paramISearchResultGroupView;
    int i = localISearchResultGroupModel.a();
    LinearLayout localLinearLayout = localSearchResultGroupMessageView.a();
    boolean bool = ThemeUtil.isInNightMode(BaseApplicationImpl.getApplication().getRuntime());
    if (localLinearLayout != null)
    {
      List localList = localISearchResultGroupModel.a();
      if ((localList != null) && (!localList.isEmpty()))
      {
        localLinearLayout.removeAllViews();
        int j = Math.min(localList.size(), i);
        i = 0;
        if (i < j)
        {
          ISearchResultModel localISearchResultModel = (ISearchResultModel)localList.get(i);
          View localView1;
          label143:
          View localView2;
          Resources localResources;
          if (this.jdField_a_of_type_Boolean)
          {
            localView1 = LayoutInflater.from(paramISearchResultGroupView.a().getContext()).inflate(2130971540, null);
            paramIModel = new FTSMessageSearchResultView(localView1);
            localView2 = localView1.findViewById(2131365685);
            localView1.setTag(2131362079, localISearchResultModel);
            localView1.setTag(2131362078, paramIModel);
            localView1.setTag(2131362080, Integer.valueOf(i));
            localView1.setTag(2131362081, Integer.valueOf(localList.size()));
            localView1.setTag(2131362077, this.jdField_a_of_type_ComTencentMobileqqSearchPresenterSearchResultGroupPresenter);
            localResources = localView1.getResources();
            if (!bool) {
              break label347;
            }
            localView1.setBackgroundColor(localResources.getColor(2131492948));
            localView2.setBackgroundResource(2130838580);
          }
          for (;;)
          {
            SearchViewUtils.a(localISearchResultModel, j, i);
            SearchViewUtils.a(localISearchResultModel.c(), localISearchResultModel.d(), localView1);
            localLinearLayout.addView(localView1);
            if (this.jdField_a_of_type_ComTencentMobileqqSearchPresenterSearchResultGroupPresenter.a() != null) {
              this.jdField_a_of_type_ComTencentMobileqqSearchPresenterSearchResultGroupPresenter.a().a((IModel)localList.get(i), paramIModel);
            }
            i += 1;
            break;
            localView1 = LayoutInflater.from(paramISearchResultGroupView.a().getContext()).inflate(2130971539, null);
            paramIModel = new SearchResultView(localView1);
            break label143;
            label347:
            localView1.setBackgroundColor(localResources.getColor(2131492969));
            localView2.setBackgroundResource(2130838579);
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
      if (bool) {
        localSearchResultGroupMessageView.jdField_a_of_type_AndroidViewView.setBackgroundResource(2130838580);
      }
      for (;;)
      {
        localSearchResultGroupMessageView.jdField_a_of_type_AndroidViewView.setTag(2131362080, Integer.valueOf(-1));
        localSearchResultGroupMessageView.jdField_a_of_type_AndroidWidgetTextView.setText(localISearchResultGroupModel.b());
        localSearchResultGroupMessageView.b.setText("查找更多聊天记录");
        localSearchResultGroupMessageView.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130843264);
        localSearchResultGroupMessageView.jdField_a_of_type_AndroidViewView.setOnClickListener(new ahuk(this, localISearchResultGroupModel));
        return;
        localSearchResultGroupMessageView.jdField_a_of_type_AndroidViewView.setBackgroundResource(2130838579);
      }
    }
    localSearchResultGroupMessageView.b().setVisibility(8);
    localSearchResultGroupMessageView.jdField_a_of_type_AndroidViewView.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.search.presenter.SearchResultGroupMessagePresenter
 * JD-Core Version:    0.7.0.1
 */