package com.tencent.mobileqq.utils;

import android.os.Bundle;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import java.io.File;

class AntiFraudConfigFileUtil$4
  implements Runnable
{
  AntiFraudConfigFileUtil$4(AntiFraudConfigFileUtil paramAntiFraudConfigFileUtil, String paramString1, String paramString2, String paramString3) {}
  
  public void run()
  {
    String str = this.this$0.a(this.a);
    File localFile = new File(str);
    Object localObject1 = localFile.getParent();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append("/download");
    ((StringBuilder)localObject2).append(this.a);
    ((StringBuilder)localObject2).append(".xml");
    localObject1 = new File(((StringBuilder)localObject2).toString());
    if (((File)localObject1).exists()) {
      ((File)localObject1).delete();
    }
    if (HttpDownloadUtil.download(null, MsfSdkUtils.insertMtype("QPSingle", this.b), (File)localObject1))
    {
      localObject2 = SecUtil.getFileMd5(((File)localObject1).getAbsolutePath());
      if (!this.c.equalsIgnoreCase((String)localObject2))
      {
        AntiFraudConfigFileUtil.b(this.this$0).putInt(this.c, 2);
        return;
      }
      if (((File)localObject1).renameTo(localFile))
      {
        AntiFraudConfigFileUtil.b(this.this$0).putInt(this.c, 3);
        this.this$0.a(this.a, System.currentTimeMillis());
        this.this$0.a(this.a, this.c);
        AntiFraudConfigFileUtil.b(this.this$0, str);
        return;
      }
      AntiFraudConfigFileUtil.b(this.this$0).putInt(this.c, 2);
      ((File)localObject1).delete();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.utils.AntiFraudConfigFileUtil.4
 * JD-Core Version:    0.7.0.1
 */