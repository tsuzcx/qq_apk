package com.tencent.mobileqq.search.presenter;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.search.model.GroupSearchModelLocalContact;
import com.tencent.mobileqq.search.model.IModel;
import com.tencent.mobileqq.search.model.ISearchResultGroupModel;
import com.tencent.mobileqq.search.model.ISearchResultModel;
import com.tencent.mobileqq.search.model.ISearchResultPositionModel;
import com.tencent.mobileqq.search.util.SearchViewUtils;
import com.tencent.mobileqq.search.view.ContactSearchResultGroupView;
import com.tencent.mobileqq.search.view.ContactSearchResultView;
import com.tencent.mobileqq.search.view.ISearchResultGroupView;
import com.tencent.mobileqq.search.view.ISearchResultView;
import com.tencent.mobileqq.troop.blocktroop.TroopBlockUtils;
import java.util.List;

public class ContactSearchResultGroupPresenter
  extends SearchResultGroupPresenter
{
  public ContactSearchResultGroupPresenter(IFaceDecoder paramIFaceDecoder)
  {
    super(paramIFaceDecoder);
  }
  
  protected IFacePresenter<ISearchResultModel, ISearchResultView> a(IFaceDecoder paramIFaceDecoder)
  {
    return new ContactSearchResultPresenter(paramIFaceDecoder);
  }
  
  public void a(IModel paramIModel, ISearchResultGroupView paramISearchResultGroupView)
  {
    paramIModel = (ISearchResultGroupModel)paramIModel;
    LinearLayout localLinearLayout = ((ContactSearchResultGroupView)paramISearchResultGroupView).a();
    if (localLinearLayout != null)
    {
      List localList = paramIModel.a();
      if (localList != null)
      {
        localLinearLayout.removeAllViews();
        int k = Math.min(localList.size(), paramIModel.a());
        int i = 0;
        if (i < k)
        {
          ISearchResultModel localISearchResultModel = (ISearchResultModel)localList.get(i);
          View localView = LayoutInflater.from(paramISearchResultGroupView.a().getContext()).inflate(2131562973, null);
          ContactSearchResultView localContactSearchResultView = new ContactSearchResultView(localView);
          localView.setTag(2131381651, localISearchResultModel);
          localView.setTag(2131381656, localContactSearchResultView);
          localView.setTag(2131381652, Integer.valueOf(i));
          localView.setTag(2131381650, Integer.valueOf(localList.size()));
          localView.setTag(2131381653, this.a);
          TroopBlockUtils.a(localView, 1, localISearchResultModel.b(), 2);
          SearchViewUtils.a(localISearchResultModel, k, i);
          int m = localISearchResultModel.a();
          int n = localISearchResultModel.b();
          if ((localISearchResultModel instanceof ISearchResultPositionModel)) {}
          for (int j = ((ISearchResultPositionModel)localISearchResultModel).u;; j = 0)
          {
            SearchViewUtils.a(m, n, localView, j);
            localLinearLayout.addView(localView);
            this.a.a(localISearchResultModel, localContactSearchResultView);
            i += 1;
            break;
          }
        }
      }
    }
    if (paramISearchResultGroupView.b() != null) {
      paramISearchResultGroupView.b().setVisibility(8);
    }
    if ((paramIModel instanceof GroupSearchModelLocalContact))
    {
      paramIModel = ((GroupSearchModelLocalContact)paramIModel).a();
      paramISearchResultGroupView = ((ContactSearchResultGroupView)paramISearchResultGroupView).a();
      if (paramISearchResultGroupView != null)
      {
        if (paramIModel == null) {
          break label339;
        }
        paramISearchResultGroupView.a().setVisibility(0);
        this.a.a(paramIModel, paramISearchResultGroupView);
      }
    }
    return;
    label339:
    paramISearchResultGroupView.a().setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.search.presenter.ContactSearchResultGroupPresenter
 * JD-Core Version:    0.7.0.1
 */