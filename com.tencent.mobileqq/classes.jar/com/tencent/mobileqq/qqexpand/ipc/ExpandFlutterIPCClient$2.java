package com.tencent.mobileqq.qqexpand.ipc;

import android.os.Bundle;

class ExpandFlutterIPCClient$2
  implements Runnable
{
  ExpandFlutterIPCClient$2(ExpandFlutterIPCClient paramExpandFlutterIPCClient, Bundle paramBundle) {}
  
  public void run()
  {
    int i = this.a.getInt("redPointNum");
    ExpandFlutterIPCClient.a(this.this$0, i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.ipc.ExpandFlutterIPCClient.2
 * JD-Core Version:    0.7.0.1
 */