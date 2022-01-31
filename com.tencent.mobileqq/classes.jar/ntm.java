import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.base.download.DownloadUrlManager;
import com.tencent.biz.qqstory.channel.CmdTaskManger.CommandCallback;
import com.tencent.biz.qqstory.model.DefaultPlayerVideoListSynchronizer.PlayerVideoListEvent;
import com.tencent.biz.qqstory.model.StoryManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.network.request.GetShareVideoListRequest;
import com.tencent.biz.qqstory.network.response.GetShareVideoListResponse;
import com.tencent.biz.qqstory.playvideo.model.MyVideoSharePlayingListSync;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.Dispatchers;
import java.util.Iterator;
import java.util.List;

public class ntm
  implements CmdTaskManger.CommandCallback
{
  public ntm(MyVideoSharePlayingListSync paramMyVideoSharePlayingListSync) {}
  
  public void a(@NonNull GetShareVideoListRequest paramGetShareVideoListRequest, @Nullable GetShareVideoListResponse paramGetShareVideoListResponse, @NonNull ErrorMessage paramErrorMessage)
  {
    this.a.jdField_c_of_type_Boolean = false;
    if ((paramGetShareVideoListResponse == null) || (paramErrorMessage.isFail()))
    {
      paramGetShareVideoListRequest = new DefaultPlayerVideoListSynchronizer.PlayerVideoListEvent();
      paramGetShareVideoListRequest.jdField_a_of_type_JavaLangString = this.a.jdField_b_of_type_JavaLangString;
      paramGetShareVideoListRequest.jdField_b_of_type_JavaLangString = this.a.jdField_c_of_type_JavaLangString;
      paramGetShareVideoListRequest.errorInfo = paramErrorMessage;
      Dispatchers.get().dispatch(paramGetShareVideoListRequest);
      return;
    }
    paramGetShareVideoListResponse.jdField_a_of_type_JavaUtilList = ((StoryManager)SuperManager.a(5)).a(paramGetShareVideoListResponse.jdField_a_of_type_JavaUtilList);
    paramErrorMessage = paramGetShareVideoListResponse.jdField_a_of_type_JavaUtilList.iterator();
    while (paramErrorMessage.hasNext())
    {
      StoryVideoItem localStoryVideoItem = (StoryVideoItem)paramErrorMessage.next();
      if (TextUtils.isEmpty(localStoryVideoItem.mOwnerUid)) {
        localStoryVideoItem.mOwnerUid = this.a.jdField_c_of_type_JavaLangString;
      }
    }
    if (TextUtils.isEmpty(paramGetShareVideoListRequest.jdField_c_of_type_JavaLangString)) {
      this.a.jdField_a_of_type_JavaUtilList.clear();
    }
    this.a.jdField_a_of_type_JavaUtilList.addAll(paramGetShareVideoListResponse.jdField_a_of_type_JavaUtilList);
    this.a.jdField_a_of_type_Int = this.a.jdField_a_of_type_JavaUtilList.size();
    this.a.jdField_b_of_type_Boolean = paramGetShareVideoListResponse.jdField_a_of_type_Boolean;
    this.a.jdField_a_of_type_JavaLangString = paramGetShareVideoListResponse.jdField_c_of_type_JavaLangString;
    ((DownloadUrlManager)SuperManager.a(28)).a(paramGetShareVideoListResponse.b);
    paramGetShareVideoListRequest = new DefaultPlayerVideoListSynchronizer.PlayerVideoListEvent();
    paramGetShareVideoListRequest.jdField_a_of_type_JavaLangString = this.a.jdField_b_of_type_JavaLangString;
    paramGetShareVideoListRequest.jdField_b_of_type_JavaLangString = this.a.jdField_c_of_type_JavaLangString;
    paramGetShareVideoListRequest.jdField_a_of_type_Boolean = false;
    paramGetShareVideoListRequest.jdField_b_of_type_Boolean = paramGetShareVideoListResponse.jdField_a_of_type_Boolean;
    paramGetShareVideoListRequest.jdField_a_of_type_JavaUtilList = this.a.jdField_a_of_type_JavaUtilList;
    if (paramGetShareVideoListRequest.jdField_a_of_type_Int < paramGetShareVideoListRequest.jdField_a_of_type_JavaUtilList.size()) {
      paramGetShareVideoListRequest.jdField_a_of_type_Int = paramGetShareVideoListRequest.jdField_a_of_type_JavaUtilList.size();
    }
    Dispatchers.get().dispatch(paramGetShareVideoListRequest);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ntm
 * JD-Core Version:    0.7.0.1
 */