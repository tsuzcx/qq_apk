package com.tencent.mobileqq.teamwork;

import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;

class TeamWorkFileExportHandler$1
  implements Runnable
{
  TeamWorkFileExportHandler$1(TeamWorkFileExportHandler paramTeamWorkFileExportHandler, String paramString1, String paramString2, String paramString3, String paramString4) {}
  
  public void run()
  {
    if ((TeamWorkFileExportHandler.a(this.this$0) == null) || (TextUtils.isEmpty(this.a))) {
      return;
    }
    TeamWorkHttpUtils.a(TeamWorkFileExportHandler.a(this.this$0), this.a, this.b, this.c, this.d, TeamWorkFileExportHandler.a(this.this$0).getCurrentAccountUin());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.TeamWorkFileExportHandler.1
 * JD-Core Version:    0.7.0.1
 */