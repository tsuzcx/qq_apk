package com.tencent.mobileqq.kandian.biz.account.api.impl;

import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.kandian.biz.framework.ReadInJoyBaseAdapter;
import com.tencent.mobileqq.kandian.biz.pts.component.FeedItemCellTypeRecommendFollow;
import kotlin.Metadata;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "Lcom/tencent/mobileqq/kandian/biz/pts/component/FeedItemCellTypeRecommendFollow;", "Landroid/view/View;", "context", "Landroid/content/Context;", "faceDecoder", "Lcom/tencent/mobileqq/app/face/IFaceDecoder;", "adapter", "Lcom/tencent/mobileqq/kandian/biz/framework/ReadInJoyBaseAdapter;", "clazz", "Ljava/lang/Class;", "invoke"}, k=3, mv={1, 1, 16})
final class CellFactoryImpl$recommendFollowFeedItemCellMap$1
  extends Lambda
  implements Function4<Context, IFaceDecoder, ReadInJoyBaseAdapter, Class<? extends View>, FeedItemCellTypeRecommendFollow<? extends View>>
{
  public static final 1 INSTANCE = new 1();
  
  CellFactoryImpl$recommendFollowFeedItemCellMap$1()
  {
    super(4);
  }
  
  @NotNull
  public final FeedItemCellTypeRecommendFollow<? extends View> invoke(@NotNull Context paramContext, @Nullable IFaceDecoder paramIFaceDecoder, @Nullable ReadInJoyBaseAdapter paramReadInJoyBaseAdapter, @NotNull Class<? extends View> paramClass)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    Intrinsics.checkParameterIsNotNull(paramClass, "clazz");
    return new FeedItemCellTypeRecommendFollow(paramContext, paramIFaceDecoder, paramReadInJoyBaseAdapter, paramClass);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.account.api.impl.CellFactoryImpl.recommendFollowFeedItemCellMap.1
 * JD-Core Version:    0.7.0.1
 */