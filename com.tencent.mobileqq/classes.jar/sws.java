import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsGradientMaskView;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsStressFollowLayout;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsStressFollowLayout.StressState;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyHeadImageView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.util.DisplayUtil;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/video/videofeeds/TiktokVideoItemDelegate;", "Lcom/tencent/biz/pubaccount/readinjoy/video/videofeeds/ShortVideoItemDelegate;", "Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsStressFollowLayout$OnFollowActionListener;", "videoHolder", "Lcom/tencent/biz/pubaccount/readinjoy/video/videofeeds/TiktokVideoItemHolder;", "presenter", "Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendPresenter;", "adapter", "Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsAdapter;", "(Lcom/tencent/biz/pubaccount/readinjoy/video/videofeeds/TiktokVideoItemHolder;Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendPresenter;Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsAdapter;)V", "getDianZanDrawable", "", "isDianZan", "", "getRewardCoinIconRes", "info", "Lcom/tencent/biz/pubaccount/VideoInfo;", "onFollowClick", "", "videoInfo", "refreshContentUI", "isNeedReloadTitle", "refreshMenuUI", "setFooterVisibility", "visible", "setHeaderVisibility", "updateCommentUI", "updateFollowStateAndUI", "needAnim", "updateStressFollowLayoutUi", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class sws
  extends swq
  implements sor
{
  private final swt a;
  
  public sws(@NotNull swt paramswt, @NotNull slr paramslr, @NotNull shl paramshl)
  {
    super((swr)paramswt, paramslr, paramshl);
    this.jdField_a_of_type_Swt = paramswt;
    paramswt = six.b(paramslr.a());
    if (paramswt[1] / paramswt[0] >= 1.97D)
    {
      paramswt = this.jdField_a_of_type_Swt;
      paramslr = this.jdField_a_of_type_Swt.p;
      if (paramslr == null) {
        break label128;
      }
      paramslr = paramslr.getLayoutParams();
      if (paramslr == null) {
        break label128;
      }
    }
    label128:
    for (int i = paramslr.height;; i = 0)
    {
      paramswt.d = i;
      paramswt = this.jdField_a_of_type_Swt.p;
      if (paramswt != null) {
        paramswt.setBackgroundDrawable(null);
      }
      this.jdField_a_of_type_Swt.a().a((sor)this);
      return;
    }
  }
  
  private final void d(VideoInfo paramVideoInfo)
  {
    if (paramVideoInfo.q) {
      paramVideoInfo.a = VideoFeedsStressFollowLayout.StressState.Shrink;
    }
    this.jdField_a_of_type_Swt.a().setVideoInfo(paramVideoInfo);
    soh localsoh = this.jdField_a_of_type_Swt.jdField_a_of_type_Soh;
    paramVideoInfo = paramVideoInfo.a;
    Intrinsics.checkExpressionValueIsNotNull(paramVideoInfo, "videoInfo.stressState");
    localsoh.a(paramVideoInfo);
  }
  
  protected int a(@NotNull VideoInfo paramVideoInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramVideoInfo, "info");
    if (paramVideoInfo.o) {
      return 2130843197;
    }
    return 2130843199;
  }
  
  public int a(boolean paramBoolean)
  {
    if (paramBoolean) {
      return 2130843195;
    }
    return 2130843198;
  }
  
  public void a(@Nullable VideoInfo paramVideoInfo)
  {
    long l2 = -1L;
    Object localObject;
    if (paramVideoInfo != null)
    {
      this.jdField_a_of_type_Shl.a(paramVideoInfo.j, paramVideoInfo.b, paramVideoInfo.p);
      if (this.jdField_a_of_type_Swt.jdField_a_of_type_Skq == null) {
        break label144;
      }
      localObject = this.jdField_a_of_type_Swt.jdField_a_of_type_Skq;
      if (localObject == null) {
        break label138;
      }
      localObject = ((skq)localObject).jdField_a_of_type_Spn;
      paramVideoInfo = new suu(paramVideoInfo);
      if (localObject == null) {
        break label150;
      }
    }
    label138:
    label144:
    label150:
    for (long l1 = ((spn)localObject).a();; l1 = -1L)
    {
      paramVideoInfo = paramVideoInfo.a(l1);
      l1 = l2;
      if (localObject != null) {
        l1 = ((spn)localObject).b();
      }
      olh.a(null, "", "0X80078FD", "0X80078FD", 0, 0, "3", "", "", paramVideoInfo.c(l1).ae(1).M(0).a().a(), false);
      return;
      localObject = null;
      break;
      localObject = null;
      break;
    }
  }
  
  public void a(@NotNull VideoInfo paramVideoInfo, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramVideoInfo, "videoInfo");
    super.a(paramVideoInfo, paramBoolean);
    if (this.jdField_a_of_type_Slr.a() != null)
    {
      QQAppInterface localQQAppInterface = this.jdField_a_of_type_Slr.a();
      if (localQQAppInterface != null)
      {
        long l = localQQAppInterface.getLongAccountUin();
        this.jdField_a_of_type_Swt.a().setHeadImgByUin(l);
      }
    }
    if (paramVideoInfo.b(this.jdField_a_of_type_Slr.a()))
    {
      this.jdField_a_of_type_Swt.b().setVisibility(0);
      return;
    }
    this.jdField_a_of_type_Swt.a().setVisibility(8);
    this.jdField_a_of_type_Swt.b().setVisibility(8);
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      localObject = this.jdField_a_of_type_Swt.jdField_a_of_type_Skq;
      if (localObject != null)
      {
        localObject = ((skq)localObject).jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
        if ((localObject != null) && (((VideoInfo)localObject).q == true))
        {
          localObject = this.jdField_a_of_type_Swt.g();
          if (localObject != null) {
            ((TextView)localObject).setVisibility(0);
          }
        }
      }
      this.jdField_a_of_type_Swt.e().setVisibility(0);
      return;
    }
    Object localObject = this.jdField_a_of_type_Swt.g();
    if (localObject != null) {
      ((TextView)localObject).setVisibility(8);
    }
    this.jdField_a_of_type_Swt.e().setVisibility(8);
  }
  
  public void a_(@NotNull VideoInfo paramVideoInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramVideoInfo, "videoInfo");
    super.a_(paramVideoInfo);
    d(paramVideoInfo);
  }
  
  protected void b(@NotNull VideoInfo paramVideoInfo, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramVideoInfo, "info");
    d(paramVideoInfo);
    if (paramVideoInfo.a == VideoFeedsStressFollowLayout.StressState.Stretched)
    {
      if (this.jdField_a_of_type_Swt.jdField_a_of_type_Sfb == null) {}
      do
      {
        do
        {
          return;
          paramVideoInfo = this.jdField_a_of_type_Swt.jdField_a_of_type_Sfb;
        } while (paramVideoInfo == null);
        paramVideoInfo = paramVideoInfo.a();
      } while (paramVideoInfo == null);
      paramVideoInfo.setVisibility(8);
      return;
    }
    super.b(paramVideoInfo, paramBoolean);
  }
  
  public void c(@NotNull VideoInfo paramVideoInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramVideoInfo, "info");
    six.b(this.jdField_a_of_type_Swt.w, paramVideoInfo.e, "评论");
    paramVideoInfo = this.jdField_a_of_type_Swt.k;
    if (paramVideoInfo != null) {
      paramVideoInfo.setImageResource(2130843194);
    }
  }
  
  public void l(boolean paramBoolean)
  {
    super.l(paramBoolean);
    Object localObject = this.jdField_a_of_type_Swt.c().getLayoutParams();
    if (localObject == null) {
      throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    }
    localObject = (ViewGroup.MarginLayoutParams)localObject;
    if (paramBoolean) {}
    for (int i = DisplayUtil.dip2px((Context)this.jdField_a_of_type_Slr.a(), 86.0F);; i = DisplayUtil.dip2px((Context)this.jdField_a_of_type_Slr.a(), 5.0F))
    {
      ((ViewGroup.MarginLayoutParams)localObject).setMargins(((ViewGroup.MarginLayoutParams)localObject).leftMargin, ((ViewGroup.MarginLayoutParams)localObject).topMargin, i, ((ViewGroup.MarginLayoutParams)localObject).bottomMargin);
      this.jdField_a_of_type_Swt.c().setLayoutParams((ViewGroup.LayoutParams)localObject);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     sws
 * JD-Core Version:    0.7.0.1
 */