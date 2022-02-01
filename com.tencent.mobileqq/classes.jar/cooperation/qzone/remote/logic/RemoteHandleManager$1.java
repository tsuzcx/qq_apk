package cooperation.qzone.remote.logic;

import android.text.TextUtils;
import cooperation.qzone.remote.IActionListener.Stub;
import cooperation.qzone.remote.RecvMsg;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

class RemoteHandleManager$1
  extends IActionListener.Stub
{
  RemoteHandleManager$1(RemoteHandleManager paramRemoteHandleManager) {}
  
  public void onRecvFromMsg(RecvMsg paramRecvMsg)
  {
    if (paramRecvMsg == null) {}
    for (;;)
    {
      return;
      if ((!TextUtils.isEmpty(paramRecvMsg.getServiceCmd())) && (RemoteHandleManager.access$000(this.this$0) != null))
      {
        Iterator localIterator = RemoteHandleManager.access$000(this.this$0).iterator();
        while (localIterator.hasNext())
        {
          Object localObject = (WeakReference)localIterator.next();
          if (localObject != null)
          {
            localObject = (WebEventListener)((WeakReference)localObject).get();
            if (localObject != null) {
              ((WebEventListener)localObject).onWebEvent(paramRecvMsg.getServiceCmd(), paramRecvMsg.extraData);
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qzone.remote.logic.RemoteHandleManager.1
 * JD-Core Version:    0.7.0.1
 */