package dov.com.qq.im.aeeditor.module.edit.multi;

import dov.com.qq.im.ae.util.AEQLog;
import dov.com.qq.im.aeeditor.view.videotrack.VideoTrackContainerView.OnStartTimeChangedListener;

class AEEditorMultiCutEditFragment$19
  implements VideoTrackContainerView.OnStartTimeChangedListener
{
  AEEditorMultiCutEditFragment$19(AEEditorMultiCutEditFragment paramAEEditorMultiCutEditFragment) {}
  
  public void a(long paramLong)
  {
    AEQLog.b("AEEditorMultiCutEditFragment", "updateTimeBarCurrentTime >> curTime:" + paramLong);
    AEEditorMultiCutEditFragment.a(this.a, true);
  }
  
  public void b(long paramLong)
  {
    AEEditorMultiCutEditFragment.b(this.a, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.edit.multi.AEEditorMultiCutEditFragment.19
 * JD-Core Version:    0.7.0.1
 */