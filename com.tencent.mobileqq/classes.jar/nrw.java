import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.storyHome.QQStoryBaseActivity;
import com.tencent.biz.qqstory.utils.BitmapUtils.OutOfMemHandleCommand;
import com.tribe.async.dispatch.Dispatcher.Dispatchable;
import com.tribe.async.dispatch.Subscriber;
import java.lang.ref.WeakReference;
import java.util.List;

public class nrw
  implements Subscriber
{
  private WeakReference jdField_a_of_type_JavaLangRefWeakReference;
  
  public nrw(QQStoryBaseActivity paramQQStoryBaseActivity1, QQStoryBaseActivity paramQQStoryBaseActivity2)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramQQStoryBaseActivity2);
  }
  
  public void accept(@NonNull List paramList)
  {
    paramList.add(BitmapUtils.OutOfMemHandleCommand.class);
  }
  
  public void handleDispatch(@NonNull Dispatcher.Dispatchable paramDispatchable)
  {
    paramDispatchable = (QQStoryBaseActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (paramDispatchable != null) {
      paramDispatchable.g();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nrw
 * JD-Core Version:    0.7.0.1
 */