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
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.kandian.base.bandwidth.BandwidthPredictor;
import com.tencent.mobileqq.kandian.biz.feeds.entity.SerializableMap;
import com.tencent.mobileqq.kandian.biz.viola.ReadInJoyViolaChannelFragment;
import com.tencent.mobileqq.kandian.biz.viola.api.IViolaUiDelegate;
import com.tencent.mobileqq.kandian.biz.viola.api.OnTitleChangeListener;
import com.tencent.mobileqq.kandian.biz.viola.view.ViolaFragment;
import com.tencent.mobileqq.kandian.biz.xtab.api.impl.RIJXTabFrameUtils;
import com.tencent.mobileqq.kandian.glue.viola.modules.BridgeModule;
import com.tencent.mobileqq.kandian.glue.viola.modules.BridgeModuleHelper;
import com.tencent.mobileqq.kandian.glue.viola.so.ViolaSoLoaderManager;
import com.tencent.mobileqq.kandian.glue.viola.so.ViolaSoLoaderManager.Companion;
import com.tencent.mobileqq.kandian.glue.viola.utils.ViolaBizUtils;
import com.tencent.mobileqq.kandian.glue.viola.view.ViolaBaseView;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.WebViewProgressBar;
import com.tencent.mobileqq.widget.WebViewProgressBarController;
import com.tencent.viola.core.ViolaSDKManager;
import java.util.HashMap;
import java.util.Map;
import mqq.app.Foreground;
import org.json.JSONException;
import org.json.JSONObject;

public class ViolaUiDelegate
  implements IViolaUiDelegate
{
  private boolean A = false;
  private View.OnClickListener B;
  private View.OnLongClickListener C;
  private ViewStub D;
  private boolean E = true;
  private ViolaFragment a;
  private Fragment b;
  private SerializableMap c;
  private WebViewProgressBarController d;
  private WebViewProgressBar e;
  private LinearLayout f;
  private View g;
  private TextView h;
  private ImageView i;
  private FrameLayout j;
  private boolean k = true;
  private OnTitleChangeListener l;
  private boolean m = false;
  private boolean n = false;
  private boolean o = false;
  private TopGestureLayout p;
  private boolean q = true;
  private boolean r = false;
  private boolean s = false;
  private boolean t = true;
  private boolean u = false;
  private boolean v = false;
  private boolean w = false;
  private HashMap x = new HashMap();
  private int y = 0;
  private int z = -1;
  
  public ViolaUiDelegate(Fragment paramFragment)
  {
    this.b = paramFragment;
  }
  
  public ViolaUiDelegate(ViolaFragment paramViolaFragment)
  {
    this.a = paramViolaFragment;
  }
  
  private static HashMap<String, Object> a(String paramString)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:659)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public static void a(Context paramContext)
  {
    if (!ViolaBaseView.b) {
      return;
    }
    JSONObject localJSONObject = new JSONObject();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("网络类型：");
    localStringBuilder.append(HttpUtil.getNetWorkTypeByStr());
    localStringBuilder.append("，网速：");
    localStringBuilder.append(BandwidthPredictor.from().getCurrentPrediction());
    localStringBuilder.append("kb/s\n已超时协议：\n");
    localStringBuilder.append(BridgeModule.ssoTimeOutRecordStr);
    String str = localStringBuilder.toString();
    try
    {
      localJSONObject.put("title", "网络状态");
      localJSONObject.put("text", str);
      localJSONObject.put("needOkBtn", true);
      localJSONObject.put("needCancelBtn", true);
      localJSONObject.put("okBtnText", "复制文本");
      localJSONObject.put("cancelBtnText", "关闭");
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    if (QBaseActivity.sTopActivity != null) {
      localObject = QBaseActivity.sTopActivity;
    } else {
      localObject = Foreground.getTopActivity();
    }
    Object localObject = BridgeModuleHelper.c(null, localJSONObject, null, (Activity)localObject);
    if (localObject != null) {
      ((QQCustomDialog)localObject).setPositiveButton("复制文本", new ViolaUiDelegate.3(paramContext, str));
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
    this.a.setStatusBarColor(paramHashMap);
  }
  
  private void b(HashMap<String, Object> paramHashMap, ViewGroup paramViewGroup)
  {
    if (paramHashMap.containsKey("title_suspension")) {
      this.q = ((Boolean)paramHashMap.get("title_suspension")).booleanValue();
    }
    if (paramHashMap.containsKey("title_trans_anim")) {
      this.r = ((Boolean)paramHashMap.get("title_trans_anim")).booleanValue();
    }
    if ((!this.r) && (paramHashMap.containsKey("cycle_loading"))) {
      this.r = ((Boolean)paramHashMap.get("cycle_loading")).booleanValue();
    }
    if (paramHashMap.containsKey("error_view_white")) {
      this.s = ((Boolean)paramHashMap.get("error_view_white")).booleanValue();
    }
    if (paramHashMap.containsKey("title_border_radius")) {
      c(paramHashMap, paramViewGroup);
    }
    if (paramHashMap.containsKey("title_default_title_height"))
    {
      int i1 = Integer.valueOf((String)paramHashMap.get("title_default_title_height")).intValue();
      this.x.put("title_default_title_height", Integer.valueOf(i1));
    }
    if (paramHashMap.containsKey("title_margin_top")) {
      d(paramHashMap, paramViewGroup);
    }
    if (paramHashMap.containsKey("title_default_gray_bar")) {
      this.x.put("title_default_gray_bar", paramHashMap.get("title_default_gray_bar"));
    }
    if (paramHashMap.containsKey("title_default_pop_anim")) {
      this.x.put("title_default_pop_anim", paramHashMap.get("title_default_pop_anim"));
    }
    if (paramHashMap.containsKey("title_default_back_bar")) {
      this.x.put("title_default_back_bar", paramHashMap.get("title_default_back_bar"));
    }
    if (paramHashMap.containsKey("title_status_immersive")) {
      this.x.put("title_status_immersive", paramHashMap.get("title_status_immersive"));
    }
    if (paramHashMap.containsKey("title_default_auto_top")) {
      this.x.put("title_default_auto_top", paramHashMap.get("title_default_auto_top"));
    }
    if (paramHashMap.containsKey("title_default_interrupt_back")) {
      this.x.put("title_default_interrupt_back", paramHashMap.get("title_default_interrupt_back"));
    }
    if (paramHashMap.containsKey("title_content_color"))
    {
      this.x.put("title_content_color", paramHashMap.get("title_content_color"));
      this.z = Color.parseColor((String)paramHashMap.get("title_content_color"));
    }
    if (paramHashMap.containsKey("title_default_title_alpha")) {
      this.x.put("title_default_title_alpha", paramHashMap.get("title_default_title_alpha"));
    }
    if (paramHashMap.containsKey("title_default_gray_float")) {
      this.x.put("title_default_gray_float", paramHashMap.get("title_default_gray_float"));
    }
    if (paramHashMap.containsKey("bundle_is_splash_activity")) {
      this.u = ((Boolean)paramHashMap.get("bundle_is_splash_activity")).booleanValue();
    }
    if (paramHashMap.containsKey("bundle_is_suspension_anyplace")) {
      this.v = ((Boolean)paramHashMap.get("bundle_is_suspension_anyplace")).booleanValue();
    }
    if (paramHashMap.containsKey("bundle_is_bid_anyplace")) {
      this.w = ((Boolean)paramHashMap.get("bundle_is_bid_anyplace")).booleanValue();
    }
    if (d()) {
      this.a.setStatusBarFontColor(Boolean.valueOf(true));
    }
    if (paramHashMap.containsKey("title_content_color")) {
      this.a.setContentViewColor((String)paramHashMap.get("title_content_color"));
    }
    if (paramHashMap.containsKey("title_status_visiable")) {
      this.a.hideStatusBarByParams();
    }
    if ((paramHashMap.containsKey("content_full_screen")) && (!paramHashMap.containsKey("title_default_is_channel"))) {
      this.a.setContentFullScreen();
    }
  }
  
  private void c(HashMap<String, Object> paramHashMap, ViewGroup paramViewGroup)
  {
    int i1 = Integer.valueOf((String)paramHashMap.get("title_border_radius")).intValue();
    this.x.put("title_border_radius", Integer.valueOf(i1));
  }
  
  private void d(ViewGroup paramViewGroup)
  {
    if (!this.k) {
      return;
    }
    this.f = ((LinearLayout)paramViewGroup.findViewById(2131441404));
    this.f.setVisibility(0);
  }
  
  private void d(HashMap<String, Object> paramHashMap, ViewGroup paramViewGroup)
  {
    if (paramViewGroup != null)
    {
      int i1 = Integer.valueOf((String)paramHashMap.get("title_margin_top")).intValue();
      this.y = AIOUtils.b(i1, paramViewGroup.getResources());
      this.x.put("title_margin_top", Integer.valueOf(i1));
    }
  }
  
  private TopGestureLayout e(ViewGroup paramViewGroup)
  {
    if (paramViewGroup == null) {
      return null;
    }
    int i1 = 0;
    while (i1 < paramViewGroup.getChildCount())
    {
      View localView = paramViewGroup.getChildAt(i1);
      if ((localView instanceof TopGestureLayout)) {
        return (TopGestureLayout)localView;
      }
      if ((localView instanceof ViewGroup)) {
        return e((ViewGroup)localView);
      }
      i1 += 1;
    }
    return null;
  }
  
  private void n()
  {
    if (this.l == null) {
      this.l = new ViolaUiDelegate.1(this);
    }
  }
  
  private void o()
  {
    if (!this.k) {
      return;
    }
    LinearLayout localLinearLayout = this.f;
    if ((localLinearLayout != null) && (localLinearLayout.getVisibility() != 0)) {
      this.f.setVisibility(0);
    }
  }
  
  private void p()
  {
    if (!this.k) {
      return;
    }
    LinearLayout localLinearLayout = this.f;
    if ((localLinearLayout != null) && (localLinearLayout.getVisibility() != 8)) {
      this.f.setVisibility(8);
    }
  }
  
  private void q()
  {
    if (this.g == null)
    {
      this.g = this.D.inflate();
      int i1 = this.z;
      if (i1 != -1) {
        this.g.setBackgroundColor(i1);
      }
      this.h = ((TextView)this.g.findViewById(2131444252));
      this.i = ((ImageView)this.g.findViewById(2131444251));
      Resources localResources = this.g.getResources();
      this.h.setText(localResources.getString(2131915491));
      this.g.setOnClickListener(this.B);
      this.g.setOnLongClickListener(this.C);
      if ((this.z != -1) && (!l())) {
        this.i.setImageDrawable(localResources.getDrawable(2130839671));
      } else {
        this.i.setImageDrawable(localResources.getDrawable(2130839454));
      }
      this.h.setTextColor(this.g.getResources().getColor(2131167846));
      ((LinearLayout.LayoutParams)this.h.getLayoutParams()).topMargin = AIOUtils.b(10.0F, localResources);
    }
  }
  
  private Activity r()
  {
    ViolaFragment localViolaFragment = this.a;
    if (localViolaFragment != null) {
      return localViolaFragment.getActivity();
    }
    return this.b.getActivity();
  }
  
  private boolean s()
  {
    if ((this.b instanceof ReadInJoyViolaChannelFragment)) {
      return true;
    }
    return (RIJXTabFrameUtils.INSTANCE.isNowInKanDianTab()) && (this.u);
  }
  
  public void a()
  {
    View localView = this.g;
    if (localView != null) {
      localView.setVisibility(8);
    }
  }
  
  public void a(int paramInt)
  {
    if (paramInt == 0)
    {
      b(this.E);
      return;
    }
    if (this.p == null) {
      this.p = i();
    }
    TopGestureLayout localTopGestureLayout = this.p;
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
      this.m = bool1;
      if (this.m) {
        this.a.hideTitleBar();
      }
      if ((!this.m) && (paramBundle.getBoolean("is_channel", false)))
      {
        this.m = true;
        this.a.hideTitleBar();
      }
      this.c = ((SerializableMap)paramBundle.getSerializable(ViolaFragment.BUNDLE_PAGE_CONFIG_DATA));
      paramBundle = this.c;
      if (paramBundle != null)
      {
        if (paramBundle.getMap().containsKey("title_hide"))
        {
          bool1 = bool2;
          if (((Integer)this.c.getMap().get("title_hide")).intValue() == 1) {
            bool1 = true;
          }
          this.m = bool1;
          if (this.m) {
            this.a.hideTitleBar();
          }
        }
        if (this.c.getMap().containsKey("title_status_color"))
        {
          this.n = ((Boolean)this.c.getMap().get("title_status_color")).booleanValue();
          if (this.n) {
            this.a.setStatusBarColor("#ffffff");
          }
        }
        if (!this.m)
        {
          if (this.c.getMap().containsKey("title_nav_background_color"))
          {
            paramBundle = (String)this.c.getMap().get("title_nav_background_color");
            this.a.setTitleContainerBackgroundColor(paramBundle);
          }
          if (this.c.getMap().containsKey("title_nav_text_color"))
          {
            paramBundle = (String)this.c.getMap().get("title_nav_text_color");
            this.a.setLeftTextColor(paramBundle);
            this.a.setRightTextColor(paramBundle);
          }
          if (this.c.getMap().containsKey("title_nav_center_text_color"))
          {
            paramBundle = (String)this.c.getMap().get("title_nav_center_text_color");
            this.a.setCenterTextColor(paramBundle);
          }
          if ((this.c.getMap().containsKey("title_nav_alpha")) && (this.c.getMap().get("title_nav_alpha") != null))
          {
            paramBundle = (Float)this.c.getMap().get("title_nav_alpha");
            this.a.setTitleAlpha(paramBundle.floatValue());
          }
        }
      }
    }
  }
  
  public void a(ViewGroup paramViewGroup)
  {
    a(a(this.a.getUrl()), paramViewGroup);
  }
  
  public void a(ViewGroup paramViewGroup, View.OnClickListener paramOnClickListener)
  {
    a(paramViewGroup, paramOnClickListener, null);
  }
  
  public void a(ViewGroup paramViewGroup, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener)
  {
    if ((!d()) && (!k()))
    {
      this.j = ((FrameLayout)paramViewGroup.findViewById(2131449906));
      if (this.j.getVisibility() != 0) {
        this.j.setVisibility(0);
      }
    }
    if (this.D == null) {
      this.D = ((ViewStub)paramViewGroup.findViewById(2131449907));
    }
    this.B = paramOnClickListener;
    this.C = paramOnLongClickListener;
  }
  
  public void a(TopGestureLayout.OnGestureListener paramOnGestureListener)
  {
    if (this.p == null) {
      b(true);
    }
    TopGestureLayout localTopGestureLayout = this.p;
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
        this.o = ((Boolean)paramHashMap.get("title_status_immersive")).booleanValue();
        if (this.o)
        {
          this.a.setStatusBarImmersive();
          if ((paramHashMap.containsKey("title_hide_nav_bar")) && (((Boolean)paramHashMap.get("title_hide_nav_bar")).booleanValue())) {
            ViolaFragment.hideNavBar(this.a.getActivity());
          }
        }
      }
      if (!this.o)
      {
        if (paramHashMap.containsKey("title_status_color"))
        {
          this.n = ((Boolean)paramHashMap.get("title_status_color")).booleanValue();
          if (this.n) {
            this.a.setStatusBarColor("#ffffff");
          }
        }
        if (paramHashMap.containsKey("title_status_bar_color")) {
          a(paramHashMap);
        }
      }
      if ((paramHashMap.containsKey("title_full_screen")) && (((Boolean)paramHashMap.get("title_full_screen")).booleanValue())) {
        this.a.setFullScreen();
      }
      Object localObject;
      if (paramHashMap.containsKey("title_status_font_color"))
      {
        localObject = (Boolean)paramHashMap.get("title_status_font_color");
        this.a.setStatusBarFontColor((Boolean)localObject);
      }
      if (paramHashMap.containsKey("title_hide"))
      {
        int i1 = ((Integer)paramHashMap.get("title_hide")).intValue();
        boolean bool = true;
        if (i1 != 1) {
          bool = false;
        }
        this.m = bool;
      }
      if (this.m)
      {
        this.a.hideTitleBar();
      }
      else
      {
        if (paramHashMap.containsKey("title_nav_background_color"))
        {
          localObject = (String)paramHashMap.get("title_nav_background_color");
          this.a.setTitleContainerBackgroundColor((String)localObject);
        }
        if (paramHashMap.containsKey("title_nav_text_color"))
        {
          localObject = (String)paramHashMap.get("title_nav_text_color");
          this.a.setLeftTextColor((String)localObject);
          this.a.setRightTextColor((String)localObject);
        }
        if (paramHashMap.containsKey("title_nav_center_text_color"))
        {
          localObject = (String)paramHashMap.get("title_nav_center_text_color");
          this.a.setCenterTextColor((String)localObject);
        }
        if ((paramHashMap.containsKey("title_nav_alpha")) && (paramHashMap.get("title_nav_alpha") != null))
        {
          localObject = (String)paramHashMap.get("title_nav_alpha");
          this.a.setTitleAlpha(Float.valueOf((String)localObject).floatValue());
        }
        this.a.setLeftButtonText(HardCodeUtil.a(2131901576), null);
        this.a.setReadInjoyTitleStyle();
      }
      n();
      b(paramHashMap, paramViewGroup);
    }
    this.a.useNightMode();
  }
  
  public void a(boolean paramBoolean)
  {
    this.k = paramBoolean;
  }
  
  public HashMap b()
  {
    return this.x;
  }
  
  public void b(ViewGroup paramViewGroup)
  {
    if (!this.k) {
      return;
    }
    if ((!d()) && (!k()))
    {
      this.e = new WebViewProgressBar(paramViewGroup.getContext());
      this.e.setId(2131440738);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, AIOUtils.b(3.0F, paramViewGroup.getContext().getResources()));
      localLayoutParams.addRule(10, -1);
      this.e.setLayoutParams(localLayoutParams);
      paramViewGroup.addView(this.e);
      this.d = new WebViewProgressBarController();
      this.d.a(this.e);
      this.e.setController(this.d);
      if ((!ViolaBizUtils.c(this.a.getUrl())) || (!ViolaSoLoaderManager.a.a().f())) {
        g();
      }
    }
    else
    {
      d(paramViewGroup);
    }
  }
  
  public void b(boolean paramBoolean)
  {
    if (this.p == null) {
      this.p = i();
    }
    TopGestureLayout localTopGestureLayout = this.p;
    if (localTopGestureLayout != null)
    {
      this.E = paramBoolean;
      localTopGestureLayout.setInterceptTouchFlag(paramBoolean);
    }
  }
  
  public OnTitleChangeListener c()
  {
    return this.l;
  }
  
  public void c(ViewGroup paramViewGroup)
  {
    if (d())
    {
      this.j = ((FrameLayout)paramViewGroup.findViewById(2131449906));
      if (this.j.getVisibility() != 0) {
        this.j.setVisibility(0);
      }
      b(true);
    }
  }
  
  public void c(boolean paramBoolean)
  {
    this.A = paramBoolean;
  }
  
  public boolean d()
  {
    return (this.q) && ((s()) || (this.v)) && (!this.w);
  }
  
  public boolean e()
  {
    View localView = this.g;
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
  
  public void f()
  {
    q();
    if ((d()) && (this.t))
    {
      ViolaSDKManager.getInstance().postOnUiThreadDelay(new ViolaUiDelegate.2(this), 350L);
      return;
    }
    View localView = this.g;
    if (localView != null) {
      localView.setVisibility(0);
    }
    if (l()) {
      this.a.setContentViewColor("white");
    }
  }
  
  public void g()
  {
    if (!this.k) {
      return;
    }
    if ((!d()) && (!k()))
    {
      WebViewProgressBarController localWebViewProgressBarController = this.d;
      if ((localWebViewProgressBarController != null) && (localWebViewProgressBarController.d() != 0)) {
        this.d.a((byte)0);
      }
    }
    else
    {
      o();
    }
  }
  
  public void h()
  {
    if (!this.k) {
      return;
    }
    if ((!d()) && (!k()))
    {
      WebViewProgressBarController localWebViewProgressBarController = this.d;
      if ((localWebViewProgressBarController != null) && (localWebViewProgressBarController.d() != 2)) {
        this.d.a((byte)2);
      }
    }
    else
    {
      p();
    }
  }
  
  public TopGestureLayout i()
  {
    if (r() == null) {
      return null;
    }
    ViewGroup localViewGroup = (ViewGroup)r().getWindow().getDecorView();
    Object localObject = null;
    int i1 = 0;
    while (i1 < localViewGroup.getChildCount())
    {
      View localView = localViewGroup.getChildAt(i1);
      localObject = localView;
      if ((localView instanceof DragFrameLayout)) {
        localObject = ((DragFrameLayout)localView).getChildAt(0);
      }
      if ((localObject instanceof TopGestureLayout)) {
        break;
      }
      i1 += 1;
    }
    if ((localObject != null) && ((localObject instanceof TopGestureLayout))) {
      return (TopGestureLayout)localObject;
    }
    return e(localViewGroup);
  }
  
  public boolean j()
  {
    return (this.A) && (!this.w);
  }
  
  public boolean k()
  {
    return this.r;
  }
  
  public boolean l()
  {
    return this.s;
  }
  
  public int m()
  {
    return this.y;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.viola.delegate.ViolaUiDelegate
 * JD-Core Version:    0.7.0.1
 */