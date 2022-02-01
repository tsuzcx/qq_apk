package com.tencent.mobileqq.shortvideo.gesture;

import android.content.IntentFilter;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.utils.BusinessCommonConfig;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class GestureMgrDownload
{
  DownloadInfo a = null;
  int b = 0;
  ArrayList<GestureMgr.GestureStatusListener> c = new ArrayList();
  
  GestureMgrDownload()
  {
    a(BaseApplicationImpl.getApplication());
    this.a = DownloadInfo.get();
    this.b = GestureUtil.a(this.a);
    QLog.d("QavGesture", 1, String.format("GestureMgr, mStatusGesture[%s]", new Object[] { Integer.valueOf(this.b) }));
  }
  
  void a(boolean paramBoolean, GestureMgr.GestureStatusListener paramGestureStatusListener)
  {
    ArrayList localArrayList = this.c;
    if (paramBoolean) {}
    try
    {
      this.c.add(paramGestureStatusListener);
      break label32;
      this.c.remove(paramGestureStatusListener);
      label32:
      return;
    }
    finally {}
  }
  
  boolean a()
  {
    this.a = DownloadInfo.get();
    this.b = GestureUtil.a(this.a);
    boolean bool2 = QLog.isDevelopLevel();
    boolean bool1 = false;
    if (bool2) {
      QLog.d("QavGesture", 4, String.format("checkResReady, mStatusGesture[%s]", new Object[] { Integer.valueOf(this.b) }));
    }
    if (11 != this.b) {
      bool1 = true;
    }
    return bool1;
  }
  
  boolean a(BaseApplicationImpl paramBaseApplicationImpl)
  {
    boolean bool2 = QLog.isDevelopLevel();
    boolean bool1 = false;
    if (bool2) {
      QLog.d("QavGesture", 4, String.format("registReceiver[%s]", new Object[] { paramBaseApplicationImpl.getQQProcessName() }));
    }
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("tencent.video.gesturemgr.notify");
    if (paramBaseApplicationImpl.registerReceiver(new GestureMgrDownload.1(this), localIntentFilter) != null) {
      bool1 = true;
    }
    return bool1;
  }
  
  boolean b()
  {
    return this.b == 1;
  }
  
  boolean c()
  {
    this.a = DownloadInfo.get();
    int i = this.b;
    this.b = GestureUtil.a(this.a);
    boolean bool;
    if (this.b == 11)
    {
      this.b = 12;
      BusinessCommonConfig.notifyQQDownload(1, null, 0);
      bool = true;
    }
    else
    {
      bool = false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QavGesture", 2, String.format("nodifyDownloadRes, lastStatus[%s], mStatusGesture[%s]", new Object[] { Integer.valueOf(i), Integer.valueOf(this.b) }));
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.gesture.GestureMgrDownload
 * JD-Core Version:    0.7.0.1
 */