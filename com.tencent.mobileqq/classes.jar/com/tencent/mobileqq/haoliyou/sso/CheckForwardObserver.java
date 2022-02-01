package com.tencent.mobileqq.haoliyou.sso;

import android.os.Bundle;
import android.util.SparseArray;
import java.lang.ref.WeakReference;
import mqq.observer.BusinessObserver;

public class CheckForwardObserver
  implements BusinessObserver
{
  private int a;
  private final SparseArray<WeakReference<OnCheckShareListener>> b = new SparseArray();
  
  private void a(boolean paramBoolean, Bundle paramBundle)
  {
    Object localObject1 = null;
    if (paramBundle != null)
    {
      i = paramBundle.getInt("req_id");
      synchronized (this.b)
      {
        localObject2 = (WeakReference)this.b.get(i);
        if (localObject2 != null)
        {
          localObject2 = (OnCheckShareListener)((WeakReference)localObject2).get();
          localObject1 = localObject2;
          if (localObject2 == null)
          {
            this.b.delete(i);
            return;
          }
        }
        i = paramBundle.getInt("result");
        j = paramBundle.getInt("jump_result");
        ??? = paramBundle.getString("jump_url");
        localObject2 = paramBundle.getString("ext_info");
        paramBundle = (Bundle)???;
      }
    }
    localObject1 = null;
    paramBundle = localObject1;
    Object localObject2 = paramBundle;
    int i = 0;
    int j = 0;
    if (localObject1 != null) {
      localObject1.onResponse(paramBoolean, i, j, paramBundle, (String)localObject2);
    }
  }
  
  int a(OnCheckShareListener paramOnCheckShareListener)
  {
    synchronized (this.b)
    {
      SparseArray localSparseArray2 = this.b;
      int i = this.a + 1;
      this.a = i;
      localSparseArray2.append(i, new WeakReference(paramOnCheckShareListener));
      i = this.a;
      return i;
    }
  }
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (paramInt != 1) {
      return;
    }
    a(paramBoolean, paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.haoliyou.sso.CheckForwardObserver
 * JD-Core Version:    0.7.0.1
 */