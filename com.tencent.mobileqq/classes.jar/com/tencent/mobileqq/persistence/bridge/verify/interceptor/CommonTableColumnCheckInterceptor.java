package com.tencent.mobileqq.persistence.bridge.verify.interceptor;

import com.tencent.biz.pubaccount.AccountDetail.bean.DynamicInfoEntity;
import com.tencent.biz.pubaccount.readinjoy.data.ReadInJoyActivityDAUInfo;
import com.tencent.biz.pubaccount.readinjoy.question.bean.QuestionSquareBean;
import com.tencent.biz.pubaccount.readinjoy.skin.GuideData;
import com.tencent.biz.pubaccount.readinjoyAd.ad.materialdownload.MaterialData;
import com.tencent.biz.qqstory.settings.QQStoryUserInfo;
import com.tencent.mobileqq.Doraemon.monitor.APIQuotaEntity;
import com.tencent.mobileqq.DrawerPushItem;
import com.tencent.mobileqq.activity.TroopNotificationCache;
import com.tencent.mobileqq.activity.aio.BeancurdMsg;
import com.tencent.mobileqq.activity.aio.stickerrecommended.StickerRecommendEntity;
import com.tencent.mobileqq.activity.aio.stickerrecommended.StickerRecommendSortEntity;
import com.tencent.mobileqq.activity.bless.BlessPtvModule;
import com.tencent.mobileqq.activity.bless.BlessTask;
import com.tencent.mobileqq.activity.bless.BlessWording;
import com.tencent.mobileqq.addon.DiyPendantEntity;
import com.tencent.mobileqq.apollo.api.model.ApolloActionData;
import com.tencent.mobileqq.apollo.api.model.ApolloActionRecentData;
import com.tencent.mobileqq.apollo.api.model.ApolloBaseInfo;
import com.tencent.mobileqq.apollo.api.model.ApolloGameData;
import com.tencent.mobileqq.apollo.api.model.ApolloGameRedDot;
import com.tencent.mobileqq.apollo.api.model.ApolloObtainedActionData;
import com.tencent.mobileqq.apollo.api.model.ApolloPreDownloadData;
import com.tencent.mobileqq.apollo.api.model.ApolloWhiteFaceID;
import com.tencent.mobileqq.apollo.api.model.CmGamePushItem;
import com.tencent.mobileqq.apollo.api.statistics.trace.data.TraceData;
import com.tencent.mobileqq.app.qqdaily.FrontBackData;
import com.tencent.mobileqq.ar.model.ArDownloadInfo;
import com.tencent.mobileqq.bubble.BubbleDiyEntity;
import com.tencent.mobileqq.businessCard.data.BusinessCard;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.config.operation.QQOperationTaskRecord;
import com.tencent.mobileqq.config.operation.QQOperationViopTipTask;
import com.tencent.mobileqq.config.operation.QQOperationVoipTipsTaskExcuteRecord;
import com.tencent.mobileqq.data.EmoticonKeywords;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.data.entitymanager.Interceptor.Chain;
import com.tencent.mobileqq.data.fts.FTSNewTroopSync;
import com.tencent.mobileqq.data.fts.FTSTroopSync;
import com.tencent.mobileqq.data.fts.FTSTroopTime;
import com.tencent.mobileqq.data.qzone.FeedInfo;
import com.tencent.mobileqq.data.troop.CommonlyUsedTroop;
import com.tencent.mobileqq.data.troop.TroopMemberCardInfo;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.doutu.DoutuData;
import com.tencent.mobileqq.gamecenter.data.GameNoticeInfo;
import com.tencent.mobileqq.gamecenter.data.PadFaceAd;
import com.tencent.mobileqq.gamecenter.message.GameUserInfo;
import com.tencent.mobileqq.hotpic.HotPicData;
import com.tencent.mobileqq.hotpic.HotPicSendData;
import com.tencent.mobileqq.hotpic.HotPicTagInfo;
import com.tencent.mobileqq.hotpic.HotVideoData;
import com.tencent.mobileqq.microapp.apkg.AppInfo;
import com.tencent.mobileqq.mini.api.QQMiniManager;
import com.tencent.mobileqq.multimsg.MultiMsgNick;
import com.tencent.mobileqq.nearby.gameroom.RecentInviteUser;
import com.tencent.mobileqq.nearby.interestTag.InterestTagInfo;
import com.tencent.mobileqq.ocr.data.OcrRecogResult;
import com.tencent.mobileqq.profile.ProfileShoppingPhotoInfo;
import com.tencent.mobileqq.shortvideo.redbag.VideoRedbagData;
import com.tencent.mobileqq.statistics.Reporting;
import com.tencent.mobileqq.tofumsg.TofuItem;
import com.tencent.mobileqq.troop.api.essence.data.TroopEssenceMsgItem;
import com.tencent.mobileqq.troop.data.NotificationRecommendTroopItem;
import com.tencent.mobileqq.troop.data.ShowExternalTroop;
import com.tencent.mobileqq.troop.data.TroopAIOAppInfo;
import com.tencent.mobileqq.troop.data.TroopAioKeyBlackRule;
import com.tencent.mobileqq.troop.data.TroopAioKeywordTipInfo;
import com.tencent.mobileqq.troop.data.TroopAioTopADInfo;
import com.tencent.mobileqq.troop.data.TroopGiftBagInfo;
import com.tencent.mobileqq.troop.data.TroopTipsEntity;
import com.tencent.mobileqq.troop.troopgame.MemberGradeLevelInfo;
import com.tencent.mobileqq.trooponline.data.TroopAllOnlineData;
import com.tencent.qidian.data.BmqqAccountType;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.contentbox.model.QZoneMsgEntityNew;

public class CommonTableColumnCheckInterceptor
  extends FindTableClassInterceptor
{
  private final Class[] a = { MultiMsgNick.class, FTSTroopSync.class, Reporting.class, BusinessCard.class, FTSTroopTime.class, DoutuData.class, QQOperationViopTipTask.class, HotPicTagInfo.class, BmqqAccountType.class, QQOperationTaskRecord.class, QQOperationVoipTipsTaskExcuteRecord.class, TroopNotificationCache.class, TroopAIOAppInfo.class, ReadInJoyActivityDAUInfo.class, HotPicData.class, HotVideoData.class, ProfileShoppingPhotoInfo.class, DrawerPushItem.class, TroopAioKeyBlackRule.class, TroopAioKeywordTipInfo.class, TroopAllOnlineData.class, DynamicInfoEntity.class, DiyPendantEntity.class, ApolloObtainedActionData.class, RecentInviteUser.class, ApolloGameRedDot.class, InterestTagInfo.class, OcrRecogResult.class, ArDownloadInfo.class, BlessPtvModule.class, BlessWording.class, QQStoryUserInfo.class, HotPicSendData.class, TroopTipsEntity.class, BubbleDiyEntity.class, TroopGiftBagInfo.class, HotChatInfo.class, ApolloGameData.class, EmoticonKeywords.class, BlessTask.class, VideoRedbagData.class, ApolloActionRecentData.class, TroopAioTopADInfo.class, NotificationRecommendTroopItem.class, FTSNewTroopSync.class, GuideData.class, FeedInfo.class, BeancurdMsg.class, APIQuotaEntity.class, AppInfo.class, QuestionSquareBean.class, CmGamePushItem.class, ApolloActionData.class, QZoneMsgEntityNew.class, ApolloPreDownloadData.class, ApolloBaseInfo.class, TraceData.class, PadFaceAd.class, GameNoticeInfo.class, ExtensionInfo.class, ApolloWhiteFaceID.class, ColorNote.class, FrontBackData.class, StickerRecommendEntity.class, StickerRecommendSortEntity.class, TofuItem.class, TroopEssenceMsgItem.class, MaterialData.class, TroopMemberInfo.class, MemberGradeLevelInfo.class, TroopMemberCardInfo.class, CommonlyUsedTroop.class, GameUserInfo.class, ShowExternalTroop.class, QQMiniManager.getMiniAppEntityClass(), QQMiniManager.getDesktopCardEntityClass(), QQMiniManager.getDeskTopAppEntityClass() };
  
  private Class a(String paramString)
  {
    Class[] arrayOfClass = this.a;
    int j = arrayOfClass.length;
    int i = 0;
    while (i < j)
    {
      Class localClass = arrayOfClass[i];
      if (localClass.getSimpleName().equals(paramString)) {
        return localClass;
      }
      i += 1;
    }
    return b(paramString);
  }
  
  private Class b(String paramString)
  {
    try
    {
      Class localClass = Class.forName("com.tencent.mobileqq.data." + paramString);
      return localClass;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      QLog.d("CommonInterceptor", 1, "find unknown table: " + paramString);
    }
    return null;
  }
  
  public Class a(Interceptor.Chain paramChain)
  {
    paramChain = a(paramChain);
    Class localClass = a(paramChain);
    if ((localClass != null) && (QLog.isColorLevel())) {
      QLog.d("CommonInterceptor", 1, "check table: " + paramChain + " / " + localClass.getName());
    }
    return localClass;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.persistence.bridge.verify.interceptor.CommonTableColumnCheckInterceptor
 * JD-Core Version:    0.7.0.1
 */