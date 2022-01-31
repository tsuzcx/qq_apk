package com.tencent.mobileqq.search.presenter;

import android.view.View;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.search.model.IModel;
import com.tencent.mobileqq.search.model.ISearchResultGroupModel;
import com.tencent.mobileqq.search.model.ISearchResultModel;
import com.tencent.mobileqq.search.util.SearchViewUtils;
import com.tencent.mobileqq.search.view.ISearchResultGroupView;
import com.tencent.mobileqq.search.view.ISearchResultView;
import com.tencent.mobileqq.search.view.IView;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.util.FaceDecoder;
import java.util.List;

public class PublicAcntSearchResultGroupPresenter
  extends SearchResultGroupPresenter
{
  public PublicAcntSearchResultGroupPresenter(FaceDecoder paramFaceDecoder)
  {
    super(paramFaceDecoder);
  }
  
  protected IFacePresenter a(FaceDecoder paramFaceDecoder)
  {
    return new PublicAcntSearchResultPresenter(paramFaceDecoder);
  }
  
  public void a(IModel paramIModel, ISearchResultGroupView paramISearchResultGroupView)
  {
    Object localObject = (ISearchResultGroupModel)paramIModel;
    a(paramISearchResultGroupView, (ISearchResultGroupModel)localObject);
    int j = ((ISearchResultGroupModel)localObject).a();
    paramIModel = paramISearchResultGroupView.a();
    if ((paramIModel != null) && (paramIModel != null))
    {
      localObject = ((ISearchResultGroupModel)localObject).a();
      if (localObject != null)
      {
        int k = Math.min(Math.min(paramIModel.size(), ((List)localObject).size()), j);
        i = 0;
        if (i < k)
        {
          ((ISearchResultView)paramIModel.get(i)).a().setVisibility(0);
          ((ISearchResultView)paramIModel.get(i)).a().setTag(2131362079, ((List)localObject).get(i));
          ((ISearchResultView)paramIModel.get(i)).a().setTag(2131362078, paramIModel.get(i));
          ((ISearchResultView)paramIModel.get(i)).a().setTag(2131362080, Integer.valueOf(i));
          ((ISearchResultView)paramIModel.get(i)).a().setTag(2131362081, Integer.valueOf(paramIModel.size()));
          ((ISearchResultView)paramIModel.get(i)).a().setTag(2131362077, this.a);
          if (ThemeUtil.isInNightMode(BaseApplicationImpl.getApplication().getRuntime())) {
            ((ISearchResultView)paramIModel.get(i)).a().setBackgroundResource(2130838576);
          }
          for (;;)
          {
            SearchViewUtils.a((ISearchResultModel)((List)localObject).get(i), k, i);
            SearchViewUtils.a(((ISearchResultModel)((List)localObject).get(i)).c(), ((ISearchResultModel)((List)localObject).get(i)).d(), ((ISearchResultView)paramIModel.get(i)).a());
            this.a.a((IModel)((List)localObject).get(i), (IView)paramIModel.get(i));
            i += 1;
            break;
            ((ISearchResultView)paramIModel.get(i)).a().setBackgroundResource(2130838575);
          }
        }
        i = Math.min(((List)localObject).size(), j);
        while (i < paramIModel.size())
        {
          ((ISearchResultView)paramIModel.get(i)).a().setVisibility(8);
          i += 1;
        }
      }
      int i = 0;
      while (i < paramIModel.size())
      {
        ((ISearchResultView)paramIModel.get(i)).a().setVisibility(8);
        i += 1;
      }
    }
    if (paramISearchResultGroupView.b() != null) {
      paramISearchResultGroupView.b().setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.search.presenter.PublicAcntSearchResultGroupPresenter
 * JD-Core Version:    0.7.0.1
 */