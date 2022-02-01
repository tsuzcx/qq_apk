package com.tencent.mobileqq.kandian.biz.video.playfeeds.viewholder;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.kandian.biz.common.baseui.RR.id;
import com.tencent.mobileqq.kandian.biz.common.baseui.RR.id.Companion;
import com.tencent.mobileqq.kandian.biz.common.widget.AbsReadInJoyNickNameTextView;
import com.tencent.mobileqq.kandian.biz.common.widget.AbsReadInJoyNickNameTextView.OnSetNickNameListener;
import com.tencent.mobileqq.kandian.biz.common.widget.IReadInJoyHeadImageView;
import com.tencent.mobileqq.kandian.biz.playfeeds.AbsVideoFeedsUGView;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.api.IVideoFeedsAccessibilityHelper;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.api.IVideoFeedsAccessibilityHelperFactory;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.api.IVideoFeedsFollowButton;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ReportPolicy;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.JvmField;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/video/playfeeds/viewholder/VideoItemHolder;", "Lcom/tencent/mobileqq/kandian/biz/video/playfeeds/viewholder/BaseVideoItemHolder;", "Lcom/tencent/mobileqq/kandian/biz/common/widget/AbsReadInJoyNickNameTextView$OnSetNickNameListener;", "rootView", "Landroid/view/View;", "itemType", "", "(Landroid/view/View;I)V", "adHeaderdownloadView", "Landroid/widget/FrameLayout;", "adverSign", "Landroid/widget/TextView;", "biuLayout", "Landroid/view/ViewGroup;", "contentLayout", "danmakuContainer", "getDanmakuContainer", "()Landroid/widget/FrameLayout;", "setDanmakuContainer", "(Landroid/widget/FrameLayout;)V", "followBtn", "Lcom/tencent/mobileqq/kandian/biz/video/playfeeds/api/IVideoFeedsFollowButton;", "footerBiuCountTextView", "footerBuiBtn", "Landroid/widget/ImageView;", "footerCommentBtn", "footerCommentBtnBg", "footerCommentBtnText", "footerDiversion", "footerLikeBtn", "footerLikeCountTextView", "footerViewGroup", "footerWriteCommentBar", "gameBarBtn", "gameBarContainer", "gameBarContent", "gameBarDownloadView", "gameBarThumbnail", "Lcom/tencent/image/URLImageView;", "gameBarTitle", "headerAccountIconImageView", "Lcom/tencent/mobileqq/kandian/biz/common/widget/IReadInJoyHeadImageView;", "headerAccountLayout", "headerAccountNameTextView", "Lcom/tencent/mobileqq/kandian/biz/common/widget/AbsReadInJoyNickNameTextView;", "headerAdBarTitleLayout", "headerAdContainer", "headerAdMore", "headerAdThumbnail", "headerAdTips", "headerAdTitle", "headerDiversion", "headerSmallGameAdContainer", "headerSoftAdContainer", "headerViewGroup", "hearAdBarIvDownload", "isShowingContent", "", "()Z", "setShowingContent", "(Z)V", "mAdBarCloseSmallV3", "mAdBarDescSmallV3", "mAdBarExpandLayoutSmallV3", "mAdBarThumbnailDescSmallV3", "mAdBarTipsPromotionSmallV3", "mAdBarTipsSmallV3", "mAdBarTitleSmallV3", "mAdBarTitleSmallV4", "mBigCardNormalView", "mBigCardNormalViewAms184", "mBigCardNormalViewAms65", "mBigCardNormalViewTest", "mHeadAdBarThumbnailSmallV3", "mHeadAdBarThumbnailSmallV4", "mSoftAdDownloadViewBig", "mSoftAdDownloadViewSmallV3", "mVideoFeedsHeaderTopAdContainerSmall", "mVideoFeedsHeaderTopAdContainerSmallV3", "Landroid/widget/LinearLayout;", "mVideoFeedsHeaderTopAdContainerSmallV4", "shareBtn", "shareGuideBtn", "shareLayout", "shuntBarCloseBtn", "shuntBarContainer", "shuntBarThumbnail", "shuntBarTitle", "smallGameBtnText", "smallGameDivider", "softAdBigCard", "softAdThumbnailCloseBtn", "strongShuntBarCloseBtn", "strongShuntBarContainer", "strongShuntBarJumpBtn", "strongShuntBarSubTitle", "strongShuntBarThumbnail", "strongShuntBarTitle", "strongShuntBarViewStub", "Landroid/view/ViewStub;", "titleTextView", "ugViewShoot", "Lcom/tencent/mobileqq/kandian/biz/playfeeds/AbsVideoFeedsUGView;", "ugViewTop", "videoFeedsAccessibilityHelper", "Lcom/tencent/mobileqq/kandian/biz/video/playfeeds/api/IVideoFeedsAccessibilityHelper;", "onSetNickName", "", "nickName", "", "kandian-api_release"}, k=1, mv={1, 1, 16})
public class VideoItemHolder
  extends BaseVideoItemHolder
  implements AbsReadInJoyNickNameTextView.OnSetNickNameListener
{
  private final IVideoFeedsAccessibilityHelper a;
  @JvmField
  @Nullable
  public AbsVideoFeedsUGView aE;
  @JvmField
  @Nullable
  public AbsVideoFeedsUGView aF;
  @JvmField
  @Nullable
  public TextView aG;
  @JvmField
  @Nullable
  public ViewGroup aH;
  @JvmField
  @Nullable
  public ViewGroup aI;
  @JvmField
  @Nullable
  public AbsReadInJoyNickNameTextView aJ;
  @JvmField
  @Nullable
  public IReadInJoyHeadImageView aK;
  @JvmField
  @Nullable
  public IVideoFeedsFollowButton aL;
  @JvmField
  @Nullable
  public View aM;
  @JvmField
  @Nullable
  public ViewGroup aN;
  @JvmField
  @Nullable
  public ViewGroup aO;
  @JvmField
  @Nullable
  public ImageView aP;
  @JvmField
  @Nullable
  public TextView aQ;
  @JvmField
  @Nullable
  public ImageView aR;
  @JvmField
  @Nullable
  public ImageView aS;
  @JvmField
  @Nullable
  public TextView aT;
  @JvmField
  @Nullable
  public TextView aU;
  @JvmField
  @Nullable
  public ViewGroup aV;
  @JvmField
  @Nullable
  public ViewGroup aW;
  @JvmField
  @Nullable
  public View aX;
  @JvmField
  @Nullable
  public ImageView aY;
  @JvmField
  @Nullable
  public ViewGroup aZ;
  private boolean b;
  @JvmField
  @Nullable
  public View bA;
  @JvmField
  @Nullable
  public View bB;
  @JvmField
  @Nullable
  public TextView bC;
  @JvmField
  @Nullable
  public FrameLayout bD;
  @JvmField
  @Nullable
  public ViewGroup bE;
  @JvmField
  @Nullable
  public ViewGroup bF;
  @JvmField
  @Nullable
  public URLImageView bG;
  @JvmField
  @Nullable
  public TextView bH;
  @JvmField
  @Nullable
  public TextView bI;
  @JvmField
  @Nullable
  public ImageView bJ;
  @JvmField
  @Nullable
  public ViewGroup bK;
  @JvmField
  @Nullable
  public TextView bL;
  @JvmField
  @Nullable
  public LinearLayout bM;
  @JvmField
  @Nullable
  public FrameLayout bN;
  @JvmField
  @Nullable
  public FrameLayout bO;
  @JvmField
  @Nullable
  public LinearLayout bP;
  @JvmField
  @Nullable
  public URLImageView bQ;
  @JvmField
  @Nullable
  public TextView bR;
  @JvmField
  @Nullable
  public View bS;
  @JvmField
  @Nullable
  public View bT;
  @JvmField
  @Nullable
  public View bU;
  @JvmField
  @Nullable
  public View bV;
  @JvmField
  @Nullable
  public View bW;
  @JvmField
  @Nullable
  public ViewGroup bX;
  @JvmField
  @NotNull
  public View bY;
  @JvmField
  @Nullable
  public ViewGroup ba;
  @JvmField
  @Nullable
  public URLImageView bb;
  @JvmField
  @Nullable
  public TextView bc;
  @JvmField
  @Nullable
  public View bd;
  @JvmField
  @Nullable
  public ViewGroup be;
  @JvmField
  @Nullable
  public ViewGroup bf;
  @JvmField
  @Nullable
  public ViewGroup bg;
  @JvmField
  @Nullable
  public URLImageView bh;
  @JvmField
  @Nullable
  public TextView bi;
  @JvmField
  @Nullable
  public TextView bj;
  @JvmField
  @Nullable
  public TextView bk;
  @JvmField
  @Nullable
  public TextView bl;
  @JvmField
  @Nullable
  public ViewStub bm;
  @JvmField
  @Nullable
  public ViewGroup bn;
  @JvmField
  @Nullable
  public URLImageView bo;
  @JvmField
  @Nullable
  public TextView bp;
  @JvmField
  @Nullable
  public View bq;
  @JvmField
  @Nullable
  public TextView br;
  @JvmField
  @Nullable
  public TextView bs;
  @JvmField
  @Nullable
  public TextView bt;
  @JvmField
  @Nullable
  public URLImageView bu;
  @JvmField
  @Nullable
  public TextView bv;
  @JvmField
  @Nullable
  public View bw;
  @JvmField
  @Nullable
  public TextView bx;
  @JvmField
  @Nullable
  public View by;
  @JvmField
  @Nullable
  public FrameLayout bz;
  @Nullable
  private FrameLayout c;
  
  public VideoItemHolder(@NotNull View paramView, int paramInt)
  {
    super(paramView, paramInt);
    this.bY = paramView;
    this.a = ((IVideoFeedsAccessibilityHelperFactory)QRoute.api(IVideoFeedsAccessibilityHelperFactory.class)).get();
    this.b = true;
    this.bS = this.bY.findViewById(RR.id.a.X());
    this.aG = ((TextView)this.bY.findViewById(RR.id.a.z()));
    this.aE = ((AbsVideoFeedsUGView)this.bY.findViewById(RR.id.a.A()));
    this.aF = ((AbsVideoFeedsUGView)this.bY.findViewById(RR.id.a.B()));
    this.aH = ((ViewGroup)this.bY.findViewById(RR.id.a.C()));
    this.aJ = ((AbsReadInJoyNickNameTextView)this.bY.findViewById(RR.id.a.D()));
    paramView = this.bY.findViewById(RR.id.a.E());
    if (paramView != null)
    {
      if (paramView != null)
      {
        this.aK = ((IReadInJoyHeadImageView)paramView);
        View localView = this.bY.findViewById(RR.id.a.F());
        paramView = localView;
        if (!(localView instanceof IVideoFeedsFollowButton)) {
          paramView = null;
        }
        this.aL = ((IVideoFeedsFollowButton)paramView);
        this.aN = ((ViewGroup)this.bY.findViewById(RR.id.a.G()));
        this.aR = ((ImageView)this.bY.findViewById(RR.id.a.H()));
        this.aV = ((ViewGroup)this.bY.findViewById(RR.id.a.I()));
        this.aS = ((ImageView)this.bY.findViewById(RR.id.a.J()));
        this.aO = ((ViewGroup)this.bY.findViewById(RR.id.a.K()));
        this.aP = ((ImageView)this.bY.findViewById(RR.id.a.L()));
        this.aQ = ((TextView)this.bY.findViewById(RR.id.a.M()));
        this.aM = this.bY.findViewById(RR.id.a.N());
        this.aT = ((TextView)this.bY.findViewById(RR.id.a.O()));
        this.aU = ((TextView)this.bY.findViewById(RR.id.a.P()));
        this.be = ((ViewGroup)this.bY.findViewById(RR.id.a.Q()));
        this.bf = ((ViewGroup)this.bY.findViewById(RR.id.a.R()));
        this.aZ = ((ViewGroup)this.bY.findViewById(RR.id.a.S()));
        this.bm = ((ViewStub)this.bY.findViewById(RR.id.a.T()));
        this.aW = ((ViewGroup)this.bY.findViewById(RR.id.a.U()));
        this.aX = this.bY.findViewById(RR.id.a.V());
        this.aY = ((ImageView)this.bY.findViewById(RR.id.a.W()));
        this.c = ((FrameLayout)this.bY.findViewById(RR.id.a.Y()));
        this.a.a(this.aJ, (AbsReadInJoyNickNameTextView.OnSetNickNameListener)this);
        VideoReport.setElementId(this.aH, "puin_button");
        VideoReport.setElementId(this.aL, "follow_button");
        VideoReport.setElementId(this.aM, "write_comment_button");
        VideoReport.setElementId(this.aO, "comment_button");
        VideoReport.setElementId(this.aS, "like_button");
        VideoReport.setElementId(this.aR, "biu_button");
        VideoReport.setElementId(this.ac, "card");
        VideoReport.setElementReportPolicy(this.ac, ReportPolicy.REPORT_POLICY_NONE);
        VideoReport.setElementId(this.ad, "card");
        VideoReport.setElementId(this.ax, "card");
        return;
      }
      throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.kandian.biz.common.widget.IReadInJoyHeadImageView");
    }
    throw new TypeCastException("null cannot be cast to non-null type android.view.View");
  }
  
  public final boolean M()
  {
    return this.b;
  }
  
  public void a(@Nullable String paramString)
  {
    Object localObject = this.aJ;
    if (localObject != null)
    {
      this.a.b((View)localObject, paramString);
      IVideoFeedsAccessibilityHelper localIVideoFeedsAccessibilityHelper = this.a;
      localObject = this.aK;
      if (localObject != null) {
        localObject = ((IReadInJoyHeadImageView)localObject).getView();
      } else {
        localObject = null;
      }
      localIVideoFeedsAccessibilityHelper.c((View)localObject, paramString);
    }
  }
  
  public final void a(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.playfeeds.viewholder.VideoItemHolder
 * JD-Core Version:    0.7.0.1
 */