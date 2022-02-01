package com.tencent.mobileqq.vas.ui;

import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class APNGDrawable$doLoadTask$1
  implements Runnable
{
  APNGDrawable$doLoadTask$1(APNGDrawable paramAPNGDrawable, ILoaderSucessCallback paramILoaderSucessCallback) {}
  
  public final void run()
  {
    int i = 0;
    while (i <= 6)
    {
      if (this.this$0.b())
      {
        APNGDrawable.a.a(true);
        this.a.a();
        return;
      }
      Thread.sleep(500L);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.ui.APNGDrawable.doLoadTask.1
 * JD-Core Version:    0.7.0.1
 */