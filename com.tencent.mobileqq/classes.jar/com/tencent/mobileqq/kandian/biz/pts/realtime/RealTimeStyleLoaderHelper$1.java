package com.tencent.mobileqq.kandian.biz.pts.realtime;

import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Iterator;
import java.util.List;

class RealTimeStyleLoaderHelper$1
  implements Runnable
{
  RealTimeStyleLoaderHelper$1(RealTimeStyleLoaderHelper paramRealTimeStyleLoaderHelper, List paramList) {}
  
  public void run()
  {
    try
    {
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append(RealTimeStyleLoaderHelper.a(this.this$0));
        ((StringBuilder)localObject).append("/");
        ((StringBuilder)localObject).append(str);
        localObject = new File(((StringBuilder)localObject).toString());
        if ((((File)localObject).exists()) && (((File)localObject).isFile()))
        {
          boolean bool = ((File)localObject).delete();
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("fileName: ");
          ((StringBuilder)localObject).append(str);
          ((StringBuilder)localObject).append("  succ :");
          ((StringBuilder)localObject).append(bool);
          QLog.d("RealTimeTemplateFactory", 1, ((StringBuilder)localObject).toString());
        }
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.d("RealTimeTemplateFactory", 1, "deleteFile: ", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.realtime.RealTimeStyleLoaderHelper.1
 * JD-Core Version:    0.7.0.1
 */