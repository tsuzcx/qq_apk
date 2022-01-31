package com.tencent.mobileqq.search.presenter;

import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.search.model.ContactSearchModelDiscussion;
import com.tencent.mobileqq.search.model.ContactSearchModelNewTroop;
import com.tencent.mobileqq.search.model.ContactSearchModelTroop;
import com.tencent.mobileqq.search.model.ISearchResultModel;
import com.tencent.mobileqq.search.view.ISearchResultView;
import com.tencent.mobileqq.util.FaceDecoder;
import java.util.Set;

public class SelectMemberContactSearchResultPresenter
  extends ContactSearchResultPresenter
{
  private Set a;
  private Set b;
  
  public SelectMemberContactSearchResultPresenter(FaceDecoder paramFaceDecoder, ContactSearchResultPresenter.OnActionListener paramOnActionListener, Set paramSet1, Set paramSet2)
  {
    super(paramFaceDecoder, paramOnActionListener);
    this.a = paramSet1;
    this.b = paramSet2;
  }
  
  public void a(ISearchResultModel paramISearchResultModel, ISearchResultView paramISearchResultView)
  {
    super.a(paramISearchResultModel, paramISearchResultView);
    if (paramISearchResultView.g() != null)
    {
      String str = paramISearchResultModel.a();
      if ((this.a != null) && (this.a.contains(str))) {
        paramISearchResultView.g().setText("已选择");
      }
      if ((this.b != null) && (this.b.contains(str))) {
        paramISearchResultView.g().setText("已加入");
      }
    }
    if (paramISearchResultView.b() != null)
    {
      if (((paramISearchResultModel instanceof ContactSearchModelTroop)) || ((paramISearchResultModel instanceof ContactSearchModelDiscussion)) || ((paramISearchResultModel instanceof ContactSearchModelNewTroop)))
      {
        if (paramISearchResultView.g() != null) {
          paramISearchResultView.g().setVisibility(8);
        }
        paramISearchResultView.b().setVisibility(0);
      }
    }
    else {
      return;
    }
    if (paramISearchResultView.g() != null) {
      paramISearchResultView.g().setVisibility(0);
    }
    paramISearchResultView.b().setVisibility(8);
  }
  
  public void c(ISearchResultModel paramISearchResultModel, ISearchResultView paramISearchResultView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.search.presenter.SelectMemberContactSearchResultPresenter
 * JD-Core Version:    0.7.0.1
 */