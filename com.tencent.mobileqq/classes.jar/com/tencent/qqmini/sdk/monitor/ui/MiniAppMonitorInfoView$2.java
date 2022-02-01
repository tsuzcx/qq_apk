package com.tencent.qqmini.sdk.monitor.ui;

import com.tencent.qqmini.sdk.launcher.core.BaseRuntime;
import com.tencent.qqmini.sdk.launcher.core.action.Action;

final class MiniAppMonitorInfoView$2
  implements Action<Long>
{
  public Long perform(BaseRuntime paramBaseRuntime)
  {
    return Long.valueOf(paramBaseRuntime.getCurrentDrawCount());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.monitor.ui.MiniAppMonitorInfoView.2
 * JD-Core Version:    0.7.0.1
 */