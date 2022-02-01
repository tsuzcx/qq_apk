package com.tencent.mobileqq.qqguildsdk.wrapper;

import com.tencent.gprosdk.GProEnterChannleInfoResult;
import com.tencent.mobileqq.qqguildsdk.data.IEnterChannleInfoResult;

class GProSdkWrapperImpl$34
  implements IEnterChannleInfoResult
{
  GProSdkWrapperImpl$34(GProSdkWrapperImpl paramGProSdkWrapperImpl, GProEnterChannleInfoResult paramGProEnterChannleInfoResult) {}
  
  public byte[] a()
  {
    return this.a.getTrtcSig();
  }
  
  public byte[] b()
  {
    return this.a.getPKey();
  }
  
  public int c()
  {
    return this.a.getAppId();
  }
  
  public boolean d()
  {
    return this.a.getDefaultMute();
  }
  
  public boolean e()
  {
    return this.a.getGlobalMute();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.34
 * JD-Core Version:    0.7.0.1
 */