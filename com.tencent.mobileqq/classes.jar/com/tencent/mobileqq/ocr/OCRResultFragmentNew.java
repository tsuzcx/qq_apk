package com.tencent.mobileqq.ocr;

import alvr;
import alwn;
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
import anvx;
import appk;
import avap;
import avat;
import avau;
import ayrt;
import ayru;
import aysk;
import aysl;
import aysm;
import aysn;
import ayso;
import aysp;
import aysq;
import aysr;
import ayss;
import ayst;
import ayvn;
import bdla;
import becr;
import becu;
import becw;
import behe;
import behf;
import behg;
import bkzi;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.TeamWorkDocEditBrowserActivity;
import com.tencent.mobileqq.activity.selectable.TextPreviewMenu.ProgressView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.ocr.view.gesture.GestureFrameLayout;
import com.tencent.mobileqq.ocr.view.gesture.GestureProxy;
import com.tencent.mobileqq.teamwork.fragment.TeamWorkDocsListFragment;
import com.tencent.mobileqq.text.QQText;
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
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

public class OCRResultFragmentNew
  extends PublicBaseFragment
  implements Handler.Callback, View.OnClickListener
{
  public static final String[] a;
  private int jdField_a_of_type_Int = -1;
  private Dialog jdField_a_of_type_AndroidAppDialog;
  public View a;
  ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  EditText jdField_a_of_type_AndroidWidgetEditText;
  FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  private avau jdField_a_of_type_Avau = new aysl(this);
  private ayvn jdField_a_of_type_Ayvn;
  private becw jdField_a_of_type_Becw = new aysr(this, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
  private behg jdField_a_of_type_Behg = new aysq(this);
  public bkzi a;
  URLImageView jdField_a_of_type_ComTencentImageURLImageView;
  private TextPreviewMenu.ProgressView jdField_a_of_type_ComTencentMobileqqActivitySelectableTextPreviewMenu$ProgressView;
  private BaseActivity jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
  GestureFrameLayout jdField_a_of_type_ComTencentMobileqqOcrViewGestureGestureFrameLayout;
  public OCRBottomTabView a;
  ParticipleBottomMenuView jdField_a_of_type_ComTencentMobileqqWidgetParticipleBottomMenuView;
  public ParticipleView a;
  private String jdField_a_of_type_JavaLangString;
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int = -1;
  View jdField_b_of_type_AndroidViewView;
  ViewGroup jdField_b_of_type_AndroidViewViewGroup;
  public OCRBottomTabView b;
  private boolean jdField_b_of_type_Boolean;
  View c;
  public ViewGroup c;
  
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
    alvr localalvr = alvr.a();
    if ((localalvr.c()) && (localalvr.a())) {
      localalvr.d();
    }
  }
  
  private void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    if (paramInt == 0)
    {
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      this.jdField_a_of_type_AndroidViewView.setBackgroundDrawable(new ColorDrawable(getResources().getColor(2131166454)));
      this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetEditText.setVisibility(0);
      this.jdField_b_of_type_AndroidViewViewGroup.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetEditText.setText(a(ayrt.jdField_b_of_type_JavaLangCharSequence, true));
      this.jdField_a_of_type_ComTencentMobileqqWidgetParticipleBottomMenuView.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqWidgetParticipleView.setVisibility(8);
      this.jdField_b_of_type_ComTencentMobileqqWidgetOCRBottomTabView.setTabImage(getResources().getDrawable(2130841485));
      this.jdField_b_of_type_ComTencentMobileqqWidgetOCRBottomTabView.setTabText(getResources().getString(2131710041));
      a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
      appk.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_c_of_type_AndroidViewViewGroup, false, 0);
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
      this.jdField_a_of_type_AndroidViewView.setBackgroundDrawable(getResources().getDrawable(2130838368));
      appk.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_c_of_type_AndroidViewViewGroup, false, 0);
    }
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  private void a(EditText paramEditText)
  {
    paramEditText.setLinkTextColor(Color.parseColor("#12B7F5"));
    if (AppSetting.c) {
      paramEditText.setAutoLinkMask(7);
    }
    for (;;)
    {
      paramEditText.addTextChangedListener(new aysm(this));
      if (a()) {
        paramEditText.setCustomSelectionActionModeCallback(new aysn(this, paramEditText));
      }
      this.jdField_a_of_type_AndroidViewView.getViewTreeObserver().addOnGlobalLayoutListener(new ayso(this, paramEditText));
      paramEditText.setOnTouchListener(new aysp(this));
      return;
      paramEditText.setAutoLinkMask(0);
    }
  }
  
  private void a(avat paramavat)
  {
    if (!FileUtil.isFileExists(paramavat.b))
    {
      QLog.d("OCRResultFragmentNew", 1, "requestOcr, file not exist, picPath:" + paramavat.b);
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 1, 2131698693, 0).a();
    }
    do
    {
      return;
      if (this.jdField_a_of_type_Boolean)
      {
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 0, 2131698696, 0).a();
        QLog.d("OCRResultFragmentNew", 1, "requestOcr, in ocr request, " + paramavat.b);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("OCRResultFragmentNew", 2, "requestOcr:" + paramavat.b);
      }
      this.jdField_a_of_type_Boolean = true;
      paramavat = (avap)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.getBusinessHandler(BusinessHandlerFactory.PIC_NEW_OCR_HANDLER);
    } while (paramavat == null);
    paramavat.a(ayrt.jdField_a_of_type_Avat);
  }
  
  private void a(ayru paramayru)
  {
    if ((paramayru == null) || (paramayru.jdField_a_of_type_JavaUtilList.isEmpty())) {
      return;
    }
    this.jdField_a_of_type_Bkzi = bkzi.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    this.jdField_a_of_type_Bkzi.a(2131698699);
    ArrayList localArrayList = new ArrayList(paramayru.jdField_a_of_type_JavaUtilList.size());
    Iterator localIterator = paramayru.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      Pair localPair = paramayru.a((String)localIterator.next());
      if (localPair != null)
      {
        this.jdField_a_of_type_Bkzi.a((CharSequence)localPair.second, ((String)localPair.first).equalsIgnoreCase(paramayru.jdField_a_of_type_JavaLangString));
        localArrayList.add(localPair.first);
      }
    }
    this.jdField_a_of_type_Bkzi.c(2131690697);
    this.jdField_a_of_type_Bkzi.a(new ayst(this, localArrayList, paramayru));
    try
    {
      this.jdField_a_of_type_Bkzi.show();
      return;
    }
    catch (Exception paramayru)
    {
      paramayru.printStackTrace();
    }
  }
  
  private void a(BaseActivity paramBaseActivity)
  {
    if (paramBaseActivity != null) {
      ((InputMethodManager)paramBaseActivity.getSystemService("input_method")).hideSoftInputFromWindow(this.jdField_a_of_type_AndroidWidgetEditText.getWindowToken(), 0);
    }
  }
  
  public static boolean a()
  {
    boolean bool = false;
    String str = DeviceInfoUtil.getDeviceModel();
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
    this.jdField_a_of_type_ComTencentMobileqqWidgetParticipleBottomMenuView.setOnMenuClickListener(new ayss(this));
    this.jdField_a_of_type_ComTencentMobileqqWidgetParticipleBottomMenuView.a(this.jdField_a_of_type_ComTencentMobileqqWidgetParticipleView);
  }
  
  private void b(String paramString)
  {
    if (!NetworkUtil.isNetSupport(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity)) {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, anvx.a(2131707275), 0).b(getResources().getDimensionPixelSize(2131299080));
    }
    while (TextUtils.isEmpty(paramString)) {
      return;
    }
    c();
    ((behf)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.getBusinessHandler(BusinessHandlerFactory.PARTICIPLE_HANDLER)).a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, paramString);
    bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, "dc00898", "", "", "0X800A357", "0X800A357", 2, 0, "", "", "", "");
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
      this.jdField_a_of_type_AndroidAppDialog.setOnCancelListener(new alwn(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity));
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivitySelectableTextPreviewMenu$ProgressView.setProgressText(anvx.a(2131707277));
      this.jdField_a_of_type_AndroidAppDialog.show();
      return;
      this.jdField_a_of_type_AndroidAppDialog.dismiss();
    }
  }
  
  private void c(String paramString)
  {
    if (!NetworkUtil.isNetworkAvailable(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity))
    {
      QLog.d("OCRResultFragmentNew", 1, "requestExport2Doc, network error");
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 1, 2131692125, 0).a();
      return;
    }
    if (!FileUtil.isFileExists(paramString))
    {
      QLog.d("OCRResultFragmentNew", 1, "requestExport2Doc, file not exist, picPath:" + paramString);
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 1, 2131698693, 0).a();
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
    ((becu)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.getBusinessHandler(BusinessHandlerFactory.TEAM_WORK_OCR_EXPORT_HANDLER)).a(this.jdField_a_of_type_JavaLangString);
  }
  
  public CharSequence a()
  {
    if (this.jdField_a_of_type_Int == 0) {
      return ayrt.a(this.jdField_a_of_type_AndroidWidgetEditText);
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
      paramString = becr.b(str, "s_qq_ocr_save");
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
        return ayrt.jdField_a_of_type_JavaLangCharSequence;
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
    paramActivity.overridePendingTransition(2130771979, 2130771977);
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
        ayrt.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, b().toString());
      }
      for (;;)
      {
        ayrt.a("0X8009C84", 0);
        break;
        ayrt.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, localCharSequence.toString());
      }
      localCharSequence = a();
      if (TextUtils.isEmpty(localCharSequence)) {
        TranslateFragment.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, String.valueOf(b()));
      }
      for (;;)
      {
        ayrt.a("0X800AAF2", 0);
        break;
        TranslateFragment.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, String.valueOf(localCharSequence));
      }
      localCharSequence = a();
      if (TextUtils.isEmpty(localCharSequence)) {
        behe.a(b().toString(), "OCRResultFragmentNew");
      }
      for (;;)
      {
        ayrt.a("0X800AAF1", 0);
        break;
        behe.a(localCharSequence.toString(), "OCRResultFragmentNew");
      }
      localCharSequence = a();
      if (TextUtils.isEmpty(localCharSequence)) {
        b(String.valueOf(b()));
      }
      for (;;)
      {
        ayrt.a("0X800A357", 2);
        break;
        b(String.valueOf(localCharSequence));
      }
      ayrt.a("0X800A161", 0);
      c(this.jdField_a_of_type_JavaLangString);
      continue;
      a(ayrt.jdField_b_of_type_Ayru);
      continue;
      onBackEvent();
      continue;
      if ((this.jdField_a_of_type_AndroidWidgetFrameLayout != null) && (this.jdField_a_of_type_AndroidWidgetFrameLayout.getVisibility() == 0))
      {
        this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(8);
        ayrt.a("0X800AC96", 0);
        continue;
        if ((this.jdField_a_of_type_JavaLangString != null) && (this.jdField_a_of_type_AndroidWidgetFrameLayout != null))
        {
          a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
          this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(0);
        }
        ayrt.a("0X800AC95", 0);
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.jdField_a_of_type_JavaLangString = getActivity().getIntent().getStringExtra("param_ocr_path");
    this.jdField_a_of_type_MqqOsMqqHandler = new MqqHandler(Looper.getMainLooper(), this);
    this.jdField_a_of_type_Ayvn = new ayvn(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.addObserver(this.jdField_a_of_type_Behg);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.addObserver(this.jdField_a_of_type_Becw);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.addObserver(this.jdField_a_of_type_Avau);
    ayrt.a("0X800AD1A", 0);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    int j = 0;
    paramLayoutInflater = paramLayoutInflater.inflate(2131561314, paramViewGroup, false);
    this.jdField_a_of_type_AndroidViewView = paramLayoutInflater.findViewById(2131376947);
    this.jdField_b_of_type_AndroidViewView = paramLayoutInflater.findViewById(2131379104);
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)paramLayoutInflater.findViewById(2131372191));
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)paramLayoutInflater.findViewById(2131372187));
    this.jdField_b_of_type_AndroidViewViewGroup = ((ViewGroup)paramLayoutInflater.findViewById(2131363751));
    this.jdField_c_of_type_AndroidViewViewGroup = ((ViewGroup)paramLayoutInflater.findViewById(2131363755));
    this.jdField_a_of_type_ComTencentMobileqqWidgetParticipleView = ((ParticipleView)paramLayoutInflater.findViewById(2131373414));
    this.jdField_a_of_type_ComTencentMobileqqWidgetParticipleBottomMenuView = ((ParticipleBottomMenuView)paramLayoutInflater.findViewById(2131372438));
    this.jdField_b_of_type_ComTencentMobileqqWidgetOCRBottomTabView = ((OCRBottomTabView)paramLayoutInflater.findViewById(2131379339));
    this.jdField_a_of_type_ComTencentMobileqqWidgetOCRBottomTabView = ((OCRBottomTabView)paramLayoutInflater.findViewById(2131366309));
    this.jdField_c_of_type_AndroidViewView = paramLayoutInflater.findViewById(2131372169);
    paramLayoutInflater.findViewById(2131372439).setOnClickListener(this);
    paramLayoutInflater.findViewById(2131367216).setOnClickListener(this);
    paramLayoutInflater.findViewById(2131365248).setOnClickListener(this);
    paramLayoutInflater.findViewById(2131363329).setOnClickListener(this);
    a(this.jdField_a_of_type_AndroidWidgetEditText);
    b();
    paramViewGroup = this.jdField_c_of_type_AndroidViewView;
    if (ayrt.jdField_a_of_type_Boolean)
    {
      i = 8;
      paramViewGroup.setVisibility(i);
      this.jdField_c_of_type_AndroidViewView.setOnClickListener(this);
      this.jdField_b_of_type_ComTencentMobileqqWidgetOCRBottomTabView.setOnClickListener(this);
      this.jdField_a_of_type_ComTencentMobileqqWidgetOCRBottomTabView.setOnClickListener(this);
      this.jdField_a_of_type_ComTencentMobileqqOcrViewGestureGestureFrameLayout = ((GestureFrameLayout)paramLayoutInflater.findViewById(2131367475));
      this.jdField_a_of_type_ComTencentMobileqqOcrViewGestureGestureFrameLayout.a().a(new aysk(this));
      this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)paramLayoutInflater.findViewById(2131365179));
      this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)paramLayoutInflater.findViewById(2131367474));
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramLayoutInflater.findViewById(2131372165));
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
      if (this.jdField_a_of_type_JavaLangString != null)
      {
        paramViewGroup = getResources().getDrawable(2130850736);
        paramViewGroup = ayrt.a(this.jdField_a_of_type_ComTencentImageURLImageView, paramViewGroup);
        this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(URLDrawable.getFileDrawable(this.jdField_a_of_type_JavaLangString, paramViewGroup));
      }
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramLayoutInflater.findViewById(2131372189));
      this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
      a(0);
      a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
      boolean bool = "1103".equals(ThemeUtil.getCurrentThemeInfo().getString("themeId"));
      paramViewGroup = paramLayoutInflater.findViewById(2131372186);
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
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.removeObserver(this.jdField_a_of_type_Behg);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.removeObserver(this.jdField_a_of_type_Becw);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.removeObserver(this.jdField_a_of_type_Avau);
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