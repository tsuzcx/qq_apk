package com.tencent.open.wadl;

import android.text.TextUtils;
import bhmi;
import bkaf;
import bkag;
import bnyy;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;

public class WadlConfigCenter$1
  implements Runnable
{
  public WadlConfigCenter$1(bkag parambkag) {}
  
  public void run()
  {
    ??? = bnyy.a();
    String str = null;
    if (((File)???).exists()) {
      str = bhmi.a((File)???);
    }
    if (QLog.isColorLevel()) {
      QLog.d("WadlConfigCenter", 2, "loadConfig content=" + str);
    }
    synchronized (bkag.a(this.this$0))
    {
      bkag.a(this.this$0).clear();
      boolean bool = TextUtils.isEmpty(str);
      if (!bool) {}
      try
      {
        bkaf localbkaf = new bkaf();
        localbkaf.a = "comminfo";
        localbkaf.a(str);
        bkag.a(this.this$0).put("comminfo", localbkaf);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.open.wadl.WadlConfigCenter.1
 * JD-Core Version:    0.7.0.1
 */