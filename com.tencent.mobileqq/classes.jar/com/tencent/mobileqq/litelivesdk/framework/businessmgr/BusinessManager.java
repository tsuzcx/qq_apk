package com.tencent.mobileqq.litelivesdk.framework.businessmgr;

import android.text.TextUtils;
import com.tencent.ilive.EnterRoomConfig;
import com.tencent.ilive.audiencepages.room.pagelogic.AudienceMultiRoomActivityLogic;
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
    long l2 = this.jdField_a_of_type_Long;
    long l1 = l2;
    if (l2 <= 0L) {
      l1 = System.currentTimeMillis();
    }
    return l1;
  }
  
  public EnterRoomConfig a()
  {
    return this.jdField_a_of_type_ComTencentIliveEnterRoomConfig;
  }
  
  public IBusinessExpireObserver a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getBusinessExpireObserver appid = ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" isContainKey = ");
    localStringBuilder.append(this.jdField_a_of_type_JavaUtilMap.containsKey(paramString));
    QLog.e("LiveBusinessManager", 1, localStringBuilder.toString());
    return (IBusinessExpireObserver)this.jdField_a_of_type_JavaUtilMap.get(paramString);
  }
  
  public BusinessConfig a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqLitelivesdkApiBusinessBusinessConfig != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getActiveBizConfig appid ");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqLitelivesdkApiBusinessBusinessConfig.jdField_a_of_type_JavaLangString);
      QLog.e("LiveBusinessManager", 1, localStringBuilder.toString());
    }
    return this.jdField_a_of_type_ComTencentMobileqqLitelivesdkApiBusinessBusinessConfig;
  }
  
  public String a()
  {
    BusinessConfig localBusinessConfig = this.jdField_a_of_type_ComTencentMobileqqLitelivesdkApiBusinessBusinessConfig;
    if ((localBusinessConfig != null) && (!StringUtil.a(localBusinessConfig.e))) {
      return this.jdField_a_of_type_ComTencentMobileqqLitelivesdkApiBusinessBusinessConfig.e;
    }
    return "";
  }
  
  public void a()
  {
    AudienceMultiRoomActivityLogic.a().c();
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
    if (paramBusinessConfig != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateActivieBizInfo appid ");
      localStringBuilder.append(paramBusinessConfig.jdField_a_of_type_JavaLangString);
      QLog.e("LiveBusinessManager", 1, localStringBuilder.toString());
    }
    this.jdField_a_of_type_ComTencentMobileqqLitelivesdkApiBusinessBusinessConfig = paramBusinessConfig;
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqLitelivesdkApiBusinessBusinessConfig != null)
    {
      if (StringUtil.a(paramString)) {
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqLitelivesdkApiBusinessBusinessConfig.d = paramString;
    }
  }
  
  public void a(String paramString, IBusinessExpireObserver paramIBusinessExpireObserver)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("registerBusinessExpireObserver appid = ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" observer == null : ");
    boolean bool;
    if (paramIBusinessExpireObserver == null) {
      bool = true;
    } else {
      bool = false;
    }
    localStringBuilder.append(bool);
    localStringBuilder.append(" isContainKey = ");
    localStringBuilder.append(this.jdField_a_of_type_JavaUtilMap.containsKey(paramString));
    QLog.e("LiveBusinessManager", 1, localStringBuilder.toString());
    if (this.jdField_a_of_type_JavaUtilMap.containsKey(paramString)) {
      this.jdField_a_of_type_JavaUtilMap.remove(paramString);
    }
    this.jdField_a_of_type_JavaUtilMap.put(paramString, paramIBusinessExpireObserver);
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
    BusinessConfig localBusinessConfig = this.jdField_a_of_type_ComTencentMobileqqLitelivesdkApiBusinessBusinessConfig;
    if ((localBusinessConfig != null) && (!StringUtil.a(localBusinessConfig.d))) {
      return this.jdField_a_of_type_ComTencentMobileqqLitelivesdkApiBusinessBusinessConfig.d;
    }
    return "";
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
    BusinessConfig localBusinessConfig = this.jdField_a_of_type_ComTencentMobileqqLitelivesdkApiBusinessBusinessConfig;
    return (localBusinessConfig != null) && ("1014".equals(localBusinessConfig.jdField_a_of_type_JavaLangString));
  }
  
  public String c()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public boolean c()
  {
    BusinessConfig localBusinessConfig = this.jdField_a_of_type_ComTencentMobileqqLitelivesdkApiBusinessBusinessConfig;
    return (localBusinessConfig != null) && ("1037".equals(localBusinessConfig.jdField_a_of_type_JavaLangString));
  }
  
  public boolean d()
  {
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.litelivesdk.framework.businessmgr.BusinessManager
 * JD-Core Version:    0.7.0.1
 */