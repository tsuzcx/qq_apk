import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.takevideo.EditVideoDoodle;
import com.tencent.biz.qqstory.takevideo.doodle.model.DoodleEmojiManager.DoodleEmojiUpdateEvent;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class ocp
  extends QQUIEventReceiver
{
  public ocp(@NonNull EditVideoDoodle paramEditVideoDoodle)
  {
    super(paramEditVideoDoodle);
  }
  
  public void a(@NonNull EditVideoDoodle paramEditVideoDoodle, @NonNull DoodleEmojiManager.DoodleEmojiUpdateEvent paramDoodleEmojiUpdateEvent)
  {
    ocr localocr = paramEditVideoDoodle.a;
    if (localocr != null) {
      localocr.a(paramEditVideoDoodle.a());
    }
    for (;;)
    {
      StoryReportor.b("edit_video", "face_list_success", 0, paramDoodleEmojiUpdateEvent.a.errorCode, new String[0]);
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
 * Qualified Name:     ocp
 * JD-Core Version:    0.7.0.1
 */