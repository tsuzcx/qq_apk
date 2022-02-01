package com.tencent.mobileqq.kandian.biz.pts.network;

import com.tencent.pts.core.PTSComposer;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class PTSGeneralRequestModule$handleReceivePtsData$1
  implements Runnable
{
  PTSGeneralRequestModule$handleReceivePtsData$1(PTSComposer paramPTSComposer, String paramString) {}
  
  public final void run()
  {
    PTSComposer localPTSComposer = this.a;
    if (localPTSComposer != null) {
      localPTSComposer.updateData(this.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.network.PTSGeneralRequestModule.handleReceivePtsData.1
 * JD-Core Version:    0.7.0.1
 */