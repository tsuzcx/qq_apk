package tencent.im.oidb.cmd0x991;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;

public final class oidb_cmd0x991$StockRsp
  extends MessageMicro<StockRsp>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_midas_json = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBInt64Field int64_give_stock = PBField.initInt64(0L);
  public final PBInt64Field int64_midas_balance = PBField.initInt64(0L);
  public final PBInt64Field int64_user_stock = PBField.initInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34 }, new String[] { "int64_user_stock", "int64_give_stock", "int64_midas_balance", "bytes_midas_json" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), localByteStringMicro }, StockRsp.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.cmd0x991.oidb_cmd0x991.StockRsp
 * JD-Core Version:    0.7.0.1
 */