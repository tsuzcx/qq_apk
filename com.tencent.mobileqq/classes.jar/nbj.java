import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.channel.CmdTaskManger.CommandCallback;
import com.tencent.biz.qqstory.model.StoryConfigManager;
import com.tencent.biz.qqstory.model.StoryConfigManager.StoryConfigEvent;
import com.tencent.biz.qqstory.network.request.PublishConfigRequest;
import com.tencent.biz.qqstory.network.response.PublishConfigResponse;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.Dispatchers;

public class nbj
  implements CmdTaskManger.CommandCallback
{
  public nbj(StoryConfigManager paramStoryConfigManager) {}
  
  public void a(@NonNull PublishConfigRequest paramPublishConfigRequest, @Nullable PublishConfigResponse paramPublishConfigResponse, @NonNull ErrorMessage paramErrorMessage)
  {
    if ((paramPublishConfigResponse != null) && (paramErrorMessage.isSuccess()))
    {
      StoryConfigManager.a(this.a, System.currentTimeMillis());
      this.a.b("show_now_entry", Boolean.valueOf(paramPublishConfigResponse.a));
      this.a.b("publish_picture", Boolean.valueOf(paramPublishConfigResponse.b));
      if (paramPublishConfigResponse.c) {
        this.a.b("first_time_pic", Boolean.valueOf(paramPublishConfigResponse.c));
      }
      this.a.b("upload_video_use_bdh", Boolean.valueOf(paramPublishConfigResponse.d));
    }
    Dispatchers.get().dispatch(new StoryConfigManager.StoryConfigEvent());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nbj
 * JD-Core Version:    0.7.0.1
 */