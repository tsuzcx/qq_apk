package com.tencent.mobileqq.transfile;

import android.os.SystemClock;
import bdmc;
import bexk;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.qphone.base.util.BaseApplication;
import java.io.File;
import java.text.DecimalFormat;
import java.util.HashMap;

public class ShortVideoUploadProcessor$7
  implements Runnable
{
  public ShortVideoUploadProcessor$7(bexk parambexk, String paramString) {}
  
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
    bdmc.a(BaseApplication.getContext()).a(null, "actShortVideoMoov", false, l4 - l1, -1L, (HashMap)localObject, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.ShortVideoUploadProcessor.7
 * JD-Core Version:    0.7.0.1
 */