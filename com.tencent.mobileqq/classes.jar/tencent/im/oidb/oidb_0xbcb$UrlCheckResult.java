package tencent.im.oidb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0xbcb$UrlCheckResult
  extends MessageMicro<UrlCheckResult>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field jump_result = PBField.initUInt32(0);
  public final PBStringField jump_url = PBField.initString("");
  public final PBUInt64Field operation_bit = PBField.initUInt64(0L);
  public final PBUInt32Field result = PBField.initUInt32(0);
  public final PBUInt32Field ret_from = PBField.initUInt32(0);
  public final PBUInt32Field uint32_level = PBField.initUInt32(0);
  public final PBUInt32Field uint32_sub_level = PBField.initUInt32(0);
  public final PBUInt32Field uint32_umrtype = PBField.initUInt32(0);
  public final PBStringField url = PBField.initString("");
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 34, 40, 48, 56, 64, 72 }, new String[] { "url", "result", "jump_result", "jump_url", "uint32_level", "uint32_sub_level", "uint32_umrtype", "ret_from", "operation_bit" }, new Object[] { "", localInteger, localInteger, "", localInteger, localInteger, localInteger, localInteger, Long.valueOf(0L) }, UrlCheckResult.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.oidb_0xbcb.UrlCheckResult
 * JD-Core Version:    0.7.0.1
 */