package com.tencent.mobileqq.search.presenter;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.search.model.ContactSearchModelTroopMember;
import com.tencent.mobileqq.search.model.ISearchResultModel;
import com.tencent.mobileqq.search.view.ISearchResultView;
import java.util.Set;

public class TroopAddFrdsSrchResultMultiPresenter
  extends ContactSearchResultPresenter
{
  public TroopAddFrdsSrchResultMultiPresenter(IFaceDecoder paramIFaceDecoder, ContactSearchResultPresenter.OnActionListener paramOnActionListener, Set<String> paramSet)
  {
    super(paramIFaceDecoder, paramOnActionListener, paramSet);
  }
  
  public void b(ISearchResultModel paramISearchResultModel, ISearchResultView paramISearchResultView)
  {
    boolean bool = true;
    super.b(paramISearchResultModel, paramISearchResultView);
    if (paramISearchResultView.c() != null)
    {
      paramISearchResultModel = (ContactSearchModelTroopMember)paramISearchResultModel;
      if ((this.a == null) || (!this.a.contains(paramISearchResultModel.b()))) {
        break label144;
      }
    }
    label138:
    label144:
    for (int i = 1;; i = 0)
    {
      if (!TextUtils.isEmpty(paramISearchResultModel.c()))
      {
        paramISearchResultView.c().setText(paramISearchResultModel.c());
        i = 1;
      }
      paramISearchResultModel = paramISearchResultView.c();
      int j;
      if (i != 0)
      {
        j = 0;
        paramISearchResultModel.setVisibility(j);
        paramISearchResultModel = paramISearchResultView.a();
        if (i != 0) {
          break label138;
        }
      }
      for (;;)
      {
        paramISearchResultModel.setClickable(bool);
        if (paramISearchResultView.a() != null) {
          paramISearchResultView.a().setVisibility(8);
        }
        return;
        j = 8;
        break;
        bool = false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.search.presenter.TroopAddFrdsSrchResultMultiPresenter
 * JD-Core Version:    0.7.0.1
 */