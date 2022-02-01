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
      paramISearchResultView.d().setVisibility(8);
      ((ContactSearchResultMobileView)paramISearchResultView).j().setVisibility(0);
    }
    else
    {
      paramISearchResultView.d().setVisibility(0);
      paramISearchResultView.d().setText(paramISearchResultModel.a());
      ((ContactSearchResultMobileView)paramISearchResultView).j().setVisibility(8);
    }
    if (paramISearchResultView.e() != null)
    {
      paramISearchResultModel = paramISearchResultModel.f();
      if (TextUtils.isEmpty(paramISearchResultModel))
      {
        paramISearchResultView.e().setVisibility(8);
        return;
      }
      paramISearchResultView.e().setVisibility(0);
      paramISearchResultView.e().setText(paramISearchResultModel);
    }
  }
  
  protected void c(ISearchResultModel paramISearchResultModel, ISearchResultView paramISearchResultView)
  {
    super.c(paramISearchResultModel, paramISearchResultView);
    ((ContactSearchResultMobileView)paramISearchResultView).j().setOnClickListener(new ContactSearchResultMobilePresenter.1(this, paramISearchResultModel));
  }
  
  public void d(ISearchResultModel paramISearchResultModel, ISearchResultView paramISearchResultView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.business.contact.presenter.ContactSearchResultMobilePresenter
 * JD-Core Version:    0.7.0.1
 */