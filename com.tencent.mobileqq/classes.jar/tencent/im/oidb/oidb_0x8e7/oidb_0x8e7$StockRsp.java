package tencent.im.oidb.oidb_0x8e7;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

public final class oidb_0x8e7$StockRsp
  extends MessageMicro<StockRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "int32_total", "int32_stock", "int32_give_count" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, StockRsp.class);
  public final PBInt32Field int32_give_count = PBField.initInt32(0);
  public final PBInt32Field int32_stock = PBField.initInt32(0);
  public final PBInt32Field int32_total = PBField.initInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.oidb_0x8e7.oidb_0x8e7.StockRsp
 * JD-Core Version:    0.7.0.1
 */