package com.tencent.qqmini.sdk.manager;

import com.tencent.qqmini.sdk.launcher.action.EngineChannel;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.BaseLibInfo;

class EngineManager$2
  implements Runnable
{
  EngineManager$2(EngineManager paramEngineManager, BaseLibInfo paramBaseLibInfo, EngineChannel paramEngineChannel) {}
  
  public void run()
  {
    QMLog.i("EngineManager", "[MiniEng] installBaseLibForChannel " + this.val$engineLibInfo + "," + this.val$remote);
    this.this$0.installBaseLib(this.val$engineLibInfo, new EngineManager.2.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.manager.EngineManager.2
 * JD-Core Version:    0.7.0.1
 */