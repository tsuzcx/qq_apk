package tencent.im.oidb.cmd0x6c3;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;

public final class oidb_0x6c3$GetStockRsp
  extends MessageMicro<GetStockRsp>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_give_info = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_midas_error = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_recharge_activity = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBInt32Field int32_count = PBField.initInt32(0);
  public final PBInt32Field int32_give_count = PBField.initInt32(0);
  public final PBInt64Field int64_balance = PBField.initInt64(0L);
  public final PBInt64Field int64_midas_gen_balance = PBField.initInt64(0L);
  public oidb_0x6c3.ImgShowConfig msg_imgshow_config = new oidb_0x6c3.ImgShowConfig();
  public oidb_0x6c3.StockInfo msg_stock = new oidb_0x6c3.StockInfo();
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 42, 50, 56, 64, 74 }, new String[] { "int32_count", "int32_give_count", "bytes_give_info", "msg_stock", "bytes_recharge_activity", "msg_imgshow_config", "int64_balance", "int64_midas_gen_balance", "bytes_midas_error" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro1, null, localByteStringMicro2, null, Long.valueOf(0L), Long.valueOf(0L), localByteStringMicro3 }, GetStockRsp.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.cmd0x6c3.oidb_0x6c3.GetStockRsp
 * JD-Core Version:    0.7.0.1
 */