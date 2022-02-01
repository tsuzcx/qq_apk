import android.view.ViewGroup;
import com.tencent.biz.pubaccount.readinjoy.pts.lite.PTSLitePlayableCardView;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/pts/util/PTSLiteItemViewUtil$Companion;", "", "()V", "CARD_TYPE_NORMAL", "", "CARD_TYPE_SPECIAL", "DIVIDER_BAR_COLOR", "DIVIDER_BAR_HEIGHT", "getDIVIDER_BAR_HEIGHT", "()I", "DIVIDER_LINE_COLOR", "DIVIDER_LINE_HEIGHT", "DIVIDER_ROUND_MARGIN_HORIZONTAL", "getDIVIDER_ROUND_MARGIN_HORIZONTAL", "setDIVIDER_ROUND_MARGIN_HORIZONTAL", "(I)V", "DIVIDER_SQUARE_MARGIN_HORIZONTAL", "getDIVIDER_SQUARE_MARGIN_HORIZONTAL", "setDIVIDER_SQUARE_MARGIN_HORIZONTAL", "DIVIDER_TYPE_NULL", "DIVIDER_TYPE_ROUND_LINE", "DIVIDER_TYPE_SQUARE_BAR", "DIVIDER_TYPE_SQUARE_LINE", "STYLE_TYPE_ROUND", "STYLE_TYPE_SQUARE", "TAG", "", "markWhiteList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "showMark", "", "getShowMark", "()Z", "setShowMark", "(Z)V", "addMarkText", "", "ptsItemView", "Landroid/view/ViewGroup;", "getCardType", "articleInfo", "Lcom/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo;", "cellType", "getDividerType", "readInJoyModel", "Lcom/tencent/biz/pubaccount/readinjoy/model/IReadInJoyModel;", "handleFooter", "ptsLitePlayableCardView", "Lcom/tencent/biz/pubaccount/readinjoy/pts/lite/PTSLitePlayableCardView;", "adapter", "Lcom/tencent/biz/pubaccount/readinjoy/view/ReadInJoyBaseAdapter;", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class qpg
{
  private final int a(pxk parampxk)
  {
    int i = 1;
    if (parampxk.g()) {
      i = 3;
    }
    ArticleInfo localArticleInfo1;
    do
    {
      return i;
      localArticleInfo1 = parampxk.a();
      if (localArticleInfo1 == null) {
        break;
      }
      if (localArticleInfo1.ptsRoundCornerCard) {
        return 2;
      }
    } while ((int)localArticleInfo1.mChannelID == 70);
    int j = parampxk.a();
    ArticleInfo localArticleInfo2 = parampxk.b();
    i = parampxk.b();
    j = ((qpg)this).a(localArticleInfo1, j);
    i = ((qpg)this).a(localArticleInfo2, i);
    if ((j == 0) && (i == 0)) {}
    for (i = 0;; i = 1) {
      return i;
    }
    return 0;
  }
  
  public final int a()
  {
    return qpf.a();
  }
  
  public final int a(@Nullable ArticleInfo paramArticleInfo, int paramInt)
  {
    if (((qnu.a((BaseArticleInfo)paramArticleInfo)) && (paramArticleInfo != null) && (paramArticleInfo.ptsSpecialCard == true)) || ((!qnu.a((BaseArticleInfo)paramArticleInfo)) && (!pfr.b(paramInt)))) {
      return 1;
    }
    return 0;
  }
  
  public final void a(@NotNull ViewGroup paramViewGroup)
  {
    Intrinsics.checkParameterIsNotNull(paramViewGroup, "ptsItemView");
  }
  
  public final void a(@NotNull pxk parampxk, @NotNull PTSLitePlayableCardView paramPTSLitePlayableCardView, @NotNull snh paramsnh)
  {
    Intrinsics.checkParameterIsNotNull(parampxk, "readInJoyModel");
    Intrinsics.checkParameterIsNotNull(paramPTSLitePlayableCardView, "ptsLitePlayableCardView");
    Intrinsics.checkParameterIsNotNull(paramsnh, "adapter");
    paramPTSLitePlayableCardView.a(((qpg)this).a(parampxk));
    paramPTSLitePlayableCardView.a(parampxk, paramsnh);
  }
  
  public final int b()
  {
    return qpf.b();
  }
  
  public final int c()
  {
    return qpf.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qpg
 * JD-Core Version:    0.7.0.1
 */