import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.av.camera.CameraUtils;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class lmh
  extends BroadcastReceiver
{
  public lmh(CameraUtils paramCameraUtils) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent == null) {
      return;
    }
    paramContext = paramIntent.getStringExtra("camera_id");
    int i = paramIntent.getIntExtra("availability", 1);
    long l = mwd.a(paramIntent);
    CameraUtils.a(this.a).put(paramContext, Integer.valueOf(i));
    if ((i == 1) && (this.a.b(l)))
    {
      paramContext = CameraUtils.a(this.a).entrySet().iterator();
      do
      {
        if (!paramContext.hasNext()) {
          break;
        }
      } while (((Integer)((Map.Entry)paramContext.next()).getValue()).intValue() != 0);
    }
    for (boolean bool = false;; bool = true)
    {
      if (AudioHelper.e()) {
        QLog.w("CameraUtils", 1, "CameraAvailabilityReceiver, sendReopenCameraMsg, result[" + bool + "], seq[" + l + "]");
      }
      if (!bool) {
        break;
      }
      CameraUtils.a(this.a).a("CameraAvailabilityReceiver", l, -1, -1);
      return;
      if (AudioHelper.e()) {
        QLog.w("CameraUtils", 1, "CameraAvailabilityReceiver, removeReopenCameraMsg, seq[" + i + "]");
      }
      CameraUtils.a(this.a).a(l);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     lmh
 * JD-Core Version:    0.7.0.1
 */