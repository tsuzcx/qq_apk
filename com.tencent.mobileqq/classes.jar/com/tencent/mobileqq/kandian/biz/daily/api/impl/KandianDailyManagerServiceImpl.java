package com.tencent.mobileqq.kandian.biz.daily.api.impl;

import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.kandian.biz.daily.api.IKandianDailyManagerService;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.KandianDailyManager;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.KandianRedDotInfo;
import kotlin.Metadata;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/daily/api/impl/KandianDailyManagerServiceImpl;", "Lcom/tencent/mobileqq/kandian/biz/daily/api/IKandianDailyManagerService;", "()V", "manager", "Lcom/tencent/mobileqq/kandian/glue/businesshandler/engine/KandianDailyManager;", "getAndRemoveLockScreenRedDodInfo", "Lcom/tencent/mobileqq/kandian/repo/feeds/entity/KandianRedDotInfo;", "getLastLockScreenMsg", "Lcom/tencent/mobileqq/data/MessageRecord;", "getRedPntInfoFromMsg", "inserFakeMsgForBreif", "", "articleInfo", "Lcom/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo;", "onCreate", "appRuntime", "Lmqq/app/AppRuntime;", "onDestroy", "onReceiveKandianDailyLockScreenMsg", "mr", "onReceiveKandianDailyMsg", "msg", "trySetTopNode", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class KandianDailyManagerServiceImpl
  implements IKandianDailyManagerService
{
  private KandianDailyManager manager;
  
  @Nullable
  public KandianRedDotInfo getAndRemoveLockScreenRedDodInfo()
  {
    KandianDailyManager localKandianDailyManager = this.manager;
    if (localKandianDailyManager != null) {
      return localKandianDailyManager.d();
    }
    return null;
  }
  
  @Nullable
  public MessageRecord getLastLockScreenMsg()
  {
    KandianDailyManager localKandianDailyManager = this.manager;
    if (localKandianDailyManager != null) {
      return localKandianDailyManager.b();
    }
    return null;
  }
  
  @Nullable
  public KandianRedDotInfo getRedPntInfoFromMsg()
  {
    KandianDailyManager localKandianDailyManager = this.manager;
    if (localKandianDailyManager != null) {
      return localKandianDailyManager.c();
    }
    return null;
  }
  
  public void inserFakeMsgForBreif(@Nullable AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    KandianDailyManager localKandianDailyManager = this.manager;
    if (localKandianDailyManager != null) {
      localKandianDailyManager.a(paramAbsBaseArticleInfo);
    }
  }
  
  public void onCreate(@Nullable AppRuntime paramAppRuntime)
  {
    if (paramAppRuntime != null) {
      paramAppRuntime = paramAppRuntime.getManager(QQManagerFactory.KANDIAN_DAILY_MANAGER);
    } else {
      paramAppRuntime = null;
    }
    AppRuntime localAppRuntime = paramAppRuntime;
    if (!(paramAppRuntime instanceof KandianDailyManager)) {
      localAppRuntime = null;
    }
    this.manager = ((KandianDailyManager)localAppRuntime);
  }
  
  public void onDestroy() {}
  
  public void onReceiveKandianDailyLockScreenMsg(@Nullable MessageRecord paramMessageRecord)
  {
    KandianDailyManager localKandianDailyManager = this.manager;
    if (localKandianDailyManager != null) {
      localKandianDailyManager.a(paramMessageRecord);
    }
  }
  
  public void onReceiveKandianDailyMsg(@Nullable MessageRecord paramMessageRecord)
  {
    KandianDailyManager localKandianDailyManager = this.manager;
    if (localKandianDailyManager != null) {
      localKandianDailyManager.b(paramMessageRecord);
    }
  }
  
  public void trySetTopNode()
  {
    KandianDailyManager localKandianDailyManager = this.manager;
    if (localKandianDailyManager != null) {
      localKandianDailyManager.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.daily.api.impl.KandianDailyManagerServiceImpl
 * JD-Core Version:    0.7.0.1
 */