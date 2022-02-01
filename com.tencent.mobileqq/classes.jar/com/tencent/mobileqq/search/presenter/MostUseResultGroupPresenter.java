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
    LinearLayout localLinearLayout = ((MostUsedSearchResultGroupView)paramISearchResultGroupView).a();
    if (localLinearLayout != null)
    {
      List localList = paramIModel.a();
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
            int j = MostUseConstants.a(localIContactSearchModel.e());
            localObject2 = null;
            if (j == 1)
            {
              localObject2 = LayoutInflater.from(paramISearchResultGroupView.a().getContext()).inflate(2131562792, null);
              paramIModel = ((View)localObject2).findViewById(2131369010);
              localObject1 = new ContactSearchResultView((View)localObject2);
            }
            else if (MostUseConstants.a(localIContactSearchModel.e()) == 2)
            {
              localObject2 = LayoutInflater.from(paramISearchResultGroupView.a().getContext()).inflate(2131562799, null);
              paramIModel = ((View)localObject2).findViewById(2131369010);
              localObject1 = new MiniProgramSearchResultView((View)localObject2);
            }
            else
            {
              paramIModel = null;
              localObject1 = paramIModel;
            }
            if ((localObject2 != null) && (paramIModel != null))
            {
              ((View)localObject2).setTag(2131380884, localIContactSearchModel);
              ((View)localObject2).setTag(2131380889, localObject1);
              ((View)localObject2).setTag(2131380885, Integer.valueOf(i));
              ((View)localObject2).setTag(2131380883, Integer.valueOf(localList.size()));
              ((View)localObject2).setTag(2131380886, this.a);
              TroopBlockUtils.a((View)localObject2, localIContactSearchModel.d(), localIContactSearchModel.a(), 1);
              SearchViewUtils.a(localIContactSearchModel, k, i);
              int m = localIContactSearchModel.b();
              int n = localIContactSearchModel.f_();
              if ((localIContactSearchModel instanceof ISearchResultPositionModel)) {
                j = localIContactSearchModel.u;
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
              paramIModel.append(localIContactSearchModel.e());
              QLog.e("MostUseResultGroupPresenter", 2, paramIModel.toString());
            }
          }
          else if ((paramIModel instanceof GroupBaseNetSearchModelItem))
          {
            paramIModel = (GroupBaseNetSearchModelItem)paramIModel;
            localObject1 = new SearchResultFromNetView(localLinearLayout, paramIModel.d());
            localObject2 = ((SearchResultFromNetView)localObject1).a();
            ((View)localObject2).setTag(2131380884, paramIModel);
            ((View)localObject2).setTag(2131380889, localObject1);
            ((View)localObject2).setTag(2131380885, Integer.valueOf(i));
            ((View)localObject2).setTag(2131380883, Integer.valueOf(localList.size()));
            ((View)localObject2).setTag(2131380886, this.a);
            SearchViewUtils.a(paramIModel, k, i);
            localObject2 = new LinearLayout.LayoutParams(-1, -2);
            localLinearLayout.addView(((SearchResultFromNetView)localObject1).a(), (ViewGroup.LayoutParams)localObject2);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.search.presenter.MostUseResultGroupPresenter
 * JD-Core Version:    0.7.0.1
 */