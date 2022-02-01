package com.tencent.tavcut.session;

import android.util.SparseArray;
import com.tencent.tavcut.util.DurationUtil;
import com.tencent.weseevideo.composition.image.WSImageRender;

class TAVCutImageSession$23
  implements Runnable
{
  TAVCutImageSession$23(TAVCutImageSession paramTAVCutImageSession) {}
  
  public void run()
  {
    DurationUtil.start("TAVCutImageSession release");
    int i = 0;
    while (i < TAVCutImageSession.access$300(this.this$0).size())
    {
      int j = TAVCutImageSession.access$300(this.this$0).keyAt(i);
      ((WSImageRender)TAVCutImageSession.access$300(this.this$0).get(j)).release();
      i += 1;
    }
    TAVCutImageSession.access$300(this.this$0).clear();
    TAVCutImageSession.access$200(this.this$0).clear();
    TAVCutImageSession.access$700(this.this$0).clear();
    DurationUtil.end("TAVCutImageSession release");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tavcut.session.TAVCutImageSession.23
 * JD-Core Version:    0.7.0.1
 */