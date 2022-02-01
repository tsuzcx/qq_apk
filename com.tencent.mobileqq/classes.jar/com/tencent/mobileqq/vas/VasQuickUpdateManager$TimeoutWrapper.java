package com.tencent.mobileqq.vas;

import bhob;
import com.tencent.mobileqq.app.ThreadManager;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.os.MqqHandler;

class VasQuickUpdateManager$TimeoutWrapper
  implements VasQuickUpdateManager.QueryItemVersionCallback, Runnable
{
  private bhob callback;
  private AtomicBoolean isDone = new AtomicBoolean(false);
  private WeakReference<bhob> weakReference;
  
  private VasQuickUpdateManager$TimeoutWrapper(bhob parambhob, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.weakReference = new WeakReference(parambhob);
      return;
    }
    this.callback = parambhob;
  }
  
  private void onResult(int paramInt, String paramString1, String paramString2)
  {
    if (this.isDone.compareAndSet(false, true))
    {
      if (this.callback == null) {
        break label32;
      }
      this.callback.a(paramInt, paramString1, paramString2);
    }
    label32:
    bhob localbhob;
    do
    {
      return;
      localbhob = (bhob)this.weakReference.get();
    } while (localbhob == null);
    localbhob.a(paramInt, paramString1, paramString2);
  }
  
  public void onQueryItemVer(boolean paramBoolean, String paramString1, String paramString2)
  {
    ThreadManager.getSubThreadHandler().removeCallbacks(this);
    int i = 0;
    if (!paramBoolean) {
      i = 1;
    }
    onResult(i, paramString1, paramString2);
  }
  
  public void run()
  {
    VasQuickUpdateEngine.getInstance().cancelQuery(this);
    onResult(2, "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.vas.VasQuickUpdateManager.TimeoutWrapper
 * JD-Core Version:    0.7.0.1
 */