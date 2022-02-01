package dov.com.qq.im.aeeditor.util;

import dov.com.qq.im.ae.util.AEQLog;
import dov.com.qq.im.aeeditor.manage.AEEditorResourceDownloader.ResDownLoadListener;
import dov.com.qq.im.aeeditor.module.text.AEEditorTextBean;

final class AEEditorPagStickerUtil$3
  implements AEEditorResourceDownloader.ResDownLoadListener
{
  AEEditorPagStickerUtil$3(AEEditorTextBean paramAEEditorTextBean, AEEditorPagStickerUtil.PrepareCallback paramPrepareCallback) {}
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_DovComQqImAeeditorUtilAEEditorPagStickerUtil$PrepareCallback != null) {
      this.jdField_a_of_type_DovComQqImAeeditorUtilAEEditorPagStickerUtil$PrepareCallback.a(this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorTextBean, (int)(0.66D * paramInt));
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      AEEditorPagStickerUtil.c(this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorTextBean, this.jdField_a_of_type_DovComQqImAeeditorUtilAEEditorPagStickerUtil$PrepareCallback);
      AEEditorPagStickerUtil.b(this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorTextBean, this.jdField_a_of_type_DovComQqImAeeditorUtilAEEditorPagStickerUtil$PrepareCallback);
      return;
    }
    if (this.jdField_a_of_type_DovComQqImAeeditorUtilAEEditorPagStickerUtil$PrepareCallback != null) {
      this.jdField_a_of_type_DovComQqImAeeditorUtilAEEditorPagStickerUtil$PrepareCallback.a(this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorTextBean, paramBoolean, "ERROR_PAG_ZIP_DOWNLOAD_FAILED");
    }
    AEQLog.a("AEEditorPagStickerUtil", "[downloadPagZip] download pag zip failed");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.util.AEEditorPagStickerUtil.3
 * JD-Core Version:    0.7.0.1
 */