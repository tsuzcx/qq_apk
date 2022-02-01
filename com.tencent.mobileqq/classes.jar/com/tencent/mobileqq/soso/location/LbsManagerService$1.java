package com.tencent.mobileqq.soso.location;

import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

final class LbsManagerService$1
  extends SosoInterfaceOnLocationListener
{
  LbsManagerService$1(int paramInt, boolean paramBoolean1, boolean paramBoolean2, long paramLong, boolean paramBoolean3, boolean paramBoolean4, String paramString, LbsManagerServiceOnLocationChangeListener paramLbsManagerServiceOnLocationChangeListener)
  {
    super(paramInt, paramBoolean1, paramBoolean2, paramLong, paramBoolean3, paramBoolean4, paramString);
  }
  
  public void onConsecutiveFailure(int paramInt1, int paramInt2)
  {
    for (;;)
    {
      synchronized ()
      {
        if (!LbsManagerService.access$100().containsKey(this)) {
          break label151;
        }
        if (QLog.isColorLevel()) {
          QLog.i("SOSO.LBS.LbsManagerService", 2, "onConsecutiveFailure reverseListenerMap contains. business id: " + this.tag + " fail count: " + paramInt2);
        }
        if (paramInt2 > 5)
        {
          localLbsManagerServiceOnLocationChangeListener = (LbsManagerServiceOnLocationChangeListener)LbsManagerService.access$100().remove(this);
          LbsManagerService.access$000().remove(localLbsManagerServiceOnLocationChangeListener);
          if (paramInt2 > 5) {
            SosoInterface.removeOnLocationListener(this);
          }
          return;
        }
        LbsManagerServiceOnLocationChangeListener localLbsManagerServiceOnLocationChangeListener = (LbsManagerServiceOnLocationChangeListener)LbsManagerService.access$100().get(this);
        if (paramInt2 == 5)
        {
          bool = true;
          localLbsManagerServiceOnLocationChangeListener.onConsecutiveFailure(paramInt1, paramInt2, bool);
        }
      }
      boolean bool = false;
      continue;
      label151:
      if (QLog.isColorLevel()) {
        QLog.i("SOSO.LBS.LbsManagerService", 2, "onConsecutiveFailure reverseListenerMap not contains. business id: " + this.tag + " fail count: " + paramInt2);
      }
    }
  }
  
  public void onLocationFinish(int paramInt, SosoLbsInfo paramSosoLbsInfo)
  {
    for (;;)
    {
      synchronized ()
      {
        if (LbsManagerService.access$100().containsKey(this))
        {
          if (QLog.isColorLevel()) {
            QLog.i("SOSO.LBS.LbsManagerService", 2, "onLocationFinish reverseListenerMap contains. business id: " + this.tag);
          }
          if (this.goonListener)
          {
            localLbsManagerServiceOnLocationChangeListener = (LbsManagerServiceOnLocationChangeListener)LbsManagerService.access$100().get(this);
            if (localLbsManagerServiceOnLocationChangeListener != null) {
              localLbsManagerServiceOnLocationChangeListener.onLocationFinish(paramInt, LbsManagerService.access$200(paramSosoLbsInfo, this.val$listener.businessId));
            }
            return;
          }
          LbsManagerServiceOnLocationChangeListener localLbsManagerServiceOnLocationChangeListener = (LbsManagerServiceOnLocationChangeListener)LbsManagerService.access$100().remove(this);
          LbsManagerService.access$000().remove(localLbsManagerServiceOnLocationChangeListener);
        }
      }
      if (QLog.isColorLevel()) {
        QLog.i("SOSO.LBS.LbsManagerService", 2, "onLocationFinish reverseListenerMap not contains. business id: " + this.tag + " this is: " + this);
      }
    }
  }
  
  public void onStatusUpdate(String paramString1, int paramInt, String paramString2)
  {
    synchronized ()
    {
      if (LbsManagerService.access$100().containsKey(this)) {
        ((LbsManagerServiceOnLocationChangeListener)LbsManagerService.access$100().get(this)).onStatusUpdate(paramString1, paramInt, paramString2);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.soso.location.LbsManagerService.1
 * JD-Core Version:    0.7.0.1
 */