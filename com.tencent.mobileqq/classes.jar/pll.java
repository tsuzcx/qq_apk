import android.os.Process;
import com.tencent.component.network.utils.thread.AsyncTask;
import java.util.concurrent.atomic.AtomicBoolean;

public class pll
  extends plt
{
  public pll(AsyncTask paramAsyncTask)
  {
    super(null);
  }
  
  public Object call()
  {
    AsyncTask.a(this.jdField_a_of_type_ComTencentComponentNetworkUtilsThreadAsyncTask).set(true);
    Process.setThreadPriority(10);
    return AsyncTask.a(this.jdField_a_of_type_ComTencentComponentNetworkUtilsThreadAsyncTask, this.jdField_a_of_type_ComTencentComponentNetworkUtilsThreadAsyncTask.a(this.jdField_a_of_type_ArrayOfJavaLangObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     pll
 * JD-Core Version:    0.7.0.1
 */