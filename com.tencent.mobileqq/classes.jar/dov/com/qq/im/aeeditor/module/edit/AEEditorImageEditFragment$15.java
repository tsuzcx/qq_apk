package dov.com.qq.im.aeeditor.module.edit;

import bmbg;
import bmbj;
import bmgo;
import bmkz;
import com.tencent.tavcut.session.TAVCutImageSession;
import dov.com.qq.im.aeeditor.module.aifilter.AEEditorAILoadingView;
import dov.com.qq.im.aeeditor.module.filter.AEEditorFilterBean;
import dov.com.qq.im.aeeditor.module.filter.AEEditorFilterControlPanel;
import java.util.HashMap;

class AEEditorImageEditFragment$15
  implements Runnable
{
  AEEditorImageEditFragment$15(AEEditorImageEditFragment paramAEEditorImageEditFragment, int paramInt1, int paramInt2, bmgo parambmgo, AEEditorFilterBean paramAEEditorFilterBean) {}
  
  public void run()
  {
    this.this$0.jdField_a_of_type_DovComQqImAeeditorModuleAifilterAEEditorAILoadingView.setShowResult(true);
    this.this$0.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterControlPanel.b(false);
    this.this$0.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterControlPanel.a(false);
    this.this$0.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterControlPanel.a(this.jdField_a_of_type_Int);
    AEEditorImageEditFragment.a(this.this$0).a(this.b, this.jdField_a_of_type_Bmgo, this.jdField_a_of_type_Int);
    AEEditorImageEditFragment.a(this.this$0).a(this.b, this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterBean.getEffectId());
    if (AEEditorImageEditFragment.a(this.this$0) != null) {
      AEEditorImageEditFragment.a(this.this$0).setOverlayImage(this.b, this.jdField_a_of_type_Bmgo.a());
    }
    bmbg.a().a().a.put(Integer.valueOf(this.b), this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterBean.getEffectId());
    bmbg.a().a().b.put(Integer.valueOf(this.b), Float.valueOf(-1.0F));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.edit.AEEditorImageEditFragment.15
 * JD-Core Version:    0.7.0.1
 */