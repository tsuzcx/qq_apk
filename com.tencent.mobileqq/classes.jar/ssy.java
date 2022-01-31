import android.support.annotation.Nullable;
import com.tribe.async.async.FutureListener.SimpleFutureListener;
import com.tribe.async.async.JobController.DoneEvent;
import com.tribe.async.async.Worker;
import com.tribe.async.dispatch.Dispatcher;

class ssy
  extends FutureListener.SimpleFutureListener<Progress, Result>
{
  ssy(ssx paramssx, Worker paramWorker) {}
  
  public void onFutureDone(@Nullable Result paramResult)
  {
    stb.a().dispatch(new JobController.DoneEvent(this.jdField_a_of_type_ComTribeAsyncAsyncWorker));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     ssy
 * JD-Core Version:    0.7.0.1
 */