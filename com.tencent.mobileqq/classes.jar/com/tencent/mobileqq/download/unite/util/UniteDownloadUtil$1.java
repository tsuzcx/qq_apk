package com.tencent.mobileqq.download.unite.util;

import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;

final class UniteDownloadUtil$1
  implements Handler.Callback
{
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 1)
    {
      long l = ((Long)paramMessage.obj).longValue();
      if (QLog.isColorLevel()) {
        QLog.d("[UniteDownload] UniteDownloadUtil", 2, new Object[] { "dialogCallbackHandler is Contain: ", Boolean.valueOf(UniteDownloadUtil.a().containsKey(Long.valueOf(l))) });
      }
      if (UniteDownloadUtil.a().containsKey(Long.valueOf(l)))
      {
        UniteDownloadUtil.DownloadDialogListener localDownloadDialogListener = (UniteDownloadUtil.DownloadDialogListener)UniteDownloadUtil.a().get(Long.valueOf(l));
        if (localDownloadDialogListener != null)
        {
          localDownloadDialogListener.a(paramMessage.arg1);
          UniteDownloadUtil.a().remove(Long.valueOf(l));
        }
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.download.unite.util.UniteDownloadUtil.1
 * JD-Core Version:    0.7.0.1
 */