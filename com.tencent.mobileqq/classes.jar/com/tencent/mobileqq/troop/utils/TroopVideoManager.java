package com.tencent.mobileqq.troop.utils;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.util.SharePreferenceUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import mqq.manager.Manager;

public class TroopVideoManager
  implements Manager
{
  protected Handler a;
  QQAppInterface a;
  public HashMap a;
  
  public TroopVideoManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    b();
  }
  
  public int a(String paramString)
  {
    paramString = (Integer)this.jdField_a_of_type_JavaUtilHashMap.get(String.valueOf(paramString));
    if (paramString != null) {
      return paramString.intValue();
    }
    return 0;
  }
  
  public void a()
  {
    Object localObject = new StringBuilder();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (((Integer)this.jdField_a_of_type_JavaUtilHashMap.get(str)).intValue() == 1) {
        ((StringBuilder)localObject).append(str).append(";");
      }
    }
    if (((StringBuilder)localObject).length() > 0)
    {
      localObject = ((StringBuilder)localObject).substring(0, ((StringBuilder)localObject).length() - 1).toString();
      SharePreferenceUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), "TroopVideoNotify", (String)localObject);
      return;
    }
    SharePreferenceUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), "TroopVideoNotify", "");
  }
  
  public void a(long paramLong)
  {
    int j = 0;
    Integer localInteger = (Integer)this.jdField_a_of_type_JavaUtilHashMap.get(String.valueOf(paramLong));
    if (localInteger != null) {}
    for (int i = localInteger.intValue();; i = 0)
    {
      boolean bool = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(paramLong);
      if ((bool) && (i == 0)) {
        j = 1;
      }
      for (;;)
      {
        this.jdField_a_of_type_JavaUtilHashMap.put(String.valueOf(paramLong), Integer.valueOf(j));
        if (j != i) {
          a();
        }
        return;
        if (bool) {
          j = i;
        }
      }
    }
  }
  
  public void a(String paramString)
  {
    if (a(paramString) == 1)
    {
      this.jdField_a_of_type_JavaUtilHashMap.put(paramString, Integer.valueOf(2));
      a();
    }
  }
  
  public void b()
  {
    Object localObject = SharePreferenceUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), "TroopVideoNotify");
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      localObject = ((String)localObject).split(";");
      if (localObject != null)
      {
        int i = 0;
        while (i < localObject.length)
        {
          this.jdField_a_of_type_JavaUtilHashMap.put(localObject[i], Integer.valueOf(1));
          i += 1;
        }
      }
    }
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp2\com34.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.TroopVideoManager
 * JD-Core Version:    0.7.0.1
 */