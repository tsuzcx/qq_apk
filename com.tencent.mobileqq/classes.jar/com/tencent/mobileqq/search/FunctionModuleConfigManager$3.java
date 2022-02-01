package com.tencent.mobileqq.search;

import android.text.TextUtils;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;

class FunctionModuleConfigManager$3
  implements Runnable
{
  FunctionModuleConfigManager$3(FunctionModuleConfigManager paramFunctionModuleConfigManager, String paramString) {}
  
  public void run()
  {
    try
    {
      Object localObject = HttpUtil.openUrlForByte(BaseApplicationImpl.getContext(), MsfSdkUtils.insertMtype("GameCenter", this.a), "GET", null, null);
      if (localObject != null)
      {
        localObject = FunctionModuleConfigManager.a(this.this$0, (byte[])localObject);
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          this.this$0.a((String)localObject);
          this.this$0.c(this.a);
          return;
        }
      }
    }
    catch (IOException localIOException)
    {
      QLog.i("search_manager_configFunctionModuleConfigManager", 1, "getFunctionListFile", localIOException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.FunctionModuleConfigManager.3
 * JD-Core Version:    0.7.0.1
 */