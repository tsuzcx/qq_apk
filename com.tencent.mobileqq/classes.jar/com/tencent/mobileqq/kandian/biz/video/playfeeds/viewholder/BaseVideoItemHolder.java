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
  @NotNull
  public ViewGroup a;
  @JvmField
  @NotNull
  public SeekBar a;
  @JvmField
  @NotNull
  public IMsgLayoutHelper a;
  @JvmField
  @Nullable
  public IVideoFeedsItemUIDelegate a;
  @JvmField
  @Nullable
  public IVideoFeedsVideoUIDelegate a;
  @JvmField
  @NotNull
  public AbsVideoFeedsGestureLayout a;
  @JvmField
  @Nullable
  public VideoPlayParam a;
  @JvmField
  @NotNull
  public ViewGroup b;
  @JvmField
  @NotNull
  public SeekBar b;
  @JvmField
  @NotNull
  public ViewGroup c;
  @JvmField
  @NotNull
  public URLImageView c;
  @JvmField
  public int d;
  @JvmField
  @NotNull
  public ViewGroup d;
  @JvmField
  @NotNull
  public ViewGroup e;
  @JvmField
  @NotNull
  public ViewGroup f;
  @JvmField
  @NotNull
  public ViewGroup g;
  @JvmField
  @NotNull
  public ImageView g;
  @JvmField
  @NotNull
  public ViewGroup h;
  @JvmField
  @NotNull
  public ImageView h;
  @JvmField
  @Nullable
  public ViewGroup i;
  @JvmField
  @NotNull
  public ImageView i;
  @JvmField
  @Nullable
  public ImageView j;
  @JvmField
  @NotNull
  public View o;
  @JvmField
  @NotNull
  public TextView o;
  @JvmField
  @NotNull
  public TextView p;
  @JvmField
  @NotNull
  public TextView q;
  @JvmField
  @NotNull
  public TextView r;
  @JvmField
  @NotNull
  public TextView s;
  @JvmField
  @NotNull
  public TextView t;
  @JvmField
  @NotNull
  public TextView u;
  
  public BaseVideoItemHolder(@NotNull View paramView, int paramInt)
  {
    super(paramView, paramInt);
    View localView = paramView.findViewById(RR.id.a.a());
    Intrinsics.checkExpressionValueIsNotNull(localView, "view.findViewById(R.id.inner_auto_seekBar)");
    this.jdField_b_of_type_AndroidWidgetSeekBar = ((SeekBar)localView);
    paramView = paramView.findViewById(RR.id.a.b());
    Intrinsics.checkExpressionValueIsNotNull(paramView, "view.findViewById(R.id.common_content_view_group)");
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)paramView);
    paramView = (View)this.jdField_a_of_type_AndroidViewViewGroup;
    localView = paramView.findViewById(RR.id.a.c());
    Intrinsics.checkExpressionValueIsNotNull(localView, "root.findViewById(R.id.video_layout)");
    this.jdField_b_of_type_AndroidViewViewGroup = ((ViewGroup)localView);
    localView = paramView.findViewById(RR.id.a.d());
    if (localView != null)
    {
      if (localView != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityAbsVideoFeedsGestureLayout = ((AbsVideoFeedsGestureLayout)localView);
        localView = paramView.findViewById(RR.id.a.e());
        Intrinsics.checkExpressionValueIsNotNull(localView, "root.findViewById(R.id.cover_imageview)");
        this.jdField_c_of_type_ComTencentImageURLImageView = ((URLImageView)localView);
        localView = paramView.findViewById(RR.id.a.f());
        Intrinsics.checkExpressionValueIsNotNull(localView, "root.findViewById(R.id.play_button)");
        this.jdField_g_of_type_AndroidWidgetImageView = ((ImageView)localView);
        localView = paramView.findViewById(RR.id.a.g());
        Intrinsics.checkExpressionValueIsNotNull(localView, "root.findViewById(R.id.video_controller_layout)");
        this.d = ((ViewGroup)localView);
        localView = paramView.findViewById(RR.id.a.h());
        Intrinsics.checkExpressionValueIsNotNull(localView, "root.findViewById(R.id.seekbar)");
        this.jdField_a_of_type_AndroidWidgetSeekBar = ((SeekBar)localView);
        localView = paramView.findViewById(RR.id.a.i());
        Intrinsics.checkExpressionValueIsNotNull(localView, "root.findViewById(R.id.current_time_textview)");
        this.jdField_o_of_type_AndroidWidgetTextView = ((TextView)localView);
        localView = paramView.findViewById(RR.id.a.j());
        Intrinsics.checkExpressionValueIsNotNull(localView, "root.findViewById(R.id.total_time_textview)");
        this.q = ((TextView)localView);
        localView = paramView.findViewById(RR.id.a.k());
        Intrinsics.checkExpressionValueIsNotNull(localView, "root.findViewById(R.id.play_button_layout)");
        this.jdField_c_of_type_AndroidViewViewGroup = ((ViewGroup)localView);
        localView = paramView.findViewById(RR.id.a.l());
        Intrinsics.checkExpressionValueIsNotNull(localView, "root.findViewById(R.id.bottom_controller_layout)");
        this.jdField_g_of_type_AndroidViewViewGroup = ((ViewGroup)localView);
        localView = paramView.findViewById(RR.id.a.m());
        Intrinsics.checkExpressionValueIsNotNull(localView, "root.findViewById(R.id.full_screen_operation)");
        this.jdField_h_of_type_AndroidViewViewGroup = ((ViewGroup)localView);
        localView = paramView.findViewById(RR.id.a.n());
        Intrinsics.checkExpressionValueIsNotNull(localView, "root.findViewById(R.id.full_screen_operation_icon)");
        this.jdField_i_of_type_AndroidWidgetImageView = ((ImageView)localView);
        localView = paramView.findViewById(RR.id.a.o());
        Intrinsics.checkExpressionValueIsNotNull(localView, "root.findViewById(R.id.operate_button_xg)");
        this.r = ((TextView)localView);
        localView = paramView.findViewById(RR.id.a.p());
        Intrinsics.checkExpressionValueIsNotNull(localView, "root.findViewById(R.id.file_size_black_toast)");
        this.s = ((TextView)localView);
        localView = paramView.findViewById(RR.id.a.q());
        Intrinsics.checkExpressionValueIsNotNull(localView, "root.findViewById(R.id.king_card_guide)");
        this.t = ((TextView)localView);
        localView = paramView.findViewById(RR.id.a.r());
        Intrinsics.checkExpressionValueIsNotNull(localView, "root.findViewById(R.id.show_video_info_for_debug)");
        this.p = ((TextView)localView);
        localView = paramView.findViewById(RR.id.a.s());
        Intrinsics.checkExpressionValueIsNotNull(localView, "root.findViewById(R.id.full_screen_layout)");
        this.e = ((ViewGroup)localView);
        localView = paramView.findViewById(RR.id.a.t());
        Intrinsics.checkExpressionValueIsNotNull(localView, "root.findViewById(R.id.close_button)");
        this.f = ((ViewGroup)localView);
        localView = paramView.findViewById(RR.id.a.u());
        Intrinsics.checkExpressionValueIsNotNull(localView, "root.findViewById(R.id.full_screen_title)");
        this.u = ((TextView)localView);
        localView = paramView.findViewById(RR.id.a.v());
        Intrinsics.checkExpressionValueIsNotNull(localView, "root.findViewById(R.id.video_volume_icon)");
        this.jdField_h_of_type_AndroidWidgetImageView = ((ImageView)localView);
        localView = paramView.findViewById(RR.id.a.w());
        Intrinsics.checkExpressionValueIsNotNull(localView, "root.findViewById(R.id.video_end_mask_view)");
        this.jdField_o_of_type_AndroidViewView = localView;
        this.j = ((ImageView)paramView.findViewById(RR.id.a.x()));
        this.jdField_i_of_type_AndroidViewViewGroup = ((ViewGroup)paramView.findViewById(RR.id.a.y()));
        this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIMsgLayoutHelper = ((IMsgLayoutHelperFactory)QRoute.api(IMsgLayoutHelperFactory.class)).create(paramView, null);
        return;
      }
      throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.AbsVideoFeedsGestureLayout");
    }
    throw new TypeCastException("null cannot be cast to non-null type android.view.View");
  }
  
  public boolean a()
  {
    VideoPlayParam localVideoPlayParam = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (localVideoPlayParam != null)
    {
      bool1 = bool2;
      if (localVideoPlayParam.a != null)
      {
        bool1 = bool2;
        if (localVideoPlayParam.a.r)
        {
          bool1 = bool2;
          if (localVideoPlayParam.a.g()) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.playfeeds.viewholder.BaseVideoItemHolder
 * JD-Core Version:    0.7.0.1
 */