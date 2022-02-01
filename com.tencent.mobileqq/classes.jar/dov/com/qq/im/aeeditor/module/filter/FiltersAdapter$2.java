package dov.com.qq.im.aeeditor.module.filter;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import dov.com.qq.im.AEReportUtils;

class FiltersAdapter$2
  implements View.OnClickListener
{
  FiltersAdapter$2(FiltersAdapter paramFiltersAdapter, AEEditorFilterBean paramAEEditorFilterBean, int paramInt) {}
  
  public void onClick(View paramView)
  {
    if (FiltersAdapter.a(this.jdField_a_of_type_DovComQqImAeeditorModuleFilterFiltersAdapter) == 10001) {
      AEReportUtils.c(this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterBean.getEffectId());
    }
    for (;;)
    {
      AEEditorFilterBean localAEEditorFilterBean = this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterBean;
      boolean bool = true;
      if (FiltersAdapter.a(this.jdField_a_of_type_DovComQqImAeeditorModuleFilterFiltersAdapter) != null) {
        bool = FiltersAdapter.a(this.jdField_a_of_type_DovComQqImAeeditorModuleFilterFiltersAdapter).a(this.jdField_a_of_type_Int, localAEEditorFilterBean);
      }
      if (bool) {
        this.jdField_a_of_type_DovComQqImAeeditorModuleFilterFiltersAdapter.a(this.jdField_a_of_type_Int);
      }
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (FiltersAdapter.a(this.jdField_a_of_type_DovComQqImAeeditorModuleFilterFiltersAdapter) == 10002) {
        AEReportUtils.o(this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterBean.getEffectId());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.filter.FiltersAdapter.2
 * JD-Core Version:    0.7.0.1
 */