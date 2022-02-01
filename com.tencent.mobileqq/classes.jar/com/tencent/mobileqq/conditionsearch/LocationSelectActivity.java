package com.tencent.mobileqq.conditionsearch;

import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.LbsBaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.ConditionSearchManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.LBSHandler;
import com.tencent.mobileqq.app.LBSObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.conditionsearch.data.BaseAddress;
import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView;
import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView.IphonePickListener;
import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView.PickerViewAdapter;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.DispatchActionMoveScrollView;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.MultiImageTextView;
import java.util.ArrayList;
import java.util.LinkedHashMap;

public class LocationSelectActivity
  extends LbsBaseActivity
  implements View.OnClickListener
{
  int jdField_a_of_type_Int = 0;
  long jdField_a_of_type_Long = 0L;
  DialogInterface.OnDismissListener jdField_a_of_type_AndroidContentDialogInterface$OnDismissListener = new LocationSelectActivity.7(this);
  Handler jdField_a_of_type_AndroidOsHandler = new LocationSelectActivity.5(this);
  ConditionSearchManager jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager;
  private LBSObserver jdField_a_of_type_ComTencentMobileqqAppLBSObserver = new LocationSelectActivity.6(this);
  private BaseAddress jdField_a_of_type_ComTencentMobileqqConditionsearchDataBaseAddress;
  IphonePickerView.IphonePickListener jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView$IphonePickListener = new LocationSelectActivity.4(this);
  IphonePickerView.PickerViewAdapter jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView$PickerViewAdapter = new LocationSelectActivity.3(this);
  IphonePickerView jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView;
  private FormSimpleItem jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  ActionSheet jdField_a_of_type_ComTencentWidgetActionSheet;
  String jdField_a_of_type_JavaLangString = "1";
  private boolean jdField_a_of_type_Boolean;
  int[] jdField_a_of_type_ArrayOfInt;
  BaseAddress[] jdField_a_of_type_ArrayOfComTencentMobileqqConditionsearchDataBaseAddress;
  Object[] jdField_a_of_type_ArrayOfJavaLangObject;
  String[] jdField_a_of_type_ArrayOfJavaLangString;
  final int jdField_b_of_type_Int = 1000;
  private FormSimpleItem jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  private FormSimpleItem jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  
  private int a(ArrayList<? extends BaseAddress> paramArrayList, String paramString)
  {
    int j = paramArrayList.size();
    int i = 0;
    while (i < j)
    {
      if (((BaseAddress)paramArrayList.get(i)).code.equals(paramString)) {
        return i;
      }
      i += 1;
    }
    return 0;
  }
  
  private String a()
  {
    Object localObject = new StringBuilder();
    int i = 0;
    while (i < this.jdField_a_of_type_Int)
    {
      BaseAddress[] arrayOfBaseAddress = this.jdField_a_of_type_ArrayOfComTencentMobileqqConditionsearchDataBaseAddress;
      if ((arrayOfBaseAddress != null) && (arrayOfBaseAddress[i] != null) && (!"0".equals(arrayOfBaseAddress[i].code)))
      {
        ((StringBuilder)localObject).append(this.jdField_a_of_type_ArrayOfComTencentMobileqqConditionsearchDataBaseAddress[i].name);
        ((StringBuilder)localObject).append("-");
      }
      i += 1;
    }
    localObject = ((StringBuilder)localObject).toString();
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      return "不限";
    }
    return ((String)localObject).substring(0, ((String)localObject).length() - 1);
  }
  
  private void a()
  {
    this.jdField_a_of_type_ArrayOfJavaLangString = new String[] { "0", "0", "0" };
    this.jdField_a_of_type_ArrayOfComTencentMobileqqConditionsearchDataBaseAddress = null;
  }
  
  private void a(FormSimpleItem paramFormSimpleItem, String paramString)
  {
    String str = paramString;
    if (!TextUtils.isEmpty(paramString))
    {
      str = paramString;
      if (paramString.equals("不限")) {
        str = "";
      }
    }
    paramFormSimpleItem.setRightText(str);
  }
  
  private void a(FormSimpleItem paramFormSimpleItem, boolean paramBoolean)
  {
    if (paramFormSimpleItem != null)
    {
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setEnabled(paramBoolean);
      paramFormSimpleItem = this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem;
      int i;
      if (!paramBoolean) {
        i = 2;
      } else {
        i = 0;
      }
      paramFormSimpleItem.setLeftTextColor(i);
    }
    if ((!paramBoolean) && (AppSetting.d)) {
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(HardCodeUtil.a(2131706393));
    }
  }
  
  private void a(String[] paramArrayOfString)
  {
    Intent localIntent = new Intent("action_get_lbs_location");
    localIntent.putExtra("code", paramArrayOfString);
    ConditionSearchManager localConditionSearchManager = this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager;
    if (localConditionSearchManager != null)
    {
      paramArrayOfString = localConditionSearchManager.a(paramArrayOfString);
      if (paramArrayOfString != null) {
        localIntent.putExtra("location", paramArrayOfString);
      }
    }
    if ((getIntent() != null) && (getIntent().hasExtra("select_location_broadcast_callback"))) {
      localIntent.putExtra("select_location_broadcast_callback", getIntent().getIntExtra("select_location_broadcast_callback", 0));
    }
    sendBroadcast(localIntent);
  }
  
  private String[] a()
  {
    String[] arrayOfString = new String[3];
    int i = 0;
    arrayOfString[0] = "0";
    arrayOfString[1] = "0";
    arrayOfString[2] = "0";
    BaseAddress[] arrayOfBaseAddress = this.jdField_a_of_type_ArrayOfComTencentMobileqqConditionsearchDataBaseAddress;
    if (arrayOfBaseAddress != null)
    {
      int j = arrayOfBaseAddress.length;
      while (i < j)
      {
        BaseAddress localBaseAddress = arrayOfBaseAddress[i];
        if (localBaseAddress == null) {
          break;
        }
        arrayOfString[(localBaseAddress.addressType - 1)] = String.valueOf(ConditionSearchManager.a(localBaseAddress.code));
        i += 1;
      }
    }
    return arrayOfString;
  }
  
  private String b()
  {
    String str = a();
    if (!"不限".equals(str)) {
      return str;
    }
    return "";
  }
  
  private void b()
  {
    String[] arrayOfString = getIntent().getStringArrayExtra("param_location");
    if (arrayOfString != null)
    {
      a();
      if ((this.jdField_c_of_type_Int == 0) && (this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.b()) && ((arrayOfString == null) || (arrayOfString[0].equals("0")))) {
        return;
      }
      this.jdField_a_of_type_JavaLangString = arrayOfString[0];
      int j = arrayOfString.length;
      int i = 1;
      while (i < j)
      {
        this.jdField_a_of_type_ArrayOfJavaLangString[(i - 1)] = arrayOfString[i];
        i += 1;
      }
    }
  }
  
  private void c()
  {
    this.jdField_a_of_type_ComTencentMobileqqConditionsearchDataBaseAddress = this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.a(this.jdField_a_of_type_JavaLangString);
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqConditionsearchDataBaseAddress;
    if (localObject == null) {
      return;
    }
    if (localObject != null)
    {
      this.jdField_a_of_type_Int = ((BaseAddress)localObject).getColumnNember();
      localObject = this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem;
      if (localObject != null)
      {
        if (this.jdField_a_of_type_Int == 0)
        {
          a((FormSimpleItem)localObject, false);
          return;
        }
        a((FormSimpleItem)localObject, true);
      }
      int i = this.jdField_a_of_type_Int;
      this.jdField_a_of_type_ArrayOfJavaLangObject = new Object[i];
      this.jdField_a_of_type_ArrayOfComTencentMobileqqConditionsearchDataBaseAddress = new BaseAddress[i];
      this.jdField_a_of_type_ArrayOfInt = new int[i];
      if (i == 0) {
        return;
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqConditionsearchDataBaseAddress;
      int k = this.jdField_a_of_type_ArrayOfJavaLangString.length;
      i = 0;
      int j = 0;
      while (i < k)
      {
        if (!"0".equals(this.jdField_a_of_type_ArrayOfJavaLangString[i]))
        {
          this.jdField_a_of_type_ArrayOfJavaLangObject[j] = ((BaseAddress)localObject).getDataList();
          BaseAddress[] arrayOfBaseAddress = this.jdField_a_of_type_ArrayOfComTencentMobileqqConditionsearchDataBaseAddress;
          BaseAddress localBaseAddress = (BaseAddress)((BaseAddress)localObject).dataMap.get(this.jdField_a_of_type_ArrayOfJavaLangString[i]);
          arrayOfBaseAddress[j] = localBaseAddress;
          this.jdField_a_of_type_ArrayOfInt[j] = a((ArrayList)this.jdField_a_of_type_ArrayOfJavaLangObject[j], this.jdField_a_of_type_ArrayOfJavaLangString[i]);
          j += 1;
          localObject = localBaseAddress;
          if (localBaseAddress == null) {
            return;
          }
        }
        i += 1;
      }
      if (j == 0)
      {
        this.jdField_a_of_type_ArrayOfJavaLangObject[j] = ((BaseAddress)localObject).getDataList();
        this.jdField_a_of_type_ArrayOfComTencentMobileqqConditionsearchDataBaseAddress[j] = ((BaseAddress)((BaseAddress)localObject).dataMap.get(Integer.valueOf(0)));
        return;
      }
      try
      {
        if (j < this.jdField_a_of_type_Int)
        {
          this.jdField_a_of_type_ArrayOfJavaLangObject[j] = ((BaseAddress)localObject).getDataList();
          return;
        }
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.d("LocationSelectActivity", 2, "", localException);
        }
      }
    }
  }
  
  private void d()
  {
    this.jdField_b_of_type_Boolean = getIntent().getBooleanExtra("param_is_popup", true);
    if (this.jdField_b_of_type_Boolean)
    {
      setRightHighlightButton(2131692486, new LocationSelectActivity.1(this));
      enableRightHighlight(true);
      this.leftView.setVisibility(8);
    }
    else
    {
      setLeftViewName(2131690529);
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131365065));
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131365064));
    this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131365066));
    int i = this.jdField_c_of_type_Int;
    if ((i != 0) && (i != 2))
    {
      setTitle(2131691052);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(8);
    }
    else
    {
      setTitle(2131691054);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setLeftIcon(null);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setLeftText(getResources().getString(2131691059));
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setLeftTextColor(1);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.a(false);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
      if (AppSetting.d) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(HardCodeUtil.a(2131706389));
      }
    }
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setLeftIcon(null);
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setLeftText(getResources().getString(2131691051));
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqConditionsearchDataBaseAddress;
    if (localObject1 != null)
    {
      if (localObject1 != null) {
        localObject1 = ((BaseAddress)localObject1).name;
      } else {
        localObject1 = HardCodeUtil.a(2131706391);
      }
    }
    else {
      localObject1 = null;
    }
    a(this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem, (String)localObject1);
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
    Object localObject2;
    if (AppSetting.d)
    {
      localObject2 = this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(HardCodeUtil.a(2131706387));
      localStringBuilder.append((String)localObject1);
      ((FormSimpleItem)localObject2).setContentDescription(localStringBuilder.toString());
    }
    this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setLeftIcon(null);
    this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setLeftText(getResources().getString(2131691055));
    this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
    if (this.jdField_a_of_type_Int == 0)
    {
      a(this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem, false);
      return;
    }
    a(this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem, true);
    this.jdField_b_of_type_JavaLangString = getIntent().getStringExtra("param_location_param");
    localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.a(this.jdField_b_of_type_JavaLangString);
    if (localObject1[0].equals(this.jdField_a_of_type_ComTencentMobileqqConditionsearchDataBaseAddress.name)) {
      this.jdField_b_of_type_JavaLangString = localObject1[1];
    }
    a(this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem, this.jdField_b_of_type_JavaLangString);
    if (AppSetting.d)
    {
      localObject1 = this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(HardCodeUtil.a(2131706385));
      ((StringBuilder)localObject2).append(this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.a().getText());
      ((FormSimpleItem)localObject1).setContentDescription(((StringBuilder)localObject2).toString());
    }
  }
  
  private void e()
  {
    if (!NetworkUtil.isNetSupport(this))
    {
      QQToast.a(this, 2131694424, 0).b(getTitleBarHeight());
      return;
    }
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppLBSObserver);
    ((LBSHandler)this.app.getBusinessHandler(BusinessHandlerFactory.LBS_HANDLER)).b();
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setLeftTextColor(2);
    Drawable localDrawable = getResources().getDrawable(2130839406);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(localDrawable);
    ((Animatable)localDrawable).start();
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setEnabled(false);
  }
  
  private void f()
  {
    this.jdField_a_of_type_ComTencentWidgetActionSheet = ActionSheet.createMenuSheet(this);
    DispatchActionMoveScrollView localDispatchActionMoveScrollView = (DispatchActionMoveScrollView)this.jdField_a_of_type_ComTencentWidgetActionSheet.findViewById(2131361999);
    localDispatchActionMoveScrollView.jdField_a_of_type_Boolean = true;
    localDispatchActionMoveScrollView.setBackgroundResource(17170445);
    this.jdField_a_of_type_ComTencentWidgetActionSheet.setOnDismissListener(this.jdField_a_of_type_AndroidContentDialogInterface$OnDismissListener);
    this.jdField_a_of_type_ComTencentWidgetActionSheet.setCloseAutoRead(true);
    this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView = ((IphonePickerView)getLayoutInflater().inflate(2131561132, null));
    this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.a(this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView$PickerViewAdapter);
    int i = 0;
    while (i < this.jdField_a_of_type_Int)
    {
      this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setSelection(i, this.jdField_a_of_type_ArrayOfInt[i]);
      i += 1;
    }
    this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setPickListener(this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView$IphonePickListener);
    if (Build.VERSION.SDK_INT >= 11) {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.getWindow().setFlags(16777216, 16777216);
    }
    this.jdField_a_of_type_ComTencentWidgetActionSheet.setActionContentView(this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView, null);
    try
    {
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentWidgetActionSheet.show();
    }
    catch (Throwable localThrowable)
    {
      if (QLog.isColorLevel()) {
        QLog.d("LocationSelectActivity", 2, localThrowable.getMessage());
      }
      this.jdField_a_of_type_Boolean = true;
    }
    this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightTextColor(1);
  }
  
  void a(boolean paramBoolean, String[] paramArrayOfString)
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem;
    int i = 1;
    ((FormSimpleItem)localObject1).setLeftTextColor(1);
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem;
    localObject1 = null;
    ((FormSimpleItem)localObject2).setRightIcon(null);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setEnabled(true);
    int j = 0;
    if ((paramBoolean) && (paramArrayOfString != null) && (paramArrayOfString.length == 4))
    {
      if (this.jdField_a_of_type_Boolean)
      {
        if (!TextUtils.isEmpty(paramArrayOfString[0])) {
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.a(paramArrayOfString[0]);
        }
        if (localObject1 != null)
        {
          this.jdField_a_of_type_JavaLangString = paramArrayOfString[0];
          a();
          int m = paramArrayOfString.length;
          while (i < m)
          {
            int k = j;
            if (!TextUtils.isEmpty(paramArrayOfString[i]))
            {
              this.jdField_a_of_type_ArrayOfJavaLangString[j] = paramArrayOfString[i];
              k = j + 1;
            }
            i += 1;
            j = k;
          }
          c();
          a(this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem, this.jdField_a_of_type_ComTencentMobileqqConditionsearchDataBaseAddress.name);
          paramArrayOfString = this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem;
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(HardCodeUtil.a(2131706388));
          ((StringBuilder)localObject1).append(this.jdField_a_of_type_ComTencentMobileqqConditionsearchDataBaseAddress.name);
          paramArrayOfString.setContentDescription(((StringBuilder)localObject1).toString());
          if (this.jdField_a_of_type_Int == 0) {
            paramArrayOfString = "";
          } else {
            paramArrayOfString = a();
          }
          a(this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem, paramArrayOfString);
          localObject1 = this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem;
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(HardCodeUtil.a(2131706390));
          ((StringBuilder)localObject2).append(paramArrayOfString);
          ((FormSimpleItem)localObject1).setContentDescription(((StringBuilder)localObject2).toString());
          return;
        }
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("invalid country code!! | cournty code is :");
          ((StringBuilder)localObject1).append(paramArrayOfString[0]);
          QLog.d("LocationSelectActivity", 2, ((StringBuilder)localObject1).toString());
        }
      }
    }
    else {
      QQToast.a(this, 2131691048, 0).b(getTitleBarHeight());
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
    if ((paramInt1 == 1000) && (paramInt2 == -1))
    {
      paramIntent = paramIntent.getStringExtra("key_country_code");
      if ((!TextUtils.isEmpty(paramIntent)) && (!paramIntent.equals(this.jdField_a_of_type_JavaLangString)))
      {
        if (this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.a(paramIntent) == null)
        {
          if (QLog.isColorLevel())
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("doOnActivityResult | should not be here, can not get country by code ! result code = ");
            localStringBuilder.append(paramIntent);
            QLog.d("LocationSelectActivity", 2, localStringBuilder.toString());
          }
          return;
        }
        this.jdField_a_of_type_JavaLangString = paramIntent;
        a();
        c();
        a(this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem, this.jdField_a_of_type_ComTencentMobileqqConditionsearchDataBaseAddress.name);
        if (this.jdField_a_of_type_Int == 0) {
          paramIntent = "";
        } else {
          paramIntent = "不限";
        }
        a(this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem, paramIntent);
        if (AppSetting.d)
        {
          paramIntent = this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(HardCodeUtil.a(2131706392));
          localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqConditionsearchDataBaseAddress.name);
          paramIntent.setContentDescription(localStringBuilder.toString());
          paramIntent = this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(HardCodeUtil.a(2131706386));
          localStringBuilder.append(this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.a().getText());
          paramIntent.setContentDescription(localStringBuilder.toString());
        }
        if (this.jdField_c_of_type_Int == 0)
        {
          paramIntent = this.app;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(ConditionSearchManager.a(this.jdField_a_of_type_JavaLangString));
          localStringBuilder.append("");
          ReportController.b(paramIntent, "CliOper", "", "", "0X8004247", "0X8004247", 0, 0, localStringBuilder.toString(), "", "", "");
          return;
        }
        paramIntent = this.app;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(ConditionSearchManager.a(this.jdField_a_of_type_JavaLangString));
        localStringBuilder.append("");
        ReportController.b(paramIntent, "CliOper", "", "", "0X8004249", "0X8004249", 0, 0, localStringBuilder.toString(), "", "", "");
      }
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.jdField_c_of_type_Int = getIntent().getIntExtra("param_req_type", 0);
    setContentBackgroundResource(2130838739);
    setContentView(2131561156);
    this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager = ((ConditionSearchManager)this.app.getManager(QQManagerFactory.CONDITION_SEARCH_MANAGER));
    b();
    c();
    d();
    return true;
  }
  
  protected void doOnDestroy()
  {
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppLBSObserver);
    super.doOnDestroy();
  }
  
  protected int getContentTipsForEnableLbs()
  {
    return 2131691045;
  }
  
  protected boolean onBackEvent()
  {
    Intent localIntent = new Intent();
    String[] arrayOfString = new String[4];
    arrayOfString[0] = this.jdField_a_of_type_JavaLangString;
    arrayOfString[1] = "0";
    arrayOfString[2] = "0";
    arrayOfString[3] = "0";
    Object localObject = this.jdField_a_of_type_ArrayOfComTencentMobileqqConditionsearchDataBaseAddress;
    int i;
    if (localObject != null)
    {
      int j = localObject.length;
      i = 0;
      while (i < j)
      {
        localObject = this.jdField_a_of_type_ArrayOfComTencentMobileqqConditionsearchDataBaseAddress;
        if (localObject[i] == null) {
          break;
        }
        arrayOfString[localObject[i].addressType] = this.jdField_a_of_type_ArrayOfComTencentMobileqqConditionsearchDataBaseAddress[i].code;
        i += 1;
      }
    }
    localIntent.putExtra("param_location", arrayOfString);
    localObject = b();
    if (this.jdField_a_of_type_ComTencentMobileqqConditionsearchDataBaseAddress != null)
    {
      if (TextUtils.isEmpty((CharSequence)localObject))
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqConditionsearchDataBaseAddress.name;
      }
      else
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqConditionsearchDataBaseAddress.name);
        ((StringBuilder)localObject).append("-");
        ((StringBuilder)localObject).append(a());
        localObject = ((StringBuilder)localObject).toString();
      }
      localIntent.putExtra("param_location_param", (String)localObject);
    }
    else
    {
      i = this.jdField_c_of_type_Int;
      if ((i != 2) && (i != 3)) {
        localObject = "不限";
      } else {
        localObject = "";
      }
      localIntent.putExtra("param_location_param", (String)localObject);
    }
    a(arrayOfString);
    setResult(-1, localIntent);
    finish();
    if (this.jdField_b_of_type_Boolean) {
      overridePendingTransition(0, 2130771992);
    }
    return false;
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    boolean bool2 = true;
    switch (i)
    {
    default: 
      break;
    case 2131365066: 
      f();
      break;
    case 2131365065: 
      ReportController.b(this.app, "CliOper", "", "", "0X8004246", "0X8004246", 0, 0, "", "", "", "");
      this.jdField_a_of_type_Boolean = true;
      checkAndEnableLbs(new LocationSelectActivity.2(this));
      break;
    case 2131365064: 
      Intent localIntent = new Intent(this, CountrySelectActivity.class);
      localIntent.putExtra("key_country_code", this.jdField_a_of_type_JavaLangString);
      i = this.jdField_c_of_type_Int;
      boolean bool1 = bool2;
      if (i != 1) {
        if (i == 0) {
          bool1 = bool2;
        } else {
          bool1 = false;
        }
      }
      localIntent.putExtra("key_no_limit_allow", bool1);
      startActivityForResult(localIntent, 1000);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  protected void onLBSForbidden() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.conditionsearch.LocationSelectActivity
 * JD-Core Version:    0.7.0.1
 */