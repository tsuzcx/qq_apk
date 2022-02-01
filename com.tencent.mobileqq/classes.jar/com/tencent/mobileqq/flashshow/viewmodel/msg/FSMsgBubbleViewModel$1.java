package com.tencent.mobileqq.flashshow.viewmodel.msg;

import androidx.lifecycle.MutableLiveData;
import com.tencent.mobileqq.flashshow.api.IFlashShowRedPointService;
import com.tencent.mobileqq.qroute.QRoute;

class FSMsgBubbleViewModel$1
  implements Runnable
{
  FSMsgBubbleViewModel$1(FSMsgBubbleViewModel paramFSMsgBubbleViewModel) {}
  
  public void run()
  {
    FSMsgBubbleViewModel.a(this.this$0).postValue(((IFlashShowRedPointService)QRoute.api(IFlashShowRedPointService.class)).getBubbleRedPointInfo());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.viewmodel.msg.FSMsgBubbleViewModel.1
 * JD-Core Version:    0.7.0.1
 */