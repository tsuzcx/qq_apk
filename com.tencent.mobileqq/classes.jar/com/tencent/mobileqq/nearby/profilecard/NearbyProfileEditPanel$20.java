package com.tencent.mobileqq.nearby.profilecard;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.nearby.api.INearbySPUtil;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.ReportTask;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.util.InputMethodUtil;
import tencent.im.oidb.cmd0xac5.cmd0xac5.MasterState;
import tencent.im.oidb.cmd0xac5.cmd0xac5.NearbyNowData;

class NearbyProfileEditPanel$20
  implements View.OnClickListener
{
  NearbyProfileEditPanel$20(NearbyProfileEditPanel paramNearbyProfileEditPanel) {}
  
  public void onClick(View paramView)
  {
    int i = this.a.F.mEnterProfileIntent.getIntExtra("param_mode", 0);
    this.a.F.notifyExitProfile(false);
    if ((i == 1) && (this.a.G == null))
    {
      this.a.F.finish();
      return;
    }
    if (this.a.F.mMode != 1) {
      return;
    }
    InputMethodUtil.a(this.a.F);
    if (!NetworkUtil.isNetSupport(BaseApplication.getContext()))
    {
      this.a.F.showToast(this.a.F.getString(2131892104));
      return;
    }
    if (!NearbyProfileEditPanel.e(this.a)) {
      return;
    }
    this.a.t();
    boolean bool1 = this.a.d();
    boolean bool2 = ((Boolean)((INearbySPUtil)QRoute.api(INearbySPUtil.class)).getValue(this.a.F.app.getCurrentAccountUin(), "nearby_profile_edit_isFirst", Boolean.valueOf(true))).booleanValue();
    boolean bool3 = this.a.k();
    if ((this.a.G.nearbyNowData != null) && (this.a.G.nearbyNowData.get() != null) && (((cmd0xac5.NearbyNowData)this.a.G.nearbyNowData.get()).master_state.get() != null)) {
      i = ((cmd0xac5.MasterState)((cmd0xac5.NearbyNowData)this.a.G.nearbyNowData.get()).master_state.get()).uint32_state.get();
    } else {
      i = 0;
    }
    if ((i != 1) && (i != 2)) {
      i = 0;
    } else {
      i = 1;
    }
    if ((this.a.G != null) && (bool3) && (i != 0))
    {
      paramView = new ReportTask(this.a.F.app).a("dc00899").b("grp_lbs").c("face_score_vip").d("expert_change");
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(this.a.G.gender + 1);
      paramView.a(new String[] { "", localStringBuilder.toString() }).a();
      this.a.F.isFaceInfoChange = bool3;
      this.a.s();
      return;
    }
    if ((this.a.G != null) && (this.a.G.godFlag) && (bool1))
    {
      paramView = this.a.F.getString(2131892097, new Object[] { this.a.L });
      paramView = DialogUtil.a(this.a.F, paramView, 0, 0, null, null);
      paramView.setPositiveButton(HardCodeUtil.a(2131905107), new NearbyProfileEditPanel.20.1(this, paramView));
      paramView.setNegativeButton(HardCodeUtil.a(2131905228), new NearbyProfileEditPanel.20.2(this, paramView));
      paramView.show();
      return;
    }
    if ((bool1) && (bool2))
    {
      paramView = HardCodeUtil.a(2131905216);
      paramView = DialogUtil.a(this.a.F, paramView, 0, 0, null, null);
      paramView.setPositiveButton(HardCodeUtil.a(2131905169), new NearbyProfileEditPanel.20.3(this, paramView));
      paramView.setNegativeButton(HardCodeUtil.a(2131905171), new NearbyProfileEditPanel.20.4(this, paramView));
      paramView.show();
      ((INearbySPUtil)QRoute.api(INearbySPUtil.class)).setValue(this.a.F.app.getCurrentAccountUin(), "nearby_profile_edit_isFirst", Boolean.valueOf(false));
      return;
    }
    if (bool1)
    {
      this.a.s();
      return;
    }
    ReportController.b(this.a.F.app, "dc00899", "grp_lbs", "", "data_card", "return_no", 0, 0, "", "", "", "");
    this.a.F.quitEditWithoutSaving();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyProfileEditPanel.20
 * JD-Core Version:    0.7.0.1
 */