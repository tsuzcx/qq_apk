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
      paramISearchResultView.d().setVisibility(8);
      ((TroopAddFrdsSrchResultView)paramISearchResultView).j().setVisibility(0);
    }
    else
    {
      paramISearchResultView.d().setVisibility(0);
      paramISearchResultView.d().setText(paramISearchResultModel.a());
      ((TroopAddFrdsSrchResultView)paramISearchResultView).j().setVisibility(8);
    }
    if (paramISearchResultView.c() != null)
    {
      paramISearchResultModel = ((TroopBatchAddFrdsSearchModelMember)paramISearchResultModel).n();
      if (TextUtils.isEmpty(paramISearchResultModel))
      {
        paramISearchResultView.c().setVisibility(8);
      }
      else
      {
        paramISearchResultView.c().setVisibility(0);
        paramISearchResultView.c().setText(paramISearchResultModel);
      }
    }
    paramISearchResultView.e().setVisibility(8);
  }
  
  protected void c(ISearchResultModel paramISearchResultModel, ISearchResultView paramISearchResultView)
  {
    super.c(paramISearchResultModel, paramISearchResultView);
    ((TroopAddFrdsSrchResultView)paramISearchResultView).j().setOnClickListener(new TroopAddFrdsSrchResultPresenter.1(this, paramISearchResultModel));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.business.contact.presenter.TroopAddFrdsSrchResultPresenter
 * JD-Core Version:    0.7.0.1
 */