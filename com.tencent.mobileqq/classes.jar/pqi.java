import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.component.network.utils.thread.AsyncTask;

public class pqi
  extends Handler
{
  public pqi(Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    pqg localpqg = (pqg)paramMessage.obj;
    switch (paramMessage.what)
    {
    default: 
      return;
    case 1: 
      AsyncTask.b(localpqg.jdField_a_of_type_ComTencentComponentNetworkUtilsThreadAsyncTask, localpqg.jdField_a_of_type_ArrayOfJavaLangObject[0]);
      return;
    }
    localpqg.jdField_a_of_type_ComTencentComponentNetworkUtilsThreadAsyncTask.a(localpqg.jdField_a_of_type_ArrayOfJavaLangObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     pqi
 * JD-Core Version:    0.7.0.1
 */