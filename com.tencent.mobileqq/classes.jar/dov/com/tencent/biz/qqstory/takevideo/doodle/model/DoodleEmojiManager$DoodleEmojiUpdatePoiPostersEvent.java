package dov.com.tencent.biz.qqstory.takevideo.doodle.model;

import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.BaseEvent;
import java.util.ArrayList;
import java.util.List;

public class DoodleEmojiManager$DoodleEmojiUpdatePoiPostersEvent
  extends BaseEvent
{
  public final int a;
  @NonNull
  public final List a;
  
  public DoodleEmojiManager$DoodleEmojiUpdatePoiPostersEvent(int paramInt, @NonNull List paramList)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaUtilList = new ArrayList(paramList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.doodle.model.DoodleEmojiManager.DoodleEmojiUpdatePoiPostersEvent
 * JD-Core Version:    0.7.0.1
 */