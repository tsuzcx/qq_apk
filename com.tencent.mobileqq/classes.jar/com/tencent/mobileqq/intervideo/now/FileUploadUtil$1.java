package com.tencent.mobileqq.intervideo.now;

import android.util.Log;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

final class FileUploadUtil$1
  implements Runnable
{
  FileUploadUtil$1(String paramString1, String paramString2) {}
  
  public void run()
  {
    FileUploadUtil.a(FileUploadUtil.a());
    HashMap localHashMap = new HashMap();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("qiqi");
    ((StringBuilder)localObject).append(UUID.randomUUID().toString().replace("-", ""));
    localObject = ((StringBuilder)localObject).toString();
    Log.i("upload", (String)localObject);
    localHashMap.put("taskUuid", localObject);
    localHashMap.put("taskType", "0");
    localHashMap.put("taskBusinessType", "2");
    localHashMap.put("taskTargetId", this.a);
    try
    {
      FileUploadUtil.a("https://upload.huayang.qq.com/cgi-bin/uploadfile", localHashMap, new File(this.b));
      return;
    }
    catch (Exception localException)
    {
      Log.e("HttpUtil", localException.getLocalizedMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.now.FileUploadUtil.1
 * JD-Core Version:    0.7.0.1
 */