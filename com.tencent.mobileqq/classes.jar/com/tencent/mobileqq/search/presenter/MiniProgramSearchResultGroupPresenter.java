package com.tencent.mobileqq.search.presenter;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.search.base.presenter.IFacePresenter;
import com.tencent.mobileqq.search.base.util.SearchViewUtils;
import com.tencent.mobileqq.search.base.view.ISearchResultGroupView;
import com.tencent.mobileqq.search.base.view.ISearchResultView;
import com.tencent.mobileqq.search.business.miniprogram.view.MiniProgramSearchResultGroupView;
import com.tencent.mobileqq.search.business.miniprogram.view.MiniProgramSearchResultView;
import com.tencent.mobileqq.search.model.IModel;
import com.tencent.mobileqq.search.model.ISearchResultGroupModel;
import com.tencent.mobileqq.search.model.ISearchResultModel;
import com.tencent.mobileqq.search.model.ISearchResultPositionModel;
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
    paramIModel = ((MiniProgramSearchResultGroupView)paramISearchResultGroupView).d();
    if (paramIModel != null)
    {
      List localList = ((ISearchResultGroupModel)localObject).b();
      if (localList != null)
      {
        paramIModel.removeAllViews();
        int k = Math.min(localList.size(), ((ISearchResultGroupModel)localObject).d());
        int i = 0;
        while (i < k)
        {
          localObject = (ISearchResultModel)localList.get(i);
          View localView = LayoutInflater.from(paramISearchResultGroupView.h().getContext()).inflate(2131629244, null);
          MiniProgramSearchResultView localMiniProgramSearchResultView = new MiniProgramSearchResultView(localView);
          localView.setTag(2131449867, localObject);
          localView.setTag(2131449873, localMiniProgramSearchResultView);
          localView.setTag(2131449868, Integer.valueOf(i));
          localView.setTag(2131449866, Integer.valueOf(localList.size()));
          localView.setTag(2131449869, this.a);
          SearchViewUtils.a((ISearchResultModel)localObject, k, i);
          int m = ((ISearchResultModel)localObject).ck_();
          int n = ((ISearchResultModel)localObject).cl_();
          int j;
          if ((localObject instanceof ISearchResultPositionModel)) {
            j = ((ISearchResultPositionModel)localObject).af;
          } else {
            j = 0;
          }
          SearchViewUtils.a(m, n, localView, j);
          paramIModel.addView(localView);
          this.a.a((IModel)localObject, localMiniProgramSearchResultView);
          i += 1;
        }
      }
    }
    if (paramISearchResultGroupView.b() != null) {
      paramISearchResultGroupView.b().setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.presenter.MiniProgramSearchResultGroupPresenter
 * JD-Core Version:    0.7.0.1
 */