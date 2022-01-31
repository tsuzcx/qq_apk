import com.tencent.biz.qqstory.model.HotSortVideoManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.network.handler.GetHotSortVideoHandler;
import com.tencent.biz.qqstory.network.handler.GetHotSortVideoHandler.GetHotSortVideoResponse;
import com.tencent.biz.qqstory.network.handler.GetHotSortVideoHandler.GetVideoByHotSortEvent;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.Dispatchers;
import java.util.ArrayList;

public class nfo
  implements Runnable
{
  public nfo(GetHotSortVideoHandler.GetHotSortVideoResponse paramGetHotSortVideoResponse, ArrayList paramArrayList, GetHotSortVideoHandler.GetVideoByHotSortEvent paramGetVideoByHotSortEvent) {}
  
  public void run()
  {
    ((HotSortVideoManager)SuperManager.a(25)).a(this.jdField_a_of_type_JavaUtilArrayList, GetHotSortVideoHandler.a(this.jdField_a_of_type_ComTencentBizQqstoryNetworkHandlerGetHotSortVideoHandler$GetHotSortVideoResponse.a), true);
    this.jdField_a_of_type_ComTencentBizQqstoryNetworkHandlerGetHotSortVideoHandler$GetVideoByHotSortEvent.jdField_a_of_type_JavaUtilArrayList = this.jdField_a_of_type_JavaUtilArrayList;
    Dispatchers.get().dispatch(this.jdField_a_of_type_ComTencentBizQqstoryNetworkHandlerGetHotSortVideoHandler$GetVideoByHotSortEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nfo
 * JD-Core Version:    0.7.0.1
 */