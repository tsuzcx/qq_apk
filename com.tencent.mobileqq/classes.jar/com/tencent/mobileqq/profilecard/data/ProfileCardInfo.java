package com.tencent.mobileqq.profilecard.data;

import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.ContactCard;
import com.tencent.mobileqq.data.troop.QQGuildMemberCard;
import com.tencent.mobileqq.data.troop.TroopMemberCard;
import com.tencent.mobileqq.profilecard.entity.IProfileBusinessInfo;
import com.tencent.mobileqq.profilecard.template.ProfileCardTemplate;
import com.tencent.mobileqq.unifiedname.MQQProfileName;
import java.util.HashMap;
import java.util.Map;

public class ProfileCardInfo
{
  private static final String TAG = "ProfileCardInfo";
  public AllInOne allInOne;
  private Map<Class<? extends IProfileBusinessInfo>, IProfileBusinessInfo> businessInfoMap;
  public Card card;
  public ContactCard contactCard;
  public long curUseStyleId;
  public long curUseTemplateVersion;
  public ProfileCardTemplate currentTemplate;
  public QQGuildMemberCard guildMemberCard;
  public boolean isNetRet;
  public boolean isQQGuildCard;
  public boolean isTimeOut;
  public boolean isTroopMemberCard;
  public String[] nameArray;
  public MQQProfileName profileName;
  public int troopGlamourLevel = -1;
  public TroopMemberCard troopMemberCard;
  public String troopRecentSaid;
  public boolean troopShowMoreBtn;
  public String troopUin = "";
  
  public <T extends IProfileBusinessInfo> T getBusinessInfo(Class<? extends IProfileBusinessInfo> paramClass)
  {
    Object localObject = this.businessInfoMap;
    if (localObject != null) {
      localObject = (IProfileBusinessInfo)((Map)localObject).get(paramClass);
    } else {
      localObject = null;
    }
    if (localObject == null)
    {
      Card localCard = this.card;
      if (localCard != null) {
        localObject = localCard.getBusinessInfo(paramClass);
      }
    }
    if (localObject != null) {
      return localObject;
    }
    return null;
  }
  
  public void putBusinessInfo(IProfileBusinessInfo paramIProfileBusinessInfo)
  {
    if (this.businessInfoMap == null) {
      this.businessInfoMap = new HashMap();
    }
    this.businessInfoMap.put(paramIProfileBusinessInfo.getClass(), paramIProfileBusinessInfo);
  }
  
  public final void removeBusinessInfo(Class<? extends IProfileBusinessInfo> paramClass)
  {
    Map localMap = this.businessInfoMap;
    if (localMap == null) {
      return;
    }
    localMap.remove(paramClass);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.data.ProfileCardInfo
 * JD-Core Version:    0.7.0.1
 */