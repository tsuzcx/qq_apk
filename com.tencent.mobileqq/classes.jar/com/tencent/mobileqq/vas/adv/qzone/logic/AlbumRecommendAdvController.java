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
  public final String a = "AlbumRecomAdvInfoView";
  public ArrayList<AdExposureChecker> b = new ArrayList();
  public AdExposureChecker.ExposureCallback c = null;
  View.OnClickListener d = new AlbumRecommendAdvController.1(this);
  private Context e;
  private AdvRoundFrameLayout f;
  private AsyncImageView g;
  private TextView h;
  private TextView i;
  private ImageView j;
  private AsyncImageView k;
  private TextView l;
  private ViewStub m;
  private View n;
  private RelativeLayout o;
  private Handler p;
  private AlumBasicData q;
  private GdtAppReceiver r;
  private boolean s;
  private WeakReference<Activity> t = null;
  
  public AlbumRecommendAdvController(Context paramContext, ViewGroup paramViewGroup)
  {
    this.e = paramContext;
    this.m = ((ViewStub)LayoutInflater.from(paramContext).inflate(2131629006, paramViewGroup, false));
    this.p = new Handler(Looper.getMainLooper());
    this.r = new GdtAppReceiver();
    this.r.register(this.e);
  }
  
  private void a()
  {
    Object localObject = this.q;
    if ((localObject != null) && (((AlumBasicData)localObject).adInfo != null))
    {
      localObject = (IGdtAdAPI)QRoute.api(IGdtAdAPI.class);
      ((IGdtAdAPI)localObject).initGdtContext(this.e, new InitGdtContextParams());
      ((IGdtAdAPI)localObject).preLoadAfterAdLoaded(this.e, new GdtAd(this.q.adInfo));
    }
  }
  
  private void a(boolean paramBoolean)
  {
    if (this.m != null)
    {
      if (this.s) {
        return;
      }
      QZLog.i("AlbumRecomAdvInfoView", " @getGdtInfo initAdvView");
      if (paramBoolean)
      {
        localObject = (ViewGroup.MarginLayoutParams)this.m.getLayoutParams();
        ((ViewGroup.MarginLayoutParams)localObject).topMargin = ViewUtils.dip2px(35.0F);
        ((ViewGroup.MarginLayoutParams)localObject).bottomMargin = ViewUtils.dip2px(10.0F);
        this.m.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
      Object localObject = this.m;
      if (paramBoolean) {
        i1 = 2131629007;
      } else {
        i1 = 2131629008;
      }
      ((ViewStub)localObject).setLayoutResource(i1);
      localObject = this.m.inflate();
      this.n = ((View)localObject);
      this.s = true;
      this.o = ((RelativeLayout)((View)localObject).findViewById(2131443386));
      this.f = ((AdvRoundFrameLayout)((View)localObject).findViewById(2131443392));
      int i1 = ViewUtils.dip2px(3.0F);
      this.f.setRaduis(i1, i1, 0, 0);
      this.g = ((AsyncImageView)((View)localObject).findViewById(2131443391));
      this.j = ((ImageView)((View)localObject).findViewById(2131443385));
      this.h = ((TextView)((View)localObject).findViewById(2131443393));
      this.i = ((TextView)((View)localObject).findViewById(2131443388));
      this.k = ((AsyncImageView)((View)localObject).findViewById(2131443387));
      this.k.setForeground(2130851127);
      this.k.setAsyncImageProcessor(new OvalProcessor());
      this.k.setWillNotDraw(false);
      this.k.setAsyncPreferQuality(true);
      this.k.setAsyncDefaultImage(2130851128);
      this.l = ((TextView)((View)localObject).findViewById(2131443390));
      this.o.setOnClickListener(this.d);
      this.j.setOnClickListener(this.d);
      ((View)localObject).findViewById(2131443389).setOnClickListener(this.d);
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
          int i1 = paramAlumBasicData.getInt("mini_program_preload");
          if (i1 == 1) {
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
      paramString = new VasAdMetaReportParam(2, paramInt, 1, 0, VasAdvSupport.h().a(), null, paramString);
      ((IVasQZoneApi)QRoute.api(IVasQZoneApi.class)).reportAdvAsync(paramString);
      return;
    }
    QZLog.i("AlbumRecomAdvInfoView", " @getGdtInfo clickAlumAdvPicViewInfo");
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
      localParams.r = paramWeakReference;
      localParams.a = new GdtAd(this.q.adInfo);
      localParams.s = new WeakReference(this.r);
      localParams.b = true;
      localParams.e = paramBoolean;
      localParams.p = new Bundle();
      localParams.p.putString("big_brother_ref_source_key", "biz_src_jc_qzone");
      ((IGdtAdAPI)QRoute.api(IGdtAdAPI.class)).handleGdtAdClick(localParams);
      QZLog.i("AlbumRecomAdvInfoView", " @getGdtInfo clickAlumAdvPicViewInfo");
    }
  }
  
  public void b(AlumBasicData paramAlumBasicData)
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
  
  public View getView()
  {
    return this.m;
  }
  
  public void hideAdView()
  {
    RelativeLayout localRelativeLayout = this.o;
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
    this.q = paramAlumBasicData;
    a(paramAlumBasicData.isUseAdNegativeFeedbackNewIcon());
    b(paramAlumBasicData);
    if ((paramAlumBasicData.adInfo != null) && (paramAlumBasicData.adInfo.app_info != null) && (paramAlumBasicData.adInfo.app_info.app_package_name != null)) {
      paramAlumBasicData.originalExposureReport(paramAlumBasicData, ApkUtils.a(paramAlumBasicData.adInfo.app_info.app_package_name.get(), this.e));
    }
    Object localObject = ImageLoader.getInstance().loadImage(paramAlumBasicData.advimageUrl, new AlbumRecommendAdvController.2(this, paramAlumBasicData));
    if (localObject != null)
    {
      this.g.setImageDrawable((Drawable)localObject);
      a(1, paramAlumBasicData.recCookie);
    }
    this.h.setText(paramAlumBasicData.advTextTitle);
    this.i.setText(paramAlumBasicData.advTextText);
    this.k.setAsyncImage(paramAlumBasicData.advLogoUrl);
    if (!TextUtils.isEmpty(paramAlumBasicData.rightBottomButton)) {
      this.l.setText(paramAlumBasicData.rightBottomButton);
    } else if (paramAlumBasicData.adInfo.product_type.get() == 12) {
      this.l.setText("去下载");
    } else {
      this.l.setText("去看看");
    }
    this.o.setVisibility(0);
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
    AdExposureChecker localAdExposureChecker = new AdExposureChecker(null, new WeakReference(this.n));
    localObject = localAdExposureChecker;
    if (paramAlumBasicData != null)
    {
      localObject = localAdExposureChecker;
      if (paramAlumBasicData.adInfo != null)
      {
        localObject = new AdExposureChecker(new GdtAd(paramAlumBasicData.adInfo), new WeakReference(this.n));
        if (this.c == null) {
          this.c = new AlbumRecommendAdvController.3(this, paramAlumBasicData);
        }
        ((AdExposureChecker)localObject).setCallback(new WeakReference(this.c));
        QZLog.i("AdExposureChecker", "startonExposure");
        this.b.add(localObject);
      }
    }
    ((AdExposureChecker)localObject).startCheck();
  }
  
  public void onDestroy()
  {
    Object localObject = this.r;
    if (localObject != null) {
      ((GdtAppReceiver)localObject).unregister(this.e);
    }
    localObject = this.b;
    if (localObject != null)
    {
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        AdExposureChecker localAdExposureChecker = (AdExposureChecker)((Iterator)localObject).next();
        localAdExposureChecker.onActivityDestroy();
        localAdExposureChecker.setCallback(null);
      }
      this.b.clear();
      this.c = null;
    }
  }
  
  public void onPause()
  {
    Object localObject = this.b;
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
    Object localObject = this.b;
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
    this.t = new WeakReference(paramActivity);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.adv.qzone.logic.AlbumRecommendAdvController
 * JD-Core Version:    0.7.0.1
 */