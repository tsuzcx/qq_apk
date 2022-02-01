package com.tencent.mobileqq.shortvideo.gesture;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class GestureMgr
{
  private static volatile GestureMgr c;
  GestureMgrDownload a = null;
  GestureMgrAppDownload b = null;
  
  public static void a()
  {
    GestureMgr localGestureMgr = e();
    if (QLog.isDevelopLevel()) {
      QLog.d("QavGesture", 4, String.format("onDownloadRequest, mStatusGesture[%s]", new Object[] { Integer.valueOf(localGestureMgr.a.b) }));
    }
    GestureMgrAppDownload.a();
  }
  
  public static GestureMgr e()
  {
    if (c == null) {
      try
      {
        if (c == null)
        {
          GestureMgr localGestureMgr = new GestureMgr();
          localGestureMgr.g();
          c = localGestureMgr;
        }
      }
      finally {}
    }
    return c;
  }
  
  private void g()
  {
    this.a = new GestureMgrDownload();
    if ((BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface)) {
      this.b = new GestureMgrAppDownload();
    }
  }
  
  public void a(boolean paramBoolean, GestureMgr.GestureStatusListener paramGestureStatusListener)
  {
    this.a.a(paramBoolean, paramGestureStatusListener);
  }
  
  public boolean b()
  {
    return this.a.a();
  }
  
  public boolean c()
  {
    return this.a.c();
  }
  
  public boolean d()
  {
    return this.a.b();
  }
  
  public boolean f()
  {
    return this.a.b == 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.gesture.GestureMgr
 * JD-Core Version:    0.7.0.1
 */