package com.tencent.mobileqq.location.net;

import android.app.Activity;
import com.tencent.mobileqq.location.data.LocationRoom.RoomKey;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.SoftReference;

class LocationHandler$3
  implements Runnable
{
  LocationHandler$3(LocationHandler paramLocationHandler, SoftReference paramSoftReference) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationHandler", 2, "[LocationManager] startLocationUpdate: invoked. call over time runnable");
    }
    if (LocationHandler.a(this.this$0) != null)
    {
      this.this$0.a(LocationHandler.a(this.this$0).a(), LocationHandler.a(this.this$0).a(), LocationHandler.a(this.this$0), 4);
      this.this$0.a(LocationHandler.a(this.this$0), true);
    }
    QQToast.a(BaseApplication.getContext(), "位置获取失败，请稍后再试", 0).a();
    Activity localActivity = (Activity)this.a.get();
    if ((localActivity != null) && (!localActivity.isFinishing()))
    {
      this.a.clear();
      localActivity.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.location.net.LocationHandler.3
 * JD-Core Version:    0.7.0.1
 */