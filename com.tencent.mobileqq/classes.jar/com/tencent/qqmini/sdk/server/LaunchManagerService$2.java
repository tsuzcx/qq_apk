package com.tencent.qqmini.sdk.server;

import java.util.Comparator;
import java.util.List;

class LaunchManagerService$2
  implements Comparator<LaunchManagerService.MiniAppSubProcessorInfo>
{
  LaunchManagerService$2(LaunchManagerService paramLaunchManagerService) {}
  
  public int compare(LaunchManagerService.MiniAppSubProcessorInfo paramMiniAppSubProcessorInfo1, LaunchManagerService.MiniAppSubProcessorInfo paramMiniAppSubProcessorInfo2)
  {
    return -(paramMiniAppSubProcessorInfo1.allMiniAppInfo.size() - paramMiniAppSubProcessorInfo2.allMiniAppInfo.size());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.server.LaunchManagerService.2
 * JD-Core Version:    0.7.0.1
 */