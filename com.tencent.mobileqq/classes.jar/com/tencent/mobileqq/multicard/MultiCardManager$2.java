package com.tencent.mobileqq.multicard;

import awus;
import awut;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import mqq.os.MqqHandler;

public class MultiCardManager$2
  implements Runnable
{
  public MultiCardManager$2(awus paramawus, long paramLong, ArrayList paramArrayList, awut paramawut) {}
  
  public void run()
  {
    HashMap localHashMap = this.this$0.a(this.jdField_a_of_type_Long, this.jdField_a_of_type_JavaUtilArrayList);
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("callbackWithNativeIntimateInfo ");
      if (localHashMap == null) {
        break label107;
      }
    }
    label107:
    for (String str = localHashMap.size() + localHashMap.toString();; str = "null")
    {
      QLog.d("MultiCardManager", 2, str + " " + this.jdField_a_of_type_Long);
      ThreadManager.getUIHandler().post(new MultiCardManager.2.1(this, localHashMap));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.multicard.MultiCardManager.2
 * JD-Core Version:    0.7.0.1
 */