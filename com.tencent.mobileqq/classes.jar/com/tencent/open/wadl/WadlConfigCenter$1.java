package com.tencent.open.wadl;

import android.text.TextUtils;
import bifp;
import bifq;
import blec;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;

public class WadlConfigCenter$1
  implements Runnable
{
  public WadlConfigCenter$1(bifq parambifq) {}
  
  public void run()
  {
    ??? = blec.a();
    String str = null;
    if (((File)???).exists()) {
      str = FileUtils.readFileContent((File)???);
    }
    if (QLog.isColorLevel()) {
      QLog.d("WadlConfigCenter", 2, "loadConfig content=" + str);
    }
    synchronized (bifq.a(this.this$0))
    {
      bifq.a(this.this$0).clear();
      boolean bool = TextUtils.isEmpty(str);
      if (!bool) {}
      try
      {
        bifp localbifp = new bifp();
        localbifp.a = "comminfo";
        localbifp.a(str);
        bifq.a(this.this$0).put("comminfo", localbifp);
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