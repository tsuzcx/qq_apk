package dov.com.qq.im.aeeditor.module.edit.multi;

import android.widget.PopupWindow.OnDismissListener;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

class AEEditorMultiCutEditFragment$8$1
  implements PopupWindow.OnDismissListener
{
  AEEditorMultiCutEditFragment$8$1(AEEditorMultiCutEditFragment.8 param8) {}
  
  public void onDismiss()
  {
    ThreadManager.getUIHandler().removeCallbacks(AEEditorMultiCutEditFragment.a(this.a.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.edit.multi.AEEditorMultiCutEditFragment.8.1
 * JD-Core Version:    0.7.0.1
 */