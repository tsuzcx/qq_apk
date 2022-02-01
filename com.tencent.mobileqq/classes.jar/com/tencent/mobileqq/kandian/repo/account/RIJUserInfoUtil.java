package com.tencent.mobileqq.kandian.repo.account;

import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/repo/account/RIJUserInfoUtil;", "", "()V", "TAG", "", "expiredTimeSecond", "", "realtimeSwitch", "", "addUinToList", "", "uinList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "uin", "requestUserInfo", "articleInfoList", "", "Lcom/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo;", "channelId", "", "updateConfig", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class RIJUserInfoUtil
{
  public static final RIJUserInfoUtil a = new RIJUserInfoUtil();
  private static boolean b;
  private static long c = 9223372036854775807L;
  
  private final void a(ArrayList<String> paramArrayList, String paramString)
  {
    if ((!TextUtils.isEmpty((CharSequence)paramString)) && (!CollectionsKt.contains((Iterable)paramArrayList, paramString)) && (paramString != null)) {
      paramArrayList.add(paramString);
    }
  }
  
  public final void a(@Nullable List<? extends AbsBaseArticleInfo> paramList, int paramInt)
  {
    ThreadManager.excute((Runnable)new RIJUserInfoUtil.requestUserInfo.runnable.1(paramInt, paramList), 128, null, false);
  }
  
  public final void a(boolean paramBoolean, long paramLong)
  {
    b = paramBoolean;
    c = paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.account.RIJUserInfoUtil
 * JD-Core Version:    0.7.0.1
 */