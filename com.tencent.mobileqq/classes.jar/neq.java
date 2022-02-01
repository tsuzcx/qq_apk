import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;

public class neq
{
  private static final neq jdField_a_of_type_Neq = new neq();
  private Handler jdField_a_of_type_AndroidOsHandler;
  private Handler b;
  
  private neq()
  {
    HandlerThread localHandlerThread = new HandlerThread("avgame_chat_thread");
    localHandlerThread.start();
    this.jdField_a_of_type_AndroidOsHandler = new Handler(localHandlerThread.getLooper());
    this.b = new Handler(Looper.getMainLooper());
  }
  
  public static neq a()
  {
    return jdField_a_of_type_Neq;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     neq
 * JD-Core Version:    0.7.0.1
 */