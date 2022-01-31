import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.network.handler.DateCollectionListPageLoader.GetCollectionListEvent;
import com.tencent.biz.qqstory.storyHome.memory.controller.MemoriesProfilePresenter;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.app.ThreadManager;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class nvi
  extends QQUIEventReceiver
{
  public nvi(@NonNull MemoriesProfilePresenter paramMemoriesProfilePresenter)
  {
    super(paramMemoriesProfilePresenter);
  }
  
  public void a(@NonNull MemoriesProfilePresenter paramMemoriesProfilePresenter, @NonNull DateCollectionListPageLoader.GetCollectionListEvent paramGetCollectionListEvent)
  {
    if (paramGetCollectionListEvent.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess())
    {
      SLog.b("Q.qqstory.memories.MemoriesProfilePresenter", "update video total count. %d.", Integer.valueOf(paramGetCollectionListEvent.jdField_a_of_type_Int));
      MemoriesProfilePresenter.a(paramMemoriesProfilePresenter, paramGetCollectionListEvent.jdField_a_of_type_Int);
      if (paramMemoriesProfilePresenter.a != null)
      {
        paramMemoriesProfilePresenter.a.videoCount = MemoriesProfilePresenter.a(paramMemoriesProfilePresenter);
        ThreadManager.post(new nvj(this, paramMemoriesProfilePresenter), 5, null, false);
      }
    }
  }
  
  public Class acceptEventClass()
  {
    return DateCollectionListPageLoader.GetCollectionListEvent.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nvi
 * JD-Core Version:    0.7.0.1
 */