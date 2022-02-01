package com.tencent.thumbplayer.core.downloadproxy.apiinner;

import android.os.Handler;
import com.tencent.thumbplayer.core.downloadproxy.utils.TPDLProxyLog;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class TPListenerManager$2
  implements Runnable
{
  TPListenerManager$2(TPListenerManager paramTPListenerManager) {}
  
  public void run()
  {
    Object localObject = TPListenerManager.access$500(this.this$0);
    try
    {
      localObject = ((Map)localObject).entrySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        int i = ((Integer)((Map.Entry)((Iterator)localObject).next()).getKey()).intValue();
        long l1 = TPProxyAdapterManager.getInstance().getCurrentOffset(i);
        long l2 = TPProxyAdapterManager.getInstance().getCurrentFilesize(i);
        this.this$0.handleCallbackMessage(2, i, Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(l1), Long.valueOf(l2), null);
      }
      TPListenerManager.access$400(this.this$0).postDelayed(TPListenerManager.access$600(this.this$0), 1000L);
    }
    catch (Throwable localThrowable)
    {
      TPDLProxyLog.e("TPListenerManager", 0, "tpdlnative", "updateProxyPlayerInfo failed, error:" + localThrowable.toString());
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.thumbplayer.core.downloadproxy.apiinner.TPListenerManager.2
 * JD-Core Version:    0.7.0.1
 */