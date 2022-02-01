package com.tencent.thumbplayer.core.downloadproxy.apiinner;

import android.os.Handler;
import com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener;
import com.tencent.thumbplayer.core.downloadproxy.jni.TPDownloadProxyNative;
import com.tencent.thumbplayer.core.downloadproxy.utils.TPDLProxyLog;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class TPListenerManager$1
  implements Runnable
{
  TPListenerManager$1(TPListenerManager paramTPListenerManager) {}
  
  public void run()
  {
    synchronized ()
    {
      Object localObject2 = TPListenerManager.access$300(this.this$0);
      try
      {
        ??? = ((Map)localObject2).entrySet().iterator();
        while (((Iterator)???).hasNext())
        {
          localObject2 = (Map.Entry)((Iterator)???).next();
          int i = ((Integer)((Map.Entry)localObject2).getKey()).intValue();
          localObject2 = (ITPPlayListener)((Map.Entry)localObject2).getValue();
          int j = (int)(((ITPPlayListener)localObject2).getCurrentPosition() / 1000L);
          int k = (int)(((ITPPlayListener)localObject2).getPlayerBufferLength() / 1000L);
          int m = (int)(((ITPPlayListener)localObject2).getAdvRemainTime() / 1000L);
          TPDownloadProxyNative.getInstance().updatePlayerPlayMsg(i, j, k, m);
        }
        localObject3 = finally;
      }
      catch (Throwable localThrowable)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("updatePlayerInfo failed, error:");
        ((StringBuilder)localObject2).append(localThrowable.toString());
        TPDLProxyLog.e("TPListenerManager", 0, "tpdlnative", ((StringBuilder)localObject2).toString());
        TPListenerManager.access$600(this.this$0).postDelayed(TPListenerManager.access$400(this.this$0), TPListenerManager.access$500(this.this$0));
        return;
      }
    }
    for (;;)
    {
      throw localObject3;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.thumbplayer.core.downloadproxy.apiinner.TPListenerManager.1
 * JD-Core Version:    0.7.0.1
 */