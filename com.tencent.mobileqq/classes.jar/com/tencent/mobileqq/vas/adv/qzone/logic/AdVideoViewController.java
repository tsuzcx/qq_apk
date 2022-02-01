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
  private boolean A = false;
  private boolean B;
  private WeakReference<Activity> C = null;
  public final String a = "AdVideoView";
  BaseVideoView b;
  public ArrayList<AdExposureChecker> c = new ArrayList();
  public AdExposureChecker.ExposureCallback d = null;
  View.OnClickListener e = new AdVideoViewController.1(this);
  private Context f;
  private TextView g;
  private TextView h;
  private ImageView i;
  private ViewStub j;
  private View k;
  private ViewGroup l;
  private Handler m;
  private AlumBasicData n;
  private GdtAppReceiver o;
  private AdvRoundFrameLayout p;
  private ImageView q;
  private ImageView r;
  private ImageView s;
  private AdvRoundFrameLayout t;
  private TextView u;
  private long v = 0L;
  private int w = 0;
  private boolean x = false;
  private long y = 0L;
  private boolean z = false;
  
  public AdVideoViewController(Context paramContext)
  {
    this.f = paramContext;
    this.m = new Handler(Looper.getMainLooper());
    this.o = new GdtAppReceiver();
    this.o.register(this.f);
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
      paramTextView.setText(2131886197);
      return;
    }
    paramTextView.setText(2131886198);
  }
  
  private boolean b(AlumBasicData paramAlumBasicData)
  {
    if (paramAlumBasicData == null) {
      return false;
    }
    int i1 = LocalMultiProcConfig.getInt("QZ_setting", "Qzone_playMode", 0);
    boolean bool = true;
    if (i1 == 2) {}
    while ((i1 == 0) && (!NetworkUtil.isWifiConnected(this.f)))
    {
      i1 = 0;
      break;
    }
    i1 = 1;
    if ((i1 == 0) || (paramAlumBasicData.mAutoPlay != 1)) {
      bool = false;
    }
    this.A = bool;
    if (QLog.isColorLevel())
    {
      paramAlumBasicData = new StringBuilder();
      paramAlumBasicData.append("getCanAutoPlay = ");
      paramAlumBasicData.append(this.A);
      QLog.d("AdVideoView", 0, paramAlumBasicData.toString());
    }
    return this.A;
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
        i1 = paramAdvReportVideoModel.d;
        int i3 = 1;
        if (i1 <= 1)
        {
          i1 = 11;
          localObject = new JSONObject();
          ((JSONObject)localObject).put("bt", "0");
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(paramAdvReportVideoModel.b);
          localStringBuilder.append("");
          ((JSONObject)localObject).put("et", localStringBuilder.toString());
          localStringBuilder = new StringBuilder();
          if (paramAdvReportVideoModel.a <= 0L) {
            break label385;
          }
          i2 = 0;
          localStringBuilder.append(i2);
          localStringBuilder.append("");
          ((JSONObject)localObject).put("bf", localStringBuilder.toString());
          localStringBuilder = new StringBuilder();
          if (!paramAdvReportVideoModel.c) {
            break label390;
          }
          i2 = i3;
          localStringBuilder.append(i2);
          localStringBuilder.append("");
          ((JSONObject)localObject).put("ef", localStringBuilder.toString());
          ((JSONObject)localObject).put("pp", "0");
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(i1);
          localStringBuilder.append("");
          ((JSONObject)localObject).put("pa", localStringBuilder.toString());
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(paramAdvReportVideoModel.f);
          localStringBuilder.append("");
          ((JSONObject)localObject).put("ft", localStringBuilder.toString());
          if (paramAdvReportVideoModel.e != 0)
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append(paramAdvReportVideoModel.e);
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
      int i1 = 13;
      continue;
      label385:
      int i2 = 1;
      continue;
      label390:
      i2 = 0;
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
      paramString = new VasAdMetaReportParam(2, paramInt, 1, 0, VasAdvSupport.h().a(), null, paramString);
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
      ((IGdtAdAPI)QRoute.api(IGdtAdAPI.class)).preLoadAfterAdLoaded(this.f, new GdtAd(paramAlumBasicData.adInfo));
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
      localParams.r = paramWeakReference;
      localParams.a = new GdtAd(paramAlumBasicData.adInfo);
      localParams.s = new WeakReference(this.o);
      localParams.b = true;
      localParams.e = false;
      localParams.g = true;
      localParams.f = true;
      localParams.p = new Bundle();
      localParams.p.putString("big_brother_ref_source_key", "biz_src_jc_qzone");
      GdtHandler.a(localParams);
      QZLog.i("AdVideoView", " @getGdtInfo clickAlumAdvPicViewInfo");
    }
  }
  
  public void a(boolean paramBoolean)
  {
    Object localObject = this.j;
    if (localObject != null)
    {
      if (this.B) {
        return;
      }
      if (paramBoolean)
      {
        localObject = (ViewGroup.MarginLayoutParams)((ViewStub)localObject).getLayoutParams();
        ((ViewGroup.MarginLayoutParams)localObject).topMargin = ViewUtils.dip2px(35.0F);
        ((ViewGroup.MarginLayoutParams)localObject).bottomMargin = ViewUtils.dip2px(10.0F);
        this.j.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
      localObject = this.j;
      if (paramBoolean) {
        i1 = 2131629010;
      } else {
        i1 = 2131629009;
      }
      ((ViewStub)localObject).setLayoutResource(i1);
      this.k = this.j.inflate();
      this.B = true;
      QZLog.i("AdVideoView", " @getGdtInfo initAdvView");
      this.l = ((ViewGroup)this.k.findViewById(2131427851));
      this.p = ((AdvRoundFrameLayout)this.k.findViewById(2131427852));
      int i1 = ViewUtils.dip2px(3.0F);
      this.p.setRaduis(i1, i1, 0, 0);
      this.q = ((ImageView)this.k.findViewById(2131427855));
      this.i = ((ImageView)this.k.findViewById(2131427854));
      this.g = ((TextView)this.k.findViewById(2131427856));
      this.r = ((ImageView)this.k.findViewById(2131427850));
      this.h = ((TextView)this.k.findViewById(2131427857));
      this.l.setOnClickListener(this.e);
      this.i.setOnClickListener(this.e);
      this.u = ((TextView)this.k.findViewById(2131443390));
      this.b = ((BaseVideoView)QQVideoViewFactory.createBaseVideoViewFS(this.f, 0L, null, null));
      this.s = new ImageView(this.f);
      this.t = ((AdvRoundFrameLayout)this.k.findViewById(2131427853));
      this.t.setRaduis(ViewUtils.dip2px(10.0F));
      this.s.setScaleType(ImageView.ScaleType.CENTER_CROP);
      localObject = new FrameLayout.LayoutParams(-1, -1);
      BaseVideoView localBaseVideoView = this.b;
      if (localBaseVideoView != null) {
        this.p.addView(localBaseVideoView, (ViewGroup.LayoutParams)localObject);
      } else {
        QZLog.i("AdVideoView", " @getGdtInfo mVideoView is null");
      }
      this.p.addView(this.s, (ViewGroup.LayoutParams)localObject);
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
    AlumBasicData localAlumBasicData = this.n;
    if ((localAlumBasicData != null) && (this.x))
    {
      this.x = false;
      a(this.w, this.y, 0, 3, false, localAlumBasicData.mVideoReportUrl);
    }
    paramBaseVideoView.releasePlayer(false);
    this.b = null;
  }
  
  @NonNull
  public View getView()
  {
    return this.j;
  }
  
  public void initStubView(@NotNull ViewGroup paramViewGroup)
  {
    this.j = ((ViewStub)LayoutInflater.from(this.f).inflate(2131629006, paramViewGroup, false));
  }
  
  public void onDestroy()
  {
    GdtAppReceiver localGdtAppReceiver = this.o;
    if (localGdtAppReceiver != null) {
      localGdtAppReceiver.unregister(this.f);
    }
    c(this.b);
  }
  
  public void onPause()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AdVideoView", 0, "onPause = ");
    }
    if (this.A) {
      b(this.b);
    }
  }
  
  public void onResume()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AdVideoView", 0, "onResume = ");
    }
    if (this.A) {
      a(this.b);
    }
  }
  
  public void setOutActivity(Activity paramActivity)
  {
    if (paramActivity != null) {
      this.C = new WeakReference(paramActivity);
    }
  }
  
  public void setVideoDataChanged(AlumBasicData paramAlumBasicData, int paramInt)
  {
    if ((paramAlumBasicData != null) && (paramAlumBasicData.mAdvType == 1))
    {
      a(paramAlumBasicData.isUseAdNegativeFeedbackNewIcon());
      a(paramAlumBasicData);
      a(this.b, paramAlumBasicData, paramInt, this.f);
      a(this.q, paramAlumBasicData.advLogoUrl, paramAlumBasicData, Boolean.valueOf(false));
      a(this.s, paramAlumBasicData.advimageUrl, paramAlumBasicData, Boolean.valueOf(true));
      a(this.u, paramAlumBasicData);
      this.g.setText(paramAlumBasicData.advTextTitle);
      this.h.setText(paramAlumBasicData.advTextText);
      this.l.setVisibility(0);
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
      this.n = paramAlumBasicData;
      paramAlumBasicData = this.n;
      if ((paramAlumBasicData != null) && (paramAlumBasicData.adInfo != null) && (this.n.adInfo.app_info != null) && (this.n.adInfo.app_info.app_package_name != null))
      {
        paramAlumBasicData = this.n;
        paramAlumBasicData.originalExposureReport(paramAlumBasicData, ApkUtils.a(paramAlumBasicData.adInfo.app_info.app_package_name.get(), this.f));
      }
      Object localObject = new AdExposureChecker(null, new WeakReference(this.k));
      AlumBasicData localAlumBasicData = this.n;
      paramAlumBasicData = (AlumBasicData)localObject;
      if (localAlumBasicData != null)
      {
        paramAlumBasicData = (AlumBasicData)localObject;
        if (localAlumBasicData.adInfo != null)
        {
          paramAlumBasicData = new AdExposureChecker(new GdtAd(this.n.adInfo), new WeakReference(this.k));
          if (this.d == null) {
            this.d = new AdVideoViewController.2(this);
          }
          paramAlumBasicData.setCallback(new WeakReference(this.d));
          QZLog.i("AdExposureChecker", "startonExposure");
          this.c.add(paramAlumBasicData);
        }
      }
      paramAlumBasicData.startCheck();
      return;
    }
    a(this.b, this.l);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.adv.qzone.logic.AdVideoViewController
 * JD-Core Version:    0.7.0.1
 */