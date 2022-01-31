package com.tencent.mobileqq.conditionsearch;

import ajfw;
import ajjy;
import ajlf;
import ajlg;
import alwv;
import alwx;
import alwy;
import alwz;
import alxa;
import alxb;
import alxp;
import alxq;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.TextView;
import awqx;
import badq;
import bbmy;
import begr;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.LbsBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.conditionsearch.data.BaseAddress;
import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView;
import com.tencent.mobileqq.widget.DispatchActionMoveScrollView;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.MultiImageTextView;
import java.util.ArrayList;
import java.util.LinkedHashMap;

public class LocationSelectActivity
  extends LbsBaseActivity
  implements View.OnClickListener
{
  public int a;
  public long a;
  ajfw jdField_a_of_type_Ajfw;
  private ajlg jdField_a_of_type_Ajlg = new alxa(this);
  alxp jdField_a_of_type_Alxp = new alwy(this);
  alxq jdField_a_of_type_Alxq = new alwx(this);
  DialogInterface.OnDismissListener jdField_a_of_type_AndroidContentDialogInterface$OnDismissListener = new alxb(this);
  public Handler a;
  public begr a;
  private BaseAddress jdField_a_of_type_ComTencentMobileqqConditionsearchDataBaseAddress;
  public IphonePickerView a;
  private FormSimpleItem jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  String jdField_a_of_type_JavaLangString = "1";
  private boolean jdField_a_of_type_Boolean;
  public int[] a;
  public BaseAddress[] a;
  public Object[] a;
  String[] jdField_a_of_type_ArrayOfJavaLangString;
  final int jdField_b_of_type_Int = 1000;
  private FormSimpleItem jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  private FormSimpleItem jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  
  public LocationSelectActivity()
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_AndroidOsHandler = new alwz(this);
  }
  
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
      if ((this.jdField_a_of_type_ArrayOfComTencentMobileqqConditionsearchDataBaseAddress != null) && (this.jdField_a_of_type_ArrayOfComTencentMobileqqConditionsearchDataBaseAddress[i] != null) && (!"0".equals(this.jdField_a_of_type_ArrayOfComTencentMobileqqConditionsearchDataBaseAddress[i].code))) {
        ((StringBuilder)localObject).append(this.jdField_a_of_type_ArrayOfComTencentMobileqqConditionsearchDataBaseAddress[i].name).append("-");
      }
      i += 1;
    }
    localObject = ((StringBuilder)localObject).toString();
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      return "不限";
    }
    return ((String)localObject).substring(0, ((String)localObject).length() - 1);
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
      if (paramBoolean) {
        break label51;
      }
    }
    label51:
    for (int i = 2;; i = 0)
    {
      paramFormSimpleItem.setLeftTextColor(i);
      if ((!paramBoolean) && (AppSetting.c)) {
        this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(ajjy.a(2131640522));
      }
      return;
    }
  }
  
  private String[] a()
  {
    int i = 0;
    String[] arrayOfString = new String[3];
    arrayOfString[0] = "0";
    arrayOfString[1] = "0";
    arrayOfString[2] = "0";
    if (this.jdField_a_of_type_ArrayOfComTencentMobileqqConditionsearchDataBaseAddress != null)
    {
      BaseAddress[] arrayOfBaseAddress = this.jdField_a_of_type_ArrayOfComTencentMobileqqConditionsearchDataBaseAddress;
      int j = arrayOfBaseAddress.length;
      while (i < j)
      {
        BaseAddress localBaseAddress = arrayOfBaseAddress[i];
        if (localBaseAddress == null) {
          break;
        }
        arrayOfString[(localBaseAddress.addressType - 1)] = String.valueOf(ajfw.a(localBaseAddress.code));
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
    this.jdField_a_of_type_ArrayOfJavaLangString = new String[] { "0", "0", "0" };
    this.jdField_a_of_type_ArrayOfComTencentMobileqqConditionsearchDataBaseAddress = null;
  }
  
  private void c()
  {
    String[] arrayOfString = getIntent().getStringArrayExtra("param_location");
    if (arrayOfString != null)
    {
      b();
      if ((this.jdField_c_of_type_Int != 0) || (!this.jdField_a_of_type_Ajfw.b()) || ((arrayOfString != null) && (!arrayOfString[0].equals("0")))) {
        break label51;
      }
    }
    for (;;)
    {
      return;
      label51:
      this.jdField_a_of_type_JavaLangString = arrayOfString[0];
      int i = 1;
      int j = arrayOfString.length;
      while (i < j)
      {
        this.jdField_a_of_type_ArrayOfJavaLangString[(i - 1)] = arrayOfString[i];
        i += 1;
      }
    }
  }
  
  private void d()
  {
    this.jdField_a_of_type_ComTencentMobileqqConditionsearchDataBaseAddress = this.jdField_a_of_type_Ajfw.a(this.jdField_a_of_type_JavaLangString);
    if (this.jdField_a_of_type_ComTencentMobileqqConditionsearchDataBaseAddress == null) {}
    do
    {
      for (;;)
      {
        return;
        if (this.jdField_a_of_type_ComTencentMobileqqConditionsearchDataBaseAddress != null)
        {
          this.jdField_a_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqConditionsearchDataBaseAddress.getColumnNember();
          if (this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem != null)
          {
            if (this.jdField_a_of_type_Int == 0)
            {
              a(this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem, false);
              return;
            }
            a(this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem, true);
          }
          this.jdField_a_of_type_ArrayOfJavaLangObject = new Object[this.jdField_a_of_type_Int];
          this.jdField_a_of_type_ArrayOfComTencentMobileqqConditionsearchDataBaseAddress = new BaseAddress[this.jdField_a_of_type_Int];
          this.jdField_a_of_type_ArrayOfInt = new int[this.jdField_a_of_type_Int];
          if (this.jdField_a_of_type_Int == 0) {
            break;
          }
          Object localObject = this.jdField_a_of_type_ComTencentMobileqqConditionsearchDataBaseAddress;
          int k = this.jdField_a_of_type_ArrayOfJavaLangString.length;
          int j = 0;
          int i = 0;
          if (j < k)
          {
            if ("0".equals(this.jdField_a_of_type_ArrayOfJavaLangString[j])) {}
            BaseAddress localBaseAddress;
            do
            {
              j += 1;
              break;
              this.jdField_a_of_type_ArrayOfJavaLangObject[i] = ((BaseAddress)localObject).getDataList();
              BaseAddress[] arrayOfBaseAddress = this.jdField_a_of_type_ArrayOfComTencentMobileqqConditionsearchDataBaseAddress;
              localBaseAddress = (BaseAddress)((BaseAddress)localObject).dataMap.get(this.jdField_a_of_type_ArrayOfJavaLangString[j]);
              arrayOfBaseAddress[i] = localBaseAddress;
              this.jdField_a_of_type_ArrayOfInt[i] = a((ArrayList)this.jdField_a_of_type_ArrayOfJavaLangObject[i], this.jdField_a_of_type_ArrayOfJavaLangString[j]);
              i += 1;
              localObject = localBaseAddress;
            } while (localBaseAddress != null);
            return;
          }
          if (i == 0)
          {
            this.jdField_a_of_type_ArrayOfJavaLangObject[i] = ((BaseAddress)localObject).getDataList();
            this.jdField_a_of_type_ArrayOfComTencentMobileqqConditionsearchDataBaseAddress[i] = ((BaseAddress)((BaseAddress)localObject).dataMap.get(Integer.valueOf(0)));
            return;
          }
          try
          {
            if (i < this.jdField_a_of_type_Int)
            {
              this.jdField_a_of_type_ArrayOfJavaLangObject[i] = ((BaseAddress)localObject).getDataList();
              return;
            }
          }
          catch (Exception localException) {}
        }
      }
    } while (!QLog.isColorLevel());
    QLog.d("LocationSelectActivity", 2, "", localException);
  }
  
  private void e()
  {
    this.jdField_b_of_type_Boolean = getIntent().getBooleanExtra("param_is_popup", true);
    label183:
    Object localObject;
    if (this.jdField_b_of_type_Boolean)
    {
      setRightHighlightButton(2131626982, new alwv(this));
      enableRightHighlight(true);
      this.leftView.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131299040));
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131299039));
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131299041));
      if ((this.jdField_c_of_type_Int != 0) && (this.jdField_c_of_type_Int != 2)) {
        break label343;
      }
      setTitle(2131625452);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setLeftIcon(null);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setLeftText(getResources().getString(2131625458));
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setLeftTextColor(1);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.a(false);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
      if (AppSetting.c) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(ajjy.a(2131640518));
      }
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setLeftIcon(null);
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setLeftText(getResources().getString(2131625449));
      if (this.jdField_a_of_type_ComTencentMobileqqConditionsearchDataBaseAddress == null) {
        break label488;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqConditionsearchDataBaseAddress == null) {
        break label362;
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqConditionsearchDataBaseAddress.name;
    }
    for (;;)
    {
      label230:
      a(this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem, (String)localObject);
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
      if (AppSetting.c) {
        this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(ajjy.a(2131640516) + (String)localObject);
      }
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setLeftIcon(null);
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setLeftText(getResources().getString(2131625453));
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
      if (this.jdField_a_of_type_Int == 0) {
        a(this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem, false);
      }
      label343:
      label362:
      do
      {
        return;
        setLeftViewName(2131624770);
        break;
        setTitle(2131625450);
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(8);
        break label183;
        localObject = ajjy.a(2131640520);
        break label230;
        a(this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem, true);
        this.jdField_b_of_type_JavaLangString = getIntent().getStringExtra("param_location_param");
        localObject = this.jdField_a_of_type_Ajfw.a(this.jdField_b_of_type_JavaLangString);
        if (localObject[0].equals(this.jdField_a_of_type_ComTencentMobileqqConditionsearchDataBaseAddress.name)) {
          this.jdField_b_of_type_JavaLangString = localObject[1];
        }
        a(this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem, this.jdField_b_of_type_JavaLangString);
      } while (!AppSetting.c);
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(ajjy.a(2131640514) + this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.a().getText());
      return;
      label488:
      localObject = null;
    }
  }
  
  private void f()
  {
    if (!badq.d(this))
    {
      bbmy.a(this, 2131628948, 0).b(getTitleBarHeight());
      return;
    }
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    addObserver(this.jdField_a_of_type_Ajlg);
    ((ajlf)this.app.a(3)).b();
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setLeftTextColor(2);
    Drawable localDrawable = getResources().getDrawable(2130839117);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(localDrawable);
    ((Animatable)localDrawable).start();
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setEnabled(false);
  }
  
  private void g()
  {
    this.jdField_a_of_type_Begr = begr.c(this);
    DispatchActionMoveScrollView localDispatchActionMoveScrollView = (DispatchActionMoveScrollView)this.jdField_a_of_type_Begr.findViewById(2131296387);
    localDispatchActionMoveScrollView.jdField_a_of_type_Boolean = true;
    localDispatchActionMoveScrollView.setBackgroundResource(17170445);
    this.jdField_a_of_type_Begr.setOnDismissListener(this.jdField_a_of_type_AndroidContentDialogInterface$OnDismissListener);
    this.jdField_a_of_type_Begr.d(true);
    this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView = ((IphonePickerView)getLayoutInflater().inflate(2131495228, null));
    this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.a(this.jdField_a_of_type_Alxq);
    int i = 0;
    while (i < this.jdField_a_of_type_Int)
    {
      this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setSelection(i, this.jdField_a_of_type_ArrayOfInt[i]);
      i += 1;
    }
    this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setPickListener(this.jdField_a_of_type_Alxp);
    if (Build.VERSION.SDK_INT >= 11) {
      this.jdField_a_of_type_Begr.getWindow().setFlags(16777216, 16777216);
    }
    this.jdField_a_of_type_Begr.a(this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView, null);
    try
    {
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_Begr.show();
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightTextColor(1);
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("LocationSelectActivity", 2, localThrowable.getMessage());
        }
        this.jdField_a_of_type_Boolean = true;
      }
    }
  }
  
  public int a()
  {
    return 2131625443;
  }
  
  public void a() {}
  
  public void a(boolean paramBoolean, String[] paramArrayOfString)
  {
    BaseAddress localBaseAddress = null;
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setLeftTextColor(1);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(null);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setEnabled(true);
    if ((paramBoolean) && (paramArrayOfString != null) && (paramArrayOfString.length == 4))
    {
      if (this.jdField_a_of_type_Boolean)
      {
        if (!TextUtils.isEmpty(paramArrayOfString[0])) {
          localBaseAddress = this.jdField_a_of_type_Ajfw.a(paramArrayOfString[0]);
        }
        if (localBaseAddress == null) {
          break label253;
        }
        this.jdField_a_of_type_JavaLangString = paramArrayOfString[0];
        b();
        m = paramArrayOfString.length;
        j = 0;
        i = 1;
        while (i < m)
        {
          k = j;
          if (!TextUtils.isEmpty(paramArrayOfString[i]))
          {
            this.jdField_a_of_type_ArrayOfJavaLangString[j] = paramArrayOfString[i];
            k = j + 1;
          }
          i += 1;
          j = k;
        }
        d();
        a(this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem, this.jdField_a_of_type_ComTencentMobileqqConditionsearchDataBaseAddress.name);
        this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(ajjy.a(2131640517) + this.jdField_a_of_type_ComTencentMobileqqConditionsearchDataBaseAddress.name);
        if (this.jdField_a_of_type_Int != 0) {
          break label245;
        }
        paramArrayOfString = "";
        a(this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem, paramArrayOfString);
        this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(ajjy.a(2131640519) + paramArrayOfString);
      }
      label245:
      label253:
      while (!QLog.isColorLevel()) {
        for (;;)
        {
          int m;
          int j;
          int i;
          int k;
          return;
          paramArrayOfString = a();
        }
      }
      QLog.d("LocationSelectActivity", 2, "invalid country code!! | cournty code is :" + paramArrayOfString[0]);
      return;
    }
    bbmy.a(this, 2131625446, 0).b(getTitleBarHeight());
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt1 == 1000) && (paramInt2 == -1))
    {
      paramIntent = paramIntent.getStringExtra("key_country_code");
      if ((!TextUtils.isEmpty(paramIntent)) && (!paramIntent.equals(this.jdField_a_of_type_JavaLangString)))
      {
        if (this.jdField_a_of_type_Ajfw.a(paramIntent) != null) {
          break label83;
        }
        if (QLog.isColorLevel()) {
          QLog.d("LocationSelectActivity", 2, "doOnActivityResult | should not be here, can not get country by code ! result code = " + paramIntent);
        }
      }
    }
    return;
    label83:
    this.jdField_a_of_type_JavaLangString = paramIntent;
    b();
    d();
    a(this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem, this.jdField_a_of_type_ComTencentMobileqqConditionsearchDataBaseAddress.name);
    if (this.jdField_a_of_type_Int == 0) {}
    for (paramIntent = "";; paramIntent = "不限")
    {
      a(this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem, paramIntent);
      if (AppSetting.c)
      {
        this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(ajjy.a(2131640521) + this.jdField_a_of_type_ComTencentMobileqqConditionsearchDataBaseAddress.name);
        this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(ajjy.a(2131640515) + this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.a().getText());
      }
      if (this.jdField_c_of_type_Int != 0) {
        break;
      }
      awqx.b(this.app, "CliOper", "", "", "0X8004247", "0X8004247", 0, 0, ajfw.a(this.jdField_a_of_type_JavaLangString) + "", "", "", "");
      return;
    }
    awqx.b(this.app, "CliOper", "", "", "0X8004249", "0X8004249", 0, 0, ajfw.a(this.jdField_a_of_type_JavaLangString) + "", "", "", "");
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.jdField_c_of_type_Int = getIntent().getIntExtra("param_req_type", 0);
    setContentBackgroundResource(2130838503);
    setContentView(2131495246);
    this.jdField_a_of_type_Ajfw = ((ajfw)this.app.getManager(59));
    c();
    d();
    e();
    return true;
  }
  
  public void doOnDestroy()
  {
    removeObserver(this.jdField_a_of_type_Ajlg);
    super.doOnDestroy();
  }
  
  public boolean onBackEvent()
  {
    Intent localIntent = new Intent();
    Object localObject = new String[4];
    localObject[0] = this.jdField_a_of_type_JavaLangString;
    localObject[1] = "0";
    localObject[2] = "0";
    localObject[3] = "0";
    int i;
    if (this.jdField_a_of_type_ArrayOfComTencentMobileqqConditionsearchDataBaseAddress != null)
    {
      int j = this.jdField_a_of_type_ArrayOfComTencentMobileqqConditionsearchDataBaseAddress.length;
      i = 0;
      if ((i < j) && (this.jdField_a_of_type_ArrayOfComTencentMobileqqConditionsearchDataBaseAddress[i] != null)) {}
    }
    else
    {
      localIntent.putExtra("param_location", (String[])localObject);
      localObject = b();
      if (this.jdField_a_of_type_ComTencentMobileqqConditionsearchDataBaseAddress == null) {
        break label202;
      }
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        break label166;
      }
    }
    label166:
    for (localObject = this.jdField_a_of_type_ComTencentMobileqqConditionsearchDataBaseAddress.name;; localObject = this.jdField_a_of_type_ComTencentMobileqqConditionsearchDataBaseAddress.name + "-" + a())
    {
      localIntent.putExtra("param_location_param", (String)localObject);
      setResult(-1, localIntent);
      finish();
      if (this.jdField_b_of_type_Boolean) {
        overridePendingTransition(0, 2130771978);
      }
      return false;
      localObject[this.jdField_a_of_type_ArrayOfComTencentMobileqqConditionsearchDataBaseAddress[i].addressType] = this.jdField_a_of_type_ArrayOfComTencentMobileqqConditionsearchDataBaseAddress[i].code;
      i += 1;
      break;
    }
    label202:
    if ((this.jdField_c_of_type_Int == 2) || (this.jdField_c_of_type_Int == 3)) {}
    for (localObject = "";; localObject = "不限")
    {
      localIntent.putExtra("param_location_param", (String)localObject);
      break;
    }
  }
  
  public void onClick(View paramView)
  {
    boolean bool = false;
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131299040: 
      awqx.b(this.app, "CliOper", "", "", "0X8004246", "0X8004246", 0, 0, "", "", "", "");
      this.jdField_a_of_type_Boolean = true;
      b(new LocationSelectActivity.2(this));
      return;
    case 2131299039: 
      paramView = new Intent(this, CountrySelectActivity.class);
      paramView.putExtra("key_country_code", this.jdField_a_of_type_JavaLangString);
      if ((this.jdField_c_of_type_Int == 1) || (this.jdField_c_of_type_Int == 0)) {
        bool = true;
      }
      paramView.putExtra("key_no_limit_allow", bool);
      startActivityForResult(paramView, 1000);
      return;
    }
    g();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.conditionsearch.LocationSelectActivity
 * JD-Core Version:    0.7.0.1
 */