package tencent.im.oidb.cmd0x6c3;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class oidb_0x6c3$StockInfo
  extends MessageMicro<StockInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "msg_stock" }, new Object[] { null }, StockInfo.class);
  public final PBRepeatMessageField<oidb_0x6c3.StockItem> msg_stock = PBField.initRepeatMessage(oidb_0x6c3.StockItem.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.cmd0x6c3.oidb_0x6c3.StockInfo
 * JD-Core Version:    0.7.0.1
 */