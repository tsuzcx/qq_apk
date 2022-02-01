package tencent.im.troop_search_popclassifc;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class popclassifc$HotWordItem
  extends MessageMicro<HotWordItem>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "str_hot_word", "str_text_color" }, new Object[] { "", "" }, HotWordItem.class);
  public final PBStringField str_hot_word = PBField.initString("");
  public final PBStringField str_text_color = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.troop_search_popclassifc.popclassifc.HotWordItem
 * JD-Core Version:    0.7.0.1
 */