package com.tencent.mobileqq.troop.fragment;

import android.content.Intent;
import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.troopsetting.api.TroopSettingObserver;
import com.tencent.mobileqq.widget.QQToast;

class TroopRemarkEditFragment$3
  extends TroopSettingObserver
{
  TroopRemarkEditFragment$3(TroopRemarkEditFragment paramTroopRemarkEditFragment) {}
  
  protected void a(boolean paramBoolean, String paramString, int paramInt)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (!TextUtils.equals(paramString, TroopRemarkEditFragment.d(this.a))) {
        return;
      }
      paramString = this.a;
      TroopRemarkEditFragment.a(paramString, TroopRemarkEditFragment.b(paramString));
      if ((paramBoolean) && (paramInt == 0))
      {
        ReportController.b(TroopRemarkEditFragment.c(this.a), "dc00899", "Grp_set_new", "", "groupnameRemarks", "sub_success", 0, 0, TroopRemarkEditFragment.d(this.a), "", "", "");
        paramString = new Intent();
        paramString.putExtra("result", TroopRemarkEditFragment.h(this.a));
        this.a.getActivity().setResult(-1, paramString);
        this.a.getActivity().finish();
        return;
      }
      QQToast.makeText(this.a.getActivity(), 2131897573, 0).show(this.a.getQBaseActivity().getTitleBarHeight());
      ReportController.b(TroopRemarkEditFragment.c(this.a), "dc00899", "Grp_set_new", "", "groupnameRemarks", "sub_failure", 0, 0, TroopRemarkEditFragment.d(this.a), "1", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.fragment.TroopRemarkEditFragment.3
 * JD-Core Version:    0.7.0.1
 */