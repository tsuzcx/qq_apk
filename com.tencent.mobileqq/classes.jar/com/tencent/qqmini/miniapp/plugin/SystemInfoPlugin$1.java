package com.tencent.qqmini.miniapp.plugin;

import com.tencent.qqmini.miniapp.util.logmonitor.ILoadLogListener;
import com.tencent.qqmini.miniapp.util.logmonitor.LogBean;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import java.util.ArrayList;
import org.json.JSONObject;

class SystemInfoPlugin$1
  implements ILoadLogListener
{
  SystemInfoPlugin$1(SystemInfoPlugin paramSystemInfoPlugin, RequestEvent paramRequestEvent) {}
  
  public void onLoaded(ArrayList<LogBean> paramArrayList)
  {
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      JSONObject localJSONObject = new JSONObject();
      try
      {
        localJSONObject.put("detectedMsg", ((LogBean)paramArrayList.get(0)).msg);
      }
      catch (Exception paramArrayList)
      {
        QMLog.e("SystemInfoPlugin", "loadLogBeanList - onLoaded get a Exception:", paramArrayList);
      }
      this.val$req.ok(localJSONObject);
      return;
    }
    this.val$req.fail("no errMsg detected");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.plugin.SystemInfoPlugin.1
 * JD-Core Version:    0.7.0.1
 */