package com.tencent.mobileqq.search.business.contact.presenter;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.api.ISearchPieceFetcher;
import com.tencent.mobileqq.search.base.util.SearchViewUtils;
import com.tencent.mobileqq.search.base.view.ISearchResultView;
import com.tencent.mobileqq.search.business.contact.model.ContactSearchModelDiscussion;
import com.tencent.mobileqq.search.business.contact.model.ContactSearchModelNewTroop;
import com.tencent.mobileqq.search.business.contact.model.ContactSearchModelTroop;
import com.tencent.mobileqq.search.business.contact.view.ContactSearchResultView;
import com.tencent.mobileqq.search.business.troop.view.TroopAddFrdsSrchResultView;
import com.tencent.mobileqq.search.model.ISearchResultModel;
import java.util.Set;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class SelectMemberContactSearchResultPresenter
  extends ContactSearchResultPresenter
{
  private Set<String> b;
  
  public SelectMemberContactSearchResultPresenter(IFaceDecoder paramIFaceDecoder, ContactSearchResultPresenter.OnActionListener paramOnActionListener, Set<String> paramSet1, Set<String> paramSet2)
  {
    super(paramIFaceDecoder, paramOnActionListener, paramSet1);
    this.b = paramSet2;
  }
  
  private void e(ISearchResultModel paramISearchResultModel, ISearchResultView paramISearchResultView)
  {
    if (((paramISearchResultView instanceof ContactSearchResultView)) && ((paramISearchResultModel instanceof ContactSearchModelTroop)))
    {
      Object localObject = (ContactSearchModelTroop)paramISearchResultModel;
      if ((((ContactSearchModelTroop)localObject).a == 3) && (paramISearchResultView.h() != null))
      {
        paramISearchResultModel = (TextView)paramISearchResultView.h().findViewById(2131444605);
        localObject = ((ContactSearchModelTroop)localObject).s();
        if ((paramISearchResultModel != null) && (!TextUtils.isEmpty((CharSequence)localObject)))
        {
          paramISearchResultModel.setVisibility(0);
          paramISearchResultModel.setText((CharSequence)localObject);
        }
        paramISearchResultModel = paramISearchResultView.b();
        if (paramISearchResultModel != null)
        {
          paramISearchResultView = (RelativeLayout.LayoutParams)paramISearchResultModel.getLayoutParams();
          if (paramISearchResultView != null)
          {
            paramISearchResultView.addRule(15, 0);
            paramISearchResultModel.setLayoutParams(paramISearchResultView);
          }
        }
      }
    }
  }
  
  public void a(ISearchResultModel paramISearchResultModel, ISearchResultView paramISearchResultView)
  {
    super.a(paramISearchResultModel, paramISearchResultView);
    if (paramISearchResultView.d() != null)
    {
      localObject = paramISearchResultModel.c();
      Set localSet = this.b;
      if ((localSet != null) && (localSet.contains(localObject))) {
        paramISearchResultView.d().setText(HardCodeUtil.a(2131911182));
      }
    }
    Object localObject = (AppInterface)MobileQQ.sMobileQQ.peekAppRuntime();
    boolean bool = SearchViewUtils.a((AppInterface)localObject, paramISearchResultModel.c());
    if (((ISearchPieceFetcher)QRoute.api(ISearchPieceFetcher.class)).isQQAppInterface((AppRuntime)localObject)) {
      if ((paramISearchResultView instanceof ContactSearchResultView)) {
        ((ContactSearchResultView)paramISearchResultView).a(bool);
      } else if ((paramISearchResultView instanceof TroopAddFrdsSrchResultView)) {
        ((TroopAddFrdsSrchResultView)paramISearchResultView).a(bool);
      }
    }
    if (paramISearchResultView.f() != null) {
      if ((!(paramISearchResultModel instanceof ContactSearchModelTroop)) && (!(paramISearchResultModel instanceof ContactSearchModelDiscussion)) && (!(paramISearchResultModel instanceof ContactSearchModelNewTroop)))
      {
        if (paramISearchResultView.d() != null) {
          paramISearchResultView.d().setVisibility(0);
        }
        paramISearchResultView.f().setVisibility(8);
      }
      else
      {
        if (paramISearchResultView.d() != null) {
          paramISearchResultView.d().setVisibility(8);
        }
        paramISearchResultView.f().setVisibility(0);
      }
    }
    e(paramISearchResultModel, paramISearchResultView);
  }
  
  public void d(ISearchResultModel paramISearchResultModel, ISearchResultView paramISearchResultView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.business.contact.presenter.SelectMemberContactSearchResultPresenter
 * JD-Core Version:    0.7.0.1
 */