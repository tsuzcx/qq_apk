package com.tencent.util.notification;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Message;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.commonsdk.util.notification.NotificationReportController;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import mqq.app.MobileQQ;

public class NotificationReportControllerImpl
  implements Handler.Callback, NotificationReportController
{
  private static final String KEY_BEGINTIME = "key_begintime";
  private static final String KEY_TODAY_REPORTED_NOTIFY_IDS = "kay_reported_notify_ids";
  private boolean hasInitTodayReportedNotifyIds = false;
  private boolean isAfterActionB = false;
  private List<NotificationReportControllerImpl.ReportEntry> mCache = new ArrayList();
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
    while (localIterator.hasNext())
    {
      localStringBuffer.append((Integer)localIterator.next());
      localStringBuffer.append(",");
    }
    return localStringBuffer.substring(0, localStringBuffer.length() - 1);
  }
  
  private void reportReal()
  {
    Object localObject1;
    if (MobileQQ.sProcessId == 1)
    {
      localObject1 = MobileQQ.sMobileQQ.peekAppRuntime();
      if ((localObject1 != null) && ((localObject1 instanceof BaseQQAppInterface)))
      {
        localBaseQQAppInterface = (BaseQQAppInterface)localObject1;
        break label37;
      }
    }
    BaseQQAppInterface localBaseQQAppInterface = null;
    label37:
    if ((localBaseQQAppInterface != null) && (this.mCache.size() > 0))
    {
      Iterator localIterator = this.mCache.iterator();
      while (localIterator.hasNext())
      {
        NotificationReportControllerImpl.ReportEntry localReportEntry = (NotificationReportControllerImpl.ReportEntry)localIterator.next();
        boolean bool = shouldReportNetInfo(localBaseQQAppInterface, localReportEntry.b);
        int i = localReportEntry.a;
        if (i != 1)
        {
          if (i != 2)
          {
            if (i != 3)
            {
              if (i != 4) {
                localObject1 = "";
              } else {
                localObject1 = "lock_clk";
              }
            }
            else {
              localObject1 = "lock_arr";
            }
          }
          else {
            localObject1 = "clk";
          }
        }
        else {
          localObject1 = "info_arr";
        }
        Object localObject2;
        if ((localReportEntry.d != 7200) && (localReportEntry.d != 1008) && (localReportEntry.d != 7220))
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(localReportEntry.b);
          ((StringBuilder)localObject2).append("");
          ReportController.a(localBaseQQAppInterface, bool, "tech_push", "push", (String)localObject1, "", 0, "", "", "", ((StringBuilder)localObject2).toString(), "", "", "", "", "");
        }
        else
        {
          localObject2 = localReportEntry;
          String str = ((NotificationReportControllerImpl.ReportEntry)localObject2).c;
          Object localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append(((NotificationReportControllerImpl.ReportEntry)localObject2).b);
          ((StringBuilder)localObject3).append("");
          localObject3 = ((StringBuilder)localObject3).toString();
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("");
          localStringBuilder.append(((NotificationReportControllerImpl.ReportEntry)localObject2).d);
          ReportController.a(localBaseQQAppInterface, bool, "tech_push", "push", (String)localObject1, "", 0, "", "", str, (String)localObject3, localStringBuilder.toString(), "", "", "", "");
        }
        if (QLog.isDevelopLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("report real msgType:");
          ((StringBuilder)localObject1).append(localReportEntry.a);
          ((StringBuilder)localObject1).append("    frienduin:");
          ((StringBuilder)localObject1).append(localReportEntry.c);
          ((StringBuilder)localObject1).append("   uinType:");
          ((StringBuilder)localObject1).append(localReportEntry.d);
          ((StringBuilder)localObject1).append("    nId:");
          ((StringBuilder)localObject1).append(localReportEntry.b);
          QLog.d("NotificationReportControllerImpl", 2, ((StringBuilder)localObject1).toString());
        }
      }
      this.mCache.clear();
    }
  }
  
  private boolean shouldReportNetInfo(BaseQQAppInterface paramBaseQQAppInterface, int paramInt)
  {
    boolean bool2 = this.hasInitTodayReportedNotifyIds;
    boolean bool1 = false;
    Object localObject1;
    Object localObject2;
    if (!bool2)
    {
      localObject1 = paramBaseQQAppInterface.getAccount();
      localObject2 = PreferenceManager.getDefaultSharedPreferences(BaseApplication.getContext());
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("key_begintime_");
      localStringBuilder.append((String)localObject1);
      long l1 = ((SharedPreferences)localObject2).getLong(localStringBuilder.toString(), 0L);
      long l2 = NotificationController.a().longValue();
      this.mTodayReportedNotifyIds = new HashSet();
      if (l1 == l2)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("kay_reported_notify_ids_");
        localStringBuilder.append((String)localObject1);
        localObject1 = ((SharedPreferences)localObject2).getString(localStringBuilder.toString(), "");
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          localObject1 = ((String)localObject1).split(",");
          int j = localObject1.length;
          int i = 0;
          while (i < j)
          {
            localObject2 = localObject1[i];
            this.mTodayReportedNotifyIds.add(Integer.valueOf((String)localObject2));
            i += 1;
          }
        }
      }
      else
      {
        localObject2 = ((SharedPreferences)localObject2).edit();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("key_begintime_");
        localStringBuilder.append((String)localObject1);
        ((SharedPreferences.Editor)localObject2).putLong(localStringBuilder.toString(), l2).apply();
      }
      this.hasInitTodayReportedNotifyIds = true;
    }
    if (!this.mTodayReportedNotifyIds.contains(Integer.valueOf(paramInt)))
    {
      this.mTodayReportedNotifyIds.add(Integer.valueOf(paramInt));
      localObject1 = PreferenceManager.getDefaultSharedPreferences(BaseApplication.getContext()).edit();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("kay_reported_notify_ids_");
      ((StringBuilder)localObject2).append(paramBaseQQAppInterface.getAccount());
      ((SharedPreferences.Editor)localObject1).putString(((StringBuilder)localObject2).toString(), getTodayReportedNotifyIdsInCache()).apply();
      bool1 = true;
    }
    return bool1;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    if ((i != 1) && (i != 2) && (i != 3) && (i != 4))
    {
      if (i != 5) {
        return true;
      }
      this.isAfterActionB = true;
      reportReal();
      return true;
    }
    paramMessage = (NotificationReportControllerImpl.ReportEntry)paramMessage.obj;
    if (this.isAfterActionB)
    {
      this.mCache.add(paramMessage);
      reportReal();
      return true;
    }
    this.mCache.add(paramMessage);
    return true;
  }
  
  public void report(int paramInt1, int paramInt2, String paramString, int paramInt3)
  {
    if (QLog.isDevelopLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("msgType:");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append("frienduin:");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append("   uinType:");
      ((StringBuilder)localObject).append(paramInt3);
      ((StringBuilder)localObject).append("    nId:");
      ((StringBuilder)localObject).append(paramInt2);
      QLog.d("NotificationReportControllerImpl", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = Message.obtain();
    ((Message)localObject).what = paramInt1;
    ((Message)localObject).obj = new NotificationReportControllerImpl.ReportEntry(paramInt1, paramInt2, paramString, paramInt3);
    this.mHandler.sendMessage((Message)localObject);
  }
  
  public void reportAll()
  {
    Message localMessage = Message.obtain();
    localMessage.what = 5;
    this.mHandler.sendMessage(localMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.util.notification.NotificationReportControllerImpl
 * JD-Core Version:    0.7.0.1
 */