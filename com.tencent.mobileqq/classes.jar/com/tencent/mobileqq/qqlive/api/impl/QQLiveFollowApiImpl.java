package com.tencent.mobileqq.qqlive.api.impl;

import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import com.tencent.mobileqq.qqlive.api.IQQLiveFollowApi;
import com.tencent.mobileqq.qqlive.api.IQQLiveFollowApi.IQQLiveFollowStateListener;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.MobileQQ;

public class QQLiveFollowApiImpl
  implements IQQLiveFollowApi
{
  public static final String ACTION_QQ_LIVE_WEB_FOLLOW_STATE = "ACTION_QQ_LIVE_WEB_FOLLOW_STATE";
  public static final String KEY_FOLLOWED_UID = "followedUid";
  public static final String KEY_IS_FOLLOWED = "isFollowed";
  public static final String KEY_ROOM_ID = "roomId";
  public static final String KEY_UID = "uid";
  private static final String TAG = "QQLiveFollowApiImpl";
  private static final AtomicBoolean isInitBroadCast = new AtomicBoolean(false);
  private static final BroadcastReceiver mWebFollowChangeReceiver = new QQLiveFollowApiImpl.1();
  private static final List<IQQLiveFollowApi.IQQLiveFollowStateListener> sWebFollowChangeListeners = new ArrayList();
  
  public QQLiveFollowApiImpl()
  {
    registerBroadcast();
  }
  
  private static void registerBroadcast()
  {
    if ((MobileQQ.sMobileQQ != null) && (!isInitBroadCast.getAndSet(true)))
    {
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("ACTION_QQ_LIVE_WEB_FOLLOW_STATE");
      try
      {
        MobileQQ.sMobileQQ.registerReceiver(mWebFollowChangeReceiver, localIntentFilter);
        return;
      }
      catch (Throwable localThrowable)
      {
        QLog.e("QQLiveFollowApiImpl", 1, localThrowable, new Object[0]);
      }
    }
  }
  
  public void addWebFollowStateChangeListener(IQQLiveFollowApi.IQQLiveFollowStateListener paramIQQLiveFollowStateListener)
  {
    if (paramIQQLiveFollowStateListener == null) {
      return;
    }
    synchronized (sWebFollowChangeListeners)
    {
      sWebFollowChangeListeners.add(paramIQQLiveFollowStateListener);
      return;
    }
  }
  
  public void removeWebFollowStateChangeListener(IQQLiveFollowApi.IQQLiveFollowStateListener paramIQQLiveFollowStateListener)
  {
    synchronized (sWebFollowChangeListeners)
    {
      sWebFollowChangeListeners.remove(paramIQQLiveFollowStateListener);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.api.impl.QQLiveFollowApiImpl
 * JD-Core Version:    0.7.0.1
 */