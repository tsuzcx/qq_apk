package com.tencent.mobileqq.profile.like;

import com.tencent.commonsdk.cache.QQLruCache;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.lang.reflect.Array;
import java.util.List;

public class PraiseManager$LoadCallback
  implements Runnable
{
  public int a;
  public int b;
  public String c;
  
  public PraiseManager$LoadCallback(PraiseManager paramPraiseManager, int paramInt1, int paramInt2, String paramString)
  {
    this.a = paramInt1;
    this.b = paramInt2;
    this.c = paramString;
  }
  
  public void run()
  {
    Object localObject2;
    synchronized (this.this$0.d)
    {
      boolean bool = this.this$0.d.isEmpty();
      int i = 0;
      if (!bool)
      {
        WeakReference[] arrayOfWeakReference = (WeakReference[])Array.newInstance(((WeakReference)this.this$0.d.get(0)).getClass(), this.this$0.d.size());
        this.this$0.d.toArray(arrayOfWeakReference);
        if (arrayOfWeakReference != null) {
          try
          {
            int j = arrayOfWeakReference.length;
            while (i < j)
            {
              ??? = arrayOfWeakReference[i];
              if ((??? != null) && (???.get() != null)) {
                ((PraiseManager.OnPraiseLoadListener)???.get()).a(this.a, (PraiseInfo)this.this$0.c.get(Integer.valueOf(this.a)), this.b, this.c);
              }
              i += 1;
            }
            return;
          }
          catch (Exception localException)
          {
            QLog.e("PraiseManager", 1, "LoadCallback failed", localException);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.profile.like.PraiseManager.LoadCallback
 * JD-Core Version:    0.7.0.1
 */