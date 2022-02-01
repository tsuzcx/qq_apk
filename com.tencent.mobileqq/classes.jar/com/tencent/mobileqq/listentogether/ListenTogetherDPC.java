package com.tencent.mobileqq.listentogether;

import android.text.TextUtils;
import com.tencent.mobileqq.dpc.DPCObserver;
import com.tencent.mobileqq.dpc.api.IDPCApi;
import com.tencent.mobileqq.dpc.enumname.DPCNames;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;

public class ListenTogetherDPC
{
  public static final String a;
  public int a;
  public long a;
  public DPCObserver a;
  public int b = 0;
  
  static
  {
    jdField_a_of_type_JavaLangString = DPCNames.ltcfg.name();
  }
  
  private ListenTogetherDPC()
  {
    this.jdField_a_of_type_Int = 50;
    this.jdField_a_of_type_Long = 3000L;
    this.jdField_a_of_type_ComTencentMobileqqDpcDPCObserver = new ListenTogetherDPC.1(this);
    a();
    ((IDPCApi)QRoute.api(IDPCApi.class)).addObserver(this.jdField_a_of_type_ComTencentMobileqqDpcDPCObserver);
  }
  
  public static ListenTogetherDPC a()
  {
    return ListenTogetherDPC.SingletonHolder.a();
  }
  
  private void a()
  {
    String str = ((IDPCApi)QRoute.api(IDPCApi.class)).getFeatureValueWithoutAccountManager(jdField_a_of_type_JavaLangString);
    try
    {
      if (!TextUtils.isEmpty(str))
      {
        String[] arrayOfString = str.split("\\|");
        if (arrayOfString.length >= 4)
        {
          this.jdField_a_of_type_Int = Integer.valueOf(arrayOfString[0]).intValue();
          this.b = Integer.valueOf(arrayOfString[1]).intValue();
          this.jdField_a_of_type_Long = Long.valueOf(arrayOfString[2]).longValue();
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("ListenTogether.dpc", 2, String.format("loadDpc, dpcValue: %s, [%s]", new Object[] { str, this }));
      }
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.d("ListenTogether.dpc", 1, "loadDpc", localException);
        this.jdField_a_of_type_Int = 50;
        this.b = 0;
        this.jdField_a_of_type_Long = 3000L;
      }
    }
  }
  
  public String toString()
  {
    return "ListenTogetherDPC{maxCacheCount=" + this.jdField_a_of_type_Int + ", preDownloadNetType=" + this.b + ", playingAdjustInterval=" + this.jdField_a_of_type_Long + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.listentogether.ListenTogetherDPC
 * JD-Core Version:    0.7.0.1
 */