package com.tencent.mobileqq.kandian.biz.video.playfeeds.viewholder;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.kandian.biz.common.baseui.RR.id;
import com.tencent.mobileqq.kandian.biz.common.baseui.RR.id.Companion;
import com.tencent.mobileqq.kandian.biz.video.api.IBaseVideoItemHolder;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.api.IMsgLayoutHelper;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.api.IMsgLayoutHelperFactory;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.api.IVideoFeedsItemUIDelegate;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.api.IVideoFeedsVideoUIDelegate;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.AbsVideoFeedsGestureLayout;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoInfo;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoPlayParam;
import com.tencent.mobileqq.qroute.QRoute;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/video/playfeeds/viewholder/BaseVideoItemHolder;", "Lcom/tencent/mobileqq/kandian/biz/video/playfeeds/viewholder/BaseItemHolder;", "Lcom/tencent/mobileqq/kandian/biz/video/api/IBaseVideoItemHolder;", "view", "Landroid/view/View;", "itemType", "", "(Landroid/view/View;I)V", "autoSeekBar", "Landroid/widget/SeekBar;", "bottomSeekbarLayout", "Landroid/view/ViewGroup;", "coverImageView", "Lcom/tencent/image/URLImageView;", "currentTimeTextView", "Landroid/widget/TextView;", "delegate", "Lcom/tencent/mobileqq/kandian/biz/video/playfeeds/api/IVideoFeedsItemUIDelegate;", "exitFullScreenButton", "fullOperationIconImageView", "Landroid/widget/ImageView;", "fullOperationLayout", "fullScreenLayout", "fullTitleTextView", "gestureLayout", "Lcom/tencent/mobileqq/kandian/biz/video/playfeeds/entity/AbsVideoFeedsGestureLayout;", "kingcardGuideTextView", "msgLayoutHelper", "Lcom/tencent/mobileqq/kandian/biz/video/playfeeds/api/IMsgLayoutHelper;", "playButton", "playButtonLayout", "seekBar", "speedRatioBtn", "speedRatioContainer", "totalTimeTextView", "videoArea", "videoAreaBottomOffset", "videoControllerLayout", "videoEndMaskView", "videoInfoShowTextViewDebug", "videoLayout", "videoPlayParam", "Lcom/tencent/mobileqq/kandian/biz/video/playfeeds/entity/VideoPlayParam;", "videoUIDelegate", "Lcom/tencent/mobileqq/kandian/biz/video/playfeeds/api/IVideoFeedsVideoUIDelegate;", "volumeIcon", "xgFileSizeBlackToast", "xgFileSizeTextView", "isAd", "", "kandian-api_release"}, k=1, mv={1, 1, 16})
public class BaseVideoItemHolder
  extends BaseItemHolder
  implements IBaseVideoItemHolder
{
  @JvmField
  @Nullable
  public IVideoFeedsItemUIDelegate aA;
  @JvmField
  @Nullable
  public IVideoFeedsVideoUIDelegate aB;
  @JvmField
  @NotNull
  public IMsgLayoutHelper aC;
  @JvmField
  public int aD;
  @JvmField
  @NotNull
  public ViewGroup aa;
  @JvmField
  @NotNull
  public ViewGroup ab;
  @JvmField
  @NotNull
  public AbsVideoFeedsGestureLayout ac;
  @JvmField
  @NotNull
  public ImageView ad;
  @JvmField
  @NotNull
  public ViewGroup ae;
  @JvmField
  @NotNull
  public ViewGroup af;
  @JvmField
  @NotNull
  public ViewGroup ag;
  @JvmField
  @NotNull
  public ImageView ah;
  @JvmField
  @NotNull
  public SeekBar ai;
  @JvmField
  @NotNull
  public SeekBar aj;
  @JvmField
  @NotNull
  public TextView ak;
  @JvmField
  @NotNull
  public TextView al;
  @JvmField
  @NotNull
  public TextView am;
  @JvmField
  @NotNull
  public ViewGroup an;
  @JvmField
  @NotNull
  public URLImageView ao;
  @JvmField
  @NotNull
  public ViewGroup ap;
  @JvmField
  @NotNull
  public TextView aq;
  @JvmField
  @NotNull
  public TextView ar;
  @JvmField
  @NotNull
  public TextView as;
  @JvmField
  @NotNull
  public ViewGroup at;
  @JvmField
  @NotNull
  public ImageView au;
  @JvmField
  @NotNull
  public TextView av;
  @JvmField
  @NotNull
  public View aw;
  @JvmField
  @Nullable
  public ViewGroup ax;
  @JvmField
  @Nullable
  public ImageView ay;
  @JvmField
  @Nullable
  public VideoPlayParam az;
  
  public BaseVideoItemHolder(@NotNull View paramView, int paramInt)
  {
    super(paramView, paramInt);
    View localView = paramView.findViewById(RR.id.a.a());
    Intrinsics.checkExpressionValueIsNotNull(localView, "view.findViewById(R.id.inner_auto_seekBar)");
    this.aj = ((SeekBar)localView);
    paramView = paramView.findViewById(RR.id.a.b());
    Intrinsics.checkExpressionValueIsNotNull(paramView, "view.findViewById(R.id.common_content_view_group)");
    this.aa = ((ViewGroup)paramView);
    paramView = (View)this.aa;
    localView = paramView.findViewById(RR.id.a.c());
    Intrinsics.checkExpressionValueIsNotNull(localView, "root.findViewById(R.id.video_layout)");
    this.ab = ((ViewGroup)localView);
    localView = paramView.findViewById(RR.id.a.d());
    if (localView != null)
    {
      if (localView != null)
      {
        this.ac = ((AbsVideoFeedsGestureLayout)localView);
        localView = paramView.findViewById(RR.id.a.e());
        Intrinsics.checkExpressionValueIsNotNull(localView, "root.findViewById(R.id.cover_imageview)");
        this.ao = ((URLImageView)localView);
        localView = paramView.findViewById(RR.id.a.f());
        Intrinsics.checkExpressionValueIsNotNull(localView, "root.findViewById(R.id.play_button)");
        this.ad = ((ImageView)localView);
        localView = paramView.findViewById(RR.id.a.g());
        Intrinsics.checkExpressionValueIsNotNull(localView, "root.findViewById(R.id.video_controller_layout)");
        this.af = ((ViewGroup)localView);
        localView = paramView.findViewById(RR.id.a.h());
        Intrinsics.checkExpressionValueIsNotNull(localView, "root.findViewById(R.id.seekbar)");
        this.ai = ((SeekBar)localView);
        localView = paramView.findViewById(RR.id.a.i());
        Intrinsics.checkExpressionValueIsNotNull(localView, "root.findViewById(R.id.current_time_textview)");
        this.ak = ((TextView)localView);
        localView = paramView.findViewById(RR.id.a.j());
        Intrinsics.checkExpressionValueIsNotNull(localView, "root.findViewById(R.id.total_time_textview)");
        this.am = ((TextView)localView);
        localView = paramView.findViewById(RR.id.a.k());
        Intrinsics.checkExpressionValueIsNotNull(localView, "root.findViewById(R.id.play_button_layout)");
        this.ae = ((ViewGroup)localView);
        localView = paramView.findViewById(RR.id.a.l());
        Intrinsics.checkExpressionValueIsNotNull(localView, "root.findViewById(R.id.bottom_controller_layout)");
        this.ap = ((ViewGroup)localView);
        localView = paramView.findViewById(RR.id.a.m());
        Intrinsics.checkExpressionValueIsNotNull(localView, "root.findViewById(R.id.full_screen_operation)");
        this.at = ((ViewGroup)localView);
        localView = paramView.findViewById(RR.id.a.n());
        Intrinsics.checkExpressionValueIsNotNull(localView, "root.findViewById(R.id.full_screen_operation_icon)");
        this.au = ((ImageView)localView);
        localView = paramView.findViewById(RR.id.a.o());
        Intrinsics.checkExpressionValueIsNotNull(localView, "root.findViewById(R.id.operate_button_xg)");
        this.aq = ((TextView)localView);
        localView = paramView.findViewById(RR.id.a.p());
        Intrinsics.checkExpressionValueIsNotNull(localView, "root.findViewById(R.id.file_size_black_toast)");
        this.ar = ((TextView)localView);
        localView = paramView.findViewById(RR.id.a.q());
        Intrinsics.checkExpressionValueIsNotNull(localView, "root.findViewById(R.id.king_card_guide)");
        this.as = ((TextView)localView);
        localView = paramView.findViewById(RR.id.a.r());
        Intrinsics.checkExpressionValueIsNotNull(localView, "root.findViewById(R.id.show_video_info_for_debug)");
        this.al = ((TextView)localView);
        localView = paramView.findViewById(RR.id.a.s());
        Intrinsics.checkExpressionValueIsNotNull(localView, "root.findViewById(R.id.full_screen_layout)");
        this.ag = ((ViewGroup)localView);
        localView = paramView.findViewById(RR.id.a.t());
        Intrinsics.checkExpressionValueIsNotNull(localView, "root.findViewById(R.id.close_button)");
        this.an = ((ViewGroup)localView);
        localView = paramView.findViewById(RR.id.a.u());
        Intrinsics.checkExpressionValueIsNotNull(localView, "root.findViewById(R.id.full_screen_title)");
        this.av = ((TextView)localView);
        localView = paramView.findViewById(RR.id.a.v());
        Intrinsics.checkExpressionValueIsNotNull(localView, "root.findViewById(R.id.video_volume_icon)");
        this.ah = ((ImageView)localView);
        localView = paramView.findViewById(RR.id.a.w());
        Intrinsics.checkExpressionValueIsNotNull(localView, "root.findViewById(R.id.video_end_mask_view)");
        this.aw = localView;
        this.ay = ((ImageView)paramView.findViewById(RR.id.a.x()));
        this.ax = ((ViewGroup)paramView.findViewById(RR.id.a.y()));
        this.aC = ((IMsgLayoutHelperFactory)QRoute.api(IMsgLayoutHelperFactory.class)).create(paramView, null);
        return;
      }
      throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.AbsVideoFeedsGestureLayout");
    }
    throw new TypeCastException("null cannot be cast to non-null type android.view.View");
  }
  
  public boolean L()
  {
    VideoPlayParam localVideoPlayParam = this.az;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (localVideoPlayParam != null)
    {
      bool1 = bool2;
      if (localVideoPlayParam.c != null)
      {
        bool1 = bool2;
        if (localVideoPlayParam.c.aq)
        {
          bool1 = bool2;
          if (localVideoPlayParam.c.n()) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.playfeeds.viewholder.BaseVideoItemHolder
 * JD-Core Version:    0.7.0.1
 */