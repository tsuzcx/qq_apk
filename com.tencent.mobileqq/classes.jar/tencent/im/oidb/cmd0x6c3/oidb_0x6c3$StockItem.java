package tencent.im.oidb.cmd0x6c3;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

public final class oidb_0x6c3$StockItem
  extends MessageMicro<StockItem>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "int32_productid", "int32_amount", "int32_free_limit_chance" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, StockItem.class);
  public final PBInt32Field int32_amount = PBField.initInt32(0);
  public final PBInt32Field int32_free_limit_chance = PBField.initInt32(0);
  public final PBInt32Field int32_productid = PBField.initInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.cmd0x6c3.oidb_0x6c3.StockItem
 * JD-Core Version:    0.7.0.1
 */