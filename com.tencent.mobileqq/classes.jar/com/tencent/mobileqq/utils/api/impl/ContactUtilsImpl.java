package com.tencent.mobileqq.utils.api.impl;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.api.IContactUtils;
import mqq.app.AppRuntime;

public class ContactUtilsImpl
  implements IContactUtils
{
  public String getAccountNickName(AppInterface paramAppInterface, String paramString)
  {
    if ((paramAppInterface instanceof QQAppInterface)) {
      return ContactUtils.e((QQAppInterface)paramAppInterface, paramString);
    }
    return null;
  }
  
  public String getBuddyNickName(AppRuntime paramAppRuntime, String paramString, boolean paramBoolean)
  {
    return ContactUtils.b(paramAppRuntime, paramString, paramBoolean);
  }
  
  public String getFriendNickName(AppInterface paramAppInterface, String paramString)
  {
    if ((paramAppInterface instanceof QQAppInterface)) {
      return ContactUtils.c((QQAppInterface)paramAppInterface, paramString);
    }
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.utils.api.impl.ContactUtilsImpl
 * JD-Core Version:    0.7.0.1
 */