package com.tencent.mobileqq.minigame.ui;

import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;

class GameActivity1$5
  implements Runnable
{
  GameActivity1$5(GameActivity1 paramGameActivity1) {}
  
  public void run()
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("param_proc_name", BaseApplicationImpl.getApplication().getQQProcessName());
    localBundle.putString("param_proc_modulename", "mini_sdk_client_module");
    localBundle.putBoolean("param_proc_first_start", true);
    GameActivity1.access$100(this.this$0, localBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.ui.GameActivity1.5
 * JD-Core Version:    0.7.0.1
 */