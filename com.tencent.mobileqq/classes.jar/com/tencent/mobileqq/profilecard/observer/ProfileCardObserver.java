package com.tencent.mobileqq.profilecard.observer;

import com.tencent.mobileqq.data.Card;

public class ProfileCardObserver
  implements ICardObserver
{
  public static final int TYPE_GET_PROFILE_CARD = 1001;
  public static final int TYPE_GET_PROFILE_DETAIL = 1002;
  public static final int TYPE_SET_PROFILE_DETAIL = 1003;
  private static final int TYPE_START_DEFINE = 1000;
  
  protected void onGetProfileCard(boolean paramBoolean, Object paramObject) {}
  
  protected void onGetProfileDetail(boolean paramBoolean, String paramString, Card paramCard) {}
  
  protected void onSetProfileDetail(boolean paramBoolean, int paramInt, Card paramCard) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    switch (paramInt)
    {
    default: 
    case 1001: 
    case 1002: 
      do
      {
        return;
        onGetProfileCard(paramBoolean, paramObject);
        return;
      } while (!paramBoolean);
      paramObject = (Card)paramObject;
      onGetProfileDetail(paramBoolean, paramObject.uin, paramObject);
      return;
    }
    paramObject = (Object[])paramObject;
    onSetProfileDetail(paramBoolean, ((Integer)paramObject[0]).intValue(), (Card)paramObject[1]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.observer.ProfileCardObserver
 * JD-Core Version:    0.7.0.1
 */