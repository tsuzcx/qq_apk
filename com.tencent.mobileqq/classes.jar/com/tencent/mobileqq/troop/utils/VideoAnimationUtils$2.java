package com.tencent.mobileqq.troop.utils;

import bdyy;
import com.tencent.mobileqq.surfaceviewaction.gl.SpriteVideoView;
import java.lang.ref.WeakReference;

public final class VideoAnimationUtils$2
  implements Runnable
{
  public VideoAnimationUtils$2(WeakReference paramWeakReference, String paramString, bdyy parambdyy) {}
  
  public void run()
  {
    SpriteVideoView localSpriteVideoView = (SpriteVideoView)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localSpriteVideoView != null) {
      localSpriteVideoView.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Bdyy);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.VideoAnimationUtils.2
 * JD-Core Version:    0.7.0.1
 */