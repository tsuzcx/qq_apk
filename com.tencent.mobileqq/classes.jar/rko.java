import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyChannelActivity.SerializableMap;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyViolaChannelFragment;
import com.tencent.biz.pubaccount.readinjoy.view.ReadinjoyTabFrame;
import com.tencent.biz.pubaccount.readinjoy.viola.ViolaFragment;
import com.tencent.biz.pubaccount.readinjoy.viola.delegate.ViolaUiDelegate.2;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.activity.fling.TopGestureLayout.OnGestureListener;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.widget.WebViewProgressBar;
import com.tencent.viola.core.ViolaSDKManager;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.HashMap;
import java.util.Map;

public class rko
{
  public static String a;
  public static String b;
  public static String c;
  public static String d;
  public static String e;
  public static String f;
  public static String g;
  public static String h;
  public static String i = "title_status_font_color";
  public static String j = "title_status_immersive";
  public static String k = "title_full_screen";
  public static String l = "title_hide_nav_bar";
  public static String m = "title_suspension";
  public static String n = "title_border_radius";
  public static String o = "title_margin_top";
  public static String p = "bundle_is_splash_activity";
  public static String q = "bundle_is_suspension_anyplace";
  public static String r = "bundle_is_bid_anyplace";
  public static String s = "title_content_color";
  private int jdField_a_of_type_Int;
  private Fragment jdField_a_of_type_AndroidSupportV4AppFragment;
  private View jdField_a_of_type_AndroidViewView;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private bbpa jdField_a_of_type_Bbpa;
  private ReadInJoyChannelActivity.SerializableMap jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadInJoyChannelActivity$SerializableMap;
  private ViolaFragment jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViolaFragment;
  private TopGestureLayout jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout;
  private WebViewProgressBar jdField_a_of_type_ComTencentMobileqqWidgetWebViewProgressBar;
  private rkq jdField_a_of_type_Rkq;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private boolean jdField_b_of_type_Boolean;
  private boolean c;
  private boolean d;
  private boolean e;
  private boolean f;
  private boolean g;
  private boolean h;
  
  static
  {
    jdField_a_of_type_JavaLangString = "title_name";
    jdField_b_of_type_JavaLangString = "title_hide";
    jdField_c_of_type_JavaLangString = "title_nav_background_color";
    jdField_d_of_type_JavaLangString = "title_nav_text_color";
    jdField_e_of_type_JavaLangString = "title_nav_center_text_color";
    jdField_f_of_type_JavaLangString = "title_nav_alpha";
    jdField_g_of_type_JavaLangString = "title_status_bar_color";
    jdField_h_of_type_JavaLangString = "title_status_color";
  }
  
  public rko(Fragment paramFragment)
  {
    this.jdField_d_of_type_Boolean = true;
    this.jdField_e_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidSupportV4AppFragment = paramFragment;
  }
  
  public rko(ViolaFragment paramViolaFragment)
  {
    this.jdField_d_of_type_Boolean = true;
    this.jdField_e_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViolaFragment = paramViolaFragment;
  }
  
  private Activity a()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViolaFragment != null) {
      return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViolaFragment.getActivity();
    }
    return this.jdField_a_of_type_AndroidSupportV4AppFragment.getActivity();
  }
  
  private static HashMap<String, Object> a(String paramString)
  {
    boolean bool2 = true;
    if (!TextUtils.isEmpty(paramString))
    {
      HashMap localHashMap = new HashMap();
      String str = jdField_b_of_type_JavaLangString;
      int i1;
      if (paramString.contains("hideNav=1"))
      {
        i1 = 1;
        localHashMap.put(str, Integer.valueOf(i1));
        localHashMap.put(jdField_h_of_type_JavaLangString, Boolean.valueOf(paramString.contains("statusColor=1")));
        if (!TextUtils.isEmpty(rjb.a(paramString, "v_nav_bgclr"))) {
          localHashMap.put(jdField_c_of_type_JavaLangString, rjb.a(paramString, "v_nav_bgclr"));
        }
        if (!TextUtils.isEmpty(rjb.a(paramString, "v_nav_txtclr"))) {
          localHashMap.put(jdField_d_of_type_JavaLangString, rjb.a(paramString, "v_nav_txtclr"));
        }
        if (!TextUtils.isEmpty(rjb.a(paramString, "v_nav_titleclr"))) {
          localHashMap.put(jdField_e_of_type_JavaLangString, rjb.a(paramString, "v_nav_titleclr"));
        }
        if (!TextUtils.isEmpty(rjb.a(paramString, "v_nav_alpha"))) {
          localHashMap.put(jdField_f_of_type_JavaLangString, rjb.a(paramString, "v_nav_alpha"));
        }
        str = i;
        if (!paramString.contains("statusBarStyle=1")) {
          break label536;
        }
        bool1 = true;
        label188:
        localHashMap.put(str, Boolean.valueOf(bool1));
        if (!TextUtils.isEmpty(rjb.a(paramString, "statusBarColor"))) {
          localHashMap.put(jdField_g_of_type_JavaLangString, rjb.a(paramString, "statusBarColor"));
        }
        str = j;
        if (!paramString.contains("v_nav_immer=1")) {
          break label541;
        }
        bool1 = true;
        label243:
        localHashMap.put(str, Boolean.valueOf(bool1));
        str = k;
        if (!paramString.contains("v_full_screen=1")) {
          break label546;
        }
        bool1 = true;
        label271:
        localHashMap.put(str, Boolean.valueOf(bool1));
        str = l;
        if (!paramString.contains("v_hide_nav=1")) {
          break label551;
        }
        bool1 = true;
        label299:
        localHashMap.put(str, Boolean.valueOf(bool1));
        str = m;
        if ((!paramString.contains("v_present=2")) && (!paramString.contains("v_present=1"))) {
          break label556;
        }
        bool1 = true;
        label336:
        localHashMap.put(str, Boolean.valueOf(bool1));
        if (!TextUtils.isEmpty(rjb.a(paramString, "v_present_radius"))) {
          localHashMap.put(n, rjb.a(paramString, "v_present_radius"));
        }
        if (TextUtils.isEmpty(rjb.a(paramString, "v_present_top"))) {
          break label561;
        }
        localHashMap.put(o, rjb.a(paramString, "v_present_top"));
        label402:
        str = p;
        if (!paramString.contains("from_splash_activity=1")) {
          break label575;
        }
        bool1 = true;
        label418:
        localHashMap.put(str, Boolean.valueOf(bool1));
        str = q;
        if (!paramString.contains("v_present=2")) {
          break label580;
        }
        bool1 = true;
        label446:
        localHashMap.put(str, Boolean.valueOf(bool1));
        str = r;
        if (!paramString.contains("&v_bid_apply_anywhere=0")) {
          break label585;
        }
      }
      label536:
      label541:
      label546:
      label551:
      label556:
      label561:
      label575:
      label580:
      label585:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        localHashMap.put(str, Boolean.valueOf(bool1));
        if (paramString.contains("v_bg_color")) {
          localHashMap.put(s, "#" + rjb.a(paramString, "v_bg_color"));
        }
        return localHashMap;
        i1 = 0;
        break;
        bool1 = false;
        break label188;
        bool1 = false;
        break label243;
        bool1 = false;
        break label271;
        bool1 = false;
        break label299;
        bool1 = false;
        break label336;
        localHashMap.put(o, "0");
        break label402;
        bool1 = false;
        break label418;
        bool1 = false;
        break label446;
      }
    }
    return null;
  }
  
  private boolean c()
  {
    if ((this.jdField_a_of_type_AndroidSupportV4AppFragment instanceof ReadInJoyViolaChannelFragment)) {}
    while ((ReadinjoyTabFrame.c_()) && (this.jdField_f_of_type_Boolean)) {
      return true;
    }
    return false;
  }
  
  private void d(ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramViewGroup.findViewById(2131306882));
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
  }
  
  private void e()
  {
    if (this.jdField_a_of_type_Rkq == null) {
      this.jdField_a_of_type_Rkq = new rkp(this);
    }
  }
  
  private void f()
  {
    if ((this.jdField_a_of_type_AndroidWidgetLinearLayout != null) && (this.jdField_a_of_type_AndroidWidgetLinearLayout.getVisibility() != 0)) {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    }
  }
  
  private void g()
  {
    if ((this.jdField_a_of_type_AndroidWidgetLinearLayout != null) && (this.jdField_a_of_type_AndroidWidgetLinearLayout.getVisibility() != 8)) {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    }
  }
  
  public int a()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public rkq a()
  {
    return this.jdField_a_of_type_Rkq;
  }
  
  public void a()
  {
    if (b()) {
      f();
    }
    while ((this.jdField_a_of_type_Bbpa == null) || (this.jdField_a_of_type_Bbpa.b() == 0)) {
      return;
    }
    this.jdField_a_of_type_Bbpa.a((byte)0);
  }
  
  public void a(Bundle paramBundle)
  {
    boolean bool2 = true;
    if (paramBundle != null)
    {
      if (paramBundle.getInt(jdField_b_of_type_JavaLangString, 0) != 1) {
        break label401;
      }
      bool1 = true;
      this.jdField_a_of_type_Boolean = bool1;
      if (this.jdField_a_of_type_Boolean) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViolaFragment.o();
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadInJoyChannelActivity$SerializableMap = ((ReadInJoyChannelActivity.SerializableMap)paramBundle.getSerializable(ViolaFragment.jdField_a_of_type_JavaLangString));
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadInJoyChannelActivity$SerializableMap != null) {
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadInJoyChannelActivity$SerializableMap.getMap().containsKey(jdField_b_of_type_JavaLangString)) {
          if (((Integer)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadInJoyChannelActivity$SerializableMap.getMap().get(jdField_b_of_type_JavaLangString)).intValue() != 1) {
            break label406;
          }
        }
      }
    }
    label401:
    label406:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.jdField_a_of_type_Boolean = bool1;
      if (this.jdField_a_of_type_Boolean) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViolaFragment.o();
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadInJoyChannelActivity$SerializableMap.getMap().containsKey(jdField_h_of_type_JavaLangString))
      {
        this.jdField_b_of_type_Boolean = ((Boolean)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadInJoyChannelActivity$SerializableMap.getMap().get(jdField_h_of_type_JavaLangString)).booleanValue();
        if (this.jdField_b_of_type_Boolean) {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViolaFragment.a("#ffffff");
        }
      }
      if (!this.jdField_a_of_type_Boolean)
      {
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadInJoyChannelActivity$SerializableMap.getMap().containsKey(jdField_c_of_type_JavaLangString))
        {
          paramBundle = (String)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadInJoyChannelActivity$SerializableMap.getMap().get(jdField_c_of_type_JavaLangString);
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViolaFragment.c(paramBundle);
        }
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadInJoyChannelActivity$SerializableMap.getMap().containsKey(jdField_d_of_type_JavaLangString))
        {
          paramBundle = (String)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadInJoyChannelActivity$SerializableMap.getMap().get(jdField_d_of_type_JavaLangString);
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViolaFragment.d(paramBundle);
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViolaFragment.f(paramBundle);
        }
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadInJoyChannelActivity$SerializableMap.getMap().containsKey(jdField_e_of_type_JavaLangString))
        {
          paramBundle = (String)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadInJoyChannelActivity$SerializableMap.getMap().get(jdField_e_of_type_JavaLangString);
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViolaFragment.e(paramBundle);
        }
        if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadInJoyChannelActivity$SerializableMap.getMap().containsKey(jdField_f_of_type_JavaLangString)) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadInJoyChannelActivity$SerializableMap.getMap().get(jdField_f_of_type_JavaLangString) != null))
        {
          paramBundle = (Float)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadInJoyChannelActivity$SerializableMap.getMap().get(jdField_f_of_type_JavaLangString);
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViolaFragment.a(paramBundle.floatValue());
        }
      }
      return;
      bool1 = false;
      break;
    }
  }
  
  public void a(ViewGroup paramViewGroup)
  {
    a(a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViolaFragment.a()), paramViewGroup);
  }
  
  public void a(ViewGroup paramViewGroup, View.OnClickListener paramOnClickListener)
  {
    if (!b())
    {
      this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)paramViewGroup.findViewById(2131313408));
      if (this.jdField_a_of_type_AndroidWidgetFrameLayout.getVisibility() != 0) {
        this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(0);
      }
    }
    if (this.jdField_a_of_type_AndroidViewView == null)
    {
      this.jdField_a_of_type_AndroidViewView = ((ViewStub)paramViewGroup.findViewById(2131313409)).inflate();
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131309025));
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131309024));
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramViewGroup.getResources().getString(2131652712));
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(paramOnClickListener);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramViewGroup.getResources().getDrawable(2130838992));
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(paramViewGroup.getResources().getColor(2131101146));
    ((LinearLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams()).topMargin = aciy.a(10.0F, paramViewGroup.getResources());
    if ((b()) && (this.jdField_a_of_type_Int != 0))
    {
      int i1 = Color.parseColor("#F9F9FB");
      paramViewGroup = new GradientDrawable();
      paramViewGroup.setCornerRadii(new float[] { this.jdField_a_of_type_Int, this.jdField_a_of_type_Int, this.jdField_a_of_type_Int, this.jdField_a_of_type_Int, 0.0F, 0.0F, 0.0F, 0.0F });
      paramViewGroup.setColor(i1);
      this.jdField_a_of_type_AndroidViewView.setBackgroundDrawable(paramViewGroup);
    }
  }
  
  public void a(TopGestureLayout.OnGestureListener paramOnGestureListener)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout == null) {
      a(true);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout.setOnFlingGesture(paramOnGestureListener);
    }
  }
  
  public void a(HashMap<String, Object> paramHashMap, ViewGroup paramViewGroup)
  {
    String str;
    Object localObject;
    boolean bool;
    if (paramHashMap != null)
    {
      if (paramHashMap.containsKey(j))
      {
        this.jdField_c_of_type_Boolean = ((Boolean)paramHashMap.get(j)).booleanValue();
        if (this.jdField_c_of_type_Boolean)
        {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViolaFragment.l();
          if ((paramHashMap.containsKey(l)) && (((Boolean)paramHashMap.get(l)).booleanValue())) {
            this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViolaFragment.s();
          }
        }
      }
      if (!this.jdField_c_of_type_Boolean)
      {
        if (paramHashMap.containsKey(jdField_h_of_type_JavaLangString))
        {
          this.jdField_b_of_type_Boolean = ((Boolean)paramHashMap.get(jdField_h_of_type_JavaLangString)).booleanValue();
          if (this.jdField_b_of_type_Boolean) {
            this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViolaFragment.a("#ffffff");
          }
        }
        if (paramHashMap.containsKey(jdField_g_of_type_JavaLangString))
        {
          str = (String)paramHashMap.get(jdField_g_of_type_JavaLangString);
          if (!str.startsWith("0x")) {
            break label565;
          }
          localObject = str.replace("0x", "#");
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViolaFragment.a((String)localObject);
        }
      }
      if ((paramHashMap.containsKey(k)) && (((Boolean)paramHashMap.get(k)).booleanValue())) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViolaFragment.r();
      }
      if (paramHashMap.containsKey(i))
      {
        localObject = (Boolean)paramHashMap.get(i);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViolaFragment.a((Boolean)localObject);
      }
      if (paramHashMap.containsKey(jdField_b_of_type_JavaLangString))
      {
        if (((Integer)paramHashMap.get(jdField_b_of_type_JavaLangString)).intValue() != 1) {
          break label595;
        }
        bool = true;
        label276:
        this.jdField_a_of_type_Boolean = bool;
      }
      if (!this.jdField_a_of_type_Boolean) {
        break label600;
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViolaFragment.o();
    }
    for (;;)
    {
      e();
      if (paramHashMap.containsKey(m)) {
        this.jdField_d_of_type_Boolean = ((Boolean)paramHashMap.get(m)).booleanValue();
      }
      if ((paramHashMap.containsKey(n)) && (paramViewGroup != null)) {
        this.jdField_a_of_type_Int = aciy.a(Integer.valueOf((String)paramHashMap.get(n)).intValue(), paramViewGroup.getResources());
      }
      if ((paramHashMap.containsKey(o)) && (paramViewGroup != null)) {
        this.jdField_b_of_type_Int = (aciy.a(Integer.valueOf((String)paramHashMap.get(o)).intValue(), paramViewGroup.getResources()) + ImmersiveUtils.getStatusBarHeight(a()));
      }
      if (paramHashMap.containsKey(p)) {
        this.jdField_f_of_type_Boolean = ((Boolean)paramHashMap.get(p)).booleanValue();
      }
      if (paramHashMap.containsKey(q)) {
        this.jdField_g_of_type_Boolean = ((Boolean)paramHashMap.get(q)).booleanValue();
      }
      if (paramHashMap.containsKey(r)) {
        this.jdField_h_of_type_Boolean = ((Boolean)paramHashMap.get(r)).booleanValue();
      }
      if (b()) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViolaFragment.a(Boolean.valueOf(true));
      }
      if ((paramHashMap.containsKey(s)) && (rmb.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViolaFragment.a()))) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViolaFragment.h((String)paramHashMap.get(s));
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViolaFragment.b();
      return;
      label565:
      localObject = str;
      if (!str.startsWith("0X")) {
        break;
      }
      localObject = str.replace("0X", "#");
      break;
      label595:
      bool = false;
      break label276;
      label600:
      if (paramHashMap.containsKey(jdField_c_of_type_JavaLangString))
      {
        localObject = (String)paramHashMap.get(jdField_c_of_type_JavaLangString);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViolaFragment.c((String)localObject);
      }
      if (paramHashMap.containsKey(jdField_d_of_type_JavaLangString))
      {
        localObject = (String)paramHashMap.get(jdField_d_of_type_JavaLangString);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViolaFragment.d((String)localObject);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViolaFragment.f((String)localObject);
      }
      if (paramHashMap.containsKey(jdField_e_of_type_JavaLangString))
      {
        localObject = (String)paramHashMap.get(jdField_e_of_type_JavaLangString);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViolaFragment.e((String)localObject);
      }
      if ((paramHashMap.containsKey(jdField_f_of_type_JavaLangString)) && (paramHashMap.get(jdField_f_of_type_JavaLangString) != null))
      {
        localObject = (String)paramHashMap.get(jdField_f_of_type_JavaLangString);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViolaFragment.a(Float.valueOf((String)localObject).floatValue());
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViolaFragment.a(ajjy.a(2131650676), null);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViolaFragment.q();
    }
  }
  
  public void a(boolean paramBoolean)
  {
    Object localObject;
    int i1;
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout == null) && (a() != null))
    {
      ViewGroup localViewGroup = (ViewGroup)a().getWindow().getDecorView();
      localObject = null;
      i1 = 0;
      if (i1 >= localViewGroup.getChildCount()) {
        break label120;
      }
      View localView = localViewGroup.getChildAt(i1);
      localObject = localView;
      if ((localView instanceof DragFrameLayout)) {
        localObject = ((DragFrameLayout)localView).getChildAt(0);
      }
      if (!(localObject instanceof TopGestureLayout)) {
        break label113;
      }
    }
    label113:
    label120:
    for (;;)
    {
      if ((localObject != null) && ((localObject instanceof TopGestureLayout))) {
        this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout = ((TopGestureLayout)localObject);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout.setInterceptTouchFlag(paramBoolean);
      }
      return;
      i1 += 1;
      break;
    }
  }
  
  public boolean a()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_AndroidViewView != null)
    {
      bool1 = bool2;
      if (this.jdField_a_of_type_AndroidViewView.getVisibility() == 0) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public void b()
  {
    if (b()) {
      g();
    }
    while ((this.jdField_a_of_type_Bbpa == null) || (this.jdField_a_of_type_Bbpa.b() == 2)) {
      return;
    }
    this.jdField_a_of_type_Bbpa.a((byte)2);
  }
  
  public void b(ViewGroup paramViewGroup)
  {
    if (b()) {
      d(paramViewGroup);
    }
    do
    {
      return;
      this.jdField_a_of_type_ComTencentMobileqqWidgetWebViewProgressBar = new WebViewProgressBar(paramViewGroup.getContext());
      this.jdField_a_of_type_ComTencentMobileqqWidgetWebViewProgressBar.setId(2131306308);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, aciy.a(3.0F, paramViewGroup.getContext().getResources()));
      localLayoutParams.addRule(10, -1);
      this.jdField_a_of_type_ComTencentMobileqqWidgetWebViewProgressBar.setLayoutParams(localLayoutParams);
      paramViewGroup.addView(this.jdField_a_of_type_ComTencentMobileqqWidgetWebViewProgressBar);
      this.jdField_a_of_type_Bbpa = new bbpa();
      this.jdField_a_of_type_Bbpa.a(this.jdField_a_of_type_ComTencentMobileqqWidgetWebViewProgressBar);
      this.jdField_a_of_type_ComTencentMobileqqWidgetWebViewProgressBar.setController(this.jdField_a_of_type_Bbpa);
    } while ((rmb.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViolaFragment.a())) && (amzs.i()) && (amzt.i()));
    a();
  }
  
  public boolean b()
  {
    return (this.jdField_d_of_type_Boolean) && ((c()) || (this.jdField_g_of_type_Boolean)) && (!this.jdField_h_of_type_Boolean);
  }
  
  public void c()
  {
    if ((b()) && (this.jdField_e_of_type_Boolean)) {
      ViolaSDKManager.getInstance().postOnUiThreadDelay(new ViolaUiDelegate.2(this), 350L);
    }
    while (this.jdField_a_of_type_AndroidViewView == null) {
      return;
    }
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
  }
  
  public void c(ViewGroup paramViewGroup)
  {
    if (b())
    {
      this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)paramViewGroup.findViewById(2131313408));
      if (this.jdField_a_of_type_Int != 0)
      {
        i1 = Color.parseColor("#F9F9FB");
        localGradientDrawable = new GradientDrawable();
        localGradientDrawable.setCornerRadii(new float[] { this.jdField_a_of_type_Int, this.jdField_a_of_type_Int, this.jdField_a_of_type_Int, this.jdField_a_of_type_Int, 0.0F, 0.0F, 0.0F, 0.0F });
        localGradientDrawable.setColor(i1);
        this.jdField_a_of_type_AndroidWidgetFrameLayout.setBackgroundDrawable(localGradientDrawable);
      }
      if (this.jdField_b_of_type_Int != 0) {
        ((FrameLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetFrameLayout.getLayoutParams()).setMargins(0, this.jdField_b_of_type_Int, 0, 0);
      }
      paramViewGroup = paramViewGroup.findViewById(2131313413);
      paramViewGroup.setVisibility(0);
      int i1 = Color.parseColor("#B5B5B5");
      GradientDrawable localGradientDrawable = new GradientDrawable();
      localGradientDrawable.setCornerRadius(66.0F);
      localGradientDrawable.setColor(i1);
      paramViewGroup.setBackgroundDrawable(localGradientDrawable);
      a(true);
    }
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_AndroidViewView != null) {
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     rko
 * JD-Core Version:    0.7.0.1
 */