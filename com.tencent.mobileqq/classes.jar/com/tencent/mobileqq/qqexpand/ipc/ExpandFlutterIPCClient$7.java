package com.tencent.mobileqq.qqexpand.ipc;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.Iterator;

class ExpandFlutterIPCClient$7
  implements Runnable
{
  ExpandFlutterIPCClient$7(ExpandFlutterIPCClient paramExpandFlutterIPCClient, Bundle paramBundle) {}
  
  public void run()
  {
    String str = this.a.getString("response");
    Iterator localIterator = ExpandFlutterIPCClient.a(this.this$0).iterator();
    while (localIterator.hasNext()) {
      ((IExpandIpcFlutterNotifyListener.ExpandIpcFlutterNotifyListener)localIterator.next()).c(str);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.ipc.ExpandFlutterIPCClient.7
 * JD-Core Version:    0.7.0.1
 */