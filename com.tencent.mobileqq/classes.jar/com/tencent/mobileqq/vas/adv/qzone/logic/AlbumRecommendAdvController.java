package com.tencent.mobileqq.vas.adv.qzone.logic;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
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
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.ad.tangram.util.AdExposureChecker;
import com.tencent.ad.tangram.util.AdExposureChecker.ExposureCallback;
import com.tencent.component.media.image.ImageLoader;
import com.tencent.component.media.image.processor.OvalProcessor;
import com.tencent.component.media.image.view.AsyncImageView;
import com.tencent.gdtad.IGdtAdAPI;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.aditem.GdtAppReceiver;
import com.tencent.gdtad.aditem.GdtHandler.Params;
import com.tencent.gdtad.params.InitGdtContextParams;
import com.tencent.mobileqq.cooperation.ApkUtils;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.adv.base.support.VasAdvSupport;
import com.tencent.mobileqq.vas.adv.common.data.AlumBasicData;
import com.tencent.mobileqq.vas.adv.qzone.api.IVasQZoneApi;
import com.tencent.mobileqq.vas.adv.qzone.data.VasAdMetaReportParam;
import cooperation.qzone.thread.QzoneBaseThread;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import cooperation.qzone.util.QZLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONObject;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.AppInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo;

public class AlbumRecommendAdvController
  implements IAlbumRecommendAdvController
{
  private Context jdField_a_of_type_AndroidContentContext;
  private Handler jdField_a_of_type_AndroidOsHandler;
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new AlbumRecommendAdvController.1(this);
  private View jdField_a_of_type_AndroidViewView;
  private ViewStub jdField_a_of_type_AndroidViewViewStub;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  public AdExposureChecker.ExposureCallback a;
  private AsyncImageView jdField_a_of_type_ComTencentComponentMediaImageViewAsyncImageView;
  private GdtAppReceiver jdField_a_of_type_ComTencentGdtadAditemGdtAppReceiver;
  private AlumBasicData jdField_a_of_type_ComTencentMobileqqVasAdvCommonDataAlumBasicData;
  private AdvRoundFrameLayout jdField_a_of_type_ComTencentMobileqqVasAdvQzoneLogicAdvRoundFrameLayout;
  public final String a;
  private WeakReference<Activity> jdField_a_of_type_JavaLangRefWeakReference = null;
  public ArrayList<AdExposureChecker> a;
  private boolean jdField_a_of_type_Boolean;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private AsyncImageView jdField_b_of_type_ComTencentComponentMediaImageViewAsyncImageView;
  private TextView c;
  
  public AlbumRecommendAdvController(Context paramContext, ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_JavaLangString = "AlbumRecomAdvInfoView";
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_ComTencentAdTangramUtilAdExposureChecker$ExposureCallback = null;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewViewStub = ((ViewStub)LayoutInflater.from(paramContext).inflate(2131562575, paramViewGroup, false));
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    this.jdField_a_of_type_ComTencentGdtadAditemGdtAppReceiver = new GdtAppReceiver();
    this.jdField_a_of_type_ComTencentGdtadAditemGdtAppReceiver.register(this.jdField_a_of_type_AndroidContentContext);
  }
  
  private void a()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqVasAdvCommonDataAlumBasicData;
    if ((localObject != null) && (((AlumBasicData)localObject).adInfo != null))
    {
      localObject = (IGdtAdAPI)QRoute.api(IGdtAdAPI.class);
      ((IGdtAdAPI)localObject).initGdtContext(this.jdField_a_of_type_AndroidContentContext, new InitGdtContextParams());
      ((IGdtAdAPI)localObject).preLoadAfterAdLoaded(this.jdField_a_of_type_AndroidContentContext, new GdtAd(this.jdField_a_of_type_ComTencentMobileqqVasAdvCommonDataAlumBasicData.adInfo));
    }
  }
  
  private void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_AndroidViewViewStub != null)
    {
      if (this.jdField_a_of_type_Boolean) {
        return;
      }
      QZLog.i("AlbumRecomAdvInfoView", " @getGdtInfo initAdvView");
      if (paramBoolean)
      {
        localObject = (ViewGroup.MarginLayoutParams)this.jdField_a_of_type_AndroidViewViewStub.getLayoutParams();
        ((ViewGroup.MarginLayoutParams)localObject).topMargin = ViewUtils.a(35.0F);
        ((ViewGroup.MarginLayoutParams)localObject).bottomMargin = ViewUtils.a(10.0F);
        this.jdField_a_of_type_AndroidViewViewStub.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
      Object localObject = this.jdField_a_of_type_AndroidViewViewStub;
      if (paramBoolean) {
        i = 2131562576;
      } else {
        i = 2131562577;
      }
      ((ViewStub)localObject).setLayoutResource(i);
      localObject = this.jdField_a_of_type_AndroidViewViewStub.inflate();
      this.jdField_a_of_type_AndroidViewView = ((View)localObject);
      this.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)((View)localObject).findViewById(2131375201));
      this.jdField_a_of_type_ComTencentMobileqqVasAdvQzoneLogicAdvRoundFrameLayout = ((AdvRoundFrameLayout)((View)localObject).findViewById(2131375207));
      int i = ViewUtils.a(3.0F);
      this.jdField_a_of_type_ComTencentMobileqqVasAdvQzoneLogicAdvRoundFrameLayout.setRaduis(i, i, 0, 0);
      this.jdField_a_of_type_ComTencentComponentMediaImageViewAsyncImageView = ((AsyncImageView)((View)localObject).findViewById(2131375206));
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject).findViewById(2131375200));
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)((View)localObject).findViewById(2131375208));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)((View)localObject).findViewById(2131375203));
      this.jdField_b_of_type_ComTencentComponentMediaImageViewAsyncImageView = ((AsyncImageView)((View)localObject).findViewById(2131375202));
      this.jdField_b_of_type_ComTencentComponentMediaImageViewAsyncImageView.setForeground(2130849443);
      this.jdField_b_of_type_ComTencentComponentMediaImageViewAsyncImageView.setAsyncImageProcessor(new OvalProcessor());
      this.jdField_b_of_type_ComTencentComponentMediaImageViewAsyncImageView.setWillNotDraw(false);
      this.jdField_b_of_type_ComTencentComponentMediaImageViewAsyncImageView.setAsyncPreferQuality(true);
      this.jdField_b_of_type_ComTencentComponentMediaImageViewAsyncImageView.setAsyncDefaultImage(2130849444);
      this.c = ((TextView)((View)localObject).findViewById(2131375205));
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      ((View)localObject).findViewById(2131375204).setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    }
  }
  
  public static boolean a(AlumBasicData paramAlumBasicData)
  {
    if ((paramAlumBasicData != null) && (paramAlumBasicData.adInfo.ext_json != null)) {
      try
      {
        paramAlumBasicData = new JSONObject(paramAlumBasicData.adInfo.ext_json.get());
        if (paramAlumBasicData.has("mini_program_preload"))
        {
          int i = paramAlumBasicData.getInt("mini_program_preload");
          if (i == 1) {
            return true;
          }
        }
      }
      catch (Exception paramAlumBasicData)
      {
        paramAlumBasicData.printStackTrace();
      }
    }
    return false;
  }
  
  public void a(int paramInt, String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = new VasAdMetaReportParam(2, paramInt, 1, 0, VasAdvSupport.a().a(), null, paramString);
      ((IVasQZoneApi)QRoute.api(IVasQZoneApi.class)).reportAdvAsync(paramString);
      return;
    }
    QZLog.i("AlbumRecomAdvInfoView", " @getGdtInfo clickAlumAdvPicViewInfo");
  }
  
  public void a(AlumBasicData paramAlumBasicData)
  {
    if ((paramAlumBasicData != null) && (paramAlumBasicData.adInfo != null)) {
      if ((paramAlumBasicData.adInfo.display_info != null) && (paramAlumBasicData.adInfo.display_info.mini_program_type != null) && (paramAlumBasicData.adInfo.display_info.mini_program_type.get() == 11))
      {
        if (a(paramAlumBasicData)) {
          a();
        }
      }
      else {
        a();
      }
    }
  }
  
  public void a(String paramString)
  {
    QzoneHandlerThreadFactory.getHandlerThread("Normal_HandlerThread").postDelayed(new AlbumRecommendAdvController.4(this, paramString), 0L);
  }
  
  public void a(WeakReference<Activity> paramWeakReference, boolean paramBoolean)
  {
    GdtHandler.Params localParams = new GdtHandler.Params();
    if (paramWeakReference != null)
    {
      localParams.jdField_a_of_type_JavaLangRefWeakReference = paramWeakReference;
      localParams.jdField_a_of_type_ComTencentGdtadAditemGdtAd = new GdtAd(this.jdField_a_of_type_ComTencentMobileqqVasAdvCommonDataAlumBasicData.adInfo);
      localParams.jdField_b_of_type_JavaLangRefWeakReference = new WeakReference(this.jdField_a_of_type_ComTencentGdtadAditemGdtAppReceiver);
      localParams.jdField_a_of_type_Boolean = true;
      localParams.jdField_b_of_type_Boolean = paramBoolean;
      localParams.jdField_a_of_type_AndroidOsBundle = new Bundle();
      localParams.jdField_a_of_type_AndroidOsBundle.putString("big_brother_ref_source_key", "biz_src_jc_qzone");
      ((IGdtAdAPI)QRoute.api(IGdtAdAPI.class)).handleGdtAdClick(localParams);
      QZLog.i("AlbumRecomAdvInfoView", " @getGdtInfo clickAlumAdvPicViewInfo");
    }
  }
  
  public View getView()
  {
    return this.jdField_a_of_type_AndroidViewViewStub;
  }
  
  public void hideAdView()
  {
    RelativeLayout localRelativeLayout = this.jdField_a_of_type_AndroidWidgetRelativeLayout;
    if (localRelativeLayout != null) {
      localRelativeLayout.setVisibility(8);
    }
    QZLog.i("AlbumRecomAdvInfoView", " hide ad view AlbumRecomAdvInfoView");
  }
  
  public void initAndRenderData(@NonNull AlumBasicData paramAlumBasicData)
  {
    if (TextUtils.isEmpty(paramAlumBasicData.advimageUrl))
    {
      hideAdView();
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqVasAdvCommonDataAlumBasicData = paramAlumBasicData;
    a(paramAlumBasicData.isUseAdNegativeFeedbackNewIcon());
    a(paramAlumBasicData);
    if ((paramAlumBasicData.adInfo != null) && (paramAlumBasicData.adInfo.app_info != null) && (paramAlumBasicData.adInfo.app_info.app_package_name != null)) {
      paramAlumBasicData.originalExposureReport(paramAlumBasicData, ApkUtils.a(paramAlumBasicData.adInfo.app_info.app_package_name.get(), this.jdField_a_of_type_AndroidContentContext));
    }
    Object localObject = ImageLoader.getInstance().loadImage(paramAlumBasicData.advimageUrl, new AlbumRecommendAdvController.2(this, paramAlumBasicData));
    if (localObject != null)
    {
      this.jdField_a_of_type_ComTencentComponentMediaImageViewAsyncImageView.setImageDrawable((Drawable)localObject);
      a(1, paramAlumBasicData.recCookie);
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramAlumBasicData.advTextTitle);
    this.jdField_b_of_type_AndroidWidgetTextView.setText(paramAlumBasicData.advTextText);
    this.jdField_b_of_type_ComTencentComponentMediaImageViewAsyncImageView.setAsyncImage(paramAlumBasicData.advLogoUrl);
    if (!TextUtils.isEmpty(paramAlumBasicData.rightBottomButton)) {
      this.c.setText(paramAlumBasicData.rightBottomButton);
    } else if (paramAlumBasicData.adInfo.product_type.get() == 12) {
      this.c.setText("去下载");
    } else {
      this.c.setText("去看看");
    }
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    if (QZLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("setDataChanged titile =");
      ((StringBuilder)localObject).append(paramAlumBasicData.advTextTitle);
      ((StringBuilder)localObject).append(" desc =");
      ((StringBuilder)localObject).append(paramAlumBasicData.advTextText);
      ((StringBuilder)localObject).append(" url =");
      ((StringBuilder)localObject).append(paramAlumBasicData.advimageUrl);
      QZLog.i("AlbumRecomAdvInfoView", ((StringBuilder)localObject).toString());
    }
    AdExposureChecker localAdExposureChecker = new AdExposureChecker(null, new WeakReference(this.jdField_a_of_type_AndroidViewView));
    localObject = localAdExposureChecker;
    if (paramAlumBasicData != null)
    {
      localObject = localAdExposureChecker;
      if (paramAlumBasicData.adInfo != null)
      {
        localObject = new AdExposureChecker(new GdtAd(paramAlumBasicData.adInfo), new WeakReference(this.jdField_a_of_type_AndroidViewView));
        if (this.jdField_a_of_type_ComTencentAdTangramUtilAdExposureChecker$ExposureCallback == null) {
          this.jdField_a_of_type_ComTencentAdTangramUtilAdExposureChecker$ExposureCallback = new AlbumRecommendAdvController.3(this, paramAlumBasicData);
        }
        ((AdExposureChecker)localObject).setCallback(new WeakReference(this.jdField_a_of_type_ComTencentAdTangramUtilAdExposureChecker$ExposureCallback));
        QZLog.i("AdExposureChecker", "startonExposure");
        this.jdField_a_of_type_JavaUtilArrayList.add(localObject);
      }
    }
    ((AdExposureChecker)localObject).startCheck();
  }
  
  public void onDestroy()
  {
    Object localObject = this.jdField_a_of_type_ComTencentGdtadAditemGdtAppReceiver;
    if (localObject != null) {
      ((GdtAppReceiver)localObject).unregister(this.jdField_a_of_type_AndroidContentContext);
    }
    localObject = this.jdField_a_of_type_JavaUtilArrayList;
    if (localObject != null)
    {
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        AdExposureChecker localAdExposureChecker = (AdExposureChecker)((Iterator)localObject).next();
        localAdExposureChecker.onActivityDestroy();
        localAdExposureChecker.setCallback(null);
      }
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      this.jdField_a_of_type_ComTencentAdTangramUtilAdExposureChecker$ExposureCallback = null;
    }
  }
  
  public void onPause()
  {
    Object localObject = this.jdField_a_of_type_JavaUtilArrayList;
    if (localObject != null)
    {
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((AdExposureChecker)((Iterator)localObject).next()).onActivityPause();
      }
    }
  }
  
  public void onResume()
  {
    Object localObject = this.jdField_a_of_type_JavaUtilArrayList;
    if (localObject != null)
    {
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((AdExposureChecker)((Iterator)localObject).next()).onActivityResume();
      }
    }
  }
  
  public void setOutActivity(Activity paramActivity)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramActivity);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.adv.qzone.logic.AlbumRecommendAdvController
 * JD-Core Version:    0.7.0.1
 */