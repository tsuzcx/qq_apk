package com.tencent.mobileqq.weiyun;

import android.os.Bundle;
import com.tencent.mobileqq.pluginsdk.ipc.RemoteCommand;
import com.tencent.mobileqq.pluginsdk.ipc.RemoteCommand.OnInvokeFinishLinstener;
import java.util.concurrent.atomic.AtomicInteger;

public class WeiyunRemoteCommand
  extends RemoteCommand
{
  private static final AtomicInteger a = new AtomicInteger();
  private static WeiyunRemoteCommand.OnStateChangeListener b;
  
  public WeiyunRemoteCommand()
  {
    super("weiyun.notify_state");
  }
  
  public void a(WeiyunRemoteCommand.OnStateChangeListener paramOnStateChangeListener)
  {
    b = paramOnStateChangeListener;
  }
  
  public Bundle invoke(Bundle paramBundle, RemoteCommand.OnInvokeFinishLinstener paramOnInvokeFinishLinstener)
  {
    paramOnInvokeFinishLinstener = new Bundle();
    int i = paramBundle.getInt("param_state", a.get());
    if (i != a.get())
    {
      a.set(i);
      paramBundle = b;
      if (paramBundle != null) {
        paramBundle.a(a.get());
      }
    }
    return paramOnInvokeFinishLinstener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.weiyun.WeiyunRemoteCommand
 * JD-Core Version:    0.7.0.1
 */