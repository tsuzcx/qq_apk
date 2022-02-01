package com.tencent.mobileqq.search.presenter;

import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.search.base.presenter.IFacePresenter;
import com.tencent.mobileqq.search.base.presenter.IPresenter;
import com.tencent.mobileqq.search.base.presenter.SearchResultPresenter;
import com.tencent.mobileqq.search.base.view.ISearchResultGroupView;
import com.tencent.mobileqq.search.base.view.ISearchResultView;
import com.tencent.mobileqq.search.base.view.IView;
import com.tencent.mobileqq.search.model.IModel;
import com.tencent.mobileqq.search.model.ISearchResultGroupModel;
import com.tencent.mobileqq.search.model.ISearchResultModel;
import java.util.List;

public class SearchResultGroupPresenter
  implements IPresenter<IModel, ISearchResultGroupView>
{
  private IFaceDecoder a;
  protected IFacePresenter a;
  
  public SearchResultGroupPresenter(IFaceDecoder paramIFaceDecoder)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder = paramIFaceDecoder;
    this.jdField_a_of_type_ComTencentMobileqqSearchBasePresenterIFacePresenter = a(paramIFaceDecoder);
  }
  
  public SearchResultGroupPresenter(IFaceDecoder paramIFaceDecoder, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder = paramIFaceDecoder;
    this.jdField_a_of_type_ComTencentMobileqqSearchBasePresenterIFacePresenter = a(paramIFaceDecoder, paramInt);
  }
  
  public SearchResultGroupPresenter(IFaceDecoder paramIFaceDecoder, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder = paramIFaceDecoder;
    this.jdField_a_of_type_ComTencentMobileqqSearchBasePresenterIFacePresenter = a(paramIFaceDecoder, paramBoolean);
  }
  
  public IFacePresenter a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqSearchBasePresenterIFacePresenter;
  }
  
  protected IFacePresenter<ISearchResultModel, ISearchResultView> a(IFaceDecoder paramIFaceDecoder)
  {
    return new SearchResultPresenter(paramIFaceDecoder);
  }
  
  protected IFacePresenter<ISearchResultModel, ISearchResultView> a(IFaceDecoder paramIFaceDecoder, int paramInt)
  {
    return new ActiveEntitySearchResultPresenter(paramIFaceDecoder, paramInt);
  }
  
  protected IFacePresenter<ISearchResultModel, ISearchResultView> a(IFaceDecoder paramIFaceDecoder, boolean paramBoolean)
  {
    if (!paramBoolean) {
      return a(paramIFaceDecoder);
    }
    return new FTSMessageSearchResultPresenter(paramIFaceDecoder);
  }
  
  protected void a(ISearchResultGroupView paramISearchResultGroupView, ISearchResultGroupModel paramISearchResultGroupModel)
  {
    if (paramISearchResultGroupView.a() != null) {
      paramISearchResultGroupView.a().setText(paramISearchResultGroupModel.a());
    }
  }
  
  public void a(IModel paramIModel, ISearchResultGroupView paramISearchResultGroupView)
  {
    Object localObject = (ISearchResultGroupModel)paramIModel;
    a(paramISearchResultGroupView, (ISearchResultGroupModel)localObject);
    int n = ((ISearchResultGroupModel)localObject).a();
    paramIModel = paramISearchResultGroupView.a();
    if ((paramIModel != null) && (paramIModel != null))
    {
      localObject = ((ISearchResultGroupModel)localObject).a();
      int i = 0;
      if (localObject != null)
      {
        i = 0;
        for (;;)
        {
          int j = paramIModel.size();
          int m = 1;
          if (i < j) {
            j = 1;
          } else {
            j = 0;
          }
          int k;
          if (i < ((List)localObject).size()) {
            k = 1;
          } else {
            k = 0;
          }
          if (i >= n) {
            m = 0;
          }
          if ((j & k & m) == 0) {
            break;
          }
          ((ISearchResultView)paramIModel.get(i)).a().setVisibility(0);
          ((ISearchResultView)paramIModel.get(i)).a().setTag(2131380884, ((List)localObject).get(i));
          ((ISearchResultView)paramIModel.get(i)).a().setTag(2131380889, paramIModel.get(i));
          ((ISearchResultView)paramIModel.get(i)).a().setTag(2131380885, Integer.valueOf(i));
          ((ISearchResultView)paramIModel.get(i)).a().setTag(2131380883, Integer.valueOf(paramIModel.size()));
          ((ISearchResultView)paramIModel.get(i)).a().setTag(2131380886, this.jdField_a_of_type_ComTencentMobileqqSearchBasePresenterIFacePresenter);
          this.jdField_a_of_type_ComTencentMobileqqSearchBasePresenterIFacePresenter.a((IModel)((List)localObject).get(i), (IView)paramIModel.get(i));
          i += 1;
        }
        i = Math.min(((List)localObject).size(), n);
        while (i < paramIModel.size())
        {
          ((ISearchResultView)paramIModel.get(i)).a().setVisibility(8);
          i += 1;
        }
      }
      while (i < paramIModel.size())
      {
        ((ISearchResultView)paramIModel.get(i)).a().setVisibility(8);
        i += 1;
      }
    }
    if (paramISearchResultGroupView.b() != null) {
      paramISearchResultGroupView.b().setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.search.presenter.SearchResultGroupPresenter
 * JD-Core Version:    0.7.0.1
 */