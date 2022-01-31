import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.channel.CmdTaskManger.CommandCallback;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.TagManager;
import com.tencent.biz.qqstory.model.TagManager.FeedTagListUpdateEvent;
import com.tencent.biz.qqstory.network.request.GetFeedTagInfoListRequest;
import com.tencent.biz.qqstory.network.request.GetFeedTagInfoListRequest.FeedTagInfoList;
import com.tencent.biz.qqstory.network.request.GetFeedTagInfoListRequest.GetFeedTagInfoListResponse;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.Dispatchers;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class nda
  implements CmdTaskManger.CommandCallback
{
  public nda(TagManager paramTagManager) {}
  
  public void a(@NonNull GetFeedTagInfoListRequest paramGetFeedTagInfoListRequest, @Nullable GetFeedTagInfoListRequest.GetFeedTagInfoListResponse paramGetFeedTagInfoListResponse, @NonNull ErrorMessage paramErrorMessage)
  {
    paramGetFeedTagInfoListRequest = paramGetFeedTagInfoListRequest.jdField_a_of_type_JavaUtilList.iterator();
    while (paramGetFeedTagInfoListRequest.hasNext())
    {
      localObject = (String)paramGetFeedTagInfoListRequest.next();
      TagManager.a(this.a).remove(localObject);
    }
    paramGetFeedTagInfoListRequest = new TagManager.FeedTagListUpdateEvent();
    paramGetFeedTagInfoListRequest.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage = paramErrorMessage;
    if ((paramErrorMessage.isFail()) || (paramGetFeedTagInfoListResponse == null))
    {
      SLog.d("Q.qqstory:TagManager", "request fail for get tag request");
      Dispatchers.get().dispatch(paramGetFeedTagInfoListRequest);
      return;
    }
    paramErrorMessage = paramGetFeedTagInfoListRequest.jdField_a_of_type_JavaUtilMap;
    Object localObject = (TagManager)SuperManager.a(27);
    paramGetFeedTagInfoListResponse = paramGetFeedTagInfoListResponse.jdField_a_of_type_JavaUtilList.iterator();
    while (paramGetFeedTagInfoListResponse.hasNext())
    {
      GetFeedTagInfoListRequest.FeedTagInfoList localFeedTagInfoList = (GetFeedTagInfoListRequest.FeedTagInfoList)paramGetFeedTagInfoListResponse.next();
      ((TagManager)localObject).a(localFeedTagInfoList.jdField_a_of_type_JavaLangString, localFeedTagInfoList.jdField_a_of_type_JavaUtilList);
      paramErrorMessage.put(localFeedTagInfoList.jdField_a_of_type_JavaLangString, localFeedTagInfoList);
      SLog.a("Q.qqstory:TagManager", "save feedId :%s , %s", localFeedTagInfoList.jdField_a_of_type_JavaLangString, localFeedTagInfoList.jdField_a_of_type_JavaUtilList);
    }
    Dispatchers.get().dispatch(paramGetFeedTagInfoListRequest);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nda
 * JD-Core Version:    0.7.0.1
 */