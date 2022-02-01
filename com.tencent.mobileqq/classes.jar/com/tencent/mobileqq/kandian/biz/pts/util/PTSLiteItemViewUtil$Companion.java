package com.tencent.mobileqq.kandian.biz.pts.util;

import android.view.ViewGroup;
import com.tencent.mobileqq.kandian.biz.framework.ReadInJoyBaseAdapter;
import com.tencent.mobileqq.kandian.biz.pts.lite.PTSLiteItemViewBuilder;
import com.tencent.mobileqq.kandian.biz.pts.lite.PTSLitePlayableCardView;
import com.tencent.mobileqq.kandian.glue.pts.util.ProteusSupportUtil;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.api.IReadInJoyModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/pts/util/PTSLiteItemViewUtil$Companion;", "", "()V", "CARD_TYPE_NORMAL", "", "CARD_TYPE_SPECIAL", "DIVIDER_BAR_COLOR", "DIVIDER_BAR_HEIGHT", "getDIVIDER_BAR_HEIGHT", "()I", "DIVIDER_LINE_COLOR", "DIVIDER_LINE_HEIGHT", "DIVIDER_ROUND_MARGIN_HORIZONTAL", "getDIVIDER_ROUND_MARGIN_HORIZONTAL", "setDIVIDER_ROUND_MARGIN_HORIZONTAL", "(I)V", "DIVIDER_SQUARE_MARGIN_HORIZONTAL", "getDIVIDER_SQUARE_MARGIN_HORIZONTAL", "setDIVIDER_SQUARE_MARGIN_HORIZONTAL", "DIVIDER_TYPE_NULL", "DIVIDER_TYPE_ROUND_LINE", "DIVIDER_TYPE_SQUARE_BAR", "DIVIDER_TYPE_SQUARE_LINE", "STYLE_TYPE_ROUND", "STYLE_TYPE_SQUARE", "TAG", "", "markWhiteList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "showMark", "", "getShowMark", "()Z", "setShowMark", "(Z)V", "addMarkText", "", "ptsItemView", "Landroid/view/ViewGroup;", "getCardType", "articleInfo", "Lcom/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo;", "cellType", "getDividerType", "readInJoyModel", "Lcom/tencent/mobileqq/kandian/repo/feeds/entity/api/IReadInJoyModel;", "handleFooter", "ptsLitePlayableCardView", "Lcom/tencent/mobileqq/kandian/biz/pts/lite/PTSLitePlayableCardView;", "adapter", "Lcom/tencent/mobileqq/kandian/biz/framework/ReadInJoyBaseAdapter;", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class PTSLiteItemViewUtil$Companion
{
  private final int a(IReadInJoyModel paramIReadInJoyModel)
  {
    boolean bool = paramIReadInJoyModel.g();
    int j = 3;
    if (bool) {
      return 3;
    }
    AbsBaseArticleInfo localAbsBaseArticleInfo1 = paramIReadInJoyModel.a();
    int k = paramIReadInJoyModel.d();
    AbsBaseArticleInfo localAbsBaseArticleInfo2 = paramIReadInJoyModel.b();
    int i = paramIReadInJoyModel.e();
    paramIReadInJoyModel = (Companion)this;
    k = paramIReadInJoyModel.a(localAbsBaseArticleInfo1, k);
    int m = paramIReadInJoyModel.a(localAbsBaseArticleInfo2, i);
    i = 0;
    if (localAbsBaseArticleInfo1 != null)
    {
      if (localAbsBaseArticleInfo1.ptsRoundCornerCard)
      {
        i = j;
        if (k == 0)
        {
          i = j;
          if (m == 0) {
            i = 2;
          }
        }
        return i;
      }
      if ((int)localAbsBaseArticleInfo1.mChannelID == 70) {
        return 1;
      }
      if ((k == 0) && (m == 0)) {
        return 0;
      }
      i = 1;
    }
    return i;
  }
  
  public final int a()
  {
    return PTSLiteItemViewUtil.a();
  }
  
  public final int a(@Nullable AbsBaseArticleInfo paramAbsBaseArticleInfo, int paramInt)
  {
    boolean bool = PTSLiteItemViewBuilder.b(paramAbsBaseArticleInfo);
    int i = 1;
    if ((!bool) || (paramAbsBaseArticleInfo == null) || (paramAbsBaseArticleInfo.ptsSpecialCard != true))
    {
      if ((!PTSLiteItemViewBuilder.b(paramAbsBaseArticleInfo)) && (!ProteusSupportUtil.b(paramInt))) {
        return 1;
      }
      i = 0;
    }
    return i;
  }
  
  public final void a(@NotNull ViewGroup paramViewGroup)
  {
    Intrinsics.checkParameterIsNotNull(paramViewGroup, "ptsItemView");
  }
  
  public final void a(@NotNull IReadInJoyModel paramIReadInJoyModel, @NotNull PTSLitePlayableCardView paramPTSLitePlayableCardView, @NotNull ReadInJoyBaseAdapter paramReadInJoyBaseAdapter)
  {
    Intrinsics.checkParameterIsNotNull(paramIReadInJoyModel, "readInJoyModel");
    Intrinsics.checkParameterIsNotNull(paramPTSLitePlayableCardView, "ptsLitePlayableCardView");
    Intrinsics.checkParameterIsNotNull(paramReadInJoyBaseAdapter, "adapter");
    paramPTSLitePlayableCardView.a(((Companion)this).a(paramIReadInJoyModel));
    paramPTSLitePlayableCardView.a(paramIReadInJoyModel, paramReadInJoyBaseAdapter);
  }
  
  public final int b()
  {
    return PTSLiteItemViewUtil.b();
  }
  
  public final int c()
  {
    return PTSLiteItemViewUtil.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.util.PTSLiteItemViewUtil.Companion
 * JD-Core Version:    0.7.0.1
 */