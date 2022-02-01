package com.tencent.mobileqq.troop.api.impl;

import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.mobileqq.troop.api.IAnonymousChatApi;

public class AnonymousChatApiImpl
  implements IAnonymousChatApi
{
  public boolean getAioAnonymousStatus(String paramString)
  {
    return AnonymousChatHelper.a().a(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.api.impl.AnonymousChatApiImpl
 * JD-Core Version:    0.7.0.1
 */