package com.tencent.mobileqq.vas.hippy.api.impl;

import com.tencent.mobileqq.vas.hippy.api.IVasHippyApi;
import com.tencent.mtt.hippy.HippyAPIProvider;
import com.tencent.mtt.hippy.uimanager.HippyCustomViewCreator;

public class VasHippyApiImpl
  implements IVasHippyApi
{
  public HippyAPIProvider createHippyAPIProvider()
  {
    return new VasApiProvider();
  }
  
  public HippyCustomViewCreator createHippyCustomViewCreator()
  {
    return new VasViewCreator();
  }
  
  public boolean isVasModule(String paramString)
  {
    return ("QQVip".equals(paramString)) || ("qqgxh".equals(paramString)) || ("qqdhy".equals(paramString)) || ("QQVipPay".equals(paramString)) || ("qqMiniGame".equals(paramString)) || ("qqYellowDiamond".equals(paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.hippy.api.impl.VasHippyApiImpl
 * JD-Core Version:    0.7.0.1
 */