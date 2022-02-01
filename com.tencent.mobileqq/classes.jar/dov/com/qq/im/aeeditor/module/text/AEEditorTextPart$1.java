package dov.com.qq.im.aeeditor.module.text;

import com.tencent.tavcut.bean.TextEditorData;
import com.tencent.tavcut.session.TAVCutSession;
import dov.com.qq.im.ae.util.AEQLog;

class AEEditorTextPart$1
  implements AEEditorTextEditDialog.IAEEditorStickerBack
{
  AEEditorTextPart$1(AEEditorTextPart paramAEEditorTextPart, TextEditorData paramTextEditorData, TAVCutSession paramTAVCutSession) {}
  
  public void a(TextEditorData paramTextEditorData)
  {
    if (paramTextEditorData != null)
    {
      this.jdField_a_of_type_ComTencentTavcutBeanTextEditorData.setContent(paramTextEditorData.getContent());
      this.jdField_a_of_type_ComTencentTavcutBeanTextEditorData.setTextColor(paramTextEditorData.getTextColor());
      this.jdField_a_of_type_ComTencentTavcutSessionTAVCutSession.updateTextSticker(this.jdField_a_of_type_ComTencentTavcutBeanTextEditorData);
      if (AEEditorTextPart.a(this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorTextPart) != null)
      {
        AEEditorTextPart.a(this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorTextPart).a(this.jdField_a_of_type_ComTencentTavcutBeanTextEditorData);
        AEQLog.a("AEEditorTextPart", "[stickerInfo] update");
      }
      return;
    }
    AEQLog.d("AEEditorTextPart", "update sticker back null.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.text.AEEditorTextPart.1
 * JD-Core Version:    0.7.0.1
 */