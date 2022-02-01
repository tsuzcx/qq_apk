package com.tencent.mobileqq.troop.api.troopcreate.impl;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troop.api.troopcreate.IQQBase;
import com.tencent.mobileqq.utils.ContactUtils;
import mqq.app.AppRuntime;

public class QQBaseImpl
  implements IQQBase
{
  public String getAccountNickName(AppInterface paramAppInterface, String paramString)
  {
    if ((paramAppInterface instanceof QQAppInterface)) {
      return ContactUtils.f((QQAppInterface)paramAppInterface, paramString);
    }
    return null;
  }
  
  public int getAnimationTypeR2L()
  {
    return 2;
  }
  
  public int getBackButtonSideL()
  {
    return 0;
  }
  
  public String getHeaderText(String paramString)
  {
    return ContactUtils.b(paramString);
  }
  
  public void onCreate(AppRuntime paramAppRuntime) {}
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.api.troopcreate.impl.QQBaseImpl
 * JD-Core Version:    0.7.0.1
 */