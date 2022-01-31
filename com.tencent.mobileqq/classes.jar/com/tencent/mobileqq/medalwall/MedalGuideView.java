package com.tencent.mobileqq.medalwall;

import actn;
import ajwe;
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
import asfp;
import asfq;
import asfr;
import asfs;
import asft;
import asfu;
import asfv;
import asfw;
import asfy;
import asfz;
import asgb;
import asgc;
import atbn;
import bbdj;
import bfnk;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MedalInfo;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

public class MedalGuideView
  extends FrameLayout
  implements Handler.Callback, View.OnClickListener, Animation.AnimationListener
{
  private static final int[] jdField_a_of_type_ArrayOfInt = { 2130844578, 2130844580, 2130844579 };
  private static final int[] jdField_b_of_type_ArrayOfInt = { 2130844569, 2130844570, 2130844571 };
  private static java.lang.ref.WeakReference<MedalGuideView> jdField_c_of_type_JavaLangRefWeakReference;
  private static final int[] jdField_c_of_type_ArrayOfInt = { 2131166269, 2131166273, 2131166271 };
  private static final int[] jdField_d_of_type_ArrayOfInt = { 2131166275, 2131166277, 2131166276 };
  private static final int[] jdField_e_of_type_ArrayOfInt = { 2130844560, 2130844562, 2130844561 };
  private static final int[] f = { 2130844564, 2130844568, 2130844566 };
  private static final int[] g = { 2130844575, 2130844576, 2130844577 };
  public int a;
  public ArgbEvaluator a;
  ColorDrawable jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
  Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  public ViewGroup a;
  Button jdField_a_of_type_AndroidWidgetButton;
  public ImageButton a;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  asfw jdField_a_of_type_Asfw = null;
  asfy jdField_a_of_type_Asfy = null;
  public asfz a;
  asgb jdField_a_of_type_Asgb;
  asgc jdField_a_of_type_Asgc;
  public bfnk a;
  public URLImageView a;
  String jdField_a_of_type_JavaLangString;
  java.lang.ref.WeakReference<View> jdField_a_of_type_JavaLangRefWeakReference = null;
  List<mqq.util.WeakReference<ValueAnimator>> jdField_a_of_type_JavaUtilList;
  public boolean a;
  int jdField_b_of_type_Int;
  Button jdField_b_of_type_AndroidWidgetButton;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  asgb jdField_b_of_type_Asgb;
  String jdField_b_of_type_JavaLangString;
  java.lang.ref.WeakReference<BaseActivity> jdField_b_of_type_JavaLangRefWeakReference = null;
  boolean jdField_b_of_type_Boolean = true;
  int jdField_c_of_type_Int;
  asgb jdField_c_of_type_Asgb;
  String jdField_c_of_type_JavaLangString;
  public boolean c;
  int jdField_d_of_type_Int;
  public boolean d;
  int jdField_e_of_type_Int;
  boolean jdField_e_of_type_Boolean;
  
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
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidAnimationArgbEvaluator = null;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_a_of_type_Asfz = null;
    b();
  }
  
  public static void a()
  {
    if (jdField_c_of_type_JavaLangRefWeakReference != null)
    {
      MedalGuideView localMedalGuideView = (MedalGuideView)jdField_c_of_type_JavaLangRefWeakReference.get();
      if (localMedalGuideView != null) {
        localMedalGuideView.d();
      }
      jdField_c_of_type_JavaLangRefWeakReference.clear();
      jdField_c_of_type_JavaLangRefWeakReference = null;
      if (QLog.isColorLevel()) {
        QLog.i("MedalWallMng", 2, String.format(Locale.getDefault(), "doCleanMedalGuide guide: %s", new Object[] { localMedalGuideView }));
      }
    }
  }
  
  private void a(float paramFloat)
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setAlpha(paramFloat);
    this.jdField_b_of_type_AndroidWidgetTextView.setAlpha(paramFloat);
    this.jdField_a_of_type_AndroidWidgetButton.setAlpha(paramFloat);
    this.jdField_b_of_type_AndroidWidgetButton.setAlpha(paramFloat);
    this.jdField_a_of_type_AndroidWidgetImageButton.setAlpha(paramFloat);
  }
  
  private void a(View paramView)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    Object localObject;
    String str6;
    int k;
    String str3;
    long l2;
    long l1;
    String str1;
    String str4;
    int j;
    int i;
    String str2;
    if (this.jdField_a_of_type_Asgc == null)
    {
      this.jdField_a_of_type_Asgc = new asgc(paramView.getContext(), localQQAppInterface);
      localObject = ((MedalWallMng)localQQAppInterface.getManager(250)).a();
      str6 = asgc.g;
      k = actn.a(48.0F, getResources());
      str3 = "";
      paramView = "";
      if ((this.jdField_a_of_type_Asfy == null) || (this.jdField_a_of_type_Asfy.jdField_a_of_type_ComTencentMobileqqDataMedalInfo == null)) {
        break label707;
      }
      switch (this.jdField_a_of_type_Asfy.jdField_a_of_type_ComTencentMobileqqDataMedalInfo.iLevel)
      {
      default: 
        l2 = this.jdField_a_of_type_Asfy.jdField_a_of_type_ComTencentMobileqqDataMedalInfo.lObtainTimeLevel1;
        l1 = this.jdField_a_of_type_Asfy.jdField_a_of_type_ComTencentMobileqqDataMedalInfo.lSeqLevel1;
        paramView = String.format("%s %s", new Object[] { this.jdField_c_of_type_JavaLangString, paramView });
        str1 = this.jdField_a_of_type_Asfy.jdField_c_of_type_JavaLangString;
        str4 = atbn.a(localQQAppInterface.getCurrentAccountUin());
        j = this.jdField_a_of_type_Asfy.jdField_a_of_type_ComTencentMobileqqDataMedalInfo.iId;
        i = this.jdField_a_of_type_Asfy.jdField_a_of_type_ComTencentMobileqqDataMedalInfo.iLevel;
        str3 = localQQAppInterface.getCurrentNickname();
        str2 = asgc.a(new String[] { j + "", i + "", str4, str3 });
      }
    }
    for (;;)
    {
      localObject = new StringBuilder((String)localObject);
      ((StringBuilder)localObject).append("&uincode=").append(str4);
      ((StringBuilder)localObject).append("&id=").append(j);
      ((StringBuilder)localObject).append("&level=").append(i);
      ((StringBuilder)localObject).append("&nick=").append(URLEncoder.encode(str3));
      ((StringBuilder)localObject).append("&en=").append(str2);
      ((StringBuilder)localObject).append("&fromId=").append(1);
      if ((this.jdField_a_of_type_Asfy != null) && (this.jdField_a_of_type_Asfy.jdField_a_of_type_ComTencentMobileqqDataMedalInfo != null) && (this.jdField_a_of_type_Asfy.jdField_a_of_type_ComTencentMobileqqDataMedalInfo.iId == 0)) {
        str3 = "0";
      }
      for (;;)
      {
        try
        {
          str2 = asgc.a(Long.valueOf(l2 * 1000L)).substring(0, 4);
          ((StringBuilder)localObject).append("&year=").append(str2);
          ((StringBuilder)localObject).append("&seq=").append(l1);
          if (QLog.isColorLevel()) {
            QLog.i("ShareHelper", 4, "shareUrl:" + ((StringBuilder)localObject).toString());
          }
          this.jdField_a_of_type_Asgc.a(paramView, str6, ((StringBuilder)localObject).toString(), str1, "QQ勋章墙", asgc.a(this.jdField_a_of_type_ComTencentImageURLImageView.getDrawable(), k, k));
          this.jdField_a_of_type_Asgc.a(new asfp(this));
          ThreadManager.post(new MedalGuideView.3(this, localQQAppInterface), 5, null, false);
          return;
          l2 = this.jdField_a_of_type_Asfy.jdField_a_of_type_ComTencentMobileqqDataMedalInfo.lObtainTimeLevel1;
          l1 = this.jdField_a_of_type_Asfy.jdField_a_of_type_ComTencentMobileqqDataMedalInfo.lSeqLevel1;
          paramView = "I";
          break;
          l2 = this.jdField_a_of_type_Asfy.jdField_a_of_type_ComTencentMobileqqDataMedalInfo.lObtainTimeLevel2;
          l1 = this.jdField_a_of_type_Asfy.jdField_a_of_type_ComTencentMobileqqDataMedalInfo.lSeqLevel2;
          paramView = "II";
          break;
          l2 = this.jdField_a_of_type_Asfy.jdField_a_of_type_ComTencentMobileqqDataMedalInfo.lObtainTimeLevel3;
          l1 = this.jdField_a_of_type_Asfy.jdField_a_of_type_ComTencentMobileqqDataMedalInfo.lSeqLevel3;
          paramView = "III";
        }
        catch (Exception localException)
        {
          str2 = str3;
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.i("ShareHelper", 2, localException.getMessage(), localException);
          str2 = str3;
          continue;
        }
        ((StringBuilder)localObject).append("&time=").append(l2);
      }
      label707:
      str2 = "";
      paramView = "";
      i = 0;
      str1 = "";
      l2 = 0L;
      l1 = 0L;
      String str5 = "";
      j = 0;
    }
  }
  
  public static void a(asfy paramasfy, BaseActivity paramBaseActivity, View paramView, int paramInt)
  {
    if (paramView == null) {
      return;
    }
    if (QLog.isDevelopLevel()) {
      QLog.i("MedalWallMng", 4, String.format(Locale.getDefault(), "showMedalGuide from: %d, view: %s, activity: %s, medal: %s", new Object[] { Integer.valueOf(paramInt), paramView, paramBaseActivity, paramasfy }));
    }
    a();
    MedalGuideView localMedalGuideView = new MedalGuideView(paramBaseActivity);
    asfw localasfw = new asfw(localMedalGuideView, -1, -1, true);
    localMedalGuideView.a(paramasfy, paramBaseActivity, paramView, paramInt, localasfw);
    localasfw.setClippingEnabled(false);
    localasfw.setOutsideTouchable(true);
    localasfw.setBackgroundDrawable(new ColorDrawable(0));
    localasfw.showAtLocation(paramView, 0, 0, 0);
    ThreadManager.post(new MedalGuideView.10(paramInt), 5, null, false);
    jdField_c_of_type_JavaLangRefWeakReference = new java.lang.ref.WeakReference(localMedalGuideView);
  }
  
  private void b()
  {
    this.jdField_a_of_type_Bfnk = new bfnk(Looper.getMainLooper(), this);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    inflate(getContext(), 2131560838, this);
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)findViewById(2131364692));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131377350));
    this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)findViewById(2131369848));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131369849));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131376003));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)findViewById(2131365698));
    this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)findViewById(2131364259));
    this.jdField_a_of_type_AndroidWidgetImageButton.setOnClickListener(this);
    this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable = new ColorDrawable(0);
    try
    {
      DisplayMetrics localDisplayMetrics1 = getResources().getDisplayMetrics();
      DisplayMetrics localDisplayMetrics2 = ajwe.a;
      if (localDisplayMetrics1.density != localDisplayMetrics2.density)
      {
        float f2 = localDisplayMetrics2.density / localDisplayMetrics1.density;
        float f1 = f2;
        if (f2 > 1.0F) {
          f1 = 1.0F;
        }
        f1 = localDisplayMetrics2.density * f1;
        Object localObject = (LinearLayout.LayoutParams)this.jdField_a_of_type_ComTencentImageURLImageView.getLayoutParams();
        ((LinearLayout.LayoutParams)localObject).width = ((int)(290.0F * f1));
        ((LinearLayout.LayoutParams)localObject).height = ((int)(290.0F * f1));
        ((LinearLayout.LayoutParams)localObject).topMargin = ((int)(30.0F * f1));
        this.jdField_a_of_type_ComTencentImageURLImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
        localObject = (LinearLayout.LayoutParams)this.jdField_b_of_type_AndroidWidgetTextView.getLayoutParams();
        ((LinearLayout.LayoutParams)localObject).topMargin = ((int)(20.0F * f1));
        this.jdField_b_of_type_AndroidWidgetTextView.setLayoutParams((ViewGroup.LayoutParams)localObject);
        localObject = (LinearLayout)findViewById(2131361902);
        LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)((LinearLayout)localObject).getLayoutParams();
        localLayoutParams.topMargin = ((int)(32.0F * f1));
        ((LinearLayout)localObject).setLayoutParams(localLayoutParams);
        localObject = (LinearLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetImageButton.getLayoutParams();
        ((LinearLayout.LayoutParams)localObject).topMargin = ((int)(40.0F * f1));
        this.jdField_a_of_type_AndroidWidgetImageButton.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
      if (QLog.isColorLevel()) {
        QLog.i("MedalWallMng", 2, String.format(Locale.getDefault(), "dm[%f, %d, %f], system[%f, %d, %f]", new Object[] { Float.valueOf(localDisplayMetrics1.density), Integer.valueOf(localDisplayMetrics1.densityDpi), Float.valueOf(localDisplayMetrics1.scaledDensity), Float.valueOf(localDisplayMetrics2.density), Integer.valueOf(localDisplayMetrics2.densityDpi), Float.valueOf(localDisplayMetrics2.scaledDensity) }));
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
    this.jdField_a_of_type_AndroidAnimationArgbEvaluator = new ArgbEvaluator();
    this.jdField_a_of_type_Int = getResources().getColor(2131166268);
    this.jdField_a_of_type_ComTencentImageURLImageView.setAlpha(0.0F);
    this.jdField_a_of_type_AndroidViewViewGroup.setBackgroundColor(0);
    a(0.0F);
  }
  
  private void c()
  {
    Resources localResources = getResources();
    this.jdField_a_of_type_AndroidWidgetTextView.setText(2131699117);
    this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(jdField_a_of_type_ArrayOfInt[this.jdField_d_of_type_Int], 0, jdField_a_of_type_ArrayOfInt[this.jdField_d_of_type_Int], 0);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(localResources.getColor(jdField_c_of_type_ArrayOfInt[this.jdField_d_of_type_Int]));
    Object localObject = URLDrawable.URLDrawableOptions.obtain();
    int i = localResources.getDimensionPixelSize(2131298090);
    ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = i;
    ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = i;
    ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
    ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
    if (bbdj.a(this.jdField_b_of_type_JavaLangString)) {
      localObject = URLDrawable.getDrawable(new File(this.jdField_b_of_type_JavaLangString), (URLDrawable.URLDrawableOptions)localObject);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject);
      this.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_c_of_type_JavaLangString);
      if (this.jdField_e_of_type_Boolean) {
        this.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
      }
      for (;;)
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(localResources.getColor(jdField_c_of_type_ArrayOfInt[this.jdField_d_of_type_Int]));
        this.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(jdField_e_of_type_ArrayOfInt[this.jdField_d_of_type_Int]);
        this.jdField_a_of_type_AndroidWidgetButton.setTextColor(localResources.getColorStateList(jdField_d_of_type_ArrayOfInt[this.jdField_d_of_type_Int]));
        this.jdField_b_of_type_AndroidWidgetButton.setBackgroundResource(jdField_e_of_type_ArrayOfInt[this.jdField_d_of_type_Int]);
        this.jdField_b_of_type_AndroidWidgetButton.setTextColor(localResources.getColorStateList(jdField_d_of_type_ArrayOfInt[this.jdField_d_of_type_Int]));
        this.jdField_a_of_type_AndroidWidgetImageButton.setImageResource(f[this.jdField_d_of_type_Int]);
        return;
        if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
          break label349;
        }
        localObject = URLDrawable.getDrawable(this.jdField_a_of_type_JavaLangString, (URLDrawable.URLDrawableOptions)localObject);
        break;
        localObject = getResources().getDrawable(jdField_b_of_type_ArrayOfInt[this.jdField_d_of_type_Int]);
        ((Drawable)localObject).setBounds(0, 0, ((Drawable)localObject).getIntrinsicWidth(), ((Drawable)localObject).getIntrinsicHeight());
        this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable.setBounds(0, 0, ((Drawable)localObject).getIntrinsicWidth(), ((Drawable)localObject).getIntrinsicHeight());
        this.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawables(this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable, null, (Drawable)localObject, null);
      }
      label349:
      localObject = null;
    }
  }
  
  private void d()
  {
    if (QLog.isColorLevel()) {
      QLog.i("MedalWallMng", 2, "close");
    }
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Bfnk.removeMessages(3);
    if (this.jdField_a_of_type_Asfz != null)
    {
      this.jdField_a_of_type_Asfz.c();
      this.jdField_a_of_type_Asfz = null;
    }
    if (this.jdField_b_of_type_JavaLangRefWeakReference != null)
    {
      this.jdField_b_of_type_JavaLangRefWeakReference.clear();
      this.jdField_b_of_type_JavaLangRefWeakReference = null;
    }
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null)
    {
      this.jdField_a_of_type_JavaLangRefWeakReference.clear();
      this.jdField_a_of_type_JavaLangRefWeakReference = null;
    }
    this.jdField_a_of_type_Asfy = null;
    if (this.jdField_a_of_type_Asfw != null)
    {
      this.jdField_a_of_type_Asfw.a();
      this.jdField_a_of_type_Asfw = null;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      mqq.util.WeakReference localWeakReference = (mqq.util.WeakReference)localIterator.next();
      ValueAnimator localValueAnimator = (ValueAnimator)localWeakReference.get();
      if (localValueAnimator != null)
      {
        localValueAnimator.cancel();
        localValueAnimator.removeAllUpdateListeners();
        localWeakReference.clear();
      }
    }
  }
  
  public void a(asfy paramasfy, BaseActivity paramBaseActivity, View paramView, int paramInt, asfw paramasfw)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new java.lang.ref.WeakReference(paramView);
    this.jdField_b_of_type_JavaLangRefWeakReference = new java.lang.ref.WeakReference(paramBaseActivity);
    this.jdField_e_of_type_Int = paramInt;
    this.jdField_a_of_type_Asfy = paramasfy;
    this.jdField_a_of_type_Asfw = paramasfw;
    this.jdField_a_of_type_Asgc = null;
    if (this.jdField_a_of_type_Asfw != null) {
      this.jdField_a_of_type_Asfw.a(new asfv(this));
    }
    if ((paramasfy != null) && (paramasfy.jdField_a_of_type_ComTencentMobileqqDataMedalInfo != null))
    {
      this.jdField_b_of_type_Int = paramasfy.jdField_a_of_type_ComTencentMobileqqDataMedalInfo.iId;
      if ((paramasfy.jdField_a_of_type_ComTencentMobileqqDataMedalInfo.iLevel >= 1) && (paramasfy.jdField_a_of_type_ComTencentMobileqqDataMedalInfo.iLevel <= 3))
      {
        this.jdField_d_of_type_Int = (paramasfy.jdField_a_of_type_ComTencentMobileqqDataMedalInfo.iLevel - 1);
        this.jdField_e_of_type_Boolean = false;
        this.jdField_c_of_type_Int = paramasfy.jdField_a_of_type_ComTencentMobileqqDataMedalInfo.iLevel;
        this.jdField_c_of_type_JavaLangString = paramasfy.jdField_a_of_type_ComTencentMobileqqDataMedalInfo.strName;
        this.jdField_b_of_type_JavaLangString = paramasfy.jdField_b_of_type_JavaLangString;
        this.jdField_a_of_type_JavaLangString = paramasfy.jdField_a_of_type_JavaLangString;
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = new ColorDrawable(0);
      c();
      return;
      this.jdField_d_of_type_Int = 2;
      this.jdField_e_of_type_Boolean = true;
      break;
      this.jdField_b_of_type_Int = 0;
      this.jdField_d_of_type_Int = 2;
      this.jdField_c_of_type_JavaLangString = "";
      this.jdField_b_of_type_JavaLangString = null;
      this.jdField_a_of_type_JavaLangString = null;
      this.jdField_e_of_type_Boolean = false;
      this.jdField_c_of_type_Int = 1;
    }
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    if (this.jdField_b_of_type_Boolean)
    {
      this.jdField_b_of_type_Boolean = false;
      this.jdField_d_of_type_Boolean = false;
      this.jdField_a_of_type_Bfnk.sendEmptyMessage(1);
      this.jdField_a_of_type_Bfnk.sendEmptyMessageDelayed(5, 1600L);
    }
    if (this.jdField_a_of_type_Asfz != null) {
      this.jdField_a_of_type_Asfz.a(paramCanvas, 1);
    }
    super.dispatchDraw(paramCanvas);
    if (this.jdField_a_of_type_Asfz != null) {
      this.jdField_a_of_type_Asfz.a(paramCanvas, 2);
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return true;
      if (QLog.isDevelopLevel()) {
        QLog.i("MedalWallMng", 4, "MSG_START_ENTER_ANIM");
      }
      this.jdField_c_of_type_Boolean = false;
      paramMessage = PropertyValuesHolder.ofKeyframe("alpha", new Keyframe[] { Keyframe.ofFloat(0.0F, 0.0F), Keyframe.ofFloat(0.05714286F, 0.0F), Keyframe.ofFloat(0.2F, 1.0F), Keyframe.ofFloat(1.0F, 1.0F) });
      float f1 = this.jdField_a_of_type_ComTencentImageURLImageView.getY();
      float f2 = this.jdField_a_of_type_ComTencentImageURLImageView.getHeight();
      float f4 = this.jdField_b_of_type_AndroidWidgetTextView.getY();
      float f5 = this.jdField_b_of_type_AndroidWidgetTextView.getHeight();
      float f3 = -this.jdField_a_of_type_ComTencentImageURLImageView.getY();
      f2 = f4 + f5 - (f1 + f2);
      f1 = f2;
      if (f2 < 0.0F) {
        f1 = this.jdField_a_of_type_ComTencentImageURLImageView.getHeight() * 0.3F;
      }
      paramMessage = ValueAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[] { paramMessage, PropertyValuesHolder.ofKeyframe("translate", new Keyframe[] { Keyframe.ofFloat(0.0F, f3), Keyframe.ofFloat(0.7714286F, f1), Keyframe.ofFloat(1.0F, 0.0F) }) });
      this.jdField_a_of_type_JavaUtilList.add(new mqq.util.WeakReference(paramMessage));
      paramMessage.addUpdateListener(new asfq(this));
      paramMessage.setDuration(700L);
      paramMessage.start();
      paramMessage = ValueAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[] { PropertyValuesHolder.ofKeyframe("alpha", new Keyframe[] { Keyframe.ofFloat(0.0F, 0.0F), Keyframe.ofFloat(0.08571429F, 0.0F), Keyframe.ofFloat(1.0F, 1.0F) }) });
      this.jdField_a_of_type_JavaUtilList.add(new mqq.util.WeakReference(paramMessage));
      paramMessage.addUpdateListener(new asfr(this));
      paramMessage.setDuration(700L);
      paramMessage.start();
      continue;
      f5 = 2540.0F - 1940.0F;
      paramMessage = ValueAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[] { PropertyValuesHolder.ofKeyframe("alpha", new Keyframe[] { Keyframe.ofFloat(0.0F, 1.0F), Keyframe.ofFloat((2100.0F - 1940.0F) / f5, 0.0F), Keyframe.ofFloat(1.0F, 0.0F) }) });
      this.jdField_a_of_type_JavaUtilList.add(new mqq.util.WeakReference(paramMessage));
      paramMessage.addUpdateListener(new asfs(this));
      paramMessage.setDuration((f5 * 1.0F));
      paramMessage.start();
      paramMessage = ValueAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[] { PropertyValuesHolder.ofKeyframe("bgColor", new Keyframe[] { Keyframe.ofFloat(0.0F, 0.0F), Keyframe.ofFloat((2100.0F - 1940.0F) / f5, 0.0F), Keyframe.ofFloat((2340.0F - 1940.0F) / f5, 1.0F), Keyframe.ofFloat(1.0F, 1.0F) }) });
      this.jdField_a_of_type_JavaUtilList.add(new mqq.util.WeakReference(paramMessage));
      paramMessage.addUpdateListener(new asft(this));
      paramMessage.setDuration((f5 * 1.0F));
      paramMessage.start();
      label603:
      int i;
      Object localObject1;
      Object localObject2;
      int j;
      if (this.jdField_a_of_type_JavaLangRefWeakReference == null)
      {
        paramMessage = null;
        i = Math.max(this.jdField_a_of_type_ComTencentImageURLImageView.getWidth(), this.jdField_a_of_type_ComTencentImageURLImageView.getHeight());
        if (paramMessage == null) {
          break label1367;
        }
        localObject1 = new int[2];
        localObject2 = new int[2];
        paramMessage.getLocationOnScreen((int[])localObject1);
        this.jdField_a_of_type_ComTencentImageURLImageView.getLocationOnScreen((int[])localObject2);
        j = Math.min(paramMessage.getWidth(), paramMessage.getHeight());
        if ((j != 0) && (i != 0)) {
          break label1356;
        }
        f1 = 0.2F;
        label678:
        localObject1[0] += j / 2;
        localObject1[1] += j / 2;
        localObject2[0] += i / 2;
        localObject2[1] += i / 2;
        f2 = localObject1[0] - localObject2[0];
        f4 = localObject1[1] - localObject2[1];
        if (QLog.isDevelopLevel())
        {
          paramMessage = new int[2];
          this.jdField_a_of_type_ComTencentImageURLImageView.getLocationInWindow(paramMessage);
          f3 = this.jdField_a_of_type_ComTencentImageURLImageView.getPivotX();
          float f6 = this.jdField_a_of_type_ComTencentImageURLImageView.getPivotY();
          QLog.i("MedalWallMng", 4, String.format(Locale.getDefault(), "icon end anim target[%d, %d], cur[%d, %d], size: %d, curSize: %d curWindowLoc[%d,%d] pivot[%f, %f]", new Object[] { Integer.valueOf(localObject1[0]), Integer.valueOf(localObject1[1]), Integer.valueOf(localObject2[0]), Integer.valueOf(localObject2[1]), Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(paramMessage[0]), Integer.valueOf(paramMessage[1]), Float.valueOf(f3), Float.valueOf(f6) }));
        }
        f3 = f1;
        f1 = f4;
      }
      for (;;)
      {
        if (QLog.isDevelopLevel()) {
          QLog.i("MedalWallMng", 4, String.format(Locale.getDefault(), "icon end anim [scale: %f, transX: %f, transY: %f]  [%f, %f]", new Object[] { Float.valueOf(f3), Float.valueOf(f2), Float.valueOf(f1), Float.valueOf(this.jdField_a_of_type_ComTencentImageURLImageView.getX()), Float.valueOf(this.jdField_a_of_type_ComTencentImageURLImageView.getY()) }));
        }
        paramMessage = PropertyValuesHolder.ofKeyframe("alpha", new Keyframe[] { Keyframe.ofFloat(0.0F, 1.0F), Keyframe.ofFloat((2460.0F - 1940.0F) / f5, 1.0F), Keyframe.ofFloat(1.0F, 0.0F) });
        localObject1 = PropertyValuesHolder.ofKeyframe("scale", new Keyframe[] { Keyframe.ofFloat(0.0F, 1.0F), Keyframe.ofFloat((2100.0F - 1940.0F) / f5, 1.0F), Keyframe.ofFloat((2480.0F - 1940.0F) / f5, f3), Keyframe.ofFloat(1.0F, f3) });
        localObject2 = Keyframe.ofFloat(0.0F, 0.0F);
        Keyframe localKeyframe1 = Keyframe.ofFloat((2100.0F - 1940.0F) / f5, 0.0F);
        localKeyframe1.setInterpolator(new AccelerateDecelerateInterpolator());
        localObject2 = PropertyValuesHolder.ofKeyframe("translationX", new Keyframe[] { localObject2, localKeyframe1, Keyframe.ofFloat((2480.0F - 1940.0F) / f5, f2), Keyframe.ofFloat(1.0F, f2) });
        localKeyframe1 = Keyframe.ofFloat(0.0F, 0.0F);
        Keyframe localKeyframe2 = Keyframe.ofFloat((2100.0F - 1940.0F) / f5, 0.0F);
        localKeyframe2.setInterpolator(new AccelerateDecelerateInterpolator());
        paramMessage = ValueAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[] { paramMessage, localObject1, localObject2, PropertyValuesHolder.ofKeyframe("translationY", new Keyframe[] { localKeyframe1, localKeyframe2, Keyframe.ofFloat((2480.0F - 1940.0F) / f5, f1), Keyframe.ofFloat(1.0F, f1) }) });
        this.jdField_a_of_type_JavaUtilList.add(new mqq.util.WeakReference(paramMessage));
        paramMessage.addUpdateListener(new asfu(this));
        paramMessage.setDuration((f5 * 1.0F));
        paramMessage.start();
        this.jdField_a_of_type_Bfnk.sendEmptyMessageDelayed(3, (f5 * 1.0F) + 200L);
        break;
        paramMessage = (View)this.jdField_a_of_type_JavaLangRefWeakReference.get();
        break label603;
        label1356:
        f1 = j / i;
        break label678;
        label1367:
        f2 = -this.jdField_a_of_type_ComTencentImageURLImageView.getX() - i / 2.0F;
        f1 = -this.jdField_a_of_type_ComTencentImageURLImageView.getY() - i / 2.0F;
        f3 = 0.2F;
      }
      if (QLog.isDevelopLevel()) {
        QLog.i("MedalWallMng", 4, "MSG_START_3D_ROTATE");
      }
      f1 = this.jdField_a_of_type_ComTencentImageURLImageView.getWidth() / 2;
      f2 = this.jdField_a_of_type_ComTencentImageURLImageView.getHeight() / 2;
      this.jdField_a_of_type_Asgb = new asgb(0.0F, -24.0F * 0.65F, f1, f2, 0.0F, true);
      this.jdField_a_of_type_Asgb.setDuration(260L);
      this.jdField_a_of_type_Asgb.setFillAfter(true);
      this.jdField_a_of_type_Asgb.setAnimationListener(this);
      this.jdField_b_of_type_Asgb = new asgb(-24.0F * 0.65F, 15.0F * 0.65F, f1, f2, 0.0F, false);
      this.jdField_b_of_type_Asgb.setDuration(260L);
      this.jdField_b_of_type_Asgb.setFillAfter(true);
      this.jdField_b_of_type_Asgb.setAnimationListener(this);
      this.jdField_c_of_type_Asgb = new asgb(15.0F * 0.65F, 0.0F, f1, f2, 0.0F, true);
      this.jdField_c_of_type_Asgb.setDuration(300L);
      this.jdField_c_of_type_Asgb.setFillAfter(true);
      this.jdField_c_of_type_Asgb.setAnimationListener(this);
      this.jdField_a_of_type_ComTencentImageURLImageView.startAnimation(this.jdField_a_of_type_Asgb);
      this.jdField_a_of_type_Asfz = new asfz(this, 2, 100, g);
      this.jdField_a_of_type_Asfz.a(getWidth(), getHeight());
      continue;
      d();
      continue;
      this.jdField_d_of_type_Boolean = true;
    }
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (paramAnimation == this.jdField_a_of_type_Asgb) {
      this.jdField_a_of_type_ComTencentImageURLImageView.startAnimation(this.jdField_b_of_type_Asgb);
    }
    do
    {
      return;
      if (paramAnimation == this.jdField_b_of_type_Asgb)
      {
        this.jdField_a_of_type_ComTencentImageURLImageView.startAnimation(this.jdField_c_of_type_Asgb);
        return;
      }
    } while (paramAnimation != this.jdField_c_of_type_Asgb);
    this.jdField_d_of_type_Boolean = true;
    this.jdField_a_of_type_Bfnk.removeMessages(5);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    do
    {
      do
      {
        return;
        a(paramView);
        return;
        if (this.jdField_b_of_type_JavaLangRefWeakReference == null) {}
        for (paramView = null;; paramView = (BaseActivity)this.jdField_b_of_type_JavaLangRefWeakReference.get())
        {
          if (paramView != null)
          {
            String str = ((MedalWallMng)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getManager(250)).a(true, paramView.getCurrentAccountUin(), MedalWallMng.jdField_d_of_type_Int);
            str = String.format(Locale.getDefault(), "%s&openMedalId=%s&openMedalLevel=%s", new Object[] { str, Integer.valueOf(this.jdField_b_of_type_Int), Integer.valueOf(this.jdField_c_of_type_Int) });
            Intent localIntent = new Intent(paramView, QQBrowserActivity.class);
            localIntent.putExtra("url", str);
            paramView.startActivity(localIntent);
            if (QLog.isColorLevel()) {
              QLog.i("MedalWallMng", 2, String.format(Locale.getDefault(), "enter medal url: %s", new Object[] { str }));
            }
            ThreadManager.post(new MedalGuideView.1(this), 5, null, false);
          }
          d();
          return;
        }
        if (this.jdField_d_of_type_Boolean) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.i("MedalWallMng", 2, "close when enter animation is not finished yet!");
      return;
    } while (this.jdField_a_of_type_Bfnk.hasMessages(2));
    this.jdField_a_of_type_Bfnk.sendEmptyMessage(2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.medalwall.MedalGuideView
 * JD-Core Version:    0.7.0.1
 */