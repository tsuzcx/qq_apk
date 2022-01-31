package com.tencent.mobileqq.search.presenter;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.search.model.ContactSearchModelTroopMember;
import com.tencent.mobileqq.search.model.ISearchResultModel;
import com.tencent.mobileqq.search.view.ISearchResultView;
import com.tencent.mobileqq.util.FaceDecoder;
import java.util.Iterator;
import java.util.Set;

public class TroopAddFrdsSrchResultMultiPresenter
  extends ContactSearchResultPresenter
{
  private Set a;
  
  public TroopAddFrdsSrchResultMultiPresenter(FaceDecoder paramFaceDecoder, ContactSearchResultPresenter.OnActionListener paramOnActionListener, Set paramSet)
  {
    super(paramFaceDecoder, paramOnActionListener);
    this.a = paramSet;
  }
  
  public void a(ISearchResultModel paramISearchResultModel, ISearchResultView paramISearchResultView)
  {
    boolean bool = true;
    super.a(paramISearchResultModel, paramISearchResultView);
    int i;
    int j;
    if (paramISearchResultView.g() != null)
    {
      paramISearchResultModel = (ContactSearchModelTroopMember)paramISearchResultModel;
      if (this.a != null)
      {
        Iterator localIterator = this.a.iterator();
        i = 0;
        j = i;
        if (!localIterator.hasNext()) {
          break label95;
        }
        if (!((String)localIterator.next()).equals(paramISearchResultModel.a())) {
          break label191;
        }
        paramISearchResultView.g().setText("已选择");
        i = 1;
      }
    }
    label185:
    label191:
    for (;;)
    {
      break;
      j = 0;
      label95:
      if (!TextUtils.isEmpty(paramISearchResultModel.c()))
      {
        paramISearchResultView.g().setText(paramISearchResultModel.c());
        j = 1;
      }
      paramISearchResultModel = paramISearchResultView.g();
      if (j != 0)
      {
        i = 0;
        paramISearchResultModel.setVisibility(i);
        paramISearchResultModel = paramISearchResultView.a();
        if (j != 0) {
          break label185;
        }
      }
      for (;;)
      {
        paramISearchResultModel.setClickable(bool);
        if (paramISearchResultView.b() != null) {
          paramISearchResultView.b().setVisibility(8);
        }
        return;
        i = 8;
        break;
        bool = false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.search.presenter.TroopAddFrdsSrchResultMultiPresenter
 * JD-Core Version:    0.7.0.1
 */