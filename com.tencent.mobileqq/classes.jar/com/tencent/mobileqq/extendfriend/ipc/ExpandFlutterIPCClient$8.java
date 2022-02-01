package com.tencent.mobileqq.extendfriend.ipc;

import java.util.ArrayList;
import java.util.Iterator;

class ExpandFlutterIPCClient$8
  implements Runnable
{
  ExpandFlutterIPCClient$8(ExpandFlutterIPCClient paramExpandFlutterIPCClient) {}
  
  public void run()
  {
    Iterator localIterator = ExpandFlutterIPCClient.a(this.this$0).iterator();
    while (localIterator.hasNext()) {
      ((IExpandIpcFlutterNotifyListener.ExpandIpcFlutterNotifyListener)localIterator.next()).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.ipc.ExpandFlutterIPCClient.8
 * JD-Core Version:    0.7.0.1
 */