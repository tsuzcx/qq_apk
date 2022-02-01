package com.tencent.mtt.hippy.modules.nativemodules.animation;

import android.util.SparseArray;

class AnimationModule$1
  implements Runnable
{
  AnimationModule$1(AnimationModule paramAnimationModule) {}
  
  public void run()
  {
    if (AnimationModule.a(this.a) == null) {
      return;
    }
    int j = AnimationModule.a(this.a).size();
    int i = 0;
    while (i < j)
    {
      ((a)AnimationModule.a(this.a).valueAt(i)).h();
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mtt.hippy.modules.nativemodules.animation.AnimationModule.1
 * JD-Core Version:    0.7.0.1
 */