package com.tencent.mobileqq.persistence.bridge.verify.interceptor;

import com.tencent.biz.pubaccount.accountdetail.api.IPublicAccountDynamicInfoEntity;
import com.tencent.biz.pubaccount.api.IPublicAccountProxy;
import com.tencent.biz.pubaccount.readinjoyAd.ad.materialdownload.MaterialData;
import com.tencent.biz.qqstory.settings.QQStoryUserInfo;
import com.tencent.gamecenter.wadl.biz.entity.GameNoticeInfo;
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
import com.tencent.mobileqq.apollo.model.ApolloActionData;
import com.tencent.mobileqq.apollo.model.ApolloActionRecentData;
import com.tencent.mobileqq.apollo.model.ApolloBaseInfo;
import com.tencent.mobileqq.apollo.model.ApolloGameData;
import com.tencent.mobileqq.apollo.model.ApolloObtainedActionData;
import com.tencent.mobileqq.apollo.model.ApolloPreDownloadData;
import com.tencent.mobileqq.apollo.model.ApolloWhiteFaceID;
import com.tencent.mobileqq.apollo.statistics.trace.data.TraceData;
import com.tencent.mobileqq.app.qqdaily.FrontBackData;
import com.tencent.mobileqq.bubble.BubbleDiyEntity;
import com.tencent.mobileqq.businessCard.data.BusinessCard;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.config.operation.QQOperationTaskRecord;
import com.tencent.mobileqq.config.operation.QQOperationViopTipTask;
import com.tencent.mobileqq.config.operation.QQOperationVoipTipsTaskExcuteRecord;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.DiscussionMemberInfo;
import com.tencent.mobileqq.data.EmoticonKeywords;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.data.entitymanager.Interceptor.Chain;
import com.tencent.mobileqq.data.qzone.FeedInfo;
import com.tencent.mobileqq.data.troop.CommonlyUsedTroop;
import com.tencent.mobileqq.data.troop.TroopMemberCardInfo;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.doutu.DoutuData;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.fts.data.troop.FTSNewTroopSync;
import com.tencent.mobileqq.fts.data.troop.FTSTroopSync;
import com.tencent.mobileqq.fts.data.troop.FTSTroopTime;
import com.tencent.mobileqq.gamecenter.data.PadFaceAd;
import com.tencent.mobileqq.gamecenter.msginfo.GameUserInfo;
import com.tencent.mobileqq.guild.data.ChannelMsgEvent;
import com.tencent.mobileqq.guild.message.GuildMsgSeqTimeItem;
import com.tencent.mobileqq.guild.temp.api.IGuildFeatureAdapterApi;
import com.tencent.mobileqq.hotpic.HotPicData;
import com.tencent.mobileqq.hotpic.HotPicSendData;
import com.tencent.mobileqq.hotpic.HotPicTagInfo;
import com.tencent.mobileqq.hotpic.HotVideoData;
import com.tencent.mobileqq.kandian.biz.common.api.IReadInJoyHelper;
import com.tencent.mobileqq.kandian.repo.feeds.entity.QuestionSquareBean;
import com.tencent.mobileqq.microapp.apkg.AppInfo;
import com.tencent.mobileqq.mini.api.QQMiniManager;
import com.tencent.mobileqq.multimsg.MultiMsgNick;
import com.tencent.mobileqq.profile.ProfileShoppingPhotoInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.Reporting;
import com.tencent.mobileqq.tofumsg.TofuItem;
import com.tencent.mobileqq.tofumsg.TofuLimitMsg;
import com.tencent.mobileqq.troop.data.GroupSystemMsgOldData;
import com.tencent.mobileqq.troop.data.ShowExternalTroop;
import com.tencent.mobileqq.troop.data.TroopAIOAppInfo;
import com.tencent.mobileqq.troop.data.TroopAIONotifyItem;
import com.tencent.mobileqq.troop.data.TroopAioKeyBlackRule;
import com.tencent.mobileqq.troop.data.TroopAioKeywordTipInfo;
import com.tencent.mobileqq.troop.data.TroopAioTopADInfo;
import com.tencent.mobileqq.troop.data.TroopGiftBagInfo;
import com.tencent.mobileqq.troop.data.TroopTipsEntity;
import com.tencent.mobileqq.troop.essence.data.TroopEssenceMsgItem;
import com.tencent.mobileqq.troop.onlinemember.data.TroopAllOnlineData;
import com.tencent.mobileqq.troop.recommend.data.NotificationRecommendTroopItem;
import com.tencent.mobileqq.troop.recommend.data.RecentRecommendTroopItem;
import com.tencent.mobileqq.troop.troopapps.data.FullListGroupAppEntity;
import com.tencent.mobileqq.troop.troopapps.data.GrayGroupAppEntity;
import com.tencent.mobileqq.troop.troopapps.data.TroopAppInfo;
import com.tencent.mobileqq.troop.troopgame.MemberGradeLevelInfo;
import com.tencent.mobileqq.vashealth.api.IQQHealthApi;
import com.tencent.qidian.data.BmqqAccountType;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qzonehub.model.QZoneMsgEntityNew;

public class CommonTableColumnCheckInterceptor
  extends FindTableClassInterceptor
{
  private final Class[] a = { MultiMsgNick.class, FTSTroopSync.class, Reporting.class, BusinessCard.class, FTSTroopTime.class, DoutuData.class, QQOperationViopTipTask.class, HotPicTagInfo.class, BmqqAccountType.class, QQOperationTaskRecord.class, QQOperationVoipTipsTaskExcuteRecord.class, TroopNotificationCache.class, TroopAIOAppInfo.class, ((IReadInJoyHelper)QRoute.api(IReadInJoyHelper.class)).getReadInJoyActivityDAUInfo(), HotPicData.class, HotVideoData.class, ProfileShoppingPhotoInfo.class, DrawerPushItem.class, TroopAioKeyBlackRule.class, TroopAioKeywordTipInfo.class, TroopAllOnlineData.class, ((IPublicAccountProxy)QRoute.api(IPublicAccountProxy.class)).getImplClass(IPublicAccountDynamicInfoEntity.class), DiyPendantEntity.class, ApolloObtainedActionData.class, BlessPtvModule.class, BlessWording.class, QQStoryUserInfo.class, ((IQQHealthApi)QRoute.api(IQQHealthApi.class)).getTracePathDataClass(), ((IQQHealthApi)QRoute.api(IQQHealthApi.class)).getTracePointDataClass(), HotPicSendData.class, TroopTipsEntity.class, BubbleDiyEntity.class, TroopGiftBagInfo.class, HotChatInfo.class, ApolloGameData.class, EmoticonKeywords.class, BlessTask.class, ApolloActionRecentData.class, TroopAioTopADInfo.class, NotificationRecommendTroopItem.class, FTSNewTroopSync.class, ((IReadInJoyHelper)QRoute.api(IReadInJoyHelper.class)).getGuideDataClazz(), FeedInfo.class, BeancurdMsg.class, APIQuotaEntity.class, AppInfo.class, QuestionSquareBean.class, ApolloActionData.class, QZoneMsgEntityNew.class, ApolloPreDownloadData.class, ApolloBaseInfo.class, TraceData.class, PadFaceAd.class, GameNoticeInfo.class, ExtensionInfo.class, ApolloWhiteFaceID.class, ColorNote.class, FrontBackData.class, StickerRecommendEntity.class, StickerRecommendSortEntity.class, TofuItem.class, TroopEssenceMsgItem.class, MaterialData.class, TroopMemberInfo.class, MemberGradeLevelInfo.class, TroopMemberCardInfo.class, CommonlyUsedTroop.class, ShowExternalTroop.class, QQMiniManager.getMiniAppEntityClass(), QQMiniManager.getDesktopCardEntityClass(), QQMiniManager.getDeskTopAppEntityClass(), FullListGroupAppEntity.class, GrayGroupAppEntity.class, TroopAppInfo.class, TroopAIONotifyItem.class, RecentRecommendTroopItem.class, GroupSystemMsgOldData.class, DiscussionMemberInfo.class, DiscussionInfo.class, GuildMsgSeqTimeItem.class, TofuLimitMsg.class, GameUserInfo.class, ((IGuildFeatureAdapterApi)QRoute.api(IGuildFeatureAdapterApi.class)).getGuildMessageNavigateInfoClass(), ChannelMsgEvent.class, FileManagerEntity.class };
  
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
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("com.tencent.mobileqq.data.");
      ((StringBuilder)localObject).append(paramString);
      localObject = Class.forName(((StringBuilder)localObject).toString());
      return localObject;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      Object localObject;
      label31:
      break label31;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("find unknown table: ");
    ((StringBuilder)localObject).append(paramString);
    QLog.d("CommonInterceptor", 1, ((StringBuilder)localObject).toString());
    return null;
  }
  
  public Class a(Interceptor.Chain paramChain)
  {
    paramChain = b(paramChain);
    Class localClass = a(paramChain);
    if ((localClass != null) && (QLog.isColorLevel()))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("check table: ");
      localStringBuilder.append(paramChain);
      localStringBuilder.append(" / ");
      localStringBuilder.append(localClass.getName());
      QLog.d("CommonInterceptor", 1, localStringBuilder.toString());
    }
    return localClass;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.persistence.bridge.verify.interceptor.CommonTableColumnCheckInterceptor
 * JD-Core Version:    0.7.0.1
 */