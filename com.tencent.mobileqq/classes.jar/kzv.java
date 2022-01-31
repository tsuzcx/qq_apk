import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.av.camera.CameraUtils;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class kzv
  extends Handler
{
  WeakReference<CameraUtils> a;
  
  public kzv(CameraUtils paramCameraUtils, Looper paramLooper)
  {
    super(paramLooper);
    this.a = new WeakReference(paramCameraUtils);
  }
  
  public void a(long paramLong)
  {
    removeMessages(1);
  }
  
  public void a(String paramString, long paramLong, int paramInt1, int paramInt2)
  {
    QLog.w("CameraUtils", 1, "sendReopenCameraMsg[" + paramString + "], size[" + paramInt1 + ", " + paramInt2 + "], subthread[" + getLooper().getThread().getId() + "], seq[" + paramLong + "]");
    a(paramLong);
    paramString = obtainMessage(1);
    paramString.arg1 = paramInt1;
    paramString.arg2 = paramInt2;
    paramString.obj = Long.valueOf(paramLong);
    sendMessageDelayed(paramString, 1000L);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if ((this.a != null) && (this.a.get() != null) && (paramMessage != null) && (paramMessage.what == 1)) {
      if (!(paramMessage.obj instanceof Long)) {
        break label75;
      }
    }
    label75:
    for (long l = Long.valueOf(0L).longValue();; l = 0L)
    {
      CameraUtils.a((CameraUtils)this.a.get(), l, paramMessage.arg1, paramMessage.arg2);
      super.handleMessage(paramMessage);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     kzv
 * JD-Core Version:    0.7.0.1
 */