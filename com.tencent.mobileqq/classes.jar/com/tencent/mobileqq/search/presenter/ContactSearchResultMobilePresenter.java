package com.tencent.mobileqq.search.presenter;

import android.text.TextUtils;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.search.model.ISearchResultModel;
import com.tencent.mobileqq.search.view.ContactSearchResultMobileView;
import com.tencent.mobileqq.search.view.ISearchResultView;

public class ContactSearchResultMobilePresenter
  extends ContactSearchResultPresenter
{
  public ContactSearchResultMobilePresenter(IFaceDecoder paramIFaceDecoder, ContactSearchResultPresenter.OnActionListener paramOnActionListener)
  {
    super(paramIFaceDecoder, paramOnActionListener);
  }
  
  public void b(ISearchResultModel paramISearchResultModel, ISearchResultView paramISearchResultView)
  {
    super.b(paramISearchResultModel, paramISearchResultView);
    if (TextUtils.isEmpty(paramISearchResultModel.c()))
    {
      paramISearchResultView.c().setVisibility(8);
      ((ContactSearchResultMobileView)paramISearchResultView).a().setVisibility(0);
    }
    for (;;)
    {
      if (paramISearchResultView.d() != null)
      {
        paramISearchResultModel = paramISearchResultModel.d();
        if (!TextUtils.isEmpty(paramISearchResultModel)) {
          break;
        }
        paramISearchResultView.d().setVisibility(8);
      }
      return;
      paramISearchResultView.c().setVisibility(0);
      paramISearchResultView.c().setText(paramISearchResultModel.c());
      ((ContactSearchResultMobileView)paramISearchResultView).a().setVisibility(8);
    }
    paramISearchResultView.d().setVisibility(0);
    paramISearchResultView.d().setText(paramISearchResultModel);
  }
  
  protected void c(ISearchResultModel paramISearchResultModel, ISearchResultView paramISearchResultView)
  {
    super.c(paramISearchResultModel, paramISearchResultView);
    ((ContactSearchResultMobileView)paramISearchResultView).a().setOnClickListener(new ContactSearchResultMobilePresenter.1(this, paramISearchResultModel));
  }
  
  public void d(ISearchResultModel paramISearchResultModel, ISearchResultView paramISearchResultView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.search.presenter.ContactSearchResultMobilePresenter
 * JD-Core Version:    0.7.0.1
 */