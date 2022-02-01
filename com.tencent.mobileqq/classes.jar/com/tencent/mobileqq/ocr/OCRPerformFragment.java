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
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.contact.addcontact.findtroop.BubbleLayout;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.ar.utils.UniformUtils;
import com.tencent.mobileqq.armap.ScanSuccessView;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.gallery.picocr.PicOcrManager;
import com.tencent.mobileqq.gallery.picocr.PicOcrManager.OCRReqContext;
import com.tencent.mobileqq.gallery.picocr.PicOcrObserver;
import com.tencent.mobileqq.gallery.picocr.PicOcrRspResult;
import com.tencent.mobileqq.ocr.data.TranslateResult;
import com.tencent.mobileqq.ocr.view.EyeButton;
import com.tencent.mobileqq.ocr.view.OcrImageSectBean;
import com.tencent.mobileqq.ocr.view.OcrImageTextBean;
import com.tencent.mobileqq.ocr.view.OcrImageTextView;
import com.tencent.mobileqq.ocr.view.OcrScrollGestureListener;
import com.tencent.mobileqq.ocr.view.OcrScrollGestureListener.OcrPerformListener;
import com.tencent.mobileqq.ocr.view.TranslateLanguageOptionsView;
import com.tencent.mobileqq.ocr.view.TranslateLanguageOptionsView.OptionItem;
import com.tencent.mobileqq.ocr.view.gesture.GestureFrameLayout;
import com.tencent.mobileqq.ocr.view.gesture.GestureProxy;
import com.tencent.mobileqq.ocr.view.gesture.state.State;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.textpreview.MenuUtil;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.util.AccessibilityUtils;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.OCRBottomTabView;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.tfm.metrics.api.Metrics;
import com.tencent.tfm.metrics.api.MetricsApi;
import com.tencent.util.WeakReferenceHandler;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class OCRPerformFragment
  extends PublicBaseFragment
  implements Handler.Callback, View.OnClickListener, OcrScrollGestureListener.OcrPerformListener
{
  private int jdField_a_of_type_Int = 0;
  private long jdField_a_of_type_Long = -1L;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = null;
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private BubbleLayout jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactFindtroopBubbleLayout;
  private BaseActivity jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
  private ScanSuccessView jdField_a_of_type_ComTencentMobileqqArmapScanSuccessView;
  private PicOcrObserver jdField_a_of_type_ComTencentMobileqqGalleryPicocrPicOcrObserver = new OCRPerformFragment.6(this);
  private PicOcrRspResult jdField_a_of_type_ComTencentMobileqqGalleryPicocrPicOcrRspResult;
  private OCRObserver jdField_a_of_type_ComTencentMobileqqOcrOCRObserver = new OCRPerformFragment.11(this);
  private TranslateController jdField_a_of_type_ComTencentMobileqqOcrTranslateController;
  private OcrImageTextView jdField_a_of_type_ComTencentMobileqqOcrViewOcrImageTextView;
  private TranslateLanguageOptionsView jdField_a_of_type_ComTencentMobileqqOcrViewTranslateLanguageOptionsView;
  private GestureFrameLayout jdField_a_of_type_ComTencentMobileqqOcrViewGestureGestureFrameLayout;
  private QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  private final WeakReferenceHandler jdField_a_of_type_ComTencentUtilWeakReferenceHandler = new WeakReferenceHandler(Looper.getMainLooper(), this);
  private ActionSheet jdField_a_of_type_ComTencentWidgetActionSheet;
  private String jdField_a_of_type_JavaLangString;
  private volatile boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int = -1;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private TranslateLanguageOptionsView jdField_b_of_type_ComTencentMobileqqOcrViewTranslateLanguageOptionsView;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean = false;
  private RelativeLayout jdField_c_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private boolean jdField_c_of_type_Boolean = false;
  private RelativeLayout jdField_d_of_type_AndroidWidgetRelativeLayout;
  private boolean jdField_d_of_type_Boolean = false;
  private boolean e = false;
  
  private CharSequence a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqOcrViewOcrImageTextView != null) && (this.jdField_a_of_type_ComTencentMobileqqOcrViewOcrImageTextView.b()))
    {
      OCRPerformUtil.jdField_b_of_type_JavaLangCharSequence = this.jdField_a_of_type_ComTencentMobileqqOcrViewOcrImageTextView.a();
      return OCRPerformUtil.jdField_b_of_type_JavaLangCharSequence;
    }
    if ((OCRPerformUtil.jdField_a_of_type_Boolean) && (OCRPerformUtil.jdField_a_of_type_ComTencentMobileqqOcrDataTranslateResult != null)) {
      return OCRPerformUtil.jdField_a_of_type_ComTencentMobileqqOcrDataTranslateResult.a();
    }
    return OCRPerformUtil.jdField_a_of_type_JavaLangCharSequence;
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
    OCRPerformUtil.a("0X80082C7", 0);
  }
  
  private void a(View paramView)
  {
    Object localObject = (OCRBottomTabView)paramView.findViewById(2131372485);
    ((OCRBottomTabView)localObject).setOnClickListener(this);
    if ((AppSetting.jdField_d_of_type_Boolean) && (((OCRBottomTabView)localObject).isEnabled())) {
      AccessibilityUtils.a((View)localObject, String.valueOf(((OCRBottomTabView)localObject).a()).trim());
    }
    localObject = (OCRBottomTabView)paramView.findViewById(2131372484);
    ((OCRBottomTabView)localObject).setOnClickListener(this);
    if ((AppSetting.jdField_d_of_type_Boolean) && (((OCRBottomTabView)localObject).isEnabled())) {
      AccessibilityUtils.a((View)localObject, String.valueOf(((OCRBottomTabView)localObject).a()).trim());
    }
    localObject = (OCRBottomTabView)paramView.findViewById(2131372483);
    ((OCRBottomTabView)localObject).setOnClickListener(this);
    if ((AppSetting.jdField_d_of_type_Boolean) && (((OCRBottomTabView)localObject).isEnabled())) {
      AccessibilityUtils.a((View)localObject, String.valueOf(((OCRBottomTabView)localObject).a()).trim());
    }
    localObject = (OCRBottomTabView)paramView.findViewById(2131372482);
    ((OCRBottomTabView)localObject).setOnClickListener(this);
    if ((AppSetting.jdField_d_of_type_Boolean) && (((OCRBottomTabView)localObject).isEnabled())) {
      AccessibilityUtils.a((View)localObject, String.valueOf(((OCRBottomTabView)localObject).a()).trim());
    }
    localObject = (OCRBottomTabView)paramView.findViewById(2131372486);
    ((OCRBottomTabView)localObject).setOnClickListener(this);
    if ((AppSetting.jdField_d_of_type_Boolean) && (((OCRBottomTabView)localObject).isEnabled())) {
      AccessibilityUtils.a((View)localObject, String.valueOf(((OCRBottomTabView)localObject).a()).trim());
    }
    this.jdField_b_of_type_JavaLangString = getResources().getString(2131698988);
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_ComTencentMobileqqOcrViewOcrImageTextView = ((OcrImageTextView)paramView.findViewById(2131372476));
    this.jdField_a_of_type_ComTencentMobileqqOcrViewOcrImageTextView.setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqOcrViewOcrImageTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131372478));
    localObject = (ImageButton)paramView.findViewById(2131372480);
    ((ImageButton)localObject).setOnClickListener(this);
    AccessibilityUtil.a((View)localObject, getResources().getString(2131690778), null);
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131372477));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131372472));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131372473));
    this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactFindtroopBubbleLayout = ((BubbleLayout)paramView.findViewById(2131372468));
    this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactFindtroopBubbleLayout.setSelected(true);
    localObject = (EyeButton)paramView.findViewById(2131372481);
    AccessibilityUtil.a((View)localObject, getResources().getString(2131699013), null);
    ((EyeButton)localObject).setLonTouchListener(new OCRPerformFragment.3(this));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131379749));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131379745));
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_d_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131372487));
    a(OCRPerformUtil.jdField_a_of_type_ComTencentMobileqqOcrOCRPerformUtil$OCRLanHolder, false);
    this.jdField_c_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131372479));
    this.jdField_c_of_type_AndroidWidgetRelativeLayout.bringToFront();
    UniformUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_c_of_type_AndroidWidgetRelativeLayout);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131372475));
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(4);
    this.jdField_a_of_type_ComTencentMobileqqOcrViewGestureGestureFrameLayout = ((GestureFrameLayout)paramView.findViewById(2131367856));
  }
  
  private void a(PicOcrManager.OCRReqContext paramOCRReqContext, boolean paramBoolean)
  {
    if ((paramBoolean) && (OCRPerformUtil.jdField_a_of_type_ComTencentMobileqqGalleryPicocrPicOcrRspResult != null))
    {
      a(OCRPerformUtil.jdField_a_of_type_ComTencentMobileqqGalleryPicocrPicOcrRspResult, false);
      return;
    }
    if (!FileUtil.a(paramOCRReqContext.jdField_b_of_type_JavaLangString))
    {
      QLog.d("OCRPerformFragment", 1, "requestOcr, file not exist, picPath:" + paramOCRReqContext.jdField_b_of_type_JavaLangString);
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 1, 2131698996, 0).a();
      return;
    }
    if (this.jdField_a_of_type_Boolean)
    {
      QLog.d("OCRPerformFragment", 1, "requestOcr, in ocr request, " + paramOCRReqContext.jdField_b_of_type_JavaLangString);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("OCRPerformFragment", 2, "requestOcr:" + paramOCRReqContext.jdField_b_of_type_JavaLangString);
    }
    i();
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    ((PicOcrManager)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.getManager(QQManagerFactory.PIC_OCR_MANAGER)).a(paramOCRReqContext, this.jdField_a_of_type_ComTencentMobileqqGalleryPicocrPicOcrObserver);
    this.jdField_a_of_type_Int += 1;
  }
  
  private void a(PicOcrRspResult paramPicOcrRspResult, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("OCRPerformFragment", 2, "updateOcrResultData：" + paramPicOcrRspResult.toString());
    }
    if (paramBoolean)
    {
      OCRPerformUtil.jdField_a_of_type_JavaLangCharSequence = OCRPerformUtil.a(paramPicOcrRspResult.jdField_a_of_type_JavaUtilArrayList);
      if (!OCRPerformUtil.jdField_a_of_type_Boolean)
      {
        OCRPerformUtil.jdField_a_of_type_ComTencentMobileqqOcrOCRPerformUtil$OCRLanHolder = OCRPerformUtil.a(OCRPerformUtil.jdField_a_of_type_ComTencentMobileqqOcrOCRPerformUtil$OCRLanHolder, paramPicOcrRspResult.jdField_b_of_type_JavaLangString, paramPicOcrRspResult.jdField_b_of_type_JavaUtilArrayList, paramPicOcrRspResult.jdField_a_of_type_JavaUtilHashMap);
        OCRPerformUtil.jdField_b_of_type_ComTencentMobileqqOcrOCRPerformUtil$OCRLanHolder = OCRPerformUtil.a(OCRPerformUtil.jdField_b_of_type_ComTencentMobileqqOcrOCRPerformUtil$OCRLanHolder, paramPicOcrRspResult.jdField_b_of_type_JavaLangString, paramPicOcrRspResult.jdField_b_of_type_JavaUtilArrayList, paramPicOcrRspResult.jdField_a_of_type_JavaUtilHashMap);
      }
      if (OCRPerformUtil.jdField_a_of_type_ComTencentMobileqqGalleryPicocrPicOcrManager$OCRReqContext != null)
      {
        OCRPerformUtil.jdField_a_of_type_ComTencentMobileqqGalleryPicocrPicOcrManager$OCRReqContext.jdField_a_of_type_JavaLangString = paramPicOcrRspResult.jdField_b_of_type_JavaLangString;
        OCRPerformUtil.jdField_a_of_type_ComTencentMobileqqGalleryPicocrPicOcrManager$OCRReqContext.jdField_a_of_type_Int = this.jdField_b_of_type_Int;
        OCRPerformUtil.jdField_a_of_type_ComTencentMobileqqGalleryPicocrPicOcrManager$OCRReqContext.jdField_d_of_type_JavaLangString = paramPicOcrRspResult.jdField_a_of_type_JavaLangString;
        OCRPerformUtil.jdField_a_of_type_ComTencentMobileqqGalleryPicocrPicOcrManager$OCRReqContext.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
        OCRPerformUtil.jdField_a_of_type_ComTencentMobileqqGalleryPicocrPicOcrManager$OCRReqContext.f = paramPicOcrRspResult.jdField_c_of_type_JavaLangString;
        OCRPerformUtil.jdField_a_of_type_ComTencentMobileqqGalleryPicocrPicOcrManager$OCRReqContext.jdField_b_of_type_Int = paramPicOcrRspResult.jdField_d_of_type_Int;
        OCRPerformUtil.jdField_a_of_type_ComTencentMobileqqGalleryPicocrPicOcrManager$OCRReqContext.jdField_c_of_type_Int = paramPicOcrRspResult.e;
        OCRPerformUtil.jdField_a_of_type_ComTencentMobileqqGalleryPicocrPicOcrManager$OCRReqContext.jdField_a_of_type_Long = paramPicOcrRspResult.jdField_c_of_type_Int;
        OCRPerformUtil.jdField_a_of_type_ComTencentMobileqqGalleryPicocrPicOcrManager$OCRReqContext.e = paramPicOcrRspResult.jdField_d_of_type_JavaLangString;
      }
      paramPicOcrRspResult.f = ImageUtil.c(this.jdField_a_of_type_JavaLangString);
      OCRPerformUtil.jdField_a_of_type_ComTencentMobileqqGalleryPicocrPicOcrRspResult = paramPicOcrRspResult;
    }
    if (OCRPerformUtil.jdField_a_of_type_Boolean)
    {
      a(OCRPerformUtil.jdField_a_of_type_ComTencentMobileqqOcrOCRPerformUtil$OCRLanHolder.jdField_b_of_type_JavaLangString, OCRPerformUtil.jdField_a_of_type_ComTencentMobileqqOcrOCRPerformUtil$OCRLanHolder.jdField_c_of_type_JavaLangString, false);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqOcrViewOcrImageTextView.setResultNormal(OCRPerformUtil.jdField_a_of_type_ComTencentMobileqqGalleryPicocrPicOcrRspResult);
    AccessibilityUtil.a(this.jdField_a_of_type_ComTencentMobileqqOcrViewOcrImageTextView, OCRPerformUtil.jdField_a_of_type_JavaLangCharSequence, null);
  }
  
  private void a(OCRPerformUtil.OCRLanHolder paramOCRLanHolder)
  {
    if (QLog.isColorLevel()) {
      QLog.d("OCRPerformFragment", 2, "showTranslateSrcLanOptions, lanHolder:" + paramOCRLanHolder.a());
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqOcrViewTranslateLanguageOptionsView != null) && (this.jdField_a_of_type_ComTencentMobileqqOcrViewTranslateLanguageOptionsView.isShowing())) {
      this.jdField_a_of_type_ComTencentMobileqqOcrViewTranslateLanguageOptionsView.dismiss();
    }
    if ((this.jdField_b_of_type_ComTencentMobileqqOcrViewTranslateLanguageOptionsView != null) && (this.jdField_b_of_type_ComTencentMobileqqOcrViewTranslateLanguageOptionsView.isShowing())) {
      this.jdField_b_of_type_ComTencentMobileqqOcrViewTranslateLanguageOptionsView.dismiss();
    }
    while ((paramOCRLanHolder.jdField_b_of_type_JavaUtilList == null) || (paramOCRLanHolder.jdField_b_of_type_JavaUtilList.size() == 0)) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    int j = 0;
    while (i < paramOCRLanHolder.jdField_b_of_type_JavaUtilList.size())
    {
      String str = (String)paramOCRLanHolder.jdField_b_of_type_JavaUtilList.get(i);
      if (str.equalsIgnoreCase(paramOCRLanHolder.jdField_b_of_type_JavaLangString)) {
        j = i;
      }
      TranslateLanguageOptionsView.OptionItem localOptionItem = new TranslateLanguageOptionsView.OptionItem();
      localOptionItem.jdField_b_of_type_JavaLangString = str;
      localOptionItem.jdField_a_of_type_JavaLangString = OCRPerformUtil.a(str);
      localArrayList.add(localOptionItem);
      i += 1;
    }
    this.jdField_b_of_type_ComTencentMobileqqOcrViewTranslateLanguageOptionsView = TranslateLanguageOptionsView.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, localArrayList, j, new OCRPerformFragment.7(this, paramOCRLanHolder));
    i = this.jdField_b_of_type_AndroidWidgetTextView.getMeasuredWidth() / 2;
    j = AIOUtils.a(75.0F, getResources());
    this.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
    this.jdField_b_of_type_ComTencentMobileqqOcrViewTranslateLanguageOptionsView.showAsDropDown(this.jdField_b_of_type_AndroidWidgetTextView, i - j, 0);
    this.jdField_b_of_type_ComTencentMobileqqOcrViewTranslateLanguageOptionsView.setOnDismissListener(new OCRPerformFragment.8(this, paramOCRLanHolder));
  }
  
  private void a(OCRPerformUtil.OCRLanHolder paramOCRLanHolder, boolean paramBoolean)
  {
    int i;
    Object localObject;
    if (paramBoolean)
    {
      i = 2130841629;
      if (!paramBoolean) {
        break label89;
      }
      localObject = "#00CAFC";
      label17:
      OCRBottomTabView localOCRBottomTabView = (OCRBottomTabView)this.jdField_a_of_type_AndroidViewView.findViewById(2131372486);
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
    while (paramOCRLanHolder == null)
    {
      return;
      i = 2130841628;
      break;
      localObject = "#FFFFFF";
      break label17;
      i = 8;
      break label71;
    }
    if (QLog.isColorLevel()) {
      QLog.d("OCRPerformFragment", 2, "updateTranslateTitle, lanHolder:" + paramOCRLanHolder.a());
    }
    this.jdField_b_of_type_AndroidWidgetTextView.setText(paramOCRLanHolder.a(paramOCRLanHolder.jdField_b_of_type_JavaLangString));
    this.jdField_c_of_type_AndroidWidgetTextView.setText(paramOCRLanHolder.a(paramOCRLanHolder.jdField_c_of_type_JavaLangString));
    if ((paramOCRLanHolder.jdField_b_of_type_JavaUtilList == null) || (paramOCRLanHolder.jdField_b_of_type_JavaUtilList.size() <= 1))
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setClickable(false);
      this.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
    }
    while ((paramOCRLanHolder.jdField_c_of_type_JavaUtilList == null) || (paramOCRLanHolder.jdField_c_of_type_JavaUtilList.size() <= 1))
    {
      this.jdField_c_of_type_AndroidWidgetTextView.setClickable(false);
      this.jdField_c_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
      return;
      this.jdField_b_of_type_AndroidWidgetTextView.setClickable(true);
      localObject = getResources().getDrawable(2130846475);
      this.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, null, (Drawable)localObject);
    }
    this.jdField_c_of_type_AndroidWidgetTextView.setClickable(true);
    paramOCRLanHolder = getResources().getDrawable(2130846475);
    this.jdField_c_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, null, paramOCRLanHolder);
  }
  
  private void a(TranslateResult paramTranslateResult)
  {
    if (QLog.isColorLevel()) {
      QLog.d("OCRPerformFragment", 2, "src:" + paramTranslateResult.jdField_a_of_type_JavaLangString + ", dst:" + paramTranslateResult.jdField_b_of_type_JavaLangString + ", OCRLanHolder:" + OCRPerformUtil.jdField_a_of_type_ComTencentMobileqqOcrOCRPerformUtil$OCRLanHolder.a());
    }
    if (OCRPerformUtil.jdField_a_of_type_ComTencentMobileqqOcrOCRPerformUtil$OCRLanHolder != null)
    {
      OCRPerformUtil.jdField_a_of_type_ComTencentMobileqqOcrOCRPerformUtil$OCRLanHolder.b(paramTranslateResult.jdField_a_of_type_JavaLangString);
      OCRPerformUtil.jdField_a_of_type_ComTencentMobileqqOcrOCRPerformUtil$OCRLanHolder.c(paramTranslateResult.jdField_b_of_type_JavaLangString);
      OCRPerformUtil.jdField_b_of_type_ComTencentMobileqqOcrOCRPerformUtil$OCRLanHolder.a(OCRPerformUtil.jdField_a_of_type_ComTencentMobileqqOcrOCRPerformUtil$OCRLanHolder.jdField_c_of_type_JavaLangString);
      a(OCRPerformUtil.jdField_a_of_type_ComTencentMobileqqOcrOCRPerformUtil$OCRLanHolder, OCRPerformUtil.jdField_a_of_type_Boolean);
    }
    if (QLog.isColorLevel()) {
      QLog.d("OCRPerformFragment", 2, new Object[] { paramTranslateResult.b() });
    }
    this.jdField_a_of_type_ComTencentMobileqqOcrViewOcrImageTextView.setResultSection(paramTranslateResult);
    AccessibilityUtil.a(this.jdField_a_of_type_ComTencentMobileqqOcrViewOcrImageTextView, paramTranslateResult.c(), null);
  }
  
  private void a(String paramString)
  {
    OCRPerformUtil.jdField_b_of_type_JavaLangCharSequence = a();
    Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, OCRResultFragmentNew.class);
    localIntent.putExtra("param_ocr_path", paramString);
    PublicFragmentActivity.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, localIntent, OCRResultFragmentNew.class);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.overridePendingTransition(0, 0);
  }
  
  private void a(String paramString1, String paramString2, boolean paramBoolean)
  {
    if ((paramBoolean) && (OCRPerformUtil.jdField_a_of_type_ComTencentMobileqqOcrDataTranslateResult != null)) {
      a(OCRPerformUtil.jdField_a_of_type_ComTencentMobileqqOcrDataTranslateResult);
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
    if (!NetworkUtil.g(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity))
    {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 1, 2131692257, 0).a();
      OCRPerformUtil.a("0X800B557", 0);
      return;
    }
    String str = String.valueOf(OCRPerformUtil.jdField_a_of_type_JavaLangCharSequence);
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
  
  private void a(List<OcrImageTextBean> paramList, List<OcrImageSectBean> paramList1)
  {
    paramList = new OcrScrollGestureListener(this.jdField_a_of_type_ComTencentMobileqqOcrViewGestureGestureFrameLayout, paramList, paramList1, this, this);
    this.jdField_a_of_type_ComTencentMobileqqOcrViewGestureGestureFrameLayout.a().a(paramList);
  }
  
  private void a(boolean paramBoolean)
  {
    String str1 = getResources().getString(2131699017);
    String str2 = getResources().getString(2131699020);
    OCRBottomTabView localOCRBottomTabView = (OCRBottomTabView)this.jdField_a_of_type_AndroidViewView.findViewById(2131372482);
    if (paramBoolean)
    {
      String str3 = String.valueOf(localOCRBottomTabView.a());
      if (!str3.contains(str2)) {
        localOCRBottomTabView.setTabText(str3 + str2);
      }
      localOCRBottomTabView = (OCRBottomTabView)this.jdField_a_of_type_AndroidViewView.findViewById(2131372485);
      str3 = String.valueOf(localOCRBottomTabView.a());
      if (!str3.contains(str2)) {
        localOCRBottomTabView.setTabText(str3 + str2);
      }
      localOCRBottomTabView = (OCRBottomTabView)this.jdField_a_of_type_AndroidViewView.findViewById(2131372484);
      str3 = String.valueOf(localOCRBottomTabView.a());
      if (!str3.contains(str2)) {
        localOCRBottomTabView.setTabText(str3.replace(str1, str2));
      }
      this.jdField_b_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString.replace(str1, str2);
      return;
    }
    localOCRBottomTabView.setTabText(getResources().getString(2131699014));
    ((OCRBottomTabView)this.jdField_a_of_type_AndroidViewView.findViewById(2131372485)).setTabText(getResources().getString(2131692678));
    ((OCRBottomTabView)this.jdField_a_of_type_AndroidViewView.findViewById(2131372486)).setTabText(getResources().getString(2131699008));
    ((OCRBottomTabView)this.jdField_a_of_type_AndroidViewView.findViewById(2131372484)).setTabText(getResources().getString(2131699015));
    this.jdField_b_of_type_JavaLangString = getResources().getString(2131698988);
  }
  
  private void b(OCRPerformUtil.OCRLanHolder paramOCRLanHolder)
  {
    if (QLog.isColorLevel()) {
      QLog.d("OCRPerformFragment", 2, "showTranslateDstLanOptions, lanHolder:" + paramOCRLanHolder.a());
    }
    if ((this.jdField_b_of_type_ComTencentMobileqqOcrViewTranslateLanguageOptionsView != null) && (this.jdField_b_of_type_ComTencentMobileqqOcrViewTranslateLanguageOptionsView.isShowing())) {
      this.jdField_b_of_type_ComTencentMobileqqOcrViewTranslateLanguageOptionsView.dismiss();
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqOcrViewTranslateLanguageOptionsView != null) && (this.jdField_a_of_type_ComTencentMobileqqOcrViewTranslateLanguageOptionsView.isShowing())) {
      this.jdField_a_of_type_ComTencentMobileqqOcrViewTranslateLanguageOptionsView.dismiss();
    }
    while ((paramOCRLanHolder.jdField_c_of_type_JavaUtilList == null) || (paramOCRLanHolder.jdField_c_of_type_JavaUtilList.size() == 0)) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    int j = 0;
    if (i < paramOCRLanHolder.jdField_c_of_type_JavaUtilList.size())
    {
      String str = (String)paramOCRLanHolder.jdField_c_of_type_JavaUtilList.get(i);
      if (str.equalsIgnoreCase(paramOCRLanHolder.jdField_b_of_type_JavaLangString)) {}
      for (;;)
      {
        i += 1;
        break;
        if (str.equalsIgnoreCase(paramOCRLanHolder.jdField_c_of_type_JavaLangString)) {
          j = i;
        }
        TranslateLanguageOptionsView.OptionItem localOptionItem = new TranslateLanguageOptionsView.OptionItem();
        localOptionItem.jdField_b_of_type_JavaLangString = str;
        localOptionItem.jdField_a_of_type_JavaLangString = OCRPerformUtil.a(str);
        localArrayList.add(localOptionItem);
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqOcrViewTranslateLanguageOptionsView = TranslateLanguageOptionsView.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, localArrayList, j, new OCRPerformFragment.9(this, paramOCRLanHolder));
    i = this.jdField_c_of_type_AndroidWidgetTextView.getMeasuredWidth() / 2;
    j = AIOUtils.a(75.0F, getResources());
    this.jdField_c_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
    this.jdField_a_of_type_ComTencentMobileqqOcrViewTranslateLanguageOptionsView.showAsDropDown(this.jdField_c_of_type_AndroidWidgetTextView, i - j, 0);
    this.jdField_a_of_type_ComTencentMobileqqOcrViewTranslateLanguageOptionsView.setOnDismissListener(new OCRPerformFragment.10(this, paramOCRLanHolder));
  }
  
  private void b(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
      }
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, getResources().getDimensionPixelSize(2131299166));
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(2131699012);
    }
    if (!this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.isFinishing()) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
    }
    OCRPerformUtil.a("0X800B556", 0);
  }
  
  private void e()
  {
    SharedPreferences localSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.getApp().getSharedPreferences("check_update_sp_key", 0);
    String str = "businessinfo_ocr_gesture_guide_" + this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.getCurrentAccountUin();
    if (localSharedPreferences.getBoolean(str, true))
    {
      this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130841625);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131699018);
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
      this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130841626);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131699019);
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
    this.jdField_a_of_type_ComTencentWidgetActionSheet = ActionSheet.create(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    this.jdField_a_of_type_ComTencentWidgetActionSheet.addButton(this.jdField_b_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentWidgetActionSheet.addButton(2131698987);
    this.jdField_a_of_type_ComTencentWidgetActionSheet.addCancelButton(2131690800);
    this.jdField_a_of_type_ComTencentWidgetActionSheet.setOnButtonClickListener(new OCRPerformFragment.4(this));
    this.jdField_a_of_type_ComTencentWidgetActionSheet.show();
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
      this.jdField_a_of_type_ComTencentMobileqqArmapScanSuccessView.setScanText(HardCodeUtil.a(2131707796));
    }
    if (this.jdField_a_of_type_AndroidWidgetImageView == null)
    {
      localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      this.jdField_a_of_type_AndroidWidgetImageView = new ImageView(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130843521);
      localLayoutParams.leftMargin = AIOUtils.a(12.0F, getResources());
      if (ImmersiveUtils.isSupporImmersive() != 1) {
        break label225;
      }
    }
    label225:
    for (localLayoutParams.topMargin = (ImmersiveUtils.getStatusBarHeight(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity) + AIOUtils.a(12.0F, getResources()));; localLayoutParams.topMargin = AIOUtils.a(12.0F, getResources()))
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_AndroidWidgetImageView, localLayoutParams);
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new OCRPerformFragment.5(this));
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
        if (this.jdField_a_of_type_ComTencentMobileqqGalleryPicocrPicOcrRspResult != null)
        {
          if (QLog.isColorLevel()) {
            QLog.i("OCRPerformFragment", 2, "onUpdate useLocalResult！");
          }
          this.jdField_a_of_type_ComTencentMobileqqGalleryPicocrPicOcrObserver.onUpdate(100, true, this.jdField_a_of_type_ComTencentMobileqqGalleryPicocrPicOcrRspResult);
        }
      }
    }
    do
    {
      do
      {
        return true;
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 1, 2131698992, 0).a();
        onBackEvent();
        return true;
        if (paramMessage.what == 101)
        {
          QQToast.a(BaseApplicationImpl.getContext(), 1, 2131698997, 0).a();
          onBackEvent();
          return true;
        }
      } while (paramMessage.what != 102);
      paramMessage = (PicOcrRspResult)paramMessage.obj;
    } while (paramMessage == null);
    if (this.jdField_b_of_type_Boolean)
    {
      if (QLog.isColorLevel()) {
        QLog.i("OCRPerformFragment", 2, "onUpdate useRspCache！");
      }
      this.jdField_a_of_type_ComTencentMobileqqGalleryPicocrPicOcrObserver.onUpdate(100, true, paramMessage);
      return true;
    }
    this.jdField_a_of_type_ComTencentMobileqqGalleryPicocrPicOcrRspResult = paramMessage;
    return true;
  }
  
  public void initWindowStyleAndAnimation(Activity paramActivity)
  {
    paramActivity.overridePendingTransition(2130771981, 2130771979);
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
      OCRPerformUtil.a("0X800AAE0", 0);
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
      OCRPerformUtil.b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_JavaLangString);
      if (OCRPerformUtil.jdField_a_of_type_Boolean) {}
      for (localObject = "0X800B55C";; localObject = "0X800AAE2")
      {
        OCRPerformUtil.a((String)localObject, 0);
        break;
      }
      MenuUtil.copy(String.valueOf(a()), "OCRPerformFragment");
      if (OCRPerformUtil.jdField_a_of_type_Boolean) {}
      for (localObject = "0X800B55D";; localObject = "0X800AAE7")
      {
        i = j;
        if (this.jdField_a_of_type_ComTencentMobileqqOcrViewOcrImageTextView.b()) {
          i = 2;
        }
        OCRPerformUtil.a((String)localObject, i);
        break;
      }
      if (!OCRPerformUtil.jdField_a_of_type_Boolean)
      {
        bool = true;
        label282:
        OCRPerformUtil.jdField_a_of_type_Boolean = bool;
        if (!OCRPerformUtil.jdField_a_of_type_Boolean) {
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
        OCRPerformUtil.a((String)localObject, i);
        a(false);
        if (!OCRPerformUtil.jdField_a_of_type_Boolean) {
          break label376;
        }
        a(OCRPerformUtil.jdField_a_of_type_ComTencentMobileqqOcrOCRPerformUtil$OCRLanHolder.jdField_b_of_type_JavaLangString, OCRPerformUtil.jdField_a_of_type_ComTencentMobileqqOcrOCRPerformUtil$OCRLanHolder.jdField_c_of_type_JavaLangString, true);
        OCRPerformUtil.jdField_b_of_type_ComTencentMobileqqOcrOCRPerformUtil$OCRLanHolder.a(OCRPerformUtil.jdField_a_of_type_ComTencentMobileqqOcrOCRPerformUtil$OCRLanHolder.jdField_c_of_type_JavaLangString);
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
      a(OCRPerformUtil.jdField_a_of_type_ComTencentMobileqqOcrOCRPerformUtil$OCRLanHolder, false);
      a(OCRPerformUtil.jdField_a_of_type_ComTencentMobileqqGalleryPicocrPicOcrManager$OCRReqContext, true);
      OCRPerformUtil.jdField_b_of_type_ComTencentMobileqqOcrOCRPerformUtil$OCRLanHolder.a(OCRPerformUtil.jdField_a_of_type_ComTencentMobileqqOcrOCRPerformUtil$OCRLanHolder);
      continue;
      if (OCRPerformUtil.jdField_a_of_type_Boolean)
      {
        localObject = "0X800B55E";
        label415:
        if (!this.jdField_a_of_type_ComTencentMobileqqOcrViewOcrImageTextView.b()) {
          break label446;
        }
      }
      for (;;)
      {
        OCRPerformUtil.a((String)localObject, i);
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
      if (OCRPerformUtil.jdField_a_of_type_Boolean)
      {
        localObject = "0X800B561";
        label498:
        if (!this.jdField_a_of_type_ComTencentMobileqqOcrViewOcrImageTextView.b()) {
          break label525;
        }
      }
      for (;;)
      {
        OCRPerformUtil.a((String)localObject, i);
        break;
        localObject = "0X800AAEC";
        break label498;
        label525:
        i = 1;
      }
      MenuUtil.copy(String.valueOf(a()), "OCRPerformFragment");
      OCRPerformUtil.a("0X800AAEF", 0);
      continue;
      OCRPerformUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, String.valueOf(a()));
      OCRPerformUtil.a("0X800AAF0", 0);
      continue;
      TranslateFragment.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, String.valueOf(a()));
      if (this.jdField_a_of_type_ComTencentMobileqqOcrViewOcrImageTextView.b()) {}
      for (;;)
      {
        OCRPerformUtil.a("0X800AAEB", i);
        break;
        i = 1;
      }
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      d();
      continue;
      a(OCRPerformUtil.jdField_a_of_type_ComTencentMobileqqOcrOCRPerformUtil$OCRLanHolder);
      continue;
      b(OCRPerformUtil.jdField_a_of_type_ComTencentMobileqqOcrOCRPerformUtil$OCRLanHolder);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    OCRPerformUtil.jdField_a_of_type_Boolean = false;
    paramBundle = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent();
    this.jdField_a_of_type_JavaLangString = paramBundle.getStringExtra("param_ocr_path");
    if (QLog.isColorLevel()) {
      QLog.e("OCRPerformFragment", 2, "mPicPath=" + this.jdField_a_of_type_JavaLangString);
    }
    this.jdField_b_of_type_Int = paramBundle.getIntExtra("param_business_type", -1);
    paramBundle = paramBundle.getStringExtra("param_ocr_md5");
    if (OCRPerformUtil.jdField_a_of_type_ComTencentMobileqqGalleryPicocrPicOcrManager$OCRReqContext == null)
    {
      OCRPerformUtil.jdField_a_of_type_ComTencentMobileqqGalleryPicocrPicOcrManager$OCRReqContext = new PicOcrManager.OCRReqContext();
      OCRPerformUtil.jdField_a_of_type_ComTencentMobileqqGalleryPicocrPicOcrManager$OCRReqContext.jdField_a_of_type_JavaLangString = "";
      OCRPerformUtil.jdField_a_of_type_ComTencentMobileqqGalleryPicocrPicOcrManager$OCRReqContext.jdField_a_of_type_Boolean = false;
    }
    OCRPerformUtil.jdField_a_of_type_ComTencentMobileqqGalleryPicocrPicOcrManager$OCRReqContext.jdField_a_of_type_Int = this.jdField_b_of_type_Int;
    OCRPerformUtil.jdField_a_of_type_ComTencentMobileqqGalleryPicocrPicOcrManager$OCRReqContext.jdField_d_of_type_JavaLangString = paramBundle;
    OCRPerformUtil.jdField_a_of_type_ComTencentMobileqqGalleryPicocrPicOcrManager$OCRReqContext.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = new OCRPerformFragment.1(this);
    paramBundle = new IntentFilter();
    paramBundle.addAction("tencent.av.v2q.StartVideoChat");
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, paramBundle);
      if (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.addObserver(this.jdField_a_of_type_ComTencentMobileqqOcrOCRObserver);
        this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.addObserver(this.jdField_a_of_type_ComTencentMobileqqGalleryPicocrPicOcrObserver);
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
    paramLayoutInflater = paramLayoutInflater.inflate(2131561417, paramViewGroup, false);
    a(paramLayoutInflater);
    ThreadManager.excute(new OCRPerformFragment.2(this), 16, null, true);
    a(OCRPerformUtil.jdField_a_of_type_ComTencentMobileqqGalleryPicocrPicOcrManager$OCRReqContext, false);
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
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.removeObserver(this.jdField_a_of_type_ComTencentMobileqqOcrOCRObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.removeObserver(this.jdField_a_of_type_ComTencentMobileqqGalleryPicocrPicOcrObserver);
    if (this.jdField_a_of_type_ComTencentMobileqqOcrViewOcrImageTextView != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqOcrViewOcrImageTextView.b();
      this.jdField_a_of_type_ComTencentMobileqqOcrViewOcrImageTextView.a();
    }
    OCRPerformUtil.a();
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
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2131695227, 0).a();
    }
    for (;;)
    {
      ReportController.b(null, "dc00898", "", "", "0X80082DD", "0X80082DD", 0, 0, "", "", "", "");
      return;
      label81:
      this.jdField_a_of_type_JavaLangString = paramIntent.getStringExtra("PhotoConst.SINGLE_PHOTO_PATH");
      this.jdField_a_of_type_ComTencentMobileqqOcrViewOcrImageTextView.setImageURI(Uri.fromFile(new File(this.jdField_a_of_type_JavaLangString)));
      this.jdField_a_of_type_ComTencentMobileqqOcrViewGestureGestureFrameLayout.a().b();
      this.jdField_a_of_type_ComTencentMobileqqOcrViewOcrImageTextView.setShowTextMask(false);
      OCRPerformUtil.jdField_a_of_type_ComTencentMobileqqGalleryPicocrPicOcrManager$OCRReqContext.a();
      OCRPerformUtil.jdField_a_of_type_ComTencentMobileqqGalleryPicocrPicOcrManager$OCRReqContext.b(this.jdField_a_of_type_JavaLangString);
      OCRPerformUtil.jdField_a_of_type_ComTencentMobileqqGalleryPicocrPicOcrManager$OCRReqContext.a(true);
      a(OCRPerformUtil.jdField_a_of_type_ComTencentMobileqqGalleryPicocrPicOcrManager$OCRReqContext, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.OCRPerformFragment
 * JD-Core Version:    0.7.0.1
 */