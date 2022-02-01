package com.tencent.mobileqq.qqgift.sso;

import com.tencent.qphone.base.util.QLog;

public abstract class GiftBaseSsoCallBack
{
  public abstract void a(int paramInt, QQGiftRspData paramQQGiftRspData);
  
  public void a(int paramInt, String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("sso call back fail [proxy error]");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(" error msg ");
      localStringBuilder.append(paramString);
      QLog.d("GiftBaseSsoCallBack", 2, localStringBuilder.toString());
    }
  }
  
  public void b(int paramInt, String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("sso call back fail [business error] ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(" error msg ");
      localStringBuilder.append(paramString);
      QLog.d("GiftBaseSsoCallBack", 2, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgift.sso.GiftBaseSsoCallBack
 * JD-Core Version:    0.7.0.1
 */