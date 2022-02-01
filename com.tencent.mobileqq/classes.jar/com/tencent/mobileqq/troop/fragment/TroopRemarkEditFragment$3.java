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
      if (!TextUtils.equals(paramString, TroopRemarkEditFragment.b(this.a))) {
        return;
      }
      paramString = this.a;
      TroopRemarkEditFragment.a(paramString, TroopRemarkEditFragment.a(paramString));
      if ((paramBoolean) && (paramInt == 0))
      {
        ReportController.b(TroopRemarkEditFragment.a(this.a), "dc00899", "Grp_set_new", "", "groupnameRemarks", "sub_success", 0, 0, TroopRemarkEditFragment.b(this.a), "", "", "");
        paramString = new Intent();
        paramString.putExtra("result", TroopRemarkEditFragment.e(this.a));
        this.a.getActivity().setResult(-1, paramString);
        this.a.getActivity().finish();
        return;
      }
      QQToast.a(this.a.getActivity(), 2131699542, 0).b(this.a.getQBaseActivity().getTitleBarHeight());
      ReportController.b(TroopRemarkEditFragment.a(this.a), "dc00899", "Grp_set_new", "", "groupnameRemarks", "sub_failure", 0, 0, TroopRemarkEditFragment.b(this.a), "1", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.troop.fragment.TroopRemarkEditFragment.3
 * JD-Core Version:    0.7.0.1
 */