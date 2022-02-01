package com.tencent.mobileqq.widget;

import android.text.TextUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.CfgProcess;
import com.tencent.mobileqq.config.CfgProcess.CfgParseResult;
import com.tencent.mobileqq.config.CfgProcess.OnGetConfigListener;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class ProfileConfigHelper
  implements CfgProcess.OnGetConfigListener
{
  private static final int[] jdField_a_of_type_ArrayOfInt = { 0, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 0, 1, 1 };
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private ProfileConfigHelper.OnConfigUpdateListener jdField_a_of_type_ComTencentMobileqqWidgetProfileConfigHelper$OnConfigUpdateListener;
  private String jdField_a_of_type_JavaLangString = null;
  private final Boolean[] jdField_a_of_type_ArrayOfJavaLangBoolean = new Boolean[15];
  
  public ProfileConfigHelper(QQAppInterface paramQQAppInterface, ProfileConfigHelper.OnConfigUpdateListener paramOnConfigUpdateListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqWidgetProfileConfigHelper$OnConfigUpdateListener = paramOnConfigUpdateListener;
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getConfigProcess().a("profile_btn_config", this);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getConfigProcess().a("profile_switch_config", this);
    }
  }
  
  private void a(String paramString)
  {
    int[] arrayOfInt = new int[15];
    int i = 0;
    while (i < 15)
    {
      arrayOfInt[i] = jdField_a_of_type_ArrayOfInt[i];
      i += 1;
    }
    label522:
    label527:
    try
    {
      if (!TextUtils.isEmpty(paramString)) {
        break label534;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
        break label367;
      }
      localObject = "";
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        Object localObject;
        label367:
        localException1 = localException1;
        QLog.e("ProfileConfigHelper", 1, "initProfileSwitchConfig fail.", localException1);
        i = 0;
        if (i < 15)
        {
          arrayOfBoolean = this.jdField_a_of_type_ArrayOfJavaLangBoolean;
          if (arrayOfInt[i] == 1) {}
          for (bool = true;; bool = false)
          {
            arrayOfBoolean[i] = Boolean.valueOf(bool);
            i += 1;
            break;
          }
        }
      }
    }
    finally
    {
      i = 0;
      if (i >= 15) {
        break label527;
      }
      Boolean[] arrayOfBoolean = this.jdField_a_of_type_ArrayOfJavaLangBoolean;
      if (arrayOfInt[i] != 1) {
        break label522;
      }
      for (boolean bool = true;; bool = false)
      {
        arrayOfBoolean[i] = Boolean.valueOf(bool);
        i += 1;
        break;
      }
    }
    localObject = CfgProcess.a((String)localObject, "profile_switch_config");
    paramString = (String)localObject;
    label534:
    for (;;) {}
  }
  
  private void b(String paramString)
  {
    Object localObject3 = null;
    Object localObject4 = null;
    label165:
    for (;;)
    {
      try
      {
        if (!TextUtils.isEmpty(paramString)) {
          break label165;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)
        {
          str = "";
          str = CfgProcess.a(str, "profile_btn_config");
          paramString = str;
        }
      }
      catch (Exception localException1)
      {
        String str;
        localException1.printStackTrace();
        Object localObject1 = localObject4;
        if (TextUtils.isEmpty(null)) {
          localObject1 = HardCodeUtil.a(2131708430);
        }
        this.jdField_a_of_type_JavaLangString = ((String)localObject1);
        continue;
      }
      finally
      {
        paramString = (String)localObject3;
        if (TextUtils.isEmpty(null)) {
          paramString = HardCodeUtil.a(2131708430);
        }
        this.jdField_a_of_type_JavaLangString = paramString;
      }
      try
      {
        str = new JSONObject(paramString).optString("call_wording");
        localObject3 = str;
        if (TextUtils.isEmpty(str)) {
          localObject3 = HardCodeUtil.a(2131708430);
        }
        this.jdField_a_of_type_JavaLangString = ((String)localObject3);
        if (QLog.isColorLevel()) {
          QLog.i("ProfileConfigHelper", 2, String.format("initVoiceBtnConfig [str:%s content:%s]", new Object[] { this.jdField_a_of_type_JavaLangString, paramString }));
        }
        return;
      }
      catch (Exception localException2)
      {
        continue;
      }
      str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    }
  }
  
  public String a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      return HardCodeUtil.a(2131708412);
    }
    if (this.jdField_a_of_type_JavaLangString == null) {
      b(null);
    }
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getConfigProcess().a(this);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
    this.jdField_a_of_type_ComTencentMobileqqWidgetProfileConfigHelper$OnConfigUpdateListener = null;
  }
  
  public void a(QQAppInterface paramQQAppInterface, int paramInt, String paramString, CfgProcess.CfgParseResult paramCfgParseResult)
  {
    if (paramCfgParseResult == null) {}
    for (;;)
    {
      return;
      if ("profile_btn_config".equals(paramString)) {
        b(paramCfgParseResult.jdField_a_of_type_JavaLangString);
      }
      while (this.jdField_a_of_type_ComTencentMobileqqWidgetProfileConfigHelper$OnConfigUpdateListener != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetProfileConfigHelper$OnConfigUpdateListener.onConfigUpdate(paramInt, paramString);
        return;
        if ("profile_switch_config".equals(paramString)) {
          a(paramCfgParseResult.jdField_a_of_type_JavaLangString);
        }
      }
    }
  }
  
  public boolean a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {}
    while ((paramInt < 0) || (paramInt >= 15)) {
      return false;
    }
    if (this.jdField_a_of_type_ArrayOfJavaLangBoolean[paramInt] == null) {
      a(null);
    }
    return this.jdField_a_of_type_ArrayOfJavaLangBoolean[paramInt].booleanValue();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.widget.ProfileConfigHelper
 * JD-Core Version:    0.7.0.1
 */