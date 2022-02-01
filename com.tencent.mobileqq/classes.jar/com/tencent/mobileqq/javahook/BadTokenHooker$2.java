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
    String str = null;
    Object localObject = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
    if (localObject != null) {
      str = ((QQAppInterface)localObject).getCurrentAccountUin();
    }
    localObject = new HashMap();
    if (this.jdField_a_of_type_JavaLangString != null) {
      ((HashMap)localObject).put("activity", this.jdField_a_of_type_JavaLangString);
    }
    if (this.b != null) {
      ((HashMap)localObject).put("detail", this.b);
    }
    ((HashMap)localObject).put("type", String.valueOf(this.jdField_a_of_type_Int));
    StatisticCollector.getInstance(BaseApplicationImpl.getApplication()).collectPerformance(str, "BadTokenHooker", false, 0L, 0L, (HashMap)localObject, "", true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.javahook.BadTokenHooker.2
 * JD-Core Version:    0.7.0.1
 */