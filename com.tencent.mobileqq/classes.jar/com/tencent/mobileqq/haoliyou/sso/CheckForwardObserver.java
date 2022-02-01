package com.tencent.mobileqq.haoliyou.sso;

import android.os.Bundle;
import android.util.SparseArray;
import java.lang.ref.WeakReference;
import mqq.observer.BusinessObserver;

public class CheckForwardObserver
  implements BusinessObserver
{
  private int jdField_a_of_type_Int;
  private final SparseArray<WeakReference<OnCheckShareListener>> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  
  private void a(boolean paramBoolean, Bundle paramBundle)
  {
    Object localObject1 = null;
    if (paramBundle != null)
    {
      i = paramBundle.getInt("req_id");
      synchronized (this.jdField_a_of_type_AndroidUtilSparseArray)
      {
        localObject2 = (WeakReference)this.jdField_a_of_type_AndroidUtilSparseArray.get(i);
        if (localObject2 != null)
        {
          localObject2 = (OnCheckShareListener)((WeakReference)localObject2).get();
          localObject1 = localObject2;
          if (localObject2 == null)
          {
            this.jdField_a_of_type_AndroidUtilSparseArray.delete(i);
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
    synchronized (this.jdField_a_of_type_AndroidUtilSparseArray)
    {
      SparseArray localSparseArray2 = this.jdField_a_of_type_AndroidUtilSparseArray;
      int i = this.jdField_a_of_type_Int + 1;
      this.jdField_a_of_type_Int = i;
      localSparseArray2.append(i, new WeakReference(paramOnCheckShareListener));
      i = this.jdField_a_of_type_Int;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.haoliyou.sso.CheckForwardObserver
 * JD-Core Version:    0.7.0.1
 */