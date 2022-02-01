package com.tencent.mobileqq.cmshow.crossengine;

import android.view.View;
import com.tencent.mobileqq.cmshow.engine.render.ICMShowView;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class CERenderService$offscreenSurfaceReady$1
  implements Runnable
{
  CERenderService$offscreenSurfaceReady$1(CERenderService paramCERenderService) {}
  
  public final void run()
  {
    CERenderService.a(this.this$0).getView().setAlpha(1.0F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.cmshow.crossengine.CERenderService.offscreenSurfaceReady.1
 * JD-Core Version:    0.7.0.1
 */