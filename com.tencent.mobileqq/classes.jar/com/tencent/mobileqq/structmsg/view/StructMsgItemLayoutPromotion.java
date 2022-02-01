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
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.ecshop.api.IEcshopUtilApi;
import com.tencent.mobileqq.ecshop.conf.EcshopConfBean;
import com.tencent.mobileqq.ecshop.conf.EcshopConfBean.PromotionConfBean;
import com.tencent.mobileqq.ecshop.view.api.IEcshopRainViewApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.structmsg.AbsStructMsgElement;
import com.tencent.mobileqq.structmsg.AbsStructMsgItem;
import com.tencent.mobileqq.urldrawable.URLDrawableHelperConstants;
import com.tencent.mobileqq.widget.FixRatioPAHighLightImageView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinnableBitmapDrawable;
import cooperation.qwallet.plugin.QWalletPicHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public class StructMsgItemLayoutPromotion
  extends AbsStructMsgItem
{
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
  }
  
  private View a(Context paramContext, RelativeLayout paramRelativeLayout, Bundle paramBundle)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    do
    {
      boolean bool = localIterator.hasNext();
      localObject = null;
      if (!bool) {
        break;
      }
      localObject = (AbsStructMsgElement)localIterator.next();
    } while (!(localObject instanceof StructMsgItemCover));
    Object localObject = ((AbsStructMsgElement)localObject).a(paramContext, null, paramBundle);
    ((View)localObject).setId(2131377961);
    paramContext = ((View)localObject).findViewById(2131368633);
    if ((paramContext instanceof FixRatioPAHighLightImageView))
    {
      ((FixRatioPAHighLightImageView)paramContext).setRatio(1.8F);
      paramContext = new RelativeLayout.LayoutParams(-1, -2);
    }
    else
    {
      int i = BaseChatItemLayout.A;
      if (!paramBundle.getBoolean("hasHeadIcon", true)) {
        i = BaseChatItemLayout.B;
      }
      double d = i;
      Double.isNaN(d);
      paramContext = new RelativeLayout.LayoutParams(-1, (int)(d / 1.8D));
    }
    paramRelativeLayout.addView((View)localObject, paramContext);
    return localObject;
  }
  
  private ImageView a(Context paramContext)
  {
    ImageView localImageView = new ImageView(paramContext);
    paramContext = paramContext.getResources().getDrawable(2130847331);
    if ((paramContext instanceof SkinnableBitmapDrawable)) {
      paramContext = ((SkinnableBitmapDrawable)paramContext).mutate2();
    } else {
      paramContext = paramContext.mutate();
    }
    if (this.jdField_s_of_type_Int == 1) {
      paramContext.setColorFilter(-1, PorterDuff.Mode.SRC_ATOP);
    } else {
      paramContext.setColorFilter(-49602, PorterDuff.Mode.SRC_ATOP);
    }
    localImageView.setImageDrawable(paramContext);
    localImageView.setScaleType(ImageView.ScaleType.FIT_XY);
    localImageView.setId(2131377962);
    return localImageView;
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
    paramContext.setId(2131377963);
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
    } else {
      localTextView.setTextColor(-1);
    }
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
    localLayoutParams.gravity = 16;
    localLayoutParams.topMargin = AIOUtils.b(10.0F, paramContext.getResources());
    localLayoutParams.bottomMargin = AIOUtils.b(10.0F, paramContext.getResources());
    paramLinearLayout.addView(localTextView, localLayoutParams);
    return localTextView;
  }
  
  private void a(Context paramContext, LinearLayout paramLinearLayout)
  {
    View localView = new View(paramContext);
    GradientDrawable localGradientDrawable = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[] { -26554, -48849 });
    localView.setBackgroundDrawable(QWalletPicHelper.getNetDrawableForAIO(this.ag, localGradientDrawable));
    paramLinearLayout.addView(localView, new LinearLayout.LayoutParams(-2, AIOUtils.b(40.0F, paramContext.getResources())));
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
    paramBundle.addRule(3, 2131377961);
    paramLinearLayout.setId(2131377960);
    paramLinearLayout.setOrientation(1);
    localRelativeLayout.addView(paramLinearLayout, paramBundle);
    b(paramContext, paramLinearLayout);
    c(paramContext, paramLinearLayout);
    d(paramContext, paramLinearLayout);
  }
  
  private void a(Context paramContext, LinearLayout paramLinearLayout, TextView paramTextView)
  {
    int i = AIOUtils.b(5.0F, paramContext.getResources());
    int j = AIOUtils.b(4.0F, paramContext.getResources());
    TextView localTextView = new TextView(paramContext);
    localTextView.setText(this.ae);
    localTextView.setTextSize(14.0F);
    localTextView.setTextColor(-1);
    localTextView.setGravity(17);
    a(localTextView, 6);
    float f1 = localTextView.getPaint().measureText(this.ae);
    float f2 = j;
    f1 = f1 + f2 + f2;
    paramContext = new LinearLayout.LayoutParams((int)f1, AIOUtils.b(20.0F, paramContext.getResources()));
    paramContext.leftMargin = i;
    paramContext.gravity = 16;
    localTextView.setBackgroundDrawable(QWalletPicHelper.getNetDrawableForAIO(this.aj, URLDrawableHelperConstants.a));
    j = this.jdField_t_of_type_Int;
    if (j == 1)
    {
      paramLinearLayout.addView(localTextView, paramContext);
      return;
    }
    if (j == 0) {
      paramTextView.post(new StructMsgItemLayoutPromotion.1(this, paramLinearLayout, paramTextView, f1, i, localTextView, paramContext));
    }
  }
  
  private void a(Context paramContext, RelativeLayout paramRelativeLayout)
  {
    ImageView localImageView = new ImageView(paramContext);
    if (this.jdField_s_of_type_Int == 1) {
      paramContext = URLDrawableHelperConstants.a;
    } else {
      paramContext = new GradientDrawable(GradientDrawable.Orientation.TL_BR, new int[] { -26554, -48849 });
    }
    localImageView.setImageDrawable(QWalletPicHelper.getNetDrawableForAIO(this.ah, paramContext));
    paramContext = new RelativeLayout.LayoutParams(-1, -2);
    paramContext.addRule(6, 2131377960);
    paramContext.addRule(8, 2131377960);
    localImageView.setScaleType(ImageView.ScaleType.FIT_XY);
    paramRelativeLayout.addView(localImageView, paramContext);
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
    localLayoutParams.leftMargin = AIOUtils.b(12.0F, paramContext.getResources());
    localLayoutParams.rightMargin = AIOUtils.b(12.0F, paramContext.getResources());
    localLayoutParams.topMargin = AIOUtils.b(6.0F, paramContext.getResources());
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
    paramContext.setImageDrawable(QWalletPicHelper.getNetDrawableForAIO(this.ai, URLDrawableHelperConstants.a));
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
    localLayoutParams.addRule(6, 2131377961);
    localLayoutParams.addRule(8, 2131377960);
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
    } else {
      localTextView.setTextColor(-1);
    }
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
    localLayoutParams.leftMargin = AIOUtils.b(12.0F, paramContext.getResources());
    localLayoutParams.rightMargin = AIOUtils.b(12.0F, paramContext.getResources());
    localLayoutParams.bottomMargin = AIOUtils.b(10.0F, paramContext.getResources());
    paramLinearLayout.addView(localTextView, localLayoutParams);
  }
  
  private void c(Context paramContext, RelativeLayout paramRelativeLayout)
  {
    ImageView localImageView = new ImageView(paramContext);
    localImageView.setImageDrawable(QWalletPicHelper.getNetDrawableForAIO(this.al, URLDrawableHelperConstants.a));
    paramContext = new RelativeLayout.LayoutParams(-1, AIOUtils.b(60.0F, paramContext.getResources()));
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
    Object localObject = new RelativeLayout.LayoutParams(-1, AIOUtils.b(45.0F, paramContext.getResources()));
    if (this.jdField_s_of_type_Int == 1)
    {
      ((RelativeLayout.LayoutParams)localObject).topMargin = AIOUtils.b(15.0F, paramContext.getResources());
      localRelativeLayout.setBackgroundDrawable(QWalletPicHelper.getNetDrawableForAIO(this.ak, new ColorDrawable(-43724)));
    }
    else
    {
      ((RelativeLayout.LayoutParams)localObject).leftMargin = AIOUtils.b(12.0F, paramContext.getResources());
      ((RelativeLayout.LayoutParams)localObject).rightMargin = AIOUtils.b(12.0F, paramContext.getResources());
      ((RelativeLayout.LayoutParams)localObject).bottomMargin = AIOUtils.b(12.0F, paramContext.getResources());
      localRelativeLayout.setBackgroundDrawable(QWalletPicHelper.getNetDrawableForAIO(this.ak, new ColorDrawable(-1)));
      a(localRelativeLayout, 8);
    }
    paramRelativeLayout.addView(localRelativeLayout, (ViewGroup.LayoutParams)localObject);
    localObject = a(paramContext);
    paramRelativeLayout = a(paramContext);
    RelativeLayout.LayoutParams localLayoutParams1 = new RelativeLayout.LayoutParams(-2, -2);
    int i = AIOUtils.b(17.0F, paramContext.getResources());
    RelativeLayout.LayoutParams localLayoutParams2 = new RelativeLayout.LayoutParams(i, i);
    localLayoutParams2.addRule(15);
    localLayoutParams2.leftMargin = AIOUtils.b(5.0F, paramContext.getResources());
    localLayoutParams2.rightMargin = AIOUtils.b(12.0F, paramContext.getResources());
    if (this.jdField_s_of_type_Int == 1)
    {
      localLayoutParams1.addRule(0, 2131377962);
      localLayoutParams1.addRule(15);
      localLayoutParams2.addRule(11);
      localRelativeLayout.addView((View)localObject, localLayoutParams1);
      localRelativeLayout.addView(paramRelativeLayout, localLayoutParams2);
      return;
    }
    paramContext = new RelativeLayout(paramContext);
    localLayoutParams2.addRule(1, 2131377963);
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
    return localObjectAnimator.getDuration() * localObjectAnimator.getRepeatCount();
  }
  
  public void a()
  {
    if ((TextUtils.isEmpty(this.ag)) && (TextUtils.isEmpty(this.ah)) && (TextUtils.isEmpty(this.ai)) && (TextUtils.isEmpty(this.aj)) && (TextUtils.isEmpty(this.ak)) && (TextUtils.isEmpty(this.al))) {
      a(((IEcshopUtilApi)QRoute.api(IEcshopUtilApi.class)).getEcshopConfBean().a);
    }
  }
  
  public boolean a(EcshopConfBean.PromotionConfBean paramPromotionConfBean)
  {
    if (this.jdField_s_of_type_Int == 1) {
      paramPromotionConfBean = paramPromotionConfBean.a;
    } else {
      paramPromotionConfBean = paramPromotionConfBean.b;
    }
    if (paramPromotionConfBean.isEmpty()) {
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
    boolean bool1 = paramAbsStructMsgElement instanceof StructMsgItemLayout6;
    boolean bool2 = false;
    if (!bool1) {
      return false;
    }
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
    bool1 = bool2;
    if (b())
    {
      bool1 = bool2;
      if (a(paramPromotionConfBean)) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  protected int b()
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
    else
    {
      paramView = a(paramContext);
    }
    b();
    a();
    if (this.jdField_s_of_type_Int == 2) {
      a(paramContext, paramView);
    }
    a(paramContext, paramView, paramBundle);
    a(paramView, 14);
    return paramView;
  }
  
  public String b()
  {
    return "LayoutPromotion";
  }
  
  public boolean b()
  {
    for (;;)
    {
      int i;
      try
      {
        if (TextUtils.isEmpty(this.X)) {
          return false;
        }
        Object localObject = new JSONObject(this.X).optJSONObject("display_info");
        JSONObject localJSONObject = ((JSONObject)localObject).optJSONObject("basic_info");
        this.ac = localJSONObject.optString("txt");
        this.ad = localJSONObject.optString("desc");
        localObject = ((JSONObject)localObject).optJSONArray("button_info");
        if (localObject != null)
        {
          i = 0;
          if (i < ((JSONArray)localObject).length())
          {
            localJSONObject = ((JSONArray)localObject).optJSONObject(i);
            if (localJSONObject == null) {
              break label214;
            }
            int j = localJSONObject.optInt("pos");
            if (j == 1)
            {
              this.ae = localJSONObject.optString("txt");
              break label214;
            }
            if (j != 2) {
              break label214;
            }
            this.af = localJSONObject.optString("txt");
            if (!TextUtils.isEmpty(this.af)) {
              break label214;
            }
            this.af = "查看详情";
            break label214;
          }
        }
        this.jdField_s_of_type_Int = ((IEcshopRainViewApi)QRoute.api(IEcshopRainViewApi.class)).getMsgPromotion(this.X);
        i = this.jdField_s_of_type_Int;
        if (i != -1) {
          return true;
        }
      }
      catch (Exception localException)
      {
        QLog.e("StructMsgItemLayoutPromotion", 1, localException, new Object[0]);
      }
      return false;
      label214:
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.view.StructMsgItemLayoutPromotion
 * JD-Core Version:    0.7.0.1
 */