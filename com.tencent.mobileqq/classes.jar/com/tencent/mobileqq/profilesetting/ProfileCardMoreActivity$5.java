package com.tencent.mobileqq.profilesetting;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import java.util.HashMap;
import java.util.Map;

class ProfileCardMoreActivity$5
  implements DialogInterface.OnClickListener
{
  ProfileCardMoreActivity$5(ProfileCardMoreActivity paramProfileCardMoreActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = new HashMap();
    paramDialogInterface.put("sgrp_member_delete_result", Integer.valueOf(3));
    VideoReport.reportEvent("clck", ProfileCardMoreActivity.a(this.a).getBtnLeft(), paramDialogInterface);
    ProfileCardMoreActivity.a(this.a).dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.profilesetting.ProfileCardMoreActivity.5
 * JD-Core Version:    0.7.0.1
 */