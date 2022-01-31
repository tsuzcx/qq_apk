package com.tencent.youtu.sdkkitframework.framework;

public class TimeoutState
  extends YtFSMBaseState
{
  public void enter()
  {
    super.enter();
    YtFSM.getInstance().sendFSMEvent(new TimeoutState.1(this));
    YtFSM.getInstance().transitNow(YtSDKKitCommon.StateNameHelper.classNameOfState(YtSDKKitCommon.StateNameHelper.StateClassName.IDLE_STATE));
  }
  
  public void enterFirst() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.youtu.sdkkitframework.framework.TimeoutState
 * JD-Core Version:    0.7.0.1
 */