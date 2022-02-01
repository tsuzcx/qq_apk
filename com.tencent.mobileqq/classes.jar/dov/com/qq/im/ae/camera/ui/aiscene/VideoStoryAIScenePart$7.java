package dov.com.qq.im.ae.camera.ui.aiscene;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.TextView;
import java.util.concurrent.atomic.AtomicBoolean;

class VideoStoryAIScenePart$7
  implements Animation.AnimationListener
{
  VideoStoryAIScenePart$7(VideoStoryAIScenePart paramVideoStoryAIScenePart, boolean paramBoolean, int paramInt, String paramString) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    VideoStoryAIScenePart.a(this.jdField_a_of_type_DovComQqImAeCameraUiAisceneVideoStoryAIScenePart, false);
    VideoStoryAIScenePart.b(this.jdField_a_of_type_DovComQqImAeCameraUiAisceneVideoStoryAIScenePart).setVisibility(8);
    VideoStoryAIScenePart.a(this.jdField_a_of_type_DovComQqImAeCameraUiAisceneVideoStoryAIScenePart).setVisibility(8);
    if ((this.jdField_a_of_type_Boolean) && (!VideoStoryAIScenePart.a(this.jdField_a_of_type_DovComQqImAeCameraUiAisceneVideoStoryAIScenePart).get())) {
      VideoStoryAIScenePart.a(this.jdField_a_of_type_DovComQqImAeCameraUiAisceneVideoStoryAIScenePart, this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString);
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    VideoStoryAIScenePart.a(this.jdField_a_of_type_DovComQqImAeCameraUiAisceneVideoStoryAIScenePart, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.ui.aiscene.VideoStoryAIScenePart.7
 * JD-Core Version:    0.7.0.1
 */