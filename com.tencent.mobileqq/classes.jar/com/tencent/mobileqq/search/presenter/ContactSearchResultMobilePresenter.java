package com.tencent.mobileqq.search.presenter;

import ahgc;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mobileqq.search.model.ISearchResultModel;
import com.tencent.mobileqq.search.view.ContactSearchResultMobileView;
import com.tencent.mobileqq.search.view.ISearchResultView;
import com.tencent.mobileqq.util.FaceDecoder;

public class ContactSearchResultMobilePresenter
  extends ContactSearchResultPresenter
{
  public ContactSearchResultMobilePresenter(FaceDecoder paramFaceDecoder, ContactSearchResultPresenter.OnActionListener paramOnActionListener)
  {
    super(paramFaceDecoder, paramOnActionListener);
  }
  
  public void a(ISearchResultModel paramISearchResultModel, ISearchResultView paramISearchResultView)
  {
    super.a(paramISearchResultModel, paramISearchResultView);
    if (TextUtils.isEmpty(paramISearchResultModel.c()))
    {
      paramISearchResultView.g().setVisibility(8);
      ((ContactSearchResultMobileView)paramISearchResultView).a().setVisibility(0);
    }
    for (;;)
    {
      if (paramISearchResultView.h() != null) {
        paramISearchResultView.h().setVisibility(8);
      }
      return;
      paramISearchResultView.g().setVisibility(0);
      paramISearchResultView.g().setText(paramISearchResultModel.c());
      ((ContactSearchResultMobileView)paramISearchResultView).a().setVisibility(8);
    }
  }
  
  public void c(ISearchResultModel paramISearchResultModel, ISearchResultView paramISearchResultView) {}
  
  protected void d(ISearchResultModel paramISearchResultModel, ISearchResultView paramISearchResultView)
  {
    super.d(paramISearchResultModel, paramISearchResultView);
    ((ContactSearchResultMobileView)paramISearchResultView).a().setOnClickListener(new ahgc(this, paramISearchResultModel));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.search.presenter.ContactSearchResultMobilePresenter
 * JD-Core Version:    0.7.0.1
 */