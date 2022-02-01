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
import com.tencent.mobileqq.search.business.contact.presenter.ContactSearchResultPresenter;
import com.tencent.mobileqq.search.business.contact.view.ContactSearchResultGroupView;
import com.tencent.mobileqq.search.business.contact.view.ContactSearchResultView;
import com.tencent.mobileqq.search.business.group.model.GroupSearchModelLocalContact;
import com.tencent.mobileqq.search.model.IModel;
import com.tencent.mobileqq.search.model.ISearchResultGroupModel;
import com.tencent.mobileqq.search.model.ISearchResultModel;
import com.tencent.mobileqq.search.model.ISearchResultPositionModel;
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
    ISearchResultGroupModel localISearchResultGroupModel = (ISearchResultGroupModel)paramIModel;
    paramIModel = (ContactSearchResultGroupView)paramISearchResultGroupView;
    LinearLayout localLinearLayout = paramIModel.a();
    if (localLinearLayout != null)
    {
      List localList = localISearchResultGroupModel.a();
      if (localList != null)
      {
        localLinearLayout.removeAllViews();
        int k = Math.min(localList.size(), localISearchResultGroupModel.a());
        int i = 0;
        while (i < k)
        {
          ISearchResultModel localISearchResultModel = (ISearchResultModel)localList.get(i);
          View localView = LayoutInflater.from(paramISearchResultGroupView.a().getContext()).inflate(2131562792, null);
          ContactSearchResultView localContactSearchResultView = new ContactSearchResultView(localView);
          localView.setTag(2131380884, localISearchResultModel);
          localView.setTag(2131380889, localContactSearchResultView);
          localView.setTag(2131380885, Integer.valueOf(i));
          localView.setTag(2131380883, Integer.valueOf(localList.size()));
          localView.setTag(2131380886, this.a);
          TroopBlockUtils.a(localView, 1, localISearchResultModel.a(), 2);
          SearchViewUtils.a(localISearchResultModel, k, i);
          int m = localISearchResultModel.b();
          int n = localISearchResultModel.f_();
          int j;
          if ((localISearchResultModel instanceof ISearchResultPositionModel)) {
            j = ((ISearchResultPositionModel)localISearchResultModel).u;
          } else {
            j = 0;
          }
          SearchViewUtils.a(m, n, localView, j);
          localLinearLayout.addView(localView);
          this.a.a(localISearchResultModel, localContactSearchResultView);
          i += 1;
        }
      }
    }
    if (paramISearchResultGroupView.b() != null) {
      paramISearchResultGroupView.b().setVisibility(8);
    }
    if ((localISearchResultGroupModel instanceof GroupSearchModelLocalContact))
    {
      paramISearchResultGroupView = ((GroupSearchModelLocalContact)localISearchResultGroupModel).a();
      paramIModel = paramIModel.a();
      if (paramIModel != null)
      {
        if (paramISearchResultGroupView != null)
        {
          paramIModel.a().setVisibility(0);
          this.a.a(paramISearchResultGroupView, paramIModel);
          return;
        }
        paramIModel.a().setVisibility(8);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.search.presenter.ContactSearchResultGroupPresenter
 * JD-Core Version:    0.7.0.1
 */