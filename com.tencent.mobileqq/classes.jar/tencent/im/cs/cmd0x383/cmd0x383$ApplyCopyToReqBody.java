package tencent.im.cs.cmd0x383;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class cmd0x383$ApplyCopyToReqBody
  extends MessageMicro<ApplyCopyToReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBStringField str_src_file_path = PBField.initString("");
  public final PBUInt32Field uint32_dst_bus_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_src_bus_id = PBField.initUInt32(0);
  public final PBUInt64Field uint64_dst_uin = PBField.initUInt64(0L);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32 }, new String[] { "uint32_src_bus_id", "str_src_file_path", "uint32_dst_bus_id", "uint64_dst_uin" }, new Object[] { localInteger, "", localInteger, Long.valueOf(0L) }, ApplyCopyToReqBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.cs.cmd0x383.cmd0x383.ApplyCopyToReqBody
 * JD-Core Version:    0.7.0.1
 */