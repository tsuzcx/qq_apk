package dov.com.qq.im.aeeditor.module.edit;

import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import com.tencent.tavcut.session.TAVCutImageSession;
import dov.com.qq.im.ae.util.AEQLog;

class AEEditorImageEditFragment$1
  extends GestureDetector.SimpleOnGestureListener
{
  AEEditorImageEditFragment$1(AEEditorImageEditFragment paramAEEditorImageEditFragment) {}
  
  public void onShowPress(MotionEvent paramMotionEvent)
  {
    super.onShowPress(paramMotionEvent);
    AEEditorImageEditFragment.a(this.a).toggleAEKit(AEEditorImageEditFragment.a(this.a), false);
    AEQLog.a("AEEditorImageEditFragment", "[onTouch] onShowPress");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.edit.AEEditorImageEditFragment.1
 * JD-Core Version:    0.7.0.1
 */