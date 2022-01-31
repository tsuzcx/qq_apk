package tencent.im.troop_search_searchtab;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

public final class searchtab$Card
  extends MessageMicro
{
  public static final int RPT_ITEM1_FIELD_NUMBER = 3;
  public static final int RPT_ITEM2_FIELD_NUMBER = 4;
  public static final int RPT_ITEM3_FIELD_NUMBER = 5;
  public static final int STR_TRANSFER_DESC_FIELD_NUMBER = 6;
  public static final int STR_TRANSFER_URL_FIELD_NUMBER = 7;
  public static final int TITLE_BAR_FIELD_NUMBER = 2;
  public static final int TYPE_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42, 50, 58 }, new String[] { "type", "title_bar", "rpt_item1", "rpt_item2", "rpt_item3", "str_transfer_desc", "str_transfer_url" }, new Object[] { Integer.valueOf(1), null, null, null, null, "", "" }, Card.class);
  public final PBRepeatMessageField rpt_item1 = PBField.initRepeatMessage(searchtab.Item1.class);
  public final PBRepeatMessageField rpt_item2 = PBField.initRepeatMessage(searchtab.Item2.class);
  public final PBRepeatMessageField rpt_item3 = PBField.initRepeatMessage(searchtab.Item3.class);
  public final PBStringField str_transfer_desc = PBField.initString("");
  public final PBStringField str_transfer_url = PBField.initString("");
  public searchtab.TitleBar title_bar = new searchtab.TitleBar();
  public final PBEnumField type = PBField.initEnum(1);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.troop_search_searchtab.searchtab.Card
 * JD-Core Version:    0.7.0.1
 */