package dov.com.qq.im.aeeditor.module.edit.multi;

import android.view.View;
import dov.com.qq.im.aeeditor.module.edit.multi.viewmodel.MvVideoViewModel;
import dov.com.qq.im.aeeditor.view.dragdrop.IDragView;
import dov.com.qq.im.aeeditor.view.videotrack.TrackSelectedStateChangeListener;
import dov.com.qq.im.aeeditor.view.videotrack.VideoTrackContainerView;

class AEEditorMultiCutEditFragment$20
  implements TrackSelectedStateChangeListener
{
  AEEditorMultiCutEditFragment$20(AEEditorMultiCutEditFragment paramAEEditorMultiCutEditFragment) {}
  
  public void a(IDragView paramIDragView, boolean paramBoolean, int paramInt)
  {
    this.a.a.b();
    if (paramBoolean)
    {
      ((View)paramIDragView).post(new AEEditorMultiCutEditFragment.20.1(this, paramIDragView));
      if (AEEditorMultiCutEditFragment.a(this.a).a()) {
        AEEditorMultiCutEditFragment.a(this.a).b();
      }
      return;
    }
    ((View)paramIDragView).post(new AEEditorMultiCutEditFragment.20.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.edit.multi.AEEditorMultiCutEditFragment.20
 * JD-Core Version:    0.7.0.1
 */