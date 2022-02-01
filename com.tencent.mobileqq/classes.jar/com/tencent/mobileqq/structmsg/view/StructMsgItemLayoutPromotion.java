package com.tencent.mobileqq.structmsg.view;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.pubaccount.ecshopassit.EcShopAssistantManager;
import com.tencent.biz.pubaccount.ecshopassit.conf.EcshopConfBean;
import com.tencent.biz.pubaccount.ecshopassit.conf.EcshopConfBean.PromotionConfBean;
import com.tencent.biz.pubaccount.ecshopassit.conf.EcshopConfProcessor;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.structmsg.AbsStructMsgElement;
import com.tencent.mobileqq.structmsg.AbsStructMsgItem;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.widget.FixRatioPAHighLightImageView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinnableBitmapDrawable;
import cooperation.qwallet.plugin.IQWalletPicHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public class StructMsgItemLayoutPromotion
  extends AbsStructMsgItem
{
  private IQWalletPicHelper a;
  private String ac = null;
  private String ad = null;
  private String ae = null;
  private String af = null;
  private String ag = null;
  private String ah = null;
  private String ai = null;
  private String aj = null;
  private String ak = null;
  private String al = null;
  private int s;
  private int t;
  
  public StructMsgItemLayoutPromotion()
  {
    this.jdField_s_of_type_Int = -1;
    this.jdField_t_of_type_Int = 0;
    this.jdField_a_of_type_CooperationQwalletPluginIQWalletPicHelper = ((IQWalletPicHelper)QRoute.api(IQWalletPicHelper.class));
  }
  
  private View a(Context paramContext, RelativeLayout paramRelativeLayout, Bundle paramBundle)
  {
    Object localObject = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (((Iterator)localObject).hasNext())
    {
      AbsStructMsgElement localAbsStructMsgElement = (AbsStructMsgElement)((Iterator)localObject).next();
      if ((localAbsStructMsgElement instanceof StructMsgItemCover))
      {
        localObject = localAbsStructMsgElement.a(paramContext, null, paramBundle);
        ((View)localObject).setId(2131378550);
        paramContext = ((View)localObject).findViewById(2131368907);
        if ((paramContext instanceof FixRatioPAHighLightImageView)) {
          ((FixRatioPAHighLightImageView)paramContext).setRatio(1.8F);
        }
        int i;
        for (paramContext = new RelativeLayout.LayoutParams(-1, -2);; paramContext = new RelativeLayout.LayoutParams(-1, (int)(i / 1.8D)))
        {
          paramRelativeLayout.addView((View)localObject, paramContext);
          return localObject;
          i = BaseChatItemLayout.A;
          if (!paramBundle.getBoolean("hasHeadIcon", true)) {
            i = BaseChatItemLayout.B;
          }
        }
      }
    }
    return null;
  }
  
  private ImageView a(Context paramContext)
  {
    ImageView localImageView = new ImageView(paramContext);
    paramContext = paramContext.getResources().getDrawable(2130847462);
    if ((paramContext instanceof SkinnableBitmapDrawable))
    {
      paramContext = ((SkinnableBitmapDrawable)paramContext).mutate2();
      if (this.jdField_s_of_type_Int != 1) {
        break label78;
      }
      paramContext.setColorFilter(-1, PorterDuff.Mode.SRC_ATOP);
    }
    for (;;)
    {
      localImageView.setImageDrawable(paramContext);
      localImageView.setScaleType(ImageView.ScaleType.FIT_XY);
      localImageView.setId(2131378551);
      return localImageView;
      paramContext = paramContext.mutate();
      break;
      label78:
      paramContext.setColorFilter(-49602, PorterDuff.Mode.SRC_ATOP);
    }
  }
  
  private LinearLayout a(Context paramContext)
  {
    paramContext = new LinearLayout(paramContext);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
    paramContext.setOrientation(1);
    paramContext.setLayoutParams(localLayoutParams);
    if (QLog.isColorLevel()) {
      QLog.i("StructMsgItemLayoutPromotion", 2, "getItemRootView");
    }
    return paramContext;
  }
  
  private TextView a(Context paramContext)
  {
    paramContext = new TextView(paramContext);
    paramContext.setText(this.af);
    paramContext.setTypeface(Typeface.DEFAULT_BOLD);
    paramContext.setTextSize(17.0F);
    paramContext.setId(2131378552);
    if (this.jdField_s_of_type_Int == 1)
    {
      paramContext.setTextColor(-1);
      return paramContext;
    }
    paramContext.setTextColor(-49602);
    return paramContext;
  }
  
  private TextView a(Context paramContext, LinearLayout paramLinearLayout)
  {
    TextView localTextView = new TextView(paramContext);
    localTextView.setText(this.ac);
    localTextView.setTextSize(18.0F);
    localTextView.setTypeface(Typeface.DEFAULT_BOLD);
    if (this.jdField_s_of_type_Int == 1) {
      localTextView.setTextColor(-16777216);
    }
    for (;;)
    {
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
      localLayoutParams.gravity = 16;
      localLayoutParams.topMargin = AIOUtils.a(10.0F, paramContext.getResources());
      localLayoutParams.bottomMargin = AIOUtils.a(10.0F, paramContext.getResources());
      paramLinearLayout.addView(localTextView, localLayoutParams);
      return localTextView;
      localTextView.setTextColor(-1);
    }
  }
  
  private void a(Context paramContext, LinearLayout paramLinearLayout)
  {
    View localView = new View(paramContext);
    GradientDrawable localGradientDrawable = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[] { -26554, -48849 });
    localView.setBackgroundDrawable(this.jdField_a_of_type_CooperationQwalletPluginIQWalletPicHelper.getNetDrawableForAIO(this.ag, localGradientDrawable));
    paramLinearLayout.addView(localView, new LinearLayout.LayoutParams(-2, AIOUtils.a(40.0F, paramContext.getResources())));
  }
  
  private void a(Context paramContext, LinearLayout paramLinearLayout, Bundle paramBundle)
  {
    RelativeLayout localRelativeLayout = new RelativeLayout(paramContext);
    paramLinearLayout.addView(localRelativeLayout, new LinearLayout.LayoutParams(-1, -2));
    a(paramContext, localRelativeLayout);
    b(paramContext, localRelativeLayout);
    a(paramContext, localRelativeLayout, paramBundle);
    paramLinearLayout = new LinearLayout(paramContext);
    paramBundle = new RelativeLayout.LayoutParams(-1, -2);
    paramBundle.addRule(3, 2131378550);
    paramLinearLayout.setId(2131378549);
    paramLinearLayout.setOrientation(1);
    localRelativeLayout.addView(paramLinearLayout, paramBundle);
    b(paramContext, paramLinearLayout);
    c(paramContext, paramLinearLayout);
    d(paramContext, paramLinearLayout);
  }
  
  private void a(Context paramContext, LinearLayout paramLinearLayout, TextView paramTextView)
  {
    int i = AIOUtils.a(5.0F, paramContext.getResources());
    int j = AIOUtils.a(4.0F, paramContext.getResources());
    TextView localTextView = new TextView(paramContext);
    localTextView.setText(this.ae);
    localTextView.setTextSize(14.0F);
    localTextView.setTextColor(-1);
    localTextView.setGravity(17);
    a(localTextView, 6);
    float f = localTextView.getPaint().measureText(this.ae) + j + j;
    paramContext = new LinearLayout.LayoutParams((int)f, AIOUtils.a(20.0F, paramContext.getResources()));
    paramContext.leftMargin = i;
    paramContext.gravity = 16;
    localTextView.setBackgroundDrawable(this.jdField_a_of_type_CooperationQwalletPluginIQWalletPicHelper.getNetDrawableForAIO(this.aj, URLDrawableHelper.TRANSPARENT));
    if (this.jdField_t_of_type_Int == 1) {
      paramLinearLayout.addView(localTextView, paramContext);
    }
    while (this.jdField_t_of_type_Int != 0) {
      return;
    }
    paramTextView.post(new StructMsgItemLayoutPromotion.1(this, paramLinearLayout, paramTextView, f, i, localTextView, paramContext));
  }
  
  private void a(Context paramContext, RelativeLayout paramRelativeLayout)
  {
    ImageView localImageView = new ImageView(paramContext);
    if (this.jdField_s_of_type_Int == 1) {}
    for (paramContext = URLDrawableHelper.TRANSPARENT;; paramContext = new GradientDrawable(GradientDrawable.Orientation.TL_BR, new int[] { -26554, -48849 }))
    {
      localImageView.setImageDrawable(this.jdField_a_of_type_CooperationQwalletPluginIQWalletPicHelper.getNetDrawableForAIO(this.ah, paramContext));
      paramContext = new RelativeLayout.LayoutParams(-1, -2);
      paramContext.addRule(6, 2131378549);
      paramContext.addRule(8, 2131378549);
      localImageView.setScaleType(ImageView.ScaleType.FIT_XY);
      paramRelativeLayout.addView(localImageView, paramContext);
      return;
    }
  }
  
  private void a(View paramView, int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      paramView.setOutlineProvider(new StructMsgItemLayoutPromotion.2(this, paramInt));
      paramView.setClipToOutline(true);
    }
  }
  
  private void b(Context paramContext, LinearLayout paramLinearLayout)
  {
    LinearLayout localLinearLayout = new LinearLayout(paramContext);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
    localLayoutParams.leftMargin = AIOUtils.a(12.0F, paramContext.getResources());
    localLayoutParams.rightMargin = AIOUtils.a(12.0F, paramContext.getResources());
    localLayoutParams.topMargin = AIOUtils.a(6.0F, paramContext.getResources());
    localLinearLayout.setOrientation(0);
    paramLinearLayout.addView(localLinearLayout, localLayoutParams);
    paramLinearLayout = a(paramContext, localLinearLayout);
    if (!TextUtils.isEmpty(this.ae)) {
      a(paramContext, localLinearLayout, paramLinearLayout);
    }
  }
  
  private void b(Context paramContext, RelativeLayout paramRelativeLayout)
  {
    paramContext = new ImageView(paramContext);
    paramContext.setImageDrawable(this.jdField_a_of_type_CooperationQwalletPluginIQWalletPicHelper.getNetDrawableForAIO(this.ai, URLDrawableHelper.TRANSPARENT));
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
    localLayoutParams.addRule(6, 2131378550);
    localLayoutParams.addRule(8, 2131378549);
    paramContext.setScaleType(ImageView.ScaleType.FIT_END);
    paramRelativeLayout.addView(paramContext, localLayoutParams);
  }
  
  private void c(Context paramContext, LinearLayout paramLinearLayout)
  {
    if (TextUtils.isEmpty(this.ad)) {
      return;
    }
    TextView localTextView = new TextView(paramContext);
    localTextView.setText(this.ad);
    localTextView.setTextSize(14.0F);
    if (this.jdField_s_of_type_Int == 1) {
      localTextView.setTextColor(-16777216);
    }
    for (;;)
    {
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
      localLayoutParams.leftMargin = AIOUtils.a(12.0F, paramContext.getResources());
      localLayoutParams.rightMargin = AIOUtils.a(12.0F, paramContext.getResources());
      localLayoutParams.bottomMargin = AIOUtils.a(10.0F, paramContext.getResources());
      paramLinearLayout.addView(localTextView, localLayoutParams);
      return;
      localTextView.setTextColor(-1);
    }
  }
  
  private void c(Context paramContext, RelativeLayout paramRelativeLayout)
  {
    ImageView localImageView = new ImageView(paramContext);
    localImageView.setImageDrawable(this.jdField_a_of_type_CooperationQwalletPluginIQWalletPicHelper.getNetDrawableForAIO(this.al, URLDrawableHelper.TRANSPARENT));
    paramContext = new RelativeLayout.LayoutParams(-1, AIOUtils.a(60.0F, paramContext.getResources()));
    localImageView.setScaleType(ImageView.ScaleType.FIT_START);
    paramRelativeLayout.addView(localImageView, paramContext);
  }
  
  private void d(Context paramContext, LinearLayout paramLinearLayout)
  {
    RelativeLayout localRelativeLayout = new RelativeLayout(paramContext);
    paramLinearLayout.addView(localRelativeLayout, new LinearLayout.LayoutParams(-1, -2));
    d(paramContext, localRelativeLayout);
    if (this.jdField_s_of_type_Int == 1) {
      c(paramContext, localRelativeLayout);
    }
  }
  
  private void d(Context paramContext, RelativeLayout paramRelativeLayout)
  {
    RelativeLayout localRelativeLayout = new RelativeLayout(paramContext);
    Object localObject = new RelativeLayout.LayoutParams(-1, AIOUtils.a(45.0F, paramContext.getResources()));
    if (this.jdField_s_of_type_Int == 1)
    {
      ((RelativeLayout.LayoutParams)localObject).topMargin = AIOUtils.a(15.0F, paramContext.getResources());
      localRelativeLayout.setBackgroundDrawable(this.jdField_a_of_type_CooperationQwalletPluginIQWalletPicHelper.getNetDrawableForAIO(this.ak, new ColorDrawable(-43724)));
    }
    RelativeLayout.LayoutParams localLayoutParams1;
    RelativeLayout.LayoutParams localLayoutParams2;
    for (;;)
    {
      paramRelativeLayout.addView(localRelativeLayout, (ViewGroup.LayoutParams)localObject);
      localObject = a(paramContext);
      paramRelativeLayout = a(paramContext);
      localLayoutParams1 = new RelativeLayout.LayoutParams(-2, -2);
      int i = AIOUtils.a(17.0F, paramContext.getResources());
      localLayoutParams2 = new RelativeLayout.LayoutParams(i, i);
      localLayoutParams2.addRule(15);
      localLayoutParams2.leftMargin = AIOUtils.a(5.0F, paramContext.getResources());
      localLayoutParams2.rightMargin = AIOUtils.a(12.0F, paramContext.getResources());
      if (this.jdField_s_of_type_Int != 1) {
        break;
      }
      localLayoutParams1.addRule(0, 2131378551);
      localLayoutParams1.addRule(15);
      localLayoutParams2.addRule(11);
      localRelativeLayout.addView((View)localObject, localLayoutParams1);
      localRelativeLayout.addView(paramRelativeLayout, localLayoutParams2);
      return;
      ((RelativeLayout.LayoutParams)localObject).leftMargin = AIOUtils.a(12.0F, paramContext.getResources());
      ((RelativeLayout.LayoutParams)localObject).rightMargin = AIOUtils.a(12.0F, paramContext.getResources());
      ((RelativeLayout.LayoutParams)localObject).bottomMargin = AIOUtils.a(12.0F, paramContext.getResources());
      localRelativeLayout.setBackgroundDrawable(this.jdField_a_of_type_CooperationQwalletPluginIQWalletPicHelper.getNetDrawableForAIO(this.ak, new ColorDrawable(-1)));
      a(localRelativeLayout, 8);
    }
    paramContext = new RelativeLayout(paramContext);
    localLayoutParams2.addRule(1, 2131378552);
    paramContext.addView((View)localObject, localLayoutParams1);
    paramContext.addView(paramRelativeLayout, localLayoutParams2);
    localObject = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject).addRule(13);
    localRelativeLayout.addView(paramContext, (ViewGroup.LayoutParams)localObject);
    a(paramRelativeLayout);
  }
  
  public long a(View paramView)
  {
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(paramView, "translationX", new float[] { 0.0F, 20.0F, 0.0F });
    localObjectAnimator.setDuration(800L);
    localObjectAnimator.setRepeatCount(-1);
    localObjectAnimator.setRepeatMode(1);
    localObjectAnimator.start();
    paramView.addOnAttachStateChangeListener(new StructMsgItemLayoutPromotion.3(this, localObjectAnimator));
    long l = localObjectAnimator.getDuration();
    return localObjectAnimator.getRepeatCount() * l;
  }
  
  public void a()
  {
    EcshopConfBean localEcshopConfBean;
    if ((TextUtils.isEmpty(this.ag)) && (TextUtils.isEmpty(this.ah)) && (TextUtils.isEmpty(this.ai)) && (TextUtils.isEmpty(this.aj)) && (TextUtils.isEmpty(this.ak)) && (TextUtils.isEmpty(this.al)))
    {
      localEcshopConfBean = EcshopConfProcessor.a();
      if (localEcshopConfBean != null) {}
    }
    else
    {
      return;
    }
    a(localEcshopConfBean.a);
  }
  
  public boolean a(EcshopConfBean.PromotionConfBean paramPromotionConfBean)
  {
    if (this.jdField_s_of_type_Int == 1) {}
    for (paramPromotionConfBean = paramPromotionConfBean.a; paramPromotionConfBean.isEmpty(); paramPromotionConfBean = paramPromotionConfBean.b) {
      return false;
    }
    this.ag = ((String)paramPromotionConfBean.get("top_bg_url"));
    this.ah = ((String)paramPromotionConfBean.get("bottom_bg_url"));
    this.ai = ((String)paramPromotionConfBean.get("bottom_ani_url"));
    this.aj = ((String)paramPromotionConfBean.get("discount_bg_url"));
    this.ak = ((String)paramPromotionConfBean.get("detail_bg_url"));
    this.al = ((String)paramPromotionConfBean.get("detail_logo_url"));
    return true;
  }
  
  public boolean a(AbsStructMsgElement paramAbsStructMsgElement, EcshopConfBean.PromotionConfBean paramPromotionConfBean)
  {
    if (!(paramAbsStructMsgElement instanceof StructMsgItemLayout6)) {}
    do
    {
      return false;
      paramAbsStructMsgElement = (AbsStructMsgItem)paramAbsStructMsgElement;
      this.jdField_a_of_type_JavaUtilArrayList = paramAbsStructMsgElement.jdField_a_of_type_JavaUtilArrayList;
      this.b = paramAbsStructMsgElement.b;
      this.jdField_c_of_type_JavaLangString = paramAbsStructMsgElement.jdField_c_of_type_JavaLangString;
      this.jdField_d_of_type_JavaLangString = paramAbsStructMsgElement.jdField_d_of_type_JavaLangString;
      this.jdField_e_of_type_JavaLangString = paramAbsStructMsgElement.jdField_e_of_type_JavaLangString;
      this.jdField_f_of_type_JavaLangString = paramAbsStructMsgElement.jdField_f_of_type_JavaLangString;
      this.jdField_g_of_type_JavaLangString = paramAbsStructMsgElement.jdField_g_of_type_JavaLangString;
      this.jdField_h_of_type_JavaLangString = paramAbsStructMsgElement.jdField_h_of_type_JavaLangString;
      this.jdField_i_of_type_JavaLangString = paramAbsStructMsgElement.jdField_i_of_type_JavaLangString;
      this.jdField_j_of_type_JavaLangString = paramAbsStructMsgElement.jdField_j_of_type_JavaLangString;
      this.jdField_k_of_type_JavaLangString = paramAbsStructMsgElement.jdField_k_of_type_JavaLangString;
      this.jdField_l_of_type_JavaLangString = paramAbsStructMsgElement.jdField_l_of_type_JavaLangString;
      this.jdField_m_of_type_JavaLangString = paramAbsStructMsgElement.jdField_m_of_type_JavaLangString;
      this.jdField_n_of_type_JavaLangString = paramAbsStructMsgElement.jdField_n_of_type_JavaLangString;
      this.o = paramAbsStructMsgElement.o;
      this.p = paramAbsStructMsgElement.p;
      this.q = paramAbsStructMsgElement.q;
      this.jdField_c_of_type_Int = paramAbsStructMsgElement.jdField_c_of_type_Int;
      this.r = paramAbsStructMsgElement.r;
      this.jdField_s_of_type_JavaLangString = paramAbsStructMsgElement.jdField_s_of_type_JavaLangString;
      this.jdField_t_of_type_JavaLangString = paramAbsStructMsgElement.jdField_t_of_type_JavaLangString;
      this.u = paramAbsStructMsgElement.u;
      this.v = paramAbsStructMsgElement.v;
      this.jdField_d_of_type_Int = paramAbsStructMsgElement.jdField_d_of_type_Int;
      this.w = paramAbsStructMsgElement.w;
      this.x = paramAbsStructMsgElement.x;
      this.y = paramAbsStructMsgElement.y;
      this.z = paramAbsStructMsgElement.z;
      this.A = paramAbsStructMsgElement.A;
      this.jdField_e_of_type_Int = paramAbsStructMsgElement.jdField_e_of_type_Int;
      this.B = paramAbsStructMsgElement.B;
      this.C = paramAbsStructMsgElement.C;
      this.D = paramAbsStructMsgElement.D;
      this.E = paramAbsStructMsgElement.E;
      this.F = paramAbsStructMsgElement.F;
      this.G = paramAbsStructMsgElement.G;
      this.H = paramAbsStructMsgElement.H;
      this.I = paramAbsStructMsgElement.I;
      this.J = paramAbsStructMsgElement.J;
      this.jdField_f_of_type_Int = paramAbsStructMsgElement.jdField_f_of_type_Int;
      this.K = paramAbsStructMsgElement.K;
      this.L = paramAbsStructMsgElement.L;
      this.M = paramAbsStructMsgElement.M;
      this.N = paramAbsStructMsgElement.N;
      this.O = paramAbsStructMsgElement.O;
      this.jdField_g_of_type_Int = paramAbsStructMsgElement.jdField_g_of_type_Int;
      this.jdField_h_of_type_Int = paramAbsStructMsgElement.jdField_h_of_type_Int;
      this.P = paramAbsStructMsgElement.P;
      this.Q = paramAbsStructMsgElement.Q;
      this.R = paramAbsStructMsgElement.R;
      this.jdField_i_of_type_Int = paramAbsStructMsgElement.jdField_i_of_type_Int;
      this.jdField_j_of_type_Int = paramAbsStructMsgElement.jdField_j_of_type_Int;
      this.jdField_k_of_type_Int = paramAbsStructMsgElement.jdField_k_of_type_Int;
      this.jdField_l_of_type_Int = paramAbsStructMsgElement.jdField_l_of_type_Int;
      this.S = paramAbsStructMsgElement.S;
      this.T = paramAbsStructMsgElement.T;
      this.U = paramAbsStructMsgElement.U;
      this.V = paramAbsStructMsgElement.V;
      this.W = paramAbsStructMsgElement.W;
      this.X = paramAbsStructMsgElement.X;
      this.Y = paramAbsStructMsgElement.Y;
      this.jdField_m_of_type_Int = paramAbsStructMsgElement.jdField_m_of_type_Int;
      this.Z = paramAbsStructMsgElement.Z;
      this.aa = paramAbsStructMsgElement.aa;
      this.jdField_a_of_type_Long = paramAbsStructMsgElement.jdField_a_of_type_Long;
      this.ab = paramAbsStructMsgElement.ab;
      this.jdField_n_of_type_Int = paramAbsStructMsgElement.jdField_n_of_type_Int;
      this.jdField_a_of_type_JavaLangRefWeakReference = paramAbsStructMsgElement.jdField_a_of_type_JavaLangRefWeakReference;
      this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg = paramAbsStructMsgElement.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg;
    } while ((!b()) || (!a(paramPromotionConfBean)));
    return true;
  }
  
  public int b()
  {
    return 102632;
  }
  
  public View b(Context paramContext, View paramView, Bundle paramBundle)
  {
    if ((paramView instanceof LinearLayout))
    {
      paramView = (LinearLayout)paramView;
      paramView.removeAllViews();
    }
    for (;;)
    {
      b();
      a();
      if (this.jdField_s_of_type_Int == 2) {
        a(paramContext, paramView);
      }
      a(paramContext, paramView, paramBundle);
      a(paramView, 14);
      return paramView;
      paramView = a(paramContext);
    }
  }
  
  public String b()
  {
    return "LayoutPromotion";
  }
  
  public boolean b()
  {
    boolean bool = false;
    for (;;)
    {
      JSONObject localJSONObject;
      int i;
      int j;
      try
      {
        if (TextUtils.isEmpty(this.X)) {
          return false;
        }
        Object localObject = new JSONObject(this.X).optJSONObject("display_info");
        localJSONObject = ((JSONObject)localObject).optJSONObject("basic_info");
        this.ac = localJSONObject.optString("txt");
        this.ad = localJSONObject.optString("desc");
        localObject = ((JSONObject)localObject).optJSONArray("button_info");
        if (localObject == null) {
          break label191;
        }
        i = 0;
        if (i >= ((JSONArray)localObject).length()) {
          break label191;
        }
        localJSONObject = ((JSONArray)localObject).optJSONObject(i);
        if (localJSONObject == null) {
          break label216;
        }
        j = localJSONObject.optInt("pos");
        if (j == 1) {
          this.ae = localJSONObject.optString("txt");
        }
      }
      catch (Exception localException)
      {
        QLog.e("StructMsgItemLayoutPromotion", 1, localException, new Object[0]);
        return false;
      }
      if (j == 2)
      {
        this.af = localJSONObject.optString("txt");
        if (TextUtils.isEmpty(this.af))
        {
          this.af = "查看详情";
          break label216;
          label191:
          this.jdField_s_of_type_Int = EcShopAssistantManager.a(this.X);
          i = this.jdField_s_of_type_Int;
          if (i != -1) {
            bool = true;
          }
          return bool;
        }
      }
      label216:
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.view.StructMsgItemLayoutPromotion
 * JD-Core Version:    0.7.0.1
 */