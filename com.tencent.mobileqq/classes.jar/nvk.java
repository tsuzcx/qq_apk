import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.storyHome.memory.controller.MemoriesProfilePresenter;
import com.tencent.biz.qqstory.storyHome.memory.controller.ShareGroupPageLoader.GetShareGroupListEvent;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.app.ThreadManager;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class nvk
  extends QQUIEventReceiver
{
  public nvk(@NonNull MemoriesProfilePresenter paramMemoriesProfilePresenter)
  {
    super(paramMemoriesProfilePresenter);
  }
  
  public void a(@NonNull MemoriesProfilePresenter paramMemoriesProfilePresenter, @NonNull ShareGroupPageLoader.GetShareGroupListEvent paramGetShareGroupListEvent)
  {
    if (paramGetShareGroupListEvent.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess())
    {
      SLog.b("Q.qqstory.memories.MemoriesProfilePresenter", "update share group total count. %d.", Integer.valueOf(paramGetShareGroupListEvent.jdField_a_of_type_Int));
      MemoriesProfilePresenter.b(paramMemoriesProfilePresenter, paramGetShareGroupListEvent.jdField_a_of_type_Int);
      if (paramMemoriesProfilePresenter.a != null)
      {
        paramMemoriesProfilePresenter.a.shareGroupCount = MemoriesProfilePresenter.b(paramMemoriesProfilePresenter);
        ThreadManager.post(new nvl(this, paramMemoriesProfilePresenter), 5, null, false);
      }
    }
  }
  
  public Class acceptEventClass()
  {
    return ShareGroupPageLoader.GetShareGroupListEvent.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nvk
 * JD-Core Version:    0.7.0.1
 */