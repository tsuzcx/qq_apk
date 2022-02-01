package com.tencent.mobileqq.multicard;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import mqq.os.MqqHandler;

class MultiCardManager$3
  implements Runnable
{
  MultiCardManager$3(MultiCardManager paramMultiCardManager, long paramLong, MultiCardManager.GetGroupRecommendUinListsListener paramGetGroupRecommendUinListsListener) {}
  
  public void run()
  {
    ArrayList localArrayList1 = MultiCardManager.a(this.this$0, this.jdField_a_of_type_Long);
    if (localArrayList1 != null) {
      synchronized (MultiCardManager.a(this.this$0))
      {
        MultiCardManager.a(this.this$0).put(Long.valueOf(this.jdField_a_of_type_Long), (ArrayList)localArrayList1.clone());
      }
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("callbackWithNativeUinList ");
      localStringBuilder.append(this.jdField_a_of_type_Long);
      localStringBuilder.append(" ");
      if (localArrayList2 != null) {
        ??? = localArrayList2.toString();
      } else {
        ??? = "null";
      }
      localStringBuilder.append((String)???);
      QLog.d("MultiCardManager", 2, localStringBuilder.toString());
    }
    ThreadManager.getUIHandler().post(new MultiCardManager.3.1(this, localArrayList2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.multicard.MultiCardManager.3
 * JD-Core Version:    0.7.0.1
 */