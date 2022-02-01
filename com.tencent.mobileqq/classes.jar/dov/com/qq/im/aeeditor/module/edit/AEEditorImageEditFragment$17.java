package dov.com.qq.im.aeeditor.module.edit;

import com.tencent.tavcut.session.TAVCutImageSession;
import dov.com.qq.im.ae.report.AEBaseReportParam;
import dov.com.qq.im.ae.report.AEEditReportData;
import dov.com.qq.im.aeeditor.module.aifilter.AEEditorAILoadingView;
import dov.com.qq.im.aeeditor.module.aifilter.ComicsFilterResult;
import dov.com.qq.im.aeeditor.module.filter.AEEditorFilterBean;
import dov.com.qq.im.aeeditor.module.filter.AEEditorFilterControlPanel;
import dov.com.qq.im.aeeditor.module.filter.ImageFilterInfoCache;
import java.util.HashMap;

class AEEditorImageEditFragment$17
  implements Runnable
{
  AEEditorImageEditFragment$17(AEEditorImageEditFragment paramAEEditorImageEditFragment, int paramInt1, int paramInt2, ComicsFilterResult paramComicsFilterResult, AEEditorFilterBean paramAEEditorFilterBean) {}
  
  public void run()
  {
    this.this$0.jdField_a_of_type_DovComQqImAeeditorModuleAifilterAEEditorAILoadingView.setShowResult(true);
    this.this$0.e(false);
    this.this$0.f(false);
    this.this$0.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterControlPanel.a(this.jdField_a_of_type_Int);
    AEEditorImageEditFragment.a(this.this$0).a(this.b, this.jdField_a_of_type_DovComQqImAeeditorModuleAifilterComicsFilterResult, this.jdField_a_of_type_Int);
    AEEditorImageEditFragment.a(this.this$0).a(this.b, this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterBean.getEffectId());
    if (AEEditorImageEditFragment.a(this.this$0) != null) {
      AEEditorImageEditFragment.a(this.this$0).setOverlayImage(this.b, this.jdField_a_of_type_DovComQqImAeeditorModuleAifilterComicsFilterResult.a());
    }
    AEBaseReportParam.a().a().a.put(Integer.valueOf(this.b), this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterBean.getEffectId());
    AEBaseReportParam.a().a().b.put(Integer.valueOf(this.b), Float.valueOf(-1.0F));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.edit.AEEditorImageEditFragment.17
 * JD-Core Version:    0.7.0.1
 */