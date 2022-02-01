package com.tencent.mobileqq.kandian.biz.daily.api;

import androidx.annotation.Nullable;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.KandianRedDotInfo;
import com.tencent.mobileqq.qroute.annotation.Service;
import mqq.app.api.IRuntimeService;

@Service(needUin=false, process={"all"})
public abstract interface IKandianDailyManagerService
  extends IRuntimeService
{
  @Nullable
  public abstract KandianRedDotInfo getAndRemoveLockScreenRedDodInfo();
  
  @Nullable
  public abstract MessageRecord getLastLockScreenMsg();
  
  @Nullable
  public abstract KandianRedDotInfo getRedPntInfoFromMsg();
  
  public abstract void inserFakeMsgForBreif(AbsBaseArticleInfo paramAbsBaseArticleInfo);
  
  public abstract void onReceiveKandianDailyLockScreenMsg(MessageRecord paramMessageRecord);
  
  public abstract void onReceiveKandianDailyMsg(MessageRecord paramMessageRecord);
  
  public abstract void trySetTopNode();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.daily.api.IKandianDailyManagerService
 * JD-Core Version:    0.7.0.1
 */