package com.tencent.mobileqq.ocr;

import agej;
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
import anzj;
import apsw;
import auog;
import avik;
import avin;
import avio;
import avir;
import ayxw;
import ayxx;
import ayxy;
import ayxz;
import ayya;
import ayyb;
import ayyc;
import azbk;
import azbl;
import azbm;
import azcn;
import bdep;
import bdll;
import behj;
import bhga;
import bhmq;
import blhq;
import blir;
import bplg;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.contact.addcontact.findtroop.BubbleLayout;
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
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.tfm.metrics.api.Metrics;
import com.tencent.tfm.metrics.api.MetricsApi;
import com.tencent.tfm.metrics.api.SuccessRateMeasure;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import mqq.util.WeakReference;

public class OCRPerformFragment
  extends PublicBaseFragment
  implements Handler.Callback, View.OnClickListener, ayyc, azbm
{
  public static String a;
  public static String b;
  int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long = -1L;
  BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = null;
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private avio jdField_a_of_type_Avio = new ayya(this);
  private avir jdField_a_of_type_Avir;
  public final blhq a;
  private blir jdField_a_of_type_Blir;
  private BubbleLayout jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactFindtroopBubbleLayout;
  private BaseActivity jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
  private ScanSuccessView jdField_a_of_type_ComTencentMobileqqArmapScanSuccessView;
  private OcrImageTextView jdField_a_of_type_ComTencentMobileqqOcrViewOcrImageTextView;
  private GestureFrameLayout jdField_a_of_type_ComTencentMobileqqOcrViewGestureGestureFrameLayout;
  private WeakReference<QQAppInterface> jdField_a_of_type_MqqUtilWeakReference;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  private boolean jdField_b_of_type_Boolean;
  private RelativeLayout jdField_c_of_type_AndroidWidgetRelativeLayout;
  private String jdField_c_of_type_JavaLangString;
  private boolean jdField_c_of_type_Boolean;
  private String jdField_d_of_type_JavaLangString;
  private boolean jdField_d_of_type_Boolean;
  private boolean e;
  
  static
  {
    jdField_a_of_type_JavaLangString = "OCR_REQUEST";
    jdField_b_of_type_JavaLangString = "requestOcr";
  }
  
  public OCRPerformFragment()
  {
    this.jdField_a_of_type_Blhq = new blhq(Looper.getMainLooper(), this);
  }
  
  private CharSequence a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqOcrViewOcrImageTextView != null) && (this.jdField_a_of_type_ComTencentMobileqqOcrViewOcrImageTextView.b())) {}
    for (CharSequence localCharSequence = this.jdField_a_of_type_ComTencentMobileqqOcrViewOcrImageTextView.a();; localCharSequence = ayyb.a())
    {
      ayyb.b(localCharSequence);
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
    ayyb.a("0X80082C7", 0);
  }
  
  private void a(View paramView)
  {
    Object localObject = (OCRBottomTabView)paramView.findViewById(2131372027);
    ((OCRBottomTabView)localObject).setOnClickListener(this);
    if ((AppSetting.jdField_c_of_type_Boolean) && (((OCRBottomTabView)localObject).isEnabled())) {
      bhga.a((View)localObject, String.valueOf(((OCRBottomTabView)localObject).a()).trim());
    }
    localObject = (OCRBottomTabView)paramView.findViewById(2131372026);
    ((OCRBottomTabView)localObject).setOnClickListener(this);
    if ((AppSetting.jdField_c_of_type_Boolean) && (((OCRBottomTabView)localObject).isEnabled())) {
      bhga.a((View)localObject, String.valueOf(((OCRBottomTabView)localObject).a()).trim());
    }
    localObject = (OCRBottomTabView)paramView.findViewById(2131372025);
    ((OCRBottomTabView)localObject).setOnClickListener(this);
    if ((AppSetting.jdField_c_of_type_Boolean) && (((OCRBottomTabView)localObject).isEnabled())) {
      bhga.a((View)localObject, String.valueOf(((OCRBottomTabView)localObject).a()).trim());
    }
    localObject = (OCRBottomTabView)paramView.findViewById(2131372024);
    ((OCRBottomTabView)localObject).setOnClickListener(this);
    if ((AppSetting.jdField_c_of_type_Boolean) && (((OCRBottomTabView)localObject).isEnabled())) {
      bhga.a((View)localObject, String.valueOf(((OCRBottomTabView)localObject).a()).trim());
    }
    localObject = (OCRBottomTabView)paramView.findViewById(2131372028);
    ((OCRBottomTabView)localObject).setOnClickListener(this);
    if ((AppSetting.jdField_c_of_type_Boolean) && (((OCRBottomTabView)localObject).isEnabled())) {
      bhga.a((View)localObject, String.valueOf(((OCRBottomTabView)localObject).a()).trim());
    }
    this.jdField_d_of_type_JavaLangString = getResources().getString(2131698224);
    this.jdField_a_of_type_ComTencentMobileqqOcrViewOcrImageTextView = ((OcrImageTextView)paramView.findViewById(2131372018));
    this.jdField_a_of_type_ComTencentMobileqqOcrViewOcrImageTextView.setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqOcrViewOcrImageTextView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqOcrViewOcrImageTextView.setHideAnimLisnter(this);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131372020));
    localObject = (ImageButton)paramView.findViewById(2131372022);
    ((ImageButton)localObject).setOnClickListener(this);
    bhga.a((View)localObject, getResources().getString(2131690559), null);
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131372019));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131372014));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131372015));
    this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactFindtroopBubbleLayout = ((BubbleLayout)paramView.findViewById(2131372010));
    this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactFindtroopBubbleLayout.setSelected(true);
    localObject = (EyeButton)paramView.findViewById(2131372023);
    bhga.a((View)localObject, getResources().getString(2131698249), null);
    ((EyeButton)localObject).setLonTouchListener(new ayxx(this));
    this.jdField_c_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131372021));
    this.jdField_c_of_type_AndroidWidgetRelativeLayout.bringToFront();
    apsw.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_c_of_type_AndroidWidgetRelativeLayout);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131372017));
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(4);
    this.jdField_a_of_type_ComTencentMobileqqOcrViewGestureGestureFrameLayout = ((GestureFrameLayout)paramView.findViewById(2131367488));
  }
  
  private void a(avin paramavin)
  {
    if (!auog.a(paramavin.jdField_b_of_type_JavaLangString))
    {
      QLog.d("OCRPerformFragment", 1, "requestOcr, file not exist, picPath:" + paramavin.jdField_b_of_type_JavaLangString);
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 1, 2131698232, 0).a();
      return;
    }
    if (this.jdField_b_of_type_Boolean)
    {
      QLog.d("OCRPerformFragment", 1, "requestOcr, in ocr request, " + paramavin.jdField_b_of_type_JavaLangString);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("OCRPerformFragment", 2, "requestOcr:" + paramavin.jdField_b_of_type_JavaLangString);
    }
    this.jdField_a_of_type_ComTencentMobileqqOcrViewOcrImageTextView.a(true);
    i();
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    ((avik)((QQAppInterface)this.jdField_a_of_type_MqqUtilWeakReference.get()).getManager(353)).a(paramavin, this.jdField_a_of_type_Avio);
    this.jdField_b_of_type_Int += 1;
  }
  
  private void a(String paramString)
  {
    ayyb.b(a());
    Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, OCRResultFragmentNew.class);
    localIntent.putExtra("param_ocr_path", paramString);
    PublicFragmentActivity.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, localIntent, OCRResultFragmentNew.class);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.overridePendingTransition(0, 0);
  }
  
  private void a(boolean paramBoolean, String paramString, ArrayList<String> paramArrayList, avir paramavir)
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.bringToFront();
    if (QLog.isColorLevel()) {
      QLog.d("OCRPerformFragment", 2, "updateOcrResult, 更新OCR结果，主线程调用, succ:" + paramBoolean);
    }
    this.jdField_a_of_type_Long = (System.currentTimeMillis() - this.jdField_a_of_type_Long);
    if ((paramBoolean) && (paramavir.jdField_a_of_type_JavaUtilArrayList != null) && (!paramavir.jdField_a_of_type_JavaUtilArrayList.isEmpty()))
    {
      ((SuccessRateMeasure)MetricsApi.getDefault().get(jdField_a_of_type_JavaLangString, SuccessRateMeasure.class)).recordSuccess(new String[] { jdField_b_of_type_JavaLangString, "success" });
      int i = bhmq.b(this.jdField_c_of_type_JavaLangString);
      ayyb.a(ayyb.a(paramavir.jdField_a_of_type_JavaUtilArrayList));
      ayyb.a(paramString, paramArrayList, paramavir.jdField_a_of_type_JavaUtilHashMap);
      this.jdField_a_of_type_ComTencentMobileqqOcrViewOcrImageTextView.a(paramavir.jdField_a_of_type_JavaUtilArrayList, paramavir.jdField_a_of_type_Int, paramavir.jdField_b_of_type_Int, paramavir.jdField_a_of_type_JavaLangString, i);
      bhga.a(this.jdField_a_of_type_ComTencentMobileqqOcrViewOcrImageTextView, ayyb.a(), null);
      if (ayyb.a != null)
      {
        ayyb.a.jdField_a_of_type_JavaLangString = paramavir.jdField_b_of_type_JavaLangString;
        ayyb.a.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
        ayyb.a.jdField_d_of_type_JavaLangString = paramavir.jdField_a_of_type_JavaLangString;
        ayyb.a.jdField_b_of_type_JavaLangString = this.jdField_c_of_type_JavaLangString;
        ayyb.a.f = paramavir.jdField_c_of_type_JavaLangString;
        ayyb.a.jdField_b_of_type_Int = paramavir.jdField_d_of_type_Int;
        ayyb.a.jdField_c_of_type_Int = paramavir.e;
        ayyb.a.jdField_a_of_type_Long = paramavir.jdField_c_of_type_Int;
        ayyb.a.e = paramavir.jdField_d_of_type_JavaLangString;
      }
      if (this.jdField_a_of_type_Long > 0L) {
        ayyb.a("0X800AD16", (int)this.jdField_a_of_type_Long);
      }
      if (this.jdField_b_of_type_Int <= 1) {
        ayyb.a("0X800AD17", 0);
      }
      return;
    }
    ((SuccessRateMeasure)MetricsApi.getDefault().get(jdField_a_of_type_JavaLangString, SuccessRateMeasure.class)).recordFail(new String[] { jdField_b_of_type_JavaLangString, "failure" });
    QQToast.a(BaseApplicationImpl.getContext(), 1, 2131698233, 0).a();
    ayyb.a("0X800AD18", 0);
    onBackEvent();
  }
  
  private void b(List<azbk> paramList)
  {
    paramList = new azbl(this.jdField_a_of_type_ComTencentMobileqqOcrViewGestureGestureFrameLayout, paramList, this, this);
    this.jdField_a_of_type_ComTencentMobileqqOcrViewGestureGestureFrameLayout.a().a(paramList);
  }
  
  private void d()
  {
    SharedPreferences localSharedPreferences = ((QQAppInterface)this.jdField_a_of_type_MqqUtilWeakReference.get()).getApp().getSharedPreferences("check_update_sp_key", 0);
    String str = "businessinfo_ocr_gesture_guide_" + ((QQAppInterface)this.jdField_a_of_type_MqqUtilWeakReference.get()).getCurrentAccountUin();
    if (localSharedPreferences.getBoolean(str, true))
    {
      this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130841440);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131698254);
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
      this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130841441);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131698255);
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
      this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactFindtroopBubbleLayout.setVisibility(0);
      localSharedPreferences.edit().putBoolean(str, false).commit();
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactFindtroopBubbleLayout.setVisibility(8);
  }
  
  private void g()
  {
    String str1 = getResources().getString(2131698253);
    String str2 = getResources().getString(2131698256);
    if (this.jdField_a_of_type_ComTencentMobileqqOcrViewOcrImageTextView.b())
    {
      OCRBottomTabView localOCRBottomTabView = (OCRBottomTabView)this.jdField_a_of_type_AndroidViewView.findViewById(2131372024);
      String str3 = String.valueOf(localOCRBottomTabView.a());
      if (!str3.contains(str2)) {
        localOCRBottomTabView.setTabText(str3 + str2);
      }
      localOCRBottomTabView = (OCRBottomTabView)this.jdField_a_of_type_AndroidViewView.findViewById(2131372027);
      str3 = String.valueOf(localOCRBottomTabView.a());
      if (!str3.contains(str2)) {
        localOCRBottomTabView.setTabText(str3 + str2);
      }
      localOCRBottomTabView = (OCRBottomTabView)this.jdField_a_of_type_AndroidViewView.findViewById(2131372028);
      str3 = String.valueOf(localOCRBottomTabView.a());
      if (!str3.contains(str2)) {
        localOCRBottomTabView.setTabText(str3 + str2);
      }
      localOCRBottomTabView = (OCRBottomTabView)this.jdField_a_of_type_AndroidViewView.findViewById(2131372026);
      str3 = String.valueOf(localOCRBottomTabView.a());
      if (!str3.contains(str2)) {
        localOCRBottomTabView.setTabText(str3.replace(str1, str2));
      }
      this.jdField_d_of_type_JavaLangString = this.jdField_d_of_type_JavaLangString.replace(str1, str2);
      return;
    }
    ((OCRBottomTabView)this.jdField_a_of_type_AndroidViewView.findViewById(2131372024)).setTabText(getResources().getString(2131698250));
    ((OCRBottomTabView)this.jdField_a_of_type_AndroidViewView.findViewById(2131372027)).setTabText(getResources().getString(2131692394));
    ((OCRBottomTabView)this.jdField_a_of_type_AndroidViewView.findViewById(2131372028)).setTabText(getResources().getString(2131698244));
    ((OCRBottomTabView)this.jdField_a_of_type_AndroidViewView.findViewById(2131372026)).setTabText(getResources().getString(2131698251));
    this.jdField_d_of_type_JavaLangString = getResources().getString(2131698224);
  }
  
  private void h()
  {
    this.jdField_a_of_type_Blir = blir.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    this.jdField_a_of_type_Blir.c(this.jdField_d_of_type_JavaLangString);
    this.jdField_a_of_type_Blir.b(2131698223);
    this.jdField_a_of_type_Blir.c(2131690580);
    this.jdField_a_of_type_Blir.a(new ayxy(this));
    this.jdField_a_of_type_Blir.show();
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
      this.jdField_a_of_type_ComTencentMobileqqArmapScanSuccessView.setScale(bdep.jdField_a_of_type_Int);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_ComTencentMobileqqArmapScanSuccessView, localLayoutParams);
      this.jdField_a_of_type_ComTencentMobileqqArmapScanSuccessView.setScanText(anzj.a(2131706695));
    }
    if (this.jdField_a_of_type_AndroidWidgetImageView == null)
    {
      localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      this.jdField_a_of_type_AndroidWidgetImageView = new ImageView(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130843253);
      localLayoutParams.leftMargin = agej.a(12.0F, getResources());
      if (ImmersiveUtils.isSupporImmersive() != 1) {
        break label225;
      }
    }
    label225:
    for (localLayoutParams.topMargin = (ImmersiveUtils.getStatusBarHeight(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity) + agej.a(12.0F, getResources()));; localLayoutParams.topMargin = agej.a(12.0F, getResources()))
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_AndroidWidgetImageView, localLayoutParams);
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new ayxz(this));
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
  
  public void a(List<azbk> paramList)
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
    if (!this.jdField_d_of_type_Boolean)
    {
      this.jdField_d_of_type_Boolean = true;
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
      if ((!this.jdField_d_of_type_Boolean) && (!this.jdField_a_of_type_ComTencentMobileqqOcrViewOcrImageTextView.a(this.jdField_a_of_type_ComTencentMobileqqOcrViewGestureGestureFrameLayout.getHeight())))
      {
        this.jdField_d_of_type_Boolean = true;
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
        if (this.jdField_a_of_type_Avir != null)
        {
          if (QLog.isColorLevel()) {
            QLog.i("OCRPerformFragment", 2, "onUpdate useLocalResult！");
          }
          this.jdField_a_of_type_Avio.onUpdate(100, true, this.jdField_a_of_type_Avir);
        }
      }
    }
    do
    {
      do
      {
        return true;
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 1, 2131698228, 0).a();
        onBackEvent();
        return true;
        if (paramMessage.what == 101)
        {
          QQToast.a(BaseApplicationImpl.getContext(), 1, 2131698233, 0).a();
          onBackEvent();
          return true;
        }
      } while (paramMessage.what != 102);
      paramMessage = (avir)paramMessage.obj;
    } while (paramMessage == null);
    if (this.jdField_a_of_type_Boolean)
    {
      if (QLog.isColorLevel()) {
        QLog.i("OCRPerformFragment", 2, "onUpdate useRspCache！");
      }
      this.jdField_a_of_type_Avio.onUpdate(100, true, paramMessage);
      return true;
    }
    this.jdField_a_of_type_Avir = paramMessage;
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
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      ayyb.a("0X800AAE0", 0);
      onBackEvent();
      continue;
      OcrImageTextView localOcrImageTextView = this.jdField_a_of_type_ComTencentMobileqqOcrViewOcrImageTextView;
      if (!this.jdField_a_of_type_ComTencentMobileqqOcrViewOcrImageTextView.a()) {}
      for (;;)
      {
        localOcrImageTextView.setShowTextMask(bool);
        break;
        bool = false;
      }
      ayyb.b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_c_of_type_JavaLangString);
      ayyb.a("0X800AAE2", 0);
      continue;
      behj.a(String.valueOf(a()), "OCRPerformFragment");
      i = j;
      if (this.jdField_a_of_type_ComTencentMobileqqOcrViewOcrImageTextView.b()) {
        i = 2;
      }
      ayyb.a("0X800AAE7", i);
      continue;
      TranslateFragment.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, String.valueOf(a()));
      if (this.jdField_a_of_type_ComTencentMobileqqOcrViewOcrImageTextView.b()) {}
      for (;;)
      {
        ayyb.a("0X800AAEB", i);
        break;
        i = 1;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqOcrViewOcrImageTextView.b()) {}
      for (;;)
      {
        ayyb.a("0X800AAE8", i);
        h();
        break;
        i = 1;
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactFindtroopBubbleLayout != null) && (this.jdField_a_of_type_AndroidWidgetLinearLayout.getVisibility() != 8)) {
        this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactFindtroopBubbleLayout.setVisibility(8);
      }
      a(this.jdField_c_of_type_JavaLangString);
      if (this.jdField_a_of_type_ComTencentMobileqqOcrViewOcrImageTextView.b()) {}
      for (;;)
      {
        ayyb.a("0X800AAEC", i);
        break;
        i = 1;
      }
      behj.a(String.valueOf(a()), "OCRPerformFragment");
      ayyb.a("0X800AAEF", 0);
      continue;
      ayyb.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, String.valueOf(a()));
      ayyb.a("0X800AAF0", 0);
      continue;
      TranslateFragment.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, String.valueOf(a()));
      ayyb.a("0X800AB91", 0);
      continue;
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      c();
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = getActivity().getIntent();
    this.jdField_c_of_type_JavaLangString = paramBundle.getStringExtra("param_ocr_path");
    if (QLog.isColorLevel()) {
      QLog.e("OCRPerformFragment", 2, "mPicPath=" + this.jdField_c_of_type_JavaLangString);
    }
    int i = paramBundle.getIntExtra("param_business_type", -1);
    paramBundle = paramBundle.getStringExtra("param_ocr_md5");
    if (ayyb.a == null)
    {
      ayyb.a = new avin();
      ayyb.a.jdField_a_of_type_JavaLangString = "";
      ayyb.a.jdField_a_of_type_Boolean = false;
    }
    ayyb.a.jdField_a_of_type_Int = i;
    ayyb.a.jdField_d_of_type_JavaLangString = paramBundle;
    ayyb.a.jdField_b_of_type_JavaLangString = this.jdField_c_of_type_JavaLangString;
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = new ayxw(this);
    paramBundle = new IntentFilter();
    paramBundle.addAction("tencent.av.v2q.StartVideoChat");
    try
    {
      getActivity().registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, paramBundle);
      this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference((QQAppInterface)bplg.a());
      if (this.jdField_a_of_type_MqqUtilWeakReference.get() != null) {
        ((QQAppInterface)this.jdField_a_of_type_MqqUtilWeakReference.get()).addObserver(this.jdField_a_of_type_Avio);
      }
      MetricsApi.getDefault().buildSuccessRateCounter(jdField_a_of_type_JavaLangString);
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
    paramLayoutInflater = paramLayoutInflater.inflate(2131561376, paramViewGroup, false);
    a(paramLayoutInflater);
    ThreadManager.excute(new OCRPerformFragment.2(this), 16, null, true);
    a(ayyb.a);
    this.jdField_a_of_type_AndroidViewView = paramLayoutInflater;
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
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
    ((QQAppInterface)this.jdField_a_of_type_MqqUtilWeakReference.get()).removeObserver(this.jdField_a_of_type_Avio);
    if (this.jdField_a_of_type_ComTencentMobileqqOcrViewOcrImageTextView != null) {
      this.jdField_a_of_type_ComTencentMobileqqOcrViewOcrImageTextView.a();
    }
    ayyb.a();
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
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2131694664, 0).a();
    }
    for (;;)
    {
      bdll.b(null, "dc00898", "", "", "0X80082DD", "0X80082DD", 0, 0, "", "", "", "");
      return;
      label81:
      this.jdField_c_of_type_JavaLangString = paramIntent.getStringExtra("PhotoConst.SINGLE_PHOTO_PATH");
      this.jdField_a_of_type_ComTencentMobileqqOcrViewOcrImageTextView.setImageURI(Uri.fromFile(new File(this.jdField_c_of_type_JavaLangString)));
      this.jdField_a_of_type_ComTencentMobileqqOcrViewGestureGestureFrameLayout.a().b();
      this.jdField_a_of_type_ComTencentMobileqqOcrViewOcrImageTextView.setShowTextMask(false);
      ayyb.a.a();
      ayyb.a.b(this.jdField_c_of_type_JavaLangString);
      ayyb.a.a(true);
      a(ayyb.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.OCRPerformFragment
 * JD-Core Version:    0.7.0.1
 */