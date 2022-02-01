package com.tencent.mobileqq.search.presenter;

import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.search.model.IModel;
import com.tencent.mobileqq.search.model.ISearchResultGroupModel;
import com.tencent.mobileqq.search.model.ISearchResultModel;
import com.tencent.mobileqq.search.view.ISearchResultGroupView;
import com.tencent.mobileqq.search.view.ISearchResultView;
import com.tencent.mobileqq.search.view.IView;
import java.util.List;

public class SearchResultGroupPresenter
  implements IPresenter<IModel, ISearchResultGroupView>
{
  private IFaceDecoder a;
  protected IFacePresenter a;
  
  public SearchResultGroupPresenter(IFaceDecoder paramIFaceDecoder)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder = paramIFaceDecoder;
    this.jdField_a_of_type_ComTencentMobileqqSearchPresenterIFacePresenter = a(paramIFaceDecoder);
  }
  
  public SearchResultGroupPresenter(IFaceDecoder paramIFaceDecoder, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder = paramIFaceDecoder;
    this.jdField_a_of_type_ComTencentMobileqqSearchPresenterIFacePresenter = a(paramIFaceDecoder, paramInt);
  }
  
  public SearchResultGroupPresenter(IFaceDecoder paramIFaceDecoder, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder = paramIFaceDecoder;
    this.jdField_a_of_type_ComTencentMobileqqSearchPresenterIFacePresenter = a(paramIFaceDecoder, paramBoolean);
  }
  
  public IFacePresenter a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqSearchPresenterIFacePresenter;
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
  
  public void a(IModel paramIModel, ISearchResultGroupView paramISearchResultGroupView)
  {
    int i = 0;
    Object localObject = (ISearchResultGroupModel)paramIModel;
    a(paramISearchResultGroupView, (ISearchResultGroupModel)localObject);
    int n = ((ISearchResultGroupModel)localObject).a();
    paramIModel = paramISearchResultGroupView.a();
    if ((paramIModel != null) && (paramIModel != null))
    {
      localObject = ((ISearchResultGroupModel)localObject).a();
      if (localObject != null)
      {
        i = 0;
        int j;
        label68:
        int k;
        if (i < paramIModel.size())
        {
          j = 1;
          if (i >= ((List)localObject).size()) {
            break label296;
          }
          k = 1;
          label82:
          if (i >= n) {
            break label302;
          }
        }
        label296:
        label302:
        for (int m = 1;; m = 0)
        {
          if ((m & k & j) == 0) {
            break label308;
          }
          ((ISearchResultView)paramIModel.get(i)).a().setVisibility(0);
          ((ISearchResultView)paramIModel.get(i)).a().setTag(2131381651, ((List)localObject).get(i));
          ((ISearchResultView)paramIModel.get(i)).a().setTag(2131381656, paramIModel.get(i));
          ((ISearchResultView)paramIModel.get(i)).a().setTag(2131381652, Integer.valueOf(i));
          ((ISearchResultView)paramIModel.get(i)).a().setTag(2131381650, Integer.valueOf(paramIModel.size()));
          ((ISearchResultView)paramIModel.get(i)).a().setTag(2131381653, this.jdField_a_of_type_ComTencentMobileqqSearchPresenterIFacePresenter);
          this.jdField_a_of_type_ComTencentMobileqqSearchPresenterIFacePresenter.a((IModel)((List)localObject).get(i), (IView)paramIModel.get(i));
          i += 1;
          break;
          j = 0;
          break label68;
          k = 0;
          break label82;
        }
        label308:
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
  
  protected void a(ISearchResultGroupView paramISearchResultGroupView, ISearchResultGroupModel paramISearchResultGroupModel)
  {
    if (paramISearchResultGroupView.a() != null) {
      paramISearchResultGroupView.a().setText(paramISearchResultGroupModel.a());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.search.presenter.SearchResultGroupPresenter
 * JD-Core Version:    0.7.0.1
 */