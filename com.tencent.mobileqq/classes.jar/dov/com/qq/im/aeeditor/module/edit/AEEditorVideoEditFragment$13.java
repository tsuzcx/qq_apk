package dov.com.qq.im.aeeditor.module.edit;

import com.tencent.mobileqq.app.ThreadManager;
import dov.com.qq.im.aeeditor.view.AEEditorQcircleBubbleView;
import mqq.os.MqqHandler;

class AEEditorVideoEditFragment$13
  implements Runnable
{
  AEEditorVideoEditFragment$13(AEEditorVideoEditFragment paramAEEditorVideoEditFragment) {}
  
  public void run()
  {
    this.this$0.jdField_a_of_type_DovComQqImAeeditorViewAEEditorQcircleBubbleView.b(1);
    this.this$0.jdField_a_of_type_DovComQqImAeeditorViewAEEditorQcircleBubbleView.c(2131689711);
    this.this$0.jdField_a_of_type_DovComQqImAeeditorViewAEEditorQcircleBubbleView.a(this.this$0.jdField_a_of_type_ComTencentTavcutViewTAVCutVideoView, 4, 1);
    ThreadManager.getUIHandler().postDelayed(AEEditorVideoEditFragment.a(this.this$0), 3000L);
    this.this$0.jdField_a_of_type_DovComQqImAeeditorViewAEEditorQcircleBubbleView.setOnDismissListener(new AEEditorVideoEditFragment.13.1(this));
    this.this$0.r();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.edit.AEEditorVideoEditFragment.13
 * JD-Core Version:    0.7.0.1
 */