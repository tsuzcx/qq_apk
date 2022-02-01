package com.tencent.qqmini.minigame;

import android.app.ActivityManager;
import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Debug.MemoryInfo;
import android.os.Process;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import org.json.JSONObject;

class GameRuntime$2
  implements ComponentCallbacks2
{
  GameRuntime$2(GameRuntime paramGameRuntime) {}
  
  public void onConfigurationChanged(Configuration paramConfiguration) {}
  
  public void onLowMemory()
  {
    Debug.MemoryInfo[] arrayOfMemoryInfo = ((ActivityManager)this.this$0.getContext().getSystemService("activity")).getProcessMemoryInfo(new int[] { Process.myPid() });
    QMLog.e("GameRuntime", "onLowMemory!!!!!! Meminfo:dalvikPss[" + arrayOfMemoryInfo[0].dalvikPss + "],nativePss[" + arrayOfMemoryInfo[0].nativePss + "],otherPss[" + arrayOfMemoryInfo[0].otherPss + "],total[" + arrayOfMemoryInfo[0].getTotalPss() + "]");
  }
  
  public void onTrimMemory(int paramInt)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("level", paramInt);
      if (this.this$0.getGameJsService(1) != null) {
        this.this$0.getGameJsService(1).evaluateSubscribeJS("onMemoryWarning", localJSONObject.toString(), -1);
      }
      return;
    }
    catch (Exception localException)
    {
      QMLog.e("GameRuntime", "Failed to registerComponentCallback", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.minigame.GameRuntime.2
 * JD-Core Version:    0.7.0.1
 */