package dov.com.qq.im.aeeditor.module.autotemplate;

import android.view.View;
import android.view.View.OnClickListener;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaCategory;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import dov.com.qq.im.AEReportUtils;
import java.util.List;

class AEAutoTemplateCategoryAdapter$1
  implements View.OnClickListener
{
  AEAutoTemplateCategoryAdapter$1(AEAutoTemplateCategoryAdapter paramAEAutoTemplateCategoryAdapter, int paramInt) {}
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_DovComQqImAeeditorModuleAutotemplateAEAutoTemplateCategoryAdapter.a(this.jdField_a_of_type_Int);
    if (AEAutoTemplateCategoryAdapter.a(this.jdField_a_of_type_DovComQqImAeeditorModuleAutotemplateAEAutoTemplateCategoryAdapter) != null) {
      AEAutoTemplateCategoryAdapter.a(this.jdField_a_of_type_DovComQqImAeeditorModuleAutotemplateAEAutoTemplateCategoryAdapter).a(this.jdField_a_of_type_Int);
    }
    AEReportUtils.k(((MetaCategory)AEAutoTemplateCategoryAdapter.a(this.jdField_a_of_type_DovComQqImAeeditorModuleAutotemplateAEAutoTemplateCategoryAdapter).get(this.jdField_a_of_type_Int)).id);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.autotemplate.AEAutoTemplateCategoryAdapter.1
 * JD-Core Version:    0.7.0.1
 */