package tencent.im.oidb.oidb_0xde5;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0xde5$ReqBody
  extends MessageMicro<ReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBStringField str_comment = PBField.initString("");
  public final PBStringField str_longnick_id = PBField.initString("");
  public final PBUInt64Field uint64_from_uin = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_longnick_uin = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_target_comment_id = PBField.initUInt64(0L);
  
  static
  {
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32, 42 }, new String[] { "uint64_longnick_uin", "str_longnick_id", "uint64_target_comment_id", "uint64_from_uin", "str_comment" }, new Object[] { localLong, "", localLong, localLong, "" }, ReqBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.oidb_0xde5.oidb_0xde5.ReqBody
 * JD-Core Version:    0.7.0.1
 */