package com.tencent.mobileqq.transfile;

import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.highway.config.HwServlet;
import com.tencent.mobileqq.highway.openup.SessionInfo;

final class StoryUploadProcessor$2
  implements Runnable
{
  public void run()
  {
    String str = QQStoryContext.a().a();
    for (;;)
    {
      try
      {
        byte[] arrayOfByte1 = SessionInfo.getInstance(str).getHttpconn_sig_session();
        byte[] arrayOfByte2 = null;
        if (arrayOfByte1 != null)
        {
          int i = SessionInfo.getInstance(str).getHttpconn_sig_session().length;
          arrayOfByte1 = new byte[i];
          System.arraycopy(SessionInfo.getInstance(str).getHttpconn_sig_session(), 0, arrayOfByte1, 0, i);
          if (SessionInfo.getInstance(str).getSessionKey() != null)
          {
            i = SessionInfo.getInstance(str).getSessionKey().length;
            arrayOfByte2 = new byte[i];
            System.arraycopy(SessionInfo.getInstance(str).getSessionKey(), 0, arrayOfByte2, 0, i);
          }
          if ((arrayOfByte1 == null) || (arrayOfByte1.length == 0) || (arrayOfByte2 == null) || (arrayOfByte2.length == 0))
          {
            QQStoryContext.a();
            HwServlet.getConfig(QQStoryContext.a(), str);
            SLog.d(StoryUploadProcessor.TAG, "pull session key");
          }
          return;
        }
      }
      finally {}
      Object localObject2 = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.StoryUploadProcessor.2
 * JD-Core Version:    0.7.0.1
 */