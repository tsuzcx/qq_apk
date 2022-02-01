package com.tencent.mobileqq.profilesetting.api;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.ArrayList;

@QAPI(process={""})
public abstract interface IProfileSettingApi
  extends QRouteApi
{
  public static final int ALL_NOT_VISIBLE_STATE = 2;
  public static final int FIELD_PRIVACY_CONSTELLATION = 41609;
  public static final int INVALID_STATE = -1;
  
  public abstract int getProfileDisplaySettingStateFromCard(int paramInt, Card paramCard, AppInterface paramAppInterface);
  
  public abstract int getProfileSettingStateFromCard(int paramInt, Card paramCard);
  
  public abstract boolean reqGetCardDisplaySetting(AppInterface paramAppInterface, ArrayList<Integer> paramArrayList);
  
  public abstract void requestProfileSettingState(AppInterface paramAppInterface, ArrayList<Integer> paramArrayList);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.profilesetting.api.IProfileSettingApi
 * JD-Core Version:    0.7.0.1
 */