import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.Window;
import android.widget.FrameLayout;
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
import java.util.HashMap;
import java.util.Map;

public class rxb
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
  public static String p = "title_default_gray_bar";
  public static String q = "title_default_pop_anim";
  public static String r = "title_default_back_bar";
  public static String s = "title_default_auto_top";
  public static String t = "title_default_interrupt_back";
  public static String u = "title_default_title_height";
  public static String v = "bundle_is_splash_activity";
  public static String w = "bundle_is_suspension_anyplace";
  public static String x = "bundle_is_bid_anyplace";
  public static String y = "title_content_color";
  private int jdField_a_of_type_Int;
  private Fragment jdField_a_of_type_AndroidSupportV4AppFragment;
  private View jdField_a_of_type_AndroidViewView;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private bcsr jdField_a_of_type_Bcsr;
  private ReadInJoyChannelActivity.SerializableMap jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadInJoyChannelActivity$SerializableMap;
  private ViolaFragment jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViolaFragment;
  private TopGestureLayout jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout;
  private WebViewProgressBar jdField_a_of_type_ComTencentMobileqqWidgetWebViewProgressBar;
  private HashMap jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private rxd jdField_a_of_type_Rxd;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int = -1;
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
  
  public rxb(Fragment paramFragment)
  {
    this.jdField_d_of_type_Boolean = true;
    this.jdField_e_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidSupportV4AppFragment = paramFragment;
  }
  
  public rxb(ViolaFragment paramViolaFragment)
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
        if (!TextUtils.isEmpty(rvx.a(paramString, "v_nav_bgclr"))) {
          localHashMap.put(jdField_c_of_type_JavaLangString, rvx.a(paramString, "v_nav_bgclr"));
        }
        if (!TextUtils.isEmpty(rvx.a(paramString, "v_nav_txtclr"))) {
          localHashMap.put(jdField_d_of_type_JavaLangString, rvx.a(paramString, "v_nav_txtclr"));
        }
        if (!TextUtils.isEmpty(rvx.a(paramString, "v_nav_titleclr"))) {
          localHashMap.put(jdField_e_of_type_JavaLangString, rvx.a(paramString, "v_nav_titleclr"));
        }
        if (!TextUtils.isEmpty(rvx.a(paramString, "v_nav_alpha"))) {
          localHashMap.put(jdField_f_of_type_JavaLangString, rvx.a(paramString, "v_nav_alpha"));
        }
        str = i;
        if (!paramString.contains("statusBarStyle=1")) {
          break label709;
        }
        bool1 = true;
        label188:
        localHashMap.put(str, Boolean.valueOf(bool1));
        if (!TextUtils.isEmpty(rvx.a(paramString, "statusBarColor"))) {
          localHashMap.put(jdField_g_of_type_JavaLangString, rvx.a(paramString, "statusBarColor"));
        }
        str = j;
        if (!paramString.contains("v_nav_immer=1")) {
          break label714;
        }
        bool1 = true;
        label243:
        localHashMap.put(str, Boolean.valueOf(bool1));
        str = k;
        if (!paramString.contains("v_full_screen=1")) {
          break label719;
        }
        bool1 = true;
        label271:
        localHashMap.put(str, Boolean.valueOf(bool1));
        str = l;
        if (!paramString.contains("v_hide_nav=1")) {
          break label724;
        }
        bool1 = true;
        label299:
        localHashMap.put(str, Boolean.valueOf(bool1));
        str = m;
        if ((!paramString.contains("v_present=2")) && (!paramString.contains("v_present=1"))) {
          break label729;
        }
        bool1 = true;
        label336:
        localHashMap.put(str, Boolean.valueOf(bool1));
        if (!TextUtils.isEmpty(rvx.a(paramString, "v_present_radius"))) {
          localHashMap.put(n, rvx.a(paramString, "v_present_radius"));
        }
        if (!TextUtils.isEmpty(rvx.a(paramString, "v_present_top"))) {
          localHashMap.put(o, rvx.a(paramString, "v_present_top"));
        }
        if (!TextUtils.isEmpty(rvx.a(paramString, "v_present_titleHeight"))) {
          localHashMap.put(u, rvx.a(paramString, "v_present_titleHeight"));
        }
        str = v;
        if (!paramString.contains("from_splash_activity=1")) {
          break label734;
        }
        bool1 = true;
        label445:
        localHashMap.put(str, Boolean.valueOf(bool1));
        str = w;
        if (!paramString.contains("v_present=2")) {
          break label739;
        }
        bool1 = true;
        label473:
        localHashMap.put(str, Boolean.valueOf(bool1));
        str = x;
        if (!paramString.contains("&v_bid_apply_anywhere=0")) {
          break label744;
        }
        bool1 = true;
        label501:
        localHashMap.put(str, Boolean.valueOf(bool1));
        str = p;
        if (!paramString.contains("v_present_bar=0")) {
          break label749;
        }
        bool1 = false;
        label529:
        localHashMap.put(str, Boolean.valueOf(bool1));
        str = q;
        if (!paramString.contains("v_present_pop=0")) {
          break label754;
        }
        bool1 = false;
        label557:
        localHashMap.put(str, Boolean.valueOf(bool1));
        str = r;
        if (!paramString.contains("v_present_back_bar=1")) {
          break label759;
        }
        bool1 = true;
        label586:
        localHashMap.put(str, Boolean.valueOf(bool1));
        str = s;
        if (!paramString.contains("v_present_auto_top=0")) {
          break label764;
        }
        bool1 = false;
        label615:
        localHashMap.put(str, Boolean.valueOf(bool1));
        str = t;
        if (!paramString.contains("v_present_interrupt_back=1")) {
          break label769;
        }
      }
      label769:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        localHashMap.put(str, Boolean.valueOf(bool1));
        if (paramString.contains("v_bg_color")) {
          localHashMap.put(y, "#" + rvx.a(paramString, "v_bg_color"));
        }
        return localHashMap;
        i1 = 0;
        break;
        label709:
        bool1 = false;
        break label188;
        label714:
        bool1 = false;
        break label243;
        label719:
        bool1 = false;
        break label271;
        label724:
        bool1 = false;
        break label299;
        label729:
        bool1 = false;
        break label336;
        label734:
        bool1 = false;
        break label445;
        label739:
        bool1 = false;
        break label473;
        label744:
        bool1 = false;
        break label501;
        label749:
        bool1 = true;
        break label529;
        label754:
        bool1 = true;
        break label557;
        label759:
        bool1 = false;
        break label586;
        label764:
        bool1 = true;
        break label615;
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
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramViewGroup.findViewById(2131372594));
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
  }
  
  private void e()
  {
    if (this.jdField_a_of_type_Rxd == null) {
      this.jdField_a_of_type_Rxd = new rxc(this);
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
    return this.jdField_a_of_type_Int;
  }
  
  public HashMap a()
  {
    return this.jdField_a_of_type_JavaUtilHashMap;
  }
  
  public rxd a()
  {
    return this.jdField_a_of_type_Rxd;
  }
  
  public void a()
  {
    if (b()) {
      f();
    }
    while ((this.jdField_a_of_type_Bcsr == null) || (this.jdField_a_of_type_Bcsr.b() == 0)) {
      return;
    }
    this.jdField_a_of_type_Bcsr.a((byte)0);
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
      this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)paramViewGroup.findViewById(2131379248));
      if (this.jdField_a_of_type_AndroidWidgetFrameLayout.getVisibility() != 0) {
        this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(0);
      }
    }
    if (this.jdField_a_of_type_AndroidViewView == null)
    {
      this.jdField_a_of_type_AndroidViewView = ((ViewStub)paramViewGroup.findViewById(2131379249)).inflate();
      if (this.jdField_b_of_type_Int != -1) {
        this.jdField_a_of_type_AndroidViewView.setBackgroundColor(this.jdField_b_of_type_Int);
      }
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131374768));
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131374767));
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramViewGroup.getResources().getString(2131718547));
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(paramOnClickListener);
    if (this.jdField_b_of_type_Int == -1) {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramViewGroup.getResources().getDrawable(2130839020));
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(paramViewGroup.getResources().getColor(2131166740));
      ((LinearLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams()).topMargin = actj.a(10.0F, paramViewGroup.getResources());
      return;
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramViewGroup.getResources().getDrawable(2130839210));
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
            break label827;
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
          break label858;
        }
        bool = true;
        label278:
        this.jdField_a_of_type_Boolean = bool;
      }
      if (!this.jdField_a_of_type_Boolean) {
        break label864;
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViolaFragment.o();
    }
    for (;;)
    {
      e();
      if (paramHashMap.containsKey(m)) {
        this.jdField_d_of_type_Boolean = ((Boolean)paramHashMap.get(m)).booleanValue();
      }
      int i1;
      if ((paramHashMap.containsKey(n)) && (paramViewGroup != null))
      {
        i1 = Integer.valueOf((String)paramHashMap.get(n)).intValue();
        this.jdField_a_of_type_JavaUtilHashMap.put(n, Integer.valueOf(i1));
      }
      if ((paramHashMap.containsKey(u)) && (paramViewGroup != null))
      {
        i1 = Integer.valueOf((String)paramHashMap.get(u)).intValue();
        this.jdField_a_of_type_JavaUtilHashMap.put(u, Integer.valueOf(i1));
      }
      if ((paramHashMap.containsKey(o)) && (paramViewGroup != null))
      {
        i1 = Integer.valueOf((String)paramHashMap.get(o)).intValue();
        this.jdField_a_of_type_Int = actj.a(i1, paramViewGroup.getResources());
        this.jdField_a_of_type_JavaUtilHashMap.put(o, Integer.valueOf(i1));
      }
      if (paramHashMap.containsKey(p)) {
        this.jdField_a_of_type_JavaUtilHashMap.put(p, paramHashMap.get(p));
      }
      if (paramHashMap.containsKey(q)) {
        this.jdField_a_of_type_JavaUtilHashMap.put(q, paramHashMap.get(q));
      }
      if (paramHashMap.containsKey(r)) {
        this.jdField_a_of_type_JavaUtilHashMap.put(r, paramHashMap.get(r));
      }
      if (paramHashMap.containsKey(j)) {
        this.jdField_a_of_type_JavaUtilHashMap.put(j, paramHashMap.get(j));
      }
      if (paramHashMap.containsKey(s)) {
        this.jdField_a_of_type_JavaUtilHashMap.put(s, paramHashMap.get(s));
      }
      if (paramHashMap.containsKey(t)) {
        this.jdField_a_of_type_JavaUtilHashMap.put(t, paramHashMap.get(t));
      }
      if (paramHashMap.containsKey(y))
      {
        this.jdField_a_of_type_JavaUtilHashMap.put(y, paramHashMap.get(y));
        this.jdField_b_of_type_Int = Color.parseColor((String)paramHashMap.get(y));
      }
      if (paramHashMap.containsKey(v)) {
        this.jdField_f_of_type_Boolean = ((Boolean)paramHashMap.get(v)).booleanValue();
      }
      if (paramHashMap.containsKey(w)) {
        this.jdField_g_of_type_Boolean = ((Boolean)paramHashMap.get(w)).booleanValue();
      }
      if (paramHashMap.containsKey(x)) {
        this.jdField_h_of_type_Boolean = ((Boolean)paramHashMap.get(x)).booleanValue();
      }
      if (b()) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViolaFragment.a(Boolean.valueOf(true));
      }
      if (paramHashMap.containsKey(y)) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViolaFragment.h((String)paramHashMap.get(y));
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViolaFragment.b();
      return;
      label827:
      localObject = str;
      if (!str.startsWith("0X")) {
        break;
      }
      localObject = str.replace("0X", "#");
      break;
      label858:
      bool = false;
      break label278;
      label864:
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
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViolaFragment.a(ajya.a(2131716478), null);
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
    while ((this.jdField_a_of_type_Bcsr == null) || (this.jdField_a_of_type_Bcsr.b() == 2)) {
      return;
    }
    this.jdField_a_of_type_Bcsr.a((byte)2);
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
      this.jdField_a_of_type_ComTencentMobileqqWidgetWebViewProgressBar.setId(2131372005);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, actj.a(3.0F, paramViewGroup.getContext().getResources()));
      localLayoutParams.addRule(10, -1);
      this.jdField_a_of_type_ComTencentMobileqqWidgetWebViewProgressBar.setLayoutParams(localLayoutParams);
      paramViewGroup.addView(this.jdField_a_of_type_ComTencentMobileqqWidgetWebViewProgressBar);
      this.jdField_a_of_type_Bcsr = new bcsr();
      this.jdField_a_of_type_Bcsr.a(this.jdField_a_of_type_ComTencentMobileqqWidgetWebViewProgressBar);
      this.jdField_a_of_type_ComTencentMobileqqWidgetWebViewProgressBar.setController(this.jdField_a_of_type_Bcsr);
    } while ((ryp.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViolaFragment.a())) && (anqf.i()) && (anqg.i()));
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
      this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)paramViewGroup.findViewById(2131379248));
      if (this.jdField_a_of_type_AndroidWidgetFrameLayout.getVisibility() != 0) {
        this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(0);
      }
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
 * Qualified Name:     rxb
 * JD-Core Version:    0.7.0.1
 */