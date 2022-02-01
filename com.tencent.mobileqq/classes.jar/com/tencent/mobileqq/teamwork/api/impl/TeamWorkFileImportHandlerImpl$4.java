package com.tencent.mobileqq.teamwork.api.impl;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.teamwork.api.IGetExternalInterface;
import com.tencent.mobileqq.teamwork.bean.ImportFormData;
import com.tencent.mobileqq.teamwork.bean.TeamWorkFileImportInfo;
import org.json.JSONObject;

class TeamWorkFileImportHandlerImpl$4
  implements Runnable
{
  TeamWorkFileImportHandlerImpl$4(TeamWorkFileImportHandlerImpl paramTeamWorkFileImportHandlerImpl, JSONObject paramJSONObject, TeamWorkFileImportInfo paramTeamWorkFileImportInfo) {}
  
  public void run()
  {
    if (TeamWorkFileImportHandlerImpl.access$000(this.this$0) == null) {
      return;
    }
    Object localObject = ((IGetExternalInterface)QRoute.api(IGetExternalInterface.class)).checkFormCache(this.a, TeamWorkFileImportHandlerImpl.access$000(this.this$0).getCurrentAccountUin());
    if (localObject != null)
    {
      localObject = ImportFormData.a((JSONObject)localObject);
      if ((localObject != null) && (((ImportFormData)localObject).a != null) && (((ImportFormData)localObject).g))
      {
        this.b.O = ((ImportFormData)localObject).f;
        this.this$0.notifyUI(6, true, new Object[] { ((ImportFormData)localObject).a, ((ImportFormData)localObject).e, this.b });
        return;
      }
      this.this$0.notifyUI(7, false, new Object[] { this.b });
      return;
    }
    this.this$0.notifyUIError(this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.api.impl.TeamWorkFileImportHandlerImpl.4
 * JD-Core Version:    0.7.0.1
 */