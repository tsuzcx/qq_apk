import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.device.file.DeviceFileHandler;

public class pxr
  extends Handler
{
  public pxr(DeviceFileHandler paramDeviceFileHandler, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    }
    this.a.a(103, true, paramMessage.obj);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     pxr
 * JD-Core Version:    0.7.0.1
 */