package com.tencent.mobileqq.search.business.contact.presenter;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.search.base.view.ISearchResultView;
import com.tencent.mobileqq.search.business.contact.model.ContactSearchModelPhoneContact;
import com.tencent.mobileqq.search.model.ISearchResultModel;
import java.util.Iterator;
import java.util.List;

public class ContactSearchResultMobileMultiPresenter
  extends ContactSearchResultPresenter
{
  private List<PhoneContact> a;
  
  public ContactSearchResultMobileMultiPresenter(IFaceDecoder paramIFaceDecoder, ContactSearchResultPresenter.OnActionListener paramOnActionListener, List<PhoneContact> paramList)
  {
    super(paramIFaceDecoder, paramOnActionListener);
    this.a = paramList;
  }
  
  public void a(ISearchResultModel paramISearchResultModel, ISearchResultView paramISearchResultView)
  {
    super.a(paramISearchResultModel, paramISearchResultView);
    if (paramISearchResultView.c() != null)
    {
      paramISearchResultModel = (ContactSearchModelPhoneContact)paramISearchResultModel;
      Object localObject = this.a;
      int k = 0;
      int i;
      if (localObject != null)
      {
        localObject = ((List)localObject).iterator();
        i = 0;
        for (;;)
        {
          j = i;
          if (!((Iterator)localObject).hasNext()) {
            break;
          }
          if (((PhoneContact)((Iterator)localObject).next()).contactID == paramISearchResultModel.a.contactID)
          {
            paramISearchResultView.c().setText(HardCodeUtil.a(2131702690));
            i = 1;
          }
        }
      }
      int j = 0;
      if (!TextUtils.isEmpty(paramISearchResultModel.a()))
      {
        paramISearchResultView.c().setText(paramISearchResultModel.a());
        j = 1;
      }
      paramISearchResultModel = paramISearchResultView.c();
      if (j != 0) {
        i = k;
      } else {
        i = 8;
      }
      paramISearchResultModel.setVisibility(i);
      paramISearchResultView.a().setClickable(j ^ 0x1);
    }
    if (paramISearchResultView.a() != null) {
      paramISearchResultView.a().setVisibility(8);
    }
  }
  
  public void d(ISearchResultModel paramISearchResultModel, ISearchResultView paramISearchResultView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.search.business.contact.presenter.ContactSearchResultMobileMultiPresenter
 * JD-Core Version:    0.7.0.1
 */