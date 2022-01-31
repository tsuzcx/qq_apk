import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.channel.CmdTaskManger.CommandCallback;
import com.tencent.biz.qqstory.model.MemoryManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.network.request.GetProfileYearNodeListRequest;
import com.tencent.biz.qqstory.network.request.GetProfileYearNodeListRequest.GetProfileYearNodeListResponse;
import com.tencent.biz.qqstory.storyHome.memory.controller.ProfileFeedPresenter;
import com.tencent.biz.qqstory.storyHome.memory.controller.ProfileFeedPresenter.GetYearNodeListEvent;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.Dispatchers;
import java.util.concurrent.atomic.AtomicBoolean;

public class nvv
  implements CmdTaskManger.CommandCallback
{
  public nvv(ProfileFeedPresenter paramProfileFeedPresenter, boolean paramBoolean) {}
  
  public void a(@NonNull GetProfileYearNodeListRequest paramGetProfileYearNodeListRequest, @Nullable GetProfileYearNodeListRequest.GetProfileYearNodeListResponse arg2, @NonNull ErrorMessage paramErrorMessage)
  {
    if (ProfileFeedPresenter.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryControllerProfileFeedPresenter).get())
    {
      SLog.e("Q.qqstory.memories.ProfileFeedPresenter", "year node data back when activity has been destroyed.");
      return;
    }
    SLog.a("Q.qqstory.memories.ProfileFeedPresenter", "on year node data back. is successful : %s.", Boolean.valueOf(paramErrorMessage.isSuccess()));
    paramGetProfileYearNodeListRequest = new ProfileFeedPresenter.GetYearNodeListEvent(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryControllerProfileFeedPresenter, paramErrorMessage);
    paramGetProfileYearNodeListRequest.jdField_a_of_type_Boolean = this.jdField_a_of_type_Boolean;
    if ((??? == null) || (paramErrorMessage.isFail()))
    {
      Dispatchers.get().dispatch(paramGetProfileYearNodeListRequest);
      return;
    }
    paramGetProfileYearNodeListRequest.jdField_a_of_type_JavaUtilList = ???.jdField_a_of_type_JavaUtilList;
    ((MemoryManager)SuperManager.a(19)).a(???.jdField_a_of_type_JavaUtilList, true);
    synchronized (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryControllerProfileFeedPresenter)
    {
      Dispatchers.get().dispatch(paramGetProfileYearNodeListRequest);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nvv
 * JD-Core Version:    0.7.0.1
 */