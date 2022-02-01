package com.tencent.mobileqq.guild.setting;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.CheckBox;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class QQGuildMemberFragment$14
  implements DialogInterface.OnClickListener
{
  QQGuildMemberFragment$14(QQGuildMemberFragment paramQQGuildMemberFragment, List paramList, CheckBox paramCheckBox) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    QQGuildMemberFragment.b(this.c, this.a);
    paramDialogInterface = new HashMap();
    if (this.b.isChecked()) {
      paramInt = 1;
    } else {
      paramInt = 2;
    }
    paramDialogInterface.put("sgrp_member_delete_result", Integer.valueOf(paramInt));
    VideoReport.reportEvent("clck", QQGuildMemberFragment.g(this.c).getBtnight(), paramDialogInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.setting.QQGuildMemberFragment.14
 * JD-Core Version:    0.7.0.1
 */