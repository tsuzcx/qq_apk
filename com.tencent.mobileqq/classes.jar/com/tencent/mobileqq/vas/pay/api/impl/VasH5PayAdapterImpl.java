package com.tencent.mobileqq.vas.pay.api.impl;

import com.tencent.mobileqq.vas.pay.api.IVasH5PayAdapter;

public class VasH5PayAdapterImpl
  implements IVasH5PayAdapter
{
  public String getDiyCardH5Pay()
  {
    return "diyCardH5Pay";
  }
  
  public String getSvipCallbackSN()
  {
    return "svip";
  }
  
  public long getWebViewTransparentConstants()
  {
    return 524288L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.pay.api.impl.VasH5PayAdapterImpl
 * JD-Core Version:    0.7.0.1
 */