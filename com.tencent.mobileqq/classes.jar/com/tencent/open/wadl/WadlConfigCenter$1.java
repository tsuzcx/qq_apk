package com.tencent.open.wadl;

import android.text.TextUtils;
import bdhb;
import bfsb;
import bfsc;
import bfso;
import bkjb;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;

public class WadlConfigCenter$1
  implements Runnable
{
  public WadlConfigCenter$1(bfsc parambfsc) {}
  
  public void run()
  {
    ??? = bkjb.a();
    String str = null;
    if (((File)???).exists()) {
      str = bdhb.a((File)???);
    }
    if (QLog.isColorLevel()) {
      QLog.d("WadlConfigCenter", 2, "loadConfig content=" + str);
    }
    synchronized (bfsc.a(this.this$0))
    {
      bfsc.a(this.this$0).clear();
      boolean bool = TextUtils.isEmpty(str);
      if (!bool) {}
      try
      {
        Object localObject3 = new bfso();
        ((bfso)localObject3).a = "valid_url_regex_lists";
        ((bfso)localObject3).a(str);
        bfsc.a(this.this$0).put("valid_url_regex_lists", localObject3);
        localObject3 = new bfsb();
        ((bfsb)localObject3).a = "comminfo";
        ((bfsb)localObject3).a(str);
        bfsc.a(this.this$0).put("comminfo", localObject3);
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localException.printStackTrace();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.wadl.WadlConfigCenter.1
 * JD-Core Version:    0.7.0.1
 */