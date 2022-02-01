package com.tencent.mobileqq.troop.api.impl;

import com.tencent.mobileqq.troop.announcement.api.impl.TroopAnnouncementHandler;
import com.tencent.mobileqq.troop.api.ITroopHandlerNameApi;
import com.tencent.mobileqq.troop.association.handler.TroopAssociationHandler;
import com.tencent.mobileqq.troop.clockin.handler.TroopClockInHandler;
import com.tencent.mobileqq.troop.essence.handler.TroopEssenceMsgHandler;
import com.tencent.mobileqq.troop.fans.handler.TroopFansHandler;
import com.tencent.mobileqq.troop.handler.TroopAddFriendHandler;
import com.tencent.mobileqq.troop.handler.TroopAvatarHandler;
import com.tencent.mobileqq.troop.handler.TroopBatchInfoHandler;
import com.tencent.mobileqq.troop.handler.TroopCommonlyUsedHandler;
import com.tencent.mobileqq.troop.handler.TroopInfoExtHandler;
import com.tencent.mobileqq.troop.handler.TroopInfoHandler;
import com.tencent.mobileqq.troop.handler.TroopListHandler;
import com.tencent.mobileqq.troop.handler.TroopMemberCardHandler;
import com.tencent.mobileqq.troop.handler.TroopMemberInfoHandler;
import com.tencent.mobileqq.troop.handler.TroopMemberListHandler;
import com.tencent.mobileqq.troop.handler.TroopMemberMngHandler;
import com.tencent.mobileqq.troop.handler.TroopMngHandler;
import com.tencent.mobileqq.troop.handler.TroopModifyHandler;
import com.tencent.mobileqq.troop.handler.TroopNotificationHandler;
import com.tencent.mobileqq.troop.handler.TroopPushHandler;
import com.tencent.mobileqq.troop.handler.TroopTokenHandler;
import com.tencent.mobileqq.troop.homework.handler.HomeworkHandler;
import com.tencent.mobileqq.troop.honor.handler.TroopHonorHandler;
import com.tencent.mobileqq.troop.luckycharacter.api.impl.TroopLuckyCharacterHandler;
import com.tencent.mobileqq.troop.onlinemember.handler.TroopOnlineMemberHandler;
import com.tencent.mobileqq.troop.onlinepush.api.impl.TroopOnlinePushHandler;
import com.tencent.mobileqq.troop.recommend.handler.TroopRecommendHandler;
import com.tencent.mobileqq.troop.roamsetting.RoamSettingHandler;
import com.tencent.mobileqq.troop.robot.api.impl.TroopRobotHandler;
import com.tencent.mobileqq.troop.showexternal.api.impl.TroopShowExternalHandler;
import com.tencent.mobileqq.troop.troopanonymous.TroopAnonymousHandler;
import com.tencent.mobileqq.troop.troopapps.api.impl.TroopAppHandler;
import com.tencent.mobileqq.troop.troopaudit.handler.TroopAuditHandler;
import com.tencent.mobileqq.troop.troopconfig.api.impl.TroopConfigHandler;
import com.tencent.mobileqq.troop.troopfee.handler.TroopFeeHandler;
import com.tencent.mobileqq.troop.troopgag.api.impl.TroopGagHandler;
import com.tencent.mobileqq.troop.troopgame.handler.TroopGameHandler;
import com.tencent.mobileqq.troop.troopmanager.api.impl.TroopManagerBizHandler;
import com.tencent.mobileqq.troop.troopmemberlevel.handler.TroopMemberLevelHandler;
import com.tencent.mobileqq.troop.troopmessage.handler.TroopMessageHandler;
import com.tencent.mobileqq.troop.troopnotification.handler.TroopAioNotifyHandler;
import com.tencent.mobileqq.troop.troopphoto.api.impl.TroopPhotoHandler;
import com.tencent.mobileqq.troop.troopreddot.handler.TroopRedDotHandler;
import com.tencent.mobileqq.troop.troopsetting.api.impl.TroopSettingHandler;
import com.tencent.mobileqq.troop.troopsurvey.handler.TroopSurveyHandler;

public class TroopHandlerNameApiImpl
  implements ITroopHandlerNameApi
{
  public String getTroopAddFriendHandlerName()
  {
    return TroopAddFriendHandler.class.getName();
  }
  
  public String getTroopAioNotifyHandlerName()
  {
    return TroopAioNotifyHandler.class.getName();
  }
  
  public String getTroopAnnouncementHandlerName()
  {
    return TroopAnnouncementHandler.class.getName();
  }
  
  public String getTroopAnonymousHandlerName()
  {
    return TroopAnonymousHandler.class.getName();
  }
  
  public String getTroopAppHandlerName()
  {
    return TroopAppHandler.class.getName();
  }
  
  public String getTroopAssociationHandlerName()
  {
    return TroopAssociationHandler.class.getName();
  }
  
  public String getTroopAuditHandlerName()
  {
    return TroopAuditHandler.class.getName();
  }
  
  public String getTroopAvatarHandlerName()
  {
    return TroopAvatarHandler.class.getName();
  }
  
  public String getTroopBatchInfoHandlerName()
  {
    return TroopBatchInfoHandler.class.getName();
  }
  
  public String getTroopClockInHandlerName()
  {
    return TroopClockInHandler.class.getName();
  }
  
  public String getTroopCommonlyUsedHandlerName()
  {
    return TroopCommonlyUsedHandler.class.getName();
  }
  
  public String getTroopConfigHandlerName()
  {
    return TroopConfigHandler.class.getName();
  }
  
  public String getTroopEssenceHandlerName()
  {
    return TroopEssenceMsgHandler.class.getName();
  }
  
  public String getTroopFansHandlerName()
  {
    return TroopFansHandler.class.getName();
  }
  
  public String getTroopFeeHandlerName()
  {
    return TroopFeeHandler.class.getName();
  }
  
  public String getTroopGagHandlerName()
  {
    return TroopGagHandler.class.getName();
  }
  
  public String getTroopGameHandlerName()
  {
    return TroopGameHandler.class.getName();
  }
  
  public String getTroopHomeworkHandlerName()
  {
    return HomeworkHandler.class.getName();
  }
  
  public String getTroopHonorHandlerName()
  {
    return TroopHonorHandler.class.getName();
  }
  
  public String getTroopInfoExtHandlerName()
  {
    return TroopInfoExtHandler.class.getName();
  }
  
  public String getTroopInfoHandlerName()
  {
    return TroopInfoHandler.class.getName();
  }
  
  public String getTroopListHandlerName()
  {
    return TroopListHandler.class.getName();
  }
  
  public String getTroopLuckyCharacterHandlerName()
  {
    return TroopLuckyCharacterHandler.class.getName();
  }
  
  public String getTroopManagerBizHandlerName()
  {
    return TroopManagerBizHandler.class.getName();
  }
  
  public String getTroopMemberCardHandlerName()
  {
    return TroopMemberCardHandler.class.getName();
  }
  
  public String getTroopMemberInfoHandlerName()
  {
    return TroopMemberInfoHandler.class.getName();
  }
  
  public String getTroopMemberLevelHandlerName()
  {
    return TroopMemberLevelHandler.class.getName();
  }
  
  public String getTroopMemberListHandlerName()
  {
    return TroopMemberListHandler.class.getName();
  }
  
  public String getTroopMemberMngHandlerName()
  {
    return TroopMemberMngHandler.class.getName();
  }
  
  public String getTroopMessageHandlerName()
  {
    return TroopMessageHandler.class.getName();
  }
  
  public String getTroopMngHandlerName()
  {
    return TroopMngHandler.class.getName();
  }
  
  public String getTroopModifyHandlerName()
  {
    return TroopModifyHandler.class.getName();
  }
  
  public String getTroopNotificationHandlerName()
  {
    return TroopNotificationHandler.class.getName();
  }
  
  public String getTroopOnlineMemberHandlerName()
  {
    return TroopOnlineMemberHandler.class.getName();
  }
  
  public String getTroopOnlinePushHandlerName()
  {
    return TroopOnlinePushHandler.class.getName();
  }
  
  public String getTroopPhotoHandlerName()
  {
    return TroopPhotoHandler.class.getName();
  }
  
  public String getTroopPushHandlerName()
  {
    return TroopPushHandler.class.getName();
  }
  
  public String getTroopRecommendHandlerName()
  {
    return TroopRecommendHandler.class.getName();
  }
  
  public String getTroopRedDotHandlerName()
  {
    return TroopRedDotHandler.class.getName();
  }
  
  public String getTroopRoamSettingHandlerName()
  {
    return RoamSettingHandler.class.getName();
  }
  
  public String getTroopRobotHandlerName()
  {
    return TroopRobotHandler.class.getName();
  }
  
  public String getTroopSettingHandlerName()
  {
    return TroopSettingHandler.class.getName();
  }
  
  public String getTroopShowExternalHandlerName()
  {
    return TroopShowExternalHandler.class.getName();
  }
  
  public String getTroopSurveyHandlerName()
  {
    return TroopSurveyHandler.class.getName();
  }
  
  public String getTroopTokenHandlerName()
  {
    return TroopTokenHandler.class.getName();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.troop.api.impl.TroopHandlerNameApiImpl
 * JD-Core Version:    0.7.0.1
 */