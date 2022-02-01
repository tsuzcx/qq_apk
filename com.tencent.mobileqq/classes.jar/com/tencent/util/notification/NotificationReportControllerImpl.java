package com.tencent.util.notification;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Message;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import bdll;
import blhs;
import blhv;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.commonsdk.util.notification.NotificationReportController;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class NotificationReportControllerImpl
  implements Handler.Callback, NotificationReportController
{
  private static final String KEY_BEGINTIME = "key_begintime";
  private static final String KEY_TODAY_REPORTED_NOTIFY_IDS = "kay_reported_notify_ids";
  private boolean hasInitTodayReportedNotifyIds;
  private boolean isAfterActionB;
  private List<blhv> mCache = new ArrayList();
  Handler mHandler = null;
  private Set<Integer> mTodayReportedNotifyIds;
  
  public NotificationReportControllerImpl()
  {
    HandlerThread localHandlerThread = ThreadManager.newFreeHandlerThread("NotificationReportControllerImpl", 0);
    localHandlerThread.start();
    this.mHandler = new Handler(localHandlerThread.getLooper(), this);
  }
  
  private String getTodayReportedNotifyIdsInCache()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    Iterator localIterator = this.mTodayReportedNotifyIds.iterator();
    while (localIterator.hasNext()) {
      localStringBuffer.append((Integer)localIterator.next()).append(",");
    }
    return localStringBuffer.substring(0, localStringBuffer.length() - 1);
  }
  
  private void reportReal()
  {
    Object localObject;
    if ((0 == 0) && (BaseApplicationImpl.sProcessId == 1))
    {
      localObject = BaseApplicationImpl.getApplication().peekAppRuntime();
      if ((localObject == null) || (!(localObject instanceof QQAppInterface))) {}
    }
    for (QQAppInterface localQQAppInterface = (QQAppInterface)localObject;; localQQAppInterface = null)
    {
      if ((localQQAppInterface != null) && (this.mCache.size() > 0))
      {
        Iterator localIterator = this.mCache.iterator();
        if (localIterator.hasNext())
        {
          blhv localblhv = (blhv)localIterator.next();
          boolean bool = shouldReportNetInfo(localQQAppInterface, localblhv.b);
          localObject = "";
          switch (localblhv.jdField_a_of_type_Int)
          {
          default: 
            label132:
            if ((localblhv.c == 7200) || (localblhv.c == 1008) || (localblhv.c == 7220)) {
              bdll.a(localQQAppInterface, bool, "tech_push", "push", (String)localObject, "", 0, "", "", localblhv.jdField_a_of_type_JavaLangString, localblhv.b + "", "" + localblhv.c, "", "", "", "");
            }
            break;
          }
          while (QLog.isDevelopLevel())
          {
            QLog.d("NotificationReportControllerImpl", 2, "report real msgType:" + localblhv.jdField_a_of_type_Int + "    frienduin:" + localblhv.jdField_a_of_type_JavaLangString + "   uinType:" + localblhv.c + "    nId:" + localblhv.b);
            break;
            localObject = "info_arr";
            break label132;
            localObject = "clk";
            break label132;
            localObject = "lock_arr";
            break label132;
            localObject = "lock_clk";
            break label132;
            bdll.a(localQQAppInterface, bool, "tech_push", "push", (String)localObject, "", 0, "", "", "", localblhv.b + "", "", "", "", "", "");
          }
        }
        this.mCache.clear();
      }
      return;
    }
  }
  
  private boolean shouldReportNetInfo(QQAppInterface paramQQAppInterface, int paramInt)
  {
    if (!this.hasInitTodayReportedNotifyIds)
    {
      Object localObject = paramQQAppInterface.getAccount();
      SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(BaseApplicationImpl.getContext());
      long l1 = localSharedPreferences.getLong("key_begintime_" + (String)localObject, 0L);
      long l2 = blhs.a().longValue();
      this.mTodayReportedNotifyIds = new HashSet();
      if (l1 == l2)
      {
        localObject = localSharedPreferences.getString("kay_reported_notify_ids_" + (String)localObject, "");
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          localObject = ((String)localObject).split(",");
          int j = localObject.length;
          int i = 0;
          while (i < j)
          {
            localSharedPreferences = localObject[i];
            this.mTodayReportedNotifyIds.add(Integer.valueOf(localSharedPreferences));
            i += 1;
          }
        }
      }
      else
      {
        localSharedPreferences.edit().putLong("key_begintime_" + (String)localObject, l2).apply();
      }
      this.hasInitTodayReportedNotifyIds = true;
    }
    if (!this.mTodayReportedNotifyIds.contains(Integer.valueOf(paramInt)))
    {
      this.mTodayReportedNotifyIds.add(Integer.valueOf(paramInt));
      PreferenceManager.getDefaultSharedPreferences(BaseApplicationImpl.getContext()).edit().putString("kay_reported_notify_ids_" + paramQQAppInterface.getAccount(), getTodayReportedNotifyIdsInCache()).apply();
      return true;
    }
    return false;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return true;
    case 1: 
    case 2: 
    case 3: 
    case 4: 
      paramMessage = (blhv)paramMessage.obj;
      if (this.isAfterActionB)
      {
        this.mCache.add(paramMessage);
        reportReal();
        return true;
      }
      this.mCache.add(paramMessage);
      return true;
    }
    this.isAfterActionB = true;
    reportReal();
    return true;
  }
  
  public void report(int paramInt1, int paramInt2, String paramString, int paramInt3)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("NotificationReportControllerImpl", 2, "msgType:" + paramInt1 + "frienduin:" + paramString + "   uinType:" + paramInt3 + "    nId:" + paramInt2);
    }
    Message localMessage = Message.obtain();
    localMessage.what = paramInt1;
    localMessage.obj = new blhv(paramInt1, paramInt2, paramString, paramInt3);
    this.mHandler.sendMessage(localMessage);
  }
  
  public void reportAll()
  {
    Message localMessage = Message.obtain();
    localMessage.what = 5;
    this.mHandler.sendMessage(localMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.util.notification.NotificationReportControllerImpl
 * JD-Core Version:    0.7.0.1
 */