package com.tencent.mobileqq.litelivesdk.framework.businessmgr;

import android.text.TextUtils;
import com.tencent.ilive.EnterRoomConfig;
import com.tencent.mobileqq.litelivesdk.api.IBusinessExpireObserver;
import com.tencent.mobileqq.litelivesdk.api.business.BusinessConfig;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;

public class BusinessManager
{
  public static BusinessManager a;
  private long jdField_a_of_type_Long = 0L;
  private EnterRoomConfig jdField_a_of_type_ComTencentIliveEnterRoomConfig;
  private BusinessConfig jdField_a_of_type_ComTencentMobileqqLitelivesdkApiBusinessBusinessConfig;
  private String jdField_a_of_type_JavaLangString = "0";
  private Map<String, IBusinessExpireObserver> jdField_a_of_type_JavaUtilMap = new HashMap();
  private boolean jdField_a_of_type_Boolean;
  private boolean b = true;
  private boolean c;
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqLitelivesdkFrameworkBusinessmgrBusinessManager = new BusinessManager();
  }
  
  public long a()
  {
    if (this.jdField_a_of_type_Long <= 0L) {
      return System.currentTimeMillis();
    }
    return this.jdField_a_of_type_Long;
  }
  
  public EnterRoomConfig a()
  {
    return this.jdField_a_of_type_ComTencentIliveEnterRoomConfig;
  }
  
  public IBusinessExpireObserver a(String paramString)
  {
    QLog.e("LiveBusinessManager", 1, "getBusinessExpireObserver appid = " + paramString + " isContainKey = " + this.jdField_a_of_type_JavaUtilMap.containsKey(paramString));
    return (IBusinessExpireObserver)this.jdField_a_of_type_JavaUtilMap.get(paramString);
  }
  
  public BusinessConfig a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqLitelivesdkApiBusinessBusinessConfig != null) {
      QLog.e("LiveBusinessManager", 1, "getActiveBizConfig appid " + this.jdField_a_of_type_ComTencentMobileqqLitelivesdkApiBusinessBusinessConfig.jdField_a_of_type_JavaLangString);
    }
    return this.jdField_a_of_type_ComTencentMobileqqLitelivesdkApiBusinessBusinessConfig;
  }
  
  public String a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqLitelivesdkApiBusinessBusinessConfig == null) || (StringUtil.a(this.jdField_a_of_type_ComTencentMobileqqLitelivesdkApiBusinessBusinessConfig.e))) {
      return "";
    }
    return this.jdField_a_of_type_ComTencentMobileqqLitelivesdkApiBusinessBusinessConfig.e;
  }
  
  public void a(long paramLong)
  {
    if (paramLong <= 0L)
    {
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      return;
    }
    this.jdField_a_of_type_Long = paramLong;
  }
  
  public void a(EnterRoomConfig paramEnterRoomConfig)
  {
    this.jdField_a_of_type_ComTencentIliveEnterRoomConfig = paramEnterRoomConfig;
    this.c = this.b;
    this.b = false;
  }
  
  public void a(BusinessConfig paramBusinessConfig)
  {
    if (paramBusinessConfig != null) {
      QLog.e("LiveBusinessManager", 1, "updateActivieBizInfo appid " + paramBusinessConfig.jdField_a_of_type_JavaLangString);
    }
    this.jdField_a_of_type_ComTencentMobileqqLitelivesdkApiBusinessBusinessConfig = paramBusinessConfig;
  }
  
  public void a(String paramString)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqLitelivesdkApiBusinessBusinessConfig == null) || (StringUtil.a(paramString))) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqLitelivesdkApiBusinessBusinessConfig.d = paramString;
  }
  
  public void a(String paramString, IBusinessExpireObserver paramIBusinessExpireObserver)
  {
    StringBuilder localStringBuilder = new StringBuilder().append("registerBusinessExpireObserver appid = ").append(paramString).append(" observer == null : ");
    if (paramIBusinessExpireObserver == null) {}
    for (boolean bool = true;; bool = false)
    {
      QLog.e("LiveBusinessManager", 1, bool + " isContainKey = " + this.jdField_a_of_type_JavaUtilMap.containsKey(paramString));
      if (this.jdField_a_of_type_JavaUtilMap.containsKey(paramString)) {
        this.jdField_a_of_type_JavaUtilMap.remove(paramString);
      }
      this.jdField_a_of_type_JavaUtilMap.put(paramString, paramIBusinessExpireObserver);
      return;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public String b()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqLitelivesdkApiBusinessBusinessConfig == null) || (StringUtil.a(this.jdField_a_of_type_ComTencentMobileqqLitelivesdkApiBusinessBusinessConfig.d))) {
      return "";
    }
    return this.jdField_a_of_type_ComTencentMobileqqLitelivesdkApiBusinessBusinessConfig.d;
  }
  
  public void b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public boolean b()
  {
    return (this.jdField_a_of_type_ComTencentMobileqqLitelivesdkApiBusinessBusinessConfig != null) && ("1014".equals(this.jdField_a_of_type_ComTencentMobileqqLitelivesdkApiBusinessBusinessConfig.jdField_a_of_type_JavaLangString));
  }
  
  public String c()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public boolean c()
  {
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.litelivesdk.framework.businessmgr.BusinessManager
 * JD-Core Version:    0.7.0.1
 */