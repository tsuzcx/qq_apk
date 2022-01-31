package com.tencent.mobileqq.search.presenter;

import ahzn;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mobileqq.search.model.ISearchResultModel;
import com.tencent.mobileqq.search.model.TroopBatchAddFrdsSearchModelMember;
import com.tencent.mobileqq.search.view.ISearchResultView;
import com.tencent.mobileqq.search.view.TroopAddFrdsSrchResultView;
import com.tencent.mobileqq.util.FaceDecoder;

public class TroopAddFrdsSrchResultPresenter
  extends ContactSearchResultPresenter
{
  public TroopAddFrdsSrchResultPresenter(FaceDecoder paramFaceDecoder, ContactSearchResultPresenter.OnActionListener paramOnActionListener)
  {
    super(paramFaceDecoder, paramOnActionListener);
  }
  
  public void a(ISearchResultModel paramISearchResultModel, ISearchResultView paramISearchResultView)
  {
    super.a(paramISearchResultModel, paramISearchResultView);
    if (TextUtils.isEmpty(paramISearchResultModel.c()))
    {
      paramISearchResultView.g().setVisibility(8);
      ((TroopAddFrdsSrchResultView)paramISearchResultView).a().setVisibility(0);
      if (paramISearchResultView.f() != null)
      {
        paramISearchResultModel = ((TroopBatchAddFrdsSearchModelMember)paramISearchResultModel).d();
        if (!TextUtils.isEmpty(paramISearchResultModel)) {
          break label127;
        }
        paramISearchResultView.f().setVisibility(8);
      }
    }
    for (;;)
    {
      paramISearchResultView.h().setVisibility(8);
      return;
      paramISearchResultView.g().setVisibility(0);
      paramISearchResultView.g().setText(paramISearchResultModel.c());
      ((TroopAddFrdsSrchResultView)paramISearchResultView).a().setVisibility(8);
      break;
      label127:
      paramISearchResultView.f().setVisibility(0);
      paramISearchResultView.f().setText(paramISearchResultModel);
    }
  }
  
  protected void d(ISearchResultModel paramISearchResultModel, ISearchResultView paramISearchResultView)
  {
    super.d(paramISearchResultModel, paramISearchResultView);
    ((TroopAddFrdsSrchResultView)paramISearchResultView).a().setOnClickListener(new ahzn(this, paramISearchResultModel));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.search.presenter.TroopAddFrdsSrchResultPresenter
 * JD-Core Version:    0.7.0.1
 */