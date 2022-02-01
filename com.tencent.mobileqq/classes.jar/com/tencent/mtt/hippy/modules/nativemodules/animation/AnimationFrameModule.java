package com.tencent.mtt.hippy.modules.nativemodules.animation;

import android.os.Build.VERSION;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.annotation.HippyMethod;
import com.tencent.mtt.hippy.annotation.HippyNativeModule;
import com.tencent.mtt.hippy.annotation.HippyNativeModule.Thread;
import com.tencent.mtt.hippy.dom.e;
import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.mtt.hippy.modules.nativemodules.HippyNativeModuleBase;

@HippyNativeModule(name="AnimationFrameModule", thread=HippyNativeModule.Thread.MAIN)
public class AnimationFrameModule
  extends HippyNativeModuleBase
{
  private static boolean a;
  
  static
  {
    if (Build.VERSION.SDK_INT >= 16) {}
    for (boolean bool = true;; bool = false)
    {
      a = bool;
      return;
    }
  }
  
  public AnimationFrameModule(HippyEngineContext paramHippyEngineContext)
  {
    super(paramHippyEngineContext);
  }
  
  @HippyMethod(name="requestAnimationFrame")
  public void requestAnimationFrame(Promise paramPromise)
  {
    e.a().a(new AnimationFrameModule.1(this, paramPromise));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mtt.hippy.modules.nativemodules.animation.AnimationFrameModule
 * JD-Core Version:    0.7.0.1
 */