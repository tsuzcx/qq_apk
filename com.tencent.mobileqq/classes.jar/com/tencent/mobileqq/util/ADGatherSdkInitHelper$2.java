package com.tencent.mobileqq.util;

import com.tencent.ad.tangram.thread.AdThreadManager;
import com.tencent.gathererga.core.IExecutor;

final class ADGatherSdkInitHelper$2
  implements IExecutor
{
  public void a(Runnable paramRunnable)
  {
    AdThreadManager.INSTANCE.post(paramRunnable, 4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.util.ADGatherSdkInitHelper.2
 * JD-Core Version:    0.7.0.1
 */