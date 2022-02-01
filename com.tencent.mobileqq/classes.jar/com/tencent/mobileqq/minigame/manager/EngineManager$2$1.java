package com.tencent.mobileqq.minigame.manager;

import android.os.Bundle;
import android.util.SparseArray;
import com.tencent.mobileqq.mini.sdk.BaseLibInfo;

class EngineManager$2$1
  implements EngineInstaller.Callback
{
  EngineManager$2$1(EngineManager.2 param2) {}
  
  public void onEngineWorkAbort()
  {
    this.this$1.val$remote.send(54, null);
    EngineInstaller localEngineInstaller = (EngineInstaller)EngineManager.access$500(this.this$1.this$0).get(this.this$1.val$engineLibInfo.baseLibType);
    if (localEngineInstaller != null) {
      localEngineInstaller.removeCallback(this);
    }
  }
  
  public void onEngineWorkBegin()
  {
    this.this$1.val$remote.send(52, null);
  }
  
  public void onEngineWorkFinish()
  {
    this.this$1.val$remote.send(54, null);
    EngineInstaller localEngineInstaller = (EngineInstaller)EngineManager.access$500(this.this$1.this$0).get(this.this$1.val$engineLibInfo.baseLibType);
    if (localEngineInstaller != null) {
      localEngineInstaller.removeCallback(this);
    }
  }
  
  public void onMessageUpdate(float paramFloat, String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putFloat("engineInstallerProgress", paramFloat);
    localBundle.putString("engineInstallerMessage", paramString);
    this.this$1.val$remote.send(53, localBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.manager.EngineManager.2.1
 * JD-Core Version:    0.7.0.1
 */