package com.tencent.mobileqq.conditionsearch;

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
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.JobSelectionActivity;
import com.tencent.mobileqq.app.ConditionSearchManager;
import com.tencent.mobileqq.app.ConditionSearchManager.IConfigListener;
import com.tencent.mobileqq.app.ConditionSearchManager.ISearchListener;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.LBSObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.conditionsearch.data.BaseAddress;
import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView;
import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView.IphonePickListener;
import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView.PickerViewAdapter;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.DispatchActionMoveScrollView;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.MultiImageTextView;
import com.tencent.widget.ThemeImageWrapper;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

public class ConditionSearchFriendActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener
{
  private static final String jdField_c_of_type_JavaLangString = HardCodeUtil.a(2131702553);
  volatile int jdField_a_of_type_Int;
  DialogInterface.OnDismissListener jdField_a_of_type_AndroidContentDialogInterface$OnDismissListener = new ConditionSearchFriendActivity.5(this);
  Handler jdField_a_of_type_AndroidOsHandler = new ConditionSearchFriendActivity.7(this);
  View jdField_a_of_type_AndroidViewView;
  Button jdField_a_of_type_AndroidWidgetButton;
  EditText jdField_a_of_type_AndroidWidgetEditText;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  ConditionSearchManager.IConfigListener jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager$IConfigListener = new ConditionSearchFriendActivity.9(this);
  ConditionSearchManager.ISearchListener jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager$ISearchListener = new ConditionSearchFriendActivity.8(this);
  ConditionSearchManager jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager;
  LBSObserver jdField_a_of_type_ComTencentMobileqqAppLBSObserver = new ConditionSearchFriendActivity.10(this);
  BaseAddress jdField_a_of_type_ComTencentMobileqqConditionsearchDataBaseAddress;
  IphonePickerView.IphonePickListener jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView$IphonePickListener = new ConditionSearchFriendActivity.4(this);
  IphonePickerView.PickerViewAdapter jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView$PickerViewAdapter = new ConditionSearchFriendActivity.3(this);
  IphonePickerView jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView;
  FormSimpleItem jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  ActionSheet jdField_a_of_type_ComTencentWidgetActionSheet;
  String jdField_a_of_type_JavaLangString;
  boolean jdField_a_of_type_Boolean = false;
  int[] jdField_a_of_type_ArrayOfInt;
  BaseAddress[] jdField_a_of_type_ArrayOfComTencentMobileqqConditionsearchDataBaseAddress;
  Object[] jdField_a_of_type_ArrayOfJavaLangObject;
  String[] jdField_a_of_type_ArrayOfJavaLangString;
  volatile int jdField_b_of_type_Int;
  View jdField_b_of_type_AndroidViewView;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  FormSimpleItem jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  String jdField_b_of_type_JavaLangString;
  boolean jdField_b_of_type_Boolean = false;
  volatile int jdField_c_of_type_Int;
  View jdField_c_of_type_AndroidViewView;
  TextView jdField_c_of_type_AndroidWidgetTextView;
  FormSimpleItem jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  boolean jdField_c_of_type_Boolean = true;
  volatile int jdField_d_of_type_Int;
  View jdField_d_of_type_AndroidViewView;
  TextView jdField_d_of_type_AndroidWidgetTextView;
  FormSimpleItem jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  boolean jdField_d_of_type_Boolean = true;
  volatile int jdField_e_of_type_Int;
  View jdField_e_of_type_AndroidViewView;
  FormSimpleItem jdField_e_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  volatile int f;
  volatile int g;
  int h;
  int i;
  int j = 0;
  private final int k = 20;
  private int l = 0;
  
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
    int m = this.h;
    if ((m > 0) && (m <= 3))
    {
      if (paramInt == 1)
      {
        if ("不限".equals(this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.a().getText())) {
          this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText(this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.c(b()));
        }
        c(1);
        return;
      }
      if (paramInt == 2)
      {
        if ("不限".equals(this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.a().getText())) {
          this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText(this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.c(b()));
        }
        c(2);
      }
    }
    else if (!"0".equals(this.jdField_b_of_type_JavaLangString))
    {
      Intent localIntent = new Intent(this, CountrySelectActivity.class);
      localIntent.putExtra("key_country_code", this.jdField_b_of_type_JavaLangString);
      localIntent.putExtra("key_no_limit_allow", true);
      if (paramInt == 1)
      {
        startActivityForResult(localIntent, 1003);
        return;
      }
      if (paramInt == 2) {
        startActivityForResult(localIntent, 1004);
      }
    }
    else
    {
      if (!paramBoolean)
      {
        b(paramInt);
        f();
      }
      if (paramInt == 1)
      {
        this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText(this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.c(b()));
        c(1);
        return;
      }
      if (paramInt == 2)
      {
        this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText(this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.c(b()));
        c(2);
      }
    }
  }
  
  private int b(int paramInt)
  {
    int m = 0;
    if ((paramInt >= 0) && (paramInt <= 17)) {
      return 0;
    }
    if (paramInt > 17) {
      m = paramInt - 17;
    }
    return m;
  }
  
  private String b()
  {
    Object localObject1 = new StringBuilder();
    if (!"0".equals(this.jdField_b_of_type_JavaLangString))
    {
      Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqConditionsearchDataBaseAddress;
      if (localObject2 != null)
      {
        ((StringBuilder)localObject1).append(((BaseAddress)localObject2).name);
        ((StringBuilder)localObject1).append("-");
        int m = 0;
        while (m < this.h)
        {
          localObject2 = this.jdField_a_of_type_ArrayOfComTencentMobileqqConditionsearchDataBaseAddress;
          if ((localObject2 != null) && (localObject2[m] != null) && (!"0".equals(localObject2[m].code)))
          {
            ((StringBuilder)localObject1).append(this.jdField_a_of_type_ArrayOfComTencentMobileqqConditionsearchDataBaseAddress[m].name);
            ((StringBuilder)localObject1).append("-");
          }
          m += 1;
        }
      }
    }
    localObject1 = ((StringBuilder)localObject1).toString();
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      return "不限";
    }
    return ((String)localObject1).substring(0, ((String)localObject1).length() - 1);
  }
  
  private void b(int paramInt)
  {
    int m = 1;
    Object localObject;
    String[] arrayOfString;
    if (paramInt == 1)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.b();
      this.jdField_b_of_type_JavaLangString = localObject[0];
      if (this.jdField_b_of_type_JavaLangString.equals("0"))
      {
        arrayOfString = this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.a();
        this.jdField_b_of_type_JavaLangString = arrayOfString[0];
        localObject = arrayOfString;
        if (this.jdField_b_of_type_JavaLangString.equals("0"))
        {
          this.jdField_b_of_type_JavaLangString = "1";
          localObject = arrayOfString;
        }
      }
    }
    else if (paramInt == 2)
    {
      arrayOfString = this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.c();
      this.jdField_b_of_type_JavaLangString = arrayOfString[0];
      localObject = arrayOfString;
      if (this.jdField_b_of_type_JavaLangString.equals("0"))
      {
        this.jdField_b_of_type_JavaLangString = "1";
        localObject = arrayOfString;
      }
    }
    else
    {
      localObject = null;
    }
    this.jdField_a_of_type_ArrayOfJavaLangString = new String[] { "0", "0", "0" };
    if (localObject != null)
    {
      int n = localObject.length;
      while (m < n)
      {
        this.jdField_a_of_type_ArrayOfJavaLangString[(m - 1)] = localObject[m];
        m += 1;
      }
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("initLocationCode|type : ");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(", mLocationCountyCode : ");
      ((StringBuilder)localObject).append(this.jdField_b_of_type_JavaLangString);
      QLog.d("ConditionSearchFriendActivity", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  private void c()
  {
    this.jdField_b_of_type_Boolean = getIntent().getBooleanExtra("key_first_req_location", false);
    this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager = ((ConditionSearchManager)this.app.getManager(QQManagerFactory.CONDITION_SEARCH_MANAGER));
    ThreadManager.getSubThreadHandler().post(new ConditionSearchFriendActivity.1(this));
    this.jdField_d_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.c();
    this.jdField_e_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.b();
    if ((this.jdField_e_of_type_Int == ConditionSearchManager.jdField_c_of_type_ArrayOfInt[0]) || (this.jdField_e_of_type_Int == ConditionSearchManager.jdField_c_of_type_ArrayOfInt[1]))
    {
      this.jdField_e_of_type_Int = 0;
      this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.a(this.jdField_e_of_type_Int);
    }
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)findViewById(2131366324));
    this.jdField_a_of_type_AndroidWidgetEditText.setFilters(new InputFilter[] { new InputFilter.LengthFilter(20) });
    Object localObject1 = getResources().getDrawable(2130850688);
    ((Drawable)localObject1).setBounds(0, 0, ((Drawable)localObject1).getIntrinsicWidth(), ((Drawable)localObject1).getIntrinsicHeight());
    this.jdField_a_of_type_AndroidWidgetEditText.setCompoundDrawables((Drawable)localObject1, null, null, null);
    this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(new ConditionSearchFriendActivity.2(this));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131365058));
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131365061));
    this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131365059));
    this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131365060));
    this.jdField_e_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131365062));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131365209));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131367604);
    this.jdField_b_of_type_AndroidViewView = findViewById(2131367606);
    this.jdField_c_of_type_AndroidViewView = findViewById(2131367602);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131366774));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131370653));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131363698));
    d();
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_c_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setLeftIcon(null);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setLeftText(getResources().getString(2131691050));
    localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.a(this.jdField_b_of_type_Int, this.jdField_c_of_type_Int);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText((CharSequence)localObject1);
    Object localObject3;
    if (AppSetting.jdField_d_of_type_Boolean)
    {
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem;
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append(HardCodeUtil.a(2131702559));
      ((StringBuilder)localObject3).append((String)localObject1);
      ((FormSimpleItem)localObject2).setContentDescription(((StringBuilder)localObject3).toString());
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
    this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(0);
    this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem.setLeftIcon(null);
    this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem.setLeftText(getResources().getString(2131691053));
    this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText(ConditionSearchManager.d[this.jdField_e_of_type_Int]);
    if (AppSetting.jdField_d_of_type_Boolean)
    {
      localObject1 = this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(HardCodeUtil.a(2131702550));
      ((StringBuilder)localObject2).append(ConditionSearchManager.d[this.jdField_e_of_type_Int]);
      ((FormSimpleItem)localObject1).setContentDescription(((StringBuilder)localObject2).toString());
    }
    this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setLeftIcon(null);
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setLeftText(getResources().getString(2131691054));
    localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.a(0);
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText(this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.c((String)localObject1));
    if (AppSetting.jdField_d_of_type_Boolean)
    {
      localObject2 = this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem;
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append(HardCodeUtil.a(2131702542));
      ((StringBuilder)localObject3).append((String)localObject1);
      ((FormSimpleItem)localObject2).setContentDescription(((StringBuilder)localObject3).toString());
    }
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
    this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setLeftIcon(null);
    this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setLeftText(getResources().getString(2131691052));
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.a(1);
    this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText(this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.c((String)localObject2));
    if (AppSetting.jdField_d_of_type_Boolean)
    {
      localObject3 = this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(HardCodeUtil.a(2131702556));
      localStringBuilder.append((String)localObject2);
      ((FormSimpleItem)localObject3).setContentDescription(localStringBuilder.toString());
    }
    this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
    this.jdField_e_of_type_ComTencentMobileqqWidgetFormSimpleItem.setLeftIcon(null);
    this.jdField_e_of_type_ComTencentMobileqqWidgetFormSimpleItem.setLeftText(getResources().getString(2131691056));
    this.jdField_e_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText(ConditionSearchManager.jdField_c_of_type_ArrayOfJavaLangString[this.jdField_d_of_type_Int]);
    if (AppSetting.jdField_d_of_type_Boolean)
    {
      localObject2 = this.jdField_e_of_type_ComTencentMobileqqWidgetFormSimpleItem;
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append(HardCodeUtil.a(2131702545));
      ((StringBuilder)localObject3).append(ConditionSearchManager.jdField_c_of_type_ArrayOfJavaLangString[this.jdField_d_of_type_Int]);
      ((FormSimpleItem)localObject2).setContentDescription(((StringBuilder)localObject3).toString());
    }
    this.jdField_e_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    if (AppSetting.jdField_d_of_type_Boolean) {
      this.jdField_a_of_type_AndroidWidgetButton.setContentDescription(getString(2131691129));
    }
    g();
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("init|mIsFirstReqLocation : ");
      ((StringBuilder)localObject2).append(this.jdField_b_of_type_Boolean);
      ((StringBuilder)localObject2).append(", locDesc : ");
      ((StringBuilder)localObject2).append((String)localObject1);
      QLog.d("ConditionSearchFriendActivity", 2, ((StringBuilder)localObject2).toString());
    }
    if ((this.jdField_b_of_type_Boolean) || ("不限".equals(localObject1))) {
      addObserver(this.jdField_a_of_type_ComTencentMobileqqAppLBSObserver);
    }
  }
  
  private void c(int paramInt)
  {
    this.i = paramInt;
    this.jdField_a_of_type_ComTencentWidgetActionSheet = ActionSheet.createMenuSheet(this);
    Object localObject = (DispatchActionMoveScrollView)this.jdField_a_of_type_ComTencentWidgetActionSheet.findViewById(2131361999);
    ((DispatchActionMoveScrollView)localObject).getChildAt(0).setOnClickListener(null);
    ((DispatchActionMoveScrollView)localObject).jdField_a_of_type_Boolean = true;
    ((DispatchActionMoveScrollView)localObject).setBackgroundResource(17170445);
    this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView = ((IphonePickerView)getLayoutInflater().inflate(2131561132, null));
    this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.a(this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView$PickerViewAdapter);
    this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setBackgroundColor(-1118221);
    int n = -1;
    int m;
    if (paramInt == 0)
    {
      paramInt = b(this.jdField_b_of_type_Int);
      m = b(this.jdField_c_of_type_Int);
      this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setSelection(0, paramInt);
      this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setSelection(1, m);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightTextColor(1);
      paramInt = a(this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem);
      m = this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.getHeight();
    }
    else if (paramInt == 3)
    {
      this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setSelection(0, this.jdField_d_of_type_Int);
      this.jdField_e_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightTextColor(1);
      paramInt = a(this.jdField_e_of_type_ComTencentMobileqqWidgetFormSimpleItem);
      m = this.jdField_e_of_type_ComTencentMobileqqWidgetFormSimpleItem.getHeight();
    }
    else
    {
      m = 0;
      while (m < this.h)
      {
        this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setSelection(m, this.jdField_a_of_type_ArrayOfInt[m]);
        m += 1;
      }
      this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.findViewById(2131377144));
      this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
      localObject = this.jdField_a_of_type_ComTencentMobileqqConditionsearchDataBaseAddress;
      if (localObject != null) {
        localObject = ((BaseAddress)localObject).name;
      } else {
        localObject = "中国";
      }
      this.jdField_d_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
      this.jdField_d_of_type_AndroidWidgetTextView.setOnClickListener(this);
      if (AppSetting.jdField_d_of_type_Boolean)
      {
        TextView localTextView = this.jdField_d_of_type_AndroidWidgetTextView;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(HardCodeUtil.a(2131702555));
        localStringBuilder.append((String)localObject);
        localStringBuilder.append(HardCodeUtil.a(2131702552));
        localTextView.setContentDescription(localStringBuilder.toString());
      }
      if (paramInt == 1)
      {
        this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightTextColor(1);
        paramInt = a(this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem);
        m = this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.getHeight();
      }
      else if (paramInt == 2)
      {
        this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightTextColor(1);
        paramInt = a(this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem);
        m = this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.getHeight();
      }
      else
      {
        m = -1;
        paramInt = n;
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setPickListener(this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView$IphonePickListener);
    if (Build.VERSION.SDK_INT >= 11) {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.getWindow().setFlags(16777216, 16777216);
    }
    this.jdField_a_of_type_ComTencentWidgetActionSheet.setActionContentView(this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView, null);
    this.jdField_a_of_type_ComTencentWidgetActionSheet.setOnDismissListener(this.jdField_a_of_type_AndroidContentDialogInterface$OnDismissListener);
    try
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.show();
      this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.post(new ConditionSearchFriendActivity.6(this, paramInt, m));
      return;
    }
    catch (Throwable localThrowable)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ConditionSearchFriendActivity", 2, localThrowable.getMessage());
      }
    }
  }
  
  private void d()
  {
    boolean bool = ThemeImageWrapper.isNightMode();
    int m;
    if (bool) {
      m = 2130839433;
    } else {
      m = 2130849954;
    }
    this.jdField_a_of_type_AndroidViewView.setBackgroundResource(m);
    this.jdField_b_of_type_AndroidViewView.setBackgroundResource(m);
    this.jdField_c_of_type_AndroidViewView.setBackgroundResource(m);
    if (bool) {
      m = 2131167139;
    } else {
      m = 2131167061;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(getResources().getColor(m));
    this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(getResources().getColor(m));
    this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(getResources().getColor(m));
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
    this.jdField_a_of_type_ComTencentMobileqqConditionsearchDataBaseAddress = this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.a(this.jdField_b_of_type_JavaLangString);
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqConditionsearchDataBaseAddress;
    Object localObject2;
    if (localObject1 != null)
    {
      this.h = ((BaseAddress)localObject1).getColumnNember();
      int m = this.h;
      this.jdField_a_of_type_ArrayOfJavaLangObject = new Object[m];
      this.jdField_a_of_type_ArrayOfComTencentMobileqqConditionsearchDataBaseAddress = new BaseAddress[m];
      this.jdField_a_of_type_ArrayOfInt = new int[m];
      if (m == 0) {
        return;
      }
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqConditionsearchDataBaseAddress;
      int i1 = this.jdField_a_of_type_ArrayOfJavaLangString.length;
      m = 0;
      int n = 0;
      while (m < i1)
      {
        if (!"0".equals(this.jdField_a_of_type_ArrayOfJavaLangString[m]))
        {
          localObject2 = this.jdField_a_of_type_ArrayOfJavaLangObject;
          if (n >= localObject2.length) {
            break;
          }
          localObject2[n] = ((BaseAddress)localObject1).getDataList();
          BaseAddress[] arrayOfBaseAddress = this.jdField_a_of_type_ArrayOfComTencentMobileqqConditionsearchDataBaseAddress;
          localObject2 = (BaseAddress)((BaseAddress)localObject1).dataMap.get(this.jdField_a_of_type_ArrayOfJavaLangString[m]);
          arrayOfBaseAddress[n] = localObject2;
          this.jdField_a_of_type_ArrayOfInt[n] = a((ArrayList)this.jdField_a_of_type_ArrayOfJavaLangObject[n], this.jdField_a_of_type_ArrayOfJavaLangString[m]);
          n += 1;
          localObject1 = localObject2;
          if (localObject2 == null) {
            return;
          }
        }
        m += 1;
      }
      if (n < this.h)
      {
        this.jdField_a_of_type_ArrayOfJavaLangObject[n] = ((BaseAddress)localObject1).getDataList();
        this.jdField_a_of_type_ArrayOfComTencentMobileqqConditionsearchDataBaseAddress[n] = ((BaseAddress)((BaseAddress)localObject1).dataMap.get(Integer.valueOf(0)));
        this.jdField_a_of_type_ArrayOfInt[n] = 0;
      }
    }
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("initLocationData|mLocationColumCount : ");
      ((StringBuilder)localObject2).append(this.h);
      ((StringBuilder)localObject2).append(", mLocationCountry.name : ");
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqConditionsearchDataBaseAddress;
      if (localObject1 == null) {
        localObject1 = "null";
      } else {
        localObject1 = ((BaseAddress)localObject1).name;
      }
      ((StringBuilder)localObject2).append((String)localObject1);
      QLog.d("ConditionSearchFriendActivity", 2, ((StringBuilder)localObject2).toString());
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
    else if (this.jdField_a_of_type_Int == 1)
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
    if (AppSetting.jdField_d_of_type_Boolean)
    {
      this.jdField_c_of_type_AndroidViewView.setContentDescription(HardCodeUtil.a(2131702557));
      this.jdField_b_of_type_AndroidViewView.setContentDescription(HardCodeUtil.a(2131702549));
      this.jdField_a_of_type_AndroidViewView.setContentDescription(HardCodeUtil.a(2131702554));
    }
  }
  
  void a()
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("dismissWaittingDialog | type = ");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog);
      QLog.d("ConditionSearchFriendActivity", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
    if ((localObject != null) && (((QQProgressDialog)localObject).isShowing()))
    {
      this.j = 0;
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
      if (QLog.isColorLevel()) {
        QLog.d("ConditionSearchFriendActivity", 2, "dismissWaittingDialog dismiss");
      }
    }
  }
  
  void a(int paramInt)
  {
    int m = this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.a();
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("startSelectAddress|checkUpdate result = ");
      localStringBuilder.append(m);
      QLog.d("ConditionSearchFriendActivity", 2, localStringBuilder.toString());
    }
    boolean bool2 = false;
    boolean bool1 = false;
    if (m != 0)
    {
      m = this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.a(m, true);
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("startSelectAddress|update updateResult = ");
        localStringBuilder.append(m);
        QLog.d("ConditionSearchFriendActivity", 2, localStringBuilder.toString());
      }
      if (m == 2)
      {
        QQToast.a(this, 2131694424, 0).b(getTitleBarHeight());
        return;
      }
      if (m == 0)
      {
        a(paramInt, getString(2131691060));
        this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.c(this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager$IConfigListener);
        return;
      }
      a(paramInt, getString(2131691060));
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1000, 20000L);
      return;
    }
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("startSelectAddress|type : ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(", mNeedInitLocation");
      localStringBuilder.append(this.jdField_d_of_type_Boolean);
      localStringBuilder.append(", mNeedInitHome : ");
      localStringBuilder.append(this.jdField_c_of_type_Boolean);
      localStringBuilder.append(", mLocationColumCount : ");
      localStringBuilder.append(this.h);
      localStringBuilder.append(", mLocationCountyCode : ");
      localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
      QLog.d("ConditionSearchFriendActivity", 2, localStringBuilder.toString());
    }
    if (paramInt == 1)
    {
      if (this.jdField_d_of_type_Boolean)
      {
        b(1);
        f();
        this.jdField_d_of_type_Boolean = false;
        this.jdField_c_of_type_Boolean = true;
        bool1 = true;
      }
      a(paramInt, bool1);
      return;
    }
    if (paramInt == 2)
    {
      bool1 = bool2;
      if (this.jdField_c_of_type_Boolean)
      {
        b(2);
        f();
        this.jdField_c_of_type_Boolean = false;
        this.jdField_d_of_type_Boolean = true;
        bool1 = true;
      }
      a(paramInt, bool1);
    }
  }
  
  void a(int paramInt, String paramString)
  {
    this.j = paramInt;
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this, getTitleBarHeight());
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("showWaitingDialog | type = ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(", str = ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(", dlg=");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog);
      QLog.d("ConditionSearchFriendActivity", 2, localStringBuilder.toString());
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(paramString);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
  }
  
  void b()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      ReportController.b(this.app, "CliOper", "", "", "0X8004241", "0X8004241", 0, 0, "", "", "", "");
      this.jdField_a_of_type_Boolean = false;
    }
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("doOnActivityResult | requestCode = ");
      ((StringBuilder)localObject).append(paramInt1);
      QLog.d("ConditionSearchFriendActivity", 2, ((StringBuilder)localObject).toString());
    }
    if (paramIntent == null) {
      return;
    }
    if (paramInt2 == -1) {
      if (paramInt1 == 1002)
      {
        this.jdField_e_of_type_Int = paramIntent.getIntExtra("param_id", 0);
        this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText(ConditionSearchManager.d[this.jdField_e_of_type_Int]);
        this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.a(this.jdField_e_of_type_Int);
        if (AppSetting.jdField_d_of_type_Boolean)
        {
          paramIntent = this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem;
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(HardCodeUtil.a(2131702544));
          ((StringBuilder)localObject).append(ConditionSearchManager.d[this.jdField_e_of_type_Int]);
          paramIntent.setContentDescription(((StringBuilder)localObject).toString());
        }
      }
      else
      {
        paramIntent = paramIntent.getStringExtra("key_country_code");
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("doOnActivityResult | codes = ");
          ((StringBuilder)localObject).append(paramIntent);
          QLog.d("ConditionSearchFriendActivity", 2, ((StringBuilder)localObject).toString());
        }
        if ((!TextUtils.isEmpty(paramIntent)) && (!paramIntent.equals(this.jdField_b_of_type_JavaLangString)))
        {
          this.jdField_b_of_type_JavaLangString = paramIntent;
          this.jdField_a_of_type_ComTencentMobileqqConditionsearchDataBaseAddress = this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.a(this.jdField_b_of_type_JavaLangString);
          paramIntent = this.jdField_a_of_type_ComTencentMobileqqConditionsearchDataBaseAddress;
          if (paramIntent != null)
          {
            paramInt2 = paramIntent.getColumnNember();
            if ((paramInt2 > 0) && (paramInt2 <= 3))
            {
              e();
              f();
              paramIntent = this.jdField_a_of_type_ComTencentWidgetActionSheet;
              if ((paramIntent != null) && (paramIntent.isShowing()))
              {
                if (this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView == null) {
                  this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView = ((IphonePickerView)getLayoutInflater().inflate(2131561132, null));
                }
                this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.a(this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView$PickerViewAdapter);
                paramInt2 = 0;
              }
              while (paramInt2 < this.h)
              {
                this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.a(paramInt2);
                this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setSelection(paramInt2, 0);
                paramInt2 += 1;
                continue;
                if (paramInt1 == 1003) {
                  c(1);
                } else if (paramInt1 == 1004) {
                  c(2);
                }
              }
              paramIntent = this.jdField_d_of_type_AndroidWidgetTextView;
              if (paramIntent != null)
              {
                paramIntent.setText(this.jdField_a_of_type_ComTencentMobileqqConditionsearchDataBaseAddress.name);
                if (AppSetting.jdField_d_of_type_Boolean)
                {
                  paramIntent = this.jdField_d_of_type_AndroidWidgetTextView;
                  localObject = new StringBuilder();
                  ((StringBuilder)localObject).append(HardCodeUtil.a(2131702543));
                  ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqConditionsearchDataBaseAddress.name);
                  ((StringBuilder)localObject).append(HardCodeUtil.a(2131702546));
                  paramIntent.setContentDescription(((StringBuilder)localObject).toString());
                }
              }
            }
            else
            {
              e();
              f();
              paramIntent = this.jdField_a_of_type_ComTencentWidgetActionSheet;
              if ((paramIntent != null) && (paramIntent.isShowing()))
              {
                this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
              }
              else
              {
                paramIntent = new String[4];
                paramIntent[0] = this.jdField_b_of_type_JavaLangString;
                localObject = this.jdField_a_of_type_ArrayOfJavaLangString;
                paramIntent[1] = localObject[0];
                paramIntent[2] = localObject[1];
                paramIntent[3] = localObject[2];
                localObject = b();
                if (paramInt1 == 1003)
                {
                  this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.a(0, (String)localObject);
                  this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.b(paramIntent);
                }
                else if (paramInt1 == 1004)
                {
                  this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.a(1, (String)localObject);
                  this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.c(paramIntent);
                }
              }
            }
            if (paramInt1 == 1003)
            {
              this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText(this.jdField_a_of_type_ComTencentMobileqqConditionsearchDataBaseAddress.name);
              if (AppSetting.jdField_d_of_type_Boolean)
              {
                paramIntent = this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem;
                localObject = new StringBuilder();
                ((StringBuilder)localObject).append(HardCodeUtil.a(2131702539));
                ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqConditionsearchDataBaseAddress.name);
                paramIntent.setContentDescription(((StringBuilder)localObject).toString());
              }
            }
            else if (paramInt1 == 1004)
            {
              this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText(this.jdField_a_of_type_ComTencentMobileqqConditionsearchDataBaseAddress.name);
              if (AppSetting.jdField_d_of_type_Boolean)
              {
                paramIntent = this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem;
                localObject = new StringBuilder();
                ((StringBuilder)localObject).append(HardCodeUtil.a(2131702558));
                ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqConditionsearchDataBaseAddress.name);
                paramIntent.setContentDescription(((StringBuilder)localObject).toString());
              }
            }
          }
        }
      }
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2131561013);
    this.jdField_d_of_type_AndroidViewView = findViewById(2131376809);
    this.jdField_e_of_type_AndroidViewView = findViewById(2131368832);
    setContentBackgroundResource(2130838739);
    this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager = ((ConditionSearchManager)this.app.getManager(QQManagerFactory.CONDITION_SEARCH_MANAGER));
    setTitle(2131691043);
    c();
    return true;
  }
  
  protected void doOnDestroy()
  {
    b();
    super.doOnDestroy();
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.b(this);
    this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.d(this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager$IConfigListener);
    this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.d(this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager$ISearchListener);
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppLBSObserver);
  }
  
  protected void doOnStart()
  {
    super.doOnStart();
    ConditionSearchManager localConditionSearchManager = this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager;
    if (localConditionSearchManager != null) {
      localConditionSearchManager.a(this);
    }
  }
  
  public void onClick(View paramView)
  {
    b();
    int m = paramView.getId();
    Object localObject1;
    switch (m)
    {
    default: 
      Object localObject2;
      switch (m)
      {
      default: 
        break;
      case 2131377144: 
        localObject1 = new Intent(this, CountrySelectActivity.class);
        ((Intent)localObject1).putExtra("key_country_code", this.jdField_b_of_type_JavaLangString);
        ((Intent)localObject1).putExtra("key_no_limit_allow", true);
        m = this.i;
        if (m == 1) {
          startActivityForResult((Intent)localObject1, 1003);
        } else if (m == 2) {
          startActivityForResult((Intent)localObject1, 1004);
        }
        break;
      case 2131367606: 
        this.jdField_a_of_type_Int = 1;
        g();
        this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.c(this.jdField_a_of_type_Int);
        localObject1 = this.app;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(this.jdField_a_of_type_Int);
        ((StringBuilder)localObject2).append("");
        ReportController.b((AppRuntime)localObject1, "CliOper", "", "", "0X8004242", "0X8004242", 0, 0, ((StringBuilder)localObject2).toString(), "", "", "");
        break;
      case 2131367604: 
        this.jdField_a_of_type_Int = 2;
        g();
        this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.c(this.jdField_a_of_type_Int);
        localObject1 = this.app;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(this.jdField_a_of_type_Int);
        ((StringBuilder)localObject2).append("");
        ReportController.b((AppRuntime)localObject1, "CliOper", "", "", "0X8004242", "0X8004242", 0, 0, ((StringBuilder)localObject2).toString(), "", "", "");
        break;
      case 2131367602: 
        this.jdField_a_of_type_Int = 0;
        g();
        this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.c(this.jdField_a_of_type_Int);
        localObject1 = this.app;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(this.jdField_a_of_type_Int);
        ((StringBuilder)localObject2).append("");
        ReportController.b((AppRuntime)localObject1, "CliOper", "", "", "0X8004242", "0X8004242", 0, 0, ((StringBuilder)localObject2).toString(), "", "", "");
        break;
      case 2131365209: 
        ReportController.b(this.app, "CliOper", "", "", "0X800424B", "0X800424B", 0, 0, "", "", "", "");
        if (!NetworkUtil.isNetSupport(this))
        {
          QQToast.a(this, 2131694424, 0).b(getTitleBarHeight());
        }
        else
        {
          this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidWidgetEditText.getText().toString();
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.b();
          localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.c();
          this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.c(this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager$ISearchListener);
          this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.a(true, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, this.jdField_c_of_type_Int, (String[])localObject1, (String[])localObject2, this.jdField_e_of_type_Int, this.jdField_d_of_type_Int, 1);
          a(3, getString(2131691061));
        }
        break;
      }
      break;
    case 2131365062: 
      c(3);
      break;
    case 2131365061: 
      this.jdField_b_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.a();
      ReportController.b(this.app, "CliOper", "", "", "0X8004244", "0X8004244", 0, 0, "", "", "", "");
      a(1);
      break;
    case 2131365060: 
      localObject1 = new Intent(this, JobSelectionActivity.class);
      ((Intent)localObject1).putExtra("param_id", this.jdField_e_of_type_Int);
      ((Intent)localObject1).putExtra("param_from_consearch", true);
      ((Intent)localObject1).putExtra("param_need_no_limit", true);
      startActivityForResult((Intent)localObject1, 1002);
      break;
    case 2131365059: 
      ReportController.b(this.app, "CliOper", "", "", "0X8004245", "0X8004245", 0, 0, "", "", "", "");
      a(2);
      break;
    case 2131365058: 
      c(0);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.conditionsearch.ConditionSearchFriendActivity
 * JD-Core Version:    0.7.0.1
 */