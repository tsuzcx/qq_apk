package com.tencent.mobileqq.nearby;

import android.os.SystemClock;
import android.text.TextUtils;
import aupv;
import azmz;
import bdee;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class ImgDownloadListener$1
  implements Runnable
{
  public ImgDownloadListener$1(aupv paramaupv, long paramLong) {}
  
  public void run()
  {
    long l = SystemClock.elapsedRealtime() - aupv.a(this.this$0);
    Object localObject2 = bdee.a(aupv.a(this.this$0));
    Object localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = "wifi";
    }
    localObject2 = new HashMap();
    ((HashMap)localObject2).put("fileSize", String.valueOf(this.a));
    ((HashMap)localObject2).put("costTime", String.valueOf(l));
    ((HashMap)localObject2).put("apn", localObject1);
    ((HashMap)localObject2).put("param_NetType", bdee.a(null) + "");
    azmz.a(aupv.a(this.this$0)).a("", aupv.a(this.this$0), true, l, 0L, (HashMap)localObject2, "", true);
    if (QLog.isColorLevel()) {
      QLog.d("ImgDownloadListener", 2, "onFileDownloadSucceed, fileSize=" + this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.ImgDownloadListener.1
 * JD-Core Version:    0.7.0.1
 */