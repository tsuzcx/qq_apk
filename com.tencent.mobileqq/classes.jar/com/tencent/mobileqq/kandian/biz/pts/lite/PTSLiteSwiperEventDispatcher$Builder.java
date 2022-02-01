package com.tencent.mobileqq.kandian.biz.pts.lite;

import com.tencent.mobileqq.kandian.biz.framework.ReadInJoyBaseAdapter;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/pts/lite/PTSLiteSwiperEventDispatcher$Builder;", "", "()V", "adapter", "Lcom/tencent/mobileqq/kandian/biz/framework/ReadInJoyBaseAdapter;", "getAdapter", "()Lcom/tencent/mobileqq/kandian/biz/framework/ReadInJoyBaseAdapter;", "setAdapter", "(Lcom/tencent/mobileqq/kandian/biz/framework/ReadInJoyBaseAdapter;)V", "articleInfoMap", "Ljava/util/HashMap;", "", "Lcom/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo;", "Lkotlin/collections/HashMap;", "getArticleInfoMap", "()Ljava/util/HashMap;", "setArticleInfoMap", "(Ljava/util/HashMap;)V", "positionMap", "", "getPositionMap", "setPositionMap", "build", "Lcom/tencent/mobileqq/kandian/biz/pts/lite/PTSLiteSwiperEventDispatcher;", "withArticleInfoMap", "withPositionMap", "withRIJAdapter", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class PTSLiteSwiperEventDispatcher$Builder
{
  @Nullable
  private ReadInJoyBaseAdapter jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkReadInJoyBaseAdapter;
  @NotNull
  private HashMap<String, Integer> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  @NotNull
  private HashMap<String, AbsBaseArticleInfo> b = new HashMap();
  
  @NotNull
  public final Builder a(@NotNull ReadInJoyBaseAdapter paramReadInJoyBaseAdapter)
  {
    Intrinsics.checkParameterIsNotNull(paramReadInJoyBaseAdapter, "adapter");
    this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkReadInJoyBaseAdapter = paramReadInJoyBaseAdapter;
    return this;
  }
  
  @NotNull
  public final Builder a(@NotNull HashMap<String, Integer> paramHashMap)
  {
    Intrinsics.checkParameterIsNotNull(paramHashMap, "positionMap");
    this.jdField_a_of_type_JavaUtilHashMap = paramHashMap;
    return this;
  }
  
  @NotNull
  public final PTSLiteSwiperEventDispatcher a()
  {
    PTSLiteSwiperEventDispatcher localPTSLiteSwiperEventDispatcher = new PTSLiteSwiperEventDispatcher(null);
    PTSLiteSwiperEventDispatcher.a(localPTSLiteSwiperEventDispatcher, this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkReadInJoyBaseAdapter);
    PTSLiteSwiperEventDispatcher.a(localPTSLiteSwiperEventDispatcher, this.jdField_a_of_type_JavaUtilHashMap);
    PTSLiteSwiperEventDispatcher.b(localPTSLiteSwiperEventDispatcher, this.b);
    return localPTSLiteSwiperEventDispatcher;
  }
  
  @NotNull
  public final Builder b(@NotNull HashMap<String, AbsBaseArticleInfo> paramHashMap)
  {
    Intrinsics.checkParameterIsNotNull(paramHashMap, "articleInfoMap");
    this.b = paramHashMap;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.lite.PTSLiteSwiperEventDispatcher.Builder
 * JD-Core Version:    0.7.0.1
 */