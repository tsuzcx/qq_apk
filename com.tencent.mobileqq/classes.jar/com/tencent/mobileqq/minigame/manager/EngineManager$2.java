package com.tencent.mobileqq.minigame.manager;

import com.tencent.mobileqq.mini.sdk.BaseLibInfo;
import com.tencent.qphone.base.util.QLog;

class EngineManager$2
  implements Runnable
{
  EngineManager$2(EngineManager paramEngineManager, BaseLibInfo paramBaseLibInfo, EngineChannel paramEngineChannel) {}
  
  public void run()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[MiniEng] installBaseLibForChannel ");
    localStringBuilder.append(this.val$engineLibInfo);
    localStringBuilder.append(",");
    localStringBuilder.append(this.val$remote);
    QLog.i("EngineManager", 1, localStringBuilder.toString());
    this.this$0.installBaseLib(this.val$engineLibInfo, new EngineManager.2.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.manager.EngineManager.2
 * JD-Core Version:    0.7.0.1
 */