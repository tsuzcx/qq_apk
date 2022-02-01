package com.tencent.mobileqq.kandian.biz.xtab.badge;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.kandian.biz.framework.RIJAppSetting;
import com.tencent.mobileqq.kandian.biz.xtab.api.impl.RIJXTabFrameUtils;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.KandianMergeManager;
import com.tencent.mobileqq.kandian.repo.feeds.entity.TabChannelCoverInfo;
import com.tencent.mobileqq.kandian.repo.tab.RIJXTabRedDotInfo;
import com.tencent.mobileqq.kandian.repo.xtab.api.impl.RIJXTabConfigHandler;
import com.tencent.mobileqq.kandian.repo.xtab.badge.RIJXTabBadgeShowLevel;
import com.tencent.mobileqq.kandian.repo.xtab.badge.RIJXTabBadgeStore;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/xtab/badge/RIJXTabBadgeInterceptor;", "Lcom/tencent/mobileqq/kandian/biz/xtab/badge/IRIJBadgeInterceptor;", "app", "Lcom/tencent/mobileqq/app/QQAppInterface;", "mergeManager", "Lcom/tencent/mobileqq/kandian/glue/businesshandler/engine/KandianMergeManager;", "(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/kandian/glue/businesshandler/engine/KandianMergeManager;)V", "isChannelExist", "", "badgeInfo", "Lcom/tencent/mobileqq/kandian/repo/tab/RIJXTabRedDotInfo;", "isFriendBigBadge", "isKDCommunityBadge", "kandianTabHasMsgBoxBadgeNum", "mr", "Lcom/tencent/mobileqq/data/MessageRecord;", "needHandleBadge", "xTabBadgeInfo", "onNotifyBadgeMsg", "onReceiveBadgeMsg", "onSaveBadgeMsg", "", "shouldIntercept", "Companion", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class RIJXTabBadgeInterceptor
  implements IRIJBadgeInterceptor
{
  public static final RIJXTabBadgeInterceptor.Companion b = new RIJXTabBadgeInterceptor.Companion(null);
  private final QQAppInterface c;
  private final KandianMergeManager d;
  
  public RIJXTabBadgeInterceptor(@NotNull QQAppInterface paramQQAppInterface, @NotNull KandianMergeManager paramKandianMergeManager)
  {
    this.c = paramQQAppInterface;
    this.d = paramKandianMergeManager;
  }
  
  private final boolean a(RIJXTabRedDotInfo paramRIJXTabRedDotInfo)
  {
    return (RIJXTabConfigHandler.INSTANCE.isXTabMode()) && (b(paramRIJXTabRedDotInfo)) && ((c(paramRIJXTabRedDotInfo)) || (d(paramRIJXTabRedDotInfo))) && ((!RIJAppSetting.b(paramRIJXTabRedDotInfo.getChannelId())) || (c(paramRIJXTabRedDotInfo)));
  }
  
  private final boolean b(RIJXTabRedDotInfo paramRIJXTabRedDotInfo)
  {
    Iterator localIterator = ((Iterable)RIJXTabConfigHandler.INSTANCE.getTabList()).iterator();
    while (localIterator.hasNext()) {
      if (((TabChannelCoverInfo)localIterator.next()).mChannelCoverId == paramRIJXTabRedDotInfo.getChannelId()) {
        return true;
      }
    }
    return false;
  }
  
  private final boolean c(RIJXTabRedDotInfo paramRIJXTabRedDotInfo)
  {
    return (paramRIJXTabRedDotInfo.getChannelId() == TabChannelCoverInfo.TYPE_CHANNEL_XTAB_FRIEND_CONFIG) && (paramRIJXTabRedDotInfo.isBig()) && (paramRIJXTabRedDotInfo.getUin() > 0L);
  }
  
  private final boolean d(RIJXTabRedDotInfo paramRIJXTabRedDotInfo)
  {
    return paramRIJXTabRedDotInfo.getChannelId() == TabChannelCoverInfo.TYPE_CHANNEL_XTAB_KD_COMMUNITY_CONFIG;
  }
  
  private final boolean e(MessageRecord paramMessageRecord)
  {
    return (!RIJXTabFrameUtils.INSTANCE.isNowInKanDianTab()) && (this.d.R() > 0);
  }
  
  public boolean a(@NotNull MessageRecord paramMessageRecord)
  {
    Intrinsics.checkParameterIsNotNull(paramMessageRecord, "mr");
    boolean bool = RIJXTabBadgeInfoExtKt.a(paramMessageRecord, this.c);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("shouldIntercept(");
      localStringBuilder.append(bool);
      localStringBuilder.append(") --> ");
      localStringBuilder.append("from:");
      localStringBuilder.append(KandianMergeManager.a(paramMessageRecord, (AppInterface)this.c));
      localStringBuilder.append(',');
      localStringBuilder.append("badgeInfo:");
      localStringBuilder.append(RIJXTabBadgeInfoExtKt.a(paramMessageRecord));
      QLog.i("RIJXTabBadgeInterceptor", 2, localStringBuilder.toString());
    }
    return bool;
  }
  
  public boolean b(@NotNull MessageRecord paramMessageRecord)
  {
    Intrinsics.checkParameterIsNotNull(paramMessageRecord, "mr");
    Object localObject = RIJXTabBadgeInfoExtKt.a(paramMessageRecord);
    if (localObject == null)
    {
      if ((paramMessageRecord instanceof MessageForStructing))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onReceiveBadgeMsg, struttingMsg.mMsgActionData=");
        paramMessageRecord = ((MessageForStructing)paramMessageRecord).structingMsg;
        if (paramMessageRecord != null) {
          paramMessageRecord = paramMessageRecord.mMsgActionData;
        } else {
          paramMessageRecord = null;
        }
        ((StringBuilder)localObject).append(paramMessageRecord);
        QLog.e("RIJXTabBadgeInterceptor", 1, ((StringBuilder)localObject).toString());
        return true;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onReceiveBadgeMsg, errorTypeMsg, ");
      ((StringBuilder)localObject).append(paramMessageRecord.getClass().getName());
      QLog.e("RIJXTabBadgeInterceptor", 1, ((StringBuilder)localObject).toString());
      return true;
    }
    boolean bool = a((RIJXTabRedDotInfo)localObject) ^ true;
    if (QLog.isColorLevel())
    {
      paramMessageRecord = new StringBuilder();
      paramMessageRecord.append("onReceiveBadgeMsg(");
      paramMessageRecord.append(bool);
      paramMessageRecord.append(") --> ");
      paramMessageRecord.append("isXTabMode:");
      paramMessageRecord.append(RIJXTabConfigHandler.INSTANCE.isXTabMode());
      paramMessageRecord.append(", ");
      paramMessageRecord.append(", ");
      paramMessageRecord.append("isChannelExist:");
      paramMessageRecord.append(b((RIJXTabRedDotInfo)localObject));
      QLog.i("RIJXTabBadgeInterceptor", 2, paramMessageRecord.toString());
    }
    return bool;
  }
  
  public int c(@NotNull MessageRecord paramMessageRecord)
  {
    Intrinsics.checkParameterIsNotNull(paramMessageRecord, "mr");
    RIJXTabRedDotInfo localRIJXTabRedDotInfo = RIJXTabBadgeInfoExtKt.a(paramMessageRecord);
    int j = -1;
    int i = j;
    if (localRIJXTabRedDotInfo != null)
    {
      boolean bool1 = RIJXTabBadgeStore.a.a(localRIJXTabRedDotInfo);
      if (bool1)
      {
        boolean bool2 = e(paramMessageRecord);
        boolean bool3 = RIJXTabFrameUtils.INSTANCE.isNowInKanDianTab();
        if (c(localRIJXTabRedDotInfo)) {
          if ((!bool2) && (!bool3)) {
            RIJXTabBadgeShowLevel.a(2);
          } else {
            RIJXTabBadgeShowLevel.a(1);
          }
        }
        paramMessageRecord = new StringBuilder();
        paramMessageRecord.append("onSaveBadgeMsg,kandianTabHasMsgBoxBadgeNum:");
        paramMessageRecord.append(bool2);
        paramMessageRecord.append(", ");
        paramMessageRecord.append("isNowInKanDianTab:");
        paramMessageRecord.append(bool3);
        paramMessageRecord.append(",level:");
        paramMessageRecord.append(RIJXTabBadgeShowLevel.a());
        QLog.i("RIJXTabBadgeInterceptor", 1, paramMessageRecord.toString());
      }
      paramMessageRecord = new StringBuilder();
      paramMessageRecord.append("onSaveBadgeMsg,result:");
      paramMessageRecord.append(bool1);
      QLog.i("RIJXTabBadgeInterceptor", 1, paramMessageRecord.toString());
      if (QLog.isColorLevel())
      {
        paramMessageRecord = new StringBuilder();
        paramMessageRecord.append("onSaveBadgeMsg,badgeInfo: ");
        paramMessageRecord.append(localRIJXTabRedDotInfo);
        QLog.i("RIJXTabBadgeInterceptor", 2, paramMessageRecord.toString());
      }
      this.d.r();
      i = j;
      if (bool1) {
        i = 1;
      }
    }
    return i;
  }
  
  public boolean d(@NotNull MessageRecord paramMessageRecord)
  {
    Intrinsics.checkParameterIsNotNull(paramMessageRecord, "mr");
    RIJXTabBadgeDispatcher.a();
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.xtab.badge.RIJXTabBadgeInterceptor
 * JD-Core Version:    0.7.0.1
 */