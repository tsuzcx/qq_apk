package com.tencent.mobileqq.utils.api.impl;

import com.tencent.mobileqq.utils.SecurityUtile;
import com.tencent.mobileqq.utils.api.ISecurityUtile;

public class SecurityUtileImpl
  implements ISecurityUtile
{
  public String encode(String paramString)
  {
    return SecurityUtile.encode(paramString);
  }
  
  public byte[] encode(byte[] paramArrayOfByte)
  {
    return SecurityUtile.encode(paramArrayOfByte);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.utils.api.impl.SecurityUtileImpl
 * JD-Core Version:    0.7.0.1
 */