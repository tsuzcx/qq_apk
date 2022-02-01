package com.tencent.mobileqq.shortvideo.gesture;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

class GestureMgrDownload$1
  extends BroadcastReceiver
{
  GestureMgrDownload$1(GestureMgrDownload paramGestureMgrDownload) {}
  
  public void onReceive(Context arg1, Intent paramIntent)
  {
    if (paramIntent != null)
    {
      if (paramIntent.getAction() == null) {
        return;
      }
      if ("tencent.video.gesturemgr.notify".equals(paramIntent.getAction()))
      {
        int i = paramIntent.getIntExtra("Event_Progress", 0);
        if ((i != 100) && (i >= 0))
        {
          if (QLog.isDevelopLevel()) {
            QLog.d("QavGesture", 4, String.format("receive notify, progress[%s]", new Object[] { Integer.valueOf(i) }));
          }
          paramIntent = new ArrayList();
          synchronized (this.a.c)
          {
            paramIntent.addAll(this.a.c);
            ??? = paramIntent.iterator();
            if (!???.hasNext()) {
              return;
            }
            ((GestureMgr.GestureStatusListener)???.next()).a(i);
          }
        }
        this.a.a = DownloadInfo.get();
        int j = this.a.b;
        ??? = this.a;
        ???.b = GestureUtil.a(???.a);
        boolean bool;
        if ((i == 100) && (this.a.b != 11)) {
          bool = true;
        } else {
          bool = false;
        }
        if (QLog.isColorLevel()) {
          QLog.d("QavGesture", 2, String.format("receive notify, lastStatus[%s], progress[%s], mStatusGesture[%s], data[%s]", new Object[] { Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(this.a.b), this.a.a }));
        }
        paramIntent = new ArrayList();
        synchronized (this.a.c)
        {
          paramIntent.addAll(this.a.c);
          ??? = paramIntent.iterator();
          if (???.hasNext()) {
            ((GestureMgr.GestureStatusListener)???.next()).a(bool, this.a.b(), this.a.b);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.gesture.GestureMgrDownload.1
 * JD-Core Version:    0.7.0.1
 */