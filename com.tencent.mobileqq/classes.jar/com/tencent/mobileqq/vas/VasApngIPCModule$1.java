package com.tencent.mobileqq.vas;

import com.tencent.image.URLDrawableHandler;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;

class VasApngIPCModule$1
  implements EIPCResultCallback
{
  VasApngIPCModule$1(VasApngIPCModule paramVasApngIPCModule, URLDrawableHandler paramURLDrawableHandler) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    this.this$0.load(this.val$urlDrawableHandler, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.vas.VasApngIPCModule.1
 * JD-Core Version:    0.7.0.1
 */