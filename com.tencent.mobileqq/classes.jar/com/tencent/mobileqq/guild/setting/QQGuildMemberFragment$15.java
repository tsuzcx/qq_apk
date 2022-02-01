package com.tencent.mobileqq.guild.setting;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.widget.CheckBox;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import java.util.HashMap;
import java.util.Map;

class QQGuildMemberFragment$15
  implements DialogInterface.OnDismissListener
{
  QQGuildMemberFragment$15(QQGuildMemberFragment paramQQGuildMemberFragment, CheckBox paramCheckBox) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    paramDialogInterface = new HashMap();
    int i;
    if (this.a.isChecked()) {
      i = 1;
    } else {
      i = 2;
    }
    paramDialogInterface.put("sgrp_member_delete_result", Integer.valueOf(i));
    VideoReport.reportEvent("imp", QQGuildMemberFragment.g(this.b).getBtnight(), paramDialogInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.setting.QQGuildMemberFragment.15
 * JD-Core Version:    0.7.0.1
 */