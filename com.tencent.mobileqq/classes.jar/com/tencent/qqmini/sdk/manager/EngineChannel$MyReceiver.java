package com.tencent.qqmini.sdk.manager;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import betl;

public class EngineChannel$MyReceiver
  extends ResultReceiver
{
  public EngineChannel$MyReceiver(EngineChannel paramEngineChannel, Handler paramHandler)
  {
    super(paramHandler);
  }
  
  protected void onReceiveResult(int paramInt, Bundle paramBundle)
  {
    if (EngineChannel.a(this.a) != null) {
      EngineChannel.a(this.a).a(paramInt, paramBundle);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.manager.EngineChannel.MyReceiver
 * JD-Core Version:    0.7.0.1
 */