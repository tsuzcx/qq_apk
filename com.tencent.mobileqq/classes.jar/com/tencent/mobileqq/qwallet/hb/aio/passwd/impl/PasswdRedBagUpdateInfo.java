package com.tencent.mobileqq.qwallet.hb.aio.passwd.impl;

public class PasswdRedBagUpdateInfo
{
  public long a;
  public int b;
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject instanceof PasswdRedBagUpdateInfo))
    {
      paramObject = (PasswdRedBagUpdateInfo)paramObject;
      if ((paramObject.b == this.b) && (paramObject.a == this.a)) {
        return true;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.aio.passwd.impl.PasswdRedBagUpdateInfo
 * JD-Core Version:    0.7.0.1
 */