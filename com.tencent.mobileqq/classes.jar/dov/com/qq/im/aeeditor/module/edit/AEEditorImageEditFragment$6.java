package dov.com.qq.im.aeeditor.module.edit;

import bllm;
import bloe;
import com.tencent.tavcut.session.TAVCutImageSession;
import dov.com.qq.im.aeeditor.module.aifilter.AEEditorAILoadingView;
import dov.com.qq.im.aeeditor.module.filter.AEEditorFilterControlPanel;

class AEEditorImageEditFragment$6
  implements Runnable
{
  AEEditorImageEditFragment$6(AEEditorImageEditFragment paramAEEditorImageEditFragment, int paramInt, bllm parambllm) {}
  
  public void run()
  {
    this.this$0.jdField_a_of_type_DovComQqImAeeditorModuleAifilterAEEditorAILoadingView.setShowResult(true);
    this.this$0.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterControlPanel.c(false);
    if (this.this$0.b()) {
      this.this$0.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterControlPanel.b(false);
    }
    this.this$0.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterControlPanel.a(2);
    AEEditorImageEditFragment.a(this.this$0).a(this.jdField_a_of_type_Int, this.jdField_a_of_type_Bllm);
    if (AEEditorImageEditFragment.a(this.this$0) != null) {
      AEEditorImageEditFragment.a(this.this$0).setOverlayImage(this.jdField_a_of_type_Int, this.jdField_a_of_type_Bllm.a());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.edit.AEEditorImageEditFragment.6
 * JD-Core Version:    0.7.0.1
 */