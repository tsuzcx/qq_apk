package com.tencent.mobileqq.relationx.config;

import android.text.TextUtils;
import com.tencent.mobileqq.dpc.DPCObserver;
import com.tencent.mobileqq.dpc.api.IDPCApi;
import com.tencent.mobileqq.dpc.enumname.DPCNames;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;

public class TroubleShootCfg
{
  private static final String jdField_a_of_type_JavaLangString = DPCNames.troubleShootCfg.name();
  @Deprecated
  private int jdField_a_of_type_Int = 1;
  private DPCObserver jdField_a_of_type_ComTencentMobileqqDpcDPCObserver = new TroubleShootCfg.1(this);
  
  private TroubleShootCfg()
  {
    ((IDPCApi)QRoute.api(IDPCApi.class)).addObserver(this.jdField_a_of_type_ComTencentMobileqqDpcDPCObserver);
    a();
  }
  
  public void a()
  {
    String str = ((IDPCApi)QRoute.api(IDPCApi.class)).getFeatureValueWithoutAccountManager(jdField_a_of_type_JavaLangString);
    if (!TextUtils.isEmpty(str))
    {
      String[] arrayOfString = str.split("\\|");
      if (arrayOfString.length >= 1) {
        try
        {
          this.jdField_a_of_type_Int = Integer.valueOf(arrayOfString[0]).intValue();
        }
        catch (Exception localException)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("loadConfig exception :");
          localStringBuilder.append(localException.getMessage());
          QLog.d("TroubleShootCfg", 1, localStringBuilder.toString());
          this.jdField_a_of_type_Int = 1;
        }
      }
    }
    else
    {
      this.jdField_a_of_type_Int = 1;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TroubleShootCfg", 2, String.format("loadConfig dpc=%s", new Object[] { str }));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.relationx.config.TroubleShootCfg
 * JD-Core Version:    0.7.0.1
 */