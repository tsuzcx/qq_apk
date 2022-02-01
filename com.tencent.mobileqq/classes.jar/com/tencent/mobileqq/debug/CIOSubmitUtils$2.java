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
    String str2;
    try
    {
      str2 = Environment.getExternalStorageDirectory() + "/cio_mobile_qq";
      CIOSubmitUtils.a(str2);
      Object localObject1 = "";
      if (MobileQQ.sProcessId == 1) {
        localObject1 = CIOSubmitUtils.b();
      }
      CIOSubmitUtils.a(str2, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, this.c, (String)localObject1, this.d, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
      str2 = (String)CIOSubmitUtils.a(str2, "com.tencent.mobileqq").second;
      localObject1 = CIOSubmitUtils.a((String)localObject1, str2, "8.5.5");
      localObject2 = new StringBuffer(1024);
      localObject3 = ((JSONObject)localObject1).keys();
      String str3 = (String)((Iterator)localObject3).next();
      String str4 = ((JSONObject)localObject1).getString(str3);
      ((StringBuffer)localObject2).append(str3).append("=").append(URLEncoder.encode(str4, "UTF-8"));
      while (((Iterator)localObject3).hasNext())
      {
        str3 = (String)((Iterator)localObject3).next();
        str4 = ((JSONObject)localObject1).getString(str3);
        ((StringBuffer)localObject2).append("&").append(str3).append("=").append(URLEncoder.encode(str4, "UTF-8"));
      }
      ((StringBuffer)localObject2).append("&a=1");
    }
    catch (Throwable localThrowable)
    {
      QLog.e("CIOSubmitUtils", 1, "submitCIOReportAsyncV2 ERR", localThrowable);
      return;
    }
    Object localObject2 = "https://sngapm.qq.com/entrance/1/uploadFile/?" + ((StringBuffer)localObject2).toString();
    if (QLog.isColorLevel()) {
      QLog.i("CIOSubmitUtils", 2, "[qcloud_report_cio] file url: " + (String)localObject2);
    }
    Object localObject3 = new CIOSubmitUtils.UploadFileUtil(BaseApplication.getContext());
    ((CIOSubmitUtils.UploadFileUtil)localObject3).a(str2);
    ((CIOSubmitUtils.UploadFileUtil)localObject3).b((String)localObject2);
    ((CIOSubmitUtils.UploadFileUtil)localObject3).a(localThrowable);
    String str1 = ((CIOSubmitUtils.UploadFileUtil)localObject3).a();
    if (QLog.isColorLevel()) {
      QLog.d("CIOSubmitUtils", 2, "submitCIOReportAsyncV2 result:" + str1);
    }
    CIOSubmitUtils.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.debug.CIOSubmitUtils.2
 * JD-Core Version:    0.7.0.1
 */