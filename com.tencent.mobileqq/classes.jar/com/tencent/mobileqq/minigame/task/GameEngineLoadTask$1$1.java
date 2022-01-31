package com.tencent.mobileqq.minigame.task;

import android.os.Bundle;
import com.tencent.mobileqq.mini.launch.CmdCallback.Stub;
import com.tencent.mobileqq.minigame.manager.EngineChannel;
import com.tencent.mobileqq.minigame.manager.GameLoadManager;
import com.tencent.mobileqq.minigame.utils.GameLog;

class GameEngineLoadTask$1$1
  extends CmdCallback.Stub
{
  GameEngineLoadTask$1$1(GameEngineLoadTask.1 param1) {}
  
  public void onCmdResult(boolean paramBoolean, Bundle paramBundle)
  {
    if ((paramBoolean) && (paramBundle != null))
    {
      paramBundle.setClassLoader(getClass().getClassLoader());
      paramBundle = (EngineChannel)paramBundle.getParcelable("engineChannel");
      GameLoadManager.g().setEngineChannel(paramBundle);
      GameLog.getInstance().e("EngineLoadTask", "[MiniEng]reInitOutChannel " + paramBundle);
      GameEngineLoadTask.access$100(this.this$1.this$0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.task.GameEngineLoadTask.1.1
 * JD-Core Version:    0.7.0.1
 */