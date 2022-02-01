package com.tencent.open.wadl;

import android.text.TextUtils;
import bgmg;
import bizg;
import bizh;
import bmxq;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;

public class WadlConfigCenter$1
  implements Runnable
{
  public WadlConfigCenter$1(bizh parambizh) {}
  
  public void run()
  {
    ??? = bmxq.a();
    String str = null;
    if (((File)???).exists()) {
      str = bgmg.a((File)???);
    }
    if (QLog.isColorLevel()) {
      QLog.d("WadlConfigCenter", 2, "loadConfig content=" + str);
    }
    synchronized (bizh.a(this.this$0))
    {
      bizh.a(this.this$0).clear();
      boolean bool = TextUtils.isEmpty(str);
      if (!bool) {}
      try
      {
        bizg localbizg = new bizg();
        localbizg.a = "comminfo";
        localbizg.a(str);
        bizh.a(this.this$0).put("comminfo", localbizg);
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