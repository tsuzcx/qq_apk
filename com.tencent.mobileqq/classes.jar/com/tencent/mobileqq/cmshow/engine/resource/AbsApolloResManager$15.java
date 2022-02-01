package com.tencent.mobileqq.cmshow.engine.resource;

import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import mqq.app.AppRuntime;
import org.json.JSONObject;

class AbsApolloResManager$15
  implements Runnable
{
  AbsApolloResManager$15(AbsApolloResManager paramAbsApolloResManager) {}
  
  public void run()
  {
    Object localObject = null;
    try
    {
      AppInterface localAppInterface = AbsApolloResManager.b(this.this$0);
      if (localAppInterface != null) {
        localObject = localAppInterface.getApp();
      }
      if (localObject == null)
      {
        QLog.e("[cmshow]cm_res", 1, "[mReadApolloResVersionRunable] error, context is null!");
        return;
      }
      localObject = new File("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo");
      ((File)localObject).mkdirs();
      localObject = new File((File)localObject, "apollo_res_version_info.json");
      if (((File)localObject).exists())
      {
        localObject = FileUtils.readFileToString((File)localObject);
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          this.this$0.b = new JSONObject((String)localObject);
        }
      }
    }
    catch (Exception localException)
    {
      QLog.e("[cmshow]cm_res", 1, localException.getMessage());
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      QLog.e("[cmshow]cm_res", 1, localOutOfMemoryError.getMessage());
    }
    if (this.this$0.b == null) {
      this.this$0.b = new JSONObject();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.cmshow.engine.resource.AbsApolloResManager.15
 * JD-Core Version:    0.7.0.1
 */