package dov.com.tencent.biz.qqstory.takevideo.doodle.model;

import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.BaseEvent;

public class DoodleEmojiManager$DoodleEmojiDownloadEvent
  extends BaseEvent
{
  public final int a;
  public final long a;
  @NonNull
  public final DoodleEmojiItem a;
  public final boolean a;
  public final long b;
  public boolean b;
  
  public DoodleEmojiManager$DoodleEmojiDownloadEvent(@NonNull DoodleEmojiItem paramDoodleEmojiItem, int paramInt, boolean paramBoolean, long paramLong1, long paramLong2)
  {
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleModelDoodleEmojiItem = paramDoodleEmojiItem;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_Long = paramLong1;
    this.b = paramLong2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.doodle.model.DoodleEmojiManager.DoodleEmojiDownloadEvent
 * JD-Core Version:    0.7.0.1
 */