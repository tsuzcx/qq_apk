package qqcircle;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class QQCircleMsgPaelem$CommInfo
  extends MessageMicro<CommInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_0x4d8_content = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_apns_wording = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_group_member_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_msg_flag = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32 }, new String[] { "uint32_msg_flag", "bytes_apns_wording", "bytes_0x4d8_content", "uint32_group_member_flag" }, new Object[] { Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2, Integer.valueOf(0) }, CommInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qqcircle.QQCircleMsgPaelem.CommInfo
 * JD-Core Version:    0.7.0.1
 */