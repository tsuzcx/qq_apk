package tencent.im.cs.longconn.voip;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class hd_video_voip_2$CmdPhoneBindRspBody
  extends MessageMicro<CmdPhoneBindRspBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_call_id = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_call_phone = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_call_prompt = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_ability = PBField.initUInt32(0);
  public final PBUInt32Field uint32_call_phone_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_call_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_cb_line_count = PBField.initUInt32(0);
  public final PBUInt64Field uint64_call_id = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 42, 48, 56, 64 }, new String[] { "uint32_call_type", "uint64_call_id", "bytes_call_id", "bytes_call_prompt", "bytes_call_phone", "uint32_ability", "uint32_call_phone_type", "uint32_cb_line_count" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, CmdPhoneBindRspBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     tencent.im.cs.longconn.voip.hd_video_voip_2.CmdPhoneBindRspBody
 * JD-Core Version:    0.7.0.1
 */