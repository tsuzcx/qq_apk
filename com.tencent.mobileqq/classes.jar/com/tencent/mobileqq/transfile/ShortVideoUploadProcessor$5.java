package com.tencent.mobileqq.transfile;

import android.os.SystemClock;
import awrn;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
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
    File localFile = new File(this.a);
    Object localObject = ShortVideoUtils.e(localFile);
    if (localObject == null) {
      return;
    }
    long l2 = Long.valueOf(localObject.split("\\|")[0]).longValue();
    long l3 = Long.valueOf(localObject.split("\\|")[1]).longValue();
    long l4 = SystemClock.uptimeMillis();
    localObject = new HashMap();
    ((HashMap)localObject).put("param_moovOffset", l2 + "");
    ((HashMap)localObject).put("param_moovSize", l3 + "");
    ((HashMap)localObject).put("param_videoLen", localFile.length() + "");
    DecimalFormat localDecimalFormat = new DecimalFormat("##.000");
    ((HashMap)localObject).put("param_moovPosition", localDecimalFormat.format(l2 * 1.0D / localFile.length()) + "");
    awrn.a(BaseApplication.getContext()).a(null, "actShortVideoMoov", false, l4 - l1, -1L, (HashMap)localObject, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.ShortVideoUploadProcessor.5
 * JD-Core Version:    0.7.0.1
 */