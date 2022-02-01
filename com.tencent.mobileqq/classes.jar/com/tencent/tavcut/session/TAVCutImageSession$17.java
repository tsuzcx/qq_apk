package com.tencent.tavcut.session;

import android.text.TextUtils;
import com.tencent.weseevideo.model.MediaModel;
import com.tencent.weseevideo.model.WSTemplateManager;
import com.tencent.weseevideo.model.effect.MediaEffectModel;
import java.util.List;

class TAVCutImageSession$17
  implements Runnable
{
  TAVCutImageSession$17(TAVCutImageSession paramTAVCutImageSession, int paramInt, String paramString1, String paramString2) {}
  
  public void run()
  {
    Object localObject = (MediaModel)this.this$0.mediaModels.get(this.val$index);
    ((MediaModel)localObject).getMediaEffectModel().putParam("FRAME_PARAMS_KEY_IS_ON", "1");
    ((MediaModel)localObject).getMediaEffectModel().putParam("FRAME_PARAMS_KEY_COLOR", this.val$color);
    WSTemplateManager.updateTemplate((MediaModel)localObject, 2, this.val$templateDir, true, new String[] { "ae_editor_board_template.json" });
    localObject = this.this$0;
    int i = this.val$index;
    if (!TextUtils.isEmpty(this.val$templateDir)) {}
    for (boolean bool = true;; bool = false)
    {
      TAVCutImageSession.access$500((TAVCutImageSession)localObject, i, 2, bool);
      this.this$0.render(this.val$index);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tavcut.session.TAVCutImageSession.17
 * JD-Core Version:    0.7.0.1
 */