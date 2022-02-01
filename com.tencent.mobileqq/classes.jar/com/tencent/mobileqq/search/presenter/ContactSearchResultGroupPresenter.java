package com.tencent.mobileqq.search.presenter;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.search.base.presenter.IFacePresenter;
import com.tencent.mobileqq.search.base.util.SearchViewUtils;
import com.tencent.mobileqq.search.base.view.ISearchResultGroupView;
import com.tencent.mobileqq.search.base.view.ISearchResultView;
import com.tencent.mobileqq.search.base.view.IView;
import com.tencent.mobileqq.search.business.contact.presenter.ContactSearchResultPresenter;
import com.tencent.mobileqq.search.business.contact.view.ContactSearchResultGroupView;
import com.tencent.mobileqq.search.business.contact.view.ContactSearchResultView;
import com.tencent.mobileqq.search.business.group.model.GroupSearchModelLocalContact;
import com.tencent.mobileqq.search.model.IModel;
import com.tencent.mobileqq.search.model.ISearchResultGroupModel;
import com.tencent.mobileqq.search.model.ISearchResultModel;
import com.tencent.mobileqq.search.model.ISearchResultPositionModel;
import com.tencent.mobileqq.search.util.SearchCostStat;
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
    paramIModel = new StringBuffer();
    Object localObject1 = (ContactSearchResultGroupView)paramISearchResultGroupView;
    LinearLayout localLinearLayout = ((ContactSearchResultGroupView)localObject1).e();
    if (localLinearLayout != null)
    {
      List localList = localISearchResultGroupModel.b();
      if (localList != null)
      {
        localLinearLayout.removeAllViews();
        int k = Math.min(localList.size(), localISearchResultGroupModel.d());
        int i = 0;
        while (i < k)
        {
          Object localObject2 = (ISearchResultModel)localList.get(i);
          View localView = LayoutInflater.from(paramISearchResultGroupView.h().getContext()).inflate(2131629237, null);
          ContactSearchResultView localContactSearchResultView = new ContactSearchResultView(localView);
          localView.setTag(2131449867, localObject2);
          localView.setTag(2131449873, localContactSearchResultView);
          localView.setTag(2131449868, Integer.valueOf(i));
          localView.setTag(2131449866, Integer.valueOf(localList.size()));
          localView.setTag(2131449869, this.a);
          TroopBlockUtils.a(localView, 1, ((ISearchResultModel)localObject2).c(), 2);
          SearchViewUtils.a((ISearchResultModel)localObject2, k, i);
          int m = ((ISearchResultModel)localObject2).ck_();
          int n = ((ISearchResultModel)localObject2).cl_();
          int j;
          if ((localObject2 instanceof ISearchResultPositionModel)) {
            j = ((ISearchResultPositionModel)localObject2).af;
          } else {
            j = 0;
          }
          SearchViewUtils.a(m, n, localView, j);
          localLinearLayout.addView(localView);
          this.a.a((IModel)localObject2, localContactSearchResultView);
          localObject2 = ((ISearchResultModel)localObject2).c();
          if (!TextUtils.isEmpty((CharSequence)localObject2))
          {
            paramIModel.append((String)localObject2);
            paramIModel.append(",");
          }
          i += 1;
        }
      }
    }
    if (paramISearchResultGroupView.b() != null) {
      paramISearchResultGroupView.b().setVisibility(8);
    }
    if ((localISearchResultGroupModel instanceof GroupSearchModelLocalContact))
    {
      paramISearchResultGroupView = ((GroupSearchModelLocalContact)localISearchResultGroupModel).e();
      localObject1 = ((ContactSearchResultGroupView)localObject1).d();
      if (localObject1 != null) {
        if (paramISearchResultGroupView != null)
        {
          ((ISearchResultView)localObject1).h().setVisibility(0);
          this.a.a(paramISearchResultGroupView, (IView)localObject1);
        }
        else
        {
          ((ISearchResultView)localObject1).h().setVisibility(8);
        }
      }
      SearchCostStat.c(paramIModel.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.presenter.ContactSearchResultGroupPresenter
 * JD-Core Version:    0.7.0.1
 */