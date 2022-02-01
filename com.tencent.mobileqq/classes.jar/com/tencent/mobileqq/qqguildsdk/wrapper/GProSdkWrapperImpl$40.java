package com.tencent.mobileqq.qqguildsdk.wrapper;

import com.tencent.gprosdk.GProResult;
import com.tencent.mobileqq.qqguildsdk.data.IGProResultInfo;
import com.tencent.mobileqq.qqguildsdk.util.GProConvert;

class GProSdkWrapperImpl$40
  implements IGProResultInfo
{
  GProSdkWrapperImpl$40(GProSdkWrapperImpl paramGProSdkWrapperImpl, GProResult paramGProResult) {}
  
  public String a()
  {
    return GProConvert.a(this.a.getMemberTid());
  }
  
  public int b()
  {
    return this.a.getResult();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.40
 * JD-Core Version:    0.7.0.1
 */