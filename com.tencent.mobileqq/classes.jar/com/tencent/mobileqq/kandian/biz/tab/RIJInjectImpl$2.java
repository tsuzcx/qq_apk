package com.tencent.mobileqq.kandian.biz.tab;

import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;

final class RIJInjectImpl$2
  implements Runnable
{
  public void run()
  {
    try
    {
      ReadInJoyUtils.f();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.tab.RIJInjectImpl.2
 * JD-Core Version:    0.7.0.1
 */