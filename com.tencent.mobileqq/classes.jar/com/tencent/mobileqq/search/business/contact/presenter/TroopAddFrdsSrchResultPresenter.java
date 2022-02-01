package com.tencent.mobileqq.search.business.contact.presenter;

import android.text.TextUtils;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.search.base.view.ISearchResultView;
import com.tencent.mobileqq.search.business.contact.model.TroopBatchAddFrdsSearchModelMember;
import com.tencent.mobileqq.search.business.troop.view.TroopAddFrdsSrchResultView;
import com.tencent.mobileqq.search.model.ISearchResultModel;

public class TroopAddFrdsSrchResultPresenter
  extends ContactSearchResultPresenter
{
  public TroopAddFrdsSrchResultPresenter(IFaceDecoder paramIFaceDecoder, ContactSearchResultPresenter.OnActionListener paramOnActionListener)
  {
    super(paramIFaceDecoder, paramOnActionListener);
  }
  
  public void a(ISearchResultModel paramISearchResultModel, ISearchResultView paramISearchResultView)
  {
    super.a(paramISearchResultModel, paramISearchResultView);
    if (TextUtils.isEmpty(paramISearchResultModel.a()))
    {
      paramISearchResultView.c().setVisibility(8);
      ((TroopAddFrdsSrchResultView)paramISearchResultView).a().setVisibility(0);
    }
    else
    {
      paramISearchResultView.c().setVisibility(0);
      paramISearchResultView.c().setText(paramISearchResultModel.a());
      ((TroopAddFrdsSrchResultView)paramISearchResultView).a().setVisibility(8);
    }
    if (paramISearchResultView.b() != null)
    {
      paramISearchResultModel = ((TroopBatchAddFrdsSearchModelMember)paramISearchResultModel).d();
      if (TextUtils.isEmpty(paramISearchResultModel))
      {
        paramISearchResultView.b().setVisibility(8);
      }
      else
      {
        paramISearchResultView.b().setVisibility(0);
        paramISearchResultView.b().setText(paramISearchResultModel);
      }
    }
    paramISearchResultView.d().setVisibility(8);
  }
  
  protected void c(ISearchResultModel paramISearchResultModel, ISearchResultView paramISearchResultView)
  {
    super.c(paramISearchResultModel, paramISearchResultView);
    ((TroopAddFrdsSrchResultView)paramISearchResultView).a().setOnClickListener(new TroopAddFrdsSrchResultPresenter.1(this, paramISearchResultModel));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.search.business.contact.presenter.TroopAddFrdsSrchResultPresenter
 * JD-Core Version:    0.7.0.1
 */