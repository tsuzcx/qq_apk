package com.tencent.mobileqq.search.business.contact.presenter;

import android.text.TextUtils;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.search.base.view.ISearchResultView;
import com.tencent.mobileqq.search.business.contact.view.ContactSearchResultMobileView;
import com.tencent.mobileqq.search.model.ISearchResultModel;

public class ContactSearchResultMobilePresenter
  extends ContactSearchResultPresenter
{
  public ContactSearchResultMobilePresenter(IFaceDecoder paramIFaceDecoder, ContactSearchResultPresenter.OnActionListener paramOnActionListener)
  {
    super(paramIFaceDecoder, paramOnActionListener);
  }
  
  public void a(ISearchResultModel paramISearchResultModel, ISearchResultView paramISearchResultView)
  {
    super.a(paramISearchResultModel, paramISearchResultView);
    if (TextUtils.isEmpty(paramISearchResultModel.a()))
    {
      paramISearchResultView.c().setVisibility(8);
      ((ContactSearchResultMobileView)paramISearchResultView).a().setVisibility(0);
    }
    else
    {
      paramISearchResultView.c().setVisibility(0);
      paramISearchResultView.c().setText(paramISearchResultModel.a());
      ((ContactSearchResultMobileView)paramISearchResultView).a().setVisibility(8);
    }
    if (paramISearchResultView.d() != null)
    {
      paramISearchResultModel = paramISearchResultModel.d();
      if (TextUtils.isEmpty(paramISearchResultModel))
      {
        paramISearchResultView.d().setVisibility(8);
        return;
      }
      paramISearchResultView.d().setVisibility(0);
      paramISearchResultView.d().setText(paramISearchResultModel);
    }
  }
  
  protected void c(ISearchResultModel paramISearchResultModel, ISearchResultView paramISearchResultView)
  {
    super.c(paramISearchResultModel, paramISearchResultView);
    ((ContactSearchResultMobileView)paramISearchResultView).a().setOnClickListener(new ContactSearchResultMobilePresenter.1(this, paramISearchResultModel));
  }
  
  public void d(ISearchResultModel paramISearchResultModel, ISearchResultView paramISearchResultView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.search.business.contact.presenter.ContactSearchResultMobilePresenter
 * JD-Core Version:    0.7.0.1
 */