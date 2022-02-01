package com.tencent.mobileqq.utils;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.debug.EnvSwitchActivity;

final class AudioHelper$2
  implements Runnable
{
  AudioHelper$2(AppInterface paramAppInterface) {}
  
  public void run()
  {
    int i = -1;
    if (AudioHelper.d()) {
      if (!EnvSwitchActivity.isTestEnvironment()) {
        break label26;
      }
    }
    label26:
    for (i = 1;; i = 0)
    {
      AudioHelper.a(this.a, i);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.utils.AudioHelper.2
 * JD-Core Version:    0.7.0.1
 */