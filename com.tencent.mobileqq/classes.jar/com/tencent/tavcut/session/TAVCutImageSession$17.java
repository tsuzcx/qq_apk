package com.tencent.tavcut.session;

import com.tencent.weseevideo.model.MediaModel;
import com.tencent.weseevideo.model.WSTemplateManager;
import com.tencent.weseevideo.model.effect.GestureModel;
import com.tencent.weseevideo.model.effect.MediaEffectModel;
import java.util.List;

class TAVCutImageSession$17
  implements Runnable
{
  TAVCutImageSession$17(TAVCutImageSession paramTAVCutImageSession, int paramInt, String paramString1, String paramString2) {}
  
  public void run()
  {
    MediaModel localMediaModel = (MediaModel)this.this$0.mediaModels.get(this.val$index);
    localMediaModel.getMediaEffectModel().putParam("FRAME_PARAMS_KEY_IS_ON", "1");
    localMediaModel.getMediaEffectModel().putParam("FRAME_PARAMS_KEY_COLOR", this.val$color);
    localMediaModel.getMediaEffectModel().getGestureModel().reset();
    WSTemplateManager.updateTemplate(localMediaModel, 2, this.val$templateDir, true, new String[] { "ae_editor_board_template.json" });
    TAVCutImageSession.access$600(this.this$0, this.val$index, true);
    this.this$0.render(this.val$index);
    this.this$0.setBasePicActive(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tavcut.session.TAVCutImageSession.17
 * JD-Core Version:    0.7.0.1
 */