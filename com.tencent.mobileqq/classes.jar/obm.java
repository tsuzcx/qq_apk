import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.storyHome.memory.controller.MemoriesProfilePresenter;
import com.tencent.biz.qqstory.storyHome.memory.controller.ShareGroupPageLoader.GetShareGroupListEvent;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.app.ThreadManager;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class obm
  extends QQUIEventReceiver
{
  public obm(@NonNull MemoriesProfilePresenter paramMemoriesProfilePresenter)
  {
    super(paramMemoriesProfilePresenter);
  }
  
  public void a(@NonNull MemoriesProfilePresenter paramMemoriesProfilePresenter, @NonNull ShareGroupPageLoader.GetShareGroupListEvent paramGetShareGroupListEvent)
  {
    if (paramGetShareGroupListEvent.errorInfo.isSuccess())
    {
      SLog.b("Q.qqstory.memories.MemoriesProfilePresenter", "update share group total count. %d.", Integer.valueOf(paramGetShareGroupListEvent.a));
      MemoriesProfilePresenter.b(paramMemoriesProfilePresenter, paramGetShareGroupListEvent.a);
      if (paramMemoriesProfilePresenter.a != null)
      {
        paramMemoriesProfilePresenter.a.shareGroupCount = MemoriesProfilePresenter.b(paramMemoriesProfilePresenter);
        ThreadManager.post(new obn(this, paramMemoriesProfilePresenter), 5, null, false);
      }
    }
  }
  
  public Class acceptEventClass()
  {
    return ShareGroupPageLoader.GetShareGroupListEvent.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     obm
 * JD-Core Version:    0.7.0.1
 */