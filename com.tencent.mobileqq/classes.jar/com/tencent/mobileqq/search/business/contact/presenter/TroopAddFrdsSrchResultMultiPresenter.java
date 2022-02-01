package com.tencent.mobileqq.search.business.contact.presenter;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.search.base.view.ISearchResultView;
import com.tencent.mobileqq.search.business.contact.model.ContactSearchModelTroopMember;
import com.tencent.mobileqq.search.model.ISearchResultModel;
import java.util.Set;

public class TroopAddFrdsSrchResultMultiPresenter
  extends ContactSearchResultPresenter
{
  public TroopAddFrdsSrchResultMultiPresenter(IFaceDecoder paramIFaceDecoder, ContactSearchResultPresenter.OnActionListener paramOnActionListener, Set<String> paramSet)
  {
    super(paramIFaceDecoder, paramOnActionListener, paramSet);
  }
  
  public void a(ISearchResultModel paramISearchResultModel, ISearchResultView paramISearchResultView)
  {
    super.a(paramISearchResultModel, paramISearchResultView);
    if (paramISearchResultView.d() != null)
    {
      paramISearchResultModel = (ContactSearchModelTroopMember)paramISearchResultModel;
      Set localSet = this.a;
      int j = 0;
      int i;
      if ((localSet != null) && (this.a.contains(paramISearchResultModel.c()))) {
        i = 1;
      } else {
        i = 0;
      }
      if (!TextUtils.isEmpty(paramISearchResultModel.a()))
      {
        paramISearchResultView.d().setText(paramISearchResultModel.a());
        i = 1;
      }
      paramISearchResultModel = paramISearchResultView.d();
      if (i == 0) {
        j = 8;
      }
      paramISearchResultModel.setVisibility(j);
      paramISearchResultView.h().setClickable(i ^ 0x1);
    }
    if (paramISearchResultView.f() != null) {
      paramISearchResultView.f().setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.business.contact.presenter.TroopAddFrdsSrchResultMultiPresenter
 * JD-Core Version:    0.7.0.1
 */