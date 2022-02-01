package com.tencent.mobileqq.search.presenter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.search.base.presenter.IFacePresenter;
import com.tencent.mobileqq.search.base.util.SearchViewUtils;
import com.tencent.mobileqq.search.base.view.ISearchResultGroupView;
import com.tencent.mobileqq.search.base.view.ISearchResultView;
import com.tencent.mobileqq.search.base.view.IView;
import com.tencent.mobileqq.search.business.contact.model.IContactSearchModel;
import com.tencent.mobileqq.search.business.contact.view.ContactSearchResultView;
import com.tencent.mobileqq.search.business.miniprogram.view.MiniProgramSearchResultView;
import com.tencent.mobileqq.search.business.mostused.view.MostUsedSearchResultGroupView;
import com.tencent.mobileqq.search.model.GroupBaseNetSearchModelItem;
import com.tencent.mobileqq.search.model.IModel;
import com.tencent.mobileqq.search.model.ISearchResultGroupModel;
import com.tencent.mobileqq.search.model.ISearchResultModel;
import com.tencent.mobileqq.search.model.ISearchResultPositionModel;
import com.tencent.mobileqq.search.mostused.MostUseConstants;
import com.tencent.mobileqq.search.view.SearchResultFromNetView;
import com.tencent.mobileqq.troop.blocktroop.TroopBlockUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class MostUseResultGroupPresenter
  extends SearchResultGroupPresenter
{
  public MostUseResultGroupPresenter(IFaceDecoder paramIFaceDecoder)
  {
    super(paramIFaceDecoder);
  }
  
  protected IFacePresenter<ISearchResultModel, ISearchResultView> a(IFaceDecoder paramIFaceDecoder)
  {
    return new MostUsedResultPresenter(paramIFaceDecoder);
  }
  
  public void a(IModel paramIModel, ISearchResultGroupView paramISearchResultGroupView)
  {
    paramIModel = (ISearchResultGroupModel)paramIModel;
    LinearLayout localLinearLayout = ((MostUsedSearchResultGroupView)paramISearchResultGroupView).d();
    if (localLinearLayout != null)
    {
      List localList = paramIModel.b();
      if (localList != null)
      {
        localLinearLayout.removeAllViews();
        int k = Math.min(localList.size(), 3);
        int i = 0;
        while (i < k)
        {
          paramIModel = (ISearchResultModel)localList.get(i);
          Object localObject2;
          Object localObject1;
          if ((paramIModel instanceof IContactSearchModel))
          {
            IContactSearchModel localIContactSearchModel = (IContactSearchModel)paramIModel;
            int j = MostUseConstants.a(localIContactSearchModel.o());
            localObject2 = null;
            if (j == 1)
            {
              localObject2 = LayoutInflater.from(paramISearchResultGroupView.h().getContext()).inflate(2131629237, null);
              paramIModel = ((View)localObject2).findViewById(2131435970);
              localObject1 = new ContactSearchResultView((View)localObject2);
            }
            else if (MostUseConstants.a(localIContactSearchModel.o()) == 2)
            {
              localObject2 = LayoutInflater.from(paramISearchResultGroupView.h().getContext()).inflate(2131629244, null);
              paramIModel = ((View)localObject2).findViewById(2131435970);
              localObject1 = new MiniProgramSearchResultView((View)localObject2);
            }
            else
            {
              paramIModel = null;
              localObject1 = paramIModel;
            }
            if ((localObject2 != null) && (paramIModel != null))
            {
              ((View)localObject2).setTag(2131449867, localIContactSearchModel);
              ((View)localObject2).setTag(2131449873, localObject1);
              ((View)localObject2).setTag(2131449868, Integer.valueOf(i));
              ((View)localObject2).setTag(2131449866, Integer.valueOf(localList.size()));
              ((View)localObject2).setTag(2131449869, this.a);
              TroopBlockUtils.a((View)localObject2, localIContactSearchModel.j(), localIContactSearchModel.c(), 1);
              SearchViewUtils.a(localIContactSearchModel, k, i);
              int m = localIContactSearchModel.ck_();
              int n = localIContactSearchModel.cl_();
              if ((localIContactSearchModel instanceof ISearchResultPositionModel)) {
                j = localIContactSearchModel.af;
              } else {
                j = 0;
              }
              SearchViewUtils.a(m, n, (View)localObject2, j);
              localLinearLayout.addView((View)localObject2);
              this.a.a(localIContactSearchModel, (IView)localObject1);
            }
            else
            {
              paramIModel = new StringBuilder();
              paramIModel.append("unresolved id type");
              paramIModel.append(localIContactSearchModel.o());
              QLog.e("MostUseResultGroupPresenter", 2, paramIModel.toString());
            }
          }
          else if ((paramIModel instanceof GroupBaseNetSearchModelItem))
          {
            paramIModel = (GroupBaseNetSearchModelItem)paramIModel;
            localObject1 = new SearchResultFromNetView(localLinearLayout, paramIModel.j());
            localObject2 = ((SearchResultFromNetView)localObject1).h();
            ((View)localObject2).setTag(2131449867, paramIModel);
            ((View)localObject2).setTag(2131449873, localObject1);
            ((View)localObject2).setTag(2131449868, Integer.valueOf(i));
            ((View)localObject2).setTag(2131449866, Integer.valueOf(localList.size()));
            ((View)localObject2).setTag(2131449869, this.a);
            SearchViewUtils.a(paramIModel, k, i);
            localObject2 = new LinearLayout.LayoutParams(-1, -2);
            localLinearLayout.addView(((SearchResultFromNetView)localObject1).h(), (ViewGroup.LayoutParams)localObject2);
            this.a.a(paramIModel, (IView)localObject1);
          }
          else
          {
            QLog.e("MostUseResultGroupPresenter", 2, "unknown type in MOST USED GROUP P");
          }
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
 * Qualified Name:     com.tencent.mobileqq.search.presenter.MostUseResultGroupPresenter
 * JD-Core Version:    0.7.0.1
 */