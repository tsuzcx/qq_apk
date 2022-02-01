package com.tencent.mobileqq.filemanager.activity.recentfile;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.app.MobileQQ;

class QfileBaseRecentFileTabView$2$1
  implements Runnable
{
  QfileBaseRecentFileTabView$2$1(QfileBaseRecentFileTabView.2 param2, List paramList) {}
  
  public void run()
  {
    if (QLog.isDevelopLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Thread id: ");
      ((StringBuilder)localObject).append(Thread.currentThread().getId());
      ((StringBuilder)localObject).append(" queryFileEntitiesFromDB addAll");
      QLog.e("crashBUG", 1, ((StringBuilder)localObject).toString());
    }
    if (QLog.isColorLevel())
    {
      localObject = QfileBaseRecentFileTabView.a;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("queryFileEntitiesFromDB end size[");
      localStringBuilder.append(this.a.size());
      localStringBuilder.append("]");
      QLog.i((String)localObject, 2, localStringBuilder.toString());
    }
    this.b.this$0.a(this.a);
    if (QLog.isColorLevel())
    {
      localObject = QfileBaseRecentFileTabView.a;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("initFileEntities size[");
      localStringBuilder.append(this.b.this$0.k.size());
      localStringBuilder.append("]");
      QLog.i((String)localObject, 2, localStringBuilder.toString());
    }
    this.b.this$0.getRecentFileRecords();
    Object localObject = QfileBaseRecentFileTabView.d(this.b.this$0).getApplication();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("OfflineFileMerge");
    localStringBuilder.append(QfileBaseRecentFileTabView.c(this.b.this$0).getCurrentUin());
    localObject = ((MobileQQ)localObject).getSharedPreferences(localStringBuilder.toString(), 0);
    long l1 = ((SharedPreferences)localObject).getLong("LastRequestTime", 0L);
    long l2 = System.currentTimeMillis();
    if (Math.abs(l2 - l1) > 86400000L)
    {
      QLog.i(QfileBaseRecentFileTabView.a, 1, "updata offlineList");
      QfileBaseRecentFileTabView.e(this.b.this$0);
    }
    else
    {
      ((SharedPreferences)localObject).edit().putLong("LastRequestTime", l2).commit();
      QLog.i(QfileBaseRecentFileTabView.a, 1, "updata last process time");
    }
    if (QLog.isDevelopLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Thread id: ");
      ((StringBuilder)localObject).append(Thread.currentThread().getId());
      ((StringBuilder)localObject).append(" queryFileEntitiesFromDB -> getRecentFileRecords ");
      QLog.e("crashBUG", 1, ((StringBuilder)localObject).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.recentfile.QfileBaseRecentFileTabView.2.1
 * JD-Core Version:    0.7.0.1
 */