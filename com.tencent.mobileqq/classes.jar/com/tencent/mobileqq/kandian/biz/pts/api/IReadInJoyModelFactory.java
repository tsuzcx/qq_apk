package com.tencent.mobileqq.kandian.biz.pts.api;

import android.content.Context;
import com.tencent.mobileqq.kandian.biz.common.baseui.IReadInJoyBaseAdapter;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.api.IReadInJoyModel;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@QAPI(process={"all"})
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/pts/api/IReadInJoyModelFactory;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "createReadInJoyModel", "Lcom/tencent/mobileqq/kandian/repo/feeds/entity/api/IReadInJoyModel;", "context", "Landroid/content/Context;", "article", "Lcom/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo;", "cellType", "", "channelID", "channelType", "position", "needShowLastReadPositionView", "", "total", "nextArticle", "adapter", "Lcom/tencent/mobileqq/kandian/biz/common/baseui/IReadInJoyBaseAdapter;", "kandian-api_release"}, k=1, mv={1, 1, 16})
public abstract interface IReadInJoyModelFactory
  extends QRouteApi
{
  @NotNull
  public abstract IReadInJoyModel createReadInJoyModel(@Nullable Context paramContext, @Nullable AbsBaseArticleInfo paramAbsBaseArticleInfo1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean, int paramInt5, @Nullable AbsBaseArticleInfo paramAbsBaseArticleInfo2, @Nullable IReadInJoyBaseAdapter paramIReadInJoyBaseAdapter);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.api.IReadInJoyModelFactory
 * JD-Core Version:    0.7.0.1
 */