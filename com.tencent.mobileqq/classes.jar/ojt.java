import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.channel.CmdTaskManger.CommandCallback;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspGetMusicListConfig;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.MusicConfigInfo;
import com.tencent.biz.qqstory.network.request.GetMusicConfigRequest;
import com.tencent.biz.qqstory.network.response.GetMusicConfigResponse;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.takevideo.music.QQStoryMusicInfo;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import java.util.ArrayList;

public class ojt
  implements CmdTaskManger.CommandCallback
{
  long jdField_a_of_type_Long = System.currentTimeMillis();
  Context jdField_a_of_type_AndroidContentContext;
  
  public ojt(@NonNull Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext.getApplicationContext();
  }
  
  public void a(@NonNull GetMusicConfigRequest paramGetMusicConfigRequest, @Nullable GetMusicConfigResponse paramGetMusicConfigResponse, @NonNull ErrorMessage paramErrorMessage)
  {
    StoryReportor.a("edit_video", "music_list_time", 0, 0, new String[] { String.valueOf(System.currentTimeMillis() - this.jdField_a_of_type_Long), "", "", "" });
    if ((paramErrorMessage.isFail()) || (paramGetMusicConfigResponse == null))
    {
      StoryReportor.a("edit_video", "music_list_failed", 0, 0, new String[] { "", "", "", "" });
      return;
    }
    paramGetMusicConfigRequest = paramGetMusicConfigResponse.a;
    int j = paramGetMusicConfigRequest.music_config.size();
    paramGetMusicConfigResponse = new ArrayList(j);
    if (j > 0)
    {
      int i = 0;
      while (i < j)
      {
        paramGetMusicConfigResponse.add(new QQStoryMusicInfo((qqstory_struct.MusicConfigInfo)paramGetMusicConfigRequest.music_config.get(i)));
        i += 1;
      }
    }
    StoryReportor.a("edit_video", "music_list_count", 0, 0, new String[] { String.valueOf(j), "", "", "" });
    QQStoryMusicInfo.a(this.jdField_a_of_type_AndroidContentContext, paramGetMusicConfigResponse);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ojt
 * JD-Core Version:    0.7.0.1
 */