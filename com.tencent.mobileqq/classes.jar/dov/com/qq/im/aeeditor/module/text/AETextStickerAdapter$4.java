package dov.com.qq.im.aeeditor.module.text;

import bpam;
import bpkf;
import dov.com.qq.im.aeeditor.manage.AEEditorPagStickerConfig;

public class AETextStickerAdapter$4
  implements Runnable
{
  public AETextStickerAdapter$4(bpkf parambpkf, boolean paramBoolean, AEEditorPagStickerConfig paramAEEditorPagStickerConfig, AEEditorTextBean paramAEEditorTextBean) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      if (this.jdField_a_of_type_DovComQqImAeeditorManageAEEditorPagStickerConfig != null) {
        AEEditorTextBean.updateTextBeanByStickerConfig(this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorTextBean, this.jdField_a_of_type_DovComQqImAeeditorManageAEEditorPagStickerConfig);
      }
      return;
    }
    bpam.d("AETextStickerAdapter", "[onGetPagStickerConfig] succeeded failed");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.text.AETextStickerAdapter.4
 * JD-Core Version:    0.7.0.1
 */