import com.tencent.biz.qqstory.model.DefaultPlayerVideoListSynchronizer.PlayerVideoListEvent;
import com.tencent.biz.qqstory.network.BatchHandlerListPuller;
import com.tencent.biz.qqstory.network.BatchHandlerListPuller.IPullResultCallback;
import com.tencent.biz.qqstory.network.response.GetCollectionVideoListResponse;
import com.tencent.biz.qqstory.playvideo.model.MemorySharePlayingListSync;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.Dispatchers;
import java.util.List;

class nni
  implements BatchHandlerListPuller.IPullResultCallback
{
  nni(nnh paramnnh, BatchHandlerListPuller paramBatchHandlerListPuller, GetCollectionVideoListResponse paramGetCollectionVideoListResponse) {}
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryNetworkBatchHandlerListPuller.a();
    DefaultPlayerVideoListSynchronizer.PlayerVideoListEvent localPlayerVideoListEvent = new DefaultPlayerVideoListSynchronizer.PlayerVideoListEvent();
    localPlayerVideoListEvent.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_Nnh.a.jdField_b_of_type_JavaLangString;
    localPlayerVideoListEvent.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_Nnh.a.jdField_d_of_type_JavaLangString;
    localPlayerVideoListEvent.jdField_a_of_type_Boolean = false;
    localPlayerVideoListEvent.jdField_b_of_type_Boolean = this.jdField_a_of_type_ComTencentBizQqstoryNetworkResponseGetCollectionVideoListResponse.jdField_a_of_type_Boolean;
    localPlayerVideoListEvent.c = this.jdField_a_of_type_Nnh.a.jdField_d_of_type_Boolean;
    localPlayerVideoListEvent.jdField_a_of_type_JavaUtilList = this.jdField_a_of_type_Nnh.a.jdField_a_of_type_JavaUtilList;
    localPlayerVideoListEvent.jdField_a_of_type_Int = localPlayerVideoListEvent.jdField_a_of_type_JavaUtilList.size();
    if (localPlayerVideoListEvent.jdField_a_of_type_Int < localPlayerVideoListEvent.jdField_a_of_type_JavaUtilList.size()) {
      localPlayerVideoListEvent.jdField_a_of_type_Int = localPlayerVideoListEvent.jdField_a_of_type_JavaUtilList.size();
    }
    Dispatchers.get().dispatch(localPlayerVideoListEvent);
    SLog.b("Q.qqstory.player.MemorySharePlayingListSync", "get video list return:" + localPlayerVideoListEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nni
 * JD-Core Version:    0.7.0.1
 */