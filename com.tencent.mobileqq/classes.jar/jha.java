import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.av.camera.CameraUtils;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class jha
  extends Handler
{
  WeakReference a;
  
  public jha(CameraUtils paramCameraUtils, Looper paramLooper)
  {
    super(paramLooper);
    this.a = new WeakReference(paramCameraUtils);
  }
  
  public void a()
  {
    removeMessages(1);
  }
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    QLog.w("CameraUtils", 1, "sendReopenCameraMsg[" + paramString + "], size[" + paramInt1 + ", " + paramInt2 + "], subthread[" + getLooper().getThread().getId() + "]");
    a();
    paramString = obtainMessage(1);
    paramString.arg1 = paramInt1;
    paramString.arg2 = paramInt2;
    sendMessageDelayed(paramString, 1000L);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if ((this.a != null) && (this.a.get() != null) && (paramMessage != null) && (paramMessage.what == 1)) {
      CameraUtils.a((CameraUtils)this.a.get(), paramMessage.arg1, paramMessage.arg2);
    }
    super.handleMessage(paramMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     jha
 * JD-Core Version:    0.7.0.1
 */