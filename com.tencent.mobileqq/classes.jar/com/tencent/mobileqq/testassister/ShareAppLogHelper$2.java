package com.tencent.mobileqq.testassister;

import com.tencent.qphone.base.util.QLog;
import java.io.File;

class ShareAppLogHelper$2
  implements Runnable
{
  ShareAppLogHelper$2(ShareAppLogHelper paramShareAppLogHelper) {}
  
  public void run()
  {
    Object localObject = new ShareAppLogHelper.TimeLogger("allCost");
    ((ShareAppLogHelper.TimeLogger)localObject).a(0);
    int i = ShareAppLogHelper.a(this.this$0);
    if (i != 0)
    {
      ShareAppLogHelper.a(this.this$0, i);
      ShareAppLogHelper.a(this.this$0);
      return;
    }
    i = ShareAppLogHelper.b(this.this$0);
    ((ShareAppLogHelper.TimeLogger)localObject).a(1);
    if (i == 1)
    {
      ShareAppLogHelper.b(this.this$0, i);
      if (QLog.isColorLevel()) {
        QLog.d("ShareAppLogHelper", 4, "status is size warning, show dialog");
      }
      ShareAppLogHelper.b(this.this$0);
      if (!ShareAppLogHelper.a(this.this$0))
      {
        localObject = this.this$0;
        ShareAppLogHelper.a((ShareAppLogHelper)localObject, ShareAppLogHelper.a((ShareAppLogHelper)localObject));
      }
      else
      {
        try
        {
          localObject = new File(ShareAppLogHelper.a(this.this$0));
          if (!((File)localObject).exists()) {
            break label182;
          }
          ((File)localObject).delete();
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
        }
      }
    }
    else if (i == 0)
    {
      ShareAppLogHelper localShareAppLogHelper = this.this$0;
      ShareAppLogHelper.a(localShareAppLogHelper, ShareAppLogHelper.a(localShareAppLogHelper));
    }
    else
    {
      ShareAppLogHelper.a(this.this$0, i);
    }
    label182:
    ShareAppLogHelper.a(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.testassister.ShareAppLogHelper.2
 * JD-Core Version:    0.7.0.1
 */