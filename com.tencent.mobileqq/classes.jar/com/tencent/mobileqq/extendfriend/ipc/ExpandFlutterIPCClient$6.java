package com.tencent.mobileqq.extendfriend.ipc;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.Iterator;

class ExpandFlutterIPCClient$6
  implements Runnable
{
  ExpandFlutterIPCClient$6(ExpandFlutterIPCClient paramExpandFlutterIPCClient, Bundle paramBundle) {}
  
  public void run()
  {
    String str = this.a.getString("response");
    Iterator localIterator = ExpandFlutterIPCClient.a(this.this$0).iterator();
    while (localIterator.hasNext()) {
      ((IExpandIpcFlutterNotifyListener.ExpandIpcFlutterNotifyListener)localIterator.next()).b(str);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.ipc.ExpandFlutterIPCClient.6
 * JD-Core Version:    0.7.0.1
 */