package com.tencent.mobileqq.profilesetting.api.impl;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profilesetting.CardSettingHandler;
import com.tencent.mobileqq.profilesetting.ProfileSettingUtils;
import com.tencent.mobileqq.profilesetting.ProfileSettingUtils.Companion;
import com.tencent.mobileqq.profilesetting.api.IProfileSettingApi;
import java.util.ArrayList;

public class ProfileSettingApiImpl
  implements IProfileSettingApi
{
  public int getProfileDisplaySettingStateFromCard(int paramInt, Card paramCard, AppInterface paramAppInterface)
  {
    return ProfileSettingUtils.a.a(paramInt, paramCard, (QQAppInterface)paramAppInterface);
  }
  
  public int getProfileSettingStateFromCard(int paramInt, Card paramCard)
  {
    return ProfileSettingUtils.a.a(paramInt, paramCard, null);
  }
  
  public boolean reqGetCardDisplaySetting(AppInterface paramAppInterface, ArrayList<Integer> paramArrayList)
  {
    if (paramAppInterface != null)
    {
      paramAppInterface = (CardSettingHandler)paramAppInterface.getBusinessHandler(BusinessHandlerFactory.CARD_SETTING_HANDLER);
      if (paramAppInterface != null)
      {
        paramArrayList = new ArrayList();
        paramArrayList.add(Integer.valueOf(42425));
        paramAppInterface.a(paramArrayList);
        return true;
      }
    }
    return false;
  }
  
  public void requestProfileSettingState(AppInterface paramAppInterface, ArrayList<Integer> paramArrayList)
  {
    paramAppInterface = (CardSettingHandler)paramAppInterface.getBusinessHandler(BusinessHandlerFactory.CARD_SETTING_HANDLER);
    if (paramAppInterface != null) {
      paramAppInterface.a(paramArrayList);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.profilesetting.api.impl.ProfileSettingApiImpl
 * JD-Core Version:    0.7.0.1
 */