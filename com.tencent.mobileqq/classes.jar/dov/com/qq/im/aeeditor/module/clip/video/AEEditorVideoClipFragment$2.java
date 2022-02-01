package dov.com.qq.im.aeeditor.module.clip.video;

import com.tencent.tavcut.session.TAVCutVideoSession;
import com.tencent.tavcut.timeline.TimelineView.SpeedChangeCallback;

class AEEditorVideoClipFragment$2
  implements TimelineView.SpeedChangeCallback
{
  AEEditorVideoClipFragment$2(AEEditorVideoClipFragment paramAEEditorVideoClipFragment) {}
  
  public void onChangeFailed(int paramInt) {}
  
  public void onChangeSucc(float paramFloat)
  {
    this.a.jdField_a_of_type_JavaLangFloat = Float.valueOf(this.a.jdField_a_of_type_Float);
    AEEditorVideoClipFragment.a(this.a).setSpeed(paramFloat, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.clip.video.AEEditorVideoClipFragment.2
 * JD-Core Version:    0.7.0.1
 */