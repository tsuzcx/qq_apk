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
import com.tencent.biz.pubaccount.readinjoy.DailyDynamicHeaderViewController.11;
import com.tencent.biz.pubaccount.readinjoy.DailyDynamicHeaderViewController.9;
import com.tencent.biz.pubaccount.readinjoy.view.DailyTitleBar;
import com.tencent.biz.pubaccount.readinjoy.view.DailyTitleBarSwitcher;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyDailyPullToZoomHeaderXListView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.Layout.Params;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.ViewFactory;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.json.JSONObject;

public class ofk
{
  private int jdField_a_of_type_Int = -1;
  private final View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new ofl(this);
  private View jdField_a_of_type_AndroidViewView;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private final aoou jdField_a_of_type_Aoou = new ofr(this, "readinjoy_weather");
  private DailyTitleBarSwitcher jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewDailyTitleBarSwitcher;
  private final VafContext jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext;
  private final pmn jdField_a_of_type_Pmn = new ofs(this);
  private int jdField_b_of_type_Int = -1;
  private final View.OnClickListener jdField_b_of_type_AndroidViewView$OnClickListener = new ofn(this);
  private final View.OnClickListener c = new ofo(this);
  private final View.OnClickListener d = new ofp(this);
  private View.OnClickListener e;
  
  public ofk(@NonNull VafContext paramVafContext)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext = paramVafContext;
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
        QLog.i("DailyHeaderViewController", 1, "[inflateProteusView] " + (String)localObject);
        localObject = teh.a("daily_dynamic_header", true);
        if (localObject != null)
        {
          paramJSONObject = ((teh)localObject).getTemplateBean(paramJSONObject);
          if (paramJSONObject != null)
          {
            paramVafContext = paramVafContext.getViewFactory().inflate(paramVafContext, paramJSONObject);
            pfr.a(paramVafContext, null, paramJSONObject);
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
    if ((this.jdField_b_of_type_Int == -1) || (this.jdField_b_of_type_Int == 0))
    {
      Container localContainer = a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext, paramJSONObject);
      if (localContainer != null)
      {
        Drawable localDrawable = this.jdField_a_of_type_AndroidViewView.getContext().getResources().getDrawable(2130843138);
        a(this.jdField_a_of_type_AndroidViewView, localContainer, localDrawable, paramJSONObject);
        this.jdField_a_of_type_AndroidViewViewGroup.setOnClickListener(paramOnClickListener);
        return localContainer;
      }
      a(0);
    }
    for (;;)
    {
      return null;
      e();
      paramJSONObject = a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext, paramJSONObject);
      if (paramJSONObject != null)
      {
        this.jdField_a_of_type_AndroidViewViewGroup.setOnClickListener(paramOnClickListener);
        a(this.jdField_a_of_type_AndroidViewViewGroup, paramJSONObject);
        this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130843138);
        return paramJSONObject;
      }
      a(0);
    }
  }
  
  private static URLDrawable.URLDrawableOptions a(Context paramContext)
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    paramContext = paramContext.getResources().getDrawable(2130843138);
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
    QLog.i("DailyHeaderViewController", 1, "[moveToState] from: " + this.jdField_a_of_type_Int + " to " + paramInt);
    this.jdField_b_of_type_Int = this.jdField_a_of_type_Int;
    this.jdField_a_of_type_Int = paramInt;
    bmqa.a("sp_key_daily_dynamic_header_state", Integer.valueOf(this.jdField_a_of_type_Int));
    if (this.jdField_a_of_type_AndroidViewViewGroup != null) {
      this.jdField_a_of_type_AndroidViewViewGroup.setOnClickListener(null);
    }
    switch (paramInt)
    {
    default: 
      throw new IllegalStateException("invalid state " + paramInt);
    case 0: 
      b();
      return;
    case 1: 
      c();
      return;
    case 2: 
    case 3: 
    case 4: 
      b(paramInt);
      return;
    }
    d();
  }
  
  private void a(@NonNull View paramView, @NonNull Container paramContainer, @NonNull Drawable paramDrawable, JSONObject paramJSONObject)
  {
    QLog.i("DailyHeaderViewController", 1, "[setupDynamicHeader] ");
    ((DailyTitleBar)paramView.findViewById(2131371802)).setVisibility(8);
    DailyTitleBarSwitcher localDailyTitleBarSwitcher = (DailyTitleBarSwitcher)paramView.findViewById(2131365213);
    localDailyTitleBarSwitcher.setVisibility(0);
    localDailyTitleBarSwitcher.setOnLeftButtonClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    localDailyTitleBarSwitcher.setOnRightButtonClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
    localDailyTitleBarSwitcher.setOnTitleClickListener(this.e);
    ReadInJoyDailyPullToZoomHeaderXListView localReadInJoyDailyPullToZoomHeaderXListView = (ReadInJoyDailyPullToZoomHeaderXListView)paramView.findViewById(2131378089);
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)LayoutInflater.from(paramView.getContext()).inflate(2131560137, localReadInJoyDailyPullToZoomHeaderXListView, false));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131363223));
    ofi.a(paramDrawable);
    ofi.a(this.jdField_a_of_type_AndroidWidgetImageView);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramDrawable);
    a(this.jdField_a_of_type_AndroidViewViewGroup, paramContainer);
    localReadInJoyDailyPullToZoomHeaderXListView.a(localDailyTitleBarSwitcher.a());
    localReadInJoyDailyPullToZoomHeaderXListView.addHeaderView(this.jdField_a_of_type_AndroidViewViewGroup);
    localReadInJoyDailyPullToZoomHeaderXListView.setHeaderImage(this.jdField_a_of_type_AndroidWidgetImageView);
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
    ViewFactory.findClickableViewListener(paramContainer.getVirtualView(), new ofu(paramString, paramJSONObject));
  }
  
  private void a(@NonNull BaseActivity paramBaseActivity, @NonNull Runnable paramRunnable)
  {
    if (Build.VERSION.SDK_INT >= 23)
    {
      if (paramBaseActivity.checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") != 0)
      {
        paramBaseActivity.requestPermissions(new oft(this, paramRunnable), 1, new String[] { "android.permission.ACCESS_FINE_LOCATION" });
        return;
      }
      paramRunnable.run();
      return;
    }
    paramRunnable.run();
  }
  
  private void a(String paramString)
  {
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131363223));
    try
    {
      paramString = URLDrawable.getDrawable(paramString, a(this.jdField_a_of_type_AndroidWidgetImageView.getContext()));
      ofi.a(paramString);
      ofi.a(this.jdField_a_of_type_AndroidWidgetImageView);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramString);
      return;
    }
    catch (Exception paramString)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2131166859);
      QLog.e("DailyHeaderViewController", 1, "[onDailyDynamicHeaderDataUpdated] ", paramString);
    }
  }
  
  private void a(JSONObject paramJSONObject)
  {
    if (this.jdField_a_of_type_AndroidViewView == null) {}
    do
    {
      return;
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewDailyTitleBarSwitcher == null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewDailyTitleBarSwitcher = ((DailyTitleBarSwitcher)this.jdField_a_of_type_AndroidViewView.findViewById(2131365213));
      }
    } while ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewDailyTitleBarSwitcher == null) || (paramJSONObject == null));
    String str = paramJSONObject.optString("weather_summary_title");
    paramJSONObject = paramJSONObject.optString("weather_jump_url");
    if (!TextUtils.isEmpty(str))
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewDailyTitleBarSwitcher.setBackgroundViewTitle(str, 12.0F);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewDailyTitleBarSwitcher.setOnTitleClickWeatherListener(new ofm(this, paramJSONObject));
      return;
    }
    QLog.i("DailyHeaderViewController", 1, "bindDataForTitleBar, no data.");
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewDailyTitleBarSwitcher.setBackgroundViewTitle("", 12.0F);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewDailyTitleBarSwitcher.setOnTitleClickWeatherListener(null);
  }
  
  private void a(boolean paramBoolean)
  {
    QLog.i("DailyHeaderViewController", 1, "[requestForUpdate] ");
    long l1 = ((Long)bmqa.a("sp_key_daily_dynamic_header_last_refresh_time", Long.valueOf(0L))).longValue();
    long l2 = System.currentTimeMillis();
    long l3 = Aladdin.getConfig(157).getIntegerFromString("refresh_debounce_interval", 5);
    if ((l2 - l1 > 60000L * l3) || (paramBoolean)) {
      ThreadManagerV2.getUIHandlerV2().post(new DailyDynamicHeaderViewController.9(this));
    }
    do
    {
      return;
      QLog.i("DailyHeaderViewController", 1, "[requestForUpdate] too frequent, less than " + l3 + " minutes, skip.");
    } while (!QLog.isColorLevel());
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    QLog.d("DailyHeaderViewController", 2, "[requestForUpdate] last refresh: " + localSimpleDateFormat.format(new Date(l1)));
    QLog.d("DailyHeaderViewController", 2, "[requestForUpdate] current time: " + localSimpleDateFormat.format(new Date(l2)));
  }
  
  private static boolean a(Container paramContainer, JSONObject paramJSONObject)
  {
    Object localObject = paramContainer.getTag();
    if ((localObject instanceof TemplateBean))
    {
      localObject = (TemplateBean)localObject;
      try
      {
        teh localteh = teh.a("daily_dynamic_header", true);
        if (localteh != null) {}
        for (paramJSONObject = localteh.getTemplateBean(paramJSONObject); (paramJSONObject != null) && (TextUtils.equals(paramJSONObject.getStyleName(), ((TemplateBean)localObject).getStyleName())) && (((TemplateBean)localObject).getId() == paramJSONObject.getId()); paramJSONObject = null)
        {
          QLog.i("DailyHeaderViewController", 1, "[bindDataForProteusHeader] template match, bind data");
          pfr.a(paramContainer, (TemplateBean)localObject, paramJSONObject);
          return true;
        }
        return false;
      }
      catch (Exception paramContainer)
      {
        QLog.e("DailyHeaderViewController", 1, "[handleStateDynamic] ", paramContainer);
      }
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
    DailyTitleBar localDailyTitleBar = (DailyTitleBar)this.jdField_a_of_type_AndroidViewView.findViewById(2131371802);
    localDailyTitleBar.setVisibility(0);
    ImmersiveUtils.a(true, ((Activity)this.jdField_a_of_type_AndroidViewView.getContext()).getWindow());
    localDailyTitleBar.setOnLeftButtonClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    localDailyTitleBar.setOnRightButtonClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
    localDailyTitleBar.setOnTitleClickListener(this.e);
    this.jdField_a_of_type_AndroidViewView.findViewById(2131365213).setVisibility(8);
    if (this.jdField_a_of_type_AndroidViewViewGroup != null)
    {
      ((ReadInJoyDailyPullToZoomHeaderXListView)this.jdField_a_of_type_AndroidViewView.findViewById(2131378089)).removeHeaderView(this.jdField_a_of_type_AndroidViewViewGroup);
      this.jdField_a_of_type_AndroidViewViewGroup = null;
      this.jdField_a_of_type_AndroidWidgetImageView = null;
    }
  }
  
  private void b(int paramInt)
  {
    JSONObject localJSONObject = new JSONObject();
    for (;;)
    {
      try
      {
        localJSONObject.putOpt("style_ID", "ReadInJoyDailyDynamicWeatherHeaderError");
        switch (paramInt)
        {
        case 2: 
          throw new IllegalStateException("illegal state " + paramInt);
        }
      }
      catch (Exception localException)
      {
        a(0);
        return;
      }
      localJSONObject.putOpt("error_reason", anni.a(2131701502)).putOpt("operation_text", anni.a(2131701507));
      View.OnClickListener localOnClickListener = this.c;
      for (;;)
      {
        a(localJSONObject, localOnClickListener);
        return;
        localJSONObject.putOpt("error_reason", anni.a(2131701508)).putOpt("operation_text", anni.a(2131701505));
        localOnClickListener = this.d;
        continue;
        localJSONObject.putOpt("error_reason", anni.a(2131701509)).putOpt("operation_text", anni.a(2131701506));
        localOnClickListener = this.c;
      }
    }
  }
  
  private void b(View paramView)
  {
    if ((Build.VERSION.SDK_INT >= 23) && (((BaseActivity)paramView.getContext()).checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") != 0))
    {
      QLog.i("DailyHeaderViewController", 1, "[setupHeaders] location permission not granted");
      a(3);
      return;
    }
    a(((Integer)bmqa.a("sp_key_daily_dynamic_header_state", Integer.valueOf(0))).intValue());
  }
  
  private static void b(String paramString, JSONObject paramJSONObject)
  {
    QLog.i("DailyHeaderViewController", 1, "[reportHeaderExposure] " + paramString);
    phi localphi = new phi();
    localphi.b("model_type", a(paramString));
    localphi.b("topic_id", paramJSONObject.optString("topic_id", ""));
    oat.a(null, "CliOper", "", "", "0X8009D12", "0X8009D12", 0, 0, "", "", "", localphi.a(), false);
  }
  
  private void b(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return;
    }
    a(paramJSONObject.optString("background_url"));
    a(paramJSONObject);
    this.jdField_a_of_type_AndroidWidgetImageView.requestLayout();
  }
  
  private void c()
  {
    JSONObject localJSONObject = pmh.a().a();
    Object localObject;
    if ((this.jdField_b_of_type_Int != -1) && (this.jdField_b_of_type_Int != 0) && (this.jdField_a_of_type_AndroidViewViewGroup != null))
    {
      if (a((Container)this.jdField_a_of_type_AndroidViewViewGroup.getChildAt(1), localJSONObject))
      {
        QLog.i("DailyHeaderViewController", 1, "[onDailyDynamicHeaderDataUpdated] template match, bind data");
        b(localJSONObject);
        return;
      }
      QLog.i("DailyHeaderViewController", 1, "[onDailyDynamicHeaderDataUpdated] template mismatch, re-inflate");
      e();
      localObject = b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext, localJSONObject);
      if (localObject != null)
      {
        QLog.i("DailyHeaderViewController", 1, "[handleStateDynamic] successfully inflate dynamic header, update.");
        a(this.jdField_a_of_type_AndroidViewViewGroup, (Container)localObject);
        b(localJSONObject);
        return;
      }
      QLog.e("DailyHeaderViewController", 1, "[onDailyDynamicHeaderDataUpdated] fail to inflate dynamic header");
      a(0);
      return;
    }
    Container localContainer = b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext, localJSONObject);
    if (localContainer != null)
    {
      localObject = localJSONObject.optString("background_url");
      try
      {
        localObject = URLDrawable.getDrawable((String)localObject, a(this.jdField_a_of_type_AndroidViewView.getContext()));
        a(this.jdField_a_of_type_AndroidViewView, localContainer, (Drawable)localObject, localJSONObject);
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Drawable localDrawable = this.jdField_a_of_type_AndroidViewView.getContext().getResources().getDrawable(2131166859);
        }
      }
    }
    a(0);
  }
  
  private static void c(String paramString, JSONObject paramJSONObject)
  {
    QLog.i("DailyHeaderViewController", 1, "[reportHeaderClick] " + paramString);
    phi localphi = new phi();
    localphi.b("model_type", a(paramString));
    localphi.b("topic_id", paramJSONObject.optString("topic_id", ""));
    oat.a(null, "CliOper", "", "", "0X8009D13", "0X8009D13", 0, 0, "", "", "", localphi.a(), false);
  }
  
  private void d()
  {
    QLog.i("DailyHeaderViewController", 1, "[handleLoading] ");
    Object localObject = new JSONObject();
    for (;;)
    {
      try
      {
        ((JSONObject)localObject).putOpt("style_ID", "ReadInJoyDailyDynamicWeatherHeaderError");
        switch (this.jdField_b_of_type_Int)
        {
        case 2: 
          throw new IllegalStateException("illegal state " + this.jdField_b_of_type_Int);
        }
      }
      catch (Exception localException)
      {
        a(0);
        localObject = a((JSONObject)localObject, null);
        if (localObject != null)
        {
          localObject = ((Container)localObject).getVirtualView().findViewBaseByName("id_refresh_icon").getNativeView();
          Animation localAnimation = AnimationUtils.loadAnimation(((View)localObject).getContext(), 2130772188);
          localAnimation.setFillAfter(true);
          ((View)localObject).startAnimation(localAnimation);
        }
        this.jdField_a_of_type_AndroidViewView.postDelayed(new DailyDynamicHeaderViewController.11(this), 1000L);
        return;
      }
      ((JSONObject)localObject).putOpt("error_reason", anni.a(2131701500));
      for (;;)
      {
        ((JSONObject)localObject).putOpt("operation_text", anni.a(2131701501));
        break;
        ((JSONObject)localObject).putOpt("error_reason", anni.a(2131701504));
        continue;
        ((JSONObject)localObject).putOpt("error_reason", anni.a(2131701503));
      }
    }
  }
  
  private void e()
  {
    if (this.jdField_a_of_type_AndroidViewViewGroup != null) {
      while (this.jdField_a_of_type_AndroidViewViewGroup.getChildAt(1) != null) {
        this.jdField_a_of_type_AndroidViewViewGroup.removeViewAt(1);
      }
    }
  }
  
  public void a()
  {
    aoor.b(this.jdField_a_of_type_Aoou);
    pmk.a().b(this.jdField_a_of_type_Pmn);
  }
  
  public void a(View.OnClickListener paramOnClickListener)
  {
    this.e = paramOnClickListener;
  }
  
  public void a(View paramView)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
    boolean bool = pil.b();
    QLog.i("DailyHeaderViewController", 1, "[onCreateView] enable_dynamic_header=" + bool);
    if (bool)
    {
      b(paramView);
      pmk.a().a(this.jdField_a_of_type_Pmn);
      a(false);
      return;
    }
    a(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ofk
 * JD-Core Version:    0.7.0.1
 */