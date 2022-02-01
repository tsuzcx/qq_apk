package com.tencent.mobileqq.medalwall;

import android.animation.ArgbEvaluator;
import android.animation.Keyframe;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MedalInfo;
import com.tencent.mobileqq.nearby.NearbyURLSafeUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.WeakReferenceHandler;
import java.io.File;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import mqq.app.AppRuntime;

public class MedalGuideView
  extends FrameLayout
  implements Handler.Callback, View.OnClickListener, Animation.AnimationListener
{
  private static final int[] I = { 2130847046, 2130847048, 2130847047 };
  private static final int[] J = { 2130847037, 2130847038, 2130847039 };
  private static final int[] K = { 2131167282, 2131167286, 2131167284 };
  private static final int[] L = { 2131167288, 2131167290, 2131167289 };
  private static final int[] M = { 2130847028, 2130847030, 2130847029 };
  private static final int[] N = { 2130847032, 2130847036, 2130847034 };
  private static final int[] O = { 2130847043, 2130847044, 2130847045 };
  private static java.lang.ref.WeakReference<MedalGuideView> P = null;
  ParticleSystem A = null;
  MedalGuideView.MedalPopupWindow B = null;
  java.lang.ref.WeakReference<View> C = null;
  java.lang.ref.WeakReference<QBaseActivity> D = null;
  MedalWallMng.NeedGuideMedal E = null;
  int F;
  ShareHelper G;
  List<mqq.util.WeakReference<ValueAnimator>> H;
  WeakReferenceHandler a;
  ViewGroup b;
  TextView c;
  URLImageView d;
  TextView e;
  Button f;
  Button g;
  ImageButton h;
  Drawable i;
  ColorDrawable j;
  boolean k = false;
  boolean l = true;
  ArgbEvaluator m = null;
  int n;
  boolean o = false;
  Rotate3dAnimation p;
  Rotate3dAnimation q;
  Rotate3dAnimation r;
  boolean s = false;
  int t;
  int u;
  int v;
  boolean w;
  String x;
  String y;
  String z;
  
  public MedalGuideView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public MedalGuideView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public MedalGuideView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    b();
  }
  
  public static void a()
  {
    Object localObject = P;
    if (localObject != null)
    {
      localObject = (MedalGuideView)((java.lang.ref.WeakReference)localObject).get();
      if (localObject != null) {
        ((MedalGuideView)localObject).d();
      }
      P.clear();
      P = null;
      if (QLog.isColorLevel()) {
        QLog.i("MedalWallMng", 2, String.format(Locale.getDefault(), "doCleanMedalGuide guide: %s", new Object[] { localObject }));
      }
    }
  }
  
  private void a(float paramFloat)
  {
    this.c.setAlpha(paramFloat);
    this.e.setAlpha(paramFloat);
    this.f.setAlpha(paramFloat);
    this.g.setAlpha(paramFloat);
    this.h.setAlpha(paramFloat);
  }
  
  private void a(View paramView)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if (this.G == null)
    {
      this.G = new ShareHelper(paramView.getContext(), localQQAppInterface);
      String str2 = ((MedalWallMng)localQQAppInterface.getManager(QQManagerFactory.MEDAL_WALL_MNG)).e();
      String str1 = ShareHelper.k;
      int i3 = AIOUtils.b(48.0F, getResources());
      paramView = this.E;
      long l1 = 0L;
      Object localObject2 = "";
      int i1;
      long l2;
      Object localObject1;
      Object localObject4;
      int i2;
      Object localObject5;
      if ((paramView != null) && (paramView.a != null))
      {
        i1 = this.E.a.iLevel;
        if (i1 != 1)
        {
          if (i1 != 2)
          {
            if (i1 != 3)
            {
              l1 = this.E.a.lObtainTimeLevel1;
              l2 = this.E.a.lSeqLevel1;
              paramView = "";
            }
            else
            {
              l1 = this.E.a.lObtainTimeLevel3;
              l2 = this.E.a.lSeqLevel3;
              paramView = "III";
            }
          }
          else
          {
            l1 = this.E.a.lObtainTimeLevel2;
            l2 = this.E.a.lSeqLevel2;
            paramView = "II";
          }
        }
        else
        {
          l1 = this.E.a.lObtainTimeLevel1;
          l2 = this.E.a.lSeqLevel1;
          paramView = "I";
        }
        paramView = String.format("%s %s", new Object[] { this.z, paramView });
        localObject1 = this.E.d;
        localObject4 = NearbyURLSafeUtil.b(localQQAppInterface.getCurrentAccountUin());
        i2 = this.E.a.iId;
        i1 = this.E.a.iLevel;
        localObject5 = localQQAppInterface.getCurrentNickname();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(i2);
        ((StringBuilder)localObject2).append("");
        localObject2 = ((StringBuilder)localObject2).toString();
        localObject6 = new StringBuilder();
        ((StringBuilder)localObject6).append(i1);
        ((StringBuilder)localObject6).append("");
        localObject2 = ShareHelper.a(new String[] { localObject2, ((StringBuilder)localObject6).toString(), localObject4, localObject5 });
      }
      else
      {
        l2 = 0L;
        localObject6 = "";
        paramView = (View)localObject6;
        localObject1 = paramView;
        localObject5 = localObject1;
        i1 = 0;
        i2 = 0;
        localObject4 = localObject1;
        localObject1 = paramView;
        paramView = (View)localObject6;
      }
      Object localObject6 = new StringBuilder(str2);
      ((StringBuilder)localObject6).append("&uincode=");
      ((StringBuilder)localObject6).append((String)localObject4);
      ((StringBuilder)localObject6).append("&id=");
      ((StringBuilder)localObject6).append(i2);
      ((StringBuilder)localObject6).append("&level=");
      ((StringBuilder)localObject6).append(i1);
      ((StringBuilder)localObject6).append("&nick=");
      ((StringBuilder)localObject6).append(URLEncoder.encode((String)localObject5));
      ((StringBuilder)localObject6).append("&en=");
      ((StringBuilder)localObject6).append((String)localObject2);
      ((StringBuilder)localObject6).append("&fromId=");
      ((StringBuilder)localObject6).append(1);
      localObject2 = this.E;
      Object localObject3;
      if ((localObject2 != null) && (((MedalWallMng.NeedGuideMedal)localObject2).a != null) && (this.E.a.iId == 0))
      {
        try
        {
          localObject2 = ShareHelper.a(Long.valueOf(l1 * 1000L)).substring(0, 4);
        }
        catch (Exception localException)
        {
          if (QLog.isColorLevel()) {
            QLog.i("ShareHelper", 2, localException.getMessage(), localException);
          }
          localObject3 = "0";
        }
        ((StringBuilder)localObject6).append("&year=");
        ((StringBuilder)localObject6).append((String)localObject3);
        ((StringBuilder)localObject6).append("&seq=");
        ((StringBuilder)localObject6).append(l2);
      }
      else
      {
        ((StringBuilder)localObject6).append("&time=");
        ((StringBuilder)localObject6).append(l1);
      }
      if (QLog.isColorLevel())
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("shareUrl:");
        ((StringBuilder)localObject3).append(((StringBuilder)localObject6).toString());
        QLog.i("ShareHelper", 4, ((StringBuilder)localObject3).toString());
      }
      this.G.a(paramView, str1, ((StringBuilder)localObject6).toString(), (String)localObject1, "QQ勋章墙", ShareHelper.a(this.d.getDrawable(), i3, i3));
    }
    this.G.a(new MedalGuideView.2(this));
    ThreadManager.post(new MedalGuideView.3(this, localQQAppInterface), 5, null, false);
  }
  
  public static void a(MedalWallMng.NeedGuideMedal paramNeedGuideMedal, QBaseActivity paramQBaseActivity, View paramView, int paramInt)
  {
    if (paramView == null) {
      return;
    }
    if (QLog.isDevelopLevel()) {
      QLog.i("MedalWallMng", 4, String.format(Locale.getDefault(), "showMedalGuide from: %d, view: %s, activity: %s, medal: %s", new Object[] { Integer.valueOf(paramInt), paramView, paramQBaseActivity, paramNeedGuideMedal }));
    }
    a();
    MedalGuideView localMedalGuideView = new MedalGuideView(paramQBaseActivity);
    MedalGuideView.MedalPopupWindow localMedalPopupWindow = new MedalGuideView.MedalPopupWindow(localMedalGuideView, -1, -1, true);
    localMedalGuideView.a(paramNeedGuideMedal, paramQBaseActivity, paramView, paramInt, localMedalPopupWindow);
    localMedalPopupWindow.setClippingEnabled(false);
    localMedalPopupWindow.setOutsideTouchable(true);
    localMedalPopupWindow.setBackgroundDrawable(new ColorDrawable(0));
    localMedalPopupWindow.showAtLocation(paramView, 0, 0, 0);
    ThreadManager.post(new MedalGuideView.10(paramInt), 5, null, false);
    P = new java.lang.ref.WeakReference(localMedalGuideView);
  }
  
  private void b()
  {
    this.a = new WeakReferenceHandler(Looper.getMainLooper(), this);
    this.H = new ArrayList();
    inflate(getContext(), 2131627522, this);
    this.b = ((ViewGroup)findViewById(2131431322));
    this.c = ((TextView)findViewById(2131447463));
    this.d = ((URLImageView)findViewById(2131438030));
    this.e = ((TextView)findViewById(2131438031));
    this.f = ((Button)findViewById(2131445753));
    this.f.setOnClickListener(this);
    this.g = ((Button)findViewById(2131432556));
    this.g.setOnClickListener(this);
    this.h = ((ImageButton)findViewById(2131430806));
    this.h.setOnClickListener(this);
    this.j = new ColorDrawable(0);
    try
    {
      DisplayMetrics localDisplayMetrics1 = getResources().getDisplayMetrics();
      DisplayMetrics localDisplayMetrics2 = FontSettingManager.systemMetrics;
      if (localDisplayMetrics1.density != localDisplayMetrics2.density)
      {
        float f2 = localDisplayMetrics2.density / localDisplayMetrics1.density;
        float f1 = f2;
        if (f2 > 1.0F) {
          f1 = 1.0F;
        }
        f1 = localDisplayMetrics2.density * f1;
        Object localObject = (LinearLayout.LayoutParams)this.d.getLayoutParams();
        int i1 = (int)(290.0F * f1);
        ((LinearLayout.LayoutParams)localObject).width = i1;
        ((LinearLayout.LayoutParams)localObject).height = i1;
        ((LinearLayout.LayoutParams)localObject).topMargin = ((int)(30.0F * f1));
        this.d.setLayoutParams((ViewGroup.LayoutParams)localObject);
        localObject = (LinearLayout.LayoutParams)this.e.getLayoutParams();
        ((LinearLayout.LayoutParams)localObject).topMargin = ((int)(20.0F * f1));
        this.e.setLayoutParams((ViewGroup.LayoutParams)localObject);
        localObject = (LinearLayout)findViewById(2131427526);
        LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)((LinearLayout)localObject).getLayoutParams();
        localLayoutParams.topMargin = ((int)(32.0F * f1));
        ((LinearLayout)localObject).setLayoutParams(localLayoutParams);
        localObject = (LinearLayout.LayoutParams)this.h.getLayoutParams();
        ((LinearLayout.LayoutParams)localObject).topMargin = ((int)(f1 * 40.0F));
        this.h.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
      if (QLog.isColorLevel()) {
        QLog.i("MedalWallMng", 2, String.format(Locale.getDefault(), "dm[%f, %d, %f], system[%f, %d, %f]", new Object[] { Float.valueOf(localDisplayMetrics1.density), Integer.valueOf(localDisplayMetrics1.densityDpi), Float.valueOf(localDisplayMetrics1.scaledDensity), Float.valueOf(localDisplayMetrics2.density), Integer.valueOf(localDisplayMetrics2.densityDpi), Float.valueOf(localDisplayMetrics2.scaledDensity) }));
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    this.m = new ArgbEvaluator();
    this.n = getResources().getColor(2131167281);
    this.d.setAlpha(0.0F);
    this.b.setBackgroundColor(0);
    a(0.0F);
  }
  
  private void c()
  {
    Resources localResources = getResources();
    this.c.setText(2131897018);
    Object localObject1 = this.c;
    Object localObject2 = I;
    int i1 = this.v;
    ((TextView)localObject1).setCompoundDrawablesWithIntrinsicBounds(localObject2[i1], 0, localObject2[i1], 0);
    this.c.setTextColor(localResources.getColor(K[this.v]));
    localObject1 = URLDrawable.URLDrawableOptions.obtain();
    i1 = localResources.getDimensionPixelSize(2131299071);
    ((URLDrawable.URLDrawableOptions)localObject1).mRequestWidth = i1;
    ((URLDrawable.URLDrawableOptions)localObject1).mRequestHeight = i1;
    localObject2 = this.i;
    ((URLDrawable.URLDrawableOptions)localObject1).mFailedDrawable = ((Drawable)localObject2);
    ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = ((Drawable)localObject2);
    if (FileUtils.fileExists(this.y)) {
      localObject1 = URLDrawable.getDrawable(new File(this.y), (URLDrawable.URLDrawableOptions)localObject1);
    } else if (!TextUtils.isEmpty(this.x)) {
      localObject1 = URLDrawable.getDrawable(this.x, (URLDrawable.URLDrawableOptions)localObject1);
    } else {
      localObject1 = null;
    }
    this.d.setImageDrawable((Drawable)localObject1);
    this.e.setText(this.z);
    if (this.w)
    {
      this.e.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
    }
    else
    {
      localObject1 = getResources().getDrawable(J[this.v]);
      ((Drawable)localObject1).setBounds(0, 0, ((Drawable)localObject1).getIntrinsicWidth(), ((Drawable)localObject1).getIntrinsicHeight());
      this.j.setBounds(0, 0, ((Drawable)localObject1).getIntrinsicWidth(), ((Drawable)localObject1).getIntrinsicHeight());
      this.e.setCompoundDrawables(this.j, null, (Drawable)localObject1, null);
    }
    this.e.setTextColor(localResources.getColor(K[this.v]));
    this.f.setBackgroundResource(M[this.v]);
    this.f.setTextColor(localResources.getColorStateList(L[this.v]));
    this.g.setBackgroundResource(M[this.v]);
    this.g.setTextColor(localResources.getColorStateList(L[this.v]));
    this.h.setImageResource(N[this.v]);
  }
  
  private void d()
  {
    if (QLog.isColorLevel()) {
      QLog.i("MedalWallMng", 2, "close");
    }
    this.k = true;
    this.a.removeMessages(3);
    Object localObject = this.A;
    if (localObject != null)
    {
      ((ParticleSystem)localObject).c();
      this.A = null;
    }
    localObject = this.D;
    if (localObject != null)
    {
      ((java.lang.ref.WeakReference)localObject).clear();
      this.D = null;
    }
    localObject = this.C;
    if (localObject != null)
    {
      ((java.lang.ref.WeakReference)localObject).clear();
      this.C = null;
    }
    this.E = null;
    localObject = this.B;
    if (localObject != null)
    {
      ((MedalGuideView.MedalPopupWindow)localObject).a();
      this.B = null;
    }
    localObject = this.H.iterator();
    while (((Iterator)localObject).hasNext())
    {
      mqq.util.WeakReference localWeakReference = (mqq.util.WeakReference)((Iterator)localObject).next();
      ValueAnimator localValueAnimator = (ValueAnimator)localWeakReference.get();
      if (localValueAnimator != null)
      {
        localValueAnimator.cancel();
        localValueAnimator.removeAllUpdateListeners();
        localWeakReference.clear();
      }
    }
  }
  
  public void a(MedalWallMng.NeedGuideMedal paramNeedGuideMedal, QBaseActivity paramQBaseActivity, View paramView, int paramInt, MedalGuideView.MedalPopupWindow paramMedalPopupWindow)
  {
    this.C = new java.lang.ref.WeakReference(paramView);
    this.D = new java.lang.ref.WeakReference(paramQBaseActivity);
    this.F = paramInt;
    this.E = paramNeedGuideMedal;
    this.B = paramMedalPopupWindow;
    this.G = null;
    paramQBaseActivity = this.B;
    if (paramQBaseActivity != null) {
      paramQBaseActivity.a(new MedalGuideView.9(this));
    }
    if ((paramNeedGuideMedal != null) && (paramNeedGuideMedal.a != null))
    {
      this.t = paramNeedGuideMedal.a.iId;
      if ((paramNeedGuideMedal.a.iLevel >= 1) && (paramNeedGuideMedal.a.iLevel <= 3))
      {
        this.v = (paramNeedGuideMedal.a.iLevel - 1);
        this.w = false;
      }
      else
      {
        this.v = 2;
        this.w = true;
      }
      this.u = paramNeedGuideMedal.a.iLevel;
      this.z = paramNeedGuideMedal.a.strName;
      this.y = paramNeedGuideMedal.c;
      this.x = paramNeedGuideMedal.b;
    }
    else
    {
      this.t = 0;
      this.v = 2;
      this.z = "";
      this.y = null;
      this.x = null;
      this.w = false;
      this.u = 1;
    }
    this.i = new ColorDrawable(0);
    c();
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    if (this.l)
    {
      this.l = false;
      this.s = false;
      this.a.sendEmptyMessage(1);
      this.a.sendEmptyMessageDelayed(5, 1600L);
    }
    ParticleSystem localParticleSystem = this.A;
    if (localParticleSystem != null) {
      localParticleSystem.a(paramCanvas, 1);
    }
    super.dispatchDraw(paramCanvas);
    localParticleSystem = this.A;
    if (localParticleSystem != null) {
      localParticleSystem.a(paramCanvas, 2);
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int i1 = paramMessage.what;
    if (i1 != 1) {
      if (i1 != 2) {
        if (i1 != 3) {
          if (i1 != 4) {
            if (i1 == 5) {}
          }
        }
      }
    }
    for (;;)
    {
      return true;
      this.s = true;
      continue;
      if (QLog.isDevelopLevel()) {
        QLog.i("MedalWallMng", 4, "MSG_START_3D_ROTATE");
      }
      float f1 = this.d.getWidth() / 2;
      float f2 = this.d.getHeight() / 2;
      this.p = new Rotate3dAnimation(0.0F, -15.599999F, f1, f2, 0.0F, true);
      this.p.setDuration(260L);
      this.p.setFillAfter(true);
      this.p.setAnimationListener(this);
      this.q = new Rotate3dAnimation(-15.599999F, 9.75F, f1, f2, 0.0F, false);
      this.q.setDuration(260L);
      this.q.setFillAfter(true);
      this.q.setAnimationListener(this);
      this.r = new Rotate3dAnimation(9.75F, 0.0F, f1, f2, 0.0F, true);
      this.r.setDuration(300L);
      this.r.setFillAfter(true);
      this.r.setAnimationListener(this);
      this.d.startAnimation(this.p);
      this.A = new ParticleSystem(this, 2, 100, O);
      this.A.a(getWidth(), getHeight());
      continue;
      d();
      continue;
      paramMessage = ValueAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[] { PropertyValuesHolder.ofKeyframe("alpha", new Keyframe[] { Keyframe.ofFloat(0.0F, 1.0F), Keyframe.ofFloat(0.2666667F, 0.0F), Keyframe.ofFloat(1.0F, 0.0F) }) });
      this.H.add(new mqq.util.WeakReference(paramMessage));
      paramMessage.addUpdateListener(new MedalGuideView.6(this));
      long l1 = 600.0F;
      paramMessage.setDuration(l1);
      paramMessage.start();
      paramMessage = ValueAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[] { PropertyValuesHolder.ofKeyframe("bgColor", new Keyframe[] { Keyframe.ofFloat(0.0F, 0.0F), Keyframe.ofFloat(0.2666667F, 0.0F), Keyframe.ofFloat(0.6666667F, 1.0F), Keyframe.ofFloat(1.0F, 1.0F) }) });
      this.H.add(new mqq.util.WeakReference(paramMessage));
      paramMessage.addUpdateListener(new MedalGuideView.7(this));
      paramMessage.setDuration(l1);
      paramMessage.start();
      paramMessage = this.C;
      if (paramMessage == null) {
        paramMessage = null;
      } else {
        paramMessage = (View)paramMessage.get();
      }
      i1 = Math.max(this.d.getWidth(), this.d.getHeight());
      if (paramMessage != null)
      {
        localObject1 = new int[2];
        localObject2 = new int[2];
        paramMessage.getLocationOnScreen((int[])localObject1);
        this.d.getLocationOnScreen((int[])localObject2);
        int i2 = Math.min(paramMessage.getWidth(), paramMessage.getHeight());
        if ((i2 != 0) && (i1 != 0)) {
          f1 = i2 / i1;
        } else {
          f1 = 0.2F;
        }
        int i3 = localObject1[0];
        int i4 = i2 / 2;
        localObject1[0] = (i3 + i4);
        localObject1[1] += i4;
        i3 = localObject2[0];
        i4 = i1 / 2;
        localObject2[0] = (i3 + i4);
        localObject2[1] += i4;
        f3 = localObject1[0] - localObject2[0];
        f2 = localObject1[1] - localObject2[1];
        if (QLog.isDevelopLevel())
        {
          paramMessage = new int[2];
          this.d.getLocationInWindow(paramMessage);
          f4 = this.d.getPivotX();
          f5 = this.d.getPivotY();
          QLog.i("MedalWallMng", 4, String.format(Locale.getDefault(), "icon end anim target[%d, %d], cur[%d, %d], size: %d, curSize: %d curWindowLoc[%d,%d] pivot[%f, %f]", new Object[] { Integer.valueOf(localObject1[0]), Integer.valueOf(localObject1[1]), Integer.valueOf(localObject2[0]), Integer.valueOf(localObject2[1]), Integer.valueOf(i2), Integer.valueOf(i1), Integer.valueOf(paramMessage[0]), Integer.valueOf(paramMessage[1]), Float.valueOf(f4), Float.valueOf(f5) }));
        }
      }
      else
      {
        f2 = -this.d.getX();
        f1 = i1 / 2.0F;
        f3 = f2 - f1;
        f2 = -this.d.getY() - f1;
        f1 = 0.2F;
      }
      if (QLog.isDevelopLevel()) {
        QLog.i("MedalWallMng", 4, String.format(Locale.getDefault(), "icon end anim [scale: %f, transX: %f, transY: %f]  [%f, %f]", new Object[] { Float.valueOf(f1), Float.valueOf(f3), Float.valueOf(f2), Float.valueOf(this.d.getX()), Float.valueOf(this.d.getY()) }));
      }
      paramMessage = PropertyValuesHolder.ofKeyframe("alpha", new Keyframe[] { Keyframe.ofFloat(0.0F, 1.0F), Keyframe.ofFloat(0.8666667F, 1.0F), Keyframe.ofFloat(1.0F, 0.0F) });
      Object localObject1 = PropertyValuesHolder.ofKeyframe("scale", new Keyframe[] { Keyframe.ofFloat(0.0F, 1.0F), Keyframe.ofFloat(0.2666667F, 1.0F), Keyframe.ofFloat(0.9F, f1), Keyframe.ofFloat(1.0F, f1) });
      Object localObject2 = Keyframe.ofFloat(0.0F, 0.0F);
      Keyframe localKeyframe1 = Keyframe.ofFloat(0.2666667F, 0.0F);
      localKeyframe1.setInterpolator(new AccelerateDecelerateInterpolator());
      localObject2 = PropertyValuesHolder.ofKeyframe("translationX", new Keyframe[] { localObject2, localKeyframe1, Keyframe.ofFloat(0.9F, f3), Keyframe.ofFloat(1.0F, f3) });
      localKeyframe1 = Keyframe.ofFloat(0.0F, 0.0F);
      Keyframe localKeyframe2 = Keyframe.ofFloat(0.2666667F, 0.0F);
      localKeyframe2.setInterpolator(new AccelerateDecelerateInterpolator());
      paramMessage = ValueAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[] { paramMessage, localObject1, localObject2, PropertyValuesHolder.ofKeyframe("translationY", new Keyframe[] { localKeyframe1, localKeyframe2, Keyframe.ofFloat(0.9F, f2), Keyframe.ofFloat(1.0F, f2) }) });
      this.H.add(new mqq.util.WeakReference(paramMessage));
      paramMessage.addUpdateListener(new MedalGuideView.8(this));
      paramMessage.setDuration(l1);
      paramMessage.start();
      this.a.sendEmptyMessageDelayed(3, l1 + 200L);
      continue;
      if (QLog.isDevelopLevel()) {
        QLog.i("MedalWallMng", 4, "MSG_START_ENTER_ANIM");
      }
      this.o = false;
      paramMessage = PropertyValuesHolder.ofKeyframe("alpha", new Keyframe[] { Keyframe.ofFloat(0.0F, 0.0F), Keyframe.ofFloat(0.05714286F, 0.0F), Keyframe.ofFloat(0.2F, 1.0F), Keyframe.ofFloat(1.0F, 1.0F) });
      f1 = this.d.getY();
      f2 = this.d.getHeight();
      float f4 = this.e.getY();
      float f5 = this.e.getHeight();
      float f3 = -this.d.getY();
      f2 = f4 + f5 - (f1 + f2);
      f1 = f2;
      if (f2 < 0.0F) {
        f1 = this.d.getHeight() * 0.3F;
      }
      paramMessage = ValueAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[] { paramMessage, PropertyValuesHolder.ofKeyframe("translate", new Keyframe[] { Keyframe.ofFloat(0.0F, f3), Keyframe.ofFloat(0.7714286F, f1), Keyframe.ofFloat(1.0F, 0.0F) }) });
      this.H.add(new mqq.util.WeakReference(paramMessage));
      paramMessage.addUpdateListener(new MedalGuideView.4(this));
      paramMessage.setDuration(700L);
      paramMessage.start();
      paramMessage = ValueAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[] { PropertyValuesHolder.ofKeyframe("alpha", new Keyframe[] { Keyframe.ofFloat(0.0F, 0.0F), Keyframe.ofFloat(0.08571429F, 0.0F), Keyframe.ofFloat(1.0F, 1.0F) }) });
      this.H.add(new mqq.util.WeakReference(paramMessage));
      paramMessage.addUpdateListener(new MedalGuideView.5(this));
      paramMessage.setDuration(700L);
      paramMessage.start();
    }
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (paramAnimation == this.p)
    {
      this.d.startAnimation(this.q);
      return;
    }
    if (paramAnimation == this.q)
    {
      this.d.startAnimation(this.r);
      return;
    }
    if (paramAnimation == this.r)
    {
      this.s = true;
      this.a.removeMessages(5);
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
  
  public void onClick(View paramView)
  {
    int i1 = paramView.getId();
    if (i1 != 2131430806)
    {
      if (i1 != 2131432556)
      {
        if (i1 == 2131445753) {
          a(paramView);
        }
      }
      else
      {
        Object localObject = this.D;
        if (localObject == null) {
          localObject = null;
        } else {
          localObject = (QBaseActivity)((java.lang.ref.WeakReference)localObject).get();
        }
        if (localObject != null)
        {
          String str = ((MedalWallMng)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getManager(QQManagerFactory.MEDAL_WALL_MNG)).a(true, ((QBaseActivity)localObject).getAppRuntime().getCurrentAccountUin(), MedalWallMng.f);
          str = String.format(Locale.getDefault(), "%s&openMedalId=%s&openMedalLevel=%s", new Object[] { str, Integer.valueOf(this.t), Integer.valueOf(this.u) });
          Intent localIntent = new Intent((Context)localObject, QQBrowserActivity.class);
          localIntent.putExtra("url", str);
          ((QBaseActivity)localObject).startActivity(localIntent);
          if (QLog.isColorLevel()) {
            QLog.i("MedalWallMng", 2, String.format(Locale.getDefault(), "enter medal url: %s", new Object[] { str }));
          }
          ThreadManager.post(new MedalGuideView.1(this), 5, null, false);
        }
        d();
      }
    }
    else if (!this.s)
    {
      if (QLog.isColorLevel()) {
        QLog.i("MedalWallMng", 2, "close when enter animation is not finished yet!");
      }
    }
    else if (!this.a.hasMessages(2)) {
      this.a.sendEmptyMessage(2);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.medalwall.MedalGuideView
 * JD-Core Version:    0.7.0.1
 */