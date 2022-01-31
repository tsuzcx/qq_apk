import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.VideoControlUI;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class lyx
  extends BroadcastReceiver
{
  public lyx(VideoControlUI paramVideoControlUI) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ((paramIntent == null) || (this.a.jdField_a_of_type_ComTencentAvVideoController == null)) {
      return;
    }
    long l = min.a(paramIntent);
    paramContext = paramIntent.getStringExtra("camera_id");
    int i = paramIntent.getIntExtra("availability", 1);
    QLog.w(this.a.c, 1, "CameraAvailabilityReceiver, cameraId[" + paramContext + "], availability[" + i + "], mCameraAvailable[" + this.a.jdField_a_of_type_ComTencentAvVideoController.a().X + "], seq[" + l + "]");
    this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(paramContext, i);
    if (i == 0)
    {
      VideoControlUI.a(this.a, l, i);
      return;
    }
    paramContext = this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
    if ((paramContext != null) && (paramContext.size() > 0))
    {
      paramContext = paramContext.entrySet().iterator();
      do
      {
        if (!paramContext.hasNext()) {
          break;
        }
      } while (((Integer)((Map.Entry)paramContext.next()).getValue()).intValue() != 0);
    }
    for (i = 0;; i = -1)
    {
      VideoControlUI.a(this.a, l, i);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     lyx
 * JD-Core Version:    0.7.0.1
 */