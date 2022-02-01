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
    int i = paramMessage.what;
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3)
        {
          if (i != 4)
          {
            if (i != 5) {
              return;
            }
            if (paramMessage.obj != null) {
              QSecLibMgr.a(this.a, (QSecLibMgr.LibEventListener)paramMessage.obj);
            }
          }
          else
          {
            QSecLibMgr.c(this.a);
          }
        }
        else {
          QSecLibMgr.b(this.a);
        }
      }
      else if (paramMessage.obj != null) {
        QSecLibMgr.a(this.a, (List)paramMessage.obj);
      }
    }
    else {
      QSecLibMgr.a(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqprotect.qsec.QSecLibMgr.QSecHandler
 * JD-Core Version:    0.7.0.1
 */