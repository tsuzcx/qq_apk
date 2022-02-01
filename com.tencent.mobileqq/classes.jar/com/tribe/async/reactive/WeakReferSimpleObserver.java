package com.tribe.async.reactive;

import android.support.annotation.NonNull;
import com.tribe.async.log.SLog;
import java.lang.ref.WeakReference;

public class WeakReferSimpleObserver<R, T>
  implements Observer<T>
{
  public static final String TAG = "async.WeakReferSimpleObserver";
  private WeakReference<R> mSimpleObserverWeakReference;
  
  public WeakReferSimpleObserver(R paramR)
  {
    this.mSimpleObserverWeakReference = new WeakReference(paramR);
  }
  
  public final void onCancel()
  {
    Object localObject = this.mSimpleObserverWeakReference.get();
    if (localObject != null)
    {
      onCancel(localObject);
      return;
    }
    SLog.v("async.WeakReferSimpleObserver", "UI is null");
  }
  
  public void onCancel(@NonNull R paramR) {}
  
  public final void onComplete()
  {
    Object localObject = this.mSimpleObserverWeakReference.get();
    if (localObject != null)
    {
      onComplete(localObject);
      return;
    }
    SLog.v("async.WeakReferSimpleObserver", "UI is null");
  }
  
  public void onComplete(@NonNull R paramR) {}
  
  public final void onError(@NonNull Error paramError)
  {
    Object localObject = this.mSimpleObserverWeakReference.get();
    if (localObject != null)
    {
      onError(localObject, paramError);
      return;
    }
    SLog.v("async.WeakReferSimpleObserver", "UI is null");
  }
  
  public void onError(@NonNull R paramR, @NonNull Error paramError) {}
  
  public final void onNext(T paramT)
  {
    Object localObject = this.mSimpleObserverWeakReference.get();
    if (localObject != null)
    {
      onNext(localObject, paramT);
      return;
    }
    SLog.v("async.WeakReferSimpleObserver", "UI is null");
  }
  
  public void onNext(@NonNull R paramR, T paramT) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tribe.async.reactive.WeakReferSimpleObserver
 * JD-Core Version:    0.7.0.1
 */