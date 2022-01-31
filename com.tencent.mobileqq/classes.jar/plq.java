import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.component.network.utils.thread.AsyncTask;

public class plq
  extends Handler
{
  public plq(Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    plo localplo = (plo)paramMessage.obj;
    switch (paramMessage.what)
    {
    default: 
      return;
    case 1: 
      AsyncTask.b(localplo.jdField_a_of_type_ComTencentComponentNetworkUtilsThreadAsyncTask, localplo.jdField_a_of_type_ArrayOfJavaLangObject[0]);
      return;
    }
    localplo.jdField_a_of_type_ComTencentComponentNetworkUtilsThreadAsyncTask.a(localplo.jdField_a_of_type_ArrayOfJavaLangObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     plq
 * JD-Core Version:    0.7.0.1
 */