package com.tencent.mobileqq.search.presenter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.search.model.GroupBaseNetSearchModelItem;
import com.tencent.mobileqq.search.model.IContactSearchModel;
import com.tencent.mobileqq.search.model.IModel;
import com.tencent.mobileqq.search.model.ISearchResultGroupModel;
import com.tencent.mobileqq.search.model.ISearchResultModel;
import com.tencent.mobileqq.search.model.ISearchResultPositionModel;
import com.tencent.mobileqq.search.mostused.MostUseConstants;
import com.tencent.mobileqq.search.util.SearchViewUtils;
import com.tencent.mobileqq.search.view.ContactSearchResultView;
import com.tencent.mobileqq.search.view.ISearchResultGroupView;
import com.tencent.mobileqq.search.view.ISearchResultView;
import com.tencent.mobileqq.search.view.IView;
import com.tencent.mobileqq.search.view.MiniProgramSearchResultView;
import com.tencent.mobileqq.search.view.MostUsedSearchResultGroupView;
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
    List localList;
    int k;
    int i;
    IContactSearchModel localIContactSearchModel;
    Object localObject2;
    Object localObject1;
    if (localLinearLayout != null)
    {
      localList = paramIModel.a();
      if (localList != null)
      {
        localLinearLayout.removeAllViews();
        k = Math.min(localList.size(), 3);
        i = 0;
        if (i < k)
        {
          paramIModel = (ISearchResultModel)localList.get(i);
          if ((paramIModel instanceof IContactSearchModel))
          {
            localIContactSearchModel = (IContactSearchModel)paramIModel;
            localObject2 = null;
            if (MostUseConstants.a(localIContactSearchModel.e()) == 1)
            {
              localObject2 = LayoutInflater.from(paramISearchResultGroupView.a().getContext()).inflate(2131562973, null);
              paramIModel = ((View)localObject2).findViewById(2131369281);
              localObject1 = new ContactSearchResultView((View)localObject2);
            }
          }
        }
      }
    }
    for (;;)
    {
      label137:
      int j;
      if ((localObject2 != null) && (paramIModel != null))
      {
        ((View)localObject2).setTag(2131381651, localIContactSearchModel);
        ((View)localObject2).setTag(2131381656, localObject1);
        ((View)localObject2).setTag(2131381652, Integer.valueOf(i));
        ((View)localObject2).setTag(2131381650, Integer.valueOf(localList.size()));
        ((View)localObject2).setTag(2131381653, this.a);
        TroopBlockUtils.a((View)localObject2, localIContactSearchModel.d(), localIContactSearchModel.b(), 1);
        SearchViewUtils.a(localIContactSearchModel, k, i);
        int m = localIContactSearchModel.a();
        int n = localIContactSearchModel.b();
        if ((localIContactSearchModel instanceof ISearchResultPositionModel))
        {
          j = localIContactSearchModel.u;
          label256:
          SearchViewUtils.a(m, n, (View)localObject2, j);
          localLinearLayout.addView((View)localObject2);
          this.a.a(localIContactSearchModel, (IView)localObject1);
        }
      }
      for (;;)
      {
        i += 1;
        break;
        if (MostUseConstants.a(localIContactSearchModel.e()) != 2) {
          break label554;
        }
        localObject2 = LayoutInflater.from(paramISearchResultGroupView.a().getContext()).inflate(2131562980, null);
        paramIModel = ((View)localObject2).findViewById(2131369281);
        localObject1 = new MiniProgramSearchResultView((View)localObject2);
        break label137;
        j = 0;
        break label256;
        QLog.e("MostUseResultGroupPresenter", 2, "unresolved id type" + localIContactSearchModel.e());
        continue;
        if ((paramIModel instanceof GroupBaseNetSearchModelItem))
        {
          paramIModel = (GroupBaseNetSearchModelItem)paramIModel;
          localObject1 = new SearchResultFromNetView(localLinearLayout, paramIModel.d());
          localObject2 = ((SearchResultFromNetView)localObject1).a();
          ((View)localObject2).setTag(2131381651, paramIModel);
          ((View)localObject2).setTag(2131381656, localObject1);
          ((View)localObject2).setTag(2131381652, Integer.valueOf(i));
          ((View)localObject2).setTag(2131381650, Integer.valueOf(localList.size()));
          ((View)localObject2).setTag(2131381653, this.a);
          SearchViewUtils.a(paramIModel, k, i);
          localObject2 = new LinearLayout.LayoutParams(-1, -2);
          localLinearLayout.addView(((SearchResultFromNetView)localObject1).a(), (ViewGroup.LayoutParams)localObject2);
          this.a.a(paramIModel, (IView)localObject1);
        }
        else
        {
          QLog.e("MostUseResultGroupPresenter", 2, "unknown type in MOST USED GROUP P");
        }
      }
      if (paramISearchResultGroupView.b() != null) {
        paramISearchResultGroupView.b().setVisibility(8);
      }
      return;
      label554:
      paramIModel = null;
      localObject1 = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.search.presenter.MostUseResultGroupPresenter
 * JD-Core Version:    0.7.0.1
 */