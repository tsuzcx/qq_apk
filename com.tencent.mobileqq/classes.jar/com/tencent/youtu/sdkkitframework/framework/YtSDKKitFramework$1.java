package com.tencent.youtu.sdkkitframework.framework;

import com.tencent.youtu.sdkkitframework.common.YtSDKStats;

class YtSDKKitFramework$1
  implements Runnable
{
  YtSDKKitFramework$1(YtSDKKitFramework paramYtSDKKitFramework) {}
  
  public void run()
  {
    YtSDKStats.getInstance().reset();
    YtFSM.getInstance().reset();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.youtu.sdkkitframework.framework.YtSDKKitFramework.1
 * JD-Core Version:    0.7.0.1
 */