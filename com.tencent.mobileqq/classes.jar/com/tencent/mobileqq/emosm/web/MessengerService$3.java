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
    if (this.a.a != null)
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("url", null);
      int i;
      if (paramTeamWorkFileImportInfo != null) {
        i = paramTeamWorkFileImportInfo.f;
      } else {
        i = 0;
      }
      localBundle.putInt("retCode", i);
      String str2 = "";
      if (paramTeamWorkFileImportInfo != null) {
        str1 = paramTeamWorkFileImportInfo.h;
      } else {
        str1 = "";
      }
      localBundle.putString("errorStr", str1);
      String str1 = str2;
      if (paramTeamWorkFileImportInfo != null) {
        str1 = paramTeamWorkFileImportInfo.i;
      }
      localBundle.putString("redirectUrl", str1);
      this.a.a.putBundle("response", localBundle);
      paramTeamWorkFileImportInfo = this.a;
      paramTeamWorkFileImportInfo.a(paramTeamWorkFileImportInfo.a);
      this.a.a = null;
    }
  }
  
  public void a(String paramString, TeamWorkFileImportInfo paramTeamWorkFileImportInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.emoji.web.MessengerService", 2, "MessengerService onFileImportSuccess");
    }
    if (this.a.a != null)
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("url", paramString);
      if ((paramTeamWorkFileImportInfo != null) && (paramTeamWorkFileImportInfo.d == 10)) {
        localBundle.putBoolean("needRefresh", true);
      }
      this.a.a.putBundle("response", localBundle);
      paramString = this.a;
      paramString.a(paramString.a);
      this.a.a = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.web.MessengerService.3
 * JD-Core Version:    0.7.0.1
 */