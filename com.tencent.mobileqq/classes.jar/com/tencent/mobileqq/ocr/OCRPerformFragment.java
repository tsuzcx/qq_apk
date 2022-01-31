package com.tencent.mobileqq.ocr;

import aekt;
import alpo;
import ancj;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import arof;
import asfk;
import asfn;
import asfo;
import asfr;
import avrc;
import avrd;
import avre;
import avrf;
import avrg;
import avrh;
import avri;
import avuq;
import avur;
import avus;
import avvt;
import azgq;
import azmj;
import baja;
import bcvq;
import bhow;
import bhpy;
import bllv;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.contact.addcontact.BubbleLayout;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.armap.ScanSuccessView;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.ocr.view.EyeButton;
import com.tencent.mobileqq.ocr.view.OcrImageTextView;
import com.tencent.mobileqq.ocr.view.gesture.GestureFrameLayout;
import com.tencent.mobileqq.ocr.view.gesture.GestureProxy;
import com.tencent.mobileqq.widget.OCRBottomTabView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import mqq.util.WeakReference;

public class OCRPerformFragment
  extends PublicBaseFragment
  implements Handler.Callback, View.OnClickListener, avri, avus
{
  int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long = -1L;
  BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = null;
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private asfo jdField_a_of_type_Asfo = new avrg(this);
  private asfr jdField_a_of_type_Asfr;
  public final bhow a;
  private bhpy jdField_a_of_type_Bhpy;
  private BubbleLayout jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactBubbleLayout;
  private BaseActivity jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
  private ScanSuccessView jdField_a_of_type_ComTencentMobileqqArmapScanSuccessView;
  private OcrImageTextView jdField_a_of_type_ComTencentMobileqqOcrViewOcrImageTextView;
  private GestureFrameLayout jdField_a_of_type_ComTencentMobileqqOcrViewGestureGestureFrameLayout;
  private String jdField_a_of_type_JavaLangString;
  private WeakReference<QQAppInterface> jdField_a_of_type_MqqUtilWeakReference;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean;
  private RelativeLayout jdField_c_of_type_AndroidWidgetRelativeLayout;
  private boolean jdField_c_of_type_Boolean;
  private boolean d;
  private boolean e;
  
  public OCRPerformFragment()
  {
    this.jdField_a_of_type_Bhow = new bhow(Looper.getMainLooper(), this);
  }
  
  private CharSequence a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqOcrViewOcrImageTextView != null) && (this.jdField_a_of_type_ComTencentMobileqqOcrViewOcrImageTextView.b())) {}
    for (CharSequence localCharSequence = this.jdField_a_of_type_ComTencentMobileqqOcrViewOcrImageTextView.a();; localCharSequence = avrh.a())
    {
      avrh.b(localCharSequence);
      return localCharSequence;
    }
  }
  
  public static void a(Activity paramActivity, String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    Intent localIntent = new Intent(paramActivity, OCRPerformFragment.class);
    localIntent.putExtra("param_ocr_path", paramString1);
    localIntent.putExtra("PARAM_FROM", paramInt1);
    localIntent.addFlags(67108864);
    localIntent.putExtra("param_ocr_md5", paramString2);
    localIntent.putExtra("param_business_type", paramInt2);
    PublicFragmentActivity.a(paramActivity, localIntent, OCRPerformFragment.class);
    paramActivity.overridePendingTransition(0, 0);
    avrh.a("0X80082C7", 0);
  }
  
  private void a(View paramView)
  {
    Object localObject = (OCRBottomTabView)paramView.findViewById(2131371329);
    ((OCRBottomTabView)localObject).setOnClickListener(this);
    if ((AppSetting.jdField_c_of_type_Boolean) && (((OCRBottomTabView)localObject).isEnabled())) {
      bcvq.a((View)localObject, String.valueOf(((OCRBottomTabView)localObject).a()).trim());
    }
    localObject = (OCRBottomTabView)paramView.findViewById(2131371328);
    ((OCRBottomTabView)localObject).setOnClickListener(this);
    if ((AppSetting.jdField_c_of_type_Boolean) && (((OCRBottomTabView)localObject).isEnabled())) {
      bcvq.a((View)localObject, String.valueOf(((OCRBottomTabView)localObject).a()).trim());
    }
    localObject = (OCRBottomTabView)paramView.findViewById(2131371327);
    ((OCRBottomTabView)localObject).setOnClickListener(this);
    if ((AppSetting.jdField_c_of_type_Boolean) && (((OCRBottomTabView)localObject).isEnabled())) {
      bcvq.a((View)localObject, String.valueOf(((OCRBottomTabView)localObject).a()).trim());
    }
    localObject = (OCRBottomTabView)paramView.findViewById(2131371326);
    ((OCRBottomTabView)localObject).setOnClickListener(this);
    if ((AppSetting.jdField_c_of_type_Boolean) && (((OCRBottomTabView)localObject).isEnabled())) {
      bcvq.a((View)localObject, String.valueOf(((OCRBottomTabView)localObject).a()).trim());
    }
    localObject = (OCRBottomTabView)paramView.findViewById(2131371330);
    ((OCRBottomTabView)localObject).setOnClickListener(this);
    if ((AppSetting.jdField_c_of_type_Boolean) && (((OCRBottomTabView)localObject).isEnabled())) {
      bcvq.a((View)localObject, String.valueOf(((OCRBottomTabView)localObject).a()).trim());
    }
    this.jdField_b_of_type_JavaLangString = getResources().getString(2131699576);
    this.jdField_a_of_type_ComTencentMobileqqOcrViewOcrImageTextView = ((OcrImageTextView)paramView.findViewById(2131371320));
    this.jdField_a_of_type_ComTencentMobileqqOcrViewOcrImageTextView.setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqOcrViewOcrImageTextView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqOcrViewOcrImageTextView.setHideAnimLisnter(this);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131371322));
    localObject = (ImageButton)paramView.findViewById(2131371324);
    ((ImageButton)localObject).setOnClickListener(this);
    bcvq.a((View)localObject, getResources().getString(2131690623), null);
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131371321));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131371316));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131371317));
    this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactBubbleLayout = ((BubbleLayout)paramView.findViewById(2131371312));
    this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactBubbleLayout.setSelected(true);
    localObject = (EyeButton)paramView.findViewById(2131371325);
    bcvq.a((View)localObject, getResources().getString(2131699615), null);
    ((EyeButton)localObject).setLonTouchListener(new avrd(this));
    this.jdField_c_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131371323));
    this.jdField_c_of_type_AndroidWidgetRelativeLayout.bringToFront();
    ancj.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_c_of_type_AndroidWidgetRelativeLayout);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131371319));
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(4);
    this.jdField_a_of_type_ComTencentMobileqqOcrViewGestureGestureFrameLayout = ((GestureFrameLayout)paramView.findViewById(2131367124));
  }
  
  private void a(asfn paramasfn)
  {
    if (!arof.a(paramasfn.jdField_b_of_type_JavaLangString))
    {
      QLog.d("OCRPerformFragment", 1, "requestOcr, file not exist, picPath:" + paramasfn.jdField_b_of_type_JavaLangString);
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 1, 2131699590, 0).a();
      return;
    }
    if (this.jdField_b_of_type_Boolean)
    {
      QLog.d("OCRPerformFragment", 1, "requestOcr, in ocr request, " + paramasfn.jdField_b_of_type_JavaLangString);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("OCRPerformFragment", 2, "requestOcr:" + paramasfn.jdField_b_of_type_JavaLangString);
    }
    this.jdField_a_of_type_ComTencentMobileqqOcrViewOcrImageTextView.a(true);
    i();
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    ((asfk)((QQAppInterface)this.jdField_a_of_type_MqqUtilWeakReference.get()).getManager(353)).a(paramasfn, this.jdField_a_of_type_Asfo);
    this.jdField_b_of_type_Int += 1;
  }
  
  private void a(String paramString)
  {
    avrh.b(a());
    Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, OCRResultFragmentNew.class);
    localIntent.putExtra("param_ocr_path", paramString);
    PublicFragmentActivity.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, localIntent, OCRResultFragmentNew.class);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.overridePendingTransition(0, 0);
  }
  
  private void a(boolean paramBoolean, String paramString, ArrayList<String> paramArrayList, asfr paramasfr)
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.bringToFront();
    if (QLog.isColorLevel()) {
      QLog.d("OCRPerformFragment", 2, "updateOcrResult, 更新OCR结果，主线程调用, succ:" + paramBoolean);
    }
    this.jdField_a_of_type_Long = (System.currentTimeMillis() - this.jdField_a_of_type_Long);
    if ((paramBoolean) && (paramasfr.jdField_a_of_type_JavaUtilArrayList != null) && (!paramasfr.jdField_a_of_type_JavaUtilArrayList.isEmpty()))
    {
      avrh.a(avrh.a(paramasfr.jdField_a_of_type_JavaUtilArrayList));
      avrh.a(paramString, paramArrayList, paramasfr.jdField_a_of_type_JavaUtilHashMap);
      this.jdField_a_of_type_ComTencentMobileqqOcrViewOcrImageTextView.a(paramasfr.jdField_a_of_type_JavaUtilArrayList, paramasfr.jdField_a_of_type_Int, paramasfr.jdField_b_of_type_Int, paramasfr.jdField_a_of_type_JavaLangString);
      bcvq.a(this.jdField_a_of_type_ComTencentMobileqqOcrViewOcrImageTextView, avrh.a(), null);
      if (avrh.a != null)
      {
        avrh.a.jdField_a_of_type_JavaLangString = paramasfr.jdField_b_of_type_JavaLangString;
        avrh.a.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
        avrh.a.jdField_d_of_type_JavaLangString = paramasfr.jdField_a_of_type_JavaLangString;
        avrh.a.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
        avrh.a.f = paramasfr.jdField_c_of_type_JavaLangString;
        avrh.a.jdField_b_of_type_Int = paramasfr.jdField_d_of_type_Int;
        avrh.a.jdField_c_of_type_Int = paramasfr.e;
        avrh.a.jdField_a_of_type_Long = paramasfr.jdField_c_of_type_Int;
        avrh.a.e = paramasfr.jdField_d_of_type_JavaLangString;
      }
      if (this.jdField_a_of_type_Long > 0L) {
        avrh.a("0X800AD16", (int)this.jdField_a_of_type_Long);
      }
      if (this.jdField_b_of_type_Int <= 1) {
        avrh.a("0X800AD17", 0);
      }
      return;
    }
    QQToast.a(BaseApplicationImpl.getContext(), 1, 2131699591, 0).a();
    avrh.a("0X800AD18", 0);
    onBackEvent();
  }
  
  private void b(List<avuq> paramList)
  {
    paramList = new avur(this.jdField_a_of_type_ComTencentMobileqqOcrViewGestureGestureFrameLayout, paramList, this, this);
    this.jdField_a_of_type_ComTencentMobileqqOcrViewGestureGestureFrameLayout.a().a(paramList);
  }
  
  private void d()
  {
    SharedPreferences localSharedPreferences = ((QQAppInterface)this.jdField_a_of_type_MqqUtilWeakReference.get()).getApp().getSharedPreferences("check_update_sp_key", 0);
    String str = "businessinfo_ocr_gesture_guide_" + ((QQAppInterface)this.jdField_a_of_type_MqqUtilWeakReference.get()).getCurrentAccountUin();
    if (localSharedPreferences.getBoolean(str, true))
    {
      this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130841139);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131699620);
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      localSharedPreferences.edit().putBoolean(str, false).commit();
      return;
    }
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
  }
  
  private void e()
  {
    SharedPreferences localSharedPreferences = ((QQAppInterface)this.jdField_a_of_type_MqqUtilWeakReference.get()).getApp().getSharedPreferences("check_update_sp_key", 0);
    String str = "businessinfo_ocr_gesture_select_guide_" + ((QQAppInterface)this.jdField_a_of_type_MqqUtilWeakReference.get()).getCurrentAccountUin();
    if (localSharedPreferences.getBoolean(str, true))
    {
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130841140);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131699621);
      localSharedPreferences.edit().putBoolean(str, false).commit();
      return;
    }
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
  }
  
  private void f()
  {
    SharedPreferences localSharedPreferences = ((QQAppInterface)this.jdField_a_of_type_MqqUtilWeakReference.get()).getApp().getSharedPreferences("check_update_sp_key", 0);
    String str = "businessinfo_ocr_gesture_fullText_guide_" + ((QQAppInterface)this.jdField_a_of_type_MqqUtilWeakReference.get()).getCurrentAccountUin();
    if (localSharedPreferences.getBoolean(str, true))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactBubbleLayout.setVisibility(0);
      localSharedPreferences.edit().putBoolean(str, false).commit();
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactBubbleLayout.setVisibility(8);
  }
  
  private void g()
  {
    String str1 = getResources().getString(2131699619);
    String str2 = getResources().getString(2131699622);
    if (this.jdField_a_of_type_ComTencentMobileqqOcrViewOcrImageTextView.b())
    {
      OCRBottomTabView localOCRBottomTabView = (OCRBottomTabView)this.jdField_a_of_type_AndroidViewView.findViewById(2131371326);
      String str3 = String.valueOf(localOCRBottomTabView.a());
      if (!str3.contains(str2)) {
        localOCRBottomTabView.setTabText(str3 + str2);
      }
      localOCRBottomTabView = (OCRBottomTabView)this.jdField_a_of_type_AndroidViewView.findViewById(2131371329);
      str3 = String.valueOf(localOCRBottomTabView.a());
      if (!str3.contains(str2)) {
        localOCRBottomTabView.setTabText(str3 + str2);
      }
      localOCRBottomTabView = (OCRBottomTabView)this.jdField_a_of_type_AndroidViewView.findViewById(2131371330);
      str3 = String.valueOf(localOCRBottomTabView.a());
      if (!str3.contains(str2)) {
        localOCRBottomTabView.setTabText(str3 + str2);
      }
      localOCRBottomTabView = (OCRBottomTabView)this.jdField_a_of_type_AndroidViewView.findViewById(2131371328);
      str3 = String.valueOf(localOCRBottomTabView.a());
      if (!str3.contains(str2)) {
        localOCRBottomTabView.setTabText(str3.replace(str1, str2));
      }
      this.jdField_b_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString.replace(str1, str2);
      return;
    }
    ((OCRBottomTabView)this.jdField_a_of_type_AndroidViewView.findViewById(2131371326)).setTabText(getResources().getString(2131699616));
    ((OCRBottomTabView)this.jdField_a_of_type_AndroidViewView.findViewById(2131371329)).setTabText(getResources().getString(2131692824));
    ((OCRBottomTabView)this.jdField_a_of_type_AndroidViewView.findViewById(2131371330)).setTabText(getResources().getString(2131699610));
    ((OCRBottomTabView)this.jdField_a_of_type_AndroidViewView.findViewById(2131371328)).setTabText(getResources().getString(2131699617));
    this.jdField_b_of_type_JavaLangString = getResources().getString(2131699576);
  }
  
  private void h()
  {
    this.jdField_a_of_type_Bhpy = bhpy.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    this.jdField_a_of_type_Bhpy.c(this.jdField_b_of_type_JavaLangString);
    this.jdField_a_of_type_Bhpy.b(2131699575);
    this.jdField_a_of_type_Bhpy.c(2131690648);
    this.jdField_a_of_type_Bhpy.a(new avre(this));
    this.jdField_a_of_type_Bhpy.show();
  }
  
  private void i()
  {
    this.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    RelativeLayout.LayoutParams localLayoutParams;
    if (this.jdField_a_of_type_ComTencentMobileqqArmapScanSuccessView == null)
    {
      localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
      this.jdField_a_of_type_ComTencentMobileqqArmapScanSuccessView = new ScanSuccessView(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
      this.jdField_a_of_type_ComTencentMobileqqArmapScanSuccessView.setShowProgress(false);
      this.jdField_a_of_type_ComTencentMobileqqArmapScanSuccessView.setBackgroundColor(2130706432);
      this.jdField_a_of_type_ComTencentMobileqqArmapScanSuccessView.setScale(azgq.jdField_a_of_type_Int);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_ComTencentMobileqqArmapScanSuccessView, localLayoutParams);
      this.jdField_a_of_type_ComTencentMobileqqArmapScanSuccessView.setScanText(alpo.a(2131708199));
    }
    if (this.jdField_a_of_type_AndroidWidgetImageView == null)
    {
      localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      this.jdField_a_of_type_AndroidWidgetImageView = new ImageView(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130842876);
      localLayoutParams.leftMargin = aekt.a(12.0F, getResources());
      if (ImmersiveUtils.isSupporImmersive() != 1) {
        break label225;
      }
    }
    label225:
    for (localLayoutParams.topMargin = (ImmersiveUtils.getStatusBarHeight(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity) + aekt.a(12.0F, getResources()));; localLayoutParams.topMargin = aekt.a(12.0F, getResources()))
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_AndroidWidgetImageView, localLayoutParams);
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new avrf(this));
      this.jdField_a_of_type_AndroidWidgetImageView.bringToFront();
      return;
    }
  }
  
  private void j()
  {
    if (this.jdField_a_of_type_AndroidWidgetImageView != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("OCRPerformFragment", 2, "hideInRecoViewAnimation, mRecognizeBackBtn");
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.removeView(this.jdField_a_of_type_AndroidWidgetImageView);
      this.jdField_a_of_type_AndroidWidgetImageView = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqArmapScanSuccessView != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("OCRPerformFragment", 2, "hideInRecoViewAnimation, mRecognizeView");
      }
      this.jdField_a_of_type_ComTencentMobileqqArmapScanSuccessView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.removeView(this.jdField_a_of_type_ComTencentMobileqqArmapScanSuccessView);
      this.jdField_a_of_type_ComTencentMobileqqArmapScanSuccessView = null;
    }
    this.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
  }
  
  public void a()
  {
    g();
  }
  
  public void a(List<avuq> paramList)
  {
    if (paramList != null) {
      b(paramList);
    }
    j();
    c();
  }
  
  public boolean a()
  {
    float f = this.jdField_a_of_type_ComTencentMobileqqOcrViewGestureGestureFrameLayout.a().a().c();
    boolean bool;
    if (f > 1.0F) {
      bool = true;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("OCRPerformFragment", 2, new Object[] { "checkImageFitView, zoom:", Float.valueOf(f), " result:", Boolean.valueOf(bool) });
      }
      return bool;
      if (f == 1.0F)
      {
        if (!this.jdField_a_of_type_ComTencentMobileqqOcrViewOcrImageTextView.a(this.jdField_a_of_type_ComTencentMobileqqOcrViewGestureGestureFrameLayout.getHeight())) {
          bool = true;
        } else {
          bool = false;
        }
      }
      else {
        bool = false;
      }
    }
  }
  
  public void b()
  {
    if (!this.d)
    {
      this.d = true;
      d();
    }
  }
  
  public void c()
  {
    if (!this.jdField_c_of_type_Boolean)
    {
      this.jdField_c_of_type_Boolean = true;
      e();
    }
    do
    {
      return;
      if ((!this.d) && (!this.jdField_a_of_type_ComTencentMobileqqOcrViewOcrImageTextView.a(this.jdField_a_of_type_ComTencentMobileqqOcrViewGestureGestureFrameLayout.getHeight())))
      {
        this.d = true;
        d();
        return;
      }
    } while (this.e);
    this.e = true;
    f();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (QLog.isColorLevel()) {
      QLog.i("OCRPerformFragment", 2, "what:" + paramMessage.what);
    }
    if (paramMessage.what == 100)
    {
      paramMessage = (Bitmap)paramMessage.obj;
      if (paramMessage != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqOcrViewOcrImageTextView.setImageBitmap(paramMessage);
        this.jdField_a_of_type_Boolean = true;
        if (this.jdField_a_of_type_Asfr != null)
        {
          if (QLog.isColorLevel()) {
            QLog.i("OCRPerformFragment", 2, "onUpdate useLocalResult！");
          }
          this.jdField_a_of_type_Asfo.onUpdate(100, true, this.jdField_a_of_type_Asfr);
        }
      }
    }
    do
    {
      do
      {
        return true;
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 1, 2131699581, 0).a();
        onBackEvent();
        return true;
        if (paramMessage.what == 101)
        {
          QQToast.a(BaseApplicationImpl.getContext(), 1, 2131699591, 0).a();
          onBackEvent();
          return true;
        }
      } while (paramMessage.what != 102);
      paramMessage = (asfr)paramMessage.obj;
    } while (paramMessage == null);
    if (this.jdField_a_of_type_Boolean)
    {
      if (QLog.isColorLevel()) {
        QLog.i("OCRPerformFragment", 2, "onUpdate useRspCache！");
      }
      this.jdField_a_of_type_Asfo.onUpdate(100, true, paramMessage);
      return true;
    }
    this.jdField_a_of_type_Asfr = paramMessage;
    return true;
  }
  
  public void initWindowStyleAndAnimation(Activity paramActivity)
  {
    paramActivity.overridePendingTransition(2130771979, 2130771977);
    paramActivity.getWindow().setFlags(1024, 1024);
    if (Build.VERSION.SDK_INT >= 19)
    {
      paramActivity.getWindow().getDecorView().setSystemUiVisibility(5);
      paramActivity.getWindow().addFlags(134217728);
    }
  }
  
  public boolean needImmersive()
  {
    return false;
  }
  
  public boolean needStatusTrans()
  {
    return false;
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = ((BaseActivity)paramActivity);
  }
  
  public boolean onBackEvent()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.finish();
    }
    return true;
  }
  
  public void onClick(View paramView)
  {
    int i = 2;
    int j = 1;
    boolean bool = true;
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131371324: 
      avrh.a("0X800AAE0", 0);
      onBackEvent();
      return;
    case 2131371325: 
      paramView = this.jdField_a_of_type_ComTencentMobileqqOcrViewOcrImageTextView;
      if (!this.jdField_a_of_type_ComTencentMobileqqOcrViewOcrImageTextView.a()) {}
      for (;;)
      {
        paramView.setShowTextMask(bool);
        return;
        bool = false;
      }
    case 2131371327: 
      avrh.b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_JavaLangString);
      avrh.a("0X800AAE2", 0);
      return;
    case 2131371326: 
      baja.a(String.valueOf(a()), "OCRPerformFragment");
      i = j;
      if (this.jdField_a_of_type_ComTencentMobileqqOcrViewOcrImageTextView.b()) {
        i = 2;
      }
      avrh.a("0X800AAE7", i);
      return;
    case 2131371330: 
      TranslateFragment.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, String.valueOf(a()));
      if (this.jdField_a_of_type_ComTencentMobileqqOcrViewOcrImageTextView.b()) {}
      for (;;)
      {
        avrh.a("0X800AAEB", i);
        return;
        i = 1;
      }
    case 2131371329: 
      if (this.jdField_a_of_type_ComTencentMobileqqOcrViewOcrImageTextView.b()) {}
      for (;;)
      {
        avrh.a("0X800AAE8", i);
        h();
        return;
        i = 1;
      }
    case 2131371328: 
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactBubbleLayout != null) && (this.jdField_a_of_type_AndroidWidgetLinearLayout.getVisibility() != 8)) {
        this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactBubbleLayout.setVisibility(8);
      }
      a(this.jdField_a_of_type_JavaLangString);
      if (this.jdField_a_of_type_ComTencentMobileqqOcrViewOcrImageTextView.b()) {}
      for (;;)
      {
        avrh.a("0X800AAEC", i);
        return;
        i = 1;
      }
    case 2131364910: 
      baja.a(String.valueOf(a()), "OCRPerformFragment");
      avrh.a("0X800AAEF", 0);
      return;
    case 2131366750: 
      avrh.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, String.valueOf(a()));
      avrh.a("0X800AAF0", 0);
      return;
    case 2131378200: 
      TranslateFragment.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, String.valueOf(a()));
      avrh.a("0X800AB91", 0);
      return;
    }
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    c();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = getActivity().getIntent();
    this.jdField_a_of_type_JavaLangString = paramBundle.getStringExtra("param_ocr_path");
    if (QLog.isColorLevel()) {
      QLog.e("OCRPerformFragment", 2, "mPicPath=" + this.jdField_a_of_type_JavaLangString);
    }
    int i = paramBundle.getIntExtra("param_business_type", -1);
    paramBundle = paramBundle.getStringExtra("param_ocr_md5");
    if (avrh.a == null)
    {
      avrh.a = new asfn();
      avrh.a.jdField_a_of_type_JavaLangString = "";
      avrh.a.jdField_a_of_type_Boolean = false;
    }
    avrh.a.jdField_a_of_type_Int = i;
    avrh.a.jdField_d_of_type_JavaLangString = paramBundle;
    avrh.a.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = new avrc(this);
    paramBundle = new IntentFilter();
    paramBundle.addAction("tencent.av.v2q.StartVideoChat");
    try
    {
      getActivity().registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, paramBundle);
      this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference((QQAppInterface)bllv.a());
      if (this.jdField_a_of_type_MqqUtilWeakReference.get() != null) {
        ((QQAppInterface)this.jdField_a_of_type_MqqUtilWeakReference.get()).addObserver(this.jdField_a_of_type_Asfo);
      }
      return;
    }
    catch (Exception paramBundle)
    {
      for (;;)
      {
        paramBundle.printStackTrace();
      }
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131561108, paramViewGroup, false);
    a(paramLayoutInflater);
    ThreadManager.excute(new OCRPerformFragment.2(this), 16, null, true);
    a(avrh.a);
    this.jdField_a_of_type_AndroidViewView = paramLayoutInflater;
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("OCRPerformFragment", 2, "onDestroy!");
    }
    if (this.jdField_a_of_type_AndroidContentBroadcastReceiver != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      this.jdField_a_of_type_AndroidContentBroadcastReceiver = null;
    }
    ((QQAppInterface)this.jdField_a_of_type_MqqUtilWeakReference.get()).removeObserver(this.jdField_a_of_type_Asfo);
    if (this.jdField_a_of_type_ComTencentMobileqqOcrViewOcrImageTextView != null) {
      this.jdField_a_of_type_ComTencentMobileqqOcrViewOcrImageTextView.a();
    }
    avrh.a();
    super.onDestroy();
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    if ((paramIntent != null) && (paramIntent.getIntExtra("sub_business_id", -1) == 103))
    {
      if (!this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.isInMultiWindow()) {
        break label81;
      }
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2131695732, 0).a();
    }
    for (;;)
    {
      azmj.b(null, "dc00898", "", "", "0X80082DD", "0X80082DD", 0, 0, "", "", "", "");
      return;
      label81:
      this.jdField_a_of_type_JavaLangString = paramIntent.getStringExtra("PhotoConst.SINGLE_PHOTO_PATH");
      this.jdField_a_of_type_ComTencentMobileqqOcrViewOcrImageTextView.setImageURI(Uri.fromFile(new File(this.jdField_a_of_type_JavaLangString)));
      this.jdField_a_of_type_ComTencentMobileqqOcrViewGestureGestureFrameLayout.a().b();
      this.jdField_a_of_type_ComTencentMobileqqOcrViewOcrImageTextView.setShowTextMask(false);
      avrh.a.a();
      avrh.a.b(this.jdField_a_of_type_JavaLangString);
      avrh.a.a(true);
      a(avrh.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.OCRPerformFragment
 * JD-Core Version:    0.7.0.1
 */