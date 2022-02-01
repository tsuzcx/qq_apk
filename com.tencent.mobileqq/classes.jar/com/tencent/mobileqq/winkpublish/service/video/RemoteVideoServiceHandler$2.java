package com.tencent.mobileqq.winkpublish.service.video;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import com.tencent.qcircle.cooperation.config.QCircleConfigHelper;
import com.tencent.qphone.base.util.QLog;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

class RemoteVideoServiceHandler$2
  implements ServiceConnection
{
  RemoteVideoServiceHandler$2(RemoteVideoServiceHandler paramRemoteVideoServiceHandler) {}
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    QLog.i(RemoteVideoServiceHandler.g(), 1, "RemoteVideoServiceHandler onServiceConnected");
    RemoteVideoServiceHandler.a(this.a, new Messenger(paramIBinder));
    paramComponentName = Message.obtain();
    paramComponentName.what = 1000;
    paramComponentName.replyTo = RemoteVideoServiceHandler.b(this.a);
    this.a.b(paramComponentName);
    this.a.c();
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    QLog.i(RemoteVideoServiceHandler.g(), 1, "RemoteVideoServiceHandler onServiceDisconnected");
    RemoteVideoServiceHandler.a(this.a, null);
    paramComponentName = QCircleConfigHelper.a("QZoneTextSetting", "UploadVideoServerLost", "视频合成服务连接丢失");
    Collection localCollection = (Collection)RemoteVideoServiceHandler.a(this.a).clone();
    RemoteVideoServiceHandler.a(this.a).clear();
    Iterator localIterator = localCollection.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      RemoteVideoServiceHandler.a(this.a, str, paramComponentName, 1);
    }
    localCollection.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.winkpublish.service.video.RemoteVideoServiceHandler.2
 * JD-Core Version:    0.7.0.1
 */