package com.tencent.mobileqq.kandian.glue.viola.delegate;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.activity.fling.TopGestureLayout.OnGestureListener;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.kandian.base.bandwidth.BandwidthPredictor;
import com.tencent.mobileqq.kandian.biz.common.RIJXTabFrameUtils;
import com.tencent.mobileqq.kandian.biz.feeds.entity.SerializableMap;
import com.tencent.mobileqq.kandian.biz.viola.ReadInJoyViolaChannelFragment;
import com.tencent.mobileqq.kandian.biz.viola.api.IViolaUiDelegate;
import com.tencent.mobileqq.kandian.biz.viola.api.OnTitleChangeListener;
import com.tencent.mobileqq.kandian.biz.viola.view.ViolaFragment;
import com.tencent.mobileqq.kandian.glue.viola.ViolaBizLibHandler;
import com.tencent.mobileqq.kandian.glue.viola.ViolaLibHandler;
import com.tencent.mobileqq.kandian.glue.viola.modules.BridgeModule;
import com.tencent.mobileqq.kandian.glue.viola.modules.BridgeModuleHelper;
import com.tencent.mobileqq.kandian.glue.viola.utils.ViolaBizUtils;
import com.tencent.mobileqq.kandian.glue.viola.view.ViolaBaseView;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.WebViewProgressBar;
import com.tencent.mobileqq.widget.WebViewProgressBarController;
import com.tencent.viola.core.ViolaSDKManager;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class ViolaUiDelegate
  implements IViolaUiDelegate
{
  private int jdField_a_of_type_Int = 0;
  private View jdField_a_of_type_AndroidViewView;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private Fragment jdField_a_of_type_AndroidxFragmentAppFragment;
  private TopGestureLayout jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout;
  private SerializableMap jdField_a_of_type_ComTencentMobileqqKandianBizFeedsEntitySerializableMap;
  private OnTitleChangeListener jdField_a_of_type_ComTencentMobileqqKandianBizViolaApiOnTitleChangeListener;
  private ViolaFragment jdField_a_of_type_ComTencentMobileqqKandianBizViolaViewViolaFragment;
  private WebViewProgressBar jdField_a_of_type_ComTencentMobileqqWidgetWebViewProgressBar;
  private WebViewProgressBarController jdField_a_of_type_ComTencentMobileqqWidgetWebViewProgressBarController;
  private HashMap jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private boolean jdField_a_of_type_Boolean = true;
  private int jdField_b_of_type_Int = -1;
  private boolean jdField_b_of_type_Boolean = false;
  private boolean c = false;
  private boolean d = false;
  private boolean e = true;
  private boolean f = false;
  private boolean g = false;
  private boolean h = true;
  private boolean i = false;
  private boolean j = false;
  private boolean k = false;
  private boolean l = false;
  private boolean m = true;
  
  public ViolaUiDelegate(Fragment paramFragment)
  {
    this.jdField_a_of_type_AndroidxFragmentAppFragment = paramFragment;
  }
  
  public ViolaUiDelegate(ViolaFragment paramViolaFragment)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizViolaViewViolaFragment = paramViolaFragment;
  }
  
  private Activity a()
  {
    ViolaFragment localViolaFragment = this.jdField_a_of_type_ComTencentMobileqqKandianBizViolaViewViolaFragment;
    if (localViolaFragment != null) {
      return localViolaFragment.getActivity();
    }
    return this.jdField_a_of_type_AndroidxFragmentAppFragment.getActivity();
  }
  
  private TopGestureLayout a(ViewGroup paramViewGroup)
  {
    if (paramViewGroup == null) {
      return null;
    }
    int n = 0;
    while (n < paramViewGroup.getChildCount())
    {
      View localView = paramViewGroup.getChildAt(n);
      if ((localView instanceof TopGestureLayout)) {
        return (TopGestureLayout)localView;
      }
      if ((localView instanceof ViewGroup)) {
        return a((ViewGroup)localView);
      }
      n += 1;
    }
    return null;
  }
  
  private static HashMap<String, Object> a(String paramString)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:659)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public static void a(Context paramContext)
  {
    if (!ViolaBaseView.jdField_a_of_type_Boolean) {
      return;
    }
    Object localObject1 = new JSONObject();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("网络类型：");
    ((StringBuilder)localObject2).append(HttpUtil.getNetWorkTypeByStr());
    ((StringBuilder)localObject2).append("，网速：");
    ((StringBuilder)localObject2).append(BandwidthPredictor.from().getCurrentPrediction());
    ((StringBuilder)localObject2).append("kb/s\n已超时协议：\n");
    ((StringBuilder)localObject2).append(BridgeModule.ssoTimeOutRecordStr);
    localObject2 = ((StringBuilder)localObject2).toString();
    try
    {
      ((JSONObject)localObject1).put("title", "网络状态");
      ((JSONObject)localObject1).put("text", localObject2);
      ((JSONObject)localObject1).put("needOkBtn", true);
      ((JSONObject)localObject1).put("needCancelBtn", true);
      ((JSONObject)localObject1).put("okBtnText", "复制文本");
      ((JSONObject)localObject1).put("cancelBtnText", "关闭");
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    localObject1 = BridgeModuleHelper.a(null, (JSONObject)localObject1, null);
    if (localObject1 != null) {
      ((QQCustomDialog)localObject1).setPositiveButton("复制文本", new ViolaUiDelegate.3(paramContext, (String)localObject2));
    }
  }
  
  private void a(HashMap<String, Object> paramHashMap)
  {
    String str = (String)paramHashMap.get("title_status_bar_color");
    if (str.startsWith("0x"))
    {
      paramHashMap = str.replace("0x", "#");
    }
    else
    {
      paramHashMap = str;
      if (str.startsWith("0X")) {
        paramHashMap = str.replace("0X", "#");
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianBizViolaViewViolaFragment.setStatusBarColor(paramHashMap);
  }
  
  private void b(HashMap<String, Object> paramHashMap, ViewGroup paramViewGroup)
  {
    if (paramHashMap.containsKey("title_suspension")) {
      this.e = ((Boolean)paramHashMap.get("title_suspension")).booleanValue();
    }
    if (paramHashMap.containsKey("title_trans_anim")) {
      this.f = ((Boolean)paramHashMap.get("title_trans_anim")).booleanValue();
    }
    if (paramHashMap.containsKey("error_view_white")) {
      this.g = ((Boolean)paramHashMap.get("error_view_white")).booleanValue();
    }
    if (paramHashMap.containsKey("title_border_radius")) {
      c(paramHashMap, paramViewGroup);
    }
    if (paramHashMap.containsKey("title_default_title_height"))
    {
      int n = Integer.valueOf((String)paramHashMap.get("title_default_title_height")).intValue();
      this.jdField_a_of_type_JavaUtilHashMap.put("title_default_title_height", Integer.valueOf(n));
    }
    if (paramHashMap.containsKey("title_margin_top")) {
      d(paramHashMap, paramViewGroup);
    }
    if (paramHashMap.containsKey("title_default_gray_bar")) {
      this.jdField_a_of_type_JavaUtilHashMap.put("title_default_gray_bar", paramHashMap.get("title_default_gray_bar"));
    }
    if (paramHashMap.containsKey("title_default_pop_anim")) {
      this.jdField_a_of_type_JavaUtilHashMap.put("title_default_pop_anim", paramHashMap.get("title_default_pop_anim"));
    }
    if (paramHashMap.containsKey("title_default_back_bar")) {
      this.jdField_a_of_type_JavaUtilHashMap.put("title_default_back_bar", paramHashMap.get("title_default_back_bar"));
    }
    if (paramHashMap.containsKey("title_status_immersive")) {
      this.jdField_a_of_type_JavaUtilHashMap.put("title_status_immersive", paramHashMap.get("title_status_immersive"));
    }
    if (paramHashMap.containsKey("title_default_auto_top")) {
      this.jdField_a_of_type_JavaUtilHashMap.put("title_default_auto_top", paramHashMap.get("title_default_auto_top"));
    }
    if (paramHashMap.containsKey("title_default_interrupt_back")) {
      this.jdField_a_of_type_JavaUtilHashMap.put("title_default_interrupt_back", paramHashMap.get("title_default_interrupt_back"));
    }
    if (paramHashMap.containsKey("title_content_color"))
    {
      this.jdField_a_of_type_JavaUtilHashMap.put("title_content_color", paramHashMap.get("title_content_color"));
      this.jdField_b_of_type_Int = Color.parseColor((String)paramHashMap.get("title_content_color"));
    }
    if (paramHashMap.containsKey("title_default_title_alpha")) {
      this.jdField_a_of_type_JavaUtilHashMap.put("title_default_title_alpha", paramHashMap.get("title_default_title_alpha"));
    }
    if (paramHashMap.containsKey("title_default_gray_float")) {
      this.jdField_a_of_type_JavaUtilHashMap.put("title_default_gray_float", paramHashMap.get("title_default_gray_float"));
    }
    if (paramHashMap.containsKey("bundle_is_splash_activity")) {
      this.i = ((Boolean)paramHashMap.get("bundle_is_splash_activity")).booleanValue();
    }
    if (paramHashMap.containsKey("bundle_is_suspension_anyplace")) {
      this.j = ((Boolean)paramHashMap.get("bundle_is_suspension_anyplace")).booleanValue();
    }
    if (paramHashMap.containsKey("bundle_is_bid_anyplace")) {
      this.k = ((Boolean)paramHashMap.get("bundle_is_bid_anyplace")).booleanValue();
    }
    if (a()) {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizViolaViewViolaFragment.setStatusBarFontColor(Boolean.valueOf(true));
    }
    if (paramHashMap.containsKey("title_content_color")) {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizViolaViewViolaFragment.setContentViewColor((String)paramHashMap.get("title_content_color"));
    }
    if (paramHashMap.containsKey("title_status_visiable")) {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizViolaViewViolaFragment.hideStatusBarByParams();
    }
    if ((paramHashMap.containsKey("content_full_screen")) && (!paramHashMap.containsKey("title_default_is_channel"))) {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizViolaViewViolaFragment.setContentFullScreen();
    }
  }
  
  private void c(HashMap<String, Object> paramHashMap, ViewGroup paramViewGroup)
  {
    int n = Integer.valueOf((String)paramHashMap.get("title_border_radius")).intValue();
    this.jdField_a_of_type_JavaUtilHashMap.put("title_border_radius", Integer.valueOf(n));
  }
  
  private void d(ViewGroup paramViewGroup)
  {
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramViewGroup.findViewById(2131373730));
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
  }
  
  private void d(HashMap<String, Object> paramHashMap, ViewGroup paramViewGroup)
  {
    if (paramViewGroup != null)
    {
      int n = Integer.valueOf((String)paramHashMap.get("title_margin_top")).intValue();
      this.jdField_a_of_type_Int = AIOUtils.b(n, paramViewGroup.getResources());
      this.jdField_a_of_type_JavaUtilHashMap.put("title_margin_top", Integer.valueOf(n));
    }
  }
  
  private void e()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizViolaApiOnTitleChangeListener == null) {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizViolaApiOnTitleChangeListener = new ViolaUiDelegate.1(this);
    }
  }
  
  private void f()
  {
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    LinearLayout localLinearLayout = this.jdField_a_of_type_AndroidWidgetLinearLayout;
    if ((localLinearLayout != null) && (localLinearLayout.getVisibility() != 0)) {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    }
  }
  
  private boolean f()
  {
    if ((this.jdField_a_of_type_AndroidxFragmentAppFragment instanceof ReadInJoyViolaChannelFragment)) {
      return true;
    }
    return (RIJXTabFrameUtils.INSTANCE.isNowInKanDianTab()) && (this.i);
  }
  
  private void g()
  {
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    LinearLayout localLinearLayout = this.jdField_a_of_type_AndroidWidgetLinearLayout;
    if ((localLinearLayout != null) && (localLinearLayout.getVisibility() != 8)) {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public TopGestureLayout a()
  {
    if (a() == null) {
      return null;
    }
    ViewGroup localViewGroup = (ViewGroup)a().getWindow().getDecorView();
    Object localObject = null;
    int n = 0;
    while (n < localViewGroup.getChildCount())
    {
      View localView = localViewGroup.getChildAt(n);
      localObject = localView;
      if ((localView instanceof DragFrameLayout)) {
        localObject = ((DragFrameLayout)localView).getChildAt(0);
      }
      if ((localObject instanceof TopGestureLayout)) {
        break;
      }
      n += 1;
    }
    if ((localObject != null) && ((localObject instanceof TopGestureLayout))) {
      return (TopGestureLayout)localObject;
    }
    return a(localViewGroup);
  }
  
  public OnTitleChangeListener a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianBizViolaApiOnTitleChangeListener;
  }
  
  public HashMap a()
  {
    return this.jdField_a_of_type_JavaUtilHashMap;
  }
  
  public void a()
  {
    View localView = this.jdField_a_of_type_AndroidViewView;
    if (localView != null) {
      localView.setVisibility(8);
    }
  }
  
  public void a(int paramInt)
  {
    if (paramInt == 0)
    {
      b(this.m);
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout == null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout = a();
    }
    TopGestureLayout localTopGestureLayout = this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout;
    if (localTopGestureLayout != null) {
      localTopGestureLayout.setInterceptTouchFlag(false);
    }
  }
  
  public void a(Bundle paramBundle)
  {
    if (paramBundle != null)
    {
      boolean bool2 = false;
      boolean bool1;
      if (paramBundle.getInt("title_hide", 0) == 1) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      this.jdField_b_of_type_Boolean = bool1;
      if (this.jdField_b_of_type_Boolean) {
        this.jdField_a_of_type_ComTencentMobileqqKandianBizViolaViewViolaFragment.hideTitleBar();
      }
      if ((!this.jdField_b_of_type_Boolean) && (paramBundle.getBoolean("is_channel", false)))
      {
        this.jdField_b_of_type_Boolean = true;
        this.jdField_a_of_type_ComTencentMobileqqKandianBizViolaViewViolaFragment.hideTitleBar();
      }
      this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsEntitySerializableMap = ((SerializableMap)paramBundle.getSerializable(ViolaFragment.BUNDLE_PAGE_CONFIG_DATA));
      paramBundle = this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsEntitySerializableMap;
      if (paramBundle != null)
      {
        if (paramBundle.getMap().containsKey("title_hide"))
        {
          bool1 = bool2;
          if (((Integer)this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsEntitySerializableMap.getMap().get("title_hide")).intValue() == 1) {
            bool1 = true;
          }
          this.jdField_b_of_type_Boolean = bool1;
          if (this.jdField_b_of_type_Boolean) {
            this.jdField_a_of_type_ComTencentMobileqqKandianBizViolaViewViolaFragment.hideTitleBar();
          }
        }
        if (this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsEntitySerializableMap.getMap().containsKey("title_status_color"))
        {
          this.c = ((Boolean)this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsEntitySerializableMap.getMap().get("title_status_color")).booleanValue();
          if (this.c) {
            this.jdField_a_of_type_ComTencentMobileqqKandianBizViolaViewViolaFragment.setStatusBarColor("#ffffff");
          }
        }
        if (!this.jdField_b_of_type_Boolean)
        {
          if (this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsEntitySerializableMap.getMap().containsKey("title_nav_background_color"))
          {
            paramBundle = (String)this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsEntitySerializableMap.getMap().get("title_nav_background_color");
            this.jdField_a_of_type_ComTencentMobileqqKandianBizViolaViewViolaFragment.setTitleContainerBackgroundColor(paramBundle);
          }
          if (this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsEntitySerializableMap.getMap().containsKey("title_nav_text_color"))
          {
            paramBundle = (String)this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsEntitySerializableMap.getMap().get("title_nav_text_color");
            this.jdField_a_of_type_ComTencentMobileqqKandianBizViolaViewViolaFragment.setLeftTextColor(paramBundle);
            this.jdField_a_of_type_ComTencentMobileqqKandianBizViolaViewViolaFragment.setRightTextColor(paramBundle);
          }
          if (this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsEntitySerializableMap.getMap().containsKey("title_nav_center_text_color"))
          {
            paramBundle = (String)this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsEntitySerializableMap.getMap().get("title_nav_center_text_color");
            this.jdField_a_of_type_ComTencentMobileqqKandianBizViolaViewViolaFragment.setCenterTextColor(paramBundle);
          }
          if ((this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsEntitySerializableMap.getMap().containsKey("title_nav_alpha")) && (this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsEntitySerializableMap.getMap().get("title_nav_alpha") != null))
          {
            paramBundle = (Float)this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsEntitySerializableMap.getMap().get("title_nav_alpha");
            this.jdField_a_of_type_ComTencentMobileqqKandianBizViolaViewViolaFragment.setTitleAlpha(paramBundle.floatValue());
          }
        }
      }
    }
  }
  
  public void a(ViewGroup paramViewGroup)
  {
    a(a(this.jdField_a_of_type_ComTencentMobileqqKandianBizViolaViewViolaFragment.getUrl()), paramViewGroup);
  }
  
  public void a(ViewGroup paramViewGroup, View.OnClickListener paramOnClickListener)
  {
    a(paramViewGroup, paramOnClickListener, null);
  }
  
  public void a(ViewGroup paramViewGroup, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener)
  {
    if ((!a()) && (!d()))
    {
      this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)paramViewGroup.findViewById(2131380916));
      if (this.jdField_a_of_type_AndroidWidgetFrameLayout.getVisibility() != 0) {
        this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(0);
      }
    }
    if (this.jdField_a_of_type_AndroidViewView == null)
    {
      this.jdField_a_of_type_AndroidViewView = ((ViewStub)paramViewGroup.findViewById(2131380917)).inflate();
      int n = this.jdField_b_of_type_Int;
      if (n != -1) {
        this.jdField_a_of_type_AndroidViewView.setBackgroundColor(n);
      }
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131376052));
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131376051));
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramViewGroup.getResources().getString(2131718010));
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(paramOnClickListener);
    if (paramOnLongClickListener != null) {
      this.jdField_a_of_type_AndroidViewView.setOnLongClickListener(paramOnLongClickListener);
    }
    if ((this.jdField_b_of_type_Int != -1) && (!e())) {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramViewGroup.getResources().getDrawable(2130839481));
    } else {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramViewGroup.getResources().getDrawable(2130839274));
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(paramViewGroup.getResources().getColor(2131166925));
    ((LinearLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams()).topMargin = AIOUtils.b(10.0F, paramViewGroup.getResources());
  }
  
  public void a(TopGestureLayout.OnGestureListener paramOnGestureListener)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout == null) {
      b(true);
    }
    TopGestureLayout localTopGestureLayout = this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout;
    if (localTopGestureLayout != null) {
      localTopGestureLayout.setOnFlingGesture(paramOnGestureListener);
    }
  }
  
  public void a(HashMap<String, Object> paramHashMap, ViewGroup paramViewGroup)
  {
    if (paramHashMap != null)
    {
      if (paramHashMap.containsKey("title_status_immersive"))
      {
        this.d = ((Boolean)paramHashMap.get("title_status_immersive")).booleanValue();
        if (this.d)
        {
          this.jdField_a_of_type_ComTencentMobileqqKandianBizViolaViewViolaFragment.setStatusBarImmersive();
          if ((paramHashMap.containsKey("title_hide_nav_bar")) && (((Boolean)paramHashMap.get("title_hide_nav_bar")).booleanValue())) {
            ViolaFragment.hideNavBar(this.jdField_a_of_type_ComTencentMobileqqKandianBizViolaViewViolaFragment.getActivity());
          }
        }
      }
      if (!this.d)
      {
        if (paramHashMap.containsKey("title_status_color"))
        {
          this.c = ((Boolean)paramHashMap.get("title_status_color")).booleanValue();
          if (this.c) {
            this.jdField_a_of_type_ComTencentMobileqqKandianBizViolaViewViolaFragment.setStatusBarColor("#ffffff");
          }
        }
        if (paramHashMap.containsKey("title_status_bar_color")) {
          a(paramHashMap);
        }
      }
      if ((paramHashMap.containsKey("title_full_screen")) && (((Boolean)paramHashMap.get("title_full_screen")).booleanValue())) {
        this.jdField_a_of_type_ComTencentMobileqqKandianBizViolaViewViolaFragment.setFullScreen();
      }
      Object localObject;
      if (paramHashMap.containsKey("title_status_font_color"))
      {
        localObject = (Boolean)paramHashMap.get("title_status_font_color");
        this.jdField_a_of_type_ComTencentMobileqqKandianBizViolaViewViolaFragment.setStatusBarFontColor((Boolean)localObject);
      }
      if (paramHashMap.containsKey("title_hide"))
      {
        int n = ((Integer)paramHashMap.get("title_hide")).intValue();
        boolean bool = true;
        if (n != 1) {
          bool = false;
        }
        this.jdField_b_of_type_Boolean = bool;
      }
      if (this.jdField_b_of_type_Boolean)
      {
        this.jdField_a_of_type_ComTencentMobileqqKandianBizViolaViewViolaFragment.hideTitleBar();
      }
      else
      {
        if (paramHashMap.containsKey("title_nav_background_color"))
        {
          localObject = (String)paramHashMap.get("title_nav_background_color");
          this.jdField_a_of_type_ComTencentMobileqqKandianBizViolaViewViolaFragment.setTitleContainerBackgroundColor((String)localObject);
        }
        if (paramHashMap.containsKey("title_nav_text_color"))
        {
          localObject = (String)paramHashMap.get("title_nav_text_color");
          this.jdField_a_of_type_ComTencentMobileqqKandianBizViolaViewViolaFragment.setLeftTextColor((String)localObject);
          this.jdField_a_of_type_ComTencentMobileqqKandianBizViolaViewViolaFragment.setRightTextColor((String)localObject);
        }
        if (paramHashMap.containsKey("title_nav_center_text_color"))
        {
          localObject = (String)paramHashMap.get("title_nav_center_text_color");
          this.jdField_a_of_type_ComTencentMobileqqKandianBizViolaViewViolaFragment.setCenterTextColor((String)localObject);
        }
        if ((paramHashMap.containsKey("title_nav_alpha")) && (paramHashMap.get("title_nav_alpha") != null))
        {
          localObject = (String)paramHashMap.get("title_nav_alpha");
          this.jdField_a_of_type_ComTencentMobileqqKandianBizViolaViewViolaFragment.setTitleAlpha(Float.valueOf((String)localObject).floatValue());
        }
        this.jdField_a_of_type_ComTencentMobileqqKandianBizViolaViewViolaFragment.setLeftButtonText(HardCodeUtil.a(2131716201), null);
        this.jdField_a_of_type_ComTencentMobileqqKandianBizViolaViewViolaFragment.setReadInjoyTitleStyle();
      }
      e();
      b(paramHashMap, paramViewGroup);
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianBizViolaViewViolaFragment.useNightMode();
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public boolean a()
  {
    return (this.e) && ((f()) || (this.j)) && (!this.k);
  }
  
  public void b()
  {
    if ((a()) && (this.h))
    {
      ViolaSDKManager.getInstance().postOnUiThreadDelay(new ViolaUiDelegate.2(this), 350L);
      return;
    }
    View localView = this.jdField_a_of_type_AndroidViewView;
    if (localView != null) {
      localView.setVisibility(0);
    }
    if (e()) {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizViolaViewViolaFragment.setContentViewColor("white");
    }
  }
  
  public void b(ViewGroup paramViewGroup)
  {
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    if ((!a()) && (!d()))
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetWebViewProgressBar = new WebViewProgressBar(paramViewGroup.getContext());
      this.jdField_a_of_type_ComTencentMobileqqWidgetWebViewProgressBar.setId(2131373133);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, AIOUtils.b(3.0F, paramViewGroup.getContext().getResources()));
      localLayoutParams.addRule(10, -1);
      this.jdField_a_of_type_ComTencentMobileqqWidgetWebViewProgressBar.setLayoutParams(localLayoutParams);
      paramViewGroup.addView(this.jdField_a_of_type_ComTencentMobileqqWidgetWebViewProgressBar);
      this.jdField_a_of_type_ComTencentMobileqqWidgetWebViewProgressBarController = new WebViewProgressBarController();
      this.jdField_a_of_type_ComTencentMobileqqWidgetWebViewProgressBarController.a(this.jdField_a_of_type_ComTencentMobileqqWidgetWebViewProgressBar);
      this.jdField_a_of_type_ComTencentMobileqqWidgetWebViewProgressBar.setController(this.jdField_a_of_type_ComTencentMobileqqWidgetWebViewProgressBarController);
      if ((!ViolaBizUtils.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizViolaViewViolaFragment.getUrl())) || (!ViolaBizLibHandler.i()) || (!ViolaLibHandler.i())) {
        c();
      }
    }
    else
    {
      d(paramViewGroup);
    }
  }
  
  public void b(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout == null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout = a();
    }
    TopGestureLayout localTopGestureLayout = this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout;
    if (localTopGestureLayout != null)
    {
      this.m = paramBoolean;
      localTopGestureLayout.setInterceptTouchFlag(paramBoolean);
    }
  }
  
  public boolean b()
  {
    View localView = this.jdField_a_of_type_AndroidViewView;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (localView != null)
    {
      bool1 = bool2;
      if (localView.getVisibility() == 0) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public void c()
  {
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    if ((!a()) && (!d()))
    {
      WebViewProgressBarController localWebViewProgressBarController = this.jdField_a_of_type_ComTencentMobileqqWidgetWebViewProgressBarController;
      if ((localWebViewProgressBarController != null) && (localWebViewProgressBarController.b() != 0)) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetWebViewProgressBarController.a((byte)0);
      }
    }
    else
    {
      f();
    }
  }
  
  public void c(ViewGroup paramViewGroup)
  {
    if (a())
    {
      this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)paramViewGroup.findViewById(2131380916));
      if (this.jdField_a_of_type_AndroidWidgetFrameLayout.getVisibility() != 0) {
        this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(0);
      }
      b(true);
    }
  }
  
  public void c(boolean paramBoolean)
  {
    this.l = paramBoolean;
  }
  
  public boolean c()
  {
    return (this.l) && (!this.k);
  }
  
  public void d()
  {
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    if ((!a()) && (!d()))
    {
      WebViewProgressBarController localWebViewProgressBarController = this.jdField_a_of_type_ComTencentMobileqqWidgetWebViewProgressBarController;
      if ((localWebViewProgressBarController != null) && (localWebViewProgressBarController.b() != 2)) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetWebViewProgressBarController.a((byte)2);
      }
    }
    else
    {
      g();
    }
  }
  
  public boolean d()
  {
    return this.f;
  }
  
  public boolean e()
  {
    return this.g;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.viola.delegate.ViolaUiDelegate
 * JD-Core Version:    0.7.0.1
 */