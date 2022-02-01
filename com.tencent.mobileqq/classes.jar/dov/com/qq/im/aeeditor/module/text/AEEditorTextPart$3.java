package dov.com.qq.im.aeeditor.module.text;

import com.tencent.tavcut.session.TAVCutSession;
import com.tencent.tavcut.session.TAVCutVideoSession;
import com.tencent.weseevideo.model.effect.StickerModel;

class AEEditorTextPart$3
  implements Runnable
{
  AEEditorTextPart$3(AEEditorTextPart paramAEEditorTextPart, TAVCutSession paramTAVCutSession, StickerModel paramStickerModel) {}
  
  public void run()
  {
    ((TAVCutVideoSession)this.jdField_a_of_type_ComTencentTavcutSessionTAVCutSession).addSticker(this.jdField_a_of_type_ComTencentWeseevideoModelEffectStickerModel);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.text.AEEditorTextPart.3
 * JD-Core Version:    0.7.0.1
 */