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

public class sno
{
  public static String A = "content_full_screen";
  public static String B = "statusBarStyle=2";
  public static String C = "v_content_full=1";
  public static String a;
  public static String b;
  public static String c;
  public static String d;
  public static String e;
  public static String f;
  public static String g;
  public static String h;
  public static String i;
  public static String j;
  public static String k;
  public static String l;
  public static String m;
  public static String n;
  public static String o;
  public static String p;
  public static String q;
  public static String r;
  public static String s;
  public static String t;
  public static String u;
  public static String v;
  public static String w;
  public static String x;
  public static String y;
  public static String z;
  private int jdField_a_of_type_Int;
  private Fragment jdField_a_of_type_AndroidSupportV4AppFragment;
  private View jdField_a_of_type_AndroidViewView;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private bewj jdField_a_of_type_Bewj;
  private ReadInJoyChannelActivity.SerializableMap jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadInJoyChannelActivity$SerializableMap;
  private ViolaFragment jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViolaFragment;
  private TopGestureLayout jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout;
  private WebViewProgressBar jdField_a_of_type_ComTencentMobileqqWidgetWebViewProgressBar;
  private HashMap jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private snq jdField_a_of_type_Snq;
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
    i = "title_status_font_color";
    j = "title_status_immersive";
    k = "title_full_screen";
    l = "title_hide_nav_bar";
    m = "title_suspension";
    n = "title_border_radius";
    o = "title_margin_top";
    p = "title_default_gray_bar";
    q = "title_default_pop_anim";
    r = "title_default_back_bar";
    s = "title_default_auto_top";
    t = "title_default_interrupt_back";
    u = "title_default_title_height";
    v = "bundle_is_splash_activity";
    w = "bundle_is_suspension_anyplace";
    x = "bundle_is_bid_anyplace";
    y = "title_content_color";
    z = "title_status_visiable";
  }
  
  public sno(Fragment paramFragment)
  {
    this.jdField_d_of_type_Boolean = true;
    this.jdField_e_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidSupportV4AppFragment = paramFragment;
  }
  
  public sno(ViolaFragment paramViolaFragment)
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
    boolean bool2 = false;
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
        if (!TextUtils.isEmpty(smk.a(paramString, "v_nav_bgclr"))) {
          localHashMap.put(jdField_c_of_type_JavaLangString, smk.a(paramString, "v_nav_bgclr"));
        }
        if (!TextUtils.isEmpty(smk.a(paramString, "v_nav_txtclr"))) {
          localHashMap.put(jdField_d_of_type_JavaLangString, smk.a(paramString, "v_nav_txtclr"));
        }
        if (!TextUtils.isEmpty(smk.a(paramString, "v_nav_titleclr"))) {
          localHashMap.put(jdField_e_of_type_JavaLangString, smk.a(paramString, "v_nav_titleclr"));
        }
        if (!TextUtils.isEmpty(smk.a(paramString, "v_nav_alpha"))) {
          localHashMap.put(jdField_f_of_type_JavaLangString, smk.a(paramString, "v_nav_alpha"));
        }
        str = i;
        if (!paramString.contains("statusBarStyle=1")) {
          break label771;
        }
        bool1 = true;
        label188:
        localHashMap.put(str, Boolean.valueOf(bool1));
        if (!TextUtils.isEmpty(smk.a(paramString, "statusBarColor"))) {
          localHashMap.put(jdField_g_of_type_JavaLangString, smk.a(paramString, "statusBarColor"));
        }
        str = j;
        if (!paramString.contains("v_nav_immer=1")) {
          break label776;
        }
        bool1 = true;
        label243:
        localHashMap.put(str, Boolean.valueOf(bool1));
        str = k;
        if (!paramString.contains("v_full_screen=1")) {
          break label781;
        }
        bool1 = true;
        label271:
        localHashMap.put(str, Boolean.valueOf(bool1));
        str = l;
        if (!paramString.contains("v_hide_nav=1")) {
          break label786;
        }
        bool1 = true;
        label300:
        localHashMap.put(str, Boolean.valueOf(bool1));
        str = m;
        if ((!paramString.contains("v_present=2")) && (!paramString.contains("v_present=1"))) {
          break label791;
        }
        bool1 = true;
        label339:
        localHashMap.put(str, Boolean.valueOf(bool1));
        if (!TextUtils.isEmpty(smk.a(paramString, "v_present_radius"))) {
          localHashMap.put(n, smk.a(paramString, "v_present_radius"));
        }
        if (!TextUtils.isEmpty(smk.a(paramString, "v_present_top"))) {
          localHashMap.put(o, smk.a(paramString, "v_present_top"));
        }
        if (!TextUtils.isEmpty(smk.a(paramString, "v_present_titleHeight"))) {
          localHashMap.put(u, smk.a(paramString, "v_present_titleHeight"));
        }
        str = v;
        if (!paramString.contains("from_splash_activity=1")) {
          break label796;
        }
        bool1 = true;
        label455:
        localHashMap.put(str, Boolean.valueOf(bool1));
        str = w;
        if (!paramString.contains("v_present=2")) {
          break label801;
        }
        bool1 = true;
        label484:
        localHashMap.put(str, Boolean.valueOf(bool1));
        str = x;
        if (!paramString.contains("&v_bid_apply_anywhere=0")) {
          break label806;
        }
        bool1 = true;
        label513:
        localHashMap.put(str, Boolean.valueOf(bool1));
        str = p;
        if (!paramString.contains("v_present_bar=0")) {
          break label811;
        }
        bool1 = false;
        label542:
        localHashMap.put(str, Boolean.valueOf(bool1));
        str = q;
        if (!paramString.contains("v_present_pop=0")) {
          break label816;
        }
        bool1 = false;
        label571:
        localHashMap.put(str, Boolean.valueOf(bool1));
        str = r;
        if (!paramString.contains("v_present_back_bar=1")) {
          break label821;
        }
        bool1 = true;
        label600:
        localHashMap.put(str, Boolean.valueOf(bool1));
        str = s;
        if (!paramString.contains("v_present_auto_top=0")) {
          break label826;
        }
      }
      label771:
      label776:
      label781:
      label786:
      label791:
      label796:
      label801:
      label806:
      label811:
      label816:
      label821:
      label826:
      for (boolean bool1 = false;; bool1 = true)
      {
        localHashMap.put(str, Boolean.valueOf(bool1));
        str = t;
        bool1 = bool2;
        if (paramString.contains("v_present_interrupt_back=1")) {
          bool1 = true;
        }
        localHashMap.put(str, Boolean.valueOf(bool1));
        if (paramString.contains("v_bg_color")) {
          localHashMap.put(y, "#" + smk.a(paramString, "v_bg_color"));
        }
        if (paramString.contains(B)) {
          localHashMap.put(z, Boolean.valueOf(true));
        }
        if (paramString.contains(C)) {
          localHashMap.put(A, Boolean.valueOf(true));
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
        break label300;
        bool1 = false;
        break label339;
        bool1 = false;
        break label455;
        bool1 = false;
        break label484;
        bool1 = false;
        break label513;
        bool1 = true;
        break label542;
        bool1 = true;
        break label571;
        bool1 = false;
        break label600;
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
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramViewGroup.findViewById(2131372977));
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
  }
  
  private void e()
  {
    if (this.jdField_a_of_type_Snq == null) {
      this.jdField_a_of_type_Snq = new snp(this);
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
  
  public snq a()
  {
    return this.jdField_a_of_type_Snq;
  }
  
  public void a()
  {
    if (b()) {
      f();
    }
    while ((this.jdField_a_of_type_Bewj == null) || (this.jdField_a_of_type_Bewj.b() == 0)) {
      return;
    }
    this.jdField_a_of_type_Bewj.a((byte)0);
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
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViolaFragment.p();
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
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViolaFragment.p();
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
      this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)paramViewGroup.findViewById(2131380007));
      if (this.jdField_a_of_type_AndroidWidgetFrameLayout.getVisibility() != 0) {
        this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(0);
      }
    }
    if (this.jdField_a_of_type_AndroidViewView == null)
    {
      this.jdField_a_of_type_AndroidViewView = ((ViewStub)paramViewGroup.findViewById(2131380008)).inflate();
      if (this.jdField_b_of_type_Int != -1) {
        this.jdField_a_of_type_AndroidViewView.setBackgroundColor(this.jdField_b_of_type_Int);
      }
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131375282));
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131375281));
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramViewGroup.getResources().getString(2131719007));
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(paramOnClickListener);
    if (this.jdField_b_of_type_Int == -1) {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramViewGroup.getResources().getDrawable(2130839102));
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(paramViewGroup.getResources().getColor(2131166789));
      ((LinearLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams()).topMargin = aepi.a(10.0F, paramViewGroup.getResources());
      return;
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramViewGroup.getResources().getDrawable(2130839300));
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
            this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViolaFragment.t();
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
            break label861;
          }
          localObject = str.replace("0x", "#");
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViolaFragment.a((String)localObject);
        }
      }
      if ((paramHashMap.containsKey(k)) && (((Boolean)paramHashMap.get(k)).booleanValue())) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViolaFragment.s();
      }
      if (paramHashMap.containsKey(i))
      {
        localObject = (Boolean)paramHashMap.get(i);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViolaFragment.a((Boolean)localObject);
      }
      if (paramHashMap.containsKey(jdField_b_of_type_JavaLangString))
      {
        if (((Integer)paramHashMap.get(jdField_b_of_type_JavaLangString)).intValue() != 1) {
          break label892;
        }
        bool = true;
        label278:
        this.jdField_a_of_type_Boolean = bool;
      }
      if (!this.jdField_a_of_type_Boolean) {
        break label898;
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViolaFragment.p();
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
        this.jdField_a_of_type_Int = aepi.a(i1, paramViewGroup.getResources());
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
      if (paramHashMap.containsKey(z)) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViolaFragment.o();
      }
      if (paramHashMap.containsKey(A)) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViolaFragment.u();
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViolaFragment.b();
      return;
      label861:
      localObject = str;
      if (!str.startsWith("0X")) {
        break;
      }
      localObject = str.replace("0X", "#");
      break;
      label892:
      bool = false;
      break label278;
      label898:
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
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViolaFragment.a(alud.a(2131716862), null);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViolaFragment.r();
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
    while ((this.jdField_a_of_type_Bewj == null) || (this.jdField_a_of_type_Bewj.b() == 2)) {
      return;
    }
    this.jdField_a_of_type_Bewj.a((byte)2);
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
      this.jdField_a_of_type_ComTencentMobileqqWidgetWebViewProgressBar.setId(2131372342);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, aepi.a(3.0F, paramViewGroup.getContext().getResources()));
      localLayoutParams.addRule(10, -1);
      this.jdField_a_of_type_ComTencentMobileqqWidgetWebViewProgressBar.setLayoutParams(localLayoutParams);
      paramViewGroup.addView(this.jdField_a_of_type_ComTencentMobileqqWidgetWebViewProgressBar);
      this.jdField_a_of_type_Bewj = new bewj();
      this.jdField_a_of_type_Bewj.a(this.jdField_a_of_type_ComTencentMobileqqWidgetWebViewProgressBar);
      this.jdField_a_of_type_ComTencentMobileqqWidgetWebViewProgressBar.setController(this.jdField_a_of_type_Bewj);
    } while ((spw.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViolaFragment.a())) && (aplw.i()) && (aplx.i()));
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
      this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)paramViewGroup.findViewById(2131380007));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     sno
 * JD-Core Version:    0.7.0.1
 */