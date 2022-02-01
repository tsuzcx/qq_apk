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
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.activity.contact.addcontact.findtroop.BubbleLayout;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.ar.utils.UniformUtils;
import com.tencent.mobileqq.armap.ScanSuccessView;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.gallery.picocr.PicOcrObserver;
import com.tencent.mobileqq.gallery.picocr.PicOcrRspResult;
import com.tencent.mobileqq.ocr.api.IPicOcrService;
import com.tencent.mobileqq.ocr.api.impl.OCRHandler;
import com.tencent.mobileqq.ocr.data.TranslateResult;
import com.tencent.mobileqq.ocr.req.OCRReqContext;
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
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.textpreview.BaseMenuUtil;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.util.AccessibilityUtils;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.OCRAccountUtil;
import com.tencent.mobileqq.widget.OCRBottomTabView;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.tfm.metrics.api.Metrics;
import com.tencent.tfm.metrics.api.MetricsApi;
import com.tencent.util.WeakReferenceHandler;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class OCRPerformFragment
  extends QPublicBaseFragment
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
  private QBaseActivity jdField_a_of_type_ComTencentMobileqqAppQBaseActivity;
  private ScanSuccessView jdField_a_of_type_ComTencentMobileqqArmapScanSuccessView;
  private PicOcrObserver jdField_a_of_type_ComTencentMobileqqGalleryPicocrPicOcrObserver = new OCRPerformFragment.6(this);
  private PicOcrRspResult jdField_a_of_type_ComTencentMobileqqGalleryPicocrPicOcrRspResult;
  private OCRObserver jdField_a_of_type_ComTencentMobileqqOcrOCRObserver = new OCRPerformFragment.11(this);
  private OCRHandler jdField_a_of_type_ComTencentMobileqqOcrApiImplOCRHandler;
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
    OcrImageTextView localOcrImageTextView = this.jdField_a_of_type_ComTencentMobileqqOcrViewOcrImageTextView;
    if ((localOcrImageTextView != null) && (localOcrImageTextView.b()))
    {
      OCRPerformUtil.jdField_b_of_type_JavaLangCharSequence = this.jdField_a_of_type_ComTencentMobileqqOcrViewOcrImageTextView.a();
      return OCRPerformUtil.jdField_b_of_type_JavaLangCharSequence;
    }
    if ((OCRPerformUtil.jdField_a_of_type_Boolean) && (OCRPerformUtil.jdField_a_of_type_ComTencentMobileqqOcrDataTranslateResult != null)) {
      return OCRPerformUtil.jdField_a_of_type_ComTencentMobileqqOcrDataTranslateResult.a();
    }
    return OCRPerformUtil.jdField_a_of_type_JavaLangCharSequence;
  }
  
  private void a(int paramInt)
  {
    HashMap localHashMap = new HashMap();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt);
    localStringBuilder.append("");
    localHashMap.put("param_ocr_is_cache", localStringBuilder.toString());
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance("", "picOcrIsCache", true, 0L, 0L, localHashMap, "");
  }
  
  private void a(long paramLong)
  {
    HashMap localHashMap = new HashMap();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramLong);
    localStringBuilder.append("");
    localHashMap.put("param_ocr_cost", localStringBuilder.toString());
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance("", "picOcrCost", true, 0L, 0L, localHashMap, "");
  }
  
  public static void a(Activity paramActivity, String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    Intent localIntent = new Intent(paramActivity, OCRPerformFragment.class);
    localIntent.putExtra("param_ocr_path", paramString1);
    localIntent.putExtra("PARAM_FROM", paramInt1);
    localIntent.addFlags(67108864);
    localIntent.putExtra("param_ocr_md5", paramString2);
    localIntent.putExtra("param_business_type", paramInt2);
    QPublicFragmentActivity.start(paramActivity, localIntent, OCRPerformFragment.class);
    paramActivity.overridePendingTransition(0, 0);
    OCRPerformUtil.a("0X80082C7", 0);
  }
  
  private void a(View paramView)
  {
    Object localObject = (OCRBottomTabView)paramView.findViewById(2131372067);
    ((OCRBottomTabView)localObject).setOnClickListener(this);
    if ((AppSetting.jdField_d_of_type_Boolean) && (((OCRBottomTabView)localObject).isEnabled())) {
      AccessibilityUtils.a((View)localObject, String.valueOf(((OCRBottomTabView)localObject).a()).trim());
    }
    localObject = (OCRBottomTabView)paramView.findViewById(2131372066);
    ((OCRBottomTabView)localObject).setOnClickListener(this);
    if ((AppSetting.jdField_d_of_type_Boolean) && (((OCRBottomTabView)localObject).isEnabled())) {
      AccessibilityUtils.a((View)localObject, String.valueOf(((OCRBottomTabView)localObject).a()).trim());
    }
    localObject = (OCRBottomTabView)paramView.findViewById(2131372065);
    ((OCRBottomTabView)localObject).setOnClickListener(this);
    if ((AppSetting.jdField_d_of_type_Boolean) && (((OCRBottomTabView)localObject).isEnabled())) {
      AccessibilityUtils.a((View)localObject, String.valueOf(((OCRBottomTabView)localObject).a()).trim());
    }
    localObject = (OCRBottomTabView)paramView.findViewById(2131372064);
    ((OCRBottomTabView)localObject).setOnClickListener(this);
    if ((AppSetting.jdField_d_of_type_Boolean) && (((OCRBottomTabView)localObject).isEnabled())) {
      AccessibilityUtils.a((View)localObject, String.valueOf(((OCRBottomTabView)localObject).a()).trim());
    }
    localObject = (OCRBottomTabView)paramView.findViewById(2131372068);
    ((OCRBottomTabView)localObject).setOnClickListener(this);
    if ((AppSetting.jdField_d_of_type_Boolean) && (((OCRBottomTabView)localObject).isEnabled())) {
      AccessibilityUtils.a((View)localObject, String.valueOf(((OCRBottomTabView)localObject).a()).trim());
    }
    this.jdField_b_of_type_JavaLangString = getResources().getString(2131699066);
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_ComTencentMobileqqOcrViewOcrImageTextView = ((OcrImageTextView)paramView.findViewById(2131372058));
    this.jdField_a_of_type_ComTencentMobileqqOcrViewOcrImageTextView.setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqOcrViewOcrImageTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131372060));
    localObject = (ImageButton)paramView.findViewById(2131372062);
    ((ImageButton)localObject).setOnClickListener(this);
    AccessibilityUtil.a((View)localObject, getResources().getString(2131690706), null);
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131372059));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131372054));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131372055));
    this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactFindtroopBubbleLayout = ((BubbleLayout)paramView.findViewById(2131372050));
    this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactFindtroopBubbleLayout.setSelected(true);
    localObject = (EyeButton)paramView.findViewById(2131372063);
    AccessibilityUtil.a((View)localObject, getResources().getString(2131699091), null);
    ((EyeButton)localObject).setLonTouchListener(new OCRPerformFragment.3(this));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131379087));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131379083));
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_d_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131372069));
    a(OCRPerformUtil.jdField_a_of_type_ComTencentMobileqqOcrOCRPerformUtil$OCRLanHolder, false);
    this.jdField_c_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131372061));
    this.jdField_c_of_type_AndroidWidgetRelativeLayout.bringToFront();
    UniformUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, this.jdField_c_of_type_AndroidWidgetRelativeLayout);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131372057));
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(4);
    this.jdField_a_of_type_ComTencentMobileqqOcrViewGestureGestureFrameLayout = ((GestureFrameLayout)paramView.findViewById(2131367623));
  }
  
  private void a(PicOcrRspResult paramPicOcrRspResult, boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateOcrResultData：");
      localStringBuilder.append(paramPicOcrRspResult.toString());
      QLog.d("OCRPerformFragment", 2, localStringBuilder.toString());
    }
    if (paramBoolean)
    {
      OCRPerformUtil.jdField_a_of_type_JavaLangCharSequence = OCRPerformUtil.a(paramPicOcrRspResult.jdField_a_of_type_JavaUtilArrayList);
      if (!OCRPerformUtil.jdField_a_of_type_Boolean)
      {
        OCRPerformUtil.jdField_a_of_type_ComTencentMobileqqOcrOCRPerformUtil$OCRLanHolder = OCRPerformUtil.a(OCRPerformUtil.jdField_a_of_type_ComTencentMobileqqOcrOCRPerformUtil$OCRLanHolder, paramPicOcrRspResult.jdField_b_of_type_JavaLangString, paramPicOcrRspResult.jdField_b_of_type_JavaUtilArrayList, paramPicOcrRspResult.jdField_a_of_type_JavaUtilHashMap);
        OCRPerformUtil.jdField_b_of_type_ComTencentMobileqqOcrOCRPerformUtil$OCRLanHolder = OCRPerformUtil.a(OCRPerformUtil.jdField_b_of_type_ComTencentMobileqqOcrOCRPerformUtil$OCRLanHolder, paramPicOcrRspResult.jdField_b_of_type_JavaLangString, paramPicOcrRspResult.jdField_b_of_type_JavaUtilArrayList, paramPicOcrRspResult.jdField_a_of_type_JavaUtilHashMap);
      }
      if (OCRPerformUtil.jdField_a_of_type_ComTencentMobileqqOcrReqOCRReqContext != null)
      {
        OCRPerformUtil.jdField_a_of_type_ComTencentMobileqqOcrReqOCRReqContext.jdField_a_of_type_JavaLangString = paramPicOcrRspResult.jdField_b_of_type_JavaLangString;
        OCRPerformUtil.jdField_a_of_type_ComTencentMobileqqOcrReqOCRReqContext.jdField_a_of_type_Int = this.jdField_b_of_type_Int;
        OCRPerformUtil.jdField_a_of_type_ComTencentMobileqqOcrReqOCRReqContext.jdField_d_of_type_JavaLangString = paramPicOcrRspResult.jdField_a_of_type_JavaLangString;
        OCRPerformUtil.jdField_a_of_type_ComTencentMobileqqOcrReqOCRReqContext.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
        OCRPerformUtil.jdField_a_of_type_ComTencentMobileqqOcrReqOCRReqContext.f = paramPicOcrRspResult.jdField_c_of_type_JavaLangString;
        OCRPerformUtil.jdField_a_of_type_ComTencentMobileqqOcrReqOCRReqContext.jdField_b_of_type_Int = paramPicOcrRspResult.jdField_d_of_type_Int;
        OCRPerformUtil.jdField_a_of_type_ComTencentMobileqqOcrReqOCRReqContext.jdField_c_of_type_Int = paramPicOcrRspResult.e;
        OCRPerformUtil.jdField_a_of_type_ComTencentMobileqqOcrReqOCRReqContext.jdField_a_of_type_Long = paramPicOcrRspResult.jdField_c_of_type_Int;
        OCRPerformUtil.jdField_a_of_type_ComTencentMobileqqOcrReqOCRReqContext.e = paramPicOcrRspResult.jdField_d_of_type_JavaLangString;
      }
      paramPicOcrRspResult.f = BaseImageUtil.c(this.jdField_a_of_type_JavaLangString);
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
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("showTranslateSrcLanOptions, lanHolder:");
      ((StringBuilder)localObject).append(paramOCRLanHolder.a());
      QLog.d("OCRPerformFragment", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqOcrViewTranslateLanguageOptionsView;
    if ((localObject != null) && (((TranslateLanguageOptionsView)localObject).isShowing())) {
      this.jdField_a_of_type_ComTencentMobileqqOcrViewTranslateLanguageOptionsView.dismiss();
    }
    localObject = this.jdField_b_of_type_ComTencentMobileqqOcrViewTranslateLanguageOptionsView;
    if ((localObject != null) && (((TranslateLanguageOptionsView)localObject).isShowing()))
    {
      this.jdField_b_of_type_ComTencentMobileqqOcrViewTranslateLanguageOptionsView.dismiss();
      return;
    }
    if (paramOCRLanHolder.jdField_b_of_type_JavaUtilList != null)
    {
      if (paramOCRLanHolder.jdField_b_of_type_JavaUtilList.size() == 0) {
        return;
      }
      localObject = new ArrayList();
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
        ((List)localObject).add(localOptionItem);
        i += 1;
      }
      this.jdField_b_of_type_ComTencentMobileqqOcrViewTranslateLanguageOptionsView = TranslateLanguageOptionsView.a(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, (List)localObject, j, new OCRPerformFragment.7(this, paramOCRLanHolder));
      i = this.jdField_b_of_type_AndroidWidgetTextView.getMeasuredWidth() / 2;
      j = DisplayUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, 75.0F);
      this.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
      this.jdField_b_of_type_ComTencentMobileqqOcrViewTranslateLanguageOptionsView.showAsDropDown(this.jdField_b_of_type_AndroidWidgetTextView, i - j, 0);
      this.jdField_b_of_type_ComTencentMobileqqOcrViewTranslateLanguageOptionsView.setOnDismissListener(new OCRPerformFragment.8(this, paramOCRLanHolder));
    }
  }
  
  private void a(OCRPerformUtil.OCRLanHolder paramOCRLanHolder, boolean paramBoolean)
  {
    int i;
    if (paramBoolean) {
      i = 2130841514;
    } else {
      i = 2130841513;
    }
    if (paramBoolean) {
      localObject = "#00CAFC";
    } else {
      localObject = "#FFFFFF";
    }
    OCRBottomTabView localOCRBottomTabView = (OCRBottomTabView)this.jdField_a_of_type_AndroidViewView.findViewById(2131372068);
    if (localOCRBottomTabView != null)
    {
      localOCRBottomTabView.setTabImage(getResources().getDrawable(i));
      localOCRBottomTabView.setTabTextColor(Color.parseColor((String)localObject));
    }
    Object localObject = this.jdField_d_of_type_AndroidWidgetRelativeLayout;
    if (paramBoolean) {
      i = 0;
    } else {
      i = 8;
    }
    ((RelativeLayout)localObject).setVisibility(i);
    if (!paramBoolean) {
      return;
    }
    if (paramOCRLanHolder == null) {
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("updateTranslateTitle, lanHolder:");
      ((StringBuilder)localObject).append(paramOCRLanHolder.a());
      QLog.d("OCRPerformFragment", 2, ((StringBuilder)localObject).toString());
    }
    this.jdField_b_of_type_AndroidWidgetTextView.setText(paramOCRLanHolder.a(paramOCRLanHolder.jdField_b_of_type_JavaLangString));
    this.jdField_c_of_type_AndroidWidgetTextView.setText(paramOCRLanHolder.a(paramOCRLanHolder.jdField_c_of_type_JavaLangString));
    if ((paramOCRLanHolder.jdField_b_of_type_JavaUtilList != null) && (paramOCRLanHolder.jdField_b_of_type_JavaUtilList.size() > 1))
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setClickable(true);
      localObject = getResources().getDrawable(2130846355);
      this.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, null, (Drawable)localObject);
    }
    else
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setClickable(false);
      this.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
    }
    if ((paramOCRLanHolder.jdField_c_of_type_JavaUtilList != null) && (paramOCRLanHolder.jdField_c_of_type_JavaUtilList.size() > 1))
    {
      this.jdField_c_of_type_AndroidWidgetTextView.setClickable(true);
      paramOCRLanHolder = getResources().getDrawable(2130846355);
      this.jdField_c_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, null, paramOCRLanHolder);
      return;
    }
    this.jdField_c_of_type_AndroidWidgetTextView.setClickable(false);
    this.jdField_c_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
  }
  
  private void a(TranslateResult paramTranslateResult)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("src:");
      localStringBuilder.append(paramTranslateResult.jdField_a_of_type_JavaLangString);
      localStringBuilder.append(", dst:");
      localStringBuilder.append(paramTranslateResult.jdField_b_of_type_JavaLangString);
      localStringBuilder.append(", OCRLanHolder:");
      localStringBuilder.append(OCRPerformUtil.jdField_a_of_type_ComTencentMobileqqOcrOCRPerformUtil$OCRLanHolder.a());
      QLog.d("OCRPerformFragment", 2, localStringBuilder.toString());
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
  
  private void a(OCRReqContext paramOCRReqContext, boolean paramBoolean)
  {
    if ((paramBoolean) && (OCRPerformUtil.jdField_a_of_type_ComTencentMobileqqGalleryPicocrPicOcrRspResult != null))
    {
      a(1);
      a(OCRPerformUtil.jdField_a_of_type_ComTencentMobileqqGalleryPicocrPicOcrRspResult, false);
      return;
    }
    if (paramOCRReqContext == null)
    {
      paramOCRReqContext = new StringBuilder();
      paramOCRReqContext.append("requestOcr, reqContext is null!!! BusinessType = ");
      paramOCRReqContext.append(this.jdField_b_of_type_Int);
      QLog.d("OCRPerformFragment", 2, paramOCRReqContext.toString());
      return;
    }
    StringBuilder localStringBuilder;
    if (!FileUtils.fileExists(paramOCRReqContext.jdField_b_of_type_JavaLangString))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("requestOcr, file not exist, picPath:");
      localStringBuilder.append(paramOCRReqContext.jdField_b_of_type_JavaLangString);
      QLog.d("OCRPerformFragment", 1, localStringBuilder.toString());
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, 1, 2131699074, 0).a();
      return;
    }
    if (this.jdField_a_of_type_Boolean)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("requestOcr, in ocr request, ");
      localStringBuilder.append(paramOCRReqContext.jdField_b_of_type_JavaLangString);
      QLog.d("OCRPerformFragment", 1, localStringBuilder.toString());
      return;
    }
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("requestOcr:");
      localStringBuilder.append(paramOCRReqContext.jdField_b_of_type_JavaLangString);
      QLog.d("OCRPerformFragment", 2, localStringBuilder.toString());
    }
    i();
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    ((IPicOcrService)this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getAppRuntime().getRuntimeService(IPicOcrService.class, "")).requestOcr(paramOCRReqContext, this.jdField_a_of_type_ComTencentMobileqqGalleryPicocrPicOcrObserver);
    this.jdField_a_of_type_Int += 1;
  }
  
  private void a(String paramString)
  {
    OCRPerformUtil.jdField_b_of_type_JavaLangCharSequence = a();
    Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, OCRResultFragmentNew.class);
    localIntent.putExtra("param_ocr_path", paramString);
    QPublicFragmentActivity.start(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, localIntent, OCRResultFragmentNew.class);
    this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.overridePendingTransition(0, 0);
  }
  
  private void a(String paramString1, String paramString2, boolean paramBoolean)
  {
    if ((paramBoolean) && (OCRPerformUtil.jdField_a_of_type_ComTencentMobileqqOcrDataTranslateResult != null))
    {
      a(OCRPerformUtil.jdField_a_of_type_ComTencentMobileqqOcrDataTranslateResult);
      return;
    }
    if (this.jdField_a_of_type_Boolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("OCRPerformFragment", 2, "updateTranslateTitle, inTranslateRequestNow");
      }
      return;
    }
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)))
    {
      if (!NetworkUtil.isNetworkAvailable(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity))
      {
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, 1, 2131692183, 0).a();
        OCRPerformUtil.a("0X800B557", 0);
        return;
      }
      String str = String.valueOf(OCRPerformUtil.jdField_a_of_type_JavaLangCharSequence);
      if (TextUtils.isEmpty(str))
      {
        QLog.d("OCRPerformFragment", 1, "requestTranslate, mInputTransText null");
        return;
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("requestTranslate, srcLan:");
        ((StringBuilder)localObject).append(paramString1);
        ((StringBuilder)localObject).append(", dstLan:");
        ((StringBuilder)localObject).append(paramString2);
        QLog.d("OCRPerformFragment", 2, ((StringBuilder)localObject).toString());
      }
      this.jdField_a_of_type_Boolean = true;
      b(false);
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqOcrApiImplOCRHandler;
      if (localObject != null) {
        ((OCRHandler)localObject).a(str, paramString1, paramString2);
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("OCRPerformFragment", 2, "updateTranslateTitle, srcLan/dstLan is null");
    }
  }
  
  private void a(List<OcrImageTextBean> paramList, List<OcrImageSectBean> paramList1)
  {
    paramList = new OcrScrollGestureListener(this.jdField_a_of_type_ComTencentMobileqqOcrViewGestureGestureFrameLayout, paramList, paramList1, this, this);
    this.jdField_a_of_type_ComTencentMobileqqOcrViewGestureGestureFrameLayout.a().a(paramList);
  }
  
  private void a(boolean paramBoolean)
  {
    String str1 = getResources().getString(2131699095);
    String str2 = getResources().getString(2131699098);
    OCRBottomTabView localOCRBottomTabView = (OCRBottomTabView)this.jdField_a_of_type_AndroidViewView.findViewById(2131372064);
    if (paramBoolean)
    {
      String str3 = String.valueOf(localOCRBottomTabView.a());
      StringBuilder localStringBuilder;
      if (!str3.contains(str2))
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(str3);
        localStringBuilder.append(str2);
        localOCRBottomTabView.setTabText(localStringBuilder.toString());
      }
      localOCRBottomTabView = (OCRBottomTabView)this.jdField_a_of_type_AndroidViewView.findViewById(2131372067);
      str3 = String.valueOf(localOCRBottomTabView.a());
      if (!str3.contains(str2))
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(str3);
        localStringBuilder.append(str2);
        localOCRBottomTabView.setTabText(localStringBuilder.toString());
      }
      localOCRBottomTabView = (OCRBottomTabView)this.jdField_a_of_type_AndroidViewView.findViewById(2131372066);
      str3 = String.valueOf(localOCRBottomTabView.a());
      if (!str3.contains(str2)) {
        localOCRBottomTabView.setTabText(str3.replace(str1, str2));
      }
      this.jdField_b_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString.replace(str1, str2);
      return;
    }
    localOCRBottomTabView.setTabText(getResources().getString(2131699092));
    ((OCRBottomTabView)this.jdField_a_of_type_AndroidViewView.findViewById(2131372067)).setTabText(getResources().getString(2131692635));
    ((OCRBottomTabView)this.jdField_a_of_type_AndroidViewView.findViewById(2131372068)).setTabText(getResources().getString(2131699086));
    ((OCRBottomTabView)this.jdField_a_of_type_AndroidViewView.findViewById(2131372066)).setTabText(getResources().getString(2131699093));
    this.jdField_b_of_type_JavaLangString = getResources().getString(2131699066);
  }
  
  private void b(OCRPerformUtil.OCRLanHolder paramOCRLanHolder)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("showTranslateDstLanOptions, lanHolder:");
      ((StringBuilder)localObject).append(paramOCRLanHolder.a());
      QLog.d("OCRPerformFragment", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.jdField_b_of_type_ComTencentMobileqqOcrViewTranslateLanguageOptionsView;
    if ((localObject != null) && (((TranslateLanguageOptionsView)localObject).isShowing())) {
      this.jdField_b_of_type_ComTencentMobileqqOcrViewTranslateLanguageOptionsView.dismiss();
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqOcrViewTranslateLanguageOptionsView;
    if ((localObject != null) && (((TranslateLanguageOptionsView)localObject).isShowing()))
    {
      this.jdField_a_of_type_ComTencentMobileqqOcrViewTranslateLanguageOptionsView.dismiss();
      return;
    }
    if (paramOCRLanHolder.jdField_c_of_type_JavaUtilList != null)
    {
      if (paramOCRLanHolder.jdField_c_of_type_JavaUtilList.size() == 0) {
        return;
      }
      localObject = new ArrayList();
      int i = 0;
      int j = 0;
      while (i < paramOCRLanHolder.jdField_c_of_type_JavaUtilList.size())
      {
        String str = (String)paramOCRLanHolder.jdField_c_of_type_JavaUtilList.get(i);
        if (!str.equalsIgnoreCase(paramOCRLanHolder.jdField_b_of_type_JavaLangString))
        {
          if (str.equalsIgnoreCase(paramOCRLanHolder.jdField_c_of_type_JavaLangString)) {
            j = i;
          }
          TranslateLanguageOptionsView.OptionItem localOptionItem = new TranslateLanguageOptionsView.OptionItem();
          localOptionItem.jdField_b_of_type_JavaLangString = str;
          localOptionItem.jdField_a_of_type_JavaLangString = OCRPerformUtil.a(str);
          ((List)localObject).add(localOptionItem);
        }
        i += 1;
      }
      this.jdField_a_of_type_ComTencentMobileqqOcrViewTranslateLanguageOptionsView = TranslateLanguageOptionsView.a(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, (List)localObject, j, new OCRPerformFragment.9(this, paramOCRLanHolder));
      i = this.jdField_c_of_type_AndroidWidgetTextView.getMeasuredWidth() / 2;
      j = DisplayUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, 75.0F);
      this.jdField_c_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
      this.jdField_a_of_type_ComTencentMobileqqOcrViewTranslateLanguageOptionsView.showAsDropDown(this.jdField_c_of_type_AndroidWidgetTextView, i - j, 0);
      this.jdField_a_of_type_ComTencentMobileqqOcrViewTranslateLanguageOptionsView.setOnDismissListener(new OCRPerformFragment.10(this, paramOCRLanHolder));
    }
  }
  
  private void b(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      QQProgressDialog localQQProgressDialog = this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
      if ((localQQProgressDialog != null) && (localQQProgressDialog.isShowing())) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
      }
    }
    else
    {
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, getResources().getDimensionPixelSize(2131299168));
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(2131699090);
      }
      if (!this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.isFinishing()) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
      }
      OCRPerformUtil.a("0X800B556", 0);
    }
  }
  
  private void e()
  {
    SharedPreferences localSharedPreferences = MobileQQ.sMobileQQ.getSharedPreferences("check_update_sp_key", 0);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("businessinfo_ocr_gesture_guide_");
    ((StringBuilder)localObject).append(OCRAccountUtil.a());
    localObject = ((StringBuilder)localObject).toString();
    if (localSharedPreferences.getBoolean((String)localObject, true))
    {
      this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130841510);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131699096);
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      localSharedPreferences.edit().putBoolean((String)localObject, false).commit();
      return;
    }
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
  }
  
  private void f()
  {
    SharedPreferences localSharedPreferences = MobileQQ.sMobileQQ.getSharedPreferences("check_update_sp_key", 0);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("businessinfo_ocr_gesture_select_guide_");
    ((StringBuilder)localObject).append(OCRAccountUtil.a());
    localObject = ((StringBuilder)localObject).toString();
    if (localSharedPreferences.getBoolean((String)localObject, true))
    {
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130841511);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131699097);
      localSharedPreferences.edit().putBoolean((String)localObject, false).commit();
      return;
    }
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
  }
  
  private void g()
  {
    SharedPreferences localSharedPreferences = MobileQQ.sMobileQQ.getSharedPreferences("check_update_sp_key", 0);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("businessinfo_ocr_gesture_fullText_guide_");
    ((StringBuilder)localObject).append(OCRAccountUtil.a());
    localObject = ((StringBuilder)localObject).toString();
    if (localSharedPreferences.getBoolean((String)localObject, true))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactFindtroopBubbleLayout.setVisibility(0);
      localSharedPreferences.edit().putBoolean((String)localObject, false).commit();
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactFindtroopBubbleLayout.setVisibility(8);
  }
  
  private void h()
  {
    this.jdField_a_of_type_ComTencentWidgetActionSheet = ActionSheet.create(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity);
    this.jdField_a_of_type_ComTencentWidgetActionSheet.addButton(this.jdField_b_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentWidgetActionSheet.addButton(2131699065);
    this.jdField_a_of_type_ComTencentWidgetActionSheet.addCancelButton(2131690728);
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
      this.jdField_a_of_type_ComTencentMobileqqArmapScanSuccessView = new ScanSuccessView(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity);
      this.jdField_a_of_type_ComTencentMobileqqArmapScanSuccessView.setShowProgress(false);
      this.jdField_a_of_type_ComTencentMobileqqArmapScanSuccessView.setBackgroundColor(2130706432);
      this.jdField_a_of_type_ComTencentMobileqqArmapScanSuccessView.setScale(ScreenUtil.SCREEN_WIDTH);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_ComTencentMobileqqArmapScanSuccessView, localLayoutParams);
      this.jdField_a_of_type_ComTencentMobileqqArmapScanSuccessView.setScanText(HardCodeUtil.a(2131707820));
    }
    if (this.jdField_a_of_type_AndroidWidgetImageView == null)
    {
      localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      this.jdField_a_of_type_AndroidWidgetImageView = new ImageView(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130843435);
      localLayoutParams.leftMargin = DisplayUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, 12.0F);
      if (ImmersiveUtils.isSupporImmersive() == 1) {
        localLayoutParams.topMargin = (ImmersiveUtils.getStatusBarHeight(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity) + DisplayUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, 12.0F));
      } else {
        localLayoutParams.topMargin = DisplayUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, 12.0F);
      }
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_AndroidWidgetImageView, localLayoutParams);
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new OCRPerformFragment.5(this));
      this.jdField_a_of_type_AndroidWidgetImageView.bringToFront();
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
    OcrImageTextView localOcrImageTextView = this.jdField_a_of_type_ComTencentMobileqqOcrViewOcrImageTextView;
    if (localOcrImageTextView != null) {
      a(localOcrImageTextView.a(), this.jdField_a_of_type_ComTencentMobileqqOcrViewOcrImageTextView.b());
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
    } else if (f == 1.0F) {
      bool = this.jdField_a_of_type_ComTencentMobileqqOcrViewOcrImageTextView.a(this.jdField_a_of_type_ComTencentMobileqqOcrViewGestureGestureFrameLayout.getHeight()) ^ true;
    } else {
      bool = false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("OCRPerformFragment", 2, new Object[] { "checkImageFitView, zoom:", Float.valueOf(f), " result:", Boolean.valueOf(bool) });
    }
    return bool;
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
      return;
    }
    if ((!this.jdField_d_of_type_Boolean) && (!this.jdField_a_of_type_ComTencentMobileqqOcrViewOcrImageTextView.a(this.jdField_a_of_type_ComTencentMobileqqOcrViewGestureGestureFrameLayout.getHeight())))
    {
      this.jdField_d_of_type_Boolean = true;
      e();
      return;
    }
    if (!this.e)
    {
      this.e = true;
      g();
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("what:");
      localStringBuilder.append(paramMessage.what);
      QLog.i("OCRPerformFragment", 2, localStringBuilder.toString());
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
          return true;
        }
      }
      else
      {
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, 1, 2131699070, 0).a();
        onBackEvent();
        return true;
      }
    }
    else
    {
      if (paramMessage.what == 101)
      {
        QQToast.a(MobileQQ.sMobileQQ, 1, 2131699075, 0).a();
        onBackEvent();
        return true;
      }
      if (paramMessage.what == 102)
      {
        paramMessage = (PicOcrRspResult)paramMessage.obj;
        if (paramMessage != null)
        {
          if (this.jdField_b_of_type_Boolean)
          {
            if (QLog.isColorLevel()) {
              QLog.i("OCRPerformFragment", 2, "onUpdate useRspCache！");
            }
            this.jdField_a_of_type_ComTencentMobileqqGalleryPicocrPicOcrObserver.onUpdate(100, true, paramMessage);
            return true;
          }
          this.jdField_a_of_type_ComTencentMobileqqGalleryPicocrPicOcrRspResult = paramMessage;
        }
      }
    }
    return true;
  }
  
  public void initWindowStyleAndAnimation(Activity paramActivity)
  {
    paramActivity.overridePendingTransition(2130771993, 2130771991);
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
    this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity = ((QBaseActivity)paramActivity);
  }
  
  public boolean onBackEvent()
  {
    QBaseActivity localQBaseActivity = this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity;
    if (localQBaseActivity != null) {
      localQBaseActivity.finish();
    }
    return true;
  }
  
  public void onClick(View paramView)
  {
    int i1 = paramView.getId();
    if (i1 == 2131372062)
    {
      OCRPerformUtil.a("0X800AAE0", 0);
      onBackEvent();
    }
    else
    {
      int k = 1;
      int m = 1;
      int n = 1;
      int i = 1;
      Object localObject;
      if (i1 == 2131372063)
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqOcrViewOcrImageTextView;
        ((OcrImageTextView)localObject).setShowTextMask(((OcrImageTextView)localObject).a() ^ true);
      }
      else if (i1 == 2131372065)
      {
        OCRPerformUtil.b(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, this.jdField_a_of_type_JavaLangString);
        if (OCRPerformUtil.jdField_a_of_type_Boolean) {
          localObject = "0X800B55C";
        } else {
          localObject = "0X800AAE2";
        }
        OCRPerformUtil.a((String)localObject, 0);
      }
      else
      {
        int j = 2;
        if (i1 == 2131372064)
        {
          BaseMenuUtil.copy(String.valueOf(a()), "OCRPerformFragment");
          if (OCRPerformUtil.jdField_a_of_type_Boolean) {
            localObject = "0X800B55D";
          } else {
            localObject = "0X800AAE7";
          }
          if (this.jdField_a_of_type_ComTencentMobileqqOcrViewOcrImageTextView.b()) {
            i = 2;
          }
          OCRPerformUtil.a((String)localObject, i);
        }
        else if (i1 == 2131372068)
        {
          OCRPerformUtil.jdField_a_of_type_Boolean ^= true;
          if (OCRPerformUtil.jdField_a_of_type_Boolean) {
            localObject = "0X800B555";
          } else {
            localObject = "0X800B562";
          }
          if (this.jdField_a_of_type_ComTencentMobileqqOcrViewOcrImageTextView.b()) {
            i = j;
          } else {
            i = 1;
          }
          OCRPerformUtil.a((String)localObject, i);
          a(false);
          if (OCRPerformUtil.jdField_a_of_type_Boolean)
          {
            a(OCRPerformUtil.jdField_a_of_type_ComTencentMobileqqOcrOCRPerformUtil$OCRLanHolder.jdField_b_of_type_JavaLangString, OCRPerformUtil.jdField_a_of_type_ComTencentMobileqqOcrOCRPerformUtil$OCRLanHolder.jdField_c_of_type_JavaLangString, true);
            OCRPerformUtil.jdField_b_of_type_ComTencentMobileqqOcrOCRPerformUtil$OCRLanHolder.a(OCRPerformUtil.jdField_a_of_type_ComTencentMobileqqOcrOCRPerformUtil$OCRLanHolder.jdField_c_of_type_JavaLangString);
          }
          else
          {
            a(OCRPerformUtil.jdField_a_of_type_ComTencentMobileqqOcrOCRPerformUtil$OCRLanHolder, false);
            a(OCRPerformUtil.jdField_a_of_type_ComTencentMobileqqOcrReqOCRReqContext, true);
            OCRPerformUtil.jdField_b_of_type_ComTencentMobileqqOcrOCRPerformUtil$OCRLanHolder.a(OCRPerformUtil.jdField_a_of_type_ComTencentMobileqqOcrOCRPerformUtil$OCRLanHolder);
          }
        }
        else if (i1 == 2131372067)
        {
          if (OCRPerformUtil.jdField_a_of_type_Boolean) {
            localObject = "0X800B55E";
          } else {
            localObject = "0X800AAE8";
          }
          i = k;
          if (this.jdField_a_of_type_ComTencentMobileqqOcrViewOcrImageTextView.b()) {
            i = 2;
          }
          OCRPerformUtil.a((String)localObject, i);
          h();
        }
        else if (i1 == 2131372066)
        {
          if ((this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactFindtroopBubbleLayout != null) && (this.jdField_a_of_type_AndroidWidgetLinearLayout.getVisibility() != 8)) {
            this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactFindtroopBubbleLayout.setVisibility(8);
          }
          a(this.jdField_a_of_type_JavaLangString);
          if (OCRPerformUtil.jdField_a_of_type_Boolean) {
            localObject = "0X800B561";
          } else {
            localObject = "0X800AAEC";
          }
          i = m;
          if (this.jdField_a_of_type_ComTencentMobileqqOcrViewOcrImageTextView.b()) {
            i = 2;
          }
          OCRPerformUtil.a((String)localObject, i);
        }
        else if (i1 == 2131365311)
        {
          BaseMenuUtil.copy(String.valueOf(a()), "OCRPerformFragment");
          OCRPerformUtil.a("0X800AAEF", 0);
        }
        else if (i1 == 2131367180)
        {
          OCRPerformUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, String.valueOf(a()));
          OCRPerformUtil.a("0X800AAF0", 0);
        }
        else if (i1 == 2131379096)
        {
          TranslateFragment.a(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, String.valueOf(a()));
          i = n;
          if (this.jdField_a_of_type_ComTencentMobileqqOcrViewOcrImageTextView.b()) {
            i = 2;
          }
          OCRPerformUtil.a("0X800AAEB", i);
        }
        else if (i1 == 2131372059)
        {
          this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
          d();
        }
        else if (i1 == 2131379087)
        {
          a(OCRPerformUtil.jdField_a_of_type_ComTencentMobileqqOcrOCRPerformUtil$OCRLanHolder);
        }
        else if (i1 == 2131379083)
        {
          b(OCRPerformUtil.jdField_a_of_type_ComTencentMobileqqOcrOCRPerformUtil$OCRLanHolder);
        }
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    OCRPerformUtil.jdField_a_of_type_Boolean = false;
    paramBundle = this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getIntent();
    this.jdField_a_of_type_JavaLangString = paramBundle.getStringExtra("param_ocr_path");
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("mPicPath=");
      localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
      QLog.e("OCRPerformFragment", 2, localStringBuilder.toString());
    }
    this.jdField_b_of_type_Int = paramBundle.getIntExtra("param_business_type", -1);
    paramBundle = paramBundle.getStringExtra("param_ocr_md5");
    if (OCRPerformUtil.jdField_a_of_type_ComTencentMobileqqOcrReqOCRReqContext == null)
    {
      OCRPerformUtil.jdField_a_of_type_ComTencentMobileqqOcrReqOCRReqContext = new OCRReqContext();
      OCRPerformUtil.jdField_a_of_type_ComTencentMobileqqOcrReqOCRReqContext.jdField_a_of_type_JavaLangString = "";
      OCRPerformUtil.jdField_a_of_type_ComTencentMobileqqOcrReqOCRReqContext.jdField_a_of_type_Boolean = false;
    }
    OCRPerformUtil.jdField_a_of_type_ComTencentMobileqqOcrReqOCRReqContext.jdField_a_of_type_Int = this.jdField_b_of_type_Int;
    OCRPerformUtil.jdField_a_of_type_ComTencentMobileqqOcrReqOCRReqContext.jdField_d_of_type_JavaLangString = paramBundle;
    OCRPerformUtil.jdField_a_of_type_ComTencentMobileqqOcrReqOCRReqContext.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = new OCRPerformFragment.1(this);
    paramBundle = new IntentFilter();
    paramBundle.addAction("tencent.av.v2q.StartVideoChat");
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, paramBundle);
    }
    catch (Exception paramBundle)
    {
      paramBundle.printStackTrace();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getAppRuntime() != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.addObserver(this.jdField_a_of_type_ComTencentMobileqqOcrOCRObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.addObserver(this.jdField_a_of_type_ComTencentMobileqqGalleryPicocrPicOcrObserver);
    }
    this.jdField_a_of_type_ComTencentMobileqqOcrApiImplOCRHandler = ((OCRHandler)((AppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null)).getBusinessHandler(OCRHandler.jdField_a_of_type_JavaLangString));
    MetricsApi.getDefault().buildSuccessRateCounter("OCR_REQUEST");
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131561256, paramViewGroup, false);
    a(paramLayoutInflater);
    ThreadManager.excute(new OCRPerformFragment.2(this), 16, null, true);
    a(OCRPerformUtil.jdField_a_of_type_ComTencentMobileqqOcrReqOCRReqContext, false);
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("OCRPerformFragment", 2, "onDestroy!");
    }
    Object localObject = this.jdField_a_of_type_AndroidContentBroadcastReceiver;
    if (localObject != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.unregisterReceiver((BroadcastReceiver)localObject);
      this.jdField_a_of_type_AndroidContentBroadcastReceiver = null;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.removeObserver(this.jdField_a_of_type_ComTencentMobileqqOcrOCRObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.removeObserver(this.jdField_a_of_type_ComTencentMobileqqGalleryPicocrPicOcrObserver);
    localObject = this.jdField_a_of_type_ComTencentMobileqqOcrViewOcrImageTextView;
    if (localObject != null)
    {
      ((OcrImageTextView)localObject).b();
      this.jdField_a_of_type_ComTencentMobileqqOcrViewOcrImageTextView.a();
    }
    OCRPerformUtil.a();
    this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity = null;
    super.onDestroy();
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    if ((paramIntent != null) && (paramIntent.getIntExtra("qq_sub_business_id", -1) == 103))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.isInMultiWindow())
      {
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, 2131695223, 0).a();
      }
      else
      {
        this.jdField_a_of_type_JavaLangString = paramIntent.getStringExtra("PhotoConst.SINGLE_PHOTO_PATH");
        this.jdField_a_of_type_ComTencentMobileqqOcrViewOcrImageTextView.setImageURI(Uri.fromFile(new File(this.jdField_a_of_type_JavaLangString)));
        this.jdField_a_of_type_ComTencentMobileqqOcrViewGestureGestureFrameLayout.a().b();
        this.jdField_a_of_type_ComTencentMobileqqOcrViewOcrImageTextView.setShowTextMask(false);
        OCRPerformUtil.jdField_a_of_type_ComTencentMobileqqOcrReqOCRReqContext.a();
        OCRPerformUtil.jdField_a_of_type_ComTencentMobileqqOcrReqOCRReqContext.b(this.jdField_a_of_type_JavaLangString);
        OCRPerformUtil.jdField_a_of_type_ComTencentMobileqqOcrReqOCRReqContext.a(true);
        a(OCRPerformUtil.jdField_a_of_type_ComTencentMobileqqOcrReqOCRReqContext, false);
      }
      ReportController.b(null, "dc00898", "", "", "0X80082DD", "0X80082DD", 0, 0, "", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.OCRPerformFragment
 * JD-Core Version:    0.7.0.1
 */