package com.tencent.mobileqq.nearby;

import android.os.SystemClock;
import android.text.TextUtils;
import asyy;
import axrn;
import bbfj;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class ImgDownloadListener$2
  implements Runnable
{
  public ImgDownloadListener$2(asyy paramasyy, int paramInt) {}
  
  public void run()
  {
    long l = SystemClock.elapsedRealtime() - asyy.a(this.this$0);
    Object localObject2 = bbfj.a(asyy.a(this.this$0));
    Object localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = "wifi";
    }
    localObject2 = new HashMap();
    ((HashMap)localObject2).put("errorCode", String.valueOf(this.a));
    ((HashMap)localObject2).put("costTime", String.valueOf(l));
    ((HashMap)localObject2).put("apn", localObject1);
    ((HashMap)localObject2).put("param_NetType", bbfj.a(null) + "");
    axrn.a(asyy.a(this.this$0)).a("", asyy.a(this.this$0), false, l, 0L, (HashMap)localObject2, "", true);
    if (QLog.isColorLevel()) {
      QLog.d("ImgDownloadListener", 2, "onFileDownloadFailed, errorCode=" + this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.ImgDownloadListener.2
 * JD-Core Version:    0.7.0.1
 */