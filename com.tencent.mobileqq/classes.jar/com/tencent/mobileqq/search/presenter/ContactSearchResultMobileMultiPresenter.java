package com.tencent.mobileqq.search.presenter;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.search.model.ContactSearchModelPhoneContact;
import com.tencent.mobileqq.search.model.ISearchResultModel;
import com.tencent.mobileqq.search.view.ISearchResultView;
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
  
  public void b(ISearchResultModel paramISearchResultModel, ISearchResultView paramISearchResultView)
  {
    boolean bool = true;
    super.b(paramISearchResultModel, paramISearchResultView);
    int i;
    int j;
    if (paramISearchResultView.c() != null)
    {
      paramISearchResultModel = (ContactSearchModelPhoneContact)paramISearchResultModel;
      if (this.a != null)
      {
        Iterator localIterator = this.a.iterator();
        i = 0;
        j = i;
        if (!localIterator.hasNext()) {
          break label101;
        }
        if (((PhoneContact)localIterator.next()).contactID != paramISearchResultModel.a.contactID) {
          break label197;
        }
        paramISearchResultView.c().setText(HardCodeUtil.a(2131702558));
        i = 1;
      }
    }
    label191:
    label197:
    for (;;)
    {
      break;
      j = 0;
      label101:
      if (!TextUtils.isEmpty(paramISearchResultModel.c()))
      {
        paramISearchResultView.c().setText(paramISearchResultModel.c());
        j = 1;
      }
      paramISearchResultModel = paramISearchResultView.c();
      if (j != 0)
      {
        i = 0;
        paramISearchResultModel.setVisibility(i);
        paramISearchResultModel = paramISearchResultView.a();
        if (j != 0) {
          break label191;
        }
      }
      for (;;)
      {
        paramISearchResultModel.setClickable(bool);
        if (paramISearchResultView.a() != null) {
          paramISearchResultView.a().setVisibility(8);
        }
        return;
        i = 8;
        break;
        bool = false;
      }
    }
  }
  
  public void d(ISearchResultModel paramISearchResultModel, ISearchResultView paramISearchResultView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.search.presenter.ContactSearchResultMobileMultiPresenter
 * JD-Core Version:    0.7.0.1
 */