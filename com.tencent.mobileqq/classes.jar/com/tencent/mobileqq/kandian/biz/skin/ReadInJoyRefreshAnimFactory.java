package com.tencent.mobileqq.kandian.biz.skin;

import android.content.Context;
import com.tencent.mobileqq.kandian.biz.pullrefresh.ReadInJoyAnimBaseManager;
import com.tencent.mobileqq.kandian.biz.pullrefresh.ReadInJoyAnimDefaultManager;
import com.tencent.mobileqq.kandian.biz.pullrefresh.ReadInJoyAnimOldManager;
import com.tencent.mobileqq.kandian.biz.skin.api.IReadInJoyRefreshAnimFactory;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/skin/ReadInJoyRefreshAnimFactory;", "Lcom/tencent/mobileqq/kandian/biz/skin/api/IReadInJoyRefreshAnimFactory;", "()V", "PULL_REFRESH_TYPE_DEFAULT", "", "PULL_REFRESH_TYPE_OLD", "PULL_REFRESH_TYPE_SKIN", "getAnimManger", "Lcom/tencent/mobileqq/kandian/biz/pullrefresh/ReadInJoyAnimBaseManager;", "context", "Landroid/content/Context;", "animType", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class ReadInJoyRefreshAnimFactory
  implements IReadInJoyRefreshAnimFactory
{
  public static final ReadInJoyRefreshAnimFactory INSTANCE = new ReadInJoyRefreshAnimFactory();
  public static final int PULL_REFRESH_TYPE_DEFAULT = 0;
  public static final int PULL_REFRESH_TYPE_OLD = 1;
  public static final int PULL_REFRESH_TYPE_SKIN = 2;
  
  @NotNull
  public ReadInJoyAnimBaseManager getAnimManger(@Nullable Context paramContext, int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2) {
          return (ReadInJoyAnimBaseManager)new ReadInJoyAnimDefaultManager(paramContext);
        }
        return (ReadInJoyAnimBaseManager)new ReadInJoySkinAnimManager(paramContext);
      }
      return (ReadInJoyAnimBaseManager)new ReadInJoyAnimOldManager(paramContext);
    }
    return (ReadInJoyAnimBaseManager)new ReadInJoyAnimDefaultManager(paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.skin.ReadInJoyRefreshAnimFactory
 * JD-Core Version:    0.7.0.1
 */