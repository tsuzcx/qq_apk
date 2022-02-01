package com.tencent.mobileqq.richmedia.dc;

import android.os.Environment;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class DCShortVideo$1
  implements Runnable
{
  public void run()
  {
    DCShortVideo.DCShortVideoSendData localDCShortVideoSendData = new DCShortVideo.DCShortVideoSendData();
    Object localObject1 = new File(this.a);
    if (!((File)localObject1).exists()) {
      return;
    }
    localDCShortVideoSendData.p = ((File)localObject1).length();
    if (localDCShortVideoSendData.p <= 0L) {
      return;
    }
    this.this$0.a(this.b, this.c, this.d, this.e, localDCShortVideoSendData);
    localDCShortVideoSendData.r = this.f;
    localDCShortVideoSendData.q = this.g;
    try
    {
      Object localObject2 = this.a;
      String str = Environment.getExternalStorageDirectory().toString();
      localObject1 = localObject2;
      if (str != null)
      {
        localObject1 = localObject2;
        if (this.a.contains(str)) {
          localObject1 = this.a.replace(str, "");
        }
      }
      int m = ((String)localObject1).lastIndexOf("/");
      localObject2 = localObject1;
      if (m != -1) {
        localObject2 = ((String)localObject1).substring(0, m);
      }
      localDCShortVideoSendData.a = ((String)localObject2).replace("/", "//");
      if (!DCShortVideo.a(this.this$0, localDCShortVideoSendData, this.a)) {
        return;
      }
      DCShortVideo.a(this.this$0, this.b, localDCShortVideoSendData, this.h, this.i, this.j);
      localDCShortVideoSendData.j = this.k;
      localDCShortVideoSendData.n = ((int)((System.currentTimeMillis() - new File(this.a).lastModified()) / 60000L));
      if (localDCShortVideoSendData.n == 0) {
        localDCShortVideoSendData.n = 1;
      }
      if (QLog.isDevelopLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("[reportSend]url=");
        ((StringBuilder)localObject1).append(localDCShortVideoSendData.a);
        ((StringBuilder)localObject1).append(",shortVideoType=");
        ((StringBuilder)localObject1).append(localDCShortVideoSendData.g);
        ((StringBuilder)localObject1).append(",shortVideoSourceType = ");
        ((StringBuilder)localObject1).append(localDCShortVideoSendData.m);
        ((StringBuilder)localObject1).append(",uinType = ");
        ((StringBuilder)localObject1).append(localDCShortVideoSendData.c);
        ((StringBuilder)localObject1).append(",groupMemCount = ");
        ((StringBuilder)localObject1).append(localDCShortVideoSendData.d);
        ((StringBuilder)localObject1).append(",isForward = ");
        ((StringBuilder)localObject1).append(localDCShortVideoSendData.b);
        ((StringBuilder)localObject1).append(",isExsit = ");
        ((StringBuilder)localObject1).append(localDCShortVideoSendData.j);
        ((StringBuilder)localObject1).append(",age = ");
        ((StringBuilder)localObject1).append(localDCShortVideoSendData.e);
        ((StringBuilder)localObject1).append(",gender = ");
        ((StringBuilder)localObject1).append(localDCShortVideoSendData.f);
        ((StringBuilder)localObject1).append(",userType = ");
        ((StringBuilder)localObject1).append(localDCShortVideoSendData.o);
        ((StringBuilder)localObject1).append(",reprotHour = ");
        ((StringBuilder)localObject1).append(localDCShortVideoSendData.h);
        ((StringBuilder)localObject1).append(",fileInterval = ");
        ((StringBuilder)localObject1).append(localDCShortVideoSendData.n);
        ((StringBuilder)localObject1).append(",netType = ");
        ((StringBuilder)localObject1).append(localDCShortVideoSendData.i);
        ((StringBuilder)localObject1).append(",forwardSourceGroupMemCount = ");
        ((StringBuilder)localObject1).append(localDCShortVideoSendData.l);
        ((StringBuilder)localObject1).append(",forwardSourceUinType = ");
        ((StringBuilder)localObject1).append(localDCShortVideoSendData.k);
        ((StringBuilder)localObject1).append(",duration = ");
        ((StringBuilder)localObject1).append(localDCShortVideoSendData.r);
        ((StringBuilder)localObject1).append(",fileSize = ");
        ((StringBuilder)localObject1).append(localDCShortVideoSendData.p);
        ((StringBuilder)localObject1).append(",md5 = ");
        ((StringBuilder)localObject1).append(localDCShortVideoSendData.q);
        QLog.d("DCShortVideo", 4, ((StringBuilder)localObject1).toString());
      }
      localObject1 = new DataReport.ReportTask("ShortVideo.Send", localDCShortVideoSendData.a("ShortVideo.Send"));
      DataReport.a().a((DataReport.ReportTask)localObject1);
      return;
    }
    catch (Exception localException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.dc.DCShortVideo.1
 * JD-Core Version:    0.7.0.1
 */