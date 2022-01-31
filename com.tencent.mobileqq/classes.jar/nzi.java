import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.channel.CmdTaskManger.CommandCallback;
import com.tencent.biz.qqstory.model.LikeManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.storyHome.detail.model.DetailLikeListLoader;
import com.tencent.biz.qqstory.storyHome.detail.model.DetailLikeListLoader.GetLikeListEvent;
import com.tencent.biz.qqstory.storyHome.detail.model.DetailLikeListLoader.GetLikeListRequest;
import com.tencent.biz.qqstory.storyHome.detail.model.DetailLikeListLoader.GetLikeListResponse;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.Dispatchers;

public class nzi
  implements CmdTaskManger.CommandCallback
{
  public nzi(DetailLikeListLoader paramDetailLikeListLoader, boolean paramBoolean) {}
  
  public void a(@NonNull DetailLikeListLoader.GetLikeListRequest paramGetLikeListRequest, @Nullable DetailLikeListLoader.GetLikeListResponse arg2, @NonNull ErrorMessage paramErrorMessage)
  {
    paramGetLikeListRequest = new DetailLikeListLoader.GetLikeListEvent(paramErrorMessage, DetailLikeListLoader.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailLikeListLoader));
    paramGetLikeListRequest.jdField_b_of_type_Boolean = false;
    paramGetLikeListRequest.jdField_a_of_type_Boolean = DetailLikeListLoader.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailLikeListLoader);
    paramGetLikeListRequest.jdField_a_of_type_Int = DetailLikeListLoader.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailLikeListLoader);
    if ((??? == null) || (paramErrorMessage.isFail()))
    {
      Dispatchers.get().dispatch(paramGetLikeListRequest);
      return;
    }
    paramGetLikeListRequest.jdField_c_of_type_Int = ???.jdField_c_of_type_Int;
    paramGetLikeListRequest.jdField_b_of_type_Int = ???.jdField_b_of_type_Int;
    paramGetLikeListRequest.jdField_a_of_type_JavaUtilList = ???.jdField_a_of_type_JavaUtilList;
    paramGetLikeListRequest.jdField_c_of_type_Boolean = this.jdField_a_of_type_Boolean;
    ((LikeManager)SuperManager.a(15)).a(paramGetLikeListRequest.jdField_a_of_type_JavaUtilList, DetailLikeListLoader.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailLikeListLoader), DetailLikeListLoader.b(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailLikeListLoader), true);
    synchronized (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailLikeListLoader)
    {
      DetailLikeListLoader.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailLikeListLoader, true);
      Dispatchers.get().dispatch(paramGetLikeListRequest);
      SLog.a("Q.qqstory.detail:DetailLikeListLoader", "dispatch like list return from network: %s", paramGetLikeListRequest);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nzi
 * JD-Core Version:    0.7.0.1
 */