import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsGestureLayout;
import com.tencent.image.URLImageView;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/video/videofeeds/BaseVideoItemHolder;", "Lcom/tencent/biz/pubaccount/readinjoy/video/videofeeds/BaseItemHolder;", "view", "Landroid/view/View;", "itemType", "", "(Landroid/view/View;I)V", "autoSeekBar", "Landroid/widget/SeekBar;", "bottomSeekbarLayout", "Landroid/view/ViewGroup;", "coverImageView", "Lcom/tencent/image/URLImageView;", "currentTimeTextView", "Landroid/widget/TextView;", "delegate", "Lcom/tencent/biz/pubaccount/readinjoy/video/IVideoFeedsItemUIDelegate;", "exitFullScreenButton", "fullOperationIconImageView", "Landroid/widget/ImageView;", "fullOperationLayout", "fullScreenLayout", "fullTitleTextView", "gestureLayout", "Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsGestureLayout;", "kingcardGuideTextView", "msgLayoutHelper", "Lcom/tencent/biz/pubaccount/readinjoy/video/playfeedback/MsgLayoutHelper;", "playButton", "playButtonLayout", "seekBar", "speedRatioBtn", "totalTimeTextView", "videoArea", "videoAreaBottomOffset", "videoControllerLayout", "videoEndMaskView", "videoInfoShowTextViewDebug", "videoLayout", "videoPlayParam", "Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager$VideoPlayParam;", "videoUIDelegate", "Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsVideoUIDelegate;", "volumeIcon", "xgFileSizeBlackToast", "xgFileSizeTextView", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public class swm
  extends swj
{
  @JvmField
  @NotNull
  public ViewGroup a;
  @JvmField
  @NotNull
  public SeekBar a;
  @JvmField
  @NotNull
  public VideoFeedsGestureLayout a;
  @JvmField
  @Nullable
  public sfc a;
  @JvmField
  @Nullable
  public skq a;
  @JvmField
  @Nullable
  public sow a;
  @JvmField
  @NotNull
  public suf a;
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
  
  public swm(@NotNull View paramView, int paramInt)
  {
    super(paramView, paramInt);
    View localView = paramView.findViewById(2131368896);
    Intrinsics.checkExpressionValueIsNotNull(localView, "view.findViewById(R.id.inner_auto_seekBar)");
    this.jdField_b_of_type_AndroidWidgetSeekBar = ((SeekBar)localView);
    paramView = paramView.findViewById(2131364988);
    Intrinsics.checkExpressionValueIsNotNull(paramView, "view.findViewById(R.id.common_content_view_group)");
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)paramView);
    paramView = (View)this.jdField_a_of_type_AndroidViewViewGroup;
    localView = paramView.findViewById(2131380944);
    Intrinsics.checkExpressionValueIsNotNull(localView, "root.findViewById(R.id.video_layout)");
    this.jdField_b_of_type_AndroidViewViewGroup = ((ViewGroup)localView);
    localView = paramView.findViewById(2131367650);
    Intrinsics.checkExpressionValueIsNotNull(localView, "root.findViewById(R.id.gesture_layout)");
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureLayout = ((VideoFeedsGestureLayout)localView);
    localView = paramView.findViewById(2131365288);
    Intrinsics.checkExpressionValueIsNotNull(localView, "root.findViewById(R.id.cover_imageview)");
    this.jdField_c_of_type_ComTencentImageURLImageView = ((URLImageView)localView);
    localView = paramView.findViewById(2131372920);
    Intrinsics.checkExpressionValueIsNotNull(localView, "root.findViewById(R.id.play_button)");
    this.jdField_g_of_type_AndroidWidgetImageView = ((ImageView)localView);
    localView = paramView.findViewById(2131380855);
    Intrinsics.checkExpressionValueIsNotNull(localView, "root.findViewById(R.id.video_controller_layout)");
    this.d = ((ViewGroup)localView);
    localView = paramView.findViewById(2131377275);
    Intrinsics.checkExpressionValueIsNotNull(localView, "root.findViewById(R.id.seekbar)");
    this.jdField_a_of_type_AndroidWidgetSeekBar = ((SeekBar)localView);
    localView = paramView.findViewById(2131365354);
    Intrinsics.checkExpressionValueIsNotNull(localView, "root.findViewById(R.id.current_time_textview)");
    this.jdField_o_of_type_AndroidWidgetTextView = ((TextView)localView);
    localView = paramView.findViewById(2131379311);
    Intrinsics.checkExpressionValueIsNotNull(localView, "root.findViewById(R.id.total_time_textview)");
    this.q = ((TextView)localView);
    localView = paramView.findViewById(2131372921);
    Intrinsics.checkExpressionValueIsNotNull(localView, "root.findViewById(R.id.play_button_layout)");
    this.jdField_c_of_type_AndroidViewViewGroup = ((ViewGroup)localView);
    localView = paramView.findViewById(2131363713);
    Intrinsics.checkExpressionValueIsNotNull(localView, "root.findViewById(R.id.bottom_controller_layout)");
    this.jdField_g_of_type_AndroidViewViewGroup = ((ViewGroup)localView);
    localView = paramView.findViewById(2131367466);
    Intrinsics.checkExpressionValueIsNotNull(localView, "root.findViewById(R.id.full_screen_operation)");
    this.jdField_h_of_type_AndroidViewViewGroup = ((ViewGroup)localView);
    localView = paramView.findViewById(2131367467);
    Intrinsics.checkExpressionValueIsNotNull(localView, "root.findViewById(R.id.full_screen_operation_icon)");
    this.i = ((ImageView)localView);
    localView = paramView.findViewById(2131372278);
    Intrinsics.checkExpressionValueIsNotNull(localView, "root.findViewById(R.id.operate_button_xg)");
    this.r = ((TextView)localView);
    localView = paramView.findViewById(2131366775);
    Intrinsics.checkExpressionValueIsNotNull(localView, "root.findViewById(R.id.file_size_black_toast)");
    this.s = ((TextView)localView);
    localView = paramView.findViewById(2131369734);
    Intrinsics.checkExpressionValueIsNotNull(localView, "root.findViewById(R.id.king_card_guide)");
    this.t = ((TextView)localView);
    localView = paramView.findViewById(2131377673);
    Intrinsics.checkExpressionValueIsNotNull(localView, "root.findViewById(R.id.show_video_info_for_debug)");
    this.p = ((TextView)localView);
    localView = paramView.findViewById(2131367465);
    Intrinsics.checkExpressionValueIsNotNull(localView, "root.findViewById(R.id.full_screen_layout)");
    this.e = ((ViewGroup)localView);
    localView = paramView.findViewById(2131364711);
    Intrinsics.checkExpressionValueIsNotNull(localView, "root.findViewById(R.id.close_button)");
    this.f = ((ViewGroup)localView);
    localView = paramView.findViewById(2131367468);
    Intrinsics.checkExpressionValueIsNotNull(localView, "root.findViewById(R.id.full_screen_title)");
    this.u = ((TextView)localView);
    localView = paramView.findViewById(2131381097);
    Intrinsics.checkExpressionValueIsNotNull(localView, "root.findViewById(R.id.video_volume_icon)");
    this.jdField_h_of_type_AndroidWidgetImageView = ((ImageView)localView);
    localView = paramView.findViewById(2131380880);
    Intrinsics.checkExpressionValueIsNotNull(localView, "root.findViewById(R.id.video_end_mask_view)");
    this.jdField_o_of_type_AndroidViewView = localView;
    this.j = ((ImageView)paramView.findViewById(2131381035));
    this.jdField_a_of_type_Suf = new suf(paramView, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     swm
 * JD-Core Version:    0.7.0.1
 */