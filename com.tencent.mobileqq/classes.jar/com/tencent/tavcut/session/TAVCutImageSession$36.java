package com.tencent.tavcut.session;

import android.util.SparseArray;
import com.tencent.tavcut.aekit.PreSegModel;
import com.tencent.weseevideo.composition.VideoRenderChainManager;
import com.tencent.weseevideo.model.MediaModel;
import com.tencent.weseevideo.model.effect.MediaEffectModel;
import com.tencent.weseevideo.model.resource.MediaClipModel;
import com.tencent.weseevideo.model.resource.MediaResourceModel;
import com.tencent.weseevideo.model.resource.VideoResourceModel;
import java.util.List;

class TAVCutImageSession$36
  implements Runnable
{
  TAVCutImageSession$36(TAVCutImageSession paramTAVCutImageSession, int paramInt, String paramString) {}
  
  public void run()
  {
    Object localObject = new PreSegModel();
    ((PreSegModel)localObject).setIndex(this.jdField_a_of_type_Int);
    ((PreSegModel)localObject).setSegMaterial(this.jdField_a_of_type_JavaLangString);
    ((PreSegModel)localObject).setOriginPic(((MediaClipModel)((MediaModel)this.this$0.getMediaModels().get(this.jdField_a_of_type_Int)).getMediaResourceModel().getVideos().get(0)).getResource().getPath());
    ((MediaModel)this.this$0.mediaModels.get(this.jdField_a_of_type_Int)).getMediaEffectModel().setPreSegModel((PreSegModel)localObject);
    localObject = this.this$0;
    ((TAVCutImageSession)localObject).updateRenderChain((VideoRenderChainManager)((TAVCutImageSession)localObject).renderChainManagers.get(this.jdField_a_of_type_Int), ((MediaModel)this.this$0.mediaModels.get(this.jdField_a_of_type_Int)).getMediaEffectModel(), false);
    this.this$0.render(this.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tavcut.session.TAVCutImageSession.36
 * JD-Core Version:    0.7.0.1
 */