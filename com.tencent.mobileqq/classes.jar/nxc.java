import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.network.handler.DateCollectionListPageLoader.GetCollectionListEvent;
import com.tencent.biz.qqstory.storyHome.memory.controller.MemoriesVideoCollectionPresenter;
import com.tencent.biz.qqstory.storyHome.memory.controller.MemoriesVideoCollectionPresenter.VideoCollectionPresenterEventListener;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class nxc
  extends QQUIEventReceiver
{
  public nxc(@NonNull MemoriesVideoCollectionPresenter paramMemoriesVideoCollectionPresenter)
  {
    super(paramMemoriesVideoCollectionPresenter);
  }
  
  public void a(@NonNull MemoriesVideoCollectionPresenter paramMemoriesVideoCollectionPresenter, @NonNull DateCollectionListPageLoader.GetCollectionListEvent paramGetCollectionListEvent)
  {
    if (!TextUtils.equals(String.valueOf(paramMemoriesVideoCollectionPresenter.hashCode()), paramGetCollectionListEvent.jdField_a_of_type_JavaLangString)) {
      return;
    }
    SLog.b("Q.qqstory.memories.MemoriesVideoCollectionPresenter", "receive video collection list. %s.", paramGetCollectionListEvent);
    if (paramGetCollectionListEvent.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess())
    {
      paramMemoriesVideoCollectionPresenter.jdField_a_of_type_Int = paramGetCollectionListEvent.jdField_a_of_type_Int;
      paramMemoriesVideoCollectionPresenter.jdField_a_of_type_Boolean = true;
      if (paramGetCollectionListEvent.e)
      {
        paramMemoriesVideoCollectionPresenter.a(paramGetCollectionListEvent.jdField_a_of_type_JavaUtilList, paramGetCollectionListEvent.c, paramGetCollectionListEvent.jdField_a_of_type_Boolean);
        paramMemoriesVideoCollectionPresenter.b = paramGetCollectionListEvent.jdField_a_of_type_Boolean;
      }
    }
    MemoriesVideoCollectionPresenter.a(paramMemoriesVideoCollectionPresenter).a(paramGetCollectionListEvent.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess());
  }
  
  public Class acceptEventClass()
  {
    return DateCollectionListPageLoader.GetCollectionListEvent.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nxc
 * JD-Core Version:    0.7.0.1
 */