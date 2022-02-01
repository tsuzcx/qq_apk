package com.tencent.mobileqq.weather.hippy;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.api.IPublicAccountHandler;
import com.tencent.hippy.qq.api.IHippyAccessHelper;
import com.tencent.hippy.qq.fragment.CommonHippyFragment;
import com.tencent.hippy.qq.utils.SerializableMap;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.qroute.route.URIRequest;
import com.tencent.mobileqq.qwallet.utils.FlymeOSStatusBarFontUtils;
import com.tencent.mobileqq.soso.location.LbsManagerServiceOnLocationChangeListener;
import com.tencent.mobileqq.soso.location.api.ILbsManagerServiceApi;
import com.tencent.mobileqq.weather.api.IWeatherCommApi;
import com.tencent.mobileqq.weather.api.IWeatherReportApi;
import com.tencent.mobileqq.weather.util.WeatherHelper;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.theme.SkinnableBitmapDrawable;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/weather/hippy/WeatherMainHippyFragment;", "Lcom/tencent/hippy/qq/fragment/CommonHippyFragment;", "()V", "mBackIcon", "Landroid/widget/ImageView;", "mRightIcon", "mTitleLayout", "Landroid/widget/LinearLayout;", "mTitleText", "Landroid/widget/TextView;", "doBussinessInitData", "Lorg/json/JSONObject;", "jsInitData", "getLayoutResId", "", "gotoErrorUrl", "", "initBackView", "", "color", "initRightView", "initTitleLayout", "initTitleText", "initViews", "onResume", "requestAdCode", "setTitleLayout", "toWeatherOptionActivity", "updateTitleLayout", "params", "Lcom/tencent/mtt/hippy/common/HippyMap;", "Companion", "qq-weather-impl_release"}, k=1, mv={1, 1, 16})
public final class WeatherMainHippyFragment
  extends CommonHippyFragment
{
  public static final WeatherMainHippyFragment.Companion a = new WeatherMainHippyFragment.Companion(null);
  private LinearLayout b;
  private ImageView c;
  private ImageView d;
  private TextView e;
  
  private final void a()
  {
    Object localObject = this.mRootView.findViewById(2131442536);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "mRootView.findViewById(R…q_weather_pa_hippy_title)");
    this.b = ((LinearLayout)localObject);
    localObject = this.b;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mTitleLayout");
    }
    localObject = ((LinearLayout)localObject).findViewById(2131442535);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "mTitleLayout.findViewByI…R.id.qq_weather_back_img)");
    this.c = ((ImageView)localObject);
    localObject = this.b;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mTitleLayout");
    }
    localObject = ((LinearLayout)localObject).findViewById(2131442540);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "mTitleLayout.findViewByI….id.qq_wetaher_right_img)");
    this.d = ((ImageView)localObject);
    localObject = this.b;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mTitleLayout");
    }
    localObject = ((LinearLayout)localObject).findViewById(2131442537);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "mTitleLayout.findViewByI…id.qq_weather_title_text)");
    this.e = ((TextView)localObject);
    b();
  }
  
  private final void a(int paramInt)
  {
    Drawable localDrawable = getResources().getDrawable(2130841209);
    if ((localDrawable instanceof SkinnableBitmapDrawable)) {
      localDrawable = ((SkinnableBitmapDrawable)localDrawable).mutate2();
    } else {
      localDrawable = localDrawable.mutate();
    }
    localDrawable.setColorFilter(paramInt, PorterDuff.Mode.SRC_ATOP);
    ImageView localImageView = this.c;
    if (localImageView == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mBackIcon");
    }
    localImageView.setImageDrawable(localDrawable);
  }
  
  private final void b()
  {
    Object localObject = this.b;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mTitleLayout");
    }
    ((LinearLayout)localObject).setBackgroundColor(0);
    localObject = this.c;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mBackIcon");
    }
    ((ImageView)localObject).setOnClickListener((View.OnClickListener)new WeatherMainHippyFragment.setTitleLayout.1(this));
    localObject = this.d;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mRightIcon");
    }
    ((ImageView)localObject).setOnClickListener((View.OnClickListener)new WeatherMainHippyFragment.setTitleLayout.2(this));
    a(-1);
    c(-1);
    b(-1);
    FlymeOSStatusBarFontUtils.a((Activity)getActivity(), false);
  }
  
  private final void b(int paramInt)
  {
    Drawable localDrawable = getResources().getDrawable(2130850223);
    Intrinsics.checkExpressionValueIsNotNull(localDrawable, "resources.getDrawable(co…ne_icon_title_more_black)");
    if ((localDrawable instanceof SkinnableBitmapDrawable))
    {
      localDrawable = ((SkinnableBitmapDrawable)localDrawable).mutate2();
      Intrinsics.checkExpressionValueIsNotNull(localDrawable, "drawable.mutate2()");
    }
    else
    {
      localDrawable = localDrawable.mutate();
      Intrinsics.checkExpressionValueIsNotNull(localDrawable, "drawable.mutate()");
    }
    localDrawable.setColorFilter(paramInt, PorterDuff.Mode.SRC_ATOP);
    ImageView localImageView = this.d;
    if (localImageView == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mRightIcon");
    }
    localImageView.setImageDrawable(localDrawable);
  }
  
  private final void c()
  {
    ((IWeatherReportApi)QRoute.api(IWeatherReportApi.class)).reportWeather(null, "new_topbar_account_click");
    ActivityURIRequest localActivityURIRequest = new ActivityURIRequest((Context)getQBaseActivity(), "/pubaccount/detail");
    localActivityURIRequest.extra().putString("uin", "2658655094");
    localActivityURIRequest.extra().putString("uinname", "QQ天气");
    localActivityURIRequest.extra().putInt("uintype", 1008);
    localActivityURIRequest.setFlags(67108864);
    QRoute.startUri((URIRequest)localActivityURIRequest, null);
    ((IPublicAccountHandler)QRoute.api(IPublicAccountHandler.class)).reportClickPublicAccountEvent(null, "2658655094", "Pb_account_lifeservice", "mp_msg_sys_2", "detail");
  }
  
  private final void c(int paramInt)
  {
    TextView localTextView = this.e;
    if (localTextView == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mTitleText");
    }
    localTextView.setTextColor(paramInt);
  }
  
  private final void d()
  {
    ((ILbsManagerServiceApi)QRoute.api(ILbsManagerServiceApi.class)).startLocation((LbsManagerServiceOnLocationChangeListener)new WeatherMainHippyFragment.requestAdCode.1(this, "qq_weather", false));
  }
  
  public final void a(@NotNull HippyMap paramHippyMap)
  {
    Intrinsics.checkParameterIsNotNull(paramHippyMap, "params");
    if (((WeatherMainHippyFragment)this).b == null) {
      return;
    }
    ThreadManagerV2.getUIHandlerV2().post((Runnable)new WeatherMainHippyFragment.updateTitleLayout.2(this, paramHippyMap));
  }
  
  @NotNull
  protected JSONObject doBussinessInitData(@Nullable JSONObject paramJSONObject)
  {
    paramJSONObject = super.doBussinessInitData(paramJSONObject);
    if (paramJSONObject == null) {
      paramJSONObject = new JSONObject();
    }
    Object localObject1 = getParameters();
    if (localObject1 != null)
    {
      SerializableMap localSerializableMap = (SerializableMap)((Bundle)localObject1).getSerializable("qqWeatherParams");
      boolean bool = ((Bundle)localObject1).getBoolean("isFromShare", false);
      if (localSerializableMap != null)
      {
        localObject1 = localSerializableMap.getMap();
        Intrinsics.checkExpressionValueIsNotNull(localObject1, "map");
        localObject1 = (Map)localObject1;
        Object localObject2 = getQBaseActivity();
        Intrinsics.checkExpressionValueIsNotNull(localObject2, "qBaseActivity");
        localObject2 = ((QBaseActivity)localObject2).getAppRuntime();
        Intrinsics.checkExpressionValueIsNotNull(localObject2, "qBaseActivity.appRuntime");
        ((Map)localObject1).put("uin", ((AppRuntime)localObject2).getCurrentUin());
        localObject1 = localSerializableMap.getMap();
        Intrinsics.checkExpressionValueIsNotNull(localObject1, "map");
        ((Map)localObject1).put("isFromShare", Boolean.valueOf(bool));
        localObject1 = localSerializableMap.getMap();
        Intrinsics.checkExpressionValueIsNotNull(localObject1, "map");
        ((Map)localObject1).put("isAuth", Boolean.valueOf(WeatherHelper.a((Context)getActivity())));
        paramJSONObject.put("qqWeatherParams", ((IHippyAccessHelper)QRoute.api(IHippyAccessHelper.class)).wrapHashMap(null, localSerializableMap.getMap()));
      }
    }
    return paramJSONObject;
  }
  
  protected int getLayoutResId()
  {
    return 2131627942;
  }
  
  protected boolean gotoErrorUrl()
  {
    if (!isFragmentDestroyed())
    {
      QBaseActivity localQBaseActivity = getQBaseActivity();
      if (localQBaseActivity != null)
      {
        QRouteApi localQRouteApi = QRoute.api(IWeatherCommApi.class);
        Intrinsics.checkExpressionValueIsNotNull(localQRouteApi, "QRoute.api(IWeatherCommApi::class.java)");
        ((IWeatherCommApi)localQRouteApi).openWeatherWebForHippy((Context)localQBaseActivity, getParameters().getString("adcode", "100000"));
        getQBaseActivity().finish();
        return true;
      }
    }
    return super.gotoErrorUrl();
  }
  
  protected void initViews()
  {
    super.initViews();
    a();
  }
  
  public void onResume()
  {
    if (WeatherHelper.a((Context)getActivity())) {
      d();
    }
    super.onResume();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.weather.hippy.WeatherMainHippyFragment
 * JD-Core Version:    0.7.0.1
 */