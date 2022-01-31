package com.tencent.mobileqq.search.presenter;

import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.search.model.GroupBaseNetSearchModelItem;
import com.tencent.mobileqq.search.model.IModel;
import com.tencent.mobileqq.search.model.ISearchResultGroupModel;
import com.tencent.mobileqq.search.model.ISearchResultModel;
import com.tencent.mobileqq.search.util.SearchViewUtils;
import com.tencent.mobileqq.search.view.FunctionSearchResultGroupView;
import com.tencent.mobileqq.search.view.ISearchResultGroupView;
import com.tencent.mobileqq.search.view.IView;
import com.tencent.mobileqq.search.view.SearchResultFromNetView;
import com.tencent.mobileqq.util.FaceDecoder;
import java.util.List;

public class FunctionSearchResultGroupPresenter
  extends SearchResultGroupPresenter
{
  public FunctionSearchResultGroupPresenter(FaceDecoder paramFaceDecoder)
  {
    super(paramFaceDecoder, 268435456);
  }
  
  public void a(IModel paramIModel, ISearchResultGroupView paramISearchResultGroupView)
  {
    Object localObject1 = (ISearchResultGroupModel)paramIModel;
    paramIModel = ((FunctionSearchResultGroupView)paramISearchResultGroupView).a();
    if (paramIModel != null)
    {
      List localList = ((ISearchResultGroupModel)localObject1).a();
      if (localList != null)
      {
        paramIModel.removeAllViews();
        int j = Math.min(localList.size(), ((ISearchResultGroupModel)localObject1).a());
        int i = 0;
        while (i < j)
        {
          localObject1 = new SearchResultFromNetView(((FunctionSearchResultGroupView)paramISearchResultGroupView).a(), 268435456);
          Object localObject2 = ((SearchResultFromNetView)localObject1).a();
          ISearchResultModel localISearchResultModel = (ISearchResultModel)localList.get(i);
          ((View)localObject2).setTag(2131362079, localISearchResultModel);
          ((View)localObject2).setTag(2131362078, localObject1);
          ((View)localObject2).setTag(2131362080, Integer.valueOf(i));
          ((View)localObject2).setTag(2131362081, Integer.valueOf(localList.size()));
          ((View)localObject2).setTag(2131362077, this.a);
          if ((localISearchResultModel instanceof GroupBaseNetSearchModelItem)) {
            SearchViewUtils.a((GroupBaseNetSearchModelItem)localISearchResultModel, j, i);
          }
          localObject2 = new LinearLayout.LayoutParams(-1, -2);
          paramIModel.addView(((SearchResultFromNetView)localObject1).a(), (ViewGroup.LayoutParams)localObject2);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.search.presenter.FunctionSearchResultGroupPresenter
 * JD-Core Version:    0.7.0.1
 */