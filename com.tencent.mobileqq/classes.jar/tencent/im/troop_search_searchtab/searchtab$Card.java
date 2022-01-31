package tencent.im.troop_search_searchtab;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

public final class searchtab$Card
  extends MessageMicro<Card>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42, 50, 58 }, new String[] { "type", "title_bar", "rpt_item1", "rpt_item2", "rpt_item3", "str_transfer_desc", "str_transfer_url" }, new Object[] { Integer.valueOf(1), null, null, null, null, "", "" }, Card.class);
  public final PBRepeatMessageField<searchtab.Item1> rpt_item1 = PBField.initRepeatMessage(searchtab.Item1.class);
  public final PBRepeatMessageField<searchtab.Item2> rpt_item2 = PBField.initRepeatMessage(searchtab.Item2.class);
  public final PBRepeatMessageField<searchtab.Item3> rpt_item3 = PBField.initRepeatMessage(searchtab.Item3.class);
  public final PBStringField str_transfer_desc = PBField.initString("");
  public final PBStringField str_transfer_url = PBField.initString("");
  public searchtab.TitleBar title_bar = new searchtab.TitleBar();
  public final PBEnumField type = PBField.initEnum(1);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     tencent.im.troop_search_searchtab.searchtab.Card
 * JD-Core Version:    0.7.0.1
 */