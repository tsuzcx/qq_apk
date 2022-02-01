package com.tencent.mobileqq.flashshow.manager;

import com.tencent.biz.qcircleshadow.lib.variation.HostFileUtils;
import com.tencent.qphone.base.util.QLog;

class FSRichMediaDownLoadManager$1
  implements Runnable
{
  FSRichMediaDownLoadManager$1(FSRichMediaDownLoadManager paramFSRichMediaDownLoadManager, FSRichMediaDownLoadManager.DownLoadParams paramDownLoadParams) {}
  
  public void run()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(FSRichMediaDownLoadManager.c());
    localStringBuilder.append(".nomedia");
    HostFileUtils.createFileIfNotExits(localStringBuilder.toString());
    if (HostFileUtils.fileExists(this.a.b()))
    {
      if (FSRichMediaDownLoadManager.DownLoadParams.a(this.a) != null) {
        FSRichMediaDownLoadManager.DownLoadParams.a(this.a).a(true);
      }
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.a.a());
      localStringBuilder.append(",download file is existed ");
      QLog.d("FSRichMediaDownLoadManager", 1, localStringBuilder.toString());
      return;
    }
    if (HostFileUtils.fileExists(this.a.c()))
    {
      if (!FSRichMediaDownLoadManager.a(this.this$0, this.a)) {
        FSRichMediaDownLoadManager.b(this.this$0, this.a);
      }
    }
    else {
      FSRichMediaDownLoadManager.b(this.this$0, this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.manager.FSRichMediaDownLoadManager.1
 * JD-Core Version:    0.7.0.1
 */