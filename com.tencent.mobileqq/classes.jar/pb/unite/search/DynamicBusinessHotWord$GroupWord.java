package pb.unite.search;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class DynamicBusinessHotWord$GroupWord
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "group_id", "rpt_hot_word_items", "clue_word_item" }, new Object[] { null, null, null }, GroupWord.class);
  public DynamicBusinessHotWord.ClueWordItem clue_word_item = new DynamicBusinessHotWord.ClueWordItem();
  public DynamicBusinessHotWord.GroupID group_id = new DynamicBusinessHotWord.GroupID();
  public final PBRepeatMessageField rpt_hot_word_items = PBField.initRepeatMessage(DynamicBusinessHotWord.HotWordItem.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aad.jar
 * Qualified Name:     pb.unite.search.DynamicBusinessHotWord.GroupWord
 * JD-Core Version:    0.7.0.1
 */