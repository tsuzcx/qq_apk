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
import android.support.v4.app.FragmentActivity;
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
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.TeamWorkDocEditBrowserActivity;
import com.tencent.mobileqq.activity.selectable.AIOSelectableDelegateImpl;
import com.tencent.mobileqq.activity.selectable.TextPreviewMenu.CancelDialogListener;
import com.tencent.mobileqq.activity.selectable.TextPreviewMenu.ProgressView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ar.utils.UniformUtils;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.gallery.picocr.PicOcrHandler;
import com.tencent.mobileqq.gallery.picocr.PicOcrManager.OCRReqContext;
import com.tencent.mobileqq.gallery.picocr.PicOcrObserver;
import com.tencent.mobileqq.ocr.view.TDProgressDialog;
import com.tencent.mobileqq.ocr.view.gesture.GestureFrameLayout;
import com.tencent.mobileqq.ocr.view.gesture.GestureProxy;
import com.tencent.mobileqq.qqparticiple.IParticipleAction;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.teamwork.TeamWorkUtils;
import com.tencent.mobileqq.teamwork.TenDocOCRExportHandler;
import com.tencent.mobileqq.teamwork.TenDocOCRExportObserver;
import com.tencent.mobileqq.teamwork.fragment.TeamWorkDocsListFragment;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.textpreview.MenuUtil;
import com.tencent.mobileqq.textpreview.ParticipleObserver;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.OCRBottomTabView;
import com.tencent.mobileqq.widget.ParticipleBottomMenuView;
import com.tencent.mobileqq.widget.ParticipleView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.widget.ActionSheet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

public class OCRResultFragmentNew
  extends PublicBaseFragment
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
  private TextPreviewMenu.ProgressView jdField_a_of_type_ComTencentMobileqqActivitySelectableTextPreviewMenu$ProgressView;
  private BaseActivity jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
  private PicOcrObserver jdField_a_of_type_ComTencentMobileqqGalleryPicocrPicOcrObserver = new OCRResultFragmentNew.10(this);
  private TDProgressDialog jdField_a_of_type_ComTencentMobileqqOcrViewTDProgressDialog;
  GestureFrameLayout jdField_a_of_type_ComTencentMobileqqOcrViewGestureGestureFrameLayout;
  private TenDocOCRExportObserver jdField_a_of_type_ComTencentMobileqqTeamworkTenDocOCRExportObserver = new OCRResultFragmentNew.7(this, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
  private ParticipleObserver jdField_a_of_type_ComTencentMobileqqTextpreviewParticipleObserver = new OCRResultFragmentNew.6(this);
  OCRBottomTabView jdField_a_of_type_ComTencentMobileqqWidgetOCRBottomTabView;
  ParticipleBottomMenuView jdField_a_of_type_ComTencentMobileqqWidgetParticipleBottomMenuView;
  ParticipleView jdField_a_of_type_ComTencentMobileqqWidgetParticipleView;
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
  
  private void a()
  {
    AIOSelectableDelegateImpl localAIOSelectableDelegateImpl = AIOSelectableDelegateImpl.a();
    if ((localAIOSelectableDelegateImpl.c()) && (localAIOSelectableDelegateImpl.a())) {
      localAIOSelectableDelegateImpl.d();
    }
  }
  
  private void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    if (paramInt == 0)
    {
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      this.jdField_a_of_type_AndroidViewView.setBackgroundDrawable(new ColorDrawable(getResources().getColor(2131166457)));
      this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetEditText.setVisibility(0);
      this.jdField_b_of_type_AndroidViewViewGroup.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetEditText.setText(a(OCRPerformUtil.jdField_b_of_type_JavaLangCharSequence, true));
      this.jdField_a_of_type_ComTencentMobileqqWidgetParticipleBottomMenuView.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqWidgetParticipleView.setVisibility(8);
      this.jdField_b_of_type_ComTencentMobileqqWidgetOCRBottomTabView.setTabImage(getResources().getDrawable(2130841628));
      this.jdField_b_of_type_ComTencentMobileqqWidgetOCRBottomTabView.setTabText(getResources().getString(2131710557));
      a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
      UniformUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_c_of_type_AndroidViewViewGroup, false, 0);
    }
    if (paramInt == 2)
    {
      a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
      a();
      this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetEditText.setVisibility(8);
      this.jdField_b_of_type_AndroidViewViewGroup.setVisibility(8);
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqWidgetParticipleView.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqWidgetParticipleBottomMenuView.b();
      this.jdField_a_of_type_AndroidViewView.setBackgroundDrawable(getResources().getDrawable(2130838437));
      UniformUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_c_of_type_AndroidViewViewGroup, false, 0);
    }
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  private void a(EditText paramEditText)
  {
    paramEditText.setLinkTextColor(Color.parseColor("#12B7F5"));
    if (AppSetting.d) {
      paramEditText.setAutoLinkMask(7);
    }
    for (;;)
    {
      paramEditText.addTextChangedListener(new OCRResultFragmentNew.2(this));
      if (a()) {
        paramEditText.setCustomSelectionActionModeCallback(new OCRResultFragmentNew.3(this, paramEditText));
      }
      this.jdField_a_of_type_AndroidViewView.getViewTreeObserver().addOnGlobalLayoutListener(new OCRResultFragmentNew.4(this, paramEditText));
      paramEditText.setOnTouchListener(new OCRResultFragmentNew.5(this));
      return;
      paramEditText.setAutoLinkMask(0);
    }
  }
  
  private void a(BaseActivity paramBaseActivity)
  {
    if (paramBaseActivity != null) {
      ((InputMethodManager)paramBaseActivity.getSystemService("input_method")).hideSoftInputFromWindow(this.jdField_a_of_type_AndroidWidgetEditText.getWindowToken(), 0);
    }
  }
  
  private void a(PicOcrManager.OCRReqContext paramOCRReqContext)
  {
    if (!FileUtil.a(paramOCRReqContext.b))
    {
      QLog.d("OCRResultFragmentNew", 1, "requestOcr, file not exist, picPath:" + paramOCRReqContext.b);
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 1, 2131698996, 0).a();
    }
    do
    {
      return;
      if (this.jdField_a_of_type_Boolean)
      {
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 0, 2131698999, 0).a();
        QLog.d("OCRResultFragmentNew", 1, "requestOcr, in ocr request, " + paramOCRReqContext.b);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("OCRResultFragmentNew", 2, "requestOcr:" + paramOCRReqContext.b);
      }
      this.jdField_a_of_type_Boolean = true;
      paramOCRReqContext = (PicOcrHandler)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.getBusinessHandler(BusinessHandlerFactory.PIC_NEW_OCR_HANDLER);
    } while (paramOCRReqContext == null);
    paramOCRReqContext.a(OCRPerformUtil.jdField_a_of_type_ComTencentMobileqqGalleryPicocrPicOcrManager$OCRReqContext);
  }
  
  private void a(OCRPerformUtil.OCRLanHolder paramOCRLanHolder)
  {
    if ((paramOCRLanHolder == null) || (paramOCRLanHolder.jdField_a_of_type_JavaUtilList.isEmpty())) {
      return;
    }
    this.jdField_a_of_type_ComTencentWidgetActionSheet = ActionSheet.create(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    this.jdField_a_of_type_ComTencentWidgetActionSheet.setMainTitle(2131699002);
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
    this.jdField_a_of_type_ComTencentWidgetActionSheet.addCancelButton(2131690800);
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
  
  public static boolean a()
  {
    boolean bool = false;
    String str = DeviceInfoUtil.d();
    int i;
    if (!TextUtils.isEmpty(str))
    {
      String[] arrayOfString = jdField_a_of_type_ArrayOfJavaLangString;
      int j = arrayOfString.length;
      i = 0;
      if (i < j) {
        if (!str.equals(arrayOfString[i])) {}
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("OCRResultFragmentNew", 2, "isSupportAddContextMenu mode:" + str + ",isSupport: " + bool);
      }
      return bool;
      i += 1;
      break;
      bool = true;
    }
  }
  
  private void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetParticipleBottomMenuView.setOnMenuClickListener(new OCRResultFragmentNew.8(this));
    this.jdField_a_of_type_ComTencentMobileqqWidgetParticipleBottomMenuView.a(this.jdField_a_of_type_ComTencentMobileqqWidgetParticipleView);
  }
  
  private void b(String paramString)
  {
    if (!NetworkUtil.d(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity)) {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, HardCodeUtil.a(2131707800), 0).b(getResources().getDimensionPixelSize(2131299166));
    }
    while (TextUtils.isEmpty(paramString)) {
      return;
    }
    c();
    ((IParticipleAction)QRoute.api(IParticipleAction.class)).participleTheContent(paramString);
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, "dc00898", "", "", "0X800A357", "0X800A357", 2, 0, "", "", "", "");
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_AndroidAppDialog == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivitySelectableTextPreviewMenu$ProgressView = new TextPreviewMenu.ProgressView(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
      this.jdField_a_of_type_AndroidAppDialog = new ReportDialog(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
      if (this.jdField_a_of_type_AndroidAppDialog.getWindow() != null) {
        this.jdField_a_of_type_AndroidAppDialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
      }
      this.jdField_a_of_type_AndroidAppDialog.setCanceledOnTouchOutside(false);
      this.jdField_a_of_type_AndroidAppDialog.requestWindowFeature(1);
      this.jdField_a_of_type_AndroidAppDialog.setContentView(this.jdField_a_of_type_ComTencentMobileqqActivitySelectableTextPreviewMenu$ProgressView);
      this.jdField_a_of_type_AndroidAppDialog.setOnCancelListener(new TextPreviewMenu.CancelDialogListener(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity));
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivitySelectableTextPreviewMenu$ProgressView.setProgressText(HardCodeUtil.a(2131707802));
      this.jdField_a_of_type_AndroidAppDialog.show();
      return;
      this.jdField_a_of_type_AndroidAppDialog.dismiss();
    }
  }
  
  private void c(String paramString)
  {
    if (!NetworkUtil.g(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity))
    {
      QLog.d("OCRResultFragmentNew", 1, "requestExport2Doc, network error");
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 1, 2131692257, 0).a();
      return;
    }
    if (!FileUtil.a(paramString))
    {
      QLog.d("OCRResultFragmentNew", 1, "requestExport2Doc, file not exist, picPath:" + paramString);
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 1, 2131698996, 0).a();
      return;
    }
    if (this.jdField_b_of_type_Boolean)
    {
      QLog.d("OCRResultFragmentNew", 1, "requestExport2Doc, in export request, " + paramString);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("OCRResultFragmentNew", 2, String.format("requestExport2Doc: %s", new Object[] { this.jdField_a_of_type_JavaLangString }));
    }
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_JavaLangString = paramString;
    ((TenDocOCRExportHandler)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.getBusinessHandler(BusinessHandlerFactory.TEAM_WORK_OCR_EXPORT_HANDLER)).a(this.jdField_a_of_type_JavaLangString);
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
      Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, QQBrowserActivity.class);
      String str = paramString;
      if (TextUtils.isEmpty(paramString)) {
        str = "https://docs.qq.com/desktop/m/index.html?_from=1";
      }
      paramString = TeamWorkUtils.b(str, "s_qq_ocr_save");
      localIntent.putExtra("tdsourcetag", "s_qq_ocr_save");
      localIntent.putExtra("big_brother_source_key", "biz_src_jc_file");
      localIntent.putExtra("fragment_class", TeamWorkDocsListFragment.class.getCanonicalName());
      if (!TeamWorkDocEditBrowserActivity.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, paramString, localIntent.getStringExtra("tdsourcetag"))) {
        startActivity(localIntent.putExtra("url", paramString));
      }
      return;
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
      if (this.jdField_a_of_type_AndroidWidgetEditText == null) {
        return OCRPerformUtil.jdField_a_of_type_JavaLangCharSequence;
      }
      return this.jdField_a_of_type_AndroidWidgetEditText.getText();
    }
    return "";
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    return false;
  }
  
  public void initWindowStyleAndAnimation(Activity paramActivity)
  {
    paramActivity.overridePendingTransition(2130771981, 2130771979);
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
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = ((BaseActivity)paramActivity);
  }
  
  public boolean onBackEvent()
  {
    a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    if (this.jdField_a_of_type_Int == 2) {
      a(0);
    }
    for (;;)
    {
      return true;
      this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.finish();
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      CharSequence localCharSequence = a();
      if (TextUtils.isEmpty(localCharSequence)) {
        OCRPerformUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, b().toString());
      }
      for (;;)
      {
        OCRPerformUtil.a("0X8009C84", 0);
        break;
        OCRPerformUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, localCharSequence.toString());
      }
      localCharSequence = a();
      if (TextUtils.isEmpty(localCharSequence)) {
        TranslateFragment.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, String.valueOf(b()));
      }
      for (;;)
      {
        OCRPerformUtil.a("0X800AAF2", 0);
        break;
        TranslateFragment.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, String.valueOf(localCharSequence));
      }
      localCharSequence = a();
      if (TextUtils.isEmpty(localCharSequence)) {
        MenuUtil.copy(b().toString(), "OCRResultFragmentNew");
      }
      for (;;)
      {
        OCRPerformUtil.a("0X800AAF1", 0);
        break;
        MenuUtil.copy(localCharSequence.toString(), "OCRResultFragmentNew");
      }
      localCharSequence = a();
      if (TextUtils.isEmpty(localCharSequence)) {
        b(String.valueOf(b()));
      }
      for (;;)
      {
        OCRPerformUtil.a("0X800A357", 2);
        break;
        b(String.valueOf(localCharSequence));
      }
      OCRPerformUtil.a("0X800A161", 0);
      c(this.jdField_a_of_type_JavaLangString);
      continue;
      a(OCRPerformUtil.jdField_b_of_type_ComTencentMobileqqOcrOCRPerformUtil$OCRLanHolder);
      continue;
      onBackEvent();
      continue;
      if ((this.jdField_a_of_type_AndroidWidgetFrameLayout != null) && (this.jdField_a_of_type_AndroidWidgetFrameLayout.getVisibility() == 0))
      {
        this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(8);
        OCRPerformUtil.a("0X800AC96", 0);
        continue;
        if ((this.jdField_a_of_type_JavaLangString != null) && (this.jdField_a_of_type_AndroidWidgetFrameLayout != null))
        {
          a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
          this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(0);
        }
        OCRPerformUtil.a("0X800AC95", 0);
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.jdField_a_of_type_JavaLangString = getActivity().getIntent().getStringExtra("param_ocr_path");
    this.jdField_a_of_type_MqqOsMqqHandler = new MqqHandler(Looper.getMainLooper(), this);
    this.jdField_a_of_type_ComTencentMobileqqOcrViewTDProgressDialog = new TDProgressDialog(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.addObserver(this.jdField_a_of_type_ComTencentMobileqqTextpreviewParticipleObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.addObserver(this.jdField_a_of_type_ComTencentMobileqqTeamworkTenDocOCRExportObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.addObserver(this.jdField_a_of_type_ComTencentMobileqqGalleryPicocrPicOcrObserver);
    OCRPerformUtil.a("0X800AD1A", 0);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    int j = 0;
    paramLayoutInflater = paramLayoutInflater.inflate(2131561419, paramViewGroup, false);
    this.jdField_a_of_type_AndroidViewView = paramLayoutInflater.findViewById(2131377356);
    this.jdField_b_of_type_AndroidViewView = paramLayoutInflater.findViewById(2131379538);
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)paramLayoutInflater.findViewById(2131372493));
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)paramLayoutInflater.findViewById(2131372489));
    this.jdField_b_of_type_AndroidViewViewGroup = ((ViewGroup)paramLayoutInflater.findViewById(2131363847));
    this.jdField_c_of_type_AndroidViewViewGroup = ((ViewGroup)paramLayoutInflater.findViewById(2131363851));
    this.jdField_a_of_type_ComTencentMobileqqWidgetParticipleView = ((ParticipleView)paramLayoutInflater.findViewById(2131373727));
    this.jdField_a_of_type_ComTencentMobileqqWidgetParticipleBottomMenuView = ((ParticipleBottomMenuView)paramLayoutInflater.findViewById(2131372748));
    this.jdField_b_of_type_ComTencentMobileqqWidgetOCRBottomTabView = ((OCRBottomTabView)paramLayoutInflater.findViewById(2131379762));
    this.jdField_a_of_type_ComTencentMobileqqWidgetOCRBottomTabView = ((OCRBottomTabView)paramLayoutInflater.findViewById(2131366483));
    this.jdField_c_of_type_AndroidViewView = paramLayoutInflater.findViewById(2131372471);
    paramLayoutInflater.findViewById(2131372749).setOnClickListener(this);
    paramLayoutInflater.findViewById(2131367401).setOnClickListener(this);
    paramLayoutInflater.findViewById(2131365387).setOnClickListener(this);
    paramLayoutInflater.findViewById(2131363408).setOnClickListener(this);
    a(this.jdField_a_of_type_AndroidWidgetEditText);
    b();
    paramViewGroup = this.jdField_c_of_type_AndroidViewView;
    if (OCRPerformUtil.jdField_a_of_type_Boolean)
    {
      i = 8;
      paramViewGroup.setVisibility(i);
      this.jdField_c_of_type_AndroidViewView.setOnClickListener(this);
      this.jdField_b_of_type_ComTencentMobileqqWidgetOCRBottomTabView.setOnClickListener(this);
      this.jdField_a_of_type_ComTencentMobileqqWidgetOCRBottomTabView.setOnClickListener(this);
      this.jdField_a_of_type_ComTencentMobileqqOcrViewGestureGestureFrameLayout = ((GestureFrameLayout)paramLayoutInflater.findViewById(2131367662));
      this.jdField_a_of_type_ComTencentMobileqqOcrViewGestureGestureFrameLayout.a().a(new OCRResultFragmentNew.1(this));
      this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)paramLayoutInflater.findViewById(2131365317));
      this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)paramLayoutInflater.findViewById(2131367661));
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramLayoutInflater.findViewById(2131372467));
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
      if (this.jdField_a_of_type_JavaLangString != null)
      {
        paramViewGroup = getResources().getDrawable(2130851162);
        paramViewGroup = OCRPerformUtil.a(this.jdField_a_of_type_ComTencentImageURLImageView, paramViewGroup);
        this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(URLDrawable.getFileDrawable(this.jdField_a_of_type_JavaLangString, paramViewGroup));
      }
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramLayoutInflater.findViewById(2131372491));
      this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
      a(0);
      a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
      boolean bool = "1103".equals(ThemeUtil.getCurrentThemeInfo().getString("themeId"));
      paramViewGroup = paramLayoutInflater.findViewById(2131372488);
      if (!bool) {
        break label471;
      }
    }
    label471:
    for (int i = j;; i = 8)
    {
      paramViewGroup.setVisibility(i);
      V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
      return paramLayoutInflater;
      i = 0;
      break;
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.removeObserver(this.jdField_a_of_type_ComTencentMobileqqTextpreviewParticipleObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.removeObserver(this.jdField_a_of_type_ComTencentMobileqqTeamworkTenDocOCRExportObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.removeObserver(this.jdField_a_of_type_ComTencentMobileqqGalleryPicocrPicOcrObserver);
    if (this.jdField_a_of_type_AndroidAppDialog != null)
    {
      this.jdField_a_of_type_AndroidAppDialog.setOnCancelListener(null);
      this.jdField_a_of_type_AndroidAppDialog.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.OCRResultFragmentNew
 * JD-Core Version:    0.7.0.1
 */