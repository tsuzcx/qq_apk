import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.channel.CmdTaskManger.CommandCallback;
import com.tencent.biz.qqstory.model.DiscoverManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.network.request.CommonRequest;
import com.tencent.biz.qqstory.network.response.CommonResponse;
import com.tencent.biz.qqstory.storyHome.discover.view.DiscoverPresenter;
import com.tencent.biz.qqstory.support.logging.SLog;

public class oao
  implements CmdTaskManger.CommandCallback
{
  public oao(DiscoverPresenter paramDiscoverPresenter) {}
  
  public void a(@NonNull CommonRequest paramCommonRequest, @Nullable CommonResponse paramCommonResponse, @NonNull ErrorMessage paramErrorMessage)
  {
    if ((paramErrorMessage.isFail()) || (paramCommonResponse == null))
    {
      SLog.e("Q.qqstory.discover.DiscoverPresenter", "StorySvc.get_hot_topic_info request fail! %s", new Object[] { paramErrorMessage.toString() });
      return;
    }
    ((DiscoverManager)SuperManager.a(22)).a(DiscoverPresenter.a(this.a), paramCommonResponse.a);
    DiscoverPresenter.a(this.a, paramCommonResponse.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     oao
 * JD-Core Version:    0.7.0.1
 */