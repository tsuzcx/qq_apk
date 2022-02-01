package com.tencent.mobileqq.teamwork.api.impl;

import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.teamwork.api.ITeamWorkHttpUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

class TeamWorkFileImportHandlerImpl$8
  implements Runnable
{
  TeamWorkFileImportHandlerImpl$8(TeamWorkFileImportHandlerImpl paramTeamWorkFileImportHandlerImpl, String paramString) {}
  
  public void run()
  {
    if (TeamWorkFileImportHandlerImpl.access$000(this.this$0) == null) {
      return;
    }
    Object localObject = ((ITeamWorkHttpUtils)QRoute.api(ITeamWorkHttpUtils.class)).getTencentDocReddot(this.a, TeamWorkFileImportHandlerImpl.access$000(this.this$0).getCurrentAccountUin());
    if (!TextUtils.isEmpty((CharSequence)localObject)) {}
    for (;;)
    {
      try
      {
        localObject = new JSONObject((String)localObject);
        if (!((JSONObject)localObject).has("TotalUnreadNum")) {
          break label107;
        }
        i = ((JSONObject)localObject).getInt("TotalUnreadNum");
        this.this$0.notifyUI(3, true, new Object[] { Integer.valueOf(i) });
        return;
      }
      catch (JSONException localJSONException)
      {
        QLog.e("TeamWorkFileImportHandlerImpl", 1, localJSONException.toString());
      }
      return;
      label107:
      int i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.api.impl.TeamWorkFileImportHandlerImpl.8
 * JD-Core Version:    0.7.0.1
 */