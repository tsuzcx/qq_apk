package com.tencent.mobileqq.conditionsearch;

import ajfw;
import ajga;
import ajgc;
import ajjy;
import ajlg;
import alwj;
import alwk;
import alwl;
import alwm;
import alwn;
import alwo;
import alwp;
import alwq;
import alxp;
import alxq;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import awqx;
import badq;
import bbms;
import bbmy;
import begr;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.JobSelectionActivity;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.conditionsearch.data.BaseAddress;
import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView;
import com.tencent.mobileqq.widget.DispatchActionMoveScrollView;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.MultiImageTextView;
import java.util.ArrayList;
import java.util.LinkedHashMap;

public class ConditionSearchFriendActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener
{
  private static final String jdField_c_of_type_JavaLangString = ajjy.a(2131636574);
  public int a;
  public ajfw a;
  ajga jdField_a_of_type_Ajga = new alwp(this);
  ajgc jdField_a_of_type_Ajgc = new alwo(this);
  ajlg jdField_a_of_type_Ajlg = new alwq(this);
  alxp jdField_a_of_type_Alxp = new alwl(this);
  alxq jdField_a_of_type_Alxq = new alwk(this);
  DialogInterface.OnDismissListener jdField_a_of_type_AndroidContentDialogInterface$OnDismissListener = new alwm(this);
  Handler jdField_a_of_type_AndroidOsHandler = new alwn(this);
  View jdField_a_of_type_AndroidViewView;
  Button jdField_a_of_type_AndroidWidgetButton;
  EditText jdField_a_of_type_AndroidWidgetEditText;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  bbms jdField_a_of_type_Bbms;
  public begr a;
  BaseAddress jdField_a_of_type_ComTencentMobileqqConditionsearchDataBaseAddress;
  public IphonePickerView a;
  public FormSimpleItem a;
  public String a;
  public boolean a;
  public int[] a;
  public BaseAddress[] a;
  public Object[] a;
  public String[] a;
  public int b;
  View jdField_b_of_type_AndroidViewView;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  public FormSimpleItem b;
  public String b;
  public boolean b;
  public int c;
  View jdField_c_of_type_AndroidViewView;
  public TextView c;
  public FormSimpleItem c;
  public boolean c;
  public int d;
  View jdField_d_of_type_AndroidViewView;
  FormSimpleItem jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  public boolean d;
  public int e;
  public View e;
  public FormSimpleItem e;
  public int f;
  public int g;
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
          e();
        }
        if (paramInt == 1)
        {
          this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText(this.jdField_a_of_type_Ajfw.c(b()));
          c(1);
          return;
        }
      } while (paramInt != 2);
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText(this.jdField_a_of_type_Ajfw.c(b()));
      c(2);
      return;
      if (paramInt == 1)
      {
        if ("不限".equals(this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.a().getText())) {
          this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText(this.jdField_a_of_type_Ajfw.c(b()));
        }
        c(1);
        return;
      }
    } while (paramInt != 2);
    if ("不限".equals(this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.a().getText())) {
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText(this.jdField_a_of_type_Ajfw.c(b()));
    }
    c(2);
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
      localObject = this.jdField_a_of_type_Ajfw.b();
      this.jdField_b_of_type_JavaLangString = localObject[0];
      if (this.jdField_b_of_type_JavaLangString.equals("0"))
      {
        arrayOfString = this.jdField_a_of_type_Ajfw.a();
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
        arrayOfString = this.jdField_a_of_type_Ajfw.c();
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
    this.jdField_a_of_type_Ajfw = ((ajfw)this.app.getManager(59));
    this.jdField_a_of_type_Int = this.jdField_a_of_type_Ajfw.d();
    Object localObject = this.jdField_a_of_type_Ajfw.a();
    this.jdField_b_of_type_Int = localObject[0];
    this.jdField_c_of_type_Int = localObject[1];
    this.f = localObject[0];
    this.g = localObject[1];
    this.jdField_d_of_type_Int = this.jdField_a_of_type_Ajfw.c();
    this.jdField_e_of_type_Int = this.jdField_a_of_type_Ajfw.b();
    if ((this.jdField_e_of_type_Int == ajfw.jdField_c_of_type_ArrayOfInt[0]) || (this.jdField_e_of_type_Int == ajfw.jdField_c_of_type_ArrayOfInt[1]))
    {
      this.jdField_e_of_type_Int = 0;
      this.jdField_a_of_type_Ajfw.a(this.jdField_e_of_type_Int);
    }
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)findViewById(2131300160));
    this.jdField_a_of_type_AndroidWidgetEditText.setFilters(new InputFilter[] { new InputFilter.LengthFilter(20) });
    localObject = getResources().getDrawable(2130848991);
    ((Drawable)localObject).setBounds(0, 0, ((Drawable)localObject).getIntrinsicWidth(), ((Drawable)localObject).getIntrinsicHeight());
    this.jdField_a_of_type_AndroidWidgetEditText.setCompoundDrawables((Drawable)localObject, null, null, null);
    this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(new alwj(this));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131299033));
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131299036));
    this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131299034));
    this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131299035));
    this.jdField_e_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131299037));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131299167));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131301375);
    this.jdField_b_of_type_AndroidViewView = findViewById(2131301377);
    this.jdField_c_of_type_AndroidViewView = findViewById(2131301373);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131300603));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131304087));
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_c_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setLeftIcon(null);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setLeftText(getResources().getString(2131625448));
    localObject = this.jdField_a_of_type_Ajfw.a(this.jdField_b_of_type_Int, this.jdField_c_of_type_Int);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText((CharSequence)localObject);
    if (AppSetting.jdField_c_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(ajjy.a(2131636580) + (String)localObject);
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
    this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(0);
    this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem.setLeftIcon(null);
    this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem.setLeftText(getResources().getString(2131625451));
    this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText(ajfw.d[this.jdField_e_of_type_Int]);
    if (AppSetting.jdField_c_of_type_Boolean) {
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(ajjy.a(2131636571) + ajfw.d[this.jdField_e_of_type_Int]);
    }
    this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setLeftIcon(null);
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setLeftText(getResources().getString(2131625452));
    localObject = this.jdField_a_of_type_Ajfw.a(0);
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText(this.jdField_a_of_type_Ajfw.c((String)localObject));
    if (AppSetting.jdField_c_of_type_Boolean) {
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(ajjy.a(2131636563) + (String)localObject);
    }
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
    this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setLeftIcon(null);
    this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setLeftText(getResources().getString(2131625450));
    String str = this.jdField_a_of_type_Ajfw.a(1);
    this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText(this.jdField_a_of_type_Ajfw.c(str));
    if (AppSetting.jdField_c_of_type_Boolean) {
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(ajjy.a(2131636577) + str);
    }
    this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
    this.jdField_e_of_type_ComTencentMobileqqWidgetFormSimpleItem.setLeftIcon(null);
    this.jdField_e_of_type_ComTencentMobileqqWidgetFormSimpleItem.setLeftText(getResources().getString(2131625455));
    this.jdField_e_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText(ajfw.jdField_c_of_type_ArrayOfJavaLangString[this.jdField_d_of_type_Int]);
    if (AppSetting.jdField_c_of_type_Boolean) {
      this.jdField_e_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(ajjy.a(2131636566) + ajfw.jdField_c_of_type_ArrayOfJavaLangString[this.jdField_d_of_type_Int]);
    }
    this.jdField_e_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    if (AppSetting.jdField_c_of_type_Boolean) {
      this.jdField_a_of_type_AndroidWidgetButton.setContentDescription(getString(2131625547));
    }
    f();
    if (QLog.isColorLevel()) {
      QLog.d("ConditionSearchFriendActivity", 2, "init|mIsFirstReqLocation : " + this.jdField_b_of_type_Boolean + ", locDesc : " + (String)localObject);
    }
    if ((this.jdField_b_of_type_Boolean) || ("不限".equals(localObject))) {
      addObserver(this.jdField_a_of_type_Ajlg);
    }
  }
  
  private void c(int paramInt)
  {
    int n = -1;
    this.i = paramInt;
    this.jdField_a_of_type_Begr = begr.c(this);
    Object localObject = (DispatchActionMoveScrollView)this.jdField_a_of_type_Begr.findViewById(2131296387);
    ((DispatchActionMoveScrollView)localObject).getChildAt(0).setOnClickListener(null);
    ((DispatchActionMoveScrollView)localObject).jdField_a_of_type_Boolean = true;
    ((DispatchActionMoveScrollView)localObject).setBackgroundResource(17170445);
    this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView = ((IphonePickerView)getLayoutInflater().inflate(2131495228, null));
    this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.a(this.jdField_a_of_type_Alxq);
    this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setBackgroundColor(-1118221);
    int m;
    if (paramInt == 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setSelection(0, this.jdField_b_of_type_Int);
      this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setSelection(1, this.jdField_c_of_type_Int);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightTextColor(1);
      m = a(this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem);
      paramInt = this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.getHeight();
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setPickListener(this.jdField_a_of_type_Alxp);
      if (Build.VERSION.SDK_INT >= 11) {
        this.jdField_a_of_type_Begr.getWindow().setFlags(16777216, 16777216);
      }
      this.jdField_a_of_type_Begr.a(this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView, null);
      this.jdField_a_of_type_Begr.setOnDismissListener(this.jdField_a_of_type_AndroidContentDialogInterface$OnDismissListener);
      try
      {
        this.jdField_a_of_type_Begr.show();
        this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.post(new ConditionSearchFriendActivity.5(this, m, paramInt));
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
          this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.findViewById(2131310029));
          this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
          if (this.jdField_a_of_type_ComTencentMobileqqConditionsearchDataBaseAddress != null) {}
          for (localObject = this.jdField_a_of_type_ComTencentMobileqqConditionsearchDataBaseAddress.name;; localObject = "中国")
          {
            this.jdField_c_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
            this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(this);
            if (AppSetting.jdField_c_of_type_Boolean) {
              this.jdField_c_of_type_AndroidWidgetTextView.setContentDescription(ajjy.a(2131636576) + (String)localObject + ajjy.a(2131636573));
            }
            if (paramInt != 1) {
              break label451;
            }
            this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightTextColor(1);
            m = a(this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem);
            paramInt = this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.getHeight();
            break;
          }
          label451:
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
    this.jdField_a_of_type_ArrayOfInt = null;
    this.jdField_a_of_type_ArrayOfComTencentMobileqqConditionsearchDataBaseAddress = null;
    this.jdField_a_of_type_ArrayOfJavaLangObject = null;
    this.h = 0;
    this.jdField_a_of_type_ArrayOfJavaLangString = new String[] { "0", "0", "0" };
  }
  
  private void e()
  {
    this.jdField_a_of_type_ComTencentMobileqqConditionsearchDataBaseAddress = this.jdField_a_of_type_Ajfw.a(this.jdField_b_of_type_JavaLangString);
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
  
  private void f()
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
        this.jdField_c_of_type_AndroidViewView.setContentDescription(ajjy.a(2131636578));
        this.jdField_b_of_type_AndroidViewView.setContentDescription(ajjy.a(2131636570));
        this.jdField_a_of_type_AndroidViewView.setContentDescription(ajjy.a(2131636575));
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
      QLog.d("ConditionSearchFriendActivity", 2, "dismissWaittingDialog | type = " + this.jdField_a_of_type_Bbms);
    }
    if ((this.jdField_a_of_type_Bbms != null) && (this.jdField_a_of_type_Bbms.isShowing()))
    {
      this.j = 0;
      this.jdField_a_of_type_Bbms.dismiss();
      if (QLog.isColorLevel()) {
        QLog.d("ConditionSearchFriendActivity", 2, "dismissWaittingDialog dismiss");
      }
    }
  }
  
  public void a(int paramInt)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    int m = this.jdField_a_of_type_Ajfw.a();
    if (QLog.isColorLevel()) {
      QLog.d("ConditionSearchFriendActivity", 2, "startSelectAddress|checkUpdate result = " + m);
    }
    if (m != 0)
    {
      m = this.jdField_a_of_type_Ajfw.a(m, true);
      if (QLog.isColorLevel()) {
        QLog.d("ConditionSearchFriendActivity", 2, "startSelectAddress|update updateResult = " + m);
      }
      if (m == 2)
      {
        bbmy.a(this, 2131628948, 0).b(getTitleBarHeight());
        return;
      }
      if (m == 0)
      {
        a(paramInt, getString(2131625459));
        this.jdField_a_of_type_Ajfw.c(this.jdField_a_of_type_Ajga);
        return;
      }
      a(paramInt, getString(2131625459));
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
      e();
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
        e();
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
    if (this.jdField_a_of_type_Bbms == null) {
      this.jdField_a_of_type_Bbms = new bbms(this, getTitleBarHeight());
    }
    if (QLog.isColorLevel()) {
      QLog.d("ConditionSearchFriendActivity", 2, "showWaitingDialog | type = " + paramInt + ", str = " + paramString + ", dlg=" + this.jdField_a_of_type_Bbms);
    }
    this.jdField_a_of_type_Bbms.a(paramString);
    this.jdField_a_of_type_Bbms.show();
  }
  
  void b()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      awqx.b(this.app, "CliOper", "", "", "0X8004241", "0X8004241", 0, 0, "", "", "", "");
      this.jdField_a_of_type_Boolean = false;
    }
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
              this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText(ajfw.d[this.jdField_e_of_type_Int]);
              this.jdField_a_of_type_Ajfw.a(this.jdField_e_of_type_Int);
            } while (!AppSetting.jdField_c_of_type_Boolean);
            this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(ajjy.a(2131636565) + ajfw.d[this.jdField_e_of_type_Int]);
            return;
            paramIntent = paramIntent.getStringExtra("key_country_code");
            if (QLog.isColorLevel()) {
              QLog.d("ConditionSearchFriendActivity", 2, "doOnActivityResult | codes = " + paramIntent);
            }
          } while ((TextUtils.isEmpty(paramIntent)) || (paramIntent.equals(this.jdField_b_of_type_JavaLangString)));
          this.jdField_b_of_type_JavaLangString = paramIntent;
          this.jdField_a_of_type_ComTencentMobileqqConditionsearchDataBaseAddress = this.jdField_a_of_type_Ajfw.a(this.jdField_b_of_type_JavaLangString);
        } while (this.jdField_a_of_type_ComTencentMobileqqConditionsearchDataBaseAddress == null);
        paramInt2 = this.jdField_a_of_type_ComTencentMobileqqConditionsearchDataBaseAddress.getColumnNember();
        if ((paramInt2 <= 0) || (paramInt2 > 3))
        {
          d();
          e();
          if ((this.jdField_a_of_type_Begr != null) && (this.jdField_a_of_type_Begr.isShowing())) {
            this.jdField_a_of_type_Begr.dismiss();
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
          this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(ajjy.a(2131636560) + this.jdField_a_of_type_ComTencentMobileqqConditionsearchDataBaseAddress.name);
          return;
          paramIntent = new String[4];
          paramIntent[0] = this.jdField_b_of_type_JavaLangString;
          paramIntent[1] = this.jdField_a_of_type_ArrayOfJavaLangString[0];
          paramIntent[2] = this.jdField_a_of_type_ArrayOfJavaLangString[1];
          paramIntent[3] = this.jdField_a_of_type_ArrayOfJavaLangString[2];
          String str = b();
          if (paramInt1 == 1003)
          {
            this.jdField_a_of_type_Ajfw.a(0, str);
            this.jdField_a_of_type_Ajfw.b(paramIntent);
          }
          else if (paramInt1 == 1004)
          {
            this.jdField_a_of_type_Ajfw.a(1, str);
            this.jdField_a_of_type_Ajfw.c(paramIntent);
            continue;
            d();
            e();
            if ((this.jdField_a_of_type_Begr != null) && (this.jdField_a_of_type_Begr.isShowing()))
            {
              if (this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView == null) {
                this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView = ((IphonePickerView)getLayoutInflater().inflate(2131495228, null));
              }
              this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.a(this.jdField_a_of_type_Alxq);
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
              if (this.jdField_c_of_type_AndroidWidgetTextView == null) {
                break label626;
              }
              this.jdField_c_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqConditionsearchDataBaseAddress.name);
              if (!AppSetting.jdField_c_of_type_Boolean) {
                break;
              }
              this.jdField_c_of_type_AndroidWidgetTextView.setContentDescription(ajjy.a(2131636564) + this.jdField_a_of_type_ComTencentMobileqqConditionsearchDataBaseAddress.name + ajjy.a(2131636567));
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
    this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(ajjy.a(2131636579) + this.jdField_a_of_type_ComTencentMobileqqConditionsearchDataBaseAddress.name);
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2131495117);
    this.jdField_d_of_type_AndroidViewView = findViewById(2131309736);
    this.jdField_e_of_type_AndroidViewView = findViewById(2131302536);
    setContentBackgroundResource(2130838503);
    this.jdField_a_of_type_Ajfw = ((ajfw)this.app.getManager(59));
    setTitle(2131625441);
    c();
    return true;
  }
  
  public void doOnDestroy()
  {
    b();
    super.doOnDestroy();
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_Ajfw.b(this);
    this.jdField_a_of_type_Ajfw.d(this.jdField_a_of_type_Ajga);
    this.jdField_a_of_type_Ajfw.d(this.jdField_a_of_type_Ajgc);
    removeObserver(this.jdField_a_of_type_Ajlg);
  }
  
  public void doOnStart()
  {
    super.doOnStart();
    if (this.jdField_a_of_type_Ajfw != null) {
      this.jdField_a_of_type_Ajfw.a(this);
    }
  }
  
  public void onClick(View paramView)
  {
    b();
    switch (paramView.getId())
    {
    }
    do
    {
      return;
      awqx.b(this.app, "CliOper", "", "", "0X800424B", "0X800424B", 0, 0, "", "", "", "");
      if (!badq.d(this))
      {
        bbmy.a(this, 2131628948, 0).b(getTitleBarHeight());
        return;
      }
      this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidWidgetEditText.getText().toString();
      paramView = this.jdField_a_of_type_Ajfw.b();
      String[] arrayOfString = this.jdField_a_of_type_Ajfw.c();
      this.jdField_a_of_type_Ajfw.c(this.jdField_a_of_type_Ajgc);
      this.jdField_a_of_type_Ajfw.a(true, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, this.jdField_c_of_type_Int, paramView, arrayOfString, this.jdField_e_of_type_Int, this.jdField_d_of_type_Int, 1);
      a(3, getString(2131625460));
      return;
      c(0);
      return;
      paramView = new Intent(this, JobSelectionActivity.class);
      paramView.putExtra("param_id", this.jdField_e_of_type_Int);
      paramView.putExtra("param_from_consearch", true);
      paramView.putExtra("param_need_no_limit", true);
      startActivityForResult(paramView, 1002);
      return;
      awqx.b(this.app, "CliOper", "", "", "0X8004245", "0X8004245", 0, 0, "", "", "", "");
      a(2);
      return;
      this.jdField_b_of_type_Boolean = false;
      this.jdField_a_of_type_Ajfw.a();
      awqx.b(this.app, "CliOper", "", "", "0X8004244", "0X8004244", 0, 0, "", "", "", "");
      a(1);
      return;
      c(3);
      return;
      this.jdField_a_of_type_Int = 2;
      f();
      this.jdField_a_of_type_Ajfw.c(this.jdField_a_of_type_Int);
      awqx.b(this.app, "CliOper", "", "", "0X8004242", "0X8004242", 0, 0, this.jdField_a_of_type_Int + "", "", "", "");
      return;
      this.jdField_a_of_type_Int = 1;
      f();
      this.jdField_a_of_type_Ajfw.c(this.jdField_a_of_type_Int);
      awqx.b(this.app, "CliOper", "", "", "0X8004242", "0X8004242", 0, 0, this.jdField_a_of_type_Int + "", "", "", "");
      return;
      this.jdField_a_of_type_Int = 0;
      f();
      this.jdField_a_of_type_Ajfw.c(this.jdField_a_of_type_Int);
      awqx.b(this.app, "CliOper", "", "", "0X8004242", "0X8004242", 0, 0, this.jdField_a_of_type_Int + "", "", "", "");
      return;
      paramView = new Intent(this, CountrySelectActivity.class);
      paramView.putExtra("key_country_code", this.jdField_b_of_type_JavaLangString);
      paramView.putExtra("key_no_limit_allow", true);
      if (this.i == 1)
      {
        startActivityForResult(paramView, 1003);
        return;
      }
    } while (this.i != 2);
    startActivityForResult(paramView, 1004);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.conditionsearch.ConditionSearchFriendActivity
 * JD-Core Version:    0.7.0.1
 */