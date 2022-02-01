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
  private static final int[] jdField_a_of_type_ArrayOfInt = { 2130845582, 2130845584, 2130845583 };
  private static final int[] jdField_b_of_type_ArrayOfInt = { 2130845573, 2130845574, 2130845575 };
  private static java.lang.ref.WeakReference<MedalGuideView> jdField_c_of_type_JavaLangRefWeakReference = null;
  private static final int[] jdField_c_of_type_ArrayOfInt = { 2131166440, 2131166444, 2131166442 };
  private static final int[] jdField_d_of_type_ArrayOfInt = { 2131166446, 2131166448, 2131166447 };
  private static final int[] jdField_e_of_type_ArrayOfInt = { 2130845564, 2130845566, 2130845565 };
  private static final int[] f = { 2130845568, 2130845572, 2130845570 };
  private static final int[] g = { 2130845579, 2130845580, 2130845581 };
  int jdField_a_of_type_Int;
  ArgbEvaluator jdField_a_of_type_AndroidAnimationArgbEvaluator = null;
  ColorDrawable jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
  Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  Button jdField_a_of_type_AndroidWidgetButton;
  ImageButton jdField_a_of_type_AndroidWidgetImageButton;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  URLImageView jdField_a_of_type_ComTencentImageURLImageView;
  MedalGuideView.MedalPopupWindow jdField_a_of_type_ComTencentMobileqqMedalwallMedalGuideView$MedalPopupWindow = null;
  MedalWallMng.NeedGuideMedal jdField_a_of_type_ComTencentMobileqqMedalwallMedalWallMng$NeedGuideMedal = null;
  ParticleSystem jdField_a_of_type_ComTencentMobileqqMedalwallParticleSystem = null;
  Rotate3dAnimation jdField_a_of_type_ComTencentMobileqqMedalwallRotate3dAnimation;
  ShareHelper jdField_a_of_type_ComTencentMobileqqMedalwallShareHelper;
  WeakReferenceHandler jdField_a_of_type_ComTencentUtilWeakReferenceHandler;
  String jdField_a_of_type_JavaLangString;
  java.lang.ref.WeakReference<View> jdField_a_of_type_JavaLangRefWeakReference = null;
  List<mqq.util.WeakReference<ValueAnimator>> jdField_a_of_type_JavaUtilList;
  boolean jdField_a_of_type_Boolean = false;
  int jdField_b_of_type_Int;
  Button jdField_b_of_type_AndroidWidgetButton;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  Rotate3dAnimation jdField_b_of_type_ComTencentMobileqqMedalwallRotate3dAnimation;
  String jdField_b_of_type_JavaLangString;
  java.lang.ref.WeakReference<QBaseActivity> jdField_b_of_type_JavaLangRefWeakReference = null;
  boolean jdField_b_of_type_Boolean = true;
  int jdField_c_of_type_Int;
  Rotate3dAnimation jdField_c_of_type_ComTencentMobileqqMedalwallRotate3dAnimation;
  String jdField_c_of_type_JavaLangString;
  boolean jdField_c_of_type_Boolean = false;
  int jdField_d_of_type_Int;
  boolean jdField_d_of_type_Boolean = false;
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
    b();
  }
  
  public static void a()
  {
    Object localObject = jdField_c_of_type_JavaLangRefWeakReference;
    if (localObject != null)
    {
      localObject = (MedalGuideView)((java.lang.ref.WeakReference)localObject).get();
      if (localObject != null) {
        ((MedalGuideView)localObject).d();
      }
      jdField_c_of_type_JavaLangRefWeakReference.clear();
      jdField_c_of_type_JavaLangRefWeakReference = null;
      if (QLog.isColorLevel()) {
        QLog.i("MedalWallMng", 2, String.format(Locale.getDefault(), "doCleanMedalGuide guide: %s", new Object[] { localObject }));
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
    if (this.jdField_a_of_type_ComTencentMobileqqMedalwallShareHelper == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqMedalwallShareHelper = new ShareHelper(paramView.getContext(), localQQAppInterface);
      String str2 = ((MedalWallMng)localQQAppInterface.getManager(QQManagerFactory.MEDAL_WALL_MNG)).a();
      String str1 = ShareHelper.g;
      int k = AIOUtils.b(48.0F, getResources());
      paramView = this.jdField_a_of_type_ComTencentMobileqqMedalwallMedalWallMng$NeedGuideMedal;
      long l1 = 0L;
      Object localObject2 = "";
      int i;
      long l2;
      Object localObject1;
      Object localObject4;
      int j;
      Object localObject5;
      if ((paramView != null) && (paramView.jdField_a_of_type_ComTencentMobileqqDataMedalInfo != null))
      {
        i = this.jdField_a_of_type_ComTencentMobileqqMedalwallMedalWallMng$NeedGuideMedal.jdField_a_of_type_ComTencentMobileqqDataMedalInfo.iLevel;
        if (i != 1)
        {
          if (i != 2)
          {
            if (i != 3)
            {
              l1 = this.jdField_a_of_type_ComTencentMobileqqMedalwallMedalWallMng$NeedGuideMedal.jdField_a_of_type_ComTencentMobileqqDataMedalInfo.lObtainTimeLevel1;
              l2 = this.jdField_a_of_type_ComTencentMobileqqMedalwallMedalWallMng$NeedGuideMedal.jdField_a_of_type_ComTencentMobileqqDataMedalInfo.lSeqLevel1;
              paramView = "";
            }
            else
            {
              l1 = this.jdField_a_of_type_ComTencentMobileqqMedalwallMedalWallMng$NeedGuideMedal.jdField_a_of_type_ComTencentMobileqqDataMedalInfo.lObtainTimeLevel3;
              l2 = this.jdField_a_of_type_ComTencentMobileqqMedalwallMedalWallMng$NeedGuideMedal.jdField_a_of_type_ComTencentMobileqqDataMedalInfo.lSeqLevel3;
              paramView = "III";
            }
          }
          else
          {
            l1 = this.jdField_a_of_type_ComTencentMobileqqMedalwallMedalWallMng$NeedGuideMedal.jdField_a_of_type_ComTencentMobileqqDataMedalInfo.lObtainTimeLevel2;
            l2 = this.jdField_a_of_type_ComTencentMobileqqMedalwallMedalWallMng$NeedGuideMedal.jdField_a_of_type_ComTencentMobileqqDataMedalInfo.lSeqLevel2;
            paramView = "II";
          }
        }
        else
        {
          l1 = this.jdField_a_of_type_ComTencentMobileqqMedalwallMedalWallMng$NeedGuideMedal.jdField_a_of_type_ComTencentMobileqqDataMedalInfo.lObtainTimeLevel1;
          l2 = this.jdField_a_of_type_ComTencentMobileqqMedalwallMedalWallMng$NeedGuideMedal.jdField_a_of_type_ComTencentMobileqqDataMedalInfo.lSeqLevel1;
          paramView = "I";
        }
        paramView = String.format("%s %s", new Object[] { this.jdField_c_of_type_JavaLangString, paramView });
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqMedalwallMedalWallMng$NeedGuideMedal.jdField_c_of_type_JavaLangString;
        localObject4 = NearbyURLSafeUtil.a(localQQAppInterface.getCurrentAccountUin());
        j = this.jdField_a_of_type_ComTencentMobileqqMedalwallMedalWallMng$NeedGuideMedal.jdField_a_of_type_ComTencentMobileqqDataMedalInfo.iId;
        i = this.jdField_a_of_type_ComTencentMobileqqMedalwallMedalWallMng$NeedGuideMedal.jdField_a_of_type_ComTencentMobileqqDataMedalInfo.iLevel;
        localObject5 = localQQAppInterface.getCurrentNickname();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(j);
        ((StringBuilder)localObject2).append("");
        localObject2 = ((StringBuilder)localObject2).toString();
        localObject6 = new StringBuilder();
        ((StringBuilder)localObject6).append(i);
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
        i = 0;
        j = 0;
        localObject4 = localObject1;
        localObject1 = paramView;
        paramView = (View)localObject6;
      }
      Object localObject6 = new StringBuilder(str2);
      ((StringBuilder)localObject6).append("&uincode=");
      ((StringBuilder)localObject6).append((String)localObject4);
      ((StringBuilder)localObject6).append("&id=");
      ((StringBuilder)localObject6).append(j);
      ((StringBuilder)localObject6).append("&level=");
      ((StringBuilder)localObject6).append(i);
      ((StringBuilder)localObject6).append("&nick=");
      ((StringBuilder)localObject6).append(URLEncoder.encode((String)localObject5));
      ((StringBuilder)localObject6).append("&en=");
      ((StringBuilder)localObject6).append((String)localObject2);
      ((StringBuilder)localObject6).append("&fromId=");
      ((StringBuilder)localObject6).append(1);
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqMedalwallMedalWallMng$NeedGuideMedal;
      Object localObject3;
      if ((localObject2 != null) && (((MedalWallMng.NeedGuideMedal)localObject2).jdField_a_of_type_ComTencentMobileqqDataMedalInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqMedalwallMedalWallMng$NeedGuideMedal.jdField_a_of_type_ComTencentMobileqqDataMedalInfo.iId == 0))
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
      this.jdField_a_of_type_ComTencentMobileqqMedalwallShareHelper.a(paramView, str1, ((StringBuilder)localObject6).toString(), (String)localObject1, "QQ勋章墙", ShareHelper.a(this.jdField_a_of_type_ComTencentImageURLImageView.getDrawable(), k, k));
    }
    this.jdField_a_of_type_ComTencentMobileqqMedalwallShareHelper.a(new MedalGuideView.2(this));
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
    jdField_c_of_type_JavaLangRefWeakReference = new java.lang.ref.WeakReference(localMedalGuideView);
  }
  
  private void b()
  {
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler = new WeakReferenceHandler(Looper.getMainLooper(), this);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    inflate(getContext(), 2131561170, this);
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)findViewById(2131365169));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131378784));
    this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)findViewById(2131370730));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131370731));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131377360));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)findViewById(2131366260));
    this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)findViewById(2131364703));
    this.jdField_a_of_type_AndroidWidgetImageButton.setOnClickListener(this);
    this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable = new ColorDrawable(0);
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
        Object localObject = (LinearLayout.LayoutParams)this.jdField_a_of_type_ComTencentImageURLImageView.getLayoutParams();
        int i = (int)(290.0F * f1);
        ((LinearLayout.LayoutParams)localObject).width = i;
        ((LinearLayout.LayoutParams)localObject).height = i;
        ((LinearLayout.LayoutParams)localObject).topMargin = ((int)(30.0F * f1));
        this.jdField_a_of_type_ComTencentImageURLImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
        localObject = (LinearLayout.LayoutParams)this.jdField_b_of_type_AndroidWidgetTextView.getLayoutParams();
        ((LinearLayout.LayoutParams)localObject).topMargin = ((int)(20.0F * f1));
        this.jdField_b_of_type_AndroidWidgetTextView.setLayoutParams((ViewGroup.LayoutParams)localObject);
        localObject = (LinearLayout)findViewById(2131361971);
        LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)((LinearLayout)localObject).getLayoutParams();
        localLayoutParams.topMargin = ((int)(32.0F * f1));
        ((LinearLayout)localObject).setLayoutParams(localLayoutParams);
        localObject = (LinearLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetImageButton.getLayoutParams();
        ((LinearLayout.LayoutParams)localObject).topMargin = ((int)(f1 * 40.0F));
        this.jdField_a_of_type_AndroidWidgetImageButton.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
      if (QLog.isColorLevel()) {
        QLog.i("MedalWallMng", 2, String.format(Locale.getDefault(), "dm[%f, %d, %f], system[%f, %d, %f]", new Object[] { Float.valueOf(localDisplayMetrics1.density), Integer.valueOf(localDisplayMetrics1.densityDpi), Float.valueOf(localDisplayMetrics1.scaledDensity), Float.valueOf(localDisplayMetrics2.density), Integer.valueOf(localDisplayMetrics2.densityDpi), Float.valueOf(localDisplayMetrics2.scaledDensity) }));
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    this.jdField_a_of_type_AndroidAnimationArgbEvaluator = new ArgbEvaluator();
    this.jdField_a_of_type_Int = getResources().getColor(2131166439);
    this.jdField_a_of_type_ComTencentImageURLImageView.setAlpha(0.0F);
    this.jdField_a_of_type_AndroidViewViewGroup.setBackgroundColor(0);
    a(0.0F);
  }
  
  private void c()
  {
    Resources localResources = getResources();
    this.jdField_a_of_type_AndroidWidgetTextView.setText(2131699014);
    Object localObject1 = this.jdField_a_of_type_AndroidWidgetTextView;
    Object localObject2 = jdField_a_of_type_ArrayOfInt;
    int i = this.jdField_d_of_type_Int;
    ((TextView)localObject1).setCompoundDrawablesWithIntrinsicBounds(localObject2[i], 0, localObject2[i], 0);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(localResources.getColor(jdField_c_of_type_ArrayOfInt[this.jdField_d_of_type_Int]));
    localObject1 = URLDrawable.URLDrawableOptions.obtain();
    i = localResources.getDimensionPixelSize(2131298357);
    ((URLDrawable.URLDrawableOptions)localObject1).mRequestWidth = i;
    ((URLDrawable.URLDrawableOptions)localObject1).mRequestHeight = i;
    localObject2 = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
    ((URLDrawable.URLDrawableOptions)localObject1).mFailedDrawable = ((Drawable)localObject2);
    ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = ((Drawable)localObject2);
    if (FileUtils.fileExists(this.jdField_b_of_type_JavaLangString)) {
      localObject1 = URLDrawable.getDrawable(new File(this.jdField_b_of_type_JavaLangString), (URLDrawable.URLDrawableOptions)localObject1);
    } else if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      localObject1 = URLDrawable.getDrawable(this.jdField_a_of_type_JavaLangString, (URLDrawable.URLDrawableOptions)localObject1);
    } else {
      localObject1 = null;
    }
    this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject1);
    this.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_c_of_type_JavaLangString);
    if (this.jdField_e_of_type_Boolean)
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
    }
    else
    {
      localObject1 = getResources().getDrawable(jdField_b_of_type_ArrayOfInt[this.jdField_d_of_type_Int]);
      ((Drawable)localObject1).setBounds(0, 0, ((Drawable)localObject1).getIntrinsicWidth(), ((Drawable)localObject1).getIntrinsicHeight());
      this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable.setBounds(0, 0, ((Drawable)localObject1).getIntrinsicWidth(), ((Drawable)localObject1).getIntrinsicHeight());
      this.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawables(this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable, null, (Drawable)localObject1, null);
    }
    this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(localResources.getColor(jdField_c_of_type_ArrayOfInt[this.jdField_d_of_type_Int]));
    this.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(jdField_e_of_type_ArrayOfInt[this.jdField_d_of_type_Int]);
    this.jdField_a_of_type_AndroidWidgetButton.setTextColor(localResources.getColorStateList(jdField_d_of_type_ArrayOfInt[this.jdField_d_of_type_Int]));
    this.jdField_b_of_type_AndroidWidgetButton.setBackgroundResource(jdField_e_of_type_ArrayOfInt[this.jdField_d_of_type_Int]);
    this.jdField_b_of_type_AndroidWidgetButton.setTextColor(localResources.getColorStateList(jdField_d_of_type_ArrayOfInt[this.jdField_d_of_type_Int]));
    this.jdField_a_of_type_AndroidWidgetImageButton.setImageResource(f[this.jdField_d_of_type_Int]);
  }
  
  private void d()
  {
    if (QLog.isColorLevel()) {
      QLog.i("MedalWallMng", 2, "close");
    }
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(3);
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqMedalwallParticleSystem;
    if (localObject != null)
    {
      ((ParticleSystem)localObject).c();
      this.jdField_a_of_type_ComTencentMobileqqMedalwallParticleSystem = null;
    }
    localObject = this.jdField_b_of_type_JavaLangRefWeakReference;
    if (localObject != null)
    {
      ((java.lang.ref.WeakReference)localObject).clear();
      this.jdField_b_of_type_JavaLangRefWeakReference = null;
    }
    localObject = this.jdField_a_of_type_JavaLangRefWeakReference;
    if (localObject != null)
    {
      ((java.lang.ref.WeakReference)localObject).clear();
      this.jdField_a_of_type_JavaLangRefWeakReference = null;
    }
    this.jdField_a_of_type_ComTencentMobileqqMedalwallMedalWallMng$NeedGuideMedal = null;
    localObject = this.jdField_a_of_type_ComTencentMobileqqMedalwallMedalGuideView$MedalPopupWindow;
    if (localObject != null)
    {
      ((MedalGuideView.MedalPopupWindow)localObject).a();
      this.jdField_a_of_type_ComTencentMobileqqMedalwallMedalGuideView$MedalPopupWindow = null;
    }
    localObject = this.jdField_a_of_type_JavaUtilList.iterator();
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
    this.jdField_a_of_type_JavaLangRefWeakReference = new java.lang.ref.WeakReference(paramView);
    this.jdField_b_of_type_JavaLangRefWeakReference = new java.lang.ref.WeakReference(paramQBaseActivity);
    this.jdField_e_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentMobileqqMedalwallMedalWallMng$NeedGuideMedal = paramNeedGuideMedal;
    this.jdField_a_of_type_ComTencentMobileqqMedalwallMedalGuideView$MedalPopupWindow = paramMedalPopupWindow;
    this.jdField_a_of_type_ComTencentMobileqqMedalwallShareHelper = null;
    paramQBaseActivity = this.jdField_a_of_type_ComTencentMobileqqMedalwallMedalGuideView$MedalPopupWindow;
    if (paramQBaseActivity != null) {
      paramQBaseActivity.a(new MedalGuideView.9(this));
    }
    if ((paramNeedGuideMedal != null) && (paramNeedGuideMedal.jdField_a_of_type_ComTencentMobileqqDataMedalInfo != null))
    {
      this.jdField_b_of_type_Int = paramNeedGuideMedal.jdField_a_of_type_ComTencentMobileqqDataMedalInfo.iId;
      if ((paramNeedGuideMedal.jdField_a_of_type_ComTencentMobileqqDataMedalInfo.iLevel >= 1) && (paramNeedGuideMedal.jdField_a_of_type_ComTencentMobileqqDataMedalInfo.iLevel <= 3))
      {
        this.jdField_d_of_type_Int = (paramNeedGuideMedal.jdField_a_of_type_ComTencentMobileqqDataMedalInfo.iLevel - 1);
        this.jdField_e_of_type_Boolean = false;
      }
      else
      {
        this.jdField_d_of_type_Int = 2;
        this.jdField_e_of_type_Boolean = true;
      }
      this.jdField_c_of_type_Int = paramNeedGuideMedal.jdField_a_of_type_ComTencentMobileqqDataMedalInfo.iLevel;
      this.jdField_c_of_type_JavaLangString = paramNeedGuideMedal.jdField_a_of_type_ComTencentMobileqqDataMedalInfo.strName;
      this.jdField_b_of_type_JavaLangString = paramNeedGuideMedal.jdField_b_of_type_JavaLangString;
      this.jdField_a_of_type_JavaLangString = paramNeedGuideMedal.jdField_a_of_type_JavaLangString;
    }
    else
    {
      this.jdField_b_of_type_Int = 0;
      this.jdField_d_of_type_Int = 2;
      this.jdField_c_of_type_JavaLangString = "";
      this.jdField_b_of_type_JavaLangString = null;
      this.jdField_a_of_type_JavaLangString = null;
      this.jdField_e_of_type_Boolean = false;
      this.jdField_c_of_type_Int = 1;
    }
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = new ColorDrawable(0);
    c();
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    if (this.jdField_b_of_type_Boolean)
    {
      this.jdField_b_of_type_Boolean = false;
      this.jdField_d_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessage(1);
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessageDelayed(5, 1600L);
    }
    ParticleSystem localParticleSystem = this.jdField_a_of_type_ComTencentMobileqqMedalwallParticleSystem;
    if (localParticleSystem != null) {
      localParticleSystem.a(paramCanvas, 1);
    }
    super.dispatchDraw(paramCanvas);
    localParticleSystem = this.jdField_a_of_type_ComTencentMobileqqMedalwallParticleSystem;
    if (localParticleSystem != null) {
      localParticleSystem.a(paramCanvas, 2);
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    if (i != 1) {
      if (i != 2) {
        if (i != 3) {
          if (i != 4) {
            if (i == 5) {}
          }
        }
      }
    }
    for (;;)
    {
      return true;
      this.jdField_d_of_type_Boolean = true;
      continue;
      if (QLog.isDevelopLevel()) {
        QLog.i("MedalWallMng", 4, "MSG_START_3D_ROTATE");
      }
      float f1 = this.jdField_a_of_type_ComTencentImageURLImageView.getWidth() / 2;
      float f2 = this.jdField_a_of_type_ComTencentImageURLImageView.getHeight() / 2;
      this.jdField_a_of_type_ComTencentMobileqqMedalwallRotate3dAnimation = new Rotate3dAnimation(0.0F, -15.599999F, f1, f2, 0.0F, true);
      this.jdField_a_of_type_ComTencentMobileqqMedalwallRotate3dAnimation.setDuration(260L);
      this.jdField_a_of_type_ComTencentMobileqqMedalwallRotate3dAnimation.setFillAfter(true);
      this.jdField_a_of_type_ComTencentMobileqqMedalwallRotate3dAnimation.setAnimationListener(this);
      this.jdField_b_of_type_ComTencentMobileqqMedalwallRotate3dAnimation = new Rotate3dAnimation(-15.599999F, 9.75F, f1, f2, 0.0F, false);
      this.jdField_b_of_type_ComTencentMobileqqMedalwallRotate3dAnimation.setDuration(260L);
      this.jdField_b_of_type_ComTencentMobileqqMedalwallRotate3dAnimation.setFillAfter(true);
      this.jdField_b_of_type_ComTencentMobileqqMedalwallRotate3dAnimation.setAnimationListener(this);
      this.jdField_c_of_type_ComTencentMobileqqMedalwallRotate3dAnimation = new Rotate3dAnimation(9.75F, 0.0F, f1, f2, 0.0F, true);
      this.jdField_c_of_type_ComTencentMobileqqMedalwallRotate3dAnimation.setDuration(300L);
      this.jdField_c_of_type_ComTencentMobileqqMedalwallRotate3dAnimation.setFillAfter(true);
      this.jdField_c_of_type_ComTencentMobileqqMedalwallRotate3dAnimation.setAnimationListener(this);
      this.jdField_a_of_type_ComTencentImageURLImageView.startAnimation(this.jdField_a_of_type_ComTencentMobileqqMedalwallRotate3dAnimation);
      this.jdField_a_of_type_ComTencentMobileqqMedalwallParticleSystem = new ParticleSystem(this, 2, 100, g);
      this.jdField_a_of_type_ComTencentMobileqqMedalwallParticleSystem.a(getWidth(), getHeight());
      continue;
      d();
      continue;
      paramMessage = ValueAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[] { PropertyValuesHolder.ofKeyframe("alpha", new Keyframe[] { Keyframe.ofFloat(0.0F, 1.0F), Keyframe.ofFloat(0.2666667F, 0.0F), Keyframe.ofFloat(1.0F, 0.0F) }) });
      this.jdField_a_of_type_JavaUtilList.add(new mqq.util.WeakReference(paramMessage));
      paramMessage.addUpdateListener(new MedalGuideView.6(this));
      long l = 600.0F;
      paramMessage.setDuration(l);
      paramMessage.start();
      paramMessage = ValueAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[] { PropertyValuesHolder.ofKeyframe("bgColor", new Keyframe[] { Keyframe.ofFloat(0.0F, 0.0F), Keyframe.ofFloat(0.2666667F, 0.0F), Keyframe.ofFloat(0.6666667F, 1.0F), Keyframe.ofFloat(1.0F, 1.0F) }) });
      this.jdField_a_of_type_JavaUtilList.add(new mqq.util.WeakReference(paramMessage));
      paramMessage.addUpdateListener(new MedalGuideView.7(this));
      paramMessage.setDuration(l);
      paramMessage.start();
      paramMessage = this.jdField_a_of_type_JavaLangRefWeakReference;
      if (paramMessage == null) {
        paramMessage = null;
      } else {
        paramMessage = (View)paramMessage.get();
      }
      i = Math.max(this.jdField_a_of_type_ComTencentImageURLImageView.getWidth(), this.jdField_a_of_type_ComTencentImageURLImageView.getHeight());
      if (paramMessage != null)
      {
        localObject1 = new int[2];
        localObject2 = new int[2];
        paramMessage.getLocationOnScreen((int[])localObject1);
        this.jdField_a_of_type_ComTencentImageURLImageView.getLocationOnScreen((int[])localObject2);
        int j = Math.min(paramMessage.getWidth(), paramMessage.getHeight());
        if ((j != 0) && (i != 0)) {
          f1 = j / i;
        } else {
          f1 = 0.2F;
        }
        int k = localObject1[0];
        int m = j / 2;
        localObject1[0] = (k + m);
        localObject1[1] += m;
        k = localObject2[0];
        m = i / 2;
        localObject2[0] = (k + m);
        localObject2[1] += m;
        f3 = localObject1[0] - localObject2[0];
        f2 = localObject1[1] - localObject2[1];
        if (QLog.isDevelopLevel())
        {
          paramMessage = new int[2];
          this.jdField_a_of_type_ComTencentImageURLImageView.getLocationInWindow(paramMessage);
          f4 = this.jdField_a_of_type_ComTencentImageURLImageView.getPivotX();
          f5 = this.jdField_a_of_type_ComTencentImageURLImageView.getPivotY();
          QLog.i("MedalWallMng", 4, String.format(Locale.getDefault(), "icon end anim target[%d, %d], cur[%d, %d], size: %d, curSize: %d curWindowLoc[%d,%d] pivot[%f, %f]", new Object[] { Integer.valueOf(localObject1[0]), Integer.valueOf(localObject1[1]), Integer.valueOf(localObject2[0]), Integer.valueOf(localObject2[1]), Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(paramMessage[0]), Integer.valueOf(paramMessage[1]), Float.valueOf(f4), Float.valueOf(f5) }));
        }
      }
      else
      {
        f2 = -this.jdField_a_of_type_ComTencentImageURLImageView.getX();
        f1 = i / 2.0F;
        f3 = f2 - f1;
        f2 = -this.jdField_a_of_type_ComTencentImageURLImageView.getY() - f1;
        f1 = 0.2F;
      }
      if (QLog.isDevelopLevel()) {
        QLog.i("MedalWallMng", 4, String.format(Locale.getDefault(), "icon end anim [scale: %f, transX: %f, transY: %f]  [%f, %f]", new Object[] { Float.valueOf(f1), Float.valueOf(f3), Float.valueOf(f2), Float.valueOf(this.jdField_a_of_type_ComTencentImageURLImageView.getX()), Float.valueOf(this.jdField_a_of_type_ComTencentImageURLImageView.getY()) }));
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
      this.jdField_a_of_type_JavaUtilList.add(new mqq.util.WeakReference(paramMessage));
      paramMessage.addUpdateListener(new MedalGuideView.8(this));
      paramMessage.setDuration(l);
      paramMessage.start();
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessageDelayed(3, l + 200L);
      continue;
      if (QLog.isDevelopLevel()) {
        QLog.i("MedalWallMng", 4, "MSG_START_ENTER_ANIM");
      }
      this.jdField_c_of_type_Boolean = false;
      paramMessage = PropertyValuesHolder.ofKeyframe("alpha", new Keyframe[] { Keyframe.ofFloat(0.0F, 0.0F), Keyframe.ofFloat(0.05714286F, 0.0F), Keyframe.ofFloat(0.2F, 1.0F), Keyframe.ofFloat(1.0F, 1.0F) });
      f1 = this.jdField_a_of_type_ComTencentImageURLImageView.getY();
      f2 = this.jdField_a_of_type_ComTencentImageURLImageView.getHeight();
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
      paramMessage.addUpdateListener(new MedalGuideView.4(this));
      paramMessage.setDuration(700L);
      paramMessage.start();
      paramMessage = ValueAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[] { PropertyValuesHolder.ofKeyframe("alpha", new Keyframe[] { Keyframe.ofFloat(0.0F, 0.0F), Keyframe.ofFloat(0.08571429F, 0.0F), Keyframe.ofFloat(1.0F, 1.0F) }) });
      this.jdField_a_of_type_JavaUtilList.add(new mqq.util.WeakReference(paramMessage));
      paramMessage.addUpdateListener(new MedalGuideView.5(this));
      paramMessage.setDuration(700L);
      paramMessage.start();
    }
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (paramAnimation == this.jdField_a_of_type_ComTencentMobileqqMedalwallRotate3dAnimation)
    {
      this.jdField_a_of_type_ComTencentImageURLImageView.startAnimation(this.jdField_b_of_type_ComTencentMobileqqMedalwallRotate3dAnimation);
      return;
    }
    if (paramAnimation == this.jdField_b_of_type_ComTencentMobileqqMedalwallRotate3dAnimation)
    {
      this.jdField_a_of_type_ComTencentImageURLImageView.startAnimation(this.jdField_c_of_type_ComTencentMobileqqMedalwallRotate3dAnimation);
      return;
    }
    if (paramAnimation == this.jdField_c_of_type_ComTencentMobileqqMedalwallRotate3dAnimation)
    {
      this.jdField_d_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(5);
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i != 2131364703)
    {
      if (i != 2131366260)
      {
        if (i == 2131377360) {
          a(paramView);
        }
      }
      else
      {
        Object localObject = this.jdField_b_of_type_JavaLangRefWeakReference;
        if (localObject == null) {
          localObject = null;
        } else {
          localObject = (QBaseActivity)((java.lang.ref.WeakReference)localObject).get();
        }
        if (localObject != null)
        {
          String str = ((MedalWallMng)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getManager(QQManagerFactory.MEDAL_WALL_MNG)).a(true, ((QBaseActivity)localObject).getAppRuntime().getCurrentAccountUin(), MedalWallMng.jdField_d_of_type_Int);
          str = String.format(Locale.getDefault(), "%s&openMedalId=%s&openMedalLevel=%s", new Object[] { str, Integer.valueOf(this.jdField_b_of_type_Int), Integer.valueOf(this.jdField_c_of_type_Int) });
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
    else if (!this.jdField_d_of_type_Boolean)
    {
      if (QLog.isColorLevel()) {
        QLog.i("MedalWallMng", 2, "close when enter animation is not finished yet!");
      }
    }
    else if (!this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.hasMessages(2)) {
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessage(2);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.medalwall.MedalGuideView
 * JD-Core Version:    0.7.0.1
 */