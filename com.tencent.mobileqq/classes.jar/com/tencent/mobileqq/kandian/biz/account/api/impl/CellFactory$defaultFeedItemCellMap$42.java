package com.tencent.mobileqq.kandian.biz.account.api.impl;

import android.content.Context;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.kandian.biz.framework.ReadInJoyBaseAdapter;
import com.tencent.mobileqq.kandian.biz.pts.component.FeedItemCellTypeTopicSocial;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "Lcom/tencent/mobileqq/kandian/biz/pts/component/FeedItemCellTypeTopicSocial;", "context", "Landroid/content/Context;", "faceDecoder", "Lcom/tencent/mobileqq/app/face/IFaceDecoder;", "adapter", "Lcom/tencent/mobileqq/kandian/biz/framework/ReadInJoyBaseAdapter;", "invoke"}, k=3, mv={1, 1, 16})
final class CellFactory$defaultFeedItemCellMap$42
  extends Lambda
  implements Function3<Context, IFaceDecoder, ReadInJoyBaseAdapter, FeedItemCellTypeTopicSocial>
{
  public static final 42 INSTANCE = new 42();
  
  CellFactory$defaultFeedItemCellMap$42()
  {
    super(3);
  }
  
  @NotNull
  public final FeedItemCellTypeTopicSocial invoke(@NotNull Context paramContext, @Nullable IFaceDecoder paramIFaceDecoder, @Nullable ReadInJoyBaseAdapter paramReadInJoyBaseAdapter)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    return new FeedItemCellTypeTopicSocial(paramContext, paramIFaceDecoder, paramReadInJoyBaseAdapter);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.account.api.impl.CellFactory.defaultFeedItemCellMap.42
 * JD-Core Version:    0.7.0.1
 */