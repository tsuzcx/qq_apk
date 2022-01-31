package com.tencent.qqmini.sdk.runtime.plugin;

import bglu;
import bgod;
import bgok;
import bgvo;
import org.json.JSONObject;

class SubpackageJsPlugin$1
  implements bgvo
{
  SubpackageJsPlugin$1(SubpackageJsPlugin paramSubpackageJsPlugin, int paramInt, String paramString, bgok parambgok) {}
  
  public void onInitApkgInfo(int paramInt, bgod parambgod, String paramString)
  {
    parambgod = new JSONObject();
    try
    {
      parambgod.put("taskId", this.val$loadTaskId);
      parambgod.put("moduleName", this.val$moduleName);
      if (paramInt == 0) {
        parambgod.put("state", "success");
      }
      for (;;)
      {
        this.val$req.a.a("onLoadSubPackageTaskStateChange", parambgod.toString(), 0);
        return;
        parambgod.put("state", "fail");
      }
      try
      {
        parambgod.put("taskId", this.val$loadTaskId);
        parambgod.put("moduleName", this.val$moduleName);
        parambgod.put("state", "fail");
        this.val$req.a.a("onLoadSubPackageTaskStateChange", parambgod.toString(), 0);
        paramString.printStackTrace();
        return;
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          localThrowable.printStackTrace();
        }
      }
    }
    catch (Throwable paramString) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.runtime.plugin.SubpackageJsPlugin.1
 * JD-Core Version:    0.7.0.1
 */