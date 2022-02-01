package com.tencent.mobileqq.kandian.biz.framework;

import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/framework/RIJFeedsFluencyOptimizeUtil;", "", "()V", "TAG", "", "useViewTypeCache", "", "getUseViewTypeCache", "()Ljava/lang/Boolean;", "setUseViewTypeCache", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getViewTypeCache", "", "articleInfo", "Lcom/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo;", "isAbleToUseViewTypeCache", "updateViewTypeCache", "", "itemViewType", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class RIJFeedsFluencyOptimizeUtil
{
  public static final RIJFeedsFluencyOptimizeUtil a;
  @Nullable
  private static Boolean a;
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkRIJFeedsFluencyOptimizeUtil = new RIJFeedsFluencyOptimizeUtil();
  }
  
  public final int a(@Nullable AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    boolean bool = a();
    int i = -1;
    if (!bool) {
      return -1;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[getViewTypeCache] rowKey = ");
      Object localObject2 = null;
      if (paramAbsBaseArticleInfo != null) {
        localObject1 = paramAbsBaseArticleInfo.innerUniqueID;
      } else {
        localObject1 = null;
      }
      localStringBuilder.append((String)localObject1);
      localStringBuilder.append(", title = ");
      if (paramAbsBaseArticleInfo != null) {
        localObject1 = paramAbsBaseArticleInfo.mTitle;
      } else {
        localObject1 = null;
      }
      localStringBuilder.append((String)localObject1);
      localStringBuilder.append(", itemViewType = ");
      Object localObject1 = localObject2;
      if (paramAbsBaseArticleInfo != null) {
        localObject1 = Integer.valueOf(paramAbsBaseArticleInfo.itemViewType);
      }
      localStringBuilder.append(localObject1);
      QLog.i("RIJFeedsFluencyOptimizeUtil", 1, localStringBuilder.toString());
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
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[updateViewTypeCache] rowKey = ");
      Object localObject2 = null;
      if (paramAbsBaseArticleInfo != null) {
        localObject1 = paramAbsBaseArticleInfo.innerUniqueID;
      } else {
        localObject1 = null;
      }
      localStringBuilder.append((String)localObject1);
      localStringBuilder.append(", title = ");
      if (paramAbsBaseArticleInfo != null) {
        localObject1 = paramAbsBaseArticleInfo.mTitle;
      } else {
        localObject1 = null;
      }
      localStringBuilder.append((String)localObject1);
      localStringBuilder.append(", itemViewType = ");
      Object localObject1 = localObject2;
      if (paramAbsBaseArticleInfo != null) {
        localObject1 = Integer.valueOf(paramAbsBaseArticleInfo.itemViewType);
      }
      localStringBuilder.append(localObject1);
      QLog.i("RIJFeedsFluencyOptimizeUtil", 1, localStringBuilder.toString());
    }
  }
  
  public final boolean a()
  {
    Object localObject = jdField_a_of_type_JavaLangBoolean;
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
      jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(bool1);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[isAbleToUseViewTypeCache] useViewTypeCache = ");
      ((StringBuilder)localObject).append(jdField_a_of_type_JavaLangBoolean);
      QLog.i("RIJFeedsFluencyOptimizeUtil", 1, ((StringBuilder)localObject).toString());
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[isAbleToUseViewTypeCache] useViewTypeCache = ");
      ((StringBuilder)localObject).append(jdField_a_of_type_JavaLangBoolean);
      QLog.i("RIJFeedsFluencyOptimizeUtil", 1, ((StringBuilder)localObject).toString());
    }
    localObject = jdField_a_of_type_JavaLangBoolean;
    boolean bool1 = bool2;
    if (localObject != null) {
      bool1 = ((Boolean)localObject).booleanValue();
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.framework.RIJFeedsFluencyOptimizeUtil
 * JD-Core Version:    0.7.0.1
 */