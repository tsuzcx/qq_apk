package com.tencent.tavcut.session;

import android.util.SparseArray;
import com.tencent.weseevideo.composition.image.WSImageRender;

class TAVCutSession$5
  implements Runnable
{
  TAVCutSession$5(TAVCutSession paramTAVCutSession, int paramInt) {}
  
  public void run()
  {
    this.this$0.currentIndex = this.val$currentIndex;
    if ((this.this$0 instanceof TAVCutImageSession))
    {
      TAVCutImageSession localTAVCutImageSession = (TAVCutImageSession)this.this$0;
      if (localTAVCutImageSession.getImageRenderers().size() > 0)
      {
        int i = 0;
        while (i < localTAVCutImageSession.getImageRenderers().size())
        {
          WSImageRender localWSImageRender = (WSImageRender)localTAVCutImageSession.getImageRenderers().get(i);
          if (localWSImageRender != null)
          {
            localWSImageRender.setCurrent(this.val$currentIndex);
            localWSImageRender.setMineIndex(i);
          }
          i += 1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tavcut.session.TAVCutSession.5
 * JD-Core Version:    0.7.0.1
 */