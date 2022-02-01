package com.tencent.mobileqq.richstatus;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.app.ConfigObserver;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.LinkedList;

class StatusManager$2
  extends ConfigObserver
{
  StatusManager$2(StatusManager paramStatusManager) {}
  
  protected void a(boolean paramBoolean, int paramInt)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onUpdateStatusActions ");
      ((StringBuilder)localObject).append(paramBoolean);
      ((StringBuilder)localObject).append(", ");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("Q.richstatus.xml", 2, ((StringBuilder)localObject).toString());
    }
    StatusManager.a(this.a, 0L);
    if (paramBoolean)
    {
      if (paramInt == 100)
      {
        StatusManager.b(this.a, System.currentTimeMillis());
        StatusManager.a(this.a).edit().putLong("k_update_time", StatusManager.a(this.a)).commit();
      }
      this.a.a(true);
    }
    if (StatusManager.a(this.a) != null)
    {
      localObject = StatusManager.a(this.a).iterator();
      while (((Iterator)localObject).hasNext())
      {
        IActionListener localIActionListener = (IActionListener)((Iterator)localObject).next();
        int i;
        if (paramBoolean) {
          i = 300;
        } else {
          i = 301;
        }
        localIActionListener.a(paramInt, i);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.richstatus.StatusManager.2
 * JD-Core Version:    0.7.0.1
 */