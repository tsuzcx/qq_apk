package com.tencent.tavcut.session;

import android.graphics.Bitmap;
import android.support.annotation.Nullable;
import com.tencent.weseevideo.composition.image.WSImageRender.ImageRenderCallback;

class TAVCutImageSession$22$1
  implements WSImageRender.ImageRenderCallback
{
  TAVCutImageSession$22$1(TAVCutImageSession.22 param22) {}
  
  public void onCompletion(@Nullable Bitmap paramBitmap)
  {
    this.this$1.this$0.runOnMainThread(new TAVCutImageSession.22.1.1(this, paramBitmap));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tavcut.session.TAVCutImageSession.22.1
 * JD-Core Version:    0.7.0.1
 */