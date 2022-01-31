package com.tencent.mobileqq.minigame.jsapi;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.minigame.ui.GameActivity;

class GameBrandRuntime$1
  implements Runnable
{
  GameBrandRuntime$1(GameBrandRuntime paramGameBrandRuntime, Activity paramActivity) {}
  
  public void run()
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("param_proc_name", BaseApplicationImpl.getApplication().getQQProcessName());
    localBundle.putString("param_proc_modulename", "mini_app_client_module");
    localBundle.putBoolean("param_proc_first_start", true);
    if ((this.val$gameActivity != null) && ((this.val$gameActivity instanceof GameActivity))) {
      ((GameActivity)this.val$gameActivity).onProcessForeGround(localBundle);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.jsapi.GameBrandRuntime.1
 * JD-Core Version:    0.7.0.1
 */