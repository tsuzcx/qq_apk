package com.tencent.mobileqq.conditionsearch;

import Override;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import anjh;
import anjl;
import anjn;
import anni;
import anot;
import aqhp;
import aqhq;
import aqhr;
import aqhs;
import aqht;
import aqhu;
import aqhv;
import aqhw;
import aqiv;
import aqiw;
import bcst;
import bgnt;
import biau;
import bkho;
import bkpg;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.JobSelectionActivity;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.conditionsearch.data.BaseAddress;
import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView;
import com.tencent.mobileqq.widget.DispatchActionMoveScrollView;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.MultiImageTextView;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import mqq.os.MqqHandler;

public class ConditionSearchFriendActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener
{
  private static final String jdField_c_of_type_JavaLangString = anni.a(2131701173);
  public volatile int a;
  DialogInterface.OnDismissListener jdField_a_of_type_AndroidContentDialogInterface$OnDismissListener = new aqht(this);
  Handler jdField_a_of_type_AndroidOsHandler = new aqhu(this);
  View jdField_a_of_type_AndroidViewView;
  Button jdField_a_of_type_AndroidWidgetButton;
  EditText jdField_a_of_type_AndroidWidgetEditText;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  public anjh a;
  anjl jdField_a_of_type_Anjl = new aqhw(this);
  anjn jdField_a_of_type_Anjn = new aqhv(this);
  anot jdField_a_of_type_Anot = new aqhp(this);
  aqiv jdField_a_of_type_Aqiv = new aqhs(this);
  aqiw jdField_a_of_type_Aqiw = new aqhr(this);
  biau jdField_a_of_type_Biau;
  public bkho a;
  BaseAddress jdField_a_of_type_ComTencentMobileqqConditionsearchDataBaseAddress;
  public IphonePickerView a;
  public FormSimpleItem a;
  public String a;
  public boolean a;
  public int[] a;
  public BaseAddress[] a;
  public Object[] a;
  public String[] a;
  public volatile int b;
  View jdField_b_of_type_AndroidViewView;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  public FormSimpleItem b;
  public String b;
  public boolean b;
  public volatile int c;
  View jdField_c_of_type_AndroidViewView;
  TextView jdField_c_of_type_AndroidWidgetTextView;
  public FormSimpleItem c;
  public boolean c;
  public volatile int d;
  View jdField_d_of_type_AndroidViewView;
  public TextView d;
  FormSimpleItem jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  public boolean d;
  public volatile int e;
  public View e;
  public FormSimpleItem e;
  public volatile int f;
  public volatile int g;
  public int h;
  public int i;
  public int j = 0;
  private final int k = 20;
  private int l;
  
  public ConditionSearchFriendActivity()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = true;
    this.jdField_d_of_type_Boolean = true;
  }
  
  private int a(int paramInt)
  {
    if (paramInt == 0) {
      return paramInt;
    }
    if (paramInt > 0) {
      return paramInt + 17;
    }
    return 0;
  }
  
  private int a(View paramView)
  {
    int[] arrayOfInt = new int[2];
    paramView.getLocationOnScreen(arrayOfInt);
    return arrayOfInt[1];
  }
  
  private int a(ArrayList<? extends BaseAddress> paramArrayList, String paramString)
  {
    int n = paramArrayList.size();
    int m = 0;
    while (m < n)
    {
      if (((BaseAddress)paramArrayList.get(m)).code.equals(paramString)) {
        return m;
      }
      m += 1;
    }
    return 0;
  }
  
  private void a(int paramInt, boolean paramBoolean)
  {
    Intent localIntent;
    if ((this.h <= 0) || (this.h > 3)) {
      if (!"0".equals(this.jdField_b_of_type_JavaLangString))
      {
        localIntent = new Intent(this, CountrySelectActivity.class);
        localIntent.putExtra("key_country_code", this.jdField_b_of_type_JavaLangString);
        localIntent.putExtra("key_no_limit_allow", true);
        if (paramInt == 1) {
          startActivityForResult(localIntent, 1003);
        }
      }
    }
    do
    {
      do
      {
        do
        {
          return;
        } while (paramInt != 2);
        startActivityForResult(localIntent, 1004);
        return;
        if (!paramBoolean)
        {
          b(paramInt);
          f();
        }
        if (paramInt == 1)
        {
          this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText(this.jdField_a_of_type_Anjh.c(b()));
          c(1);
          return;
        }
      } while (paramInt != 2);
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText(this.jdField_a_of_type_Anjh.c(b()));
      c(2);
      return;
      if (paramInt == 1)
      {
        if ("不限".equals(this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.a().getText())) {
          this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText(this.jdField_a_of_type_Anjh.c(b()));
        }
        c(1);
        return;
      }
    } while (paramInt != 2);
    if ("不限".equals(this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.a().getText())) {
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText(this.jdField_a_of_type_Anjh.c(b()));
    }
    c(2);
  }
  
  private int b(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt <= 17)) {}
    while (paramInt <= 17) {
      return 0;
    }
    return paramInt - 17;
  }
  
  private String b()
  {
    Object localObject = new StringBuilder();
    if ((!"0".equals(this.jdField_b_of_type_JavaLangString)) && (this.jdField_a_of_type_ComTencentMobileqqConditionsearchDataBaseAddress != null))
    {
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqConditionsearchDataBaseAddress.name).append("-");
      int m = 0;
      while (m < this.h)
      {
        if ((this.jdField_a_of_type_ArrayOfComTencentMobileqqConditionsearchDataBaseAddress != null) && (this.jdField_a_of_type_ArrayOfComTencentMobileqqConditionsearchDataBaseAddress[m] != null) && (!"0".equals(this.jdField_a_of_type_ArrayOfComTencentMobileqqConditionsearchDataBaseAddress[m].code))) {
          ((StringBuilder)localObject).append(this.jdField_a_of_type_ArrayOfComTencentMobileqqConditionsearchDataBaseAddress[m].name).append("-");
        }
        m += 1;
      }
    }
    localObject = ((StringBuilder)localObject).toString();
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      return "不限";
    }
    return ((String)localObject).substring(0, ((String)localObject).length() - 1);
  }
  
  private void b(int paramInt)
  {
    int m = 1;
    Object localObject = null;
    String[] arrayOfString;
    if (paramInt == 1)
    {
      localObject = this.jdField_a_of_type_Anjh.b();
      this.jdField_b_of_type_JavaLangString = localObject[0];
      if (this.jdField_b_of_type_JavaLangString.equals("0"))
      {
        arrayOfString = this.jdField_a_of_type_Anjh.a();
        this.jdField_b_of_type_JavaLangString = arrayOfString[0];
        localObject = arrayOfString;
        if (this.jdField_b_of_type_JavaLangString.equals("0"))
        {
          this.jdField_b_of_type_JavaLangString = "1";
          localObject = arrayOfString;
        }
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ArrayOfJavaLangString = new String[] { "0", "0", "0" };
      if (localObject == null) {
        break;
      }
      int n = localObject.length;
      while (m < n)
      {
        this.jdField_a_of_type_ArrayOfJavaLangString[(m - 1)] = localObject[m];
        m += 1;
      }
      if (paramInt == 2)
      {
        arrayOfString = this.jdField_a_of_type_Anjh.c();
        this.jdField_b_of_type_JavaLangString = arrayOfString[0];
        localObject = arrayOfString;
        if (this.jdField_b_of_type_JavaLangString.equals("0"))
        {
          this.jdField_b_of_type_JavaLangString = "1";
          localObject = arrayOfString;
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("ConditionSearchFriendActivity", 2, "initLocationCode|type : " + paramInt + ", mLocationCountyCode : " + this.jdField_b_of_type_JavaLangString);
    }
  }
  
  private void c()
  {
    this.jdField_b_of_type_Boolean = getIntent().getBooleanExtra("key_first_req_location", false);
    this.jdField_a_of_type_Anjh = ((anjh)this.app.getManager(59));
    ThreadManager.getSubThreadHandler().post(new ConditionSearchFriendActivity.1(this));
    this.jdField_d_of_type_Int = this.jdField_a_of_type_Anjh.c();
    this.jdField_e_of_type_Int = this.jdField_a_of_type_Anjh.b();
    if ((this.jdField_e_of_type_Int == anjh.jdField_c_of_type_ArrayOfInt[0]) || (this.jdField_e_of_type_Int == anjh.jdField_c_of_type_ArrayOfInt[1]))
    {
      this.jdField_e_of_type_Int = 0;
      this.jdField_a_of_type_Anjh.a(this.jdField_e_of_type_Int);
    }
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)findViewById(2131366094));
    this.jdField_a_of_type_AndroidWidgetEditText.setFilters(new InputFilter[] { new InputFilter.LengthFilter(20) });
    Object localObject = getResources().getDrawable(2130850325);
    ((Drawable)localObject).setBounds(0, 0, ((Drawable)localObject).getIntrinsicWidth(), ((Drawable)localObject).getIntrinsicHeight());
    this.jdField_a_of_type_AndroidWidgetEditText.setCompoundDrawables((Drawable)localObject, null, null, null);
    this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(new aqhq(this));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131364886));
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131364889));
    this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131364887));
    this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131364888));
    this.jdField_e_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131364890));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131365037));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131367408);
    this.jdField_b_of_type_AndroidViewView = findViewById(2131367410);
    this.jdField_c_of_type_AndroidViewView = findViewById(2131367406);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131366549));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131370485));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131363555));
    d();
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_c_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setLeftIcon(null);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setLeftText(getResources().getString(2131690898));
    localObject = this.jdField_a_of_type_Anjh.a(this.jdField_b_of_type_Int, this.jdField_c_of_type_Int);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText((CharSequence)localObject);
    if (AppSetting.jdField_c_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(anni.a(2131701179) + (String)localObject);
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
    this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(0);
    this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem.setLeftIcon(null);
    this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem.setLeftText(getResources().getString(2131690901));
    this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText(anjh.d[this.jdField_e_of_type_Int]);
    if (AppSetting.jdField_c_of_type_Boolean) {
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(anni.a(2131701170) + anjh.d[this.jdField_e_of_type_Int]);
    }
    this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setLeftIcon(null);
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setLeftText(getResources().getString(2131690902));
    localObject = this.jdField_a_of_type_Anjh.a(0);
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText(this.jdField_a_of_type_Anjh.c((String)localObject));
    if (AppSetting.jdField_c_of_type_Boolean) {
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(anni.a(2131701162) + (String)localObject);
    }
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
    this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setLeftIcon(null);
    this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setLeftText(getResources().getString(2131690900));
    String str = this.jdField_a_of_type_Anjh.a(1);
    this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText(this.jdField_a_of_type_Anjh.c(str));
    if (AppSetting.jdField_c_of_type_Boolean) {
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(anni.a(2131701176) + str);
    }
    this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
    this.jdField_e_of_type_ComTencentMobileqqWidgetFormSimpleItem.setLeftIcon(null);
    this.jdField_e_of_type_ComTencentMobileqqWidgetFormSimpleItem.setLeftText(getResources().getString(2131690904));
    this.jdField_e_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText(anjh.jdField_c_of_type_ArrayOfJavaLangString[this.jdField_d_of_type_Int]);
    if (AppSetting.jdField_c_of_type_Boolean) {
      this.jdField_e_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(anni.a(2131701165) + anjh.jdField_c_of_type_ArrayOfJavaLangString[this.jdField_d_of_type_Int]);
    }
    this.jdField_e_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    if (AppSetting.jdField_c_of_type_Boolean) {
      this.jdField_a_of_type_AndroidWidgetButton.setContentDescription(getString(2131690976));
    }
    g();
    if (QLog.isColorLevel()) {
      QLog.d("ConditionSearchFriendActivity", 2, "init|mIsFirstReqLocation : " + this.jdField_b_of_type_Boolean + ", locDesc : " + (String)localObject);
    }
    if ((this.jdField_b_of_type_Boolean) || ("不限".equals(localObject))) {
      addObserver(this.jdField_a_of_type_Anot);
    }
  }
  
  private void c(int paramInt)
  {
    int n = -1;
    this.i = paramInt;
    this.jdField_a_of_type_Bkho = bkho.c(this);
    Object localObject = (DispatchActionMoveScrollView)this.jdField_a_of_type_Bkho.findViewById(2131361980);
    ((DispatchActionMoveScrollView)localObject).getChildAt(0).setOnClickListener(null);
    ((DispatchActionMoveScrollView)localObject).jdField_a_of_type_Boolean = true;
    ((DispatchActionMoveScrollView)localObject).setBackgroundResource(17170445);
    this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView = ((IphonePickerView)getLayoutInflater().inflate(2131561215, null));
    this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.a(this.jdField_a_of_type_Aqiw);
    this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setBackgroundColor(-1118221);
    int m;
    if (paramInt == 0)
    {
      paramInt = b(this.jdField_b_of_type_Int);
      m = b(this.jdField_c_of_type_Int);
      this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setSelection(0, paramInt);
      this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setSelection(1, m);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightTextColor(1);
      m = a(this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem);
      paramInt = this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.getHeight();
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setPickListener(this.jdField_a_of_type_Aqiv);
      if (Build.VERSION.SDK_INT >= 11) {
        this.jdField_a_of_type_Bkho.getWindow().setFlags(16777216, 16777216);
      }
      this.jdField_a_of_type_Bkho.a(this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView, null);
      this.jdField_a_of_type_Bkho.setOnDismissListener(this.jdField_a_of_type_AndroidContentDialogInterface$OnDismissListener);
      try
      {
        this.jdField_a_of_type_Bkho.show();
        this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.post(new ConditionSearchFriendActivity.6(this, m, paramInt));
        return;
        if (paramInt == 3)
        {
          this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setSelection(0, this.jdField_d_of_type_Int);
          this.jdField_e_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightTextColor(1);
          m = a(this.jdField_e_of_type_ComTencentMobileqqWidgetFormSimpleItem);
          paramInt = this.jdField_e_of_type_ComTencentMobileqqWidgetFormSimpleItem.getHeight();
        }
        else
        {
          m = 0;
          while (m < this.h)
          {
            this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setSelection(m, this.jdField_a_of_type_ArrayOfInt[m]);
            m += 1;
          }
          this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.findViewById(2131377132));
          this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
          if (this.jdField_a_of_type_ComTencentMobileqqConditionsearchDataBaseAddress != null) {}
          for (localObject = this.jdField_a_of_type_ComTencentMobileqqConditionsearchDataBaseAddress.name;; localObject = "中国")
          {
            this.jdField_d_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
            this.jdField_d_of_type_AndroidWidgetTextView.setOnClickListener(this);
            if (AppSetting.jdField_c_of_type_Boolean) {
              this.jdField_d_of_type_AndroidWidgetTextView.setContentDescription(anni.a(2131701175) + (String)localObject + anni.a(2131701172));
            }
            if (paramInt != 1) {
              break label463;
            }
            this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightTextColor(1);
            m = a(this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem);
            paramInt = this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.getHeight();
            break;
          }
          label463:
          if (paramInt == 2)
          {
            this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightTextColor(1);
            m = a(this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem);
            paramInt = this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.getHeight();
          }
          else
          {
            paramInt = -1;
            m = n;
          }
        }
      }
      catch (Throwable localThrowable)
      {
        while (!QLog.isColorLevel()) {}
        QLog.d("ConditionSearchFriendActivity", 2, localThrowable.getMessage());
      }
    }
  }
  
  private void d()
  {
    boolean bool = bkpg.a();
    if (bool)
    {
      m = 2130839432;
      this.jdField_a_of_type_AndroidViewView.setBackgroundResource(m);
      this.jdField_b_of_type_AndroidViewView.setBackgroundResource(m);
      this.jdField_c_of_type_AndroidViewView.setBackgroundResource(m);
      if (!bool) {
        break label97;
      }
    }
    label97:
    for (int m = 2131167061;; m = 2131166991)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(getResources().getColor(m));
      this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(getResources().getColor(m));
      this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(getResources().getColor(m));
      return;
      m = 2130849617;
      break;
    }
  }
  
  private void e()
  {
    this.jdField_a_of_type_ArrayOfInt = null;
    this.jdField_a_of_type_ArrayOfComTencentMobileqqConditionsearchDataBaseAddress = null;
    this.jdField_a_of_type_ArrayOfJavaLangObject = null;
    this.h = 0;
    this.jdField_a_of_type_ArrayOfJavaLangString = new String[] { "0", "0", "0" };
  }
  
  private void f()
  {
    this.jdField_a_of_type_ComTencentMobileqqConditionsearchDataBaseAddress = this.jdField_a_of_type_Anjh.a(this.jdField_b_of_type_JavaLangString);
    if (this.jdField_a_of_type_ComTencentMobileqqConditionsearchDataBaseAddress != null)
    {
      this.h = this.jdField_a_of_type_ComTencentMobileqqConditionsearchDataBaseAddress.getColumnNember();
      this.jdField_a_of_type_ArrayOfJavaLangObject = new Object[this.h];
      this.jdField_a_of_type_ArrayOfComTencentMobileqqConditionsearchDataBaseAddress = new BaseAddress[this.h];
      this.jdField_a_of_type_ArrayOfInt = new int[this.h];
      if (this.h != 0) {}
    }
    int n;
    int m;
    while (!QLog.isColorLevel())
    {
      return;
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqConditionsearchDataBaseAddress;
      int i1 = this.jdField_a_of_type_ArrayOfJavaLangString.length;
      n = 0;
      m = 0;
      while (n < i1) {
        if ("0".equals(this.jdField_a_of_type_ArrayOfJavaLangString[n])) {
          n += 1;
        } else {
          if (m < this.jdField_a_of_type_ArrayOfJavaLangObject.length) {
            break label235;
          }
        }
      }
      if (m < this.h)
      {
        this.jdField_a_of_type_ArrayOfJavaLangObject[m] = ((BaseAddress)localObject1).getDataList();
        this.jdField_a_of_type_ArrayOfComTencentMobileqqConditionsearchDataBaseAddress[m] = ((BaseAddress)((BaseAddress)localObject1).dataMap.get(Integer.valueOf(0)));
        this.jdField_a_of_type_ArrayOfInt[m] = 0;
      }
    }
    Object localObject2 = new StringBuilder().append("initLocationData|mLocationColumCount : ").append(this.h).append(", mLocationCountry.name : ");
    if (this.jdField_a_of_type_ComTencentMobileqqConditionsearchDataBaseAddress == null) {}
    for (Object localObject1 = "null";; localObject1 = this.jdField_a_of_type_ComTencentMobileqqConditionsearchDataBaseAddress.name)
    {
      QLog.d("ConditionSearchFriendActivity", 2, (String)localObject1);
      return;
      label235:
      this.jdField_a_of_type_ArrayOfJavaLangObject[m] = ((BaseAddress)localObject1).getDataList();
      BaseAddress[] arrayOfBaseAddress = this.jdField_a_of_type_ArrayOfComTencentMobileqqConditionsearchDataBaseAddress;
      localObject2 = (BaseAddress)((BaseAddress)localObject1).dataMap.get(this.jdField_a_of_type_ArrayOfJavaLangString[n]);
      arrayOfBaseAddress[m] = localObject2;
      this.jdField_a_of_type_ArrayOfInt[m] = a((ArrayList)this.jdField_a_of_type_ArrayOfJavaLangObject[m], this.jdField_a_of_type_ArrayOfJavaLangString[n]);
      m += 1;
      localObject1 = localObject2;
      if (localObject2 != null) {
        break;
      }
      return;
    }
  }
  
  private void g()
  {
    if (this.jdField_a_of_type_Int == 0)
    {
      this.jdField_c_of_type_AndroidViewView.setSelected(true);
      this.jdField_a_of_type_AndroidViewView.setSelected(false);
      this.jdField_b_of_type_AndroidViewView.setSelected(false);
    }
    for (;;)
    {
      if (AppSetting.jdField_c_of_type_Boolean)
      {
        this.jdField_c_of_type_AndroidViewView.setContentDescription(anni.a(2131701177));
        this.jdField_b_of_type_AndroidViewView.setContentDescription(anni.a(2131701169));
        this.jdField_a_of_type_AndroidViewView.setContentDescription(anni.a(2131701174));
      }
      return;
      if (this.jdField_a_of_type_Int == 1)
      {
        this.jdField_c_of_type_AndroidViewView.setSelected(false);
        this.jdField_a_of_type_AndroidViewView.setSelected(false);
        this.jdField_b_of_type_AndroidViewView.setSelected(true);
      }
      else if (this.jdField_a_of_type_Int == 2)
      {
        this.jdField_c_of_type_AndroidViewView.setSelected(false);
        this.jdField_a_of_type_AndroidViewView.setSelected(true);
        this.jdField_b_of_type_AndroidViewView.setSelected(false);
      }
    }
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ConditionSearchFriendActivity", 2, "dismissWaittingDialog | type = " + this.jdField_a_of_type_Biau);
    }
    if ((this.jdField_a_of_type_Biau != null) && (this.jdField_a_of_type_Biau.isShowing()))
    {
      this.j = 0;
      this.jdField_a_of_type_Biau.dismiss();
      if (QLog.isColorLevel()) {
        QLog.d("ConditionSearchFriendActivity", 2, "dismissWaittingDialog dismiss");
      }
    }
  }
  
  public void a(int paramInt)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    int m = this.jdField_a_of_type_Anjh.a();
    if (QLog.isColorLevel()) {
      QLog.d("ConditionSearchFriendActivity", 2, "startSelectAddress|checkUpdate result = " + m);
    }
    if (m != 0)
    {
      m = this.jdField_a_of_type_Anjh.a(m, true);
      if (QLog.isColorLevel()) {
        QLog.d("ConditionSearchFriendActivity", 2, "startSelectAddress|update updateResult = " + m);
      }
      if (m == 2)
      {
        QQToast.a(this, 2131693948, 0).b(getTitleBarHeight());
        return;
      }
      if (m == 0)
      {
        a(paramInt, getString(2131690908));
        this.jdField_a_of_type_Anjh.c(this.jdField_a_of_type_Anjl);
        return;
      }
      a(paramInt, getString(2131690908));
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1000, 20000L);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ConditionSearchFriendActivity", 2, "startSelectAddress|type : " + paramInt + ", mNeedInitLocation" + this.jdField_d_of_type_Boolean + ", mNeedInitHome : " + this.jdField_c_of_type_Boolean + ", mLocationColumCount : " + this.h + ", mLocationCountyCode : " + this.jdField_b_of_type_JavaLangString);
    }
    if (paramInt == 1)
    {
      if (!this.jdField_d_of_type_Boolean) {
        break label339;
      }
      b(1);
      f();
      this.jdField_d_of_type_Boolean = false;
      this.jdField_c_of_type_Boolean = true;
    }
    for (;;)
    {
      a(paramInt, bool1);
      return;
      if (paramInt != 2) {
        break;
      }
      if (this.jdField_c_of_type_Boolean)
      {
        b(2);
        f();
        this.jdField_c_of_type_Boolean = false;
        this.jdField_d_of_type_Boolean = true;
      }
      for (bool1 = bool2;; bool1 = false)
      {
        a(paramInt, bool1);
        return;
      }
      label339:
      bool1 = false;
    }
  }
  
  void a(int paramInt, String paramString)
  {
    this.j = paramInt;
    if (this.jdField_a_of_type_Biau == null) {
      this.jdField_a_of_type_Biau = new biau(this, getTitleBarHeight());
    }
    if (QLog.isColorLevel()) {
      QLog.d("ConditionSearchFriendActivity", 2, "showWaitingDialog | type = " + paramInt + ", str = " + paramString + ", dlg=" + this.jdField_a_of_type_Biau);
    }
    this.jdField_a_of_type_Biau.a(paramString);
    this.jdField_a_of_type_Biau.show();
  }
  
  void b()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      bcst.b(this.app, "CliOper", "", "", "0X8004241", "0X8004241", 0, 0, "", "", "", "");
      this.jdField_a_of_type_Boolean = false;
    }
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool);
    return bool;
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ConditionSearchFriendActivity", 2, "doOnActivityResult | requestCode = " + paramInt1);
    }
    if (paramIntent == null) {}
    label37:
    label613:
    label626:
    label628:
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              break label37;
              break label37;
              break label37;
              break label37;
              do
              {
                return;
              } while (paramInt2 != -1);
              if (paramInt1 != 1002) {
                break;
              }
              this.jdField_e_of_type_Int = paramIntent.getIntExtra("param_id", 0);
              this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText(anjh.d[this.jdField_e_of_type_Int]);
              this.jdField_a_of_type_Anjh.a(this.jdField_e_of_type_Int);
            } while (!AppSetting.jdField_c_of_type_Boolean);
            this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(anni.a(2131701164) + anjh.d[this.jdField_e_of_type_Int]);
            return;
            paramIntent = paramIntent.getStringExtra("key_country_code");
            if (QLog.isColorLevel()) {
              QLog.d("ConditionSearchFriendActivity", 2, "doOnActivityResult | codes = " + paramIntent);
            }
          } while ((TextUtils.isEmpty(paramIntent)) || (paramIntent.equals(this.jdField_b_of_type_JavaLangString)));
          this.jdField_b_of_type_JavaLangString = paramIntent;
          this.jdField_a_of_type_ComTencentMobileqqConditionsearchDataBaseAddress = this.jdField_a_of_type_Anjh.a(this.jdField_b_of_type_JavaLangString);
        } while (this.jdField_a_of_type_ComTencentMobileqqConditionsearchDataBaseAddress == null);
        paramInt2 = this.jdField_a_of_type_ComTencentMobileqqConditionsearchDataBaseAddress.getColumnNember();
        if ((paramInt2 <= 0) || (paramInt2 > 3))
        {
          e();
          f();
          if ((this.jdField_a_of_type_Bkho != null) && (this.jdField_a_of_type_Bkho.isShowing())) {
            this.jdField_a_of_type_Bkho.dismiss();
          }
        }
        for (;;)
        {
          if (paramInt1 != 1003) {
            break label628;
          }
          this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText(this.jdField_a_of_type_ComTencentMobileqqConditionsearchDataBaseAddress.name);
          if (!AppSetting.jdField_c_of_type_Boolean) {
            break;
          }
          this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(anni.a(2131701159) + this.jdField_a_of_type_ComTencentMobileqqConditionsearchDataBaseAddress.name);
          return;
          paramIntent = new String[4];
          paramIntent[0] = this.jdField_b_of_type_JavaLangString;
          paramIntent[1] = this.jdField_a_of_type_ArrayOfJavaLangString[0];
          paramIntent[2] = this.jdField_a_of_type_ArrayOfJavaLangString[1];
          paramIntent[3] = this.jdField_a_of_type_ArrayOfJavaLangString[2];
          String str = b();
          if (paramInt1 == 1003)
          {
            this.jdField_a_of_type_Anjh.a(0, str);
            this.jdField_a_of_type_Anjh.b(paramIntent);
          }
          else if (paramInt1 == 1004)
          {
            this.jdField_a_of_type_Anjh.a(1, str);
            this.jdField_a_of_type_Anjh.c(paramIntent);
            continue;
            e();
            f();
            if ((this.jdField_a_of_type_Bkho != null) && (this.jdField_a_of_type_Bkho.isShowing()))
            {
              if (this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView == null) {
                this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView = ((IphonePickerView)getLayoutInflater().inflate(2131561215, null));
              }
              this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.a(this.jdField_a_of_type_Aqiw);
              paramInt2 = 0;
            }
            while (paramInt2 < this.h)
            {
              this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.a(paramInt2);
              this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setSelection(paramInt2, 0);
              paramInt2 += 1;
              continue;
              if (paramInt1 != 1003) {
                break label613;
              }
              c(1);
            }
            for (;;)
            {
              if (this.jdField_d_of_type_AndroidWidgetTextView == null) {
                break label626;
              }
              this.jdField_d_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqConditionsearchDataBaseAddress.name);
              if (!AppSetting.jdField_c_of_type_Boolean) {
                break;
              }
              this.jdField_d_of_type_AndroidWidgetTextView.setContentDescription(anni.a(2131701163) + this.jdField_a_of_type_ComTencentMobileqqConditionsearchDataBaseAddress.name + anni.a(2131701166));
              break;
              if (paramInt1 == 1004) {
                c(2);
              }
            }
          }
        }
      } while (paramInt1 != 1004);
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText(this.jdField_a_of_type_ComTencentMobileqqConditionsearchDataBaseAddress.name);
    } while (!AppSetting.jdField_c_of_type_Boolean);
    this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(anni.a(2131701178) + this.jdField_a_of_type_ComTencentMobileqqConditionsearchDataBaseAddress.name);
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2131561091);
    this.jdField_d_of_type_AndroidViewView = findViewById(2131376788);
    this.jdField_e_of_type_AndroidViewView = findViewById(2131368621);
    setContentBackgroundResource(2130838758);
    this.jdField_a_of_type_Anjh = ((anjh)this.app.getManager(59));
    setTitle(2131690891);
    c();
    return true;
  }
  
  public void doOnDestroy()
  {
    b();
    super.doOnDestroy();
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_Anjh.b(this);
    this.jdField_a_of_type_Anjh.d(this.jdField_a_of_type_Anjl);
    this.jdField_a_of_type_Anjh.d(this.jdField_a_of_type_Anjn);
    removeObserver(this.jdField_a_of_type_Anot);
  }
  
  public void doOnStart()
  {
    super.doOnStart();
    if (this.jdField_a_of_type_Anjh != null) {
      this.jdField_a_of_type_Anjh.a(this);
    }
  }
  
  public void onClick(View paramView)
  {
    b();
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      bcst.b(this.app, "CliOper", "", "", "0X800424B", "0X800424B", 0, 0, "", "", "", "");
      if (!bgnt.d(this))
      {
        QQToast.a(this, 2131693948, 0).b(getTitleBarHeight());
      }
      else
      {
        this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidWidgetEditText.getText().toString();
        Object localObject = this.jdField_a_of_type_Anjh.b();
        String[] arrayOfString = this.jdField_a_of_type_Anjh.c();
        this.jdField_a_of_type_Anjh.c(this.jdField_a_of_type_Anjn);
        this.jdField_a_of_type_Anjh.a(true, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, this.jdField_c_of_type_Int, (String[])localObject, arrayOfString, this.jdField_e_of_type_Int, this.jdField_d_of_type_Int, 1);
        a(3, getString(2131690909));
        continue;
        c(0);
        continue;
        localObject = new Intent(this, JobSelectionActivity.class);
        ((Intent)localObject).putExtra("param_id", this.jdField_e_of_type_Int);
        ((Intent)localObject).putExtra("param_from_consearch", true);
        ((Intent)localObject).putExtra("param_need_no_limit", true);
        startActivityForResult((Intent)localObject, 1002);
        continue;
        bcst.b(this.app, "CliOper", "", "", "0X8004245", "0X8004245", 0, 0, "", "", "", "");
        a(2);
        continue;
        this.jdField_b_of_type_Boolean = false;
        this.jdField_a_of_type_Anjh.a();
        bcst.b(this.app, "CliOper", "", "", "0X8004244", "0X8004244", 0, 0, "", "", "", "");
        a(1);
        continue;
        c(3);
        continue;
        this.jdField_a_of_type_Int = 2;
        g();
        this.jdField_a_of_type_Anjh.c(this.jdField_a_of_type_Int);
        bcst.b(this.app, "CliOper", "", "", "0X8004242", "0X8004242", 0, 0, this.jdField_a_of_type_Int + "", "", "", "");
        continue;
        this.jdField_a_of_type_Int = 1;
        g();
        this.jdField_a_of_type_Anjh.c(this.jdField_a_of_type_Int);
        bcst.b(this.app, "CliOper", "", "", "0X8004242", "0X8004242", 0, 0, this.jdField_a_of_type_Int + "", "", "", "");
        continue;
        this.jdField_a_of_type_Int = 0;
        g();
        this.jdField_a_of_type_Anjh.c(this.jdField_a_of_type_Int);
        bcst.b(this.app, "CliOper", "", "", "0X8004242", "0X8004242", 0, 0, this.jdField_a_of_type_Int + "", "", "", "");
        continue;
        localObject = new Intent(this, CountrySelectActivity.class);
        ((Intent)localObject).putExtra("key_country_code", this.jdField_b_of_type_JavaLangString);
        ((Intent)localObject).putExtra("key_no_limit_allow", true);
        if (this.i == 1) {
          startActivityForResult((Intent)localObject, 1003);
        } else if (this.i == 2) {
          startActivityForResult((Intent)localObject, 1004);
        }
      }
    }
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.conditionsearch.ConditionSearchFriendActivity
 * JD-Core Version:    0.7.0.1
 */