package com.tencent.mobileqq.kandian.repo.aladdin;

import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/repo/aladdin/RIJFeedsFluencyOptimizeUtil;", "", "()V", "TAG", "", "useForeBackgroundCache", "", "getUseForeBackgroundCache", "()Ljava/lang/Boolean;", "setUseForeBackgroundCache", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "useViewTypeCache", "getUseViewTypeCache", "setUseViewTypeCache", "getViewTypeCache", "", "articleInfo", "Lcom/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo;", "isAbleToUseForeBackgroundCache", "isAbleToUseViewTypeCache", "updateViewTypeCache", "", "itemViewType", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class RIJFeedsFluencyOptimizeUtil
{
  public static final RIJFeedsFluencyOptimizeUtil a = new RIJFeedsFluencyOptimizeUtil();
  @Nullable
  private static Boolean b;
  @Nullable
  private static Boolean c;
  
  public final int a(@Nullable AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    boolean bool = a();
    int i = -1;
    if (!bool) {
      return -1;
    }
    if (paramAbsBaseArticleInfo != null) {
      i = paramAbsBaseArticleInfo.itemViewType;
    }
    return i;
  }
  
  public final void a(@Nullable AbsBaseArticleInfo paramAbsBaseArticleInfo, int paramInt)
  {
    if (!a()) {
      return;
    }
    if (paramAbsBaseArticleInfo != null) {
      paramAbsBaseArticleInfo.itemViewType = paramInt;
    }
  }
  
  public final boolean a()
  {
    Object localObject = b;
    boolean bool2 = false;
    if (localObject == null)
    {
      localObject = Aladdin.getConfig(471);
      int i;
      if (localObject != null) {
        i = ((AladdinConfig)localObject).getIntegerFromString("view_type_cache", 0);
      } else {
        i = 0;
      }
      if (i == 1) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      b = Boolean.valueOf(bool1);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[isAbleToUseViewTypeCache] useViewTypeCache = ");
      ((StringBuilder)localObject).append(b);
      QLog.i("RIJFeedsFluencyOptimizeUtil", 1, ((StringBuilder)localObject).toString());
    }
    localObject = b;
    boolean bool1 = bool2;
    if (localObject != null) {
      bool1 = ((Boolean)localObject).booleanValue();
    }
    return bool1;
  }
  
  public final boolean b()
  {
    Object localObject = c;
    boolean bool2 = false;
    if (localObject == null)
    {
      localObject = Aladdin.getConfig(471);
      int i;
      if (localObject != null) {
        i = ((AladdinConfig)localObject).getIntegerFromString("fore_background_cache", 0);
      } else {
        i = 0;
      }
      if (i == 1) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      c = Boolean.valueOf(bool1);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[isAbleToUseForeBackgroundCache] useForeBackgroundCache = ");
      ((StringBuilder)localObject).append(c);
      QLog.i("RIJFeedsFluencyOptimizeUtil", 1, ((StringBuilder)localObject).toString());
    }
    localObject = c;
    boolean bool1 = bool2;
    if (localObject != null) {
      bool1 = ((Boolean)localObject).booleanValue();
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.aladdin.RIJFeedsFluencyOptimizeUtil
 * JD-Core Version:    0.7.0.1
 */