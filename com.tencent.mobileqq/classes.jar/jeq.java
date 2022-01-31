import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.av.app.GCameraAvailabilityMonitor;
import com.tencent.qphone.base.util.QLog;

public class jeq
  extends BroadcastReceiver
{
  public jeq(GCameraAvailabilityMonitor paramGCameraAvailabilityMonitor) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ((this.a.a() != null) && (paramIntent != null))
    {
      this.a.a(paramIntent.getStringExtra("camera_id"), paramIntent.getIntExtra("availability", 1));
      if (QLog.isColorLevel()) {
        QLog.d("GCameraAvailabilityMonitor", 2, "update camera availability status cameraId:" + paramIntent.getStringExtra("camera_id") + ", value:" + paramIntent.getIntExtra("availability", 1));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     jeq
 * JD-Core Version:    0.7.0.1
 */