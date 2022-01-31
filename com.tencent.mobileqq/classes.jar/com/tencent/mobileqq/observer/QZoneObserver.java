package com.tencent.mobileqq.observer;

import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;

public class QZoneObserver
  implements BusinessObserver
{
  public void a(boolean paramBoolean, Bundle paramBundle) {}
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, long paramLong) {}
  
  public void b(boolean paramBoolean, Bundle paramBundle) {}
  
  protected void c(boolean paramBoolean, Bundle paramBundle) {}
  
  public void d(boolean paramBoolean, Bundle paramBundle) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (paramInt == 1000)
    {
      boolean bool = paramBundle.getBoolean("new");
      long l = paramBundle.getLong("notify_type", 0L);
      if (QLog.isColorLevel())
      {
        if ((l >>> 17 & 1L) != 0L) {
          QLog.d("ZebraAlbum.UndealCount.QZoneObserver", 2, "onReceive QZONE_GET_UNREAD hasNew: " + bool + "type:" + l + "and then call onGetQZoneFeedCountFin");
        }
        QLog.d("UndealCount.UndealCount.QZoneObserver", 2, "qzone redtypeinfo:onReceive QZONE_GET_UNREAD hasNew: " + bool + ",type:" + l + " and then call onGetQZoneFeedCountFin");
      }
      a(paramBoolean, bool, l);
    }
    do
    {
      return;
      if (paramInt == 1001)
      {
        a(paramBoolean, paramBundle);
        return;
      }
      if (paramInt == 1002)
      {
        b(paramBoolean, paramBundle);
        return;
      }
      if (paramInt == 1003)
      {
        c(paramBoolean, paramBundle);
        return;
      }
    } while (paramInt != 1004);
    d(paramBoolean, paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.observer.QZoneObserver
 * JD-Core Version:    0.7.0.1
 */