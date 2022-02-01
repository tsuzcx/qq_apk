package com.tencent.mobileqq.minigame.task;

import android.os.Process;
import com.tencent.mobileqq.minigame.manager.GameEnvManager.IDownloadListener;
import com.tencent.mobileqq.minigame.utils.GameLog;

class TritonEngineInitTask$1
  implements GameEnvManager.IDownloadListener
{
  TritonEngineInitTask$1(TritonEngineInitTask paramTritonEngineInitTask) {}
  
  public void onDownloadResult(int paramInt, String paramString)
  {
    GameLog.getInstance().e(this.this$0.LOG_TAG, "[MiniEng] download triton on Exception callback, retCode:" + paramInt + ", msg:" + paramString);
    if (paramInt == 0) {
      Process.killProcess(Process.myPid());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.task.TritonEngineInitTask.1
 * JD-Core Version:    0.7.0.1
 */