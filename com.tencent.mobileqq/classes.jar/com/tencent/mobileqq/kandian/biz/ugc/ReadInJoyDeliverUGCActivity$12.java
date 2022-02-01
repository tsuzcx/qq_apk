package com.tencent.mobileqq.kandian.biz.ugc;

import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Iterator;
import java.util.List;

class ReadInJoyDeliverUGCActivity$12
  implements Runnable
{
  ReadInJoyDeliverUGCActivity$12(ReadInJoyDeliverUGCActivity paramReadInJoyDeliverUGCActivity) {}
  
  public void run()
  {
    Iterator localIterator = ReadInJoyDeliverUGCActivity.l(this.this$0).iterator();
    StringBuilder localStringBuilder;
    while (localIterator.hasNext())
    {
      Object localObject1 = (String)localIterator.next();
      try
      {
        localObject1 = new File((String)localObject1);
        if (((File)localObject1).exists()) {
          ((File)localObject1).delete();
        }
      }
      catch (NullPointerException localNullPointerException1)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("deleteFile error");
        localStringBuilder.append(localNullPointerException1.toString());
        QLog.d("ReadInJoyDeliverUGCActivity", 2, localStringBuilder.toString());
      }
    }
    localIterator = ReadInJoyDeliverUGCActivity.m(this.this$0).iterator();
    while (localIterator.hasNext())
    {
      Object localObject2 = (String)localIterator.next();
      try
      {
        localObject2 = new File((String)localObject2);
        if (((File)localObject2).exists()) {
          ((File)localObject2).delete();
        }
      }
      catch (NullPointerException localNullPointerException2)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("deleteFile error");
        localStringBuilder.append(localNullPointerException2.toString());
        QLog.d("ReadInJoyDeliverUGCActivity", 2, localStringBuilder.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.ReadInJoyDeliverUGCActivity.12
 * JD-Core Version:    0.7.0.1
 */