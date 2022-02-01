package tencent.im.troop_search_popclassifc;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class popclassifc$PopHotWordCard
  extends MessageMicro<PopHotWordCard>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "title_bar", "rpt_pop_items" }, new Object[] { null, null }, PopHotWordCard.class);
  public final PBRepeatMessageField<popclassifc.HotWordItem> rpt_pop_items = PBField.initRepeatMessage(popclassifc.HotWordItem.class);
  public popclassifc.TitleBar title_bar = new popclassifc.TitleBar();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.troop_search_popclassifc.popclassifc.PopHotWordCard
 * JD-Core Version:    0.7.0.1
 */