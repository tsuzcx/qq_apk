package com.tencent.mobileqq.location.net;

import android.app.Activity;
import com.tencent.mobileqq.location.data.LocationRoom.RoomKey;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.SoftReference;

class LocationShareLocationManager$1
  implements Runnable
{
  LocationShareLocationManager$1(LocationShareLocationManager paramLocationShareLocationManager, SoftReference paramSoftReference) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.LocationShare", 2, "[LocationManager] startLocationUpdate: invoked. call over time runnable");
    }
    if (LocationShareLocationManager.a(this.this$0) != null)
    {
      LocationShareRoomManager.a().a(LocationShareLocationManager.a(this.this$0).a(), LocationShareLocationManager.a(this.this$0).b(), LocationHandler.a().b(), 4);
      LocationShareLocationManager.a().a(LocationShareLocationManager.a(this.this$0), true);
    }
    QQToast.makeText(BaseApplication.getContext(), "位置获取失败，请稍后再试", 0).show();
    Activity localActivity = (Activity)this.a.get();
    if ((localActivity != null) && (!localActivity.isFinishing()))
    {
      this.a.clear();
      localActivity.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.location.net.LocationShareLocationManager.1
 * JD-Core Version:    0.7.0.1
 */