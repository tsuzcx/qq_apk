package com.tencent.mobileqq.qqlive.api.impl;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.qqlive.api.IQQLiveFollowApi.IQQLiveFollowStateListener;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

final class QQLiveFollowApiImpl$1
  extends BroadcastReceiver
{
  public void onReceive(Context arg1, Intent paramIntent)
  {
    if ((paramIntent != null) && ("ACTION_QQ_LIVE_WEB_FOLLOW_STATE".equals(paramIntent.getAction()))) {
      synchronized (QQLiveFollowApiImpl.access$000())
      {
        if (QQLiveFollowApiImpl.access$000().size() == 0) {
          return;
        }
        long l1 = paramIntent.getLongExtra("uid", 0L);
        long l2 = paramIntent.getLongExtra("followedUid", 0L);
        int i = paramIntent.getIntExtra("isFollowed", 0);
        paramIntent = paramIntent.getStringExtra("roomId");
        Object localObject = QQLiveFollowApiImpl.access$000().iterator();
        while (((Iterator)localObject).hasNext()) {
          ((IQQLiveFollowApi.IQQLiveFollowStateListener)((Iterator)localObject).next()).onFollowStateChange(l1, l2, i, paramIntent);
        }
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("[mWebFollowChangeReceiver],size:");
          ((StringBuilder)localObject).append(QQLiveFollowApiImpl.access$000().size());
          ((StringBuilder)localObject).append(",uid:");
          ((StringBuilder)localObject).append(l1);
          ((StringBuilder)localObject).append(",followedUid:");
          ((StringBuilder)localObject).append(l2);
          ((StringBuilder)localObject).append(",isFollowed:");
          ((StringBuilder)localObject).append(i);
          ((StringBuilder)localObject).append(",roomId:");
          ((StringBuilder)localObject).append(paramIntent);
          QLog.i("QQLiveFollowApiImpl", 2, ((StringBuilder)localObject).toString());
        }
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.api.impl.QQLiveFollowApiImpl.1
 * JD-Core Version:    0.7.0.1
 */