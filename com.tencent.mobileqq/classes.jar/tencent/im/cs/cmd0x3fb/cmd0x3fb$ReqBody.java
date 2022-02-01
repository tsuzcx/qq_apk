package tencent.im.cs.cmd0x3fb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class cmd0x3fb$ReqBody
  extends MessageMicro<ReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBStringField str_version = PBField.initString("");
  public final PBUInt32Field uint32_client_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_identity = PBField.initUInt32(0);
  public final PBUInt64Field uint64_to_guin = PBField.initUInt64(0L);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34 }, new String[] { "uint32_identity", "uint64_to_guin", "uint32_client_id", "str_version" }, new Object[] { localInteger, Long.valueOf(0L), localInteger, "" }, ReqBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.cs.cmd0x3fb.cmd0x3fb.ReqBody
 * JD-Core Version:    0.7.0.1
 */