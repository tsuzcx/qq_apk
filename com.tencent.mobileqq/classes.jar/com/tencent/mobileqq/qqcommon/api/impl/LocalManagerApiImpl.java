package com.tencent.mobileqq.qqcommon.api.impl;

import com.tencent.mobileqq.app.LocaleManager;
import com.tencent.mobileqq.qqcommon.api.ILocalManagerApi;

public class LocalManagerApiImpl
  implements ILocalManagerApi
{
  public boolean isLocaleCN()
  {
    return LocaleManager.a();
  }
  
  public boolean isLocaleUpdatedByUser()
  {
    return LocaleManager.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qqcommon.api.impl.LocalManagerApiImpl
 * JD-Core Version:    0.7.0.1
 */