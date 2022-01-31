package com.tencent.mobileqq.ocr;

import ajsx;
import ajtt;
import alpo;
import ancj;
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
import arof;
import asfj;
import asfn;
import asfo;
import avrh;
import avrj;
import avrz;
import avsa;
import avsb;
import avsc;
import avsd;
import avse;
import avsf;
import avsg;
import avsh;
import avsi;
import avva;
import azmj;
import badt;
import badw;
import bady;
import baig;
import baja;
import bajb;
import bajc;
import bdcb;
import bdee;
import bhpy;
import bllv;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.TeamWorkDocEditBrowserActivity;
import com.tencent.mobileqq.activity.selectable.TextPreviewMenu.ProgressView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.ocr.view.gesture.GestureFrameLayout;
import com.tencent.mobileqq.ocr.view.gesture.GestureProxy;
import com.tencent.mobileqq.teamwork.fragment.TeamWorkDocsListFragment;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.widget.OCRBottomTabView;
import com.tencent.mobileqq.widget.ParticipleBottomMenuView;
import com.tencent.mobileqq.widget.ParticipleView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;
import mqq.util.WeakReference;

public class OCRResultFragmentNew
  extends PublicBaseFragment
  implements Handler.Callback, View.OnClickListener
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
  private asfo jdField_a_of_type_Asfo = new avsa(this);
  private avva jdField_a_of_type_Avva;
  private bady jdField_a_of_type_Bady = new avsg(this, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
  private bajc jdField_a_of_type_Bajc = new avsf(this);
  public bhpy a;
  URLImageView jdField_a_of_type_ComTencentImageURLImageView;
  private TextPreviewMenu.ProgressView jdField_a_of_type_ComTencentMobileqqActivitySelectableTextPreviewMenu$ProgressView;
  private BaseActivity jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
  GestureFrameLayout jdField_a_of_type_ComTencentMobileqqOcrViewGestureGestureFrameLayout;
  public OCRBottomTabView a;
  ParticipleBottomMenuView jdField_a_of_type_ComTencentMobileqqWidgetParticipleBottomMenuView;
  public ParticipleView a;
  private String jdField_a_of_type_JavaLangString;
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler;
  private WeakReference<QQAppInterface> jdField_a_of_type_MqqUtilWeakReference;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int = -1;
  public View b;
  ViewGroup jdField_b_of_type_AndroidViewViewGroup;
  public OCRBottomTabView b;
  private boolean jdField_b_of_type_Boolean;
  public ViewGroup c;
  
  static
  {
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { "M3X", "U20", "ZTE C2016", "Lenovo K900", "HUAWEI MT7-CL00", "HUAWEI G7-TL00", "PE-CL00", "Moto X Pro", "X907", "ASUS_Z00ADB", "HUAWEI P7-L07", "XT1581", "M821", "R7c" };
  }
  
  private CharSequence a(CharSequence paramCharSequence, boolean paramBoolean)
  {
    if (paramBoolean) {
      return new baig(paramCharSequence, 8, 16);
    }
    return String.valueOf(paramCharSequence);
  }
  
  private void a()
  {
    ajsx localajsx = ajsx.a();
    if ((localajsx.c()) && (localajsx.a())) {
      localajsx.d();
    }
  }
  
  private void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    if (paramInt == 0)
    {
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      this.jdField_b_of_type_AndroidViewView.setBackgroundDrawable(new ColorDrawable(getResources().getColor(2131166344)));
      this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetEditText.setVisibility(0);
      this.jdField_b_of_type_AndroidViewViewGroup.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetEditText.setText(a(avrh.b(), true));
      this.jdField_a_of_type_ComTencentMobileqqWidgetParticipleBottomMenuView.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqWidgetParticipleView.setVisibility(8);
      this.jdField_b_of_type_ComTencentMobileqqWidgetOCRBottomTabView.setTabImage(getResources().getDrawable(2130841142));
      this.jdField_b_of_type_ComTencentMobileqqWidgetOCRBottomTabView.setTabText(getResources().getString(2131710965));
      a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
      ancj.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.c, false, 0);
    }
    if (paramInt == 2)
    {
      a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
      a();
      this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetEditText.setVisibility(8);
      this.jdField_b_of_type_AndroidViewViewGroup.setVisibility(8);
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqWidgetParticipleView.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqWidgetParticipleBottomMenuView.b();
      this.jdField_b_of_type_AndroidViewView.setBackgroundDrawable(getResources().getDrawable(2130838206));
      ancj.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.c, false, 0);
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
      paramEditText.addTextChangedListener(new avsb(this));
      if (a()) {
        paramEditText.setCustomSelectionActionModeCallback(new avsc(this, paramEditText));
      }
      this.jdField_b_of_type_AndroidViewView.getViewTreeObserver().addOnGlobalLayoutListener(new avsd(this, paramEditText));
      paramEditText.setOnTouchListener(new avse(this));
      return;
      paramEditText.setAutoLinkMask(0);
    }
  }
  
  private void a(asfn paramasfn)
  {
    if (!arof.a(paramasfn.b))
    {
      QLog.d("OCRResultFragmentNew", 1, "requestOcr, file not exist, picPath:" + paramasfn.b);
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 1, 2131699590, 0).a();
    }
    do
    {
      return;
      if (this.jdField_a_of_type_Boolean)
      {
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 0, 2131699593, 0).a();
        QLog.d("OCRResultFragmentNew", 1, "requestOcr, in ocr request, " + paramasfn.b);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("OCRResultFragmentNew", 2, "requestOcr:" + paramasfn.b);
      }
      this.jdField_a_of_type_Boolean = true;
      paramasfn = (asfj)((QQAppInterface)this.jdField_a_of_type_MqqUtilWeakReference.get()).a(170);
    } while (paramasfn == null);
    paramasfn.a(avrh.jdField_a_of_type_Asfn);
  }
  
  private void a(avrj paramavrj)
  {
    if ((paramavrj == null) || (paramavrj.jdField_a_of_type_JavaUtilList.isEmpty())) {
      return;
    }
    this.jdField_a_of_type_Bhpy = bhpy.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    this.jdField_a_of_type_Bhpy.a(2131699596);
    ArrayList localArrayList = new ArrayList(paramavrj.jdField_a_of_type_JavaUtilList.size());
    Iterator localIterator = paramavrj.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      Pair localPair = paramavrj.a((String)localIterator.next());
      if (localPair != null)
      {
        this.jdField_a_of_type_Bhpy.a((CharSequence)localPair.second, ((String)localPair.first).equalsIgnoreCase(paramavrj.jdField_a_of_type_JavaLangString));
        localArrayList.add(localPair.first);
      }
    }
    this.jdField_a_of_type_Bhpy.c(2131690648);
    this.jdField_a_of_type_Bhpy.a(new avsi(this, localArrayList, paramavrj));
    try
    {
      this.jdField_a_of_type_Bhpy.show();
      return;
    }
    catch (Exception paramavrj)
    {
      paramavrj.printStackTrace();
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
    String str = bdcb.d();
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
    this.jdField_a_of_type_ComTencentMobileqqWidgetParticipleBottomMenuView.setOnMenuClickListener(new avsh(this));
    this.jdField_a_of_type_ComTencentMobileqqWidgetParticipleBottomMenuView.a(this.jdField_a_of_type_ComTencentMobileqqWidgetParticipleView);
  }
  
  private void b(String paramString)
  {
    if (!bdee.d(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity)) {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, alpo.a(2131708203), 0).b(getResources().getDimensionPixelSize(2131298914));
    }
    while (TextUtils.isEmpty(paramString)) {
      return;
    }
    c();
    ((bajb)((QQAppInterface)this.jdField_a_of_type_MqqUtilWeakReference.get()).a(161)).a((QQAppInterface)this.jdField_a_of_type_MqqUtilWeakReference.get(), paramString);
    azmj.b((QQAppInterface)this.jdField_a_of_type_MqqUtilWeakReference.get(), "dc00898", "", "", "0X800A357", "0X800A357", 2, 0, "", "", "", "");
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_AndroidAppDialog == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivitySelectableTextPreviewMenu$ProgressView = new TextPreviewMenu.ProgressView(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
      this.jdField_a_of_type_AndroidAppDialog = new Dialog(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
      if (this.jdField_a_of_type_AndroidAppDialog.getWindow() != null) {
        this.jdField_a_of_type_AndroidAppDialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
      }
      this.jdField_a_of_type_AndroidAppDialog.setCanceledOnTouchOutside(false);
      this.jdField_a_of_type_AndroidAppDialog.requestWindowFeature(1);
      this.jdField_a_of_type_AndroidAppDialog.setContentView(this.jdField_a_of_type_ComTencentMobileqqActivitySelectableTextPreviewMenu$ProgressView);
      this.jdField_a_of_type_AndroidAppDialog.setOnCancelListener(new ajtt(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity));
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivitySelectableTextPreviewMenu$ProgressView.setProgressText(alpo.a(2131708205));
      this.jdField_a_of_type_AndroidAppDialog.show();
      return;
      this.jdField_a_of_type_AndroidAppDialog.dismiss();
    }
  }
  
  private void c(String paramString)
  {
    if (!bdee.g(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity))
    {
      QLog.d("OCRResultFragmentNew", 1, "requestExport2Doc, network error");
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 1, 2131692397, 0).a();
      return;
    }
    if (!arof.a(paramString))
    {
      QLog.d("OCRResultFragmentNew", 1, "requestExport2Doc, file not exist, picPath:" + paramString);
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 1, 2131699590, 0).a();
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
    ((badw)((QQAppInterface)this.jdField_a_of_type_MqqUtilWeakReference.get()).a(157)).a(this.jdField_a_of_type_JavaLangString);
  }
  
  public CharSequence a()
  {
    if (this.jdField_a_of_type_Int == 0) {
      return avrh.a(this.jdField_a_of_type_AndroidWidgetEditText);
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
      paramString = badt.b(str, "s_qq_ocr_save");
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
        return avrh.a();
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
    default: 
    case 2131366752: 
    case 2131378201: 
    case 2131364855: 
    case 2131371575: 
    case 2131365874: 
    case 2131371315: 
    case 2131363024: 
    case 2131371311: 
      do
      {
        return;
        paramView = a();
        if (TextUtils.isEmpty(paramView)) {
          avrh.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, b().toString());
        }
        for (;;)
        {
          avrh.a("0X8009C84", 0);
          return;
          avrh.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, paramView.toString());
        }
        paramView = a();
        if (TextUtils.isEmpty(paramView)) {
          TranslateFragment.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, String.valueOf(b()));
        }
        for (;;)
        {
          avrh.a("0X800AAF2", 0);
          return;
          TranslateFragment.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, String.valueOf(paramView));
        }
        paramView = a();
        if (TextUtils.isEmpty(paramView)) {
          baja.a(b().toString(), "OCRResultFragmentNew");
        }
        for (;;)
        {
          avrh.a("0X800AAF1", 0);
          return;
          baja.a(paramView.toString(), "OCRResultFragmentNew");
        }
        paramView = a();
        if (TextUtils.isEmpty(paramView)) {
          b(String.valueOf(b()));
        }
        for (;;)
        {
          avrh.a("0X800A357", 2);
          return;
          b(String.valueOf(paramView));
        }
        avrh.a("0X800A161", 0);
        c(this.jdField_a_of_type_JavaLangString);
        return;
        a(avrh.jdField_a_of_type_Avrj);
        return;
        onBackEvent();
        return;
      } while ((this.jdField_a_of_type_AndroidWidgetFrameLayout == null) || (this.jdField_a_of_type_AndroidWidgetFrameLayout.getVisibility() != 0));
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(8);
      avrh.a("0X800AC96", 0);
      return;
    }
    if ((this.jdField_a_of_type_JavaLangString != null) && (this.jdField_a_of_type_AndroidWidgetFrameLayout != null))
    {
      a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(0);
    }
    avrh.a("0X800AC95", 0);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.jdField_a_of_type_JavaLangString = getActivity().getIntent().getStringExtra("param_ocr_path");
    this.jdField_a_of_type_MqqOsMqqHandler = new MqqHandler(Looper.getMainLooper(), this);
    this.jdField_a_of_type_Avva = new avva(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference((QQAppInterface)bllv.a());
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.addObserver(this.jdField_a_of_type_Bajc);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.addObserver(this.jdField_a_of_type_Bady);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.addObserver(this.jdField_a_of_type_Asfo);
    avrh.a("0X800AD1A", 0);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131561110, paramViewGroup, false);
    this.jdField_a_of_type_AndroidViewView = paramLayoutInflater.findViewById(2131377981);
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)paramLayoutInflater.findViewById(2131371336));
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)paramLayoutInflater.findViewById(2131371332));
    this.jdField_b_of_type_AndroidViewViewGroup = ((ViewGroup)paramLayoutInflater.findViewById(2131363430));
    this.c = ((ViewGroup)paramLayoutInflater.findViewById(2131363434));
    this.jdField_a_of_type_ComTencentMobileqqWidgetParticipleView = ((ParticipleView)paramLayoutInflater.findViewById(2131372495));
    this.jdField_a_of_type_ComTencentMobileqqWidgetParticipleBottomMenuView = ((ParticipleBottomMenuView)paramLayoutInflater.findViewById(2131371574));
    this.jdField_b_of_type_ComTencentMobileqqWidgetOCRBottomTabView = ((OCRBottomTabView)paramLayoutInflater.findViewById(2131378201));
    this.jdField_a_of_type_ComTencentMobileqqWidgetOCRBottomTabView = ((OCRBottomTabView)paramLayoutInflater.findViewById(2131365874));
    this.jdField_b_of_type_AndroidViewView = paramLayoutInflater.findViewById(2131375981);
    paramLayoutInflater.findViewById(2131366752).setOnClickListener(this);
    paramLayoutInflater.findViewById(2131364855).setOnClickListener(this);
    paramLayoutInflater.findViewById(2131363024).setOnClickListener(this);
    paramLayoutInflater.findViewById(2131371315).setOnClickListener(this);
    paramLayoutInflater.findViewById(2131371575).setOnClickListener(this);
    a(this.jdField_a_of_type_AndroidWidgetEditText);
    b();
    this.jdField_b_of_type_ComTencentMobileqqWidgetOCRBottomTabView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetOCRBottomTabView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqOcrViewGestureGestureFrameLayout = ((GestureFrameLayout)paramLayoutInflater.findViewById(2131366995));
    this.jdField_a_of_type_ComTencentMobileqqOcrViewGestureGestureFrameLayout.a().a(new avrz(this));
    this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)paramLayoutInflater.findViewById(2131364791));
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)paramLayoutInflater.findViewById(2131366994));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramLayoutInflater.findViewById(2131371311));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    if (this.jdField_a_of_type_JavaLangString != null)
    {
      paramViewGroup = getResources().getDrawable(2130849999);
      paramViewGroup = avrh.a(this.jdField_a_of_type_ComTencentImageURLImageView, paramViewGroup);
      this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(URLDrawable.getFileDrawable(this.jdField_a_of_type_JavaLangString, paramViewGroup));
    }
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramLayoutInflater.findViewById(2131371334));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    a(0);
    a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    boolean bool = "1103".equals(ThemeUtil.getCurrentThemeInfo().getString("themeId"));
    paramViewGroup = paramLayoutInflater.findViewById(2131371331);
    if (bool) {}
    for (int i = 0;; i = 8)
    {
      paramViewGroup.setVisibility(i);
      return paramLayoutInflater;
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.removeObserver(this.jdField_a_of_type_Bajc);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.removeObserver(this.jdField_a_of_type_Bady);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.removeObserver(this.jdField_a_of_type_Asfo);
    if (this.jdField_a_of_type_AndroidAppDialog != null)
    {
      this.jdField_a_of_type_AndroidAppDialog.setOnCancelListener(null);
      this.jdField_a_of_type_AndroidAppDialog.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.OCRResultFragmentNew
 * JD-Core Version:    0.7.0.1
 */