package com.tencent.mobileqq.imcore.config.extension;

import com.tencent.mobileqq.activity.recent.config.IRecentBaseDataProcessor;
import com.tencent.mobileqq.activity.recent.config.cache.AbsCacheProcessor;
import com.tencent.mobileqq.activity.recent.config.cache.CMGameProcessor;
import com.tencent.mobileqq.activity.recent.config.cache.CombineBusinessProcessor;
import com.tencent.mobileqq.activity.recent.config.cache.DeprecatedLogicProcessor;
import com.tencent.mobileqq.activity.recent.config.cache.HiddenChatProcessor;
import com.tencent.mobileqq.activity.recent.config.cache.KandianMergeProcessor;
import com.tencent.mobileqq.activity.recent.config.cache.MsgBoxProcessor;
import com.tencent.mobileqq.activity.recent.config.cache.NewFriendCacheProcessor;
import com.tencent.mobileqq.activity.recent.config.cache.PublicAccountAssistantProcessor;
import com.tencent.mobileqq.activity.recent.config.cache.PublicAccountProcessor;
import com.tencent.mobileqq.activity.recent.config.cache.TempGameMsgProcessor;
import com.tencent.mobileqq.activity.recent.config.cache.TroopProcessor;
import com.tencent.mobileqq.activity.recent.config.menu.BaseMenuFlag;
import com.tencent.mobileqq.activity.recent.config.menu.CommonMenuFlag;
import com.tencent.mobileqq.activity.recent.config.recentlist.base.IRecentListBaseProcessor;
import com.tencent.mobileqq.activity.recent.config.recentlist.recentcheckfilter.AdvertisementFilter;
import com.tencent.mobileqq.activity.recent.config.recentlist.recentcheckfilter.DiscussHiddenFilter;
import com.tencent.mobileqq.activity.recent.config.recentlist.recentcheckfilter.HotChatFilter;
import com.tencent.mobileqq.activity.recent.config.recentlist.recentcheckfilter.TempFilterBoxFilter;
import com.tencent.mobileqq.activity.recent.config.recentlist.recentcheckfilter.TempMsgBoxFilter;
import com.tencent.mobileqq.activity.recent.config.recentlist.recentconvert.BusinessConverter;
import com.tencent.mobileqq.activity.recent.config.recentlist.recentconvert.C2CLikeConverter;
import com.tencent.mobileqq.activity.recent.config.recentlist.recentconvert.SpecialConverter;
import com.tencent.mobileqq.activity.recent.config.recentlist.recentconvertfilter.ReadInJoyFilter;
import com.tencent.mobileqq.activity.recent.config.recentlist.recentconvertfilter.SubAccountAssistantFilter;
import com.tencent.mobileqq.activity.recent.config.recentlist.recentsort.RecentSortTopProcessor;
import com.tencent.mobileqq.activity.recent.config.recentlist.recentsort.RecentSortValueProcessor;
import com.tencent.mobileqq.activity.recent.config.statusIcon.AVGameStatus;
import com.tencent.mobileqq.activity.recent.config.statusIcon.DraftStatusIcon;
import com.tencent.mobileqq.activity.recent.config.statusIcon.ListenTogetherStatus;
import com.tencent.mobileqq.activity.recent.config.statusIcon.ShareLocationStatus;
import com.tencent.mobileqq.activity.recent.config.statusIcon.StudyRoomStatus;
import com.tencent.mobileqq.activity.recent.config.statusIcon.TogetherStatus;
import com.tencent.mobileqq.activity.recent.config.statusIcon.VideoStatus;
import com.tencent.mobileqq.qroute.annotation.ConfigInject;
import java.util.ArrayList;

public final class RecentCustomizedProcessorRegister
{
  @ConfigInject(configPath="IMCore/src/main/resources/Inject_IMCoreCustomizedConfig.yml", version=2)
  public static ArrayList<Class<? extends AbsCacheProcessor>> a = new ArrayList();
  @ConfigInject(configPath="IMCore/src/main/resources/Inject_IMCoreCustomizedConfig.yml", version=1)
  public static ArrayList<Class<? extends IRecentBaseDataProcessor>> b;
  @ConfigInject(configPath="IMCore/src/main/resources/Inject_IMCoreCustomizedConfig.yml", version=1)
  public static ArrayList<Class<? extends IRecentListBaseProcessor>> c;
  
  static
  {
    a.add(CMGameProcessor.class);
    a.add(TroopProcessor.class);
    a.add(DeprecatedLogicProcessor.class);
    a.add(NewFriendCacheProcessor.class);
    a.add(PublicAccountProcessor.class);
    a.add(PublicAccountAssistantProcessor.class);
    a.add(KandianMergeProcessor.class);
    a.add(TempGameMsgProcessor.class);
    a.add(HiddenChatProcessor.class);
    a.add(CombineBusinessProcessor.class);
    a.add(MsgBoxProcessor.class);
    b = new ArrayList();
    b.add(VideoStatus.class);
    b.add(DraftStatusIcon.class);
    b.add(ShareLocationStatus.class);
    b.add(StudyRoomStatus.class);
    b.add(ListenTogetherStatus.class);
    b.add(TogetherStatus.class);
    b.add(AVGameStatus.class);
    b.add(BaseMenuFlag.class);
    b.add(CommonMenuFlag.class);
    c = new ArrayList();
    c.add(C2CLikeConverter.class);
    c.add(BusinessConverter.class);
    c.add(SpecialConverter.class);
    c.add(HotChatFilter.class);
    c.add(DiscussHiddenFilter.class);
    c.add(AdvertisementFilter.class);
    c.add(TempMsgBoxFilter.class);
    c.add(TempFilterBoxFilter.class);
    c.add(RecentSortTopProcessor.class);
    c.add(RecentSortValueProcessor.class);
    c.add(ReadInJoyFilter.class);
    c.add(SubAccountAssistantFilter.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.imcore.config.extension.RecentCustomizedProcessorRegister
 * JD-Core Version:    0.7.0.1
 */