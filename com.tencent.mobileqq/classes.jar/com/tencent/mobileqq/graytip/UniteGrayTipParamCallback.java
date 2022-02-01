package com.tencent.mobileqq.graytip;

import com.tencent.imcore.message.MsgProxyUtils;

public class UniteGrayTipParamCallback
  implements UniteGrayTipParam.Callback
{
  public boolean a(int paramInt)
  {
    return MsgProxyUtils.d(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.graytip.UniteGrayTipParamCallback
 * JD-Core Version:    0.7.0.1
 */