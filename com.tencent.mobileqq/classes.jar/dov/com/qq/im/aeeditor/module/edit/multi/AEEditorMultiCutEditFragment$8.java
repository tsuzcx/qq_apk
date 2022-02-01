package dov.com.qq.im.aeeditor.module.edit.multi;

import com.tencent.mobileqq.app.ThreadManager;
import dov.com.qq.im.aeeditor.view.AEEditorQcircleBubbleView;
import mqq.os.MqqHandler;

class AEEditorMultiCutEditFragment$8
  implements Runnable
{
  AEEditorMultiCutEditFragment$8(AEEditorMultiCutEditFragment paramAEEditorMultiCutEditFragment) {}
  
  public void run()
  {
    this.this$0.a.b(1);
    this.this$0.a.c(2131689722);
    this.this$0.a.a(AEEditorMultiCutEditFragment.a(this.this$0), 1, 3, 94, 0, false);
    ThreadManager.getUIHandler().postDelayed(AEEditorMultiCutEditFragment.a(this.this$0), 3000L);
    this.this$0.a.setOnDismissListener(new AEEditorMultiCutEditFragment.8.1(this));
    this.this$0.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.edit.multi.AEEditorMultiCutEditFragment.8
 * JD-Core Version:    0.7.0.1
 */