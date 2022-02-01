package com.tencent.mobileqq.qzonestatus;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import azsx;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class QzoneContactsFeedManager$1
  implements Runnable
{
  public QzoneContactsFeedManager$1(azsx paramazsx) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QzoneContactsFeedManager", 2, "updateQzoneFeeds:" + azsx.a(this.this$0).getCurrentAccountUin());
    }
    Object localObject = azsx.a(this.this$0);
    long l2 = ((SharedPreferences)localObject).getLong("last_click_time", 0L);
    long l1 = System.currentTimeMillis();
    l2 = l1 - l2;
    if (l2 < azsx.a()) {
      return;
    }
    long l3 = this.this$0.a();
    if ((l3 <= 0L) || (l2 >= azsx.b())) {
      this.this$0.b();
    }
    for (;;)
    {
      localObject = ((SharedPreferences)localObject).edit();
      ((SharedPreferences.Editor)localObject).putLong("last_click_time", l1);
      if (Build.VERSION.SDK_INT >= 9) {
        break;
      }
      ((SharedPreferences.Editor)localObject).commit();
      return;
      this.this$0.a(l3, this.this$0.a());
    }
    ((SharedPreferences.Editor)localObject).apply();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qzonestatus.QzoneContactsFeedManager.1
 * JD-Core Version:    0.7.0.1
 */