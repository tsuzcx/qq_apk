package com.tencent.mobileqq.teamwork.api.impl;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.teamwork.api.IGetExternalInterface;
import com.tencent.mobileqq.teamwork.bean.TeamWorkFileImportInfo;
import org.json.JSONObject;

class TeamWorkFileImportHandlerImpl$5
  implements Runnable
{
  TeamWorkFileImportHandlerImpl$5(TeamWorkFileImportHandlerImpl paramTeamWorkFileImportHandlerImpl, JSONObject paramJSONObject, TeamWorkFileImportInfo paramTeamWorkFileImportInfo) {}
  
  public void run()
  {
    if (TeamWorkFileImportHandlerImpl.access$000(this.this$0) == null) {
      return;
    }
    JSONObject localJSONObject = ((IGetExternalInterface)QRoute.api(IGetExternalInterface.class)).importFormWithUrl(this.a, TeamWorkFileImportHandlerImpl.access$000(this.this$0).getCurrentAccountUin());
    if (localJSONObject != null) {
      TeamWorkFileImportHandlerImpl.access$300(this.this$0, localJSONObject, this.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.api.impl.TeamWorkFileImportHandlerImpl.5
 * JD-Core Version:    0.7.0.1
 */