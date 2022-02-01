package com.tencent.qqprotect.qsec;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.List;

class QSecLibMgr$QSecHandler
  extends Handler
{
  public QSecLibMgr$QSecHandler(QSecLibMgr paramQSecLibMgr, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      do
      {
        return;
        QSecLibMgr.a(this.a);
        return;
      } while (paramMessage.obj == null);
      QSecLibMgr.a(this.a, (List)paramMessage.obj);
      return;
      QSecLibMgr.b(this.a);
      return;
      QSecLibMgr.c(this.a);
      return;
    } while (paramMessage.obj == null);
    QSecLibMgr.a(this.a, (QSecLibMgr.LibEventListener)paramMessage.obj);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqprotect.qsec.QSecLibMgr.QSecHandler
 * JD-Core Version:    0.7.0.1
 */