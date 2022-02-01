package dov.com.qq.im.aeeditor.module.text;

import dov.com.qq.im.ae.util.AEQLog;
import dov.com.qq.im.aeeditor.manage.AEEditorPagStickerConfig;

class AETextStickerAdapter$4
  implements Runnable
{
  AETextStickerAdapter$4(AETextStickerAdapter paramAETextStickerAdapter, boolean paramBoolean, AEEditorPagStickerConfig paramAEEditorPagStickerConfig, AEEditorTextBean paramAEEditorTextBean) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      if (this.jdField_a_of_type_DovComQqImAeeditorManageAEEditorPagStickerConfig != null) {
        AEEditorTextBean.updateTextBeanByStickerConfig(this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorTextBean, this.jdField_a_of_type_DovComQqImAeeditorManageAEEditorPagStickerConfig);
      }
      return;
    }
    AEQLog.d("AETextStickerAdapter", "[onGetPagStickerConfig] succeeded failed");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.text.AETextStickerAdapter.4
 * JD-Core Version:    0.7.0.1
 */