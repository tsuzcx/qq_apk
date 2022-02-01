package com.tencent.mobileqq.troop.utils;

import com.tencent.mobileqq.surfaceviewaction.gl.FrameSprite.OnFrameEndListener;
import com.tencent.mobileqq.surfaceviewaction.gl.SpriteVideoView;
import java.lang.ref.WeakReference;

final class VideoAnimationUtils$2
  implements Runnable
{
  VideoAnimationUtils$2(WeakReference paramWeakReference, String paramString, FrameSprite.OnFrameEndListener paramOnFrameEndListener) {}
  
  public void run()
  {
    SpriteVideoView localSpriteVideoView = (SpriteVideoView)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localSpriteVideoView != null) {
      localSpriteVideoView.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlFrameSprite$OnFrameEndListener);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.VideoAnimationUtils.2
 * JD-Core Version:    0.7.0.1
 */