package com.tencent.mobileqq.search.presenter;

import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.search.model.GroupSearchModelLocalContact;
import com.tencent.mobileqq.search.model.IModel;
import com.tencent.mobileqq.search.model.ISearchResultGroupModel;
import com.tencent.mobileqq.search.model.ISearchResultModel;
import com.tencent.mobileqq.search.util.SearchViewUtils;
import com.tencent.mobileqq.search.view.ContactSearchResultGroupView;
import com.tencent.mobileqq.search.view.ContactSearchResultView;
import com.tencent.mobileqq.search.view.ISearchResultGroupView;
import com.tencent.mobileqq.search.view.ISearchResultView;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.util.FaceDecoder;
import java.util.List;

public class ContactSearchResultGroupPresenter
  extends SearchResultGroupPresenter
{
  public ContactSearchResultGroupPresenter(FaceDecoder paramFaceDecoder)
  {
    super(paramFaceDecoder);
  }
  
  protected IFacePresenter a(FaceDecoder paramFaceDecoder)
  {
    return new ContactSearchResultPresenter(paramFaceDecoder);
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
        boolean bool = ThemeUtil.isInNightMode(BaseApplicationImpl.getApplication().getRuntime());
        int j = Math.min(localList.size(), paramIModel.a());
        int i = 0;
        if (i < j)
        {
          ISearchResultModel localISearchResultModel = (ISearchResultModel)localList.get(i);
          View localView1 = LayoutInflater.from(paramISearchResultGroupView.a().getContext()).inflate(2130971535, null);
          View localView2 = localView1.findViewById(2131365685);
          ContactSearchResultView localContactSearchResultView = new ContactSearchResultView(localView1);
          localView1.setTag(2131362079, localISearchResultModel);
          localView1.setTag(2131362078, localContactSearchResultView);
          localView1.setTag(2131362080, Integer.valueOf(i));
          localView1.setTag(2131362081, Integer.valueOf(localList.size()));
          localView1.setTag(2131362077, this.a);
          SearchViewUtils.a(localISearchResultModel, j, i);
          SearchViewUtils.a(localISearchResultModel.c(), localISearchResultModel.d(), localView1);
          Resources localResources = localView1.getResources();
          if (bool)
          {
            localView1.setBackgroundColor(localResources.getColor(2131492948));
            localView2.setBackgroundResource(2130838580);
          }
          for (;;)
          {
            localLinearLayout.addView(localView1);
            this.a.a(localISearchResultModel, localContactSearchResultView);
            i += 1;
            break;
            localView1.setBackgroundColor(localResources.getColor(2131492969));
            localView2.setBackgroundResource(2130838579);
          }
        }
      }
    }
    if (paramISearchResultGroupView.b() != null) {
      paramISearchResultGroupView.b().setVisibility(8);
    }
    paramIModel = ((GroupSearchModelLocalContact)paramIModel).a();
    paramISearchResultGroupView = ((ContactSearchResultGroupView)paramISearchResultGroupView).a();
    if (paramISearchResultGroupView != null)
    {
      if (paramIModel != null)
      {
        paramISearchResultGroupView.a().setVisibility(0);
        this.a.a(paramIModel, paramISearchResultGroupView);
      }
    }
    else {
      return;
    }
    paramISearchResultGroupView.a().setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.search.presenter.ContactSearchResultGroupPresenter
 * JD-Core Version:    0.7.0.1
 */