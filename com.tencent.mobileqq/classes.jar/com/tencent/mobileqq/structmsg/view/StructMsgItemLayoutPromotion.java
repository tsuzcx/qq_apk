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
  private String aA = null;
  private String aB = null;
  private String aC = null;
  private int aD = -1;
  private int aE = 0;
  private String aF = null;
  private String aG = null;
  private String aM = null;
  private String aN = null;
  private String aO = null;
  private String aP = null;
  private String az = null;
  
  private View a(Context paramContext, RelativeLayout paramRelativeLayout, Bundle paramBundle)
  {
    Iterator localIterator = this.ax.iterator();
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
    ((View)localObject).setId(2131446448);
    paramContext = ((View)localObject).findViewById(2131435545);
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
  
  private TextView a(Context paramContext)
  {
    paramContext = new TextView(paramContext);
    paramContext.setText(this.aC);
    paramContext.setTypeface(Typeface.DEFAULT_BOLD);
    paramContext.setTextSize(17.0F);
    paramContext.setId(2131446450);
    if (this.aD == 1)
    {
      paramContext.setTextColor(-1);
      return paramContext;
    }
    paramContext.setTextColor(-49602);
    return paramContext;
  }
  
  private void a(Context paramContext, LinearLayout paramLinearLayout)
  {
    View localView = new View(paramContext);
    GradientDrawable localGradientDrawable = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[] { -26554, -48849 });
    localView.setBackgroundDrawable(QWalletPicHelper.getNetDrawableForAIO(this.aF, localGradientDrawable));
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
    paramBundle.addRule(3, 2131446448);
    paramLinearLayout.setId(2131446447);
    paramLinearLayout.setOrientation(1);
    localRelativeLayout.addView(paramLinearLayout, paramBundle);
    b(paramContext, paramLinearLayout);
    d(paramContext, paramLinearLayout);
    e(paramContext, paramLinearLayout);
  }
  
  private void a(Context paramContext, LinearLayout paramLinearLayout, TextView paramTextView)
  {
    int i = AIOUtils.b(5.0F, paramContext.getResources());
    int j = AIOUtils.b(4.0F, paramContext.getResources());
    TextView localTextView = new TextView(paramContext);
    localTextView.setText(this.aB);
    localTextView.setTextSize(14.0F);
    localTextView.setTextColor(-1);
    localTextView.setGravity(17);
    a(localTextView, 6);
    float f1 = localTextView.getPaint().measureText(this.aB);
    float f2 = j;
    f1 = f1 + f2 + f2;
    paramContext = new LinearLayout.LayoutParams((int)f1, AIOUtils.b(20.0F, paramContext.getResources()));
    paramContext.leftMargin = i;
    paramContext.gravity = 16;
    localTextView.setBackgroundDrawable(QWalletPicHelper.getNetDrawableForAIO(this.aN, URLDrawableHelperConstants.a));
    j = this.aE;
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
    if (this.aD == 1) {
      paramContext = URLDrawableHelperConstants.a;
    } else {
      paramContext = new GradientDrawable(GradientDrawable.Orientation.TL_BR, new int[] { -26554, -48849 });
    }
    localImageView.setImageDrawable(QWalletPicHelper.getNetDrawableForAIO(this.aG, paramContext));
    paramContext = new RelativeLayout.LayoutParams(-1, -2);
    paramContext.addRule(6, 2131446447);
    paramContext.addRule(8, 2131446447);
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
  
  private ImageView b(Context paramContext)
  {
    ImageView localImageView = new ImageView(paramContext);
    paramContext = paramContext.getResources().getDrawable(2130848982);
    if ((paramContext instanceof SkinnableBitmapDrawable)) {
      paramContext = ((SkinnableBitmapDrawable)paramContext).mutate2();
    } else {
      paramContext = paramContext.mutate();
    }
    if (this.aD == 1) {
      paramContext.setColorFilter(-1, PorterDuff.Mode.SRC_ATOP);
    } else {
      paramContext.setColorFilter(-49602, PorterDuff.Mode.SRC_ATOP);
    }
    localImageView.setImageDrawable(paramContext);
    localImageView.setScaleType(ImageView.ScaleType.FIT_XY);
    localImageView.setId(2131446449);
    return localImageView;
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
    paramLinearLayout = c(paramContext, localLinearLayout);
    if (!TextUtils.isEmpty(this.aB)) {
      a(paramContext, localLinearLayout, paramLinearLayout);
    }
  }
  
  private void b(Context paramContext, RelativeLayout paramRelativeLayout)
  {
    paramContext = new ImageView(paramContext);
    paramContext.setImageDrawable(QWalletPicHelper.getNetDrawableForAIO(this.aM, URLDrawableHelperConstants.a));
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
    localLayoutParams.addRule(6, 2131446448);
    localLayoutParams.addRule(8, 2131446447);
    paramContext.setScaleType(ImageView.ScaleType.FIT_END);
    paramRelativeLayout.addView(paramContext, localLayoutParams);
  }
  
  private LinearLayout c(Context paramContext)
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
  
  private TextView c(Context paramContext, LinearLayout paramLinearLayout)
  {
    TextView localTextView = new TextView(paramContext);
    localTextView.setText(this.az);
    localTextView.setTextSize(18.0F);
    localTextView.setTypeface(Typeface.DEFAULT_BOLD);
    if (this.aD == 1) {
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
  
  private void c(Context paramContext, RelativeLayout paramRelativeLayout)
  {
    ImageView localImageView = new ImageView(paramContext);
    localImageView.setImageDrawable(QWalletPicHelper.getNetDrawableForAIO(this.aP, URLDrawableHelperConstants.a));
    paramContext = new RelativeLayout.LayoutParams(-1, AIOUtils.b(60.0F, paramContext.getResources()));
    localImageView.setScaleType(ImageView.ScaleType.FIT_START);
    paramRelativeLayout.addView(localImageView, paramContext);
  }
  
  private void d(Context paramContext, LinearLayout paramLinearLayout)
  {
    if (TextUtils.isEmpty(this.aA)) {
      return;
    }
    TextView localTextView = new TextView(paramContext);
    localTextView.setText(this.aA);
    localTextView.setTextSize(14.0F);
    if (this.aD == 1) {
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
  
  private void d(Context paramContext, RelativeLayout paramRelativeLayout)
  {
    RelativeLayout localRelativeLayout = new RelativeLayout(paramContext);
    Object localObject = new RelativeLayout.LayoutParams(-1, AIOUtils.b(45.0F, paramContext.getResources()));
    if (this.aD == 1)
    {
      ((RelativeLayout.LayoutParams)localObject).topMargin = AIOUtils.b(15.0F, paramContext.getResources());
      localRelativeLayout.setBackgroundDrawable(QWalletPicHelper.getNetDrawableForAIO(this.aO, new ColorDrawable(-43724)));
    }
    else
    {
      ((RelativeLayout.LayoutParams)localObject).leftMargin = AIOUtils.b(12.0F, paramContext.getResources());
      ((RelativeLayout.LayoutParams)localObject).rightMargin = AIOUtils.b(12.0F, paramContext.getResources());
      ((RelativeLayout.LayoutParams)localObject).bottomMargin = AIOUtils.b(12.0F, paramContext.getResources());
      localRelativeLayout.setBackgroundDrawable(QWalletPicHelper.getNetDrawableForAIO(this.aO, new ColorDrawable(-1)));
      a(localRelativeLayout, 8);
    }
    paramRelativeLayout.addView(localRelativeLayout, (ViewGroup.LayoutParams)localObject);
    localObject = a(paramContext);
    paramRelativeLayout = b(paramContext);
    RelativeLayout.LayoutParams localLayoutParams1 = new RelativeLayout.LayoutParams(-2, -2);
    int i = AIOUtils.b(17.0F, paramContext.getResources());
    RelativeLayout.LayoutParams localLayoutParams2 = new RelativeLayout.LayoutParams(i, i);
    localLayoutParams2.addRule(15);
    localLayoutParams2.leftMargin = AIOUtils.b(5.0F, paramContext.getResources());
    localLayoutParams2.rightMargin = AIOUtils.b(12.0F, paramContext.getResources());
    if (this.aD == 1)
    {
      localLayoutParams1.addRule(0, 2131446449);
      localLayoutParams1.addRule(15);
      localLayoutParams2.addRule(11);
      localRelativeLayout.addView((View)localObject, localLayoutParams1);
      localRelativeLayout.addView(paramRelativeLayout, localLayoutParams2);
      return;
    }
    paramContext = new RelativeLayout(paramContext);
    localLayoutParams2.addRule(1, 2131446450);
    paramContext.addView((View)localObject, localLayoutParams1);
    paramContext.addView(paramRelativeLayout, localLayoutParams2);
    localObject = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject).addRule(13);
    localRelativeLayout.addView(paramContext, (ViewGroup.LayoutParams)localObject);
    e(paramRelativeLayout);
  }
  
  private void e(Context paramContext, LinearLayout paramLinearLayout)
  {
    RelativeLayout localRelativeLayout = new RelativeLayout(paramContext);
    paramLinearLayout.addView(localRelativeLayout, new LinearLayout.LayoutParams(-1, -2));
    d(paramContext, localRelativeLayout);
    if (this.aD == 1) {
      c(paramContext, localRelativeLayout);
    }
  }
  
  public boolean a(EcshopConfBean.PromotionConfBean paramPromotionConfBean)
  {
    if (this.aD == 1) {
      paramPromotionConfBean = paramPromotionConfBean.f;
    } else {
      paramPromotionConfBean = paramPromotionConfBean.g;
    }
    if (paramPromotionConfBean.isEmpty()) {
      return false;
    }
    this.aF = ((String)paramPromotionConfBean.get("top_bg_url"));
    this.aG = ((String)paramPromotionConfBean.get("bottom_bg_url"));
    this.aM = ((String)paramPromotionConfBean.get("bottom_ani_url"));
    this.aN = ((String)paramPromotionConfBean.get("discount_bg_url"));
    this.aO = ((String)paramPromotionConfBean.get("detail_bg_url"));
    this.aP = ((String)paramPromotionConfBean.get("detail_logo_url"));
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
    this.ax = paramAbsStructMsgElement.ax;
    this.d = paramAbsStructMsgElement.d;
    this.e = paramAbsStructMsgElement.e;
    this.f = paramAbsStructMsgElement.f;
    this.g = paramAbsStructMsgElement.g;
    this.h = paramAbsStructMsgElement.h;
    this.i = paramAbsStructMsgElement.i;
    this.j = paramAbsStructMsgElement.j;
    this.k = paramAbsStructMsgElement.k;
    this.l = paramAbsStructMsgElement.l;
    this.m = paramAbsStructMsgElement.m;
    this.n = paramAbsStructMsgElement.n;
    this.o = paramAbsStructMsgElement.o;
    this.p = paramAbsStructMsgElement.p;
    this.q = paramAbsStructMsgElement.q;
    this.r = paramAbsStructMsgElement.r;
    this.s = paramAbsStructMsgElement.s;
    this.t = paramAbsStructMsgElement.t;
    this.u = paramAbsStructMsgElement.u;
    this.v = paramAbsStructMsgElement.v;
    this.w = paramAbsStructMsgElement.w;
    this.x = paramAbsStructMsgElement.x;
    this.y = paramAbsStructMsgElement.y;
    this.z = paramAbsStructMsgElement.z;
    this.A = paramAbsStructMsgElement.A;
    this.B = paramAbsStructMsgElement.B;
    this.C = paramAbsStructMsgElement.C;
    this.D = paramAbsStructMsgElement.D;
    this.E = paramAbsStructMsgElement.E;
    this.F = paramAbsStructMsgElement.F;
    this.G = paramAbsStructMsgElement.G;
    this.H = paramAbsStructMsgElement.H;
    this.I = paramAbsStructMsgElement.I;
    this.J = paramAbsStructMsgElement.J;
    this.K = paramAbsStructMsgElement.K;
    this.L = paramAbsStructMsgElement.L;
    this.M = paramAbsStructMsgElement.M;
    this.N = paramAbsStructMsgElement.N;
    this.O = paramAbsStructMsgElement.O;
    this.P = paramAbsStructMsgElement.P;
    this.Q = paramAbsStructMsgElement.Q;
    this.R = paramAbsStructMsgElement.R;
    this.S = paramAbsStructMsgElement.S;
    this.T = paramAbsStructMsgElement.T;
    this.U = paramAbsStructMsgElement.U;
    this.V = paramAbsStructMsgElement.V;
    this.W = paramAbsStructMsgElement.W;
    this.X = paramAbsStructMsgElement.X;
    this.Y = paramAbsStructMsgElement.Y;
    this.Z = paramAbsStructMsgElement.Z;
    this.aa = paramAbsStructMsgElement.aa;
    this.ab = paramAbsStructMsgElement.ab;
    this.ac = paramAbsStructMsgElement.ac;
    this.ad = paramAbsStructMsgElement.ad;
    this.ae = paramAbsStructMsgElement.ae;
    this.af = paramAbsStructMsgElement.af;
    this.ag = paramAbsStructMsgElement.ag;
    this.ah = paramAbsStructMsgElement.ah;
    this.ai = paramAbsStructMsgElement.ai;
    this.aj = paramAbsStructMsgElement.aj;
    this.ak = paramAbsStructMsgElement.ak;
    this.al = paramAbsStructMsgElement.al;
    this.am = paramAbsStructMsgElement.am;
    this.an = paramAbsStructMsgElement.an;
    this.ao = paramAbsStructMsgElement.ao;
    this.ap = paramAbsStructMsgElement.ap;
    this.aq = paramAbsStructMsgElement.aq;
    this.ar = paramAbsStructMsgElement.ar;
    this.as = paramAbsStructMsgElement.as;
    bool1 = bool2;
    if (f())
    {
      bool1 = bool2;
      if (a(paramPromotionConfBean)) {
        bool1 = true;
      }
    }
    return bool1;
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
      paramView = c(paramContext);
    }
    f();
    g();
    if (this.aD == 2) {
      a(paramContext, paramView);
    }
    a(paramContext, paramView, paramBundle);
    a(paramView, 14);
    return paramView;
  }
  
  protected int c()
  {
    return 102632;
  }
  
  public long e(View paramView)
  {
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(paramView, "translationX", new float[] { 0.0F, 20.0F, 0.0F });
    localObjectAnimator.setDuration(800L);
    localObjectAnimator.setRepeatCount(-1);
    localObjectAnimator.setRepeatMode(1);
    localObjectAnimator.start();
    paramView.addOnAttachStateChangeListener(new StructMsgItemLayoutPromotion.3(this, localObjectAnimator));
    return localObjectAnimator.getDuration() * localObjectAnimator.getRepeatCount();
  }
  
  public String e()
  {
    return "LayoutPromotion";
  }
  
  public boolean f()
  {
    for (;;)
    {
      int i;
      try
      {
        if (TextUtils.isEmpty(this.aj)) {
          return false;
        }
        Object localObject = new JSONObject(this.aj).optJSONObject("display_info");
        JSONObject localJSONObject = ((JSONObject)localObject).optJSONObject("basic_info");
        this.az = localJSONObject.optString("txt");
        this.aA = localJSONObject.optString("desc");
        localObject = ((JSONObject)localObject).optJSONArray("button_info");
        if (localObject != null)
        {
          i = 0;
          if (i < ((JSONArray)localObject).length())
          {
            localJSONObject = ((JSONArray)localObject).optJSONObject(i);
            if (localJSONObject == null) {
              break label215;
            }
            int j = localJSONObject.optInt("pos");
            if (j == 1)
            {
              this.aB = localJSONObject.optString("txt");
              break label215;
            }
            if (j != 2) {
              break label215;
            }
            this.aC = localJSONObject.optString("txt");
            if (!TextUtils.isEmpty(this.aC)) {
              break label215;
            }
            this.aC = "查看详情";
            break label215;
          }
        }
        this.aD = ((IEcshopRainViewApi)QRoute.api(IEcshopRainViewApi.class)).getMsgPromotion(this.aj);
        i = this.aD;
        if (i != -1) {
          return true;
        }
      }
      catch (Exception localException)
      {
        QLog.e("StructMsgItemLayoutPromotion", 1, localException, new Object[0]);
      }
      return false;
      label215:
      i += 1;
    }
  }
  
  public void g()
  {
    if ((TextUtils.isEmpty(this.aF)) && (TextUtils.isEmpty(this.aG)) && (TextUtils.isEmpty(this.aM)) && (TextUtils.isEmpty(this.aN)) && (TextUtils.isEmpty(this.aO)) && (TextUtils.isEmpty(this.aP))) {
      a(((IEcshopUtilApi)QRoute.api(IEcshopUtilApi.class)).getEcshopConfBean().m);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.view.StructMsgItemLayoutPromotion
 * JD-Core Version:    0.7.0.1
 */