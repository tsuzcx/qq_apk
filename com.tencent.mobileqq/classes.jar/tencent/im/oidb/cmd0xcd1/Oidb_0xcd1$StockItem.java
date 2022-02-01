package tencent.im.oidb.cmd0xcd1;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

public final class Oidb_0xcd1$StockItem
  extends MessageMicro<StockItem>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBInt32Field int32_amount = PBField.initInt32(0);
  public final PBInt32Field int32_productid = PBField.initInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "int32_productid", "int32_amount" }, new Object[] { localInteger, localInteger }, StockItem.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0xcd1.Oidb_0xcd1.StockItem
 * JD-Core Version:    0.7.0.1
 */