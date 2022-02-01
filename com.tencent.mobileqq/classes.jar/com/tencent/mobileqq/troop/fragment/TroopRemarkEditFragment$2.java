package com.tencent.mobileqq.troop.fragment;

import android.support.v4.app.FragmentActivity;
import android.text.Editable;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.text.QQText;
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
    TroopRemarkEditFragment.a(this.a, TroopRemarkEditFragment.a(this.a));
    if (!NetworkUtil.d(this.a.getActivity()))
    {
      QQToast.a(this.a.getActivity(), 1, 2131694459, 0).a();
      ReportController.b(TroopRemarkEditFragment.a(this.a), "dc00899", "Grp_set_new", "", "groupnameRemarks", "sub_failure", 0, 0, TroopRemarkEditFragment.b(this.a), "1", "", "");
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      Editable localEditable = TroopRemarkEditFragment.a(this.a).getText();
      Object localObject2 = null;
      Object localObject1 = localObject2;
      if (localEditable != null)
      {
        localObject1 = localObject2;
        if (localEditable.length() > 0) {
          localObject1 = new QQText(localEditable.toString(), 3);
        }
      }
      if (localObject1 == null) {}
      for (localObject1 = "";; localObject1 = ((QQText)localObject1).toString())
      {
        if (!TextUtils.equals((CharSequence)localObject1, TroopRemarkEditFragment.c(this.a))) {
          break label177;
        }
        this.a.getActivity().finish();
        break;
      }
      label177:
      TroopRemarkEditFragment.a(this.a, (String)localObject1);
      ((TroopHandler)this.a.getActivity().app.getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER)).c(TroopRemarkEditFragment.d(this.a), TroopRemarkEditFragment.b(this.a), (String)localObject1);
      TroopRemarkEditFragment.a(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.fragment.TroopRemarkEditFragment.2
 * JD-Core Version:    0.7.0.1
 */