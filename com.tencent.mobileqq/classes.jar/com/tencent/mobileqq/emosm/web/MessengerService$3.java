package com.tencent.mobileqq.emosm.web;

import android.os.Bundle;
import com.tencent.mobileqq.teamwork.TeamWorkFileImportObserver;
import com.tencent.mobileqq.teamwork.bean.TeamWorkFileImportInfo;
import com.tencent.qphone.base.util.QLog;

class MessengerService$3
  extends TeamWorkFileImportObserver
{
  MessengerService$3(MessengerService paramMessengerService) {}
  
  public void a(TeamWorkFileImportInfo paramTeamWorkFileImportInfo)
  {
    if (this.a.l != null)
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("url", null);
      int i;
      if (paramTeamWorkFileImportInfo != null) {
        i = paramTeamWorkFileImportInfo.w;
      } else {
        i = 0;
      }
      localBundle.putInt("retCode", i);
      String str2 = "";
      if (paramTeamWorkFileImportInfo != null) {
        str1 = paramTeamWorkFileImportInfo.x;
      } else {
        str1 = "";
      }
      localBundle.putString("errorStr", str1);
      String str1 = str2;
      if (paramTeamWorkFileImportInfo != null) {
        str1 = paramTeamWorkFileImportInfo.y;
      }
      localBundle.putString("redirectUrl", str1);
      this.a.l.putBundle("response", localBundle);
      paramTeamWorkFileImportInfo = this.a;
      paramTeamWorkFileImportInfo.a(paramTeamWorkFileImportInfo.l);
      this.a.l = null;
    }
  }
  
  public void a(String paramString, TeamWorkFileImportInfo paramTeamWorkFileImportInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.emoji.web.MessengerService", 2, "MessengerService onFileImportSuccess");
    }
    if (this.a.l != null)
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("url", paramString);
      if ((paramTeamWorkFileImportInfo != null) && (paramTeamWorkFileImportInfo.n == 10)) {
        localBundle.putBoolean("needRefresh", true);
      }
      this.a.l.putBundle("response", localBundle);
      paramString = this.a;
      paramString.a(paramString.l);
      this.a.l = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.web.MessengerService.3
 * JD-Core Version:    0.7.0.1
 */