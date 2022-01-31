import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.qphone.base.util.QLog;

class lff
  extends BroadcastReceiver
{
  lff(lfe paramlfe) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ((this.a.a() != null) && (paramIntent != null))
    {
      long l = mtj.a(paramIntent);
      paramContext = paramIntent.getStringExtra("camera_id");
      int i = paramIntent.getIntExtra("availability", 1);
      this.a.a(paramContext, i);
      if (QLog.isColorLevel()) {
        QLog.w("GCameraAvailabilityMonitor", 1, "CameraAvailabilityReceiver, id[" + paramContext + "], available[" + i + "], seq[" + l + "]");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     lff
 * JD-Core Version:    0.7.0.1
 */