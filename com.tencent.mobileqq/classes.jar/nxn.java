import android.os.Handler;
import android.os.Message;
import com.tencent.biz.game.SensorAPIJavaScript;

public class nxn
  extends Handler
{
  public nxn(SensorAPIJavaScript paramSensorAPIJavaScript) {}
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 5) {
      this.a.a((String)paramMessage.obj);
    }
    while (paramMessage.what != 291) {
      return;
    }
    this.a.updateMicStatus((String)paramMessage.obj);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nxn
 * JD-Core Version:    0.7.0.1
 */