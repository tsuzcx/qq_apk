package com.tencent.qqmini.sdk.core.plugins;

import bdcy;
import bdfx;
import bdfz;
import bdnz;
import org.json.JSONObject;

class FileJsPlugin$4
  implements bdnz
{
  FileJsPlugin$4(FileJsPlugin paramFileJsPlugin, int paramInt, String paramString, bdfz parambdfz) {}
  
  public void onInitApkgInfo(int paramInt, bdfx parambdfx, String paramString)
  {
    parambdfx = new JSONObject();
    try
    {
      parambdfx.put("taskId", this.val$loadTaskId);
      parambdfx.put("moduleName", this.val$moduleName);
      if (paramInt == 0) {
        parambdfx.put("state", "success");
      }
      for (;;)
      {
        this.val$req.a.a("onLoadSubPackageTaskStateChange", parambdfx.toString(), 0);
        return;
        parambdfx.put("state", "fail");
      }
      try
      {
        parambdfx.put("taskId", this.val$loadTaskId);
        parambdfx.put("moduleName", this.val$moduleName);
        parambdfx.put("state", "fail");
        this.val$req.a.a("onLoadSubPackageTaskStateChange", parambdfx.toString(), 0);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.FileJsPlugin.4
 * JD-Core Version:    0.7.0.1
 */