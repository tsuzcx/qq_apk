package com.tencent.mobileqq.kandian.biz.push.api;

import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.kandian.repo.feeds.entity.KandianRedDotInfo;
import com.tencent.mobileqq.kandian.repo.push.api.IKanDianMergeManagerCallBack;
import com.tencent.mobileqq.kandian.repo.push.api.MessageObserver;
import com.tencent.mobileqq.kandian.repo.push.api.RIJTabObserverCallBack;
import com.tencent.mobileqq.kandian.repo.reddot.KandianMsgBoxRedPntInfo;
import com.tencent.mobileqq.qroute.annotation.Service;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.RedTypeInfo;
import kotlin.Metadata;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Service(needUin=false, process={"all"})
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/push/api/IKanDianMergeManager;", "Lmqq/app/api/IRuntimeService;", "addIndependentTabObserver", "", "rijTabObserverCallBack", "Lcom/tencent/mobileqq/kandian/repo/push/api/RIJTabObserverCallBack;", "addMsgObserver", "observer", "Lcom/tencent/mobileqq/kandian/repo/push/api/MessageObserver;", "baseActivityFocusChange", "isFocused", "", "clz", "Ljava/lang/Class;", "cleanKanDianMergeSummary", "clearMsgBoxRedPnt", "createFakeFromNewMsg", "Lcom/tencent/mobileqq/data/MessageRecord;", "mr", "createFakeMsgForMergeKandian", "brief", "", "time", "from", "", "needRefresh", "createFakeMsgFrom0x135PBBuffer", "pbBuffer", "", "doSomeInitJobAfterLogin", "erasureTabRed", "tabIndex", "erasureTabRedWhenSwitchTab", "fromTabIndex", "toTabIndex", "getKandianLockScreenRedPntInfo", "Lcom/tencent/mobileqq/kandian/repo/feeds/entity/KandianRedDotInfo;", "getLastMsgForKanDian2", "getLastMsgForKandian2", "getLastSetTopMsgUniSeq", "", "getMsgFromSource", "getReadInJoyTabRedInfo", "Lcom/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$RedTypeInfo;", "getStickyStatus", "getTabRedNums", "getUnreadMsgBoxRedPntInfo", "Lcom/tencent/mobileqq/kandian/repo/reddot/KandianMsgBoxRedPntInfo;", "hasKandianOrSubscribePush", "kandianMergeMessageReaded", "mainVideoTabRedHasRed", "notificationTabRedNumsChange", "onSubscribeMsgNotification", "processMsg0x210Sub0xc5", "msgType0x210Bytes", "msgTime", "callBack", "Lcom/tencent/mobileqq/kandian/repo/push/api/IKanDianMergeManagerCallBack;", "processMsg0x210Sub0xee", "removeIndependentTabObserver", "removeKanDianPushFromSP", "removeMsgObserver", "removeSubscribePushFromSP", "uin", "roamStickySettingToServer", "sticky", "tryToShowAppInPush", "updateKanDianPushSetTopMsg", "stickyTime", "effectiveTime", "Companion", "kandian-api_release"}, k=1, mv={1, 1, 16})
public abstract interface IKanDianMergeManager
  extends IRuntimeService
{
  public static final int APP_PUSH = 6;
  public static final IKanDianMergeManager.Companion Companion = IKanDianMergeManager.Companion.a;
  public static final int ILLEGAL_MSG = 0;
  public static final int KANDIAN_FAKE_MSG = 3;
  public static final int KANDIAN_REAL_MSG = 1;
  public static final int OX210_MSG = 5;
  public static final int SUBSCRIBE_FAKE_MSG = 4;
  public static final int SUBSCRIBE_REAL_MSG = 2;
  @NotNull
  public static final String VIDEOTAB_FAKE_REDDOT_CYCLE = "video_tab_fake_reddot_cycle";
  @NotNull
  public static final String VIDEOTAB_FAKE_REDDOT_CYCLE_FRIST_SHOW_TIME = "videotab_fake_reddot_cycle_frist_show_time";
  @NotNull
  public static final String VIDEOTAB_FAKE_REDDOT_ERASURE_BY_USER = "videotab_fake_reddot_erasure_by_user";
  @NotNull
  public static final String VIDEOTAB_FAKE_REDDOT_SWITCH = "video_tab_fake_reddot_switch";
  
  public abstract void addIndependentTabObserver(@NotNull RIJTabObserverCallBack paramRIJTabObserverCallBack);
  
  public abstract void addMsgObserver(@Nullable MessageObserver paramMessageObserver);
  
  public abstract void baseActivityFocusChange(boolean paramBoolean, @Nullable Class<?> paramClass);
  
  public abstract void cleanKanDianMergeSummary();
  
  public abstract void clearMsgBoxRedPnt();
  
  @Nullable
  public abstract MessageRecord createFakeFromNewMsg(@NotNull MessageRecord paramMessageRecord);
  
  public abstract void createFakeMsgForMergeKandian(@Nullable String paramString1, @Nullable String paramString2, int paramInt, boolean paramBoolean);
  
  @Nullable
  public abstract MessageRecord createFakeMsgFrom0x135PBBuffer(@Nullable byte[] paramArrayOfByte, @Nullable String paramString);
  
  public abstract void doSomeInitJobAfterLogin();
  
  public abstract void erasureTabRed(int paramInt);
  
  public abstract boolean erasureTabRedWhenSwitchTab(int paramInt1, int paramInt2);
  
  @Nullable
  public abstract KandianRedDotInfo getKandianLockScreenRedPntInfo();
  
  @Nullable
  public abstract MessageRecord getLastMsgForKanDian2();
  
  @Nullable
  public abstract MessageRecord getLastMsgForKandian2();
  
  public abstract long getLastSetTopMsgUniSeq();
  
  public abstract int getMsgFromSource(@NotNull MessageRecord paramMessageRecord);
  
  @Nullable
  public abstract BusinessInfoCheckUpdate.RedTypeInfo getReadInJoyTabRedInfo();
  
  public abstract int getStickyStatus();
  
  public abstract int getTabRedNums(int paramInt);
  
  @Nullable
  public abstract KandianMsgBoxRedPntInfo getUnreadMsgBoxRedPntInfo();
  
  public abstract boolean hasKandianOrSubscribePush();
  
  public abstract void kandianMergeMessageReaded();
  
  public abstract void kandianMergeMessageReaded(@Nullable MessageRecord paramMessageRecord);
  
  public abstract boolean mainVideoTabRedHasRed();
  
  public abstract void notificationTabRedNumsChange();
  
  public abstract void onSubscribeMsgNotification(@Nullable MessageRecord paramMessageRecord);
  
  public abstract void processMsg0x210Sub0xc5(@NotNull byte[] paramArrayOfByte, long paramLong, @NotNull IKanDianMergeManagerCallBack paramIKanDianMergeManagerCallBack);
  
  public abstract void processMsg0x210Sub0xee(@Nullable byte[] paramArrayOfByte, long paramLong);
  
  public abstract void removeIndependentTabObserver(@NotNull RIJTabObserverCallBack paramRIJTabObserverCallBack);
  
  public abstract void removeKanDianPushFromSP();
  
  public abstract void removeMsgObserver(@Nullable MessageObserver paramMessageObserver);
  
  public abstract void removeSubscribePushFromSP();
  
  public abstract void removeSubscribePushFromSP(@Nullable String paramString);
  
  public abstract void roamStickySettingToServer(boolean paramBoolean);
  
  public abstract void tryToShowAppInPush();
  
  public abstract void updateKanDianPushSetTopMsg(int paramInt1, int paramInt2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.push.api.IKanDianMergeManager
 * JD-Core Version:    0.7.0.1
 */