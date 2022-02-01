package com.tencent.mobileqq.qqguildsdk.util;

import com.tencent.gprosdk.GProAccountCondition;
import com.tencent.mobileqq.qqguildsdk.data.appchannel.IAccountCondition;

final class GProConvert$7
  implements IAccountCondition
{
  GProConvert$7(GProAccountCondition paramGProAccountCondition) {}
  
  public long a()
  {
    return this.a.getClientId();
  }
  
  public boolean b()
  {
    return this.a.getIsNeedAuth();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.util.GProConvert.7
 * JD-Core Version:    0.7.0.1
 */