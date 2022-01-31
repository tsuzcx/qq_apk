package com.tencent.mobileqq.unifiedebug;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import avyq;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class SnapshotResultReceiver
  extends ResultReceiver
{
  private QQAppInterface a;
  
  public SnapshotResultReceiver(QQAppInterface paramQQAppInterface, Handler paramHandler)
  {
    super(paramHandler);
    this.a = paramQQAppInterface;
  }
  
  protected void onReceiveResult(int paramInt, Bundle paramBundle)
  {
    super.onReceiveResult(paramInt, paramBundle);
    Object localObject2 = null;
    Object localObject1;
    if (this.a != null)
    {
      localObject1 = (avyq)this.a.getManager(94);
      switch (paramInt)
      {
      }
    }
    label271:
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return;
              localObject1 = localObject2;
              if (!QLog.isColorLevel()) {
                break;
              }
              QLog.d("SnapshotResultReceiver", 2, "mApp.getManager(QQAppInterface.SEC_SPY_FILEMANAGER) == null");
              localObject1 = localObject2;
              break;
              localObject2 = paramBundle.getStringArrayList("snapshotPaths");
              l = paramBundle.getLong("seq");
              paramBundle = paramBundle.getString("seqKey");
            } while (localObject1 == null);
            ((avyq)localObject1).a((List)localObject2, l, paramBundle);
            return;
            localObject2 = paramBundle.getStringArrayList("snapshotPaths");
            l = paramBundle.getLong("seq");
            paramBundle = paramBundle.getString("seqKey");
            if (localObject1 != null) {
              ((avyq)localObject1).b((List)localObject2, l, paramBundle);
            }
          } while (!QLog.isColorLevel());
          QLog.d("SnapshotResultReceiver", 2, "RESULT_FINISH_ALIVE_SNAPSHOT, seq=" + l);
          return;
          if (localObject1 == null) {
            break label271;
          }
          localObject2 = paramBundle.getString("debugUrl");
          paramInt = paramBundle.getInt("maxCount");
          l = paramBundle.getLong("seq");
          ((avyq)localObject1).a((String)localObject2, paramInt, paramBundle.getLong("delay"), l, paramBundle.getString("seqKey"));
        } while (!QLog.isColorLevel());
        QLog.d("SnapshotResultReceiver", 2, "RESULT_WEBVIEW_INVALID, restart alive snapshot. seq=" + l);
        return;
      } while (!QLog.isColorLevel());
      QLog.d("SnapshotResultReceiver", 2, "RESULT_WEBVIEW_INVALID, manager == null");
      return;
    } while (localObject1 == null);
    long l = paramBundle.getLong("seq");
    ((avyq)localObject1).a(l);
    ((avyq)localObject1).a(l, -1, new Object[] { "can't find x5's method: snapshotVisibleWithBitmap" });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.unifiedebug.SnapshotResultReceiver
 * JD-Core Version:    0.7.0.1
 */