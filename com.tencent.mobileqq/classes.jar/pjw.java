import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.component.network.utils.thread.AsyncTask;

public class pjw
  extends Handler
{
  public pjw(Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    pju localpju = (pju)paramMessage.obj;
    switch (paramMessage.what)
    {
    default: 
      return;
    case 1: 
      AsyncTask.b(localpju.jdField_a_of_type_ComTencentComponentNetworkUtilsThreadAsyncTask, localpju.jdField_a_of_type_ArrayOfJavaLangObject[0]);
      return;
    }
    localpju.jdField_a_of_type_ComTencentComponentNetworkUtilsThreadAsyncTask.a(localpju.jdField_a_of_type_ArrayOfJavaLangObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     pjw
 * JD-Core Version:    0.7.0.1
 */