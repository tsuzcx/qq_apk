package com.tencent.mobileqq.multicard;

import auno;
import aunr;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import mqq.os.MqqHandler;

public class MultiCardManager$3
  implements Runnable
{
  public MultiCardManager$3(auno paramauno, long paramLong, aunr paramaunr) {}
  
  public void run()
  {
    ArrayList localArrayList = auno.a(this.this$0, this.jdField_a_of_type_Long);
    if (localArrayList != null) {}
    for (;;)
    {
      synchronized (auno.a(this.this$0))
      {
        auno.a(this.this$0).put(Long.valueOf(this.jdField_a_of_type_Long), (ArrayList)localArrayList.clone());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.multicard.MultiCardManager.3
 * JD-Core Version:    0.7.0.1
 */