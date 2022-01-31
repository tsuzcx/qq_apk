import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.channel.CmdTaskManger.CommandCallback;
import com.tencent.biz.qqstory.model.StoryConfigManager;
import com.tencent.biz.qqstory.network.request.GetBlackStatusRequest;
import com.tencent.biz.qqstory.network.response.GetBlackListStatusResponse;

public class nbk
  implements CmdTaskManger.CommandCallback
{
  public nbk(StoryConfigManager paramStoryConfigManager, long paramLong) {}
  
  public void a(@NonNull GetBlackStatusRequest paramGetBlackStatusRequest, @Nullable GetBlackListStatusResponse paramGetBlackListStatusResponse, @NonNull ErrorMessage paramErrorMessage)
  {
    if (paramGetBlackListStatusResponse != null)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryModelStoryConfigManager.b("qqstory_black_status", Integer.valueOf(paramGetBlackListStatusResponse.b));
      this.jdField_a_of_type_ComTencentBizQqstoryModelStoryConfigManager.b("qqstory_black_status_update_interval", Integer.valueOf(paramGetBlackListStatusResponse.c));
      this.jdField_a_of_type_ComTencentBizQqstoryModelStoryConfigManager.b("qqstory_black_status_last_update_time", Integer.valueOf((int)this.jdField_a_of_type_Long));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nbk
 * JD-Core Version:    0.7.0.1
 */