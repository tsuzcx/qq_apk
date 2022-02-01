package com.tencent.mobileqq.profilecard.api.impl;

import com.tencent.mobileqq.profilecard.api.IProfileHandlerApi;
import com.tencent.mobileqq.profilecard.handler.ProfileCardHandler;
import com.tencent.mobileqq.profilecommon.handler.ProfileCommonHandler;

public class ProfileHandlerApiImpl
  implements IProfileHandlerApi
{
  private static final String PROFILE_CARD_HANDLER = ProfileCardHandler.class.getName();
  private static final String PROFILE_COMMON_HANDLER = ProfileCommonHandler.class.getName();
  
  public String getProfileCardHandler()
  {
    return PROFILE_CARD_HANDLER;
  }
  
  public String getProfileCommonHandler()
  {
    return PROFILE_COMMON_HANDLER;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.api.impl.ProfileHandlerApiImpl
 * JD-Core Version:    0.7.0.1
 */