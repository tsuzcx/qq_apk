package com.tencent.mobileqq.troop.fragment;

import android.text.Editable;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import androidx.fragment.app.FragmentActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.troop.troopsetting.api.ITroopSettingHandler;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.ClearableEditText;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class TroopRemarkEditFragment$2
  implements View.OnClickListener
{
  TroopRemarkEditFragment$2(TroopRemarkEditFragment paramTroopRemarkEditFragment) {}
  
  public void onClick(View paramView)
  {
    Object localObject1 = this.a;
    TroopRemarkEditFragment.a((TroopRemarkEditFragment)localObject1, TroopRemarkEditFragment.b((TroopRemarkEditFragment)localObject1));
    if (!NetworkUtil.isNetSupport(this.a.getActivity()))
    {
      QQToast.makeText(this.a.getActivity(), 1, 2131892104, 0).show();
      ReportController.b(TroopRemarkEditFragment.c(this.a), "dc00899", "Grp_set_new", "", "groupnameRemarks", "sub_failure", 0, 0, TroopRemarkEditFragment.d(this.a), "1", "", "");
    }
    else
    {
      Editable localEditable = TroopRemarkEditFragment.b(this.a).getText();
      Object localObject2 = null;
      localObject1 = localObject2;
      if (localEditable != null)
      {
        localObject1 = localObject2;
        if (localEditable.length() > 0) {
          localObject1 = new QQText(localEditable.toString(), 3);
        }
      }
      if (localObject1 == null) {
        localObject1 = "";
      } else {
        localObject1 = ((QQText)localObject1).toString();
      }
      if (TextUtils.equals((CharSequence)localObject1, TroopRemarkEditFragment.e(this.a)))
      {
        this.a.getActivity().finish();
      }
      else
      {
        TroopRemarkEditFragment.a(this.a, (String)localObject1);
        ((ITroopSettingHandler)this.a.getBaseActivity().app.getBusinessHandler(BusinessHandlerFactory.TROOP_SETTING_HANDLER)).a(TroopRemarkEditFragment.f(this.a), TroopRemarkEditFragment.d(this.a), (String)localObject1);
        TroopRemarkEditFragment.g(this.a);
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.fragment.TroopRemarkEditFragment.2
 * JD-Core Version:    0.7.0.1
 */