package com.tencent.qcircle.tavcut.session;

import android.graphics.Bitmap;
import android.graphics.PointF;
import android.support.annotation.Nullable;
import com.tencent.qcircle.weseevideo.composition.image.WSImageRender.ImageRenderCallback;
import java.util.List;

class TAVCutImageSession$27$1$1
  implements WSImageRender.ImageRenderCallback
{
  TAVCutImageSession$27$1$1(TAVCutImageSession.27.1 param1) {}
  
  public void onCompletion(@Nullable Bitmap paramBitmap, @Nullable List<PointF> paramList)
  {
    this.this$2.this$1.this$0.runOnMainThread(new TAVCutImageSession.27.1.1.1(this, paramBitmap, paramList));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qcircle.tavcut.session.TAVCutImageSession.27.1.1
 * JD-Core Version:    0.7.0.1
 */