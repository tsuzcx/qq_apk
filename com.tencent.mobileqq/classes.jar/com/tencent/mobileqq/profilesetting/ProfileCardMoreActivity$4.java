package com.tencent.mobileqq.profilesetting;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.CheckBox;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import java.util.HashMap;
import java.util.Map;

class ProfileCardMoreActivity$4
  implements DialogInterface.OnClickListener
{
  ProfileCardMoreActivity$4(ProfileCardMoreActivity paramProfileCardMoreActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = new HashMap();
    if (((CheckBox)ProfileCardMoreActivity.a(this.a).findViewById(2131447782)).isChecked()) {
      paramInt = 1;
    } else {
      paramInt = 2;
    }
    paramDialogInterface.put("sgrp_member_delete_result", Integer.valueOf(paramInt));
    VideoReport.reportEvent("clck", ProfileCardMoreActivity.a(this.a).getBtnight(), paramDialogInterface);
    ProfileCardMoreActivity.b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.profilesetting.ProfileCardMoreActivity.4
 * JD-Core Version:    0.7.0.1
 */