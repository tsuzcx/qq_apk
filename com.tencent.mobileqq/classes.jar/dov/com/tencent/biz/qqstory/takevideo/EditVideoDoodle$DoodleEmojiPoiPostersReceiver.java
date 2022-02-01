package dov.com.tencent.biz.qqstory.takevideo;

import android.support.annotation.NonNull;
import com.tribe.async.dispatch.QQUIEventReceiver;
import dov.com.tencent.biz.qqstory.takevideo.doodle.model.DoodleEmojiManager.DoodleEmojiUpdatePoiPostersEvent;

class EditVideoDoodle$DoodleEmojiPoiPostersReceiver
  extends QQUIEventReceiver<EditVideoDoodle, DoodleEmojiManager.DoodleEmojiUpdatePoiPostersEvent>
{
  public EditVideoDoodle$DoodleEmojiPoiPostersReceiver(@NonNull EditVideoDoodle paramEditVideoDoodle)
  {
    super(paramEditVideoDoodle);
  }
  
  public void a(@NonNull EditVideoDoodle paramEditVideoDoodle, @NonNull DoodleEmojiManager.DoodleEmojiUpdatePoiPostersEvent paramDoodleEmojiUpdatePoiPostersEvent) {}
  
  public Class acceptEventClass()
  {
    return DoodleEmojiManager.DoodleEmojiUpdatePoiPostersEvent.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.EditVideoDoodle.DoodleEmojiPoiPostersReceiver
 * JD-Core Version:    0.7.0.1
 */