package com.tencent.mobileqq.minigame.manager;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;

public class EngineChannel$MyReceiver
  extends ResultReceiver
{
  public EngineChannel$MyReceiver(EngineChannel paramEngineChannel, Handler paramHandler)
  {
    super(paramHandler);
  }
  
  protected void onReceiveResult(int paramInt, Bundle paramBundle)
  {
    if (EngineChannel.access$100(this.this$0) != null) {
      EngineChannel.access$100(this.this$0).onReceiveData(paramInt, paramBundle);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.manager.EngineChannel.MyReceiver
 * JD-Core Version:    0.7.0.1
 */