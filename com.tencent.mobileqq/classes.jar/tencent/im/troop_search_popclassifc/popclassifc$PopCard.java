package tencent.im.troop_search_popclassifc;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class popclassifc$PopCard
  extends MessageMicro
{
  public static final int RPT_POP_ITEMS_FIELD_NUMBER = 2;
  public static final int TITLE_BAR_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "title_bar", "rpt_pop_items" }, new Object[] { null, null }, PopCard.class);
  public final PBRepeatMessageField rpt_pop_items = PBField.initRepeatMessage(popclassifc.PopItem.class);
  public popclassifc.TitleBar title_bar = new popclassifc.TitleBar();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.troop_search_popclassifc.popclassifc.PopCard
 * JD-Core Version:    0.7.0.1
 */