package com.tencent.mobileqq.search.presenter;

import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.search.base.presenter.IFacePresenter;
import com.tencent.mobileqq.search.base.util.SearchViewUtils;
import com.tencent.mobileqq.search.base.view.ISearchResultGroupView;
import com.tencent.mobileqq.search.base.view.ISearchResultView;
import com.tencent.mobileqq.search.base.view.IView;
import com.tencent.mobileqq.search.model.IModel;
import com.tencent.mobileqq.search.model.ISearchResultGroupModel;
import com.tencent.mobileqq.search.model.ISearchResultModel;
import com.tencent.mobileqq.search.model.ISearchResultPositionModel;
import java.util.List;

public class PublicAcntSearchResultGroupPresenter
  extends SearchResultGroupPresenter
{
  public PublicAcntSearchResultGroupPresenter(IFaceDecoder paramIFaceDecoder)
  {
    super(paramIFaceDecoder);
  }
  
  protected IFacePresenter<ISearchResultModel, ISearchResultView> a(IFaceDecoder paramIFaceDecoder)
  {
    return new PublicAcntSearchResultPresenter(paramIFaceDecoder);
  }
  
  public void a(IModel paramIModel, ISearchResultGroupView paramISearchResultGroupView)
  {
    Object localObject = (ISearchResultGroupModel)paramIModel;
    a(paramISearchResultGroupView, (ISearchResultGroupModel)localObject);
    int k = ((ISearchResultGroupModel)localObject).d();
    paramIModel = paramISearchResultGroupView.c();
    if ((paramIModel != null) && (paramIModel != null))
    {
      localObject = ((ISearchResultGroupModel)localObject).b();
      int i = 0;
      if (localObject != null)
      {
        int m = Math.min(Math.min(paramIModel.size(), ((List)localObject).size()), k);
        i = 0;
        while (i < m)
        {
          ((ISearchResultView)paramIModel.get(i)).h().setVisibility(0);
          ((ISearchResultView)paramIModel.get(i)).h().setTag(2131449867, ((List)localObject).get(i));
          ((ISearchResultView)paramIModel.get(i)).h().setTag(2131449873, paramIModel.get(i));
          ((ISearchResultView)paramIModel.get(i)).h().setTag(2131449868, Integer.valueOf(i));
          ((ISearchResultView)paramIModel.get(i)).h().setTag(2131449866, Integer.valueOf(paramIModel.size()));
          ((ISearchResultView)paramIModel.get(i)).h().setTag(2131449869, this.a);
          SearchViewUtils.a((ISearchResultModel)((List)localObject).get(i), m, i);
          int n = ((ISearchResultModel)((List)localObject).get(i)).ck_();
          int i1 = ((ISearchResultModel)((List)localObject).get(i)).cl_();
          View localView = ((ISearchResultView)paramIModel.get(i)).h();
          int j;
          if ((((List)localObject).get(i) instanceof ISearchResultPositionModel)) {
            j = ((ISearchResultPositionModel)((List)localObject).get(i)).af;
          } else {
            j = 0;
          }
          SearchViewUtils.a(n, i1, localView, j);
          this.a.a((IModel)((List)localObject).get(i), (IView)paramIModel.get(i));
          i += 1;
        }
        i = Math.min(((List)localObject).size(), k);
        while (i < paramIModel.size())
        {
          ((ISearchResultView)paramIModel.get(i)).h().setVisibility(8);
          i += 1;
        }
      }
      while (i < paramIModel.size())
      {
        ((ISearchResultView)paramIModel.get(i)).h().setVisibility(8);
        i += 1;
      }
    }
    if (paramISearchResultGroupView.b() != null) {
      paramISearchResultGroupView.b().setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.presenter.PublicAcntSearchResultGroupPresenter
 * JD-Core Version:    0.7.0.1
 */