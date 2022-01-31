package com.tencent.mobileqq.search.presenter;

import android.view.View;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.search.model.IModel;
import com.tencent.mobileqq.search.model.ISearchResultGroupModel;
import com.tencent.mobileqq.search.view.ISearchResultGroupView;
import com.tencent.mobileqq.search.view.ISearchResultView;
import com.tencent.mobileqq.search.view.IView;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.util.FaceDecoder;
import java.util.List;

public class SearchResultGroupPresenter
  implements IPresenter
{
  protected IFacePresenter a;
  private FaceDecoder a;
  
  public SearchResultGroupPresenter(FaceDecoder paramFaceDecoder)
  {
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder = paramFaceDecoder;
    this.jdField_a_of_type_ComTencentMobileqqSearchPresenterIFacePresenter = a(paramFaceDecoder);
  }
  
  public SearchResultGroupPresenter(FaceDecoder paramFaceDecoder, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder = paramFaceDecoder;
    this.jdField_a_of_type_ComTencentMobileqqSearchPresenterIFacePresenter = a(paramFaceDecoder, paramInt);
  }
  
  public SearchResultGroupPresenter(FaceDecoder paramFaceDecoder, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder = paramFaceDecoder;
    this.jdField_a_of_type_ComTencentMobileqqSearchPresenterIFacePresenter = a(paramFaceDecoder, paramBoolean);
  }
  
  public IFacePresenter a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqSearchPresenterIFacePresenter;
  }
  
  protected IFacePresenter a(FaceDecoder paramFaceDecoder)
  {
    return new SearchResultPresenter(paramFaceDecoder);
  }
  
  protected IFacePresenter a(FaceDecoder paramFaceDecoder, int paramInt)
  {
    return new ActiveEntitySearchResultPresenter(paramFaceDecoder, paramInt);
  }
  
  protected IFacePresenter a(FaceDecoder paramFaceDecoder, boolean paramBoolean)
  {
    if (!paramBoolean) {
      return a(paramFaceDecoder);
    }
    return new FTSMessageSearchResultPresenter(paramFaceDecoder);
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
        label82:
        int m;
        if (i < paramIModel.size())
        {
          j = 1;
          if (i >= ((List)localObject).size()) {
            break label328;
          }
          k = 1;
          if (i >= n) {
            break label334;
          }
          m = 1;
          label91:
          if ((m & k & j) == 0) {
            break label363;
          }
          ((ISearchResultView)paramIModel.get(i)).a().setVisibility(0);
          ((ISearchResultView)paramIModel.get(i)).a().setTag(2131362079, ((List)localObject).get(i));
          ((ISearchResultView)paramIModel.get(i)).a().setTag(2131362078, paramIModel.get(i));
          ((ISearchResultView)paramIModel.get(i)).a().setTag(2131362080, Integer.valueOf(i));
          ((ISearchResultView)paramIModel.get(i)).a().setTag(2131362081, Integer.valueOf(paramIModel.size()));
          ((ISearchResultView)paramIModel.get(i)).a().setTag(2131362077, this.jdField_a_of_type_ComTencentMobileqqSearchPresenterIFacePresenter);
          if (!ThemeUtil.isInNightMode(BaseApplicationImpl.getApplication().getRuntime())) {
            break label340;
          }
          ((ISearchResultView)paramIModel.get(i)).a().setBackgroundResource(2130838580);
        }
        for (;;)
        {
          this.jdField_a_of_type_ComTencentMobileqqSearchPresenterIFacePresenter.a((IModel)((List)localObject).get(i), (IView)paramIModel.get(i));
          i += 1;
          break;
          j = 0;
          break label68;
          label328:
          k = 0;
          break label82;
          label334:
          m = 0;
          break label91;
          label340:
          ((ISearchResultView)paramIModel.get(i)).a().setBackgroundResource(2130838579);
        }
        label363:
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.search.presenter.SearchResultGroupPresenter
 * JD-Core Version:    0.7.0.1
 */