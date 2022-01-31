package tencent.im.oidb.cmd0x8c1;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0x8c1$ReqBody
  extends MessageMicro<ReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_tmp_chat_token = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBInt32Field int32_is_super_love = PBField.initInt32(0);
  public final PBInt32Field int32_tmp_chat_token_type = PBField.initInt32(0);
  public oidb_0x8c1.UserDeviceInfo msg_req_info = new oidb_0x8c1.UserDeviceInfo();
  public final PBUInt64Field uint64_first_rater_tinyid = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_first_rater_uin = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 32, 40, 48 }, new String[] { "msg_req_info", "uint64_first_rater_uin", "bytes_tmp_chat_token", "int32_tmp_chat_token_type", "uint64_first_rater_tinyid", "int32_is_super_love" }, new Object[] { null, Long.valueOf(0L), localByteStringMicro, Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0) }, ReqBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     tencent.im.oidb.cmd0x8c1.oidb_0x8c1.ReqBody
 * JD-Core Version:    0.7.0.1
 */