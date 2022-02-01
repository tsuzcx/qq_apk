package com.tencent.mobileqq.qzonestatus;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

class QzoneContactsFeedManager$1
  implements Runnable
{
  QzoneContactsFeedManager$1(QzoneContactsFeedManager paramQzoneContactsFeedManager) {}
  
  public void run()
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("updateQzoneFeeds:");
      ((StringBuilder)localObject).append(QzoneContactsFeedManager.a(this.this$0).getCurrentAccountUin());
      QLog.d("QzoneContactsFeedManager", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = QzoneContactsFeedManager.a(this.this$0);
    long l2 = ((SharedPreferences)localObject).getLong("last_click_time", 0L);
    long l1 = System.currentTimeMillis();
    l2 = l1 - l2;
    if (l2 < QzoneContactsFeedManager.a()) {
      return;
    }
    long l3 = this.this$0.a();
    if ((l3 > 0L) && (l2 < QzoneContactsFeedManager.b()))
    {
      QzoneContactsFeedManager localQzoneContactsFeedManager = this.this$0;
      localQzoneContactsFeedManager.a(l3, localQzoneContactsFeedManager.a());
    }
    else
    {
      this.this$0.b();
    }
    localObject = ((SharedPreferences)localObject).edit();
    ((SharedPreferences.Editor)localObject).putLong("last_click_time", l1);
    if (Build.VERSION.SDK_INT < 9)
    {
      ((SharedPreferences.Editor)localObject).commit();
      return;
    }
    ((SharedPreferences.Editor)localObject).apply();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qzonestatus.QzoneContactsFeedManager.1
 * JD-Core Version:    0.7.0.1
 */