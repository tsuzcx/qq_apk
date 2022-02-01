package com.tencent.mobileqq.nearby.now.impl;

import android.os.Handler;
import android.os.Message;

class StoryPlayControllerImpl$1
  extends Handler
{
  StoryPlayControllerImpl$1(StoryPlayControllerImpl paramStoryPlayControllerImpl) {}
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 1001)
    {
      StoryPlayControllerImpl localStoryPlayControllerImpl = this.a;
      StoryPlayControllerImpl.access$000(localStoryPlayControllerImpl, localStoryPlayControllerImpl.mCurrentIndex);
    }
    super.handleMessage(paramMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.impl.StoryPlayControllerImpl.1
 * JD-Core Version:    0.7.0.1
 */