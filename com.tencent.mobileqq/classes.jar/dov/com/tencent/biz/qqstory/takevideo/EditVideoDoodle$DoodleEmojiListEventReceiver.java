package dov.com.tencent.biz.qqstory.takevideo;

import android.support.annotation.NonNull;
import com.tribe.async.dispatch.QQUIEventReceiver;
import dov.com.tencent.biz.qqstory.takevideo.doodle.model.DoodleEmojiManager.DoodleEmojiUpdateEvent;

class EditVideoDoodle$DoodleEmojiListEventReceiver
  extends QQUIEventReceiver<EditVideoDoodle, DoodleEmojiManager.DoodleEmojiUpdateEvent>
{
  public EditVideoDoodle$DoodleEmojiListEventReceiver(@NonNull EditVideoDoodle paramEditVideoDoodle)
  {
    super(paramEditVideoDoodle);
  }
  
  public void a(@NonNull EditVideoDoodle paramEditVideoDoodle, @NonNull DoodleEmojiManager.DoodleEmojiUpdateEvent paramDoodleEmojiUpdateEvent) {}
  
  public Class acceptEventClass()
  {
    return DoodleEmojiManager.DoodleEmojiUpdateEvent.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.EditVideoDoodle.DoodleEmojiListEventReceiver
 * JD-Core Version:    0.7.0.1
 */