package com.tencent.tavcut.session;

import android.os.Handler;
import android.util.SparseArray;
import com.tencent.tavcut.util.DurationUtil;
import com.tencent.tavcut.view.ext.OnRenderFinishListener;
import com.tencent.weseevideo.composition.image.AssetImageGenerator.ImageGeneratorThread;

class TAVCutImageSession$26
  implements Runnable
{
  TAVCutImageSession$26(TAVCutImageSession paramTAVCutImageSession, int paramInt, OnRenderFinishListener paramOnRenderFinishListener) {}
  
  public void run()
  {
    if (TAVCutImageSession.access$400(this.this$0).get(this.jdField_a_of_type_Int) == null)
    {
      OnRenderFinishListener localOnRenderFinishListener = this.jdField_a_of_type_ComTencentTavcutViewExtOnRenderFinishListener;
      if (localOnRenderFinishListener != null) {
        localOnRenderFinishListener.a();
      }
      return;
    }
    if ((this.this$0.renderChainManagers.get(this.jdField_a_of_type_Int) == null) || (TAVCutImageSession.access$900(this.this$0).get(this.jdField_a_of_type_Int) == null))
    {
      DurationUtil.start("initRenderEnvironment");
      TAVCutImageSession.access$1000(this.this$0, this.jdField_a_of_type_Int);
      DurationUtil.end("initRenderEnvironment");
    }
    TAVCutImageSession.access$1200(this.this$0).getHandler().post(new TAVCutImageSession.26.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tavcut.session.TAVCutImageSession.26
 * JD-Core Version:    0.7.0.1
 */