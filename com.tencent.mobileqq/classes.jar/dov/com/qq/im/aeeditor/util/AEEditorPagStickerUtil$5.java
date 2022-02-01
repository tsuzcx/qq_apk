package dov.com.qq.im.aeeditor.util;

import dov.com.qq.im.aeeditor.manage.AEEditorResourceDownloader.ResDownLoadListener;
import dov.com.qq.im.aeeditor.module.text.AEEditorTextBean;

final class AEEditorPagStickerUtil$5
  implements AEEditorResourceDownloader.ResDownLoadListener
{
  AEEditorPagStickerUtil$5(AEEditorPagStickerUtil.PrepareCallback paramPrepareCallback, AEEditorTextBean paramAEEditorTextBean) {}
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_DovComQqImAeeditorUtilAEEditorPagStickerUtil$PrepareCallback != null) {
      this.jdField_a_of_type_DovComQqImAeeditorUtilAEEditorPagStickerUtil$PrepareCallback.a(this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorTextBean, (int)(66.0D + 0.34D * paramInt));
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if ((paramBoolean) && (this.jdField_a_of_type_DovComQqImAeeditorUtilAEEditorPagStickerUtil$PrepareCallback != null)) {
      this.jdField_a_of_type_DovComQqImAeeditorUtilAEEditorPagStickerUtil$PrepareCallback.a(this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorTextBean, 100);
    }
    AEEditorPagStickerUtil.PrepareCallback localPrepareCallback;
    AEEditorTextBean localAEEditorTextBean;
    if (this.jdField_a_of_type_DovComQqImAeeditorUtilAEEditorPagStickerUtil$PrepareCallback != null)
    {
      localPrepareCallback = this.jdField_a_of_type_DovComQqImAeeditorUtilAEEditorPagStickerUtil$PrepareCallback;
      localAEEditorTextBean = this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorTextBean;
      if (!paramBoolean) {
        break label62;
      }
    }
    label62:
    for (String str = "SUCCESS_FONT_DOWNLOAD_SUCCEEDED";; str = "ERROR_FONT_DOWNLOAD_FAILED")
    {
      localPrepareCallback.a(localAEEditorTextBean, paramBoolean, str);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.util.AEEditorPagStickerUtil.5
 * JD-Core Version:    0.7.0.1
 */