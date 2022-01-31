package com.tencent.open.wadl;

import android.text.TextUtils;
import bdcs;
import bfns;
import bfnt;
import bfof;
import bkeu;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;

public class WadlConfigCenter$1
  implements Runnable
{
  public WadlConfigCenter$1(bfnt parambfnt) {}
  
  public void run()
  {
    ??? = bkeu.a();
    String str = null;
    if (((File)???).exists()) {
      str = bdcs.a((File)???);
    }
    if (QLog.isColorLevel()) {
      QLog.d("WadlConfigCenter", 2, "loadConfig content=" + str);
    }
    synchronized (bfnt.a(this.this$0))
    {
      bfnt.a(this.this$0).clear();
      boolean bool = TextUtils.isEmpty(str);
      if (!bool) {}
      try
      {
        Object localObject3 = new bfof();
        ((bfof)localObject3).a = "valid_url_regex_lists";
        ((bfof)localObject3).a(str);
        bfnt.a(this.this$0).put("valid_url_regex_lists", localObject3);
        localObject3 = new bfns();
        ((bfns)localObject3).a = "comminfo";
        ((bfns)localObject3).a(str);
        bfnt.a(this.this$0).put("comminfo", localObject3);
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