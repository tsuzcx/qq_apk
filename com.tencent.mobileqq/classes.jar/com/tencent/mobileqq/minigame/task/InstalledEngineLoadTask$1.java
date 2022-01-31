package com.tencent.mobileqq.minigame.task;

import com.tencent.mobileqq.minigame.manager.EngineInstanceManager.IListener;
import com.tencent.mobileqq.minigame.manager.GameRuntimeLoader.GameRuntimeProgressListener;
import com.tencent.mobileqq.minigame.utils.GameLog;

class InstalledEngineLoadTask$1
  implements EngineInstanceManager.IListener
{
  InstalledEngineLoadTask$1(InstalledEngineLoadTask paramInstalledEngineLoadTask) {}
  
  public void onFinish(int paramInt, String paramString)
  {
    GameLog.getInstance().i(InstalledEngineLoadTask.access$100(this.this$0), "tryGetEngineFromMainProcess onFinish, retCode:" + paramInt + ", retMsg:" + paramString + ", engine:" + this.this$0.getInstalledEngine());
    if (paramInt == 0)
    {
      this.this$0.onTaskSucceed();
      return;
    }
    this.this$0.onTaskFailed(paramInt, paramString);
  }
  
  public void onProgress(float paramFloat, String paramString)
  {
    if (InstalledEngineLoadTask.access$000(this.this$0) != null) {
      InstalledEngineLoadTask.access$000(this.this$0).onTaskProgress(this.this$0, paramFloat, paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.task.InstalledEngineLoadTask.1
 * JD-Core Version:    0.7.0.1
 */