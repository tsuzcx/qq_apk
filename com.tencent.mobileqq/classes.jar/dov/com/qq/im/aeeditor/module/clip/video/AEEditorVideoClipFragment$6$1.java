package dov.com.qq.im.aeeditor.module.clip.video;

import com.tencent.mobileqq.widget.QQToast;
import com.tencent.tavcut.session.TAVCutVideoSession;
import com.tencent.tavcut.timeline.TimelineView.SpeedChangeCallback;
import dov.com.qq.im.ae.report.AEBaseDataReporter;
import dov.com.qq.im.ae.report.AEBaseReportParam;

class AEEditorVideoClipFragment$6$1
  implements TimelineView.SpeedChangeCallback
{
  AEEditorVideoClipFragment$6$1(AEEditorVideoClipFragment.6 param6, float paramFloat) {}
  
  public void onChangeFailed(int paramInt)
  {
    AEBaseDataReporter.a().a(this.jdField_a_of_type_Float, "edit");
    if (paramInt == 1000) {
      QQToast.a(this.jdField_a_of_type_DovComQqImAeeditorModuleClipVideoAEEditorVideoClipFragment$6.jdField_a_of_type_DovComQqImAeeditorModuleClipVideoAEEditorVideoClipFragment.getActivity(), 2131689844, 0).a();
    }
    while (this.jdField_a_of_type_DovComQqImAeeditorModuleClipVideoAEEditorVideoClipFragment$6.jdField_a_of_type_DovComQqImAeeditorModuleClipVideoAEEditorVideoClipFragment.jdField_a_of_type_JavaLangFloat != null)
    {
      this.jdField_a_of_type_DovComQqImAeeditorModuleClipVideoAEEditorVideoClipFragment$6.jdField_a_of_type_DovComQqImAeeditorModuleClipVideoVideoSetSpeedDialog.a(this.jdField_a_of_type_DovComQqImAeeditorModuleClipVideoAEEditorVideoClipFragment$6.jdField_a_of_type_DovComQqImAeeditorModuleClipVideoAEEditorVideoClipFragment.jdField_a_of_type_JavaLangFloat.floatValue());
      return;
      if (paramInt == 1001) {
        QQToast.a(this.jdField_a_of_type_DovComQqImAeeditorModuleClipVideoAEEditorVideoClipFragment$6.jdField_a_of_type_DovComQqImAeeditorModuleClipVideoAEEditorVideoClipFragment.getActivity(), 2131689843, 0).a();
      }
    }
    this.jdField_a_of_type_DovComQqImAeeditorModuleClipVideoAEEditorVideoClipFragment$6.jdField_a_of_type_DovComQqImAeeditorModuleClipVideoVideoSetSpeedDialog.a(this.jdField_a_of_type_DovComQqImAeeditorModuleClipVideoAEEditorVideoClipFragment$6.jdField_a_of_type_DovComQqImAeeditorModuleClipVideoAEEditorVideoClipFragment.jdField_a_of_type_Float);
  }
  
  public void onChangeSucc(float paramFloat)
  {
    this.jdField_a_of_type_DovComQqImAeeditorModuleClipVideoAEEditorVideoClipFragment$6.jdField_a_of_type_DovComQqImAeeditorModuleClipVideoAEEditorVideoClipFragment.jdField_a_of_type_JavaLangFloat = Float.valueOf(paramFloat);
    AEEditorVideoClipFragment.a(this.jdField_a_of_type_DovComQqImAeeditorModuleClipVideoAEEditorVideoClipFragment$6.jdField_a_of_type_DovComQqImAeeditorModuleClipVideoAEEditorVideoClipFragment).setSpeed(paramFloat, true);
    AEEditorVideoClipFragment.a(this.jdField_a_of_type_DovComQqImAeeditorModuleClipVideoAEEditorVideoClipFragment$6.jdField_a_of_type_DovComQqImAeeditorModuleClipVideoAEEditorVideoClipFragment).a(AEEditorVideoClipFragment.a(this.jdField_a_of_type_DovComQqImAeeditorModuleClipVideoAEEditorVideoClipFragment$6.jdField_a_of_type_DovComQqImAeeditorModuleClipVideoAEEditorVideoClipFragment).getTAVSource());
    AEBaseReportParam.a().a().a = paramFloat;
    AEBaseDataReporter.a().a(this.jdField_a_of_type_Float, "edit");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.clip.video.AEEditorVideoClipFragment.6.1
 * JD-Core Version:    0.7.0.1
 */