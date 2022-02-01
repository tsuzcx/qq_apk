package com.tencent.mobileqq.winkpublish.service.video;

import android.content.Intent;
import android.os.Message;
import com.tencent.qcircle.cooperation.config.QCircleConfigHelper;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentLinkedQueue;

class RemoteVideoServiceHandler$3
  implements Runnable
{
  RemoteVideoServiceHandler$3(RemoteVideoServiceHandler paramRemoteVideoServiceHandler) {}
  
  public void run()
  {
    while (!this.this$0.b.isEmpty())
    {
      Object localObject = (Message)this.this$0.b.poll();
      if (localObject != null) {
        try
        {
          this.this$0.a((Message)localObject);
        }
        catch (Exception localException)
        {
          QLog.w(RemoteVideoServiceHandler.g(), 1, localException.getMessage());
          localObject = (Intent)((Message)localObject).obj;
          if (localObject == null) {
            return;
          }
          localObject = ((Intent)localObject).getStringExtra("client_key");
          String str = QCircleConfigHelper.a("QZoneTextSetting", "UploadVideoComposeFail", "视频合成失败");
          RemoteVideoServiceHandler.a(this.this$0, (String)localObject, str, 2);
          this.this$0.b((String)localObject);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.winkpublish.service.video.RemoteVideoServiceHandler.3
 * JD-Core Version:    0.7.0.1
 */