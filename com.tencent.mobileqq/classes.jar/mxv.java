import android.os.Handler;
import android.os.Looper;
import mqq.os.MqqHandler;

public class mxv
{
  private final Handler jdField_a_of_type_AndroidOsHandler;
  private final MqqHandler jdField_a_of_type_MqqOsMqqHandler;
  
  public mxv(Looper paramLooper)
  {
    this.jdField_a_of_type_MqqOsMqqHandler = new MqqHandler(paramLooper);
    this.jdField_a_of_type_AndroidOsHandler = new Handler(paramLooper);
  }
  
  public mxv(MqqHandler paramMqqHandler)
  {
    this.jdField_a_of_type_MqqOsMqqHandler = paramMqqHandler;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(paramMqqHandler.getLooper());
  }
  
  public final boolean a(Runnable paramRunnable, boolean paramBoolean)
  {
    if (paramBoolean) {
      return this.jdField_a_of_type_AndroidOsHandler.postAtFrontOfQueue(paramRunnable);
    }
    return this.jdField_a_of_type_MqqOsMqqHandler.postAtFrontOfQueue(paramRunnable);
  }
  
  public final boolean b(Runnable paramRunnable, boolean paramBoolean)
  {
    if (paramBoolean) {
      return this.jdField_a_of_type_AndroidOsHandler.post(paramRunnable);
    }
    return this.jdField_a_of_type_MqqOsMqqHandler.post(paramRunnable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mxv
 * JD-Core Version:    0.7.0.1
 */