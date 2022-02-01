package com.tencent.mobileqq.kandian.biz.daily;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.Layout.Params;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.ViewFactory;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.kandian.base.utils.RIJSPUtils;
import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.pts.factory.TemplateFactory;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicEngine;
import com.tencent.mobileqq.kandian.glue.pts.util.ProteusSupportUtil;
import com.tencent.mobileqq.kandian.glue.report.RIJTransMergeKanDianReport.ReportR5Builder;
import com.tencent.mobileqq.kandian.repo.aladdin.handlers.DailyModeConfigHandler;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyObserver;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.soso.location.LbsManagerServiceOnLocationChangeListener;
import com.tencent.mobileqq.soso.location.api.ILbsManagerServiceApi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.json.JSONObject;

public class DailyDynamicHeaderViewController
{
  private final VafContext a;
  private final View.OnClickListener b = new DailyDynamicHeaderViewController.1(this);
  private final View.OnClickListener c = new DailyDynamicHeaderViewController.2(this);
  private final View.OnClickListener d = new DailyDynamicHeaderViewController.3(this);
  private final View.OnClickListener e = new DailyDynamicHeaderViewController.4(this);
  private final LbsManagerServiceOnLocationChangeListener f = new DailyDynamicHeaderViewController.5(this, "readinjoy_weather");
  private View g;
  private ViewGroup h;
  private ImageView i;
  private DailyTitleBarSwitcher j;
  private View.OnClickListener k;
  private int l = -1;
  private int m = -1;
  private final ReadInJoyObserver n = new DailyDynamicHeaderViewController.6(this);
  
  public DailyDynamicHeaderViewController(@NonNull VafContext paramVafContext)
  {
    this.a = paramVafContext;
  }
  
  private static Container a(VafContext paramVafContext, JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return null;
    }
    for (;;)
    {
      try
      {
        Object localObject = paramJSONObject.optString("style_ID", "null");
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("[inflateProteusView] ");
        localStringBuilder.append((String)localObject);
        QLog.i("DailyHeaderViewController", 1, localStringBuilder.toString());
        localObject = TemplateFactory.a("daily_dynamic_header", true);
        if (localObject != null)
        {
          paramJSONObject = ((TemplateFactory)localObject).getTemplateBean(paramJSONObject);
          if (paramJSONObject != null)
          {
            paramVafContext = paramVafContext.getViewFactory().inflate(paramVafContext, paramJSONObject);
            ProteusSupportUtil.a(paramVafContext, null, paramJSONObject);
            paramVafContext.setTag(paramJSONObject);
            return paramVafContext;
          }
          QLog.e("DailyHeaderViewController", 1, "[inflateProteusView] template bean is null");
          return null;
        }
      }
      catch (Exception paramVafContext)
      {
        QLog.e("DailyHeaderViewController", 1, "[inflateProteusView] ", paramVafContext);
        return null;
      }
      paramJSONObject = null;
    }
  }
  
  private Container a(JSONObject paramJSONObject, View.OnClickListener paramOnClickListener)
  {
    int i1 = this.m;
    if ((i1 != -1) && (i1 != 0))
    {
      e();
      paramJSONObject = a(this.a, paramJSONObject);
      if (paramJSONObject != null)
      {
        this.h.setOnClickListener(paramOnClickListener);
        a(this.h, paramJSONObject);
        this.i.setImageResource(2130844282);
        return paramJSONObject;
      }
      a(0);
    }
    else
    {
      Container localContainer = a(this.a, paramJSONObject);
      if (localContainer != null)
      {
        Drawable localDrawable = this.g.getContext().getResources().getDrawable(2130844282);
        a(this.g, localContainer, localDrawable, paramJSONObject);
        this.h.setOnClickListener(paramOnClickListener);
        return localContainer;
      }
      a(0);
    }
    return null;
  }
  
  private static URLDrawable.URLDrawableOptions a(Context paramContext)
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    paramContext = paramContext.getResources().getDrawable(2130844282);
    localURLDrawableOptions.mLoadingDrawable = paramContext;
    localURLDrawableOptions.mFailedDrawable = paramContext;
    return localURLDrawableOptions;
  }
  
  private static String a(String paramString)
  {
    if (TextUtils.equals(paramString, "ReadInJoyDailyDynamicWeatherHeader")) {
      return "1";
    }
    if (TextUtils.equals(paramString, "ReadInJoyDailyDynamicFestivalHeader")) {
      return "2";
    }
    if (TextUtils.equals(paramString, "ReadInJoyDailyDynamicVideoTopicHeader")) {
      return "3";
    }
    return null;
  }
  
  private void a(int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[moveToState] from: ");
    ((StringBuilder)localObject).append(this.l);
    ((StringBuilder)localObject).append(" to ");
    ((StringBuilder)localObject).append(paramInt);
    QLog.i("DailyHeaderViewController", 1, ((StringBuilder)localObject).toString());
    this.m = this.l;
    this.l = paramInt;
    RIJSPUtils.a("sp_key_daily_dynamic_header_state", Integer.valueOf(this.l));
    localObject = this.h;
    if (localObject != null) {
      ((ViewGroup)localObject).setOnClickListener(null);
    }
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if ((paramInt != 2) && (paramInt != 3) && (paramInt != 4))
        {
          if (paramInt == 5)
          {
            d();
            return;
          }
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("invalid state ");
          ((StringBuilder)localObject).append(paramInt);
          throw new IllegalStateException(((StringBuilder)localObject).toString());
        }
        b(paramInt);
        return;
      }
      c();
      return;
    }
    b();
  }
  
  private void a(@NonNull View paramView, @NonNull Container paramContainer, @NonNull Drawable paramDrawable, JSONObject paramJSONObject)
  {
    QLog.i("DailyHeaderViewController", 1, "[setupDynamicHeader] ");
    ((DailyTitleBar)paramView.findViewById(2131439396)).setVisibility(8);
    DailyTitleBarSwitcher localDailyTitleBarSwitcher = (DailyTitleBarSwitcher)paramView.findViewById(2131431565);
    localDailyTitleBarSwitcher.setVisibility(0);
    localDailyTitleBarSwitcher.setOnLeftButtonClickListener(this.b);
    localDailyTitleBarSwitcher.setOnRightButtonClickListener(this.c);
    localDailyTitleBarSwitcher.setOnTitleClickListener(this.k);
    ReadInJoyDailyPullToZoomHeaderXListView localReadInJoyDailyPullToZoomHeaderXListView = (ReadInJoyDailyPullToZoomHeaderXListView)paramView.findViewById(2131446630);
    this.h = ((ViewGroup)LayoutInflater.from(paramView.getContext()).inflate(2131626214, localReadInJoyDailyPullToZoomHeaderXListView, false));
    this.i = ((ImageView)this.h.findViewById(2131429242));
    DailyDynamicHeaderBackgroundController.a(paramDrawable);
    DailyDynamicHeaderBackgroundController.a(this.i);
    this.i.setImageDrawable(paramDrawable);
    a(this.h, paramContainer);
    localReadInJoyDailyPullToZoomHeaderXListView.a(localDailyTitleBarSwitcher.getOnScrollListener());
    localReadInJoyDailyPullToZoomHeaderXListView.addHeaderView(this.h);
    localReadInJoyDailyPullToZoomHeaderXListView.setHeaderImage(this.i);
    a(paramJSONObject);
  }
  
  private static void a(ViewGroup paramViewGroup, Container paramContainer)
  {
    Layout.Params localParams = paramContainer.getVirtualView().getComLayoutParams();
    paramViewGroup.addView(paramContainer, new ViewGroup.LayoutParams(localParams.mLayoutWidth, localParams.mLayoutHeight));
  }
  
  private static void a(Container paramContainer, String paramString, JSONObject paramJSONObject)
  {
    if (paramContainer == null)
    {
      QLog.e("DailyHeaderViewController", 1, "[setupListeners] container is null");
      return;
    }
    ViewFactory.findClickableViewListener(paramContainer.getVirtualView(), new DailyDynamicHeaderViewController.8(paramString, paramJSONObject));
  }
  
  private void a(@NonNull BaseActivity paramBaseActivity, @NonNull Runnable paramRunnable)
  {
    if (Build.VERSION.SDK_INT >= 23)
    {
      if (paramBaseActivity.checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") != 0)
      {
        paramBaseActivity.requestPermissions(new DailyDynamicHeaderViewController.7(this, paramRunnable), 1, new String[] { "android.permission.ACCESS_FINE_LOCATION" });
        return;
      }
      paramRunnable.run();
      return;
    }
    paramRunnable.run();
  }
  
  private void a(JSONObject paramJSONObject)
  {
    Object localObject = this.g;
    if (localObject == null) {
      return;
    }
    if (this.j == null) {
      this.j = ((DailyTitleBarSwitcher)((View)localObject).findViewById(2131431565));
    }
    if ((this.j != null) && (paramJSONObject != null))
    {
      localObject = paramJSONObject.optString("weather_summary_title");
      paramJSONObject = paramJSONObject.optString("weather_jump_url");
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        this.j.setBackgroundViewTitle((String)localObject, 12.0F);
        this.j.setOnTitleClickWeatherListener(new DailyDynamicHeaderViewController.10(this, paramJSONObject));
        return;
      }
      QLog.i("DailyHeaderViewController", 1, "bindDataForTitleBar, no data.");
      this.j.setBackgroundViewTitle("", 12.0F);
      this.j.setOnTitleClickWeatherListener(null);
    }
  }
  
  private void a(boolean paramBoolean)
  {
    QLog.i("DailyHeaderViewController", 1, "[requestForUpdate] ");
    long l1 = ((Long)RIJSPUtils.b("sp_key_daily_dynamic_header_last_refresh_time", Long.valueOf(0L))).longValue();
    long l2 = System.currentTimeMillis();
    long l3 = Aladdin.getConfig(157).getIntegerFromString("refresh_debounce_interval", 5);
    if ((l2 - l1 <= 60000L * l3) && (!paramBoolean))
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[requestForUpdate] too frequent, less than ");
      ((StringBuilder)localObject).append(l3);
      ((StringBuilder)localObject).append(" minutes, skip.");
      QLog.i("DailyHeaderViewController", 1, ((StringBuilder)localObject).toString());
      if (QLog.isColorLevel())
      {
        localObject = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("[requestForUpdate] last refresh: ");
        localStringBuilder.append(((SimpleDateFormat)localObject).format(new Date(l1)));
        QLog.d("DailyHeaderViewController", 2, localStringBuilder.toString());
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("[requestForUpdate] current time: ");
        localStringBuilder.append(((SimpleDateFormat)localObject).format(new Date(l2)));
        QLog.d("DailyHeaderViewController", 2, localStringBuilder.toString());
      }
    }
    else
    {
      ThreadManagerV2.getUIHandlerV2().post(new DailyDynamicHeaderViewController.9(this));
    }
  }
  
  private static boolean a(Container paramContainer, JSONObject paramJSONObject)
  {
    Object localObject = paramContainer.getTag();
    if ((localObject instanceof TemplateBean)) {
      localObject = (TemplateBean)localObject;
    }
    for (;;)
    {
      try
      {
        TemplateFactory localTemplateFactory = TemplateFactory.a("daily_dynamic_header", true);
        if (localTemplateFactory == null) {
          break label96;
        }
        paramJSONObject = localTemplateFactory.getTemplateBean(paramJSONObject);
        if ((paramJSONObject != null) && (TextUtils.equals(paramJSONObject.getStyleName(), ((TemplateBean)localObject).getStyleName())) && (((TemplateBean)localObject).getId() == paramJSONObject.getId()))
        {
          QLog.i("DailyHeaderViewController", 1, "[bindDataForProteusHeader] template match, bind data");
          ProteusSupportUtil.a(paramContainer, (TemplateBean)localObject, paramJSONObject);
          return true;
        }
      }
      catch (Exception paramContainer)
      {
        QLog.e("DailyHeaderViewController", 1, "[handleStateDynamic] ", paramContainer);
      }
      return false;
      label96:
      paramJSONObject = null;
    }
  }
  
  private static Container b(VafContext paramVafContext, JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return null;
    }
    String str = paramJSONObject.optString("style_ID", "null");
    paramVafContext = a(paramVafContext, paramJSONObject);
    a(paramVafContext, str, paramJSONObject);
    b(str, paramJSONObject);
    return paramVafContext;
  }
  
  private void b()
  {
    QLog.i("DailyHeaderViewController", 1, "[handleStateNormal] ");
    DailyTitleBar localDailyTitleBar = (DailyTitleBar)this.g.findViewById(2131439396);
    localDailyTitleBar.setVisibility(0);
    ImmersiveUtils.setStatusTextColor(true, ((Activity)this.g.getContext()).getWindow());
    localDailyTitleBar.setOnLeftButtonClickListener(this.b);
    localDailyTitleBar.setOnRightButtonClickListener(this.c);
    localDailyTitleBar.setOnTitleClickListener(this.k);
    this.g.findViewById(2131431565).setVisibility(8);
    if (this.h != null)
    {
      ((ReadInJoyDailyPullToZoomHeaderXListView)this.g.findViewById(2131446630)).removeHeaderView(this.h);
      this.h = null;
      this.i = null;
    }
  }
  
  private void b(int paramInt)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.putOpt("style_ID", "ReadInJoyDailyDynamicWeatherHeaderError");
      Object localObject;
      if (paramInt != 2)
      {
        if (paramInt != 3)
        {
          if (paramInt == 4)
          {
            localJSONObject.putOpt("error_reason", HardCodeUtil.a(2131900861)).putOpt("operation_text", HardCodeUtil.a(2131900858));
            localObject = this.d;
          }
          else
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("illegal state ");
            ((StringBuilder)localObject).append(paramInt);
            throw new IllegalStateException(((StringBuilder)localObject).toString());
          }
        }
        else
        {
          localJSONObject.putOpt("error_reason", HardCodeUtil.a(2131900860)).putOpt("operation_text", HardCodeUtil.a(2131900857));
          localObject = this.e;
        }
      }
      else
      {
        localJSONObject.putOpt("error_reason", HardCodeUtil.a(2131900854)).putOpt("operation_text", HardCodeUtil.a(2131900859));
        localObject = this.d;
      }
      a(localJSONObject, (View.OnClickListener)localObject);
      return;
    }
    catch (Exception localException)
    {
      label174:
      break label174;
    }
    a(0);
  }
  
  private void b(View paramView)
  {
    if ((Build.VERSION.SDK_INT >= 23) && (((BaseActivity)paramView.getContext()).checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") != 0))
    {
      QLog.i("DailyHeaderViewController", 1, "[setupHeaders] location permission not granted");
      a(3);
      return;
    }
    a(((Integer)RIJSPUtils.b("sp_key_daily_dynamic_header_state", Integer.valueOf(0))).intValue());
  }
  
  private void b(String paramString)
  {
    this.i = ((ImageView)this.h.findViewById(2131429242));
    try
    {
      paramString = URLDrawable.getDrawable(paramString, a(this.i.getContext()));
      DailyDynamicHeaderBackgroundController.a(paramString);
      DailyDynamicHeaderBackgroundController.a(this.i);
      this.i.setImageDrawable(paramString);
      return;
    }
    catch (Exception paramString)
    {
      this.i.setImageResource(2131167836);
      QLog.e("DailyHeaderViewController", 1, "[onDailyDynamicHeaderDataUpdated] ", paramString);
    }
  }
  
  private static void b(String paramString, JSONObject paramJSONObject)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[reportHeaderExposure] ");
    ((StringBuilder)localObject).append(paramString);
    QLog.i("DailyHeaderViewController", 1, ((StringBuilder)localObject).toString());
    localObject = new RIJTransMergeKanDianReport.ReportR5Builder();
    ((RIJTransMergeKanDianReport.ReportR5Builder)localObject).addStringNotThrow("model_type", a(paramString));
    ((RIJTransMergeKanDianReport.ReportR5Builder)localObject).addStringNotThrow("topic_id", paramJSONObject.optString("topic_id", ""));
    PublicAccountReportUtils.a(null, "CliOper", "", "", "0X8009D12", "0X8009D12", 0, 0, "", "", "", ((RIJTransMergeKanDianReport.ReportR5Builder)localObject).build(), false);
  }
  
  private void b(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return;
    }
    b(paramJSONObject.optString("background_url"));
    a(paramJSONObject);
    this.i.requestLayout();
  }
  
  private void c()
  {
    JSONObject localJSONObject = ReadInJoyLogicEngine.a().ad();
    int i1 = this.m;
    if ((i1 != -1) && (i1 != 0))
    {
      localObject = this.h;
      if (localObject != null)
      {
        if (a((Container)((ViewGroup)localObject).getChildAt(1), localJSONObject))
        {
          QLog.i("DailyHeaderViewController", 1, "[onDailyDynamicHeaderDataUpdated] template match, bind data");
          b(localJSONObject);
          return;
        }
        QLog.i("DailyHeaderViewController", 1, "[onDailyDynamicHeaderDataUpdated] template mismatch, re-inflate");
        e();
        localObject = b(this.a, localJSONObject);
        if (localObject != null)
        {
          QLog.i("DailyHeaderViewController", 1, "[handleStateDynamic] successfully inflate dynamic header, update.");
          a(this.h, (Container)localObject);
          b(localJSONObject);
          return;
        }
        QLog.e("DailyHeaderViewController", 1, "[onDailyDynamicHeaderDataUpdated] fail to inflate dynamic header");
        a(0);
        return;
      }
    }
    Container localContainer = b(this.a, localJSONObject);
    if (localContainer != null) {
      localObject = localJSONObject.optString("background_url");
    }
    try
    {
      localObject = URLDrawable.getDrawable((String)localObject, a(this.g.getContext()));
    }
    catch (Exception localException)
    {
      label165:
      break label165;
    }
    Object localObject = this.g.getContext().getResources().getDrawable(2131167836);
    a(this.g, localContainer, (Drawable)localObject, localJSONObject);
    return;
    a(0);
  }
  
  private static void c(String paramString, JSONObject paramJSONObject)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[reportHeaderClick] ");
    ((StringBuilder)localObject).append(paramString);
    QLog.i("DailyHeaderViewController", 1, ((StringBuilder)localObject).toString());
    localObject = new RIJTransMergeKanDianReport.ReportR5Builder();
    ((RIJTransMergeKanDianReport.ReportR5Builder)localObject).addStringNotThrow("model_type", a(paramString));
    ((RIJTransMergeKanDianReport.ReportR5Builder)localObject).addStringNotThrow("topic_id", paramJSONObject.optString("topic_id", ""));
    PublicAccountReportUtils.a(null, "CliOper", "", "", "0X8009D13", "0X8009D13", 0, 0, "", "", "", ((RIJTransMergeKanDianReport.ReportR5Builder)localObject).build(), false);
  }
  
  private void d()
  {
    QLog.i("DailyHeaderViewController", 1, "[handleLoading] ");
    Object localObject1 = new JSONObject();
    try
    {
      ((JSONObject)localObject1).putOpt("style_ID", "ReadInJoyDailyDynamicWeatherHeaderError");
      int i1 = this.m;
      if (i1 != 2)
      {
        if (i1 != 3)
        {
          if ((i1 != 4) && (i1 != 5))
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("illegal state ");
            ((StringBuilder)localObject2).append(this.m);
            throw new IllegalStateException(((StringBuilder)localObject2).toString());
          }
          ((JSONObject)localObject1).putOpt("error_reason", HardCodeUtil.a(2131900855));
        }
        else
        {
          ((JSONObject)localObject1).putOpt("error_reason", HardCodeUtil.a(2131900856));
        }
      }
      else {
        ((JSONObject)localObject1).putOpt("error_reason", HardCodeUtil.a(2131900852));
      }
      ((JSONObject)localObject1).putOpt("operation_text", HardCodeUtil.a(2131900853));
    }
    catch (Exception localException)
    {
      Object localObject2;
      label157:
      break label157;
    }
    a(0);
    localObject1 = a((JSONObject)localObject1, null);
    if (localObject1 != null)
    {
      localObject1 = ((Container)localObject1).getVirtualView().findViewBaseByName("id_refresh_icon").getNativeView();
      localObject2 = AnimationUtils.loadAnimation(((View)localObject1).getContext(), 2130772306);
      ((Animation)localObject2).setFillAfter(true);
      ((View)localObject1).startAnimation((Animation)localObject2);
    }
    this.g.postDelayed(new DailyDynamicHeaderViewController.11(this), 1000L);
  }
  
  private void e()
  {
    if (this.h != null) {
      while (this.h.getChildAt(1) != null) {
        this.h.removeViewAt(1);
      }
    }
  }
  
  public void a()
  {
    ((ILbsManagerServiceApi)QRoute.api(ILbsManagerServiceApi.class)).removeListener(this.f);
    ReadInJoyLogicEngineEventDispatcher.a().b(this.n);
  }
  
  public void a(View.OnClickListener paramOnClickListener)
  {
    this.k = paramOnClickListener;
  }
  
  public void a(View paramView)
  {
    this.g = paramView;
    boolean bool = DailyModeConfigHandler.k();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[onCreateView] enable_dynamic_header=");
    localStringBuilder.append(bool);
    QLog.i("DailyHeaderViewController", 1, localStringBuilder.toString());
    if (bool)
    {
      b(paramView);
      ReadInJoyLogicEngineEventDispatcher.a().a(this.n);
      a(false);
      return;
    }
    a(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.daily.DailyDynamicHeaderViewController
 * JD-Core Version:    0.7.0.1
 */