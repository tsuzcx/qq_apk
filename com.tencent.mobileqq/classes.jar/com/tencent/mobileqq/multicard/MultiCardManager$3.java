package com.tencent.mobileqq.multicard;

import axgu;
import axgx;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import mqq.os.MqqHandler;

public class MultiCardManager$3
  implements Runnable
{
  public MultiCardManager$3(axgu paramaxgu, long paramLong, axgx paramaxgx) {}
  
  public void run()
  {
    ArrayList localArrayList = axgu.a(this.this$0, this.jdField_a_of_type_Long);
    if (localArrayList != null) {}
    for (;;)
    {
      synchronized (axgu.a(this.this$0))
      {
        axgu.a(this.this$0).put(Long.valueOf(this.jdField_a_of_type_Long), (ArrayList)localArrayList.clone());
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder().append("callbackWithNativeUinList ").append(this.jdField_a_of_type_Long).append(" ");
          if (localArrayList != null)
          {
            ??? = localArrayList.toString();
            QLog.d("MultiCardManager", 2, (String)???);
          }
        }
        else
        {
          ThreadManager.getUIHandler().post(new MultiCardManager.3.1(this, localArrayList));
          return;
        }
      }
      ??? = "null";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.multicard.MultiCardManager.3
 * JD-Core Version:    0.7.0.1
 */