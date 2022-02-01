package com.tencent.mobileqq.nearby.profilecard;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.nearby.api.INearbySPUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.util.InputMethodUtil;

class NearbyProfileEditTribePanel$14
  implements View.OnClickListener
{
  NearbyProfileEditTribePanel$14(NearbyProfileEditTribePanel paramNearbyProfileEditTribePanel) {}
  
  public void onClick(View paramView)
  {
    if ((this.a.A.mEnterProfileIntent.getIntExtra("param_mode", 0) == 1) && (this.a.B == null))
    {
      this.a.A.finish();
      return;
    }
    if (this.a.A.mMode != 1) {
      return;
    }
    InputMethodUtil.a(this.a.A);
    if (!NetworkUtil.isNetSupport(BaseApplication.getContext()))
    {
      this.a.A.showToast(this.a.A.getString(2131892104));
      return;
    }
    if (!NearbyProfileEditTribePanel.b(this.a)) {
      return;
    }
    this.a.k();
    boolean bool1 = this.a.d();
    boolean bool2 = ((Boolean)((INearbySPUtil)QRoute.api(INearbySPUtil.class)).getValue(this.a.A.app.getCurrentAccountUin(), "nearby_profile_edit_isFirst", Boolean.valueOf(true))).booleanValue();
    if ((this.a.B != null) && (this.a.B.godFlag) && (bool1))
    {
      paramView = this.a.A.getString(2131892097, new Object[] { this.a.G });
      paramView = DialogUtil.a(this.a.A, paramView, 0, 0, null, null);
      paramView.setPositiveButton(HardCodeUtil.a(2131905134), new NearbyProfileEditTribePanel.14.1(this, paramView));
      paramView.setNegativeButton(HardCodeUtil.a(2131905129), new NearbyProfileEditTribePanel.14.2(this, paramView));
      paramView.show();
      return;
    }
    if ((bool1) && (bool2))
    {
      paramView = HardCodeUtil.a(2131905156);
      paramView = DialogUtil.a(this.a.A, paramView, 0, 0, null, null);
      paramView.setPositiveButton(HardCodeUtil.a(2131905176), new NearbyProfileEditTribePanel.14.3(this, paramView));
      paramView.setNegativeButton(HardCodeUtil.a(2131905206), new NearbyProfileEditTribePanel.14.4(this, paramView));
      paramView.show();
      ((INearbySPUtil)QRoute.api(INearbySPUtil.class)).setValue(this.a.A.app.getCurrentAccountUin(), "nearby_profile_edit_isFirst", Boolean.valueOf(false));
      return;
    }
    if (bool1)
    {
      this.a.j();
      paramView = new Intent("tribe_profile_edit_finish");
      BaseApplicationImpl.getApplication().sendBroadcast(paramView);
      return;
    }
    ReportController.b(this.a.A.app, "dc00899", "grp_lbs", "", "data_card", "return_no", 0, 0, "", "", "", "");
    this.a.A.quitEditWithoutSaving();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyProfileEditTribePanel.14
 * JD-Core Version:    0.7.0.1
 */