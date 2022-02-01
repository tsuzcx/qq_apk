package com.tencent.qqmini.sdk.manager;

import android.os.Bundle;
import android.util.SparseArray;
import com.tencent.qqmini.sdk.launcher.action.EngineChannel;
import com.tencent.qqmini.sdk.launcher.model.BaseLibInfo;

class EngineManager$3
  implements EngineInstaller.Callback
{
  EngineManager$3(EngineManager paramEngineManager, EngineChannel paramEngineChannel, BaseLibInfo paramBaseLibInfo) {}
  
  public void onEngineWorkAbort()
  {
    this.val$channel.send(54, null);
  }
  
  public void onEngineWorkBegin()
  {
    this.val$channel.send(52, null);
  }
  
  public void onEngineWorkFinish()
  {
    this.val$channel.send(54, null);
    EngineInstaller localEngineInstaller = (EngineInstaller)EngineManager.access$100(this.this$0).get(this.val$info.baseLibType);
    if (localEngineInstaller != null) {
      localEngineInstaller.removeCallback(this);
    }
  }
  
  public void onMessageUpdate(float paramFloat, String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putFloat("engineInstallerProgress", paramFloat);
    localBundle.putString("engineInstallerMessage", paramString);
    this.val$channel.send(53, localBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqmini.sdk.manager.EngineManager.3
 * JD-Core Version:    0.7.0.1
 */