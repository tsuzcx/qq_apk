package com.tencent.mobileqq.ocr;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.CancelDialogListener;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.ar.utils.UniformUtils;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.gallery.picocr.PicOcrObserver;
import com.tencent.mobileqq.ocr.api.impl.PicOcrHandler;
import com.tencent.mobileqq.ocr.req.OCRReqContext;
import com.tencent.mobileqq.ocr.view.TDProgressDialog;
import com.tencent.mobileqq.ocr.view.gesture.GestureFrameLayout;
import com.tencent.mobileqq.ocr.view.gesture.GestureProxy;
import com.tencent.mobileqq.participle.ParticipleObserver;
import com.tencent.mobileqq.participle.api.IParticipleApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.teamwork.TenDocOCRExportHandler;
import com.tencent.mobileqq.teamwork.TenDocOCRExportObserver;
import com.tencent.mobileqq.teamwork.api.ITeamWorkDocEditBrowserProxy;
import com.tencent.mobileqq.teamwork.api.ITeamWorkDocsListFragment;
import com.tencent.mobileqq.teamwork.api.ITeamWorkUtils;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.textpreview.BaseMenuUtil;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.OCRBottomTabView;
import com.tencent.mobileqq.widget.ProgressView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.participle.ParticipleBottomMenuView;
import com.tencent.mobileqq.widget.participle.ParticipleView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.widget.ActionSheet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;

public class OCRResultFragmentNew
  extends QPublicBaseFragment
  implements Handler.Callback, View.OnClickListener, OCRPerformUtil.TextWatcher
{
  public static final String[] a;
  private int jdField_a_of_type_Int = -1;
  private Dialog jdField_a_of_type_AndroidAppDialog;
  View jdField_a_of_type_AndroidViewView;
  ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  EditText jdField_a_of_type_AndroidWidgetEditText;
  FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  URLImageView jdField_a_of_type_ComTencentImageURLImageView;
  private QBaseActivity jdField_a_of_type_ComTencentMobileqqAppQBaseActivity;
  private PicOcrObserver jdField_a_of_type_ComTencentMobileqqGalleryPicocrPicOcrObserver = new OCRResultFragmentNew.10(this);
  private TDProgressDialog jdField_a_of_type_ComTencentMobileqqOcrViewTDProgressDialog;
  GestureFrameLayout jdField_a_of_type_ComTencentMobileqqOcrViewGestureGestureFrameLayout;
  private ParticipleObserver jdField_a_of_type_ComTencentMobileqqParticipleParticipleObserver = new OCRResultFragmentNew.6(this);
  private TenDocOCRExportObserver jdField_a_of_type_ComTencentMobileqqTeamworkTenDocOCRExportObserver = new OCRResultFragmentNew.7(this, this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity);
  OCRBottomTabView jdField_a_of_type_ComTencentMobileqqWidgetOCRBottomTabView;
  private ProgressView jdField_a_of_type_ComTencentMobileqqWidgetProgressView;
  ParticipleBottomMenuView jdField_a_of_type_ComTencentMobileqqWidgetParticipleParticipleBottomMenuView;
  ParticipleView jdField_a_of_type_ComTencentMobileqqWidgetParticipleParticipleView;
  ActionSheet jdField_a_of_type_ComTencentWidgetActionSheet;
  private String jdField_a_of_type_JavaLangString;
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler;
  private boolean jdField_a_of_type_Boolean = false;
  private int jdField_b_of_type_Int = -1;
  View jdField_b_of_type_AndroidViewView;
  ViewGroup jdField_b_of_type_AndroidViewViewGroup;
  OCRBottomTabView jdField_b_of_type_ComTencentMobileqqWidgetOCRBottomTabView;
  private boolean jdField_b_of_type_Boolean;
  View jdField_c_of_type_AndroidViewView;
  ViewGroup jdField_c_of_type_AndroidViewViewGroup;
  
  static
  {
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { "M3X", "U20", "ZTE C2016", "Lenovo K900", "HUAWEI MT7-CL00", "HUAWEI G7-TL00", "PE-CL00", "Moto X Pro", "X907", "ASUS_Z00ADB", "HUAWEI P7-L07", "XT1581", "M821", "R7c" };
  }
  
  private CharSequence a(CharSequence paramCharSequence, boolean paramBoolean)
  {
    if (paramBoolean) {
      return new QQText(paramCharSequence, 8, 16);
    }
    return String.valueOf(paramCharSequence);
  }
  
  private void a() {}
  
  private void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    if (paramInt == 0)
    {
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      this.jdField_a_of_type_AndroidViewView.setBackgroundDrawable(new ColorDrawable(getResources().getColor(2131166468)));
      this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetEditText.setVisibility(0);
      this.jdField_b_of_type_AndroidViewViewGroup.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetEditText.setText(a(OCRPerformUtil.jdField_b_of_type_JavaLangCharSequence, true));
      this.jdField_a_of_type_ComTencentMobileqqWidgetParticipleParticipleBottomMenuView.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqWidgetParticipleParticipleView.setVisibility(8);
      this.jdField_b_of_type_ComTencentMobileqqWidgetOCRBottomTabView.setTabImage(getResources().getDrawable(2130841513));
      this.jdField_b_of_type_ComTencentMobileqqWidgetOCRBottomTabView.setTabText(getResources().getString(2131710536));
      a(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity);
      UniformUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, this.jdField_c_of_type_AndroidViewViewGroup, false, 0);
    }
    if (paramInt == 2)
    {
      a(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity);
      a();
      this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetEditText.setVisibility(8);
      this.jdField_b_of_type_AndroidViewViewGroup.setVisibility(8);
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqWidgetParticipleParticipleView.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqWidgetParticipleParticipleBottomMenuView.b();
      this.jdField_a_of_type_AndroidViewView.setBackgroundDrawable(getResources().getDrawable(2130838284));
      UniformUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, this.jdField_c_of_type_AndroidViewViewGroup, false, 0);
    }
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  private void a(EditText paramEditText)
  {
    paramEditText.setLinkTextColor(Color.parseColor("#12B7F5"));
    if (AppSetting.d) {
      paramEditText.setAutoLinkMask(7);
    } else {
      paramEditText.setAutoLinkMask(0);
    }
    paramEditText.addTextChangedListener(new OCRResultFragmentNew.2(this));
    if (a()) {
      paramEditText.setCustomSelectionActionModeCallback(new OCRResultFragmentNew.3(this, paramEditText));
    }
    this.jdField_a_of_type_AndroidViewView.getViewTreeObserver().addOnGlobalLayoutListener(new OCRResultFragmentNew.4(this, paramEditText));
    paramEditText.setOnTouchListener(new OCRResultFragmentNew.5(this));
  }
  
  private void a(QBaseActivity paramQBaseActivity)
  {
    if (paramQBaseActivity != null) {
      ((InputMethodManager)paramQBaseActivity.getSystemService("input_method")).hideSoftInputFromWindow(this.jdField_a_of_type_AndroidWidgetEditText.getWindowToken(), 0);
    }
  }
  
  private void a(OCRPerformUtil.OCRLanHolder paramOCRLanHolder)
  {
    if (paramOCRLanHolder != null)
    {
      if (paramOCRLanHolder.jdField_a_of_type_JavaUtilList.isEmpty()) {
        return;
      }
      this.jdField_a_of_type_ComTencentWidgetActionSheet = ActionSheet.create(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.setMainTitle(2131699080);
      ArrayList localArrayList = new ArrayList(paramOCRLanHolder.jdField_a_of_type_JavaUtilList.size());
      Iterator localIterator = paramOCRLanHolder.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        Pair localPair = paramOCRLanHolder.a((String)localIterator.next());
        if (localPair != null)
        {
          this.jdField_a_of_type_ComTencentWidgetActionSheet.addRadioButton((CharSequence)localPair.second, ((String)localPair.first).equalsIgnoreCase(paramOCRLanHolder.jdField_a_of_type_JavaLangString));
          localArrayList.add(localPair.first);
        }
      }
      this.jdField_a_of_type_ComTencentWidgetActionSheet.addCancelButton(2131690728);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.setOnButtonClickListener(new OCRResultFragmentNew.9(this, localArrayList, paramOCRLanHolder));
      try
      {
        this.jdField_a_of_type_ComTencentWidgetActionSheet.show();
        return;
      }
      catch (Exception paramOCRLanHolder)
      {
        paramOCRLanHolder.printStackTrace();
      }
    }
  }
  
  private void a(OCRReqContext paramOCRReqContext)
  {
    StringBuilder localStringBuilder;
    if (!FileUtils.fileExists(paramOCRReqContext.b))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("requestOcr, file not exist, picPath:");
      localStringBuilder.append(paramOCRReqContext.b);
      QLog.d("OCRResultFragmentNew", 1, localStringBuilder.toString());
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, 1, 2131699074, 0).a();
      return;
    }
    if (this.jdField_a_of_type_Boolean)
    {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, 0, 2131699077, 0).a();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("requestOcr, in ocr request, ");
      localStringBuilder.append(paramOCRReqContext.b);
      QLog.d("OCRResultFragmentNew", 1, localStringBuilder.toString());
      return;
    }
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("requestOcr:");
      localStringBuilder.append(paramOCRReqContext.b);
      QLog.d("OCRResultFragmentNew", 2, localStringBuilder.toString());
    }
    this.jdField_a_of_type_Boolean = true;
    paramOCRReqContext = (PicOcrHandler)((AppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null)).getBusinessHandler(PicOcrHandler.jdField_a_of_type_JavaLangString);
    if (paramOCRReqContext != null) {
      paramOCRReqContext.a(OCRPerformUtil.jdField_a_of_type_ComTencentMobileqqOcrReqOCRReqContext);
    }
  }
  
  public static boolean a()
  {
    String str = DeviceInfoUtil.d();
    boolean bool2 = TextUtils.isEmpty(str);
    boolean bool1 = false;
    Object localObject;
    if (!bool2)
    {
      localObject = jdField_a_of_type_ArrayOfJavaLangString;
      int j = localObject.length;
      int i = 0;
      while (i < j)
      {
        if (str.equals(localObject[i])) {
          break label57;
        }
        i += 1;
      }
    }
    bool1 = true;
    label57:
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("isSupportAddContextMenu mode:");
      ((StringBuilder)localObject).append(str);
      ((StringBuilder)localObject).append(",isSupport: ");
      ((StringBuilder)localObject).append(bool1);
      QLog.d("OCRResultFragmentNew", 2, ((StringBuilder)localObject).toString());
    }
    return bool1;
  }
  
  private void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetParticipleParticipleBottomMenuView.setOnMenuClickListener(new OCRResultFragmentNew.8(this));
    this.jdField_a_of_type_ComTencentMobileqqWidgetParticipleParticipleBottomMenuView.a(this.jdField_a_of_type_ComTencentMobileqqWidgetParticipleParticipleView);
  }
  
  private void b(String paramString)
  {
    if (!NetworkUtil.isNetSupport(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity))
    {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, HardCodeUtil.a(2131707824), 0).b(getResources().getDimensionPixelSize(2131299168));
      return;
    }
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    c();
    AppRuntime localAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
    if ((localAppRuntime instanceof AppInterface)) {
      ((IParticipleApi)QRoute.api(IParticipleApi.class)).participleTheContent((AppInterface)localAppRuntime, paramString);
    }
    if (localAppRuntime != null) {
      ReportController.b(localAppRuntime, "dc00898", "", "", "0X800A357", "0X800A357", 2, 0, "", "", "", "");
    }
  }
  
  private void c()
  {
    Dialog localDialog = this.jdField_a_of_type_AndroidAppDialog;
    if (localDialog == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetProgressView = new ProgressView(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity);
      this.jdField_a_of_type_AndroidAppDialog = new ReportDialog(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity);
      if (this.jdField_a_of_type_AndroidAppDialog.getWindow() != null) {
        this.jdField_a_of_type_AndroidAppDialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
      }
      this.jdField_a_of_type_AndroidAppDialog.setCanceledOnTouchOutside(false);
      this.jdField_a_of_type_AndroidAppDialog.requestWindowFeature(1);
      this.jdField_a_of_type_AndroidAppDialog.setContentView(this.jdField_a_of_type_ComTencentMobileqqWidgetProgressView);
      this.jdField_a_of_type_AndroidAppDialog.setOnCancelListener(new CancelDialogListener(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity));
    }
    else
    {
      localDialog.dismiss();
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetProgressView.setProgressText(HardCodeUtil.a(2131707826));
    this.jdField_a_of_type_AndroidAppDialog.show();
  }
  
  private void c(String paramString)
  {
    if (!NetworkUtil.isNetworkAvailable(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity))
    {
      QLog.d("OCRResultFragmentNew", 1, "requestExport2Doc, network error");
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, 1, 2131692183, 0).a();
      return;
    }
    StringBuilder localStringBuilder;
    if (!FileUtils.fileExists(paramString))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("requestExport2Doc, file not exist, picPath:");
      localStringBuilder.append(paramString);
      QLog.d("OCRResultFragmentNew", 1, localStringBuilder.toString());
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, 1, 2131699074, 0).a();
      return;
    }
    if (this.jdField_b_of_type_Boolean)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("requestExport2Doc, in export request, ");
      localStringBuilder.append(paramString);
      QLog.d("OCRResultFragmentNew", 1, localStringBuilder.toString());
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("OCRResultFragmentNew", 2, String.format("requestExport2Doc: %s", new Object[] { this.jdField_a_of_type_JavaLangString }));
    }
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_JavaLangString = paramString;
    ((TenDocOCRExportHandler)((AppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null)).getBusinessHandler(TenDocOCRExportHandler.jdField_a_of_type_JavaLangString)).a(this.jdField_a_of_type_JavaLangString);
  }
  
  public CharSequence a()
  {
    if (this.jdField_a_of_type_Int == 0) {
      return OCRPerformUtil.a(this.jdField_a_of_type_AndroidWidgetEditText);
    }
    return "";
  }
  
  protected void a(String paramString)
  {
    try
    {
      ActivityURIRequest localActivityURIRequest = new ActivityURIRequest(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, "/base/browser");
      String str = paramString;
      if (TextUtils.isEmpty(paramString)) {
        str = "https://docs.qq.com/desktop/m/index.html?_from=1";
      }
      paramString = ((ITeamWorkUtils)QRoute.api(ITeamWorkUtils.class)).getTencentDocSourceAdtagStrUrl(str, "s_qq_ocr_save");
      localActivityURIRequest.extra().putString("tdsourcetag", "s_qq_ocr_save");
      localActivityURIRequest.extra().putString("big_brother_source_key", "biz_src_jc_file");
      localActivityURIRequest.extra().putString("fragment_class", ((ITeamWorkDocsListFragment)QRoute.api(ITeamWorkDocsListFragment.class)).getCanonicalName());
      if (!((ITeamWorkDocEditBrowserProxy)QRoute.api(ITeamWorkDocEditBrowserProxy.class)).openDocsMiniApp(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, paramString, localActivityURIRequest.extra().getString("tdsourcetag")))
      {
        localActivityURIRequest.extra().putString("url", paramString);
        QRoute.startUri(localActivityURIRequest, null);
        return;
      }
    }
    catch (Exception paramString)
    {
      QLog.i("OCRResultFragmentNew", 1, paramString.toString());
    }
  }
  
  public CharSequence b()
  {
    if (this.jdField_a_of_type_Int == 0)
    {
      EditText localEditText = this.jdField_a_of_type_AndroidWidgetEditText;
      if (localEditText == null) {
        return OCRPerformUtil.jdField_a_of_type_JavaLangCharSequence;
      }
      return localEditText.getText();
    }
    return "";
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    return false;
  }
  
  public void initWindowStyleAndAnimation(Activity paramActivity)
  {
    paramActivity.overridePendingTransition(2130771993, 2130771991);
    paramActivity.getWindow().getDecorView().setSystemUiVisibility(1);
    paramActivity.getWindow().setSoftInputMode(16);
  }
  
  public boolean needImmersive()
  {
    return false;
  }
  
  public boolean needStatusTrans()
  {
    return false;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (QLog.isColorLevel()) {
      QLog.d("OCRResultFragmentNew", 2, "doOnActivityResult:OCRResultFragmentNew");
    }
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity = ((QBaseActivity)paramActivity);
  }
  
  public boolean onBackEvent()
  {
    a(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity);
    if (this.jdField_a_of_type_Int == 2) {
      a(0);
    } else {
      this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.finish();
    }
    return true;
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    Object localObject;
    if (i == 2131367183)
    {
      localObject = a();
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        OCRPerformUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, b().toString());
      } else {
        OCRPerformUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, ((CharSequence)localObject).toString());
      }
      OCRPerformUtil.a("0X8009C84", 0);
    }
    else if (i == 2131379097)
    {
      localObject = a();
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        TranslateFragment.a(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, String.valueOf(b()));
      } else {
        TranslateFragment.a(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, String.valueOf(localObject));
      }
      OCRPerformUtil.a("0X800AAF2", 0);
    }
    else if (i == 2131365252)
    {
      localObject = a();
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        BaseMenuUtil.copy(b().toString(), "OCRResultFragmentNew");
      } else {
        BaseMenuUtil.copy(((CharSequence)localObject).toString(), "OCRResultFragmentNew");
      }
      OCRPerformUtil.a("0X800AAF1", 0);
    }
    else if (i == 2131372326)
    {
      localObject = a();
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        b(String.valueOf(b()));
      } else {
        b(String.valueOf(localObject));
      }
      OCRPerformUtil.a("0X800A357", 2);
    }
    else if (i == 2131366366)
    {
      OCRPerformUtil.a("0X800A161", 0);
      c(this.jdField_a_of_type_JavaLangString);
    }
    else if (i == 2131372053)
    {
      a(OCRPerformUtil.jdField_b_of_type_ComTencentMobileqqOcrOCRPerformUtil$OCRLanHolder);
    }
    else if (i == 2131363340)
    {
      onBackEvent();
    }
    else if (i == 2131372049)
    {
      localObject = this.jdField_a_of_type_AndroidWidgetFrameLayout;
      if ((localObject != null) && (((FrameLayout)localObject).getVisibility() == 0))
      {
        this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(8);
        OCRPerformUtil.a("0X800AC96", 0);
      }
    }
    else if (i == 2131372073)
    {
      if ((this.jdField_a_of_type_JavaLangString != null) && (this.jdField_a_of_type_AndroidWidgetFrameLayout != null))
      {
        a(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity);
        this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(0);
      }
      OCRPerformUtil.a("0X800AC95", 0);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.jdField_a_of_type_JavaLangString = getActivity().getIntent().getStringExtra("param_ocr_path");
    this.jdField_a_of_type_MqqOsMqqHandler = new MqqHandler(Looper.getMainLooper(), this);
    this.jdField_a_of_type_ComTencentMobileqqOcrViewTDProgressDialog = new TDProgressDialog(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity);
    this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.addObserver(this.jdField_a_of_type_ComTencentMobileqqParticipleParticipleObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.addObserver(this.jdField_a_of_type_ComTencentMobileqqTeamworkTenDocOCRExportObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.addObserver(this.jdField_a_of_type_ComTencentMobileqqGalleryPicocrPicOcrObserver);
    OCRPerformUtil.a("0X800AD1A", 0);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    int j = 0;
    paramLayoutInflater = paramLayoutInflater.inflate(2131561257, paramViewGroup, false);
    this.jdField_a_of_type_AndroidViewView = paramLayoutInflater.findViewById(2131376809);
    this.jdField_b_of_type_AndroidViewView = paramLayoutInflater.findViewById(2131378886);
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)paramLayoutInflater.findViewById(2131372075));
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)paramLayoutInflater.findViewById(2131372071));
    this.jdField_b_of_type_AndroidViewViewGroup = ((ViewGroup)paramLayoutInflater.findViewById(2131363775));
    this.jdField_c_of_type_AndroidViewViewGroup = ((ViewGroup)paramLayoutInflater.findViewById(2131363779));
    this.jdField_a_of_type_ComTencentMobileqqWidgetParticipleParticipleView = ((ParticipleView)paramLayoutInflater.findViewById(2131373299));
    this.jdField_a_of_type_ComTencentMobileqqWidgetParticipleParticipleBottomMenuView = ((ParticipleBottomMenuView)paramLayoutInflater.findViewById(2131372325));
    this.jdField_b_of_type_ComTencentMobileqqWidgetOCRBottomTabView = ((OCRBottomTabView)paramLayoutInflater.findViewById(2131379097));
    this.jdField_a_of_type_ComTencentMobileqqWidgetOCRBottomTabView = ((OCRBottomTabView)paramLayoutInflater.findViewById(2131366366));
    this.jdField_c_of_type_AndroidViewView = paramLayoutInflater.findViewById(2131372053);
    paramLayoutInflater.findViewById(2131372326).setOnClickListener(this);
    paramLayoutInflater.findViewById(2131367183).setOnClickListener(this);
    paramLayoutInflater.findViewById(2131365252).setOnClickListener(this);
    paramLayoutInflater.findViewById(2131363340).setOnClickListener(this);
    a(this.jdField_a_of_type_AndroidWidgetEditText);
    b();
    paramViewGroup = this.jdField_c_of_type_AndroidViewView;
    int i;
    if (OCRPerformUtil.jdField_a_of_type_Boolean) {
      i = 8;
    } else {
      i = 0;
    }
    paramViewGroup.setVisibility(i);
    this.jdField_c_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_b_of_type_ComTencentMobileqqWidgetOCRBottomTabView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetOCRBottomTabView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqOcrViewGestureGestureFrameLayout = ((GestureFrameLayout)paramLayoutInflater.findViewById(2131367416));
    this.jdField_a_of_type_ComTencentMobileqqOcrViewGestureGestureFrameLayout.a().a(new OCRResultFragmentNew.1(this));
    this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)paramLayoutInflater.findViewById(2131365192));
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)paramLayoutInflater.findViewById(2131367415));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramLayoutInflater.findViewById(2131372049));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    if (this.jdField_a_of_type_JavaLangString != null)
    {
      paramViewGroup = getResources().getDrawable(2130851078);
      paramViewGroup = OCRPerformUtil.a(this.jdField_a_of_type_ComTencentImageURLImageView, paramViewGroup);
      this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(URLDrawable.getFileDrawable(this.jdField_a_of_type_JavaLangString, paramViewGroup));
    }
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramLayoutInflater.findViewById(2131372073));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    a(0);
    a(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity);
    boolean bool = "1103".equals(ThemeUtil.getCurrentThemeInfo().getString("themeId"));
    paramViewGroup = paramLayoutInflater.findViewById(2131372070);
    if (bool) {
      i = j;
    } else {
      i = 8;
    }
    paramViewGroup.setVisibility(i);
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.removeObserver(this.jdField_a_of_type_ComTencentMobileqqParticipleParticipleObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.removeObserver(this.jdField_a_of_type_ComTencentMobileqqTeamworkTenDocOCRExportObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.removeObserver(this.jdField_a_of_type_ComTencentMobileqqGalleryPicocrPicOcrObserver);
    Dialog localDialog = this.jdField_a_of_type_AndroidAppDialog;
    if (localDialog != null)
    {
      localDialog.setOnCancelListener(null);
      this.jdField_a_of_type_AndroidAppDialog.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.OCRResultFragmentNew
 * JD-Core Version:    0.7.0.1
 */