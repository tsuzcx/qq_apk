package com.tencent.mobileqq.teamwork.api.impl;

import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.teamwork.TeamWorkHttpUtils;

class TeamWorkFileExportHandlerImpl$1
  implements Runnable
{
  TeamWorkFileExportHandlerImpl$1(TeamWorkFileExportHandlerImpl paramTeamWorkFileExportHandlerImpl, String paramString1, String paramString2, String paramString3, String paramString4) {}
  
  public void run()
  {
    if (TeamWorkFileExportHandlerImpl.access$000(this.this$0) != null)
    {
      if (TextUtils.isEmpty(this.a)) {
        return;
      }
      TeamWorkHttpUtils.a(TeamWorkFileExportHandlerImpl.access$000(this.this$0), this.a, this.b, this.c, this.d, TeamWorkFileExportHandlerImpl.access$000(this.this$0).getCurrentAccountUin());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.api.impl.TeamWorkFileExportHandlerImpl.1
 * JD-Core Version:    0.7.0.1
 */