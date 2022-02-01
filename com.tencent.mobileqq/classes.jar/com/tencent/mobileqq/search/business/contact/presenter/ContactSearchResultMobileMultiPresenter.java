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
  private List<PhoneContact> b;
  
  public ContactSearchResultMobileMultiPresenter(IFaceDecoder paramIFaceDecoder, ContactSearchResultPresenter.OnActionListener paramOnActionListener, List<PhoneContact> paramList)
  {
    super(paramIFaceDecoder, paramOnActionListener);
    this.b = paramList;
  }
  
  public void a(ISearchResultModel paramISearchResultModel, ISearchResultView paramISearchResultView)
  {
    super.a(paramISearchResultModel, paramISearchResultView);
    if (paramISearchResultView.d() != null)
    {
      paramISearchResultModel = (ContactSearchModelPhoneContact)paramISearchResultModel;
      Object localObject = this.b;
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
            paramISearchResultView.d().setText(HardCodeUtil.a(2131900680));
            i = 1;
          }
        }
      }
      int j = 0;
      if (!TextUtils.isEmpty(paramISearchResultModel.a()))
      {
        paramISearchResultView.d().setText(paramISearchResultModel.a());
        j = 1;
      }
      paramISearchResultModel = paramISearchResultView.d();
      if (j != 0) {
        i = k;
      } else {
        i = 8;
      }
      paramISearchResultModel.setVisibility(i);
      paramISearchResultView.h().setClickable(j ^ 0x1);
    }
    if (paramISearchResultView.f() != null) {
      paramISearchResultView.f().setVisibility(8);
    }
  }
  
  public void d(ISearchResultModel paramISearchResultModel, ISearchResultView paramISearchResultView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.business.contact.presenter.ContactSearchResultMobileMultiPresenter
 * JD-Core Version:    0.7.0.1
 */