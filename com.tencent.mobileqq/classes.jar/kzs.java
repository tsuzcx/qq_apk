import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.av.camera.CameraUtils;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;

public class kzs
  extends Handler
{
  public kzs(CameraUtils paramCameraUtils, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    boolean bool = true;
    long l = min.a(paramMessage.obj);
    if (AudioHelper.e()) {
      QLog.w("CameraUtils", 1, "CameraHandlerThread, seq[" + l + "], event[" + paramMessage.what + "]");
    }
    switch (paramMessage.what)
    {
    default: 
      return;
    case 1: 
      CameraUtils.a(this.a, l);
      return;
    case 2: 
      if (paramMessage.arg1 == 1) {}
      for (;;)
      {
        CameraUtils.a(this.a, l, bool);
        return;
        bool = false;
      }
    case 3: 
      i = paramMessage.arg1;
      int j = paramMessage.arg2;
      CameraUtils.a(this.a, l, i, j);
      return;
    case 4: 
      CameraUtils.b(this.a, l);
      return;
    }
    int i = paramMessage.arg1;
    CameraUtils.a(this.a, l, i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     kzs
 * JD-Core Version:    0.7.0.1
 */