package com.tencent.tavcut.session;

import com.tencent.weseevideo.model.MediaModel;
import com.tencent.weseevideo.model.ModelExtKt;
import java.util.List;

class TAVCutImageSession$19
  implements Runnable
{
  TAVCutImageSession$19(TAVCutImageSession paramTAVCutImageSession, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    ModelExtKt.updateFrameColor((MediaModel)this.this$0.mediaModels.get(this.val$index), this.val$color);
    this.this$0.render(this.val$index);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tavcut.session.TAVCutImageSession.19
 * JD-Core Version:    0.7.0.1
 */