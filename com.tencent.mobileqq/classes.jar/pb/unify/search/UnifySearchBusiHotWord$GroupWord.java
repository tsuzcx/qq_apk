package pb.unify.search;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class UnifySearchBusiHotWord$GroupWord
  extends MessageMicro<GroupWord>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "group_id", "rpt_hot_word_items", "clue_word_item" }, new Object[] { null, null, null }, GroupWord.class);
  public UnifySearchBusiHotWord.ClueWordItem clue_word_item = new UnifySearchBusiHotWord.ClueWordItem();
  public UnifySearchBusiHotWord.GroupID group_id = new UnifySearchBusiHotWord.GroupID();
  public final PBRepeatMessageField<UnifySearchBusiHotWord.HotWordItem> rpt_hot_word_items = PBField.initRepeatMessage(UnifySearchBusiHotWord.HotWordItem.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     pb.unify.search.UnifySearchBusiHotWord.GroupWord
 * JD-Core Version:    0.7.0.1
 */