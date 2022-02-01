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
  boolean a;
  private IFaceDecoder b;
  private SearchResultGroupPresenter c;
  
  public SearchResultGroupMessagePresenter(IFaceDecoder paramIFaceDecoder, boolean paramBoolean)
  {
    this.b = paramIFaceDecoder;
    this.c = new SearchResultGroupPresenter(paramIFaceDecoder, paramBoolean);
    this.a = paramBoolean;
  }
  
  public void a(IModel paramIModel, ISearchResultGroupView paramISearchResultGroupView)
  {
    ISearchResultGroupModel localISearchResultGroupModel = (ISearchResultGroupModel)paramIModel;
    SearchResultGroupMessageView localSearchResultGroupMessageView = (SearchResultGroupMessageView)paramISearchResultGroupView;
    int i = localISearchResultGroupModel.d();
    LinearLayout localLinearLayout = localSearchResultGroupMessageView.d();
    ThemeUtil.isInNightMode(BaseApplicationImpl.getApplication().getRuntime());
    if (localLinearLayout != null)
    {
      List localList = localISearchResultGroupModel.b();
      if ((localList != null) && (!localList.isEmpty()))
      {
        localLinearLayout.removeAllViews();
        int k = Math.min(localList.size(), i);
        i = 0;
        while (i < k)
        {
          ISearchResultModel localISearchResultModel = (ISearchResultModel)localList.get(i);
          Object localObject;
          if (this.a)
          {
            paramIModel = LayoutInflater.from(paramISearchResultGroupView.h().getContext()).inflate(2131629241, null);
            localObject = new FTSMessageSearchResultView(paramIModel);
          }
          else
          {
            paramIModel = LayoutInflater.from(paramISearchResultGroupView.h().getContext()).inflate(2131629240, null);
            localObject = new SearchResultView(paramIModel);
          }
          paramIModel.setTag(2131449867, localISearchResultModel);
          paramIModel.setTag(2131449873, localObject);
          paramIModel.setTag(2131449868, Integer.valueOf(i));
          paramIModel.setTag(2131449866, Integer.valueOf(localList.size()));
          paramIModel.setTag(2131449869, this.c);
          SearchViewUtils.a(localISearchResultModel, k, i);
          int m = localISearchResultModel.ck_();
          int n = localISearchResultModel.cl_();
          int j;
          if ((localISearchResultModel instanceof ISearchResultPositionModel)) {
            j = ((ISearchResultPositionModel)localISearchResultModel).af;
          } else {
            j = 0;
          }
          SearchViewUtils.a(m, n, paramIModel, j);
          localLinearLayout.addView(paramIModel);
          if (this.c.a() != null) {
            this.c.a().a((IModel)localList.get(i), (IView)localObject);
          }
          i += 1;
        }
      }
    }
    paramIModel = localISearchResultGroupModel.b();
    if ((paramIModel != null) && (!paramIModel.isEmpty()))
    {
      localSearchResultGroupMessageView.e.setVisibility(8);
      return;
    }
    if (paramISearchResultGroupView.b() != null) {
      paramISearchResultGroupView.b().setVisibility(8);
    }
    localSearchResultGroupMessageView.e.setVisibility(0);
    localSearchResultGroupMessageView.e.setTag(2131449868, Integer.valueOf(-1));
    localSearchResultGroupMessageView.f.setText(localISearchResultGroupModel.c());
    localSearchResultGroupMessageView.h.setText(HardCodeUtil.a(2131911116));
    localSearchResultGroupMessageView.g.setImageResource(2130847686);
    localSearchResultGroupMessageView.e.setOnClickListener(new SearchResultGroupMessagePresenter.1(this, localISearchResultGroupModel));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.presenter.SearchResultGroupMessagePresenter
 * JD-Core Version:    0.7.0.1
 */