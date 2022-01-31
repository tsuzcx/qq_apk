import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.model.DeleteStoryVideoEvent;
import com.tribe.async.async.Job;
import com.tribe.async.async.JobContext;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.Dispatchers;

class nkx
  extends Job
{
  nkx(nkw paramnkw, DeleteStoryVideoEvent paramDeleteStoryVideoEvent) {}
  
  protected Object doInBackground(@NonNull JobContext paramJobContext, @Nullable Object... paramVarArgs)
  {
    Dispatchers.get().dispatch(this.jdField_a_of_type_ComTencentBizQqstoryModelDeleteStoryVideoEvent);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nkx
 * JD-Core Version:    0.7.0.1
 */