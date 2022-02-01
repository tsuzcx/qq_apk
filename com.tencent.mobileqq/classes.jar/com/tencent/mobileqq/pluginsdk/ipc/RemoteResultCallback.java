package com.tencent.mobileqq.pluginsdk.ipc;

import android.os.Bundle;
import mqq.app.MobileQQ;

public abstract class RemoteResultCallback
  extends RemoteCallback.Stub
{
  public abstract void onCallback(Bundle paramBundle);
  
  public final void onRemoteCallback(Bundle paramBundle)
  {
    if (paramBundle != null) {
      paramBundle.setClassLoader(MobileQQ.sMobileQQ.getClassLoader());
    }
    onCallback(paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.pluginsdk.ipc.RemoteResultCallback
 * JD-Core Version:    0.7.0.1
 */