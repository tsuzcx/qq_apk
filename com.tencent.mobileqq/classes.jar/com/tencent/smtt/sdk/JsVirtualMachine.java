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
  private final Context a;
  private final IX5JsVirtualMachine b;
  private final HashSet<WeakReference<JsVirtualMachine.a>> c = new HashSet();
  
  public JsVirtualMachine(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public JsVirtualMachine(Context paramContext, Looper paramLooper)
  {
    this.a = paramContext;
    this.b = X5JsCore.a(paramContext, paramLooper);
  }
  
  protected IX5JsContext a()
  {
    Object localObject = this.b;
    if (localObject == null)
    {
      localObject = new JsVirtualMachine.a(this.a);
      this.c.add(new WeakReference(localObject));
      return localObject;
    }
    return ((IX5JsVirtualMachine)localObject).createJsContext();
  }
  
  public void destroy()
  {
    Object localObject = this.b;
    if (localObject != null)
    {
      ((IX5JsVirtualMachine)localObject).destroy();
      return;
    }
    localObject = this.c.iterator();
    while (((Iterator)localObject).hasNext())
    {
      WeakReference localWeakReference = (WeakReference)((Iterator)localObject).next();
      if (localWeakReference.get() != null) {
        ((JsVirtualMachine.a)localWeakReference.get()).destroy();
      }
    }
  }
  
  public Looper getLooper()
  {
    IX5JsVirtualMachine localIX5JsVirtualMachine = this.b;
    if (localIX5JsVirtualMachine != null) {
      return localIX5JsVirtualMachine.getLooper();
    }
    return Looper.myLooper();
  }
  
  public boolean isFallback()
  {
    return this.b == null;
  }
  
  public void onPause()
  {
    Object localObject = this.b;
    if (localObject != null)
    {
      ((IX5JsVirtualMachine)localObject).onPause();
      return;
    }
    localObject = this.c.iterator();
    while (((Iterator)localObject).hasNext())
    {
      WeakReference localWeakReference = (WeakReference)((Iterator)localObject).next();
      if (localWeakReference.get() != null) {
        ((JsVirtualMachine.a)localWeakReference.get()).a();
      }
    }
  }
  
  public void onResume()
  {
    Object localObject = this.b;
    if (localObject != null)
    {
      ((IX5JsVirtualMachine)localObject).onResume();
      return;
    }
    localObject = this.c.iterator();
    while (((Iterator)localObject).hasNext())
    {
      WeakReference localWeakReference = (WeakReference)((Iterator)localObject).next();
      if (localWeakReference.get() != null) {
        ((JsVirtualMachine.a)localWeakReference.get()).b();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.smtt.sdk.JsVirtualMachine
 * JD-Core Version:    0.7.0.1
 */