package com.tencent.mobileqq.observer;

import android.os.Bundle;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;

public class QZoneObserver
  implements BusinessObserver
{
  protected void a(boolean paramBoolean, Bundle paramBundle) {}
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2, long paramLong) {}
  
  protected void b(boolean paramBoolean, Bundle paramBundle) {}
  
  protected void c(boolean paramBoolean, Bundle paramBundle) {}
  
  protected void d(boolean paramBoolean, Bundle paramBundle) {}
  
  protected void e(boolean paramBoolean, Bundle paramBundle) {}
  
  protected void f(boolean paramBoolean, Bundle paramBundle) {}
  
  protected void g(boolean paramBoolean, Bundle paramBundle) {}
  
  protected void h(boolean paramBoolean, Bundle paramBundle) {}
  
  protected void i(boolean paramBoolean, Bundle paramBundle) {}
  
  protected void j(boolean paramBoolean, Bundle paramBundle) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (paramInt == 1000)
    {
      boolean bool = paramBundle.getBoolean("new");
      long l = paramBundle.getLong("notify_type", 0L);
      if (QLog.isColorLevel())
      {
        if ((l >>> 17 & 1L) != 0L)
        {
          paramBundle = new StringBuilder();
          paramBundle.append("onReceive QZONE_GET_UNREAD hasNew: ");
          paramBundle.append(bool);
          paramBundle.append("type:");
          paramBundle.append(l);
          paramBundle.append("and then call onGetQZoneFeedCountFin");
          QLog.d("ZebraAlbum.UndealCount.QZoneObserver", 2, paramBundle.toString());
        }
        paramBundle = new StringBuilder();
        paramBundle.append("qzone redtypeinfo:onReceive QZONE_GET_UNREAD hasNew: ");
        paramBundle.append(bool);
        paramBundle.append(",type:");
        paramBundle.append(l);
        paramBundle.append(" and then call onGetQZoneFeedCountFin");
        QLog.d("UndealCount.UndealCount.QZoneObserver", 2, paramBundle.toString());
      }
      a(paramBoolean, bool, l);
      return;
    }
    if (paramInt == 1001)
    {
      ThreadManagerV2.executeOnSubThread(new QZoneObserver.1(this, paramBoolean, paramBundle));
      return;
    }
    if (paramInt == 1002)
    {
      c(paramBoolean, paramBundle);
      return;
    }
    if (paramInt == 1003)
    {
      d(paramBoolean, paramBundle);
      return;
    }
    if (paramInt == 1004)
    {
      e(paramBoolean, paramBundle);
      return;
    }
    if (paramInt == 1005)
    {
      f(paramBoolean, paramBundle);
      return;
    }
    if (paramInt == 1006)
    {
      g(paramBoolean, paramBundle);
      return;
    }
    if (paramInt == 1007)
    {
      ThreadManagerV2.executeOnSubThread(new QZoneObserver.2(this, paramBoolean, paramBundle));
      return;
    }
    if (paramInt == 1008)
    {
      i(paramBoolean, paramBundle);
      return;
    }
    if (paramInt == 1009)
    {
      j(paramBoolean, paramBundle);
      return;
    }
    if (paramInt == 1010) {
      a(paramBoolean, paramBundle);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.observer.QZoneObserver
 * JD-Core Version:    0.7.0.1
 */