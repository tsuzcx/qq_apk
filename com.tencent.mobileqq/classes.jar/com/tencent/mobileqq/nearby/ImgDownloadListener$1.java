package com.tencent.mobileqq.nearby;

import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

class ImgDownloadListener$1
  implements Runnable
{
  ImgDownloadListener$1(ImgDownloadListener paramImgDownloadListener, long paramLong) {}
  
  public void run()
  {
    long l1 = SystemClock.elapsedRealtime();
    long l2 = ImgDownloadListener.a(this.this$0);
    Object localObject2 = NetworkUtil.getApn(ImgDownloadListener.a(this.this$0));
    Object localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = "wifi";
    }
    localObject2 = new HashMap();
    ((HashMap)localObject2).put("fileSize", String.valueOf(this.a));
    ((HashMap)localObject2).put("costTime", String.valueOf(l1 - l2));
    ((HashMap)localObject2).put("apn", localObject1);
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(NetworkUtil.getSystemNetwork(null));
    ((StringBuilder)localObject1).append("");
    ((HashMap)localObject2).put("param_NetType", ((StringBuilder)localObject1).toString());
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("onFileDownloadSucceed, fileSize=");
      ((StringBuilder)localObject1).append(this.a);
      QLog.d("ImgDownloadListener", 2, ((StringBuilder)localObject1).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.ImgDownloadListener.1
 * JD-Core Version:    0.7.0.1
 */