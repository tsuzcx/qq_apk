package dov.com.tencent.biz.qqstory.takevideo;

import android.support.annotation.NonNull;
import com.tribe.async.dispatch.QQUIEventReceiver;
import dov.com.tencent.biz.qqstory.takevideo.doodle.model.DoodleEmojiManager.DoodleEmojiDownloadEvent;

class EditVideoDoodle$DoodleEmojiDownloadEventReceiver
  extends QQUIEventReceiver<EditVideoDoodle, DoodleEmojiManager.DoodleEmojiDownloadEvent>
{
  public EditVideoDoodle$DoodleEmojiDownloadEventReceiver(@NonNull EditVideoDoodle paramEditVideoDoodle)
  {
    super(paramEditVideoDoodle);
  }
  
  public void a(@NonNull EditVideoDoodle paramEditVideoDoodle, @NonNull DoodleEmojiManager.DoodleEmojiDownloadEvent paramDoodleEmojiDownloadEvent) {}
  
  public Class acceptEventClass()
  {
    return DoodleEmojiManager.DoodleEmojiDownloadEvent.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.EditVideoDoodle.DoodleEmojiDownloadEventReceiver
 * JD-Core Version:    0.7.0.1
 */