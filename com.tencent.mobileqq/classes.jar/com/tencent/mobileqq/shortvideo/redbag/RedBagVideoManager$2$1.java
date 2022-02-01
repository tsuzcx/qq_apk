package com.tencent.mobileqq.shortvideo.redbag;

import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

class RedBagVideoManager$2$1
  extends DownloadListener
{
  RedBagVideoManager$2$1(RedBagVideoManager.2 param2, String paramString1, String paramString2, String paramString3) {}
  
  public void onDone(DownloadTask paramDownloadTask)
  {
    int i = 0;
    boolean bool = true;
    try
    {
      if (paramDownloadTask.a() == 3)
      {
        if (QLog.isColorLevel()) {
          QLog.d("RedBagVideoManager", 2, "checkAndDownloadRes : [onDone] download finished " + this.jdField_a_of_type_JavaLangString);
        }
        paramDownloadTask = RedBagVideoManager.a(this.b);
        if (this.c.equalsIgnoreCase(paramDownloadTask))
        {
          RedBagVideoManager.a(this.b);
          RedBagVideoManager.a(RedBagVideoManager.jdField_a_of_type_JavaLangString + "videoRedbagResInfo", this.c);
          SharedPreUtils.e(BaseApplication.getContext(), false);
          break label271;
        }
      }
      for (;;)
      {
        paramDownloadTask = new HashMap();
        paramDownloadTask.put("param_FailCode", String.valueOf(i));
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "videoRedbagResDownload", bool, 0L, 0L, paramDownloadTask, "");
        RedBagVideoManager.jdField_a_of_type_Boolean = false;
        return;
        if (QLog.isColorLevel()) {
          QLog.d("RedBagVideoManager", 2, "[onDone] checkMd5 failed: " + this.b);
        }
        FileUtils.e(this.b);
        bool = false;
        i = 80704;
        break label271;
        if (QLog.isColorLevel()) {
          QLog.d("RedBagVideoManager", 2, "checkAndDownloadRes : [onDone] downloadFile failed: " + paramDownloadTask.b + " code=" + paramDownloadTask.a);
        }
        i = paramDownloadTask.a;
        bool = false;
      }
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.redbag.RedBagVideoManager.2.1
 * JD-Core Version:    0.7.0.1
 */