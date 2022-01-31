package com.tencent.mobileqq.intervideo.now;

import android.util.Log;
import aqns;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public final class FileUploadUtil$1
  implements Runnable
{
  public FileUploadUtil$1(String paramString1, String paramString2) {}
  
  public void run()
  {
    aqns.a(aqns.a());
    HashMap localHashMap = new HashMap();
    String str = "qiqi" + UUID.randomUUID().toString().replace("-", "");
    Log.i("upload", str);
    localHashMap.put("taskUuid", str);
    localHashMap.put("taskType", "0");
    localHashMap.put("taskBusinessType", "2");
    localHashMap.put("taskTargetId", this.a);
    try
    {
      aqns.a("http://upload.huayang.qq.com/cgi-bin/uploadfile", localHashMap, new File(this.b));
      return;
    }
    catch (Exception localException)
    {
      Log.e("HttpUtil", localException.getLocalizedMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.now.FileUploadUtil.1
 * JD-Core Version:    0.7.0.1
 */