package com.tencent.mobileqq.search.presenter;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.search.model.IModel;
import com.tencent.mobileqq.search.model.ISearchResultGroupModel;
import com.tencent.mobileqq.search.model.ISearchResultModel;
import com.tencent.mobileqq.search.model.ISearchResultPositionModel;
import com.tencent.mobileqq.search.util.SearchViewUtils;
import com.tencent.mobileqq.search.view.ISearchResultGroupView;
import com.tencent.mobileqq.search.view.ISearchResultView;
import com.tencent.mobileqq.search.view.MiniProgramSearchResultGroupView;
import com.tencent.mobileqq.search.view.MiniProgramSearchResultView;
import java.util.List;

public class MiniProgramSearchResultGroupPresenter
  extends SearchResultGroupPresenter
{
  public MiniProgramSearchResultGroupPresenter(IFaceDecoder paramIFaceDecoder)
  {
    super(paramIFaceDecoder);
  }
  
  protected IFacePresenter<ISearchResultModel, ISearchResultView> a(IFaceDecoder paramIFaceDecoder)
  {
    return new MiniProgramSearchResultPresenter(paramIFaceDecoder);
  }
  
  public void a(IModel paramIModel, ISearchResultGroupView paramISearchResultGroupView)
  {
    Object localObject = (ISearchResultGroupModel)paramIModel;
    paramIModel = ((MiniProgramSearchResultGroupView)paramISearchResultGroupView).a();
    if (paramIModel != null)
    {
      List localList = ((ISearchResultGroupModel)localObject).a();
      if (localList != null)
      {
        paramIModel.removeAllViews();
        int k = Math.min(localList.size(), ((ISearchResultGroupModel)localObject).a());
        int i = 0;
        if (i < k)
        {
          localObject = (ISearchResultModel)localList.get(i);
          View localView = LayoutInflater.from(paramISearchResultGroupView.a().getContext()).inflate(2131562980, null);
          MiniProgramSearchResultView localMiniProgramSearchResultView = new MiniProgramSearchResultView(localView);
          localView.setTag(2131381651, localObject);
          localView.setTag(2131381656, localMiniProgramSearchResultView);
          localView.setTag(2131381652, Integer.valueOf(i));
          localView.setTag(2131381650, Integer.valueOf(localList.size()));
          localView.setTag(2131381653, this.a);
          SearchViewUtils.a((ISearchResultModel)localObject, k, i);
          int m = ((ISearchResultModel)localObject).a();
          int n = ((ISearchResultModel)localObject).b();
          if ((localObject instanceof ISearchResultPositionModel)) {}
          for (int j = ((ISearchResultPositionModel)localObject).u;; j = 0)
          {
            SearchViewUtils.a(m, n, localView, j);
            paramIModel.addView(localView);
            this.a.a((IModel)localObject, localMiniProgramSearchResultView);
            i += 1;
            break;
          }
        }
      }
    }
    if (paramISearchResultGroupView.b() != null) {
      paramISearchResultGroupView.b().setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.search.presenter.MiniProgramSearchResultGroupPresenter
 * JD-Core Version:    0.7.0.1
 */