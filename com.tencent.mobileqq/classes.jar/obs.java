import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.network.handler.VidToSimpleInfoHandler.GetSimpleInfoListEvent;
import com.tencent.biz.qqstory.storyHome.memory.controller.MemoriesVideoCollectionPresenter;
import com.tencent.biz.qqstory.storyHome.memory.controller.MemoriesVideoCollectionPresenter.VideoCollectionPresenterEventListener;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class obs
  extends QQUIEventReceiver
{
  public obs(@NonNull MemoriesVideoCollectionPresenter paramMemoriesVideoCollectionPresenter)
  {
    super(paramMemoriesVideoCollectionPresenter);
  }
  
  public void a(@NonNull MemoriesVideoCollectionPresenter paramMemoriesVideoCollectionPresenter, @NonNull VidToSimpleInfoHandler.GetSimpleInfoListEvent paramGetSimpleInfoListEvent)
  {
    SLog.b("Q.qqstory.memories.MemoriesVideoCollectionPresenter", "receive video info list. %s.", paramGetSimpleInfoListEvent.toString());
    if (paramGetSimpleInfoListEvent.errorInfo.isSuccess()) {
      MemoriesVideoCollectionPresenter.a(paramMemoriesVideoCollectionPresenter).a(paramGetSimpleInfoListEvent.jdField_a_of_type_JavaLangString, paramGetSimpleInfoListEvent.jdField_a_of_type_JavaUtilList);
    }
  }
  
  public Class acceptEventClass()
  {
    return VidToSimpleInfoHandler.GetSimpleInfoListEvent.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     obs
 * JD-Core Version:    0.7.0.1
 */