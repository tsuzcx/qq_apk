package com.tencent.mobileqq.vas.adv.qzone.logic;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewStub;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.TMG.utils.QLog;
import com.tencent.ad.tangram.util.AdExposureChecker;
import com.tencent.ad.tangram.util.AdExposureChecker.ExposureCallback;
import com.tencent.component.media.image.ImageLoader;
import com.tencent.gdtad.IGdtAdAPI;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.aditem.GdtAppReceiver;
import com.tencent.gdtad.aditem.GdtHandler;
import com.tencent.gdtad.aditem.GdtHandler.Params;
import com.tencent.mobileqq.cooperation.ApkUtils;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qqvideoplatform.api.QQVideoViewFactory;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.adv.base.support.VasAdvSupport;
import com.tencent.mobileqq.vas.adv.common.data.AlumBasicData;
import com.tencent.mobileqq.vas.adv.qzone.api.IVasQZoneApi;
import com.tencent.mobileqq.vas.adv.qzone.data.VasAdMetaReportParam;
import com.tencent.mobileqq.vas.adv.qzone.model.AdvReportVideoModel;
import com.tencent.mobileqq.vas.adv.qzone.model.AdvReportVideoModel.Builder;
import com.tencent.mobileqq.videoplatform.api.VideoPlayParam;
import com.tencent.mobileqq.videoplatform.view.BaseVideoView;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.thread.QzoneBaseThread;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import cooperation.qzone.util.QZLog;
import java.lang.ref.WeakReference;
import java.net.URLEncoder;
import java.util.ArrayList;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.AppInfo;

public class AdVideoViewController
  implements IAdVideoViewController
{
  private int jdField_a_of_type_Int = 0;
  private long jdField_a_of_type_Long = 0L;
  private Context jdField_a_of_type_AndroidContentContext;
  private Handler jdField_a_of_type_AndroidOsHandler;
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new AdVideoViewController.1(this);
  private View jdField_a_of_type_AndroidViewView;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private ViewStub jdField_a_of_type_AndroidViewViewStub;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  public AdExposureChecker.ExposureCallback a;
  private GdtAppReceiver jdField_a_of_type_ComTencentGdtadAditemGdtAppReceiver;
  private AlumBasicData jdField_a_of_type_ComTencentMobileqqVasAdvCommonDataAlumBasicData;
  private AdvRoundFrameLayout jdField_a_of_type_ComTencentMobileqqVasAdvQzoneLogicAdvRoundFrameLayout;
  BaseVideoView jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView;
  public final String a;
  private WeakReference<Activity> jdField_a_of_type_JavaLangRefWeakReference = null;
  public ArrayList<AdExposureChecker> a;
  private boolean jdField_a_of_type_Boolean = false;
  private long jdField_b_of_type_Long = 0L;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private AdvRoundFrameLayout jdField_b_of_type_ComTencentMobileqqVasAdvQzoneLogicAdvRoundFrameLayout;
  private boolean jdField_b_of_type_Boolean = false;
  private ImageView jdField_c_of_type_AndroidWidgetImageView;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private boolean jdField_c_of_type_Boolean = false;
  private ImageView jdField_d_of_type_AndroidWidgetImageView;
  private boolean jdField_d_of_type_Boolean;
  
  public AdVideoViewController(Context paramContext)
  {
    this.jdField_a_of_type_JavaLangString = "AdVideoView";
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_ComTencentAdTangramUtilAdExposureChecker$ExposureCallback = null;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    this.jdField_a_of_type_ComTencentGdtadAditemGdtAppReceiver = new GdtAppReceiver();
    this.jdField_a_of_type_ComTencentGdtadAditemGdtAppReceiver.register(this.jdField_a_of_type_AndroidContentContext);
  }
  
  private void a(int paramInt1, long paramLong, int paramInt2, int paramInt3, boolean paramBoolean, String paramString)
  {
    AdvReportVideoModel.Builder localBuilder = new AdvReportVideoModel.Builder();
    localBuilder.c(paramInt1).a(paramBoolean).a(paramLong).a(paramInt2).b(paramInt3);
    a(localBuilder.a(), paramString);
  }
  
  private void a(TextView paramTextView, @NonNull AlumBasicData paramAlumBasicData)
  {
    if (paramTextView == null) {
      return;
    }
    if (!TextUtils.isEmpty(paramAlumBasicData.rightBottomButton))
    {
      paramTextView.setText(paramAlumBasicData.rightBottomButton);
      return;
    }
    if (paramAlumBasicData.adInfo.product_type.get() == 12)
    {
      paramTextView.setText(2131689587);
      return;
    }
    paramTextView.setText(2131689588);
  }
  
  private boolean a(AlumBasicData paramAlumBasicData)
  {
    if (paramAlumBasicData == null) {
      return false;
    }
    int i = LocalMultiProcConfig.getInt("QZ_setting", "Qzone_playMode", 0);
    boolean bool = true;
    if (i == 2) {}
    while ((i == 0) && (!NetworkUtil.isWifiConnected(this.jdField_a_of_type_AndroidContentContext)))
    {
      i = 0;
      break;
    }
    i = 1;
    if ((i == 0) || (paramAlumBasicData.mAutoPlay != 1)) {
      bool = false;
    }
    this.jdField_c_of_type_Boolean = bool;
    if (QLog.isColorLevel())
    {
      paramAlumBasicData = new StringBuilder();
      paramAlumBasicData.append("getCanAutoPlay = ");
      paramAlumBasicData.append(this.jdField_c_of_type_Boolean);
      QLog.d("AdVideoView", 0, paramAlumBasicData.toString());
    }
    return this.jdField_c_of_type_Boolean;
  }
  
  public String a(AdvReportVideoModel paramAdvReportVideoModel)
  {
    if (paramAdvReportVideoModel == null) {
      return "";
    }
    for (;;)
    {
      try
      {
        i = paramAdvReportVideoModel.jdField_a_of_type_Int;
        int k = 1;
        if (i <= 1)
        {
          i = 11;
          localObject = new JSONObject();
          ((JSONObject)localObject).put("bt", "0");
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(paramAdvReportVideoModel.jdField_b_of_type_Long);
          localStringBuilder.append("");
          ((JSONObject)localObject).put("et", localStringBuilder.toString());
          localStringBuilder = new StringBuilder();
          if (paramAdvReportVideoModel.jdField_a_of_type_Long <= 0L) {
            break label381;
          }
          j = 0;
          localStringBuilder.append(j);
          localStringBuilder.append("");
          ((JSONObject)localObject).put("bf", localStringBuilder.toString());
          localStringBuilder = new StringBuilder();
          if (!paramAdvReportVideoModel.jdField_a_of_type_Boolean) {
            break label386;
          }
          j = k;
          localStringBuilder.append(j);
          localStringBuilder.append("");
          ((JSONObject)localObject).put("ef", localStringBuilder.toString());
          ((JSONObject)localObject).put("pp", "0");
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(i);
          localStringBuilder.append("");
          ((JSONObject)localObject).put("pa", localStringBuilder.toString());
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(paramAdvReportVideoModel.c);
          localStringBuilder.append("");
          ((JSONObject)localObject).put("ft", localStringBuilder.toString());
          if (paramAdvReportVideoModel.jdField_b_of_type_Int != 0)
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append(paramAdvReportVideoModel.jdField_b_of_type_Int);
            localStringBuilder.append("");
            ((JSONObject)localObject).put("ps", localStringBuilder.toString());
          }
          paramAdvReportVideoModel = ((JSONObject)localObject).toString();
          return paramAdvReportVideoModel;
        }
      }
      catch (Exception paramAdvReportVideoModel)
      {
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append(" @getGdtInfo createGDTVideoAttachment");
        ((StringBuilder)localObject).append(paramAdvReportVideoModel.toString());
        QZLog.e("AdVideoView", ((StringBuilder)localObject).toString());
        return null;
      }
      int i = 13;
      continue;
      label381:
      int j = 1;
      continue;
      label386:
      j = 0;
    }
  }
  
  public String a(String paramString1, String paramString2)
  {
    try
    {
      StringBuffer localStringBuffer = new StringBuffer();
      if (!TextUtils.isEmpty(paramString1)) {
        localStringBuffer.append(paramString1);
      }
      if (!TextUtils.isEmpty(paramString2))
      {
        localStringBuffer.append("&video=");
        localStringBuffer.append(URLEncoder.encode(paramString2));
      }
      paramString1 = localStringBuffer.toString();
      return paramString1;
    }
    catch (Exception paramString1)
    {
      paramString2 = new StringBuilder();
      paramString2.append(" @getGdtInfo getHttpVideoPlayUrl");
      paramString2.append(paramString1.toString());
      QZLog.e("AdVideoView", paramString2.toString());
    }
    return "";
  }
  
  public void a(int paramInt, String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = new VasAdMetaReportParam(2, paramInt, 1, 0, VasAdvSupport.a().a(), null, paramString);
      ((IVasQZoneApi)QRoute.api(IVasQZoneApi.class)).reportAdvAsync(paramString);
      return;
    }
    QZLog.i("AdVideoView", " @getGdtInfo sendBusinessReport");
  }
  
  public void a(ImageView paramImageView, String paramString, AlumBasicData paramAlumBasicData, Boolean paramBoolean)
  {
    if ((paramImageView != null) && (!TextUtils.isEmpty(paramString)))
    {
      if (paramAlumBasicData == null) {
        return;
      }
      paramString = ImageLoader.getInstance().loadImage(paramString, new AdVideoViewController.6(this, paramImageView, paramBoolean, paramAlumBasicData));
      if ((paramString != null) && (paramBoolean.booleanValue()))
      {
        a(1, paramAlumBasicData.recCookie);
        paramImageView.setImageDrawable(paramString);
      }
    }
  }
  
  public void a(AlumBasicData paramAlumBasicData)
  {
    if ((paramAlumBasicData != null) && (paramAlumBasicData.mPreloadMiniApp == 1)) {
      ((IGdtAdAPI)QRoute.api(IGdtAdAPI.class)).preLoadAfterAdLoaded(this.jdField_a_of_type_AndroidContentContext, new GdtAd(paramAlumBasicData.adInfo));
    }
  }
  
  public void a(AdvReportVideoModel paramAdvReportVideoModel, String paramString)
  {
    if (paramAdvReportVideoModel != null)
    {
      if (TextUtils.isEmpty(paramString)) {
        return;
      }
      paramAdvReportVideoModel = a(paramAdvReportVideoModel);
      paramString = a(paramString, paramAdvReportVideoModel);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("reportHttpVideoUrl = ");
        localStringBuilder.append(paramAdvReportVideoModel);
        QLog.d("AdVideoView", 0, localStringBuilder.toString());
      }
      a(paramString);
    }
  }
  
  public void a(BaseVideoView paramBaseVideoView)
  {
    if (paramBaseVideoView == null) {
      return;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("startVideoPlay  time =");
      localStringBuilder.append(System.currentTimeMillis());
      QLog.d("AdVideoView", 0, localStringBuilder.toString());
    }
    paramBaseVideoView.play();
  }
  
  public void a(BaseVideoView paramBaseVideoView, View paramView)
  {
    if (paramBaseVideoView != null)
    {
      if (paramView == null) {
        return;
      }
      c(paramBaseVideoView);
      paramView.setVisibility(8);
    }
  }
  
  public void a(BaseVideoView paramBaseVideoView, AlumBasicData paramAlumBasicData, int paramInt, Context paramContext)
  {
    if ((paramBaseVideoView != null) && (paramAlumBasicData != null))
    {
      if (paramAlumBasicData.mAdvType != 1) {
        return;
      }
      paramContext = new VideoPlayParam();
      paramContext.mSceneId = paramInt;
      paramContext.mIsMute = true;
      paramContext.mIsLoop = true;
      paramContext.mUrls = new String[] { paramAlumBasicData.mVideoUrl };
      paramContext.mNeedPlayProgress = true;
      paramContext.mVideoFileTimeMs = paramAlumBasicData.mShowVideoTime;
      paramContext.mCallback = new AdVideoViewController.3(this, paramAlumBasicData, paramBaseVideoView);
      paramBaseVideoView.setVideoParam(paramContext);
      QzoneHandlerThreadFactory.getHandlerThread("YellowVip_HandlerThread").post(new AdVideoViewController.4(this, paramAlumBasicData, paramBaseVideoView));
    }
  }
  
  public void a(String paramString)
  {
    QzoneHandlerThreadFactory.getHandlerThread("Normal_HandlerThread").postDelayed(new AdVideoViewController.5(this, paramString), 0L);
  }
  
  public void a(WeakReference<Activity> paramWeakReference, AlumBasicData paramAlumBasicData)
  {
    GdtHandler.Params localParams = new GdtHandler.Params();
    if (paramWeakReference != null)
    {
      localParams.jdField_a_of_type_JavaLangRefWeakReference = paramWeakReference;
      localParams.jdField_a_of_type_ComTencentGdtadAditemGdtAd = new GdtAd(paramAlumBasicData.adInfo);
      localParams.jdField_b_of_type_JavaLangRefWeakReference = new WeakReference(this.jdField_a_of_type_ComTencentGdtadAditemGdtAppReceiver);
      localParams.jdField_a_of_type_Boolean = true;
      localParams.jdField_b_of_type_Boolean = false;
      localParams.jdField_d_of_type_Boolean = true;
      localParams.jdField_c_of_type_Boolean = true;
      localParams.jdField_a_of_type_AndroidOsBundle = new Bundle();
      localParams.jdField_a_of_type_AndroidOsBundle.putString("big_brother_ref_source_key", "biz_src_jc_qzone");
      GdtHandler.a(localParams);
      QZLog.i("AdVideoView", " @getGdtInfo clickAlumAdvPicViewInfo");
    }
  }
  
  public void a(boolean paramBoolean)
  {
    Object localObject = this.jdField_a_of_type_AndroidViewViewStub;
    if (localObject != null)
    {
      if (this.jdField_d_of_type_Boolean) {
        return;
      }
      if (paramBoolean)
      {
        localObject = (ViewGroup.MarginLayoutParams)((ViewStub)localObject).getLayoutParams();
        ((ViewGroup.MarginLayoutParams)localObject).topMargin = ViewUtils.a(35.0F);
        ((ViewGroup.MarginLayoutParams)localObject).bottomMargin = ViewUtils.a(10.0F);
        this.jdField_a_of_type_AndroidViewViewStub.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
      localObject = this.jdField_a_of_type_AndroidViewViewStub;
      if (paramBoolean) {
        i = 2131562579;
      } else {
        i = 2131562578;
      }
      ((ViewStub)localObject).setLayoutResource(i);
      this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewViewStub.inflate();
      this.jdField_d_of_type_Boolean = true;
      QZLog.i("AdVideoView", " @getGdtInfo initAdvView");
      this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)this.jdField_a_of_type_AndroidViewView.findViewById(2131362264));
      this.jdField_a_of_type_ComTencentMobileqqVasAdvQzoneLogicAdvRoundFrameLayout = ((AdvRoundFrameLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131362265));
      int i = ViewUtils.a(3.0F);
      this.jdField_a_of_type_ComTencentMobileqqVasAdvQzoneLogicAdvRoundFrameLayout.setRaduis(i, i, 0, 0);
      this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131362268));
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131362267));
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131362269));
      this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131362263));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131362270));
      this.jdField_a_of_type_AndroidViewViewGroup.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131375205));
      this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView = ((BaseVideoView)QQVideoViewFactory.c(this.jdField_a_of_type_AndroidContentContext, 0L, null, null));
      this.jdField_d_of_type_AndroidWidgetImageView = new ImageView(this.jdField_a_of_type_AndroidContentContext);
      this.jdField_b_of_type_ComTencentMobileqqVasAdvQzoneLogicAdvRoundFrameLayout = ((AdvRoundFrameLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131362266));
      this.jdField_b_of_type_ComTencentMobileqqVasAdvQzoneLogicAdvRoundFrameLayout.setRaduis(ViewUtils.a(10.0F));
      this.jdField_d_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
      localObject = new FrameLayout.LayoutParams(-1, -1);
      BaseVideoView localBaseVideoView = this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView;
      if (localBaseVideoView != null) {
        this.jdField_a_of_type_ComTencentMobileqqVasAdvQzoneLogicAdvRoundFrameLayout.addView(localBaseVideoView, (ViewGroup.LayoutParams)localObject);
      } else {
        QZLog.i("AdVideoView", " @getGdtInfo mVideoView is null");
      }
      this.jdField_a_of_type_ComTencentMobileqqVasAdvQzoneLogicAdvRoundFrameLayout.addView(this.jdField_d_of_type_AndroidWidgetImageView, (ViewGroup.LayoutParams)localObject);
    }
  }
  
  public void b(BaseVideoView paramBaseVideoView)
  {
    if (paramBaseVideoView == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("AdVideoView", 0, "pauseVideoPlay ");
    }
    paramBaseVideoView.pause();
  }
  
  public void c(BaseVideoView paramBaseVideoView)
  {
    if (paramBaseVideoView == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("AdVideoView", 0, "realeseaPlayer ");
    }
    AlumBasicData localAlumBasicData = this.jdField_a_of_type_ComTencentMobileqqVasAdvCommonDataAlumBasicData;
    if ((localAlumBasicData != null) && (this.jdField_a_of_type_Boolean))
    {
      this.jdField_a_of_type_Boolean = false;
      a(this.jdField_a_of_type_Int, this.jdField_b_of_type_Long, 0, 3, false, localAlumBasicData.mVideoReportUrl);
    }
    paramBaseVideoView.releasePlayer(false);
    this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView = null;
  }
  
  @NonNull
  public View getView()
  {
    return this.jdField_a_of_type_AndroidViewViewStub;
  }
  
  public void initStubView(@NotNull ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_AndroidViewViewStub = ((ViewStub)LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131562575, paramViewGroup, false));
  }
  
  public void onDestroy()
  {
    GdtAppReceiver localGdtAppReceiver = this.jdField_a_of_type_ComTencentGdtadAditemGdtAppReceiver;
    if (localGdtAppReceiver != null) {
      localGdtAppReceiver.unregister(this.jdField_a_of_type_AndroidContentContext);
    }
    c(this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView);
  }
  
  public void onPause()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AdVideoView", 0, "onPause = ");
    }
    if (this.jdField_c_of_type_Boolean) {
      b(this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView);
    }
  }
  
  public void onResume()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AdVideoView", 0, "onResume = ");
    }
    if (this.jdField_c_of_type_Boolean) {
      a(this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView);
    }
  }
  
  public void setOutActivity(Activity paramActivity)
  {
    if (paramActivity != null) {
      this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramActivity);
    }
  }
  
  public void setVideoDataChanged(AlumBasicData paramAlumBasicData, int paramInt)
  {
    if ((paramAlumBasicData != null) && (paramAlumBasicData.mAdvType == 1))
    {
      a(paramAlumBasicData.isUseAdNegativeFeedbackNewIcon());
      a(paramAlumBasicData);
      a(this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView, paramAlumBasicData, paramInt, this.jdField_a_of_type_AndroidContentContext);
      a(this.jdField_b_of_type_AndroidWidgetImageView, paramAlumBasicData.advLogoUrl, paramAlumBasicData, Boolean.valueOf(false));
      a(this.jdField_d_of_type_AndroidWidgetImageView, paramAlumBasicData.advimageUrl, paramAlumBasicData, Boolean.valueOf(true));
      a(this.jdField_c_of_type_AndroidWidgetTextView, paramAlumBasicData);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramAlumBasicData.advTextTitle);
      this.jdField_b_of_type_AndroidWidgetTextView.setText(paramAlumBasicData.advTextText);
      this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
      if (QZLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("setDataChanged titile =");
        ((StringBuilder)localObject).append(paramAlumBasicData.advTextTitle);
        ((StringBuilder)localObject).append(" desc =");
        ((StringBuilder)localObject).append(paramAlumBasicData.advTextText);
        ((StringBuilder)localObject).append(" url =");
        ((StringBuilder)localObject).append(paramAlumBasicData.advLogoUrl);
        ((StringBuilder)localObject).append("faceimage url =");
        ((StringBuilder)localObject).append(paramAlumBasicData.advimageUrl);
        QZLog.i("AdVideoView", ((StringBuilder)localObject).toString());
      }
      this.jdField_a_of_type_ComTencentMobileqqVasAdvCommonDataAlumBasicData = paramAlumBasicData;
      paramAlumBasicData = this.jdField_a_of_type_ComTencentMobileqqVasAdvCommonDataAlumBasicData;
      if ((paramAlumBasicData != null) && (paramAlumBasicData.adInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqVasAdvCommonDataAlumBasicData.adInfo.app_info != null) && (this.jdField_a_of_type_ComTencentMobileqqVasAdvCommonDataAlumBasicData.adInfo.app_info.app_package_name != null))
      {
        paramAlumBasicData = this.jdField_a_of_type_ComTencentMobileqqVasAdvCommonDataAlumBasicData;
        paramAlumBasicData.originalExposureReport(paramAlumBasicData, ApkUtils.a(paramAlumBasicData.adInfo.app_info.app_package_name.get(), this.jdField_a_of_type_AndroidContentContext));
      }
      Object localObject = new AdExposureChecker(null, new WeakReference(this.jdField_a_of_type_AndroidViewView));
      AlumBasicData localAlumBasicData = this.jdField_a_of_type_ComTencentMobileqqVasAdvCommonDataAlumBasicData;
      paramAlumBasicData = (AlumBasicData)localObject;
      if (localAlumBasicData != null)
      {
        paramAlumBasicData = (AlumBasicData)localObject;
        if (localAlumBasicData.adInfo != null)
        {
          paramAlumBasicData = new AdExposureChecker(new GdtAd(this.jdField_a_of_type_ComTencentMobileqqVasAdvCommonDataAlumBasicData.adInfo), new WeakReference(this.jdField_a_of_type_AndroidViewView));
          if (this.jdField_a_of_type_ComTencentAdTangramUtilAdExposureChecker$ExposureCallback == null) {
            this.jdField_a_of_type_ComTencentAdTangramUtilAdExposureChecker$ExposureCallback = new AdVideoViewController.2(this);
          }
          paramAlumBasicData.setCallback(new WeakReference(this.jdField_a_of_type_ComTencentAdTangramUtilAdExposureChecker$ExposureCallback));
          QZLog.i("AdExposureChecker", "startonExposure");
          this.jdField_a_of_type_JavaUtilArrayList.add(paramAlumBasicData);
        }
      }
      paramAlumBasicData.startCheck();
      return;
    }
    a(this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView, this.jdField_a_of_type_AndroidViewViewGroup);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.adv.qzone.logic.AdVideoViewController
 * JD-Core Version:    0.7.0.1
 */