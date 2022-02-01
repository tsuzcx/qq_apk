package com.tencent.mobileqq.flutter.config;

import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.dpc.api.IDPCApi;
import com.tencent.mobileqq.dpc.enumname.DPCNames;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.Random;
import mqq.app.AppRuntime;

public class QFlutterDPC
{
  private static QFlutterDPC jdField_a_of_type_ComTencentMobileqqFlutterConfigQFlutterDPC;
  private static final String jdField_a_of_type_JavaLangString = DPCNames.qflutterCfg.name();
  private static Random jdField_a_of_type_JavaUtilRandom = new Random();
  private int jdField_a_of_type_Int;
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  
  private QFlutterDPC()
  {
    ((IDPCApi)QRoute.api(IDPCApi.class)).addObserver(new QFlutterDPC.1(this));
    a();
  }
  
  public static QFlutterDPC a()
  {
    if (jdField_a_of_type_ComTencentMobileqqFlutterConfigQFlutterDPC == null) {
      try
      {
        if (jdField_a_of_type_ComTencentMobileqqFlutterConfigQFlutterDPC == null) {
          jdField_a_of_type_ComTencentMobileqqFlutterConfigQFlutterDPC = new QFlutterDPC();
        }
      }
      finally {}
    }
    return jdField_a_of_type_ComTencentMobileqqFlutterConfigQFlutterDPC;
  }
  
  public void a()
  {
    String str = ((IDPCApi)QRoute.api(IDPCApi.class)).getFeatureValueWithoutAccountManager(jdField_a_of_type_JavaLangString);
    if (!TextUtils.isEmpty(str))
    {
      String[] arrayOfString = str.split("\\|");
      if (arrayOfString.length >= 3) {
        try
        {
          if (Integer.valueOf(arrayOfString[0]).intValue() == 1) {
            this.jdField_a_of_type_Boolean = true;
          } else {
            this.jdField_a_of_type_Boolean = false;
          }
          if (jdField_a_of_type_JavaUtilRandom.nextFloat() < Float.valueOf(arrayOfString[1]).floatValue()) {
            this.b = true;
          } else {
            this.b = false;
          }
          this.jdField_a_of_type_Int = Integer.valueOf(arrayOfString[2]).intValue();
        }
        catch (Exception localException)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("loadConfig exception :");
          localStringBuilder.append(localException.getMessage());
          QLog.d("QFlutterDPC", 1, localStringBuilder.toString());
          this.b = true;
          this.jdField_a_of_type_Boolean = true;
          this.jdField_a_of_type_Int = 0;
        }
      }
    }
    else
    {
      this.b = true;
      this.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_Int = 0;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QFlutterDPC", 2, String.format("loadConfig, dpcValue: %s, mIsSupport: %s, mNeedReport: %s, mVoteRankingFlutterThreashold=%s", new Object[] { str, Boolean.valueOf(this.jdField_a_of_type_Boolean), Boolean.valueOf(this.b), Integer.valueOf(this.jdField_a_of_type_Int) }));
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public boolean b()
  {
    String str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    try
    {
      l = Long.valueOf(str).longValue();
    }
    catch (Throwable localThrowable)
    {
      long l;
      label23:
      int i;
      boolean bool;
      break label23;
    }
    l = 0L;
    i = (int)(l % 10L);
    bool = false;
    QLog.d("QFlutterDPC", 1, String.format("isVoteRankingFlutterOpen lastNum=%d threashold=%d", new Object[] { Integer.valueOf(i), Integer.valueOf(this.jdField_a_of_type_Int) }));
    if (this.jdField_a_of_type_Boolean)
    {
      if (i >= this.jdField_a_of_type_Int) {
        return false;
      }
      bool = true;
    }
    return bool;
  }
  
  public boolean c()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.flutter.config.QFlutterDPC
 * JD-Core Version:    0.7.0.1
 */