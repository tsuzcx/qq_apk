package com.tencent.mobileqq.ocr;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
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
import anvx;
import appk;
import avaq;
import avat;
import avau;
import avaw;
import ayri;
import ayrj;
import ayrk;
import ayrl;
import ayrm;
import ayrn;
import ayro;
import ayrp;
import ayrq;
import ayrr;
import ayrs;
import ayrt;
import ayru;
import ayvc;
import ayvd;
import ayve;
import ayvf;
import ayvo;
import ayvq;
import aywg;
import bdla;
import behe;
import bgyd;
import bheg;
import bisl;
import bkys;
import bkzi;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.contact.addcontact.findtroop.BubbleLayout;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.armap.ScanSuccessView;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.ocr.data.TranslateResult;
import com.tencent.mobileqq.ocr.view.EyeButton;
import com.tencent.mobileqq.ocr.view.OcrImageTextView;
import com.tencent.mobileqq.ocr.view.gesture.GestureFrameLayout;
import com.tencent.mobileqq.ocr.view.gesture.GestureProxy;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.OCRBottomTabView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.tfm.metrics.api.Metrics;
import com.tencent.tfm.metrics.api.MetricsApi;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class OCRPerformFragment
  extends PublicBaseFragment
  implements Handler.Callback, View.OnClickListener, ayvf
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long = -1L;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver;
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private avau jdField_a_of_type_Avau = new ayrp(this);
  private avaw jdField_a_of_type_Avaw;
  private ayri jdField_a_of_type_Ayri = new ayrl(this);
  private ayvo jdField_a_of_type_Ayvo;
  private bisl jdField_a_of_type_Bisl;
  private final bkys jdField_a_of_type_Bkys = new bkys(Looper.getMainLooper(), this);
  private bkzi jdField_a_of_type_Bkzi;
  private BubbleLayout jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactFindtroopBubbleLayout;
  private BaseActivity jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
  private ScanSuccessView jdField_a_of_type_ComTencentMobileqqArmapScanSuccessView;
  private TranslateController jdField_a_of_type_ComTencentMobileqqOcrTranslateController;
  private OcrImageTextView jdField_a_of_type_ComTencentMobileqqOcrViewOcrImageTextView;
  private GestureFrameLayout jdField_a_of_type_ComTencentMobileqqOcrViewGestureGestureFrameLayout;
  private String jdField_a_of_type_JavaLangString;
  private volatile boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int = -1;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private ayvo jdField_b_of_type_Ayvo;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean;
  private RelativeLayout jdField_c_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private boolean jdField_c_of_type_Boolean;
  private RelativeLayout jdField_d_of_type_AndroidWidgetRelativeLayout;
  private boolean jdField_d_of_type_Boolean;
  private boolean e;
  
  private CharSequence a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqOcrViewOcrImageTextView != null) && (this.jdField_a_of_type_ComTencentMobileqqOcrViewOcrImageTextView.b()))
    {
      ayrt.jdField_b_of_type_JavaLangCharSequence = this.jdField_a_of_type_ComTencentMobileqqOcrViewOcrImageTextView.a();
      return ayrt.jdField_b_of_type_JavaLangCharSequence;
    }
    if (ayrt.jdField_a_of_type_Boolean) {
      return ayrt.jdField_a_of_type_ComTencentMobileqqOcrDataTranslateResult.a();
    }
    return ayrt.jdField_a_of_type_JavaLangCharSequence;
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
    ayrt.a("0X80082C7", 0);
  }
  
  private void a(View paramView)
  {
    Object localObject = (OCRBottomTabView)paramView.findViewById(2131372183);
    ((OCRBottomTabView)localObject).setOnClickListener(this);
    if ((AppSetting.jdField_c_of_type_Boolean) && (((OCRBottomTabView)localObject).isEnabled())) {
      bgyd.a((View)localObject, String.valueOf(((OCRBottomTabView)localObject).a()).trim());
    }
    localObject = (OCRBottomTabView)paramView.findViewById(2131372182);
    ((OCRBottomTabView)localObject).setOnClickListener(this);
    if ((AppSetting.jdField_c_of_type_Boolean) && (((OCRBottomTabView)localObject).isEnabled())) {
      bgyd.a((View)localObject, String.valueOf(((OCRBottomTabView)localObject).a()).trim());
    }
    localObject = (OCRBottomTabView)paramView.findViewById(2131372181);
    ((OCRBottomTabView)localObject).setOnClickListener(this);
    if ((AppSetting.jdField_c_of_type_Boolean) && (((OCRBottomTabView)localObject).isEnabled())) {
      bgyd.a((View)localObject, String.valueOf(((OCRBottomTabView)localObject).a()).trim());
    }
    localObject = (OCRBottomTabView)paramView.findViewById(2131372180);
    ((OCRBottomTabView)localObject).setOnClickListener(this);
    if ((AppSetting.jdField_c_of_type_Boolean) && (((OCRBottomTabView)localObject).isEnabled())) {
      bgyd.a((View)localObject, String.valueOf(((OCRBottomTabView)localObject).a()).trim());
    }
    localObject = (OCRBottomTabView)paramView.findViewById(2131372184);
    ((OCRBottomTabView)localObject).setOnClickListener(this);
    if ((AppSetting.jdField_c_of_type_Boolean) && (((OCRBottomTabView)localObject).isEnabled())) {
      bgyd.a((View)localObject, String.valueOf(((OCRBottomTabView)localObject).a()).trim());
    }
    this.jdField_b_of_type_JavaLangString = getResources().getString(2131698685);
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_ComTencentMobileqqOcrViewOcrImageTextView = ((OcrImageTextView)paramView.findViewById(2131372174));
    this.jdField_a_of_type_ComTencentMobileqqOcrViewOcrImageTextView.setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqOcrViewOcrImageTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131372176));
    localObject = (ImageButton)paramView.findViewById(2131372178);
    ((ImageButton)localObject).setOnClickListener(this);
    bgyd.a((View)localObject, getResources().getString(2131690676), null);
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131372175));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131372170));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131372171));
    this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactFindtroopBubbleLayout = ((BubbleLayout)paramView.findViewById(2131372166));
    this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactFindtroopBubbleLayout.setSelected(true);
    localObject = (EyeButton)paramView.findViewById(2131372179);
    bgyd.a((View)localObject, getResources().getString(2131698710), null);
    ((EyeButton)localObject).setLonTouchListener(new ayrm(this));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131379326));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131379322));
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_d_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131372185));
    a(ayrt.jdField_a_of_type_Ayru, false);
    this.jdField_c_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131372177));
    this.jdField_c_of_type_AndroidWidgetRelativeLayout.bringToFront();
    appk.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_c_of_type_AndroidWidgetRelativeLayout);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131372173));
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(4);
    this.jdField_a_of_type_ComTencentMobileqqOcrViewGestureGestureFrameLayout = ((GestureFrameLayout)paramView.findViewById(2131367649));
  }
  
  private void a(avat paramavat, boolean paramBoolean)
  {
    if ((paramBoolean) && (ayrt.jdField_a_of_type_Avaw != null))
    {
      a(ayrt.jdField_a_of_type_Avaw, false);
      return;
    }
    if (!FileUtil.isFileExists(paramavat.jdField_b_of_type_JavaLangString))
    {
      QLog.d("OCRPerformFragment", 1, "requestOcr, file not exist, picPath:" + paramavat.jdField_b_of_type_JavaLangString);
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 1, 2131698693, 0).a();
      return;
    }
    if (this.jdField_a_of_type_Boolean)
    {
      QLog.d("OCRPerformFragment", 1, "requestOcr, in ocr request, " + paramavat.jdField_b_of_type_JavaLangString);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("OCRPerformFragment", 2, "requestOcr:" + paramavat.jdField_b_of_type_JavaLangString);
    }
    i();
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    ((avaq)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.getManager(QQManagerFactory.PIC_OCR_MANAGER)).a(paramavat, this.jdField_a_of_type_Avau);
    this.jdField_a_of_type_Int += 1;
  }
  
  private void a(avaw paramavaw, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("OCRPerformFragment", 2, "updateOcrResultData：" + paramavaw.toString());
    }
    if (paramBoolean)
    {
      ayrt.jdField_a_of_type_JavaLangCharSequence = ayrt.a(paramavaw.jdField_a_of_type_JavaUtilArrayList);
      if (!ayrt.jdField_a_of_type_Boolean)
      {
        ayrt.jdField_a_of_type_Ayru = ayrt.a(ayrt.jdField_a_of_type_Ayru, paramavaw.jdField_b_of_type_JavaLangString, paramavaw.jdField_b_of_type_JavaUtilArrayList, paramavaw.jdField_a_of_type_JavaUtilHashMap);
        ayrt.jdField_b_of_type_Ayru = ayrt.a(ayrt.jdField_b_of_type_Ayru, paramavaw.jdField_b_of_type_JavaLangString, paramavaw.jdField_b_of_type_JavaUtilArrayList, paramavaw.jdField_a_of_type_JavaUtilHashMap);
      }
      if (ayrt.jdField_a_of_type_Avat != null)
      {
        ayrt.jdField_a_of_type_Avat.jdField_a_of_type_JavaLangString = paramavaw.jdField_b_of_type_JavaLangString;
        ayrt.jdField_a_of_type_Avat.jdField_a_of_type_Int = this.jdField_b_of_type_Int;
        ayrt.jdField_a_of_type_Avat.jdField_d_of_type_JavaLangString = paramavaw.jdField_a_of_type_JavaLangString;
        ayrt.jdField_a_of_type_Avat.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
        ayrt.jdField_a_of_type_Avat.f = paramavaw.jdField_c_of_type_JavaLangString;
        ayrt.jdField_a_of_type_Avat.jdField_b_of_type_Int = paramavaw.jdField_d_of_type_Int;
        ayrt.jdField_a_of_type_Avat.jdField_c_of_type_Int = paramavaw.e;
        ayrt.jdField_a_of_type_Avat.jdField_a_of_type_Long = paramavaw.jdField_c_of_type_Int;
        ayrt.jdField_a_of_type_Avat.e = paramavaw.jdField_d_of_type_JavaLangString;
      }
      paramavaw.f = bheg.b(this.jdField_a_of_type_JavaLangString);
      ayrt.jdField_a_of_type_Avaw = paramavaw;
    }
    if (ayrt.jdField_a_of_type_Boolean)
    {
      a(ayrt.jdField_a_of_type_Ayru.jdField_b_of_type_JavaLangString, ayrt.jdField_a_of_type_Ayru.jdField_c_of_type_JavaLangString, false);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqOcrViewOcrImageTextView.setResultNormal(ayrt.jdField_a_of_type_Avaw);
    bgyd.a(this.jdField_a_of_type_ComTencentMobileqqOcrViewOcrImageTextView, ayrt.jdField_a_of_type_JavaLangCharSequence, null);
  }
  
  private void a(ayru paramayru)
  {
    if (QLog.isColorLevel()) {
      QLog.d("OCRPerformFragment", 2, "showTranslateSrcLanOptions, lanHolder:" + paramayru.a());
    }
    if ((this.jdField_a_of_type_Ayvo != null) && (this.jdField_a_of_type_Ayvo.isShowing())) {
      this.jdField_a_of_type_Ayvo.dismiss();
    }
    if ((this.jdField_b_of_type_Ayvo != null) && (this.jdField_b_of_type_Ayvo.isShowing())) {
      this.jdField_b_of_type_Ayvo.dismiss();
    }
    while ((paramayru.jdField_b_of_type_JavaUtilList == null) || (paramayru.jdField_b_of_type_JavaUtilList.size() == 0)) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    int j = 0;
    while (i < paramayru.jdField_b_of_type_JavaUtilList.size())
    {
      String str = (String)paramayru.jdField_b_of_type_JavaUtilList.get(i);
      if (str.equalsIgnoreCase(paramayru.jdField_b_of_type_JavaLangString)) {
        j = i;
      }
      ayvq localayvq = new ayvq();
      localayvq.jdField_b_of_type_JavaLangString = str;
      localayvq.jdField_a_of_type_JavaLangString = ayrt.a(str);
      localArrayList.add(localayvq);
      i += 1;
    }
    this.jdField_b_of_type_Ayvo = ayvo.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, localArrayList, j, new ayrq(this, paramayru));
    i = this.jdField_b_of_type_AndroidWidgetTextView.getMeasuredWidth() / 2;
    j = AIOUtils.dp2px(75.0F, getResources());
    this.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
    this.jdField_b_of_type_Ayvo.showAsDropDown(this.jdField_b_of_type_AndroidWidgetTextView, i - j, 0);
    this.jdField_b_of_type_Ayvo.setOnDismissListener(new ayrr(this, paramayru));
  }
  
  private void a(ayru paramayru, boolean paramBoolean)
  {
    int i;
    Object localObject;
    if (paramBoolean)
    {
      i = 2130841486;
      if (!paramBoolean) {
        break label89;
      }
      localObject = "#00CAFC";
      label17:
      OCRBottomTabView localOCRBottomTabView = (OCRBottomTabView)this.jdField_a_of_type_AndroidViewView.findViewById(2131372184);
      if (localOCRBottomTabView != null)
      {
        localOCRBottomTabView.setTabImage(getResources().getDrawable(i));
        localOCRBottomTabView.setTabTextColor(Color.parseColor((String)localObject));
      }
      localObject = this.jdField_d_of_type_AndroidWidgetRelativeLayout;
      if (!paramBoolean) {
        break label97;
      }
      i = 0;
      label71:
      ((RelativeLayout)localObject).setVisibility(i);
      if (paramBoolean) {
        break label103;
      }
    }
    label89:
    label97:
    label103:
    while (paramayru == null)
    {
      return;
      i = 2130841485;
      break;
      localObject = "#FFFFFF";
      break label17;
      i = 8;
      break label71;
    }
    if (QLog.isColorLevel()) {
      QLog.d("OCRPerformFragment", 2, "updateTranslateTitle, lanHolder:" + paramayru.a());
    }
    this.jdField_b_of_type_AndroidWidgetTextView.setText(paramayru.a(paramayru.jdField_b_of_type_JavaLangString));
    this.jdField_c_of_type_AndroidWidgetTextView.setText(paramayru.a(paramayru.jdField_c_of_type_JavaLangString));
    if ((paramayru.jdField_b_of_type_JavaUtilList == null) || (paramayru.jdField_b_of_type_JavaUtilList.size() <= 1))
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setClickable(false);
      this.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
    }
    while ((paramayru.jdField_c_of_type_JavaUtilList == null) || (paramayru.jdField_c_of_type_JavaUtilList.size() <= 1))
    {
      this.jdField_c_of_type_AndroidWidgetTextView.setClickable(false);
      this.jdField_c_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
      return;
      this.jdField_b_of_type_AndroidWidgetTextView.setClickable(true);
      localObject = getResources().getDrawable(2130846151);
      this.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, null, (Drawable)localObject);
    }
    this.jdField_c_of_type_AndroidWidgetTextView.setClickable(true);
    paramayru = getResources().getDrawable(2130846151);
    this.jdField_c_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, null, paramayru);
  }
  
  private void a(TranslateResult paramTranslateResult)
  {
    if (QLog.isColorLevel()) {
      QLog.d("OCRPerformFragment", 2, "src:" + paramTranslateResult.jdField_a_of_type_JavaLangString + ", dst:" + paramTranslateResult.jdField_b_of_type_JavaLangString + ", OCRLanHolder:" + ayrt.jdField_a_of_type_Ayru.a());
    }
    if (ayrt.jdField_a_of_type_Ayru != null)
    {
      ayrt.jdField_a_of_type_Ayru.b(paramTranslateResult.jdField_a_of_type_JavaLangString);
      ayrt.jdField_a_of_type_Ayru.c(paramTranslateResult.jdField_b_of_type_JavaLangString);
      ayrt.jdField_b_of_type_Ayru.a(ayrt.jdField_a_of_type_Ayru.jdField_c_of_type_JavaLangString);
      a(ayrt.jdField_a_of_type_Ayru, ayrt.jdField_a_of_type_Boolean);
    }
    if (QLog.isColorLevel()) {
      QLog.d("OCRPerformFragment", 2, new Object[] { paramTranslateResult.b() });
    }
    this.jdField_a_of_type_ComTencentMobileqqOcrViewOcrImageTextView.setResultSection(paramTranslateResult);
    bgyd.a(this.jdField_a_of_type_ComTencentMobileqqOcrViewOcrImageTextView, paramTranslateResult.c(), null);
  }
  
  private void a(String paramString)
  {
    ayrt.jdField_b_of_type_JavaLangCharSequence = a();
    Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, OCRResultFragmentNew.class);
    localIntent.putExtra("param_ocr_path", paramString);
    PublicFragmentActivity.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, localIntent, OCRResultFragmentNew.class);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.overridePendingTransition(0, 0);
  }
  
  private void a(String paramString1, String paramString2, boolean paramBoolean)
  {
    if ((paramBoolean) && (ayrt.jdField_a_of_type_ComTencentMobileqqOcrDataTranslateResult != null)) {
      a(ayrt.jdField_a_of_type_ComTencentMobileqqOcrDataTranslateResult);
    }
    do
    {
      do
      {
        return;
        if (!this.jdField_a_of_type_Boolean) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("OCRPerformFragment", 2, "updateTranslateTitle, inTranslateRequestNow");
      return;
      if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2))) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("OCRPerformFragment", 2, "updateTranslateTitle, srcLan/dstLan is null");
    return;
    if (!NetworkUtil.isNetworkAvailable(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity))
    {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 1, 2131692125, 0).a();
      ayrt.a("0X800B557", 0);
      return;
    }
    String str = String.valueOf(ayrt.jdField_a_of_type_JavaLangCharSequence);
    if (TextUtils.isEmpty(str))
    {
      QLog.d("OCRPerformFragment", 1, "requestTranslate, mInputTransText null");
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("OCRPerformFragment", 2, "requestTranslate, srcLan:" + paramString1 + ", dstLan:" + paramString2);
    }
    this.jdField_a_of_type_Boolean = true;
    b(false);
    this.jdField_a_of_type_ComTencentMobileqqOcrTranslateController.a(str, paramString1, paramString2);
  }
  
  private void a(List<ayvd> paramList, List<ayvc> paramList1)
  {
    paramList = new ayve(this.jdField_a_of_type_ComTencentMobileqqOcrViewGestureGestureFrameLayout, paramList, paramList1, this, this);
    this.jdField_a_of_type_ComTencentMobileqqOcrViewGestureGestureFrameLayout.a().a(paramList);
  }
  
  private void a(boolean paramBoolean)
  {
    String str1 = getResources().getString(2131698714);
    String str2 = getResources().getString(2131698717);
    OCRBottomTabView localOCRBottomTabView = (OCRBottomTabView)this.jdField_a_of_type_AndroidViewView.findViewById(2131372180);
    if (paramBoolean)
    {
      String str3 = String.valueOf(localOCRBottomTabView.a());
      if (!str3.contains(str2)) {
        localOCRBottomTabView.setTabText(str3 + str2);
      }
      localOCRBottomTabView = (OCRBottomTabView)this.jdField_a_of_type_AndroidViewView.findViewById(2131372183);
      str3 = String.valueOf(localOCRBottomTabView.a());
      if (!str3.contains(str2)) {
        localOCRBottomTabView.setTabText(str3 + str2);
      }
      localOCRBottomTabView = (OCRBottomTabView)this.jdField_a_of_type_AndroidViewView.findViewById(2131372182);
      str3 = String.valueOf(localOCRBottomTabView.a());
      if (!str3.contains(str2)) {
        localOCRBottomTabView.setTabText(str3.replace(str1, str2));
      }
      this.jdField_b_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString.replace(str1, str2);
      return;
    }
    localOCRBottomTabView.setTabText(getResources().getString(2131698711));
    ((OCRBottomTabView)this.jdField_a_of_type_AndroidViewView.findViewById(2131372183)).setTabText(getResources().getString(2131692544));
    ((OCRBottomTabView)this.jdField_a_of_type_AndroidViewView.findViewById(2131372184)).setTabText(getResources().getString(2131698705));
    ((OCRBottomTabView)this.jdField_a_of_type_AndroidViewView.findViewById(2131372182)).setTabText(getResources().getString(2131698712));
    this.jdField_b_of_type_JavaLangString = getResources().getString(2131698685);
  }
  
  private void b(ayru paramayru)
  {
    if (QLog.isColorLevel()) {
      QLog.d("OCRPerformFragment", 2, "showTranslateDstLanOptions, lanHolder:" + paramayru.a());
    }
    if ((this.jdField_b_of_type_Ayvo != null) && (this.jdField_b_of_type_Ayvo.isShowing())) {
      this.jdField_b_of_type_Ayvo.dismiss();
    }
    if ((this.jdField_a_of_type_Ayvo != null) && (this.jdField_a_of_type_Ayvo.isShowing())) {
      this.jdField_a_of_type_Ayvo.dismiss();
    }
    while ((paramayru.jdField_c_of_type_JavaUtilList == null) || (paramayru.jdField_c_of_type_JavaUtilList.size() == 0)) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    int j = 0;
    if (i < paramayru.jdField_c_of_type_JavaUtilList.size())
    {
      String str = (String)paramayru.jdField_c_of_type_JavaUtilList.get(i);
      if (str.equalsIgnoreCase(paramayru.jdField_b_of_type_JavaLangString)) {}
      for (;;)
      {
        i += 1;
        break;
        if (str.equalsIgnoreCase(paramayru.jdField_c_of_type_JavaLangString)) {
          j = i;
        }
        ayvq localayvq = new ayvq();
        localayvq.jdField_b_of_type_JavaLangString = str;
        localayvq.jdField_a_of_type_JavaLangString = ayrt.a(str);
        localArrayList.add(localayvq);
      }
    }
    this.jdField_a_of_type_Ayvo = ayvo.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, localArrayList, j, new ayrs(this, paramayru));
    i = this.jdField_c_of_type_AndroidWidgetTextView.getMeasuredWidth() / 2;
    j = AIOUtils.dp2px(75.0F, getResources());
    this.jdField_c_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
    this.jdField_a_of_type_Ayvo.showAsDropDown(this.jdField_c_of_type_AndroidWidgetTextView, i - j, 0);
    this.jdField_a_of_type_Ayvo.setOnDismissListener(new ayrk(this, paramayru));
  }
  
  private void b(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if ((this.jdField_a_of_type_Bisl != null) && (this.jdField_a_of_type_Bisl.isShowing())) {
        this.jdField_a_of_type_Bisl.dismiss();
      }
      return;
    }
    if (this.jdField_a_of_type_Bisl == null)
    {
      this.jdField_a_of_type_Bisl = new bisl(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, getResources().getDimensionPixelSize(2131299080));
      this.jdField_a_of_type_Bisl.c(2131698709);
    }
    if (!this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.isFinishing()) {
      this.jdField_a_of_type_Bisl.show();
    }
    ayrt.a("0X800B556", 0);
  }
  
  private void e()
  {
    SharedPreferences localSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.getApp().getSharedPreferences("check_update_sp_key", 0);
    String str = "businessinfo_ocr_gesture_guide_" + this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.getCurrentAccountUin();
    if (localSharedPreferences.getBoolean(str, true))
    {
      this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130841482);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131698715);
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      localSharedPreferences.edit().putBoolean(str, false).commit();
      return;
    }
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
  }
  
  private void f()
  {
    SharedPreferences localSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.getApp().getSharedPreferences("check_update_sp_key", 0);
    String str = "businessinfo_ocr_gesture_select_guide_" + this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.getCurrentAccountUin();
    if (localSharedPreferences.getBoolean(str, true))
    {
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130841483);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131698716);
      localSharedPreferences.edit().putBoolean(str, false).commit();
      return;
    }
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
  }
  
  private void g()
  {
    SharedPreferences localSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.getApp().getSharedPreferences("check_update_sp_key", 0);
    String str = "businessinfo_ocr_gesture_fullText_guide_" + this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.getCurrentAccountUin();
    if (localSharedPreferences.getBoolean(str, true))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactFindtroopBubbleLayout.setVisibility(0);
      localSharedPreferences.edit().putBoolean(str, false).commit();
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactFindtroopBubbleLayout.setVisibility(8);
  }
  
  private void h()
  {
    this.jdField_a_of_type_Bkzi = bkzi.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    this.jdField_a_of_type_Bkzi.c(this.jdField_b_of_type_JavaLangString);
    this.jdField_a_of_type_Bkzi.b(2131698684);
    this.jdField_a_of_type_Bkzi.c(2131690697);
    this.jdField_a_of_type_Bkzi.a(new ayrn(this));
    this.jdField_a_of_type_Bkzi.show();
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
      this.jdField_a_of_type_ComTencentMobileqqArmapScanSuccessView.setScale(ScreenUtil.SCREEN_WIDTH);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_ComTencentMobileqqArmapScanSuccessView, localLayoutParams);
      this.jdField_a_of_type_ComTencentMobileqqArmapScanSuccessView.setScanText(anvx.a(2131707271));
    }
    if (this.jdField_a_of_type_AndroidWidgetImageView == null)
    {
      localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      this.jdField_a_of_type_AndroidWidgetImageView = new ImageView(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130843352);
      localLayoutParams.leftMargin = AIOUtils.dp2px(12.0F, getResources());
      if (ImmersiveUtils.isSupporImmersive() != 1) {
        break label225;
      }
    }
    label225:
    for (localLayoutParams.topMargin = (ImmersiveUtils.getStatusBarHeight(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity) + AIOUtils.dp2px(12.0F, getResources()));; localLayoutParams.topMargin = AIOUtils.dp2px(12.0F, getResources()))
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_AndroidWidgetImageView, localLayoutParams);
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new ayro(this));
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
    if (this.jdField_a_of_type_ComTencentMobileqqOcrViewOcrImageTextView != null) {
      a(this.jdField_a_of_type_ComTencentMobileqqOcrViewOcrImageTextView.a(), this.jdField_a_of_type_ComTencentMobileqqOcrViewOcrImageTextView.b());
    }
    j();
    d();
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
    a(this.jdField_a_of_type_ComTencentMobileqqOcrViewOcrImageTextView.b());
  }
  
  public void c()
  {
    if (!this.jdField_d_of_type_Boolean)
    {
      this.jdField_d_of_type_Boolean = true;
      e();
    }
  }
  
  public void d()
  {
    if (!this.jdField_c_of_type_Boolean)
    {
      this.jdField_c_of_type_Boolean = true;
      f();
    }
    do
    {
      return;
      if ((!this.jdField_d_of_type_Boolean) && (!this.jdField_a_of_type_ComTencentMobileqqOcrViewOcrImageTextView.a(this.jdField_a_of_type_ComTencentMobileqqOcrViewGestureGestureFrameLayout.getHeight())))
      {
        this.jdField_d_of_type_Boolean = true;
        e();
        return;
      }
    } while (this.e);
    this.e = true;
    g();
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
        this.jdField_b_of_type_Boolean = true;
        if (this.jdField_a_of_type_Avaw != null)
        {
          if (QLog.isColorLevel()) {
            QLog.i("OCRPerformFragment", 2, "onUpdate useLocalResult！");
          }
          this.jdField_a_of_type_Avau.onUpdate(100, true, this.jdField_a_of_type_Avaw);
        }
      }
    }
    do
    {
      do
      {
        return true;
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 1, 2131698689, 0).a();
        onBackEvent();
        return true;
        if (paramMessage.what == 101)
        {
          QQToast.a(BaseApplicationImpl.getContext(), 1, 2131698694, 0).a();
          onBackEvent();
          return true;
        }
      } while (paramMessage.what != 102);
      paramMessage = (avaw)paramMessage.obj;
    } while (paramMessage == null);
    if (this.jdField_b_of_type_Boolean)
    {
      if (QLog.isColorLevel()) {
        QLog.i("OCRPerformFragment", 2, "onUpdate useRspCache！");
      }
      this.jdField_a_of_type_Avau.onUpdate(100, true, paramMessage);
      return true;
    }
    this.jdField_a_of_type_Avaw = paramMessage;
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
      ayrt.a("0X800AAE0", 0);
      onBackEvent();
      continue;
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqOcrViewOcrImageTextView;
      if (!this.jdField_a_of_type_ComTencentMobileqqOcrViewOcrImageTextView.a()) {}
      for (;;)
      {
        ((OcrImageTextView)localObject).setShowTextMask(bool);
        break;
        bool = false;
      }
      ayrt.b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_JavaLangString);
      if (ayrt.jdField_a_of_type_Boolean) {}
      for (localObject = "0X800B55C";; localObject = "0X800AAE2")
      {
        ayrt.a((String)localObject, 0);
        break;
      }
      behe.a(String.valueOf(a()), "OCRPerformFragment");
      if (ayrt.jdField_a_of_type_Boolean) {}
      for (localObject = "0X800B55D";; localObject = "0X800AAE7")
      {
        i = j;
        if (this.jdField_a_of_type_ComTencentMobileqqOcrViewOcrImageTextView.b()) {
          i = 2;
        }
        ayrt.a((String)localObject, i);
        break;
      }
      if (!ayrt.jdField_a_of_type_Boolean)
      {
        bool = true;
        label282:
        ayrt.jdField_a_of_type_Boolean = bool;
        if (!ayrt.jdField_a_of_type_Boolean) {
          break label363;
        }
        localObject = "0X800B555";
        label298:
        if (!this.jdField_a_of_type_ComTencentMobileqqOcrViewOcrImageTextView.b()) {
          break label371;
        }
      }
      for (;;)
      {
        ayrt.a((String)localObject, i);
        a(false);
        if (!ayrt.jdField_a_of_type_Boolean) {
          break label376;
        }
        a(ayrt.jdField_a_of_type_Ayru.jdField_b_of_type_JavaLangString, ayrt.jdField_a_of_type_Ayru.jdField_c_of_type_JavaLangString, true);
        ayrt.jdField_b_of_type_Ayru.a(ayrt.jdField_a_of_type_Ayru.jdField_c_of_type_JavaLangString);
        break;
        bool = false;
        break label282;
        label363:
        localObject = "0X800B562";
        break label298;
        label371:
        i = 1;
      }
      label376:
      a(ayrt.jdField_a_of_type_Ayru, false);
      a(ayrt.jdField_a_of_type_Avat, true);
      ayrt.jdField_b_of_type_Ayru.a(ayrt.jdField_a_of_type_Ayru);
      continue;
      if (ayrt.jdField_a_of_type_Boolean)
      {
        localObject = "0X800B55E";
        label415:
        if (!this.jdField_a_of_type_ComTencentMobileqqOcrViewOcrImageTextView.b()) {
          break label446;
        }
      }
      for (;;)
      {
        ayrt.a((String)localObject, i);
        h();
        break;
        localObject = "0X800AAE8";
        break label415;
        label446:
        i = 1;
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactFindtroopBubbleLayout != null) && (this.jdField_a_of_type_AndroidWidgetLinearLayout.getVisibility() != 8)) {
        this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactFindtroopBubbleLayout.setVisibility(8);
      }
      a(this.jdField_a_of_type_JavaLangString);
      if (ayrt.jdField_a_of_type_Boolean)
      {
        localObject = "0X800B561";
        label498:
        if (!this.jdField_a_of_type_ComTencentMobileqqOcrViewOcrImageTextView.b()) {
          break label525;
        }
      }
      for (;;)
      {
        ayrt.a((String)localObject, i);
        break;
        localObject = "0X800AAEC";
        break label498;
        label525:
        i = 1;
      }
      behe.a(String.valueOf(a()), "OCRPerformFragment");
      ayrt.a("0X800AAEF", 0);
      continue;
      ayrt.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, String.valueOf(a()));
      ayrt.a("0X800AAF0", 0);
      continue;
      TranslateFragment.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, String.valueOf(a()));
      if (this.jdField_a_of_type_ComTencentMobileqqOcrViewOcrImageTextView.b()) {}
      for (;;)
      {
        ayrt.a("0X800AAEB", i);
        break;
        i = 1;
      }
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      d();
      continue;
      a(ayrt.jdField_a_of_type_Ayru);
      continue;
      b(ayrt.jdField_a_of_type_Ayru);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    ayrt.jdField_a_of_type_Boolean = false;
    paramBundle = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent();
    this.jdField_a_of_type_JavaLangString = paramBundle.getStringExtra("param_ocr_path");
    if (QLog.isColorLevel()) {
      QLog.e("OCRPerformFragment", 2, "mPicPath=" + this.jdField_a_of_type_JavaLangString);
    }
    this.jdField_b_of_type_Int = paramBundle.getIntExtra("param_business_type", -1);
    paramBundle = paramBundle.getStringExtra("param_ocr_md5");
    if (ayrt.jdField_a_of_type_Avat == null)
    {
      ayrt.jdField_a_of_type_Avat = new avat();
      ayrt.jdField_a_of_type_Avat.jdField_a_of_type_JavaLangString = "";
      ayrt.jdField_a_of_type_Avat.jdField_a_of_type_Boolean = false;
    }
    ayrt.jdField_a_of_type_Avat.jdField_a_of_type_Int = this.jdField_b_of_type_Int;
    ayrt.jdField_a_of_type_Avat.jdField_d_of_type_JavaLangString = paramBundle;
    ayrt.jdField_a_of_type_Avat.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = new ayrj(this);
    paramBundle = new IntentFilter();
    paramBundle.addAction("tencent.av.v2q.StartVideoChat");
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, paramBundle);
      if (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.addObserver(this.jdField_a_of_type_Ayri);
        this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.addObserver(this.jdField_a_of_type_Avau);
      }
      this.jdField_a_of_type_ComTencentMobileqqOcrTranslateController = new TranslateController(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app);
      MetricsApi.getDefault().buildSuccessRateCounter("OCR_REQUEST");
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
    paramLayoutInflater = paramLayoutInflater.inflate(2131561312, paramViewGroup, false);
    a(paramLayoutInflater);
    ThreadManager.excute(new OCRPerformFragment.2(this), 16, null, true);
    a(ayrt.jdField_a_of_type_Avat, false);
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
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.removeObserver(this.jdField_a_of_type_Ayri);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.removeObserver(this.jdField_a_of_type_Avau);
    if (this.jdField_a_of_type_ComTencentMobileqqOcrViewOcrImageTextView != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqOcrViewOcrImageTextView.b();
      this.jdField_a_of_type_ComTencentMobileqqOcrViewOcrImageTextView.a();
    }
    ayrt.a();
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = null;
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
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2131694988, 0).a();
    }
    for (;;)
    {
      bdla.b(null, "dc00898", "", "", "0X80082DD", "0X80082DD", 0, 0, "", "", "", "");
      return;
      label81:
      this.jdField_a_of_type_JavaLangString = paramIntent.getStringExtra("PhotoConst.SINGLE_PHOTO_PATH");
      this.jdField_a_of_type_ComTencentMobileqqOcrViewOcrImageTextView.setImageURI(Uri.fromFile(new File(this.jdField_a_of_type_JavaLangString)));
      this.jdField_a_of_type_ComTencentMobileqqOcrViewGestureGestureFrameLayout.a().b();
      this.jdField_a_of_type_ComTencentMobileqqOcrViewOcrImageTextView.setShowTextMask(false);
      ayrt.jdField_a_of_type_Avat.a();
      ayrt.jdField_a_of_type_Avat.b(this.jdField_a_of_type_JavaLangString);
      ayrt.jdField_a_of_type_Avat.a(true);
      a(ayrt.jdField_a_of_type_Avat, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.OCRPerformFragment
 * JD-Core Version:    0.7.0.1
 */