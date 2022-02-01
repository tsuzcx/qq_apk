package com.tencent.tavcut.session;

import com.tencent.tavcut.aekit.PreSegModel;
import com.tencent.weseevideo.model.MediaModel;
import com.tencent.weseevideo.model.effect.MediaEffectModel;
import com.tencent.weseevideo.model.resource.MediaClipModel;
import com.tencent.weseevideo.model.resource.MediaResourceModel;
import com.tencent.weseevideo.model.resource.VideoResourceModel;
import java.util.List;

class TAVCutImageSession$37
  implements Runnable
{
  TAVCutImageSession$37(TAVCutImageSession paramTAVCutImageSession, int paramInt, String paramString) {}
  
  public void run()
  {
    PreSegModel localPreSegModel = new PreSegModel();
    localPreSegModel.setIndex(this.jdField_a_of_type_Int);
    localPreSegModel.setSegMaterial(this.jdField_a_of_type_JavaLangString);
    localPreSegModel.setOriginPic(((MediaClipModel)((MediaModel)this.this$0.getMediaModels().get(this.jdField_a_of_type_Int)).getMediaResourceModel().getVideos().get(0)).getResource().getPath());
    ((MediaModel)this.this$0.mediaModels.get(this.jdField_a_of_type_Int)).getMediaEffectModel().setPreSegModel(localPreSegModel);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tavcut.session.TAVCutImageSession.37
 * JD-Core Version:    0.7.0.1
 */