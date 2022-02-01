package com.tencent.mobileqq.javahook;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.StatisticCollector;
import java.util.HashMap;

final class BadTokenHooker$2
  implements Runnable
{
  BadTokenHooker$2(String paramString1, String paramString2, int paramInt) {}
  
  public void run()
  {
    Object localObject = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
    if (localObject != null) {
      localObject = ((QQAppInterface)localObject).getCurrentAccountUin();
    } else {
      localObject = null;
    }
    HashMap localHashMap = new HashMap();
    String str = this.jdField_a_of_type_JavaLangString;
    if (str != null) {
      localHashMap.put("activity", str);
    }
    str = this.b;
    if (str != null) {
      localHashMap.put("detail", str);
    }
    localHashMap.put("type", String.valueOf(this.jdField_a_of_type_Int));
    StatisticCollector.getInstance(BaseApplicationImpl.getApplication()).collectPerformance((String)localObject, "BadTokenHooker", false, 0L, 0L, localHashMap, "", true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.javahook.BadTokenHooker.2
 * JD-Core Version:    0.7.0.1
 */