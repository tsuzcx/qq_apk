package com.tencent.tavcut.session;

import android.content.Context;
import com.tencent.weseevideo.editor.sticker.dispatcher.StickerEventDispatcher;

class TAVCutSession$2
  implements Runnable
{
  TAVCutSession$2(TAVCutSession paramTAVCutSession, Context paramContext) {}
  
  public void run()
  {
    this.this$0.context = this.val$context;
    this.this$0.stickerEventListener = new TAVCutSession.2.1(this);
    StickerEventDispatcher.getInstance().addStickerEventListener(this.this$0.stickerEventListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tavcut.session.TAVCutSession.2
 * JD-Core Version:    0.7.0.1
 */