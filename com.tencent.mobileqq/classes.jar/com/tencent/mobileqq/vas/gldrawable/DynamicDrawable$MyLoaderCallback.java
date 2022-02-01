package com.tencent.mobileqq.vas.gldrawable;

import android.graphics.drawable.Drawable;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/vas/gldrawable/DynamicDrawable$MyLoaderCallback;", "Lcom/tencent/mobileqq/vas/gldrawable/GLDrawableProxy$LoaderCallback;", "drawableRef", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mobileqq/vas/gldrawable/DynamicDrawable;", "(Ljava/lang/ref/WeakReference;)V", "getDrawableRef", "()Ljava/lang/ref/WeakReference;", "onLoadFailed", "", "onLoadSucceed", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
final class DynamicDrawable$MyLoaderCallback
  implements GLDrawableProxy.LoaderCallback
{
  @NotNull
  private final WeakReference<DynamicDrawable> a;
  
  public DynamicDrawable$MyLoaderCallback(@NotNull WeakReference<DynamicDrawable> paramWeakReference)
  {
    this.a = paramWeakReference;
  }
  
  public void a()
  {
    DynamicDrawable localDynamicDrawable = (DynamicDrawable)this.a.get();
    if (localDynamicDrawable != null)
    {
      Drawable localDrawable = (Drawable)DynamicDrawable.a(localDynamicDrawable).invoke();
      if (localDrawable != null) {
        DynamicDrawable.a(localDynamicDrawable, localDrawable);
      }
      if (localDynamicDrawable.a() == null) {
        DynamicDrawable.a(localDynamicDrawable, (Drawable)DynamicDrawable.b(localDynamicDrawable).invoke());
      }
    }
  }
  
  public void b()
  {
    DynamicDrawable localDynamicDrawable = (DynamicDrawable)this.a.get();
    if ((localDynamicDrawable != null) && (localDynamicDrawable.a() == null)) {
      DynamicDrawable.a(localDynamicDrawable, (Drawable)DynamicDrawable.b(localDynamicDrawable).invoke());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.vas.gldrawable.DynamicDrawable.MyLoaderCallback
 * JD-Core Version:    0.7.0.1
 */