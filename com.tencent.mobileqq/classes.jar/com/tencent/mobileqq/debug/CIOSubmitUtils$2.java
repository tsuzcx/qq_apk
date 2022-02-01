package com.tencent.mobileqq.debug;

import android.os.Environment;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import java.net.URLEncoder;
import java.util.Iterator;
import mqq.app.MobileQQ;
import org.json.JSONObject;

final class CIOSubmitUtils$2
  implements Runnable
{
  public void run()
  {
    try
    {
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(Environment.getExternalStorageDirectory());
      ((StringBuilder)localObject1).append("/cio_mobile_qq");
      Object localObject2 = ((StringBuilder)localObject1).toString();
      CIOSubmitUtils.a((String)localObject2);
      localObject1 = "";
      if (MobileQQ.sProcessId == 1) {
        localObject1 = CIOSubmitUtils.c();
      }
      CIOSubmitUtils.a((String)localObject2, this.a, this.b, this.c, (String)localObject1, this.d, this.e, this.f);
      localObject2 = (String)CIOSubmitUtils.a((String)localObject2, "com.tencent.mobileqq").second;
      localObject1 = CIOSubmitUtils.a((String)localObject1, (String)localObject2, "8.8.17");
      Object localObject3 = new StringBuffer(1024);
      Object localObject4 = ((JSONObject)localObject1).keys();
      String str1 = (String)((Iterator)localObject4).next();
      String str2 = ((JSONObject)localObject1).getString(str1);
      ((StringBuffer)localObject3).append(str1);
      ((StringBuffer)localObject3).append("=");
      ((StringBuffer)localObject3).append(URLEncoder.encode(str2, "UTF-8"));
      while (((Iterator)localObject4).hasNext())
      {
        str1 = (String)((Iterator)localObject4).next();
        str2 = ((JSONObject)localObject1).getString(str1);
        ((StringBuffer)localObject3).append("&");
        ((StringBuffer)localObject3).append(str1);
        ((StringBuffer)localObject3).append("=");
        ((StringBuffer)localObject3).append(URLEncoder.encode(str2, "UTF-8"));
      }
      ((StringBuffer)localObject3).append("&a=1");
      localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append("https://sngapm.qq.com/entrance/1/uploadFile/?");
      ((StringBuilder)localObject4).append(((StringBuffer)localObject3).toString());
      localObject3 = ((StringBuilder)localObject4).toString();
      if (QLog.isColorLevel())
      {
        localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append("[qcloud_report_cio] file url: ");
        ((StringBuilder)localObject4).append((String)localObject3);
        QLog.i("CIOSubmitUtils", 2, ((StringBuilder)localObject4).toString());
      }
      localObject4 = new CIOSubmitUtils.UploadFileUtil(BaseApplication.getContext());
      ((CIOSubmitUtils.UploadFileUtil)localObject4).a((String)localObject2);
      ((CIOSubmitUtils.UploadFileUtil)localObject4).b((String)localObject3);
      ((CIOSubmitUtils.UploadFileUtil)localObject4).a((JSONObject)localObject1);
      localObject1 = ((CIOSubmitUtils.UploadFileUtil)localObject4).a();
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("submitCIOReportAsyncV2 result:");
        ((StringBuilder)localObject2).append((String)localObject1);
        QLog.d("CIOSubmitUtils", 2, ((StringBuilder)localObject2).toString());
      }
      CIOSubmitUtils.b();
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("CIOSubmitUtils", 1, "submitCIOReportAsyncV2 ERR", localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.debug.CIOSubmitUtils.2
 * JD-Core Version:    0.7.0.1
 */