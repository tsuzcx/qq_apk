package dov.com.qq.im.aeeditor.module.autotemplate;

import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import dov.com.qq.im.AEReportUtils;
import dov.com.qq.im.aeeditor.module.filter.AEEditorResourceManager;

class AEAutoTemplateAdapter$2
  implements View.OnClickListener
{
  AEAutoTemplateAdapter$2(AEAutoTemplateAdapter paramAEAutoTemplateAdapter, int paramInt, AEEditorAutoTemplateBean paramAEEditorAutoTemplateBean) {}
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_Int == AEAutoTemplateAdapter.a(this.jdField_a_of_type_DovComQqImAeeditorModuleAutotemplateAEAutoTemplateAdapter)) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (AEAutoTemplateAdapter.a(this.jdField_a_of_type_DovComQqImAeeditorModuleAutotemplateAEAutoTemplateAdapter) != null) {
        AEAutoTemplateAdapter.a(this.jdField_a_of_type_DovComQqImAeeditorModuleAutotemplateAEAutoTemplateAdapter).a(this.jdField_a_of_type_Int, this.jdField_a_of_type_DovComQqImAeeditorModuleAutotemplateAEEditorAutoTemplateBean);
      }
      if (TextUtils.isEmpty(this.jdField_a_of_type_DovComQqImAeeditorModuleAutotemplateAEEditorAutoTemplateBean.packageUrl))
      {
        this.jdField_a_of_type_DovComQqImAeeditorModuleAutotemplateAEAutoTemplateAdapter.notifyDataSetChanged();
      }
      else
      {
        if (AEAutoTemplateAdapter.a(this.jdField_a_of_type_DovComQqImAeeditorModuleAutotemplateAEAutoTemplateAdapter) != null) {
          AEAutoTemplateAdapter.a(this.jdField_a_of_type_DovComQqImAeeditorModuleAutotemplateAEAutoTemplateAdapter).a(this.jdField_a_of_type_DovComQqImAeeditorModuleAutotemplateAEEditorAutoTemplateBean);
        }
        AEEditorResourceManager.a().a(AEEditorAutoTemplateBean.convert2DownloadBean(this.jdField_a_of_type_DovComQqImAeeditorModuleAutotemplateAEEditorAutoTemplateBean), new AEAutoTemplateAdapter.2.1(this));
        AEReportUtils.m(this.jdField_a_of_type_DovComQqImAeeditorModuleAutotemplateAEEditorAutoTemplateBean.id);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.autotemplate.AEAutoTemplateAdapter.2
 * JD-Core Version:    0.7.0.1
 */