package com.tencent.mobileqq.flashshow.part;

import android.os.Handler;
import com.tencent.biz.richframework.delegate.impl.RFThreadManager;
import com.tencent.mobileqq.winkpublish.IPublishQueueListener;
import com.tencent.mobileqq.winkpublish.IQueueTask;
import com.tencent.qphone.base.util.QLog;

class FSPublishStatusBoxPart$3
  implements IPublishQueueListener
{
  FSPublishStatusBoxPart$3(FSPublishStatusBoxPart paramFSPublishStatusBoxPart) {}
  
  public void onProgressChanged(IQueueTask paramIQueueTask)
  {
    QLog.e("FSPublishStatusBoxPart", 1, "mPublishQueueListener:onProgressChanged");
    if (paramIQueueTask == null) {
      return;
    }
    RFThreadManager.getUIHandler().post(new FSPublishStatusBoxPart.3.2(this, paramIQueueTask));
  }
  
  public void onQueueChanged()
  {
    RFThreadManager.getUIHandler().post(new FSPublishStatusBoxPart.3.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.part.FSPublishStatusBoxPart.3
 * JD-Core Version:    0.7.0.1
 */