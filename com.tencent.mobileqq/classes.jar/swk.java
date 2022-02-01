import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsAlphaMaskView;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsGestureLayout;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.mobileqq.richmedia.capture.util.LiuHaiUtils;
import java.net.URL;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/video/videofeeds/BaseVideoItemDelegate;", "Lcom/tencent/biz/pubaccount/readinjoy/video/IVideoFeedsItemUIDelegate;", "videoHolder", "Lcom/tencent/biz/pubaccount/readinjoy/video/videofeeds/BaseVideoItemHolder;", "presenter", "Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendPresenter;", "adapter", "Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsAdapter;", "(Lcom/tencent/biz/pubaccount/readinjoy/video/videofeeds/BaseVideoItemHolder;Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendPresenter;Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsAdapter;)V", "isXgfileshow", "", "holder", "onCheckControllerVisibility", "", "visibility", "onCheckVolumeProgressVisibility", "onCommentComponentVisiblityChanged", "onGestureTouchEvent", "event", "", "onItemSizeChanged", "onNetworkStatusChanged", "isWifi", "onScreenOrientationChanged", "isFullScreen", "onShowAsFirstTime", "isScrollToTop", "isNeedShowTitle", "onSpeedRatioChanged", "drawableId", "onVideoClick", "onVisibilityChanged", "onVolumeChanged", "progress", "", "refreshContentUI", "videoInfo", "Lcom/tencent/biz/pubaccount/VideoInfo;", "isNeedReloadTitle", "resetCoverViewLayoutParams", "resetItemLayoutParams", "resetVolumeProgressState", "isControllerVisibility", "setControllerVisibility", "showCurXGfileSizeTextView", "isKingCardUser", "tryLoadExtraCoverCache", "target", "Landroid/widget/ImageView;", "coverUrl", "Ljava/net/URL;", "Companion", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public abstract class swk
  implements sfc
{
  public static final swl a;
  @JvmField
  @NotNull
  public final shl a;
  @JvmField
  @NotNull
  public final slr a;
  private final swm a;
  
  static
  {
    jdField_a_of_type_Swl = new swl(null);
  }
  
  public swk(@NotNull swm paramswm, @NotNull slr paramslr, @NotNull shl paramshl)
  {
    this.jdField_a_of_type_Swm = paramswm;
    this.jdField_a_of_type_Slr = paramslr;
    this.jdField_a_of_type_Shl = paramshl;
  }
  
  private final boolean a(ImageView paramImageView, URL paramURL)
  {
    Object localObject2 = null;
    Object localObject1 = this.jdField_a_of_type_Slr.a();
    int j;
    if (localObject1 != null)
    {
      localObject1 = ((Activity)localObject1).getIntent();
      if (localObject1 == null) {
        break label114;
      }
      j = ((Intent)localObject1).getIntExtra("item_width", 0);
      label39:
      if (localObject1 == null) {
        break label120;
      }
      i = ((Intent)localObject1).getIntExtra("item_height", 0);
      label53:
      if (localObject1 == null) {
        break label125;
      }
      j = ((Intent)localObject1).getIntExtra("item_image_width", j);
      label69:
      if (localObject1 == null) {
        break label131;
      }
    }
    label131:
    for (int i = ((Intent)localObject1).getIntExtra("item_image_height", i);; i = 0)
    {
      if ((j != 0) && (i != 0)) {
        break label136;
      }
      if (QLog.isColorLevel()) {
        QLog.d("BaseVideoItemDelegate", 2, "tryLoadExtraCoverCache: width or height = 0");
      }
      return false;
      localObject1 = null;
      break;
      label114:
      j = 0;
      break label39;
      label120:
      i = 0;
      break label53;
      label125:
      j = 0;
      break label69;
    }
    label136:
    localObject1 = new tlw();
    ((tlw)localObject1).jdField_a_of_type_JavaNetURL = pqa.a(paramURL.toString());
    ((tlw)localObject1).jdField_a_of_type_Int = j;
    ((tlw)localObject1).jdField_b_of_type_Int = i;
    tls localtls = tlv.a().a((tlw)localObject1);
    localObject1 = localObject2;
    if (localtls != null) {
      localObject1 = localtls.a();
    }
    if (localObject1 != null)
    {
      paramURL = (Drawable)new tme(localtls.a());
      if (paramImageView != null) {
        paramImageView.setImageDrawable(paramURL);
      }
      if (QLog.isDevelopLevel()) {
        QLog.d("BaseVideoItemDelegate", 2, "tryLoadExtraCoverCache: ImageManager hitCache");
      }
      return true;
    }
    localObject1 = URLDrawable.URLDrawableOptions.obtain();
    ((URLDrawable.URLDrawableOptions)localObject1).mRequestWidth = j;
    ((URLDrawable.URLDrawableOptions)localObject1).mRequestHeight = i;
    paramURL = URLDrawable.getDrawable(paramURL, (URLDrawable.URLDrawableOptions)localObject1);
    if ((paramURL != null) && (paramURL.getStatus() == 1))
    {
      if (paramImageView != null) {
        paramImageView.setImageDrawable((Drawable)paramURL);
      }
      if (QLog.isDevelopLevel()) {
        QLog.d("BaseVideoItemDelegate", 2, "tryLoadExtraCoverCache: urlDrawable hitCache");
      }
      return true;
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("BaseVideoItemDelegate", 2, "tryLoadExtraCoverCache: missCache");
    }
    return false;
  }
  
  private final boolean a(swm paramswm)
  {
    if (NetworkUtil.isMobileNetWork((Context)this.jdField_a_of_type_Slr.a()))
    {
      long l;
      if (paramswm != null)
      {
        Object localObject = paramswm.jdField_a_of_type_Skq;
        if (localObject != null)
        {
          localObject = ((skq)localObject).jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
          if (localObject != null) {
            l = ((VideoInfo)localObject).jdField_b_of_type_Long;
          }
        }
      }
      while (l >= 0L) {
        if (((paramswm instanceof swu)) && (!this.jdField_a_of_type_Shl.a(paramswm)))
        {
          return true;
          l = 0L;
        }
        else
        {
          return false;
        }
      }
    }
    return false;
  }
  
  private final void b(VideoInfo paramVideoInfo, boolean paramBoolean)
  {
    Object localObject = this.jdField_a_of_type_Swm.itemView;
    Intrinsics.checkExpressionValueIsNotNull(localObject, "videoHolder.itemView");
    localObject = ((View)localObject).getLayoutParams();
    int i = paramVideoInfo.a(this.jdField_a_of_type_Slr.a());
    int j = six.b(this.jdField_a_of_type_Slr.a())[0];
    if (paramBoolean)
    {
      ((ViewGroup.LayoutParams)localObject).height = -1;
      ((ViewGroup.LayoutParams)localObject).width = -1;
      paramVideoInfo = this.jdField_a_of_type_Swm.itemView;
      Intrinsics.checkExpressionValueIsNotNull(paramVideoInfo, "videoHolder.itemView");
      paramVideoInfo.setLayoutParams((ViewGroup.LayoutParams)localObject);
      return;
    }
    if (paramVideoInfo.a(this.jdField_a_of_type_Slr.a())) {}
    for (((ViewGroup.LayoutParams)localObject).height = i;; ((ViewGroup.LayoutParams)localObject).height = i)
    {
      ((ViewGroup.LayoutParams)localObject).width = -1;
      break;
    }
  }
  
  private final void c(VideoInfo paramVideoInfo, boolean paramBoolean)
  {
    int i = paramVideoInfo.b(this.jdField_a_of_type_Slr.a());
    ViewGroup.LayoutParams localLayoutParams = this.jdField_a_of_type_Swm.jdField_c_of_type_ComTencentImageURLImageView.getLayoutParams();
    if (paramBoolean)
    {
      localLayoutParams.height = -1;
      localLayoutParams.width = -1;
    }
    for (;;)
    {
      this.jdField_a_of_type_Swm.jdField_c_of_type_ComTencentImageURLImageView.setLayoutParams(localLayoutParams);
      return;
      localLayoutParams.width = -1;
      if (paramVideoInfo.a(this.jdField_a_of_type_Slr.a(), this.jdField_a_of_type_Swm.jdField_d_of_type_Int) != 2) {
        break;
      }
      localLayoutParams.height = -1;
    }
    if (i > 0) {}
    for (;;)
    {
      localLayoutParams.height = i;
      break;
      i = -1;
    }
  }
  
  public void a()
  {
    Object localObject = this.jdField_a_of_type_Swm.jdField_a_of_type_Skq;
    if (localObject != null)
    {
      localObject = ((skq)localObject).jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
      if (localObject != null) {
        b((VideoInfo)localObject, this.jdField_a_of_type_Slr.b());
      }
    }
    localObject = this.jdField_a_of_type_Swm.jdField_a_of_type_Skq;
    if (localObject != null)
    {
      localObject = ((skq)localObject).jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
      if (localObject != null) {
        c((VideoInfo)localObject, this.jdField_a_of_type_Slr.b());
      }
    }
  }
  
  public void a(float paramFloat)
  {
    Object localObject = this.jdField_a_of_type_Swm.jdField_a_of_type_Sow;
    if (localObject != null) {
      ((sow)localObject).a(false);
    }
    boolean bool;
    if (this.jdField_a_of_type_Swm.jdField_d_of_type_AndroidViewViewGroup.getVisibility() == 0)
    {
      this.jdField_a_of_type_Swm.jdField_a_of_type_AndroidWidgetSeekBar.setEnabled(false);
      this.jdField_a_of_type_Swm.jdField_a_of_type_AndroidWidgetSeekBar.setProgress((int)(100 * paramFloat));
      this.jdField_a_of_type_Swm.jdField_o_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_a_of_type_Swm.q.setVisibility(8);
      this.jdField_a_of_type_Swm.jdField_h_of_type_AndroidWidgetImageView.setVisibility(0);
      localObject = this.jdField_a_of_type_Swm.jdField_h_of_type_AndroidWidgetImageView;
      if (paramFloat != 0.0F)
      {
        bool = true;
        ((ImageView)localObject).setEnabled(bool);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Shl.jdField_a_of_type_AndroidOsHandler.removeMessages(0);
      this.jdField_a_of_type_Shl.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(0, 1500);
      return;
      bool = false;
      break;
      this.jdField_a_of_type_Swm.jdField_b_of_type_AndroidWidgetSeekBar.setEnabled(false);
      this.jdField_a_of_type_Swm.jdField_b_of_type_AndroidWidgetSeekBar.setProgress((int)(100 * paramFloat));
    }
  }
  
  public void a(int paramInt)
  {
    if (paramInt == 1) {
      i(true);
    }
    while (paramInt != 2) {
      return;
    }
    i(false);
  }
  
  public void a(@NotNull VideoInfo paramVideoInfo, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramVideoInfo, "videoInfo");
    this.jdField_a_of_type_Swm.jdField_h_of_type_AndroidViewViewGroup.setTag(this.jdField_a_of_type_Swm);
    this.jdField_a_of_type_Swm.jdField_h_of_type_AndroidViewViewGroup.setOnClickListener((View.OnClickListener)this.jdField_a_of_type_Shl);
    int i = six.b(this.jdField_a_of_type_Slr.a())[0];
    int j = paramVideoInfo.b(this.jdField_a_of_type_Slr.a());
    b(paramVideoInfo, this.jdField_a_of_type_Slr.b());
    this.jdField_a_of_type_Swm.jdField_a_of_type_AndroidViewViewGroup.setOnClickListener((View.OnClickListener)this.jdField_a_of_type_Shl);
    this.jdField_a_of_type_Swm.jdField_a_of_type_AndroidViewViewGroup.setTag(this.jdField_a_of_type_Swm);
    if ((paramVideoInfo.jdField_b_of_type_Int > 0) && (paramVideoInfo.jdField_c_of_type_Int > 0) && (paramVideoInfo.jdField_c_of_type_Int < 10000) && (paramVideoInfo.jdField_b_of_type_Int < 10000) && (this.jdField_a_of_type_Swm.jdField_a_of_type_Skq != null))
    {
      localObject1 = this.jdField_a_of_type_Swm.jdField_a_of_type_Skq;
      if (localObject1 == null) {
        break label930;
      }
      localObject1 = ((skq)localObject1).jdField_a_of_type_Spn;
      if (localObject1 != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("BaseVideoItemDelegate", 2, "refreshContentUI: setFixedSize width=" + paramVideoInfo.jdField_b_of_type_Int + ", height=" + paramVideoInfo.jdField_c_of_type_Int);
        }
        localObject1 = this.jdField_a_of_type_Swm.jdField_a_of_type_Skq;
        if (localObject1 != null)
        {
          localObject1 = ((skq)localObject1).jdField_a_of_type_Spn;
          if (localObject1 != null) {
            ((spn)localObject1).b(paramVideoInfo.a(this.jdField_a_of_type_Slr.a(), this.jdField_a_of_type_Swm.jdField_d_of_type_Int));
          }
        }
        localObject1 = this.jdField_a_of_type_Swm.jdField_a_of_type_Skq;
        if (localObject1 != null)
        {
          localObject1 = ((skq)localObject1).jdField_a_of_type_Spn;
          if (localObject1 != null)
          {
            localObject1 = ((spn)localObject1).a();
            if (localObject1 != null) {
              ((stv)localObject1).a(paramVideoInfo.jdField_b_of_type_Int, paramVideoInfo.jdField_c_of_type_Int);
            }
          }
        }
      }
    }
    this.jdField_a_of_type_Swm.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureLayout.setTag(this.jdField_a_of_type_Swm);
    this.jdField_a_of_type_Swm.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureLayout.setOnCustomClickListener((sin)this.jdField_a_of_type_Shl);
    this.jdField_a_of_type_Swm.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureLayout.setContext(this.jdField_a_of_type_Slr.a());
    this.jdField_a_of_type_Swm.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureLayout.setVideoPlayManager(this.jdField_a_of_type_Slr.a());
    this.jdField_a_of_type_Swm.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureLayout.setChannelID(409409L);
    this.jdField_a_of_type_Swm.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureLayout.setVideoBrightnessController(this.jdField_a_of_type_Shl.jdField_a_of_type_Sgi);
    Object localObject1 = this.jdField_a_of_type_Swm.g;
    if (localObject1 != null) {
      ((ImageView)localObject1).setBackgroundDrawable(null);
    }
    localObject1 = this.jdField_a_of_type_Swm.g;
    if (localObject1 != null) {
      ((ImageView)localObject1).setTag(this.jdField_a_of_type_Swm);
    }
    localObject1 = this.jdField_a_of_type_Swm.g;
    if (localObject1 != null) {
      ((ImageView)localObject1).setOnClickListener((View.OnClickListener)this.jdField_a_of_type_Shl);
    }
    Object localObject2 = paramVideoInfo.a();
    localObject1 = (ImageView)this.jdField_a_of_type_Swm.jdField_c_of_type_ComTencentImageURLImageView;
    c(paramVideoInfo, this.jdField_a_of_type_Slr.b());
    if (localObject2 != null)
    {
      if ((this.jdField_a_of_type_Swm.jdField_c_of_type_Int != 0) || (this.jdField_a_of_type_Swm.jdField_b_of_type_Int != 0) || (!a((ImageView)localObject1, (URL)localObject2)))
      {
        URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
        localURLDrawableOptions.mRequestWidth = i;
        localURLDrawableOptions.mRequestHeight = j;
        localURLDrawableOptions.mPlayGifImage = true;
        localURLDrawableOptions.mLoadingDrawable = ((Drawable)this.jdField_a_of_type_Shl.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable);
        localURLDrawableOptions.mFailedDrawable = ((Drawable)this.jdField_a_of_type_Shl.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable);
        localObject2 = URLDrawable.getDrawable((URL)localObject2, localURLDrawableOptions);
        if (localObject1 != null) {
          ((ImageView)localObject1).setImageDrawable((Drawable)localObject2);
        }
      }
      label635:
      if (localObject1 != null) {
        ((ImageView)localObject1).setVisibility(0);
      }
      this.jdField_a_of_type_Swm.jdField_a_of_type_AndroidWidgetSeekBar.setProgress(0);
      six.a(this.jdField_a_of_type_Swm.jdField_o_of_type_AndroidWidgetTextView, 0L);
      six.a(this.jdField_a_of_type_Swm.q, paramVideoInfo.a() * 1000);
      if ((this.jdField_a_of_type_Shl.jdField_a_of_type_Boolean) || (this.jdField_a_of_type_Swm.jdField_c_of_type_Int != 0)) {
        break label950;
      }
      this.jdField_a_of_type_Swm.jdField_c_of_type_AndroidViewViewGroup.setVisibility(0);
      label719:
      this.jdField_a_of_type_Swm.jdField_d_of_type_AndroidViewViewGroup.setVisibility(8);
      this.jdField_a_of_type_Swm.jdField_b_of_type_AndroidWidgetSeekBar.setProgress(0);
      this.jdField_a_of_type_Swm.f.setTag(this.jdField_a_of_type_Swm);
      this.jdField_a_of_type_Swm.f.setOnClickListener((View.OnClickListener)this.jdField_a_of_type_Shl);
      paramVideoInfo = this.jdField_a_of_type_Swm.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAlphaMaskView;
      if (paramVideoInfo != null) {
        paramVideoInfo.setAlpha(1.0F);
      }
      this.jdField_a_of_type_Swm.s.setVisibility(8);
      paramVideoInfo = this.jdField_a_of_type_Swm.g;
      if (paramVideoInfo != null) {
        paramVideoInfo.setVisibility(0);
      }
      this.jdField_a_of_type_Swm.r.setVisibility(8);
      this.jdField_a_of_type_Swm.t.setVisibility(8);
      this.jdField_a_of_type_Swm.jdField_o_of_type_AndroidViewView.setVisibility(8);
      paramVideoInfo = this.jdField_a_of_type_Swm.j;
      if (paramVideoInfo != null) {
        paramVideoInfo.setOnClickListener((View.OnClickListener)this.jdField_a_of_type_Shl);
      }
      paramVideoInfo = this.jdField_a_of_type_Swm.j;
      if (paramVideoInfo != null) {
        paramVideoInfo.setTag(this.jdField_a_of_type_Swm);
      }
      if (!stw.a.a()) {
        break label965;
      }
      paramVideoInfo = this.jdField_a_of_type_Swm.j;
      if (paramVideoInfo != null) {
        paramVideoInfo.setVisibility(0);
      }
    }
    for (;;)
    {
      i(false);
      return;
      label930:
      localObject1 = null;
      break;
      if (localObject1 == null) {
        break label635;
      }
      ((ImageView)localObject1).setImageDrawable(null);
      break label635;
      label950:
      this.jdField_a_of_type_Swm.jdField_c_of_type_AndroidViewViewGroup.setVisibility(8);
      break label719;
      label965:
      paramVideoInfo = this.jdField_a_of_type_Swm.j;
      if (paramVideoInfo != null) {
        paramVideoInfo.setVisibility(8);
      }
    }
  }
  
  protected final void a(@NotNull swm paramswm, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramswm, "holder");
    Activity localActivity = this.jdField_a_of_type_Slr.a();
    if (localActivity != null)
    {
      localObject1 = paramswm.jdField_a_of_type_Skq;
      if (localObject1 == null) {
        break label202;
      }
    }
    label202:
    for (Object localObject1 = ((skq)localObject1).jdField_a_of_type_ComTencentBizPubaccountVideoInfo; paramBoolean; localObject1 = null)
    {
      localObject1 = anvx.a(2131715583);
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "HardCodeUtil.qqStr(R.str….qqstr_videofee_b91647ab)");
      Object localObject2 = paramswm.g;
      if (localObject2 != null) {
        ((ImageView)localObject2).setVisibility(8);
      }
      localObject2 = localActivity.getResources().getDrawable(2130843226);
      paramswm.r.setText((CharSequence)localObject1);
      paramswm.r.setCompoundDrawablesWithIntrinsicBounds((Drawable)localObject2, null, null, null);
      paramswm.r.setCompoundDrawablePadding(AIOUtils.dp2px(6.0F, localActivity.getResources()));
      paramswm.r.setVisibility(0);
      paramswm.r.setOnClickListener((View.OnClickListener)this.jdField_a_of_type_Shl);
      paramswm.r.setTag(paramswm);
      if ((!paramBoolean) && (!TextUtils.isEmpty((CharSequence)bhyk.a("kandian"))))
      {
        paramswm.t.setVisibility(0);
        six.a((Context)localActivity, paramswm.t);
      }
      return;
    }
    if (localObject1 != null) {}
    for (long l = ((VideoInfo)localObject1).jdField_b_of_type_Long;; l = 0L)
    {
      localObject1 = six.c(l);
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "VideoFeedsHelper.getXgFi…deoInfo?.XGFileSize ?: 0)");
      break;
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (a(this.jdField_a_of_type_Swm)) {
      a(this.jdField_a_of_type_Swm, this.jdField_a_of_type_Slr.c());
    }
    for (;;)
    {
      Object localObject = this.jdField_a_of_type_Swm.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAlphaMaskView;
      if (localObject != null) {
        ((VideoFeedsAlphaMaskView)localObject).setAlpha(0.0F);
      }
      if (this.jdField_a_of_type_Swm.jdField_c_of_type_Int != 0) {
        break;
      }
      localObject = this.jdField_a_of_type_Swm.jdField_a_of_type_Skq;
      if (localObject == null) {
        break;
      }
      localObject = ((skq)localObject).jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
      if ((localObject == null) || (((VideoInfo)localObject).jdField_a_of_type_Int != 0)) {
        break;
      }
      i(true);
      return;
      this.jdField_a_of_type_Swm.jdField_c_of_type_AndroidViewViewGroup.setVisibility(8);
    }
    i(false);
  }
  
  public void b()
  {
    Object localObject = this.jdField_a_of_type_Slr.a();
    if (localObject != null)
    {
      localObject = ((swm)localObject).jdField_d_of_type_AndroidViewViewGroup;
      if ((localObject == null) || (((ViewGroup)localObject).getVisibility() != 0)) {}
    }
    for (boolean bool = true;; bool = false)
    {
      j(bool);
      return;
    }
  }
  
  public void b(int paramInt)
  {
    ImageView localImageView = this.jdField_a_of_type_Swm.j;
    if (localImageView != null) {
      localImageView.setImageResource(paramInt);
    }
  }
  
  public void c()
  {
    boolean bool = false;
    if (this.jdField_a_of_type_Swm.jdField_d_of_type_AndroidViewViewGroup.getVisibility() == 8) {
      this.jdField_a_of_type_Swm.jdField_b_of_type_AndroidWidgetSeekBar.setVisibility(8);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Swm.jdField_d_of_type_AndroidViewViewGroup.getVisibility() == 8) {
        bool = true;
      }
      i(bool);
      return;
      if (!this.jdField_a_of_type_Slr.b()) {
        this.jdField_a_of_type_Swm.jdField_b_of_type_AndroidWidgetSeekBar.setVisibility(0);
      }
    }
  }
  
  public void d(boolean paramBoolean)
  {
    Object localObject;
    if (this.jdField_a_of_type_Swm.jdField_c_of_type_Int == 0)
    {
      localObject = this.jdField_a_of_type_Swm.jdField_a_of_type_Skq;
      if (localObject != null)
      {
        localObject = ((skq)localObject).jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
        if ((localObject != null) && (((VideoInfo)localObject).jdField_a_of_type_Int == 0)) {
          i(true);
        }
      }
    }
    for (;;)
    {
      if (paramBoolean)
      {
        if (a(this.jdField_a_of_type_Swm)) {
          a(this.jdField_a_of_type_Swm, this.jdField_a_of_type_Slr.c());
        }
        localObject = this.jdField_a_of_type_Swm.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAlphaMaskView;
        if (localObject != null) {
          ((VideoFeedsAlphaMaskView)localObject).setAlpha(0.0F);
        }
      }
      localObject = this.jdField_a_of_type_Slr.a();
      if (localObject != null)
      {
        localObject = ((swm)localObject).jdField_a_of_type_Suf;
        if (localObject != null) {
          ((suf)localObject).a();
        }
      }
      return;
      i(false);
      if (this.jdField_a_of_type_Swm.jdField_c_of_type_AndroidViewViewGroup.getVisibility() == 0) {
        six.a((View)this.jdField_a_of_type_Swm.jdField_c_of_type_AndroidViewViewGroup, 8);
      }
    }
  }
  
  public void e(boolean paramBoolean) {}
  
  public void f(boolean paramBoolean)
  {
    Object localObject = this.jdField_a_of_type_Swm.jdField_a_of_type_Skq;
    if (localObject != null)
    {
      localObject = ((skq)localObject).jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
      if (localObject != null) {
        b((VideoInfo)localObject, paramBoolean);
      }
    }
    localObject = this.jdField_a_of_type_Swm.jdField_a_of_type_Skq;
    if (localObject != null)
    {
      localObject = ((skq)localObject).jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
      if (localObject != null) {
        c((VideoInfo)localObject, paramBoolean);
      }
    }
    if (paramBoolean)
    {
      this.jdField_a_of_type_Swm.e.setVisibility(0);
      this.jdField_a_of_type_Swm.i.setBackgroundDrawable(this.jdField_a_of_type_Shl.a(2130841816));
      localObject = this.jdField_a_of_type_Swm.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAlphaMaskView;
      if (localObject != null) {
        ((VideoFeedsAlphaMaskView)localObject).setVisibility(8);
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Shl.jdField_a_of_type_Bleh != null)
      {
        localObject = this.jdField_a_of_type_Shl.jdField_a_of_type_Bleh;
        Intrinsics.checkExpressionValueIsNotNull(localObject, "adapter.mAdNegPopupMenu");
        if (((bleh)localObject).isShowing()) {
          this.jdField_a_of_type_Shl.jdField_a_of_type_Bleh.dismiss();
        }
      }
      if (this.jdField_a_of_type_Shl.jdField_a_of_type_Uif != null) {
        this.jdField_a_of_type_Shl.jdField_a_of_type_Uif.a();
      }
      this.jdField_a_of_type_Swm.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureLayout.setIsInFullScreen(paramBoolean);
      this.jdField_a_of_type_Swm.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGestureLayout.a();
      i(false);
      if (LiuHaiUtils.b())
      {
        if (!paramBoolean) {
          break;
        }
        this.jdField_a_of_type_Swm.jdField_d_of_type_AndroidViewViewGroup.setPadding(LiuHaiUtils.b(this.jdField_a_of_type_Slr.a()), 0, LiuHaiUtils.b(this.jdField_a_of_type_Slr.a()), 0);
      }
      return;
      this.jdField_a_of_type_Swm.e.setVisibility(8);
      this.jdField_a_of_type_Swm.i.setBackgroundDrawable(this.jdField_a_of_type_Shl.a(2130841817));
      localObject = this.jdField_a_of_type_Swm.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAlphaMaskView;
      if (localObject != null) {
        ((VideoFeedsAlphaMaskView)localObject).setVisibility(0);
      }
    }
    this.jdField_a_of_type_Swm.jdField_d_of_type_AndroidViewViewGroup.setPadding(0, 0, 0, 0);
  }
  
  public void g(boolean paramBoolean)
  {
    i(paramBoolean);
  }
  
  public void h(boolean paramBoolean)
  {
    if (paramBoolean) {
      if (this.jdField_a_of_type_Swm.g != null)
      {
        localObject1 = this.jdField_a_of_type_Swm.g;
        if (localObject1 != null) {
          ((ImageView)localObject1).setVisibility(0);
        }
        this.jdField_a_of_type_Swm.r.setVisibility(8);
        if ((!this.jdField_a_of_type_Slr.c()) && (!TextUtils.isEmpty((CharSequence)bhyk.a("kandian")))) {
          this.jdField_a_of_type_Swm.t.setVisibility(8);
        }
      }
    }
    Object localObject2;
    do
    {
      return;
      if (six.b())
      {
        if (this.jdField_a_of_type_Slr.c())
        {
          localObject1 = anvx.a(2131715583);
          Intrinsics.checkExpressionValueIsNotNull(localObject1, "HardCodeUtil.qqStr(R.str….qqstr_videofee_b91647ab)");
          localObject2 = anvx.a(2131715539);
          this.jdField_a_of_type_Swm.jdField_a_of_type_Suf.a(0, (String)localObject2, (String)localObject1, 2130843294);
          return;
        }
        localObject1 = this.jdField_a_of_type_Swm.jdField_a_of_type_Skq;
        if (localObject1 != null)
        {
          localObject1 = ((skq)localObject1).jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
          if (localObject1 == null) {}
        }
        for (long l = ((VideoInfo)localObject1).jdField_b_of_type_Long;; l = 0L)
        {
          localObject1 = six.c(l);
          Intrinsics.checkExpressionValueIsNotNull(localObject1, "VideoFeedsHelper.getXgFi…                    ?: 0)");
          break;
        }
      }
      localObject2 = this.jdField_a_of_type_Swm.jdField_a_of_type_Sow;
    } while (localObject2 == null);
    Object localObject1 = this.jdField_a_of_type_Swm.jdField_a_of_type_Skq;
    if (localObject1 != null) {}
    for (localObject1 = ((skq)localObject1).jdField_a_of_type_ComTencentBizPubaccountVideoInfo;; localObject1 = null)
    {
      ((sow)localObject2).a((VideoInfo)localObject1);
      return;
    }
  }
  
  protected void i(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.jdField_a_of_type_Swm.jdField_d_of_type_AndroidViewViewGroup.getVisibility() == 8) {
        six.a((View)this.jdField_a_of_type_Swm.jdField_d_of_type_AndroidViewViewGroup, 0);
      }
      if (this.jdField_a_of_type_Swm.jdField_c_of_type_AndroidViewViewGroup.getVisibility() == 8) {
        six.a((View)this.jdField_a_of_type_Swm.jdField_c_of_type_AndroidViewViewGroup, 0);
      }
    }
    for (;;)
    {
      j(paramBoolean);
      return;
      if (this.jdField_a_of_type_Swm.jdField_d_of_type_AndroidViewViewGroup.getVisibility() == 0) {
        six.a((View)this.jdField_a_of_type_Swm.jdField_d_of_type_AndroidViewViewGroup, 8);
      }
      if ((this.jdField_a_of_type_Slr.a().f()) && (this.jdField_a_of_type_Swm.jdField_c_of_type_AndroidViewViewGroup.getVisibility() == 0)) {
        six.a((View)this.jdField_a_of_type_Swm.jdField_c_of_type_AndroidViewViewGroup, 8);
      }
      if (this.jdField_a_of_type_Slr.b()) {
        this.jdField_a_of_type_Swm.jdField_b_of_type_AndroidWidgetSeekBar.setVisibility(8);
      } else {
        this.jdField_a_of_type_Swm.jdField_b_of_type_AndroidWidgetSeekBar.setVisibility(0);
      }
    }
  }
  
  protected final void j(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_Swm.jdField_a_of_type_AndroidWidgetSeekBar.setEnabled(true);
      this.jdField_a_of_type_Swm.jdField_o_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_Swm.q.setVisibility(0);
      this.jdField_a_of_type_Swm.jdField_h_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    for (;;)
    {
      sow localsow = this.jdField_a_of_type_Swm.jdField_a_of_type_Sow;
      if (localsow != null) {
        localsow.a(true);
      }
      localsow = this.jdField_a_of_type_Swm.jdField_a_of_type_Sow;
      if (localsow != null) {
        localsow.a();
      }
      return;
      this.jdField_a_of_type_Swm.jdField_b_of_type_AndroidWidgetSeekBar.setEnabled(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     swk
 * JD-Core Version:    0.7.0.1
 */