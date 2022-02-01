package com.tencent.mobileqq.multicard;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import mqq.os.MqqHandler;

class MultiCardManager$2
  implements Runnable
{
  MultiCardManager$2(MultiCardManager paramMultiCardManager, long paramLong, ArrayList paramArrayList, MultiCardManager.GetGroupIntimateInfoListListener paramGetGroupIntimateInfoListListener) {}
  
  public void run()
  {
    HashMap localHashMap = this.this$0.a(this.jdField_a_of_type_Long, this.jdField_a_of_type_JavaUtilArrayList);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("callbackWithNativeIntimateInfo ");
      Object localObject;
      if (localHashMap != null)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(localHashMap.size());
        ((StringBuilder)localObject).append(localHashMap.toString());
        localObject = ((StringBuilder)localObject).toString();
      }
      else
      {
        localObject = "null";
      }
      localStringBuilder.append((String)localObject);
      localStringBuilder.append(" ");
      localStringBuilder.append(this.jdField_a_of_type_Long);
      QLog.d("MultiCardManager", 2, localStringBuilder.toString());
    }
    ThreadManager.getUIHandler().post(new MultiCardManager.2.1(this, localHashMap));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.multicard.MultiCardManager.2
 * JD-Core Version:    0.7.0.1
 */