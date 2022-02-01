package com.tencent.qcircle.tavcut.session;

import android.util.SparseArray;
import com.tencent.qcircle.weseevideo.composition.image.WSImageRender;

class TAVCutSession$6
  implements Runnable
{
  TAVCutSession$6(TAVCutSession paramTAVCutSession, int paramInt) {}
  
  public void run()
  {
    Object localObject = this.this$0;
    ((TAVCutSession)localObject).currentIndex = this.val$currentIndex;
    if ((localObject instanceof TAVCutImageSession))
    {
      localObject = (TAVCutImageSession)localObject;
      if (((TAVCutImageSession)localObject).getImageRenderers().size() > 0)
      {
        int i = 0;
        while (i < ((TAVCutImageSession)localObject).getImageRenderers().size())
        {
          WSImageRender localWSImageRender = (WSImageRender)((TAVCutImageSession)localObject).getImageRenderers().get(i);
          i += 1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qcircle.tavcut.session.TAVCutSession.6
 * JD-Core Version:    0.7.0.1
 */