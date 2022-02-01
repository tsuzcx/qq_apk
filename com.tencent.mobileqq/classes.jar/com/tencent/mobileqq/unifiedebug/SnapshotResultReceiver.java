package com.tencent.mobileqq.unifiedebug;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.secspy.SecSpyFileManager;
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
    Object localObject1 = this.a;
    if (localObject1 != null)
    {
      localObject1 = (SecSpyFileManager)((QQAppInterface)localObject1).getManager(QQManagerFactory.SEC_SPY_FILEMANAGER);
    }
    else
    {
      if (QLog.isColorLevel()) {
        QLog.d("SnapshotResultReceiver", 2, "mApp.getManager(QQAppInterface.SEC_SPY_FILEMANAGER) == null");
      }
      localObject1 = null;
    }
    long l;
    Object localObject2;
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt != 3) {
            return;
          }
          if (localObject1 != null)
          {
            l = paramBundle.getLong("seq");
            ((SecSpyFileManager)localObject1).a(l);
            ((SecSpyFileManager)localObject1).a(l, -1, new Object[] { "can't find x5's method: snapshotVisibleWithBitmap" });
          }
        }
        else if (localObject1 != null)
        {
          localObject2 = paramBundle.getString("debugUrl");
          paramInt = paramBundle.getInt("maxCount");
          l = paramBundle.getLong("seq");
          ((SecSpyFileManager)localObject1).a((String)localObject2, paramInt, paramBundle.getLong("delay"), l, paramBundle.getString("seqKey"));
          if (QLog.isColorLevel())
          {
            paramBundle = new StringBuilder();
            paramBundle.append("RESULT_WEBVIEW_INVALID, restart alive snapshot. seq=");
            paramBundle.append(l);
            QLog.d("SnapshotResultReceiver", 2, paramBundle.toString());
          }
        }
        else if (QLog.isColorLevel())
        {
          QLog.d("SnapshotResultReceiver", 2, "RESULT_WEBVIEW_INVALID, manager == null");
        }
      }
      else
      {
        localObject2 = paramBundle.getStringArrayList("snapshotPaths");
        l = paramBundle.getLong("seq");
        paramBundle = paramBundle.getString("seqKey");
        if (localObject1 != null) {
          ((SecSpyFileManager)localObject1).b((List)localObject2, l, paramBundle);
        }
        if (QLog.isColorLevel())
        {
          paramBundle = new StringBuilder();
          paramBundle.append("RESULT_FINISH_ALIVE_SNAPSHOT, seq=");
          paramBundle.append(l);
          QLog.d("SnapshotResultReceiver", 2, paramBundle.toString());
        }
      }
    }
    else
    {
      localObject2 = paramBundle.getStringArrayList("snapshotPaths");
      l = paramBundle.getLong("seq");
      paramBundle = paramBundle.getString("seqKey");
      if (localObject1 != null) {
        ((SecSpyFileManager)localObject1).a((List)localObject2, l, paramBundle);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.unifiedebug.SnapshotResultReceiver
 * JD-Core Version:    0.7.0.1
 */