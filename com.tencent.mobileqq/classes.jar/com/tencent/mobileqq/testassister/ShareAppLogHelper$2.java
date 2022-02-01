package com.tencent.mobileqq.testassister;

import java.io.File;

class ShareAppLogHelper$2
  implements Runnable
{
  ShareAppLogHelper$2(ShareAppLogHelper paramShareAppLogHelper) {}
  
  public void run()
  {
    int i = ShareAppLogHelper.a(this.this$0);
    if (i != 0)
    {
      ShareAppLogHelper.a(this.this$0, i);
      ShareAppLogHelper.a(this.this$0);
      return;
    }
    i = ShareAppLogHelper.b(this.this$0);
    if (i == 1)
    {
      ShareAppLogHelper.b(this.this$0, i);
      ShareAppLogHelper.b(this.this$0);
      if (!ShareAppLogHelper.a(this.this$0)) {
        ShareAppLogHelper.a(this.this$0, ShareAppLogHelper.a(this.this$0));
      }
    }
    for (;;)
    {
      ShareAppLogHelper.a(this.this$0);
      return;
      try
      {
        File localFile = new File(ShareAppLogHelper.a(this.this$0));
        if (!localFile.exists()) {
          continue;
        }
        localFile.delete();
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      continue;
      if (i == 0) {
        ShareAppLogHelper.a(this.this$0, ShareAppLogHelper.a(this.this$0));
      } else {
        ShareAppLogHelper.a(this.this$0, i);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.testassister.ShareAppLogHelper.2
 * JD-Core Version:    0.7.0.1
 */