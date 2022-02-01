package com.tencent.mobileqq.kandian.glue.viola.adapter.ui;

import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.viola.ui.component.image.ImageAction;
import java.lang.ref.WeakReference;
import java.util.Set;

class ComponentAdapter$ViolaImageListener
  implements URLDrawable.URLDrawableListener
{
  private WeakReference<ImageAction> b;
  private boolean c;
  
  public ComponentAdapter$ViolaImageListener(ComponentAdapter paramComponentAdapter, boolean paramBoolean, ImageAction paramImageAction)
  {
    this.b = new WeakReference(paramImageAction);
    this.c = paramBoolean;
  }
  
  public void onLoadCanceled(URLDrawable paramURLDrawable)
  {
    Object localObject = this.b;
    if (localObject == null) {
      return;
    }
    localObject = (ImageAction)((WeakReference)localObject).get();
    if (localObject == null) {
      return;
    }
    ((ImageAction)localObject).onCancel();
    ComponentAdapter.b(this.a).remove(paramURLDrawable);
  }
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    WeakReference localWeakReference = this.b;
    if ((localWeakReference != null) && (localWeakReference.get() != null)) {
      ComponentAdapter.a(this.a, (ImageAction)this.b.get(), paramURLDrawable, paramThrowable);
    }
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    WeakReference localWeakReference = this.b;
    if ((localWeakReference != null) && (localWeakReference.get() != null)) {
      ComponentAdapter.a(this.a, (ImageAction)this.b.get(), paramURLDrawable, this.c);
    }
    ComponentAdapter.b(this.a).remove(paramURLDrawable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.viola.adapter.ui.ComponentAdapter.ViolaImageListener
 * JD-Core Version:    0.7.0.1
 */