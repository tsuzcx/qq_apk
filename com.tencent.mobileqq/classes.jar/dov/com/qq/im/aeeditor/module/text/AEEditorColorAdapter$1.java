package dov.com.qq.im.aeeditor.module.text;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import dov.com.qq.im.ae.report.AEBaseDataReporter;
import dov.com.qq.im.ae.report.AEBaseReportParam;
import java.util.List;

class AEEditorColorAdapter$1
  implements View.OnClickListener
{
  AEEditorColorAdapter$1(AEEditorColorAdapter paramAEEditorColorAdapter, int paramInt, AEEditorColorAdapter.VH paramVH) {}
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_Int == AEEditorColorAdapter.a(this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorColorAdapter))
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    AEEditorColorAdapter.a(this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorColorAdapter, this.jdField_a_of_type_Int);
    AEEditorColorAdapter.a(this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorColorAdapter).a(AEEditorColorAdapter.a(this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorColorAdapter), ((Integer)AEEditorColorAdapter.a(this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorColorAdapter).get(this.jdField_a_of_type_Int)).intValue(), this.jdField_a_of_type_Int, AEEditorColorAdapter.b(this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorColorAdapter));
    AEEditorColorAdapter.a(this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorColorAdapter, this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorColorAdapter$VH, this.jdField_a_of_type_Int);
    if ("adapter_extract".equals(AEEditorColorAdapter.a(this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorColorAdapter)))
    {
      AEBaseReportParam.a().a().jdField_h_of_type_JavaLangString = "ai_color";
      AEBaseReportParam.a().a().jdField_h_of_type_Int = -1;
    }
    for (;;)
    {
      AEBaseReportParam.a().a().i = AEEditorColorAdapter.b(this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorColorAdapter);
      AEBaseDataReporter.a().s();
      break;
      if ("adapter_fix".equals(AEEditorColorAdapter.a(this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorColorAdapter)))
      {
        AEBaseReportParam.a().a().jdField_h_of_type_JavaLangString = "common_color";
        AEBaseReportParam.a().a().jdField_h_of_type_Int = (this.jdField_a_of_type_Int + 1);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.text.AEEditorColorAdapter.1
 * JD-Core Version:    0.7.0.1
 */