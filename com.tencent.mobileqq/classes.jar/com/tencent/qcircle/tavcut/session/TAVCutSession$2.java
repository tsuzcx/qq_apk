package com.tencent.qcircle.tavcut.session;

import android.content.Context;
import com.tencent.qcircle.weseevideo.editor.sticker.dispatcher.StickerEventDispatcher;

class TAVCutSession$2
  implements Runnable
{
  TAVCutSession$2(TAVCutSession paramTAVCutSession, Context paramContext) {}
  
  public void run()
  {
    TAVCutSession localTAVCutSession = this.this$0;
    localTAVCutSession.context = this.val$context;
    localTAVCutSession.stickerEventListener = new TAVCutSession.2.1(this);
    StickerEventDispatcher.getInstance().addStickerEventListener(this.this$0.stickerEventListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qcircle.tavcut.session.TAVCutSession.2
 * JD-Core Version:    0.7.0.1
 */