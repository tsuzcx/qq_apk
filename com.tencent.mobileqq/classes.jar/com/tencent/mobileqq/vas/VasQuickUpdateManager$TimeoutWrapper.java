package com.tencent.mobileqq.vas;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.vas.updatesystem.callback.QueryItemCallback;
import com.tencent.mobileqq.vas.updatesystem.callback.QueryItemVersionCallback;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.os.MqqHandler;

class VasQuickUpdateManager$TimeoutWrapper
  implements QueryItemVersionCallback, Runnable
{
  private QueryItemCallback callback;
  private AtomicBoolean isDone = new AtomicBoolean(false);
  private WeakReference<QueryItemCallback> weakReference;
  
  private VasQuickUpdateManager$TimeoutWrapper(QueryItemCallback paramQueryItemCallback, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.weakReference = new WeakReference(paramQueryItemCallback);
      return;
    }
    this.callback = paramQueryItemCallback;
  }
  
  private void onResult(int paramInt, String paramString1, String paramString2)
  {
    if (this.isDone.compareAndSet(false, true))
    {
      QueryItemCallback localQueryItemCallback = this.callback;
      if (localQueryItemCallback != null)
      {
        localQueryItemCallback.onQueryItemVer(paramInt, paramString1, paramString2);
        return;
      }
      localQueryItemCallback = (QueryItemCallback)this.weakReference.get();
      if (localQueryItemCallback != null) {
        localQueryItemCallback.onQueryItemVer(paramInt, paramString1, paramString2);
      }
    }
  }
  
  public void onQueryItemVer(boolean paramBoolean, String paramString1, String paramString2)
  {
    ThreadManager.getSubThreadHandler().removeCallbacks(this);
    onResult(paramBoolean ^ true, paramString1, paramString2);
  }
  
  public void run()
  {
    onResult(2, "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.VasQuickUpdateManager.TimeoutWrapper
 * JD-Core Version:    0.7.0.1
 */