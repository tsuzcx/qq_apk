package com.tencent.mobileqq.qqexpand.ipc;

import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

class ExpandFlutterIPCClient$4
  implements Runnable
{
  ExpandFlutterIPCClient$4(ExpandFlutterIPCClient paramExpandFlutterIPCClient, Bundle paramBundle) {}
  
  public void run()
  {
    String str = this.a.getString("data");
    int i = this.a.getInt("seqNum");
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onGetOnLineStateResponse ");
    ((StringBuilder)localObject).append(str);
    QLog.d("expand.ExpandFlutterIPCClient", 4, ((StringBuilder)localObject).toString());
    localObject = ExpandFlutterIPCClient.a(this.this$0).iterator();
    while (((Iterator)localObject).hasNext()) {
      ((IExpandIpcFlutterNotifyListener.ExpandIpcFlutterNotifyListener)((Iterator)localObject).next()).b(str, i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.ipc.ExpandFlutterIPCClient.4
 * JD-Core Version:    0.7.0.1
 */