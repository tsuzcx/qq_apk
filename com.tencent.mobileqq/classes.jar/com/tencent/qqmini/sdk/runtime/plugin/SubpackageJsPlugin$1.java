package com.tencent.qqmini.sdk.runtime.plugin;

import bghn;
import bgjw;
import bgkd;
import bgrh;
import org.json.JSONObject;

class SubpackageJsPlugin$1
  implements bgrh
{
  SubpackageJsPlugin$1(SubpackageJsPlugin paramSubpackageJsPlugin, int paramInt, String paramString, bgkd parambgkd) {}
  
  public void onInitApkgInfo(int paramInt, bgjw parambgjw, String paramString)
  {
    parambgjw = new JSONObject();
    try
    {
      parambgjw.put("taskId", this.val$loadTaskId);
      parambgjw.put("moduleName", this.val$moduleName);
      if (paramInt == 0) {
        parambgjw.put("state", "success");
      }
      for (;;)
      {
        this.val$req.a.a("onLoadSubPackageTaskStateChange", parambgjw.toString(), 0);
        return;
        parambgjw.put("state", "fail");
      }
      try
      {
        parambgjw.put("taskId", this.val$loadTaskId);
        parambgjw.put("moduleName", this.val$moduleName);
        parambgjw.put("state", "fail");
        this.val$req.a.a("onLoadSubPackageTaskStateChange", parambgjw.toString(), 0);
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