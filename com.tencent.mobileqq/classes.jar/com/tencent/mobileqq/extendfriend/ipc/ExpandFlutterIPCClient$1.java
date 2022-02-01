package com.tencent.mobileqq.extendfriend.ipc;

import android.os.Bundle;

class ExpandFlutterIPCClient$1
  implements Runnable
{
  ExpandFlutterIPCClient$1(ExpandFlutterIPCClient paramExpandFlutterIPCClient, Bundle paramBundle) {}
  
  public void run()
  {
    long l = this.a.getLong("pushType");
    byte[] arrayOfByte = this.a.getByteArray("data");
    ExpandFlutterIPCClient.a(this.this$0, l, arrayOfByte);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.ipc.ExpandFlutterIPCClient.1
 * JD-Core Version:    0.7.0.1
 */