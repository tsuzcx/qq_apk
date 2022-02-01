package com.tencent.mobileqq.kandian.biz.framework.handlers;

import com.tencent.aelight.camera.util.api.IQIMShortVideoUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.qroute.QRoute;

class VideoHandler$10
  implements Runnable
{
  VideoHandler$10(VideoHandler paramVideoHandler) {}
  
  public void run()
  {
    if (BaseApplicationImpl.sProcessId != 9) {
      ((IQIMShortVideoUtil)QRoute.api(IQIMShortVideoUtil.class)).preLoadPeakProcess(BaseApplicationImpl.getContext());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.framework.handlers.VideoHandler.10
 * JD-Core Version:    0.7.0.1
 */