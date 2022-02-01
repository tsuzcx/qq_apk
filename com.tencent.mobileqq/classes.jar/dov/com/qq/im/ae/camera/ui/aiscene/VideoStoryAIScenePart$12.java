package dov.com.qq.im.ae.camera.ui.aiscene;

import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView.AISceneCallback;
import java.util.concurrent.atomic.AtomicReference;

class VideoStoryAIScenePart$12
  implements IAIScene.GetImageSceneCB
{
  VideoStoryAIScenePart$12(VideoStoryAIScenePart paramVideoStoryAIScenePart, AtomicReference paramAtomicReference) {}
  
  public void a(TTAutoAISceneType paramTTAutoAISceneType)
  {
    CameraCaptureView.AISceneCallback localAISceneCallback = (CameraCaptureView.AISceneCallback)this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicReference.get();
    if (localAISceneCallback != null) {
      localAISceneCallback.a(paramTTAutoAISceneType);
    }
  }
  
  public void a(String paramString)
  {
    CameraCaptureView.AISceneCallback localAISceneCallback = (CameraCaptureView.AISceneCallback)this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicReference.get();
    if (localAISceneCallback != null) {
      localAISceneCallback.a(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.ui.aiscene.VideoStoryAIScenePart.12
 * JD-Core Version:    0.7.0.1
 */