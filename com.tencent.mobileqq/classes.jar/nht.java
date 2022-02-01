import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;

public class nht
{
  private static final nht jdField_a_of_type_Nht = new nht();
  private Handler jdField_a_of_type_AndroidOsHandler;
  private Handler b;
  
  private nht()
  {
    HandlerThread localHandlerThread = new HandlerThread("avgame_chat_thread");
    localHandlerThread.start();
    this.jdField_a_of_type_AndroidOsHandler = new Handler(localHandlerThread.getLooper());
    this.b = new Handler(Looper.getMainLooper());
  }
  
  public static nht a()
  {
    return jdField_a_of_type_Nht;
  }
  
  public Handler a()
  {
    return this.jdField_a_of_type_AndroidOsHandler;
  }
  
  public Handler b()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nht
 * JD-Core Version:    0.7.0.1
 */