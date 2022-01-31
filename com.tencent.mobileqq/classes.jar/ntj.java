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
import com.tencent.biz.qqstory.network.BatchHandlerListPuller;
import com.tencent.biz.qqstory.network.handler.GetVidPollInfoHandler;
import com.tencent.biz.qqstory.network.request.GetCollectionVideoListRequest;
import com.tencent.biz.qqstory.network.response.GetCollectionVideoListResponse;
import com.tencent.biz.qqstory.playvideo.model.MemorySharePlayingListSync;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.Dispatchers;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ntj
  implements CmdTaskManger.CommandCallback
{
  public ntj(MemorySharePlayingListSync paramMemorySharePlayingListSync) {}
  
  public void a(@NonNull GetCollectionVideoListRequest paramGetCollectionVideoListRequest, @Nullable GetCollectionVideoListResponse paramGetCollectionVideoListResponse, @NonNull ErrorMessage paramErrorMessage)
  {
    int i = 0;
    this.a.c = false;
    if ((paramGetCollectionVideoListResponse == null) || (paramErrorMessage.isFail()))
    {
      paramGetCollectionVideoListRequest = new DefaultPlayerVideoListSynchronizer.PlayerVideoListEvent();
      paramGetCollectionVideoListRequest.jdField_a_of_type_JavaLangString = this.a.jdField_b_of_type_JavaLangString;
      paramGetCollectionVideoListRequest.jdField_b_of_type_JavaLangString = this.a.jdField_d_of_type_JavaLangString;
      paramGetCollectionVideoListRequest.errorInfo = paramErrorMessage;
      Dispatchers.get().dispatch(paramGetCollectionVideoListRequest);
      return;
    }
    paramGetCollectionVideoListResponse.jdField_a_of_type_JavaUtilList = ((StoryManager)SuperManager.a(5)).a(paramGetCollectionVideoListResponse.jdField_a_of_type_JavaUtilList);
    paramErrorMessage = paramGetCollectionVideoListResponse.jdField_a_of_type_JavaUtilList.iterator();
    while (paramErrorMessage.hasNext()) {
      ((StoryVideoItem)paramErrorMessage.next()).mOwnerUid = this.a.jdField_d_of_type_JavaLangString;
    }
    if (TextUtils.isEmpty(paramGetCollectionVideoListRequest.jdField_d_of_type_JavaLangString)) {
      this.a.jdField_a_of_type_JavaUtilList.clear();
    }
    this.a.jdField_a_of_type_JavaLangString = paramGetCollectionVideoListResponse.c;
    this.a.jdField_a_of_type_JavaUtilList.addAll(paramGetCollectionVideoListResponse.jdField_a_of_type_JavaUtilList);
    this.a.jdField_a_of_type_Int = this.a.jdField_a_of_type_JavaUtilList.size();
    this.a.jdField_b_of_type_Boolean = paramGetCollectionVideoListResponse.jdField_a_of_type_Boolean;
    paramGetCollectionVideoListRequest = this.a;
    if (paramGetCollectionVideoListResponse.jdField_b_of_type_Int == 1) {}
    for (boolean bool = true;; bool = false)
    {
      paramGetCollectionVideoListRequest.jdField_d_of_type_Boolean = bool;
      SLog.a("Q.qqstory.player.MemorySharePlayingListSync", "last load position:%d cookie:%s", Integer.valueOf(this.a.jdField_a_of_type_Int), this.a.jdField_a_of_type_JavaLangString);
      ((DownloadUrlManager)SuperManager.a(28)).a(paramGetCollectionVideoListResponse.jdField_b_of_type_JavaUtilList);
      paramGetCollectionVideoListRequest = new ArrayList();
      while (i < this.a.jdField_a_of_type_JavaUtilList.size())
      {
        paramGetCollectionVideoListRequest.add(((StoryVideoItem)this.a.jdField_a_of_type_JavaUtilList.get(i)).mVid);
        i += 1;
      }
    }
    paramErrorMessage = BatchHandlerListPuller.a(paramGetCollectionVideoListRequest);
    paramErrorMessage.a("Q.qqstory.player.MemorySharePlayingListSync");
    paramErrorMessage.a(new ntk(this, paramErrorMessage, paramGetCollectionVideoListResponse));
    paramErrorMessage.b();
    GetVidPollInfoHandler.a(paramGetCollectionVideoListRequest);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ntj
 * JD-Core Version:    0.7.0.1
 */