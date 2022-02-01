package com.tencent.mobileqq.flashshow.part;

import android.os.Handler;
import com.tencent.biz.richframework.delegate.impl.RFThreadManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.winkpublish.api.IUploadTaskManager;

class FSMainChipPart$1
  implements Runnable
{
  FSMainChipPart$1(FSMainChipPart paramFSMainChipPart) {}
  
  public void run()
  {
    ((IUploadTaskManager)QRoute.api(IUploadTaskManager.class)).restore();
    RFThreadManager.getSerialThreadHandler().postDelayed(this.this$0.a, 30000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.part.FSMainChipPart.1
 * JD-Core Version:    0.7.0.1
 */