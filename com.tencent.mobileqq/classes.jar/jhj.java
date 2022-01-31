import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.av.camera.CameraUtils;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class jhj
  extends BroadcastReceiver
{
  public jhj(CameraUtils paramCameraUtils) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent == null) {}
    for (;;)
    {
      return;
      paramContext = paramIntent.getStringExtra("camera_id");
      int i = paramIntent.getIntExtra("availability", 1);
      CameraUtils.a(this.a).put(paramContext, Integer.valueOf(i));
      if ((i == 1) && (this.a.c()))
      {
        paramContext = CameraUtils.a(this.a).entrySet().iterator();
        do
        {
          if (!paramContext.hasNext()) {
            break;
          }
        } while (((Integer)((Map.Entry)paramContext.next()).getValue()).intValue() != 0);
      }
      for (i = 0; i != 0; i = 1)
      {
        CameraUtils.a(this.a).a("CameraAvailabilityReceiver", -1, -1);
        return;
        CameraUtils.a(this.a).a();
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     jhj
 * JD-Core Version:    0.7.0.1
 */