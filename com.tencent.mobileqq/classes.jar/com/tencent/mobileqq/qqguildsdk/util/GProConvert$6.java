package com.tencent.mobileqq.qqguildsdk.util;

import com.tencent.gprosdk.GProJoinCondition;
import com.tencent.mobileqq.qqguildsdk.data.appchannel.IAccountCondition;
import com.tencent.mobileqq.qqguildsdk.data.appchannel.IJoinCondition;

final class GProConvert$6
  implements IJoinCondition
{
  GProConvert$6(GProJoinCondition paramGProJoinCondition) {}
  
  public IAccountCondition a()
  {
    return GProConvert.a(this.a.getAccountCondition());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.util.GProConvert.6
 * JD-Core Version:    0.7.0.1
 */