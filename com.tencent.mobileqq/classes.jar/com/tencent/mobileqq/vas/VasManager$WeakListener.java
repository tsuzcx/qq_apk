package com.tencent.mobileqq.vas;

import java.lang.ref.WeakReference;

class VasManager$WeakListener<E>
  extends WeakReference<VasManager.CompleteListener<E>>
  implements VasManager.CompleteListener<E>
{
  public VasManager$WeakListener(VasManager.CompleteListener<E> paramCompleteListener)
  {
    super(paramCompleteListener);
  }
  
  public void onComplete(E paramE, Object paramObject)
  {
    VasManager.CompleteListener localCompleteListener = (VasManager.CompleteListener)get();
    if (localCompleteListener != null) {
      localCompleteListener.onComplete(paramE, paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.VasManager.WeakListener
 * JD-Core Version:    0.7.0.1
 */