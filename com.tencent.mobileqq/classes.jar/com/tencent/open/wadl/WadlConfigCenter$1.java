package com.tencent.open.wadl;

import android.text.TextUtils;
import bbdj;
import bdog;
import bdoh;
import bdot;
import bich;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;

public class WadlConfigCenter$1
  implements Runnable
{
  public WadlConfigCenter$1(bdoh parambdoh) {}
  
  public void run()
  {
    ??? = bich.a();
    String str = null;
    if (((File)???).exists()) {
      str = bbdj.a((File)???);
    }
    if (QLog.isColorLevel()) {
      QLog.d("WadlConfigCenter", 2, "loadConfig content=" + str);
    }
    synchronized (bdoh.a(this.this$0))
    {
      bdoh.a(this.this$0).clear();
      boolean bool = TextUtils.isEmpty(str);
      if (!bool) {}
      try
      {
        Object localObject3 = new bdot();
        ((bdot)localObject3).a = "valid_url_regex_lists";
        ((bdot)localObject3).a(str);
        bdoh.a(this.this$0).put("valid_url_regex_lists", localObject3);
        localObject3 = new bdog();
        ((bdog)localObject3).a = "comminfo";
        ((bdog)localObject3).a(str);
        bdoh.a(this.this$0).put("comminfo", localObject3);
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