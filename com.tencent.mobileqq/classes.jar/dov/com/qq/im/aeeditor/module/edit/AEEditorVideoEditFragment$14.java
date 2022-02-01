package dov.com.qq.im.aeeditor.module.edit;

import com.tencent.mobileqq.app.ThreadManager;
import dov.com.qq.im.aeeditor.view.AEEditorQcircleBubbleView;
import mqq.os.MqqHandler;

class AEEditorVideoEditFragment$14
  implements Runnable
{
  AEEditorVideoEditFragment$14(AEEditorVideoEditFragment paramAEEditorVideoEditFragment, boolean paramBoolean) {}
  
  public void run()
  {
    this.this$0.b.b(2);
    this.this$0.b.c(2131689721);
    this.this$0.b.a(AEEditorVideoEditFragment.a(this.this$0), 1, 2);
    ThreadManager.getUIHandler().postDelayed(AEEditorVideoEditFragment.b(this.this$0), 3000L);
    this.this$0.b.setOnDismissListener(new AEEditorVideoEditFragment.14.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.edit.AEEditorVideoEditFragment.14
 * JD-Core Version:    0.7.0.1
 */