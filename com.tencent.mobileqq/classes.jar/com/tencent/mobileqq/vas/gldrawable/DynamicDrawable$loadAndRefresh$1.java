package com.tencent.mobileqq.vas.gldrawable;

import java.lang.ref.WeakReference;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class DynamicDrawable$loadAndRefresh$1
  implements Runnable
{
  DynamicDrawable$loadAndRefresh$1(DynamicDrawable paramDynamicDrawable, GLDrawableProxy.GLDrawableLoader paramGLDrawableLoader) {}
  
  public final void run()
  {
    DynamicDrawable.MyLoaderCallback localMyLoaderCallback = new DynamicDrawable.MyLoaderCallback(new WeakReference(this.this$0));
    if (!this.a.a())
    {
      this.a.a((GLDrawableProxy.LoaderCallback)localMyLoaderCallback);
      return;
    }
    localMyLoaderCallback.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.vas.gldrawable.DynamicDrawable.loadAndRefresh.1
 * JD-Core Version:    0.7.0.1
 */