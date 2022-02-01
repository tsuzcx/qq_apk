package com.tencent.mobileqq.mini.api.impl;

import com.tencent.mobileqq.mini.api.IMiniCmdService;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil;

public class MiniCmdServiceImpl
  implements IMiniCmdService
{
  public void createUpdatableMsg(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, String paramString3, int paramInt4, byte[] paramArrayOfByte, MiniAppCmdInterface paramMiniAppCmdInterface)
  {
    MiniAppCmdUtil.getInstance().createUpdatableMsg(paramString1, paramString2, paramInt1, paramInt2, paramInt3, paramString3, paramInt4, paramArrayOfByte, paramMiniAppCmdInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.mini.api.impl.MiniCmdServiceImpl
 * JD-Core Version:    0.7.0.1
 */