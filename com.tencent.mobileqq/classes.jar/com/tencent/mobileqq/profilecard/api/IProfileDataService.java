package com.tencent.mobileqq.profilecard.api;

import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.ContactCard;
import com.tencent.mobileqq.qroute.annotation.Service;
import mqq.app.api.IRuntimeService;

@Service(process={"all"})
public abstract interface IProfileDataService
  extends IRuntimeService
{
  public abstract ContactCard getContactCardByMobileNo(String paramString, boolean paramBoolean);
  
  public abstract Card getProfileCard(String paramString, boolean paramBoolean);
  
  public abstract Card getProfileCardFromCache(String paramString);
  
  public abstract boolean saveContactCard(ContactCard paramContactCard);
  
  public abstract boolean saveProfileCard(Card paramCard);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.api.IProfileDataService
 * JD-Core Version:    0.7.0.1
 */