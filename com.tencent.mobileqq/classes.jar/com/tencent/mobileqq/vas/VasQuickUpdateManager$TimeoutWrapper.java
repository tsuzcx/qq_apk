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
      if (this.callback == null) {
        break label32;
      }
      this.callback.a(paramInt, paramString1, paramString2);
    }
    label32:
    QueryItemCallback localQueryItemCallback;
    do
    {
      return;
      localQueryItemCallback = (QueryItemCallback)this.weakReference.get();
    } while (localQueryItemCallback == null);
    localQueryItemCallback.a(paramInt, paramString1, paramString2);
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
    onResult(2, "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.vas.VasQuickUpdateManager.TimeoutWrapper
 * JD-Core Version:    0.7.0.1
 */