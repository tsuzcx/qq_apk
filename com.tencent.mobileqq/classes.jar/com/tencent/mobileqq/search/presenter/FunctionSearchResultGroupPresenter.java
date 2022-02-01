package com.tencent.mobileqq.search.presenter;

import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.search.base.presenter.IFacePresenter;
import com.tencent.mobileqq.search.base.util.SearchViewUtils;
import com.tencent.mobileqq.search.base.view.ISearchResultGroupView;
import com.tencent.mobileqq.search.base.view.IView;
import com.tencent.mobileqq.search.business.function.view.FunctionSearchResultGroupView;
import com.tencent.mobileqq.search.model.GroupBaseNetSearchModelItem;
import com.tencent.mobileqq.search.model.IModel;
import com.tencent.mobileqq.search.model.ISearchResultGroupModel;
import com.tencent.mobileqq.search.model.ISearchResultModel;
import com.tencent.mobileqq.search.view.SearchResultFromNetView;
import java.util.List;

public class FunctionSearchResultGroupPresenter
  extends SearchResultGroupPresenter
{
  public FunctionSearchResultGroupPresenter(IFaceDecoder paramIFaceDecoder)
  {
    super(paramIFaceDecoder, 268435456);
  }
  
  public void a(IModel paramIModel, ISearchResultGroupView paramISearchResultGroupView)
  {
    Object localObject1 = (ISearchResultGroupModel)paramIModel;
    paramIModel = (FunctionSearchResultGroupView)paramISearchResultGroupView;
    LinearLayout localLinearLayout = paramIModel.a();
    if (localLinearLayout != null)
    {
      List localList = ((ISearchResultGroupModel)localObject1).a();
      if (localList != null)
      {
        localLinearLayout.removeAllViews();
        int j = Math.min(localList.size(), ((ISearchResultGroupModel)localObject1).a());
        int i = 0;
        while (i < j)
        {
          localObject1 = new SearchResultFromNetView(paramIModel.a(), 268435456);
          Object localObject2 = ((SearchResultFromNetView)localObject1).a();
          ISearchResultModel localISearchResultModel = (ISearchResultModel)localList.get(i);
          ((View)localObject2).setTag(2131380884, localISearchResultModel);
          ((View)localObject2).setTag(2131380889, localObject1);
          ((View)localObject2).setTag(2131380885, Integer.valueOf(i));
          ((View)localObject2).setTag(2131380883, Integer.valueOf(localList.size()));
          ((View)localObject2).setTag(2131380886, this.a);
          if ((localISearchResultModel instanceof GroupBaseNetSearchModelItem)) {
            SearchViewUtils.a((GroupBaseNetSearchModelItem)localISearchResultModel, j, i);
          }
          localObject2 = new LinearLayout.LayoutParams(-1, -2);
          localLinearLayout.addView(((SearchResultFromNetView)localObject1).a(), (ViewGroup.LayoutParams)localObject2);
          this.a.a(localISearchResultModel, (IView)localObject1);
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
 * Qualified Name:     com.tencent.mobileqq.search.presenter.FunctionSearchResultGroupPresenter
 * JD-Core Version:    0.7.0.1
 */