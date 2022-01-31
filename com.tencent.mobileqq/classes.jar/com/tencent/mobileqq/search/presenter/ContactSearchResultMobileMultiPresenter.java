package com.tencent.mobileqq.search.presenter;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.search.model.ContactSearchModelPhoneContact;
import com.tencent.mobileqq.search.model.ISearchResultModel;
import com.tencent.mobileqq.search.view.ISearchResultView;
import com.tencent.mobileqq.util.FaceDecoder;
import java.util.Iterator;
import java.util.List;

public class ContactSearchResultMobileMultiPresenter
  extends ContactSearchResultPresenter
{
  private List a;
  
  public ContactSearchResultMobileMultiPresenter(FaceDecoder paramFaceDecoder, ContactSearchResultPresenter.OnActionListener paramOnActionListener, List paramList)
  {
    super(paramFaceDecoder, paramOnActionListener);
    this.a = paramList;
  }
  
  public void a(ISearchResultModel paramISearchResultModel, ISearchResultView paramISearchResultView)
  {
    boolean bool = true;
    super.a(paramISearchResultModel, paramISearchResultView);
    int i;
    int j;
    if (paramISearchResultView.g() != null)
    {
      paramISearchResultModel = (ContactSearchModelPhoneContact)paramISearchResultModel;
      if (this.a != null)
      {
        Iterator localIterator = this.a.iterator();
        i = 0;
        j = i;
        if (!localIterator.hasNext()) {
          break label98;
        }
        if (((PhoneContact)localIterator.next()).contactID != paramISearchResultModel.a.contactID) {
          break label194;
        }
        paramISearchResultView.g().setText("已选择");
        i = 1;
      }
    }
    label188:
    label194:
    for (;;)
    {
      break;
      j = 0;
      label98:
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
          break label188;
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
  
  public void c(ISearchResultModel paramISearchResultModel, ISearchResultView paramISearchResultView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.search.presenter.ContactSearchResultMobileMultiPresenter
 * JD-Core Version:    0.7.0.1
 */