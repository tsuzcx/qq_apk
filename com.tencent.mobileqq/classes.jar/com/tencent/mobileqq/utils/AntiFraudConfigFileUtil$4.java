package com.tencent.mobileqq.utils;

import android.os.Bundle;
import bdfc;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import java.io.File;

public class AntiFraudConfigFileUtil$4
  implements Runnable
{
  public AntiFraudConfigFileUtil$4(bdfc parambdfc, String paramString1, String paramString2, String paramString3) {}
  
  public void run()
  {
    String str1 = this.this$0.a(this.a);
    File localFile = new File(str1);
    Object localObject = localFile.getParent();
    localObject = new File((String)localObject + "/download" + this.a + ".xml");
    if (((File)localObject).exists()) {
      ((File)localObject).delete();
    }
    if (HttpDownloadUtil.a(null, MsfSdkUtils.insertMtype("QPSingle", this.b), (File)localObject))
    {
      String str2 = SecUtil.getFileMd5(((File)localObject).getAbsolutePath());
      if (!this.c.equalsIgnoreCase(str2)) {
        bdfc.b(this.this$0).putInt(this.c, 2);
      }
    }
    else
    {
      return;
    }
    if (((File)localObject).renameTo(localFile))
    {
      bdfc.b(this.this$0).putInt(this.c, 3);
      this.this$0.a(this.a, System.currentTimeMillis());
      this.this$0.a(this.a, this.c);
      bdfc.b(this.this$0, str1);
      return;
    }
    bdfc.b(this.this$0).putInt(this.c, 2);
    ((File)localObject).delete();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.utils.AntiFraudConfigFileUtil.4
 * JD-Core Version:    0.7.0.1
 */