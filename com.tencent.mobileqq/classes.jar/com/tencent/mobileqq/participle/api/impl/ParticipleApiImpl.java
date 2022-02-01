package com.tencent.mobileqq.participle.api.impl;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.participle.ParticipleHandler;
import com.tencent.mobileqq.participle.api.IParticipleApi;
import com.tencent.qphone.base.util.QLog;

public class ParticipleApiImpl
  implements IParticipleApi
{
  private static final String TAG = "ParticipleApiImpl";
  private ParticipleHandler mHandler;
  
  private ParticipleHandler getHandler(AppInterface paramAppInterface)
  {
    if (this.mHandler == null) {
      try
      {
        if (this.mHandler == null) {
          this.mHandler = ((ParticipleHandler)paramAppInterface.getBusinessHandler(ParticipleHandler.class.getName()));
        }
      }
      finally {}
    }
    return this.mHandler;
  }
  
  public void participleTheContent(AppInterface paramAppInterface, String paramString)
  {
    participleTheContent(paramAppInterface, paramString, "");
  }
  
  public void participleTheContent(AppInterface paramAppInterface, String paramString1, String paramString2)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("participleTheContent : content -> ");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(", senderUin -> ");
      localStringBuilder.append(paramString2);
      QLog.d("ParticipleApiImpl", 2, localStringBuilder.toString());
    }
    getHandler(paramAppInterface).a(paramAppInterface, paramString1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.participle.api.impl.ParticipleApiImpl
 * JD-Core Version:    0.7.0.1
 */