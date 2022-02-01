package com.tencent.mobileqq.extendfriend.ipc;

import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

class ExpandFlutterIPCClient$3
  implements Runnable
{
  ExpandFlutterIPCClient$3(ExpandFlutterIPCClient paramExpandFlutterIPCClient, Bundle paramBundle) {}
  
  public void run()
  {
    String str = this.a.getString("data");
    int i = this.a.getInt("seqNum");
    QLog.d("expand.ExpandFlutterIPCClient", 4, "handleUpdateExtendFriendInfo " + str);
    Iterator localIterator = ExpandFlutterIPCClient.a(this.this$0).iterator();
    while (localIterator.hasNext()) {
      ((IExpandIpcFlutterNotifyListener.ExpandIpcFlutterNotifyListener)localIterator.next()).a(str, i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.ipc.ExpandFlutterIPCClient.3
 * JD-Core Version:    0.7.0.1
 */