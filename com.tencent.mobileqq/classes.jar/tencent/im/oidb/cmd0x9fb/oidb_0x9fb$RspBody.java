package tencent.im.oidb.cmd0x9fb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0x9fb$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_errMsg = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field is_end = PBField.initUInt32(0);
  public final PBRepeatMessageField<oidb_0x9fb.RgroupInfo> msg_groups = PBField.initRepeatMessage(oidb_0x9fb.RgroupInfo.class);
  public final PBUInt32Field uint32_cmdid = PBField.initUInt32(0);
  public final PBUInt32Field uint32_result = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 40 }, new String[] { "uint32_cmdid", "uint32_result", "bytes_errMsg", "msg_groups", "is_end" }, new Object[] { localInteger, localInteger, localByteStringMicro, null, localInteger }, RspBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0x9fb.oidb_0x9fb.RspBody
 * JD-Core Version:    0.7.0.1
 */