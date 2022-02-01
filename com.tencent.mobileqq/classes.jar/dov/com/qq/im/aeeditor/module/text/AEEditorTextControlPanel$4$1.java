package dov.com.qq.im.aeeditor.module.text;

import android.widget.PopupWindow.OnDismissListener;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

class AEEditorTextControlPanel$4$1
  implements PopupWindow.OnDismissListener
{
  AEEditorTextControlPanel$4$1(AEEditorTextControlPanel.4 param4) {}
  
  public void onDismiss()
  {
    ThreadManager.getUIHandler().removeCallbacks(AEEditorTextControlPanel.a(this.a.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.text.AEEditorTextControlPanel.4.1
 * JD-Core Version:    0.7.0.1
 */