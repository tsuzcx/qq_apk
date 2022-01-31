import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.takevideo.EditVideoDoodle;
import com.tencent.biz.qqstory.takevideo.doodle.model.DoodleEmojiManager.DoodleEmojiUpdateEvent;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class oiw
  extends QQUIEventReceiver
{
  public oiw(@NonNull EditVideoDoodle paramEditVideoDoodle)
  {
    super(paramEditVideoDoodle);
  }
  
  public void a(@NonNull EditVideoDoodle paramEditVideoDoodle, @NonNull DoodleEmojiManager.DoodleEmojiUpdateEvent paramDoodleEmojiUpdateEvent)
  {
    oiy localoiy = paramEditVideoDoodle.a;
    if (localoiy != null) {
      localoiy.a(paramEditVideoDoodle.a());
    }
    for (;;)
    {
      StoryReportor.b("edit_video", "face_list_success", 0, paramDoodleEmojiUpdateEvent.errorInfo.errorCode, new String[0]);
      return;
      SLog.b(this.TAG, "DoodleEmojiListEventReceiver adapter is null");
    }
  }
  
  public Class acceptEventClass()
  {
    return DoodleEmojiManager.DoodleEmojiUpdateEvent.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     oiw
 * JD-Core Version:    0.7.0.1
 */