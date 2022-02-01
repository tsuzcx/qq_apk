package com.tencent.mobileqq.kandian.biz.push.api.impl;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.biz.push.ReadInJoyTabObserver;
import com.tencent.mobileqq.kandian.biz.push.api.IKanDianMergeManager;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.KandianMergeManager;
import com.tencent.mobileqq.kandian.repo.feeds.entity.KandianRedDotInfo;
import com.tencent.mobileqq.kandian.repo.push.api.IKanDianMergeManagerCallBack;
import com.tencent.mobileqq.kandian.repo.push.api.MessageObserver;
import com.tencent.mobileqq.kandian.repo.push.api.RIJTabObserverCallBack;
import com.tencent.mobileqq.kandian.repo.reddot.KandianMsgBoxRedPntInfo;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.RedTypeInfo;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/push/api/impl/KanDianMergeManagerImpl;", "Lcom/tencent/mobileqq/kandian/biz/push/api/IKanDianMergeManager;", "()V", "kanDianMergeManager", "Lcom/tencent/mobileqq/kandian/glue/businesshandler/engine/KandianMergeManager;", "readInJoyTabObserver", "Lcom/tencent/mobileqq/kandian/biz/push/ReadInJoyTabObserver;", "rijTabObserverCallBack", "Lcom/tencent/mobileqq/kandian/repo/push/api/RIJTabObserverCallBack;", "getRijTabObserverCallBack", "()Lcom/tencent/mobileqq/kandian/repo/push/api/RIJTabObserverCallBack;", "setRijTabObserverCallBack", "(Lcom/tencent/mobileqq/kandian/repo/push/api/RIJTabObserverCallBack;)V", "addIndependentTabObserver", "", "addMsgObserver", "observer", "Lcom/tencent/mobileqq/kandian/repo/push/api/MessageObserver;", "baseActivityFocusChange", "isFocused", "", "clz", "Ljava/lang/Class;", "cleanKanDianMergeSummary", "clearMsgBoxRedPnt", "createFakeFromNewMsg", "Lcom/tencent/mobileqq/data/MessageRecord;", "mr", "createFakeMsgForMergeKandian", "brief", "", "time", "from", "", "needRefresh", "createFakeMsgFrom0x135PBBuffer", "pbBuffer", "", "doSomeInitJobAfterLogin", "erasureTabRed", "tabIndex", "erasureTabRedWhenSwitchTab", "fromTabIndex", "toTabIndex", "getKandianLockScreenRedPntInfo", "Lcom/tencent/mobileqq/kandian/repo/feeds/entity/KandianRedDotInfo;", "getLastMsgForKanDian2", "getLastMsgForKandian2", "getLastSetTopMsgUniSeq", "", "getMsgFromSource", "getReadInJoyTabRedInfo", "Lcom/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$RedTypeInfo;", "getStickyStatus", "getTabRedNums", "getUnreadMsgBoxRedPntInfo", "Lcom/tencent/mobileqq/kandian/repo/reddot/KandianMsgBoxRedPntInfo;", "hasKandianOrSubscribePush", "kandianMergeMessageReaded", "mainVideoTabRedHasRed", "notificationTabRedNumsChange", "onCreate", "appRuntime", "Lmqq/app/AppRuntime;", "onDestroy", "onSubscribeMsgNotification", "processMsg0x210Sub0xc5", "msgType0x210Bytes", "msgTime", "callBack", "Lcom/tencent/mobileqq/kandian/repo/push/api/IKanDianMergeManagerCallBack;", "processMsg0x210Sub0xee", "removeIndependentTabObserver", "removeKanDianPushFromSP", "removeMsgObserver", "removeSubscribePushFromSP", "uin", "roamStickySettingToServer", "sticky", "tryToShowAppInPush", "updateKanDianPushSetTopMsg", "stickyTime", "effectiveTime", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class KanDianMergeManagerImpl
  implements IKanDianMergeManager
{
  private KandianMergeManager kanDianMergeManager;
  private final ReadInJoyTabObserver readInJoyTabObserver = (ReadInJoyTabObserver)new KanDianMergeManagerImpl.readInJoyTabObserver.1(this);
  @Nullable
  private RIJTabObserverCallBack rijTabObserverCallBack;
  
  public void addIndependentTabObserver(@NotNull RIJTabObserverCallBack paramRIJTabObserverCallBack)
  {
    Intrinsics.checkParameterIsNotNull(paramRIJTabObserverCallBack, "rijTabObserverCallBack");
    this.rijTabObserverCallBack = paramRIJTabObserverCallBack;
    paramRIJTabObserverCallBack = this.kanDianMergeManager;
    if (paramRIJTabObserverCallBack != null) {
      paramRIJTabObserverCallBack.a(this.readInJoyTabObserver);
    }
  }
  
  public void addMsgObserver(@Nullable MessageObserver paramMessageObserver)
  {
    try
    {
      KandianMergeManager localKandianMergeManager = this.kanDianMergeManager;
      if (localKandianMergeManager != null) {
        localKandianMergeManager.a(paramMessageObserver);
      }
      return;
    }
    finally {}
  }
  
  public void baseActivityFocusChange(boolean paramBoolean, @Nullable Class<?> paramClass)
  {
    KandianMergeManager localKandianMergeManager = this.kanDianMergeManager;
    if (localKandianMergeManager != null) {
      localKandianMergeManager.a(paramBoolean, paramClass);
    }
  }
  
  public void cleanKanDianMergeSummary()
  {
    KandianMergeManager localKandianMergeManager = this.kanDianMergeManager;
    if (localKandianMergeManager != null) {
      localKandianMergeManager.n();
    }
  }
  
  public void clearMsgBoxRedPnt()
  {
    KandianMergeManager localKandianMergeManager = this.kanDianMergeManager;
    if (localKandianMergeManager != null) {
      localKandianMergeManager.T();
    }
  }
  
  @Nullable
  public MessageRecord createFakeFromNewMsg(@NotNull MessageRecord paramMessageRecord)
  {
    Intrinsics.checkParameterIsNotNull(paramMessageRecord, "mr");
    KandianMergeManager localKandianMergeManager = this.kanDianMergeManager;
    if (localKandianMergeManager != null) {
      return localKandianMergeManager.b(paramMessageRecord);
    }
    return null;
  }
  
  public void createFakeMsgForMergeKandian(@Nullable String paramString1, @Nullable String paramString2, int paramInt, boolean paramBoolean)
  {
    KandianMergeManager localKandianMergeManager = this.kanDianMergeManager;
    if (localKandianMergeManager != null) {
      localKandianMergeManager.a(paramString1, paramString2, paramInt, paramBoolean);
    }
  }
  
  @Nullable
  public MessageRecord createFakeMsgFrom0x135PBBuffer(@Nullable byte[] paramArrayOfByte, @Nullable String paramString)
  {
    KandianMergeManager localKandianMergeManager = this.kanDianMergeManager;
    if (localKandianMergeManager != null) {
      return localKandianMergeManager.a(paramArrayOfByte, paramString);
    }
    return null;
  }
  
  public void doSomeInitJobAfterLogin()
  {
    KandianMergeManager localKandianMergeManager = this.kanDianMergeManager;
    if (localKandianMergeManager != null) {
      localKandianMergeManager.a();
    }
  }
  
  public void erasureTabRed(int paramInt)
  {
    KandianMergeManager localKandianMergeManager = this.kanDianMergeManager;
    if (localKandianMergeManager != null) {
      localKandianMergeManager.f(paramInt);
    }
  }
  
  public boolean erasureTabRedWhenSwitchTab(int paramInt1, int paramInt2)
  {
    KandianMergeManager localKandianMergeManager = this.kanDianMergeManager;
    if (localKandianMergeManager != null) {
      return localKandianMergeManager.b(paramInt1, paramInt2);
    }
    return false;
  }
  
  @Nullable
  public KandianRedDotInfo getKandianLockScreenRedPntInfo()
  {
    KandianMergeManager localKandianMergeManager = this.kanDianMergeManager;
    if (localKandianMergeManager != null) {
      return localKandianMergeManager.e();
    }
    return null;
  }
  
  @Nullable
  public MessageRecord getLastMsgForKanDian2()
  {
    KandianMergeManager localKandianMergeManager = this.kanDianMergeManager;
    if (localKandianMergeManager != null) {
      return localKandianMergeManager.t();
    }
    return null;
  }
  
  @Nullable
  public MessageRecord getLastMsgForKandian2()
  {
    KandianMergeManager localKandianMergeManager = this.kanDianMergeManager;
    if (localKandianMergeManager != null) {
      return localKandianMergeManager.t();
    }
    return null;
  }
  
  public long getLastSetTopMsgUniSeq()
  {
    KandianMergeManager localKandianMergeManager = this.kanDianMergeManager;
    if (localKandianMergeManager != null) {
      return localKandianMergeManager.C();
    }
    return 0L;
  }
  
  public int getMsgFromSource(@NotNull MessageRecord paramMessageRecord)
  {
    Intrinsics.checkParameterIsNotNull(paramMessageRecord, "mr");
    AppRuntime localAppRuntime = RIJQQAppInterfaceUtil.e();
    if (localAppRuntime != null) {
      return KandianMergeManager.a(paramMessageRecord, (AppInterface)localAppRuntime);
    }
    throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
  }
  
  @Nullable
  public BusinessInfoCheckUpdate.RedTypeInfo getReadInJoyTabRedInfo()
  {
    KandianMergeManager localKandianMergeManager = this.kanDianMergeManager;
    if (localKandianMergeManager != null) {
      return localKandianMergeManager.v();
    }
    return null;
  }
  
  @Nullable
  public final RIJTabObserverCallBack getRijTabObserverCallBack()
  {
    return this.rijTabObserverCallBack;
  }
  
  public int getStickyStatus()
  {
    KandianMergeManager localKandianMergeManager = this.kanDianMergeManager;
    if (localKandianMergeManager != null) {
      return localKandianMergeManager.d;
    }
    return 0;
  }
  
  public int getTabRedNums(int paramInt)
  {
    KandianMergeManager localKandianMergeManager = this.kanDianMergeManager;
    if (localKandianMergeManager != null) {
      return localKandianMergeManager.e(paramInt);
    }
    return 0;
  }
  
  @Nullable
  public KandianMsgBoxRedPntInfo getUnreadMsgBoxRedPntInfo()
  {
    KandianMergeManager localKandianMergeManager = this.kanDianMergeManager;
    if (localKandianMergeManager != null) {
      return localKandianMergeManager.Q();
    }
    return null;
  }
  
  public boolean hasKandianOrSubscribePush()
  {
    KandianMergeManager localKandianMergeManager = this.kanDianMergeManager;
    if (localKandianMergeManager != null) {
      return localKandianMergeManager.d();
    }
    return false;
  }
  
  public void kandianMergeMessageReaded()
  {
    KandianMergeManager localKandianMergeManager = this.kanDianMergeManager;
    if (localKandianMergeManager != null) {
      localKandianMergeManager.o();
    }
  }
  
  public void kandianMergeMessageReaded(@Nullable MessageRecord paramMessageRecord)
  {
    KandianMergeManager localKandianMergeManager = this.kanDianMergeManager;
    if (localKandianMergeManager != null) {
      localKandianMergeManager.e(paramMessageRecord);
    }
  }
  
  public boolean mainVideoTabRedHasRed()
  {
    KandianMergeManager localKandianMergeManager = this.kanDianMergeManager;
    if (localKandianMergeManager != null) {
      return localKandianMergeManager.M();
    }
    return false;
  }
  
  public void notificationTabRedNumsChange()
  {
    KandianMergeManager localKandianMergeManager = this.kanDianMergeManager;
    if (localKandianMergeManager != null) {
      localKandianMergeManager.I();
    }
  }
  
  public void onCreate(@Nullable AppRuntime paramAppRuntime)
  {
    if (paramAppRuntime != null) {
      paramAppRuntime = paramAppRuntime.getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER);
    } else {
      paramAppRuntime = null;
    }
    AppRuntime localAppRuntime = paramAppRuntime;
    if (!(paramAppRuntime instanceof KandianMergeManager)) {
      localAppRuntime = null;
    }
    this.kanDianMergeManager = ((KandianMergeManager)localAppRuntime);
  }
  
  public void onDestroy() {}
  
  public void onSubscribeMsgNotification(@Nullable MessageRecord paramMessageRecord)
  {
    KandianMergeManager localKandianMergeManager = this.kanDianMergeManager;
    if (localKandianMergeManager != null) {
      localKandianMergeManager.k(paramMessageRecord);
    }
  }
  
  public void processMsg0x210Sub0xc5(@NotNull byte[] paramArrayOfByte, long paramLong, @NotNull IKanDianMergeManagerCallBack paramIKanDianMergeManagerCallBack)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "msgType0x210Bytes");
    Intrinsics.checkParameterIsNotNull(paramIKanDianMergeManagerCallBack, "callBack");
    KandianMergeManager localKandianMergeManager = this.kanDianMergeManager;
    if (localKandianMergeManager != null) {
      localKandianMergeManager.a(paramArrayOfByte, paramLong, paramIKanDianMergeManagerCallBack);
    }
  }
  
  public void processMsg0x210Sub0xee(@Nullable byte[] paramArrayOfByte, long paramLong)
  {
    KandianMergeManager localKandianMergeManager = this.kanDianMergeManager;
    if (localKandianMergeManager != null) {
      localKandianMergeManager.a(paramArrayOfByte, paramLong);
    }
  }
  
  public void removeIndependentTabObserver(@NotNull RIJTabObserverCallBack paramRIJTabObserverCallBack)
  {
    Intrinsics.checkParameterIsNotNull(paramRIJTabObserverCallBack, "rijTabObserverCallBack");
    this.rijTabObserverCallBack = ((RIJTabObserverCallBack)null);
    paramRIJTabObserverCallBack = this.kanDianMergeManager;
    if (paramRIJTabObserverCallBack != null) {
      paramRIJTabObserverCallBack.b(this.readInJoyTabObserver);
    }
  }
  
  public void removeKanDianPushFromSP()
  {
    KandianMergeManager localKandianMergeManager = this.kanDianMergeManager;
    if (localKandianMergeManager != null) {
      localKandianMergeManager.r();
    }
  }
  
  public void removeMsgObserver(@Nullable MessageObserver paramMessageObserver)
  {
    try
    {
      KandianMergeManager localKandianMergeManager = this.kanDianMergeManager;
      if (localKandianMergeManager != null) {
        localKandianMergeManager.b(paramMessageObserver);
      }
      return;
    }
    finally {}
  }
  
  public void removeSubscribePushFromSP()
  {
    KandianMergeManager localKandianMergeManager = this.kanDianMergeManager;
    if (localKandianMergeManager != null) {
      localKandianMergeManager.p();
    }
  }
  
  public void removeSubscribePushFromSP(@Nullable String paramString)
  {
    try
    {
      KandianMergeManager localKandianMergeManager = this.kanDianMergeManager;
      if (localKandianMergeManager != null) {
        localKandianMergeManager.a(paramString);
      }
      return;
    }
    finally {}
  }
  
  public void roamStickySettingToServer(boolean paramBoolean)
  {
    KandianMergeManager localKandianMergeManager = this.kanDianMergeManager;
    if (localKandianMergeManager != null) {
      localKandianMergeManager.c(paramBoolean);
    }
  }
  
  public final void setRijTabObserverCallBack(@Nullable RIJTabObserverCallBack paramRIJTabObserverCallBack)
  {
    this.rijTabObserverCallBack = paramRIJTabObserverCallBack;
  }
  
  public void tryToShowAppInPush()
  {
    KandianMergeManager localKandianMergeManager = this.kanDianMergeManager;
    if (localKandianMergeManager != null) {
      localKandianMergeManager.N();
    }
  }
  
  public void updateKanDianPushSetTopMsg(int paramInt1, int paramInt2)
  {
    KandianMergeManager localKandianMergeManager = this.kanDianMergeManager;
    if (localKandianMergeManager != null) {
      localKandianMergeManager.a(paramInt1, paramInt2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.push.api.impl.KanDianMergeManagerImpl
 * JD-Core Version:    0.7.0.1
 */