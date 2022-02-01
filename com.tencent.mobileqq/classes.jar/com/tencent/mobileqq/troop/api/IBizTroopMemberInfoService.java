package com.tencent.mobileqq.troop.api;

import android.graphics.drawable.Drawable;
import com.tencent.biz.ProtoUtils.TroopProtocolObserver;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.troop.TroopMemberCard;
import com.tencent.mobileqq.qroute.annotation.Service;
import com.tencent.mobileqq.troop.data.HWTroopMemberCard;
import mqq.app.api.IRuntimeService;

@Service(process={""})
public abstract interface IBizTroopMemberInfoService
  extends IRuntimeService
{
  public abstract void asynSaveHomeworkTroopMemberIdentity(String paramString1, String paramString2, String paramString3, int paramInt, String paramString4, String paramString5);
  
  public abstract boolean getCalendarNoticeTroopMember(String paramString1, String paramString2, long paramLong, ProtoUtils.TroopProtocolObserver paramTroopProtocolObserver);
  
  public abstract HWTroopMemberCard getHWTroopMemberCard(String paramString1, String paramString2);
  
  public abstract MessageRecord getRobotLastSpeakMessage(String paramString1, String paramString2);
  
  public abstract TroopMemberCard getTroopMemberCard(String paramString1, String paramString2);
  
  public abstract double getTroopMemberDiatanceToSelf(String paramString1, String paramString2);
  
  public abstract Drawable getTroopMemberLevelDrawable(int paramInt, String paramString);
  
  public abstract String getTroopMemberNickNoEmpty(String paramString1, String paramString2);
  
  public abstract void handleAgreeJion(String paramString1, String paramString2, String paramString3);
  
  public abstract void saveHWTroopMemberCard(String paramString1, String paramString2, HWTroopMemberCard paramHWTroopMemberCard);
  
  public abstract void saveHomeworkTroopMemberIdentity(String paramString1, String paramString2, String paramString3, int paramInt, String paramString4, String paramString5);
  
  public abstract boolean saveTroopMemberGlamourLevel(String paramString1, String paramString2, int paramInt);
  
  public abstract boolean saveTroopMemberHotChatGlamourLevel(String paramString1, String paramString2, int paramInt1, int paramInt2);
  
  public abstract void saveTroopMemberLevelDrawable(int paramInt, String paramString, Drawable paramDrawable);
  
  public abstract boolean saveTroopMemberSpearkFlag(String paramString1, String paramString2, byte paramByte);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.troop.api.IBizTroopMemberInfoService
 * JD-Core Version:    0.7.0.1
 */