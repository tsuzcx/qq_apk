package com.tencent.mobileqq.search;

import android.text.TextUtils;
import awhl;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import nam;

public class FunctionModuleConfigManager$3
  implements Runnable
{
  public FunctionModuleConfigManager$3(awhl paramawhl, String paramString) {}
  
  public void run()
  {
    try
    {
      Object localObject = nam.a(BaseApplicationImpl.getContext(), MsfSdkUtils.insertMtype("GameCenter", this.a), "GET", null, null);
      if (localObject != null)
      {
        localObject = awhl.a(this.this$0, (byte[])localObject);
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          this.this$0.a((String)localObject);
          this.this$0.c(this.a);
        }
      }
      return;
    }
    catch (IOException localIOException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("Q.uniteSearch.FunctionModuleConfigManager", 2, localIOException.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.search.FunctionModuleConfigManager.3
 * JD-Core Version:    0.7.0.1
 */