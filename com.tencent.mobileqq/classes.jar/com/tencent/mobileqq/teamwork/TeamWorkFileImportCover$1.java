package com.tencent.mobileqq.teamwork;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.utils.SharedPreUtils;

class TeamWorkFileImportCover$1
  implements DialogInterface.OnClickListener
{
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    SharedPreUtils.e(TeamWorkFileImportCover.a(this.a), this.a.c.getCurrentAccountUin(), "team_work_file_importing_tips_show", false);
    TeamWorkFileImportCover.b(this.a);
    TeamWorkFileImportCover.a(this.a).finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.TeamWorkFileImportCover.1
 * JD-Core Version:    0.7.0.1
 */