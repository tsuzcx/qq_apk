package com.tencent.mobileqq.ocr;

import aibn;
import aicj;
import ajya;
import allt;
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
import apvd;
import aqmv;
import aqmz;
import aqna;
import auad;
import auaf;
import auav;
import auaw;
import auax;
import auay;
import auaz;
import auba;
import aubb;
import aubc;
import aubd;
import aube;
import audw;
import axqy;
import ayfx;
import ayga;
import aygc;
import aykk;
import ayle;
import aylf;
import aylg;
import bbdh;
import bbfj;
import bcql;
import bfpc;
import bfyd;
import bjal;
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
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
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
  private aqna jdField_a_of_type_Aqna = new auaw(this);
  private audw jdField_a_of_type_Audw;
  private aygc jdField_a_of_type_Aygc = new aubc(this, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
  private aylg jdField_a_of_type_Aylg = new aubb(this);
  public bfpc a;
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
      return new aykk(paramCharSequence, 8, 16);
    }
    return String.valueOf(paramCharSequence);
  }
  
  private void a()
  {
    aibn localaibn = aibn.a();
    if ((localaibn.c()) && (localaibn.a())) {
      localaibn.d();
    }
  }
  
  private void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    if (paramInt == 0)
    {
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      this.jdField_b_of_type_AndroidViewView.setBackgroundDrawable(new ColorDrawable(getResources().getColor(2131166297)));
      this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetEditText.setVisibility(0);
      this.jdField_b_of_type_AndroidViewViewGroup.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetEditText.setText(a(auad.b(), true));
      this.jdField_a_of_type_ComTencentMobileqqWidgetParticipleBottomMenuView.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqWidgetParticipleView.setVisibility(8);
      this.jdField_b_of_type_ComTencentMobileqqWidgetOCRBottomTabView.setTabImage(getResources().getDrawable(2130841024));
      this.jdField_b_of_type_ComTencentMobileqqWidgetOCRBottomTabView.setTabText(getResources().getString(2131710593));
      a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
      allt.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.c, false, 0);
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
      this.jdField_b_of_type_AndroidViewView.setBackgroundDrawable(getResources().getDrawable(2130838150));
      allt.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.c, false, 0);
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
      paramEditText.addTextChangedListener(new auax(this));
      if (a()) {
        paramEditText.setCustomSelectionActionModeCallback(new auay(this, paramEditText));
      }
      this.jdField_b_of_type_AndroidViewView.getViewTreeObserver().addOnGlobalLayoutListener(new auaz(this, paramEditText));
      paramEditText.setOnTouchListener(new auba(this));
      return;
      paramEditText.setAutoLinkMask(0);
    }
  }
  
  private void a(aqmz paramaqmz)
  {
    if (!apvd.a(paramaqmz.b))
    {
      QLog.d("OCRResultFragmentNew", 1, "requestOcr, file not exist, picPath:" + paramaqmz.b);
      bcql.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 1, 2131699244, 0).a();
    }
    do
    {
      return;
      if (this.jdField_a_of_type_Boolean)
      {
        bcql.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 0, 2131699247, 0).a();
        QLog.d("OCRResultFragmentNew", 1, "requestOcr, in ocr request, " + paramaqmz.b);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("OCRResultFragmentNew", 2, "requestOcr:" + paramaqmz.b);
      }
      this.jdField_a_of_type_Boolean = true;
      paramaqmz = (aqmv)((QQAppInterface)this.jdField_a_of_type_MqqUtilWeakReference.get()).a(170);
    } while (paramaqmz == null);
    paramaqmz.a(auad.jdField_a_of_type_Aqmz);
  }
  
  private void a(auaf paramauaf)
  {
    if ((paramauaf == null) || (paramauaf.jdField_a_of_type_JavaUtilList.isEmpty())) {
      return;
    }
    this.jdField_a_of_type_Bfpc = bfpc.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    this.jdField_a_of_type_Bfpc.a(2131699250);
    ArrayList localArrayList = new ArrayList(paramauaf.jdField_a_of_type_JavaUtilList.size());
    Iterator localIterator = paramauaf.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      Pair localPair = paramauaf.a((String)localIterator.next());
      if (localPair != null)
      {
        this.jdField_a_of_type_Bfpc.a((CharSequence)localPair.second, ((String)localPair.first).equalsIgnoreCase(paramauaf.jdField_a_of_type_JavaLangString));
        localArrayList.add(localPair.first);
      }
    }
    this.jdField_a_of_type_Bfpc.c(2131690596);
    this.jdField_a_of_type_Bfpc.a(new aube(this, localArrayList, paramauaf));
    try
    {
      this.jdField_a_of_type_Bfpc.show();
      return;
    }
    catch (Exception paramauaf)
    {
      paramauaf.printStackTrace();
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
    String str = bbdh.d();
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
    this.jdField_a_of_type_ComTencentMobileqqWidgetParticipleBottomMenuView.setOnMenuClickListener(new aubd(this));
    this.jdField_a_of_type_ComTencentMobileqqWidgetParticipleBottomMenuView.a(this.jdField_a_of_type_ComTencentMobileqqWidgetParticipleView);
  }
  
  private void b(String paramString)
  {
    if (!bbfj.d(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity)) {
      bcql.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, ajya.a(2131707831), 0).b(getResources().getDimensionPixelSize(2131298865));
    }
    while (TextUtils.isEmpty(paramString)) {
      return;
    }
    c();
    ((aylf)((QQAppInterface)this.jdField_a_of_type_MqqUtilWeakReference.get()).a(161)).a((QQAppInterface)this.jdField_a_of_type_MqqUtilWeakReference.get(), paramString);
    axqy.b((QQAppInterface)this.jdField_a_of_type_MqqUtilWeakReference.get(), "dc00898", "", "", "0X800A357", "0X800A357", 2, 0, "", "", "", "");
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
      this.jdField_a_of_type_AndroidAppDialog.setOnCancelListener(new aicj(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity));
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivitySelectableTextPreviewMenu$ProgressView.setProgressText(ajya.a(2131707833));
      this.jdField_a_of_type_AndroidAppDialog.show();
      return;
      this.jdField_a_of_type_AndroidAppDialog.dismiss();
    }
  }
  
  private void c(String paramString)
  {
    axqy.b(null, "dc00898", "", "", "0X800A161", "0X800A161", 0, 0, "", "0", "0", "");
    if (!bbfj.g(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity))
    {
      QLog.d("OCRResultFragmentNew", 1, "requestExport2Doc, network error");
      bcql.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 1, 2131692321, 0).a();
      return;
    }
    if (!apvd.a(paramString))
    {
      QLog.d("OCRResultFragmentNew", 1, "requestExport2Doc, file not exist, picPath:" + paramString);
      bcql.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 1, 2131699244, 0).a();
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
    ((ayga)((QQAppInterface)this.jdField_a_of_type_MqqUtilWeakReference.get()).a(157)).a(this.jdField_a_of_type_JavaLangString);
  }
  
  public CharSequence a()
  {
    if (this.jdField_a_of_type_Int == 0) {
      return auad.a(this.jdField_a_of_type_AndroidWidgetEditText);
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
      paramString = ayfx.b(str, "s_qq_ocr_save");
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
        return auad.a();
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
    do
    {
      do
      {
        return;
        paramView = a();
        if (TextUtils.isEmpty(paramView)) {
          auad.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, b().toString());
        }
        for (;;)
        {
          auad.a("0X8009C84", 0);
          return;
          auad.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, paramView.toString());
        }
        paramView = a();
        if (TextUtils.isEmpty(paramView)) {
          TranslateFragment.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, String.valueOf(b()));
        }
        for (;;)
        {
          auad.a("0X800AAF2", 0);
          return;
          TranslateFragment.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, String.valueOf(paramView));
        }
        paramView = a();
        if (TextUtils.isEmpty(paramView)) {
          ayle.a(b().toString(), "OCRResultFragmentNew");
        }
        for (;;)
        {
          auad.a("0X800AAF1", 0);
          return;
          ayle.a(paramView.toString(), "OCRResultFragmentNew");
        }
        paramView = a();
        if (TextUtils.isEmpty(paramView)) {
          b(String.valueOf(b()));
        }
        for (;;)
        {
          auad.a("0X800A357", 2);
          return;
          b(String.valueOf(paramView));
        }
        auad.a("0X800A161", 0);
        c(this.jdField_a_of_type_JavaLangString);
        return;
        a(auad.jdField_a_of_type_Auaf);
        return;
        onBackEvent();
        return;
      } while ((this.jdField_a_of_type_AndroidWidgetFrameLayout == null) || (this.jdField_a_of_type_AndroidWidgetFrameLayout.getVisibility() != 0));
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(8);
      auad.a("0X800AC96", 0);
      return;
      auad.a("0X800AC95", 0);
    } while ((this.jdField_a_of_type_JavaLangString == null) || (this.jdField_a_of_type_AndroidWidgetFrameLayout == null));
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(0);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (ImmersiveUtils.isSupporImmersive() == 1) {
      bfyd.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    }
    this.jdField_a_of_type_JavaLangString = getActivity().getIntent().getStringExtra("param_ocr_path");
    this.jdField_a_of_type_MqqOsMqqHandler = new MqqHandler(Looper.getMainLooper(), this);
    this.jdField_a_of_type_Audw = new audw(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference((QQAppInterface)bjal.a());
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.addObserver(this.jdField_a_of_type_Aylg);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.addObserver(this.jdField_a_of_type_Aygc);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.addObserver(this.jdField_a_of_type_Aqna);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131560927, paramViewGroup, false);
    this.jdField_a_of_type_AndroidViewView = paramLayoutInflater.findViewById(2131377444);
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)paramLayoutInflater.findViewById(2131371023));
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)paramLayoutInflater.findViewById(2131371019));
    this.jdField_b_of_type_AndroidViewViewGroup = ((ViewGroup)paramLayoutInflater.findViewById(2131363391));
    this.c = ((ViewGroup)paramLayoutInflater.findViewById(2131363395));
    this.jdField_a_of_type_ComTencentMobileqqWidgetParticipleView = ((ParticipleView)paramLayoutInflater.findViewById(2131372171));
    this.jdField_a_of_type_ComTencentMobileqqWidgetParticipleBottomMenuView = ((ParticipleBottomMenuView)paramLayoutInflater.findViewById(2131371262));
    this.jdField_b_of_type_ComTencentMobileqqWidgetOCRBottomTabView = ((OCRBottomTabView)paramLayoutInflater.findViewById(2131377660));
    this.jdField_a_of_type_ComTencentMobileqqWidgetOCRBottomTabView = ((OCRBottomTabView)paramLayoutInflater.findViewById(2131365787));
    this.jdField_b_of_type_AndroidViewView = paramLayoutInflater.findViewById(2131375493);
    paramLayoutInflater.findViewById(2131366634).setOnClickListener(this);
    paramLayoutInflater.findViewById(2131364774).setOnClickListener(this);
    paramLayoutInflater.findViewById(2131362988).setOnClickListener(this);
    paramLayoutInflater.findViewById(2131371002).setOnClickListener(this);
    paramLayoutInflater.findViewById(2131371263).setOnClickListener(this);
    a(this.jdField_a_of_type_AndroidWidgetEditText);
    b();
    this.jdField_b_of_type_ComTencentMobileqqWidgetOCRBottomTabView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetOCRBottomTabView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqOcrViewGestureGestureFrameLayout = ((GestureFrameLayout)paramLayoutInflater.findViewById(2131366882));
    this.jdField_a_of_type_ComTencentMobileqqOcrViewGestureGestureFrameLayout.a().a(new auav(this));
    this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)paramLayoutInflater.findViewById(2131364712));
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)paramLayoutInflater.findViewById(2131366881));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramLayoutInflater.findViewById(2131370998));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    if (this.jdField_a_of_type_JavaLangString != null)
    {
      paramViewGroup = getResources().getDrawable(2130849558);
      paramViewGroup = auad.a(this.jdField_a_of_type_ComTencentImageURLImageView, paramViewGroup);
      this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(URLDrawable.getFileDrawable(this.jdField_a_of_type_JavaLangString, paramViewGroup));
    }
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramLayoutInflater.findViewById(2131371021));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    a(0);
    a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    boolean bool = "1103".equals(ThemeUtil.getCurrentThemeInfo().getString("themeId"));
    paramViewGroup = paramLayoutInflater.findViewById(2131371018);
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
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.removeObserver(this.jdField_a_of_type_Aylg);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.removeObserver(this.jdField_a_of_type_Aygc);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.removeObserver(this.jdField_a_of_type_Aqna);
    if (this.jdField_a_of_type_AndroidAppDialog != null)
    {
      this.jdField_a_of_type_AndroidAppDialog.setOnCancelListener(null);
      this.jdField_a_of_type_AndroidAppDialog.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.OCRResultFragmentNew
 * JD-Core Version:    0.7.0.1
 */