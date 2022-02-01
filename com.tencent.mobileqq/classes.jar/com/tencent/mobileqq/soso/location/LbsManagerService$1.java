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
        Object localObject1;
        if (LbsManagerService.access$100().containsKey(this))
        {
          if (QLog.isColorLevel())
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("onConsecutiveFailure reverseListenerMap contains. business id: ");
            ((StringBuilder)localObject1).append(this.tag);
            ((StringBuilder)localObject1).append(" fail count: ");
            ((StringBuilder)localObject1).append(paramInt2);
            QLog.i("SOSO.LBS.LbsManagerService", 2, ((StringBuilder)localObject1).toString());
          }
          if (paramInt2 > 5)
          {
            localObject1 = (LbsManagerServiceOnLocationChangeListener)LbsManagerService.access$100().remove(this);
            LbsManagerService.access$000().remove(localObject1);
          }
          else
          {
            localObject1 = (LbsManagerServiceOnLocationChangeListener)LbsManagerService.access$100().get(this);
            if (paramInt2 != 5) {
              break label227;
            }
            bool = true;
            ((LbsManagerServiceOnLocationChangeListener)localObject1).onConsecutiveFailure(paramInt1, paramInt2, bool);
          }
        }
        else if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("onConsecutiveFailure reverseListenerMap not contains. business id: ");
          ((StringBuilder)localObject1).append(this.tag);
          ((StringBuilder)localObject1).append(" fail count: ");
          ((StringBuilder)localObject1).append(paramInt2);
          QLog.i("SOSO.LBS.LbsManagerService", 2, ((StringBuilder)localObject1).toString());
        }
        if (paramInt2 > 5) {
          SosoInterface.removeOnLocationListener(this);
        }
        return;
      }
      label227:
      boolean bool = false;
    }
  }
  
  public void onLocationFinish(int paramInt, SosoLbsInfo paramSosoLbsInfo)
  {
    synchronized ()
    {
      if (LbsManagerService.access$100().containsKey(this))
      {
        Object localObject;
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("onLocationFinish reverseListenerMap contains. business id: ");
          ((StringBuilder)localObject).append(this.tag);
          QLog.i("SOSO.LBS.LbsManagerService", 2, ((StringBuilder)localObject).toString());
        }
        if (this.goonListener)
        {
          localObject = (LbsManagerServiceOnLocationChangeListener)LbsManagerService.access$100().get(this);
        }
        else
        {
          localObject = (LbsManagerServiceOnLocationChangeListener)LbsManagerService.access$100().remove(this);
          LbsManagerService.access$000().remove(localObject);
        }
        if (localObject != null) {
          ((LbsManagerServiceOnLocationChangeListener)localObject).onLocationFinish(paramInt, LbsManagerService.access$200(paramSosoLbsInfo, this.val$listener.businessId));
        }
      }
      else if (QLog.isColorLevel())
      {
        paramSosoLbsInfo = new StringBuilder();
        paramSosoLbsInfo.append("onLocationFinish reverseListenerMap not contains. business id: ");
        paramSosoLbsInfo.append(this.tag);
        paramSosoLbsInfo.append(" this is: ");
        paramSosoLbsInfo.append(this);
        QLog.i("SOSO.LBS.LbsManagerService", 2, paramSosoLbsInfo.toString());
      }
      return;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.soso.location.LbsManagerService.1
 * JD-Core Version:    0.7.0.1
 */