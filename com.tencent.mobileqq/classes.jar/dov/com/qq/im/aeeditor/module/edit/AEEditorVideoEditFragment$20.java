package dov.com.qq.im.aeeditor.module.edit;

import android.graphics.Bitmap;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.tavcut.session.TAVCutVideoSession;
import com.tencent.tavcut.session.callback.FrameExtractCallback;
import com.tencent.weseevideo.model.MediaModel;
import com.tencent.weseevideo.model.ModelExtKt;
import com.tencent.weseevideo.model.effect.MediaEffectModel;
import com.tencent.weseevideo.model.effect.MusicModel;

class AEEditorVideoEditFragment$20
  implements FrameExtractCallback
{
  AEEditorVideoEditFragment$20(AEEditorVideoEditFragment paramAEEditorVideoEditFragment, TAVCutVideoSession paramTAVCutVideoSession, String paramString1, String paramString2, String paramString3) {}
  
  public void onExtractCanceled()
  {
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.release();
  }
  
  public void onExtractFailed()
  {
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.release();
  }
  
  public void onFrameExtracted(Bitmap paramBitmap)
  {
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.release();
    FileUtils.a(paramBitmap, this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_DovComQqImAeeditorModuleEditAEEditorVideoEditFragment.b();
    if (ModelExtKt.isLightTemplate(this.jdField_a_of_type_DovComQqImAeeditorModuleEditAEEditorVideoEditFragment.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.getMediaModel()))
    {
      this.jdField_a_of_type_DovComQqImAeeditorModuleEditAEEditorVideoEditFragment.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.getMediaModel().getMediaEffectModel().getMusicModel().setBgmVolume(this.jdField_a_of_type_DovComQqImAeeditorModuleEditAEEditorVideoEditFragment.b);
      this.jdField_a_of_type_DovComQqImAeeditorModuleEditAEEditorVideoEditFragment.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.getMediaModel().getMediaEffectModel().getMusicModel().setVolume(this.jdField_a_of_type_DovComQqImAeeditorModuleEditAEEditorVideoEditFragment.jdField_a_of_type_Float);
    }
    this.jdField_a_of_type_DovComQqImAeeditorModuleEditAEEditorVideoEditFragment.a(this.b, this.jdField_a_of_type_JavaLangString, this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.edit.AEEditorVideoEditFragment.20
 * JD-Core Version:    0.7.0.1
 */