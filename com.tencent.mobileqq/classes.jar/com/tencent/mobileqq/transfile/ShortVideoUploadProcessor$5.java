package com.tencent.mobileqq.transfile;

import android.os.SystemClock;
import com.tencent.mobileqq.shortvideo.SVUtils;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import java.io.File;
import java.text.DecimalFormat;
import java.util.HashMap;

class ShortVideoUploadProcessor$5
  implements Runnable
{
  ShortVideoUploadProcessor$5(ShortVideoUploadProcessor paramShortVideoUploadProcessor, String paramString) {}
  
  public void run()
  {
    long l1 = SystemClock.uptimeMillis();
    File localFile = new File(this.val$filePath);
    Object localObject1 = SVUtils.a(localFile);
    if (localObject1 == null) {
      return;
    }
    long l2 = Long.valueOf(localObject1.split("\\|")[0]).longValue();
    long l3 = Long.valueOf(localObject1.split("\\|")[1]).longValue();
    long l4 = SystemClock.uptimeMillis();
    localObject1 = new HashMap();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(l2);
    ((StringBuilder)localObject2).append("");
    ((HashMap)localObject1).put("param_moovOffset", ((StringBuilder)localObject2).toString());
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(l3);
    ((StringBuilder)localObject2).append("");
    ((HashMap)localObject1).put("param_moovSize", ((StringBuilder)localObject2).toString());
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(localFile.length());
    ((StringBuilder)localObject2).append("");
    ((HashMap)localObject1).put("param_videoLen", ((StringBuilder)localObject2).toString());
    localObject2 = new DecimalFormat("##.000");
    StringBuilder localStringBuilder = new StringBuilder();
    double d1 = l2;
    Double.isNaN(d1);
    double d2 = localFile.length();
    Double.isNaN(d2);
    localStringBuilder.append(((DecimalFormat)localObject2).format(d1 * 1.0D / d2));
    localStringBuilder.append("");
    ((HashMap)localObject1).put("param_moovPosition", localStringBuilder.toString());
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "actShortVideoMoov", false, l4 - l1, -1L, (HashMap)localObject1, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.ShortVideoUploadProcessor.5
 * JD-Core Version:    0.7.0.1
 */