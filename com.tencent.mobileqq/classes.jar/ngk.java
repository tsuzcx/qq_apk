import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;

public class ngk
{
  private static final ngk jdField_a_of_type_Ngk = new ngk();
  private Handler jdField_a_of_type_AndroidOsHandler;
  private Handler b;
  
  private ngk()
  {
    HandlerThread localHandlerThread = new HandlerThread("avgame_chat_thread");
    localHandlerThread.start();
    this.jdField_a_of_type_AndroidOsHandler = new Handler(localHandlerThread.getLooper());
    this.b = new Handler(Looper.getMainLooper());
  }
  
  public static ngk a()
  {
    return jdField_a_of_type_Ngk;
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
 * Qualified Name:     ngk
 * JD-Core Version:    0.7.0.1
 */