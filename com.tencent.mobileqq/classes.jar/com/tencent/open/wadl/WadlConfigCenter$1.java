package com.tencent.open.wadl;

import android.text.TextUtils;
import bbdx;
import bdov;
import bdow;
import bdpi;
import bicy;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;

public class WadlConfigCenter$1
  implements Runnable
{
  public WadlConfigCenter$1(bdow parambdow) {}
  
  public void run()
  {
    ??? = bicy.a();
    String str = null;
    if (((File)???).exists()) {
      str = bbdx.a((File)???);
    }
    if (QLog.isColorLevel()) {
      QLog.d("WadlConfigCenter", 2, "loadConfig content=" + str);
    }
    synchronized (bdow.a(this.this$0))
    {
      bdow.a(this.this$0).clear();
      boolean bool = TextUtils.isEmpty(str);
      if (!bool) {}
      try
      {
        Object localObject3 = new bdpi();
        ((bdpi)localObject3).a = "valid_url_regex_lists";
        ((bdpi)localObject3).a(str);
        bdow.a(this.this$0).put("valid_url_regex_lists", localObject3);
        localObject3 = new bdov();
        ((bdov)localObject3).a = "comminfo";
        ((bdov)localObject3).a(str);
        bdow.a(this.this$0).put("comminfo", localObject3);
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