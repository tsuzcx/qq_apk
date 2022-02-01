package com.tencent.mobileqq.search.presenter;

import android.text.TextUtils;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.search.model.ISearchResultModel;
import com.tencent.mobileqq.search.model.TroopBatchAddFrdsSearchModelMember;
import com.tencent.mobileqq.search.view.ISearchResultView;
import com.tencent.mobileqq.search.view.TroopAddFrdsSrchResultView;

public class TroopAddFrdsSrchResultPresenter
  extends ContactSearchResultPresenter
{
  public TroopAddFrdsSrchResultPresenter(IFaceDecoder paramIFaceDecoder, ContactSearchResultPresenter.OnActionListener paramOnActionListener)
  {
    super(paramIFaceDecoder, paramOnActionListener);
  }
  
  public void b(ISearchResultModel paramISearchResultModel, ISearchResultView paramISearchResultView)
  {
    super.b(paramISearchResultModel, paramISearchResultView);
    if (TextUtils.isEmpty(paramISearchResultModel.c()))
    {
      paramISearchResultView.c().setVisibility(8);
      ((TroopAddFrdsSrchResultView)paramISearchResultView).a().setVisibility(0);
      if (paramISearchResultView.b() != null)
      {
        paramISearchResultModel = ((TroopBatchAddFrdsSearchModelMember)paramISearchResultModel).d();
        if (!TextUtils.isEmpty(paramISearchResultModel)) {
          break label127;
        }
        paramISearchResultView.b().setVisibility(8);
      }
    }
    for (;;)
    {
      paramISearchResultView.d().setVisibility(8);
      return;
      paramISearchResultView.c().setVisibility(0);
      paramISearchResultView.c().setText(paramISearchResultModel.c());
      ((TroopAddFrdsSrchResultView)paramISearchResultView).a().setVisibility(8);
      break;
      label127:
      paramISearchResultView.b().setVisibility(0);
      paramISearchResultView.b().setText(paramISearchResultModel);
    }
  }
  
  protected void c(ISearchResultModel paramISearchResultModel, ISearchResultView paramISearchResultView)
  {
    super.c(paramISearchResultModel, paramISearchResultView);
    ((TroopAddFrdsSrchResultView)paramISearchResultView).a().setOnClickListener(new TroopAddFrdsSrchResultPresenter.1(this, paramISearchResultModel));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.search.presenter.TroopAddFrdsSrchResultPresenter
 * JD-Core Version:    0.7.0.1
 */