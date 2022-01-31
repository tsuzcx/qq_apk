import android.support.annotation.Nullable;
import com.tribe.async.async.FutureListener.SimpleFutureListener;
import com.tribe.async.async.JobController.DoneEvent;
import com.tribe.async.async.Worker;
import com.tribe.async.dispatch.Dispatcher;

class sgf
  extends FutureListener.SimpleFutureListener<Progress, Result>
{
  sgf(sge paramsge, Worker paramWorker) {}
  
  public void onFutureDone(@Nullable Result paramResult)
  {
    sgi.a().dispatch(new JobController.DoneEvent(this.jdField_a_of_type_ComTribeAsyncAsyncWorker));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     sgf
 * JD-Core Version:    0.7.0.1
 */