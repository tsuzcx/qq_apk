package dov.com.qq.im.aeeditor.module.text;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import dov.com.qq.im.AEReportUtils;
import dov.com.qq.im.ae.report.AEBaseDataReporter;
import dov.com.qq.im.ae.report.AEBaseReportParam;
import dov.com.qq.im.aeeditor.util.AEEditorPagStickerUtil;

class AETextStickerAdapter$1
  implements View.OnClickListener
{
  AETextStickerAdapter$1(AETextStickerAdapter paramAETextStickerAdapter, int paramInt, AEEditorTextBean paramAEEditorTextBean, AETextStickerAdapter.VH paramVH) {}
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_Int == AETextStickerAdapter.a(this.jdField_a_of_type_DovComQqImAeeditorModuleTextAETextStickerAdapter)) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorTextBean.pagFilePath != null)
      {
        if ((AETextStickerAdapter.a(this.jdField_a_of_type_DovComQqImAeeditorModuleTextAETextStickerAdapter) != -1) || (AETextStickerAdapter.b(this.jdField_a_of_type_DovComQqImAeeditorModuleTextAETextStickerAdapter) < 10)) {
          break;
        }
        Context localContext = this.jdField_a_of_type_DovComQqImAeeditorModuleTextAETextStickerAdapter$VH.a.getContext();
        if (localContext != null) {
          QQToast.a(localContext, localContext.getString(2131689767), 0).a();
        }
      }
    }
    AEBaseReportParam.a().a().i = this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorTextBean.id;
    AEBaseDataReporter.a().u();
    if (AETextStickerAdapter.c(this.jdField_a_of_type_DovComQqImAeeditorModuleTextAETextStickerAdapter) == 10001)
    {
      AEReportUtils.f(this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorTextBean.id);
      label133:
      if (this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorTextBean.usable) {
        break label215;
      }
      AETextStickerAdapter.a(this.jdField_a_of_type_DovComQqImAeeditorModuleTextAETextStickerAdapter, this.jdField_a_of_type_DovComQqImAeeditorModuleTextAETextStickerAdapter$VH, true);
      this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorTextBean.isDownloading = true;
      AEEditorPagStickerUtil.a(this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorTextBean, this.jdField_a_of_type_DovComQqImAeeditorModuleTextAETextStickerAdapter);
    }
    for (;;)
    {
      AETextStickerAdapter.a(this.jdField_a_of_type_DovComQqImAeeditorModuleTextAETextStickerAdapter, this.jdField_a_of_type_Int);
      break;
      if (AETextStickerAdapter.c(this.jdField_a_of_type_DovComQqImAeeditorModuleTextAETextStickerAdapter) != 10002) {
        break label133;
      }
      AEReportUtils.r(this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorTextBean.id);
      break label133;
      label215:
      if (AETextStickerAdapter.a(this.jdField_a_of_type_DovComQqImAeeditorModuleTextAETextStickerAdapter) != null)
      {
        AETextStickerAdapter.a(this.jdField_a_of_type_DovComQqImAeeditorModuleTextAETextStickerAdapter).a(this.jdField_a_of_type_Int, this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorTextBean);
        this.jdField_a_of_type_DovComQqImAeeditorModuleTextAETextStickerAdapter.notifyDataSetChanged();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.text.AETextStickerAdapter.1
 * JD-Core Version:    0.7.0.1
 */