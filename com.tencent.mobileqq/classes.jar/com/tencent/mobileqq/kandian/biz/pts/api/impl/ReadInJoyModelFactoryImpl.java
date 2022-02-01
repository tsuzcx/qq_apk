package com.tencent.mobileqq.kandian.biz.pts.api.impl;

import android.content.Context;
import com.tencent.mobileqq.kandian.biz.common.baseui.IReadInJoyBaseAdapter;
import com.tencent.mobileqq.kandian.biz.pts.ReadInJoyModelImpl;
import com.tencent.mobileqq.kandian.biz.pts.api.IReadInJoyModelFactory;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.api.IReadInJoyModel;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/pts/api/impl/ReadInJoyModelFactoryImpl;", "Lcom/tencent/mobileqq/kandian/biz/pts/api/IReadInJoyModelFactory;", "()V", "createReadInJoyModel", "Lcom/tencent/mobileqq/kandian/repo/feeds/entity/api/IReadInJoyModel;", "context", "Landroid/content/Context;", "article", "Lcom/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo;", "cellType", "", "channelID", "channelType", "position", "needShowLastReadPositionView", "", "total", "nextArticle", "adapter", "Lcom/tencent/mobileqq/kandian/biz/common/baseui/IReadInJoyBaseAdapter;", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class ReadInJoyModelFactoryImpl
  implements IReadInJoyModelFactory
{
  @NotNull
  public IReadInJoyModel createReadInJoyModel(@Nullable Context paramContext, @Nullable AbsBaseArticleInfo paramAbsBaseArticleInfo1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean, int paramInt5, @Nullable AbsBaseArticleInfo paramAbsBaseArticleInfo2, @Nullable IReadInJoyBaseAdapter paramIReadInJoyBaseAdapter)
  {
    return (IReadInJoyModel)new ReadInJoyModelImpl(paramContext, paramAbsBaseArticleInfo1, paramInt1, paramInt2, paramInt3, paramInt4, paramBoolean, paramInt5, paramAbsBaseArticleInfo2, paramIReadInJoyBaseAdapter);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.api.impl.ReadInJoyModelFactoryImpl
 * JD-Core Version:    0.7.0.1
 */