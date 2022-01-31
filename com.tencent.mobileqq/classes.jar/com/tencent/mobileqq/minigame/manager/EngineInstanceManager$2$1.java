package com.tencent.mobileqq.minigame.manager;

import android.os.Bundle;
import com.tencent.mobileqq.mini.launch.CmdCallback.Stub;
import com.tencent.qphone.base.util.QLog;

class EngineInstanceManager$2$1
  extends CmdCallback.Stub
{
  EngineInstanceManager$2$1(EngineInstanceManager.2 param2) {}
  
  public void onCmdResult(boolean paramBoolean, Bundle paramBundle)
  {
    if ((paramBoolean) && (paramBundle != null))
    {
      paramBundle.setClassLoader(getClass().getClassLoader());
      paramBundle = (EngineChannel)paramBundle.getParcelable("engineChannel");
      this.this$1.this$0.setEngineChannelIfNeed(paramBundle);
      QLog.e("EngineInstanceManager", 1, new Object[] { "reInitOutChannel:", paramBundle });
      EngineInstanceManager.access$200(this.this$1.this$0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.manager.EngineInstanceManager.2.1
 * JD-Core Version:    0.7.0.1
 */