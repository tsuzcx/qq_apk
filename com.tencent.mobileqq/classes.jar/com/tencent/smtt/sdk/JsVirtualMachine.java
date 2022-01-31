package com.tencent.smtt.sdk;

import android.content.Context;
import android.os.Looper;
import com.tencent.smtt.export.external.jscore.interfaces.IX5JsContext;
import com.tencent.smtt.export.external.jscore.interfaces.IX5JsVirtualMachine;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Iterator;

public final class JsVirtualMachine
{
  private final Context mContext;
  private final HashSet<WeakReference<JsVirtualMachine.X5JsContextFallback>> mJsContexts = new HashSet();
  private final IX5JsVirtualMachine mVirtualMachine;
  
  public JsVirtualMachine(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public JsVirtualMachine(Context paramContext, Looper paramLooper)
  {
    this.mContext = paramContext;
    this.mVirtualMachine = X5JsCore.createVirtualMachine(paramContext, paramLooper);
  }
  
  protected IX5JsContext createJsContext()
  {
    if (this.mVirtualMachine == null)
    {
      JsVirtualMachine.X5JsContextFallback localX5JsContextFallback = new JsVirtualMachine.X5JsContextFallback(this.mContext);
      this.mJsContexts.add(new WeakReference(localX5JsContextFallback));
      return localX5JsContextFallback;
    }
    return this.mVirtualMachine.createJsContext();
  }
  
  public void destroy()
  {
    if (this.mVirtualMachine != null) {
      this.mVirtualMachine.destroy();
    }
    for (;;)
    {
      return;
      Iterator localIterator = this.mJsContexts.iterator();
      while (localIterator.hasNext())
      {
        WeakReference localWeakReference = (WeakReference)localIterator.next();
        if (localWeakReference.get() != null) {
          ((JsVirtualMachine.X5JsContextFallback)localWeakReference.get()).destroy();
        }
      }
    }
  }
  
  public Looper getLooper()
  {
    if (this.mVirtualMachine != null) {
      return this.mVirtualMachine.getLooper();
    }
    return Looper.myLooper();
  }
  
  public boolean isFallback()
  {
    return this.mVirtualMachine == null;
  }
  
  public void onPause()
  {
    if (this.mVirtualMachine != null) {
      this.mVirtualMachine.onPause();
    }
    for (;;)
    {
      return;
      Iterator localIterator = this.mJsContexts.iterator();
      while (localIterator.hasNext())
      {
        WeakReference localWeakReference = (WeakReference)localIterator.next();
        if (localWeakReference.get() != null) {
          ((JsVirtualMachine.X5JsContextFallback)localWeakReference.get()).onPause();
        }
      }
    }
  }
  
  public void onResume()
  {
    if (this.mVirtualMachine != null) {
      this.mVirtualMachine.onResume();
    }
    for (;;)
    {
      return;
      Iterator localIterator = this.mJsContexts.iterator();
      while (localIterator.hasNext())
      {
        WeakReference localWeakReference = (WeakReference)localIterator.next();
        if (localWeakReference.get() != null) {
          ((JsVirtualMachine.X5JsContextFallback)localWeakReference.get()).onResume();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.smtt.sdk.JsVirtualMachine
 * JD-Core Version:    0.7.0.1
 */